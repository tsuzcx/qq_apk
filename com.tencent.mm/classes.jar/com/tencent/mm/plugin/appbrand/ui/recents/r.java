package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
  private final ArrayList<?> hIH;
  final SparseArray<s> lJT;
  private LayoutInflater mInflater;
  
  r(ArrayList<?> paramArrayList)
  {
    AppMethodBeat.i(49283);
    this.lJT = new SparseArray();
    this.hIH = paramArrayList;
    AppMethodBeat.o(49283);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(49286);
    s locals = (s)this.lJT.get(paramInt);
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
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(49287);
    s locals = (s)this.lJT.get(getItemViewType(paramInt));
    if (locals != null) {
      locals.c(paramv, uh(paramInt));
    }
    AppMethodBeat.o(49287);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(49288);
    s locals = (s)this.lJT.get(getItemViewType(paramInt));
    if (locals == null)
    {
      super.a(paramv, paramInt, paramList);
      AppMethodBeat.o(49288);
      return;
    }
    if (paramList.size() > 0)
    {
      uh(paramInt);
      if (locals.b(paramv, paramList.get(0)))
      {
        AppMethodBeat.o(49288);
        return;
      }
    }
    locals.c(paramv, uh(paramInt));
    AppMethodBeat.o(49288);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(49291);
    if (this.hIH == null)
    {
      AppMethodBeat.o(49291);
      return 0;
    }
    int i = this.hIH.size();
    AppMethodBeat.o(49291);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(49290);
    Object localObject = uh(paramInt);
    s locals = (s)this.lJT.get(getItemViewType(paramInt));
    if ((localObject == null) || (locals == null))
    {
      AppMethodBeat.o(49290);
      return 0L;
    }
    long l = locals.cC(localObject);
    AppMethodBeat.o(49290);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(49289);
    Object localObject = uh(paramInt);
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
    if ((this.hIH == null) || (bt.gL(this.hIH)))
    {
      AppMethodBeat.o(49284);
      return true;
    }
    AppMethodBeat.o(49284);
    return false;
  }
  
  final Object uh(int paramInt)
  {
    AppMethodBeat.i(49285);
    if ((paramInt < 0) || (paramInt >= getItemCount()))
    {
      AppMethodBeat.o(49285);
      return null;
    }
    Object localObject = this.hIH.get(paramInt);
    AppMethodBeat.o(49285);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.r
 * JD-Core Version:    0.7.0.1
 */