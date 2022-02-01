package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.fnd;
import com.tencent.mm.protocal.protobuf.foc;
import com.tencent.mm.protocal.protobuf.fpn;
import com.tencent.mm.protocal.protobuf.fpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends a<Boolean, fpv>
{
  public static final a nJV;
  
  static
  {
    AppMethodBeat.i(50201);
    nJV = new a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, final String paramString2, fpv paramfpv)
  {
    AppMethodBeat.i(50197);
    p.k(paramString1, "username");
    p.k(paramString2, "appId");
    p.k(paramfpv, "wxaSyncPreLaunchCmd");
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      p.j(paramString1, "java.lang.Boolean.FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        final int j = paramfpv.UNq.UNn;
        paramfpv = d.pZb;
        paramfpv = new cpz();
        Object localObject = new fnd();
        ((fnd)localObject).TuP = 0;
        ((fnd)localObject).RTb = 0;
        ((fnd)localObject).CPw = 0;
        ((fnd)localObject).TBG = 1;
        ((fnd)localObject).TBH = "";
        ((fnd)localObject).TBF = 0;
        paramfpv.Txh = ((fnd)localObject);
        paramfpv.TkK = 3;
        paramfpv.lVG = paramString2;
        paramfpv.Txp = paramString1;
        paramfpv.TnO = true;
        localObject = new foc();
        ICommLibReader localICommLibReader = au.bHb();
        if (localICommLibReader != null)
        {
          i = localICommLibReader.bGi();
          ((foc)localObject).TBI = i;
          paramfpv.Txj = ((foc)localObject);
          new d(paramfpv, false).bhW().j((com.tencent.mm.vending.c.a)new b(paramString1, paramString2, j));
          paramString1 = Boolean.TRUE;
          AppMethodBeat.o(50197);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdPreLaunch", (Throwable)paramString1, "", new Object[0]);
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(50197);
        return paramString1;
      }
      int i = -1;
    }
  }
  
  public static void cC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    p.k(paramString1, "username");
    p.k(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String bHX()
  {
    return "CmdPreLaunch";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString1, String paramString2, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.h
 * JD-Core Version:    0.7.0.1
 */