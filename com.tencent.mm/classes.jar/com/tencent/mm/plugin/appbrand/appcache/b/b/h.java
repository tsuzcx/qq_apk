package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.ehk;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.ejt;
import com.tencent.mm.protocal.protobuf.ekb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"})
public final class h
  extends a<Boolean, ekb>
{
  public static final a jNB;
  
  static
  {
    AppMethodBeat.i(50201);
    jNB = new a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, final String paramString2, ekb paramekb)
  {
    AppMethodBeat.i(50197);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    p.h(paramekb, "wxaSyncPreLaunchCmd");
    if ((bu.isNullOrNil(paramString1)) && (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      p.g(paramString1, "java.lang.Boolean.FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        final int j = paramekb.ImM.ImJ;
        paramekb = d.lRt;
        paramekb = new btz();
        Object localObject = new ehk();
        ((ehk)localObject).HeR = 0;
        ((ehk)localObject).FYj = 0;
        ((ehk)localObject).Scene = 0;
        ((ehk)localObject).Hkp = 1;
        ((ehk)localObject).Hkq = "";
        ((ehk)localObject).Hko = 0;
        paramekb.HgZ = ((ehk)localObject);
        paramekb.GWF = 3;
        paramekb.ikm = paramString2;
        paramekb.Hhh = paramString1;
        paramekb.GZm = true;
        localObject = new eij();
        ICommLibReader localICommLibReader = at.baF();
        if (localICommLibReader != null)
        {
          i = localICommLibReader.aZM();
          ((eij)localObject).Hkr = i;
          paramekb.Hhb = ((eij)localObject);
          new d(paramekb, false).aET().j((com.tencent.mm.vending.c.a)new b(paramString1, paramString2, j));
          paramString1 = Boolean.TRUE;
          AppMethodBeat.o(50197);
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("MicroMsg.AppBrand.Predownload.CmdPreLaunch", (Throwable)paramString1, "", new Object[0]);
        paramString1 = Boolean.FALSE;
        AppMethodBeat.o(50197);
        return paramString1;
      }
      int i = -1;
    }
  }
  
  public static void cj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    p.h(paramString1, "username");
    p.h(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String bbD()
  {
    return "CmdPreLaunch";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;", "kotlin.jvm.PlatformType", "call"})
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