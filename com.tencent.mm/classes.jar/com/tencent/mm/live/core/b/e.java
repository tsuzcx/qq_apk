package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "LIVE_BEAUTY_PARAMS", "", "cropHeight", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "rendererFpsCountCallback", "Lkotlin/Function1;", "", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "getOutputTexture", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setRotate", "degree", "startScaleAnimation", "scale", "", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-core_release"})
public final class e
  extends com.tencent.mm.media.i.d
{
  public static final a qTA;
  private int HEg;
  private int gtF;
  private int gtG;
  private FloatBuffer guS;
  private FloatBuffer guT;
  private ArrayList<com.tencent.mm.media.i.b.a> qSL;
  public d qSM;
  private com.tencent.mm.media.f.d qSN;
  private int qSO;
  private i qSP;
  private final int qSQ;
  private int qST;
  b<? super Integer, y> qSU;
  b<? super Integer, y> qSV;
  private av qSW;
  private boolean qyW;
  
  static
  {
    AppMethodBeat.i(205773);
    qTA = new a((byte)0);
    AppMethodBeat.o(205773);
  }
  
  public e(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(205772);
    this.qyW = paramBoolean;
    this.qSL = new ArrayList();
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.guS = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.j.c.gwe.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    k.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.guT = localFloatBuffer;
    this.qSQ = 1;
    this.qSW = new av("LiveRenderFpsCounter", (av.a)new b(this), true);
    AppMethodBeat.o(205772);
  }
  
  private final void cAh()
  {
    AppMethodBeat.i(205770);
    if ((this.gtF <= 0) || (this.guI <= 0))
    {
      AppMethodBeat.o(205770);
      return;
    }
    int j;
    int i;
    label57:
    label68:
    float f1;
    float f2;
    if ((this.guD == 90) || (this.guD == 270))
    {
      j = 1;
      if (j == 0) {
        break label222;
      }
      i = this.guJ;
      if (j == 0) {
        break label230;
      }
      j = this.guI;
      f1 = this.gtF / i;
      f2 = this.gtG / j;
      if (f1 >= f2) {
        break label239;
      }
      this.HEg = (i - (i - (int)(this.gtF / f2)));
      this.qSO = j;
    }
    for (;;)
    {
      ad.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.HEg + " height:" + this.qSO);
      localObject = ((Iterable)this.qSL).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)((Iterator)localObject).next();
        locala.cS(this.HEg, this.qSO);
        locala.cS(this.HEg, this.qSO);
      }
      j = 0;
      break;
      label222:
      i = this.guI;
      break label57;
      label230:
      j = this.guJ;
      break label68;
      label239:
      if (f1 > f2)
      {
        this.qSO = (j - (j - (int)(this.gtG / f1)));
        this.HEg = i;
      }
    }
    super.cT(this.HEg, this.qSO);
    Object localObject = this.qSM;
    if (localObject != null)
    {
      ((d)localObject).cS(this.HEg, this.qSO);
      AppMethodBeat.o(205770);
      return;
    }
    AppMethodBeat.o(205770);
  }
  
  public final com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(205764);
    this.qSP = new i();
    this.qSW.vE(1000L);
    if (this.qyW)
    {
      locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.e(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
      AppMethodBeat.o(205764);
      return locala;
    }
    com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
    AppMethodBeat.o(205764);
    return locala;
  }
  
  public final void akk()
  {
    AppMethodBeat.i(205765);
    long l = bt.GC();
    super.akk();
    Object localObject2 = this.qSP;
    Object localObject3;
    if (localObject2 != null)
    {
      i = this.guK;
      int j = this.guL;
      localObject3 = this.guT;
      Object localObject4 = this.guS;
      int m = this.guC;
      localObject1 = this.gux;
      if (localObject1 == null) {
        k.fvU();
      }
      localObject1 = ((com.tencent.mm.media.i.b.a)localObject1).guU;
      if (localObject1 == null) {
        k.fvU();
      }
      int k = this.qSQ;
      k.h(localObject3, "cubeBuffer");
      k.h(localObject4, "textureCoordBuff");
      k.h(localObject1, "outputTexture");
      if (m != -1)
      {
        GLES20.glUseProgram(((i)localObject2).gvL);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, m);
        GLES20.glUniform1i(((i)localObject2).gvO, 0);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gvM, 2, 5126, false, 0, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gvM);
        ((FloatBuffer)localObject4).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gvN, 2, 5126, false, 0, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gvN);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gvM);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gvN);
        GLES20.glBindTexture(36197, 0);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, 0);
        m = ((com.tencent.mm.media.f.d)localObject1).gro;
        if ((k != 0) && (((i)localObject2).oSo == null))
        {
          ((i)localObject2).oSo = com.tencent.mm.media.f.c.a(true, 18L);
          ((i)localObject2).qUn = new a();
          localObject3 = ((i)localObject2).qUn;
          if (localObject3 != null)
          {
            localObject4 = ((i)localObject2).oSo;
            if (localObject4 == null) {
              k.fvU();
            }
            ((a)localObject3).a(m, (com.tencent.mm.media.f.d)localObject4, k);
          }
        }
        localObject3 = ((i)localObject2).qUn;
        if (localObject3 != null)
        {
          if ((j != ((a)localObject3).guJ) || (i != ((a)localObject3).guI)) {
            ad.i(a.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          }
          ((a)localObject3).guI = i;
          ((a)localObject3).guJ = j;
          if (((a)localObject3).fVU != null)
          {
            localObject4 = ((a)localObject3).fVU;
            if (localObject4 == null) {
              k.fvU();
            }
            ((XLabEffect)localObject4).setSize(i, j);
          }
          ((a)localObject3).guC = ((com.tencent.mm.media.f.d)localObject1).gro;
          ((a)localObject3).cta();
        }
        localObject1 = ((i)localObject2).oSo;
        this.qSN = ((com.tencent.mm.media.f.d)localObject1);
        localObject1 = ((Iterable)this.qSL).iterator();
        label477:
        if (!((Iterator)localObject1).hasNext()) {
          break label553;
        }
        localObject2 = (com.tencent.mm.media.i.b.a)((Iterator)localObject1).next();
        localObject3 = this.qSN;
        if (localObject3 == null) {
          break label548;
        }
      }
    }
    label548:
    for (int i = ((com.tencent.mm.media.f.d)localObject3).gro;; i = -1)
    {
      ((com.tencent.mm.media.i.b.a)localObject2).mA(i);
      ((com.tencent.mm.media.i.b.a)localObject2).akk();
      this.qSN = ((com.tencent.mm.media.i.b.a)localObject2).guU;
      break label477;
      break;
      localObject1 = null;
      break;
    }
    label553:
    Object localObject1 = this.qSM;
    if (localObject1 != null)
    {
      localObject2 = this.qSN;
      if (localObject2 == null) {
        break label648;
      }
    }
    label648:
    for (i = ((com.tencent.mm.media.f.d)localObject2).gro;; i = -1)
    {
      ((com.tencent.mm.media.i.b.d)localObject1).guC = i;
      localObject1 = this.qSM;
      if (localObject1 != null) {
        ((d)localObject1).akk();
      }
      this.qST += 1;
      localObject1 = this.qSV;
      if (localObject1 == null) {
        break;
      }
      ((b)localObject1).aA(Integer.valueOf((int)bt.aS(l)));
      AppMethodBeat.o(205765);
      return;
    }
    AppMethodBeat.o(205765);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205766);
    super.cS(paramInt1, paramInt2);
    cAh();
    AppMethodBeat.o(205766);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205767);
    d locald = this.qSM;
    if (locald != null)
    {
      locald.cT(paramInt1, paramInt2);
      AppMethodBeat.o(205767);
      return;
    }
    AppMethodBeat.o(205767);
  }
  
  public final com.tencent.mm.media.f.d czI()
  {
    AppMethodBeat.i(205769);
    com.tencent.mm.media.f.d locald = this.qSN;
    if (locald != null) {
      locald.setSize(this.HEg, this.qSO);
    }
    locald = this.qSN;
    AppMethodBeat.o(205769);
    return locald;
  }
  
  public final void mz(int paramInt)
  {
    AppMethodBeat.i(205768);
    super.mz(paramInt);
    cAh();
    AppMethodBeat.o(205768);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205763);
    this.gtF = paramInt1;
    this.gtG = paramInt2;
    paramGL10 = this.qSM;
    if (paramGL10 != null) {
      paramGL10.cT(paramInt1, paramInt2);
    }
    cAh();
    paramGL10 = this.gux;
    if (paramGL10 != null)
    {
      paramGL10.guY = true;
      AppMethodBeat.o(205763);
      return;
    }
    AppMethodBeat.o(205763);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(205762);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.qSM = new d(this.guI, this.guJ, this.guK, this.guL);
    AppMethodBeat.o(205762);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(205771);
    super.release(paramBoolean);
    i locali = this.qSP;
    Object localObject1;
    Object localObject2;
    if (locali != null)
    {
      localObject1 = locali.zyt;
      if (localObject1 != null) {
        ((com.tencent.mm.media.i.b.d)localObject1).release();
      }
      localObject1 = locali.oSo;
      if (localObject1 != null) {
        ((com.tencent.mm.media.f.d)localObject1).close();
      }
      localObject1 = locali.qUn;
      if (localObject1 != null)
      {
        localObject2 = a.TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject2, "clear %s %d", new Object[] { localObject1, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject2 = ((a)localObject1).zwE;
      if (localObject2 != null) {
        ((com.tencent.mm.media.f.d)localObject2).close();
      }
      if (((a)localObject1).fVU != null)
      {
        localObject2 = ((a)localObject1).fVU;
        if (localObject2 == null) {
          k.fvU();
        }
        ((XLabEffect)localObject2).destroy();
        ((a)localObject1).fVU = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(a.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    GLES20.glDeleteProgram(locali.gvL);
    this.qSW.stopTimer();
    AppMethodBeat.o(205771);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(205761);
      b localb = this.qTC.qSU;
      if (localb != null) {
        localb.aA(Integer.valueOf(e.a(this.qTC)));
      }
      e.b(this.qTC);
      AppMethodBeat.o(205761);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.e
 * JD-Core Version:    0.7.0.1
 */