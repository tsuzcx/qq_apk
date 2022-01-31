package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d eMh = null;
  private int jMm;
  protected com.tencent.mm.plugin.facedetect.b.d jMn = null;
  protected c jMo = null;
  protected WeakReference<e> jNg;
  protected boolean jNh = false;
  int jNi = -1;
  public int jNj;
  protected com.tencent.mm.plugin.facedetect.b.a jNk = null;
  protected boolean jNl = false;
  protected int jNm;
  private Context mContext;
  
  a(Context paramContext, e parame, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.jMm = paramInt1;
    this.jNg = new WeakReference(parame);
    this.jNj = paramInt2;
    this.jNk = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, paramInt2);
    this.jNi = FaceDetectReporter.qL(paramInt1);
  }
  
  public final void Cn(String paramString)
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.jNk != null)
    {
      locala = this.jNk;
      if (!locala.jMq)
      {
        locala.jMs = 1;
        if (!bk.bl(paramString)) {
          break label48;
        }
        y.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
        locala.l(4, 90011, "face file null");
      }
    }
    label48:
    com.tencent.mm.j.f localf;
    do
    {
      do
      {
        return;
        if (!com.tencent.mm.vfs.e.bK(paramString))
        {
          y.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
          locala.l(4, 90011, "get image failed");
          return;
        }
        if (locala.jMr == 0L)
        {
          y.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
          locala.l(4, 90014, "uploadId not init");
          return;
        }
        y.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[] { paramString });
      } while (locala.jMq);
      localf = new com.tencent.mm.j.f();
      localf.dlP = locala.jMy;
      localf.field_mediaId = o.Cq(paramString);
      localf.field_fullpath = paramString;
      localf.field_thumbpath = "";
      localf.field_fileType = com.tencent.mm.j.a.MediaType_FILE;
      localf.field_talker = "";
      localf.field_priority = com.tencent.mm.j.a.dlk;
      localf.field_needStorage = false;
      localf.field_isStreamMedia = false;
      localf.field_appType = 0;
      localf.field_bzScene = 0;
      localf.field_largesvideo = 0;
    } while (com.tencent.mm.ak.f.Nd().c(localf));
    y.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localf.field_mediaId });
    locala.l(4, 90019, "add to cdn failed");
  }
  
  protected final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.jNg == null) {}
    for (;;)
    {
      y.i("MicroMsg.FaceDetectBaseController", "alvinluo finishWithResult mUIModel == null: %b", new Object[] { Boolean.valueOf(bool) });
      if ((this.jNg != null) && (this.jNg.get() != null)) {
        ((e)this.jNg.get()).a(paramInt1, paramInt2, paramString, paramBundle);
      }
      return;
      bool = false;
    }
  }
  
  public final void a(c paramc)
  {
    if (this.jNk != null)
    {
      this.jMo = paramc;
      this.jNk.jMo = this.jMo;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.d paramd)
  {
    if (this.jNk != null)
    {
      this.jMn = paramd;
      this.jNk.jMn = paramd;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.d paramd)
  {
    if ((this.jNg != null) && (this.jNg.get() != null)) {
      ((e)this.jNg.get()).a(paramBoolean1, paramBoolean2, paramd);
    }
  }
  
  public final void aNY()
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.jNk != null)
    {
      this.jNk.jMx = this.jNj;
      locala = this.jNk;
      g.DN();
      locala.jMp = com.tencent.mm.kernel.a.Db();
      y.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[] { Boolean.valueOf(locala.jMp) });
      if (!locala.jMp) {
        break label156;
      }
      g.Dk().a(732, locala);
      locala = this.jNk;
      locala.jMr = 0L;
      locala.jMs = 0;
      if (locala.jMt != null) {
        g.Dk().c(locala.jMt);
      }
      if (com.tencent.mm.plugin.facedetect.model.e.aOi()) {
        com.tencent.mm.plugin.facedetect.model.e.el(locala.jMr);
      }
      if (!locala.jMp) {
        break label169;
      }
    }
    label156:
    label169:
    for (locala.jMt = new u(locala.jMm, locala.jMx);; locala.jMt = new v(locala.jMm, locala.jMx))
    {
      g.Dk().a(locala.jMt, 0);
      return;
      g.Dk().a(733, locala);
      break;
    }
  }
  
  public final void aNZ()
  {
    if ((this.jNg != null) && (this.jNg.get() != null)) {
      ((e)this.jNg.get()).aNZ();
    }
    onStart();
  }
  
  public final long aOa()
  {
    if (this.jNk != null) {
      return this.jNk.jMr;
    }
    return -1L;
  }
  
  public final void aOb()
  {
    y.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
    if ((this.jNg != null) && (this.jNg.get() != null)) {
      ((e)this.jNg.get()).aOb();
    }
    this.jNg = null;
    Object localObject = bk.am(ae.getContext(), Process.myPid());
    String str = ae.getPackageName();
    y.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[] { localObject });
    boolean bool;
    if (((String)localObject).equalsIgnoreCase(str)) {
      if (this.jNk != null)
      {
        localObject = this.jNk;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).jMt != null) {
          break label201;
        }
        bool = true;
        y.v("MicroMsg.FaceUploadProcessor", "alvinluo uinit mCurrentNetScene == null: %b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.facedetect.b.a)localObject).jMq = true;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).jMt != null)
        {
          y.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[] { ((com.tencent.mm.plugin.facedetect.b.a)localObject).jMt.getClass().getSimpleName() });
          g.Dk().c(((com.tencent.mm.plugin.facedetect.b.a)localObject).jMt);
        }
        if (!((com.tencent.mm.plugin.facedetect.b.a)localObject).jMp) {
          break label206;
        }
        g.Dk().b(732, (com.tencent.mm.ah.f)localObject);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.facedetect.b.a)localObject).aNS();
      this.jNk = null;
      onRelease();
      return;
      label201:
      bool = false;
      break;
      label206:
      g.Dk().b(733, (com.tencent.mm.ah.f)localObject);
    }
  }
  
  protected abstract m aOc();
  
  public abstract Bundle aOd();
  
  public abstract void ae(int paramInt, String paramString);
  
  protected final void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if ((this.jNg != null) && (this.jNg.get() != null)) {
      ((e)this.jNg.get()).d(paramInt1, paramInt2, paramString, paramBundle);
    }
  }
  
  public final void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramInt == 0) && (!c(paramInt, paramString, paramBundle)))
    {
      y.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
      this.jNh = true;
      if (this.jNl)
      {
        paramString = aOc();
        if (paramString != null) {
          break label52;
        }
        y.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
      }
    }
    label52:
    do
    {
      return;
      y.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
      if (!this.jNh)
      {
        y.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[] { Boolean.valueOf(this.jNh) });
        return;
      }
    } while (this.jNk == null);
    paramBundle = this.jNk;
    if (paramString == null)
    {
      y.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
      return;
    }
    y.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
    paramBundle.aNS();
    paramBundle.jMu = paramString;
    paramBundle.jMs = 2;
    g.Dk().a(paramString.getType(), paramBundle);
    g.Dk().a(paramString, 0);
    paramBundle.jMv = System.currentTimeMillis();
  }
  
  public abstract void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract boolean c(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void h(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public abstract void m(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onRelease();
  
  protected abstract void onStart();
  
  public final void qG(int paramInt)
  {
    this.jNm = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */