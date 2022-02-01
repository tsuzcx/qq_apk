package com.tencent.mm.dynamicbackground.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.b;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.model.d;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 11}, iBL={""}, iBM={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRenderer", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "doInit", "", "onAttachedToWindow", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "releaseAsyn", "l", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$ReleaseListener;", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "ReleaseListener", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView
  extends GameGLSurfaceView
{
  public static final DynamicBackgroundGLSurfaceView.a jBV;
  private b jBS;
  private boolean jBT;
  private boolean jBU;
  
  static
  {
    AppMethodBeat.i(103118);
    jBV = new DynamicBackgroundGLSurfaceView.a((byte)0);
    AppMethodBeat.o(103118);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103117);
    setEGLContextClientVersion(2);
    aAR();
    setPreserveEGLContextOnPause(true);
    this.jBS = new b(paramContext);
    setRenderer((GameGLSurfaceView.o)this.jBS);
    aAQ();
    getHolder().setFormat(-3);
    paramContext = this.jBS;
    if (paramContext != null)
    {
      paramAttributeSet = (GameGLSurfaceView)this;
      p.k(paramAttributeSet, "surfaceView");
      paramContext.jCe = paramAttributeSet;
      AppMethodBeat.o(103117);
      return;
    }
    AppMethodBeat.o(103117);
  }
  
  public final void i(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(214067);
    Object localObject = this.jBS;
    if (localObject != null)
    {
      ((b)localObject).jCh = new DynamicBackgroundGLSurfaceView.b.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      if (((b)localObject).jCi)
      {
        DynamicBackgroundNative localDynamicBackgroundNative = ((b)localObject).jBW;
        if (localDynamicBackgroundNative != null)
        {
          DynamicBackgroundGLSurfaceView.b.a locala = ((b)localObject).jCh;
          if (locala == null) {
            p.iCn();
          }
          paramInt1 = locala.jCm;
          locala = ((b)localObject).jCh;
          if (locala == null) {
            p.iCn();
          }
          paramInt2 = locala.jCn;
          locala = ((b)localObject).jCh;
          if (locala == null) {
            p.iCn();
          }
          paramInt3 = locala.jCo;
          locala = ((b)localObject).jCh;
          if (locala == null) {
            p.iCn();
          }
          paramInt4 = locala.jCp;
          localObject = ((b)localObject).jCh;
          if (localObject == null) {
            p.iCn();
          }
          localDynamicBackgroundNative.i(paramInt1, paramInt2, paramInt3, paramInt4, ((DynamicBackgroundGLSurfaceView.b.a)localObject).jCq);
          AppMethodBeat.o(214067);
          return;
        }
      }
      AppMethodBeat.o(214067);
      return;
    }
    AppMethodBeat.o(214067);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(103113);
    super.onAttachedToWindow();
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onAttachedToWindow", new Object[0]);
    AppMethodBeat.o(103113);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(103110);
    super.onDetachedFromWindow();
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onDetachedFromWindow", new Object[0]);
    AppMethodBeat.o(103110);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(103115);
    super.onResume();
    this.jBT = false;
    AppMethodBeat.o(103115);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(103114);
    p.k(paramView, "changedView");
    super.onVisibilityChanged(paramView, paramInt);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (this.jBT))
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause", new Object[0]);
      this.jBT = false;
    }
    AppMethodBeat.o(103114);
  }
  
  public final void setGradientBackgroundView(View paramView)
  {
    AppMethodBeat.i(103116);
    p.k(paramView, "gradientColorBackgroundView");
    b localb = this.jBS;
    if (localb != null)
    {
      p.k(paramView, "gradientColorBackgroundView");
      localb.jCb = paramView;
      AppMethodBeat.o(103116);
      return;
    }
    AppMethodBeat.o(103116);
  }
  
  public final void setShowGradientView(boolean paramBoolean)
  {
    this.jBU = paramBoolean;
    b localb = this.jBS;
    if (localb != null)
    {
      localb.jBU = paramBoolean;
      if (!localb.jBU) {
        localb.jCd = false;
      }
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103112);
    super.surfaceCreated(paramSurfaceHolder);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceCreated", new Object[0]);
    AppMethodBeat.o(103112);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(103111);
    super.surfaceDestroyed(paramSurfaceHolder);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo surfaceDestroyed", new Object[0]);
    paramSurfaceHolder = this.jBS;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.jCc = false;
      AppMethodBeat.o(103111);
      return;
    }
    AppMethodBeat.o(103111);
  }
  
  @l(iBK={1, 1, 11}, iBL={""}, iBM={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "doInit", "", "getSleepTime", "init", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "preDestroy", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
  public static final class b
    implements GameGLSurfaceView.o
  {
    private static long jCk;
    public static final DynamicBackgroundGLSurfaceView.b.b jCl;
    boolean jBU;
    DynamicBackgroundNative jBW;
    private WeakReference<Context> jBX;
    private long jBY;
    int jBZ;
    int jCa;
    View jCb;
    boolean jCc;
    boolean jCd;
    GameGLSurfaceView jCe;
    private int jCf;
    private boolean jCg;
    a jCh;
    boolean jCi;
    private com.tencent.mm.dynamicbackground.model.c jCj;
    
    static
    {
      AppMethodBeat.i(103109);
      jCl = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
      jCk = 500L;
      AppMethodBeat.o(103109);
    }
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(103108);
      this.jBY = -1L;
      this.jCg = true;
      Object localObject = d.jBF;
      this.jCj = d.aAF();
      localObject = this.jCj;
      if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).aAt() == true))
      {
        localObject = this.jCj;
        if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).aAw())) {
          this.jBW = new DynamicBackgroundNative();
        }
      }
      for (;;)
      {
        this.jBX = new WeakReference(paramContext);
        AppMethodBeat.o(103108);
        return;
        com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
      }
    }
    
    private void aAJ()
    {
      AppMethodBeat.i(103102);
      Object localObject1 = this.jBW;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).cQ(this.jBZ, this.jCa);
      }
      localObject1 = (Context)this.jBX.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103102);
        return;
      }
      Object localObject2 = new StringBuilder();
      Object localObject3 = b.jBP;
      localObject2 = b.cC((Context)localObject1) + "scene_shaderv.glsl";
      localObject3 = new StringBuilder();
      Object localObject4 = b.jBP;
      localObject3 = b.cC((Context)localObject1) + "scene_shaderf.glsl";
      localObject4 = new StringBuilder();
      Object localObject5 = b.jBP;
      localObject4 = b.cC((Context)localObject1) + "vertex_framebuffer_plane.glsl";
      localObject5 = new StringBuilder();
      Object localObject6 = b.jBP;
      localObject5 = b.cC((Context)localObject1) + "frag_framebuffer_plane.glsl";
      localObject6 = new StringBuilder();
      Object localObject7 = b.jBP;
      localObject6 = b.cC((Context)localObject1) + "texture_vertex_shader.glsl";
      localObject7 = new StringBuilder();
      Object localObject8 = b.jBP;
      localObject7 = b.cC((Context)localObject1) + "texture_fragment_shader.glsl";
      localObject8 = new StringBuilder();
      Object localObject9 = b.jBP;
      localObject8 = b.cC((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
      localObject9 = new StringBuilder();
      b localb = b.jBP;
      localObject1 = b.cC((Context)localObject1) + "bg_gradient_fragment_shader.glsl";
      localObject9 = this.jBW;
      if (localObject9 != null) {
        ((DynamicBackgroundNative)localObject9).a((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject1);
      }
      localObject1 = this.jBW;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).initView();
      }
      this.jCf = 0;
      AppMethodBeat.o(103102);
    }
    
    private final void init()
    {
      AppMethodBeat.i(103098);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
      try
      {
        Object localObject = this.jBW;
        if ((localObject != null) && (((DynamicBackgroundNative)localObject).jBz <= 0L))
        {
          ((DynamicBackgroundNative)localObject).jBz = ((DynamicBackgroundNative)localObject).nativeInit();
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBackgroundNative", "create DynamicBackgroundNative inst: " + ((DynamicBackgroundNative)localObject).jBz, new Object[0]);
        }
        this.jCi = true;
        localObject = this.jCh;
        if (localObject != null)
        {
          DynamicBackgroundNative localDynamicBackgroundNative2 = this.jBW;
          if (localDynamicBackgroundNative2 != null)
          {
            localDynamicBackgroundNative2.i(((a)localObject).jCm, ((a)localObject).jCn, ((a)localObject).jCo, ((a)localObject).jCp, ((a)localObject).jCq);
            AppMethodBeat.o(103098);
            return;
          }
          AppMethodBeat.o(103098);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable1, "alvinluo nativeInit exception", new Object[0]);
        if ((localThrowable1 instanceof UnsatisfiedLinkError))
        {
          com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo nativeInit called failed, try to load so once more", new Object[0]);
          try
          {
            System.loadLibrary("dynamicBg");
            DynamicBackgroundNative localDynamicBackgroundNative1 = this.jBW;
            if (localDynamicBackgroundNative1 != null) {
              localDynamicBackgroundNative1.nativeInit();
            }
            this.jCi = true;
            AppMethodBeat.o(103098);
            return;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.mm.dynamicbackground.model.c localc = this.jCj;
            if (localc == null) {
              break label230;
            }
            localc.aAy();
            AppMethodBeat.o(103098);
            return;
          }
          AppMethodBeat.o(103098);
          return;
        }
        label230:
        AppMethodBeat.o(103098);
      }
    }
    
    public final void aAH()
    {
      AppMethodBeat.i(103099);
      try
      {
        init();
        Object localObject1 = (Context)this.jBX.get();
        if (localObject1 == null)
        {
          AppMethodBeat.o(103099);
          return;
        }
        Object localObject2 = this.jCj;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).au((Context)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Point(0, 0);
        }
        this.jBZ = ((Point)localObject1).x;
        this.jCa = ((Point)localObject1).y;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.jBZ), Integer.valueOf(this.jCa) });
        aAJ();
        localObject1 = this.jCj;
        if (localObject1 != null)
        {
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aAt() != true) {
            break label233;
          }
          localObject1 = this.jCj;
          if (localObject1 == null) {
            break label219;
          }
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aAA()) {
            break label233;
          }
          localObject1 = this.jCj;
          if (localObject1 == null) {
            break label226;
          }
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).aAz();
          AppMethodBeat.o(103099);
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.jCj;
        if (localc != null)
        {
          localc.aAy();
          AppMethodBeat.o(103099);
          return;
          AppMethodBeat.o(103099);
          return;
          label219:
          AppMethodBeat.o(103099);
          return;
          label226:
          AppMethodBeat.o(103099);
          return;
        }
        label233:
        AppMethodBeat.o(103099);
      }
    }
    
    public final void aAI()
    {
      AppMethodBeat.i(103100);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
      this.jCf = 0;
      AppMethodBeat.o(103100);
    }
    
    public final long aAK()
    {
      AppMethodBeat.i(214056);
      com.tencent.mm.dynamicbackground.model.c localc = this.jCj;
      if (localc != null)
      {
        long l = localc.aAE();
        AppMethodBeat.o(214056);
        return l;
      }
      AppMethodBeat.o(214056);
      return 16L;
    }
    
    public final void aAL()
    {
      AppMethodBeat.i(103103);
      Object localObject1 = this.jCj;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aAB() == true))
      {
        localObject1 = this.jCj;
        if (localObject1 != null) {
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).aAC();
        }
      }
      try
      {
        localObject1 = this.jBW;
        if ((localObject1 != null) && (((DynamicBackgroundNative)localObject1).jBz > 0L)) {
          ((DynamicBackgroundNative)localObject1).draw(((DynamicBackgroundNative)localObject1).jBz);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
          localObject2 = this.jCj;
          if (localObject2 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject2).aAu();
          }
        }
        AppMethodBeat.o(103103);
        return;
      }
      localObject1 = this.jCj;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aAB() == true))
      {
        this.jCf += 1;
        if (this.jCf >= 2)
        {
          localObject1 = this.jCj;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).aAD();
          }
        }
      }
      if ((!this.jBU) && (!this.jCd))
      {
        this.jCd = true;
        localObject1 = this.jCb;
        if (localObject1 != null)
        {
          ((View)localObject1).post((Runnable)new c(this));
          AppMethodBeat.o(103103);
          return;
        }
      }
      Object localObject2;
      if (this.jBU)
      {
        localObject2 = this.jCb;
        if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
        {
          localObject2 = this.jCb;
          if (localObject2 != null)
          {
            ((View)localObject2).post((Runnable)new d(this));
            AppMethodBeat.o(103103);
            return;
          }
        }
      }
      AppMethodBeat.o(103103);
    }
    
    public final void aAM()
    {
      AppMethodBeat.i(214059);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "preDestroy", new Object[0]);
      DynamicBackgroundNative localDynamicBackgroundNative = this.jBW;
      if (localDynamicBackgroundNative != null)
      {
        if (localDynamicBackgroundNative.jBA <= 0L)
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBackgroundNative", "preRelease: " + localDynamicBackgroundNative.jBz, new Object[0]);
          localDynamicBackgroundNative.jBA = localDynamicBackgroundNative.jBz;
          localDynamicBackgroundNative.jBz = -1L;
        }
        AppMethodBeat.o(214059);
        return;
      }
      AppMethodBeat.o(214059);
    }
    
    public final void aAN()
    {
      AppMethodBeat.i(103107);
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.jCj;
      if (localc != null)
      {
        localc.aAx();
        AppMethodBeat.o(103107);
        return;
      }
      AppMethodBeat.o(103107);
    }
    
    public final void cR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(103101);
      try
      {
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (((this.jBZ != paramInt1) && (this.jCa == paramInt2)) || ((this.jCa != paramInt2) && (this.jBZ != paramInt1)))
        {
          init();
          this.jBZ = paramInt1;
          this.jCa = paramInt2;
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.jBZ), Integer.valueOf(this.jCa) });
          aAJ();
          AppMethodBeat.o(103101);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.jCj;
        if (localc != null)
        {
          localc.aAu();
          AppMethodBeat.o(103101);
          return;
        }
        AppMethodBeat.o(103101);
      }
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(103105);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onDestroy", new Object[0]);
      try
      {
        DynamicBackgroundNative localDynamicBackgroundNative = this.jBW;
        if (localDynamicBackgroundNative != null)
        {
          localDynamicBackgroundNative.nativeRelease();
          AppMethodBeat.o(103105);
          return;
        }
        AppMethodBeat.o(103105);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeRelease exception", new Object[0]);
        AppMethodBeat.o(103105);
      }
    }
    
    public final void onPause()
    {
      AppMethodBeat.i(103106);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onPause", new Object[0]);
      AppMethodBeat.o(103106);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(103104);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onResume", new Object[0]);
      this.jCg = true;
      AppMethodBeat.o(103104);
    }
    
    @l(iBK={1, 1, 11}, iBL={""}, iBM={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"})
    static final class a
    {
      final int jCm;
      final int jCn;
      final int jCo;
      final int jCp;
      final int jCq;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        this.jCm = paramInt1;
        this.jCn = paramInt2;
        this.jCo = paramInt3;
        this.jCp = paramInt4;
        this.jCq = paramInt5;
      }
      
      public final boolean equals(Object paramObject)
      {
        boolean bool2 = false;
        boolean bool1;
        if (this != paramObject)
        {
          bool1 = bool2;
          if (!(paramObject instanceof a)) {
            break label125;
          }
          paramObject = (a)paramObject;
          if (this.jCm != paramObject.jCm) {
            break label127;
          }
          i = 1;
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.jCn != paramObject.jCn) {
            break label132;
          }
          i = 1;
          label56:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.jCo != paramObject.jCo) {
            break label137;
          }
          i = 1;
          label76:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.jCp != paramObject.jCp) {
            break label142;
          }
          i = 1;
          label96:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.jCq != paramObject.jCq) {
            break label147;
          }
        }
        label132:
        label137:
        label142:
        label147:
        for (int i = 1;; i = 0)
        {
          bool1 = bool2;
          if (i != 0) {
            bool1 = true;
          }
          label125:
          return bool1;
          label127:
          i = 0;
          break;
          i = 0;
          break label56;
          i = 0;
          break label76;
          i = 0;
          break label96;
        }
      }
      
      public final int hashCode()
      {
        return (((this.jCm * 31 + this.jCn) * 31 + this.jCo) * 31 + this.jCp) * 31 + this.jCq;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(214030);
        String str = "ColorInfo(particleColor1=" + this.jCm + ", particleColor2=" + this.jCn + ", particleColor3=" + this.jCo + ", bgColor1=" + this.jCp + ", bgColor2=" + this.jCq + ")";
        AppMethodBeat.o(214030);
        return str;
      }
    }
    
    @l(iBK={1, 1, 11}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103095);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.jCr);
        if (localObject != null)
        {
          if ((((View)localObject).getVisibility() == 0) && (!this.jCr.jCc))
          {
            localObject = DynamicBackgroundGLSurfaceView.b.b(this.jCr);
            if (localObject != null) {
              ((GameGLSurfaceView)localObject).setVisibility(0);
            }
            this.jCr.jCc = true;
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.jCr);
            if (localObject != null) {
              ((View)localObject).setAlpha(1.0F);
            }
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.jCr);
            if (localObject != null)
            {
              localObject = ((View)localObject).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.aAO());
                  if (localObject != null)
                  {
                    localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                    {
                      public final void onAnimationCancel(Animator paramAnonymousAnimator)
                      {
                        this.jCs.jCr.jCc = false;
                      }
                      
                      public final void onAnimationEnd(Animator paramAnonymousAnimator)
                      {
                        AppMethodBeat.i(103094);
                        paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.jCs.jCr);
                        if (paramAnonymousAnimator != null) {
                          paramAnonymousAnimator.setVisibility(4);
                        }
                        this.jCs.jCr.jCc = false;
                        AppMethodBeat.o(103094);
                      }
                      
                      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                      
                      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
                    });
                    if (localObject != null)
                    {
                      ((ViewPropertyAnimator)localObject).start();
                      AppMethodBeat.o(103095);
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          AppMethodBeat.o(103095);
          return;
        }
        AppMethodBeat.o(103095);
      }
    }
    
    @l(iBK={1, 1, 11}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103097);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.jCr);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = DynamicBackgroundGLSurfaceView.b.a(this.jCr);
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
        localObject = DynamicBackgroundGLSurfaceView.b.b(this.jCr);
        if (localObject != null)
        {
          ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103096);
              GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.jCt.jCr);
              if (localGameGLSurfaceView != null) {
                localGameGLSurfaceView.onPause();
              }
              localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.jCt.jCr);
              if (localGameGLSurfaceView != null)
              {
                localGameGLSurfaceView.setVisibility(4);
                AppMethodBeat.o(103096);
                return;
              }
              AppMethodBeat.o(103096);
            }
          }, 50L);
          AppMethodBeat.o(103097);
          return;
        }
        AppMethodBeat.o(103097);
      }
    }
  }
  
  @l(iBK={1, 1, 11}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView, DynamicBackgroundGLSurfaceView.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(214064);
      DynamicBackgroundGLSurfaceView.b localb = DynamicBackgroundGLSurfaceView.a(this.jCu);
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.jBW;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          localb.jCb = null;
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.jBZ = 0;
          localb.jCa = 0;
          localb.jCi = false;
          localb.jBU = false;
          localb.jCd = false;
          localb.jCc = false;
          AppMethodBeat.o(214064);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeRelease exception", new Object[0]);
          AppMethodBeat.o(214064);
          return;
        }
      }
      AppMethodBeat.o(214064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */