package com.tencent.mm.media.j;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getExternalTextureObj", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setExternalTextureObj", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "profileData", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;", "getProfileData", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;", "setProfileData", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getOutputTexture", "getSnapHeight", "getSnapWidth", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "takePhoto", "updateDrawViewSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "format", "Landroid/media/MediaFormat;", "Companion", "RenderProfileData", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements GLSurfaceView.Renderer
{
  public static final a.a nDj = new a.a((byte)0);
  private int mVb;
  public int mVd;
  public int mVe;
  public int mWn;
  public int mWo;
  private int nDk;
  private int nDl;
  public com.tencent.mm.media.j.b.a nDm;
  private byte[] nDn;
  private d nDo;
  public boolean nDp;
  private boolean nDq;
  public int nDr;
  public b nDs;
  public b<? super SurfaceTexture, ah> nDt;
  public kotlin.g.a.a<ah> nDu;
  public boolean nDv;
  public boolean nvG;
  private SurfaceTexture surfaceTexture;
  
  public a()
  {
    this(0, 0, 0, 0, 63);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mVd = paramInt1;
    this.mVe = paramInt2;
    this.mWn = paramInt3;
    this.mWo = paramInt4;
    this.nDk = paramInt5;
    this.nDl = paramInt6;
    this.mVb = -1;
    this.nDs = new b();
  }
  
  private static final void b(b paramb, SurfaceTexture paramSurfaceTexture)
  {
    paramb.invoke(paramSurfaceTexture);
  }
  
  public void G(b<? super IntBuffer, ah> paramb)
  {
    s.u(paramb, "listener");
    if (this.nDm == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", s.X("glTextureRenderProc is null ?", Boolean.valueOf(bool)), new Object[0]);
      com.tencent.mm.media.j.b.a locala = this.nDm;
      if (locala != null) {
        locala.nDL = paramb;
      }
      return;
    }
  }
  
  protected abstract com.tencent.mm.media.j.b.a bgD();
  
  public void bgE()
  {
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.bgE();
    }
  }
  
  public d bgF()
  {
    return this.nDo;
  }
  
  protected final int bpJ()
  {
    return this.nDk;
  }
  
  protected final d bpK()
  {
    return this.nDo;
  }
  
  public final SurfaceTexture bpL()
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
  
  public void bpM()
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", "takePhoto");
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.nDP = true;
    }
  }
  
  public int bpN()
  {
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala == null) {
      return 0;
    }
    return locala.nDR;
  }
  
  public int bpO()
  {
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala == null) {
      return 0;
    }
    return locala.nDS;
  }
  
  public d bpP()
  {
    return this.nDo;
  }
  
  public void ek(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.mWn = paramInt1;
    this.mWo = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.ek(paramInt1, paramInt2);
    }
  }
  
  public void el(int paramInt1, int paramInt2)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + paramInt1 + " , height : " + paramInt2, new Object[0]);
    this.mVd = paramInt1;
    this.mVe = paramInt2;
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.el(paramInt1, paramInt2);
    }
  }
  
  public void fQ(boolean paramBoolean)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + paramBoolean);
    this.nvG = paramBoolean;
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.gr(paramBoolean);
    }
  }
  
  public final int getScaleType()
  {
    return this.nDl;
  }
  
  protected final SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public void gp(boolean paramBoolean)
  {
    Object localObject2 = null;
    if (this.nDv)
    {
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
      return;
    }
    this.nDq = paramBoolean;
    this.nDm = bgD();
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.nvG);
    ek(this.mWn, this.mWo);
    el(this.mVd, this.mVe);
    th(this.nDr);
    fQ(this.nvG);
    Object localObject1;
    if ((this.nDq) && ((this.surfaceTexture == null) || (this.mVb <= 0)))
    {
      this.nDo = com.tencent.mm.media.g.c.d(false, 12L);
      GLES20.glFinish();
      localObject1 = this.nDo;
      if (localObject1 != null) {
        break label358;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        SurfaceTexture localSurfaceTexture = new SurfaceTexture(((Integer)localObject1).intValue());
        localObject1 = this.nDt;
        if (localObject1 != null) {
          break label369;
        }
        localObject1 = localObject2;
        label208:
        localSurfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)localObject1);
        localObject1 = ah.aiuX;
        this.surfaceTexture = localSurfaceTexture;
        localObject1 = this.nDo;
        if (localObject1 != null) {
          break label381;
        }
        i = -1;
        label235:
        if (i <= 0)
        {
          localObject1 = f.nFE;
          f.bqE();
        }
        Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.nDo, new Object[0]);
      }
      localObject1 = this.nDo;
      if (localObject1 != null) {
        break label389;
      }
    }
    label389:
    for (int i = -1;; i = ((d)localObject1).nAF)
    {
      tY(i);
      Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + paramBoolean + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
      this.nDv = true;
      return;
      label358:
      localObject1 = Integer.valueOf(((d)localObject1).nAF);
      break;
      label369:
      localObject1 = new a..ExternalSyntheticLambda0((b)localObject1);
      break label208;
      label381:
      i = ((d)localObject1).nAF;
      break label235;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.nDp)
    {
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
      this.nDp = false;
    }
    do
    {
      return;
      if ((this.nDn == null) && (this.mVb == -1))
      {
        Log.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        return;
      }
      paramGL10 = this.nDs;
      paramGL10.nDy = Util.currentTicks();
      if (paramGL10.nDz == 0L) {
        paramGL10.nDz = paramGL10.nDy;
      }
      bgE();
      paramGL10 = this.nDs;
      paramGL10.nDx += 1;
      paramGL10.nDw += Util.ticksToNow(paramGL10.nDy);
      paramGL10.nDA = Util.currentTicks();
      if (this.nDq)
      {
        GLES20.glFinish();
        paramGL10 = com.tencent.mm.media.j.c.a.nFo;
        com.tencent.mm.media.j.c.a.gt(false);
      }
      paramGL10 = this.nDu;
    } while (paramGL10 == null);
    paramGL10.invoke();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + paramInt1 + ", height:" + paramInt2);
    ek(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Log.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
    paramGL10 = com.tencent.mm.media.util.c.nFs;
    c.a.bqi();
  }
  
  public void release(boolean paramBoolean)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " called release, shouldDestroySurfaceTexture: " + paramBoolean + ", externalTextureObj:" + this.nDo + ", surfaceTexture:" + this.surfaceTexture, new Object[0]);
    Object localObject1 = this.nDm;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.a)localObject1).release();
    }
    localObject1 = this.nDo;
    if (localObject1 != null) {
      ((d)localObject1).close();
    }
    this.nDo = null;
    GLES20.glFinish();
    if (paramBoolean)
    {
      localObject1 = this.surfaceTexture;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).release();
      }
    }
    try
    {
      this.surfaceTexture = null;
      localObject1 = ah.aiuX;
      this.nDv = false;
      return;
    }
    finally {}
  }
  
  public final void tY(int paramInt)
  {
    this.mVb = paramInt;
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.uc(paramInt);
    }
  }
  
  public void th(int paramInt)
  {
    Log.printInfoStack("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.nDr + " , new degree : " + paramInt, new Object[0]);
    this.nDr = paramInt;
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala != null) {
      locala.th(paramInt);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/AbsSurfaceRenderer$RenderProfileData;", "", "()V", "firstRenderStart", "", "fps", "", "getFps", "()I", "lastRenderEnd", "lastRenderStart", "renderCost", "getRenderCost", "()J", "renderCostSum", "getRenderCostSum", "setRenderCostSum", "(J)V", "renderCount", "getRenderCount", "setRenderCount", "(I)V", "renderEnd", "", "renderStart", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    long nDA;
    long nDw;
    int nDx;
    long nDy;
    long nDz;
    
    public final long bpQ()
    {
      if (this.nDx == 0) {
        return 0L;
      }
      return this.nDw / this.nDx;
    }
    
    public final int getFps()
    {
      AppMethodBeat.i(237732);
      if ((this.nDz <= 0L) || (this.nDx == 0))
      {
        AppMethodBeat.o(237732);
        return 0;
      }
      long l = this.nDA - this.nDz;
      if (l <= 0L)
      {
        AppMethodBeat.o(237732);
        return 0;
      }
      int i = kotlin.h.a.eH(this.nDx * 1000.0F / (float)l);
      AppMethodBeat.o(237732);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.a
 * JD-Core Version:    0.7.0.1
 */