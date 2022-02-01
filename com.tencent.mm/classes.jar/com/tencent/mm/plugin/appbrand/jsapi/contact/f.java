package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  private String koP;
  final int kpf;
  String kpo;
  String kpp;
  String kpq;
  String kpr;
  String kps;
  
  public f()
  {
    AppMethodBeat.i(174785);
    this.kpf = com.tencent.luggage.sdk.g.a.aA(this);
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
        ac.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = bs.bG(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = k.cp(paramAnonymousString);
            paramAnonymousString = k.cq(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          ac.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramc.h(paramInt, f.this.k("ok", localHashMap));
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
    localJsApiChattingTask.username = this.kpp;
    localJsApiChattingTask.koP = this.koP;
    localJsApiChattingTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46277);
        ac.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.koP);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        Object localObject = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject).appId = f.this.kpo;
        ((WxaExposedParams.a)localObject).username = f.this.kpp;
        ((WxaExposedParams.a)localObject).from = 5;
        localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).baT());
        localIntent.putExtra("keyPrivateAppId", f.this.kpo);
        localIntent.putExtra("keyPrivateUserName", f.this.kpp);
        localIntent.putExtra("keyPrivateTitle", f.this.kpq);
        localIntent.putExtra("keyPrivateSubTitle", f.this.kpr);
        localIntent.putExtra("keyPrivateHeadImage", f.this.kps);
        localObject = com.tencent.mm.sdk.f.a.jg(paramaa.getRuntime().mContext);
        if (localObject == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          ac.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
          AppMethodBeat.o(46277);
          return;
        }
        e.aA((Context)localObject).b(new e.b()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174784);
            if (paramAnonymous2Int1 == f.this.kpf)
            {
              if (f.2.this.kpu != null) {
                f.2.this.kpu.a(true, "ok", paramAnonymous2Intent);
              }
              f.2.this.kpl.bek();
              AppMethodBeat.o(174784);
              return true;
            }
            AppMethodBeat.o(174784);
            return false;
          }
        });
        d.c((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, f.this.kpf);
        AppMethodBeat.o(46277);
      }
    };
    localJsApiChattingTask.bej();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46281);
  }
  
  private void a(aa paramaa, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46280);
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46280);
      return;
    }
    if ((AppBrandSysConfigWC)paramaa.getRuntime().DI() == null)
    {
      ac.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46280);
      return;
    }
    this.koP = paramJSONObject.optString("sessionFrom");
    if (this.koP.length() > 1024)
    {
      this.koP = this.koP.substring(0, 1024);
      ac.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.kpo = paramJSONObject.optString("appId");
    if (!bs.isNullOrNil(this.kpo))
    {
      this.kpp = paramJSONObject.optString("userName");
      this.kpq = paramJSONObject.optString("title");
      this.kpr = paramJSONObject.optString("subTitle");
      this.kps = paramJSONObject.optString("headimgUrl");
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
        ac.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
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
    ac.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
    AppMethodBeat.o(46278);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f
 * JD-Core Version:    0.7.0.1
 */