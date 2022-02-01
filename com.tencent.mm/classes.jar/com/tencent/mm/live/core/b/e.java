package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "LIVE_BEAUTY_PARAMS", "", "cropHeight", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "getOutputTexture", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setRotate", "degree", "startScaleAnimation", "scale", "", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-core_release"})
public final class e
  extends com.tencent.mm.media.j.d
{
  public static final e.a gOb;
  private boolean gKe;
  private ArrayList<com.tencent.mm.media.j.b.a> gNO;
  public d gNP;
  private com.tencent.mm.media.g.d gNQ;
  private int gNR;
  private int gNS;
  private i gNT;
  private FloatBuffer gNU;
  private FloatBuffer gNV;
  private final int gNW;
  private int gNX;
  d.g.a.b<? super Integer, z> gNY;
  d.g.a.b<? super Integer, z> gNZ;
  private aw gOa;
  private int outputHeight;
  private int outputWidth;
  
  static
  {
    AppMethodBeat.i(196980);
    gOb = new e.a((byte)0);
    AppMethodBeat.o(196980);
  }
  
  public e(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(196979);
    this.gKe = paramBoolean;
    this.gNO = new ArrayList();
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gNU = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hrw.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gNV = localFloatBuffer;
    this.gNW = 1;
    AppMethodBeat.o(196979);
  }
  
  private final void amJ()
  {
    AppMethodBeat.i(196977);
    if ((this.outputWidth <= 0) || (this.gNs <= 0))
    {
      AppMethodBeat.o(196977);
      return;
    }
    int j;
    int i;
    label57:
    label68:
    float f1;
    float f2;
    if ((this.hpY == 90) || (this.hpY == 270))
    {
      j = 1;
      if (j == 0) {
        break label222;
      }
      i = this.gNt;
      if (j == 0) {
        break label230;
      }
      j = this.gNs;
      f1 = this.outputWidth / i;
      f2 = this.outputHeight / j;
      if (f1 >= f2) {
        break label239;
      }
      this.gNR = (i - (i - (int)(this.outputWidth / f2)));
      this.gNS = j;
    }
    for (;;)
    {
      ae.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.gNR + " height:" + this.gNS);
      localObject = ((Iterable)this.gNO).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)((Iterator)localObject).next();
        locala.cU(this.gNR, this.gNS);
        locala.cU(this.gNR, this.gNS);
      }
      j = 0;
      break;
      label222:
      i = this.gNs;
      break label57;
      label230:
      j = this.gNt;
      break label68;
      label239:
      if (f1 > f2)
      {
        this.gNS = (j - (j - (int)(this.outputHeight / f1)));
        this.gNR = i;
      }
      else
      {
        this.gNS = j;
        this.gNR = i;
      }
    }
    super.cT(this.gNR, this.gNS);
    Object localObject = this.gNP;
    if (localObject != null)
    {
      ((d)localObject).cU(this.gNR, this.gNS);
      AppMethodBeat.o(196977);
      return;
    }
    AppMethodBeat.o(196977);
  }
  
  public final com.tencent.mm.media.j.b.a amG()
  {
    AppMethodBeat.i(196971);
    this.gNT = new i();
    if (this.gKe)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.outputWidth, this.outputHeight, this.hqd, this.scaleType);
      AppMethodBeat.o(196971);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gNs, this.gNt, this.outputWidth, this.outputHeight, this.hqd, this.scaleType);
    AppMethodBeat.o(196971);
    return locala;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(196972);
    long l = bu.HQ();
    super.amH();
    Object localObject2 = this.gNT;
    int j;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      i = this.outputWidth;
      j = this.outputHeight;
      localObject3 = this.gNV;
      localObject4 = this.gNU;
      int m = this.gNq;
      localObject1 = this.hpT;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).hqi;
      if (localObject1 == null) {
        p.gkB();
      }
      int k = this.gNW;
      p.h(localObject3, "cubeBuffer");
      p.h(localObject4, "textureCoordBuff");
      p.h(localObject1, "outputTexture");
      if (m != -1)
      {
        GLES20.glUseProgram(((i)localObject2).gOv);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, m);
        GLES20.glUniform1i(((i)localObject2).gOy, 0);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gOw, 2, 5126, false, 0, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gOw);
        ((FloatBuffer)localObject4).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gOx, 2, 5126, false, 0, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gOx);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gOw);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gOx);
        GLES20.glBindTexture(36197, 0);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, 0);
        m = ((com.tencent.mm.media.g.d)localObject1).hnc;
        if ((k != 0) && (((i)localObject2).gOs == null))
        {
          ((i)localObject2).gOs = com.tencent.mm.media.g.c.a(true, 18L);
          ((i)localObject2).gOt = new a();
          localObject3 = ((i)localObject2).gOt;
          if (localObject3 != null)
          {
            localObject4 = ((i)localObject2).gOs;
            if (localObject4 == null) {
              p.gkB();
            }
            ((a)localObject3).a(m, (com.tencent.mm.media.g.d)localObject4, k);
          }
          ((i)localObject2).gOm = i;
          ((i)localObject2).gOn = j;
          localObject3 = ((i)localObject2).gOt;
          if (localObject3 != null)
          {
            if ((j != ((a)localObject3).gNt) || (i != ((a)localObject3).gNs)) {
              ae.i(a.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            ((a)localObject3).gNs = i;
            ((a)localObject3).gNt = j;
            if (((a)localObject3).gvS != null)
            {
              localObject4 = ((a)localObject3).gvS;
              if (localObject4 == null) {
                p.gkB();
              }
              ((com.tencent.mm.plugin.xlabeffect.b)localObject4).setSize(i, j);
            }
            ((a)localObject3).gNq = ((com.tencent.mm.media.g.d)localObject1).hnc;
            ((a)localObject3).amA();
          }
          localObject1 = ((i)localObject2).gOs;
          label469:
          this.gNQ = ((com.tencent.mm.media.g.d)localObject1);
          localObject1 = ((Iterable)this.gNO).iterator();
          label489:
          if (!((Iterator)localObject1).hasNext()) {
            break label657;
          }
          localObject2 = (com.tencent.mm.media.j.b.a)((Iterator)localObject1).next();
          localObject3 = this.gNQ;
          if (localObject3 == null) {
            break label652;
          }
        }
      }
    }
    label652:
    for (int i = ((com.tencent.mm.media.g.d)localObject3).hnc;; i = -1)
    {
      ((com.tencent.mm.media.j.b.a)localObject2).nQ(i);
      ((com.tencent.mm.media.j.b.a)localObject2).amH();
      this.gNQ = ((com.tencent.mm.media.j.b.a)localObject2).hqi;
      break label489;
      if ((((i)localObject2).gOm == i) && (((i)localObject2).gOn == j)) {
        break;
      }
      localObject3 = ((i)localObject2).gOs;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      ((i)localObject2).gOs = com.tencent.mm.media.g.c.a(true, 18L);
      localObject3 = ((i)localObject2).gOt;
      if (localObject3 == null) {
        break;
      }
      localObject4 = ((i)localObject2).gOs;
      if (localObject4 == null) {
        p.gkB();
      }
      p.h(localObject4, "outputTexture");
      ((a)localObject3).gNr = ((com.tencent.mm.media.g.d)localObject4);
      break;
      break label469;
      localObject1 = null;
      break label469;
    }
    label657:
    Object localObject1 = this.gNP;
    if (localObject1 != null)
    {
      localObject2 = this.gNQ;
      if (localObject2 == null) {
        break label752;
      }
    }
    label752:
    for (i = ((com.tencent.mm.media.g.d)localObject2).hnc;; i = -1)
    {
      ((com.tencent.mm.media.j.b.e)localObject1).gNq = i;
      localObject1 = this.gNP;
      if (localObject1 != null) {
        ((d)localObject1).amH();
      }
      this.gNX += 1;
      localObject1 = this.gNZ;
      if (localObject1 == null) {
        break;
      }
      ((d.g.a.b)localObject1).invoke(Integer.valueOf((int)bu.aO(l)));
      AppMethodBeat.o(196972);
      return;
    }
    AppMethodBeat.o(196972);
  }
  
  public final com.tencent.mm.media.g.d amI()
  {
    AppMethodBeat.i(196976);
    com.tencent.mm.media.g.d locald = this.gNQ;
    if (locald != null) {
      locald.setSize(this.gNR, this.gNS);
    }
    locald = this.gNQ;
    AppMethodBeat.o(196976);
    return locald;
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196974);
    d locald = this.gNP;
    if (locald != null)
    {
      locald.cT(paramInt1, paramInt2);
      AppMethodBeat.o(196974);
      return;
    }
    AppMethodBeat.o(196974);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196973);
    super.cU(paramInt1, paramInt2);
    amJ();
    AppMethodBeat.o(196973);
  }
  
  public final void g(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(196968);
    aw localaw;
    if (paramb == null)
    {
      localaw = this.gOa;
      if (localaw != null) {
        localaw.stopTimer();
      }
      localaw = this.gOa;
      if (localaw != null) {
        localaw.quitSafely();
      }
    }
    for (;;)
    {
      this.gNY = paramb;
      AppMethodBeat.o(196968);
      return;
      if (this.gOa != null)
      {
        localaw = this.gOa;
        if ((localaw == null) || (localaw.isQuit() != true)) {}
      }
      else
      {
        this.gOa = new aw("LiveRenderFpsCounter", (aw.a)new b(this), true);
      }
      localaw = this.gOa;
      if (localaw != null) {
        localaw.Dv(1000L);
      }
    }
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(196975);
    super.ng(paramInt);
    amJ();
    AppMethodBeat.o(196975);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196970);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    paramGL10 = this.gNP;
    if (paramGL10 != null) {
      paramGL10.cT(paramInt1, paramInt2);
    }
    amJ();
    paramGL10 = this.hpT;
    if (paramGL10 != null)
    {
      paramGL10.hqm = true;
      AppMethodBeat.o(196970);
      return;
    }
    AppMethodBeat.o(196970);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(196969);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.gNP = new d(this.gNs, this.gNt, this.outputWidth, this.outputHeight);
    AppMethodBeat.o(196969);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(196978);
    super.release(paramBoolean);
    Object localObject1 = ((Iterable)this.gNO).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.j.b.a)((Iterator)localObject1).next()).release();
    }
    localObject1 = this.gNQ;
    if (localObject1 != null) {
      ((com.tencent.mm.media.g.d)localObject1).close();
    }
    localObject1 = this.gNP;
    if (localObject1 != null) {
      ((d)localObject1).release();
    }
    localObject1 = this.gNT;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).gOu;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((i)localObject1).gOs;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((i)localObject1).gOt;
      if (localObject2 != null)
      {
        localObject3 = a.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ae.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((a)localObject2).gNr;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((a)localObject2).gvS != null)
      {
        localObject3 = ((a)localObject2).gvS;
        if (localObject3 == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject3).destroy();
        ((a)localObject2).gvS = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(a.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(196978);
    }
    GLES20.glDeleteProgram(((i)localObject1).gOv);
    localObject1 = this.gOa;
    if (localObject1 != null) {
      ((aw)localObject1).stopTimer();
    }
    localObject1 = this.gOa;
    if (localObject1 != null)
    {
      ((aw)localObject1).quit();
      AppMethodBeat.o(196978);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements aw.a
  {
    b(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(196967);
      d.g.a.b localb = this.gOc.gNY;
      if (localb != null) {
        localb.invoke(Integer.valueOf(e.a(this.gOc)));
      }
      e.b(this.gOc);
      AppMethodBeat.o(196967);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.e
 * JD-Core Version:    0.7.0.1
 */