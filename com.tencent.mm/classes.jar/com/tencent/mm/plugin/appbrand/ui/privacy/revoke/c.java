package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.protocal.protobuf.fvg;
import com.tencent.mm.protocal.protobuf.gko;
import com.tencent.mm.protocal.protobuf.gkp;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.h;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/CgiRevokeUserInfoAuthorize;", "", "()V", "DUMMY_PLUGIN_ID", "", "EXPECT_USE_STATE", "", "getEXPECT_USE_STATE$annotations", "FUNC_ID", "TAG", "", "URI", "doRevoke", "", "toRevokeItem", "Lcom/tencent/mm/protocal/protobuf/ModUseUserInfoItem;", "(Lcom/tencent/mm/protocal/protobuf/ModUseUserInfoItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appId", "scope", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pluginAppId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toRevokeItemList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c ujO;
  static final Void ujP;
  
  static
  {
    AppMethodBeat.i(322850);
    ujO = new c();
    AppMethodBeat.o(322850);
  }
  
  public static Object a(dqg paramdqg, d<? super ah> paramd)
  {
    AppMethodBeat.i(322841);
    Object localObject2 = kotlin.a.p.listOf(paramdqg);
    paramdqg = new h(kotlin.d.a.b.au(paramd));
    Object localObject1 = (d)paramdqg;
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp_moduseuserinfo";
    locala.funcId = 4891;
    gko localgko = new gko();
    localgko.acgs.addAll((Collection)localObject2);
    localObject2 = ah.aiuX;
    localObject2 = com.tencent.mm.plugin.appbrand.ui.privacy.b.uiA;
    if (com.tencent.mm.plugin.appbrand.ui.privacy.b.getDEBUG()) {
      Log.i("MicroMsg.AppBrand.CgiRevokeUserInfoAuthorize", s.X("doRevoke, req: ", localgko.toJSON()));
    }
    localObject2 = ah.aiuX;
    locala.otE = ((com.tencent.mm.bx.a)localgko);
    locala.otF = ((com.tencent.mm.bx.a)new gkp());
    z.a(locala.bEF(), (z.a)new a((d)localObject1));
    localObject1 = paramdqg.kli();
    if (localObject1 == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    paramdqg = (dqg)localObject1;
    if (localObject1 != kotlin.d.a.a.aiwj) {
      paramdqg = ah.aiuX;
    }
    if (paramdqg == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(322841);
      return paramdqg;
    }
    paramdqg = ah.aiuX;
    AppMethodBeat.o(322841);
    return paramdqg;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    implements z.a
  {
    a(d<? super ah> paramd) {}
    
    public final int callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(322855);
      Log.i("MicroMsg.AppBrand.CgiRevokeUserInfoAuthorize", "callback, errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramc = this.msc;
        paramString = (Throwable)new IOException("Server Framework Error(errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString + ')');
        paramp = Result.Companion;
        paramc.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramString)));
        AppMethodBeat.o(322855);
        return 0;
      }
      paramString = c.c.b(paramc.otC);
      if ((paramString instanceof gkp)) {}
      for (paramString = (gkp)paramString; paramString == null; paramString = null)
      {
        paramString = c.ujO;
        paramString = this.msc;
        paramc = (Throwable)new IOException("Client Framework Error(resp is null)");
        paramp = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramc)));
        AppMethodBeat.o(322855);
        return 0;
      }
      paramInt1 = paramString.aaAa.errCode;
      paramc = paramString.aaAa.errMsg;
      Log.i("MicroMsg.AppBrand.CgiRevokeUserInfoAuthorize", "callback, logicErrCode: " + paramInt1 + ", logicErrMsg: " + paramc);
      if (paramInt1 != 0)
      {
        paramString = this.msc;
        paramc = (Throwable)new IOException("Server Logic Error(logicErrCode: " + paramInt1 + ", logicErrMsg: " + paramc + ')');
        paramp = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramc)));
        AppMethodBeat.o(322855);
        return 0;
      }
      paramString = this.msc;
      paramc = ah.aiuX;
      paramp = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(paramc));
      AppMethodBeat.o(322855);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.c
 * JD-Core Version:    0.7.0.1
 */