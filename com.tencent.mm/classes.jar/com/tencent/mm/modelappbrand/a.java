package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static void a(ut paramut, k.b paramb)
  {
    paramut.dxt.appId = paramb.hkf;
    paramut.dxt.userName = paramb.hke;
    paramut.dxt.dxv = paramb.hkd;
    paramut.dxt.dxw = paramb.hkq;
    paramut.dxt.dxy = paramb.hkh;
    paramut.dxt.aBM = paramb.hkr;
    paramut = paramut.dxt;
    if (paramb.hkq != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramut.dxz = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2620);
    ut localut = new ut();
    a(localut, paramb);
    b(localut, paramb);
    localut.dxt.scene = paramInt;
    if ((paramInt == 1074) || (paramInt == 1157)) {
      localut.dxt.cYP = paramString;
    }
    localut.dxt.dcb = paramBundle;
    com.tencent.mm.sdk.b.a.GpY.l(localut);
    AppMethodBeat.o(2620);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    ut localut = new ut();
    a(localut, paramb);
    b(localut, paramb);
    ut.a locala = localut.dxt;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localut.dxt;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.cYP = (paramString1 + ":" + paramb.hkj);
      localut.dxt.dcb = paramBundle;
      com.tencent.mm.sdk.b.a.GpY.l(localut);
      AppMethodBeat.o(2619);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(ut paramut, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.ah.a)paramb.ao(com.tencent.mm.ah.a.class);
      if ((paramb != null) && (!bs.isNullOrNil(paramb.hgb))) {
        paramut.dxt.dxK = paramb.hgb;
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.hkk))
    {
      ac.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    ut localut = new ut();
    a(localut, paramb);
    b(localut, paramb);
    localut.dxt.scene = 1044;
    localut.dxt.cYP = paramb.hkj;
    ut.a locala = localut.dxt;
    if (paramBoolean) {}
    for (;;)
    {
      locala.dxE = i;
      locala = localut.dxt;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.dxF = paramString2;
      localut.dxt.dxB.ccd = paramb.hkk;
      localut.dxt.dxB.ccc = paramString1;
      localut.dxt.dcb = paramBundle;
      com.tencent.mm.sdk.b.a.GpY.l(localut);
      AppMethodBeat.o(2621);
      return;
      i = 1;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.hkg == 2) || (paramb.hkg == 3))) || (paramb.type == 36);
  }
  
  public static boolean c(k.b paramb)
  {
    return paramb.type == 44;
  }
  
  public static boolean yZ(String paramString)
  {
    AppMethodBeat.i(2618);
    if (bs.isNullOrNil(paramString))
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