package com.tencent.mm.media.h;

import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTexture", "getExternalTexture", "setExternalTexture", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a eYo = new a((byte)0);
  SurfaceTexture bbI;
  public com.tencent.mm.media.h.b.a eXY;
  private byte[] eXZ;
  public int eYa;
  public boolean eYb;
  private boolean eYc;
  private int eYd;
  public int eYe;
  private boolean eYf;
  public a.f.a.b<? super SurfaceTexture, y> eYg;
  public a.f.a.a<y> eYh;
  public boolean eYi;
  protected int eYj;
  protected int eYk;
  public int eYl;
  public int eYm;
  protected int eYn;
  protected int scaleType;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.eYj = paramInt1;
    this.eYk = paramInt2;
    this.eYl = paramInt3;
    this.eYm = paramInt4;
    this.eYn = paramInt5;
    this.scaleType = paramInt6;
    this.eYa = -1;
    this.eYd = -1;
  }
  
  protected abstract com.tencent.mm.media.h.b.a Ve();
  
  public void Vf()
  {
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null) {
      locala.Vf();
    }
  }
  
  public final IntBuffer Vg()
  {
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null) {
      return locala.eYy;
    }
    return null;
  }
  
  public final SurfaceTexture Vh()
  {
    try
    {
      SurfaceTexture localSurfaceTexture = this.bbI;
      return localSurfaceTexture;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cD(boolean paramBoolean)
  {
    if (this.eYi)
    {
      ab.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.eYc = paramBoolean;
    this.eXY = Ve();
    ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.eYf);
    cn(this.eYl, this.eYm);
    cm(this.eYj, this.eYk);
    jX(this.eYe);
    cE(this.eYf);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.eYc) && ((this.bbI == null) || (this.eYd <= 0)))
    {
      localObject = com.tencent.mm.media.i.b.eZw;
      localObject = new int[1];
      GLES20.glGenTextures(1, (int[])localObject, 0);
      GLES20.glBindTexture(36197, localObject[0]);
      GLES20.glTexParameteri(36197, 10241, 9729);
      GLES20.glTexParameteri(36197, 10240, 9728);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      GLES20.glBindTexture(36197, 0);
      b.a.mT("glGenTextures");
      this.eYa = localObject[0];
      localSurfaceTexture = new SurfaceTexture(this.eYa);
      localObject = this.eYg;
      if (localObject == null) {
        break label398;
      }
      localObject = new b((a.f.a.b)localObject);
    }
    label398:
    for (;;)
    {
      localSurfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)localObject);
      this.bbI = localSurfaceTexture;
      if (this.eYa <= 0)
      {
        localObject = c.eZC;
        c.Vw();
      }
      ab.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.eYa, new Object[0]);
      input(this.eYa);
      ab.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.bbI, new Object[0]);
      this.eYi = true;
      return;
    }
  }
  
  public void cE(boolean paramBoolean)
  {
    ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.eYf = paramBoolean;
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null) {
      locala.eYf = paramBoolean;
    }
  }
  
  public void cm(int paramInt1, int paramInt2)
  {
    ab.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.eYj = paramInt1;
    this.eYk = paramInt2;
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null)
    {
      locala.eYj = paramInt1;
      locala.eYk = paramInt2;
    }
  }
  
  public final void cn(int paramInt1, int paramInt2)
  {
    ab.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.eYl = paramInt1;
    this.eYm = paramInt2;
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null) {
      locala.cn(paramInt1, paramInt2);
    }
  }
  
  public final void input(int paramInt)
  {
    this.eYd = paramInt;
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null) {
      locala.jY(paramInt);
    }
  }
  
  public void jX(int paramInt)
  {
    ab.b("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.eYe + " , new degree : " + paramInt, new Object[0]);
    this.eYe = paramInt;
    com.tencent.mm.media.h.b.a locala = this.eXY;
    if (locala != null) {
      locala.eYe = paramInt;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.eYb)
    {
      ab.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.eYb = false;
    }
    do
    {
      return;
      if ((this.eXZ == null) && (this.eYd == -1))
      {
        ab.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      Vf();
      paramGL10 = this.eYh;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    cn(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.i.b.eZw;
    b.a.Vo();
  }
  
  public void release(boolean paramBoolean)
  {
    ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.eXY;
    if (localObject1 != null) {
      ((com.tencent.mm.media.h.b.a)localObject1).release();
    }
    if (paramBoolean)
    {
      localObject1 = this.bbI;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).release();
      }
    }
    if (this.eYa >= 0)
    {
      GLES20.glDeleteTextures(1, new int[] { this.eYa }, 0);
      this.eYa = -1;
    }
    try
    {
      this.bbI = null;
      localObject1 = y.BMg;
      this.eYi = false;
      return;
    }
    finally {}
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.h.a
 * JD-Core Version:    0.7.0.1
 */