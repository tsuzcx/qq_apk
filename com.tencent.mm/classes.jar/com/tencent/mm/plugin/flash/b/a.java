package com.tencent.mm.plugin.flash.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.bi;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.b.w;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.flash.e.d.a;
import com.tencent.mm.plugin.flash.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
  implements com.tencent.mm.an.i, g.a, g
{
  protected long BBA;
  private String BBB;
  protected YtSDKKitFramework.IYtSDKKitNetResponseParser BBs;
  protected String BBt;
  protected boolean BBu;
  protected String BBv;
  private int BBw;
  public long BBx;
  private com.tencent.mm.plugin.flash.e.a BBy;
  protected String BBz;
  protected Activity activity;
  private boolean isLogin;
  public float latitude;
  public float longitude;
  protected String mAppId;
  protected int scene;
  private b.a tCp;
  protected String verifyInfo;
  public long wDO;
  protected long wwE;
  protected float wws;
  private com.tencent.mm.modelgeo.d yUU;
  
  public a()
  {
    AppMethodBeat.i(194312);
    this.BBw = -1;
    this.BBx = -1L;
    com.tencent.mm.kernel.h.aHE();
    this.isLogin = com.tencent.mm.kernel.b.aGL();
    this.BBz = "";
    this.wDO = 0L;
    this.BBA = 0L;
    this.BBB = "";
    AppMethodBeat.o(194312);
  }
  
  private com.tencent.mm.i.g aHf(String paramString)
  {
    AppMethodBeat.i(194351);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.iUG = this;
    localg.field_mediaId = p.azD(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 1;
    localg.field_bzScene = 0;
    localg.field_largesvideo = 0;
    localg.hDp = 5;
    this.BBB = localg.field_mediaId;
    AppMethodBeat.o(194351);
    return localg;
  }
  
  private void bp(int paramInt, String paramString)
  {
    AppMethodBeat.i(194372);
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("err_type", 4);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("err_msg", paramString);
      localJSONObject.put("err_feedback", this.BBv);
      label79:
      localHashMap.put("response", localJSONObject.toString());
      this.BBs.onNetworkResponseEvent(localHashMap, null);
      AppMethodBeat.o(194372);
      return;
    }
    catch (JSONException paramString)
    {
      break label79;
    }
  }
  
  private void epE()
  {
    AppMethodBeat.i(194334);
    if (!TextUtils.isEmpty(this.BBB))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "cancelSendTask media id:%s", new Object[] { this.BBB });
      com.tencent.mm.aq.f.bkg().Vy(this.BBB);
      this.BBB = "";
    }
    AppMethodBeat.o(194334);
  }
  
  public int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(194346);
    if (paramd == null) {}
    for (int i = -1;; i = paramd.field_retCode)
    {
      com.tencent.mm.plugin.flash.c.b.s("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.epM().gmn = i;
      com.tencent.mm.plugin.flash.c.b.epM().gmp = (System.currentTimeMillis() - this.wDO);
      if (paramInt != -21005) {
        break;
      }
      Log.i("MicroMsg.FaceFlashManagerData", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(194346);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0) && (this.BBB.equals(paramString)))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramString = paramd.field_fileId;
      paramc = new Bundle();
      paramc.putString("key_pic_cdn_id", paramString);
      paramc.putString("key_cdn_aes_key", paramd.field_aesKey);
      com.tencent.mm.plugin.flash.c.b.aHi("reqVerify");
      com.tencent.mm.plugin.flash.c.b.Su(9);
      com.tencent.mm.plugin.flash.c.b.epM().gmB = System.currentTimeMillis();
      paramc = this.BBy;
      long l = this.wwE;
      paramd = paramd.field_aesKey;
      String str1 = this.mAppId;
      String str2 = this.verifyInfo;
      i = epF();
      float f = this.wws;
      if (this.BBu) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramc.a(l, paramString, paramd, str1, str2, i, f, paramInt, this);
        AppMethodBeat.o(194346);
        return 0;
      }
    }
    if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
    {
      Log.w("MicroMsg.FaceFlashManagerData", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      com.tencent.mm.plugin.flash.c.b.epM().gmH = 5;
      paramString = new HashMap();
      paramc = new JSONObject();
    }
    try
    {
      paramc.put("errorcode", 90020);
      paramd = com.tencent.mm.ci.a.ba(this.activity, a.i.msg_net_error);
      paramc.put("err_feedback", this.BBv);
      paramc.put("err_msg", paramd);
      label409:
      paramString.put("response", paramc.toString());
      this.BBs.onNetworkResponseEvent(paramString, null);
      AppMethodBeat.o(194346);
      return 0;
    }
    catch (JSONException paramd)
    {
      break label409;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  protected final void aHc(String paramString)
  {
    AppMethodBeat.i(194337);
    com.tencent.mm.plugin.flash.c.b.epM().gmq = (System.currentTimeMillis() - this.BBA);
    com.tencent.mm.plugin.flash.c.b.epN().gmq = (System.currentTimeMillis() - this.BBA);
    paramString = aHd(paramString);
    if ((TextUtils.isEmpty(paramString)) || (!u.agG(paramString)))
    {
      bp(90034, com.tencent.mm.ci.a.ba(this.activity, a.i.face_flash_save_file_error));
      AppMethodBeat.o(194337);
      return;
    }
    aHe(paramString);
    AppMethodBeat.o(194337);
  }
  
  protected String aHd(String paramString)
  {
    AppMethodBeat.i(194338);
    paramString = f.f(paramString, String.valueOf(this.wwE), this.mAppId, epz());
    AppMethodBeat.o(194338);
    return paramString;
  }
  
  protected final void aHe(String paramString)
  {
    AppMethodBeat.i(194339);
    paramString = aHf(paramString);
    com.tencent.mm.plugin.flash.c.b.aHi("reqCdn");
    this.wDO = System.currentTimeMillis();
    com.tencent.mm.plugin.flash.c.b.Su(8);
    if (!com.tencent.mm.aq.f.bkg().f(paramString))
    {
      Log.e("MicroMsg.FaceFlashManagerData", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString.field_mediaId });
      com.tencent.mm.plugin.flash.c.b.epM().gmH = 5;
      com.tencent.mm.plugin.flash.c.b.epN().gmH = 5;
      com.tencent.mm.plugin.flash.c.b.aHi("cdnFailTask");
      bp(90019, "face file add to cdn failed");
    }
    AppMethodBeat.o(194339);
  }
  
  protected final void aHg(String paramString)
  {
    AppMethodBeat.i(194390);
    Log.i("MicroMsg.FaceFlashManagerData", "initPrepareTip :%s", new Object[] { paramString });
    if (paramString.equals("1"))
    {
      this.BBz = com.tencent.mm.ci.a.ba(this.activity, a.i.fl_act_blink);
      AppMethodBeat.o(194390);
      return;
    }
    if (paramString.equals("2"))
    {
      this.BBz = com.tencent.mm.ci.a.ba(this.activity, a.i.fl_act_open_mouth);
      AppMethodBeat.o(194390);
      return;
    }
    if (paramString.equals("3"))
    {
      this.BBz = com.tencent.mm.ci.a.ba(this.activity, a.i.fl_act_nod_head);
      AppMethodBeat.o(194390);
      return;
    }
    if (paramString.equals("4"))
    {
      this.BBz = com.tencent.mm.ci.a.ba(this.activity, a.i.fl_act_shake_head);
      AppMethodBeat.o(194390);
      return;
    }
    if (paramString.equals("5")) {
      this.BBz = com.tencent.mm.ci.a.ba(this.activity, a.i.fl_act_silence);
    }
    AppMethodBeat.o(194390);
  }
  
  public final void av(Activity paramActivity)
  {
    AppMethodBeat.i(194391);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.k(paramActivity, "android.permission.ACCESS_FINE_LOCATION", false);
    if (!bool)
    {
      Log.i("MicroMsg.FaceFlashManagerData", "startGetLocation checkLocation: %s and ignore", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(194391);
      return;
    }
    if (this.yUU == null) {
      this.yUU = com.tencent.mm.modelgeo.d.blq();
    }
    if (this.tCp == null) {
      this.tCp = new b.a()
      {
        public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
        {
          AppMethodBeat.i(197579);
          Log.i("MicroMsg.FaceFlashManagerData", "onGetLocation isOk: %b, %s, %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean)
          {
            a.this.latitude = paramAnonymousFloat2;
            a.this.longitude = paramAnonymousFloat1;
            a.c(a.this).b(a.b(a.this));
          }
          AppMethodBeat.o(197579);
          return true;
        }
      };
    }
    this.yUU.a(this.tCp, true);
    AppMethodBeat.o(194391);
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    int i = 1;
    AppMethodBeat.i(194386);
    try
    {
      if (System.currentTimeMillis() - this.BBx >= 1000L) {
        this.BBx = System.currentTimeMillis();
      }
      while (i == 0)
      {
        AppMethodBeat.o(194386);
        return;
        i = 0;
      }
      String str = com.tencent.mm.plugin.flash.d.a.aO(paramTextView.getContext(), paramString);
      Log.i("MicroMsg.FaceFlashManagerData", "updateTipText res:%s tip:%s", new Object[] { paramString, str });
      if (!TextUtils.isEmpty(str)) {
        com.tencent.mm.plugin.flash.d.a.d(paramTextView, str);
      }
      AppMethodBeat.o(194386);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramTextView, "", new Object[0]);
      AppMethodBeat.o(194386);
    }
  }
  
  public final long dhO()
  {
    return this.wwE;
  }
  
  protected final void epC()
  {
    AppMethodBeat.i(194329);
    Log.i("MicroMsg.FaceFlashManagerData", "improveBrightness");
    if (this.activity == null)
    {
      AppMethodBeat.o(194329);
      return;
    }
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190905);
        YTCommonExInterface.setAppBrightness(a.this.activity, 255);
        AppMethodBeat.o(190905);
      }
    });
    AppMethodBeat.o(194329);
  }
  
  protected final void epD()
  {
    AppMethodBeat.i(194330);
    Log.i("MicroMsg.FaceFlashManagerData", "restoreBrightness %d", new Object[] { Integer.valueOf(this.BBw) });
    if (this.BBw > 0) {
      com.tencent.e.h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195442);
          if (a.this.activity != null) {
            YTCommonExInterface.setAppBrightness(a.this.activity, a.a(a.this));
          }
          AppMethodBeat.o(195442);
        }
      });
    }
    AppMethodBeat.o(194330);
  }
  
  public int epF()
  {
    return 4;
  }
  
  public final void epG()
  {
    AppMethodBeat.i(194387);
    this.BBx = System.currentTimeMillis();
    AppMethodBeat.o(194387);
  }
  
  public int epv()
  {
    return 8;
  }
  
  public int epz()
  {
    return 3;
  }
  
  public final JSONObject er(String paramString, int paramInt)
  {
    AppMethodBeat.i(194380);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("err_type", 1);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("err_feedback", this.BBv);
      localJSONObject.put("key_app_id", this.mAppId);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("err_msg", paramString);
      }
      label68:
      AppMethodBeat.o(194380);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      break label68;
    }
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(194321);
    this.activity = paramActivity;
    this.scene = paramIntent.getIntExtra("scene", 0);
    this.mAppId = paramIntent.getStringExtra("appId");
    this.verifyInfo = paramIntent.getStringExtra("request_verify_pre_info");
    this.BBu = paramIntent.getBooleanExtra("needVideo", false);
    this.BBv = paramIntent.getStringExtra("feedbackUrl");
    this.BBw = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness", 100);
    switch (this.scene)
    {
    default: 
      paramActivity = new com.tencent.mm.plugin.flash.e.b();
      this.BBy = paramActivity;
      paramIntent = paramIntent.getStringExtra("k_ticket");
      if (!Util.isNullOrNil(paramIntent))
      {
        Log.i("MicroMsg.FaceFlashManagerData", "has prepared ticket. force set");
        com.tencent.mm.plugin.facedetect.b.q.azA(paramIntent);
      }
      if (this.isLogin) {
        com.tencent.mm.kernel.h.aGY().a(732, this);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aGY().a(this.BBy.getType(), this);
      com.tencent.mm.plugin.flash.c.b.epM().jN(this.mAppId);
      Log.i("MicroMsg.FaceFlashManagerData", "[%s]intent data, scene:%s ,mAppId:%s verifyInfo:%s currentLight %s enterBrightness: %s isLogin:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(this.scene), this.mAppId, this.verifyInfo, Float.valueOf(this.wws), Integer.valueOf(this.BBw), Boolean.valueOf(this.isLogin) });
      AppMethodBeat.o(194321);
      return;
      paramActivity = new com.tencent.mm.plugin.flash.e.f();
      break;
      paramActivity = new e();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.h();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.c();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.g();
      break;
      paramActivity = new com.tencent.mm.plugin.flash.e.d();
      break;
      com.tencent.mm.kernel.h.aGY().a(733, this);
    }
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, final YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(194327);
    Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.BBs = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.epM().gmx = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.aHi("reqCfg");
      epC();
      Log.i("MicroMsg.FaceFlashManagerData", "requestConfig");
      com.tencent.mm.plugin.flash.c.b.Su(2);
      try
      {
        this.BBt = new JSONObject(paramString2).getString("select_data");
        Log.i("MicroMsg.FaceFlashManagerData", "getConfig selectData:%s", new Object[] { this.BBt });
        if (this.isLogin)
        {
          paramString1 = new v(this.scene, epv(), this.mAppId, this.verifyInfo, this.BBt.getBytes());
          com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
          com.tencent.mm.plugin.flash.c.a.So(epv());
          AppMethodBeat.o(194327);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString1, "reflect get yt config data error", new Object[0]);
          continue;
          paramString1 = new w(this.scene, epv(), this.mAppId, this.verifyInfo, this.BBt.getBytes());
          com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
        }
      }
    }
    if (paramString1.contains("wechat_face_verify"))
    {
      com.tencent.mm.plugin.flash.c.b.epM().gmA = System.currentTimeMillis();
      epD();
      aHc(paramString2);
      com.tencent.mm.plugin.flash.c.a.Sp(epv());
      AppMethodBeat.o(194327);
      return;
    }
    paramIYtSDKKitNetResponseParser = new YtSDKKitFramework.IYtSDKKitNetResponseParser()
    {
      public final void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
      {
        AppMethodBeat.i(196463);
        Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  result:%s", new Object[] { paramAnonymousHashMap });
        paramIYtSDKKitNetResponseParser.onNetworkResponseEvent(paramAnonymousHashMap, paramAnonymousException);
        AppMethodBeat.o(196463);
      }
    };
    YtSDKKitNetHelper.getInstance().sendNetworkRequest(paramString1, paramString2, paramHashMap, paramIYtSDKKitNetResponseParser);
    AppMethodBeat.o(194327);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(194366);
    Object localObject1;
    JSONObject localJSONObject;
    if (((paramq instanceof v)) || ((paramq instanceof w)))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.plugin.flash.c.b.epM().gmy = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramInt2));
      com.tencent.mm.plugin.flash.c.b.epM().gmm = paramInt2;
      this.BBA = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (com.tencent.mm.plugin.facedetect.b.c)paramq;
        this.wwE = ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhO();
        paramString = YTAGFaceReflectForWXJNIInterface.decrypt(this.wwE, ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhP(), ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhP().length);
        paramq = new HashMap();
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("errorcode", 0);
        localJSONObject.put("err_msg", "OK");
        localJSONObject.put("type", 1);
        localJSONObject.put("smallface_ratio_threshold", ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhQ());
        Object localObject2 = new JSONObject();
        Log.i("MicroMsg.FaceFlashManagerData", "update smallface_ratio_threshold:%f", new Object[] { Float.valueOf(((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhQ()) });
        ((JSONObject)localObject2).put("smallface_ratio_threshold", ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhQ());
        YtSDKKitFramework.getInstance().updateSDKSetting((JSONObject)localObject2);
        localObject2 = ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhR();
        if (localObject2 != null) {}
        try
        {
          localJSONObject.put("select_data", new JSONObject(new String(((com.tencent.mm.plugin.facedetect.b.c)localObject1).dhR())));
          localObject1 = new JSONObject(paramString).optJSONArray("face_action_seq");
          if (localObject1 != null)
          {
            paramInt1 = 0;
            if (paramInt1 < ((JSONArray)localObject1).length())
            {
              localObject2 = ((JSONArray)localObject1).optJSONObject(paramInt1);
              if (localObject2 == null) {
                break label1430;
              }
              if (((JSONObject)localObject2).optInt("action_id", 0) == 6)
              {
                localJSONObject.put("data", ((JSONObject)localObject2).optString("action_data"));
                localJSONObject.put("color_data", ((JSONObject)localObject2).optString("action_data"));
              }
              if (((JSONObject)localObject2).optInt("action_id", 0) != 7) {
                break label1430;
              }
              localObject2 = ((JSONObject)localObject2).optString("action_data", "0");
              aHg((String)localObject2);
              localJSONObject.put("action_data", localObject2);
            }
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerData", localException, "parse selectJson error", new Object[0]);
          continue;
        }
        paramString = new HashMap();
      }
      catch (JSONException localJSONException2)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", localJSONException2, "reflect get config error", new Object[0]);
        paramq.put("response", localJSONObject.toString());
        this.BBs.onNetworkResponseEvent(paramq, null);
        Log.i("MicroMsg.FaceFlashManagerData", "[sdk-info] mBioId:%s decryptConfig:%s retMap:%s", new Object[] { Long.valueOf(this.wwE), paramString, paramq });
        AppMethodBeat.o(194366);
        return;
      }
      paramq = new JSONObject();
      try
      {
        com.tencent.mm.plugin.flash.c.b.epM().gmH = 3;
        paramq.put("errorcode", 90036);
        paramq.put("err_feedback", this.BBv);
        paramq.put("err_msg", com.tencent.mm.ci.a.ba(this.activity, a.i.net_fetch_failed));
        label620:
        paramString.put("response", paramq.toString());
        this.BBs.onNetworkResponseEvent(paramString, null);
        Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
        AppMethodBeat.o(194366);
        return;
        if ((paramq instanceof d.a))
        {
          com.tencent.mm.plugin.flash.c.b.epM().gmC = System.currentTimeMillis();
          com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramInt2));
          com.tencent.mm.plugin.flash.c.b.epM().gmo = paramInt2;
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            paramq = com.tencent.mm.plugin.flash.d.a.af(((d.a)paramq).result);
          }
        }
        try
        {
          paramq.put("errorcode", paramInt2);
          paramq.put("error_code", paramInt2);
          paramq.put("err_msg", paramString);
          label741:
          Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { paramq });
          paramString = new HashMap();
          paramString.put("response", paramq.toString());
          this.BBs.onNetworkResponseEvent(paramString, null);
          AppMethodBeat.o(194366);
          return;
          paramString = new JSONObject();
          try
          {
            paramString.put("errorcode", paramInt2);
            paramString.put("error_code", paramInt2);
            paramString.put("err_type", 3);
            paramString.put("err_code", paramInt2);
            paramString.put("err_retry", true);
            paramString.put("err_msg", com.tencent.mm.ci.a.ba(this.activity, a.i.soter_face_err_msg_retry));
            AppMethodBeat.o(194366);
            return;
          }
          catch (JSONException paramString)
          {
            AppMethodBeat.o(194366);
            return;
          }
          if ((paramq instanceof n))
          {
            Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneFacePicThirdVerifyFace errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramInt2));
            com.tencent.mm.plugin.flash.c.b.epM().gmo = paramInt2;
            com.tencent.mm.plugin.flash.c.b.epM().gmC = System.currentTimeMillis();
            localJSONObject = new JSONObject();
            for (;;)
            {
              try
              {
                localJSONObject.put("err_type", paramInt1);
                localJSONObject.put("err_code", paramInt2);
                localJSONObject.put("err_tip", ((n)paramq).wvW);
                localJSONObject.put("verify_result", ((n)paramq).wvV);
                localJSONObject.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.f)paramq).dhS());
                if ((paramInt1 != 0) || (paramInt2 != 0)) {
                  continue;
                }
                localJSONObject.put("err_msg", paramString);
                localJSONObject.put("key_app_id", this.mAppId);
                localJSONObject.put("errorcode", paramInt2);
                localJSONObject.put("error_code", paramInt2);
                localJSONObject.put("err_msg", paramString);
                com.tencent.mm.plugin.flash.c.a.Sq(epv());
              }
              catch (JSONException paramString)
              {
                continue;
              }
              Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { localJSONObject });
              paramString = new HashMap();
              paramString.put("response", localJSONObject.toString());
              this.BBs.onNetworkResponseEvent(paramString, null);
              AppMethodBeat.o(194366);
              return;
              com.tencent.mm.plugin.flash.c.b.epM().gmH = 4;
              localJSONObject.put("errorcode", paramInt2);
              localJSONObject.put("error_code", paramInt2);
              localJSONObject.put("err_msg", com.tencent.mm.ci.a.ba(this.activity, a.i.jsapi_unknown_error));
              localJSONObject.put("err_feedback", this.BBv);
              localJSONObject.put("err_msg", paramString);
              com.tencent.mm.plugin.flash.c.a.Sr(epv());
            }
          }
          if ((paramq instanceof com.tencent.mm.plugin.facedetect.b.f))
          {
            com.tencent.mm.plugin.flash.c.b.epM().gmC = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramInt2));
            com.tencent.mm.plugin.flash.c.b.epM().gmo = paramInt2;
            localJSONObject = new JSONObject();
            com.tencent.mm.plugin.facedetect.b.f localf = (com.tencent.mm.plugin.facedetect.b.f)paramq;
            new Bundle().putString(this.BBy.epR(), localf.dhT());
            try
            {
              localJSONObject.put("errorcode", paramInt2);
              localJSONObject.put("error_code", paramInt2);
              localJSONObject.put("err_type", 2);
              localJSONObject.put("err_code", paramInt2);
              localJSONObject.put("err_msg", paramString);
              localJSONObject.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.f)paramq).dhS());
              Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { localJSONObject });
              paramString = new HashMap();
              paramString.put("response", localJSONObject.toString());
              this.BBs.onNetworkResponseEvent(paramString, null);
              AppMethodBeat.o(194366);
              return;
            }
            catch (JSONException paramString) {}
          }
          AppMethodBeat.o(194366);
          return;
        }
        catch (JSONException paramString)
        {
          break label741;
        }
      }
      catch (JSONException localJSONException1)
      {
        break label620;
      }
      label1430:
      paramInt1 += 1;
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(194333);
    epE();
    epD();
    com.tencent.mm.kernel.h.aGY().b(732, this);
    com.tencent.mm.kernel.h.aGY().b(this.BBy.getType(), this);
    com.tencent.mm.kernel.h.aGY().b(733, this);
    if (this.yUU != null) {
      this.yUU.b(this.tCp);
    }
    AppMethodBeat.o(194333);
  }
  
  public void reset()
  {
    AppMethodBeat.i(194332);
    com.tencent.mm.plugin.flash.c.b.epM().jN(this.mAppId);
    epE();
    AppMethodBeat.o(194332);
  }
  
  public void x(TextView paramTextView)
  {
    AppMethodBeat.i(194389);
    com.tencent.mm.plugin.flash.d.a.d(paramTextView, this.BBz);
    AppMethodBeat.o(194389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.a
 * JD-Core Version:    0.7.0.1
 */