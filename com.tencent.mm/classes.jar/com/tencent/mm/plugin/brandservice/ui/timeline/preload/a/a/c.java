package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiTransferRequest;", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "()V", "getEnv", "", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "plugin-brandservice_release"})
public final class c<T extends a>
  extends br<T>
{
  public static final a sQg;
  
  static
  {
    AppMethodBeat.i(265067);
    sQg = new a((byte)0);
    AppMethodBeat.o(265067);
  }
  
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<T>.a paramb)
  {
    AppMethodBeat.i(265066);
    if (paramb != null) {}
    for (JSONObject localJSONObject = paramb.NN();; localJSONObject = null)
    {
      Log.d("MicroMsg.GamePrefetchJsApiTransferRequest", "[game-web-prefetch] transferRequest invokeInOwn, data: ".concat(String.valueOf(localJSONObject)));
      if (localJSONObject != null) {
        break label59;
      }
      if (paramb == null) {
        break;
      }
      paramb.dr("data is null");
      AppMethodBeat.o(265066);
      return;
    }
    AppMethodBeat.o(265066);
    return;
    label59:
    r.a(localJSONObject, (r.a)new b(paramb));
    AppMethodBeat.o(265066);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "transferRequest";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiTransferRequest$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiTransferRequest$invokeInOwn$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/TransferRequest$TransferRequestCallback;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-brandservice_release"})
  public static final class b
    implements r.a
  {
    b(b.a parama) {}
    
    public final void a(String paramString, coc paramcoc)
    {
      AppMethodBeat.i(266776);
      p.k(paramString, "errMsg");
      if (paramcoc != null)
      {
        JSONObject localJSONObject = new JSONObject();
        String str = paramcoc.error_msg;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localJSONObject.put("err_desc", paramString);
        str = paramcoc.RUC;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localJSONObject.put("respJson", paramString);
        if (paramcoc.ret == 0)
        {
          this.sQe.e(localJSONObject);
          AppMethodBeat.o(266776);
          return;
        }
        this.sQe.a("failed " + paramcoc.ret, localJSONObject);
        AppMethodBeat.o(266776);
        return;
      }
      paramcoc = this.sQe;
      int i;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label171;
        }
      }
      for (;;)
      {
        paramcoc.dr(paramString);
        AppMethodBeat.o(266776);
        return;
        i = 0;
        break;
        label171:
        paramString = "transferRequest failed";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.c
 * JD-Core Version:    0.7.0.1
 */