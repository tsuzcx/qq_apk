package com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.g;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/BaseTransferRequester;", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester;", "tokenManager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;)V", "getTokenManager", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "generateClientCheckData", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "getRequest", "Lcom/tencent/mm/modelbase/CommReqResp;", "transferRequestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "rr", "getToken", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$TokenInfo;", "(Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "", "callback", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "resetH5AuthToken", "tag", "", "transfer", "Lkotlin/Pair;", "(Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements g
{
  public static final a vWl = new a((byte)0);
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a vWm;
  
  public a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a parama)
  {
    this.vWm = parama;
  }
  
  protected static gol dgU()
  {
    Object localObject = new gdd();
    long l = System.currentTimeMillis();
    ((gdd)localObject).acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
    Log.v("MicroMsg.BaseTransferRequest", "generateClientCheckData cost %s ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    localObject = new gol().df(((gdd)localObject).toByteArray());
    s.s(localObject, "SKBuiltinBuffer_t().setB…xtSpamInfo.toByteArray())");
    return localObject;
  }
  
  protected abstract c b(TransferRequestInfo paramTransferRequestInfo);
  
  public final void b(TransferRequestInfo paramTransferRequestInfo, final g.a parama)
  {
    s.u(paramTransferRequestInfo, "transferRequestInfo");
    j.a((aq)bu.ajwo, null, null, (m)new c(paramTransferRequestInfo, this, parama, null), 3);
  }
  
  protected abstract String dgV();
  
  protected abstract dew g(c paramc);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/BaseTransferRequester$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/BaseTransferRequester$getToken$2$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$GetTokenCallback;", "onResult", "", "token", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager$TokenInfo;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.a
  {
    b(kotlin.d.d<? super com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.b> paramd) {}
    
    public final void a(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.b paramb)
    {
      AppMethodBeat.i(303068);
      kotlin.d.d locald = this.ojk;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(paramb));
      AppMethodBeat.o(303068);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    c(TransferRequestInfo paramTransferRequestInfo, a parama, g.a parama1, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(303083);
      paramObject = (kotlin.d.d)new c(this.vWn, jdField_this, parama, paramd);
      AppMethodBeat.o(303083);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(303077);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303077);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      case 1: 
        for (;;)
        {
          try
          {
            this.vWn.vBm = a.dgU();
            localObject1 = this.vWn;
            paramObject = jdField_this;
            localObject2 = this.vWn;
            locald = (kotlin.d.d)this;
            this.L$0 = localObject1;
            this.label = 1;
            paramObject = a.a(paramObject, (TransferRequestInfo)localObject2, locald);
            localObject2 = paramObject;
            if (paramObject == locala)
            {
              AppMethodBeat.o(303077);
              return locala;
              localObject1 = (TransferRequestInfo)this.L$0;
              ResultKt.throwOnFailure(paramObject);
              localObject2 = paramObject;
            }
            paramObject = (com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.b)localObject2;
            if (paramObject != null) {
              continue;
            }
            paramObject = "";
            ((TransferRequestInfo)localObject1).vBk = paramObject;
            localObject1 = new StringBuilder("[transferRequest-").append(jdField_this.dgV()).append("] scope: ").append(this.vWn.scope).append(", token: ").append(this.vWn.vBk).append(", isRetry: ").append(this.vWn.vBn).append(", url: ").append(this.vWn.url).append(", reqUrl: ");
            paramObject = this.vWn.vBl;
            if (paramObject != null) {
              continue;
            }
            paramObject = null;
            Log.i("MicroMsg.BaseTransferRequest", paramObject);
            paramObject = this.vWn.vBk;
            s.s(paramObject, "transferRequestInfo.h5AuthToken");
            if (((CharSequence)paramObject).length() <= 0) {
              continue;
            }
            i = 1;
          }
          catch (Exception paramObject)
          {
            Object localObject1;
            Object localObject2;
            kotlin.d.d locald;
            Log.printErrStackTrace("MicroMsg.BaseTransferRequest", (Throwable)paramObject, "[transferRequest-" + jdField_this.dgV() + "] exception", new Object[0]);
            paramObject = parama;
            if (paramObject == null) {
              continue;
            }
            paramObject.a("unknown error", null);
            continue;
            int i = 0;
            continue;
          }
          if (i == 0) {
            continue;
          }
          paramObject = jdField_this;
          localObject1 = this.vWn;
          localObject2 = parama;
          locald = (kotlin.d.d)this;
          this.L$0 = null;
          this.label = 2;
          paramObject = a.a(paramObject, (TransferRequestInfo)localObject1, (g.a)localObject2, locald);
          localObject1 = paramObject;
          if (paramObject != locala) {
            continue;
          }
          AppMethodBeat.o(303077);
          return locala;
          localObject2 = paramObject.vBk;
          paramObject = localObject2;
          if (localObject2 == null)
          {
            paramObject = "";
            continue;
            paramObject = paramObject.url;
          }
        }
      }
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      localObject1 = (r)localObject1;
      paramObject = (String)((r)localObject1).bsC;
      localObject1 = (dew)((r)localObject1).bsD;
      localObject2 = new StringBuilder("[transferRequest-").append(jdField_this.dgV()).append("] errMsg: ").append(paramObject).append(", result: ");
      if (localObject1 == null)
      {
        paramObject = null;
        localObject2 = ((StringBuilder)localObject2).append(paramObject).append(", resp_json: ");
        if (localObject1 != null) {
          break label552;
        }
        paramObject = null;
        label479:
        localObject2 = ((StringBuilder)localObject2).append(paramObject).append(", errMsg: ");
        if (localObject1 != null) {
          break label560;
        }
        paramObject = null;
        label498:
        Log.i("MicroMsg.BaseTransferRequest", paramObject);
        paramObject = parama;
        if (paramObject != null) {
          paramObject.a("", (dew)localObject1);
        }
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(303077);
        return paramObject;
        paramObject = Integer.valueOf(((dew)localObject1).ret);
        break;
        label552:
        paramObject = ((dew)localObject1).Kuf;
        break label479;
        label560:
        paramObject = ((dew)localObject1).error_msg;
        break label498;
        paramObject = parama;
        if (paramObject != null) {
          paramObject.a("transfer failed invalid token", null);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    implements z.a
  {
    d(a parama, kotlin.d.d<? super r<String, ? extends dew>> paramd, TransferRequestInfo paramTransferRequestInfo, g.a parama1) {}
    
    public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
    {
      AppMethodBeat.i(303065);
      Log.i("MicroMsg.BaseTransferRequest", "[transferRequest-" + this.vWo.dgV() + "] errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramc = this.vWo.g(paramc);
        if (paramc != null)
        {
          paramString = this.ojk;
          paramc = new r("", paramc);
          paramp = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramc));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(303065);
        return 0;
        paramString = this.ojk;
        paramc = new r("transfer failed invalid jsApiResponse", null);
        paramp = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
        continue;
        if ((paramInt2 == -262) || (paramInt2 == -263))
        {
          this.vWo.vWm.dgR();
          if (this.vWn.vBn)
          {
            Log.w("MicroMsg.BaseTransferRequest", "[transferRequest-" + this.vWo.dgV() + "] retry and failed");
            paramString = this.ojk;
            paramc = new r("transfer failed token expire and retry failed", null);
            paramp = Result.Companion;
            paramString.resumeWith(Result.constructor-impl(paramc));
          }
          else
          {
            Log.i("MicroMsg.BaseTransferRequest", "[transferRequest-" + this.vWo.dgV() + "] h5Session timeout and retry");
            this.vWn.vBn = true;
            this.vWn.vBm = a.dgU();
            this.vWo.b(this.vWn, this.vUT);
          }
        }
        else
        {
          paramString = this.ojk;
          paramc = new r(s.X("transfer failed errCode ", Integer.valueOf(paramInt2)), null);
          paramp = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramc));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.a
 * JD-Core Version:    0.7.0.1
 */