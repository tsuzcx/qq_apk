package com.tencent.mm.plugin.flash.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.flash.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements com.tencent.mm.ak.i, g.a, g
{
  protected Activity activity;
  protected String fuN;
  protected String mAppId;
  private boolean sPq;
  protected long sQI;
  protected float sQv;
  public long sXP;
  protected int scene;
  protected YtSDKKitFramework.IYtSDKKitNetResponseParser wIj;
  protected String wIk;
  protected boolean wIl;
  protected String wIm;
  int wIn;
  private long wIo;
  private com.tencent.mm.plugin.flash.e.a wIp;
  private String wIq;
  protected long wIr;
  
  public a()
  {
    AppMethodBeat.i(186615);
    this.wIn = -1;
    this.wIo = -1L;
    com.tencent.mm.kernel.g.aAf();
    this.sPq = com.tencent.mm.kernel.a.azo();
    this.wIq = "";
    this.sXP = 0L;
    this.wIr = 0L;
    AppMethodBeat.o(186615);
  }
  
  private com.tencent.mm.i.g axk(String paramString)
  {
    AppMethodBeat.i(186624);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.gqy = this;
    localg.field_mediaId = com.tencent.mm.plugin.facedetect.model.p.arC(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 1;
    localg.field_bzScene = 0;
    localg.field_largesvideo = 0;
    localg.fuQ = 5;
    AppMethodBeat.o(186624);
    return localg;
  }
  
  private void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(186626);
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("err_type", 4);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("errormsg", paramString);
      localJSONObject.put("err_feedback", this.wIm);
      label79:
      localHashMap.put("response", localJSONObject.toString());
      this.wIj.onNetworkResponseEvent(localHashMap, null);
      AppMethodBeat.o(186626);
      return;
    }
    catch (JSONException paramString)
    {
      break label79;
    }
  }
  
  public int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(186623);
    if (paramd == null) {}
    for (int i = -1;; i = paramd.field_retCode)
    {
      com.tencent.mm.plugin.flash.c.b.s("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.dLi().eqU = i;
      com.tencent.mm.plugin.flash.c.b.dLi().eqW = (System.currentTimeMillis() - this.sXP);
      if (paramInt != -21005) {
        break;
      }
      Log.i("MicroMsg.FaceFlashManagerData", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(186623);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramString = paramd.field_fileId;
      paramc = new Bundle();
      paramc.putString("key_pic_cdn_id", paramString);
      paramc.putString("key_cdn_aes_key", paramd.field_aesKey);
      com.tencent.mm.plugin.flash.c.b.axn("reqVerify");
      com.tencent.mm.plugin.flash.c.b.MY(9);
      com.tencent.mm.plugin.flash.c.b.dLi().eri = System.currentTimeMillis();
      paramc = this.wIp;
      long l = this.sQI;
      paramd = paramd.field_aesKey;
      String str1 = this.mAppId;
      String str2 = this.fuN;
      i = dLb();
      float f = this.sQv;
      if (this.wIl) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramc.a(l, paramString, paramd, str1, str2, i, f, paramInt, this);
        AppMethodBeat.o(186623);
        return 0;
      }
    }
    if (paramd != null)
    {
      Log.w("MicroMsg.FaceFlashManagerData", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(186623);
      return 0;
    }
    if (paramInt != 0)
    {
      Log.w("MicroMsg.FaceFlashManagerData", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(186623);
      return 0;
    }
    Log.i("MicroMsg.FaceFlashManagerData", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if (paramc != null) {
      Log.d("MicroMsg.FaceFlashManagerData", "hy: cdn process: %f", new Object[] { Double.valueOf(paramc.field_finishedLength / paramc.field_toltalLength) });
    }
    AppMethodBeat.o(186623);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  protected String axi(String paramString)
  {
    AppMethodBeat.i(186621);
    paramString = f.f(paramString, String.valueOf(this.sQI), this.mAppId, dLc());
    AppMethodBeat.o(186621);
    return paramString;
  }
  
  protected final void axj(String paramString)
  {
    AppMethodBeat.i(186622);
    paramString = axk(paramString);
    com.tencent.mm.plugin.flash.c.b.axn("reqCdn");
    this.sXP = System.currentTimeMillis();
    com.tencent.mm.plugin.flash.c.b.MY(8);
    if (!com.tencent.mm.an.f.baQ().f(paramString))
    {
      Log.e("MicroMsg.FaceFlashManagerData", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString.field_mediaId });
      com.tencent.mm.plugin.flash.c.b.axn("cdnFailTask");
      bn(90019, "face file add to cdn failed");
    }
    AppMethodBeat.o(186622);
  }
  
  public final void c(TextView paramTextView, String paramString)
  {
    int i = 1;
    AppMethodBeat.i(186628);
    try
    {
      if (System.currentTimeMillis() - this.wIo >= 1000L) {
        this.wIo = System.currentTimeMillis();
      }
      while (i == 0)
      {
        AppMethodBeat.o(186628);
        return;
        i = 0;
      }
      String str = com.tencent.mm.plugin.flash.d.a.aH(paramTextView.getContext(), paramString);
      Log.i("MicroMsg.FaceFlashManagerData", "updateTipText res:%s tip:%s", new Object[] { paramString, str });
      if (!TextUtils.isEmpty(str)) {
        paramTextView.setText(str);
      }
      AppMethodBeat.o(186628);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramTextView, "", new Object[0]);
      AppMethodBeat.o(186628);
    }
  }
  
  public final long cSK()
  {
    return this.sQI;
  }
  
  public int dKV()
  {
    return 8;
  }
  
  protected final void dKZ()
  {
    AppMethodBeat.i(186618);
    Log.i("MicroMsg.FaceFlashManagerData", "improveBrightness");
    if (this.activity == null)
    {
      AppMethodBeat.o(186618);
      return;
    }
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186613);
        YTCommonExInterface.setAppBrightness(a.this.activity, 255);
        AppMethodBeat.o(186613);
      }
    });
    AppMethodBeat.o(186618);
  }
  
  protected final void dLa()
  {
    AppMethodBeat.i(186619);
    Log.i("MicroMsg.FaceFlashManagerData", "restoreBrightness %d", new Object[] { Integer.valueOf(this.wIn) });
    if (this.wIn > 0) {
      com.tencent.f.h.RTc.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186614);
          if (a.this.activity != null) {
            YTCommonExInterface.setAppBrightness(a.this.activity, a.this.wIn);
          }
          AppMethodBeat.o(186614);
        }
      });
    }
    AppMethodBeat.o(186619);
  }
  
  public int dLb()
  {
    return 4;
  }
  
  public int dLc()
  {
    return 3;
  }
  
  public final void dLd()
  {
    AppMethodBeat.i(186629);
    this.wIo = System.currentTimeMillis();
    AppMethodBeat.o(186629);
  }
  
  public final JSONObject dT(String paramString, int paramInt)
  {
    AppMethodBeat.i(186627);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("err_type", 1);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("err_feedback", this.wIm);
      localJSONObject.put("key_app_id", this.mAppId);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("err_tip", paramString);
      }
      label69:
      AppMethodBeat.o(186627);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      break label69;
    }
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(186616);
    this.activity = paramActivity;
    this.scene = paramIntent.getIntExtra("scene", 0);
    this.mAppId = paramIntent.getStringExtra("appId");
    this.fuN = paramIntent.getStringExtra("request_verify_pre_info");
    this.wIl = paramIntent.getBooleanExtra("needVideo", false);
    this.wIm = paramIntent.getStringExtra("feedbackUrl");
    this.wIn = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness", 100);
    switch (this.scene)
    {
    default: 
      paramActivity = new com.tencent.mm.plugin.flash.e.b();
      this.wIp = paramActivity;
      paramIntent = paramIntent.getStringExtra("k_ticket");
      if (!Util.isNullOrNil(paramIntent))
      {
        Log.i("MicroMsg.FaceFlashManagerData", "has prepared ticket. force set");
        com.tencent.mm.plugin.facedetect.b.p.arz(paramIntent);
      }
      if (this.sPq) {
        com.tencent.mm.kernel.g.azz().a(732, this);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.azz().a(this.wIp.getType(), this);
      Log.i("MicroMsg.FaceFlashManagerData", "[%s]intent data, scene:%s ,mAppId:%s verifyInfo:%s currentLight %s enterBrightness: %s isLogin:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(this.scene), this.mAppId, this.fuN, Float.valueOf(this.sQv), Integer.valueOf(this.wIn), Boolean.valueOf(this.sPq) });
      AppMethodBeat.o(186616);
      return;
      paramActivity = new com.tencent.mm.plugin.flash.e.f();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.e();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.h();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.c();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.g();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.d();
      break;
      com.tencent.mm.kernel.g.azz().a(733, this);
    }
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, final YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(186617);
    Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.wIj = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.dLi().ere = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.axn("reqCfg");
      dKZ();
      Log.i("MicroMsg.FaceFlashManagerData", "requestConfig");
      com.tencent.mm.plugin.flash.c.b.MY(2);
      try
      {
        this.wIk = new JSONObject(paramString2).getString("select_data");
        Log.i("MicroMsg.FaceFlashManagerData", "getConfig selectData:%s", new Object[] { this.wIk });
        if (this.sPq)
        {
          paramString1 = new u(this.scene, dKV(), this.mAppId, this.fuN, this.wIk.getBytes());
          com.tencent.mm.kernel.g.azz().a(paramString1, 0);
          com.tencent.mm.plugin.flash.c.a.MS(dKV());
          AppMethodBeat.o(186617);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString1, "reflect get yt config data error", new Object[0]);
          continue;
          paramString1 = new v(this.scene, dKV());
          com.tencent.mm.kernel.g.azz().a(paramString1, 0);
        }
      }
    }
    if (paramString1.contains("wechat_face_verify"))
    {
      com.tencent.mm.plugin.flash.c.b.dLi().erh = System.currentTimeMillis();
      dLa();
      com.tencent.mm.plugin.flash.c.b.dLi().eqX = (System.currentTimeMillis() - this.wIr);
      paramString1 = axi(paramString2);
      if ((TextUtils.isEmpty(paramString1)) || (!s.YS(paramString1))) {
        bn(90034, "save result to file error.");
      }
      for (;;)
      {
        com.tencent.mm.plugin.flash.c.a.MT(dKV());
        AppMethodBeat.o(186617);
        return;
        axj(paramString1);
      }
    }
    paramIYtSDKKitNetResponseParser = new YtSDKKitFramework.IYtSDKKitNetResponseParser()
    {
      public final void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
      {
        AppMethodBeat.i(186612);
        Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  result:%s", new Object[] { paramAnonymousHashMap });
        paramIYtSDKKitNetResponseParser.onNetworkResponseEvent(paramAnonymousHashMap, paramAnonymousException);
        AppMethodBeat.o(186612);
      }
    };
    YtSDKKitNetHelper.getInstance().sendNetworkRequest(paramString1, paramString2, paramHashMap, paramIYtSDKKitNetResponseParser);
    AppMethodBeat.o(186617);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(186625);
    Object localObject1;
    JSONObject localJSONObject;
    if (((paramq instanceof u)) || ((paramq instanceof v)))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.plugin.flash.c.b.dLi().erf = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramInt2));
      com.tencent.mm.plugin.flash.c.b.dLi().eqT = paramInt2;
      this.wIr = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (com.tencent.mm.plugin.facedetect.b.b)paramq;
        this.sQI = ((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSK();
        paramString = YTAGFaceReflectForWXJNIInterface.decrypt(this.sQI, ((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSL(), ((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSL().length);
        paramq = new HashMap();
        localJSONObject = new JSONObject();
      }
    }
    label771:
    label1581:
    for (;;)
    {
      Object localObject2;
      try
      {
        localJSONObject.put("errorcode", 0);
        localJSONObject.put("errormsg", "OK");
        localJSONObject.put("type", 1);
        localJSONObject.put("smallface_ratio_threshold", ((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSM());
        localObject2 = new JSONObject();
        Log.i("MicroMsg.FaceFlashManagerData", "update smallface_ratio_threshold:%f", new Object[] { Float.valueOf(((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSM()) });
        ((JSONObject)localObject2).put("smallface_ratio_threshold", ((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSM());
        YtSDKKitFramework.getInstance().updateSDKSetting((JSONObject)localObject2);
        localObject2 = ((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSN();
        if (localObject2 != null) {}
        try
        {
          localJSONObject.put("select_data", new JSONObject(new String(((com.tencent.mm.plugin.facedetect.b.b)localObject1).cSN())));
          localObject1 = new JSONObject(paramString).optJSONArray("face_action_seq");
          if (localObject1 != null)
          {
            paramInt1 = 0;
            if (paramInt1 < ((JSONArray)localObject1).length())
            {
              localObject2 = ((JSONArray)localObject1).optJSONObject(paramInt1);
              if (localObject2 == null) {
                break label1581;
              }
              if (((JSONObject)localObject2).optInt("action_id", 0) == 6)
              {
                localJSONObject.put("data", ((JSONObject)localObject2).optString("action_data"));
                localJSONObject.put("color_data", ((JSONObject)localObject2).optString("action_data"));
              }
              if (((JSONObject)localObject2).optInt("action_id", 0) != 7) {
                break label1581;
              }
              localObject2 = ((JSONObject)localObject2).optString("action_data", "0");
              Log.i("MicroMsg.FaceFlashManagerData", "initPrepareTip :%s", new Object[] { localObject2 });
              if (!((String)localObject2).equals("1")) {
                break label591;
              }
              this.wIq = com.tencent.mm.cb.a.aI(this.activity, 2131760734);
              localJSONObject.put("action_data", localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerData", localException, "parse selectJson error", new Object[0]);
          continue;
        }
        if (!((String)localObject2).equals("2")) {
          break label619;
        }
      }
      catch (JSONException localJSONException2)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException2, "reflect get config error", new Object[0]);
        paramq.put("response", localJSONObject.toString());
        this.wIj.onNetworkResponseEvent(paramq, null);
        Log.i("MicroMsg.FaceFlashManagerData", "[sdk-info] mBioId:%s decryptConfig:%s retMap:%s", new Object[] { Long.valueOf(this.sQI), paramString, paramq });
        AppMethodBeat.o(186625);
        return;
      }
      label591:
      this.wIq = com.tencent.mm.cb.a.aI(this.activity, 2131760738);
      continue;
      label619:
      if (((String)localObject2).equals("3"))
      {
        this.wIq = com.tencent.mm.cb.a.aI(this.activity, 2131760737);
      }
      else if (((String)localObject2).equals("4"))
      {
        this.wIq = com.tencent.mm.cb.a.aI(this.activity, 2131760740);
      }
      else if (((String)localObject2).equals("5"))
      {
        this.wIq = com.tencent.mm.cb.a.aI(this.activity, 2131760741);
        continue;
        paramString = new HashMap();
        paramq = new JSONObject();
        try
        {
          paramq.put("errorcode", -1);
          paramq.put("errormsg", "WeChat get config error!");
          paramq.put("err_feedback", this.wIm);
          paramq.put("err_msg", com.tencent.mm.cb.a.aI(this.activity, 2131763495));
          paramString.put("response", paramq.toString());
          this.wIj.onNetworkResponseEvent(paramString, null);
          Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
          AppMethodBeat.o(186625);
          return;
          if ((paramq instanceof d.a))
          {
            com.tencent.mm.plugin.flash.c.b.dLi().erj = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramInt2));
            com.tencent.mm.plugin.flash.c.b.dLi().eqV = paramInt2;
            if ((paramInt1 == 0) && (paramInt2 == 0)) {
              paramq = com.tencent.mm.plugin.flash.d.a.al(((d.a)paramq).result);
            }
          }
          try
          {
            paramq.put("errorcode", paramInt2);
            paramq.put("error_code", paramInt2);
            paramq.put("errormsg", paramString);
            label892:
            Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { paramq });
            paramString = new HashMap();
            paramString.put("response", paramq.toString());
            this.wIj.onNetworkResponseEvent(paramString, null);
            AppMethodBeat.o(186625);
            return;
            paramq = new JSONObject();
            try
            {
              paramq.put("errorcode", paramInt2);
              paramq.put("error_code", paramInt2);
              paramq.put("errormsg", paramString);
              paramq.put("err_type", 3);
              paramq.put("err_code", 90020);
              paramq.put("err_retry", true);
              paramq.put("err_msg", com.tencent.mm.cb.a.aI(this.activity, 2131766327));
              AppMethodBeat.o(186625);
              return;
            }
            catch (JSONException paramString)
            {
              AppMethodBeat.o(186625);
              return;
            }
            if ((paramq instanceof m))
            {
              Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneFacePicThirdVerifyFace errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
              com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramInt2));
              com.tencent.mm.plugin.flash.c.b.dLi().eqV = paramInt2;
              com.tencent.mm.plugin.flash.c.b.dLi().erj = System.currentTimeMillis();
              localJSONObject = new JSONObject();
              for (;;)
              {
                try
                {
                  localJSONObject.put("err_type", paramInt1);
                  localJSONObject.put("err_code", paramInt2);
                  localJSONObject.put("verify_result", ((m)paramq).sPY);
                  localJSONObject.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.e)paramq).cSO());
                  if ((paramInt1 != 0) || (paramInt2 != 0)) {
                    continue;
                  }
                  localJSONObject.put("err_msg", paramString);
                  localJSONObject.put("key_app_id", this.mAppId);
                  localJSONObject.put("errorcode", paramInt2);
                  localJSONObject.put("error_code", paramInt2);
                  localJSONObject.put("errormsg", paramString);
                  com.tencent.mm.plugin.flash.c.a.MU(dKV());
                }
                catch (JSONException paramString)
                {
                  continue;
                }
                Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { localJSONObject });
                paramString = new HashMap();
                paramString.put("response", localJSONObject.toString());
                this.wIj.onNetworkResponseEvent(paramString, null);
                AppMethodBeat.o(186625);
                return;
                localJSONObject.put("errorcode", paramInt2);
                localJSONObject.put("error_code", paramInt2);
                localJSONObject.put("errormsg", "WeChat face verify error!");
                localJSONObject.put("err_feedback", this.wIm);
                localJSONObject.put("err_msg", paramString);
                com.tencent.mm.plugin.flash.c.a.MV(dKV());
              }
            }
            if ((paramq instanceof com.tencent.mm.plugin.facedetect.b.e))
            {
              com.tencent.mm.plugin.flash.c.b.dLi().erj = System.currentTimeMillis();
              com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramInt2));
              com.tencent.mm.plugin.flash.c.b.dLi().eqV = paramInt2;
              localJSONObject = new JSONObject();
              com.tencent.mm.plugin.facedetect.b.e locale = (com.tencent.mm.plugin.facedetect.b.e)paramq;
              new Bundle().putString(this.wIp.getResultKey(), locale.cSP());
              try
              {
                localJSONObject.put("errorcode", paramInt2);
                localJSONObject.put("error_code", paramInt2);
                localJSONObject.put("errormsg", paramString);
                localJSONObject.put("err_type", 2);
                localJSONObject.put("err_code", paramInt2);
                localJSONObject.put("err_msg", paramString);
                localJSONObject.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.e)paramq).cSO());
                Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { localJSONObject });
                paramString = new HashMap();
                paramString.put("response", localJSONObject.toString());
                this.wIj.onNetworkResponseEvent(paramString, null);
                AppMethodBeat.o(186625);
                return;
              }
              catch (JSONException paramString) {}
            }
            AppMethodBeat.o(186625);
            return;
          }
          catch (JSONException paramString)
          {
            break label892;
          }
        }
        catch (JSONException localJSONException1)
        {
          break label771;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void r(TextView paramTextView)
  {
    AppMethodBeat.i(186630);
    paramTextView.setText(this.wIq);
    AppMethodBeat.o(186630);
  }
  
  public void release()
  {
    AppMethodBeat.i(186620);
    dLa();
    com.tencent.mm.kernel.g.azz().b(732, this);
    com.tencent.mm.kernel.g.azz().b(this.wIp.getType(), this);
    com.tencent.mm.kernel.g.azz().b(733, this);
    AppMethodBeat.o(186620);
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.a
 * JD-Core Version:    0.7.0.1
 */