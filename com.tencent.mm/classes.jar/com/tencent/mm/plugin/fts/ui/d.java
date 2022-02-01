package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private int count;
  private AbsListView.OnScrollListener nOo;
  String query;
  e rtw;
  private SparseArray<a> rtx;
  long rty;
  a rtz;
  
  public d(e parame)
  {
    ad.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.rtw = parame;
    this.rtx = new SparseArray();
  }
  
  private a DI(int paramInt)
  {
    Object localObject2 = null;
    if (this.rtx.indexOfKey(paramInt) >= 0) {
      return (a)this.rtx.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = DG(paramInt);
      }
    }
    if (localObject1 == null) {
      return (a)this.rtx.get(0);
    }
    this.rtx.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract a DG(int paramInt);
  
  public final void Zl(String paramString)
  {
    stopSearch();
    this.rty = System.currentTimeMillis();
    this.query = paramString;
    ad.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    cxM();
  }
  
  protected abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  protected final void ae(int paramInt, boolean paramBoolean)
  {
    if (this.rtz != null) {
      this.rtz.af(paramInt, paramBoolean);
    }
  }
  
  protected void b(Context paramContext, a parama) {}
  
  protected void clearCache()
  {
    this.rtx.clear();
  }
  
  protected abstract void cxM();
  
  protected int cxt()
  {
    return getCount();
  }
  
  public void finish()
  {
    stopSearch();
  }
  
  public final Context getContext()
  {
    return this.rtw.getContext();
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (DI(paramInt) != null) {
      return DI(paramInt).nBH;
    }
    ad.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = DI(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.acQ().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.rqy)
    {
      locala.a(getContext(), paramView, new Object[0]);
      b(getContext(), locala);
      locala.rqy = true;
    }
    locala.acQ().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.rtw.hideVKB();
    paramAdapterView = DI(paramInt - this.rtw.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.acQ().a(getContext(), paramAdapterView));
      this.rtw.a(paramAdapterView, bool);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.nOo != null) {
      this.nOo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.nOo != null) {
      this.nOo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    ad.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
    this.count = paramInt;
  }
  
  public void stopSearch()
  {
    this.count = 0;
    this.query = "";
    clearCache();
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void af(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */