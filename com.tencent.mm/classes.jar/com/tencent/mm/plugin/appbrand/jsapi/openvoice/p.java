package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
{
  private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";
  
  public static void MT(String paramString)
  {
    AppMethodBeat.i(186743);
    ac.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouB) });
    if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouA)
    {
      com.tencent.mm.plugin.appbrand.jsapi.z.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.z.c.a();
      locala.laL.appId = paramString;
      locala.laL.aUu = 16;
      locala.laL.cZu = 1;
      com.tencent.mm.sdk.b.a.GpY.l(locala);
    }
    AppMethodBeat.o(186743);
  }
  
  public static void MU(String paramString)
  {
    AppMethodBeat.i(186744);
    if (TextUtils.isEmpty(paramString))
    {
      ac.i(TAG, "closeFloatBall, appId is empty");
      AppMethodBeat.o(186744);
      return;
    }
    ac.i(TAG, "hy:closeFloatBall, appId:%s", new Object[] { paramString });
    com.tencent.mm.plugin.appbrand.jsapi.z.c.a locala = new com.tencent.mm.plugin.appbrand.jsapi.z.c.a();
    locala.laL.appId = paramString;
    locala.laL.aUu = 16;
    locala.laL.cZu = 2;
    com.tencent.mm.sdk.b.a.GpY.l(locala);
    AppMethodBeat.o(186744);
  }
  
  public static boolean bip()
  {
    AppMethodBeat.i(186745);
    ac.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouB) });
    if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.ouA)
    {
      ac.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
      com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.otZ.a(new b() {}, p.a.ovN);
      AppMethodBeat.o(186745);
      return true;
    }
    ac.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
    AppMethodBeat.o(186745);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.p
 * JD-Core Version:    0.7.0.1
 */