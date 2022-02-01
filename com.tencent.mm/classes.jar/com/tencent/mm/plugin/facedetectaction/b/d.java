package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.a.c;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.bux;
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

public final class d
  implements i
{
  public static d wDy;
  String fSC;
  public String fSD;
  String fSE;
  String fSF;
  public MMActivity iXq;
  public int lgP;
  public int mStatus = 0;
  String packageName;
  private String personId;
  int requestCode;
  int scene;
  private e wDA;
  private float wDB;
  private String wDC;
  public a wDD;
  public int wDE;
  public int wDF;
  public FaceActionUI wDG;
  public boolean wDH = false;
  b wDz;
  MMHandler workerHandler;
  private String wwU;
  
  static
  {
    AppMethodBeat.i(104222);
    wDy = new d();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.flash.c.b.aHi("reqCfg");
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.fSC);
    com.tencent.mm.kernel.h.aGY().a(2696, this);
    com.tencent.mm.kernel.h.aGY().a(locala, 0);
    this.wDG = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void am(Runnable paramRunnable)
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
    if (this.wDG != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.wDG.a("cancel", 90004, null, Boolean.valueOf(this.wDG.wEo));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.wDG.a("cancel", 0, null, Boolean.valueOf(this.wDG.wEo));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.wDG.a("cancel", 90006, null, Boolean.valueOf(this.wDG.wEo));
      }
    }
    AppMethodBeat.o(104218);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(104216);
    Log.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      com.tencent.mm.kernel.h.aGY().b(2696, this);
      paramq = (com.tencent.mm.plugin.facedetectaction.a.a)paramq;
      com.tencent.mm.plugin.flash.c.b.s("errorType", paramInt1 + "#" + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramq.wDe;
        com.tencent.mm.plugin.flash.c.b.epN().gmm = paramString.tqa;
        com.tencent.mm.plugin.flash.c.b.s("rspCfg", Integer.valueOf(paramString.tqa));
        com.tencent.mm.plugin.flash.c.b.s("msgCfg", paramString.tqb);
        Log.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.tqa), paramString.tqb, paramString.action_data, Float.valueOf(paramString.TeT), paramString.SkY });
        if (paramString.tqa == 0)
        {
          this.personId = paramString.person_id;
          this.wwU = paramString.action_data;
          this.wDB = paramString.TeT;
          this.wDC = paramString.SkY;
          switch (Util.getInt(this.wwU, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.wDD == null) {
              break label725;
            }
            this.wDD.a(1, -1, "", "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.TeU;
          Log.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramq = this.wDz;
          MMActivity localMMActivity = this.iXq;
          b.tryLoadLibrary();
          if (!PluginFace.isEnabled()) {
            paramInt2 = 0;
          }
          while (paramInt2 == 0)
          {
            Log.i("MicroMsg.FaceCheckActionMgr", "init face actionsource failed");
            AppMethodBeat.o(104216);
            return;
            paramInt2 = com.tencent.ytcommon.a.a.dm(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2");
            Log.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
            paramq.liveType = paramInt1;
            if (paramInt2 != 0)
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(917L, 57L, 1L, false);
              Log.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.n(p.dim(), false) + "/");
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
                paramq.status = 1;
              }
              label682:
              for (paramInt2 = 1;; paramInt2 = 0)
              {
                paramq.wDv = new b.1(paramq);
                a.b.djd().wDr = paramq.wDv;
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
          this.wDz.wDw = new b.a()
          {
            public final void a(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(104211);
              Log.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              if (paramAnonymousArrayOfByte != null) {
                d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              }
              AppMethodBeat.o(104211);
            }
          };
          if (this.wDD != null) {
            this.wDD.aW(paramInt1, paramString);
          }
          label725:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.wDD != null) {
          this.wDD.a(1, paramString.tqa, paramString.tqb, "", 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      Log.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.wDD != null) {
        this.wDD.a(1, paramInt2, paramString, "", 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramq instanceof c))
    {
      paramq = (c)paramq;
      com.tencent.mm.kernel.h.aGY().b(2726, this);
      paramq = paramq.wDi;
      Log.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s serialId:%s", new Object[] { Integer.valueOf(paramq.tqa), paramq.tqb, paramq.Tfa });
      com.tencent.mm.plugin.flash.c.b.s("rspVerify", Integer.valueOf(paramq.tqa));
      com.tencent.mm.plugin.flash.c.b.s("msgVerify", paramq.tqb);
      com.tencent.mm.plugin.flash.c.b.epN().gmo = paramq.tqa;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq.tqa != 0)
        {
          if (this.wDD != null)
          {
            this.wDD.a(3, paramq.tqa, paramq.tqb, paramq.Tfa, paramq.TeZ);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          Log.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.wDD != null)
          {
            this.wDD.a(paramq);
            this.mStatus = 2;
            AppMethodBeat.o(104216);
          }
        }
      }
      else
      {
        Log.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
        if (this.wDD != null) {
          this.wDD.a(3, paramInt2, paramString, paramq.Tfa, 1);
        }
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    Log.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.wDz != null)
    {
      b.release();
      this.wDz = new b();
    }
    if (this.wDA != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.diK().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.diK().diM();
      }
      this.wDA = null;
    }
    if (paramBoolean)
    {
      if (this.workerHandler != null)
      {
        this.workerHandler.getSerial().Zxu.quit();
        this.workerHandler = null;
      }
      wDy = new d();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
    
    public abstract void a(bux parambux);
    
    public abstract void aW(int paramInt, String paramString);
    
    public abstract void dje();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */