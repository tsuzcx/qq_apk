package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.su.a;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    AppMethodBeat.i(211615);
    ad.d("MicroMsg.JsApiSendGameNameCard", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.f("data is null", null);
        AppMethodBeat.o(211615);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      i.aJq(paramString.optString("img_url"));
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
      com.tencent.mm.bs.d.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(211614);
          Object localObject1;
          if (paramAnonymousInt1 == 1) {
            localObject1 = paramString.optString("appid");
          }
          switch (paramAnonymousInt2)
          {
          default: 
            parama.f("fail", null);
            AppMethodBeat.o(211614);
            return;
          case -1: 
            if (paramAnonymousIntent == null) {}
            for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              ad.e("MicroMsg.JsApiSendGameNameCard", "mmOnActivityResult fail, toUser is null");
              parama.f("fail", null);
              AppMethodBeat.o(211614);
              return;
            }
            if (bt.isNullOrNil(str))
            {
              ad.e("MicroMsg.JsApiSendGameNameCard", "toUser is null");
              AppMethodBeat.o(211614);
              return;
            }
            q.aIE();
            Object localObject2 = com.tencent.mm.aw.d.vT(paramString.optString("img_url"));
            Object localObject3 = ac.aw(paramString);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              ad.i("MicroMsg.JsApiSendGameNameCard", "thumb image is not null");
              localObject4 = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
              ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
            }
            Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.m((String)localObject1, true, false);
            localObject2 = new su();
            ((su)localObject2).dHn.dtZ = ((WXMediaMessage)localObject3);
            ((su)localObject2).dHn.appId = ((String)localObject1);
            localObject3 = ((su)localObject2).dHn;
            if (localObject4 == null)
            {
              localObject1 = "";
              ((su.a)localObject3).appName = ((String)localObject1);
              ((su)localObject2).dHn.toUser = str;
              ((su)localObject2).dHn.dua = 2;
              if (!bt.isNullOrNil(paramString.optString("src_username"))) {
                break label500;
              }
              ((su)localObject2).dHn.dHq = null;
            }
            for (;;)
            {
              ((su)localObject2).dHn.dHr = paramString.optString("shareUrl");
              ((su)localObject2).dHn.dHs = paramString.optString("currentUrl");
              ((su)localObject2).dHn.dHt = paramString.optString("preVerifyAppId");
              a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
              if (!bt.isNullOrNil(paramAnonymousIntent))
              {
                localObject1 = new sx();
                ((sx)localObject1).dHy.dHz = str;
                ((sx)localObject1).dHy.content = paramAnonymousIntent;
                ((sx)localObject1).dHy.type = w.Ar(str);
                ((sx)localObject1).dHy.flags = 0;
                a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
              }
              com.tencent.mm.ui.base.h.cl(paramContext, paramContext.getResources().getString(2131755894));
              parama.f(null, null);
              AppMethodBeat.o(211614);
              return;
              localObject1 = ((com.tencent.mm.pluginsdk.model.app.g)localObject4).field_appName;
              break;
              label500:
              ((su)localObject2).dHn.dHo = paramString.optString("src_username");
              ((su)localObject2).dHn.dHp = paramString.optString("src_displayname");
            }
          }
          parama.f("cancel", null);
          AppMethodBeat.o(211614);
        }
      });
      AppMethodBeat.o(211615);
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ccO()
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