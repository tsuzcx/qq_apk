package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppBrandSharedMessageUI$a
  extends RecyclerView.a
{
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt) {}
  
  public final int getItemCount()
  {
    return 0;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(133095);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(133095);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI.a
 * JD-Core Version:    0.7.0.1
 */