package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.k.l;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
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
  private String oOB;
  String oOK;
  String oOL;
  String oOM;
  boolean oON;
  String oOO;
  boolean oOP;
  final int oOQ;
  
  public e()
  {
    AppMethodBeat.i(174783);
    this.oOQ = a.aI(this);
    AppMethodBeat.o(174783);
  }
  
  private void a(final ah paramah, final AppBrandSysConfigWC paramAppBrandSysConfigWC, final a parama)
  {
    AppMethodBeat.i(46263);
    String str = paramah.getRuntime().bDy().username;
    if ((paramAppBrandSysConfigWC == null) || (Util.isNullOrNil(str)))
    {
      Log.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(46263);
      return;
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cdj();
    ((d.a)localObject).lBV = new cdk();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((d.a)localObject).funcId = 1303;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    cdj localcdj = (cdj)d.b.b(((d)localObject).lBR);
    localcdj.username = str;
    localcdj.Tlg = this.businessId;
    IPCRunCgi.a((d)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(46257);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (d.c.b(paramAnonymousd.lBS) == null))
        {
          Log.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, d.c.b(paramAnonymousd.lBS) });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(46257);
          return;
        }
        paramAnonymousString = (cdk)d.c.b(paramAnonymousd.lBS);
        Log.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.Tlh });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46256);
            e.this.a(e.2.this.otx, e.2.this.oOT, paramAnonymousString.Tlh, e.2.this.oOS);
            AppMethodBeat.o(46256);
          }
        });
        AppMethodBeat.o(46257);
      }
    });
    AppMethodBeat.o(46263);
  }
  
  private void a(ah paramah, final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
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
            str = l.eo(paramAnonymousString);
            paramAnonymousString = l.ep(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          Log.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          parame.j(paramInt, e.this.m("ok", localHashMap));
          AppMethodBeat.o(46255);
          return;
        }
        parame.j(paramInt, e.this.h(paramAnonymousString, null));
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
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().bDx();
    if (localAppBrandSysConfigWC == null)
    {
      Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46262);
      return;
    }
    this.oOB = paramJSONObject.optString("sessionFrom");
    if (this.oOB.length() > 1024)
    {
      this.oOB = this.oOB.substring(0, 1024);
      Log.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.businessId = paramJSONObject.optString("businessId");
    this.oOK = paramJSONObject.optString("sendMessageTitle");
    this.oOL = paramJSONObject.optString("sendMessagePath");
    this.oOM = paramJSONObject.optString("sendMessageImg");
    this.oON = paramJSONObject.optBoolean("showMessageCard", false);
    this.oOP = com.tencent.mm.plugin.appbrand.jsapi.share.z.aiC(this.oOM);
    this.oOO = com.tencent.mm.plugin.appbrand.jsapi.share.z.a(paramah, this.oOM, true);
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
  
  private static String dx(String paramString1, String paramString2)
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
  
  private static String dy(String paramString1, String paramString2)
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
      str = paramad.oxe;
    }
    Log.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(46267);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46260);
    if ((parame instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      parame = (com.tencent.mm.plugin.appbrand.service.c)parame;
      ah localah = parame.bDv();
      if (localah == null)
      {
        Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        parame.j(paramInt, h("fail:current page do not exist", null));
        AppMethodBeat.o(46260);
        return;
      }
      a(localah, parame, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    if ((parame instanceof ad))
    {
      a((ah)parame, parame, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    parame.j(paramInt, h("fail:internal error invalid js component", null));
    AppMethodBeat.o(46260);
  }
  
  final void a(final ah paramah, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, final a parama)
  {
    AppMethodBeat.i(46264);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramah.getRuntime().bDy().username;
    final WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramah.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.fzM;
    locala.iconUrl = paramAppBrandSysConfigWC.mnM;
    locala.nHY = paramAppBrandSysConfigWC.nYR.nHY;
    locala.pkgVersion = paramAppBrandSysConfigWC.nYR.pkgVersion;
    locala.obW = paramAppBrandSysConfigWC.nYR.md5;
    locala.from = 5;
    locala.pageId = e(paramah);
    locala.obX = com.tencent.mm.plugin.appbrand.z.aca(paramah.getAppId());
    localJsApiChattingTask.username = dy(str, paramString);
    localJsApiChattingTask.nickname = dx(paramAppBrandSysConfigWC.fzM, paramString);
    localJsApiChattingTask.oOB = this.oOB;
    localJsApiChattingTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46259);
        Log.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("app_brand_chatting_expose_params", locala.bLN());
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.oOB);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        if (e.this.oON)
        {
          localIntent.putExtra("sendMessageTitle", e.this.oOK);
          localIntent.putExtra("sendMessagePath", e.this.oOL);
          localIntent.putExtra("sendMessageImg", e.this.oOM);
          localIntent.putExtra("sendMessageLocalImg", com.tencent.mm.plugin.appbrand.jsapi.share.z.aiD(e.this.oOO));
          localIntent.putExtra("needDelThumb", e.this.oOP);
        }
        localIntent.putExtra("showMessageCard", e.this.oON);
        if (paramah.getRuntime().bDl()) {}
        Object localObject;
        for (int i = 2;; i = 1)
        {
          localObject = paramah.qoI;
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
        f.aI((Context)localObject).b(new f.c()
        {
          public final boolean c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174782);
            if (paramAnonymous2Int1 == e.this.oOQ)
            {
              if (e.3.this.oOS != null) {
                e.3.this.oOS.a(true, "ok", paramAnonymous2Intent);
              }
              e.3.this.oOW.bPk();
              AppMethodBeat.o(174782);
              return true;
            }
            AppMethodBeat.o(174782);
            return false;
          }
        });
        com.tencent.mm.by.c.d((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, e.this.oOQ);
        AppMethodBeat.o(46259);
      }
    };
    localJsApiChattingTask.bsM();
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