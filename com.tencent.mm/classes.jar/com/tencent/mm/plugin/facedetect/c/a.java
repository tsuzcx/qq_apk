package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.b;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d gkS = null;
  private Context mContext;
  private int rnI;
  protected com.tencent.mm.plugin.facedetect.b.d rnJ = null;
  protected com.tencent.mm.plugin.facedetect.b.c rnK = null;
  protected WeakReference<f> roF;
  protected boolean roG = false;
  int roH = -1;
  public int roI;
  protected com.tencent.mm.plugin.facedetect.b.a roJ = null;
  protected boolean roK = false;
  protected int roL;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.rnI = paramInt1;
    this.roF = new WeakReference(paramf);
    this.roI = paramInt2;
    this.roJ = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, paramInt2);
    this.roH = FaceDetectReporter.DY(paramInt1);
  }
  
  public final void DT(int paramInt)
  {
    this.roL = paramInt;
  }
  
  protected final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.roF == null) {}
    for (;;)
    {
      ae.i("MicroMsg.FaceDetectBaseController", "alvinluo finishWithResult mUIModel == null: %b", new Object[] { Boolean.valueOf(bool) });
      if ((this.roF != null) && (this.roF.get() != null)) {
        ((f)this.roF.get()).a(paramInt1, paramInt2, paramString, paramBundle);
      }
      return;
      bool = false;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.c paramc)
  {
    if (this.roJ != null)
    {
      this.rnK = paramc;
      this.roJ.rnK = this.rnK;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.d paramd)
  {
    if (this.roJ != null)
    {
      this.rnJ = paramd;
      this.roJ.rnJ = paramd;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc)
  {
    if ((this.roF != null) && (this.roF.get() != null)) {
      ((f)this.roF.get()).a(paramBoolean1, paramBoolean2, paramc);
    }
  }
  
  public abstract void aS(int paramInt, String paramString);
  
  public final void agQ(String paramString)
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.roJ != null)
    {
      locala = this.roJ;
      if (!locala.rnM)
      {
        locala.rnO = 1;
        if (!bu.isNullOrNil(paramString)) {
          break label48;
        }
        ae.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
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
        if (!o.fB(paramString))
        {
          ae.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
          locala.s(4, 90011, "get image failed");
          return;
        }
        if (locala.rnN == 0L)
        {
          ae.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
          locala.s(4, 90014, "uploadId not init");
          return;
        }
        ae.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[] { paramString });
      } while (locala.rnM);
      localg = new com.tencent.mm.i.g();
      localg.fLl = "task_FaceUploadProcessor";
      localg.fLm = locala.rnU;
      localg.field_mediaId = p.agT(paramString);
      localg.field_fullpath = paramString;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.fKA;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_appType = 1;
      localg.field_bzScene = 0;
      localg.field_largesvideo = 0;
      localg.eRn = 5;
    } while (com.tencent.mm.an.f.aGZ().f(localg));
    ae.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
    locala.s(4, 90019, "add to cdn failed");
  }
  
  protected final void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if ((this.roF != null) && (this.roF.get() != null)) {
      ((f)this.roF.get()).d(paramInt1, paramInt2, paramString, paramBundle);
    }
  }
  
  public final void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramInt == 0) && (!c(paramInt, paramString, paramBundle)))
    {
      ae.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
      this.roG = true;
      if (this.roK)
      {
        paramString = cum();
        if (paramString != null) {
          break label51;
        }
        ae.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
      }
    }
    label51:
    do
    {
      return;
      ae.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
      if (!this.roG)
      {
        ae.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[] { Boolean.valueOf(this.roG) });
        return;
      }
    } while (this.roJ == null);
    paramBundle = this.roJ;
    if (paramString == null)
    {
      ae.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
      return;
    }
    ae.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
    paramBundle.cuc();
    paramBundle.rnQ = paramString;
    paramBundle.rnO = 2;
    com.tencent.mm.kernel.g.ajj().a(paramString.getType(), paramBundle);
    com.tencent.mm.kernel.g.ajj().a(paramString, 0);
    paramBundle.rnR = System.currentTimeMillis();
  }
  
  public abstract void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract boolean c(int paramInt, String paramString, Bundle paramBundle);
  
  public final void cui()
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.roJ != null)
    {
      this.roJ.rnT = this.roI;
      locala = this.roJ;
      com.tencent.mm.kernel.g.ajP();
      locala.rnL = com.tencent.mm.kernel.a.aiY();
      ae.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[] { Boolean.valueOf(locala.rnL) });
      if (!locala.rnL) {
        break label157;
      }
      com.tencent.mm.kernel.g.ajj().a(732, locala);
      locala = this.roJ;
      locala.rnN = 0L;
      locala.rnO = 0;
      if (locala.rnP != null) {
        com.tencent.mm.kernel.g.ajj().a(locala.rnP);
      }
      if (e.cus()) {
        e.vB(locala.rnN);
      }
      if (!locala.rnL) {
        break label170;
      }
    }
    label157:
    label170:
    for (locala.rnP = new u(locala.rnI, locala.rnT);; locala.rnP = new v(locala.rnI, locala.rnT))
    {
      com.tencent.mm.kernel.g.ajj().a(locala.rnP, 0);
      return;
      com.tencent.mm.kernel.g.ajj().a(733, locala);
      break;
    }
  }
  
  public final void cuj()
  {
    if ((this.roF != null) && (this.roF.get() != null)) {
      ((f)this.roF.get()).cuj();
    }
    onStart();
  }
  
  public final long cuk()
  {
    if (this.roJ != null) {
      return this.roJ.rnN;
    }
    return -1L;
  }
  
  public final void cul()
  {
    ae.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
    if ((this.roF != null) && (this.roF.get() != null)) {
      ((f)this.roF.get()).cul();
    }
    this.roF = null;
    Object localObject = bu.getProcessNameByPid(ak.getContext(), Process.myPid());
    String str = ak.getPackageName();
    ae.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[] { localObject });
    boolean bool;
    if (((String)localObject).equalsIgnoreCase(str)) {
      if (this.roJ != null)
      {
        localObject = this.roJ;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).rnP != null) {
          break label201;
        }
        bool = true;
        ae.v("MicroMsg.FaceUploadProcessor", "alvinluo uinit mCurrentNetScene == null: %b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.facedetect.b.a)localObject).rnM = true;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).rnP != null)
        {
          ae.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[] { ((com.tencent.mm.plugin.facedetect.b.a)localObject).rnP.getClass().getSimpleName() });
          com.tencent.mm.kernel.g.ajj().a(((com.tencent.mm.plugin.facedetect.b.a)localObject).rnP);
        }
        if (!((com.tencent.mm.plugin.facedetect.b.a)localObject).rnL) {
          break label206;
        }
        com.tencent.mm.kernel.g.ajj().b(732, (com.tencent.mm.ak.f)localObject);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.facedetect.b.a)localObject).cuc();
      this.roJ = null;
      onRelease();
      return;
      label201:
      bool = false;
      break;
      label206:
      com.tencent.mm.kernel.g.ajj().b(733, (com.tencent.mm.ak.f)localObject);
    }
  }
  
  protected abstract n cum();
  
  public abstract Bundle cun();
  
  public abstract void f(int paramInt1, int paramInt2, String paramString, n paramn);
  
  public abstract void onRelease();
  
  protected abstract void onStart();
  
  public abstract void t(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */