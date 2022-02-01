package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static void a(uj paramuj, k.b paramb)
  {
    paramuj.dzH.appId = paramb.gJF;
    paramuj.dzH.userName = paramb.gJE;
    paramuj.dzH.dzJ = paramb.gJD;
    paramuj.dzH.dzK = paramb.gJQ;
    paramuj.dzH.dzM = paramb.gJH;
    paramuj.dzH.aAS = paramb.gJR;
    paramuj = paramuj.dzH;
    if (paramb.gJQ != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramuj.dzN = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2620);
    uj localuj = new uj();
    a(localuj, paramb);
    b(localuj, paramb);
    localuj.dzH.scene = paramInt;
    if ((paramInt == 1074) || (paramInt == 1157)) {
      localuj.dzH.dbt = paramString;
    }
    localuj.dzH.deG = paramBundle;
    com.tencent.mm.sdk.b.a.ESL.l(localuj);
    AppMethodBeat.o(2620);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    uj localuj = new uj();
    a(localuj, paramb);
    b(localuj, paramb);
    uj.a locala = localuj.dzH;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localuj.dzH;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.dbt = (paramString1 + ":" + paramb.gJJ);
      localuj.dzH.deG = paramBundle;
      com.tencent.mm.sdk.b.a.ESL.l(localuj);
      AppMethodBeat.o(2619);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(uj paramuj, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
      if ((paramb != null) && (!bt.isNullOrNil(paramb.gFA))) {
        paramuj.dzH.dzY = paramb.gFA;
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.gJK))
    {
      ad.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    uj localuj = new uj();
    a(localuj, paramb);
    b(localuj, paramb);
    localuj.dzH.scene = 1044;
    localuj.dzH.dbt = paramb.gJJ;
    uj.a locala = localuj.dzH;
    if (paramBoolean) {}
    for (;;)
    {
      locala.dzS = i;
      locala = localuj.dzH;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.dzT = paramString2;
      localuj.dzH.dzP.cfh = paramb.gJK;
      localuj.dzH.dzP.cff = paramString1;
      localuj.dzH.deG = paramBundle;
      com.tencent.mm.sdk.b.a.ESL.l(localuj);
      AppMethodBeat.o(2621);
      return;
      i = 1;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.gJG == 2) || (paramb.gJG == 3))) || (paramb.type == 36);
  }
  
  public static boolean c(k.b paramb)
  {
    return paramb.type == 44;
  }
  
  public static boolean uT(String paramString)
  {
    AppMethodBeat.i(2618);
    if (bt.isNullOrNil(paramString))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a
 * JD-Core Version:    0.7.0.1
 */