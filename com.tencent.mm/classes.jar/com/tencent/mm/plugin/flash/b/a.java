package com.tencent.mm.plugin.flash.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.ce;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.q;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.b.w;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.flash.e.d.a;
import com.tencent.mm.plugin.flash.e.e;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
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
  implements com.tencent.mm.am.h, g.a, g
{
  protected YtSDKKitFramework.IYtSDKKitNetResponseParser HiY;
  protected String HiZ;
  protected boolean Hja;
  protected String Hjb;
  private int Hjc;
  public long Hjd;
  private com.tencent.mm.plugin.flash.e.a Hje;
  protected String Hjf;
  protected long Hjg;
  private String Hjh;
  private com.tencent.mm.modelgeo.d Hji;
  protected Activity activity;
  private boolean isLogin;
  public float latitude;
  public float longitude;
  protected String mAppId;
  protected int scene;
  protected String verifyInfo;
  private b.a wGt;
  protected long zSK;
  protected float zSy;
  public long zZZ;
  
  public a()
  {
    AppMethodBeat.i(264798);
    this.Hjc = -1;
    this.Hjd = -1L;
    com.tencent.mm.kernel.h.baC();
    this.isLogin = com.tencent.mm.kernel.b.aZM();
    this.Hjf = "";
    this.zZZ = 0L;
    this.Hjg = 0L;
    this.Hjh = "";
    AppMethodBeat.o(264798);
  }
  
  private com.tencent.mm.g.g aDy(String paramString)
  {
    AppMethodBeat.i(264817);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.lwL = this;
    localg.field_mediaId = com.tencent.mm.plugin.facedetect.model.k.atK(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.g.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.g.a.lvZ;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 1;
    localg.field_bzScene = 0;
    localg.field_largesvideo = 0;
    localg.hyY = 5;
    this.Hjh = localg.field_mediaId;
    AppMethodBeat.o(264817);
    return localg;
  }
  
  private void bT(int paramInt, String paramString)
  {
    AppMethodBeat.i(264834);
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("err_type", 4);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("error_code", paramInt);
      localJSONObject.put("err_msg", paramString);
      localJSONObject.put("err_feedback", this.Hjb);
      label79:
      localHashMap.put("response", localJSONObject.toString());
      this.HiY.onNetworkResponseEvent(localHashMap, null);
      AppMethodBeat.o(264834);
      return;
    }
    catch (JSONException paramString)
    {
      break label79;
    }
  }
  
  private void fuG()
  {
    AppMethodBeat.i(264806);
    if (!TextUtils.isEmpty(this.Hjh))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "cancelSendTask media id:%s", new Object[] { this.Hjh });
      com.tencent.mm.modelcdntran.k.bHW().Ny(this.Hjh);
      this.Hjh = "";
    }
    AppMethodBeat.o(264806);
  }
  
  public int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(264912);
    if (paramd == null) {}
    for (int i = -1;; i = paramd.field_retCode)
    {
      com.tencent.mm.plugin.flash.c.b.F("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.fuO().ivr = i;
      com.tencent.mm.plugin.flash.c.b.fuO().ivt = (System.currentTimeMillis() - this.zZZ);
      if (paramInt != -21005) {
        break;
      }
      Log.i("MicroMsg.FaceFlashManagerData", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      AppMethodBeat.o(264912);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0) && (this.Hjh.equals(paramString)))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      paramString = paramd.field_fileId;
      paramc = new Bundle();
      paramc.putString("key_pic_cdn_id", paramString);
      paramc.putString("key_cdn_aes_key", paramd.field_aesKey);
      com.tencent.mm.plugin.flash.c.b.aDA("reqVerify");
      com.tencent.mm.plugin.flash.c.b.VN(9);
      com.tencent.mm.plugin.flash.c.b.fuO().ivF = System.currentTimeMillis();
      paramc = this.Hje;
      long l = this.zSK;
      paramd = paramd.field_aesKey;
      String str1 = this.mAppId;
      String str2 = this.verifyInfo;
      i = fuH();
      float f = this.zSy;
      if (this.Hja) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramc.a(l, paramString, paramd, str1, str2, i, f, paramInt, this);
        AppMethodBeat.o(264912);
        return 0;
      }
    }
    if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
    {
      Log.w("MicroMsg.FaceFlashManagerData", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
      com.tencent.mm.plugin.flash.c.b.fuO().ivK = 5;
      paramString = new HashMap();
      paramc = new JSONObject();
    }
    try
    {
      paramc.put("errorcode", 90020);
      paramd = com.tencent.mm.cd.a.bt(this.activity, a.i.msg_net_error);
      paramc.put("err_feedback", this.Hjb);
      paramc.put("err_msg", paramd);
      label409:
      paramString.put("response", paramc.toString());
      this.HiY.onNetworkResponseEvent(paramString, null);
      AppMethodBeat.o(264912);
      return 0;
    }
    catch (JSONException paramd)
    {
      break label409;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  protected void aDu(String paramString)
  {
    AppMethodBeat.i(264928);
    Log.i("MicroMsg.FaceFlashManagerData", "initPrepareTip :%s", new Object[] { paramString });
    if (paramString.equals("1"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_blink);
      AppMethodBeat.o(264928);
      return;
    }
    if (paramString.equals("2"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_open_mouth);
      AppMethodBeat.o(264928);
      return;
    }
    if (paramString.equals("3"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_nod_head);
      AppMethodBeat.o(264928);
      return;
    }
    if (paramString.equals("4"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_shake_head);
      AppMethodBeat.o(264928);
      return;
    }
    if (paramString.equals("5")) {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_silence);
    }
    AppMethodBeat.o(264928);
  }
  
  protected final void aDv(String paramString)
  {
    AppMethodBeat.i(264903);
    com.tencent.mm.plugin.flash.c.b.fuO().ivu = (System.currentTimeMillis() - this.Hjg);
    com.tencent.mm.plugin.flash.c.b.fuP().ivu = (System.currentTimeMillis() - this.Hjg);
    paramString = aDw(paramString);
    if ((TextUtils.isEmpty(paramString)) || (!y.ZC(paramString)))
    {
      bT(90034, com.tencent.mm.cd.a.bt(this.activity, a.i.face_flash_save_file_error));
      AppMethodBeat.o(264903);
      return;
    }
    aDx(paramString);
    AppMethodBeat.o(264903);
  }
  
  protected String aDw(String paramString)
  {
    AppMethodBeat.i(264906);
    paramString = f.j(paramString, String.valueOf(this.zSK), this.mAppId, fuB());
    AppMethodBeat.o(264906);
    return paramString;
  }
  
  protected final void aDx(String paramString)
  {
    AppMethodBeat.i(264908);
    paramString = aDy(paramString);
    com.tencent.mm.plugin.flash.c.b.aDA("reqCdn");
    this.zZZ = System.currentTimeMillis();
    com.tencent.mm.plugin.flash.c.b.VN(8);
    if (!com.tencent.mm.modelcdntran.k.bHW().g(paramString))
    {
      Log.e("MicroMsg.FaceFlashManagerData", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { paramString.field_mediaId });
      com.tencent.mm.plugin.flash.c.b.fuO().ivK = 5;
      com.tencent.mm.plugin.flash.c.b.fuP().ivK = 5;
      com.tencent.mm.plugin.flash.c.b.aDA("cdnFailTask");
      bT(90019, "face file add to cdn failed");
    }
    AppMethodBeat.o(264908);
  }
  
  public final void aR(Activity paramActivity)
  {
    AppMethodBeat.i(264929);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.k(paramActivity, "android.permission.ACCESS_FINE_LOCATION", false);
    if (!bool)
    {
      Log.i("MicroMsg.FaceFlashManagerData", "startGetLocation checkLocation: %s and ignore", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(264929);
      return;
    }
    if (this.Hji == null) {
      this.Hji = com.tencent.mm.modelgeo.d.bJl();
    }
    if (this.wGt == null) {
      this.wGt = new b.a()
      {
        public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
        {
          AppMethodBeat.i(264760);
          Log.i("MicroMsg.FaceFlashManagerData", "onGetLocation isOk: %b, %s, %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Float.valueOf(paramAnonymousFloat2), Float.valueOf(paramAnonymousFloat1) });
          if (paramAnonymousBoolean)
          {
            a.this.latitude = paramAnonymousFloat2;
            a.this.longitude = paramAnonymousFloat1;
            a.c(a.this).a(a.b(a.this));
          }
          AppMethodBeat.o(264760);
          return true;
        }
      };
    }
    this.Hji.a(this.wGt, true, false);
    l.kK(22, 10);
    AppMethodBeat.o(264929);
  }
  
  public void c(TextView paramTextView, String paramString)
  {
    int j = 1;
    AppMethodBeat.i(264923);
    int i = j;
    for (;;)
    {
      try
      {
        if (!paramString.equals("fl_act_blink"))
        {
          i = j;
          if (!paramString.equals("fl_act_open_mouth"))
          {
            i = j;
            if (!paramString.equals("fl_act_shake_head"))
            {
              if (!paramString.equals("fl_act_nod_head")) {
                continue;
              }
              i = j;
            }
          }
        }
        if (i != 0) {
          break;
        }
        Log.i("MicroMsg.FaceFlashManagerData", "onFrameworkEvent tips: unable to change text: %s", new Object[] { paramString });
        AppMethodBeat.o(264923);
        return;
        if (System.currentTimeMillis() - this.Hjd >= 1000L)
        {
          this.Hjd = System.currentTimeMillis();
          i = j;
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramTextView)
      {
        Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramTextView, "", new Object[0]);
        AppMethodBeat.o(264923);
        return;
      }
    }
    String str = com.tencent.mm.plugin.flash.d.a.aP(paramTextView.getContext(), paramString);
    Log.i("MicroMsg.FaceFlashManagerData", "updateTipText res:%s tip:%s", new Object[] { paramString, str });
    if (!TextUtils.isEmpty(str)) {
      com.tencent.mm.plugin.flash.d.a.d(paramTextView, str);
    }
    AppMethodBeat.o(264923);
  }
  
  public final long dOz()
  {
    return this.zSK;
  }
  
  public final JSONObject fg(String paramString, int paramInt)
  {
    AppMethodBeat.i(264922);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("err_type", 1);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("err_feedback", this.Hjb);
      localJSONObject.put("key_app_id", this.mAppId);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("err_msg", paramString);
      }
      label68:
      AppMethodBeat.o(264922);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      break label68;
    }
  }
  
  public int fuB()
  {
    return 3;
  }
  
  protected final void fuE()
  {
    AppMethodBeat.i(264878);
    Log.i("MicroMsg.FaceFlashManagerData", "improveBrightness");
    if (this.activity == null)
    {
      AppMethodBeat.o(264878);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(264763);
        YTCommonExInterface.setAppBrightness(a.this.activity, 255);
        AppMethodBeat.o(264763);
      }
    });
    AppMethodBeat.o(264878);
  }
  
  protected final void fuF()
  {
    AppMethodBeat.i(264882);
    Log.i("MicroMsg.FaceFlashManagerData", "restoreBrightness %d", new Object[] { Integer.valueOf(this.Hjc) });
    if (this.Hjc > 0) {
      com.tencent.threadpool.h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(264762);
          if (a.this.activity != null) {
            YTCommonExInterface.setAppBrightness(a.this.activity, a.a(a.this));
          }
          AppMethodBeat.o(264762);
        }
      });
    }
    AppMethodBeat.o(264882);
  }
  
  public int fuH()
  {
    return 4;
  }
  
  public final void fuI()
  {
    AppMethodBeat.i(264926);
    this.Hjd = System.currentTimeMillis();
    AppMethodBeat.o(264926);
  }
  
  public int fux()
  {
    return 8;
  }
  
  public void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(264861);
    this.activity = paramActivity;
    this.scene = paramIntent.getIntExtra("scene", 0);
    this.mAppId = paramIntent.getStringExtra("appId");
    this.verifyInfo = paramIntent.getStringExtra("request_verify_pre_info");
    this.Hja = paramIntent.getBooleanExtra("needVideo", false);
    this.Hjb = paramIntent.getStringExtra("feedbackUrl");
    this.Hjc = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness", 100);
    switch (this.scene)
    {
    default: 
      paramActivity = new com.tencent.mm.plugin.flash.e.b();
      this.Hje = paramActivity;
      paramIntent = paramIntent.getStringExtra("k_ticket");
      if (!Util.isNullOrNil(paramIntent))
      {
        Log.i("MicroMsg.FaceFlashManagerData", "has prepared ticket. force set");
        q.atH(paramIntent);
      }
      if (this.isLogin) {
        com.tencent.mm.kernel.h.aZW().a(732, this);
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aZW().a(this.Hje.getType(), this);
      com.tencent.mm.plugin.flash.c.b.fuO().lv(this.mAppId);
      Log.i("MicroMsg.FaceFlashManagerData", "[%s]intent data, scene:%s ,mAppId:%s verifyInfo:%s currentLight %s enterBrightness: %s isLogin:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(this.scene), this.mAppId, this.verifyInfo, Float.valueOf(this.zSy), Integer.valueOf(this.Hjc), Boolean.valueOf(this.isLogin) });
      AppMethodBeat.o(264861);
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
      com.tencent.mm.kernel.h.aZW().a(733, this);
    }
  }
  
  public final byte[] h(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, final YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(264874);
    Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.HiY = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.fuO().ivB = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.aDA("reqCfg");
      fuE();
      Log.i("MicroMsg.FaceFlashManagerData", "requestConfig");
      com.tencent.mm.plugin.flash.c.b.VN(2);
      try
      {
        this.HiZ = new JSONObject(paramString2).getString("select_data");
        Log.i("MicroMsg.FaceFlashManagerData", "getConfig selectData:%s", new Object[] { this.HiZ });
        if (this.isLogin)
        {
          paramString1 = new v(this.scene, fux(), this.mAppId, this.verifyInfo, this.HiZ.getBytes());
          com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
          com.tencent.mm.plugin.flash.c.a.VH(fux());
          AppMethodBeat.o(264874);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FaceFlashManagerError", paramString1, "reflect get yt config data error", new Object[0]);
          continue;
          paramString1 = new w(this.scene, fux(), this.mAppId, this.verifyInfo, this.HiZ.getBytes());
          com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
        }
      }
    }
    if (paramString1.contains("wechat_face_verify"))
    {
      com.tencent.mm.plugin.flash.c.b.fuO().ivE = System.currentTimeMillis();
      fuF();
      aDv(paramString2);
      com.tencent.mm.plugin.flash.c.a.VI(fux());
      AppMethodBeat.o(264874);
      return;
    }
    paramIYtSDKKitNetResponseParser = new YtSDKKitFramework.IYtSDKKitNetResponseParser()
    {
      public final void onNetworkResponseEvent(HashMap<String, String> paramAnonymousHashMap, Exception paramAnonymousException)
      {
        AppMethodBeat.i(264766);
        Log.i("MicroMsg.FaceFlashManagerData", "onNetworkRequestEvent  result:%s", new Object[] { paramAnonymousHashMap });
        paramIYtSDKKitNetResponseParser.onNetworkResponseEvent(paramAnonymousHashMap, paramAnonymousException);
        AppMethodBeat.o(264766);
      }
    };
    YtSDKKitNetHelper.getInstance().sendNetworkRequest(paramString1, paramString2, paramHashMap, paramIYtSDKKitNetResponseParser);
    AppMethodBeat.o(264874);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(264919);
    Object localObject1;
    JSONObject localJSONObject;
    if (((paramp instanceof v)) || ((paramp instanceof w)))
    {
      Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneGetBioConfig errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.plugin.flash.c.b.fuO().ivC = System.currentTimeMillis();
      com.tencent.mm.plugin.flash.c.b.F("rspCfg", Integer.valueOf(paramInt2));
      com.tencent.mm.plugin.flash.c.b.fuO().ivq = paramInt2;
      this.Hjg = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (com.tencent.mm.plugin.facedetect.b.c)paramp;
        this.zSK = ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOz();
        paramString = YTAGFaceReflectForWXJNIInterface.decrypt(this.zSK, ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOA(), ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOA().length);
        paramp = new HashMap();
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
        localJSONObject.put("smallface_ratio_threshold", ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOB());
        Object localObject2 = new JSONObject();
        Log.i("MicroMsg.FaceFlashManagerData", "update smallface_ratio_threshold:%f", new Object[] { Float.valueOf(((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOB()) });
        ((JSONObject)localObject2).put("smallface_ratio_threshold", ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOB());
        YtSDKKitFramework.getInstance().updateSDKSetting((JSONObject)localObject2);
        localObject2 = ((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOC();
        if (localObject2 != null) {}
        try
        {
          localJSONObject.put("select_data", new JSONObject(new String(((com.tencent.mm.plugin.facedetect.b.c)localObject1).dOC())));
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
              aDu((String)localObject2);
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
        paramp.put("response", localJSONObject.toString());
        this.HiY.onNetworkResponseEvent(paramp, null);
        Log.i("MicroMsg.FaceFlashManagerData", "[sdk-info] mBioId:%s decryptConfig:%s retMap:%s", new Object[] { Long.valueOf(this.zSK), paramString, paramp });
        AppMethodBeat.o(264919);
        return;
      }
      paramp = new JSONObject();
      try
      {
        com.tencent.mm.plugin.flash.c.b.fuO().ivK = 3;
        paramp.put("errorcode", 90036);
        paramp.put("err_feedback", this.Hjb);
        paramp.put("err_msg", com.tencent.mm.cd.a.bt(this.activity, a.i.net_fetch_failed));
        label620:
        paramString.put("response", paramp.toString());
        this.HiY.onNetworkResponseEvent(paramString, null);
        Log.e("MicroMsg.FaceFlashManagerError", "get mBioId failed");
        AppMethodBeat.o(264919);
        return;
        if ((paramp instanceof d.a))
        {
          com.tencent.mm.plugin.flash.c.b.fuO().ivG = System.currentTimeMillis();
          com.tencent.mm.plugin.flash.c.b.F("rspVerify", Integer.valueOf(paramInt2));
          com.tencent.mm.plugin.flash.c.b.fuO().ivs = paramInt2;
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            paramp = com.tencent.mm.plugin.flash.d.a.ax(((d.a)paramp).result);
          }
        }
        try
        {
          paramp.put("errorcode", paramInt2);
          paramp.put("error_code", paramInt2);
          paramp.put("err_msg", paramString);
          label741:
          Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { paramp });
          paramString = new HashMap();
          paramString.put("response", paramp.toString());
          this.HiY.onNetworkResponseEvent(paramString, null);
          AppMethodBeat.o(264919);
          return;
          paramString = new JSONObject();
          try
          {
            paramString.put("errorcode", paramInt2);
            paramString.put("error_code", paramInt2);
            paramString.put("err_type", 3);
            paramString.put("err_code", paramInt2);
            paramString.put("err_retry", true);
            paramString.put("err_msg", com.tencent.mm.cd.a.bt(this.activity, a.i.soter_face_err_msg_retry));
            AppMethodBeat.o(264919);
            return;
          }
          catch (JSONException paramString)
          {
            AppMethodBeat.o(264919);
            return;
          }
          if ((paramp instanceof n))
          {
            Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]NetSceneFacePicThirdVerifyFace errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
            com.tencent.mm.plugin.flash.c.b.F("rspVerify", Integer.valueOf(paramInt2));
            com.tencent.mm.plugin.flash.c.b.fuO().ivs = paramInt2;
            com.tencent.mm.plugin.flash.c.b.fuO().ivG = System.currentTimeMillis();
            localJSONObject = new JSONObject();
            for (;;)
            {
              try
              {
                localJSONObject.put("err_type", paramInt1);
                localJSONObject.put("err_code", paramInt2);
                localJSONObject.put("err_tip", ((n)paramp).zSd);
                localJSONObject.put("verify_result", ((n)paramp).zSc);
                localJSONObject.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.f)paramp).dOD());
                if ((paramInt1 != 0) || (paramInt2 != 0)) {
                  continue;
                }
                localJSONObject.put("err_msg", paramString);
                localJSONObject.put("key_app_id", this.mAppId);
                localJSONObject.put("errorcode", paramInt2);
                localJSONObject.put("error_code", paramInt2);
                localJSONObject.put("err_msg", paramString);
                com.tencent.mm.plugin.flash.c.a.VJ(fux());
              }
              catch (JSONException paramString)
              {
                continue;
              }
              Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { localJSONObject });
              paramString = new HashMap();
              paramString.put("response", localJSONObject.toString());
              this.HiY.onNetworkResponseEvent(paramString, null);
              AppMethodBeat.o(264919);
              return;
              com.tencent.mm.plugin.flash.c.b.fuO().ivK = 4;
              localJSONObject.put("errorcode", paramInt2);
              localJSONObject.put("error_code", paramInt2);
              localJSONObject.put("err_msg", com.tencent.mm.cd.a.bt(this.activity, a.i.jsapi_unknown_error));
              localJSONObject.put("err_feedback", this.Hjb);
              localJSONObject.put("err_msg", paramString);
              com.tencent.mm.plugin.flash.c.a.VK(fux());
            }
          }
          if ((paramp instanceof com.tencent.mm.plugin.facedetect.b.f))
          {
            com.tencent.mm.plugin.flash.c.b.fuO().ivG = System.currentTimeMillis();
            com.tencent.mm.plugin.flash.c.b.F("rspVerify", Integer.valueOf(paramInt2));
            com.tencent.mm.plugin.flash.c.b.fuO().ivs = paramInt2;
            localJSONObject = new JSONObject();
            com.tencent.mm.plugin.facedetect.b.f localf = (com.tencent.mm.plugin.facedetect.b.f)paramp;
            new Bundle().putString(this.Hje.fuT(), localf.dOE());
            try
            {
              localJSONObject.put("errorcode", paramInt2);
              localJSONObject.put("error_code", paramInt2);
              localJSONObject.put("err_type", 2);
              localJSONObject.put("err_code", paramInt2);
              localJSONObject.put("err_msg", paramString);
              localJSONObject.put("err_retry", ((com.tencent.mm.plugin.facedetect.b.f)paramp).dOD());
              Log.i("MicroMsg.FaceFlashManagerData", "[cgi-ret]retContent:%s", new Object[] { localJSONObject });
              paramString = new HashMap();
              paramString.put("response", localJSONObject.toString());
              this.HiY.onNetworkResponseEvent(paramString, null);
              AppMethodBeat.o(264919);
              return;
            }
            catch (JSONException paramString) {}
          }
          AppMethodBeat.o(264919);
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
    AppMethodBeat.i(264891);
    fuG();
    fuF();
    com.tencent.mm.kernel.h.aZW().b(732, this);
    com.tencent.mm.kernel.h.aZW().b(this.Hje.getType(), this);
    com.tencent.mm.kernel.h.aZW().b(733, this);
    if (this.Hji != null) {
      this.Hji.a(this.wGt);
    }
    AppMethodBeat.o(264891);
  }
  
  public void reset()
  {
    AppMethodBeat.i(264887);
    com.tencent.mm.plugin.flash.c.b.fuO().lv(this.mAppId);
    fuG();
    AppMethodBeat.o(264887);
  }
  
  public void y(TextView paramTextView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.b.a
 * JD-Core Version:    0.7.0.1
 */