package com.tencent.mm.media.i;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a.a gVn = new a.a((byte)0);
  public com.tencent.mm.media.i.b.a gVc;
  private byte[] gVd;
  public com.tencent.mm.media.f.d gVe;
  public boolean gVf;
  private boolean gVg;
  public int gVh;
  protected boolean gVi;
  public d.g.a.b<? super SurfaceTexture, y> gVj;
  public d.g.a.a<y> gVk;
  public boolean gVl;
  protected int gVm;
  protected int gqX;
  public int gqZ;
  public int grV;
  public int grW;
  public int gra;
  protected int scaleType;
  SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.gqZ = paramInt1;
    this.gra = paramInt2;
    this.grV = paramInt3;
    this.grW = paramInt4;
    this.gVm = paramInt5;
    this.scaleType = paramInt6;
    this.gqX = -1;
  }
  
  protected abstract com.tencent.mm.media.i.b.a ajF();
  
  public void ajG()
  {
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.ajG();
    }
  }
  
  public com.tencent.mm.media.f.d ajH()
  {
    return this.gVe;
  }
  
  public final IntBuffer arh()
  {
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      return locala.arh();
    }
    return null;
  }
  
  public void ari()
  {
    ac.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.gVz = true;
    }
  }
  
  public int arj()
  {
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      return locala.gVB;
    }
    return 0;
  }
  
  public int ark()
  {
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      return locala.gVC;
    }
    return 0;
  }
  
  public void cR(int paramInt1, int paramInt2)
  {
    ac.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.grV = paramInt1;
    this.grW = paramInt2;
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.cR(paramInt1, paramInt2);
    }
  }
  
  public void cS(int paramInt1, int paramInt2)
  {
    ac.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.gqZ = paramInt1;
    this.gra = paramInt2;
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.cS(paramInt1, paramInt2);
    }
  }
  
  public final void ed(boolean paramBoolean)
  {
    if (this.gVl)
    {
      ac.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.gVg = paramBoolean;
    this.gVc = ajF();
    ac.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.gVi);
    cR(this.grV, this.grW);
    cS(this.gqZ, this.gra);
    mE(this.gVh);
    ee(this.gVi);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.gVg) && ((this.surfaceTexture == null) || (this.gqX <= 0)))
    {
      this.gVe = com.tencent.mm.media.f.c.a(false, 12L);
      localObject = this.gVe;
      if (localObject == null) {
        k.fOy();
      }
      localSurfaceTexture = new SurfaceTexture(((com.tencent.mm.media.f.d)localObject).gRW);
      localObject = this.gVj;
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
      localObject = this.gVe;
      if (localObject != null)
      {
        i = ((com.tencent.mm.media.f.d)localObject).gRW;
        if (i <= 0)
        {
          localObject = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.arD();
        }
        ac.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.gVe, new Object[0]);
        localObject = this.gVe;
        if (localObject == null) {
          break label361;
        }
      }
      for (int i = ((com.tencent.mm.media.f.d)localObject).gRW;; i = -1)
      {
        input(i);
        ac.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
        this.gVl = true;
        return;
        i = -1;
        break;
      }
    }
  }
  
  public void ee(boolean paramBoolean)
  {
    ac.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.gVi = paramBoolean;
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.gVi = paramBoolean;
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
    this.gqX = paramInt;
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.no(paramInt);
    }
  }
  
  public void l(d.g.a.b<? super IntBuffer, y> paramb)
  {
    k.h(paramb, "listener");
    Object localObject = new StringBuilder("glTextureRenderProc is null ?");
    if (this.gVc == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.m("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
      localObject = this.gVc;
      if (localObject != null) {
        ((com.tencent.mm.media.i.b.a)localObject).gVx = paramb;
      }
      return;
    }
  }
  
  public void mE(int paramInt)
  {
    ac.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.gVh + " , new degree : " + paramInt, new Object[0]);
    this.gVh = paramInt;
    com.tencent.mm.media.i.b.a locala = this.gVc;
    if (locala != null) {
      locala.mE(paramInt);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.gVf)
    {
      ac.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.gVf = false;
    }
    do
    {
      return;
      if ((this.gVd == null) && (this.gqX == -1))
      {
        ac.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      ajG();
      paramGL10 = this.gVk;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    cR(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    ac.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.j.c.gWJ;
    c.a.art();
  }
  
  public void release(boolean paramBoolean)
  {
    ac.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.gVc;
    if (localObject1 != null) {
      ((com.tencent.mm.media.i.b.a)localObject1).release();
    }
    if (paramBoolean)
    {
      localObject1 = this.surfaceTexture;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).release();
      }
    }
    localObject1 = this.gVe;
    if (localObject1 != null) {
      ((com.tencent.mm.media.f.d)localObject1).close();
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = y.KTp;
      this.gVl = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */