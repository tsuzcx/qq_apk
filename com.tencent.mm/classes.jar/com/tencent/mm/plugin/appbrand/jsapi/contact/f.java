package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  private String kJP;
  final int kKf;
  String kKo;
  String kKp;
  String kKq;
  String kKr;
  String kKs;
  
  public f()
  {
    AppMethodBeat.i(174785);
    this.kKf = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(174785);
  }
  
  private void a(aa paramaa, final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46279);
    a(paramaa, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46275);
        ad.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = bt.bI(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = k.dr(paramAnonymousString);
            paramAnonymousString = k.ds(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          ad.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramc.h(paramInt, f.this.m("ok", localHashMap));
          AppMethodBeat.o(46275);
          return;
        }
        paramc.h(paramInt, f.this.e(paramAnonymousString, null));
        AppMethodBeat.o(46275);
      }
    });
    AppMethodBeat.o(46279);
  }
  
  private void a(final aa paramaa, final a parama)
  {
    AppMethodBeat.i(46281);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    localJsApiChattingTask.username = this.kKp;
    localJsApiChattingTask.kJP = this.kJP;
    localJsApiChattingTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46277);
        ad.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.kJP);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        Object localObject = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject).appId = f.this.kKo;
        ((WxaExposedParams.a)localObject).username = f.this.kKp;
        ((WxaExposedParams.a)localObject).from = 5;
        localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).bet());
        localIntent.putExtra("keyPrivateAppId", f.this.kKo);
        localIntent.putExtra("keyPrivateUserName", f.this.kKp);
        localIntent.putExtra("keyPrivateTitle", f.this.kKq);
        localIntent.putExtra("keyPrivateSubTitle", f.this.kKr);
        localIntent.putExtra("keyPrivateHeadImage", f.this.kKs);
        localObject = com.tencent.mm.sdk.f.a.jq(paramaa.getRuntime().mContext);
        if (localObject == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          ad.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
          AppMethodBeat.o(46277);
          return;
        }
        e.aA((Context)localObject).b(new e.c()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174784);
            if (paramAnonymous2Int1 == f.this.kKf)
            {
              if (f.2.this.kKu != null) {
                f.2.this.kKu.a(true, "ok", paramAnonymous2Intent);
              }
              f.2.this.kKl.bhO();
              AppMethodBeat.o(174784);
              return true;
            }
            AppMethodBeat.o(174784);
            return false;
          }
        });
        d.c((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, f.this.kKf);
        AppMethodBeat.o(46277);
      }
    };
    localJsApiChattingTask.bhN();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46281);
  }
  
  private void a(aa paramaa, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46280);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46280);
      return;
    }
    if ((AppBrandSysConfigWC)paramaa.getRuntime().Fh() == null)
    {
      ad.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46280);
      return;
    }
    this.kJP = paramJSONObject.optString("sessionFrom");
    if (this.kJP.length() > 1024)
    {
      this.kJP = this.kJP.substring(0, 1024);
      ad.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.kKo = paramJSONObject.optString("appId");
    if (!bt.isNullOrNil(this.kKo))
    {
      this.kKp = paramJSONObject.optString("userName");
      this.kKq = paramJSONObject.optString("title");
      this.kKr = paramJSONObject.optString("subTitle");
      this.kKs = paramJSONObject.optString("headimgUrl");
      a(paramaa, parama);
    }
    AppMethodBeat.o(46280);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46278);
    if ((paramc instanceof q))
    {
      paramc = (q)paramc;
      aa localaa = paramc.getCurrentPageView();
      if (localaa == null)
      {
        ad.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
        paramc.h(paramInt, e("fail:current page do not exist", null));
        AppMethodBeat.o(46278);
        return;
      }
      a(localaa, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    if ((paramc instanceof aa))
    {
      a((aa)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    ad.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
    AppMethodBeat.o(46278);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f
 * JD-Core Version:    0.7.0.1
 */