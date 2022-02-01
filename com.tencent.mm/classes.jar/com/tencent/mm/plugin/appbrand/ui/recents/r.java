package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;

final class r
  extends RecyclerView.a
{
  private final ArrayList<?> mDataList;
  private LayoutInflater mInflater;
  final SparseArray<s> mMs;
  
  r(ArrayList<?> paramArrayList)
  {
    AppMethodBeat.i(49283);
    this.mMs = new SparseArray();
    this.mDataList = paramArrayList;
    AppMethodBeat.o(49283);
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(49286);
    s locals = (s)this.mMs.get(paramInt);
    if (locals == null)
    {
      AppMethodBeat.o(49286);
      return null;
    }
    Context localContext = paramViewGroup.getContext();
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(localContext);
    }
    paramViewGroup = locals.a(this.mInflater, paramViewGroup);
    AppMethodBeat.o(49286);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(49287);
    s locals = (s)this.mMs.get(getItemViewType(paramInt));
    if (locals != null) {
      locals.c(paramw, vE(paramInt));
    }
    AppMethodBeat.o(49287);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AppMethodBeat.i(49288);
    s locals = (s)this.mMs.get(getItemViewType(paramInt));
    if (locals == null)
    {
      super.a(paramw, paramInt, paramList);
      AppMethodBeat.o(49288);
      return;
    }
    if (paramList.size() > 0)
    {
      vE(paramInt);
      if (locals.b(paramw, paramList.get(0)))
      {
        AppMethodBeat.o(49288);
        return;
      }
    }
    locals.c(paramw, vE(paramInt));
    AppMethodBeat.o(49288);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(49291);
    if (this.mDataList == null)
    {
      AppMethodBeat.o(49291);
      return 0;
    }
    int i = this.mDataList.size();
    AppMethodBeat.o(49291);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(49290);
    Object localObject = vE(paramInt);
    s locals = (s)this.mMs.get(getItemViewType(paramInt));
    if ((localObject == null) || (locals == null))
    {
      AppMethodBeat.o(49290);
      return 0L;
    }
    long l = locals.cD(localObject);
    AppMethodBeat.o(49290);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(49289);
    Object localObject = vE(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(49289);
      return 0;
    }
    paramInt = localObject.getClass().hashCode();
    AppMethodBeat.o(49289);
    return paramInt;
  }
  
  final boolean isEmpty()
  {
    AppMethodBeat.i(49284);
    if ((this.mDataList == null) || (bt.hj(this.mDataList)))
    {
      AppMethodBeat.o(49284);
      return true;
    }
    AppMethodBeat.o(49284);
    return false;
  }
  
  final Object vE(int paramInt)
  {
    AppMethodBeat.i(49285);
    if ((paramInt < 0) || (paramInt >= getItemCount()))
    {
      AppMethodBeat.o(49285);
      return null;
    }
    Object localObject = this.mDataList.get(paramInt);
    AppMethodBeat.o(49285);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.r
 * JD-Core Version:    0.7.0.1
 */