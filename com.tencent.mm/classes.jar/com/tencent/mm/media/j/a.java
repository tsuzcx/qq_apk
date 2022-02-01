package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a.a ijz = new a.a((byte)0);
  private int hDl;
  public int hDn;
  public int hDo;
  public int hEp;
  public int hEq;
  public com.tencent.mm.media.j.b.a ijo;
  private byte[] ijp;
  public d ijq;
  public boolean ijr;
  private boolean ijs;
  public int ijt;
  public boolean iju;
  public kotlin.g.a.b<? super SurfaceTexture, x> ijv;
  public kotlin.g.a.a<x> ijw;
  public boolean ijx;
  protected int ijy;
  protected int scaleType;
  SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.hDn = paramInt1;
    this.hDo = paramInt2;
    this.hEp = paramInt3;
    this.hEq = paramInt4;
    this.ijy = paramInt5;
    this.scaleType = paramInt6;
    this.hDl = -1;
  }
  
  protected abstract com.tencent.mm.media.j.b.a aEC();
  
  public void aED()
  {
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.aED();
    }
  }
  
  public d aEE()
  {
    return this.ijq;
  }
  
  public void aML()
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.ijM = true;
    }
  }
  
  public int aMM()
  {
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      return locala.ijO;
    }
    return 0;
  }
  
  public int aMN()
  {
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      return locala.ijP;
    }
    return 0;
  }
  
  public void cY(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.hEp = paramInt1;
    this.hEq = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.cY(paramInt1, paramInt2);
    }
  }
  
  public void cZ(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.hDn = paramInt1;
    this.hDo = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.cZ(paramInt1, paramInt2);
    }
  }
  
  public void eD(boolean paramBoolean)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.iju = paramBoolean;
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.iju = paramBoolean;
    }
  }
  
  public final void eY(boolean paramBoolean)
  {
    if (this.ijx)
    {
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.ijs = paramBoolean;
    this.ijo = aEC();
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.iju);
    cY(this.hEp, this.hEq);
    cZ(this.hDn, this.hDo);
    qx(this.ijt);
    eD(this.iju);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.ijs) && ((this.surfaceTexture == null) || (this.hDl <= 0)))
    {
      this.ijq = com.tencent.mm.media.g.c.a(false, 12L);
      localObject = this.ijq;
      if (localObject == null) {
        p.hyc();
      }
      localSurfaceTexture = new SurfaceTexture(((d)localObject).igv);
      localObject = this.ijv;
      if (localObject == null) {
        break label366;
      }
      localObject = new b((kotlin.g.a.b)localObject);
    }
    label361:
    label366:
    for (;;)
    {
      localSurfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)localObject);
      this.surfaceTexture = localSurfaceTexture;
      localObject = this.ijq;
      if (localObject != null)
      {
        i = ((d)localObject).igv;
        if (i <= 0)
        {
          localObject = e.ilC;
          e.aNs();
        }
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.ijq, new Object[0]);
        localObject = this.ijq;
        if (localObject == null) {
          break label361;
        }
      }
      for (int i = ((d)localObject).igv;; i = -1)
      {
        input(i);
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
        this.ijx = true;
        return;
        i = -1;
        break;
      }
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
    this.hDl = paramInt;
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.rl(paramInt);
    }
  }
  
  public void m(kotlin.g.a.b<? super IntBuffer, x> paramb)
  {
    p.h(paramb, "listener");
    Object localObject = new StringBuilder("glTextureRenderProc is null ?");
    if (this.ijo == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
      localObject = this.ijo;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).ijJ = paramb;
      }
      return;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.ijr)
    {
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.ijr = false;
    }
    do
    {
      return;
      if ((this.ijp == null) && (this.hDl == -1))
      {
        Log.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      aED();
      paramGL10 = this.ijw;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    cY(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.k.c.ilt;
    c.a.aMY();
  }
  
  public void qx(int paramInt)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.ijt + " , new degree : " + paramInt, new Object[0]);
    this.ijt = paramInt;
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      locala.qx(paramInt);
    }
  }
  
  public void release(boolean paramBoolean)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.ijo;
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
    localObject1 = this.ijq;
    if (localObject1 != null) {
      ((d)localObject1).close();
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = x.SXb;
      this.ijx = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */