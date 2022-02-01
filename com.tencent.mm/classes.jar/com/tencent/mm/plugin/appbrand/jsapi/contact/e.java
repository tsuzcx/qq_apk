package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.e.c;
import com.tencent.luggage.h.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.br.d;
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
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  private String kNe;
  private String kNn;
  String kNo;
  String kNp;
  String kNq;
  boolean kNr;
  String kNs;
  boolean kNt;
  final int kNu;
  
  public e()
  {
    AppMethodBeat.i(174783);
    this.kNu = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(174783);
  }
  
  private void a(final ad paramad, final AppBrandSysConfigWC paramAppBrandSysConfigWC, final a parama)
  {
    AppMethodBeat.i(46263);
    String str = paramad.getRuntime().aXx().username;
    if ((paramAppBrandSysConfigWC == null) || (bu.isNullOrNil(str)))
    {
      ae.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(46263);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bjm();
    ((b.a)localObject).hQG = new bjn();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((b.a)localObject).funcId = 1303;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    bjm localbjm = (bjm)((b)localObject).hQD.hQJ;
    localbjm.username = str;
    localbjm.GWU = this.kNn;
    IPCRunCgi.a((b)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(46257);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousb.hQE.hQJ == null))
        {
          ae.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousb.hQE.hQJ });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(46257);
          return;
        }
        paramAnonymousString = (bjn)paramAnonymousb.hQE.hQJ;
        ae.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.GWV });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46256);
            e.this.a(e.2.this.kux, e.2.this.kNx, paramAnonymousString.GWV, e.2.this.kNw);
            AppMethodBeat.o(46256);
          }
        });
        AppMethodBeat.o(46257);
      }
    });
    AppMethodBeat.o(46263);
  }
  
  private void a(ad paramad, final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46261);
    a(paramad, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46255);
        ae.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
          ae.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramc.h(paramInt, e.this.n("ok", localHashMap));
          AppMethodBeat.o(46255);
          return;
        }
        paramc.h(paramInt, e.this.e(paramAnonymousString, null));
        AppMethodBeat.o(46255);
      }
    });
    AppMethodBeat.o(46261);
  }
  
  private void a(ad paramad, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46262);
    if (paramJSONObject == null)
    {
      ae.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46262);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramad.getRuntime().aXw();
    if (localAppBrandSysConfigWC == null)
    {
      ae.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46262);
      return;
    }
    this.kNe = paramJSONObject.optString("sessionFrom");
    if (this.kNe.length() > 1024)
    {
      this.kNe = this.kNe.substring(0, 1024);
      ae.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.kNn = paramJSONObject.optString("businessId");
    this.kNo = paramJSONObject.optString("sendMessageTitle");
    this.kNp = paramJSONObject.optString("sendMessagePath");
    this.kNq = paramJSONObject.optString("sendMessageImg");
    this.kNr = paramJSONObject.optBoolean("showMessageCard", false);
    this.kNt = r.Rh(this.kNq);
    this.kNs = r.a(paramad, this.kNq, true);
    if (bu.isNullOrNil(this.kNn))
    {
      ae.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramad, localAppBrandSysConfigWC, "", parama);
      AppMethodBeat.o(46262);
      return;
    }
    ae.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    a(paramad, localAppBrandSysConfigWC, parama);
    AppMethodBeat.o(46262);
  }
  
  private static String cY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46265);
    if (!bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46265);
      return "";
    }
    if (!bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46265);
      return paramString1;
    }
    ae.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46265);
    return "";
  }
  
  private static String cZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46266);
    if (!bu.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46266);
      return paramString2;
    }
    if (!bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46266);
      return paramString1;
    }
    ae.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46266);
    return "";
  }
  
  private static String e(z paramz)
  {
    AppMethodBeat.i(46267);
    String str = "";
    if (paramz != null) {
      str = paramz.kxv;
    }
    ae.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(46267);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46260);
    if ((paramc instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramc = (com.tencent.mm.plugin.appbrand.service.c)paramc;
      ad localad = paramc.aXu();
      if (localad == null)
      {
        ae.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramc.h(paramInt, e("fail:current page do not exist", null));
        AppMethodBeat.o(46260);
        return;
      }
      a(localad, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    if ((paramc instanceof z))
    {
      a((ad)paramc, paramc, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    paramc.h(paramInt, e("fail:internal error invalid js component", null));
    AppMethodBeat.o(46260);
  }
  
  final void a(final ad paramad, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, final a parama)
  {
    AppMethodBeat.i(46264);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramad.getRuntime().aXx().username;
    final WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramad.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.dpI;
    locala.iconUrl = paramAppBrandSysConfigWC.iCT;
    locala.jLV = paramAppBrandSysConfigWC.kbw.jLV;
    locala.pkgVersion = paramAppBrandSysConfigWC.kbw.pkgVersion;
    locala.kdI = paramAppBrandSysConfigWC.kbw.md5;
    locala.from = 5;
    locala.pageId = e(paramad);
    locala.kdJ = v.Lj(paramad.getAppId());
    localJsApiChattingTask.username = cZ(str, paramString);
    localJsApiChattingTask.nickname = cY(paramAppBrandSysConfigWC.dpI, paramString);
    localJsApiChattingTask.kNe = this.kNe;
    localJsApiChattingTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46259);
        ae.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("app_brand_chatting_expose_params", locala.bfb());
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.kNe);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        if (e.this.kNr)
        {
          localIntent.putExtra("sendMessageTitle", e.this.kNo);
          localIntent.putExtra("sendMessagePath", e.this.kNp);
          localIntent.putExtra("sendMessageImg", e.this.kNq);
          localIntent.putExtra("sendMessageLocalImg", r.Ri(e.this.kNs));
          localIntent.putExtra("needDelThumb", e.this.kNt);
        }
        localIntent.putExtra("showMessageCard", e.this.kNr);
        Activity localActivity = com.tencent.mm.sdk.f.a.jw(paramad.getRuntime().mContext);
        if (localActivity == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          ae.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
          AppMethodBeat.o(46259);
          return;
        }
        com.tencent.luggage.h.e.aB(localActivity).b(new e.c()
        {
          public final boolean b(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174782);
            if (paramAnonymous2Int1 == e.this.kNu)
            {
              if (e.3.this.kNw != null) {
                e.3.this.kNw.a(true, "ok", paramAnonymous2Intent);
              }
              e.3.this.kNA.bix();
              AppMethodBeat.o(174782);
              return true;
            }
            AppMethodBeat.o(174782);
            return false;
          }
        });
        d.c(localActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, e.this.kNu);
        AppMethodBeat.o(46259);
      }
    };
    localJsApiChattingTask.biw();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46264);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e
 * JD-Core Version:    0.7.0.1
 */