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
import com.tencent.mm.sdk.platformtools.ac;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private int count;
  private AbsListView.OnScrollListener orq;
  String query;
  e sCp;
  private SparseArray<a> sCq;
  long sCr;
  a sCs;
  
  public d(e parame)
  {
    ac.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.sCp = parame;
    this.sCq = new SparseArray();
  }
  
  private a FE(int paramInt)
  {
    Object localObject2 = null;
    if (this.sCq.indexOfKey(paramInt) >= 0) {
      return (a)this.sCq.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = FC(paramInt);
      }
    }
    if (localObject1 == null) {
      return (a)this.sCq.get(0);
    }
    this.sCq.put(paramInt, localObject1);
    return localObject1;
  }
  
  protected abstract a FC(int paramInt);
  
  protected abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  public final void adT(String paramString)
  {
    stopSearch();
    this.sCr = System.currentTimeMillis();
    this.query = paramString;
    ac.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    cKY();
  }
  
  protected final void ah(int paramInt, boolean paramBoolean)
  {
    if (this.sCs != null) {
      this.sCs.ai(paramInt, paramBoolean);
    }
  }
  
  protected void b(Context paramContext, a parama) {}
  
  protected int cKF()
  {
    return getCount();
  }
  
  protected abstract void cKY();
  
  protected void clearCache()
  {
    this.sCq.clear();
  }
  
  public void finish()
  {
    stopSearch();
  }
  
  public final Context getContext()
  {
    return this.sCp.getContext();
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
    if (FE(paramInt) != null) {
      return FE(paramInt).oeH;
    }
    ac.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = FE(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.adW().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.szs)
    {
      locala.a(getContext(), paramView, new Object[0]);
      b(getContext(), locala);
      locala.szs = true;
    }
    locala.adW().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.sCp.hideVKB();
    paramAdapterView = FE(paramInt - this.sCp.getListView().getHeaderViewsCount());
    if (paramAdapterView != null)
    {
      boolean bool = a(paramView, paramAdapterView, paramAdapterView.adW().a(getContext(), paramAdapterView));
      this.sCp.a(paramAdapterView, bool);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.orq != null) {
      this.orq.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.orq != null) {
      this.orq.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    ac.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
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
    public abstract void ai(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */