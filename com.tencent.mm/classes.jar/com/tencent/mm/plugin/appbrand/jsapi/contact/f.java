package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import org.json.JSONObject;

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  String kND;
  String kNE;
  String kNF;
  String kNG;
  String kNH;
  private String kNe;
  final int kNu;
  
  public f()
  {
    AppMethodBeat.i(174785);
    this.kNu = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(174785);
  }
  
  private void a(z paramz, final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46279);
    a(paramz, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46275);
        ae.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = bu.bI(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = k.dt(paramAnonymousString);
            paramAnonymousString = k.du(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          ae.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramc.h(paramInt, f.this.n("ok", localHashMap));
          AppMethodBeat.o(46275);
          return;
        }
        paramc.h(paramInt, f.this.e(paramAnonymousString, null));
        AppMethodBeat.o(46275);
      }
    });
    AppMethodBeat.o(46279);
  }
  
  private void a(final z paramz, final a parama)
  {
    AppMethodBeat.i(46281);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    localJsApiChattingTask.username = this.kNE;
    localJsApiChattingTask.kNe = this.kNe;
    localJsApiChattingTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46277);
        ae.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.kNe);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        Object localObject = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject).appId = f.this.kND;
        ((WxaExposedParams.a)localObject).username = f.this.kNE;
        ((WxaExposedParams.a)localObject).from = 5;
        localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).bfb());
        localIntent.putExtra("keyPrivateAppId", f.this.kND);
        localIntent.putExtra("keyPrivateUserName", f.this.kNE);
        localIntent.putExtra("keyPrivateTitle", f.this.kNF);
        localIntent.putExtra("keyPrivateSubTitle", f.this.kNG);
        localIntent.putExtra("keyPrivateHeadImage", f.this.kNH);
        localObject = com.tencent.mm.sdk.f.a.jw(paramz.getRuntime().mContext);
        if (localObject == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          ae.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
          AppMethodBeat.o(46277);
          return;
        }
        e.aB((Context)localObject).b(new e.c()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174784);
            if (paramAnonymous2Int1 == f.this.kNu)
            {
              if (f.2.this.kNJ != null) {
                f.2.this.kNJ.a(true, "ok", paramAnonymous2Intent);
              }
              f.2.this.kNA.bix();
              AppMethodBeat.o(174784);
              return true;
            }
            AppMethodBeat.o(174784);
            return false;
          }
        });
        d.c((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, f.this.kNu);
        AppMethodBeat.o(46277);
      }
    };
    localJsApiChattingTask.biw();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46281);
  }
  
  private void a(z paramz, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46280);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46280);
      return;
    }
    if ((AppBrandSysConfigWC)paramz.getRuntime().Fm() == null)
    {
      ae.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46280);
      return;
    }
    this.kNe = paramJSONObject.optString("sessionFrom");
    if (this.kNe.length() > 1024)
    {
      this.kNe = this.kNe.substring(0, 1024);
      ae.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.kND = paramJSONObject.optString("appId");
    if (!bu.isNullOrNil(this.kND))
    {
      this.kNE = paramJSONObject.optString("userName");
      this.kNF = paramJSONObject.optString("title");
      this.kNG = paramJSONObject.optString("subTitle");
      this.kNH = paramJSONObject.optString("headimgUrl");
      a(paramz, parama);
    }
    AppMethodBeat.o(46280);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46278);
    if ((paramc instanceof r))
    {
      paramc = (r)paramc;
      z localz = paramc.getCurrentPageView();
      if (localz == null)
      {
        ae.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
        paramc.h(paramInt, e("fail:current page do not exist", null));
        AppMethodBeat.o(46278);
        return;
      }
      a(localz, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    if ((paramc instanceof z))
    {
      a((z)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    ae.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
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