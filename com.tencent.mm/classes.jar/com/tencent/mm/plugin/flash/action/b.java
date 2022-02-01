package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.flash.b.a
{
  private int BAV = 0;
  private long BAW = 0L;
  private String fSC;
  private String fSD = "";
  private String packageName;
  private String personId;
  private float wDB;
  private String wDC;
  private boolean wDH = false;
  private byte[] wDM;
  private String wwU;
  
  private void D(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194289);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.plugin.flash.c.b.epN().gmH = 3;
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("err_msg", paramString1);
      localJSONObject.put("err_feedback", this.BBv);
      localJSONObject.put("otherVerifyTitle", this.fSD);
      paramString1 = new HashMap();
      paramString1.put("response", localJSONObject.toString());
      this.BBs.onNetworkResponseEvent(paramString1, null);
      Log.e("MicroMsg.FaceFlashActionReflectManager", "packageErrorResult get mBioId failed：%s", new Object[] { paramString2 });
      AppMethodBeat.o(194289);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "packageErrorResult error:%s", new Object[] { paramString1.getMessage() });
      }
    }
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(194286);
    Log.i("MicroMsg.FaceFlashActionReflectManager", " cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] ", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    int i;
    if (paramd == null)
    {
      i = -1;
      com.tencent.mm.plugin.flash.c.b.s("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.epN().gmn = i;
      com.tencent.mm.plugin.flash.c.b.epN().gmp = (System.currentTimeMillis() - this.wDO);
      if ((paramd == null) || (paramd.field_retCode != 0)) {
        break label216;
      }
      Log.i("MicroMsg.FaceFlashActionReflectManager", "cdnCallback upload video done. now upload");
      paramString = new com.tencent.mm.plugin.facedetectaction.a.c(this.personId, this.wwU, this.wDB, paramd.field_fileId, paramd.field_aesKey, this.scene, this.wDC, this.packageName, this.wDM, this.wDH, 2, this.wwE, this.longitude, this.latitude);
      h.aGY().a(2726, this);
      h.aGY().a(paramString, 0);
      com.tencent.mm.plugin.flash.c.b.aHi("reqVerify");
      com.tencent.mm.plugin.flash.c.b.epN().gmq = (System.currentTimeMillis() - this.BAW);
    }
    label216:
    while ((paramInt == 0) && (paramd == null))
    {
      AppMethodBeat.o(194286);
      return 0;
      i = paramd.field_retCode;
      break;
    }
    Log.i("MicroMsg.FaceFlashActionReflectManager", "cdnCallback sceneResult.field_retCode != 0");
    com.tencent.mm.plugin.flash.c.b.epN().gmH = 5;
    paramString = new JSONObject();
    try
    {
      paramString.put("errorcode", 90020);
      paramc = com.tencent.mm.ci.a.ba(this.activity, a.i.msg_net_error);
      paramString.put("err_feedback", this.BBv);
      paramString.put("err_msg", paramc);
      paramc = new HashMap();
      paramc.put("response", paramString.toString());
      this.BBs.onNetworkResponseEvent(paramc, null);
      AppMethodBeat.o(194286);
      return 0;
    }
    catch (JSONException paramc)
    {
      for (;;)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "cdn callback error:%s", new Object[] { paramc.getMessage() });
      }
    }
  }
  
  public final void c(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(194294);
    try
    {
      if (System.currentTimeMillis() - this.BBx >= 1000L) {
        this.BBx = System.currentTimeMillis();
      }
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(194294);
        return;
      }
      String str = com.tencent.mm.plugin.flash.d.a.aO(paramTextView.getContext(), paramString);
      Log.i("MicroMsg.FaceFlashActionReflectManager", "updateTipText  tip:%s，res:%s", new Object[] { str, paramString });
      if (!TextUtils.isEmpty(str)) {
        paramTextView.setText(str);
      }
      AppMethodBeat.o(194294);
      return;
    }
    catch (Exception paramTextView)
    {
      Log.e("MicroMsg.FaceFlashActionReflectManager", "updateTipText：%s", new Object[] { paramTextView.getMessage() });
      AppMethodBeat.o(194294);
    }
  }
  
  public final int epv()
  {
    return 18;
  }
  
  public final int epz()
  {
    return 3;
  }
  
  public final void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(194256);
    super.h(paramIntent, paramActivity);
    this.scene = paramIntent.getIntExtra("scene", 0);
    this.packageName = paramIntent.getStringExtra("package");
    this.fSC = paramIntent.getStringExtra("packageSign");
    this.wDH = paramIntent.getBooleanExtra("needContract", false);
    this.fSD = paramIntent.getStringExtra("otherVerifyTitle");
    Log.i("MicroMsg.FaceFlashActionReflectManager", "[%s]init data, packageName:%s scene：%s,packageSign:%s needSignContract:%s otherVerifyTitle:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(this.scene), this.packageName, this.fSC, Boolean.valueOf(this.wDH), this.fSD });
    av(paramActivity);
    AppMethodBeat.o(194256);
  }
  
  public final void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(194261);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.BBs = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.aHi("reqCfg");
      epC();
      com.tencent.mm.plugin.flash.c.a.So(18);
      com.tencent.mm.plugin.flash.c.b.Su(2);
      try
      {
        this.BBt = new JSONObject(paramString2).getString("select_data");
        Log.i("MicroMsg.FaceFlashActionReflectManager", "requestFlashConfig getConfig selectData:%s", new Object[] { this.BBt });
        paramString1 = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.fSC, 2, this.BBt.getBytes());
        h.aGY().a(2696, this);
        h.aGY().a(paramString1, 0);
        AppMethodBeat.o(194261);
        return;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          Log.e("MicroMsg.FaceFlashActionReflectManager", "requestFlashConfig reflect get yt config data error : %s", new Object[] { paramString1.getMessage() });
        }
      }
    }
    if (paramString1.contains("wechat_face_verify")) {
      try
      {
        epD();
        com.tencent.mm.plugin.flash.c.a.Sp(18);
        aHc(paramString2);
        AppMethodBeat.o(194261);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "action parse verify body error:%s", new Object[] { paramString1.getMessage() });
      }
    }
    AppMethodBeat.o(194261);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(194277);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "onSceneEnd：errType %s，errCode %s ，errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      Log.i("MicroMsg.FaceFlashActionReflectManager", "scene is getFaceCheckActionerrType");
      h.aGY().b(2696, this);
      com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramInt2));
      paramString = (com.tencent.mm.plugin.facedetectaction.a.a)paramq;
      com.tencent.mm.plugin.flash.c.b.epN().gmm = paramInt2;
      this.BAV += 1;
      this.BAW = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = paramString.wDe;
        Log.i("MicroMsg.FaceFlashActionReflectManager", "response.ret_code:%s，response.ret_msg：%s bio_id：%s，response.action_data:%s response.color_data:%s response.select_data:%s", new Object[] { Integer.valueOf(paramq.tqa), paramq.tqb, Long.valueOf(paramq.TeV), paramq.action_data, paramq.color_data, paramq.TeS });
        if (paramq.tqa == 0)
        {
          this.personId = paramq.person_id;
          this.wwU = paramq.action_data;
          this.wDB = paramq.TeT;
          this.wDC = paramq.SkY;
          this.wwE = paramq.TeV;
          paramString = new JSONObject();
          for (;;)
          {
            try
            {
              paramString.put("errorcode", 0);
              paramString.put("err_msg", "OK");
              paramString.put("type", 1);
              com.tencent.mm.cd.b localb = paramq.TeS;
              if (localb == null) {}
            }
            catch (JSONException paramq)
            {
              Log.e("MicroMsg.FaceFlashActionReflectManager", "reflect get config error:%s", new Object[] { paramq.getMessage() });
              continue;
            }
            try
            {
              paramString.put("select_data", new JSONObject(new String(paramq.TeS.UH)));
              if (!Util.isNullOrNil(paramq.action_data))
              {
                aHg(paramq.action_data);
                paramString.put("action_data", paramq.action_data);
              }
              if (!Util.isNullOrNil(paramq.color_data)) {
                paramString.put("color_data", paramq.color_data);
              }
              paramq = new HashMap();
              paramq.put("response", paramString.toString());
              this.BBs.onNetworkResponseEvent(paramq, null);
              Log.i("MicroMsg.FaceFlashActionReflectManager", "[sdk-info] retMap:%s", new Object[] { paramq });
              AppMethodBeat.o(194277);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.FaceFlashActionReflectManager", "parse select_data fail:%s", new Object[] { localException.getMessage() });
            }
          }
        }
        D(paramq.tqa, paramq.tqb, "response.ret_code != 0");
        AppMethodBeat.o(194277);
        return;
      }
      D(90036, com.tencent.mm.ci.a.ba(this.activity, a.i.net_fetch_failed), "cgi failed");
      AppMethodBeat.o(194277);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.c))
    {
      h.aGY().b(2726, this);
      paramq = ((com.tencent.mm.plugin.facedetectaction.a.c)paramq).wDi;
      Log.i("MicroMsg.FaceFlashActionReflectManager", "scene is getFaceCheckResult：ret_code: %s, ret_msg: %s serialId:%s retry:%s", new Object[] { Integer.valueOf(paramq.tqa), paramq.tqb, paramq.Tfa, Integer.valueOf(paramq.TeZ) });
      com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramq.tqa));
      com.tencent.mm.plugin.flash.c.b.epN().gmo = paramq.tqa;
      paramString = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramString.put("countFace", this.BAV);
        paramString.put("err_code", paramq.tqa);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          continue;
        }
        com.tencent.mm.plugin.flash.c.a.Sq(18);
        paramString.put("errorcode", paramq.tqa);
        paramString.put("error_code", paramq.tqa);
        paramString.put("errormsg", paramq.tqb);
        paramString.put("err_msg", "ok");
        paramString.put("token", paramq.SqY);
        paramString.put("serial_id", paramq.Tfa);
        paramString.put("scene", this.scene);
        if (paramq.tqa != 0)
        {
          paramString.put("err_retry", paramq.TeZ);
          paramString.put("err_tip", paramq.tqb);
          paramString.put("err_msg", "fail");
          paramString.put("otherVerifyTitle", this.fSD);
        }
      }
      catch (JSONException paramq)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "NetSceneGetFaceCheckResult parse fail :%s", new Object[] { paramq.getMessage() });
        continue;
      }
      paramq = new HashMap();
      paramq.put("response", paramString.toString());
      this.BBs.onNetworkResponseEvent(paramq, null);
      AppMethodBeat.o(194277);
      return;
      com.tencent.mm.plugin.flash.c.a.Sr(18);
      com.tencent.mm.plugin.flash.c.b.epN().gmH = 4;
      paramString.put("errorcode", paramInt2);
      paramString.put("error_code", paramInt2);
      paramString.put("errormsg", paramq.tqb);
      paramString.put("otherVerifyTitle", this.fSD);
      paramString.put("err_code", paramInt2);
      paramString.put("err_retry", paramq.TeZ);
      paramString.put("err_msg", "fail");
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(194298);
    super.release();
    h.aGY().b(2696, this);
    h.aGY().b(2726, this);
    AppMethodBeat.o(194298);
  }
  
  public final void x(TextView paramTextView)
  {
    AppMethodBeat.i(194291);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "init prepareVerifyTip:%s", new Object[] { this.BBz });
    paramTextView.setText(this.BBz);
    AppMethodBeat.o(194291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.b
 * JD-Core Version:    0.7.0.1
 */