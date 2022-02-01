package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.kinda.gen.KTableView;
import com.tencent.kinda.gen.KTableViewCellManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public class KindaTableViewImpl
  extends MMKView<ListView>
  implements KTableView
{
  private static final String TAG = "MicroMsg.KindaTableViewImplV2";
  private Adapter mAdapter;
  private ArrayList<KTableViewCellManager> mDataList;
  private boolean mEnableRefresh;
  private VoidCallback mLoadMoreCallback;
  private Map<Integer, WeakReference<View>> mViewMap;
  private View refreshFooterView;
  
  public KindaTableViewImpl()
  {
    AppMethodBeat.i(214504);
    this.mDataList = new ArrayList();
    this.mEnableRefresh = false;
    this.mViewMap = new HashMap();
    AppMethodBeat.o(214504);
  }
  
  public ListView createView(Context paramContext)
  {
    AppMethodBeat.i(214505);
    Log.d("MicroMsg.KindaTableViewImplV2", "create view");
    this.view = new ListView(paramContext);
    this.refreshFooterView = aa.jQ(paramContext).inflate(2131492904, null);
    this.refreshFooterView.setVisibility(8);
    ((ListView)this.view).addFooterView(this.refreshFooterView, null, false);
    this.mAdapter = new Adapter(null);
    ((ListView)this.view).setAdapter(this.mAdapter);
    ((ListView)this.view).setSelector(2131101287);
    ((ListView)this.view).setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(214499);
        if ((KindaTableViewImpl.this.mEnableRefresh) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (paramAnonymousAbsListView.getCount() > 0) && (KindaTableViewImpl.this.mLoadMoreCallback != null)) {
          KindaTableViewImpl.this.mLoadMoreCallback.call();
        }
        AppMethodBeat.o(214499);
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    paramContext = (ListView)this.view;
    AppMethodBeat.o(214505);
    return paramContext;
  }
  
  public void setCells(ArrayList<KTableViewCellManager> paramArrayList)
  {
    AppMethodBeat.i(214506);
    Log.i("MicroMsg.KindaTableViewImplV2", "set cells: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.mDataList.clear();
    this.mViewMap.clear();
    this.mDataList.addAll(paramArrayList);
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
    AppMethodBeat.o(214506);
  }
  
  public void setEnableFooterRefreshView(boolean paramBoolean)
  {
    AppMethodBeat.i(214507);
    this.mEnableRefresh = paramBoolean;
    if (paramBoolean)
    {
      this.refreshFooterView.setVisibility(0);
      AppMethodBeat.o(214507);
      return;
    }
    this.refreshFooterView.setVisibility(8);
    AppMethodBeat.o(214507);
  }
  
  public void setFooterRefreshViewLoadMoreCallbackImpl(VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(214508);
    Log.d("MicroMsg.KindaTableViewImplV2", "set footer refresh callback");
    this.mLoadMoreCallback = paramVoidCallback;
    AppMethodBeat.o(214508);
  }
  
  class Adapter
    extends BaseAdapter
  {
    private Adapter() {}
    
    public int getCount()
    {
      AppMethodBeat.i(214500);
      int i = KindaTableViewImpl.this.mDataList.size();
      AppMethodBeat.o(214500);
      return i;
    }
    
    public KTableViewCellManager getItem(int paramInt)
    {
      AppMethodBeat.i(214501);
      KTableViewCellManager localKTableViewCellManager = (KTableViewCellManager)KindaTableViewImpl.this.mDataList.get(paramInt);
      AppMethodBeat.o(214501);
      return localKTableViewCellManager;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(214502);
      Log.v("MicroMsg.KindaTableViewImplV2", "get view for: %s", new Object[] { Integer.valueOf(paramInt) });
      paramView = ((KTableViewCellManager)KindaTableViewImpl.this.mDataList.get(paramInt)).getView();
      Assert.assertTrue("kViewLayout must be MMKViewLayout!", paramView instanceof MMKViewLayout);
      KindaTableViewImpl.this.mViewMap.put(Integer.valueOf(paramInt), new WeakReference(((MMKViewLayout)paramView).getView()));
      ((MMKViewLayout)paramView).getView().setTag("test_position_".concat(String.valueOf(paramInt)));
      paramView = (ViewGroup)((MMKViewLayout)paramView).getView();
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      paramViewGroup = new FrameLayout(KindaTableViewImpl.this.mContext);
      paramViewGroup.addView(paramView);
      AppMethodBeat.o(214502);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaTableViewImpl
 * JD-Core Version:    0.7.0.1
 */