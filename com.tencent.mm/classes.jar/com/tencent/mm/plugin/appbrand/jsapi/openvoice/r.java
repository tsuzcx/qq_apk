package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
{
  private static String TAG = "MicroMsg.OpenVoice.VoIpLogicHandler";
  
  public static void ais(String paramString)
  {
    AppMethodBeat.i(282250);
    Log.i(TAG, "hy:showFloatBall, appId:%s, is1v1:%s", new Object[] { paramString, Boolean.valueOf(q.tRM.tSo) });
    if (q.tRM.tSn)
    {
      a locala = new a();
      locala.pKz.appId = paramString;
      locala.pKz.aOm = 16;
      locala.pKz.fvK = 1;
      EventCenter.instance.publish(locala);
    }
    AppMethodBeat.o(282250);
  }
  
  public static void ait(String paramString)
  {
    AppMethodBeat.i(282251);
    if (TextUtils.isEmpty(paramString))
    {
      Log.i(TAG, "closeFloatBall, appId is empty");
      AppMethodBeat.o(282251);
      return;
    }
    Log.i(TAG, "hy:closeFloatBall, appId:%s", new Object[] { paramString });
    a locala = new a();
    locala.pKz.appId = paramString;
    locala.pKz.aOm = 16;
    locala.pKz.fvK = 2;
    EventCenter.instance.publish(locala);
    AppMethodBeat.o(282251);
  }
  
  public static boolean bTR()
  {
    AppMethodBeat.i(282252);
    Log.i(TAG, "hy:handUpVoIPTalking, is1v1:%s", new Object[] { Boolean.valueOf(q.tRM.tSo) });
    if (q.tRM.tSn)
    {
      Log.i(TAG, "hy:handUpVoIPTalking, stop voip talking");
      q.tRM.a(new b() {}, q.a.tTC);
      AppMethodBeat.o(282252);
      return true;
    }
    Log.i(TAG, "hy:handUpVoIPTalking, voip is stopped");
    AppMethodBeat.o(282252);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.r
 * JD-Core Version:    0.7.0.1
 */