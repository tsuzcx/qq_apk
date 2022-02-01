package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.plugin.brandservice.api.f;
import com.tencent.mm.plugin.brandservice.api.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiTransferRequestBase;", "T", "Lcom/tencent/luggage/container/LuggageComponent;", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi;", "()V", "getEnv", "", "getTransferFuncName", "", "getTransferType", "invokeInMM", "", "context", "Landroid/content/Context;", "dataStr", "jsApiCallback", "Lcom/tencent/mm/plugin/webview/luggage/jsapi/LuggageBaseJsApi$JsApiCallback;", "invokeInOwn", "ctx", "Lcom/tencent/luggage/container/LuggageJsApi$InvokeContext;", "Lcom/tencent/luggage/container/LuggageJsApi;", "kotlin.jvm.PlatformType", "name", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T extends a>
  extends bv<T>
{
  public static final a vVv = new a((byte)0);
  
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<T>.a paramb)
  {
    if (paramb == null) {}
    for (Object localObject = null;; localObject = paramb.eiZ.eif)
    {
      Log.d("MicroMsg.GamePrefetchJsApiTransferRequestBase", "[game-web-prefetch] " + dgG() + " invokeInOwn, data: " + localObject);
      if (localObject != null) {
        break;
      }
      if (paramb != null) {
        paramb.a("data is null", null);
      }
      return;
    }
    ((JSONObject)localObject).put("type", dgH());
    ((f)h.ax(f.class)).a((JSONObject)localObject, (g.a)new b(paramb, this));
  }
  
  public abstract String dgG();
  
  public abstract int dgH();
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return dgG();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiTransferRequestBase$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/GamePrefetchJsApiTransferRequestBase$invokeInOwn$1", "Lcom/tencent/mm/plugin/brandservice/api/ITransferRequester$TransferRequestResultCallback;", "interceptRequest", "", "requestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "onResult", "", "errMsg", "", "response", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(b<T>.a paramb, d<T> paramd) {}
    
    public final void a(String paramString, dew paramdew)
    {
      AppMethodBeat.i(303144);
      s.u(paramString, "errMsg");
      if (paramdew != null)
      {
        JSONObject localJSONObject = new JSONObject();
        String str = paramdew.error_msg;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localJSONObject.put("err_desc", paramString);
        str = paramdew.Kuf;
        paramString = str;
        if (str == null) {
          paramString = "";
        }
        localJSONObject.put("respJson", paramString);
        if (paramdew.ret == 0)
        {
          this.vVt.a("", localJSONObject);
          AppMethodBeat.o(303144);
          return;
        }
        this.vVt.a(s.X("failed ", Integer.valueOf(paramdew.ret)), localJSONObject);
        AppMethodBeat.o(303144);
        return;
      }
      paramdew = this.vVt;
      int i;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label167;
        }
      }
      for (;;)
      {
        paramdew.a(paramString, null);
        AppMethodBeat.o(303144);
        return;
        i = 0;
        break;
        label167:
        paramString = s.X(jdField_this.dgG(), " failed");
      }
    }
    
    public final boolean a(TransferRequestInfo paramTransferRequestInfo)
    {
      AppMethodBeat.i(303136);
      if (paramTransferRequestInfo == null)
      {
        AppMethodBeat.o(303136);
        return false;
      }
      paramTransferRequestInfo = paramTransferRequestInfo.url;
      s.s(paramTransferRequestInfo, "requestInfo.url");
      if (!UrlExKt.isGameCenterUrl(paramTransferRequestInfo))
      {
        AppMethodBeat.o(303136);
        return true;
      }
      AppMethodBeat.o(303136);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.d
 * JD-Core Version:    0.7.0.1
 */