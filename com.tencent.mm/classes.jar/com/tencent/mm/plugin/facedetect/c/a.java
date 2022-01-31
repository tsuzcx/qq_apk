package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.b;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public abstract class a
{
  private com.tencent.mm.remoteservice.d evl = null;
  private Context mContext;
  private int mgs;
  protected com.tencent.mm.plugin.facedetect.b.d mgt = null;
  protected com.tencent.mm.plugin.facedetect.b.c mgu = null;
  protected WeakReference<f> mhp;
  protected boolean mhq = false;
  int mhr = -1;
  public int mhs;
  protected com.tencent.mm.plugin.facedetect.b.a mht = null;
  protected boolean mhu = false;
  protected int mhv;
  
  a(Context paramContext, f paramf, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mgs = paramInt1;
    this.mhp = new WeakReference(paramf);
    this.mhs = paramInt2;
    this.mht = new com.tencent.mm.plugin.facedetect.b.a(paramInt1, paramInt2);
    this.mhr = FaceDetectReporter.vG(paramInt1);
  }
  
  public final void No(String paramString)
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.mht != null)
    {
      locala = this.mht;
      if (!locala.mgw)
      {
        locala.mgy = 1;
        if (!bo.isNullOrNil(paramString)) {
          break label48;
        }
        ab.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
        locala.p(4, 90011, "face file null");
      }
    }
    label48:
    com.tencent.mm.i.g localg;
    do
    {
      do
      {
        return;
        if (!com.tencent.mm.vfs.e.cN(paramString))
        {
          ab.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
          locala.p(4, 90011, "get image failed");
          return;
        }
        if (locala.mgx == 0L)
        {
          ab.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
          locala.p(4, 90014, "uploadId not init");
          return;
        }
        ab.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[] { paramString });
      } while (locala.mgw);
      localg = new com.tencent.mm.i.g();
      localg.edp = locala.mgE;
      localg.field_mediaId = com.tencent.mm.plugin.facedetect.model.p.Nr(paramString);
      localg.field_fullpath = paramString;
      localg.field_thumbpath = "";
      localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      localg.field_talker = "";
      localg.field_priority = com.tencent.mm.i.a.ecF;
      localg.field_needStorage = false;
      localg.field_isStreamMedia = false;
      localg.field_appType = 0;
      localg.field_bzScene = 0;
      localg.field_largesvideo = 0;
    } while (com.tencent.mm.al.f.afO().e(localg));
    ab.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
    locala.p(4, 90019, "add to cdn failed");
  }
  
  protected final void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.mhp == null) {}
    for (;;)
    {
      ab.i("MicroMsg.FaceDetectBaseController", "alvinluo finishWithResult mUIModel == null: %b", new Object[] { Boolean.valueOf(bool) });
      if ((this.mhp != null) && (this.mhp.get() != null)) {
        ((f)this.mhp.get()).a(paramInt1, paramInt2, paramString, paramBundle);
      }
      return;
      bool = false;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.c paramc)
  {
    if (this.mht != null)
    {
      this.mgu = paramc;
      this.mht.mgu = this.mgu;
    }
  }
  
  public final void a(com.tencent.mm.plugin.facedetect.b.d paramd)
  {
    if (this.mht != null)
    {
      this.mgt = paramd;
      this.mht.mgt = paramd;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.facedetect.ui.c paramc)
  {
    if ((this.mhp != null) && (this.mhp.get() != null)) {
      ((f)this.mhp.get()).a(paramBoolean1, paramBoolean2, paramc);
    }
  }
  
  public abstract void ax(int paramInt, String paramString);
  
  protected final void b(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if ((this.mhp != null) && (this.mhp.get() != null)) {
      ((f)this.mhp.get()).d(paramInt1, paramInt2, paramString, paramBundle);
    }
  }
  
  public final void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if ((paramInt == 0) && (!c(paramInt, paramString, paramBundle)))
    {
      ab.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
      this.mhq = true;
      if (this.mhu)
      {
        paramString = buf();
        if (paramString != null) {
          break label50;
        }
        ab.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
      }
    }
    label50:
    do
    {
      return;
      ab.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
      if (!this.mhq)
      {
        ab.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[] { Boolean.valueOf(this.mhq) });
        return;
      }
    } while (this.mht == null);
    paramBundle = this.mht;
    if (paramString == null)
    {
      ab.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
      return;
    }
    ab.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[] { Integer.valueOf(paramString.getType()) });
    paramBundle.btV();
    paramBundle.mgA = paramString;
    paramBundle.mgy = 2;
    com.tencent.mm.kernel.g.Rc().a(paramString.getType(), paramBundle);
    com.tencent.mm.kernel.g.Rc().a(paramString, 0);
    paramBundle.mgB = System.currentTimeMillis();
  }
  
  public final void bub()
  {
    com.tencent.mm.plugin.facedetect.b.a locala;
    if (this.mht != null)
    {
      this.mht.mgD = this.mhs;
      locala = this.mht;
      com.tencent.mm.kernel.g.RJ();
      locala.mgv = com.tencent.mm.kernel.a.QT();
      ab.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[] { Boolean.valueOf(locala.mgv) });
      if (!locala.mgv) {
        break label157;
      }
      com.tencent.mm.kernel.g.Rc().a(732, locala);
      locala = this.mht;
      locala.mgx = 0L;
      locala.mgy = 0;
      if (locala.mgz != null) {
        com.tencent.mm.kernel.g.Rc().a(locala.mgz);
      }
      if (com.tencent.mm.plugin.facedetect.model.e.bul()) {
        com.tencent.mm.plugin.facedetect.model.e.jI(locala.mgx);
      }
      if (!locala.mgv) {
        break label170;
      }
    }
    label157:
    label170:
    for (locala.mgz = new u(locala.mgs, locala.mgD);; locala.mgz = new v(locala.mgs, locala.mgD))
    {
      com.tencent.mm.kernel.g.Rc().a(locala.mgz, 0);
      return;
      com.tencent.mm.kernel.g.Rc().a(733, locala);
      break;
    }
  }
  
  public final void buc()
  {
    if ((this.mhp != null) && (this.mhp.get() != null)) {
      ((f)this.mhp.get()).buc();
    }
    onStart();
  }
  
  public final long bud()
  {
    if (this.mht != null) {
      return this.mht.mgx;
    }
    return -1L;
  }
  
  public final void bue()
  {
    ab.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
    if ((this.mhp != null) && (this.mhp.get() != null)) {
      ((f)this.mhp.get()).bue();
    }
    this.mhp = null;
    Object localObject = bo.az(ah.getContext(), Process.myPid());
    String str = ah.getPackageName();
    ab.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[] { localObject });
    boolean bool;
    if (((String)localObject).equalsIgnoreCase(str)) {
      if (this.mht != null)
      {
        localObject = this.mht;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).mgz != null) {
          break label201;
        }
        bool = true;
        ab.v("MicroMsg.FaceUploadProcessor", "alvinluo uinit mCurrentNetScene == null: %b", new Object[] { Boolean.valueOf(bool) });
        ((com.tencent.mm.plugin.facedetect.b.a)localObject).mgw = true;
        if (((com.tencent.mm.plugin.facedetect.b.a)localObject).mgz != null)
        {
          ab.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[] { ((com.tencent.mm.plugin.facedetect.b.a)localObject).mgz.getClass().getSimpleName() });
          com.tencent.mm.kernel.g.Rc().a(((com.tencent.mm.plugin.facedetect.b.a)localObject).mgz);
        }
        if (!((com.tencent.mm.plugin.facedetect.b.a)localObject).mgv) {
          break label206;
        }
        com.tencent.mm.kernel.g.Rc().b(732, (com.tencent.mm.ai.f)localObject);
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.facedetect.b.a)localObject).btV();
      this.mht = null;
      onRelease();
      return;
      label201:
      bool = false;
      break;
      label206:
      com.tencent.mm.kernel.g.Rc().b(733, (com.tencent.mm.ai.f)localObject);
    }
  }
  
  protected abstract m buf();
  
  public abstract Bundle bug();
  
  public abstract void c(int paramInt1, int paramInt2, String paramString, Bundle paramBundle);
  
  public abstract boolean c(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void f(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public abstract void onRelease();
  
  protected abstract void onStart();
  
  public abstract void q(int paramInt1, int paramInt2, String paramString);
  
  public final void vB(int paramInt)
  {
    this.mhv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.a
 * JD-Core Version:    0.7.0.1
 */