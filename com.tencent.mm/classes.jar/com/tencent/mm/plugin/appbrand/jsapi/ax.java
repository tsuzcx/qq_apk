package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPCCheckStrangerRequest", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a rxQ;
  
  static
  {
    AppMethodBeat.i(325577);
    rxQ = new a((byte)0);
    NAME = "checkStrangerContactListIsFriend";
    CTRL_INDEX = 983;
    AppMethodBeat.o(325577);
  }
  
  private static final void a(f paramf, int paramInt, ax paramax, Bundle paramBundle)
  {
    AppMethodBeat.i(325572);
    s.u(paramax, "this$0");
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("resJo", "");
      try
      {
        paramBundle = new JSONObject(paramBundle);
        Log.i("MicroMsg.JsApiCheckStrangerIsFriend", "onCallback，result ：%s", new Object[] { paramBundle });
        paramf.callback(paramInt, paramax.h("ok", paramBundle));
        AppMethodBeat.o(325572);
        return;
      }
      finally
      {
        for (;;)
        {
          paramBundle = null;
        }
      }
    }
    Log.i("MicroMsg.JsApiCheckStrangerIsFriend", "onCallback，data == null");
    paramf.callback(paramInt, paramax.ZP("fail data == null "));
    AppMethodBeat.o(325572);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(325590);
    s.u(paramJSONObject, "data");
    Log.i("MicroMsg.JsApiCheckStrangerIsFriend", s.X("invoke JsApiCheckStrangerIsFriend! ", paramJSONObject));
    if (paramf == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = paramf.getContext())
    {
      AppMethodBeat.o(325590);
      return;
    }
    localObject1 = new Bundle();
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null) {}
    for (paramJSONObject = localObject2;; paramJSONObject = paramJSONObject.toString())
    {
      ((Bundle)localObject1).putString("date", paramJSONObject);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, b.class, new ax..ExternalSyntheticLambda0(paramf, paramInt, this));
      AppMethodBeat.o(325590);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$IPCCheckStrangerRequest;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements d<Bundle, Bundle>
  {
    public static final a rxR;
    
    static
    {
      AppMethodBeat.i(325690);
      rxR = new a((byte)0);
      AppMethodBeat.o(325690);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiCheckStrangerIsFriend$IPCCheckStrangerRequest$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(JSONObject paramJSONObject, Bundle paramBundle, com.tencent.mm.ipcinvoker.f<Bundle> paramf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ax
 * JD-Core Version:    0.7.0.1
 */