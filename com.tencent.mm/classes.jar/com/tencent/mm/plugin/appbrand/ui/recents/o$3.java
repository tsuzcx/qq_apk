package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class o$3
  extends z
{
  o$3(o paramo, RecyclerView.v paramv, x paramx) {}
  
  public final void aB(View paramView)
  {
    AppMethodBeat.i(133507);
    ((RecentsRecyclerView)paramView.getParent()).cC(paramView);
    this.iVw.D(this.acv);
    AppMethodBeat.o(133507);
  }
  
  public final void aC(View paramView)
  {
    AppMethodBeat.i(133508);
    if (paramView == null)
    {
      AppMethodBeat.o(133508);
      return;
    }
    ((RecentsRecyclerView)paramView.getParent()).cD(paramView);
    this.iVx.a(null);
    t.e(paramView, 0.0F);
    this.iVw.B(this.acv);
    this.iVw.iVk.remove(this.acv);
    o.a(this.iVw);
    AppMethodBeat.o(133508);
  }
  
  public final void aD(View paramView)
  {
    AppMethodBeat.i(133509);
    if (paramView == null)
    {
      AppMethodBeat.o(133509);
      return;
    }
    t.e(paramView, 0.0F);
    t.f(paramView, 1.0F);
    AppMethodBeat.o(133509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.3
 * JD-Core Version:    0.7.0.1
 */