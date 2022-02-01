package com.tencent.mm.plugin.appbrand.jsapi.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a sqI;
  
  static
  {
    AppMethodBeat.i(50643);
    sqI = new a((byte)0);
    NAME = "profile";
    CTRL_INDEX = 508;
    AppMethodBeat.o(50643);
  }
  
  private static final void a(f paramf, int paramInt1, c paramc, String paramString1, int paramInt2, String paramString2, String paramString3, ProfileResult paramProfileResult)
  {
    AppMethodBeat.i(325857);
    s.u(paramf, "$env");
    s.u(paramc, "this$0");
    if (paramProfileResult == null)
    {
      Log.e("MicroMsg.JsApiProfile", "onReceiveResult get NULL result");
      paramf.callback(paramInt1, paramc.a(null, a.e.rVx, null));
      AppMethodBeat.o(325857);
      return;
    }
    Log.i("MicroMsg.JsApiProfile", "onReceiveResult resultCode:%d", new Object[] { Integer.valueOf(paramProfileResult.resultCode) });
    switch (paramProfileResult.resultCode)
    {
    default: 
      paramf.callback(paramInt1, paramc.ZP("fail"));
      AppMethodBeat.o(325857);
      return;
    case 0: 
      paramf.callback(paramInt1, paramc.ZP("fail"));
      AppMethodBeat.o(325857);
      return;
    case 1: 
      Intent localIntent = new Intent();
      if (!Util.isNullOrNil(paramString1)) {
        localIntent.putExtra("key_add_contact_report_info", paramString1);
      }
      if ((paramProfileResult.sqJ & 0x1) != 0) {
        localIntent.putExtra("Contact_Scene", paramInt2);
      }
      s.s(paramString2, "tabTypeStr");
      if (((CharSequence)paramString2).length() > 0) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if ((paramInt2 != 0) && (Util.safeParseInt(paramString2) == 2)) {
          localIntent.putExtra("biz_profile_tab_type", 1);
        }
        localIntent.putExtra("Contact_User", paramString3);
        localIntent.putExtra("key_use_new_contact_profile", true);
        com.tencent.mm.br.c.b(paramf.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        paramf.callback(paramInt1, paramc.ZP("ok"));
        AppMethodBeat.o(325857);
        return;
      }
    }
    paramf.callback(paramInt1, paramc.ZP("cancel"));
    AppMethodBeat.o(325857);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(50642);
    s.u(paramf, "env");
    s.u(paramJSONObject, "data");
    Object localObject = paramJSONObject.optString("username");
    int i = paramJSONObject.optInt("scene", 122);
    String str1 = paramJSONObject.optString("profileReportInfo");
    String str2 = paramJSONObject.optString("tabType");
    if (Util.isNullOrNil((String)localObject))
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(50642);
      return;
    }
    paramJSONObject = new ProfileRequest();
    paramJSONObject.username = ((String)localObject);
    paramJSONObject.scene = i;
    localObject = new c..ExternalSyntheticLambda0(paramf, paramInt, this, str1, i, str2, (String)localObject);
    a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)paramJSONObject, (AppBrandProxyUIProcessTask.b)localObject);
    AppMethodBeat.o(50642);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/JsApiProfile$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "JSAPI_Profile_Tab_Video", "NAME", "", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.profile.c
 * JD-Core Version:    0.7.0.1
 */