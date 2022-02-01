package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.ytcommon.util.YTCommonInterface;

public final class d
  implements com.tencent.mm.ak.g
{
  public static d qFG;
  String dtT;
  public String dtU;
  public int hcR;
  public MMActivity iMV;
  public int mStatus = 0;
  String packageName;
  b qFH;
  private e qFI;
  private String qFJ;
  private float qFK;
  private String qFL;
  public a qFM;
  ao qFN;
  public int qFO;
  public int qFP;
  public FaceActionUI qFt;
  private String qxG;
  int requestCode;
  int scene;
  
  static
  {
    AppMethodBeat.i(104222);
    qFG = new d();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dtT);
    com.tencent.mm.kernel.g.agi().a(2696, this);
    com.tencent.mm.kernel.g.agi().a(locala, 0);
    this.qFt = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(104217);
    if (this.qFN != null) {
      this.qFN.post(paramRunnable);
    }
    AppMethodBeat.o(104217);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104218);
    if (this.qFt != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.qFt.a("cancel", 90004, null, Boolean.valueOf(this.qFt.qGo));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.qFt.a("cancel", 90025, null, Boolean.valueOf(this.qFt.qGo));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.qFt.a("cancel", 90006, null, Boolean.valueOf(this.qFt.qGo));
      }
    }
    AppMethodBeat.o(104218);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(104216);
    ac.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      com.tencent.mm.kernel.g.agi().b(2696, this);
      paramn = (com.tencent.mm.plugin.facedetectaction.a.a)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramn.qFo;
        ac.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.nWx), paramString.nWy, paramString.action_data, Float.valueOf(paramString.EPb), paramString.Epl });
        if (paramString.nWx == 0)
        {
          this.qFJ = paramString.person_id;
          this.qxG = paramString.action_data;
          this.qFK = paramString.EPb;
          this.qFL = paramString.Epl;
          switch (bs.getInt(this.qxG, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.qFM == null) {
              break label663;
            }
            this.qFM.a(1, -1, "", "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.EPc;
          ac.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramn = this.qFH;
          MMActivity localMMActivity = this.iMV;
          b.tryLoadLibrary();
          if (!PluginFace.isEnabled()) {
            paramInt2 = 0;
          }
          while (paramInt2 == 0)
          {
            ac.i("MicroMsg.FaceCheckActionMgr", "init face actionsource failed");
            AppMethodBeat.o(104216);
            return;
            paramInt2 = YTCommonInterface.initAuth(ai.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
            ac.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
            paramn.qFC = paramInt1;
            if (paramInt2 != 0)
            {
              h.wUl.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              h.wUl.idkeyStat(917L, 57L, 1L, false);
              ac.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.k(p.cnG(), false) + "/");
              }
              ac.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(paramInt2) });
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
                paramn.qFD = new b.1(paramn);
                a.b.coH().qFy = paramn.qFD;
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
                  ac.i("MicroMsg.FaceCheckActionEngine", "YTFaceTraceInterface.initModel failed，return:".concat(String.valueOf(paramInt2)));
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
          this.qFH.qFE = new b.a()
          {
            public final void a(byte[][] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
            {
              AppMethodBeat.i(104211);
              ac.i("MicroMsg.FaceCheckActionMgr", "onStartRecord, frameDatas: %s, width: %s, height: %s", new Object[] { paramAnonymousArrayOfByte, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              if (paramAnonymousArrayOfByte != null) {
                d.a(d.this, paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
              }
              AppMethodBeat.o(104211);
            }
          };
          if (this.qFM != null) {
            this.qFM.aT(paramInt1, paramString);
          }
          label663:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.qFM != null) {
          this.qFM.a(1, paramString.nWx, paramString.nWy, "", 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      ac.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.qFM != null) {
        this.qFM.a(1, paramInt2, paramString, "", 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.b))
    {
      paramn = (com.tencent.mm.plugin.facedetectaction.a.b)paramn;
      com.tencent.mm.kernel.g.agi().b(2726, this);
      paramn = paramn.qFq;
      ac.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s serialId:%s", new Object[] { Integer.valueOf(paramn.nWx), paramn.nWy, paramn.EPh });
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn.nWx != 0)
        {
          if (this.qFM != null)
          {
            this.qFM.a(3, paramn.nWx, paramn.nWy, paramn.EPh, paramn.EPg);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          ac.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.qFM != null)
          {
            this.qFM.a(paramn);
            this.mStatus = 2;
            AppMethodBeat.o(104216);
          }
        }
      }
      else
      {
        ac.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
        if (this.qFM != null) {
          this.qFM.a(3, paramInt2, paramString, paramn.EPh, 1);
        }
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    ac.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.qFH != null)
    {
      b.release();
      this.qFH = new b();
    }
    if (this.qFI != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.coq().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.coq().cos();
      }
      this.qFI = null;
    }
    if (paramBoolean)
    {
      if (this.qFN != null)
      {
        this.qFN.getSerial().KbG.quit();
        this.qFN = null;
      }
      qFG = new d();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
    
    public abstract void a(axf paramaxf);
    
    public abstract void aT(int paramInt, String paramString);
    
    public abstract void coI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */