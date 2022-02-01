package com.tencent.mm.plugin.lite.a.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class e
  extends com.tencent.mm.plugin.lite.api.e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271588);
    Log.d("LiteAppJsApiJumpToBizProfile", "Invoke jumpToBizProfile");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271588);
      return;
    }
    paramString = paramJSONObject.optString("tousername");
    String str1 = paramJSONObject.optString("extmsg");
    Log.d("LiteAppJsApiJumpToBizProfile", "doJumpToBizProfile %s, %s", new Object[] { paramString, str1 });
    String str2 = paramJSONObject.optString("url");
    if (Util.isNullOrNil(paramString))
    {
      this.JZj.aJV("fail: username is null");
      AppMethodBeat.o(271588);
      return;
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("tousername", paramString);
    paramJSONObject.put("extmsg", str1);
    paramJSONObject.put("url", str2);
    paramString = new Intent();
    paramString.addFlags(268435456);
    paramString.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    paramString.putExtra("proxyui_action_code_key", 3);
    paramString.putExtra("jump_to_biz_profile_params", paramJSONObject);
    paramString.putExtra("callback_id", b.d(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, paramString.aYi(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiJumpToBizProfile", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiJumpToBizProfile", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271588);
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271593);
    if (paramInt1 == 3) {}
    switch (paramInt2)
    {
    case 1: 
    default: 
      this.JZj.aJV("fail");
      Log.e("LiteAppJsApiJumpToBizProfile", "unknown resultCode");
      AppMethodBeat.o(271593);
      return;
    case -1: 
      this.JZj.fTW();
      AppMethodBeat.o(271593);
      return;
    case 0: 
      this.JZj.aJV("canceled");
      AppMethodBeat.o(271593);
      return;
    }
    this.JZj.aJV("check_fail");
    AppMethodBeat.o(271593);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.e
 * JD-Core Version:    0.7.0.1
 */