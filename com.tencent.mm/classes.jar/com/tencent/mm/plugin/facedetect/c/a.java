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
  private com.tencent.mm.remoteservice.d fLo = null;
  private Context mContext;
  private int pNh;
  protected com.tencent.mm.plugin.facedetect.b.d pNi = null;
  protected com.tencent.mm.plugin.facedetect.b.c pNj = null;
  protected WeakReference<f> pOd;
  protected boolean pOe = false;
  int pOf = -1;
  public int pOg;
  protected com.tencent.mm.plugin.facedetect.b.a pOh = null;
  protected boolean pOi = false;
  protected int pOj;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.pNh = paramInt1;
    this.pOd = new WeakReference(paramf);
    this.pOg = paramInt2;
    this.pOh = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, paramInt2);
    this.pOf = FaceDetectReporter.BY(paramInt1);
  }
  
  public final void BT(int paramInt)
  {
    this.pOj = paramInt;
  }
  
  public final void XI(String paramString)
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.pOh != null)
    {
      locala = this.pOh;
      if (!locala.pNl)
      {
        locala.pNn = 1;
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
        if (!i.eK(paramString))
        {
          ad.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
          locala.s(4, 90011, "get image failed");
          return;
        }
        if (locala.pNm == 0L)
        {
          ad.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
          locala.s(4, 90014, "uploadId not init");
          return;
        }
        ad.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[] { paramString });
      } while (locala.pNl);
      localg = new com.tencent.mm.i.g();
      localg.fnH = locala.pNt;
      localg.field_mediaId = p.XL(paramString);
      localg.field_fullpath = paramString;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.fmV;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_appType = 0;
      localg.field_bzScene = 0;
      localg.field_largesvideo = 0;
    } while (com.tencent.mm.ao.f.awL().e(localg));
    ad.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
    locala.s(4, 90019, "add to cdn failed");
  }
  
  protected final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.pOd == null) {}
    for (;;)
    {
      ad.i("MicroMsg.FaceDetectBaseController", "alvinluo finishWithResult mUIModel == null: %b", new Object[] { Boolean.valueOf(bool) });
      if ((this.pOd != null) && (this.pOd.get() != null)) {
        ((f)this.pOd.get()).a(paramInt1, paramInt2, paramString, paramBundle);
      }
      return;
      bool = false;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.c paramc)
  {
    if (this.pOh != null)
    {
      this.pNj = paramc;
      this.pOh.pNj = this.pNj;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.d paramd)
  {
    if (this.pOh != null)
    {
      this.pNi = paramd;
      this.pOh.pNi = paramd;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc)
  {
    if ((this.pOd != null) && (this.pOd.get() != null)) {
      ((f)this.pOd.get()).a(paramBoolean1, paramBoolean2, paramc);
    }
  }
  
  public abstract void aN(int paramInt, String paramString);
  
  protected final void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if ((this.pOd != null) && (this.pOd.get() != null)) {
      ((f)this.pOd.get()).d(paramInt1, paramInt2, paramString, paramBundle);
    }
  }
  
  public final void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramInt == 0) && (!c(paramInt, paramString, paramBundle)))
    {
      ad.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
      this.pOe = true;
      if (this.pOi)
      {
        paramString = cfz();
        if (paramString != null) {
          break label50;
        }
        ad.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
      }
    }
    label50:
    do
    {
      return;
      ad.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
      if (!this.pOe)
      {
        ad.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[] { Boolean.valueOf(this.pOe) });
        return;
      }
    } while (this.pOh == null);
    paramBundle = this.pOh;
    if (paramString == null)
    {
      ad.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
      return;
    }
    ad.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
    paramBundle.cfp();
    paramBundle.pNp = paramString;
    paramBundle.pNn = 2;
    com.tencent.mm.kernel.g.aeS().a(paramString.getType(), paramBundle);
    com.tencent.mm.kernel.g.aeS().a(paramString, 0);
    paramBundle.pNq = System.currentTimeMillis();
  }
  
  public abstract void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract boolean c(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract Bundle cfA();
  
  public final void cfv()
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.pOh != null)
    {
      this.pOh.pNs = this.pOg;
      locala = this.pOh;
      com.tencent.mm.kernel.g.afz();
      locala.pNk = com.tencent.mm.kernel.a.aeH();
      ad.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[] { Boolean.valueOf(locala.pNk) });
      if (!locala.pNk) {
        break label157;
      }
      com.tencent.mm.kernel.g.aeS().a(732, locala);
      locala = this.pOh;
      locala.pNm = 0L;
      locala.pNn = 0;
      if (locala.pNo != null) {
        com.tencent.mm.kernel.g.aeS().a(locala.pNo);
      }
      if (e.cfF()) {
        e.pz(locala.pNm);
      }
      if (!locala.pNk) {
        break label170;
      }
    }
    label157:
    label170:
    for (locala.pNo = new u(locala.pNh, locala.pNs);; locala.pNo = new v(locala.pNh, locala.pNs))
    {
      com.tencent.mm.kernel.g.aeS().a(locala.pNo, 0);
      return;
      com.tencent.mm.kernel.g.aeS().a(733, locala);
      break;
    }
  }
  
  public final void cfw()
  {
    if ((this.pOd != null) && (this.pOd.get() != null)) {
      ((f)this.pOd.get()).cfw();
    }
    onStart();
  }
  
  public final long cfx()
  {
    if (this.pOh != null) {
      return this.pOh.pNm;
    }
    return -1L;
  }
  
  public final void cfy()
  {
    ad.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
    if ((this.pOd != null) && (this.pOd.get() != null)) {
      ((f)this.pOd.get()).cfy();
    }
    this.pOd = null;
    Object localObject = bt.getProcessNameByPid(aj.getContext(), Process.myPid());
    String str = aj.getPackageName();
    ad.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[] { localObject });
    boolean bool;
    if (((String)localObject).equalsIgnoreCase(str)) {
      if (this.pOh != null)
      {
        localObject = this.pOh;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).pNo != null) {
          break label201;
        }
        bool = true;
        ad.v("MicroMsg.FaceUploadProcessor", "alvinluo uinit mCurrentNetScene == null: %b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.facedetect.b.a)localObject).pNl = true;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).pNo != null)
        {
          ad.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[] { ((com.tencent.mm.plugin.facedetect.b.a)localObject).pNo.getClass().getSimpleName() });
          com.tencent.mm.kernel.g.aeS().a(((com.tencent.mm.plugin.facedetect.b.a)localObject).pNo);
        }
        if (!((com.tencent.mm.plugin.facedetect.b.a)localObject).pNk) {
          break label206;
        }
        com.tencent.mm.kernel.g.aeS().b(732, (com.tencent.mm.al.g)localObject);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.facedetect.b.a)localObject).cfp();
      this.pOh = null;
      onRelease();
      return;
      label201:
      bool = false;
      break;
      label206:
      com.tencent.mm.kernel.g.aeS().b(733, (com.tencent.mm.al.g)localObject);
    }
  }
  
  protected abstract n cfz();
  
  public abstract void f(int paramInt1, int paramInt2, String paramString, n paramn);
  
  public abstract void onRelease();
  
  protected abstract void onStart();
  
  public abstract void t(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */