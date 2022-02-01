package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.ytcommon.util.YTCommonInterface;

public final class d
  implements f
{
  public static d rxC;
  String dGY;
  public String dGZ;
  String dHa;
  public MMActivity fNT;
  public int hxN;
  public int mStatus = 0;
  String packageName;
  int requestCode;
  private String rpA;
  b rxD;
  private e rxE;
  private String rxF;
  private float rxG;
  private String rxH;
  public a rxI;
  aq rxJ;
  public int rxK;
  public int rxL;
  public boolean rxM = false;
  public FaceActionUI rxp;
  int scene;
  
  static
  {
    AppMethodBeat.i(104222);
    rxC = new d();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dGY);
    com.tencent.mm.kernel.g.ajj().a(2696, this);
    com.tencent.mm.kernel.g.ajj().a(locala, 0);
    this.rxp = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(104217);
    if (this.rxJ != null) {
      this.rxJ.post(paramRunnable);
    }
    AppMethodBeat.o(104217);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104218);
    if (this.rxp != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.rxp.a("cancel", 90004, null, Boolean.valueOf(this.rxp.ryl));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.rxp.a("cancel", 90025, null, Boolean.valueOf(this.rxp.ryl));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.rxp.a("cancel", 90006, null, Boolean.valueOf(this.rxp.ryl));
      }
    }
    AppMethodBeat.o(104218);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(104216);
    ae.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      com.tencent.mm.kernel.g.ajj().b(2696, this);
      paramn = (com.tencent.mm.plugin.facedetectaction.a.a)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramn.rxj;
        ae.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.oGt), paramString.oGu, paramString.action_data, Float.valueOf(paramString.GRI), paramString.GoW });
        if (paramString.oGt == 0)
        {
          this.rxF = paramString.person_id;
          this.rpA = paramString.action_data;
          this.rxG = paramString.GRI;
          this.rxH = paramString.GoW;
          switch (bu.getInt(this.rpA, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.rxI == null) {
              break label663;
            }
            this.rxI.a(1, -1, "", "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.GRJ;
          ae.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramn = this.rxD;
          MMActivity localMMActivity = this.fNT;
          b.tryLoadLibrary();
          if (!PluginFace.isEnabled()) {
            paramInt2 = 0;
          }
          while (paramInt2 == 0)
          {
            ae.i("MicroMsg.FaceCheckActionMgr", "init face actionsource failed");
            AppMethodBeat.o(104216);
            return;
            paramInt2 = YTCommonInterface.initAuth(ak.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
            ae.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
            paramn.rxy = paramInt1;
            if (paramInt2 != 0)
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 57L, 1L, false);
              ae.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.k(p.cuM(), false) + "/");
              }
              ae.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(paramInt2) });
              if (paramInt2 != 0)
              {
                paramInt2 = 0;
                label473:
                if (paramInt2 == 0) {
                  break label620;
                }
                YTCommonExInterface.setAppBrightness(localMMActivity, 255);
                paramn.status = 1;
              }
              label620:
              for (paramInt2 = 1;; paramInt2 = 0)
              {
                paramn.rxz = new b.1(paramn);
                a.b.cvN().rxu = paramn.rxz;
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
                  ae.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(paramInt2)));
                  paramInt2 = 0;
                  break label473;
                }
                paramInt2 = 1;
                YTPoseDetectInterface.setSafetyLevel(1);
                break label473;
              }
            }
          }
          this.mStatus = 0;
          this.rxD.rxA = new b.a()
          {
            public final void a(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(104211);
              ae.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              if (paramAnonymousArrayOfByte != null) {
                d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              }
              AppMethodBeat.o(104211);
            }
          };
          if (this.rxI != null) {
            this.rxI.aV(paramInt1, paramString);
          }
          label663:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.rxI != null) {
          this.rxI.a(1, paramString.oGt, paramString.oGu, "", 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      ae.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.rxI != null) {
        this.rxI.a(1, paramInt2, paramString, "", 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.b))
    {
      paramn = (com.tencent.mm.plugin.facedetectaction.a.b)paramn;
      com.tencent.mm.kernel.g.ajj().b(2726, this);
      paramn = paramn.rxl;
      ae.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s serialId:%s", new Object[] { Integer.valueOf(paramn.oGt), paramn.oGu, paramn.GRP });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.oGt != 0)
        {
          if (this.rxI != null)
          {
            this.rxI.a(3, paramn.oGt, paramn.oGu, paramn.GRP, paramn.GRO);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          ae.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.rxI != null)
          {
            this.rxI.a(paramn);
            this.mStatus = 2;
            AppMethodBeat.o(104216);
          }
        }
      }
      else
      {
        ae.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
        if (this.rxI != null) {
          this.rxI.a(3, paramInt2, paramString, paramn.GRP, 1);
        }
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    ae.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.rxD != null)
    {
      b.release();
      this.rxD = new b();
    }
    if (this.rxE != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.cvw().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.cvw().cvy();
      }
      this.rxE = null;
    }
    if (paramBoolean)
    {
      if (this.rxJ != null)
      {
        this.rxJ.getSerial().Msx.quit();
        this.rxJ = null;
      }
      rxC = new d();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
    
    public abstract void a(bbv parambbv);
    
    public abstract void aV(int paramInt, String paramString);
    
    public abstract void cvO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */