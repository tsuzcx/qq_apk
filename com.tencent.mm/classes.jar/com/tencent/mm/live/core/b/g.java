package com.tencent.mm.live.core.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.e.n;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveTexEditRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "useCPUCrop", "", "(Z)V", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "cropHeight", "", "cropWidth", "cubeBuffer", "Ljava/nio/FloatBuffer;", "faceBeautyProgram", "Lcom/tencent/mm/live/core/render/LiveYTFaceBeautyRendererProgram;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "finalTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "flipTextureHeight", "flipTextureWidth", "mFps", "mTimerCount", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mirrorMode", "outputHeight", "outputWidth", "renderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "Lkotlin/collections/ArrayList;", "value", "Lkotlin/Function1;", "", "rendererFpsCountCallback", "getRendererFpsCountCallback", "()Lkotlin/jvm/functions/Function1;", "setRendererFpsCountCallback", "(Lkotlin/jvm/functions/Function1;)V", "rendererPerFrameCostCallback", "getRendererPerFrameCostCallback", "setRendererPerFrameCostCallback", "screenRender", "Lcom/tencent/mm/live/core/render/LiveScreenRenderProc;", "textureCoordBuff", "getUseCPUCrop", "()Z", "setUseCPUCrop", "calculateTextureSize", "doInitRenderProc", "endScaleAnimation", "time", "genDefaultBeautyConfig", "genDefaultFilterConfig", "getOutputTexture", "mirror", "onSurfaceChanged", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "shouldDestroySurfaceTexture", "render", "reset", "setLiveScene", "scene", "setRotate", "degree", "setup", "startScaleAnimation", "scale", "", "updateBeautyConfig", "updateDrawViewSize", "updateFilterConfig", "updateMirror", "isMirror", "updateMirrorMode", "updateTextureSize", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.media.j.c
{
  public static final g.a mVL;
  private boolean mNk;
  a mRD;
  b mRE;
  private ArrayList<com.tencent.mm.media.j.b.a> mVM;
  private e mVN;
  private d mVO;
  private int mVP;
  private int mVQ;
  private int mVR;
  private int mVS;
  public j mVT;
  private FloatBuffer mVU;
  private FloatBuffer mVV;
  private int mVW;
  private kotlin.g.a.b<? super Integer, ah> mVX;
  kotlin.g.a.b<? super Integer, ah> mVY;
  private MTimerHandler mVZ;
  int mWa;
  private int outputHeight;
  private int outputWidth;
  
  static
  {
    AppMethodBeat.i(247739);
    mVL = new g.a((byte)0);
    AppMethodBeat.o(247739);
  }
  
  public g(boolean paramBoolean)
  {
    super(2);
    AppMethodBeat.i(247704);
    this.mNk = paramBoolean;
    this.mVM = new ArrayList();
    Object localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.mVU = ((FloatBuffer)localObject);
    localObject = ByteBuffer.allocateDirect(com.tencent.mm.media.util.c.nFt.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    s.s(localObject, "allocateDirect(GLEnviron…eOrder()).asFloatBuffer()");
    this.mVV = ((FloatBuffer)localObject);
    localObject = e.n.mLw;
    this.mWa = e.n.bdB();
    AppMethodBeat.o(247704);
  }
  
  private static final boolean a(g paramg)
  {
    AppMethodBeat.i(247734);
    s.u(paramg, "this$0");
    kotlin.g.a.b localb = paramg.mVX;
    if (localb != null) {
      localb.invoke(Integer.valueOf(paramg.mVW));
    }
    paramg.mVW = 0;
    AppMethodBeat.o(247734);
    return true;
  }
  
  private final void bgG()
  {
    AppMethodBeat.i(247724);
    if ((this.outputWidth <= 0) || (this.mVd <= 0))
    {
      AppMethodBeat.o(247724);
      return;
    }
    int i;
    int j;
    label56:
    label71:
    float f1;
    float f2;
    if ((this.nDr == 90) || (this.nDr == 270))
    {
      i = 1;
      if (i == 0) {
        break label245;
      }
      j = this.mVe;
      this.mVR = j;
      if (i == 0) {
        break label254;
      }
      i = this.mVd;
      this.mVS = i;
      f1 = this.outputWidth / this.mVR;
      f2 = this.outputHeight / this.mVS;
      if (f1 >= f2) {
        break label262;
      }
      this.mVP = (this.mVR - (this.mVR - (int)(this.outputWidth / f2)));
      this.mVQ = this.mVS;
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveTexEditRenderer", "calculate crop texture width:" + this.mVP + " height:" + this.mVQ);
      localObject = ((Iterable)this.mVM).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)((Iterator)localObject).next();
        locala.el(this.mVP, this.mVQ);
        locala.el(this.mVP, this.mVQ);
      }
      i = 0;
      break;
      label245:
      j = this.mVd;
      break label56;
      label254:
      i = this.mVe;
      break label71;
      label262:
      if (f1 > f2)
      {
        this.mVQ = (this.mVS - (this.mVS - (int)(this.outputHeight / f1)));
        this.mVP = this.mVR;
      }
      else
      {
        this.mVQ = this.mVS;
        this.mVP = this.mVR;
      }
    }
    super.ek(this.mVR, this.mVS);
    Object localObject = this.mVN;
    if (localObject != null) {
      ((e)localObject).el(this.mVR, this.mVS);
    }
    AppMethodBeat.o(247724);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(247781);
    this.mVT = new j();
    if (this.mNk)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.mVd, this.mVe, this.outputWidth, this.outputHeight, bpJ(), getScaleType());
      AppMethodBeat.o(247781);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.mVd, this.mVe, this.outputWidth, this.outputHeight, bpJ(), getScaleType());
    AppMethodBeat.o(247781);
    return locala;
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(247799);
    long l = Util.currentTicks();
    super.bgE();
    j localj = this.mVT;
    label49:
    Object localObject2;
    d locald;
    if (localj == null)
    {
      localObject1 = null;
      this.mVO = ((d)localObject1);
      localObject1 = ((Iterable)this.mVM).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label726;
      }
      localObject2 = (com.tencent.mm.media.j.b.a)((Iterator)localObject1).next();
      locald = this.mVO;
      if (locald != null) {
        break label717;
      }
    }
    label717:
    for (int i = -1;; i = locald.nAF)
    {
      ((com.tencent.mm.media.j.b.a)localObject2).uc(i);
      ((com.tencent.mm.media.j.b.a)localObject2).bgE();
      this.mVO = ((com.tencent.mm.media.j.b.a)localObject2).nDF;
      break label49;
      i = this.mWn;
      int j = this.mWo;
      Object localObject4 = this.mVV;
      FloatBuffer localFloatBuffer = this.mVU;
      localObject1 = this.nDm;
      s.checkNotNull(localObject1);
      locald = ((com.tencent.mm.media.j.b.a)localObject1).nDF;
      s.checkNotNull(locald);
      localObject2 = this.mRD;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new a();
        ((Map)((a)localObject1).mUV).put(Integer.valueOf(0), Integer.valueOf(-1));
        ((Map)((a)localObject1).mUV).put(Integer.valueOf(1), Integer.valueOf(-1));
        ((Map)((a)localObject1).mUV).put(Integer.valueOf(4), Integer.valueOf(-1));
        ((Map)((a)localObject1).mUV).put(Integer.valueOf(2), Integer.valueOf(-1));
        ((Map)((a)localObject1).mUV).put(Integer.valueOf(5), Integer.valueOf(-1));
        ((Map)((a)localObject1).mUV).put(Integer.valueOf(3), Integer.valueOf(-1));
      }
      Object localObject3 = this.mRE;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = new b(-1, "", -1);
      }
      s.u(localObject4, "cubeBuffer");
      s.u(localFloatBuffer, "textureCoordBuff");
      s.u(locald, "texture");
      s.u(localObject1, "beautyParam");
      s.u(localObject2, "filterParam");
      if (locald.nAF != -1)
      {
        int k = locald.nAF;
        if ((localj.mWn == 0) || (localj.mWo == 0))
        {
          if (localj.mWs != null) {
            break label621;
          }
          localj.mWs = com.tencent.mm.media.g.c.d(true, 18L);
          localj.mWt = new c();
          localObject3 = localj.mWt;
          if (localObject3 != null)
          {
            localObject4 = localj.mWs;
            s.checkNotNull(localObject4);
            ((c)localObject3).a(k, (d)localObject4, (a)localObject1, (b)localObject2);
          }
        }
        for (;;)
        {
          localj.mWn = i;
          localj.mWo = j;
          localObject1 = localj.mWt;
          if (localObject1 != null)
          {
            i = localj.mWn;
            j = localj.mWo;
            if ((j != ((c)localObject1).mVe) || (i != ((c)localObject1).mVd)) {
              Log.i(c.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            ((c)localObject1).mVd = i;
            ((c)localObject1).mVe = j;
            if (((c)localObject1).muW != null)
            {
              localObject2 = ((c)localObject1).muW;
              s.checkNotNull(localObject2);
              ((k)localObject2).setSize(i, j);
            }
            ((c)localObject1).mVb = locald.nAF;
            ((c)localObject1).bgv();
          }
          localObject1 = localj.mWs;
          break;
          label621:
          if ((localj.mWn != i) || (localj.mWo != j))
          {
            localObject1 = localj.mWs;
            if (localObject1 != null) {
              ((d)localObject1).close();
            }
            localj.mWs = com.tencent.mm.media.g.c.d(true, 18L);
            localObject1 = localj.mWt;
            if (localObject1 != null)
            {
              localObject2 = localj.mWs;
              s.checkNotNull(localObject2);
              s.u(localObject2, "outputTexture");
              ((c)localObject1).mVc = ((d)localObject2);
            }
          }
        }
      }
      localObject1 = locald;
      break;
    }
    label726:
    Object localObject1 = this.mVN;
    if (localObject1 != null)
    {
      localObject2 = this.mVO;
      if (localObject2 != null) {
        break label817;
      }
    }
    label817:
    for (i = -1;; i = ((d)localObject2).nAF)
    {
      ((com.tencent.mm.media.j.b.e)localObject1).mVb = i;
      localObject1 = this.mVN;
      if (localObject1 != null) {
        ((e)localObject1).bgE();
      }
      this.mVW += 1;
      localObject1 = this.mVY;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(Integer.valueOf((int)Util.ticksToNow(l)));
      }
      AppMethodBeat.o(247799);
      return;
    }
  }
  
  public final d bgF()
  {
    AppMethodBeat.i(247826);
    d locald = this.mVO;
    if (locald != null) {
      locald.setSize(this.mVR, this.mVS);
    }
    locald = this.mVO;
    AppMethodBeat.o(247826);
    return locald;
  }
  
  public final void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247813);
    e locale = this.mVN;
    if (locale != null) {
      locale.ek(paramInt1, paramInt2);
    }
    AppMethodBeat.o(247813);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247807);
    super.el(paramInt1, paramInt2);
    bgG();
    AppMethodBeat.o(247807);
  }
  
  public final void fQ(boolean paramBoolean)
  {
    AppMethodBeat.i(247846);
    Log.i("MicroMsg.LiveTexEditRenderer", "mirror mirrorMode:" + this.mWa + " mirror:" + paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      int i = this.mWa;
      localObject = e.n.mLw;
      if (i == e.n.bdA())
      {
        localObject = this.mVN;
        if (localObject != null) {
          ((e)localObject).gr(true);
        }
        super.fQ(false);
        AppMethodBeat.o(247846);
        return;
      }
      i = this.mWa;
      localObject = e.n.mLw;
      if (i == e.n.bdB())
      {
        localObject = this.mVN;
        if (localObject != null) {
          ((e)localObject).gr(false);
        }
        super.fQ(true);
        AppMethodBeat.o(247846);
      }
    }
    else
    {
      localObject = this.mVN;
      if (localObject != null) {
        ((e)localObject).gr(false);
      }
      super.fQ(false);
    }
    AppMethodBeat.o(247846);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247775);
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    paramGL10 = this.mVN;
    if (paramGL10 != null) {
      paramGL10.ek(paramInt1, paramInt2);
    }
    bgG();
    paramGL10 = this.nDm;
    if (paramGL10 != null) {
      paramGL10.gq(true);
    }
    AppMethodBeat.o(247775);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(247766);
    super.onSurfaceCreated(paramGL10, paramEGLConfig);
    this.mVN = new e(this.mVd, this.mVe, this.outputWidth, this.outputHeight);
    AppMethodBeat.o(247766);
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(247855);
    super.release(paramBoolean);
    Object localObject1 = ((Iterable)this.mVM).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.media.j.b.a)((Iterator)localObject1).next()).release();
    }
    localObject1 = this.mVO;
    if (localObject1 != null) {
      ((d)localObject1).close();
    }
    localObject1 = this.mVN;
    if (localObject1 != null) {
      ((e)localObject1).release();
    }
    localObject1 = this.mVT;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((j)localObject1).mWu;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((j)localObject1).mWs;
      if (localObject2 != null) {
        ((d)localObject2).close();
      }
      localObject2 = ((j)localObject1).mWt;
      if (localObject2 != null) {
        Log.i(c.TAG, "clear %s %d", new Object[] { localObject2, Long.valueOf(Thread.currentThread().getId()) });
      }
    }
    try
    {
      Object localObject3 = ((c)localObject2).mVc;
      if (localObject3 != null) {
        ((d)localObject3).close();
      }
      if (((c)localObject2).muW != null)
      {
        localObject3 = ((c)localObject2).muW;
        s.checkNotNull(localObject3);
        ((k)localObject3).destroy();
        ((c)localObject2).muW = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(c.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    GLES20.glDeleteProgram(((j)localObject1).programId);
    localObject1 = this.mVZ;
    if (localObject1 != null) {
      ((MTimerHandler)localObject1).stopTimer();
    }
    localObject1 = this.mVZ;
    if (localObject1 != null) {
      ((MTimerHandler)localObject1).quit();
    }
    AppMethodBeat.o(247855);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(247832);
    e locale = this.mVN;
    if (locale != null) {
      locale.reset();
    }
    AppMethodBeat.o(247832);
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(247820);
    super.th(paramInt);
    bgG();
    AppMethodBeat.o(247820);
  }
  
  public final void w(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(247758);
    MTimerHandler localMTimerHandler;
    if (paramb == null)
    {
      localMTimerHandler = this.mVZ;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      localMTimerHandler = this.mVZ;
      if (localMTimerHandler != null) {
        localMTimerHandler.quitSafely();
      }
      this.mVX = paramb;
      AppMethodBeat.o(247758);
      return;
    }
    if (this.mVZ != null)
    {
      localMTimerHandler = this.mVZ;
      if ((localMTimerHandler == null) || (localMTimerHandler.isQuit() != true)) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mVZ = new MTimerHandler("LiveRenderFpsCounter", new g..ExternalSyntheticLambda0(this), true);
      }
      localMTimerHandler = this.mVZ;
      if (localMTimerHandler == null) {
        break;
      }
      localMTimerHandler.startTimer(1000L);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.g
 * JD-Core Version:    0.7.0.1
 */