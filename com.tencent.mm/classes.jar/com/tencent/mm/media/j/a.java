package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a.a hnq = new a.a((byte)0);
  protected int gKH;
  public int gKJ;
  public int gKK;
  public int gLD;
  public int gLE;
  public com.tencent.mm.media.j.b.a hnf;
  private byte[] hng;
  public com.tencent.mm.media.g.d hnh;
  public boolean hni;
  private boolean hnj;
  public int hnk;
  protected boolean hnl;
  public d.g.a.b<? super SurfaceTexture, z> hnm;
  public d.g.a.a<z> hnn;
  public boolean hno;
  protected int hnp;
  protected int scaleType;
  SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.gKJ = paramInt1;
    this.gKK = paramInt2;
    this.gLD = paramInt3;
    this.gLE = paramInt4;
    this.hnp = paramInt5;
    this.scaleType = paramInt6;
    this.gKH = -1;
  }
  
  protected abstract com.tencent.mm.media.j.b.a amr();
  
  public void ams()
  {
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.ams();
    }
  }
  
  public com.tencent.mm.media.g.d amt()
  {
    return this.hnh;
  }
  
  public final IntBuffer atU()
  {
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      return locala.atU();
    }
    return null;
  }
  
  public void atV()
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.hnD = true;
    }
  }
  
  public int atW()
  {
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      return locala.hnF;
    }
    return 0;
  }
  
  public int atX()
  {
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      return locala.hnG;
    }
    return 0;
  }
  
  public void cT(int paramInt1, int paramInt2)
  {
    ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.gLD = paramInt1;
    this.gLE = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.cT(paramInt1, paramInt2);
    }
  }
  
  public void cU(int paramInt1, int paramInt2)
  {
    ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.gKJ = paramInt1;
    this.gKK = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.cU(paramInt1, paramInt2);
    }
  }
  
  public final void ef(boolean paramBoolean)
  {
    if (this.hno)
    {
      ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.hnj = paramBoolean;
    this.hnf = amr();
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.hnl);
    cT(this.gLD, this.gLE);
    cU(this.gKJ, this.gKK);
    nd(this.hnk);
    eg(this.hnl);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.hnj) && ((this.surfaceTexture == null) || (this.gKH <= 0)))
    {
      this.hnh = com.tencent.mm.media.g.c.a(false, 12L);
      localObject = this.hnh;
      if (localObject == null) {
        p.gfZ();
      }
      localSurfaceTexture = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject).hko);
      localObject = this.hnm;
      if (localObject == null) {
        break label366;
      }
      localObject = new b((d.g.a.b)localObject);
    }
    label361:
    label366:
    for (;;)
    {
      localSurfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)localObject);
      this.surfaceTexture = localSurfaceTexture;
      localObject = this.hnh;
      if (localObject != null)
      {
        i = ((com.tencent.mm.media.g.d)localObject).hko;
        if (i <= 0)
        {
          localObject = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.auq();
        }
        ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.hnh, new Object[0]);
        localObject = this.hnh;
        if (localObject == null) {
          break label361;
        }
      }
      for (int i = ((com.tencent.mm.media.g.d)localObject).hko;; i = -1)
      {
        input(i);
        ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
        this.hno = true;
        return;
        i = -1;
        break;
      }
    }
  }
  
  public void eg(boolean paramBoolean)
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.hnl = paramBoolean;
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.hnl = paramBoolean;
    }
  }
  
  public final SurfaceTexture getTexture()
  {
    try
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      return localSurfaceTexture;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void input(int paramInt)
  {
    this.gKH = paramInt;
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.nN(paramInt);
    }
  }
  
  public void m(d.g.a.b<? super IntBuffer, z> paramb)
  {
    p.h(paramb, "listener");
    Object localObject = new StringBuilder("glTextureRenderProc is null ?");
    if (this.hnf == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.m("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
      localObject = this.hnf;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).hnA = paramb;
      }
      return;
    }
  }
  
  public void nd(int paramInt)
  {
    ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.hnk + " , new degree : " + paramInt, new Object[0]);
    this.hnk = paramInt;
    com.tencent.mm.media.j.b.a locala = this.hnf;
    if (locala != null) {
      locala.nd(paramInt);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.hni)
    {
      ad.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.hni = false;
    }
    do
    {
      return;
      if ((this.hng == null) && (this.gKH == -1))
      {
        ad.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      ams();
      paramGL10 = this.hnn;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    cT(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.k.c.hoP;
    c.a.aug();
  }
  
  public void release(boolean paramBoolean)
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.hnf;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    if (paramBoolean)
    {
      localObject1 = this.surfaceTexture;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).release();
      }
    }
    localObject1 = this.hnh;
    if (localObject1 != null) {
      ((com.tencent.mm.media.g.d)localObject1).close();
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = z.MKo;
      this.hno = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */