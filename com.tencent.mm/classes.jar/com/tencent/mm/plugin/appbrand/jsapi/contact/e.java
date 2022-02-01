package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.e.b;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.r;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  String jOA;
  boolean jOB;
  String jOC;
  boolean jOD;
  final int jOE;
  private String jOo;
  private String jOx;
  String jOy;
  String jOz;
  
  public e()
  {
    AppMethodBeat.i(174783);
    this.jOE = com.tencent.luggage.sdk.g.a.aD(this);
    AppMethodBeat.o(174783);
  }
  
  private void a(final ae paramae, final AppBrandSysConfigWC paramAppBrandSysConfigWC, final a parama)
  {
    AppMethodBeat.i(46263);
    String str = paramae.getRuntime().aNc().username;
    if ((paramAppBrandSysConfigWC == null) || (bt.isNullOrNil(str)))
    {
      ad.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(46263);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bau();
    ((b.a)localObject).gUV = new bav();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((b.a)localObject).funcId = 1303;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    bau localbau = (bau)((b)localObject).gUS.gUX;
    localbau.username = str;
    localbau.Dyy = this.jOx;
    IPCRunCgi.a((b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46257);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.gUT.gUX == null))
        {
          ad.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.gUT.gUX });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(46257);
          return;
        }
        paramAnonymousString = (bav)paramAnonymousb.gUT.gUX;
        ad.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.Dyz });
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46256);
            e.this.a(e.2.this.iXG, e.2.this.jOH, paramAnonymousString.Dyz, e.2.this.jOG);
            AppMethodBeat.o(46256);
          }
        });
        AppMethodBeat.o(46257);
      }
    });
    AppMethodBeat.o(46263);
  }
  
  private void a(ae paramae, final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46261);
    a(paramae, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46255);
        ad.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = bt.by(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = k.cA(paramAnonymousString);
            paramAnonymousString = k.cB(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          ad.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramc.h(paramInt, e.this.k("ok", localHashMap));
          AppMethodBeat.o(46255);
          return;
        }
        paramc.h(paramInt, e.this.e(paramAnonymousString, null));
        AppMethodBeat.o(46255);
      }
    });
    AppMethodBeat.o(46261);
  }
  
  private void a(ae paramae, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46262);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46262);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramae.getRuntime().aNb();
    if (localAppBrandSysConfigWC == null)
    {
      ad.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46262);
      return;
    }
    this.jOo = paramJSONObject.optString("sessionFrom");
    if (this.jOo.length() > 1024)
    {
      this.jOo = this.jOo.substring(0, 1024);
      ad.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.jOx = paramJSONObject.optString("businessId");
    this.jOy = paramJSONObject.optString("sendMessageTitle");
    this.jOz = paramJSONObject.optString("sendMessagePath");
    this.jOA = paramJSONObject.optString("sendMessageImg");
    this.jOB = paramJSONObject.optBoolean("showMessageCard", false);
    this.jOD = r.IX(this.jOA);
    this.jOC = r.a(paramae, this.jOA, true);
    if (bt.isNullOrNil(this.jOx))
    {
      ad.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramae, localAppBrandSysConfigWC, "", parama);
      AppMethodBeat.o(46262);
      return;
    }
    ad.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    a(paramae, localAppBrandSysConfigWC, parama);
    AppMethodBeat.o(46262);
  }
  
  private static String cK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46265);
    if (!bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46265);
      return "";
    }
    if (!bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46265);
      return paramString1;
    }
    ad.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46265);
    return "";
  }
  
  private static String cL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46266);
    if (!bt.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46266);
      return paramString2;
    }
    if (!bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46266);
      return paramString1;
    }
    ad.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46266);
    return "";
  }
  
  private static String e(aa paramaa)
  {
    AppMethodBeat.i(46267);
    String str = "";
    if (paramaa != null) {
      str = paramaa.jzm;
    }
    ad.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(46267);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46260);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramc = (com.tencent.mm.plugin.appbrand.service.c)paramc;
      ae localae = paramc.aMZ();
      if (localae == null)
      {
        ad.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramc.h(paramInt, e("fail:current page do not exist", null));
        AppMethodBeat.o(46260);
        return;
      }
      a(localae, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    if ((paramc instanceof aa))
    {
      a((ae)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    paramc.h(paramInt, e("fail:internal error invalid js component", null));
    AppMethodBeat.o(46260);
  }
  
  final void a(final ae paramae, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, final a parama)
  {
    AppMethodBeat.i(46264);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramae.getRuntime().aNc().username;
    final WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramae.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.dfM;
    locala.iconUrl = paramAppBrandSysConfigWC.hGe;
    locala.iOQ = paramAppBrandSysConfigWC.jdS.iOQ;
    locala.pkgVersion = paramAppBrandSysConfigWC.jdS.pkgVersion;
    locala.jfT = paramAppBrandSysConfigWC.jdS.md5;
    locala.from = 5;
    locala.pageId = e(paramae);
    locala.jfU = u.Du(paramae.getAppId());
    localJsApiChattingTask.username = cL(str, paramString);
    localJsApiChattingTask.nickname = cK(paramAppBrandSysConfigWC.dfM, paramString);
    localJsApiChattingTask.jOo = this.jOo;
    localJsApiChattingTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46259);
        ad.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("app_brand_chatting_expose_params", locala.aTV());
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.jOo);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        if (e.this.jOB)
        {
          localIntent.putExtra("sendMessageTitle", e.this.jOy);
          localIntent.putExtra("sendMessagePath", e.this.jOz);
          localIntent.putExtra("sendMessageImg", e.this.jOA);
          localIntent.putExtra("sendMessageLocalImg", r.IY(e.this.jOC));
          localIntent.putExtra("needDelThumb", e.this.jOD);
        }
        localIntent.putExtra("showMessageCard", e.this.jOB);
        Activity localActivity = com.tencent.mm.sdk.f.a.iV(paramae.getRuntime().mContext);
        if (localActivity == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          ad.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
          AppMethodBeat.o(46259);
          return;
        }
        com.tencent.luggage.h.e.az(localActivity).b(new e.b()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174782);
            if (paramAnonymous2Int1 == e.this.jOE)
            {
              if (e.3.this.jOG != null) {
                e.3.this.jOG.a(true, "ok", paramAnonymous2Intent);
              }
              e.3.this.jOK.aXn();
              AppMethodBeat.o(174782);
              return true;
            }
            AppMethodBeat.o(174782);
            return false;
          }
        });
        d.c(localActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, e.this.jOE);
        AppMethodBeat.o(46259);
      }
    };
    localJsApiChattingTask.aXm();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46264);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e
 * JD-Core Version:    0.7.0.1
 */