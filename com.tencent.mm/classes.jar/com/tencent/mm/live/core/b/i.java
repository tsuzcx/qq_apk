package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.l;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "cropHeight", "", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "flipTextureHeight", "flipTextureWidth", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mirrorMode", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "genDefaultBeautyConfig", "genDefaultFilterConfig", "getOutputTexture", "mirror", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setLiveScene", "scene", "setRotate", "degree", "setup", "startScaleAnimation", "scale", "", "updateBeautyConfig", "updateDrawViewSize", "updateFilterConfig", "updateMirror", "isMirror", "updateMirrorMode", "updateTextureSize", "Companion", "plugin-core_release"})
public final class i
  extends com.tencent.mm.media.j.d
{
  public static final a ksh;
  private boolean kmf;
  a knC;
  b knD;
  private ArrayList<com.tencent.mm.media.j.b.a> krS;
  private f krT;
  private com.tencent.mm.media.g.d krU;
  private int krV;
  private int krW;
  private int krX;
  private int krY;
  public m krZ;
  private FloatBuffer ksa;
  private FloatBuffer ksb;
  private int ksc;
  kotlin.g.a.b<? super Integer, x> ksd;
  kotlin.g.a.b<? super Integer, x> kse;
  private MTimerHandler ksf;
  int ksg;
  private int outputHeight;
  private int outputWidth;
  
  static
  {
    AppMethodBeat.i(198951);
    ksh = new a((byte)0);
    AppMethodBeat.o(198951);
  }
  
  public i(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(198948);
    this.kmf = paramBoolean;
    this.krS = new ArrayList();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.lak.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.ksa = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.k.c.laj.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    p.j(localObject, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
    this.ksb = ((FloatBuffer)localObject);
    localObject = e.l.kkD;
    this.ksg = e.l.aKF();
    AppMethodBeat.o(198948);
  }
  
  private final void aMW()
  {
    AppMethodBeat.i(198936);
    if ((this.outputWidth <= 0) || (this.krg <= 0))
    {
      AppMethodBeat.o(198936);
      return;
    }
    int i;
    int j;
    label56:
    label71:
    float f1;
    float f2;
    if ((this.kYg == 90) || (this.kYg == 270))
    {
      i = 1;
      if (i == 0) {
        break label242;
      }
      j = this.krh;
      this.krX = j;
      if (i == 0) {
        break label251;
      }
      i = this.krg;
      this.krY = i;
      f1 = this.outputWidth / this.krX;
      f2 = this.outputHeight / this.krY;
      if (f1 >= f2) {
        break label259;
      }
      this.krV = (this.krX - (this.krX - (int)(this.outputWidth / f2)));
      this.krW = this.krY;
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.krV + " height:" + this.krW);
      localObject = ((Iterable)this.krS).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)((Iterator)localObject).next();
        locala.dv(this.krV, this.krW);
        locala.dv(this.krV, this.krW);
      }
      i = 0;
      break;
      label242:
      j = this.krg;
      break label56;
      label251:
      i = this.krh;
      break label71;
      label259:
      if (f1 > f2)
      {
        this.krW = (this.krY - (this.krY - (int)(this.outputHeight / f1)));
        this.krV = this.krX;
      }
      else
      {
        this.krW = this.krY;
        this.krV = this.krX;
      }
    }
    super.du(this.krX, this.krY);
    Object localObject = this.krT;
    if (localObject != null)
    {
      ((f)localObject).dv(this.krX, this.krY);
      AppMethodBeat.o(198936);
      return;
    }
    AppMethodBeat.o(198936);
  }
  
  public final com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(198898);
    this.krZ = new m();
    if (this.kmf)
    {
      locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.f(this.krg, this.krh, this.outputWidth, this.outputHeight, aVh(), getScaleType());
      AppMethodBeat.o(198898);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.krg, this.krh, this.outputWidth, this.outputHeight, aVh(), getScaleType());
    AppMethodBeat.o(198898);
    return locala;
  }
  
  public final void aMU()
  {
    AppMethodBeat.i(198917);
    long l = Util.currentTicks();
    super.aMU();
    m localm = this.krZ;
    int j;
    com.tencent.mm.media.g.d locald;
    Object localObject2;
    if (localm != null)
    {
      i = this.ksu;
      j = this.ksv;
      Object localObject4 = this.ksb;
      FloatBuffer localFloatBuffer = this.ksa;
      localObject1 = this.kYb;
      if (localObject1 == null) {
        p.iCn();
      }
      locald = ((com.tencent.mm.media.j.b.a)localObject1).kYx;
      if (locald == null) {
        p.iCn();
      }
      localObject2 = this.knC;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a();
        ((Map)((a)localObject1).kra).put(Integer.valueOf(0), Integer.valueOf(-1));
        ((Map)((a)localObject1).kra).put(Integer.valueOf(1), Integer.valueOf(-1));
        ((Map)((a)localObject1).kra).put(Integer.valueOf(4), Integer.valueOf(-1));
        ((Map)((a)localObject1).kra).put(Integer.valueOf(2), Integer.valueOf(-1));
        ((Map)((a)localObject1).kra).put(Integer.valueOf(5), Integer.valueOf(-1));
        ((Map)((a)localObject1).kra).put(Integer.valueOf(3), Integer.valueOf(-1));
      }
      Object localObject3 = this.knD;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new b(-1, "", -1);
      }
      p.k(localObject4, "cubeBuffer");
      p.k(localFloatBuffer, "textureCoordBuff");
      p.k(locald, "texture");
      p.k(localObject1, "beautyParam");
      p.k(localObject2, "filterParam");
      if (locald.kVj != -1)
      {
        int k = locald.kVj;
        if ((localm.ksu == 0) || (localm.ksv == 0))
        {
          if (localm.ksA == null)
          {
            localm.ksA = com.tencent.mm.media.g.c.a(true, 18L);
            localm.ksB = new c();
            localObject3 = localm.ksB;
            if (localObject3 != null)
            {
              localObject4 = localm.ksA;
              if (localObject4 == null) {
                p.iCn();
              }
              ((c)localObject3).a(k, (com.tencent.mm.media.g.d)localObject4, (a)localObject1, (b)localObject2);
            }
            localm.ksu = i;
            localm.ksv = j;
          }
        }
        else
        {
          localObject1 = localm.ksB;
          if (localObject1 != null)
          {
            i = localm.ksu;
            j = localm.ksv;
            if ((j != ((c)localObject1).krh) || (i != ((c)localObject1).krg)) {
              Log.i(c.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            ((c)localObject1).krg = i;
            ((c)localObject1).krh = j;
            if (((c)localObject1).jUF != null)
            {
              localObject2 = ((c)localObject1).jUF;
              if (localObject2 == null) {
                p.iCn();
              }
              ((com.tencent.mm.plugin.xlabeffect.e)localObject2).setSize(i, j);
            }
            ((c)localObject1).kre = locald.kVj;
            ((c)localObject1).aML();
          }
          localObject1 = localm.ksA;
          label549:
          this.krU = ((com.tencent.mm.media.g.d)localObject1);
          localObject1 = ((Iterable)this.krS).iterator();
          label569:
          if (!((Iterator)localObject1).hasNext()) {
            break label741;
          }
          localObject2 = (com.tencent.mm.media.j.b.a)((Iterator)localObject1).next();
          locald = this.krU;
          if (locald == null) {
            break label736;
          }
        }
      }
    }
    label736:
    for (int i = locald.kVj;; i = -1)
    {
      ((com.tencent.mm.media.j.b.a)localObject2).ua(i);
      ((com.tencent.mm.media.j.b.a)localObject2).aMU();
      this.krU = ((com.tencent.mm.media.j.b.a)localObject2).kYx;
      break label569;
      if ((localm.ksu == i) && (localm.ksv == j)) {
        break;
      }
      localObject1 = localm.ksA;
      if (localObject1 != null) {
        ((com.tencent.mm.media.g.d)localObject1).close();
      }
      localm.ksA = com.tencent.mm.media.g.c.a(true, 18L);
      localObject1 = localm.ksB;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localm.ksA;
      if (localObject2 == null) {
        p.iCn();
      }
      p.k(localObject2, "outputTexture");
      ((c)localObject1).krf = ((com.tencent.mm.media.g.d)localObject2);
      break;
      localObject1 = locald;
      break label549;
      localObject1 = null;
      break label549;
    }
    label741:
    Object localObject1 = this.krT;
    if (localObject1 != null)
    {
      localObject2 = this.krU;
      if (localObject2 == null) {
        break label836;
      }
    }
    label836:
    for (i = ((com.tencent.mm.media.g.d)localObject2).kVj;; i = -1)
    {
      ((com.tencent.mm.media.j.b.e)localObject1).kre = i;
      localObject1 = this.krT;
      if (localObject1 != null) {
        ((f)localObject1).aMU();
      }
      this.ksc += 1;
      localObject1 = this.kse;
      if (localObject1 == null) {
        break;
      }
      ((kotlin.g.a.b)localObject1).invoke(Integer.valueOf((int)Util.ticksToNow(l)));
      AppMethodBeat.o(198917);
      return;
    }
    AppMethodBeat.o(198917);
  }
  
  public final com.tencent.mm.media.g.d aMV()
  {
    AppMethodBeat.i(198923);
    com.tencent.mm.media.g.d locald = this.krU;
    if (locald != null) {
      locald.setSize(this.krX, this.krY);
    }
    locald = this.krU;
    AppMethodBeat.o(198923);
    return locald;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198919);
    f localf = this.krT;
    if (localf != null)
    {
      localf.du(paramInt1, paramInt2);
      AppMethodBeat.o(198919);
      return;
    }
    AppMethodBeat.o(198919);
  }
  
  public final void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198918);
    super.dv(paramInt1, paramInt2);
    aMW();
    AppMethodBeat.o(198918);
  }
  
  public final void fj(boolean paramBoolean)
  {
    AppMethodBeat.i(198941);
    Log.i("MicroMsg.LiveTexEditRenderer", "mirror mirrorMode:" + this.ksg + " mirror:" + paramBoolean);
    if (paramBoolean)
    {
      int i = this.ksg;
      localObject = e.l.kkD;
      if (i == e.l.aKE())
      {
        localObject = this.krT;
        if (localObject != null) {
          ((com.tencent.mm.media.j.b.a)localObject).kYh = true;
        }
        super.fj(false);
        AppMethodBeat.o(198941);
        return;
      }
      i = this.ksg;
      localObject = e.l.kkD;
      if (i == e.l.aKF())
      {
        localObject = this.krT;
        if (localObject != null) {
          ((com.tencent.mm.media.j.b.a)localObject).kYh = false;
        }
        super.fj(true);
      }
      AppMethodBeat.o(198941);
      return;
    }
    Object localObject = this.krT;
    if (localObject != null) {
      ((com.tencent.mm.media.j.b.a)localObject).kYh = false;
    }
    super.fj(false);
    AppMethodBeat.o(198941);
  }
  
  public final void g(kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(198893);
    MTimerHandler localMTimerHandler;
    if (paramb == null)
    {
      localMTimerHandler = this.ksf;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localMTimerHandler = this.ksf;
      if (localMTimerHandler != null) {
        localMTimerHandler.quitSafely();
      }
    }
    for (;;)
    {
      this.ksd = paramb;
      AppMethodBeat.o(198893);
      return;
      if (this.ksf != null)
      {
        localMTimerHandler = this.ksf;
        if ((localMTimerHandler == null) || (localMTimerHandler.isQuit() != true)) {}
      }
      else
      {
        this.ksf = new MTimerHandler("LiveRenderFpsCounter", (MTimerHandler.CallBack)new b(this), true);
      }
      localMTimerHandler = this.ksf;
      if (localMTimerHandler != null) {
        localMTimerHandler.startTimer(1000L);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198897);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    paramGL10 = this.krT;
    if (paramGL10 != null) {
      paramGL10.du(paramInt1, paramInt2);
    }
    aMW();
    paramGL10 = this.kYb;
    if (paramGL10 != null)
    {
      paramGL10.kYB = true;
      AppMethodBeat.o(198897);
      return;
    }
    AppMethodBeat.o(198897);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(198894);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.krT = new f(this.krg, this.krh, this.outputWidth, this.outputHeight);
    AppMethodBeat.o(198894);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(198945);
    super.release(paramBoolean);
    Object localObject1 = ((Iterable)this.krS).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.j.b.a)((Iterator)localObject1).next()).release();
    }
    localObject1 = this.krU;
    if (localObject1 != null) {
      ((com.tencent.mm.media.g.d)localObject1).close();
    }
    localObject1 = this.krT;
    if (localObject1 != null) {
      ((f)localObject1).release();
    }
    localObject1 = this.krZ;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((m)localObject1).ksC;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((m)localObject1).ksA;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((m)localObject1).ksB;
      if (localObject2 != null)
      {
        localObject3 = c.TAG;
        Thread localThread = Thread.currentThread();
        p.j(localThread, "Thread.currentThread()");
        Log.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((c)localObject2).krf;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((c)localObject2).jUF != null)
      {
        localObject3 = ((c)localObject2).jUF;
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject3).destroy();
        ((c)localObject2).jUF = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(c.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
      AppMethodBeat.o(198945);
    }
    GLES20.glDeleteProgram(((m)localObject1).programId);
    localObject1 = this.ksf;
    if (localObject1 != null) {
      ((MTimerHandler)localObject1).stopTimer();
    }
    localObject1 = this.ksf;
    if (localObject1 != null)
    {
      ((MTimerHandler)localObject1).quit();
      AppMethodBeat.o(198945);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(198937);
    f localf = this.krT;
    if (localf != null)
    {
      localf.reset();
      AppMethodBeat.o(198937);
      return;
    }
    AppMethodBeat.o(198937);
  }
  
  public final void tm(int paramInt)
  {
    AppMethodBeat.i(198920);
    super.tm(paramInt);
    aMW();
    AppMethodBeat.o(198920);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer$Companion;", "", "()V", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements MTimerHandler.CallBack
  {
    b(i parami) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(199440);
      kotlin.g.a.b localb = this.ksi.ksd;
      if (localb != null) {
        localb.invoke(Integer.valueOf(i.a(this.ksi)));
      }
      i.b(this.ksi);
      AppMethodBeat.o(199440);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.i
 * JD-Core Version:    0.7.0.1
 */