package com.tencent.mm.live.core.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "()V", "updatePrivateMapKey", "", "privateMapKey", "", "Companion", "plugin-core_release"})
public final class a
  extends b
{
  private static a hAi;
  public static final a hAj;
  
  static
  {
    AppMethodBeat.i(196489);
    hAj = new a((byte)0);
    AppMethodBeat.o(196489);
  }
  
  public final void Go(String paramString)
  {
    AppMethodBeat.i(196488);
    p.h(paramString, "privateMapKey");
    if (!Util.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.h("privateMapKey", paramString);
      paramString = new i();
      paramString.h("api", "updatePrivateMapKey");
      paramString.h("params", locali);
      Log.i("MicroMsg.LiveCoreVisitor", "updatePrivateMapKey:" + paramString + ' ');
      this.hAl.callExperimentalAPI(paramString.toString());
    }
    AppMethodBeat.o(196488);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean aDp()
    {
      AppMethodBeat.i(196487);
      if (a.aDv() != null)
      {
        AppMethodBeat.o(196487);
        return true;
      }
      AppMethodBeat.o(196487);
      return false;
    }
    
    public static a aDw()
    {
      AppMethodBeat.i(196486);
      if (a.aDv() == null) {
        a.a(new a());
      }
      a locala = a.aDv();
      if (locala == null) {
        p.hyc();
      }
      AppMethodBeat.o(196486);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.a
 * JD-Core Version:    0.7.0.1
 */