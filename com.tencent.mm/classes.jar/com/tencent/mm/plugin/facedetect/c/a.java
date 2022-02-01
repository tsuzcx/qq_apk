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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d fPa = null;
  private Context mContext;
  private int qvP;
  protected com.tencent.mm.plugin.facedetect.b.d qvQ = null;
  protected com.tencent.mm.plugin.facedetect.b.c qvR = null;
  protected WeakReference<f> qwL;
  protected boolean qwM = false;
  int qwN = -1;
  public int qwO;
  protected com.tencent.mm.plugin.facedetect.b.a qwP = null;
  protected boolean qwQ = false;
  protected int qwR;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.qvP = paramInt1;
    this.qwL = new WeakReference(paramf);
    this.qwO = paramInt2;
    this.qwP = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, paramInt2);
    this.qwN = FaceDetectReporter.CT(paramInt1);
  }
  
  public final void CO(int paramInt)
  {
    this.qwR = paramInt;
  }
  
  protected final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.qwL == null) {}
    for (;;)
    {
      ac.i("MicroMsg.FaceDetectBaseController", "alvinluo finishWithResult mUIModel == null: %b", new Object[] { Boolean.valueOf(bool) });
      if ((this.qwL != null) && (this.qwL.get() != null)) {
        ((f)this.qwL.get()).a(paramInt1, paramInt2, paramString, paramBundle);
      }
      return;
      bool = false;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.c paramc)
  {
    if (this.qwP != null)
    {
      this.qvR = paramc;
      this.qwP.qvR = this.qvR;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.d paramd)
  {
    if (this.qwP != null)
    {
      this.qvQ = paramd;
      this.qwP.qvQ = paramd;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc)
  {
    if ((this.qwL != null) && (this.qwL.get() != null)) {
      ((f)this.qwL.get()).a(paramBoolean1, paramBoolean2, paramc);
    }
  }
  
  public abstract void aQ(int paramInt, String paramString);
  
  public final void acf(String paramString)
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.qwP != null)
    {
      locala = this.qwP;
      if (!locala.qvT)
      {
        locala.qvV = 1;
        if (!bs.isNullOrNil(paramString)) {
          break label48;
        }
        ac.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
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
        if (!i.eA(paramString))
        {
          ac.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
          locala.s(4, 90011, "get image failed");
          return;
        }
        if (locala.qvU == 0L)
        {
          ac.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
          locala.s(4, 90014, "uploadId not init");
          return;
        }
        ac.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[] { paramString });
      } while (locala.qvT);
      localg = new com.tencent.mm.i.g();
      localg.frb = locala.qwb;
      localg.field_mediaId = p.aci(paramString);
      localg.field_fullpath = paramString;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.fqp;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_appType = 0;
      localg.field_bzScene = 0;
      localg.field_largesvideo = 0;
    } while (com.tencent.mm.an.f.aDD().f(localg));
    ac.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
    locala.s(4, 90019, "add to cdn failed");
  }
  
  protected final void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if ((this.qwL != null) && (this.qwL.get() != null)) {
      ((f)this.qwL.get()).d(paramInt1, paramInt2, paramString, paramBundle);
    }
  }
  
  public final void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramInt == 0) && (!c(paramInt, paramString, paramBundle)))
    {
      ac.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
      this.qwM = true;
      if (this.qwQ)
      {
        paramString = cng();
        if (paramString != null) {
          break label50;
        }
        ac.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
      }
    }
    label50:
    do
    {
      return;
      ac.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
      if (!this.qwM)
      {
        ac.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[] { Boolean.valueOf(this.qwM) });
        return;
      }
    } while (this.qwP == null);
    paramBundle = this.qwP;
    if (paramString == null)
    {
      ac.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
      return;
    }
    ac.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
    paramBundle.cmW();
    paramBundle.qvX = paramString;
    paramBundle.qvV = 2;
    com.tencent.mm.kernel.g.agi().a(paramString.getType(), paramBundle);
    com.tencent.mm.kernel.g.agi().a(paramString, 0);
    paramBundle.qvY = System.currentTimeMillis();
  }
  
  public abstract void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract boolean c(int paramInt, String paramString, Bundle paramBundle);
  
  public final void cnc()
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.qwP != null)
    {
      this.qwP.qwa = this.qwO;
      locala = this.qwP;
      com.tencent.mm.kernel.g.agP();
      locala.qvS = com.tencent.mm.kernel.a.afX();
      ac.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[] { Boolean.valueOf(locala.qvS) });
      if (!locala.qvS) {
        break label157;
      }
      com.tencent.mm.kernel.g.agi().a(732, locala);
      locala = this.qwP;
      locala.qvU = 0L;
      locala.qvV = 0;
      if (locala.qvW != null) {
        com.tencent.mm.kernel.g.agi().a(locala.qvW);
      }
      if (e.cnm()) {
        e.to(locala.qvU);
      }
      if (!locala.qvS) {
        break label170;
      }
    }
    label157:
    label170:
    for (locala.qvW = new u(locala.qvP, locala.qwa);; locala.qvW = new v(locala.qvP, locala.qwa))
    {
      com.tencent.mm.kernel.g.agi().a(locala.qvW, 0);
      return;
      com.tencent.mm.kernel.g.agi().a(733, locala);
      break;
    }
  }
  
  public final void cnd()
  {
    if ((this.qwL != null) && (this.qwL.get() != null)) {
      ((f)this.qwL.get()).cnd();
    }
    onStart();
  }
  
  public final long cne()
  {
    if (this.qwP != null) {
      return this.qwP.qvU;
    }
    return -1L;
  }
  
  public final void cnf()
  {
    ac.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
    if ((this.qwL != null) && (this.qwL.get() != null)) {
      ((f)this.qwL.get()).cnf();
    }
    this.qwL = null;
    Object localObject = bs.getProcessNameByPid(ai.getContext(), Process.myPid());
    String str = ai.getPackageName();
    ac.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[] { localObject });
    boolean bool;
    if (((String)localObject).equalsIgnoreCase(str)) {
      if (this.qwP != null)
      {
        localObject = this.qwP;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).qvW != null) {
          break label201;
        }
        bool = true;
        ac.v("MicroMsg.FaceUploadProcessor", "alvinluo uinit mCurrentNetScene == null: %b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.facedetect.b.a)localObject).qvT = true;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).qvW != null)
        {
          ac.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[] { ((com.tencent.mm.plugin.facedetect.b.a)localObject).qvW.getClass().getSimpleName() });
          com.tencent.mm.kernel.g.agi().a(((com.tencent.mm.plugin.facedetect.b.a)localObject).qvW);
        }
        if (!((com.tencent.mm.plugin.facedetect.b.a)localObject).qvS) {
          break label206;
        }
        com.tencent.mm.kernel.g.agi().b(732, (com.tencent.mm.ak.g)localObject);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.facedetect.b.a)localObject).cmW();
      this.qwP = null;
      onRelease();
      return;
      label201:
      bool = false;
      break;
      label206:
      com.tencent.mm.kernel.g.agi().b(733, (com.tencent.mm.ak.g)localObject);
    }
  }
  
  protected abstract n cng();
  
  public abstract Bundle cnh();
  
  public abstract void f(int paramInt1, int paramInt2, String paramString, n paramn);
  
  public abstract void onRelease();
  
  protected abstract void onStart();
  
  public abstract void t(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */