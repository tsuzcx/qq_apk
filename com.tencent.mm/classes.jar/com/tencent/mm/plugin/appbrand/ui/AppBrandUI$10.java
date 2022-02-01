package com.tencent.mm.plugin.appbrand.ui;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.task.g.a;

final class AppBrandUI$10
  implements g
{
  AppBrandUI$10(AppBrandUI paramAppBrandUI) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(223145);
    n localn = n.mKo;
    n.a(this.mKh, parama);
    AppMethodBeat.o(223145);
  }
  
  public final boolean aXc()
  {
    AppMethodBeat.i(223146);
    boolean bool = this.mKh.aXc();
    AppMethodBeat.o(223146);
    return bool;
  }
  
  public final FrameLayout bzE()
  {
    AppMethodBeat.i(223143);
    FrameLayout localFrameLayout = (FrameLayout)AppBrandUI.i(this.mKh);
    AppMethodBeat.o(223143);
    return localFrameLayout;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(223144);
    this.mKh.finish();
    AppMethodBeat.o(223144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.10
 * JD-Core Version:    0.7.0.1
 */