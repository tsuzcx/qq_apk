package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest;", "", "()V", "TAG", "", "TRANSFER_REQUEST_H5_VERSION", "", "TRANSFER_REQUEST_JSAPI_CONTROL_BYTES_INDEX", "h5AuthToken", "h5AuthTokenExpireTime", "doTransferRequest", "", "transferRequestInfo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestInfo;", "callback", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestCallback;", "generateClientCheckData", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getH5AuthToken", "requestInfo", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalH5AuthToken", "h5ExtTransfer", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetH5AuthToken", "saveH5AuthToken", "h5AuthResponse", "Lcom/tencent/mm/protocal/protobuf/H5AuthResponse;", "transferRequest", "data", "Lorg/json/JSONObject;", "ErrCode", "TransferRequestCallback", "TransferRequestInfo", "plugin-brandservice_release"})
public final class r
{
  private static String sNA;
  private static int sNB;
  public static final r sNC;
  
  static
  {
    AppMethodBeat.i(265323);
    sNC = new r();
    sNA = "";
    sNB = -1;
    AppMethodBeat.o(265323);
  }
  
  private static void a(b paramb, final r.a parama)
  {
    AppMethodBeat.i(265318);
    try
    {
      g.b((ak)br.abxo, null, (m)new c(paramb, parama, null), 3);
      AppMethodBeat.o(265318);
      return;
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.TransferRequest", (Throwable)paramb, "transferRequest exception", new Object[0]);
      if (parama != null)
      {
        parama.a("unknown error", null);
        AppMethodBeat.o(265318);
        return;
      }
      AppMethodBeat.o(265318);
    }
  }
  
  public static final void a(JSONObject paramJSONObject, r.a parama)
  {
    AppMethodBeat.i(265317);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(265317);
      return;
    }
    Object localObject1 = b.sNE;
    p.k(paramJSONObject, "data");
    localObject1 = new b();
    Object localObject2 = paramJSONObject.optString("h5Url");
    p.j(localObject2, "data.optString(\"h5Url\")");
    p.k(localObject2, "<set-?>");
    ((b)localObject1).url = ((String)localObject2);
    localObject2 = paramJSONObject.optString("scope");
    p.j(localObject2, "data.optString(\"scope\")");
    p.k(localObject2, "<set-?>");
    ((b)localObject1).scope = ((String)localObject2);
    localObject2 = new cob();
    ((cob)localObject2).url = paramJSONObject.optString("reqUrl");
    ((cob)localObject2).Twl = paramJSONObject.optInt("cgiCmdId");
    ((cob)localObject2).RUB = paramJSONObject.getJSONObject("reqBody").toString();
    ((b)localObject1).sND = ((cob)localObject2);
    a((b)localObject1, parama);
    AppMethodBeat.o(265317);
  }
  
  private static eae cCu()
  {
    AppMethodBeat.i(265322);
    Object localObject = new fgr();
    ((fgr)localObject).UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
    localObject = new eae().dc(((fgr)localObject).toByteArray());
    p.j(localObject, "SKBuiltinBuffer_t().setB…xtSpamInfo.toByteArray())");
    AppMethodBeat.o(265322);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestInfo;", "", "()V", "h5AuthToken", "", "getH5AuthToken", "()Ljava/lang/String;", "setH5AuthToken", "(Ljava/lang/String;)V", "isRetry", "", "()Z", "setRetry", "(Z)V", "jsApiRequest", "Lcom/tencent/mm/protocal/protobuf/JsApiRequest;", "getJsApiRequest", "()Lcom/tencent/mm/protocal/protobuf/JsApiRequest;", "setJsApiRequest", "(Lcom/tencent/mm/protocal/protobuf/JsApiRequest;)V", "scope", "getScope", "setScope", "url", "getUrl", "setUrl", "Companion", "plugin-brandservice_release"})
  static final class b
  {
    public static final a sNE;
    boolean isRetry;
    String sNA = "";
    cob sND;
    String scope = "";
    String url = "";
    
    static
    {
      AppMethodBeat.i(258688);
      sNE = new a((byte)0);
      AppMethodBeat.o(258688);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestInfo$Companion;", "", "()V", "parseFromJSON", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestInfo;", "data", "Lorg/json/JSONObject;", "plugin-brandservice_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    c(r.b paramb, r.a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(266062);
      p.k(paramd, "completion");
      paramd = new c(this.sNF, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(266062);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(266063);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(266063);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject3 = null;
      AppMethodBeat.i(266061);
      a locala = a.aaAA;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(266061);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = this.sNF;
        localObject2 = r.sNC;
        localObject2 = this.sNF;
        this.L$0 = paramObject;
        this.oDA = localObject1;
        this.label = 1;
        localObject2 = r.a((r.b)localObject2, this);
        if (localObject2 == locala)
        {
          AppMethodBeat.o(266061);
          return locala;
        }
        break;
      case 1: 
        localObject1 = (r.b)this.oDA;
        ak localak = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject2 = paramObject;
        paramObject = localak;
      }
      for (;;)
      {
        localObject2 = (String)localObject2;
        p.k(localObject2, "<set-?>");
        ((r.b)localObject1).sNA = ((String)localObject2);
        Log.i("MicroMsg.TransferRequest", "transferRequest scope: " + this.sNF.scope + ", token: " + this.sNF.sNA + ", isRetry: " + this.sNF.isRetry + ", url: " + this.sNF.url);
        int i;
        if (((CharSequence)this.sNF.sNA).length() > 0) {
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            localObject1 = r.sNC;
            localObject1 = this.sNF;
            localObject2 = parama;
            this.L$0 = paramObject;
            this.label = 2;
            localObject1 = r.a((r.b)localObject1, (r.a)localObject2, this);
            paramObject = localObject1;
            if (localObject1 == locala)
            {
              AppMethodBeat.o(266061);
              return locala;
              i = 0;
              continue;
              ResultKt.throwOnFailure(paramObject);
            }
            else
            {
              localObject1 = (coc)paramObject;
              localObject2 = new StringBuilder("[game-web-prefetch] transferRequest ret: ");
              if (localObject1 != null)
              {
                paramObject = Integer.valueOf(((coc)localObject1).ret);
                localObject2 = ((StringBuilder)localObject2).append(paramObject).append(", resp_json: ");
                if (localObject1 == null) {
                  break label448;
                }
                paramObject = ((coc)localObject1).RUC;
                label375:
                localObject2 = ((StringBuilder)localObject2).append(paramObject).append(", errMsg: ");
                paramObject = localObject3;
                if (localObject1 != null) {
                  paramObject = ((coc)localObject1).error_msg;
                }
                Log.i("MicroMsg.TransferRequest", paramObject);
                paramObject = parama;
                if (paramObject != null) {
                  paramObject.a("", (coc)localObject1);
                }
              }
            }
          }
        }
        for (;;)
        {
          paramObject = x.aazN;
          AppMethodBeat.o(266061);
          return paramObject;
          paramObject = null;
          break;
          label448:
          paramObject = null;
          break label375;
          paramObject = parama;
          if (paramObject != null) {
            paramObject.a("token invalid", null);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class d
    implements IPCRunCgi.a
  {
    d(kotlin.d.d paramd) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(260403);
      Log.i("MicroMsg.TransferRequest", "[game-web-prefetch] h5Auth errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.j(paramd, "rr");
        paramd = paramd.bhY();
        paramString = paramd;
        if (!(paramd instanceof cic)) {
          paramString = null;
        }
        paramString = (cic)paramString;
        if (paramString != null)
        {
          paramd = r.sNC;
          r.a(paramString);
          kotlin.d.d locald = this.lrJ;
          paramd = paramString.Tpe;
          paramString = paramd;
          if (paramd == null) {
            paramString = "";
          }
          paramd = Result.Companion;
          locald.resumeWith(Result.constructor-impl(paramString));
          AppMethodBeat.o(260403);
          return;
        }
      }
      paramString = this.lrJ;
      paramd = Result.Companion;
      paramString.resumeWith(Result.constructor-impl(""));
      AppMethodBeat.o(260403);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$h5ExtTransfer$2$2"})
  static final class e
    implements IPCRunCgi.a
  {
    e(kotlin.d.d paramd, r.b paramb, r.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd)
    {
      Result.Companion localCompanion = null;
      AppMethodBeat.i(266550);
      Log.i("MicroMsg.TransferRequest", "[game-web-prefetch] h5ExTransfer errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        p.j(paramd, "rr");
        paramString = paramd.bhY();
        if ((paramString instanceof cie)) {
          break label255;
        }
        paramString = localCompanion;
      }
      label255:
      for (;;)
      {
        paramd = (cie)paramString;
        if (paramd != null)
        {
          paramString = this.lrJ;
          paramd = paramd.Tph;
          localCompanion = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramd));
          AppMethodBeat.o(266550);
          return;
        }
        AppMethodBeat.o(266550);
        return;
        if ((paramInt2 == -262) || (paramInt2 == -263))
        {
          paramString = r.sNC;
          r.cCv();
          if (this.sNH.isRetry)
          {
            Log.w("MicroMsg.TransferRequest", "[game-web-prefetch] h5ExtTransfer retry and failed");
            paramString = this.lrJ;
            paramd = Result.Companion;
            paramString.resumeWith(Result.constructor-impl(null));
            AppMethodBeat.o(266550);
            return;
          }
          Log.i("MicroMsg.TransferRequest", "[game-web-prefetch] h5ExtTransfer h5Session timeout and retry");
          this.sNH.isRetry = true;
          paramString = r.sNC;
          r.b(this.sNH, this.sNI);
          AppMethodBeat.o(266550);
          return;
        }
        paramString = this.lrJ;
        paramd = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(null));
        AppMethodBeat.o(266550);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.r
 * JD-Core Version:    0.7.0.1
 */