package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.l.e;
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
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.x;
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

public final class f
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 550;
  public static final String NAME = "privateEnterContact";
  private String businessId;
  String rSA;
  boolean rSB;
  String rSC;
  boolean rSD;
  final int rSE;
  String rSN;
  String rSO;
  String rSP;
  String rSQ;
  String rSR;
  String rSS;
  String rST;
  String rSr;
  String rSy;
  String rSz;
  
  public f()
  {
    AppMethodBeat.i(174785);
    this.rSE = a.ce(this);
    AppMethodBeat.o(174785);
  }
  
  private void a(final ah paramah, final a parama)
  {
    AppMethodBeat.i(327796);
    final JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
    localJsApiChattingTask.username = this.rSO;
    localJsApiChattingTask.rSr = this.rSr;
    localJsApiChattingTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46277);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        localIntent.putExtra("Chat_User", localJsApiChattingTask.username);
        localIntent.putExtra("app_brand_chatting_from_scene", 2);
        localIntent.putExtra("key_temp_session_from", localJsApiChattingTask.rSr);
        localIntent.putExtra("finish_direct", true);
        Object localObject = g.qWE;
        if (!g.ckz()) {
          localIntent.putExtra("key_need_send_video", false);
        }
        localObject = new WxaExposedParams.a();
        ((WxaExposedParams.a)localObject).appId = f.this.rSN;
        ((WxaExposedParams.a)localObject).username = f.this.rSO;
        ((WxaExposedParams.a)localObject).from = 5;
        localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).cll());
        localIntent.putExtra("keyPrivateAppId", f.this.rSN);
        localIntent.putExtra("keyPrivateUserName", f.this.rSO);
        localIntent.putExtra("keyPrivateTitle", f.this.rSP);
        localIntent.putExtra("keyPrivateSubTitle", f.this.rSQ);
        localIntent.putExtra("keyPrivateHeadImage", f.this.rSR);
        if (paramah.getRuntime().ccB()) {}
        for (int i = 2;; i = 1)
        {
          localObject = paramah.cEE();
          String str = paramah.getAppId();
          Log.i("MicroMsg.JsApiPrivateEnterContact", "doEnterChattingCustomized, scene: %d, sceneNote: %s, fromAppId: %s", new Object[] { Integer.valueOf(i), localObject, str });
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
          Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
          AppMethodBeat.o(46277);
          return;
        }
        e.bt((Context)localObject).b(new e.c()
        {
          public final boolean onResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
          {
            AppMethodBeat.i(174784);
            if (paramAnonymous2Int1 == f.this.rSE)
            {
              if (f.2.this.rSV != null) {
                f.2.this.rSV.a(true, "ok", paramAnonymous2Intent);
              }
              f.2.this.rSK.cpx();
              AppMethodBeat.o(174784);
              return true;
            }
            AppMethodBeat.o(174784);
            return false;
          }
        });
        com.tencent.mm.br.c.d((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, f.this.rSE);
        AppMethodBeat.o(46277);
      }
    };
    localJsApiChattingTask.bQt();
    AppMethodBeat.o(327796);
  }
  
  private void a(ah paramah, final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(327792);
    a(paramah, paramJSONObject, new a()
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
            str = m.fL(paramAnonymousString);
            paramAnonymousString = m.fM(paramAnonymousString);
          }
          localHashMap.put("path", str);
          localHashMap.put("query", paramAnonymousString);
          Log.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", new Object[] { str, paramAnonymousString.toString() });
          paramf.callback(paramInt, f.this.m("ok", localHashMap));
          AppMethodBeat.o(46275);
          return;
        }
        paramf.callback(paramInt, f.this.ZP(paramAnonymousString));
        AppMethodBeat.o(46275);
      }
    });
    AppMethodBeat.o(327792);
  }
  
  private void a(ah paramah, JSONObject paramJSONObject, a parama)
  {
    AppMethodBeat.i(327795);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
      parama.a(false, "fail:invalid data", null);
      AppMethodBeat.o(327795);
      return;
    }
    if (paramah.getRuntime().ccM() == null)
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
      parama.a(false, "fail:config is null", null);
      AppMethodBeat.o(327795);
      return;
    }
    this.rSr = paramJSONObject.optString("sessionFrom");
    if (this.rSr.length() > 1024)
    {
      this.rSr = this.rSr.substring(0, 1024);
      Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
    }
    this.rSN = paramJSONObject.optString("appId");
    if (Util.isNullOrNil(this.rSN))
    {
      parama.a(false, "fail:appId is null", null);
      AppMethodBeat.o(327795);
      return;
    }
    this.rSO = paramJSONObject.optString("userName");
    this.rSS = paramJSONObject.optString("contactUsername");
    this.rSS = aaw(this.rSS);
    this.rSP = paramJSONObject.optString("title");
    this.rSQ = paramJSONObject.optString("subTitle");
    this.rSR = paramJSONObject.optString("headimgUrl");
    if (!Util.isNullOrNil(this.rSO))
    {
      a(paramah, parama);
      AppMethodBeat.o(327795);
      return;
    }
    if (!Util.isNullOrNil(this.rSS))
    {
      this.businessId = paramJSONObject.optString("businessId");
      this.rSy = paramJSONObject.optString("sendMessageTitle");
      this.rSz = paramJSONObject.optString("sendMessagePath");
      this.rSA = paramJSONObject.optString("sendMessageImg");
      this.rSB = paramJSONObject.optBoolean("showMessageCard", false);
      this.rSD = x.abC(this.rSA);
      this.rSC = x.a(paramah, this.rSA, true);
      b(paramah, parama);
    }
    AppMethodBeat.o(327795);
  }
  
  private static String aaw(String paramString)
  {
    AppMethodBeat.i(327803);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(327803);
      return "";
    }
    if (paramString.endsWith("@app"))
    {
      AppMethodBeat.o(327803);
      return paramString;
    }
    paramString = paramString + "@app";
    AppMethodBeat.o(327803);
    return paramString;
  }
  
  private void b(final ah paramah, final a parama)
  {
    AppMethodBeat.i(327802);
    if (Util.isNullOrNil(this.rSS))
    {
      Log.e("MicroMsg.JsApiPrivateEnterContact", "doCgiAndEnterChatting username is null, err");
      if (parama != null) {
        parama.a(false, "fail:config is null", null);
      }
      AppMethodBeat.o(327802);
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
    localcsz.username = this.rSS;
    localcsz.aayQ = this.businessId;
    IPCRunCgi.a((com.tencent.mm.am.c)localObject, new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(327809);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0) || (c.c.b(paramAnonymousc.otC) == null))
        {
          Log.e("MicroMsg.JsApiPrivateEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, c.c.b(paramAnonymousc.otC) });
          if (parama != null) {
            parama.a(false, "fail:cgi fail", null);
          }
          AppMethodBeat.o(327809);
          return;
        }
        paramAnonymousString = (cta)c.c.b(paramAnonymousc.otC);
        Log.i("MicroMsg.JsApiPrivateEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[] { paramAnonymousString.aayR });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(327790);
            f.this.rST = paramAnonymousString.aayR;
            f localf = f.this;
            ah localah = f.3.this.rxl;
            f.a locala = f.3.this.rSV;
            JsApiChattingTask localJsApiChattingTask = new JsApiChattingTask();
            localJsApiChattingTask.rbO = localf.rSS;
            Object localObject = localf.rSS;
            String str = localf.rST;
            if (!Util.isNullOrNil(str)) {
              localObject = str;
            }
            for (;;)
            {
              localJsApiChattingTask.username = ((String)localObject);
              localJsApiChattingTask.rSr = localf.rSr;
              localJsApiChattingTask.rxj = new f.4(localf, localJsApiChattingTask, localah, locala);
              localJsApiChattingTask.bQt();
              AppMethodBeat.o(327790);
              return;
              if (Util.isNullOrNil((String)localObject))
              {
                Log.e("MicroMsg.JsApiPrivateEnterContact", "username & subBusinessUsername is null, err");
                localObject = "";
              }
            }
          }
        });
        AppMethodBeat.o(327809);
      }
    });
    AppMethodBeat.o(327802);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46278);
    if ((paramf instanceof com.tencent.mm.plugin.appbrand.service.c))
    {
      paramf = (com.tencent.mm.plugin.appbrand.service.c)paramf;
      ah localah = paramf.ccK();
      if (localah == null)
      {
        Log.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
        paramf.callback(paramInt, ZP("fail:current page do not exist"));
        AppMethodBeat.o(46278);
        return;
      }
      a(localah, paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(46278);
      return;
    }
    if ((paramf instanceof ah))
    {
      a((ah)paramf, paramf, paramJSONObject, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f
 * JD-Core Version:    0.7.0.1
 */