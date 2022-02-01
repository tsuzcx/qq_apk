package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.protocal.protobuf.fvg;
import com.tencent.mm.protocal.protobuf.gjy;
import com.tencent.mm.protocal.protobuf.gjz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/CgiGetAuthorizeInfo;", "", "()V", "FUNC_ID", "", "TAG", "", "URI", "doGet", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetAuthInfoResp;", "appId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ujN;
  
  static
  {
    AppMethodBeat.i(322852);
    ujN = new b();
    AppMethodBeat.o(322852);
  }
  
  public static Object h(String paramString, d<? super gjz> paramd)
  {
    AppMethodBeat.i(322846);
    h localh = new h(kotlin.d.a.b.au(paramd));
    d locald = (d)localh;
    c.a locala = new c.a();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
    locala.funcId = 1115;
    gjy localgjy = new gjy();
    localgjy.appId = paramString;
    paramString = ah.aiuX;
    locala.otE = ((com.tencent.mm.bx.a)localgjy);
    locala.otF = ((com.tencent.mm.bx.a)new gjz());
    z.a(locala.bEF(), (z.a)new a(locald));
    paramString = localh.kli();
    if (paramString == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(322846);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    implements z.a
  {
    a(d<? super gjz> paramd) {}
    
    public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
    {
      AppMethodBeat.i(322803);
      Log.i("MicroMsg.AppBrand.CgiGetAuthorizeInfo", "callback, errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramc = this.msc;
        paramString = (Throwable)new IOException("Server Framework Error(errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString + ')');
        paramp = Result.Companion;
        paramc.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString)));
        AppMethodBeat.o(322803);
        return 0;
      }
      paramString = c.c.b(paramc.otC);
      if ((paramString instanceof gjz)) {}
      for (paramString = (gjz)paramString; paramString == null; paramString = null)
      {
        paramString = b.ujN;
        paramString = this.msc;
        paramc = (Throwable)new IOException("Client Framework Error(resp is null)");
        paramp = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramc)));
        AppMethodBeat.o(322803);
        return 0;
      }
      paramInt1 = paramString.acfT.errCode;
      paramc = paramString.acfT.errMsg;
      Log.i("MicroMsg.AppBrand.CgiGetAuthorizeInfo", "callback, logicErrCode: " + paramInt1 + ", logicErrMsg: " + paramc);
      if (paramInt1 != 0)
      {
        paramString = this.msc;
        paramc = (Throwable)new IOException("Server Logic Error(logicErrCode: " + paramInt1 + ", logicErrMsg: " + paramc + ')');
        paramp = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramc)));
        AppMethodBeat.o(322803);
        return 0;
      }
      paramc = this.msc;
      paramp = Result.Companion;
      paramc.resumeWith(Result.constructor-impl(paramString));
      AppMethodBeat.o(322803);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.b
 * JD-Core Version:    0.7.0.1
 */