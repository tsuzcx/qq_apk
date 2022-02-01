package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class f
  extends d
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  private String lRW;
  final int lSl;
  String lSu;
  String lSv;
  String lSw;
  String lSx;
  String lSy;
  
  public f()
  {
    AppMethodBeat.i(174785);
    this.lSl = a.aK(this);
    AppMethodBeat.o(174785);
  }
  
  private void a(final ac paramac, final a parama)
  {
    AppMethodBeat.i(46281);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    localJsApiChattingTask.username = this.lSv;
    localJsApiChattingTask.lRW = this.lRW;
    localJsApiChattingTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46277);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.lRW);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        Object localObject = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject).appId = f.this.lSu;
        ((WxaExposedParams.a)localObject).username = f.this.lSv;
        ((WxaExposedParams.a)localObject).from = 5;
        localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).bAv());
        localIntent.putExtra("keyPrivateAppId", f.this.lSu);
        localIntent.putExtra("keyPrivateUserName", f.this.lSv);
        localIntent.putExtra("keyPrivateTitle", f.this.lSw);
        localIntent.putExtra("keyPrivateSubTitle", f.this.lSx);
        localIntent.putExtra("keyPrivateHeadImage", f.this.lSy);
        localObject = AndroidContextUtil.castActivityOrNull(paramac.getRuntime().mContext);
        if (localObject == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
          AppMethodBeat.o(46277);
          return;
        }
        com.tencent.luggage.h.f.aK((Context)localObject).b(new f.c()
        {
          public final boolean c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174784);
            if (paramAnonymous2Int1 == f.this.lSl)
            {
              if (f.2.this.lSA != null) {
                f.2.this.lSA.a(true, "ok", paramAnonymous2Intent);
              }
              f.2.this.lSr.bDK();
              AppMethodBeat.o(174784);
              return true;
            }
            AppMethodBeat.o(174784);
            return false;
          }
        });
        c.c((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, f.this.lSl);
        AppMethodBeat.o(46277);
      }
    };
    localJsApiChattingTask.bDJ();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46281);
  }
  
  private void a(ac paramac, final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46279);
    a(paramac, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46275);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = Util.nullAs(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = l.dM(paramAnonymousString);
            paramAnonymousString = l.dN(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          Log.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramf.i(paramInt, f.this.n("ok", localHashMap));
          AppMethodBeat.o(46275);
          return;
        }
        paramf.i(paramInt, f.this.h(paramAnonymousString, null));
        AppMethodBeat.o(46275);
      }
    });
    AppMethodBeat.o(46279);
  }
  
  private void a(ac paramac, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46280);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46280);
      return;
    }
    if ((AppBrandSysConfigWC)paramac.getRuntime().OT() == null)
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46280);
      return;
    }
    this.lRW = paramJSONObject.optString("sessionFrom");
    if (this.lRW.length() > 1024)
    {
      this.lRW = this.lRW.substring(0, 1024);
      Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.lSu = paramJSONObject.optString("appId");
    if (!Util.isNullOrNil(this.lSu))
    {
      this.lSv = paramJSONObject.optString("userName");
      this.lSw = paramJSONObject.optString("title");
      this.lSx = paramJSONObject.optString("subTitle");
      this.lSy = paramJSONObject.optString("headimgUrl");
      a(paramac, parama);
    }
    AppMethodBeat.o(46280);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46278);
    if ((paramf instanceof s))
    {
      paramf = (s)paramf;
      ac localac = paramf.getCurrentPageView();
      if (localac == null)
      {
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
        paramf.i(paramInt, h("fail:current page do not exist", null));
        AppMethodBeat.o(46278);
        return;
      }
      a(localac, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    if ((paramf instanceof ac))
    {
      a((ac)paramf, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    Log.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
    AppMethodBeat.o(46278);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f
 * JD-Core Version:    0.7.0.1
 */