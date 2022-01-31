package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.b.c;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.1;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends d
{
  public static final int CTRL_INDEX = 516;
  public static final String NAME = "joinVoIPChat";
  private static String TAG = "MicroMsg.OpenVoice.JsApiCloudVoiceJoinVoIPChat";
  private e gyK = new e();
  private f gyL = new f();
  private g gyM = new g();
  private long gyN = -1L;
  private int gyO = 0;
  private String mAppId = "";
  
  public final void b(o paramo, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramo.C(paramInt, h("fail:data is null or nil", null));
      return;
    }
    this.mAppId = paramo.mAppId;
    Object localObject = new b.1(this);
    paramo.getRuntime().fyy.a((c.a)localObject);
    try
    {
      String str1 = paramJSONObject.getString("signature");
      String str2 = paramJSONObject.getString("nonceStr");
      String str3 = paramJSONObject.getString("groupId");
      int i = paramJSONObject.getInt("timeStamp");
      paramJSONObject = paramJSONObject.getJSONObject("muteConfig");
      boolean bool1 = paramJSONObject.optBoolean("muteMicrophone");
      boolean bool2 = paramJSONObject.optBoolean("muteEarphone");
      paramJSONObject = paramo.mAppId;
      y.i(TAG, "hy: appId:" + paramJSONObject + ",signature:" + str1 + ",nonceStr:" + str2 + ",groupId:" + str3 + ",muteMicroPhone:" + bool1 + ",muteEarPhone:" + bool2);
      this.gyO = 0;
      this.gyN = bk.UZ();
      j localj = j.iFl;
      b.2 local2 = new b.2(this, bool2, bool1, paramo, paramInt);
      localObject = new b.3(this, paramo, (c.a)localObject);
      b.4 local4 = new b.4(this, paramo);
      b.5 local5 = new b.5(this, paramo);
      y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger join room. %s, %s, %s, %d, %s", new Object[] { paramJSONObject, str1, str3, Integer.valueOf(i), str2 });
      localj.H(new j.1(localj, paramJSONObject, "wx766655dab8fe851b", str1, str3, i, str2, local2, (a)localObject, local4, local5));
      y.i(TAG, "hy: JsApiCloudVoiceJoinVoIPChat callbackId:" + paramInt);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace(TAG, paramJSONObject, "", new Object[0]);
      paramo.C(paramInt, h("fail: param error!", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b
 * JD-Core Version:    0.7.0.1
 */