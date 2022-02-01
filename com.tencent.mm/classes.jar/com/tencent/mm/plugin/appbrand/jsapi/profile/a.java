package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a sqG;
  
  static
  {
    AppMethodBeat.i(50637);
    sqG = new a((byte)0);
    NAME = "openBizProfile";
    CTRL_INDEX = 560;
    AppMethodBeat.o(50637);
  }
  
  private static final void a(f paramf, int paramInt1, a parama, String paramString1, int paramInt2, String paramString2, ProfileResult paramProfileResult)
  {
    int i = 0;
    AppMethodBeat.i(325860);
    s.u(paramf, "$env");
    s.u(parama, "this$0");
    if (paramProfileResult == null)
    {
      Log.e("MicroMsg.JsApiOpenBizProfile", "onReceiveResult, null result");
      paramf.callback(paramInt1, parama.ZP("fail"));
      AppMethodBeat.o(325860);
      return;
    }
    Log.i("MicroMsg.JsApiOpenBizProfile", "onReceiveResult resultCode:%d", new Object[] { Integer.valueOf(paramProfileResult.resultCode) });
    switch (paramProfileResult.resultCode)
    {
    default: 
      paramf.callback(paramInt1, parama.ZP("fail"));
      AppMethodBeat.o(325860);
      return;
    case 0: 
      paramf.callback(paramInt1, parama.ZP("fail"));
      AppMethodBeat.o(325860);
      return;
    case 1: 
      Intent localIntent = new Intent();
      if (!Util.isNullOrNil(paramString1)) {
        localIntent.putExtra("key_add_contact_report_info", paramString1);
      }
      if ((paramProfileResult.sqJ & 0x1) != 0) {
        i = 1;
      }
      if (i != 0)
      {
        localIntent.putExtra("Contact_Scene", paramInt2);
        localIntent.putExtra("Contact_User", paramString2);
        localIntent.putExtra("key_use_new_contact_profile", true);
        paramf.i(new a..ExternalSyntheticLambda1(paramf, localIntent), 100L);
        paramf.callback(paramInt1, parama.ZP("ok"));
        AppMethodBeat.o(325860);
        return;
      }
      Log.i("MicroMsg.JsApiOpenBizProfile", "onReceiveResult, fail:not biz contact");
      paramf.callback(paramInt1, parama.ZP("fail:not biz contact"));
      AppMethodBeat.o(325860);
      return;
    }
    paramf.callback(paramInt1, parama.ZP("cancel"));
    AppMethodBeat.o(325860);
  }
  
  private static final void a(f paramf, Intent paramIntent)
  {
    AppMethodBeat.i(325853);
    s.u(paramf, "$env");
    s.u(paramIntent, "$intent");
    com.tencent.mm.br.c.b(paramf.getContext(), "profile", ".ui.ContactInfoUI", paramIntent);
    AppMethodBeat.o(325853);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(50636);
    s.u(paramf, "env");
    s.u(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    int i = paramJSONObject.optInt("scene", 122);
    String str = paramJSONObject.optString("profileReportInfo");
    if (Util.isNullOrNil((String)localObject))
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(50636);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = new a..ExternalSyntheticLambda0(paramf, paramInt, this, str, i, (String)localObject);
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50636);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenBizProfile$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.a
 * JD-Core Version:    0.7.0.1
 */