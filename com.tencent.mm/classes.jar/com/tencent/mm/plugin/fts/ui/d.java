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
import com.tencent.mm.sdk.platformtools.ab;

public abstract class d
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private int count;
  private AbsListView.OnScrollListener kHL;
  private e mWG;
  private SparseArray<a> mWH;
  long mWI;
  d.a mWJ;
  String query;
  
  public d(e parame)
  {
    ab.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
    this.mWG = parame;
    this.mWH = new SparseArray();
  }
  
  private a ww(int paramInt)
  {
    Object localObject2 = null;
    if (this.mWH.indexOfKey(paramInt) >= 0) {
      return (a)this.mWH.get(paramInt);
    }
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < getCount()) {
        localObject1 = wu(paramInt);
      }
    }
    if (localObject1 == null) {
      return (a)this.mWH.get(0);
    }
    this.mWH.put(paramInt, localObject1);
    return localObject1;
  }
  
  public final void Pu(String paramString)
  {
    stopSearch();
    this.mWI = System.currentTimeMillis();
    this.query = paramString;
    ab.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[] { paramString });
    bCy();
  }
  
  protected final void V(int paramInt, boolean paramBoolean)
  {
    if (this.mWJ != null) {
      this.mWJ.W(paramInt, paramBoolean);
    }
  }
  
  protected abstract boolean a(View paramView, a parama, boolean paramBoolean);
  
  protected int bCf()
  {
    return getCount();
  }
  
  protected abstract void bCy();
  
  protected void clearCache()
  {
    this.mWH.clear();
  }
  
  public void finish()
  {
    stopSearch();
  }
  
  public final Context getContext()
  {
    return this.mWG.getContext();
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
    if (ww(paramInt) != null) {
      return ww(paramInt).kwo;
    }
    ab.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = ww(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.Pr().a(getContext(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    if (!locala.mTG)
    {
      locala.a(getContext(), paramView, new Object[0]);
      locala.mTG = true;
    }
    locala.Pr().a(getContext(), paramView, locala, new Object[0]);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 22;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mWG.hideVKB();
    if (paramInt >= getCount()) {
      return;
    }
    paramAdapterView = ww(paramInt);
    a(paramView, paramAdapterView, paramAdapterView.Pr().a(getContext(), paramAdapterView));
    this.mWG.a(paramAdapterView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.kHL != null) {
      this.kHL.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.kHL != null) {
      this.kHL.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  protected final void setCount(int paramInt)
  {
    ab.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[] { Integer.valueOf(paramInt) });
    this.count = paramInt;
  }
  
  public void stopSearch()
  {
    this.count = 0;
    this.query = "";
    clearCache();
    notifyDataSetChanged();
  }
  
  protected abstract a wu(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.d
 * JD-Core Version:    0.7.0.1
 */