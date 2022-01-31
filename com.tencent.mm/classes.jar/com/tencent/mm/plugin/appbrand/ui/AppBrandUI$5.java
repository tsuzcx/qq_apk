package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.i.a;

final class AppBrandUI$5
  implements com.tencent.mm.plugin.appbrand.task.i
{
  AppBrandUI$5(AppBrandUI paramAppBrandUI) {}
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(138141);
    i locali = i.iPk;
    i.a(this.iPh, parama);
    AppMethodBeat.o(138141);
  }
  
  public final FrameLayout aLW()
  {
    AppMethodBeat.i(138139);
    FrameLayout localFrameLayout = (FrameLayout)AppBrandUI.d(this.iPh);
    AppMethodBeat.o(138139);
    return localFrameLayout;
  }
  
  public final boolean aLX()
  {
    AppMethodBeat.i(138142);
    boolean bool = this.iPh.aLX();
    AppMethodBeat.o(138142);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(138140);
    this.iPh.finish();
    AppMethodBeat.o(138140);
  }
  
  public final Activity getContext()
  {
    return this.iPh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.5
 * JD-Core Version:    0.7.0.1
 */