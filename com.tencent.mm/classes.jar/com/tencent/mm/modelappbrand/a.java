package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.api.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static boolean SE(String paramString)
  {
    AppMethodBeat.i(2618);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(2618);
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("BindWxaInfo");
      if (paramString != null)
      {
        if (paramString.optInt("openWxaByBizQRCode", 0) > 0)
        {
          AppMethodBeat.o(2618);
          return true;
        }
        AppMethodBeat.o(2618);
        return false;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(2618);
    }
    return false;
  }
  
  public static int SF(String paramString)
  {
    AppMethodBeat.i(220352);
    int i = 1;
    if (as.bvK(paramString)) {
      i = 2;
    }
    for (;;)
    {
      if (ab.PR(paramString)) {
        i = 4;
      }
      AppMethodBeat.o(220352);
      return i;
      if (ab.PP(paramString)) {
        i = 3;
      }
    }
  }
  
  private static void a(xw paramxw, k.b paramb)
  {
    paramxw.fWN.appId = paramb.loB;
    paramxw.fWN.userName = paramb.loA;
    paramxw.fWN.fWP = paramb.loz;
    paramxw.fWN.fWQ = paramb.loT;
    paramxw.fWN.fWT = paramb.loD;
    paramxw.fWN.appVersion = paramb.loU;
    paramxw.fWN.fWW.lyw = paramb.loM;
    paramxw = paramxw.fWN;
    if (paramb.loT != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramxw.fWU = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2620);
    xw localxw = new xw();
    a(localxw, paramb);
    b(localxw, paramb);
    localxw.fWN.scene = paramInt;
    if ((paramInt == 1074) || (paramInt == 1157)) {
      localxw.fWN.fvd = paramString;
    }
    localxw.fWN.fyw = paramBundle;
    localxw.fWN.chatType = paramBundle.getInt("chat_type", -1);
    localxw.fWN.fWY = paramBundle.getString("chatroom_username", "");
    EventCenter.instance.publish(localxw);
    AppMethodBeat.o(2620);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    xw localxw = new xw();
    a(localxw, paramb);
    b(localxw, paramb);
    int j = paramBundle.getInt("chat_type", -1);
    xw.a locala = localxw.fWN;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localxw.fWN;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label191;
      }
    }
    label191:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.fvd = (paramString1 + ":" + paramb.loF + ":" + j);
      localxw.fWN.fyw = paramBundle;
      localxw.fWN.chatType = j;
      localxw.fWN.fWY = paramBundle.getString("chatroom_username", "");
      EventCenter.instance.publish(localxw);
      AppMethodBeat.o(2619);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(xw paramxw, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.aj.a)paramb.ar(com.tencent.mm.aj.a.class);
      if ((paramb != null) && (!Util.isNullOrNil(paramb.lkn))) {
        paramxw.fWN.fXg = paramb.lkn;
      }
      if (paramb != null)
      {
        j localj = new j();
        localj.lkp = paramb.lkp;
        paramxw.fWN.fXh = localj.bFa();
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.loG))
    {
      Log.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    xw localxw = new xw();
    a(localxw, paramb);
    b(localxw, paramb);
    localxw.fWN.scene = 1044;
    int j = paramBundle.getInt("chat_type", -1);
    localxw.fWN.fvd = (paramb.loF + ":" + j + ":" + paramString1);
    xw.a locala = localxw.fWN;
    if (paramBoolean) {}
    for (;;)
    {
      locala.fXa = i;
      locala = localxw.fWN;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.fXb = paramString2;
      localxw.fWN.fWW.cwU = paramb.loG;
      localxw.fWN.fWW.cwT = paramString1;
      localxw.fWN.chatType = j;
      localxw.fWN.fWY = paramBundle.getString("chatroom_username", "");
      localxw.fWN.fyw = paramBundle;
      EventCenter.instance.publish(localxw);
      AppMethodBeat.o(2621);
      return;
      i = 1;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.loC == 2) || (paramb.loC == 3))) || (paramb.type == 36);
  }
  
  public static boolean c(k.b paramb)
  {
    return paramb.type == 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */