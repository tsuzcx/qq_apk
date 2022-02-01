package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.atx;
import com.tencent.mm.protocal.protobuf.atz;
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
  implements com.tencent.mm.al.g
{
  public static d pXb;
  String dwg;
  public String dwh;
  public int gCt;
  public MMActivity imP;
  public int mStatus = 0;
  private String pOY;
  public FaceActionUI pWO;
  b pXc;
  private e pXd;
  private String pXe;
  private float pXf;
  private String pXg;
  public a pXh;
  ap pXi;
  public int pXj;
  public int pXk;
  String packageName;
  int requestCode;
  int scene;
  
  static
  {
    AppMethodBeat.i(104222);
    pXb = new d();
    AppMethodBeat.o(104222);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(104215);
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.dwg);
    com.tencent.mm.kernel.g.aeS().a(2696, this);
    com.tencent.mm.kernel.g.aeS().a(locala, 0);
    this.pWO = paramFaceActionUI;
    AppMethodBeat.o(104215);
  }
  
  public final void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(104217);
    if (this.pXi != null) {
      this.pXi.post(paramRunnable);
    }
    AppMethodBeat.o(104217);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104218);
    if (this.pWO != null)
    {
      if ((this.mStatus == 0) || (this.mStatus == 1))
      {
        this.pWO.a("cancel", 90004, null, Boolean.valueOf(this.pWO.pXJ));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 2)
      {
        this.pWO.a("cancel", 90025, null, Boolean.valueOf(this.pWO.pXJ));
        AppMethodBeat.o(104218);
        return;
      }
      if (this.mStatus == 3) {
        this.pWO.a("cancel", 90006, null, Boolean.valueOf(this.pWO.pXJ));
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
      com.tencent.mm.kernel.g.aeS().b(2696, this);
      paramn = (com.tencent.mm.plugin.facedetectaction.a.a)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramn.pWJ;
        ad.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.ntx), paramString.nty, paramString.action_data, Float.valueOf(paramString.DtT), paramString.CWC });
        if (paramString.ntx == 0)
        {
          this.pXe = paramString.person_id;
          this.pOY = paramString.action_data;
          this.pXf = paramString.DtT;
          this.pXg = paramString.CWC;
          switch (bt.getInt(this.pOY, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.pXh == null) {
              break label661;
            }
            this.pXh.b(1, -1, "", 1);
            AppMethodBeat.o(104216);
            return;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.DtU;
          ad.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramn = this.pXc;
          MMActivity localMMActivity = this.imP;
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
            paramn.pWX = paramInt1;
            if (paramInt2 != 0)
            {
              h.vKh.idkeyStat(917L, 58L, 1L, false);
              paramInt2 = 0;
            }
            else
            {
              h.vKh.idkeyStat(917L, 57L, 1L, false);
              ad.i("MicroMsg.FaceCheckActionEngine", "initYoutuInstance()");
              paramInt2 = -1;
              if (PluginFace.isEnabled()) {
                paramInt2 = YTFaceTrack.GlobalInit(com.tencent.mm.b.q.k(p.cfZ(), false) + "/");
              }
              ad.i("MicroMsg.FaceCheckActionEngine", "YTPoseDetectInterface.initModel ret: %s", new Object[] { Integer.valueOf(paramInt2) });
              if (paramInt2 != 0)
              {
                paramInt2 = 0;
                label471:
                if (paramInt2 == 0) {
                  break label618;
                }
                YTCommonExInterface.setAppBrightness(localMMActivity, 255);
                paramn.status = 1;
              }
              label618:
              for (paramInt2 = 1;; paramInt2 = 0)
              {
                paramn.pWY = new b.1(paramn);
                a.b.cha().pWT = paramn.pWY;
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
                  break label471;
                }
                paramInt2 = 1;
                YTPoseDetectInterface.setSafetyLevel(2);
                break label471;
              }
            }
          }
          this.mStatus = 0;
          this.pXc.pWZ = new b.a()
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
          if (this.pXh != null) {
            this.pXh.aQ(paramInt1, paramString);
          }
          label661:
          AppMethodBeat.o(104216);
          return;
        }
        if (this.pXh != null) {
          this.pXh.b(1, paramString.ntx, paramString.nty, 1);
        }
        AppMethodBeat.o(104216);
        return;
      }
      ad.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.pXh != null) {
        this.pXh.b(1, paramInt2, paramString, 1);
      }
      AppMethodBeat.o(104216);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.facedetectaction.a.b))
    {
      paramn = (com.tencent.mm.plugin.facedetectaction.a.b)paramn;
      com.tencent.mm.kernel.g.aeS().b(2726, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramn.pWL;
        ad.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(paramString.ntx), paramString.nty });
        if (paramString.ntx != 0)
        {
          if (this.pXh != null)
          {
            this.pXh.b(3, paramString.ntx, paramString.nty, paramString.DtY);
            AppMethodBeat.o(104216);
          }
        }
        else
        {
          ad.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.pXh != null)
          {
            this.pXh.XP(paramString.Dbd);
            this.mStatus = 2;
          }
        }
        AppMethodBeat.o(104216);
        return;
      }
      ad.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
      if (this.pXh != null) {
        this.pXh.b(3, paramInt2, paramString, 1);
      }
    }
    AppMethodBeat.o(104216);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(104219);
    ad.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.pXc != null)
    {
      b.release();
      this.pXc = new b();
    }
    if (this.pXd != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.cgJ().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.cgJ().cgL();
      }
      this.pXd = null;
    }
    if (paramBoolean)
    {
      if (this.pXi != null)
      {
        this.pXi.getSerial().IzX.quit();
        this.pXi = null;
      }
      pXb = new d();
    }
    AppMethodBeat.o(104219);
  }
  
  public static abstract interface a
  {
    public abstract void XP(String paramString);
    
    public abstract void aQ(int paramInt, String paramString);
    
    public abstract void b(int paramInt1, int paramInt2, String paramString, int paramInt3);
    
    public abstract void chb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */