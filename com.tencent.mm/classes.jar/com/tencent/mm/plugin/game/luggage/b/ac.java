package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.g.a.sv.a;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class ac
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(final Context paramContext, final String paramString, final bq.a parama)
  {
    AppMethodBeat.i(193004);
    ae.d("MicroMsg.JsApiSendGameNameCard", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.f("data is null", null);
        AppMethodBeat.o(193004);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      i.aKJ(paramString.optString("img_url"));
      HashMap localHashMap = new HashMap();
      localHashMap.put("img_url", paramString.optString("img_url"));
      localHashMap.put("desc", paramString.optString("desc"));
      localHashMap.put("title", paramString.optString("title"));
      localHashMap.put("url", paramString.optString("shareUrl"));
      localHashMap.put("nickname", paramString.optString("card_nick_name"));
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_Type", 3);
      localIntent.putExtra("scene_from", 2);
      localIntent.putExtra("mutil_select_is_ret", true);
      localIntent.putExtra("webview_params", localHashMap);
      localIntent.putExtra("is_game_card", true);
      localIntent.putExtra("Retr_Msg_Type", 2);
      com.tencent.mm.br.d.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(193003);
          Object localObject1;
          if (paramAnonymousInt1 == 1) {
            localObject1 = paramString.optString("appid");
          }
          switch (paramAnonymousInt2)
          {
          default: 
            parama.f("fail", null);
            AppMethodBeat.o(193003);
            return;
          case -1: 
            if (paramAnonymousIntent == null) {}
            for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              ae.e("MicroMsg.JsApiSendGameNameCard", "mmOnActivityResult fail, toUser is null");
              parama.f("fail", null);
              AppMethodBeat.o(193003);
              return;
            }
            if (bu.isNullOrNil(str))
            {
              ae.e("MicroMsg.JsApiSendGameNameCard", "toUser is null");
              AppMethodBeat.o(193003);
              return;
            }
            q.aIW();
            Object localObject2 = com.tencent.mm.av.d.wA(paramString.optString("img_url"));
            Object localObject3 = ac.aw(paramString);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              ae.i("MicroMsg.JsApiSendGameNameCard", "thumb image is not null");
              localObject4 = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
              ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
            }
            Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.m((String)localObject1, true, false);
            localObject2 = new sv();
            ((sv)localObject2).dIs.dve = ((WXMediaMessage)localObject3);
            ((sv)localObject2).dIs.appId = ((String)localObject1);
            localObject3 = ((sv)localObject2).dIs;
            if (localObject4 == null)
            {
              localObject1 = "";
              ((sv.a)localObject3).appName = ((String)localObject1);
              ((sv)localObject2).dIs.toUser = str;
              ((sv)localObject2).dIs.dvf = 2;
              if (!bu.isNullOrNil(paramString.optString("src_username"))) {
                break label500;
              }
              ((sv)localObject2).dIs.dIv = null;
            }
            for (;;)
            {
              ((sv)localObject2).dIs.dIw = paramString.optString("shareUrl");
              ((sv)localObject2).dIs.dIx = paramString.optString("currentUrl");
              ((sv)localObject2).dIs.dIy = paramString.optString("preVerifyAppId");
              a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
              if (!bu.isNullOrNil(paramAnonymousIntent))
              {
                localObject1 = new sy();
                ((sy)localObject1).dID.cUB = str;
                ((sy)localObject1).dID.content = paramAnonymousIntent;
                ((sy)localObject1).dID.type = x.Bb(str);
                ((sy)localObject1).dID.flags = 0;
                a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
              }
              com.tencent.mm.ui.base.h.cm(paramContext, paramContext.getResources().getString(2131755894));
              parama.f(null, null);
              AppMethodBeat.o(193003);
              return;
              localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              label500:
              ((sv)localObject2).dIs.dIt = paramString.optString("src_username");
              ((sv)localObject2).dIs.dIu = paramString.optString("src_displayname");
            }
          }
          parama.f("cancel", null);
          AppMethodBeat.o(193003);
        }
      });
      AppMethodBeat.o(193004);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendGameNameCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ac
 * JD-Core Version:    0.7.0.1
 */