package com.tencent.mm.live.core.core.e;

import android.content.Context;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.f.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloud;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "()V", "calcMiniWindowSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "hideMiniWindowWhenBackground", "", "setMuteWhenBackground", "updatePrivateMapKey", "", "privateMapKey", "", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  public static final a mRf;
  private static a mRg;
  
  static
  {
    AppMethodBeat.i(247985);
    mRf = new a((byte)0);
    AppMethodBeat.o(247985);
  }
  
  public final void FO(String paramString)
  {
    AppMethodBeat.i(247994);
    s.u(paramString, "privateMapKey");
    if (!Util.isNullOrNil(paramString))
    {
      i locali = new i();
      locali.m("privateMapKey", paramString);
      paramString = new i();
      paramString.m("api", "updatePrivateMapKey");
      paramString.m("params", locali);
      Log.i("MicroMsg.LiveCoreVisitor", "updatePrivateMapKey:" + paramString + ' ');
      beO().callExperimentalAPI(paramString.toString());
    }
    AppMethodBeat.o(247994);
  }
  
  public final boolean beK()
  {
    return true;
  }
  
  public final boolean beL()
  {
    return true;
  }
  
  public final Point dB(Context paramContext)
  {
    AppMethodBeat.i(248011);
    s.u(paramContext, "context");
    paramContext = com.tencent.mm.live.core.d.a.mWH;
    paramContext = com.tencent.mm.live.core.d.a.em(this.videoWidth, this.videoHeight);
    AppMethodBeat.o(248011);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "TAG", "", "getInstance", "hasInstance", "", "releaseInstance", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a beN()
    {
      AppMethodBeat.i(247971);
      if (a.beM() == null) {
        a.a(new a());
      }
      a locala = a.beM();
      s.checkNotNull(locala);
      AppMethodBeat.o(247971);
      return locala;
    }
    
    public static boolean bek()
    {
      AppMethodBeat.i(247979);
      if (a.beM() != null)
      {
        AppMethodBeat.o(247979);
        return true;
      }
      AppMethodBeat.o(247979);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.e.a
 * JD-Core Version:    0.7.0.1
 */