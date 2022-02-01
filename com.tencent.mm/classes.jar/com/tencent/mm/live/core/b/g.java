package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.c;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "cropHeight", "", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mirrorMode", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "genDefaultBeautyConfig", "genDefaultFilterConfig", "getOutputTexture", "mirror", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setRotate", "degree", "setup", "scene", "startScaleAnimation", "scale", "", "updateBeautyConfig", "updateDrawViewSize", "updateFilterConfig", "updateMirror", "isMirror", "updateMirrorMode", "updateTextureSize", "Companion", "plugin-core_release"})
public final class g
  extends com.tencent.mm.media.j.d
{
  public static final g.a hEc;
  private ArrayList<com.tencent.mm.media.j.b.a> hDN;
  public f hDO;
  private com.tencent.mm.media.g.d hDP;
  private int hDQ;
  private int hDR;
  k hDS;
  private FloatBuffer hDT;
  private FloatBuffer hDU;
  a hDV;
  b hDW;
  private int hDX;
  kotlin.g.a.b<? super Integer, x> hDY;
  kotlin.g.a.b<? super Integer, x> hDZ;
  private MTimerHandler hEa;
  public int hEb;
  private boolean hzi;
  private int outputHeight;
  private int outputWidth;
  
  static
  {
    AppMethodBeat.i(196666);
    hEc = new g.a((byte)0);
    AppMethodBeat.o(196666);
  }
  
  public g(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(196665);
    this.hzi = paramBoolean;
    this.hDN = new ArrayList();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hDT = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.ilm.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.g(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.hDU = ((FloatBuffer)localObject);
    localObject = e.g.hxV;
    this.hEb = e.g.aCQ();
    AppMethodBeat.o(196665);
  }
  
  private final void aEF()
  {
    AppMethodBeat.i(196662);
    if ((this.outputWidth <= 0) || (this.hDn <= 0))
    {
      AppMethodBeat.o(196662);
      return;
    }
    int j;
    int i;
    label57:
    label68:
    float f1;
    float f2;
    if ((this.ijt == 90) || (this.ijt == 270))
    {
      j = 1;
      if (j == 0) {
        break label222;
      }
      i = this.hDo;
      if (j == 0) {
        break label230;
      }
      j = this.hDn;
      f1 = this.outputWidth / i;
      f2 = this.outputHeight / j;
      if (f1 >= f2) {
        break label239;
      }
      this.hDQ = (i - (i - (int)(this.outputWidth / f2)));
      this.hDR = j;
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.hDQ + " height:" + this.hDR);
      localObject = ((Iterable)this.hDN).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)((Iterator)localObject).next();
        locala.cZ(this.hDQ, this.hDR);
        locala.cZ(this.hDQ, this.hDR);
      }
      j = 0;
      break;
      label222:
      i = this.hDn;
      break label57;
      label230:
      j = this.hDo;
      break label68;
      label239:
      if (f1 > f2)
      {
        this.hDR = (j - (j - (int)(this.outputHeight / f1)));
        this.hDQ = i;
      }
      else
      {
        this.hDR = j;
        this.hDQ = i;
      }
    }
    super.cY(this.hDQ, this.hDR);
    Object localObject = this.hDO;
    if (localObject != null)
    {
      ((f)localObject).cZ(this.hDQ, this.hDR);
      AppMethodBeat.o(196662);
      return;
    }
    AppMethodBeat.o(196662);
  }
  
  public final com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(196656);
    this.hDS = new k();
    if (this.hzi)
    {
      locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.f(this.hDn, this.hDo, this.outputWidth, this.outputHeight, this.ijy, this.scaleType);
      AppMethodBeat.o(196656);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.outputWidth, this.outputHeight, this.ijy, this.scaleType);
    AppMethodBeat.o(196656);
    return locala;
  }
  
  public final void aED()
  {
    AppMethodBeat.i(196657);
    long l = Util.currentTicks();
    super.aED();
    k localk = this.hDS;
    int j;
    com.tencent.mm.media.g.d locald;
    Object localObject2;
    if (localk != null)
    {
      i = this.outputWidth;
      j = this.outputHeight;
      Object localObject4 = this.hDU;
      FloatBuffer localFloatBuffer = this.hDT;
      localObject1 = this.ijo;
      if (localObject1 == null) {
        p.hyc();
      }
      locald = ((com.tencent.mm.media.j.b.a)localObject1).ijD;
      if (locald == null) {
        p.hyc();
      }
      localObject2 = this.hDV;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a();
        localObject2 = (Map)((a)localObject1).hDh;
        localObject3 = e.c.hxm;
        ((Map)localObject2).put(Integer.valueOf(e.c.aCh()), Integer.valueOf(-1));
        localObject2 = (Map)((a)localObject1).hDh;
        localObject3 = e.c.hxm;
        ((Map)localObject2).put(Integer.valueOf(e.c.aCi()), Integer.valueOf(-1));
        localObject2 = (Map)((a)localObject1).hDh;
        localObject3 = e.c.hxm;
        ((Map)localObject2).put(Integer.valueOf(e.c.aCl()), Integer.valueOf(-1));
        localObject2 = (Map)((a)localObject1).hDh;
        localObject3 = e.c.hxm;
        ((Map)localObject2).put(Integer.valueOf(e.c.aCj()), Integer.valueOf(-1));
        localObject2 = (Map)((a)localObject1).hDh;
        localObject3 = e.c.hxm;
        ((Map)localObject2).put(Integer.valueOf(e.c.aCm()), Integer.valueOf(-1));
        localObject2 = (Map)((a)localObject1).hDh;
        localObject3 = e.c.hxm;
        ((Map)localObject2).put(Integer.valueOf(e.c.aCk()), Integer.valueOf(-1));
      }
      Object localObject3 = this.hDW;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new b(-1, "", -1);
      }
      p.h(localObject4, "cubeBuffer");
      p.h(localFloatBuffer, "textureCoordBuff");
      p.h(locald, "texture");
      p.h(localObject1, "beautyParam");
      p.h(localObject2, "filterParam");
      if (locald.igv != -1)
      {
        int k = locald.igv;
        if ((localk.hEp == 0) || (localk.hEq == 0))
        {
          if (localk.hEv == null)
          {
            localk.hEv = com.tencent.mm.media.g.c.a(true, 18L);
            localk.hEw = new c();
            localObject3 = localk.hEw;
            if (localObject3 != null)
            {
              localObject4 = localk.hEv;
              if (localObject4 == null) {
                p.hyc();
              }
              ((c)localObject3).a(k, (com.tencent.mm.media.g.d)localObject4, (a)localObject1, (b)localObject2);
            }
            localk.hEp = i;
            localk.hEq = j;
          }
        }
        else
        {
          localObject1 = localk.hEw;
          if (localObject1 != null)
          {
            i = localk.hEp;
            j = localk.hEq;
            if ((j != ((c)localObject1).hDo) || (i != ((c)localObject1).hDn)) {
              Log.i(c.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            ((c)localObject1).hDn = i;
            ((c)localObject1).hDo = j;
            if (((c)localObject1).hiH != null)
            {
              localObject2 = ((c)localObject1).hiH;
              if (localObject2 == null) {
                p.hyc();
              }
              ((com.tencent.mm.plugin.xlabeffect.b)localObject2).setSize(i, j);
            }
            ((c)localObject1).hDl = locald.igv;
            ((c)localObject1).aEw();
          }
          localObject1 = localk.hEv;
          label615:
          this.hDP = ((com.tencent.mm.media.g.d)localObject1);
          localObject1 = ((Iterable)this.hDN).iterator();
          label635:
          if (!((Iterator)localObject1).hasNext()) {
            break label807;
          }
          localObject2 = (com.tencent.mm.media.j.b.a)((Iterator)localObject1).next();
          locald = this.hDP;
          if (locald == null) {
            break label802;
          }
        }
      }
    }
    label802:
    for (int i = locald.igv;; i = -1)
    {
      ((com.tencent.mm.media.j.b.a)localObject2).rl(i);
      ((com.tencent.mm.media.j.b.a)localObject2).aED();
      this.hDP = ((com.tencent.mm.media.j.b.a)localObject2).ijD;
      break label635;
      if ((localk.hEp == i) && (localk.hEq == j)) {
        break;
      }
      localObject1 = localk.hEv;
      if (localObject1 != null) {
        ((com.tencent.mm.media.g.d)localObject1).close();
      }
      localk.hEv = com.tencent.mm.media.g.c.a(true, 18L);
      localObject1 = localk.hEw;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localk.hEv;
      if (localObject2 == null) {
        p.hyc();
      }
      p.h(localObject2, "outputTexture");
      ((c)localObject1).hDm = ((com.tencent.mm.media.g.d)localObject2);
      break;
      localObject1 = locald;
      break label615;
      localObject1 = null;
      break label615;
    }
    label807:
    Object localObject1 = this.hDO;
    if (localObject1 != null)
    {
      localObject2 = this.hDP;
      if (localObject2 == null) {
        break label902;
      }
    }
    label902:
    for (i = ((com.tencent.mm.media.g.d)localObject2).igv;; i = -1)
    {
      ((e)localObject1).hDl = i;
      localObject1 = this.hDO;
      if (localObject1 != null) {
        ((f)localObject1).aED();
      }
      this.hDX += 1;
      localObject1 = this.hDZ;
      if (localObject1 == null) {
        break;
      }
      ((kotlin.g.a.b)localObject1).invoke(Integer.valueOf((int)Util.ticksToNow(l)));
      AppMethodBeat.o(196657);
      return;
    }
    AppMethodBeat.o(196657);
  }
  
  public final com.tencent.mm.media.g.d aEE()
  {
    AppMethodBeat.i(196661);
    com.tencent.mm.media.g.d locald = this.hDP;
    if (locald != null) {
      locald.setSize(this.hDQ, this.hDR);
    }
    locald = this.hDP;
    AppMethodBeat.o(196661);
    return locald;
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196659);
    f localf = this.hDO;
    if (localf != null)
    {
      localf.cY(paramInt1, paramInt2);
      AppMethodBeat.o(196659);
      return;
    }
    AppMethodBeat.o(196659);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196658);
    super.cZ(paramInt1, paramInt2);
    aEF();
    AppMethodBeat.o(196658);
  }
  
  public final void eD(boolean paramBoolean)
  {
    AppMethodBeat.i(196663);
    Log.i("MicroMsg.LiveTexEditRenderer", "mirror mirrorMode:" + this.hEb + " mirror:" + paramBoolean);
    if (paramBoolean)
    {
      int i = this.hEb;
      localObject = e.g.hxV;
      if (i == e.g.aCQ())
      {
        localObject = this.hDO;
        if (localObject != null) {
          ((com.tencent.mm.media.j.b.a)localObject).iju = true;
        }
        super.eD(false);
        AppMethodBeat.o(196663);
        return;
      }
      i = this.hEb;
      localObject = e.g.hxV;
      if (i == e.g.aCR())
      {
        localObject = this.hDO;
        if (localObject != null) {
          ((com.tencent.mm.media.j.b.a)localObject).iju = false;
        }
        super.eD(true);
      }
      AppMethodBeat.o(196663);
      return;
    }
    Object localObject = this.hDO;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).iju = false;
    }
    super.eD(false);
    AppMethodBeat.o(196663);
  }
  
  public final void g(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(196653);
    MTimerHandler localMTimerHandler;
    if (paramb == null)
    {
      localMTimerHandler = this.hEa;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localMTimerHandler = this.hEa;
      if (localMTimerHandler != null) {
        localMTimerHandler.quitSafely();
      }
    }
    for (;;)
    {
      this.hDY = paramb;
      AppMethodBeat.o(196653);
      return;
      if (this.hEa != null)
      {
        localMTimerHandler = this.hEa;
        if ((localMTimerHandler == null) || (localMTimerHandler.isQuit() != true)) {}
      }
      else
      {
        this.hEa = new MTimerHandler("LiveRenderFpsCounter", (MTimerHandler.CallBack)new b(this), true);
      }
      localMTimerHandler = this.hEa;
      if (localMTimerHandler != null) {
        localMTimerHandler.startTimer(1000L);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196655);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    paramGL10 = this.hDO;
    if (paramGL10 != null) {
      paramGL10.cY(paramInt1, paramInt2);
    }
    aEF();
    paramGL10 = this.ijo;
    if (paramGL10 != null)
    {
      paramGL10.ijH = true;
      AppMethodBeat.o(196655);
      return;
    }
    AppMethodBeat.o(196655);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(196654);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.hDO = new f(this.hDn, this.hDo, this.outputWidth, this.outputHeight);
    AppMethodBeat.o(196654);
  }
  
  public final void qx(int paramInt)
  {
    AppMethodBeat.i(196660);
    super.qx(paramInt);
    aEF();
    AppMethodBeat.o(196660);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(196664);
    super.release(paramBoolean);
    Object localObject1 = ((Iterable)this.hDN).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.j.b.a)((Iterator)localObject1).next()).release();
    }
    localObject1 = this.hDP;
    if (localObject1 != null) {
      ((com.tencent.mm.media.g.d)localObject1).close();
    }
    localObject1 = this.hDO;
    if (localObject1 != null) {
      ((f)localObject1).release();
    }
    localObject1 = this.hDS;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((k)localObject1).hEx;
      if (localObject2 != null) {
        ((e)localObject2).release();
      }
      localObject2 = ((k)localObject1).hEv;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((k)localObject1).hEw;
      if (localObject2 != null)
      {
        localObject3 = c.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        Log.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((c)localObject2).hDm;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((c)localObject2).hiH != null)
      {
        localObject3 = ((c)localObject2).hiH;
        if (localObject3 == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject3).destroy();
        ((c)localObject2).hiH = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(c.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(196664);
    }
    GLES20.glDeleteProgram(((k)localObject1).programId);
    localObject1 = this.hEa;
    if (localObject1 != null) {
      ((MTimerHandler)localObject1).stopTimer();
    }
    localObject1 = this.hEa;
    if (localObject1 != null)
    {
      ((MTimerHandler)localObject1).quit();
      AppMethodBeat.o(196664);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(g paramg) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(196652);
      kotlin.g.a.b localb = this.hEd.hDY;
      if (localb != null) {
        localb.invoke(Integer.valueOf(g.a(this.hEd)));
      }
      g.b(this.hEd);
      AppMethodBeat.o(196652);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.g
 * JD-Core Version:    0.7.0.1
 */