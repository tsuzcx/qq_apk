package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.feu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends a<Boolean, feu>
{
  public static final a kPP;
  
  static
  {
    AppMethodBeat.i(50201);
    kPP = new a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, final String paramString2, feu paramfeu)
  {
    AppMethodBeat.i(50197);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    p.h(paramfeu, "wxaSyncPreLaunchCmd");
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      p.g(paramString1, "java.lang.Boolean.FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        final int j = paramfeu.NzO.NzL;
        paramfeu = d.mYC;
        paramfeu = new chd();
        Object localObject = new fcc();
        ((fcc)localObject).MjZ = 0;
        ((fcc)localObject).KSa = 0;
        ((fcc)localObject).Scene = 0;
        ((fcc)localObject).MqD = 1;
        ((fcc)localObject).MqE = "";
        ((fcc)localObject).MqC = 0;
        paramfeu.Mmn = ((fcc)localObject);
        paramfeu.Mbn = 3;
        paramfeu.jfi = paramString2;
        paramfeu.Mmv = paramString1;
        paramfeu.Mem = true;
        localObject = new fdb();
        ICommLibReader localICommLibReader = at.bvT();
        if (localICommLibReader != null)
        {
          i = localICommLibReader.bvd();
          ((fdb)localObject).MqF = i;
          paramfeu.Mmp = ((fdb)localObject);
          new d(paramfeu, false).aYI().j((com.tencent.mm.vending.c.a)new b(paramString1, paramString2, j));
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
  
  public static void cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String bwQ()
  {
    return "CmdPreLaunch";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(String paramString1, String paramString2, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.h
 * JD-Core Version:    0.7.0.1
 */