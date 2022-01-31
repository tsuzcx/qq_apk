package com.tencent.mm.plugin.facedetectaction.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.e.a.3;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

public final class d
  implements f
{
  public static d mqx;
  String cFw;
  public String cFx;
  public MMActivity cmc;
  public int fcn;
  public int mStatus = 0;
  private String mik;
  private String mqA;
  private float mqB;
  private String mqC;
  public d.a mqD;
  HandlerThread mqE;
  ak mqF;
  public int mqG;
  public int mqH;
  public FaceActionUI mqf;
  public b mqy;
  private e mqz;
  String packageName;
  int requestCode;
  int scene;
  
  static
  {
    AppMethodBeat.i(700);
    mqx = new d();
    AppMethodBeat.o(700);
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(695);
    if (this.mqF != null) {
      this.mqF.post(paramRunnable);
    }
    AppMethodBeat.o(695);
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    AppMethodBeat.i(693);
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.cFw);
    g.Rc().a(2696, this);
    g.Rc().a(locala, 0);
    this.mqf = paramFaceActionUI;
    AppMethodBeat.o(693);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(696);
    if ((this.mStatus == 0) || (this.mStatus == 1))
    {
      this.mqf.a("cancel", 90004, null, Boolean.valueOf(this.mqf.mrf));
      AppMethodBeat.o(696);
      return;
    }
    if (this.mStatus == 2)
    {
      this.mqf.a("cancel", 90025, null, Boolean.valueOf(this.mqf.mrf));
      AppMethodBeat.o(696);
      return;
    }
    if (this.mStatus == 3) {
      this.mqf.a("cancel", 90006, null, Boolean.valueOf(this.mqf.mrf));
    }
    AppMethodBeat.o(696);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(694);
    ab.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      g.Rc().b(2696, this);
      paramm = (com.tencent.mm.plugin.facedetectaction.a.a)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramm.mqa;
        ab.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.koj), paramString.kok, paramString.xby, Float.valueOf(paramString.xbz), paramString.wKp });
        if (paramString.koj == 0)
        {
          this.mqA = paramString.person_id;
          this.mik = paramString.xby;
          this.mqB = paramString.xbz;
          this.mqC = paramString.wKp;
          switch (bo.getInt(this.mik, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
          }
          while (paramInt1 == -1)
          {
            if (this.mqD == null) {
              break label393;
            }
            this.mqD.a(1, -1, "", 1);
            AppMethodBeat.o(694);
            return;
            paramInt1 = 0;
            continue;
            paramInt1 = 1;
            continue;
            paramInt1 = 2;
          }
          paramString = paramString.xbA;
          ab.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
          paramm = this.mqy;
          MMActivity localMMActivity = this.cmc;
          paramInt2 = YTCommonExInterface.initAuth(ah.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false);
          ab.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
          paramm.mqt = paramInt1;
          if (paramInt2 != 0) {
            h.qsU.idkeyStat(917L, 58L, 1L, false);
          }
          for (;;)
          {
            this.mStatus = 0;
            this.mqy.mqv = new d.1(this);
            if (this.mqD != null) {
              this.mqD.aA(paramInt1, paramString);
            }
            label393:
            AppMethodBeat.o(694);
            return;
            h.qsU.idkeyStat(917L, 57L, 1L, false);
            paramm.f(localMMActivity);
            paramm.mqu = new b.1(paramm);
          }
        }
        if (this.mqD != null) {
          this.mqD.a(1, paramString.koj, paramString.kok, 1);
        }
        AppMethodBeat.o(694);
        return;
      }
      ab.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
      if (this.mqD != null) {
        this.mqD.a(1, paramInt2, paramString, 1);
      }
      AppMethodBeat.o(694);
      return;
    }
    if ((paramm instanceof com.tencent.mm.plugin.facedetectaction.a.b))
    {
      paramm = (com.tencent.mm.plugin.facedetectaction.a.b)paramm;
      g.Rc().b(2726, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramm.mqc;
        ab.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(paramString.koj), paramString.kok });
        if (paramString.koj != 0)
        {
          if (this.mqD != null)
          {
            this.mqD.a(3, paramString.koj, paramString.kok, paramString.xbE);
            AppMethodBeat.o(694);
          }
        }
        else
        {
          ab.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
          if (this.mqD != null)
          {
            this.mqD.Nv(paramString.wOx);
            this.mStatus = 2;
          }
        }
        AppMethodBeat.o(694);
        return;
      }
      ab.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
      if (this.mqD != null) {
        this.mqD.a(3, paramInt2, paramString, 1);
      }
    }
    AppMethodBeat.o(694);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(697);
    ab.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    b localb;
    if (this.mqy != null) {
      localb = this.mqy;
    }
    try
    {
      if ((localb.status == 4) || (localb.status == 3) || (localb.status == 5)) {
        YTPoseDetectInterface.releaseModel();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.FaceCheckActionEngine", localException, "release error", new Object[0]);
      }
    }
    this.mqy = new b();
    if (this.mqz != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.bvo().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.bvo().bvq();
      }
      this.mqz = null;
    }
    if (paramBoolean)
    {
      if (this.mqE != null)
      {
        this.mqE.quit();
        this.mqE = null;
        this.mqF = null;
      }
      mqx = new d();
    }
    AppMethodBeat.o(697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */