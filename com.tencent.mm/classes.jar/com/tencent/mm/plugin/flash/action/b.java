package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.g.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.flash.b.a
{
  boolean HiQ = false;
  private int Hit = 0;
  private long Hiu = 0L;
  private String hYA = "";
  private String hYz;
  private String packageName;
  private String personId;
  private String zTa;
  private float zZM;
  private String zZN;
  private boolean zZS = false;
  private byte[] zZX;
  
  private void I(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(264765);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.plugin.flash.c.b.fuP().ivK = 3;
      localJSONObject.put("errorcode", paramInt);
      localJSONObject.put("err_code", paramInt);
      localJSONObject.put("err_msg", paramString1);
      localJSONObject.put("err_feedback", this.Hjb);
      localJSONObject.put("otherVerifyTitle", this.hYA);
      paramString1 = new HashMap();
      paramString1.put("response", localJSONObject.toString());
      this.HiY.onNetworkResponseEvent(paramString1, null);
      Log.e("MicroMsg.FaceFlashActionReflectManager", "packageErrorResult get mBioId failed：%s", new Object[] { paramString2 });
      AppMethodBeat.o(264765);
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
  
  public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(264825);
    Log.i("MicroMsg.FaceFlashActionReflectManager", " cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] ", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    int i;
    if (paramd == null)
    {
      i = -1;
      com.tencent.mm.plugin.flash.c.b.F("rspCdn", Integer.valueOf(i));
      com.tencent.mm.plugin.flash.c.b.fuP().ivr = i;
      com.tencent.mm.plugin.flash.c.b.fuP().ivt = (System.currentTimeMillis() - this.zZZ);
      if ((paramd == null) || (paramd.field_retCode != 0)) {
        break label216;
      }
      Log.i("MicroMsg.FaceFlashActionReflectManager", "cdnCallback upload video done. now upload");
      paramString = new com.tencent.mm.plugin.facedetectaction.a.c(this.personId, this.zTa, this.zZM, paramd.field_fileId, paramd.field_aesKey, this.scene, this.zZN, this.packageName, this.zZX, this.zZS, 2, this.zSK, this.longitude, this.latitude);
      h.aZW().a(2726, this);
      h.aZW().a(paramString, 0);
      com.tencent.mm.plugin.flash.c.b.aDA("reqVerify");
      com.tencent.mm.plugin.flash.c.b.fuP().ivu = (System.currentTimeMillis() - this.Hiu);
    }
    label216:
    while ((paramInt == 0) && (paramd == null))
    {
      AppMethodBeat.o(264825);
      return 0;
      i = paramd.field_retCode;
      break;
    }
    Log.i("MicroMsg.FaceFlashActionReflectManager", "cdnCallback sceneResult.field_retCode != 0");
    com.tencent.mm.plugin.flash.c.b.fuP().ivK = 5;
    paramString = new JSONObject();
    try
    {
      paramString.put("errorcode", 90020);
      paramc = com.tencent.mm.cd.a.bt(this.activity, a.i.msg_net_error);
      paramString.put("err_feedback", this.Hjb);
      paramString.put("err_msg", paramc);
      paramc = new HashMap();
      paramc.put("response", paramString.toString());
      this.HiY.onNetworkResponseEvent(paramc, null);
      AppMethodBeat.o(264825);
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
  
  public final void aDu(String paramString)
  {
    AppMethodBeat.i(264845);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "initPrepareTip :%s", new Object[] { paramString });
    paramString = paramString.split(",");
    if (paramString.length > 1) {}
    for (this.HiQ = true;; this.HiQ = false)
    {
      paramString = paramString[0];
      if (!paramString.equals("1")) {
        break;
      }
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_blink);
      AppMethodBeat.o(264845);
      return;
    }
    if (paramString.equals("2"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_open_mouth);
      AppMethodBeat.o(264845);
      return;
    }
    if (paramString.equals("3"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_nod_head);
      AppMethodBeat.o(264845);
      return;
    }
    if (paramString.equals("4"))
    {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_shake_head);
      AppMethodBeat.o(264845);
      return;
    }
    if (paramString.equals("5")) {
      this.Hjf = com.tencent.mm.cd.a.bt(this.activity, a.i.fl_act_silence);
    }
    AppMethodBeat.o(264845);
  }
  
  public final void c(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(264854);
    for (;;)
    {
      try
      {
        if ((!paramString.equals("fl_act_blink")) && (!paramString.equals("fl_act_open_mouth")) && (!paramString.equals("fl_act_shake_head")))
        {
          if (paramString.equals("fl_act_nod_head"))
          {
            break label182;
            if (i == 0)
            {
              Log.i("MicroMsg.FaceFlashActionReflectManager", "updateTipText tip failed : %s", new Object[] { paramString });
              AppMethodBeat.o(264854);
            }
          }
          else
          {
            if (System.currentTimeMillis() - this.Hjd < 1000L) {
              break label187;
            }
            this.Hjd = System.currentTimeMillis();
            i = 1;
            continue;
          }
          String str = com.tencent.mm.plugin.flash.d.a.aP(paramTextView.getContext(), paramString);
          Log.i("MicroMsg.FaceFlashActionReflectManager", "updateTipText tip succ :%s， res:%s", new Object[] { str, paramString });
          if (!TextUtils.isEmpty(str)) {
            paramTextView.setText(str);
          }
          AppMethodBeat.o(264854);
          return;
        }
      }
      catch (Exception paramTextView)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "updateTipText：%s", new Object[] { paramTextView.getMessage() });
        AppMethodBeat.o(264854);
        return;
      }
      label182:
      int i = 1;
      continue;
      label187:
      i = 0;
    }
  }
  
  public final int fuB()
  {
    return 3;
  }
  
  public final int fux()
  {
    return 18;
  }
  
  public final void h(Intent paramIntent, Activity paramActivity)
  {
    AppMethodBeat.i(264775);
    super.h(paramIntent, paramActivity);
    this.scene = paramIntent.getIntExtra("scene", 0);
    this.packageName = paramIntent.getStringExtra("package");
    this.hYz = paramIntent.getStringExtra("packageSign");
    this.zZS = paramIntent.getBooleanExtra("needContract", false);
    this.hYA = paramIntent.getStringExtra("otherVerifyTitle");
    Log.i("MicroMsg.FaceFlashActionReflectManager", "[%s]init data, packageName:%s scene：%s,packageSign:%s needSignContract:%s otherVerifyTitle:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(this.scene), this.packageName, this.hYz, Boolean.valueOf(this.zZS), this.hYA });
    aR(paramActivity);
    AppMethodBeat.o(264775);
  }
  
  public final void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    AppMethodBeat.i(264782);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "onNetworkRequestEvent  url:%s requestContent:%s requestHeaders:%s", new Object[] { paramString1, paramString2, paramHashMap });
    this.HiY = paramIYtSDKKitNetResponseParser;
    if (paramString1.contains("wechat_face_config"))
    {
      com.tencent.mm.plugin.flash.c.b.aDA("reqCfg");
      fuE();
      com.tencent.mm.plugin.flash.c.a.VH(18);
      com.tencent.mm.plugin.flash.c.b.VN(2);
      try
      {
        this.HiZ = new JSONObject(paramString2).getString("select_data");
        Log.i("MicroMsg.FaceFlashActionReflectManager", "requestFlashConfig getConfig selectData:%s", new Object[] { this.HiZ });
        paramString1 = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.hYz, 2, this.HiZ.getBytes());
        h.aZW().a(2696, this);
        h.aZW().a(paramString1, 0);
        AppMethodBeat.o(264782);
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
        fuF();
        com.tencent.mm.plugin.flash.c.a.VI(18);
        aDv(paramString2);
        AppMethodBeat.o(264782);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "action parse verify body error:%s", new Object[] { paramString1.getMessage() });
      }
    }
    AppMethodBeat.o(264782);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(264811);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "onSceneEnd：errType %s，errCode %s ，errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramp instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      Log.i("MicroMsg.FaceFlashActionReflectManager", "scene is getFaceCheckActionerrType");
      h.aZW().b(2696, this);
      com.tencent.mm.plugin.flash.c.b.F("rspCfg", Integer.valueOf(paramInt2));
      paramString = (com.tencent.mm.plugin.facedetectaction.a.a)paramp;
      com.tencent.mm.plugin.flash.c.b.fuP().ivq = paramInt2;
      this.Hit += 1;
      this.Hiu = System.currentTimeMillis();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = paramString.zZp;
        Log.i("MicroMsg.FaceFlashActionReflectManager", "response.ret_code:%s，response.ret_msg：%s bio_id：%s，response.action_data:%s response.color_data:%s response.select_data:%s", new Object[] { Integer.valueOf(paramp.wuz), paramp.wuA, Long.valueOf(paramp.aasp), paramp.action_data, paramp.color_data, paramp.aasm });
        if (paramp.wuz == 0)
        {
          this.personId = paramp.person_id;
          this.zTa = paramp.action_data;
          this.zZM = paramp.aasn;
          this.zZN = paramp.Zji;
          this.zSK = paramp.aasp;
          paramString = new JSONObject();
          for (;;)
          {
            try
            {
              paramString.put("errorcode", 0);
              paramString.put("err_msg", "OK");
              paramString.put("type", 1);
              com.tencent.mm.bx.b localb = paramp.aasm;
              if (localb == null) {}
            }
            catch (JSONException paramp)
            {
              Log.e("MicroMsg.FaceFlashActionReflectManager", "reflect get config error:%s", new Object[] { paramp.getMessage() });
              continue;
            }
            try
            {
              paramString.put("select_data", new JSONObject(new String(paramp.aasm.Op)));
              if (!Util.isNullOrNil(paramp.action_data))
              {
                aDu(paramp.action_data);
                paramString.put("action_data", paramp.action_data);
              }
              if (!Util.isNullOrNil(paramp.color_data)) {
                paramString.put("color_data", paramp.color_data);
              }
              paramp = new HashMap();
              paramp.put("response", paramString.toString());
              this.HiY.onNetworkResponseEvent(paramp, null);
              Log.i("MicroMsg.FaceFlashActionReflectManager", "[sdk-info] retMap:%s", new Object[] { paramp });
              AppMethodBeat.o(264811);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.FaceFlashActionReflectManager", "parse select_data fail:%s", new Object[] { localException.getMessage() });
            }
          }
        }
        I(paramp.wuz, paramp.wuA, "response.ret_code != 0");
        AppMethodBeat.o(264811);
        return;
      }
      I(90036, com.tencent.mm.cd.a.bt(this.activity, a.i.net_fetch_failed), "cgi failed");
      AppMethodBeat.o(264811);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.facedetectaction.a.c))
    {
      h.aZW().b(2726, this);
      paramp = ((com.tencent.mm.plugin.facedetectaction.a.c)paramp).zZt;
      Log.i("MicroMsg.FaceFlashActionReflectManager", "scene is getFaceCheckResult：ret_code: %s, ret_msg: %s serialId:%s retry:%s", new Object[] { Integer.valueOf(paramp.wuz), paramp.wuA, paramp.aasu, Integer.valueOf(paramp.aast) });
      com.tencent.mm.plugin.flash.c.b.F("rspVerify", Integer.valueOf(paramp.wuz));
      com.tencent.mm.plugin.flash.c.b.fuP().ivs = paramp.wuz;
      paramString = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramString.put("countFace", this.Hit);
        paramString.put("err_code", paramp.wuz);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          continue;
        }
        com.tencent.mm.plugin.flash.c.a.VJ(18);
        paramString.put("errorcode", paramp.wuz);
        paramString.put("error_code", paramp.wuz);
        paramString.put("errormsg", paramp.wuA);
        paramString.put("err_msg", "ok");
        paramString.put("token", paramp.ZpZ);
        paramString.put("serial_id", paramp.aasu);
        paramString.put("scene", this.scene);
        if (paramp.wuz != 0)
        {
          paramString.put("err_retry", paramp.aast);
          paramString.put("err_tip", paramp.wuA);
          paramString.put("err_msg", "fail");
          paramString.put("otherVerifyTitle", this.hYA);
        }
      }
      catch (JSONException paramp)
      {
        Log.e("MicroMsg.FaceFlashActionReflectManager", "NetSceneGetFaceCheckResult parse fail :%s", new Object[] { paramp.getMessage() });
        continue;
      }
      paramp = new HashMap();
      paramp.put("response", paramString.toString());
      this.HiY.onNetworkResponseEvent(paramp, null);
      AppMethodBeat.o(264811);
      return;
      com.tencent.mm.plugin.flash.c.a.VK(18);
      com.tencent.mm.plugin.flash.c.b.fuP().ivK = 4;
      paramString.put("errorcode", paramInt2);
      paramString.put("error_code", paramInt2);
      paramString.put("errormsg", paramp.wuA);
      paramString.put("otherVerifyTitle", this.hYA);
      paramString.put("err_code", paramInt2);
      paramString.put("err_retry", paramp.aast);
      paramString.put("err_msg", "fail");
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(264868);
    super.release();
    h.aZW().b(2696, this);
    h.aZW().b(2726, this);
    AppMethodBeat.o(264868);
  }
  
  public final void y(TextView paramTextView)
  {
    AppMethodBeat.i(264835);
    Log.i("MicroMsg.FaceFlashActionReflectManager", "init prepareVerifyTip:%s", new Object[] { this.Hjf });
    paramTextView.setText(this.Hjf);
    AppMethodBeat.o(264835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.b
 * JD-Core Version:    0.7.0.1
 */