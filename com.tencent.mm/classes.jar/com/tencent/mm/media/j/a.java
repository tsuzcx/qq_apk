package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "profileData", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;", "getProfileData", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;", "setProfileData", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getExternalTexture", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "RenderProfileData", "plugin-mediaeditor_release"})
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a kYo = new a((byte)0);
  public com.tencent.mm.media.j.b.a kYb;
  private byte[] kYc;
  public d kYd;
  public boolean kYe;
  private boolean kYf;
  public int kYg;
  public boolean kYh;
  public b kYi;
  public kotlin.g.a.b<? super SurfaceTexture, x> kYj;
  public kotlin.g.a.a<x> kYk;
  public boolean kYl;
  private int kYm;
  private int kYn;
  private int kre;
  public int krg;
  public int krh;
  public int ksu;
  public int ksv;
  private SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.krg = paramInt1;
    this.krh = paramInt2;
    this.ksu = paramInt3;
    this.ksv = paramInt4;
    this.kYm = paramInt5;
    this.kYn = paramInt6;
    this.kre = -1;
    this.kYi = new b();
  }
  
  protected abstract com.tencent.mm.media.j.b.a aMT();
  
  public void aMU()
  {
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.aMU();
    }
  }
  
  public d aMV()
  {
    return this.kYd;
  }
  
  public void aVe()
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.kYH = true;
    }
  }
  
  public int aVf()
  {
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      return locala.kYJ;
    }
    return 0;
  }
  
  public int aVg()
  {
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      return locala.kYK;
    }
    return 0;
  }
  
  protected final int aVh()
  {
    return this.kYm;
  }
  
  public void du(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.ksu = paramInt1;
    this.ksv = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.du(paramInt1, paramInt2);
    }
  }
  
  public void dv(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.krg = paramInt1;
    this.krh = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.dv(paramInt1, paramInt2);
    }
  }
  
  public final void fF(boolean paramBoolean)
  {
    if (this.kYl)
    {
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.kYf = paramBoolean;
    this.kYb = aMT();
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.kYh);
    du(this.ksu, this.ksv);
    dv(this.krg, this.krh);
    tm(this.kYg);
    fj(this.kYh);
    Object localObject;
    SurfaceTexture localSurfaceTexture;
    if ((this.kYf) && ((this.surfaceTexture == null) || (this.kre <= 0)))
    {
      this.kYd = com.tencent.mm.media.g.c.a(false, 12L);
      localObject = this.kYd;
      if (localObject == null) {
        p.iCn();
      }
      localSurfaceTexture = new SurfaceTexture(((d)localObject).kVj);
      localObject = this.kYj;
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
      localObject = this.kYd;
      if (localObject != null)
      {
        i = ((d)localObject).kVj;
        if (i <= 0)
        {
          localObject = f.laB;
          f.aVW();
        }
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.kYd, new Object[0]);
        localObject = this.kYd;
        if (localObject == null) {
          break label361;
        }
      }
      for (int i = ((d)localObject).kVj;; i = -1)
      {
        tZ(i);
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
        this.kYl = true;
        return;
        i = -1;
        break;
      }
    }
  }
  
  public void fj(boolean paramBoolean)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.kYh = paramBoolean;
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.kYh = paramBoolean;
    }
  }
  
  public final int getScaleType()
  {
    return this.kYn;
  }
  
  protected final SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
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
  
  public void m(kotlin.g.a.b<? super IntBuffer, x> paramb)
  {
    p.k(paramb, "listener");
    Object localObject = new StringBuilder("glTextureRenderProc is null ?");
    if (this.kYb == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", bool, new Object[0]);
      localObject = this.kYb;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.a)localObject).kYD = paramb;
      }
      return;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.kYe)
    {
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.kYe = false;
    }
    do
    {
      return;
      if ((this.kYc == null) && (this.kre == -1))
      {
        Log.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      paramGL10 = this.kYi;
      paramGL10.kYr = Util.currentTicks();
      if (paramGL10.kYs == 0L) {
        paramGL10.kYs = paramGL10.kYr;
      }
      aMU();
      paramGL10 = this.kYi;
      paramGL10.kYq += 1;
      paramGL10.kYp += Util.ticksToNow(paramGL10.kYr);
      paramGL10.kYt = Util.currentTicks();
      paramGL10 = this.kYk;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    du(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.k.c.lar;
    c.a.aVB();
  }
  
  public void release(boolean paramBoolean)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean);
    Object localObject1 = this.kYb;
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
    localObject1 = this.kYd;
    if (localObject1 != null) {
      ((d)localObject1).close();
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = x.aazN;
      this.kYl = false;
      return;
    }
    finally {}
  }
  
  public final void tZ(int paramInt)
  {
    this.kre = paramInt;
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.ua(paramInt);
    }
  }
  
  public void tm(int paramInt)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.kYg + " , new degree : " + paramInt, new Object[0]);
    this.kYg = paramInt;
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      locala.tm(paramInt);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer$Companion;", "", "()V", "TAG", "", "getExternalTextureRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getYUVRenderer", "plugin-mediaeditor_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;", "", "()V", "firstRenderStart", "", "fps", "", "getFps", "()I", "lastRenderEnd", "lastRenderStart", "renderCost", "getRenderCost", "()J", "renderCostSum", "getRenderCostSum", "setRenderCostSum", "(J)V", "renderCount", "getRenderCount", "setRenderCount", "(I)V", "renderEnd", "", "renderStart", "plugin-mediaeditor_release"})
  public static final class b
  {
    long kYp;
    int kYq;
    long kYr;
    long kYs;
    long kYt;
    
    public final long aVi()
    {
      if (this.kYq == 0) {
        return 0L;
      }
      return this.kYp / this.kYq;
    }
    
    public final int getFps()
    {
      AppMethodBeat.i(261842);
      if ((this.kYs <= 0L) || (this.kYq == 0))
      {
        AppMethodBeat.o(261842);
        return 0;
      }
      long l = this.kYt - this.kYs;
      if (l <= 0L)
      {
        AppMethodBeat.o(261842);
        return 0;
      }
      int i = kotlin.h.a.dm(this.kYq * 1000.0F / (float)l);
      AppMethodBeat.o(261842);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */