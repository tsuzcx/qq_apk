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
import com.tencent.kinda.framework.R.color;
import com.tencent.kinda.framework.R.layout;
import com.tencent.kinda.gen.KTableView;
import com.tencent.kinda.gen.KTableViewCellManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
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
    AppMethodBeat.i(226580);
    this.mDataList = new ArrayList();
    this.mEnableRefresh = false;
    this.mViewMap = new HashMap();
    AppMethodBeat.o(226580);
  }
  
  public ListView createView(Context paramContext)
  {
    AppMethodBeat.i(226585);
    Log.d("MicroMsg.KindaTableViewImplV2", "create view");
    this.view = new ListView(paramContext);
    this.refreshFooterView = af.mU(paramContext).inflate(R.layout.aa_record_list_loading_more, null);
    this.refreshFooterView.setVisibility(8);
    ((ListView)this.view).addFooterView(this.refreshFooterView, null, false);
    this.mAdapter = new Adapter(null);
    ((ListView)this.view).setAdapter(this.mAdapter);
    ((ListView)this.view).setSelector(R.color.transparent);
    ((ListView)this.view).setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(226630);
        if ((KindaTableViewImpl.this.mEnableRefresh) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (paramAnonymousAbsListView.getCount() > 0) && (KindaTableViewImpl.this.mLoadMoreCallback != null)) {
          KindaTableViewImpl.this.mLoadMoreCallback.call();
        }
        AppMethodBeat.o(226630);
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    paramContext = (ListView)this.view;
    AppMethodBeat.o(226585);
    return paramContext;
  }
  
  public void setCells(ArrayList<KTableViewCellManager> paramArrayList)
  {
    AppMethodBeat.i(226587);
    Log.i("MicroMsg.KindaTableViewImplV2", "set cells: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.mDataList.clear();
    this.mViewMap.clear();
    this.mDataList.addAll(paramArrayList);
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
    AppMethodBeat.o(226587);
  }
  
  public void setEnableFooterRefreshView(boolean paramBoolean)
  {
    AppMethodBeat.i(226588);
    this.mEnableRefresh = paramBoolean;
    if (paramBoolean)
    {
      this.refreshFooterView.setVisibility(0);
      AppMethodBeat.o(226588);
      return;
    }
    this.refreshFooterView.setVisibility(8);
    AppMethodBeat.o(226588);
  }
  
  public void setFooterRefreshViewLoadMoreCallbackImpl(VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(226590);
    Log.d("MicroMsg.KindaTableViewImplV2", "set footer refresh callback");
    this.mLoadMoreCallback = paramVoidCallback;
    AppMethodBeat.o(226590);
  }
  
  class Adapter
    extends BaseAdapter
  {
    private Adapter() {}
    
    public int getCount()
    {
      AppMethodBeat.i(226599);
      int i = KindaTableViewImpl.this.mDataList.size();
      AppMethodBeat.o(226599);
      return i;
    }
    
    public KTableViewCellManager getItem(int paramInt)
    {
      AppMethodBeat.i(226602);
      KTableViewCellManager localKTableViewCellManager = (KTableViewCellManager)KindaTableViewImpl.this.mDataList.get(paramInt);
      AppMethodBeat.o(226602);
      return localKTableViewCellManager;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(226608);
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
      AppMethodBeat.o(226608);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaTableViewImpl
 * JD-Core Version:    0.7.0.1
 */