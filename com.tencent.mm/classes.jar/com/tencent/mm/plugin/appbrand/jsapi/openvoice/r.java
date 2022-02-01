package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
{
  private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";
  
  public static void abq(String paramString)
  {
    AppMethodBeat.i(326323);
    Log.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", new Object[] { paramString, Boolean.valueOf(q.wVc.wVF) });
    if (q.wVc.wVE)
    {
      a locala = new a();
      locala.sPs.appId = paramString;
      locala.sPs.cIi = 16;
      locala.sPs.hAf = 1;
      locala.publish();
    }
    AppMethodBeat.o(326323);
  }
  
  public static void abr(String paramString)
  {
    AppMethodBeat.i(326333);
    if (TextUtils.isEmpty(paramString))
    {
      Log.i(TAG, "closeFloatBall, appId is empty");
      AppMethodBeat.o(326333);
      return;
    }
    Log.i(TAG, "hy:closeFloatBall, appId:%s", new Object[] { paramString });
    a locala = new a();
    locala.sPs.appId = paramString;
    locala.sPs.cIi = 16;
    locala.sPs.hAf = 2;
    locala.publish();
    AppMethodBeat.o(326333);
  }
  
  public static boolean cue()
  {
    AppMethodBeat.i(326336);
    Log.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", new Object[] { Boolean.valueOf(q.wVc.wVF) });
    if (q.wVc.wVE)
    {
      Log.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
      q.wVc.a(new b() {}, q.a.wWT);
      AppMethodBeat.o(326336);
      return true;
    }
    Log.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
    AppMethodBeat.o(326336);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.r
 * JD-Core Version:    0.7.0.1
 */