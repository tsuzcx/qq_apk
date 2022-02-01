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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private int count;
  private AbsListView.OnScrollListener oUM;
  String query;
  e tyQ;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> tyR;
  long tyS;
  a tyT;
  
  public d(e parame)
  {
    ad.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.tyQ = parame;
    this.tyR = new SparseArray();
  }
  
  private com.tencent.mm.plugin.fts.a.d.a.a GT(int paramInt)
  {
    Object localObject2 = null;
    if (this.tyR.indexOfKey(paramInt) >= 0) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.tyR.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = GR(paramInt);
      }
    }
    if (localObject1 == null) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.tyR.get(0);
    }
    this.tyR.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt);
  
  protected abstract boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean);
  
  public final void ahT(String paramString)
  {
    stopSearch();
    this.tyS = System.currentTimeMillis();
    this.query = paramString;
    ad.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    cTn();
  }
  
  protected final void al(int paramInt, boolean paramBoolean)
  {
    if (this.tyT != null) {
      this.tyT.am(paramInt, paramBoolean);
    }
  }
  
  protected void b(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  protected int cSU()
  {
    return getCount();
  }
  
  protected abstract void cTn();
  
  public final e cTs()
  {
    return this.tyQ;
  }
  
  protected void clearCache()
  {
    this.tyR.clear();
  }
  
  public void finish()
  {
    stopSearch();
  }
  
  public final Context getContext()
  {
    return this.tyQ.getContext();
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
    if (GT(paramInt) != null) {
      return GT(paramInt).oIb;
    }
    ad.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = GT(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.agC().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.tvT)
    {
      locala.a(getContext(), paramView, new Object[0]);
      b(getContext(), locala);
      locala.tvT = true;
    }
    locala.agC().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    this.tyQ.hideVKB();
    paramAdapterView = GT(paramInt - this.tyQ.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.agC().a(getContext(), paramAdapterView));
      this.tyQ.a(paramAdapterView, bool);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.oUM != null) {
      this.oUM.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.oUM != null) {
      this.oUM.onScrollStateChanged(paramAbsListView, paramInt);
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
    public abstract void am(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */