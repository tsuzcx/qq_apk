package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class OpenBusinessViewUtil
{
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, OpenBusinessViewUtil.a parama)
  {
    AppMethodBeat.i(131050);
    azk localazk = new azk();
    localazk.cpt = paramInt;
    localazk.xoI = paramString1;
    localazk.xoJ = paramString3;
    localazk.xoK = paramString4;
    localazk.query = paramString2;
    paramString1 = new b.a();
    paramString1.funcId = 1268;
    paramString1.uri = "/cgi-bin/mmbiz-bin/wxabusiness/launchbizwxaapp";
    paramString1.fsX = localazk;
    paramString1.fsY = new azl();
    b.a(paramString1.ado(), new OpenBusinessViewUtil.1(parama));
    AppMethodBeat.o(131050);
  }
  
  public static void k(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(131054);
    ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackMiniProgram, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    l(paramString1, paramInt, paramString2);
    AppMethodBeat.o(131054);
  }
  
  private static void l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(131055);
    kl localkl = new kl();
    localkl.cAi.errCode = paramInt;
    localkl.cAi.businessType = paramString1;
    localkl.cAi.cAh = paramString2;
    a.ymk.l(localkl);
    AppMethodBeat.o(131055);
  }
  
  public static void s(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(131053);
    ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackApplication, appId:%s, businessType:%s, errCode:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppBrandMainProcessService.a(new JsApiNavigateBackApplication.NavigateBackAppTask(paramString1, bo.bf(null, "{}"), paramString2, paramInt));
    AppMethodBeat.o(131053);
  }
  
  public static void t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(131056);
    ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackH5, businessType:%s, errCode:%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (ah.brt())
    {
      u(paramString1, paramString2, paramInt);
      AppMethodBeat.o(131056);
      return;
    }
    AppBrandMainProcessService.a(new OpenBusinessViewUtil.NavigateBackH5Task(paramString1, paramString2, paramInt));
    AppMethodBeat.o(131056);
  }
  
  public static void u(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(131057);
    kk localkk = new kk();
    localkk.cAg.businessType = paramString1;
    localkk.cAg.errCode = paramInt;
    localkk.cAg.cAh = paramString2;
    a.ymk.l(localkk);
    AppMethodBeat.o(131057);
  }
  
  public static void z(i parami)
  {
    AppMethodBeat.i(143405);
    if (parami == null)
    {
      AppMethodBeat.o(143405);
      return;
    }
    int i = n.yc(parami.mAppId).gRf;
    String str = n.yc(parami.mAppId).gRe;
    ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, businessType:%s, launchScene:%s", new Object[] { str, Integer.valueOf(i) });
    if (!bo.isNullOrNil(str))
    {
      if (i == 2)
      {
        if (!n.yc(parami.mAppId).gRg)
        {
          ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to H5, businessType:%s", new Object[] { str });
          t(str, null, -3);
        }
        AppMethodBeat.o(143405);
        return;
      }
      if (i == 4)
      {
        if (!n.yc(parami.mAppId).gRi)
        {
          ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to Application, businessType:%s", new Object[] { str });
          if ((parami.wZ().hiz != null) && (!bo.isNullOrNil(parami.wZ().hiz.appId))) {
            s(parami.wZ().hiz.appId, str, -2);
          }
        }
        AppMethodBeat.o(143405);
        return;
      }
      if ((i == 1) && (!n.yc(parami.mAppId).gRh))
      {
        ab.i("MicroMsg.OpenBusinessViewUtil", "navigateBackCancelResultIfNeed, return cancel to MiniProgram, businessType:%s", new Object[] { str });
        k(str, d.hLI.errCode, null);
      }
    }
    AppMethodBeat.o(143405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil
 * JD-Core Version:    0.7.0.1
 */