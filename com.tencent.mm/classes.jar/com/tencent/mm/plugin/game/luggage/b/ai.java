package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.uw;
import com.tencent.mm.f.a.uw.a;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class ai
  extends bs<i>
{
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(231325);
    Log.d("MicroMsg.JsApiSendGameNameCard", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.i("data is null", null);
        AppMethodBeat.o(231325);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      k.bmW(paramString.optString("img_url"));
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
      c.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", localIntent, 1, new MMActivity.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(231831);
          Object localObject1;
          if (paramAnonymousInt1 == 1) {
            localObject1 = paramString.optString("appid");
          }
          switch (paramAnonymousInt2)
          {
          default: 
            parama.i("fail", null);
            AppMethodBeat.o(231831);
            return;
          case -1: 
            if (paramAnonymousIntent == null) {}
            for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              Log.e("MicroMsg.JsApiSendGameNameCard", "mmOnActivityResult fail, toUser is null");
              parama.i("fail", null);
              AppMethodBeat.o(231831);
              return;
            }
            if (Util.isNullOrNil(str))
            {
              Log.e("MicroMsg.JsApiSendGameNameCard", "toUser is null");
              AppMethodBeat.o(231831);
              return;
            }
            q.bmg();
            Object localObject2 = d.LI(paramString.optString("img_url"));
            Object localObject3 = ai.aZ(paramString);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              Log.i("MicroMsg.JsApiSendGameNameCard", "thumb image is not null");
              localObject4 = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
              ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
            }
            Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.o((String)localObject1, true, false);
            localObject2 = new uw();
            ((uw)localObject2).fUc.fvl = ((WXMediaMessage)localObject3);
            ((uw)localObject2).fUc.appId = ((String)localObject1);
            localObject3 = ((uw)localObject2).fUc;
            if (localObject4 == null)
            {
              localObject1 = "";
              ((uw.a)localObject3).appName = ((String)localObject1);
              ((uw)localObject2).fUc.toUser = str;
              ((uw)localObject2).fUc.fFO = 2;
              if (!Util.isNullOrNil(paramString.optString("src_username"))) {
                break label501;
              }
              ((uw)localObject2).fUc.fUf = null;
            }
            for (;;)
            {
              ((uw)localObject2).fUc.fUg = paramString.optString("shareUrl");
              ((uw)localObject2).fUc.fUh = paramString.optString("currentUrl");
              ((uw)localObject2).fUc.fUi = paramString.optString("preVerifyAppId");
              EventCenter.instance.publish((IEvent)localObject2);
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
              if (!Util.isNullOrNil(paramAnonymousIntent))
              {
                localObject1 = new uz();
                ((uz)localObject1).fUn.fcD = str;
                ((uz)localObject1).fUn.content = paramAnonymousIntent;
                ((uz)localObject1).fUn.type = ab.QZ(str);
                ((uz)localObject1).fUn.flags = 0;
                EventCenter.instance.publish((IEvent)localObject1);
              }
              com.tencent.mm.ui.base.h.cO(paramContext, paramContext.getResources().getString(c.i.app_shared));
              parama.i(null, null);
              AppMethodBeat.o(231831);
              return;
              localObject1 = ((g)localObject4).field_appName;
              break;
              label501:
              ((uw)localObject2).fUc.fUd = paramString.optString("src_username");
              ((uw)localObject2).fUc.fUe = paramString.optString("src_displayname");
            }
          }
          parama.i("cancel", null);
          AppMethodBeat.o(231831);
        }
      });
      AppMethodBeat.o(231325);
    }
  }
  
  public final void b(b<i>.a paramb) {}
  
  public final int cDj()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendGameNameCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ai
 * JD-Core Version:    0.7.0.1
 */