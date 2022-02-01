package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.d;
import com.tencent.mm.sdk.platformtools.ax;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$Companion;", "", "()V", "KEY", "", "setCanShowAlphaCover", "", "can", "", "plugin-appbrand-integration_release"})
public final class u$a
{
  public static void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(189618);
    Object localObject = d.jDy;
    localObject = d.Lv();
    if (localObject != null)
    {
      ((ax)localObject).putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
      AppMethodBeat.o(189618);
      return;
    }
    AppMethodBeat.o(189618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u.a
 * JD-Core Version:    0.7.0.1
 */