package com.tencent.mm.plugin.lite.a.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class a
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271502);
    Log.d("LiteAppJsApiDownloadGameVideo", "Invoke downloadGameVideo");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("fail: data is null");
      AppMethodBeat.o(271502);
      return;
    }
    paramString = paramJSONObject.optString("videoUrl", "");
    if (Util.isNullOrNil(paramString))
    {
      this.JZj.aJV("videoUrl is null");
      AppMethodBeat.o(271502);
      return;
    }
    String str = paramJSONObject.optString("thumbUrl", "");
    if (Util.isNullOrNil(str))
    {
      this.JZj.aJV("thumbUrl is null");
      AppMethodBeat.o(271502);
      return;
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("videoUrl", paramString);
    paramJSONObject.put("thumbUrl", str);
    paramString = new Intent();
    paramString.addFlags(268435456);
    paramString.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    paramString.putExtra("proxyui_action_code_key", 7);
    paramString.putExtra("download_game_video_params", paramJSONObject);
    paramString.putExtra("callback_id", b.h(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, paramString.aYi(), "com/tencent/mm/plugin/lite/jsapi/gamecenter/LiteAppJsApiDownloadGameVideo", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/gamecenter/LiteAppJsApiDownloadGameVideo", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271502);
  }
  
  public final void f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(271508);
    if (paramInt1 == 1137)
    {
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getStringExtra("ret_info");
        if ("0".equals(paramIntent))
        {
          this.JZj.fTW();
          AppMethodBeat.o(271508);
          return;
        }
        this.JZj.aJV(paramIntent);
        AppMethodBeat.o(271508);
        return;
      }
      this.JZj.aJV("cancel");
    }
    AppMethodBeat.o(271508);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.e.a
 * JD-Core Version:    0.7.0.1
 */