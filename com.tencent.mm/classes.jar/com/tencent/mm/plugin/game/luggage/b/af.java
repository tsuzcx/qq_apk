package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tt.a;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
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

public class af
  extends bs<com.tencent.mm.plugin.game.luggage.g.i>
{
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(186883);
    Log.d("MicroMsg.JsApiSendGameNameCard", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.i("data is null", null);
        AppMethodBeat.o(186883);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.i.baY(paramString.optString("img_url"));
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
          AppMethodBeat.i(186882);
          Object localObject1;
          if (paramAnonymousInt1 == 1) {
            localObject1 = paramString.optString("appid");
          }
          switch (paramAnonymousInt2)
          {
          default: 
            parama.i("fail", null);
            AppMethodBeat.o(186882);
            return;
          case -1: 
            if (paramAnonymousIntent == null) {}
            for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              Log.e("MicroMsg.JsApiSendGameNameCard", "mmOnActivityResult fail, toUser is null");
              parama.i("fail", null);
              AppMethodBeat.o(186882);
              return;
            }
            if (Util.isNullOrNil(str))
            {
              Log.e("MicroMsg.JsApiSendGameNameCard", "toUser is null");
              AppMethodBeat.o(186882);
              return;
            }
            q.bcQ();
            Object localObject2 = d.EP(paramString.optString("img_url"));
            Object localObject3 = af.aS(paramString);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              Log.i("MicroMsg.JsApiSendGameNameCard", "thumb image is not null");
              localObject4 = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
              ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
            }
            Object localObject4 = com.tencent.mm.pluginsdk.model.app.h.o((String)localObject1, true, false);
            localObject2 = new tt();
            ((tt)localObject2).eaf.dCE = ((WXMediaMessage)localObject3);
            ((tt)localObject2).eaf.appId = ((String)localObject1);
            localObject3 = ((tt)localObject2).eaf;
            if (localObject4 == null)
            {
              localObject1 = "";
              ((tt.a)localObject3).appName = ((String)localObject1);
              ((tt)localObject2).eaf.toUser = str;
              ((tt)localObject2).eaf.dMG = 2;
              if (!Util.isNullOrNil(paramString.optString("src_username"))) {
                break label500;
              }
              ((tt)localObject2).eaf.eai = null;
            }
            for (;;)
            {
              ((tt)localObject2).eaf.eaj = paramString.optString("shareUrl");
              ((tt)localObject2).eaf.eak = paramString.optString("currentUrl");
              ((tt)localObject2).eaf.eal = paramString.optString("preVerifyAppId");
              EventCenter.instance.publish((IEvent)localObject2);
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
              if (!Util.isNullOrNil(paramAnonymousIntent))
              {
                localObject1 = new tw();
                ((tw)localObject1).eaq.dkV = str;
                ((tw)localObject1).eaq.content = paramAnonymousIntent;
                ((tw)localObject1).eaq.type = ab.JG(str);
                ((tw)localObject1).eaq.flags = 0;
                EventCenter.instance.publish((IEvent)localObject1);
              }
              com.tencent.mm.ui.base.h.cD(paramContext, paramContext.getResources().getString(2131755986));
              parama.i(null, null);
              AppMethodBeat.o(186882);
              return;
              localObject1 = ((g)localObject4).field_appName;
              break;
              label500:
              ((tt)localObject2).eaf.eag = paramString.optString("src_username");
              ((tt)localObject2).eaf.eah = paramString.optString("src_displayname");
            }
          }
          parama.i("cancel", null);
          AppMethodBeat.o(186882);
        }
      });
      AppMethodBeat.o(186883);
    }
  }
  
  public final void b(b<com.tencent.mm.plugin.game.luggage.g.i>.a paramb) {}
  
  public final int dTs()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendGameNameCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.af
 * JD-Core Version:    0.7.0.1
 */