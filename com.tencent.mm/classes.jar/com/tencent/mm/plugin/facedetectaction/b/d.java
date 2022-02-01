package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  public static d rpy;
  String dFT;
  public String dFU;
  public MMActivity fLP;
  public int huZ;
  public int mStatus = 0;
  String packageName;
  int requestCode;
  private String rhw;
  private e rpA;
  private String rpB;
  private float rpC;
  private String rpD;
  public a rpE;
  ap rpF;
  public int rpG;
  public int rpH;
  public boolean rpI = false;
  public FaceActionUI rpl;
  b rpz;
  int scene;
  
  static
  {
    AppMethodBeat.i(104222);
    rpy = new d();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dFT);
    com.tencent.mm.kernel.g.aiU().a(2696, this);
    com.tencent.mm.kernel.g.aiU().a(locala, 0);
    this.rpl = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(104217);
    if (this.rpF != null) {
      this.rpF.post(paramRunnable);
    }
    AppMethodBeat.o(104217);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104218);
    if (this.rpl != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.rpl.a("cancel", 90004, null, Boolean.valueOf(this.rpl.rqh));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.rpl.a("cancel", 90025, null, Boolean.valueOf(this.rpl.rqh));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.rpl.a("cancel", 90006, null, Boolean.valueOf(this.rpl.rqh));
      }
    }
    AppMethodBeat.o(104218);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(104216);
    ad.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      com.tencent.mm.kernel.g.aiU().b(2696, this);
      paramn = (com.tencent.mm.plugin.facedetectaction.a.a)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramn.rpf;
        ad.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.ozR), paramString.ozS, paramString.action_data, Float.valueOf(paramString.Gyi), paramString.FWx });
        if (paramString.ozR == 0)
        {
          this.rpB = paramString.person_id;
          this.rhw = paramString.action_data;
          this.rpC = paramString.Gyi;
          this.rpD = paramString.FWx;
          switch (bt.getInt(this.rhw, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.rpE == null) {
              break label663;
            }
            this.rpE.a(1, -1, "", "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.Gyj;
          ad.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramn = this.rpz;
          MMActivity localMMActivity = this.fLP;
          b.tryLoadLibrary();
          if (!PluginFace.isEnabled()) {
            paramInt2 = 0;
          }
          while (paramInt2 == 0)
          {
            ad.i("MicroMsg.FaceCheckActionMgr", "init face actionsource failed");
            AppMethodBeat.o(104216);
            return;
            paramInt2 = YTCommonInterface.initAuth(aj.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
            ad.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
            paramn.rpu = paramInt1;
            if (paramInt2 != 0)
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(917L, 57L, 1L, false);
              ad.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.k(p.ctl(), false) + "/");
              }
              ad.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(paramInt2) });
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
                paramn.rpv = new b.1(paramn);
                a.b.cum().rpq = paramn.rpv;
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
                  ad.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(paramInt2)));
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
          this.rpz.rpw = new b.a()
          {
            public final void a(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(104211);
              ad.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              if (paramAnonymousArrayOfByte != null) {
                d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              }
              AppMethodBeat.o(104211);
            }
          };
          if (this.rpE != null) {
            this.rpE.aW(paramInt1, paramString);
          }
          label663:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.rpE != null) {
          this.rpE.a(1, paramString.ozR, paramString.ozS, "", 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      ad.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.rpE != null) {
        this.rpE.a(1, paramInt2, paramString, "", 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.b))
    {
      paramn = (com.tencent.mm.plugin.facedetectaction.a.b)paramn;
      com.tencent.mm.kernel.g.aiU().b(2726, this);
      paramn = paramn.rph;
      ad.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s serialId:%s", new Object[] { Integer.valueOf(paramn.ozR), paramn.ozS, paramn.Gyp });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.ozR != 0)
        {
          if (this.rpE != null)
          {
            this.rpE.a(3, paramn.ozR, paramn.ozS, paramn.Gyp, paramn.Gyo);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          ad.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.rpE != null)
          {
            this.rpE.a(paramn);
            this.mStatus = 2;
            AppMethodBeat.o(104216);
          }
        }
      }
      else
      {
        ad.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
        if (this.rpE != null) {
          this.rpE.a(3, paramInt2, paramString, paramn.Gyp, 1);
        }
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    ad.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.rpz != null)
    {
      b.release();
      this.rpz = new b();
    }
    if (this.rpA != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.ctV().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.ctV().ctX();
      }
      this.rpA = null;
    }
    if (paramBoolean)
    {
      if (this.rpF != null)
      {
        this.rpF.getSerial().LVC.quit();
        this.rpF = null;
      }
      rpy = new d();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
    
    public abstract void a(bbf parambbf);
    
    public abstract void aW(int paramInt, String paramString);
    
    public abstract void cun();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */