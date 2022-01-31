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
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.y;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  String bVk;
  private int count;
  private AbsListView.OnScrollListener iCE;
  private e kAO;
  private SparseArray<a> kAP;
  long kAQ;
  d.a kAR;
  
  public d(e parame)
  {
    y.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.kAO = parame;
    this.kAP = new SparseArray();
  }
  
  private a rA(int paramInt)
  {
    if (this.kAP.indexOfKey(paramInt) >= 0) {
      return (a)this.kAP.get(paramInt);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = ry(paramInt);
      }
    }
    if (localObject1 == null) {
      return (a)this.kAP.get(0);
    }
    this.kAP.put(paramInt, localObject1);
    return localObject1;
  }
  
  public final void Ej(String paramString)
  {
    stopSearch();
    this.kAQ = System.currentTimeMillis();
    this.bVk = paramString;
    y.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    aVV();
  }
  
  protected final void N(int paramInt, boolean paramBoolean)
  {
    if (this.kAR != null) {
      this.kAR.O(paramInt, paramBoolean);
    }
  }
  
  protected abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  protected int aVE()
  {
    return getCount();
  }
  
  protected abstract void aVV();
  
  protected void clearCache()
  {
    this.kAP.clear();
  }
  
  public void finish()
  {
    stopSearch();
  }
  
  public final Context getContext()
  {
    return this.kAO.getContext();
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
    if (rA(paramInt) != null) {
      return rA(paramInt).ivk;
    }
    y.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = rA(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.BD().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.kxS)
    {
      locala.a(getContext(), paramView, new Object[0]);
      locala.kxS = true;
    }
    locala.BD().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 21;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.kAO.XM();
    if (paramInt >= getCount()) {
      return;
    }
    paramAdapterView = rA(paramInt);
    a(paramView, paramAdapterView, paramAdapterView.BD().a(getContext(), paramAdapterView));
    this.kAO.a(paramAdapterView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.iCE != null) {
      this.iCE.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.iCE != null) {
      this.iCE.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected abstract a ry(int paramInt);
  
  protected final void setCount(int paramInt)
  {
    y.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
    this.count = paramInt;
  }
  
  public void stopSearch()
  {
    this.count = 0;
    this.bVk = "";
    clearCache();
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */