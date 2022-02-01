package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "LIVE_BEAUTY_PARAMS", "", "cropHeight", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "getOutputTexture", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setRotate", "degree", "startScaleAnimation", "scale", "", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-core_release"})
public final class e
  extends com.tencent.mm.media.j.d
{
  public static final e.a gLs;
  private boolean gHv;
  private ArrayList<com.tencent.mm.media.j.b.a> gLf;
  public d gLg;
  private com.tencent.mm.media.g.d gLh;
  private int gLi;
  private int gLj;
  private i gLk;
  private FloatBuffer gLl;
  private FloatBuffer gLm;
  private final int gLn;
  private int gLo;
  d.g.a.b<? super Integer, z> gLp;
  d.g.a.b<? super Integer, z> gLq;
  private av gLr;
  private int outputHeight;
  private int outputWidth;
  
  static
  {
    AppMethodBeat.i(216968);
    gLs = new e.a((byte)0);
    AppMethodBeat.o(216968);
  }
  
  public e(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(216967);
    this.gHv = paramBoolean;
    this.gLf = new ArrayList();
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gLl = localFloatBuffer;
    localFloatBuffer = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.hoI.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.gLm = localFloatBuffer;
    this.gLn = 1;
    AppMethodBeat.o(216967);
  }
  
  private final void amu()
  {
    AppMethodBeat.i(216965);
    if ((this.outputWidth <= 0) || (this.gKJ <= 0))
    {
      AppMethodBeat.o(216965);
      return;
    }
    int j;
    int i;
    label57:
    label68:
    float f1;
    float f2;
    if ((this.hnk == 90) || (this.hnk == 270))
    {
      j = 1;
      if (j == 0) {
        break label222;
      }
      i = this.gKK;
      if (j == 0) {
        break label230;
      }
      j = this.gKJ;
      f1 = this.outputWidth / i;
      f2 = this.outputHeight / j;
      if (f1 >= f2) {
        break label239;
      }
      this.gLi = (i - (i - (int)(this.outputWidth / f2)));
      this.gLj = j;
    }
    for (;;)
    {
      ad.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.gLi + " height:" + this.gLj);
      localObject = ((Iterable)this.gLf).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)((Iterator)localObject).next();
        locala.cU(this.gLi, this.gLj);
        locala.cU(this.gLi, this.gLj);
      }
      j = 0;
      break;
      label222:
      i = this.gKJ;
      break label57;
      label230:
      j = this.gKK;
      break label68;
      label239:
      if (f1 > f2)
      {
        this.gLj = (j - (j - (int)(this.outputHeight / f1)));
        this.gLi = i;
      }
      else
      {
        this.gLj = j;
        this.gLi = i;
      }
    }
    super.cT(this.gLi, this.gLj);
    Object localObject = this.gLg;
    if (localObject != null)
    {
      ((d)localObject).cU(this.gLi, this.gLj);
      AppMethodBeat.o(216965);
      return;
    }
    AppMethodBeat.o(216965);
  }
  
  public final com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(216959);
    this.gLk = new i();
    if (this.gHv)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.outputWidth, this.outputHeight, this.hnp, this.scaleType);
      AppMethodBeat.o(216959);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gKJ, this.gKK, this.outputWidth, this.outputHeight, this.hnp, this.scaleType);
    AppMethodBeat.o(216959);
    return locala;
  }
  
  public final void ams()
  {
    AppMethodBeat.i(216960);
    long l = bt.HI();
    super.ams();
    Object localObject2 = this.gLk;
    int j;
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      i = this.outputWidth;
      j = this.outputHeight;
      localObject3 = this.gLm;
      localObject4 = this.gLl;
      int m = this.gKH;
      localObject1 = this.hnf;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).hnu;
      if (localObject1 == null) {
        p.gfZ();
      }
      int k = this.gLn;
      p.h(localObject3, "cubeBuffer");
      p.h(localObject4, "textureCoordBuff");
      p.h(localObject1, "outputTexture");
      if (m != -1)
      {
        GLES20.glUseProgram(((i)localObject2).gLM);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, m);
        GLES20.glUniform1i(((i)localObject2).gLP, 0);
        ((FloatBuffer)localObject3).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gLN, 2, 5126, false, 0, (Buffer)localObject3);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gLN);
        ((FloatBuffer)localObject4).position(0);
        GLES20.glVertexAttribPointer(((i)localObject2).gLO, 2, 5126, false, 0, (Buffer)localObject4);
        GLES20.glEnableVertexAttribArray(((i)localObject2).gLO);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gLN);
        GLES20.glDisableVertexAttribArray(((i)localObject2).gLO);
        GLES20.glBindTexture(36197, 0);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, 0);
        m = ((com.tencent.mm.media.g.d)localObject1).hko;
        if ((k != 0) && (((i)localObject2).gLJ == null))
        {
          ((i)localObject2).gLJ = com.tencent.mm.media.g.c.a(true, 18L);
          ((i)localObject2).gLK = new a();
          localObject3 = ((i)localObject2).gLK;
          if (localObject3 != null)
          {
            localObject4 = ((i)localObject2).gLJ;
            if (localObject4 == null) {
              p.gfZ();
            }
            ((a)localObject3).a(m, (com.tencent.mm.media.g.d)localObject4, k);
          }
          ((i)localObject2).gLD = i;
          ((i)localObject2).gLE = j;
          localObject3 = ((i)localObject2).gLK;
          if (localObject3 != null)
          {
            if ((j != ((a)localObject3).gKK) || (i != ((a)localObject3).gKJ)) {
              ad.i(a.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            ((a)localObject3).gKJ = i;
            ((a)localObject3).gKK = j;
            if (((a)localObject3).gtl != null)
            {
              localObject4 = ((a)localObject3).gtl;
              if (localObject4 == null) {
                p.gfZ();
              }
              ((com.tencent.mm.plugin.xlabeffect.b)localObject4).setSize(i, j);
            }
            ((a)localObject3).gKH = ((com.tencent.mm.media.g.d)localObject1).hko;
            ((a)localObject3).aml();
          }
          localObject1 = ((i)localObject2).gLJ;
          label469:
          this.gLh = ((com.tencent.mm.media.g.d)localObject1);
          localObject1 = ((Iterable)this.gLf).iterator();
          label489:
          if (!((Iterator)localObject1).hasNext()) {
            break label657;
          }
          localObject2 = (com.tencent.mm.media.j.b.a)((Iterator)localObject1).next();
          localObject3 = this.gLh;
          if (localObject3 == null) {
            break label652;
          }
        }
      }
    }
    label652:
    for (int i = ((com.tencent.mm.media.g.d)localObject3).hko;; i = -1)
    {
      ((com.tencent.mm.media.j.b.a)localObject2).nN(i);
      ((com.tencent.mm.media.j.b.a)localObject2).ams();
      this.gLh = ((com.tencent.mm.media.j.b.a)localObject2).hnu;
      break label489;
      if ((((i)localObject2).gLD == i) && (((i)localObject2).gLE == j)) {
        break;
      }
      localObject3 = ((i)localObject2).gLJ;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      ((i)localObject2).gLJ = com.tencent.mm.media.g.c.a(true, 18L);
      localObject3 = ((i)localObject2).gLK;
      if (localObject3 == null) {
        break;
      }
      localObject4 = ((i)localObject2).gLJ;
      if (localObject4 == null) {
        p.gfZ();
      }
      p.h(localObject4, "outputTexture");
      ((a)localObject3).gKI = ((com.tencent.mm.media.g.d)localObject4);
      break;
      break label469;
      localObject1 = null;
      break label469;
    }
    label657:
    Object localObject1 = this.gLg;
    if (localObject1 != null)
    {
      localObject2 = this.gLh;
      if (localObject2 == null) {
        break label752;
      }
    }
    label752:
    for (i = ((com.tencent.mm.media.g.d)localObject2).hko;; i = -1)
    {
      ((com.tencent.mm.media.j.b.e)localObject1).gKH = i;
      localObject1 = this.gLg;
      if (localObject1 != null) {
        ((d)localObject1).ams();
      }
      this.gLo += 1;
      localObject1 = this.gLq;
      if (localObject1 == null) {
        break;
      }
      ((d.g.a.b)localObject1).invoke(Integer.valueOf((int)bt.aO(l)));
      AppMethodBeat.o(216960);
      return;
    }
    AppMethodBeat.o(216960);
  }
  
  public final com.tencent.mm.media.g.d amt()
  {
    AppMethodBeat.i(216964);
    com.tencent.mm.media.g.d locald = this.gLh;
    if (locald != null) {
      locald.setSize(this.gLi, this.gLj);
    }
    locald = this.gLh;
    AppMethodBeat.o(216964);
    return locald;
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216962);
    d locald = this.gLg;
    if (locald != null)
    {
      locald.cT(paramInt1, paramInt2);
      AppMethodBeat.o(216962);
      return;
    }
    AppMethodBeat.o(216962);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216961);
    super.cU(paramInt1, paramInt2);
    amu();
    AppMethodBeat.o(216961);
  }
  
  public final void g(d.g.a.b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(216956);
    av localav;
    if (paramb == null)
    {
      localav = this.gLr;
      if (localav != null) {
        localav.stopTimer();
      }
      localav = this.gLr;
      if (localav != null) {
        localav.quitSafely();
      }
    }
    for (;;)
    {
      this.gLp = paramb;
      AppMethodBeat.o(216956);
      return;
      if (this.gLr != null)
      {
        localav = this.gLr;
        if ((localav == null) || (localav.isQuit() != true)) {}
      }
      else
      {
        this.gLr = new av("LiveRenderFpsCounter", (av.a)new b(this), true);
      }
      localav = this.gLr;
      if (localav != null) {
        localav.CX(1000L);
      }
    }
  }
  
  public final void nd(int paramInt)
  {
    AppMethodBeat.i(216963);
    super.nd(paramInt);
    amu();
    AppMethodBeat.o(216963);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216958);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    paramGL10 = this.gLg;
    if (paramGL10 != null) {
      paramGL10.cT(paramInt1, paramInt2);
    }
    amu();
    paramGL10 = this.hnf;
    if (paramGL10 != null)
    {
      paramGL10.hny = true;
      AppMethodBeat.o(216958);
      return;
    }
    AppMethodBeat.o(216958);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(216957);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.gLg = new d(this.gKJ, this.gKK, this.outputWidth, this.outputHeight);
    AppMethodBeat.o(216957);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(216966);
    super.release(paramBoolean);
    Object localObject1 = ((Iterable)this.gLf).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.j.b.a)((Iterator)localObject1).next()).release();
    }
    localObject1 = this.gLh;
    if (localObject1 != null) {
      ((com.tencent.mm.media.g.d)localObject1).close();
    }
    localObject1 = this.gLg;
    if (localObject1 != null) {
      ((d)localObject1).release();
    }
    localObject1 = this.gLk;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).gLL;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((i)localObject1).gLJ;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((i)localObject1).gLK;
      if (localObject2 != null)
      {
        localObject3 = a.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((a)localObject2).gKI;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((a)localObject2).gtl != null)
      {
        localObject3 = ((a)localObject2).gtl;
        if (localObject3 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject3).destroy();
        ((a)localObject2).gtl = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(a.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(216966);
    }
    GLES20.glDeleteProgram(((i)localObject1).gLM);
    localObject1 = this.gLr;
    if (localObject1 != null) {
      ((av)localObject1).stopTimer();
    }
    localObject1 = this.gLr;
    if (localObject1 != null)
    {
      ((av)localObject1).quit();
      AppMethodBeat.o(216966);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements av.a
  {
    b(e parame) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(216955);
      d.g.a.b localb = this.gLt.gLp;
      if (localb != null) {
        localb.invoke(Integer.valueOf(e.a(this.gLt)));
      }
      e.b(this.gLt);
      AppMethodBeat.o(216955);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.e
 * JD-Core Version:    0.7.0.1
 */