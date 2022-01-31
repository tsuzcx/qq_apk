package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.List;

final class s
  extends RecyclerView.a
{
  private LayoutInflater Lu;
  final SparseArray<t> hjZ = new SparseArray();
  private final ArrayList<?> hka;
  
  s(ArrayList<?> paramArrayList)
  {
    this.hka = paramArrayList;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    t localt = (t)this.hjZ.get(paramInt);
    if (localt == null) {
      return null;
    }
    Context localContext = paramViewGroup.getContext();
    if (this.Lu == null) {
      this.Lu = LayoutInflater.from(localContext);
    }
    return localt.a(this.Lu, paramViewGroup);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    t localt = (t)this.hjZ.get(getItemViewType(paramInt));
    if (localt != null) {
      localt.a(paramv, mt(paramInt));
    }
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    t localt = (t)this.hjZ.get(getItemViewType(paramInt));
    if (localt == null) {
      super.a(paramv, paramInt, paramList);
    }
    while ((paramList.size() > 0) && (localt.a(paramv, mt(paramInt), paramList.get(0)))) {
      return;
    }
    localt.a(paramv, mt(paramInt));
  }
  
  public final int getItemCount()
  {
    if (this.hka == null) {
      return 0;
    }
    return this.hka.size();
  }
  
  public final long getItemId(int paramInt)
  {
    Object localObject = mt(paramInt);
    t localt = (t)this.hjZ.get(getItemViewType(paramInt));
    if ((localObject == null) || (localt == null)) {
      return 0L;
    }
    return localt.aT(localObject);
  }
  
  public final int getItemViewType(int paramInt)
  {
    Object localObject = mt(paramInt);
    if (localObject == null) {
      return 0;
    }
    return localObject.getClass().hashCode();
  }
  
  final boolean isEmpty()
  {
    return (this.hka == null) || (bk.dk(this.hka));
  }
  
  final Object mt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getItemCount())) {
      return null;
    }
    return this.hka.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.s
 * JD-Core Version:    0.7.0.1
 */