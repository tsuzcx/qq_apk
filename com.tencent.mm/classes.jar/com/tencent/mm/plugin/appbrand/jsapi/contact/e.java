package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.share.y;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 145;
  public static final String NAME = "enterContact";
  private String businessId;
  private String lRW;
  String lSf;
  String lSg;
  String lSh;
  boolean lSi;
  String lSj;
  boolean lSk;
  final int lSl;
  
  public e()
  {
    AppMethodBeat.i(174783);
    this.lSl = a.aK(this);
    AppMethodBeat.o(174783);
  }
  
  private void a(final ag paramag, final AppBrandSysConfigWC paramAppBrandSysConfigWC, final a parama)
  {
    AppMethodBeat.i(46263);
    String str = paramag.getRuntime().bsC().username;
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
    ((d.a)localObject).iLN = new bvr();
    ((d.a)localObject).iLO = new bvs();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
    ((d.a)localObject).funcId = 1303;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    bvr localbvr = (bvr)((com.tencent.mm.ak.d)localObject).iLK.iLR;
    localbvr.username = str;
    localbvr.MbE = this.businessId;
    IPCRunCgi.a((com.tencent.mm.ak.d)localObject, new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.ak.d paramAnonymousd)
      {
        AppMethodBeat.i(46257);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (paramAnonymousd.iLL.iLR == null))
        {
          Log.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, paramAnonymousd.iLL.iLR });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(46257);
          return;
        }
        paramAnonymousString = (bvs)paramAnonymousd.iLL.iLR;
        Log.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.MbF });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46256);
            e.this.a(e.2.this.lyx, e.2.this.lSo, paramAnonymousString.MbF, e.2.this.lSn);
            AppMethodBeat.o(46256);
          }
        });
        AppMethodBeat.o(46257);
      }
    });
    AppMethodBeat.o(46263);
  }
  
  private void a(ag paramag, final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46261);
    a(paramag, paramJSONObject, new a()
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
            str = l.dM(paramAnonymousString);
            paramAnonymousString = l.dN(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          Log.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramf.i(paramInt, e.this.n("ok", localHashMap));
          AppMethodBeat.o(46255);
          return;
        }
        paramf.i(paramInt, e.this.h(paramAnonymousString, null));
        AppMethodBeat.o(46255);
      }
    });
    AppMethodBeat.o(46261);
  }
  
  private void a(ag paramag, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(46262);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(46262);
      return;
    }
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramag.getRuntime().bsB();
    if (localAppBrandSysConfigWC == null)
    {
      Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(46262);
      return;
    }
    this.lRW = paramJSONObject.optString("sessionFrom");
    if (this.lRW.length() > 1024)
    {
      this.lRW = this.lRW.substring(0, 1024);
      Log.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
    }
    this.businessId = paramJSONObject.optString("businessId");
    this.lSf = paramJSONObject.optString("sendMessageTitle");
    this.lSg = paramJSONObject.optString("sendMessagePath");
    this.lSh = paramJSONObject.optString("sendMessageImg");
    this.lSi = paramJSONObject.optBoolean("showMessageCard", false);
    this.lSk = y.aaK(this.lSh);
    this.lSj = y.a(paramag, this.lSh, true);
    if (Util.isNullOrNil(this.businessId))
    {
      Log.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
      a(paramag, localAppBrandSysConfigWC, "", parama);
      AppMethodBeat.o(46262);
      return;
    }
    Log.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
    a(paramag, localAppBrandSysConfigWC, parama);
    AppMethodBeat.o(46262);
  }
  
  private static String jdMethod_do(String paramString1, String paramString2)
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
  
  private static String dp(String paramString1, String paramString2)
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
  
  private static String e(ac paramac)
  {
    AppMethodBeat.i(46267);
    String str = "";
    if (paramac != null) {
      str = paramac.lBI;
    }
    Log.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", new Object[] { str });
    AppMethodBeat.o(46267);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46260);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramf = (com.tencent.mm.plugin.appbrand.service.c)paramf;
      ag localag = paramf.bsz();
      if (localag == null)
      {
        Log.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
        paramf.i(paramInt, h("fail:current page do not exist", null));
        AppMethodBeat.o(46260);
        return;
      }
      a(localag, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    if ((paramf instanceof ac))
    {
      a((ag)paramf, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46260);
      return;
    }
    paramf.i(paramInt, h("fail:internal error invalid js component", null));
    AppMethodBeat.o(46260);
  }
  
  final void a(final ag paramag, AppBrandSysConfigWC paramAppBrandSysConfigWC, String paramString, final a parama)
  {
    AppMethodBeat.i(46264);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    String str = paramag.getRuntime().bsC().username;
    final WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = paramag.getAppId();
    locala.username = str;
    locala.nickname = paramAppBrandSysConfigWC.brandName;
    locala.iconUrl = paramAppBrandSysConfigWC.jyi;
    locala.kNW = paramAppBrandSysConfigWC.leE.kNW;
    locala.pkgVersion = paramAppBrandSysConfigWC.leE.pkgVersion;
    locala.lhn = paramAppBrandSysConfigWC.leE.md5;
    locala.from = 5;
    locala.pageId = e(paramag);
    locala.lho = w.Ur(paramag.getAppId());
    localJsApiChattingTask.username = dp(str, paramString);
    localJsApiChattingTask.nickname = jdMethod_do(paramAppBrandSysConfigWC.brandName, paramString);
    localJsApiChattingTask.lRW = this.lRW;
    localJsApiChattingTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46259);
        Log.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("app_brand_chatting_expose_params", locala.bAv());
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.lRW);
        localIntent.putExtra("finish_direct", true);
        localIntent.putExtra("key_need_send_video", false);
        if (e.this.lSi)
        {
          localIntent.putExtra("sendMessageTitle", e.this.lSf);
          localIntent.putExtra("sendMessagePath", e.this.lSg);
          localIntent.putExtra("sendMessageImg", e.this.lSh);
          localIntent.putExtra("sendMessageLocalImg", y.aaL(e.this.lSj));
          localIntent.putExtra("needDelThumb", e.this.lSk);
        }
        localIntent.putExtra("showMessageCard", e.this.lSi);
        Activity localActivity = AndroidContextUtil.castActivityOrNull(paramag.getRuntime().mContext);
        if (localActivity == null)
        {
          if (parama != null) {
            parama.a(false, "fail:internal error invalid android context", null);
          }
          Log.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
          AppMethodBeat.o(46259);
          return;
        }
        com.tencent.luggage.h.f.aK(localActivity).b(new f.c()
        {
          public final boolean c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174782);
            if (paramAnonymous2Int1 == e.this.lSl)
            {
              if (e.3.this.lSn != null) {
                e.3.this.lSn.a(true, "ok", paramAnonymous2Intent);
              }
              e.3.this.lSr.bDK();
              AppMethodBeat.o(174782);
              return true;
            }
            AppMethodBeat.o(174782);
            return false;
          }
        });
        com.tencent.mm.br.c.c(localActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, e.this.lSl);
        AppMethodBeat.o(46259);
      }
    };
    localJsApiChattingTask.bDJ();
    AppBrandMainProcessService.a(localJsApiChattingTask);
    AppMethodBeat.o(46264);
  }
  
  static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e
 * JD-Core Version:    0.7.0.1
 */