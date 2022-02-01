package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.plugin.appbrand.launching.d.d.a;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.dwn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends a<Boolean, dwn>
{
  public static final a iQl;
  
  static
  {
    AppMethodBeat.i(50201);
    iQl = new a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, final String paramString2, dwn paramdwn)
  {
    AppMethodBeat.i(50197);
    k.h(paramString1, "username");
    k.h(paramString2, "appId");
    k.h(paramdwn, "wxaSyncPreLaunchCmd");
    if ((bt.isNullOrNil(paramString1)) && (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      k.g(paramString1, "java.lang.Boolean.FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        final int j = paramdwn.EKf.EKc;
        paramdwn = ar.aPR();
        if (paramdwn != null)
        {
          i = paramdwn.aPc();
          paramdwn = new dty();
          paramdwn.DGx = 0;
          paramdwn.CHC = 0;
          paramdwn.Scene = 0;
          paramdwn.DKX = 1;
          paramdwn.DKY = "";
          paramdwn.DKW = 0;
          d.a locala = d.kOb;
          d.a.a(paramString1, paramString2, paramdwn, null, null, i, null, false).auK().j((com.tencent.mm.vending.c.a)new b(paramString1, paramString2, j));
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
  
  public static void bX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    k.h(paramString1, "username");
    k.h(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String aQI()
  {
    return "CmdPreLaunch";
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString1, String paramString2, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.h
 * JD-Core Version:    0.7.0.1
 */