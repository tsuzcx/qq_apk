package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "()V", "updatePrivateMapKey", "", "privateMapKey", "", "Companion", "plugin-core_release"})
public final class a
  extends c
{
  private static a kni;
  public static final a knj;
  
  static
  {
    AppMethodBeat.i(199342);
    knj = new a((byte)0);
    AppMethodBeat.o(199342);
  }
  
  public final void Nv(String paramString)
  {
    AppMethodBeat.i(199340);
    p.k(paramString, "privateMapKey");
    if (!Util.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.g("privateMapKey", paramString);
      paramString = new i();
      paramString.g("api", "updatePrivateMapKey");
      paramString.g("params", locali);
      Log.i("MicroMsg.LiveCoreVisitor", "updatePrivateMapKey:" + paramString + ' ');
      this.knl.callExperimentalAPI(paramString.toString());
    }
    AppMethodBeat.o(199340);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "TAG", "", "getInstance", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean aLi()
    {
      AppMethodBeat.i(199016);
      if (a.aLt() != null)
      {
        AppMethodBeat.o(199016);
        return true;
      }
      AppMethodBeat.o(199016);
      return false;
    }
    
    public static a aLu()
    {
      AppMethodBeat.i(199013);
      if (a.aLt() == null) {
        a.a(new a());
      }
      a locala = a.aLt();
      if (locala == null) {
        p.iCn();
      }
      AppMethodBeat.o(199013);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a
 * JD-Core Version:    0.7.0.1
 */