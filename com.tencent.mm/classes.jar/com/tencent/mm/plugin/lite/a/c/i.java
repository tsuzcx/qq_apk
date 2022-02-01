package com.tencent.mm.plugin.lite.a.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wm.a;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.lite.a.b;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class i
  extends com.tencent.mm.plugin.lite.api.e
{
  private String appId;
  private JSONObject rmi;
  
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271591);
    this.appId = paramString;
    this.rmi = paramJSONObject;
    String str2 = paramJSONObject.optString("url");
    paramJSONObject.optString("path");
    if (str2.isEmpty())
    {
      this.JZj.aJV("");
      AppMethodBeat.o(271591);
      return;
    }
    String str1 = paramJSONObject.optString("thumbUrl");
    if ((!Util.isNullOrNil(str1)) && (str1.startsWith("http"))) {
      r.bJZ().a(str1, true, null);
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
    paramString.putExtra("callback_id", b.a(this));
    paramJSONObject = MMApplicationContext.getContext();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    com.tencent.mm.hellhoundlib.a.a.b(paramJSONObject, paramString.aYi(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramJSONObject.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramJSONObject, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271591);
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(271605);
    if (paramInt1 == 1)
    {
      switch (paramInt2)
      {
      default: 
        this.JZj.aJV("");
        AppMethodBeat.o(271605);
        return;
      case -1: 
        String str2 = this.rmi.optString("url");
        if (paramIntent == null) {}
        for (String str1 = null; Util.isNullOrNil(str1); str1 = paramIntent.getStringExtra("Select_Conv_User"))
        {
          Log.e("LiteAppJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
          this.JZj.aJV("");
          AppMethodBeat.o(271605);
          return;
        }
        r.bJZ();
        Object localObject2 = com.tencent.mm.modelimage.e.Eo(this.rmi.optString("thumbUrl"));
        Object localObject4 = this.appId;
        Object localObject3 = this.rmi;
        Object localObject1;
        if (fUc())
        {
          localObject4 = new WXWebpageObject();
          ((WXWebpageObject)localObject4).webpageUrl = ((JSONObject)localObject3).optString("url");
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject4);
          ((WXMediaMessage)localObject1).title = ((JSONObject)localObject3).optString("title");
          ((WXMediaMessage)localObject1).description = ((JSONObject)localObject3).optString("desc");
          if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
          {
            Log.i("LiteAppJsApiSendAppMessage", "thumb image is not null");
            localObject3 = new ByteArrayOutputStream();
            ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
            ((WXMediaMessage)localObject1).thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
          }
          localObject3 = this.rmi.optString("srcId");
          localObject4 = h.s((String)localObject3, true, false);
          localObject2 = new wm();
          ((wm)localObject2).hZZ.hzF = ((WXMediaMessage)localObject1);
          ((wm)localObject2).hZZ.toUser = str1;
          ((wm)localObject2).hZZ.hKZ = 2;
          ((wm)localObject2).hZZ.appId = ((String)localObject3);
          localObject3 = ((wm)localObject2).hZZ;
          if (localObject4 != null) {
            break label589;
          }
          localObject1 = "";
          label344:
          ((wm.a)localObject3).appName = ((String)localObject1);
          if (!Util.isNullOrNil(this.rmi.optString("src_username"))) {
            break label599;
          }
          ((wm)localObject2).hZZ.iac = null;
        }
        for (;;)
        {
          ((wm)localObject2).hZZ.iae = str2;
          ((wm)localObject2).hZZ.iad = str2;
          ((wm)localObject2).publish();
          paramIntent = paramIntent.getStringExtra("custom_send_text");
          if (!Util.isNullOrNil(paramIntent))
          {
            localObject1 = new wp();
            ((wp)localObject1).iak.hgl = str1;
            ((wp)localObject1).iak.content = paramIntent;
            ((wp)localObject1).iak.type = ab.IX(str1);
            ((wp)localObject1).iak.flags = 0;
            ((wp)localObject1).publish();
          }
          this.JZj.fTW();
          AppMethodBeat.o(271605);
          return;
          localObject1 = new WXLiteAppObject();
          ((WXLiteAppObject)localObject1).userName = ((String)localObject4);
          ((WXLiteAppObject)localObject1).path = ((JSONObject)localObject3).optString("path");
          ((WXLiteAppObject)localObject1).webpageUrl = ((JSONObject)localObject3).optString("url");
          localObject4 = ((JSONObject)localObject3).optJSONObject("query");
          if (localObject4 != null) {
            ((WXLiteAppObject)localObject1).query = ((JSONObject)localObject4).toString();
          }
          localObject1 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
          ((WXMediaMessage)localObject1).title = ((JSONObject)localObject3).optString("title");
          ((WXMediaMessage)localObject1).description = ((JSONObject)localObject3).optString("desc");
          break;
          label589:
          localObject1 = ((g)localObject4).field_appName;
          break label344;
          label599:
          ((wm)localObject2).hZZ.iaa = this.rmi.optString("src_username");
          ((wm)localObject2).hZZ.iab = this.rmi.optString("src_displayname");
        }
      }
      this.JZj.aJV("cancel");
      AppMethodBeat.o(271605);
      return;
    }
    this.JZj.aJV("");
    AppMethodBeat.o(271605);
  }
  
  public final int fEx()
  {
    return 1;
  }
  
  protected boolean fUc()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.i
 * JD-Core Version:    0.7.0.1
 */