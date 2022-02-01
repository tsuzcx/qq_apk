package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

final class q
  extends RecyclerView.a
{
  private final ArrayList<?> mDataList;
  private LayoutInflater mInflater;
  final SparseArray<r> uol;
  
  q(ArrayList<?> paramArrayList)
  {
    AppMethodBeat.i(49283);
    this.uol = new SparseArray();
    this.mDataList = paramArrayList;
    AppMethodBeat.o(49283);
  }
  
  final Object Dx(int paramInt)
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
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    AppMethodBeat.i(323092);
    r localr = (r)this.uol.get(getItemViewType(paramInt));
    if (localr == null)
    {
      super.a(paramv, paramInt, paramList);
      AppMethodBeat.o(323092);
      return;
    }
    if (paramList.size() > 0)
    {
      Dx(paramInt);
      if (localr.a(paramv, paramList.get(0)))
      {
        AppMethodBeat.o(323092);
        return;
      }
    }
    localr.b(paramv, Dx(paramInt));
    AppMethodBeat.o(323092);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(323087);
    r localr = (r)this.uol.get(paramInt);
    if (localr == null)
    {
      AppMethodBeat.o(323087);
      return null;
    }
    Context localContext = paramViewGroup.getContext();
    if (this.mInflater == null) {
      this.mInflater = LayoutInflater.from(localContext);
    }
    paramViewGroup = localr.b(this.mInflater, paramViewGroup);
    AppMethodBeat.o(323087);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(323089);
    r localr = (r)this.uol.get(getItemViewType(paramInt));
    if (localr != null) {
      localr.b(paramv, Dx(paramInt));
    }
    AppMethodBeat.o(323089);
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
    Object localObject = Dx(paramInt);
    r localr = (r)this.uol.get(getItemViewType(paramInt));
    if ((localObject == null) || (localr == null))
    {
      AppMethodBeat.o(49290);
      return 0L;
    }
    long l = localr.ei(localObject);
    AppMethodBeat.o(49290);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(49289);
    Object localObject = Dx(paramInt);
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
    if ((this.mDataList == null) || (Util.isNullOrNil(this.mDataList)))
    {
      AppMethodBeat.o(49284);
      return true;
    }
    AppMethodBeat.o(49284);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.q
 * JD-Core Version:    0.7.0.1
 */