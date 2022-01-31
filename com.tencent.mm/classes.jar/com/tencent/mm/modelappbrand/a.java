package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static void a(so paramso, j.b paramb)
  {
    paramso.cIQ.appId = paramb.fiY;
    paramso.cIQ.userName = paramb.fiX;
    paramso.cIQ.cIS = paramb.fiW;
    paramso.cIQ.cIT = paramb.fjh;
    paramso.cIQ.cIV = paramb.fja;
    paramso.cIQ.bDc = paramb.fji;
    paramso = paramso.cIQ;
    if (paramb.fjh != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramso.cIW = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, j.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(51127);
    so localso = new so();
    a(localso, paramb);
    b(localso, paramb);
    localso.cIQ.scene = paramInt;
    if (paramInt == 1074) {
      localso.cIQ.cmF = paramString;
    }
    localso.cIQ.cpJ = paramBundle;
    com.tencent.mm.sdk.b.a.ymk.l(localso);
    AppMethodBeat.o(51127);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, j.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(51126);
    so localso = new so();
    a(localso, paramb);
    b(localso, paramb);
    so.a locala = localso.cIQ;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localso.cIQ;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label142;
      }
    }
    label142:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.cmF = (paramString1 + ":" + paramb.fjc);
      localso.cIQ.cpJ = paramBundle;
      com.tencent.mm.sdk.b.a.ymk.l(localso);
      AppMethodBeat.o(51126);
      return;
      i = 1007;
      break;
    }
  }
  
  public static boolean acg()
  {
    AppMethodBeat.i(51130);
    if (!g.RG())
    {
      AppMethodBeat.o(51130);
      return false;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100360");
    if ((localc.isValid()) && ("1".equals(localc.dvN().get("isOpenFTSSearchMiniGameEntry"))))
    {
      AppMethodBeat.o(51130);
      return true;
    }
    AppMethodBeat.o(51130);
    return false;
  }
  
  private static void b(so paramso, j.b paramb)
  {
    AppMethodBeat.i(51129);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.af.a)paramb.R(com.tencent.mm.af.a.class);
      if ((paramb != null) && (!bo.isNullOrNil(paramb.ffo))) {
        paramso.cIQ.cJg = paramb.ffo;
      }
    }
    AppMethodBeat.o(51129);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, j.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(51128);
    if (TextUtils.isEmpty(paramb.fjd))
    {
      ab.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(51128);
      return;
    }
    so localso = new so();
    a(localso, paramb);
    b(localso, paramb);
    localso.cIQ.scene = 1044;
    localso.cIQ.cmF = paramb.fjc;
    so.a locala = localso.cIQ;
    if (paramBoolean) {}
    for (;;)
    {
      locala.cJb = i;
      locala = localso.cIQ;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.cJc = paramString2;
      localso.cIQ.cIY.bCZ = paramb.fjd;
      localso.cIQ.cIY.bCY = paramString1;
      localso.cIQ.cpJ = paramBundle;
      com.tencent.mm.sdk.b.a.ymk.l(localso);
      AppMethodBeat.o(51128);
      return;
      i = 1;
    }
  }
  
  public static boolean qe(String paramString)
  {
    AppMethodBeat.i(51125);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(51125);
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("BindWxaInfo");
      if (paramString != null)
      {
        if (paramString.optInt("openWxaByBizQRCode", 0) > 0)
        {
          AppMethodBeat.o(51125);
          return true;
        }
        AppMethodBeat.o(51125);
        return false;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(51125);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */