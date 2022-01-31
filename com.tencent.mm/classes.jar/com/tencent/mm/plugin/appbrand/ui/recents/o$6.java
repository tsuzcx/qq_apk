package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v4.view.t;
import android.support.v4.view.z;
import android.support.v7.widget.as;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class o$6
  extends z
{
  o$6(o paramo, AppBrandLauncherRecentsList.e parame) {}
  
  public final void aB(View paramView)
  {
    AppMethodBeat.i(133513);
    this.iVw.D(this.iVy);
    AppMethodBeat.o(133513);
  }
  
  public final void aC(View paramView)
  {
    AppMethodBeat.i(133514);
    t.e(paramView, 0.0F);
    t.f(paramView, 1.0F);
    this.iVw.B(this.iVy);
    this.iVw.iVq.remove(this.iVy);
    o.a(this.iVw);
    AppMethodBeat.o(133514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o.6
 * JD-Core Version:    0.7.0.1
 */