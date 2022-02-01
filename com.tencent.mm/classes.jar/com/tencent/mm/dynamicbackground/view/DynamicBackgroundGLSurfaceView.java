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

@l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRenderer", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView
  extends GameGLSurfaceView
{
  public static final DynamicBackgroundGLSurfaceView.a gRz;
  public b gRw;
  private boolean gRx;
  private boolean gRy;
  
  static
  {
    AppMethodBeat.i(103118);
    gRz = new DynamicBackgroundGLSurfaceView.a((byte)0);
    AppMethodBeat.o(103118);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103117);
    setEGLContextClientVersion(2);
    atW();
    setPreserveEGLContextOnPause(true);
    this.gRw = new b(paramContext);
    setRenderer((GameGLSurfaceView.n)this.gRw);
    getHolder().setFormat(-3);
    paramContext = this.gRw;
    if (paramContext != null)
    {
      paramAttributeSet = (GameGLSurfaceView)this;
      p.h(paramAttributeSet, "surfaceView");
      paramContext.gRI = paramAttributeSet;
      AppMethodBeat.o(103117);
      return;
    }
    AppMethodBeat.o(103117);
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
    this.gRx = false;
    AppMethodBeat.o(103115);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(103114);
    p.h(paramView, "changedView");
    super.onVisibilityChanged(paramView, paramInt);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (this.gRx))
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause", new Object[0]);
      this.gRx = false;
    }
    AppMethodBeat.o(103114);
  }
  
  public final void setColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(230546);
    Object localObject = this.gRw;
    if (localObject != null)
    {
      ((b)localObject).gRL = new DynamicBackgroundGLSurfaceView.b.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      if (((b)localObject).gRM)
      {
        DynamicBackgroundNative localDynamicBackgroundNative = ((b)localObject).gRA;
        if (localDynamicBackgroundNative != null)
        {
          DynamicBackgroundGLSurfaceView.b.a locala = ((b)localObject).gRL;
          if (locala == null) {
            p.hyc();
          }
          paramInt1 = locala.gRQ;
          locala = ((b)localObject).gRL;
          if (locala == null) {
            p.hyc();
          }
          paramInt2 = locala.gRR;
          locala = ((b)localObject).gRL;
          if (locala == null) {
            p.hyc();
          }
          paramInt3 = locala.gRS;
          locala = ((b)localObject).gRL;
          if (locala == null) {
            p.hyc();
          }
          paramInt4 = locala.gRT;
          localObject = ((b)localObject).gRL;
          if (localObject == null) {
            p.hyc();
          }
          localDynamicBackgroundNative.setColor(paramInt1, paramInt2, paramInt3, paramInt4, ((DynamicBackgroundGLSurfaceView.b.a)localObject).gRU);
          AppMethodBeat.o(230546);
          return;
        }
      }
      AppMethodBeat.o(230546);
      return;
    }
    AppMethodBeat.o(230546);
  }
  
  public final void setGradientBackgroundView(View paramView)
  {
    AppMethodBeat.i(103116);
    p.h(paramView, "gradientColorBackgroundView");
    b localb = this.gRw;
    if (localb != null)
    {
      p.h(paramView, "gradientColorBackgroundView");
      localb.gRF = paramView;
      AppMethodBeat.o(103116);
      return;
    }
    AppMethodBeat.o(103116);
  }
  
  public final void setShowGradientView(boolean paramBoolean)
  {
    this.gRy = paramBoolean;
    b localb = this.gRw;
    if (localb != null)
    {
      localb.gRy = paramBoolean;
      if (!localb.gRy) {
        localb.gRH = false;
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
    paramSurfaceHolder = this.gRw;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.gRG = false;
      AppMethodBeat.o(103111);
      return;
    }
    AppMethodBeat.o(103111);
  }
  
  @l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
  public static final class b
    implements GameGLSurfaceView.n
  {
    private static long gRO;
    public static final DynamicBackgroundGLSurfaceView.b.b gRP;
    public DynamicBackgroundNative gRA;
    private WeakReference<Context> gRB;
    private long gRC;
    public int gRD;
    public int gRE;
    View gRF;
    boolean gRG;
    boolean gRH;
    GameGLSurfaceView gRI;
    private int gRJ;
    private boolean gRK;
    a gRL;
    public boolean gRM;
    private com.tencent.mm.dynamicbackground.model.c gRN;
    boolean gRy;
    
    static
    {
      AppMethodBeat.i(103109);
      gRP = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
      gRO = 500L;
      AppMethodBeat.o(103109);
    }
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(103108);
      this.gRC = -1L;
      this.gRK = true;
      Object localObject = d.gRj;
      this.gRN = d.atN();
      localObject = this.gRN;
      if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).atB() == true))
      {
        localObject = this.gRN;
        if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).atE())) {
          this.gRA = new DynamicBackgroundNative();
        }
      }
      for (;;)
      {
        this.gRB = new WeakReference(paramContext);
        AppMethodBeat.o(103108);
        return;
        com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
      }
    }
    
    private final void atR()
    {
      AppMethodBeat.i(103102);
      Object localObject1 = this.gRA;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).surfaceCreated(this.gRD, this.gRE);
      }
      localObject1 = (Context)this.gRB.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103102);
        return;
      }
      DynamicBackgroundNative localDynamicBackgroundNative = this.gRA;
      if (localDynamicBackgroundNative != null)
      {
        Object localObject2 = new StringBuilder();
        Object localObject3 = b.gRt;
        localObject2 = b.cF((Context)localObject1) + "scene_shaderv.glsl";
        localObject3 = new StringBuilder();
        Object localObject4 = b.gRt;
        localObject3 = b.cF((Context)localObject1) + "scene_shaderf.glsl";
        localObject4 = new StringBuilder();
        Object localObject5 = b.gRt;
        localObject4 = b.cF((Context)localObject1) + "vertex_framebuffer_plane.glsl";
        localObject5 = new StringBuilder();
        Object localObject6 = b.gRt;
        localObject5 = b.cF((Context)localObject1) + "frag_framebuffer_plane.glsl";
        localObject6 = new StringBuilder();
        Object localObject7 = b.gRt;
        localObject6 = b.cF((Context)localObject1) + "texture_vertex_shader.glsl";
        localObject7 = new StringBuilder();
        Object localObject8 = b.gRt;
        localObject7 = b.cF((Context)localObject1) + "texture_fragment_shader.glsl";
        localObject8 = new StringBuilder();
        Object localObject9 = b.gRt;
        localObject8 = b.cF((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
        localObject9 = new StringBuilder();
        b localb = b.gRt;
        localDynamicBackgroundNative.setupGlslFiles((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, b.cF((Context)localObject1) + "bg_gradient_fragment_shader.glsl");
      }
      localObject1 = this.gRA;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).initView();
      }
      this.gRJ = 0;
      AppMethodBeat.o(103102);
    }
    
    private final void init()
    {
      AppMethodBeat.i(103098);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
      try
      {
        Object localObject = this.gRA;
        if (localObject != null) {
          ((DynamicBackgroundNative)localObject).nativeInit();
        }
        this.gRM = true;
        localObject = this.gRL;
        if (localObject != null)
        {
          DynamicBackgroundNative localDynamicBackgroundNative2 = this.gRA;
          if (localDynamicBackgroundNative2 != null)
          {
            localDynamicBackgroundNative2.setColor(((a)localObject).gRQ, ((a)localObject).gRR, ((a)localObject).gRS, ((a)localObject).gRT, ((a)localObject).gRU);
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
            DynamicBackgroundNative localDynamicBackgroundNative1 = this.gRA;
            if (localDynamicBackgroundNative1 != null) {
              localDynamicBackgroundNative1.nativeInit();
            }
            this.gRM = true;
            AppMethodBeat.o(103098);
            return;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.mm.dynamicbackground.model.c localc = this.gRN;
            if (localc == null) {
              break label186;
            }
            localc.atG();
            AppMethodBeat.o(103098);
            return;
          }
          AppMethodBeat.o(103098);
          return;
        }
        label186:
        AppMethodBeat.o(103098);
      }
    }
    
    public final void atP()
    {
      AppMethodBeat.i(103099);
      try
      {
        init();
        Object localObject1 = (Context)this.gRB.get();
        if (localObject1 == null)
        {
          AppMethodBeat.o(103099);
          return;
        }
        Object localObject2 = this.gRN;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).az((Context)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Point(0, 0);
        }
        this.gRD = ((Point)localObject1).x;
        this.gRE = ((Point)localObject1).y;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.gRD), Integer.valueOf(this.gRE) });
        atR();
        localObject1 = this.gRN;
        if (localObject1 != null)
        {
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).atB() != true) {
            break label233;
          }
          localObject1 = this.gRN;
          if (localObject1 == null) {
            break label219;
          }
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).atI()) {
            break label233;
          }
          localObject1 = this.gRN;
          if (localObject1 == null) {
            break label226;
          }
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).atH();
          AppMethodBeat.o(103099);
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.gRN;
        if (localc != null)
        {
          localc.atG();
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
    
    public final void atQ()
    {
      AppMethodBeat.i(103100);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
      this.gRJ = 0;
      AppMethodBeat.o(103100);
    }
    
    public final void atS()
    {
      AppMethodBeat.i(103103);
      for (;;)
      {
        try
        {
          localObject1 = this.gRN;
          if (localObject1 == null) {
            continue;
          }
          l = ((com.tencent.mm.dynamicbackground.model.c)localObject1).atM();
          Thread.sleep(l);
        }
        catch (Exception localException)
        {
          Object localObject1;
          long l;
          Object localObject2;
          continue;
        }
        localObject1 = this.gRN;
        if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).atJ() == true))
        {
          localObject1 = this.gRN;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).atK();
          }
        }
        try
        {
          localObject1 = this.gRA;
          if (localObject1 != null) {
            ((DynamicBackgroundNative)localObject1).draw();
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
          localObject2 = this.gRN;
          if (localObject2 == null) {
            continue;
          }
          ((com.tencent.mm.dynamicbackground.model.c)localObject2).atC();
          continue;
          AppMethodBeat.o(103103);
          return;
        }
        localObject1 = this.gRN;
        if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).atJ() == true))
        {
          this.gRJ += 1;
          if (this.gRJ >= 2)
          {
            localObject1 = this.gRN;
            if (localObject1 != null) {
              ((com.tencent.mm.dynamicbackground.model.c)localObject1).atL();
            }
          }
        }
        if ((this.gRy) || (this.gRH)) {
          continue;
        }
        this.gRH = true;
        localObject1 = this.gRF;
        if (localObject1 == null) {
          continue;
        }
        ((View)localObject1).post((Runnable)new c(this));
        AppMethodBeat.o(103103);
        return;
        l = 16L;
      }
      if (this.gRy)
      {
        localObject2 = this.gRF;
        if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
        {
          localObject2 = this.gRF;
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
    
    public final void atT()
    {
      AppMethodBeat.i(103107);
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.gRN;
      if (localc != null)
      {
        localc.atF();
        AppMethodBeat.o(103107);
        return;
      }
      AppMethodBeat.o(103107);
    }
    
    public final void cx(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(103101);
      try
      {
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (((this.gRD != paramInt1) && (this.gRE == paramInt2)) || ((this.gRE != paramInt2) && (this.gRD != paramInt1)))
        {
          init();
          this.gRD = paramInt1;
          this.gRE = paramInt2;
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.gRD), Integer.valueOf(this.gRE) });
          atR();
          AppMethodBeat.o(103101);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.gRN;
        if (localc != null)
        {
          localc.atC();
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
        DynamicBackgroundNative localDynamicBackgroundNative = this.gRA;
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
      this.gRK = true;
      AppMethodBeat.o(103104);
    }
    
    @l(hxD={1, 1, 11}, hxE={""}, hxF={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"})
    static final class a
    {
      final int gRQ;
      final int gRR;
      final int gRS;
      final int gRT;
      final int gRU;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        this.gRQ = paramInt1;
        this.gRR = paramInt2;
        this.gRS = paramInt3;
        this.gRT = paramInt4;
        this.gRU = paramInt5;
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
          if (this.gRQ != paramObject.gRQ) {
            break label127;
          }
          i = 1;
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.gRR != paramObject.gRR) {
            break label132;
          }
          i = 1;
          label56:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.gRS != paramObject.gRS) {
            break label137;
          }
          i = 1;
          label76:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.gRT != paramObject.gRT) {
            break label142;
          }
          i = 1;
          label96:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.gRU != paramObject.gRU) {
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
        return (((this.gRQ * 31 + this.gRR) * 31 + this.gRS) * 31 + this.gRT) * 31 + this.gRU;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(230545);
        String str = "ColorInfo(particleColor1=" + this.gRQ + ", particleColor2=" + this.gRR + ", particleColor3=" + this.gRS + ", bgColor1=" + this.gRT + ", bgColor2=" + this.gRU + ")";
        AppMethodBeat.o(230545);
        return str;
      }
    }
    
    @l(hxD={1, 1, 11}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103095);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.gRV);
        if (localObject != null)
        {
          if ((((View)localObject).getVisibility() == 0) && (!this.gRV.gRG))
          {
            localObject = DynamicBackgroundGLSurfaceView.b.b(this.gRV);
            if (localObject != null) {
              ((GameGLSurfaceView)localObject).setVisibility(0);
            }
            this.gRV.gRG = true;
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.gRV);
            if (localObject != null) {
              ((View)localObject).setAlpha(1.0F);
            }
            com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.gRV);
            if (localObject != null)
            {
              localObject = ((View)localObject).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.atU());
                  if (localObject != null)
                  {
                    localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                    {
                      public final void onAnimationCancel(Animator paramAnonymousAnimator)
                      {
                        this.gRW.gRV.gRG = false;
                      }
                      
                      public final void onAnimationEnd(Animator paramAnonymousAnimator)
                      {
                        AppMethodBeat.i(103094);
                        paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.gRW.gRV);
                        if (paramAnonymousAnimator != null) {
                          paramAnonymousAnimator.setVisibility(4);
                        }
                        this.gRW.gRV.gRG = false;
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
    
    @l(hxD={1, 1, 11}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103097);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.gRV);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = DynamicBackgroundGLSurfaceView.b.a(this.gRV);
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
        com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
        localObject = DynamicBackgroundGLSurfaceView.b.b(this.gRV);
        if (localObject != null)
        {
          ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103096);
              GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.gRX.gRV);
              if (localGameGLSurfaceView != null) {
                localGameGLSurfaceView.onPause();
              }
              localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.gRX.gRV);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */