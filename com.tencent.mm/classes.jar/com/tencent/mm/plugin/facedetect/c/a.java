package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.b;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d giA = null;
  private Context mContext;
  private int rfF;
  protected com.tencent.mm.plugin.facedetect.b.d rfG = null;
  protected com.tencent.mm.plugin.facedetect.b.c rfH = null;
  protected WeakReference<f> rgB;
  protected boolean rgC = false;
  int rgD = -1;
  public int rgE;
  protected com.tencent.mm.plugin.facedetect.b.a rgF = null;
  protected boolean rgG = false;
  protected int rgH;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.rfF = paramInt1;
    this.rgB = new WeakReference(paramf);
    this.rgE = paramInt2;
    this.rgF = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, paramInt2);
    this.rgD = FaceDetectReporter.DL(paramInt1);
  }
  
  public final void DG(int paramInt)
  {
    this.rgH = paramInt;
  }
  
  protected final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.rgB == null) {}
    for (;;)
    {
      ad.i("MicroMsg.FaceDetectBaseController", "alvinluo finishWithResult mUIModel == null: %b", new Object[] { Boolean.valueOf(bool) });
      if ((this.rgB != null) && (this.rgB.get() != null)) {
        ((f)this.rgB.get()).a(paramInt1, paramInt2, paramString, paramBundle);
      }
      return;
      bool = false;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.c paramc)
  {
    if (this.rgF != null)
    {
      this.rfH = paramc;
      this.rgF.rfH = this.rfH;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.d paramd)
  {
    if (this.rgF != null)
    {
      this.rfG = paramd;
      this.rgF.rfG = paramd;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc)
  {
    if ((this.rgB != null) && (this.rgB.get() != null)) {
      ((f)this.rgB.get()).a(paramBoolean1, paramBoolean2, paramc);
    }
  }
  
  public abstract void aT(int paramInt, String paramString);
  
  public final void afU(String paramString)
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.rgF != null)
    {
      locala = this.rgF;
      if (!locala.rfJ)
      {
        locala.rfL = 1;
        if (!bt.isNullOrNil(paramString)) {
          break label48;
        }
        ad.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
        locala.s(4, 90011, "face file null");
      }
    }
    label48:
    com.tencent.mm.i.g localg;
    do
    {
      do
      {
        return;
        if (!i.fv(paramString))
        {
          ad.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
          locala.s(4, 90011, "get image failed");
          return;
        }
        if (locala.rfK == 0L)
        {
          ad.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
          locala.s(4, 90014, "uploadId not init");
          return;
        }
        ad.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[] { paramString });
      } while (locala.rfJ);
      localg = new com.tencent.mm.i.g();
      localg.fJi = "task_FaceUploadProcessor";
      localg.fJj = locala.rfR;
      localg.field_mediaId = p.afX(paramString);
      localg.field_fullpath = paramString;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.fIw;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_appType = 1;
      localg.field_bzScene = 0;
      localg.field_largesvideo = 0;
      localg.ePC = 5;
    } while (com.tencent.mm.ao.f.aGI().f(localg));
    ad.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
    locala.s(4, 90019, "add to cdn failed");
  }
  
  protected final void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if ((this.rgB != null) && (this.rgB.get() != null)) {
      ((f)this.rgB.get()).d(paramInt1, paramInt2, paramString, paramBundle);
    }
  }
  
  public final void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramInt == 0) && (!c(paramInt, paramString, paramBundle)))
    {
      ad.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
      this.rgC = true;
      if (this.rgG)
      {
        paramString = csL();
        if (paramString != null) {
          break label51;
        }
        ad.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
      }
    }
    label51:
    do
    {
      return;
      ad.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
      if (!this.rgC)
      {
        ad.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[] { Boolean.valueOf(this.rgC) });
        return;
      }
    } while (this.rgF == null);
    paramBundle = this.rgF;
    if (paramString == null)
    {
      ad.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
      return;
    }
    ad.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
    paramBundle.csB();
    paramBundle.rfN = paramString;
    paramBundle.rfL = 2;
    com.tencent.mm.kernel.g.aiU().a(paramString.getType(), paramBundle);
    com.tencent.mm.kernel.g.aiU().a(paramString, 0);
    paramBundle.rfO = System.currentTimeMillis();
  }
  
  public abstract void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract boolean c(int paramInt, String paramString, Bundle paramBundle);
  
  public final void csH()
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.rgF != null)
    {
      this.rgF.rfQ = this.rgE;
      locala = this.rgF;
      com.tencent.mm.kernel.g.ajA();
      locala.rfI = com.tencent.mm.kernel.a.aiJ();
      ad.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[] { Boolean.valueOf(locala.rfI) });
      if (!locala.rfI) {
        break label157;
      }
      com.tencent.mm.kernel.g.aiU().a(732, locala);
      locala = this.rgF;
      locala.rfK = 0L;
      locala.rfL = 0;
      if (locala.rfM != null) {
        com.tencent.mm.kernel.g.aiU().a(locala.rfM);
      }
      if (e.csR()) {
        e.vl(locala.rfK);
      }
      if (!locala.rfI) {
        break label170;
      }
    }
    label157:
    label170:
    for (locala.rfM = new u(locala.rfF, locala.rfQ);; locala.rfM = new v(locala.rfF, locala.rfQ))
    {
      com.tencent.mm.kernel.g.aiU().a(locala.rfM, 0);
      return;
      com.tencent.mm.kernel.g.aiU().a(733, locala);
      break;
    }
  }
  
  public final void csI()
  {
    if ((this.rgB != null) && (this.rgB.get() != null)) {
      ((f)this.rgB.get()).csI();
    }
    onStart();
  }
  
  public final long csJ()
  {
    if (this.rgF != null) {
      return this.rgF.rfK;
    }
    return -1L;
  }
  
  public final void csK()
  {
    ad.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
    if ((this.rgB != null) && (this.rgB.get() != null)) {
      ((f)this.rgB.get()).csK();
    }
    this.rgB = null;
    Object localObject = bt.getProcessNameByPid(aj.getContext(), Process.myPid());
    String str = aj.getPackageName();
    ad.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[] { localObject });
    boolean bool;
    if (((String)localObject).equalsIgnoreCase(str)) {
      if (this.rgF != null)
      {
        localObject = this.rgF;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).rfM != null) {
          break label201;
        }
        bool = true;
        ad.v("MicroMsg.FaceUploadProcessor", "alvinluo uinit mCurrentNetScene == null: %b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.facedetect.b.a)localObject).rfJ = true;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).rfM != null)
        {
          ad.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[] { ((com.tencent.mm.plugin.facedetect.b.a)localObject).rfM.getClass().getSimpleName() });
          com.tencent.mm.kernel.g.aiU().a(((com.tencent.mm.plugin.facedetect.b.a)localObject).rfM);
        }
        if (!((com.tencent.mm.plugin.facedetect.b.a)localObject).rfI) {
          break label206;
        }
        com.tencent.mm.kernel.g.aiU().b(732, (com.tencent.mm.al.f)localObject);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.facedetect.b.a)localObject).csB();
      this.rgF = null;
      onRelease();
      return;
      label201:
      bool = false;
      break;
      label206:
      com.tencent.mm.kernel.g.aiU().b(733, (com.tencent.mm.al.f)localObject);
    }
  }
  
  protected abstract n csL();
  
  public abstract Bundle csM();
  
  public abstract void f(int paramInt1, int paramInt2, String paramString, n paramn);
  
  public abstract void onRelease();
  
  protected abstract void onStart();
  
  public abstract void t(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */