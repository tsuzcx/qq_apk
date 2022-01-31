package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class o$2
  extends z
{
  o$2(o paramo, RecyclerView.v paramv, x paramx) {}
  
  public final void aB(View paramView)
  {
    AppMethodBeat.i(133504);
    ((RecentsRecyclerView)paramView.getParent()).cC(paramView);
    this.iVw.D(this.acv);
    AppMethodBeat.o(133504);
  }
  
  public final void aC(View paramView)
  {
    AppMethodBeat.i(133505);
    if (paramView == null)
    {
      AppMethodBeat.o(133505);
      return;
    }
    ((RecentsRecyclerView)paramView.getParent()).cD(paramView);
    this.iVx.a(null);
    t.e(paramView, 0.0F);
    this.iVw.B(this.acv);
    this.iVw.iVi.remove(this.acv);
    o.a(this.iVw);
    AppMethodBeat.o(133505);
  }
  
  public final void aD(View paramView)
  {
    AppMethodBeat.i(133506);
    if (paramView == null)
    {
      AppMethodBeat.o(133506);
      return;
    }
    t.e(paramView, 0.0F);
    t.f(paramView, 1.0F);
    AppMethodBeat.o(133506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.2
 * JD-Core Version:    0.7.0.1
 */