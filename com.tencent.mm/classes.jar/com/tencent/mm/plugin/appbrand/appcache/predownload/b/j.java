package com.tencent.mm.plugin.appbrand.appcache.predownload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.launching.aj;
import com.tencent.mm.plugin.appbrand.launching.d.d;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.gjw;
import com.tencent.mm.protocal.protobuf.glb;
import com.tencent.mm.protocal.protobuf.gmn;
import com.tencent.mm.protocal.protobuf.gmx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/CmdPreLaunch;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/cmd/AbstractCmd;", "", "Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;", "()V", "call", "username", "", "appId", "wxaSyncPreLaunchCmd", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/WxaSyncPreLaunchCmd;)Ljava/lang/Boolean;", "callInner", "reportID", "", "getCmdBase", "Lcom/tencent/mm/protocal/protobuf/WxaSyncBaseCmd;", "getCmdName", "testBackdoor", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends a<Boolean, gmx>
{
  public static final j.a qJE;
  
  static
  {
    AppMethodBeat.i(50201);
    qJE = new j.a((byte)0);
    AppMethodBeat.o(50201);
  }
  
  private static Boolean a(String paramString1, String paramString2, gmx paramgmx)
  {
    AppMethodBeat.i(50197);
    s.u(paramString1, "username");
    s.u(paramString2, "appId");
    s.u(paramgmx, "wxaSyncPreLaunchCmd");
    if ((Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2)))
    {
      Log.e("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "invalid username & appId");
      paramString1 = Boolean.FALSE;
      s.s(paramString1, "FALSE");
      AppMethodBeat.o(50197);
      return paramString1;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        int j = paramgmx.achK.achH;
        paramgmx = d.tdN;
        paramgmx = new dgt();
        Object localObject1 = new gjw();
        ((gjw)localObject1).aaJu = 0;
        ((gjw)localObject1).YQB = 0;
        ((gjw)localObject1).IJG = 0;
        ((gjw)localObject1).aaQV = 1;
        ((gjw)localObject1).aaQW = "";
        ((gjw)localObject1).aaQU = 0;
        localObject2 = ah.aiuX;
        paramgmx.aaLM = ((gjw)localObject1);
        paramgmx.aayr = 3;
        paramgmx.oOI = paramString2;
        paramgmx.aaLU = paramString1;
        paramgmx.aaBV = true;
        localObject1 = new glb();
        localObject2 = av.cgx();
        if (localObject2 == null)
        {
          i = -1;
          ((glb)localObject1).aaQX = i;
          localObject2 = ah.aiuX;
          paramgmx.aaLO = ((glb)localObject1);
          localObject1 = new aeo();
          ((aeo)localObject1).ZmB = 1;
          localObject2 = ah.aiuX;
          paramgmx.YMR = ((aeo)localObject1);
          new d(paramgmx, false).bFJ().j(new j..ExternalSyntheticLambda0(paramString1, paramString2, j));
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
      int i = ((ICommLibReader)localObject2).cfG();
    }
  }
  
  private static final ah a(String paramString1, String paramString2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(320521);
    s.u(paramString1, "$username");
    s.u(paramString2, "$appId");
    Log.i("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "getContact(%s %s) back, errType %d, errCode %d, errMsg %s", new Object[] { paramString1, paramString2, Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    if (parama == null) {}
    boolean bool;
    for (paramString1 = null; (paramString1 == null) || (parama.errCode != 0) || (parama.errType != 0); paramString1 = (dgu)parama.ott)
    {
      bool = false;
      if (!bool) {
        break label304;
      }
      paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, 169L);
      label107:
      Log.i("MicroMsg.AppBrand.Predownload.CmdPreLaunch", "callInner: preLaunch res = [%b]", new Object[] { Boolean.valueOf(bool) });
      paramString1 = ah.aiuX;
      AppMethodBeat.o(320521);
      return paramString1;
    }
    paramString1 = (dgu)parama.ott;
    if (paramString1 == null)
    {
      paramString1 = "";
      label164:
      if (!Util.isNullOrNil(paramString1)) {
        break label325;
      }
    }
    for (;;)
    {
      paramString1 = n.cfd();
      String str = "appId = [" + paramString2 + "], storage = null? [%b]";
      if (paramString1 == null) {}
      for (bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrand.Predownload.CmdPreLaunch", str, new Object[] { Boolean.valueOf(bool) });
        if (paramString1 == null) {
          break label319;
        }
        paramString1.iP(paramString2);
        if (paramString1.a(paramString2, (dgu)parama.ott) == null) {
          break label298;
        }
        bool = true;
        break;
        paramString1 = paramString1.appid;
        if (paramString1 == null)
        {
          paramString1 = "";
          break label164;
        }
        str = paramString1.toString();
        paramString1 = str;
        if (str != null) {
          break label164;
        }
        paramString1 = "";
        break label164;
      }
      label298:
      bool = false;
      break;
      label304:
      paramString1 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.qJY;
      com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.ac(paramInt, 170L);
      break label107;
      label319:
      bool = false;
      break;
      label325:
      paramString2 = paramString1;
    }
  }
  
  public static void cT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50199);
    s.u(paramString1, "username");
    s.u(paramString2, "appId");
    AppMethodBeat.o(50199);
  }
  
  public final String cht()
  {
    return "CmdPreLaunch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.b.j
 * JD-Core Version:    0.7.0.1
 */