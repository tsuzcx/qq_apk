package com.tencent.mm.plugin.facedetectaction.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.b.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.k;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.protocal.protobuf.cjr;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

public final class c
  implements com.tencent.mm.am.h
{
  public static c zZJ;
  int hPm;
  public String hYA;
  String hYB;
  String hYC;
  String hYD;
  String hYz;
  public MMActivity lzt;
  public int mStatus = 0;
  public int nLz;
  String packageName;
  private String personId;
  int scene;
  MMHandler workerHandler;
  private String zTa;
  b zZK;
  private d zZL;
  private float zZM;
  private String zZN;
  public a zZO;
  public int zZP;
  public int zZQ;
  public FaceActionUI zZR;
  public boolean zZS = false;
  
  static
  {
    AppMethodBeat.i(104222);
    zZJ = new c();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.flash.c.b.aDA("reqCfg");
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.hYz);
    com.tencent.mm.kernel.h.aZW().a(2696, this);
    com.tencent.mm.kernel.h.aZW().a(locala, 0);
    this.zZR = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(104217);
    if (this.workerHandler != null) {
      this.workerHandler.post(paramRunnable);
    }
    AppMethodBeat.o(104217);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104218);
    if (this.zZR != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.zZR.a("cancel", 90004, null, Boolean.valueOf(this.zZR.Aaz));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.zZR.a("cancel", 0, null, Boolean.valueOf(this.zZR.Aaz));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.zZR.a("cancel", 90006, null, Boolean.valueOf(this.zZR.Aaz));
      }
    }
    AppMethodBeat.o(104218);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(104216);
    Log.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramp instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      com.tencent.mm.kernel.h.aZW().b(2696, this);
      paramp = (com.tencent.mm.plugin.facedetectaction.a.a)paramp;
      com.tencent.mm.plugin.flash.c.b.F("errorType", paramInt1 + "#" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramp.zZp;
        com.tencent.mm.plugin.flash.c.b.fuP().ivq = paramString.wuz;
        com.tencent.mm.plugin.flash.c.b.F("rspCfg", Integer.valueOf(paramString.wuz));
        com.tencent.mm.plugin.flash.c.b.F("msgCfg", paramString.wuA);
        Log.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.wuz), paramString.wuA, paramString.action_data, Float.valueOf(paramString.aasn), paramString.Zji });
        if (paramString.wuz == 0)
        {
          this.personId = paramString.person_id;
          this.zTa = paramString.action_data;
          this.zZM = paramString.aasn;
          this.zZN = paramString.Zji;
          switch (Util.getInt(this.zTa, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.zZO == null) {
              break label725;
            }
            this.zZO.a(1, -1, "", "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.aaso;
          Log.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramp = this.zZK;
          MMActivity localMMActivity = this.lzt;
          b.tryLoadLibrary();
          if (!PluginFace.isEnabled()) {
            paramInt2 = 0;
          }
          while (paramInt2 == 0)
          {
            Log.i("MicroMsg.FaceCheckActionMgr", "init face actionsource failed");
            AppMethodBeat.o(104216);
            return;
            paramInt2 = com.tencent.ytcommon.a.a.dv(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2");
            Log.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
            paramp.liveType = paramInt1;
            if (paramInt2 != 0)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(917L, 57L, 1L, false);
              Log.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(q.n(k.dOX(), false) + "/");
              }
              Log.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(paramInt2) });
              if (paramInt2 != 0)
              {
                paramInt2 = 0;
                label535:
                if (paramInt2 == 0) {
                  break label682;
                }
                YTCommonExInterface.setAppBrightness(localMMActivity, 255);
                paramp.status = 1;
              }
              label682:
              for (paramInt2 = 1;; paramInt2 = 0)
              {
                paramp.zZG = new b.1(paramp);
                a.b.dPO().zZC = paramp.zZG;
                break;
                Object localObject = YTFaceTrack.getInstance().GetFaceDetectParam();
                ((YTFaceDetectParam)localObject).bigger_face_mode = true;
                ((YTFaceDetectParam)localObject).min_face_size = 50;
                YTFaceTrack.getInstance().SetFaceDetectParam((YTFaceDetectParam)localObject);
                localObject = YTFaceTrack.getInstance().GetFaceTrackParam();
                ((YTFaceTrackParam)localObject).need_pose_estimate = true;
                ((YTFaceTrackParam)localObject).detect_interval = 20;
                YTFaceTrack.getInstance().SetFaceTrackParam((YTFaceTrackParam)localObject);
                paramInt2 = YTPoseDetectInterface.initModel();
                if (paramInt2 != 0)
                {
                  Log.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(paramInt2)));
                  paramInt2 = 0;
                  break label535;
                }
                paramInt2 = 1;
                YTPoseDetectInterface.setSafetyLevel(1);
                break label535;
              }
            }
          }
          this.mStatus = 0;
          this.zZK.zZH = new b.a()
          {
            public final void a(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(104211);
              Log.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              if (paramAnonymousArrayOfByte != null) {
                c.a(c.this, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              }
              AppMethodBeat.o(104211);
            }
          };
          if (this.zZO != null) {
            this.zZO.bq(paramInt1, paramString);
          }
          label725:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.zZO != null) {
          this.zZO.a(1, paramString.wuz, paramString.wuA, "", 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      Log.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.zZO != null) {
        this.zZO.a(1, paramInt2, paramString, "", 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramp instanceof com.tencent.mm.plugin.facedetectaction.a.c))
    {
      paramp = (com.tencent.mm.plugin.facedetectaction.a.c)paramp;
      com.tencent.mm.kernel.h.aZW().b(2726, this);
      paramp = paramp.zZt;
      Log.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s serialId:%s", new Object[] { Integer.valueOf(paramp.wuz), paramp.wuA, paramp.aasu });
      com.tencent.mm.plugin.flash.c.b.F("rspVerify", Integer.valueOf(paramp.wuz));
      com.tencent.mm.plugin.flash.c.b.F("msgVerify", paramp.wuA);
      com.tencent.mm.plugin.flash.c.b.fuP().ivs = paramp.wuz;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp.wuz != 0)
        {
          if (this.zZO != null)
          {
            this.zZO.a(3, paramp.wuz, paramp.wuA, paramp.aasu, paramp.aast);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          Log.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.zZO != null)
          {
            this.zZO.a(paramp);
            this.mStatus = 2;
            AppMethodBeat.o(104216);
          }
        }
      }
      else
      {
        Log.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
        if (this.zZO != null) {
          this.zZO.a(3, paramInt2, paramString, paramp.aasu, 1);
        }
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    Log.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.zZK != null)
    {
      b.release();
      this.zZK = new b();
    }
    if (this.zZL != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.dPv().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.dPv().dPx();
      }
      this.zZL = null;
    }
    if (paramBoolean)
    {
      if (this.workerHandler != null)
      {
        this.workerHandler.getSerial().ahCy.quit();
        this.workerHandler = null;
      }
      zZJ = new c();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
    
    public abstract void a(cjv paramcjv);
    
    public abstract void bq(int paramInt, String paramString);
    
    public abstract void dPP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.model.c
 * JD-Core Version:    0.7.0.1
 */