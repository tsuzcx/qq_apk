package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class s
  extends RecyclerView.a
{
  final SparseArray<t> iVG;
  private final ArrayList<?> iVH;
  private LayoutInflater mInflater;
  
  s(ArrayList<?> paramArrayList)
  {
    AppMethodBeat.i(133553);
    this.iVG = new SparseArray();
    this.iVH = paramArrayList;
    AppMethodBeat.o(133553);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(133556);
    t localt = (t)this.iVG.get(paramInt);
    if (localt == null)
    {
      AppMethodBeat.o(133556);
      return null;
    }
    Context localContext = paramViewGroup.getContext();
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(localContext);
    }
    paramViewGroup = localt.a(this.mInflater, paramViewGroup);
    AppMethodBeat.o(133556);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(133557);
    t localt = (t)this.iVG.get(getItemViewType(paramInt));
    if (localt != null) {
      localt.c(paramv, pJ(paramInt));
    }
    AppMethodBeat.o(133557);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(133558);
    t localt = (t)this.iVG.get(getItemViewType(paramInt));
    if (localt == null)
    {
      super.a(paramv, paramInt, paramList);
      AppMethodBeat.o(133558);
      return;
    }
    if (paramList.size() > 0)
    {
      pJ(paramInt);
      if (localt.b(paramv, paramList.get(0)))
      {
        AppMethodBeat.o(133558);
        return;
      }
    }
    localt.c(paramv, pJ(paramInt));
    AppMethodBeat.o(133558);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(133561);
    if (this.iVH == null)
    {
      AppMethodBeat.o(133561);
      return 0;
    }
    int i = this.iVH.size();
    AppMethodBeat.o(133561);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(133560);
    Object localObject = pJ(paramInt);
    t localt = (t)this.iVG.get(getItemViewType(paramInt));
    if ((localObject == null) || (localt == null))
    {
      AppMethodBeat.o(133560);
      return 0L;
    }
    long l = localt.bp(localObject);
    AppMethodBeat.o(133560);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(133559);
    Object localObject = pJ(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133559);
      return 0;
    }
    paramInt = localObject.getClass().hashCode();
    AppMethodBeat.o(133559);
    return paramInt;
  }
  
  final boolean isEmpty()
  {
    AppMethodBeat.i(133554);
    if ((this.iVH == null) || (bo.es(this.iVH)))
    {
      AppMethodBeat.o(133554);
      return true;
    }
    AppMethodBeat.o(133554);
    return false;
  }
  
  final Object pJ(int paramInt)
  {
    AppMethodBeat.i(133555);
    if ((paramInt < 0) || (paramInt >= getItemCount()))
    {
      AppMethodBeat.o(133555);
      return null;
    }
    Object localObject = this.iVH.get(paramInt);
    AppMethodBeat.o(133555);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.s
 * JD-Core Version:    0.7.0.1
 */