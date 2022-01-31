package com.tencent.mm.plugin.facedetectaction.b;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

public final class d
  implements f
{
  public static d jWf = new d();
  public MMActivity bER;
  int bQU;
  String bXA;
  public String bXB;
  private String jNY;
  public FaceActionUI jVN;
  public b jWg;
  private e jWh;
  private String jWi;
  private float jWj;
  private String jWk;
  public d.a jWl;
  HandlerThread jWm;
  ah jWn;
  public int jWo;
  public int jWp;
  public int jWq;
  public int mStatus = 0;
  String packageName;
  int scene;
  
  public final void H(Runnable paramRunnable)
  {
    if (this.jWn != null) {
      this.jWn.post(paramRunnable);
    }
  }
  
  public final void a(FaceActionUI paramFaceActionUI)
  {
    com.tencent.mm.plugin.facedetectaction.a.a locala = new com.tencent.mm.plugin.facedetectaction.a.a(this.scene, this.packageName, this.bXA);
    g.Dk().a(2696, this);
    g.Dk().a(locala, 0);
    this.jVN = paramFaceActionUI;
  }
  
  public final void onBackPressed()
  {
    if ((this.mStatus == 0) || (this.mStatus == 1)) {
      this.jVN.a("cancel", 90004, null, Boolean.valueOf(this.jVN.jWO));
    }
    do
    {
      return;
      if (this.mStatus == 2)
      {
        this.jVN.a("cancel", 90025, null, Boolean.valueOf(this.jVN.jWO));
        return;
      }
    } while (this.mStatus != 3);
    this.jVN.a("cancel", 90006, null, Boolean.valueOf(this.jVN.jWO));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FaceCheckActionMgr", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof com.tencent.mm.plugin.facedetectaction.a.a))
    {
      g.Dk().b(2696, this);
      paramm = (com.tencent.mm.plugin.facedetectaction.a.a)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = paramm.jVI;
        y.i("MicroMsg.FaceCheckActionMgr", "GetFaceCheckAction, ret_code: %s, ret_msg: %s, action_data: %s, reduction_ratio: %s, take_message: %s", new Object[] { Integer.valueOf(paramString.ino), paramString.inp, paramString.tdA, Float.valueOf(paramString.tdB), paramString.sMC });
        if (paramString.ino == 0)
        {
          this.jWi = paramString.person_id;
          this.jNY = paramString.tdA;
          this.jWj = paramString.tdB;
          this.jWk = paramString.sMC;
          switch (bk.getInt(this.jNY, -1))
          {
          case 2: 
          case 4: 
          default: 
            paramInt1 = -1;
            if (paramInt1 == -1) {
              if (this.jWl != null) {
                this.jWl.a(1, -1, "", 1);
              }
            }
            break;
          }
        }
      }
    }
    label583:
    label617:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramInt1 = 0;
                break;
                paramInt1 = 1;
                break;
                paramInt1 = 2;
                break;
                paramString = paramString.tdC;
                y.i("MicroMsg.FaceCheckActionMgr", "onGetLiveTypeFinish, liveType: %s, actionHint: %s", new Object[] { Integer.valueOf(paramInt1), paramString });
                paramm = this.jWg;
                MMActivity localMMActivity = this.bER;
                paramInt2 = YTCommonExInterface.initAuth(ae.getContext(), "rel_wechat_2055-12-06.lic1.2", 0, false);
                y.i("MicroMsg.FaceCheckActionEngine", "initAuth ret: %s", new Object[] { Integer.valueOf(paramInt2) });
                paramm.jWb = paramInt1;
                if (paramInt2 != 0) {
                  h.nFQ.a(917L, 58L, 1L, false);
                }
                for (;;)
                {
                  this.mStatus = 0;
                  this.jWg.jWd = new d.1(this);
                  if (this.jWl == null) {
                    break;
                  }
                  this.jWl.ah(paramInt1, paramString);
                  return;
                  h.nFQ.a(917L, 57L, 1L, false);
                  paramm.e(localMMActivity);
                  paramm.jWc = new b.1(paramm);
                }
              } while (this.jWl == null);
              this.jWl.a(1, paramString.ino, paramString.inp, 1);
              return;
              y.e("MicroMsg.FaceCheckActionMgr", "get face check action failed!");
            } while (this.jWl == null);
            this.jWl.a(1, paramInt2, paramString, 1);
            return;
          } while (!(paramm instanceof com.tencent.mm.plugin.facedetectaction.a.b));
          paramm = (com.tencent.mm.plugin.facedetectaction.a.b)paramm;
          g.Dk().b(2726, this);
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label617;
          }
          paramString = paramm.jVK;
          y.i("MicroMsg.FaceCheckActionMgr", "get face check result, ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(paramString.ino), paramString.inp });
          if (paramString.ino == 0) {
            break label583;
          }
        } while (this.jWl == null);
        this.jWl.a(3, paramString.ino, paramString.inp, paramString.tdG);
        return;
        y.i("MicroMsg.FaceCheckActionMgr", "on verify finish!");
      } while (this.jWl == null);
      this.jWl.Cu(paramString.sQc);
      this.mStatus = 2;
      return;
      y.e("MicroMsg.FaceCheckActionMgr", "get face check result failed");
    } while (this.jWl == null);
    this.jWl.a(3, paramInt2, paramString, 1);
  }
  
  public final void release(boolean paramBoolean)
  {
    y.i("MicroMsg.FaceCheckActionMgr", "release, recreate: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    b localb;
    if (this.jWg != null) {
      localb = this.jWg;
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
        y.printErrStackTrace("MicroMsg.FaceCheckActionEngine", localException, "release error", new Object[0]);
      }
    }
    this.jWg = new b();
    if (this.jWh != null)
    {
      if (com.tencent.mm.plugin.facedetect.e.a.aPj().isStarted()) {
        com.tencent.mm.plugin.facedetect.e.a.aPj().aPl();
      }
      this.jWh = null;
    }
    if (paramBoolean)
    {
      if (this.jWm != null)
      {
        this.jWm.quit();
        this.jWm = null;
        this.jWn = null;
      }
      jWf = new d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.d
 * JD-Core Version:    0.7.0.1
 */