package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.plugin.appbrand.api.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static boolean CA(String paramString)
  {
    AppMethodBeat.i(2618);
    if (bu.isNullOrNil(paramString))
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
  
  private static void a(vq paramvq, k.b paramb)
  {
    paramvq.dKT.appId = paramb.hFd;
    paramvq.dKT.userName = paramb.hFc;
    paramvq.dKT.dKV = paramb.hFb;
    paramvq.dKT.dKW = paramb.hFr;
    paramvq.dKT.dKZ = paramb.hFf;
    paramvq.dKT.aDD = paramb.hFs;
    paramvq = paramvq.dKT;
    if (paramb.hFr != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramvq.dLa = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2620);
    vq localvq = new vq();
    a(localvq, paramb);
    b(localvq, paramb);
    localvq.dKT.scene = paramInt;
    if ((paramInt == 1074) || (paramInt == 1157)) {
      localvq.dKT.dlj = paramString;
    }
    localvq.dKT.doz = paramBundle;
    com.tencent.mm.sdk.b.a.IvT.l(localvq);
    AppMethodBeat.o(2620);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    vq localvq = new vq();
    a(localvq, paramb);
    b(localvq, paramb);
    vq.a locala = localvq.dKT;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localvq.dKT;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.dlj = (paramString1 + ":" + paramb.hFh);
      localvq.dKT.doz = paramBundle;
      com.tencent.mm.sdk.b.a.IvT.l(localvq);
      AppMethodBeat.o(2619);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(vq paramvq, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
      if ((paramb != null) && (!bu.isNullOrNil(paramb.hAX))) {
        paramvq.dKT.dLl = paramb.hAX;
      }
      if (paramb != null)
      {
        h localh = new h();
        localh.hAZ = paramb.hAZ;
        paramvq.dKT.dLm = localh.aYO();
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.hFi))
    {
      ae.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    vq localvq = new vq();
    a(localvq, paramb);
    b(localvq, paramb);
    localvq.dKT.scene = 1044;
    localvq.dKT.dlj = paramb.hFh;
    vq.a locala = localvq.dKT;
    if (paramBoolean) {}
    for (;;)
    {
      locala.dLf = i;
      locala = localvq.dKT;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.dLg = paramString2;
      localvq.dKT.dLc.cmw = paramb.hFi;
      localvq.dKT.dLc.cmv = paramString1;
      localvq.dKT.doz = paramBundle;
      com.tencent.mm.sdk.b.a.IvT.l(localvq);
      AppMethodBeat.o(2621);
      return;
      i = 1;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.hFe == 2) || (paramb.hFe == 3))) || (paramb.type == 36);
  }
  
  public static boolean c(k.b paramb)
  {
    return paramb.type == 44;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */