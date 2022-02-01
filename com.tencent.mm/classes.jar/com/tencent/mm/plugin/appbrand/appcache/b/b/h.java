package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.plugin.appbrand.launching.d.d.a;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends a<Boolean, ece>
{
  public static final a jqv;
  
  static
  {
    AppMethodBeat.i(50201);
    jqv = new a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, final String paramString2, ece paramece)
  {
    AppMethodBeat.i(50197);
    k.h(paramString1, "username");
    k.h(paramString2, "appId");
    k.h(paramece, "wxaSyncPreLaunchCmd");
    if ((bs.isNullOrNil(paramString1)) && (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      k.g(paramString1, "java.lang.Boolean.FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        final int j = paramece.Ghr.Gho;
        paramece = ar.aWJ();
        if (paramece != null)
        {
          i = paramece.aVU();
          paramece = new dzp();
          paramece.FbR = 0;
          paramece.Eae = 0;
          paramece.Scene = 0;
          paramece.Fhm = 1;
          paramece.Fhn = "";
          paramece.Fhl = 0;
          d.a locala = d.lpA;
          d.a.a(paramString1, paramString2, paramece, null, null, i, null, false).aBB().j((com.tencent.mm.vending.c.a)new b(paramString1, paramString2, j));
          paramString1 = Boolean.TRUE;
          AppMethodBeat.o(50197);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdPreLaunch", (Throwable)paramString1, "", new Object[0]);
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(50197);
        return paramString1;
      }
      int i = -1;
    }
  }
  
  public static void cg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    k.h(paramString1, "username");
    k.h(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String aXD()
  {
    return "CmdPreLaunch";
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
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