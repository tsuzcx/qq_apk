package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.d;
import com.tencent.mm.sdk.platformtools.ay;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/FakeNativeSnapshotDisplayLoadingSplash$Companion;", "", "()V", "KEY", "", "setCanShowAlphaCover", "", "can", "", "plugin-appbrand-integration_release"})
public final class v$a
{
  public static void setCanShowAlphaCover(boolean paramBoolean)
  {
    AppMethodBeat.i(223890);
    Object localObject = d.jGw;
    localObject = d.LD();
    if (localObject != null)
    {
      ((ay)localObject).putBoolean("FakeNativeSnapshotDisplayLoadingSplash_SHOW_ALPHA_COVER", paramBoolean);
      AppMethodBeat.o(223890);
      return;
    }
    AppMethodBeat.o(223890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.v.a
 * JD-Core Version:    0.7.0.1
 */