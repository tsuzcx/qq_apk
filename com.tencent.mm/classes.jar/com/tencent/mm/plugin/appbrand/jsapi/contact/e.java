package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.l.m;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.x;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  private String businessId;
  String rSA;
  boolean rSB;
  String rSC;
  boolean rSD;
  final int rSE;
  private String rSr;
  String rSy;
  String rSz;
  
  public e()
  {
    AppMethodBeat.i(174783);
    this.rSE = a.ce(this);
    AppMethodBeat.o(174783);
  }
  
  private void a(final ah paramah, final AppBrandSysConfigWC paramAppBrandSysConfigWC, final a parama)
  {
    AppMethodBeat.i(46263);
    String str = paramah.getRuntime().getInitConfig().username;
    if ((paramAppBrandSysConfigWC == null) || (Util.isNullOrNil(str)))
    {
      Log.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(46263);
      return;
    }
    Object localObject = new c.a();
    ((c.a)localObject).otE = new csz();
    ((c.a)localObject).otF = new cta();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((c.a)localObject).funcId = 1303;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    csz localcsz = (csz)c.b.b(((com.tencent.mm.am.c)localObject).otB);
    localcsz.username = str;
    localcsz.aayQ = this.businessId;
    IPCRunCgi.a((com.tencent.mm.am.c)localObject, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(46257);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
        {
          Log.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, c.c.b(paramAnonymousc.otC) });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(46257);
          return;
        }
        paramAnonymousString = (cta)c.c.b(paramAnonymousc.otC);
        Log.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.aayR });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46256);
            e.this.a(e.2.this.rxl, e.2.this.rSH, paramAnonymousString.aayR, e.2.this.rSG);
            AppMethodBeat.o(46256);
          }
        });
        AppMethodBeat.o(46257);
      }
    });
    AppMethodBeat.o(46263);
  }
  
  private void a(ah paramah, final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46261);
    a(paramah, paramJSONObject, new a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(46255);
        Log.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          HashMap localHashMap = new HashMap();
          String str = "";
          paramAnonymousString = new HashMap();
          if (paramAnonymousIntent != null)
          {
            paramAnonymousString = Util.nullAs(paramAnonymousIntent.getStringExtra("keyOutPagePath"), "");
            str = m.fL(paramAnonymousString);
            paramAnonymousString = m.fM(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          Log.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramf.callback(paramInt, e.this.m("ok", localHashMap));
          AppMethodBeat.o(46255);
          return;
        }
        paramf.callback(paramInt, e.this.ZP(paramAnonymousString));
        AppMethodBeat.o(46255);
      }
    });
    AppMethodBeat.o(46261);
  }
  
  private void a(ah paramah, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46262);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46262);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().ccM();
    if (localAppBrandSysConfigWC == null)
    {
      Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46262);
      return;
    }
    this.rSr = paramJSONObject.optString("sessionFrom");
    if (this.rSr.length() > 1024)
    {
      this.rSr = this.rSr.substring(0, 1024);
      Log.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.businessId = paramJSONObject.optString("businessId");
    this.rSy = paramJSONObject.optString("sendMessageTitle");
    if (Util.isNullOrNil(this.rSy)) {
      this.rSy = paramah.coY();
    }
    this.rSz = paramJSONObject.optString("sendMessagePath");
    if (Util.isNullOrNil(this.rSz))
    {
      this.rSz = paramah.cEE();
      if (this.rSz.length() > 1024) {
        this.rSz = this.rSz.substring(0, 1024);
      }
    }
    this.rSA = paramJSONObject.optString("sendMessageImg");
    this.rSB = paramJSONObject.optBoolean("showMessageCard", false);
    this.rSD = x.abC(this.rSA);
    this.rSC = x.a(paramah, this.rSA, true);
    if (Util.isNullOrNil(this.businessId))
    {
      Log.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramah, localAppBrandSysConfigWC, "", parama);
      AppMethodBeat.o(46262);
      return;
    }
    Log.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    a(paramah, localAppBrandSysConfigWC, parama);
    AppMethodBeat.o(46262);
  }
  
  private static String dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46265);
    if (!Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46265);
      return "";
    }
    if (!Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46265);
      return paramString1;
    }
    Log.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46265);
    return "";
  }
  
  private static String dR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(46266);
    if (!Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(46266);
      return paramString2;
    }
    if (!Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(46266);
      return paramString1;
    }
    Log.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
    AppMethodBeat.o(46266);
    return "";
  }
  
  private static String e(ad paramad)
  {
    AppMethodBeat.i(46267);
    String str = "";
    if (paramad != null) {
      str = paramad.cgR();
    }
    Log.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(46267);
    return str;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46260);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramf = (com.tencent.mm.plugin.appbrand.service.c)paramf;
      ah localah = paramf.ccK();
      if (localah == null)
      {
        Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramf.callback(paramInt, ZP("fail:current page do not exist"));
        AppMethodBeat.o(46260);
        return;
      }
      a(localah, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    if ((paramf instanceof ad))
    {
      a((ah)paramf, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    paramf.callback(paramInt, ZP("fail:internal error invalid js component"));
    AppMethodBeat.o(46260);
  }
  
  final void a(final ah paramah, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, final a parama)
  {
    AppMethodBeat.i(46264);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramah.getRuntime().getInitConfig().username;
    final WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramah.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.hEy;
    locala.iconUrl = paramAppBrandSysConfigWC.phA;
    locala.qHO = paramAppBrandSysConfigWC.qYY.qHO;
    locala.pkgVersion = paramAppBrandSysConfigWC.qYY.pkgVersion;
    locala.rcM = paramAppBrandSysConfigWC.qYY.md5;
    locala.from = 5;
    locala.hUf = e(paramah);
    locala.rcN = ac.UC(paramah.getAppId());
    localJsApiChattingTask.username = dR(str, paramString);
    localJsApiChattingTask.nickname = dQ(paramAppBrandSysConfigWC.hEy, paramString);
    localJsApiChattingTask.rSr = this.rSr;
    localJsApiChattingTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46259);
        Log.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("app_brand_chatting_expose_params", locala.cll());
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.rSr);
        localIntent.putExtra("finish_direct", true);
        Object localObject = g.qWE;
        if (!g.ckz()) {
          localIntent.putExtra("key_need_send_video", false);
        }
        if (e.this.rSB)
        {
          localIntent.putExtra("sendMessageTitle", e.this.rSy);
          localIntent.putExtra("sendMessagePath", e.this.rSz);
          localIntent.putExtra("sendMessageImg", e.this.rSA);
          localIntent.putExtra("sendMessageLocalImg", x.abD(e.this.rSC));
          localIntent.putExtra("needDelThumb", e.this.rSD);
        }
        localIntent.putExtra("showMessageCard", e.this.rSB);
        if (paramah.getRuntime().ccB()) {}
        for (int i = 2;; i = 1)
        {
          localObject = paramah.cEE();
          String str = paramah.getAppId();
          Log.i("MicroMsg.JsApiEnterContact", "doEnterChatting, scene: %d, sceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(i), localObject, str });
          localIntent.putExtra("app_brand_chatting_from_scene_new", i);
          localIntent.putExtra("app_brand_chatting_from_scene_note_new", (String)localObject);
          localIntent.putExtra("app_brand_chatting_from_app_id", str);
          localObject = AndroidContextUtil.castActivityOrNull(paramah.getRuntime().mContext);
          if (localObject != null) {
            break;
          }
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          Log.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
          AppMethodBeat.o(46259);
          return;
        }
        com.tencent.luggage.l.e.bt((Context)localObject).b(new e.c()
        {
          public final boolean onResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174782);
            if (paramAnonymous2Int1 == e.this.rSE)
            {
              if (e.3.this.rSG != null) {
                e.3.this.rSG.a(true, "ok", paramAnonymous2Intent);
              }
              e.3.this.rSK.cpx();
              AppMethodBeat.o(174782);
              return true;
            }
            AppMethodBeat.o(174782);
            return false;
          }
        });
        com.tencent.mm.br.c.d((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, e.this.rSE);
        AppMethodBeat.o(46259);
      }
    };
    localJsApiChattingTask.bQt();
    AppMethodBeat.o(46264);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e
 * JD-Core Version:    0.7.0.1
 */