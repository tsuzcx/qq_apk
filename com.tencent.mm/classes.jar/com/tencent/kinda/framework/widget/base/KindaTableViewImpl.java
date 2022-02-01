package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.kinda.gen.KTableView;
import com.tencent.kinda.gen.KTableViewCellManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KindaTableViewImpl
  extends MMKView<ListView>
  implements KTableView
{
  private static final String TAG = "MicroMsg.KindaTableViewImplV2";
  private KindaTableViewImpl.Adapter mAdapter;
  private ArrayList<KTableViewCellManager> mDataList;
  private boolean mEnableRefresh;
  private VoidCallback mLoadMoreCallback;
  private Map<Integer, WeakReference<View>> mViewMap;
  private View refreshFooterView;
  
  public KindaTableViewImpl()
  {
    AppMethodBeat.i(199495);
    this.mDataList = new ArrayList();
    this.mEnableRefresh = false;
    this.mViewMap = new HashMap();
    AppMethodBeat.o(199495);
  }
  
  public ListView createView(Context paramContext)
  {
    AppMethodBeat.i(199496);
    ad.d("MicroMsg.KindaTableViewImplV2", "create view");
    this.view = new ListView(paramContext);
    this.refreshFooterView = z.jO(paramContext).inflate(2131492888, null);
    this.refreshFooterView.setVisibility(8);
    ((ListView)this.view).addFooterView(this.refreshFooterView, null, false);
    this.mAdapter = new KindaTableViewImpl.Adapter(this, null);
    ((ListView)this.view).setAdapter(this.mAdapter);
    ((ListView)this.view).setSelector(2131101053);
    ((ListView)this.view).setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(199490);
        if ((KindaTableViewImpl.this.mEnableRefresh) && (paramAnonymousAbsListView.getLastVisiblePosition() == paramAnonymousAbsListView.getCount() - 1) && (paramAnonymousAbsListView.getCount() > 0) && (KindaTableViewImpl.this.mLoadMoreCallback != null)) {
          KindaTableViewImpl.this.mLoadMoreCallback.call();
        }
        AppMethodBeat.o(199490);
      }
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    paramContext = (ListView)this.view;
    AppMethodBeat.o(199496);
    return paramContext;
  }
  
  public void setCells(ArrayList<KTableViewCellManager> paramArrayList)
  {
    AppMethodBeat.i(199497);
    ad.i("MicroMsg.KindaTableViewImplV2", "set cells: %s", new Object[] { Integer.valueOf(paramArrayList.size()) });
    this.mDataList.clear();
    this.mViewMap.clear();
    this.mDataList.addAll(paramArrayList);
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
    AppMethodBeat.o(199497);
  }
  
  public void setEnableFooterRefreshView(boolean paramBoolean)
  {
    AppMethodBeat.i(199498);
    this.mEnableRefresh = paramBoolean;
    if (paramBoolean)
    {
      this.refreshFooterView.setVisibility(0);
      AppMethodBeat.o(199498);
      return;
    }
    this.refreshFooterView.setVisibility(8);
    AppMethodBeat.o(199498);
  }
  
  public void setFooterRefreshViewLoadMoreCallbackImpl(VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(199499);
    ad.d("MicroMsg.KindaTableViewImplV2", "set footer refresh callback");
    this.mLoadMoreCallback = paramVoidCallback;
    AppMethodBeat.o(199499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaTableViewImpl
 * JD-Core Version:    0.7.0.1
 */