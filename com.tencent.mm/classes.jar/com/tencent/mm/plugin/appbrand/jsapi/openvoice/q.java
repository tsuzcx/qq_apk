package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
{
  private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";
  
  public static void QZ(String paramString)
  {
    AppMethodBeat.i(222639);
    ae.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", new Object[] { paramString, Boolean.valueOf(p.pdY.pez) });
    if (p.pdY.pey)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ad.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.a();
      locala.lCj.appId = paramString;
      locala.lCj.beO = 16;
      locala.lCj.dlO = 1;
      com.tencent.mm.sdk.b.a.IvT.l(locala);
    }
    AppMethodBeat.o(222639);
  }
  
  public static void Ra(String paramString)
  {
    AppMethodBeat.i(222640);
    if (TextUtils.isEmpty(paramString))
    {
      ae.i(TAG, "closeFloatBall, appId is empty");
      AppMethodBeat.o(222640);
      return;
    }
    ae.i(TAG, "hy:closeFloatBall, appId:%s", new Object[] { paramString });
    com.tencent.mm.plugin.appbrand.jsapi.ad.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ad.c.a();
    locala.lCj.appId = paramString;
    locala.lCj.beO = 16;
    locala.lCj.dlO = 2;
    com.tencent.mm.sdk.b.a.IvT.l(locala);
    AppMethodBeat.o(222640);
  }
  
  public static boolean bmJ()
  {
    AppMethodBeat.i(222641);
    ae.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", new Object[] { Boolean.valueOf(p.pdY.pez) });
    if (p.pdY.pey)
    {
      ae.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
      p.pdY.a(new q.1(), p.a.pfM);
      AppMethodBeat.o(222641);
      return true;
    }
    ae.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
    AppMethodBeat.o(222641);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.q
 * JD-Core Version:    0.7.0.1
 */