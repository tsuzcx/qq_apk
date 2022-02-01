package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.egs;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends a<Boolean, eik>
{
  public static final a jKp;
  
  static
  {
    AppMethodBeat.i(50201);
    jKp = new a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, final String paramString2, eik parameik)
  {
    AppMethodBeat.i(50197);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    p.h(parameik, "wxaSyncPreLaunchCmd");
    if ((bt.isNullOrNil(paramString1)) && (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      p.g(paramString1, "java.lang.Boolean.FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        final int j = parameik.HSF.HSC;
        parameik = d.lMT;
        parameik = new btf();
        Object localObject = new eft();
        ((eft)localObject).GLq = 0;
        ((eft)localObject).FFN = 0;
        ((eft)localObject).Scene = 0;
        ((eft)localObject).GQO = 1;
        ((eft)localObject).GQP = "";
        ((eft)localObject).GQN = 0;
        parameik.GNz = ((eft)localObject);
        parameik.GDf = 3;
        parameik.iht = paramString2;
        parameik.GNH = paramString1;
        parameik.GFK = true;
        localObject = new egs();
        ICommLibReader localICommLibReader = as.bag();
        if (localICommLibReader != null)
        {
          i = localICommLibReader.aZp();
          ((egs)localObject).GQQ = i;
          parameik.GNB = ((egs)localObject);
          new d(parameik, false).aED().j((com.tencent.mm.vending.c.a)new b(paramString1, paramString2, j));
          paramString1 = Boolean.TRUE;
          AppMethodBeat.o(50197);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdPreLaunch", (Throwable)paramString1, "", new Object[0]);
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(50197);
        return paramString1;
      }
      int i = -1;
    }
  }
  
  public static void ci(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String bbb()
  {
    return "CmdPreLaunch";
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString1, String paramString2, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.h
 * JD-Core Version:    0.7.0.1
 */