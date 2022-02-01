package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.plugin.appbrand.api.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static boolean BY(String paramString)
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
  
  private static void a(vm paramvm, k.b paramb)
  {
    paramvm.dJF.appId = paramb.hCo;
    paramvm.dJF.userName = paramb.hCn;
    paramvm.dJF.dJH = paramb.hCm;
    paramvm.dJF.dJI = paramb.hCz;
    paramvm.dJF.dJK = paramb.hCq;
    paramvm.dJF.aDD = paramb.hCA;
    paramvm = paramvm.dJF;
    if (paramb.hCz != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramvm.dJL = bool;
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2620);
    vm localvm = new vm();
    a(localvm, paramb);
    b(localvm, paramb);
    localvm.dJF.scene = paramInt;
    if ((paramInt == 1074) || (paramInt == 1157)) {
      localvm.dJF.dkh = paramString;
    }
    localvm.dJF.dnx = paramBundle;
    com.tencent.mm.sdk.b.a.IbL.l(localvm);
    AppMethodBeat.o(2620);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    vm localvm = new vm();
    a(localvm, paramb);
    b(localvm, paramb);
    vm.a locala = localvm.dJF;
    int i;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      i = 1008;
      locala.scene = i;
      locala = localvm.dJF;
      localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label144;
      }
    }
    label144:
    for (paramString1 = ":".concat(String.valueOf(paramString2));; paramString1 = "")
    {
      locala.dkh = (paramString1 + ":" + paramb.hCs);
      localvm.dJF.dnx = paramBundle;
      com.tencent.mm.sdk.b.a.IbL.l(localvm);
      AppMethodBeat.o(2619);
      return;
      i = 1007;
      break;
    }
  }
  
  private static void b(vm paramvm, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (com.tencent.mm.ai.a)paramb.ao(com.tencent.mm.ai.a.class);
      if ((paramb != null) && (!bt.isNullOrNil(paramb.hyj))) {
        paramvm.dJF.dJW = paramb.hyj;
      }
      if (paramb != null)
      {
        h localh = new h();
        localh.hyl = paramb.hyl;
        paramvm.dJF.dJX = localh.aYt();
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int i = 2;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.hCt))
    {
      ad.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    vm localvm = new vm();
    a(localvm, paramb);
    b(localvm, paramb);
    localvm.dJF.scene = 1044;
    localvm.dJF.dkh = paramb.hCs;
    vm.a locala = localvm.dJF;
    if (paramBoolean) {}
    for (;;)
    {
      locala.dJQ = i;
      locala = localvm.dJF;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      locala.dJR = paramString2;
      localvm.dJF.dJN.cmu = paramb.hCt;
      localvm.dJF.dJN.cmt = paramString1;
      localvm.dJF.dnx = paramBundle;
      com.tencent.mm.sdk.b.a.IbL.l(localvm);
      AppMethodBeat.o(2621);
      return;
      i = 1;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.hCp == 2) || (paramb.hCp == 3))) || (paramb.type == 36);
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