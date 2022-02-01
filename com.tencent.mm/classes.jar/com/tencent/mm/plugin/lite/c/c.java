package com.tencent.mm.plugin.lite.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class c
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  private String appId;
  private JSONObject kkm;
  
  public final int cZP()
  {
    return 1;
  }
  
  public final void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217785);
    if (paramInt1 == 1)
    {
      switch (paramInt2)
      {
      default: 
        this.vko.ZC("");
        AppMethodBeat.o(217785);
        return;
      case -1: 
        Object localObject1 = this.kkm.optString("url");
        if (paramIntent == null) {}
        for (String str = null; bu.isNullOrNil(str); str = paramIntent.getStringExtra("Select_Conv_User"))
        {
          ae.e("LiteAppJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
          this.vko.ZC("");
          AppMethodBeat.o(217785);
          return;
        }
        q.aIW();
        Object localObject2 = d.wA(this.kkm.optString("thumbUrl"));
        Object localObject5 = this.appId;
        Object localObject3 = this.kkm;
        Object localObject4 = new WXLiteAppObject();
        ((WXLiteAppObject)localObject4).userName = ((String)localObject5);
        ((WXLiteAppObject)localObject4).path = ((JSONObject)localObject3).optString("path");
        ((WXLiteAppObject)localObject4).webpageUrl = ((JSONObject)localObject3).optString("url");
        localObject5 = ((JSONObject)localObject3).optJSONObject("query");
        if (localObject5 != null) {
          ((WXLiteAppObject)localObject4).query = ((JSONObject)localObject5).toString();
        }
        localObject4 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject4);
        ((WXMediaMessage)localObject4).title = ((JSONObject)localObject3).optString("title");
        ((WXMediaMessage)localObject4).description = ((JSONObject)localObject3).optString("desc");
        if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
        {
          ae.i("LiteAppJsApiSendAppMessage", "thumb image is not null");
          localObject3 = new ByteArrayOutputStream();
          ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
          ((WXMediaMessage)localObject4).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
        }
        h.m(this.appId, true, false);
        localObject2 = new sv();
        ((sv)localObject2).dIs.dve = ((WXMediaMessage)localObject4);
        ((sv)localObject2).dIs.toUser = str;
        ((sv)localObject2).dIs.dvf = 49;
        ((sv)localObject2).dIs.dIt = str;
        ((sv)localObject2).dIs.dIu = "";
        ((sv)localObject2).dIs.dIx = ((String)localObject1);
        ((sv)localObject2).dIs.dIw = ((String)localObject1);
        com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        if (!bu.isNullOrNil(paramIntent))
        {
          localObject1 = new sy();
          ((sy)localObject1).dID.cUB = str;
          ((sy)localObject1).dID.content = paramIntent;
          ((sy)localObject1).dID.type = x.Bb(str);
          ((sy)localObject1).dID.flags = 0;
          com.tencent.mm.sdk.b.a.IvT.l((b)localObject1);
        }
        this.vko.cZN();
        AppMethodBeat.o(217785);
        return;
      }
      this.vko.ZC("cancel");
      AppMethodBeat.o(217785);
      return;
    }
    this.vko.ZC("");
    AppMethodBeat.o(217785);
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217784);
    this.appId = paramString;
    this.kkm = paramJSONObject;
    String str2 = paramJSONObject.optString("url");
    paramString = paramJSONObject.optString("path");
    if ((str2.isEmpty()) || (paramString.isEmpty()))
    {
      this.vko.ZC("");
      AppMethodBeat.o(217784);
      return;
    }
    String str1 = paramJSONObject.optString("thumbUrl");
    if ((!bu.isNullOrNil(str1)) && (str1.startsWith("http"))) {
      q.aIW().a(str1, null);
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
    paramString.setClass(ak.getContext(), WxaLiteAppApiProxyUI.class);
    paramString.putExtra("proxyui_action_code_key", 0);
    paramString.putExtra("webview_params", localHashMap);
    paramString.putExtra("callback_id", LiteAppCenter.addSelectConversationUICallback(this));
    paramJSONObject = ak.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
    com.tencent.mm.hellhoundlib.a.a.a(paramJSONObject, paramString.ahE(), "com/tencent/mm/plugin/lite/comm/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramJSONObject, "com/tencent/mm/plugin/lite/comm/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.c
 * JD-Core Version:    0.7.0.1
 */