package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.f;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "LIVE_BEAUTY_PARAMS", "", "cropHeight", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "getOutputTexture", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setRotate", "degree", "startScaleAnimation", "scale", "", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-core_release"})
public final class e
  extends com.tencent.mm.media.i.d
{
  public static final e.a grK;
  private boolean gnM;
  private int grA;
  private int grB;
  private i grC;
  private FloatBuffer grD;
  private FloatBuffer grE;
  private final int grF;
  private int grG;
  b<? super Integer, y> grH;
  b<? super Integer, y> grI;
  private au grJ;
  private ArrayList<com.tencent.mm.media.i.b.a> grv;
  public d grw;
  private com.tencent.mm.media.f.d grx;
  private int gry;
  private int grz;
  
  static
  {
    AppMethodBeat.i(209310);
    grK = new e.a((byte)0);
    AppMethodBeat.o(209310);
  }
  
  public e(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(209309);
    this.gnM = paramBoolean;
    this.grv = new ArrayList();
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.grD = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gWC.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.grE = localFloatBuffer;
    this.grF = 1;
    AppMethodBeat.o(209309);
  }
  
  private final void ajI()
  {
    AppMethodBeat.i(209307);
    if ((this.grA <= 0) || (this.gqZ <= 0))
    {
      AppMethodBeat.o(209307);
      return;
    }
    int j;
    int i;
    label57:
    label68:
    float f1;
    float f2;
    if ((this.gVh == 90) || (this.gVh == 270))
    {
      j = 1;
      if (j == 0) {
        break label222;
      }
      i = this.gra;
      if (j == 0) {
        break label230;
      }
      j = this.gqZ;
      f1 = this.grA / i;
      f2 = this.grB / j;
      if (f1 >= f2) {
        break label239;
      }
      this.gry = (i - (i - (int)(this.grA / f2)));
      this.grz = j;
    }
    for (;;)
    {
      ac.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.gry + " height:" + this.grz);
      localObject = ((Iterable)this.grv).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)((Iterator)localObject).next();
        locala.cS(this.gry, this.grz);
        locala.cS(this.gry, this.grz);
      }
      j = 0;
      break;
      label222:
      i = this.gqZ;
      break label57;
      label230:
      j = this.gra;
      break label68;
      label239:
      if (f1 > f2)
      {
        this.grz = (j - (j - (int)(this.grB / f1)));
        this.gry = i;
      }
      else
      {
        this.grz = j;
        this.gry = i;
      }
    }
    super.cR(this.gry, this.grz);
    Object localObject = this.grw;
    if (localObject != null)
    {
      ((d)localObject).cS(this.gry, this.grz);
      AppMethodBeat.o(209307);
      return;
    }
    AppMethodBeat.o(209307);
  }
  
  public final com.tencent.mm.media.i.b.a ajF()
  {
    AppMethodBeat.i(209301);
    this.grC = new i();
    if (this.gnM)
    {
      locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grA, this.grB, this.gVm, this.scaleType);
      AppMethodBeat.o(209301);
      return locala;
    }
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.gqZ, this.gra, this.grA, this.grB, this.gVm, this.scaleType);
    AppMethodBeat.o(209301);
    return locala;
  }
  
  public final void ajG()
  {
    AppMethodBeat.i(209302);
    long l = bs.Gn();
    super.ajG();
    Object localObject2 = this.grC;
    int j;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      i = this.grA;
      j = this.grB;
      localObject3 = this.grE;
      localObject4 = this.grD;
      int m = this.gqX;
      localObject1 = this.gVc;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = ((com.tencent.mm.media.i.b.a)localObject1).gVr;
      if (localObject1 == null) {
        k.fOy();
      }
      int k = this.grF;
      k.h(localObject3, "cubeBuffer");
      k.h(localObject4, "textureCoordBuff");
      k.h(localObject1, "outputTexture");
      if (m != -1)
      {
        GLES20.glUseProgram(((i)localObject2).gse);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, m);
        GLES20.glUniform1i(((i)localObject2).gsh, 0);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gsf, 2, 5126, false, 0, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gsf);
        ((FloatBuffer)localObject4).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gsg, 2, 5126, false, 0, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gsg);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gsf);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gsg);
        GLES20.glBindTexture(36197, 0);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, 0);
        m = ((com.tencent.mm.media.f.d)localObject1).gRW;
        if ((k != 0) && (((i)localObject2).gsb == null))
        {
          ((i)localObject2).gsb = com.tencent.mm.media.f.c.a(true, 18L);
          ((i)localObject2).gsc = new a();
          localObject3 = ((i)localObject2).gsc;
          if (localObject3 != null)
          {
            localObject4 = ((i)localObject2).gsb;
            if (localObject4 == null) {
              k.fOy();
            }
            ((a)localObject3).a(m, (com.tencent.mm.media.f.d)localObject4, k);
          }
          ((i)localObject2).grV = i;
          ((i)localObject2).grW = j;
          localObject3 = ((i)localObject2).gsc;
          if (localObject3 != null)
          {
            if ((j != ((a)localObject3).gra) || (i != ((a)localObject3).gqZ)) {
              ac.i(a.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            ((a)localObject3).gqZ = i;
            ((a)localObject3).gra = j;
            if (((a)localObject3).fZP != null)
            {
              localObject4 = ((a)localObject3).fZP;
              if (localObject4 == null) {
                k.fOy();
              }
              ((XLabEffect)localObject4).setSize(i, j);
            }
            ((a)localObject3).gqX = ((com.tencent.mm.media.f.d)localObject1).gRW;
            ((a)localObject3).ajz();
          }
          localObject1 = ((i)localObject2).gsb;
          label469:
          this.grx = ((com.tencent.mm.media.f.d)localObject1);
          localObject1 = ((Iterable)this.grv).iterator();
          label489:
          if (!((Iterator)localObject1).hasNext()) {
            break label657;
          }
          localObject2 = (com.tencent.mm.media.i.b.a)((Iterator)localObject1).next();
          localObject3 = this.grx;
          if (localObject3 == null) {
            break label652;
          }
        }
      }
    }
    label652:
    for (int i = ((com.tencent.mm.media.f.d)localObject3).gRW;; i = -1)
    {
      ((com.tencent.mm.media.i.b.a)localObject2).no(i);
      ((com.tencent.mm.media.i.b.a)localObject2).ajG();
      this.grx = ((com.tencent.mm.media.i.b.a)localObject2).gVr;
      break label489;
      if ((((i)localObject2).grV == i) && (((i)localObject2).grW == j)) {
        break;
      }
      localObject3 = ((i)localObject2).gsb;
      if (localObject3 != null) {
        ((com.tencent.mm.media.f.d)localObject3).close();
      }
      ((i)localObject2).gsb = com.tencent.mm.media.f.c.a(true, 18L);
      localObject3 = ((i)localObject2).gsc;
      if (localObject3 == null) {
        break;
      }
      localObject4 = ((i)localObject2).gsb;
      if (localObject4 == null) {
        k.fOy();
      }
      k.h(localObject4, "outputTexture");
      ((a)localObject3).gqY = ((com.tencent.mm.media.f.d)localObject4);
      break;
      break label469;
      localObject1 = null;
      break label469;
    }
    label657:
    Object localObject1 = this.grw;
    if (localObject1 != null)
    {
      localObject2 = this.grx;
      if (localObject2 == null) {
        break label752;
      }
    }
    label752:
    for (i = ((com.tencent.mm.media.f.d)localObject2).gRW;; i = -1)
    {
      ((com.tencent.mm.media.i.b.e)localObject1).gqX = i;
      localObject1 = this.grw;
      if (localObject1 != null) {
        ((d)localObject1).ajG();
      }
      this.grG += 1;
      localObject1 = this.grI;
      if (localObject1 == null) {
        break;
      }
      ((b)localObject1).ay(Integer.valueOf((int)bs.aO(l)));
      AppMethodBeat.o(209302);
      return;
    }
    AppMethodBeat.o(209302);
  }
  
  public final com.tencent.mm.media.f.d ajH()
  {
    AppMethodBeat.i(209306);
    com.tencent.mm.media.f.d locald = this.grx;
    if (locald != null) {
      locald.setSize(this.gry, this.grz);
    }
    locald = this.grx;
    AppMethodBeat.o(209306);
    return locald;
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209304);
    d locald = this.grw;
    if (locald != null)
    {
      locald.cR(paramInt1, paramInt2);
      AppMethodBeat.o(209304);
      return;
    }
    AppMethodBeat.o(209304);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209303);
    super.cS(paramInt1, paramInt2);
    ajI();
    AppMethodBeat.o(209303);
  }
  
  public final void f(b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(209298);
    au localau;
    if (paramb == null)
    {
      localau = this.grJ;
      if (localau != null) {
        localau.stopTimer();
      }
      localau = this.grJ;
      if (localau != null) {
        localau.quitSafely();
      }
    }
    for (;;)
    {
      this.grH = paramb;
      AppMethodBeat.o(209298);
      return;
      if (this.grJ != null)
      {
        localau = this.grJ;
        if ((localau == null) || (localau.isQuit() != true)) {}
      }
      else
      {
        this.grJ = new au("LiveRenderFpsCounter", (au.a)new b(this), true);
      }
      localau = this.grJ;
      if (localau != null) {
        localau.Ah(1000L);
      }
    }
  }
  
  public final void mE(int paramInt)
  {
    AppMethodBeat.i(209305);
    super.mE(paramInt);
    ajI();
    AppMethodBeat.o(209305);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209300);
    this.grA = paramInt1;
    this.grB = paramInt2;
    paramGL10 = this.grw;
    if (paramGL10 != null) {
      paramGL10.cR(paramInt1, paramInt2);
    }
    ajI();
    paramGL10 = this.gVc;
    if (paramGL10 != null)
    {
      paramGL10.gVv = true;
      AppMethodBeat.o(209300);
      return;
    }
    AppMethodBeat.o(209300);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(209299);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.grw = new d(this.gqZ, this.gra, this.grA, this.grB);
    AppMethodBeat.o(209299);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(209308);
    super.release(paramBoolean);
    Object localObject1 = ((Iterable)this.grv).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.i.b.a)((Iterator)localObject1).next()).release();
    }
    localObject1 = this.grx;
    if (localObject1 != null) {
      ((com.tencent.mm.media.f.d)localObject1).close();
    }
    localObject1 = this.grw;
    if (localObject1 != null) {
      ((d)localObject1).release();
    }
    localObject1 = this.grC;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).gsd;
      if (localObject2 != null) {
        ((com.tencent.mm.media.i.b.e)localObject2).release();
      }
      localObject2 = ((i)localObject1).gsb;
      if (localObject2 != null) {
        ((com.tencent.mm.media.f.d)localObject2).close();
      }
      localObject2 = ((i)localObject1).gsc;
      if (localObject2 != null)
      {
        localObject3 = a.TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ac.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((a)localObject2).gqY;
      if (localObject3 != null) {
        ((com.tencent.mm.media.f.d)localObject3).close();
      }
      if (((a)localObject2).fZP != null)
      {
        localObject3 = ((a)localObject2).fZP;
        if (localObject3 == null) {
          k.fOy();
        }
        ((XLabEffect)localObject3).destroy();
        ((a)localObject2).fZP = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace(a.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(209308);
    }
    GLES20.glDeleteProgram(((i)localObject1).gse);
    localObject1 = this.grJ;
    if (localObject1 != null) {
      ((au)localObject1).stopTimer();
    }
    localObject1 = this.grJ;
    if (localObject1 != null)
    {
      ((au)localObject1).quit();
      AppMethodBeat.o(209308);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements au.a
  {
    b(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(209297);
      b localb = this.grL.grH;
      if (localb != null) {
        localb.ay(Integer.valueOf(e.a(this.grL)));
      }
      e.b(this.grL);
      AppMethodBeat.o(209297);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.e
 * JD-Core Version:    0.7.0.1
 */