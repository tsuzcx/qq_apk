package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
{
  private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";
  
  public static void Qq(String paramString)
  {
    AppMethodBeat.i(188489);
    ad.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", new Object[] { paramString, Boolean.valueOf(p.oXv.oXW) });
    if (p.oXv.oXV)
    {
      com.tencent.mm.plugin.appbrand.jsapi.ac.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.a();
      locala.lxL.appId = paramString;
      locala.lxL.beO = 16;
      locala.lxL.dkM = 1;
      com.tencent.mm.sdk.b.a.IbL.l(locala);
    }
    AppMethodBeat.o(188489);
  }
  
  public static void Qr(String paramString)
  {
    AppMethodBeat.i(188490);
    if (TextUtils.isEmpty(paramString))
    {
      ad.i(TAG, "closeFloatBall, appId is empty");
      AppMethodBeat.o(188490);
      return;
    }
    ad.i(TAG, "hy:closeFloatBall, appId:%s", new Object[] { paramString });
    com.tencent.mm.plugin.appbrand.jsapi.ac.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.ac.c.a();
    locala.lxL.appId = paramString;
    locala.lxL.beO = 16;
    locala.lxL.dkM = 2;
    com.tencent.mm.sdk.b.a.IbL.l(locala);
    AppMethodBeat.o(188490);
  }
  
  public static boolean bma()
  {
    AppMethodBeat.i(188491);
    ad.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", new Object[] { Boolean.valueOf(p.oXv.oXW) });
    if (p.oXv.oXV)
    {
      ad.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
      p.oXv.a(new b() {}, p.a.oZi);
      AppMethodBeat.o(188491);
      return true;
    }
    ad.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
    AppMethodBeat.o(188491);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.q
 * JD-Core Version:    0.7.0.1
 */