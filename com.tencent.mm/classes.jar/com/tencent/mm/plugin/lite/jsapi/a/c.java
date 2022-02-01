package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
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

public class c
  extends b
{
  private String appId;
  private JSONObject lnV;
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(198841);
    this.appId = paramString;
    this.lnV = paramJSONObject;
    String str2 = paramJSONObject.optString("url");
    paramJSONObject.optString("path");
    if (str2.isEmpty())
    {
      this.yEn.aCS("");
      AppMethodBeat.o(198841);
      return;
    }
    String str1 = paramJSONObject.optString("thumbUrl");
    if ((!Util.isNullOrNil(str1)) && (str1.startsWith("http"))) {
      q.bcQ().a(str1, null);
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
    paramString.putExtra("callback_id", com.tencent.mm.plugin.lite.c.a(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramJSONObject, paramString.axQ(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(198841);
  }
  
  public final void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(198842);
    if (paramInt1 == 1)
    {
      switch (paramInt2)
      {
      default: 
        this.yEn.aCS("");
        AppMethodBeat.o(198842);
        return;
      case -1: 
        String str2 = this.lnV.optString("url");
        if (paramIntent == null) {}
        for (String str1 = null; Util.isNullOrNil(str1); str1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          Log.e("LiteAppJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
          this.yEn.aCS("");
          AppMethodBeat.o(198842);
          return;
        }
        q.bcQ();
        Object localObject1 = d.EP(this.lnV.optString("thumbUrl"));
        Object localObject4 = this.appId;
        Object localObject2 = this.lnV;
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
        localObject4 = this.lnV.optString("srcId");
        localObject1 = h.o((String)localObject4, true, false);
        localObject2 = new tt();
        ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject3);
        ((tt)localObject2).eaf.toUser = str1;
        ((tt)localObject2).eaf.dMG = 2;
        ((tt)localObject2).eaf.appId = ((String)localObject4);
        localObject3 = ((tt)localObject2).eaf;
        if (localObject1 == null)
        {
          localObject1 = "";
          ((tt.a)localObject3).appName = ((String)localObject1);
          if (!Util.isNullOrNil(this.lnV.optString("src_username"))) {
            break label534;
          }
          ((tt)localObject2).eaf.eai = null;
        }
        for (;;)
        {
          ((tt)localObject2).eaf.eak = str2;
          ((tt)localObject2).eaf.eaj = str2;
          EventCenter.instance.publish((IEvent)localObject2);
          paramIntent = paramIntent.getStringExtra("custom_send_text");
          if (!Util.isNullOrNil(paramIntent))
          {
            localObject1 = new tw();
            ((tw)localObject1).eaq.dkV = str1;
            ((tw)localObject1).eaq.content = paramIntent;
            ((tw)localObject1).eaq.type = ab.JG(str1);
            ((tw)localObject1).eaq.flags = 0;
            EventCenter.instance.publish((IEvent)localObject1);
          }
          this.yEn.ecz();
          AppMethodBeat.o(198842);
          return;
          localObject1 = ((g)localObject1).field_appName;
          break;
          label534:
          ((tt)localObject2).eaf.eag = this.lnV.optString("src_username");
          ((tt)localObject2).eaf.eah = this.lnV.optString("src_displayname");
        }
      }
      this.yEn.aCS("cancel");
      AppMethodBeat.o(198842);
      return;
    }
    this.yEn.aCS("");
    AppMethodBeat.o(198842);
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.c
 * JD-Core Version:    0.7.0.1
 */