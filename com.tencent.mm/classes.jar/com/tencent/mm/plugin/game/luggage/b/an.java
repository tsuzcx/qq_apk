package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wm;
import com.tencent.mm.autogen.a.wm.a;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.k;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class an
  extends bw<GameWebPage>
{
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(277189);
    Log.d("MicroMsg.JsApiSendGameNameCard", "invokeInMM");
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString == null)
      {
        parama.j("data is null", null);
        AppMethodBeat.o(277189);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      m.bmB(paramString.optString("img_url"));
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
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(277163);
          Object localObject1;
          if (paramAnonymousInt1 == 1) {
            localObject1 = paramString.optString("appid");
          }
          switch (paramAnonymousInt2)
          {
          default: 
            parama.j("fail", null);
            AppMethodBeat.o(277163);
            return;
          case -1: 
            if (paramAnonymousIntent == null) {}
            for (String str = null; (str == null) || (str.length() == 0); str = paramAnonymousIntent.getStringExtra("Select_Conv_User"))
            {
              Log.e("MicroMsg.JsApiSendGameNameCard", "mmOnActivityResult fail, toUser is null");
              parama.j("fail", null);
              AppMethodBeat.o(277163);
              return;
            }
            if (Util.isNullOrNil(str))
            {
              Log.e("MicroMsg.JsApiSendGameNameCard", "toUser is null");
              AppMethodBeat.o(277163);
              return;
            }
            r.bJZ();
            Object localObject2 = e.Eo(paramString.optString("img_url"));
            Object localObject3 = an.bm(paramString);
            if ((localObject2 != null) && (!((Bitmap)localObject2).isRecycled()))
            {
              Log.i("MicroMsg.JsApiSendGameNameCard", "thumb image is not null");
              localObject4 = new ByteArrayOutputStream();
              ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject4);
              ((WXMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
            }
            Object localObject4 = h.s((String)localObject1, true, false);
            localObject2 = new wm();
            ((wm)localObject2).hZZ.hzF = ((WXMediaMessage)localObject3);
            ((wm)localObject2).hZZ.appId = ((String)localObject1);
            localObject3 = ((wm)localObject2).hZZ;
            if (localObject4 == null)
            {
              localObject1 = "";
              ((wm.a)localObject3).appName = ((String)localObject1);
              ((wm)localObject2).hZZ.toUser = str;
              ((wm)localObject2).hZZ.hKZ = 2;
              if (!Util.isNullOrNil(paramString.optString("src_username"))) {
                break label495;
              }
              ((wm)localObject2).hZZ.iac = null;
            }
            for (;;)
            {
              ((wm)localObject2).hZZ.iad = paramString.optString("shareUrl");
              ((wm)localObject2).hZZ.iae = paramString.optString("currentUrl");
              ((wm)localObject2).hZZ.iaf = paramString.optString("preVerifyAppId");
              ((wm)localObject2).publish();
              paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
              if (!Util.isNullOrNil(paramAnonymousIntent))
              {
                localObject1 = new wp();
                ((wp)localObject1).iak.hgl = str;
                ((wp)localObject1).iak.content = paramAnonymousIntent;
                ((wp)localObject1).iak.type = ab.IX(str);
                ((wp)localObject1).iak.flags = 0;
                ((wp)localObject1).publish();
              }
              k.cZ(paramContext, paramContext.getResources().getString(c.i.app_shared));
              parama.j(null, null);
              AppMethodBeat.o(277163);
              return;
              localObject1 = ((g)localObject4).field_appName;
              break;
              label495:
              ((wm)localObject2).hZZ.iaa = paramString.optString("src_username");
              ((wm)localObject2).hZZ.iab = paramString.optString("src_displayname");
            }
          }
          parama.j("cancel", null);
          AppMethodBeat.o(277163);
        }
      });
      AppMethodBeat.o(277189);
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "sendGameNameCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.an
 * JD-Core Version:    0.7.0.1
 */