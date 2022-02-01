package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uw.a;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class d
  extends b
{
  private String appId;
  private JSONObject oiG;
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(233924);
    this.appId = paramString;
    this.oiG = paramJSONObject;
    String str2 = paramJSONObject.optString("url");
    paramJSONObject.optString("path");
    if (str2.isEmpty())
    {
      this.Ega.aNa("");
      AppMethodBeat.o(233924);
      return;
    }
    String str1 = paramJSONObject.optString("thumbUrl");
    if ((!Util.isNullOrNil(str1)) && (str1.startsWith("http"))) {
      q.bmg().a(str1, null);
    }
    HashMap localHashMap = new HashMap();
    paramString = str1;
    if (str1 == null) {
      paramString = "";
    }
    localHashMap.put("img_url", paramString);
    localHashMap.put("desc", paramJSONObject.optString("desc"));
    localHashMap.put("title", paramJSONObject.optString("title"));
    localHashMap.put("url", str2);
    paramString = new Intent();
    paramString.addFlags(268435456);
    paramString.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
    paramString.putExtra("proxyui_action_code_key", 0);
    paramString.putExtra("webview_params", localHashMap);
    paramString.putExtra("callback_id", c.a(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, paramString.aFh(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(233924);
  }
  
  public final void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(233929);
    if (paramInt1 == 1)
    {
      switch (paramInt2)
      {
      default: 
        this.Ega.aNa("");
        AppMethodBeat.o(233929);
        return;
      case -1: 
        String str2 = this.oiG.optString("url");
        if (paramIntent == null) {}
        for (String str1 = null; Util.isNullOrNil(str1); str1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          Log.e("LiteAppJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
          this.Ega.aNa("");
          AppMethodBeat.o(233929);
          return;
        }
        q.bmg();
        Object localObject1 = com.tencent.mm.ay.d.LI(this.oiG.optString("thumbUrl"));
        Object localObject4 = this.appId;
        Object localObject2 = this.oiG;
        Object localObject3 = new WXLiteAppObject();
        ((WXLiteAppObject)localObject3).userName = ((String)localObject4);
        ((WXLiteAppObject)localObject3).path = ((JSONObject)localObject2).optString("path");
        ((WXLiteAppObject)localObject3).webpageUrl = ((JSONObject)localObject2).optString("url");
        localObject4 = ((JSONObject)localObject2).optJSONObject("query");
        if (localObject4 != null) {
          ((WXLiteAppObject)localObject3).query = ((JSONObject)localObject4).toString();
        }
        localObject3 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject3);
        ((WXMediaMessage)localObject3).title = ((JSONObject)localObject2).optString("title");
        ((WXMediaMessage)localObject3).description = ((JSONObject)localObject2).optString("desc");
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          Log.i("LiteAppJsApiSendAppMessage", "thumb image is not null");
          localObject2 = new ByteArrayOutputStream();
          ((Bitmap)localObject1).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject2);
          ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject2).toByteArray();
        }
        localObject4 = this.oiG.optString("srcId");
        localObject1 = h.o((String)localObject4, true, false);
        localObject2 = new uw();
        ((uw)localObject2).fUc.fvl = ((WXMediaMessage)localObject3);
        ((uw)localObject2).fUc.toUser = str1;
        ((uw)localObject2).fUc.fFO = 2;
        ((uw)localObject2).fUc.appId = ((String)localObject4);
        localObject3 = ((uw)localObject2).fUc;
        if (localObject1 == null)
        {
          localObject1 = "";
          ((uw.a)localObject3).appName = ((String)localObject1);
          if (!Util.isNullOrNil(this.oiG.optString("src_username"))) {
            break label534;
          }
          ((uw)localObject2).fUc.fUf = null;
        }
        for (;;)
        {
          ((uw)localObject2).fUc.fUh = str2;
          ((uw)localObject2).fUc.fUg = str2;
          EventCenter.instance.publish((IEvent)localObject2);
          paramIntent = paramIntent.getStringExtra("custom_send_text");
          if (!Util.isNullOrNil(paramIntent))
          {
            localObject1 = new uz();
            ((uz)localObject1).fUn.fcD = str1;
            ((uz)localObject1).fUn.content = paramIntent;
            ((uz)localObject1).fUn.type = ab.QZ(str1);
            ((uz)localObject1).fUn.flags = 0;
            EventCenter.instance.publish((IEvent)localObject1);
          }
          this.Ega.eLC();
          AppMethodBeat.o(233929);
          return;
          localObject1 = ((g)localObject1).field_appName;
          break;
          label534:
          ((uw)localObject2).fUc.fUd = this.oiG.optString("src_username");
          ((uw)localObject2).fUc.fUe = this.oiG.optString("src_displayname");
        }
      }
      this.Ega.aNa("cancel");
      AppMethodBeat.o(233929);
      return;
    }
    this.Ega.aNa("");
    AppMethodBeat.o(233929);
  }
  
  public final int ewF()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.d
 * JD-Core Version:    0.7.0.1
 */