package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.widget.as;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class o$4
  extends z
{
  o$4(o paramo, AppBrandLauncherRecentsList.e parame, x paramx) {}
  
  public final void aB(View paramView) {}
  
  public final void aC(View paramView)
  {
    AppMethodBeat.i(133510);
    this.iVx.a(null);
    this.iVw.m(this.iVy);
    this.iVw.iVm.remove(this.iVy);
    o.a(this.iVw);
    AppMethodBeat.o(133510);
  }
  
  public final void aD(View paramView)
  {
    AppMethodBeat.i(133511);
    if (paramView == null)
    {
      AppMethodBeat.o(133511);
      return;
    }
    t.e(paramView, 0.0F);
    t.f(paramView, 1.0F);
    AppMethodBeat.o(133511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.4
 * JD-Core Version:    0.7.0.1
 */