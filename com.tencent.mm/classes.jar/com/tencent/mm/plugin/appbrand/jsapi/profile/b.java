package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenUserProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a sqH;
  
  static
  {
    AppMethodBeat.i(50640);
    sqH = new a((byte)0);
    NAME = "openUserProfile";
    CTRL_INDEX = 559;
    AppMethodBeat.o(50640);
  }
  
  private static final void a(f paramf, int paramInt, b paramb, String paramString1, String paramString2, ProfileResult paramProfileResult)
  {
    int i = 1;
    AppMethodBeat.i(325855);
    s.u(paramf, "$env");
    s.u(paramb, "this$0");
    Log.i("MicroMsg.JsApiOpenUserProfile", "onReceiveResult resultCode:%d", new Object[] { Integer.valueOf(paramProfileResult.resultCode) });
    switch (paramProfileResult.resultCode)
    {
    default: 
      paramf.callback(paramInt, paramb.ZP("fail"));
      AppMethodBeat.o(325855);
      return;
    case 0: 
      paramf.callback(paramInt, paramb.ZP("fail"));
      AppMethodBeat.o(325855);
      return;
    case 1: 
      Intent localIntent = new Intent();
      if (!Util.isNullOrNil(paramString1)) {
        localIntent.putExtra("key_add_contact_report_info", paramString1);
      }
      if ((paramProfileResult.sqJ & 0x1) != 0) {}
      while (i == 0)
      {
        localIntent.putExtra("Contact_User", paramString2);
        com.tencent.mm.br.c.b(paramf.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        paramf.callback(paramInt, paramb.ZP("ok"));
        AppMethodBeat.o(325855);
        return;
        i = 0;
      }
      Log.i("MicroMsg.JsApiOpenUserProfile", "onReceiveResult, fail:not user contact");
      paramf.callback(paramInt, paramb.ZP("fail:not user contact"));
      AppMethodBeat.o(325855);
      return;
    }
    paramf.callback(paramInt, paramb.ZP("cancel"));
    AppMethodBeat.o(325855);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(50639);
    s.u(paramf, "env");
    s.u(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    int i = paramJSONObject.optInt("scene", 122);
    String str = paramJSONObject.optString("profileReportInfo");
    if (Util.isNullOrNil((String)localObject))
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(50639);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = new b..ExternalSyntheticLambda0(paramf, paramInt, this, str, (String)localObject);
    a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50639);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiOpenUserProfile$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.b
 * JD-Core Version:    0.7.0.1
 */