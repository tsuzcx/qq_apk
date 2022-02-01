package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.a;
import com.tencent.mm.plugin.appbrand.api.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static boolean Ll(String paramString)
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
  
  private static void a(wq paramwq, k.b paramb)
  {
    paramwq.ecI.appId = paramb.izj;
    paramwq.ecI.userName = paramb.izi;
    paramwq.ecI.ecK = paramb.izh;
    paramwq.ecI.ecL = paramb.izz;
    paramwq.ecI.ecO = paramb.izl;
    paramwq.ecI.appVersion = paramb.izA;
    paramwq = paramwq.ecI;
    if (paramb.izz != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramwq.ecP = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2620);
    wq localwq = new wq();
    a(localwq, paramb);
    b(localwq, paramb);
    localwq.ecI.scene = paramInt;
    if ((paramInt == 1074) || (paramInt == 1157)) {
      localwq.ecI.dCw = paramString;
    }
    localwq.ecI.dFP = paramBundle;
    EventCenter.instance.publish(localwq);
    AppMethodBeat.o(2620);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    wq localwq = new wq();
    a(localwq, paramb);
    b(localwq, paramb);
    wq.a locala = localwq.ecI;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localwq.ecI;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.dCw = (paramString1 + ":" + paramb.izn);
      localwq.ecI.dFP = paramBundle;
      EventCenter.instance.publish(localwq);
      AppMethodBeat.o(2619);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(wq paramwq, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.ag.a)paramb.as(com.tencent.mm.ag.a.class);
      if ((paramb != null) && (!Util.isNullOrNil(paramb.ive))) {
        paramwq.ecI.eda = paramb.ive;
      }
      if (paramb != null)
      {
        j localj = new j();
        localj.ivg = paramb.ivg;
        paramwq.ecI.edb = localj.bua();
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.izo))
    {
      Log.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    wq localwq = new wq();
    a(localwq, paramb);
    b(localwq, paramb);
    localwq.ecI.scene = 1044;
    localwq.ecI.dCw = paramb.izn;
    wq.a locala = localwq.ecI;
    if (paramBoolean) {}
    for (;;)
    {
      locala.ecU = i;
      locala = localwq.ecI;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.ecV = paramString2;
      localwq.ecI.ecR.cyr = paramb.izo;
      localwq.ecI.ecR.cyq = paramString1;
      localwq.ecI.dFP = paramBundle;
      EventCenter.instance.publish(localwq);
      AppMethodBeat.o(2621);
      return;
      i = 1;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.izk == 2) || (paramb.izk == 3))) || (paramb.type == 36);
  }
  
  public static boolean c(k.b paramb)
  {
    return paramb.type == 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */