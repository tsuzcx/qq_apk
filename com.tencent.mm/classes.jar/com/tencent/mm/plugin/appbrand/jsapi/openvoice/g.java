package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.20;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "join1v1VoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiJoin1v1VoIPChat";
  
  public g()
  {
    AppMethodBeat.i(186731);
    com.tencent.mm.plugin.appbrand.permission.c.Qk("join1v1VoIPChat");
    AppMethodBeat.o(186731);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(186732);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(186732);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c)paramc.getRuntime().as(com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c.class);
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.appbrand.jsapi.z.c.b.c)localObject1).bma();
      if (!bs.isNullOrNil((String)localObject1))
      {
        ac.e(TAG, "can not join voip chat now, message:%s", new Object[] { localObject1 });
        paramc.h(paramInt, "fail: can not join voip chat now");
        Toast.makeText(paramc.getContext(), (CharSequence)localObject1, 0).show();
        AppMethodBeat.o(186732);
        return;
      }
    }
    this.mAppId = paramc.getAppId();
    b(paramc);
    localObject1 = paramc.getAppId();
    ac.i(TAG, "hy: appId:" + (String)localObject1 + ", data:" + paramJSONObject.toString());
    try
    {
      long l = paramJSONObject.getLong("roomId");
      ac.i(TAG, "hy:roomId:".concat(String.valueOf(l)));
      int j = paramJSONObject.optInt("roomType", 2);
      int k = paramJSONObject.optInt("lifespan", 86400);
      String str1 = paramJSONObject.optString("sessionKey", "");
      String str2 = paramJSONObject.optString("privateData", "");
      Object localObject2 = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = ((JSONObject)localObject2).optBoolean("muteMicrophone");
      final boolean bool2 = ((JSONObject)localObject2).optBoolean("muteEarphone");
      final boolean bool3 = paramJSONObject.optBoolean("handsFree", false);
      this.kEK = 0;
      this.kEJ = bs.Gn();
      if ((paramc.getRuntime() != null) && (paramc.getRuntime().CC())) {}
      for (int i = 0;; i = 1)
      {
        gl(false);
        paramJSONObject = p.otZ;
        localObject2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local2 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local3 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local4 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b local5 = new com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b() {};
        ac.i("MicroMsg.OpenVoice.OpenVoiceService", "jd: trigger join room. %s, %s, %d, %d, %d", new Object[] { localObject1, "wx766655dab8fe851b", Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j) });
        paramJSONObject.ag(new p.20(paramJSONObject, (String)localObject1, "wx766655dab8fe851b", i, j, str2, l, str1, k, (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b)localObject2, local2, local3, local4, local5));
        ac.i(TAG, "hy: JsApiJoin1v1VoIPChat callbackId:".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(186732);
        return;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace(TAG, paramJSONObject, "handle join voip 1v1 data exception", new Object[0]);
      paramc.h(paramInt, e("fail: param error!", null));
      AppMethodBeat.o(186732);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.g
 * JD-Core Version:    0.7.0.1
 */