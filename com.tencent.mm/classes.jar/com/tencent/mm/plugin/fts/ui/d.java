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
import com.tencent.mm.sdk.platformtools.ae;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private int count;
  private AbsListView.OnScrollListener pbp;
  String query;
  e tJH;
  private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> tJI;
  long tJJ;
  a tJK;
  
  public d(e parame)
  {
    ae.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.tJH = parame;
    this.tJI = new SparseArray();
  }
  
  private com.tencent.mm.plugin.fts.a.d.a.a Hq(int paramInt)
  {
    Object localObject2 = null;
    if (this.tJI.indexOfKey(paramInt) >= 0) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.tJI.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = Ho(paramInt);
      }
    }
    if (localObject1 == null) {
      return (com.tencent.mm.plugin.fts.a.d.a.a)this.tJI.get(0);
    }
    this.tJI.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt);
  
  protected abstract boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean);
  
  public final void aiR(String paramString)
  {
    stopSearch();
    this.tJJ = System.currentTimeMillis();
    this.query = paramString;
    ae.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    cVS();
  }
  
  protected final void ao(int paramInt, boolean paramBoolean)
  {
    if (this.tJK != null) {
      this.tJK.ap(paramInt, paramBoolean);
    }
  }
  
  protected void b(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a parama) {}
  
  protected abstract void cVS();
  
  public final e cVX()
  {
    return this.tJH;
  }
  
  protected int cVz()
  {
    return getCount();
  }
  
  protected void clearCache()
  {
    this.tJI.clear();
  }
  
  public void finish()
  {
    stopSearch();
  }
  
  public final Context getContext()
  {
    return this.tJH.getContext();
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
    if (Hq(paramInt) != null) {
      return Hq(paramInt).oOD;
    }
    ae.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public final String getQuery()
  {
    return this.query;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.plugin.fts.a.d.a.a locala = Hq(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.agQ().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.tGK)
    {
      locala.a(getContext(), paramView, new Object[0]);
      b(getContext(), locala);
      locala.tGK = true;
    }
    locala.agQ().a(getContext(), paramView, locala, new Object[0]);
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
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    this.tJH.hideVKB();
    paramAdapterView = Hq(paramInt - this.tJH.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.agQ().a(getContext(), paramAdapterView));
      this.tJH.a(paramAdapterView, bool);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.pbp != null) {
      this.pbp.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.pbp != null) {
      this.pbp.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    ae.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
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
    public abstract void ap(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */