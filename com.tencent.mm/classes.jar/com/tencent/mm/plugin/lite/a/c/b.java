package com.tencent.mm.plugin.lite.a.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271618);
    Log.d("LiteAppJsApiBatchAddCard", "Invoke batchAddCard");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("fail: data is null");
      AppMethodBeat.o(271618);
      return;
    }
    paramString = paramJSONObject.optString("card_list");
    String str1 = paramJSONObject.optString("srcUsername");
    String str2 = paramJSONObject.optString("url");
    String str3 = paramJSONObject.optString("consumedCardId");
    String str4 = paramJSONObject.optString("template_id");
    if (Util.isNullOrNil(paramString))
    {
      this.JZj.aJV("fail: cardlist is null");
      AppMethodBeat.o(271618);
      return;
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("card_list", paramString);
    paramJSONObject.put("srcUsername", str1);
    paramJSONObject.put("scene", "7");
    paramJSONObject.put("url", str2);
    paramJSONObject.put("consumedCardId", str3);
    paramJSONObject.put("template_id", str4);
    paramString = new Intent();
    paramString.addFlags(268435456);
    paramString.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    paramString.putExtra("proxyui_action_code_key", 1);
    paramString.putExtra("batch_add_card_params", paramJSONObject);
    paramString.putExtra("callback_id", com.tencent.mm.plugin.lite.a.b.b(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, paramString.aYi(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiBatchAddCard", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiBatchAddCard", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271618);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(271623);
    if (paramInt1 == 1)
    {
      HashMap localHashMap = new HashMap();
      if (paramIntent != null) {
        localHashMap.put("card_list", Util.nullAs(paramIntent.getStringExtra("card_list"), ""));
      }
      if (paramInt2 == -1)
      {
        this.JZj.az(localHashMap);
        AppMethodBeat.o(271623);
        return;
      }
      if (paramIntent == null) {
        break label111;
      }
    }
    label111:
    for (paramInt1 = paramIntent.getIntExtra("result_code", 2);; paramInt1 = 2)
    {
      if (paramInt1 == 2)
      {
        this.JZj.aJV("fail");
        AppMethodBeat.o(271623);
        return;
      }
      this.JZj.aJV("cancel");
      AppMethodBeat.o(271623);
      return;
    }
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.b
 * JD-Core Version:    0.7.0.1
 */