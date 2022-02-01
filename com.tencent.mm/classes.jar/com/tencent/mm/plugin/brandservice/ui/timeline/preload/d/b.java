package com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.TransferResultInfo;
import com.tencent.mm.plugin.brandservice.api.g;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequestService;", "()V", "transferRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "callback", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "data", "Lorg/json/JSONObject;", "Companion", "RequestInMMTask", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.brandservice.api.f
{
  public static final a vWf;
  
  static
  {
    AppMethodBeat.i(303048);
    vWf = new a((byte)0);
    AppMethodBeat.o(303048);
  }
  
  public final void a(TransferRequestInfo paramTransferRequestInfo, g.a parama)
  {
    AppMethodBeat.i(303057);
    if (paramTransferRequestInfo == null)
    {
      if (parama != null) {
        parama.a("invalid requestInfo", null);
      }
      AppMethodBeat.o(303057);
      return;
    }
    if ((parama != null) && (parama.a(paramTransferRequestInfo)))
    {
      Log.w("MicroMsg.TransferRequestServiceImpl", "transferRequest intercepted");
      AppMethodBeat.o(303057);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      localObject = b.vWg;
      b.b.a.c(paramTransferRequestInfo, parama);
      AppMethodBeat.o(303057);
      return;
    }
    Object localObject = MainProcessIPCService.PROCESS_NAME;
    s.s(localObject, "PROCESS_NAME");
    com.tencent.mm.ipcinvoker.a.a((String)localObject, (Parcelable)paramTransferRequestInfo, (d)new b(), (kotlin.g.a.b)new c(parama));
    AppMethodBeat.o(303057);
  }
  
  public final void a(JSONObject paramJSONObject, g.a parama)
  {
    AppMethodBeat.i(303051);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(303051);
      return;
    }
    a(TransferRequestInfo.aL(paramJSONObject), parama);
    AppMethodBeat.o(303051);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestServiceImpl$Companion;", "", "()V", "TAG", "", "createTransferRequester", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester;", "type", "", "tokenManager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestServiceImpl$RequestInMMTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "Lcom/tencent/mm/plugin/brandservice/api/TransferResultInfo;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d<TransferRequestInfo, TransferResultInfo>
  {
    public static final a vWg;
    
    static
    {
      AppMethodBeat.i(303101);
      vWg = new a((byte)0);
      AppMethodBeat.o(303101);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestServiceImpl$RequestInMMTask$Companion;", "", "()V", "transferRequestInMM", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "callback", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static void c(TransferRequestInfo paramTransferRequestInfo, g.a parama)
      {
        AppMethodBeat.i(303073);
        s.u(paramTransferRequestInfo, "requestInfo");
        Log.i("MicroMsg.TransferRequestServiceImpl", s.X("[transferRequestInMM] type: ", Integer.valueOf(paramTransferRequestInfo.type)));
        Object localObject = b.vWf;
        localObject = b.a.a(paramTransferRequestInfo.type, (a)c.vWh);
        if (localObject == null)
        {
          Log.e("MicroMsg.TransferRequestServiceImpl", "transferRequest invalid transfer type");
          AppMethodBeat.o(303073);
          return;
        }
        ((g)localObject).b(paramTransferRequestInfo, (g.a)new a(parama));
        AppMethodBeat.o(303073);
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestServiceImpl$RequestInMMTask$Companion$transferRequestInMM$1", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class a
        implements g.a
      {
        a(g.a parama) {}
        
        public final void a(String paramString, dew paramdew)
        {
          AppMethodBeat.i(303060);
          s.u(paramString, "errMsg");
          g.a locala = this.vUT;
          if (locala != null) {
            locala.a(paramString, paramdew);
          }
          AppMethodBeat.o(303060);
        }
        
        public final boolean a(TransferRequestInfo paramTransferRequestInfo)
        {
          return false;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/TransferRequestServiceImpl$RequestInMMTask$invoke$2", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements g.a
    {
      b(com.tencent.mm.ipcinvoker.f<TransferResultInfo> paramf) {}
      
      public final void a(String paramString, dew paramdew)
      {
        AppMethodBeat.i(303081);
        com.tencent.mm.ipcinvoker.f localf = this.mht;
        if (localf != null)
        {
          TransferResultInfo localTransferResultInfo = new TransferResultInfo();
          localTransferResultInfo.errMsg = paramString;
          localTransferResultInfo.vBo = paramdew;
          paramString = ah.aiuX;
          localf.onCallback(localTransferResultInfo);
        }
        AppMethodBeat.o(303081);
      }
      
      public final boolean a(TransferRequestInfo paramTransferRequestInfo)
      {
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/brandservice/api/TransferResultInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<TransferResultInfo, ah>
  {
    c(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.b
 * JD-Core Version:    0.7.0.1
 */