package com.tencent.mm.plugin.lite.a.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiRequestVerifyPwd;", "Lcom/tencent/mm/plugin/lite/api/LiteAppJsApi;", "()V", "invoke", "", "appId", "", "data", "Lorg/json/JSONObject;", "isFromView", "", "onRequestVerifyPwd", "requestCode", "", "resultCode", "retData", "Landroid/content/Intent;", "runModel", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends e
{
  public static final a KaC;
  private static final String NAME;
  
  static
  {
    AppMethodBeat.i(271525);
    KaC = new a((byte)0);
    NAME = "verifiyWXPassword";
    AppMethodBeat.o(271525);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271535);
    Log.d("LiteAppJsApiRequestVerifyPwd", "invoke requestVerifyPwd");
    paramJSONObject = new Intent();
    paramJSONObject.addFlags(268435456);
    paramJSONObject.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    paramJSONObject.putExtra("proxyui_action_code_key", 6);
    paramJSONObject.putExtra("callback_id", b.g((com.tencent.liteapp.jsapi.a)this));
    paramString = MMApplicationContext.getContext();
    paramJSONObject = new com.tencent.mm.hellhoundlib.b.a().cG(paramJSONObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, paramJSONObject.aYi(), "com/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiRequestVerifyPwd", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramJSONObject.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiRequestVerifyPwd", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271535);
  }
  
  public final void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(271545);
    Object localObject = new StringBuilder("LiteAppJsApiRequestVerifyPwd onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("LiteAppJsApiRequestVerifyPwd", bool);
      if ((paramInt2 != -1) || (paramIntent == null) || (paramInt1 != 1000)) {
        break;
      }
      localObject = paramIntent.getStringExtra("key_ticket");
      Map localMap = (Map)new HashMap();
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
      localMap.put("ticket", paramIntent);
      localMap.put("sucessful", "true");
      this.JZj.az(localMap);
      AppMethodBeat.o(271545);
      return;
    }
    this.JZj.aJV("fail");
    AppMethodBeat.o(271545);
  }
  
  public final int fEx()
  {
    return 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiRequestVerifyPwd$Companion;", "", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "TAG", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.k
 * JD-Core Version:    0.7.0.1
 */