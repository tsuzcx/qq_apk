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
import org.json.JSONObject;

public class g
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271513);
    Log.d("LiteAppJsApiOpenFinderSearchView", "Invoke openFinderSearchView");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271513);
      return;
    }
    paramJSONObject = paramJSONObject.toString().replace("hotwordText", "hotword_text").replace("actionType", "action_type");
    paramString = new Intent();
    paramString.addFlags(268435456);
    paramString.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    paramString.putExtra("proxyui_action_code_key", 4);
    paramString.putExtra("open_finder_search_view_param", paramJSONObject);
    paramString.putExtra("callback_id", b.e(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, paramString.aYi(), "com/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiOpenFinderSearchView", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/finder/LiteAppJsApiOpenFinderSearchView", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271513);
  }
  
  public final void cE(boolean paramBoolean)
  {
    AppMethodBeat.i(271522);
    if (paramBoolean)
    {
      this.JZj.fTW();
      AppMethodBeat.o(271522);
      return;
    }
    this.JZj.aJV("fail");
    AppMethodBeat.o(271522);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.d.g
 * JD-Core Version:    0.7.0.1
 */