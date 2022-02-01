package com.tencent.mm.media.i;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a.a guN = new a.a((byte)0);
  public boolean guA;
  private boolean guB;
  public int guC;
  public int guD;
  public boolean guE;
  public d.g.a.b<? super SurfaceTexture, y> guF;
  public d.g.a.a<y> guG;
  public boolean guH;
  public int guI;
  public int guJ;
  public int guK;
  public int guL;
  protected int guM;
  public com.tencent.mm.media.i.b.a gux;
  private byte[] guy;
  public com.tencent.mm.media.f.d guz;
  protected int scaleType;
  SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.guI = paramInt1;
    this.guJ = paramInt2;
    this.guK = paramInt3;
    this.guL = paramInt4;
    this.guM = paramInt5;
    this.scaleType = paramInt6;
    this.guC = -1;
  }
  
  protected abstract com.tencent.mm.media.i.b.a akj();
  
  public void akk()
  {
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.akk();
    }
  }
  
  public final IntBuffer akl()
  {
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      return locala.akl();
    }
    return null;
  }
  
  public void akm()
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.gvc = true;
    }
  }
  
  public int akn()
  {
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      return locala.gve;
    }
    return 0;
  }
  
  public int ako()
  {
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      return locala.gvf;
    }
    return 0;
  }
  
  public void cS(int paramInt1, int paramInt2)
  {
    ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.guI = paramInt1;
    this.guJ = paramInt2;
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.cS(paramInt1, paramInt2);
    }
  }
  
  public void cT(int paramInt1, int paramInt2)
  {
    ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.guK = paramInt1;
    this.guL = paramInt2;
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.cT(paramInt1, paramInt2);
    }
  }
  
  public com.tencent.mm.media.f.d czI()
  {
    return this.guz;
  }
  
  public final void dI(boolean paramBoolean)
  {
    if (this.guH)
    {
      ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.guB = paramBoolean;
    this.gux = akj();
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.guE);
    cT(this.guK, this.guL);
    cS(this.guI, this.guJ);
    mz(this.guD);
    dJ(this.guE);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.guB) && ((this.surfaceTexture == null) || (this.guC <= 0)))
    {
      this.guz = com.tencent.mm.media.f.c.a(false, 12L);
      localObject = this.guz;
      if (localObject == null) {
        k.fvU();
      }
      localSurfaceTexture = new SurfaceTexture(((com.tencent.mm.media.f.d)localObject).gro);
      localObject = this.guF;
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
      localObject = this.guz;
      if (localObject != null)
      {
        i = ((com.tencent.mm.media.f.d)localObject).gro;
        if (i <= 0)
        {
          localObject = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.akJ();
        }
        ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.guz, new Object[0]);
        localObject = this.guz;
        if (localObject == null) {
          break label361;
        }
      }
      for (int i = ((com.tencent.mm.media.f.d)localObject).gro;; i = -1)
      {
        input(i);
        ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
        this.guH = true;
        return;
        i = -1;
        break;
      }
    }
  }
  
  public void dJ(boolean paramBoolean)
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.guE = paramBoolean;
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.guE = paramBoolean;
    }
  }
  
  public void g(d.g.a.b<? super IntBuffer, y> paramb)
  {
    k.h(paramb, "listener");
    Object localObject = new StringBuilder("glTextureRenderProc is null ?");
    if (this.gux == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.m("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
      localObject = this.gux;
      if (localObject != null) {
        ((com.tencent.mm.media.i.b.a)localObject).gva = paramb;
      }
      return;
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
    this.guC = paramInt;
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.mA(paramInt);
    }
  }
  
  public void mz(int paramInt)
  {
    ad.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.guD + " , new degree : " + paramInt, new Object[0]);
    this.guD = paramInt;
    com.tencent.mm.media.i.b.a locala = this.gux;
    if (locala != null) {
      locala.mz(paramInt);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.guA)
    {
      ad.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.guA = false;
    }
    do
    {
      return;
      if ((this.guy == null) && (this.guC == -1))
      {
        ad.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      akk();
      paramGL10 = this.guG;
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
    paramGL10 = com.tencent.mm.media.j.c.gwl;
    c.a.akz();
  }
  
  public void release(boolean paramBoolean)
  {
    ad.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.gux;
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
    localObject1 = this.guz;
    if (localObject1 != null) {
      ((com.tencent.mm.media.f.d)localObject1).close();
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = y.JfV;
      this.guH = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */