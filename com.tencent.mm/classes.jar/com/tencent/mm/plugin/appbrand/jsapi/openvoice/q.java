package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
{
  private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";
  
  public static void aaB(String paramString)
  {
    AppMethodBeat.i(226948);
    Log.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", new Object[] { paramString, Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtC) });
    if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtB)
    {
      a locala = new a();
      locala.mJH.appId = paramString;
      locala.mJH.beL = 16;
      locala.mJH.dDe = 1;
      EventCenter.instance.publish(locala);
    }
    AppMethodBeat.o(226948);
  }
  
  public static void aaC(String paramString)
  {
    AppMethodBeat.i(226949);
    if (TextUtils.isEmpty(paramString))
    {
      Log.i(TAG, "closeFloatBall, appId is empty");
      AppMethodBeat.o(226949);
      return;
    }
    Log.i(TAG, "hy:closeFloatBall, appId:%s", new Object[] { paramString });
    a locala = new a();
    locala.mJH.appId = paramString;
    locala.mJH.beL = 16;
    locala.mJH.dDe = 2;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(226949);
  }
  
  public static boolean bIi()
  {
    AppMethodBeat.i(226950);
    Log.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtC) });
    if (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.qtB)
    {
      Log.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
      com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.qta.a(new b() {}, q.a.quQ);
      AppMethodBeat.o(226950);
      return true;
    }
    Log.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
    AppMethodBeat.o(226950);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.q
 * JD-Core Version:    0.7.0.1
 */