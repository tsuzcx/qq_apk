package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a.a hqe = new a.a((byte)0);
  protected int gNq;
  public int gNs;
  public int gNt;
  public int gOm;
  public int gOn;
  public com.tencent.mm.media.j.b.a hpT;
  private byte[] hpU;
  public com.tencent.mm.media.g.d hpV;
  public boolean hpW;
  private boolean hpX;
  public int hpY;
  protected boolean hpZ;
  public d.g.a.b<? super SurfaceTexture, z> hqa;
  public d.g.a.a<z> hqb;
  public boolean hqc;
  protected int hqd;
  protected int scaleType;
  SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.gNs = paramInt1;
    this.gNt = paramInt2;
    this.gOm = paramInt3;
    this.gOn = paramInt4;
    this.hqd = paramInt5;
    this.scaleType = paramInt6;
    this.gNq = -1;
  }
  
  protected abstract com.tencent.mm.media.j.b.a amG();
  
  public void amH()
  {
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.amH();
    }
  }
  
  public com.tencent.mm.media.g.d amI()
  {
    return this.hpV;
  }
  
  public final IntBuffer auj()
  {
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      return locala.auj();
    }
    return null;
  }
  
  public void auk()
  {
    ae.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.hqr = true;
    }
  }
  
  public int aul()
  {
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      return locala.hqt;
    }
    return 0;
  }
  
  public int aum()
  {
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      return locala.hqu;
    }
    return 0;
  }
  
  public void cT(int paramInt1, int paramInt2)
  {
    ae.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.gOm = paramInt1;
    this.gOn = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.cT(paramInt1, paramInt2);
    }
  }
  
  public void cU(int paramInt1, int paramInt2)
  {
    ae.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.gNs = paramInt1;
    this.gNt = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.cU(paramInt1, paramInt2);
    }
  }
  
  public final void eh(boolean paramBoolean)
  {
    if (this.hqc)
    {
      ae.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.hpX = paramBoolean;
    this.hpT = amG();
    ae.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.hpZ);
    cT(this.gOm, this.gOn);
    cU(this.gNs, this.gNt);
    ng(this.hpY);
    ei(this.hpZ);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.hpX) && ((this.surfaceTexture == null) || (this.gNq <= 0)))
    {
      this.hpV = com.tencent.mm.media.g.c.a(false, 12L);
      localObject = this.hpV;
      if (localObject == null) {
        p.gkB();
      }
      localSurfaceTexture = new SurfaceTexture(((com.tencent.mm.media.g.d)localObject).hnc);
      localObject = this.hqa;
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
      localObject = this.hpV;
      if (localObject != null)
      {
        i = ((com.tencent.mm.media.g.d)localObject).hnc;
        if (i <= 0)
        {
          localObject = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.auF();
        }
        ae.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.hpV, new Object[0]);
        localObject = this.hpV;
        if (localObject == null) {
          break label361;
        }
      }
      for (int i = ((com.tencent.mm.media.g.d)localObject).hnc;; i = -1)
      {
        input(i);
        ae.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
        this.hqc = true;
        return;
        i = -1;
        break;
      }
    }
  }
  
  public void ei(boolean paramBoolean)
  {
    ae.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.hpZ = paramBoolean;
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.hpZ = paramBoolean;
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
    this.gNq = paramInt;
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.nQ(paramInt);
    }
  }
  
  public void m(d.g.a.b<? super IntBuffer, z> paramb)
  {
    p.h(paramb, "listener");
    Object localObject = new StringBuilder("glTextureRenderProc is null ?");
    if (this.hpT == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.m("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
      localObject = this.hpT;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).hqo = paramb;
      }
      return;
    }
  }
  
  public void ng(int paramInt)
  {
    ae.m("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.hpY + " , new degree : " + paramInt, new Object[0]);
    this.hpY = paramInt;
    com.tencent.mm.media.j.b.a locala = this.hpT;
    if (locala != null) {
      locala.ng(paramInt);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.hpW)
    {
      ae.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.hpW = false;
    }
    do
    {
      return;
      if ((this.hpU == null) && (this.gNq == -1))
      {
        ae.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      amH();
      paramGL10 = this.hqb;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    cT(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    ae.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.k.c.hrD;
    c.a.auv();
  }
  
  public void release(boolean paramBoolean)
  {
    ae.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.hpT;
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
    localObject1 = this.hpV;
    if (localObject1 != null) {
      ((com.tencent.mm.media.g.d)localObject1).close();
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = z.Nhr;
      this.hqc = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */