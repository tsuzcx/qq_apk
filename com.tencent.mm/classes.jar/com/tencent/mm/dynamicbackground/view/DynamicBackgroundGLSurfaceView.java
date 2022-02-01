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
import d.g.b.p;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRenderer", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "onAttachedToWindow", "", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "release", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView
  extends GameGLSurfaceView
{
  public static final DynamicBackgroundGLSurfaceView.a gfP;
  public b gfM;
  private boolean gfN;
  private boolean gfO;
  
  static
  {
    AppMethodBeat.i(103118);
    gfP = new DynamicBackgroundGLSurfaceView.a((byte)0);
    AppMethodBeat.o(103118);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103117);
    setEGLContextClientVersion(2);
    aed();
    setPreserveEGLContextOnPause(true);
    this.gfM = new b(paramContext);
    setRenderer((GameGLSurfaceView.n)this.gfM);
    getHolder().setFormat(-3);
    paramContext = this.gfM;
    if (paramContext != null)
    {
      paramAttributeSet = (GameGLSurfaceView)this;
      p.h(paramAttributeSet, "surfaceView");
      paramContext.gfY = paramAttributeSet;
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
    this.gfN = false;
    AppMethodBeat.o(103115);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(103114);
    p.h(paramView, "changedView");
    super.onVisibilityChanged(paramView, paramInt);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (this.gfN))
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause", new Object[0]);
      this.gfN = false;
    }
    AppMethodBeat.o(103114);
  }
  
  public final void setGradientBackgroundView(View paramView)
  {
    AppMethodBeat.i(103116);
    p.h(paramView, "gradientColorBackgroundView");
    b localb = this.gfM;
    if (localb != null)
    {
      p.h(paramView, "gradientColorBackgroundView");
      localb.gfV = paramView;
      AppMethodBeat.o(103116);
      return;
    }
    AppMethodBeat.o(103116);
  }
  
  public final void setShowGradientView(boolean paramBoolean)
  {
    this.gfO = paramBoolean;
    b localb = this.gfM;
    if (localb != null)
    {
      localb.gfO = paramBoolean;
      if (!localb.gfO) {
        localb.gfX = false;
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
    paramSurfaceHolder = this.gfM;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.gfW = false;
      AppMethodBeat.o(103111);
      return;
    }
    AppMethodBeat.o(103111);
  }
  
  @l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
  public static final class b
    implements GameGLSurfaceView.n
  {
    private static long gge;
    public static final DynamicBackgroundGLSurfaceView.b.b ggf;
    boolean gfO;
    public DynamicBackgroundNative gfQ;
    private WeakReference<Context> gfR;
    private long gfS;
    public int gfT;
    public int gfU;
    View gfV;
    boolean gfW;
    boolean gfX;
    GameGLSurfaceView gfY;
    private int gfZ;
    private boolean gga;
    public a ggb;
    public boolean ggc;
    private com.tencent.mm.dynamicbackground.model.c ggd;
    
    static
    {
      AppMethodBeat.i(103109);
      ggf = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
      gge = 500L;
      AppMethodBeat.o(103109);
    }
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(103108);
      this.gfS = -1L;
      this.gga = true;
      Object localObject = d.gfz;
      this.ggd = d.adU();
      localObject = this.ggd;
      if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).adI() == true))
      {
        localObject = this.ggd;
        if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).adL())) {
          this.gfQ = new DynamicBackgroundNative();
        }
      }
      for (;;)
      {
        this.gfR = new WeakReference(paramContext);
        AppMethodBeat.o(103108);
        return;
        com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
      }
    }
    
    private final void adY()
    {
      AppMethodBeat.i(103102);
      Object localObject1 = this.gfQ;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).surfaceCreated(this.gfT, this.gfU);
      }
      localObject1 = (Context)this.gfR.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103102);
        return;
      }
      DynamicBackgroundNative localDynamicBackgroundNative = this.gfQ;
      if (localDynamicBackgroundNative != null)
      {
        Object localObject2 = new StringBuilder();
        Object localObject3 = b.gfJ;
        localObject2 = b.cj((Context)localObject1) + "scene_shaderv.glsl";
        localObject3 = new StringBuilder();
        Object localObject4 = b.gfJ;
        localObject3 = b.cj((Context)localObject1) + "scene_shaderf.glsl";
        localObject4 = new StringBuilder();
        Object localObject5 = b.gfJ;
        localObject4 = b.cj((Context)localObject1) + "vertex_framebuffer_plane.glsl";
        localObject5 = new StringBuilder();
        Object localObject6 = b.gfJ;
        localObject5 = b.cj((Context)localObject1) + "frag_framebuffer_plane.glsl";
        localObject6 = new StringBuilder();
        Object localObject7 = b.gfJ;
        localObject6 = b.cj((Context)localObject1) + "texture_vertex_shader.glsl";
        localObject7 = new StringBuilder();
        Object localObject8 = b.gfJ;
        localObject7 = b.cj((Context)localObject1) + "texture_fragment_shader.glsl";
        localObject8 = new StringBuilder();
        Object localObject9 = b.gfJ;
        localObject8 = b.cj((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
        localObject9 = new StringBuilder();
        b localb = b.gfJ;
        localDynamicBackgroundNative.setupGlslFiles((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, b.cj((Context)localObject1) + "bg_gradient_fragment_shader.glsl");
      }
      localObject1 = this.gfQ;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).initView();
      }
      this.gfZ = 0;
      AppMethodBeat.o(103102);
    }
    
    private final void init()
    {
      AppMethodBeat.i(103098);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
      try
      {
        Object localObject = this.gfQ;
        if (localObject != null) {
          ((DynamicBackgroundNative)localObject).nativeInit();
        }
        this.ggc = true;
        localObject = this.ggb;
        if (localObject != null)
        {
          DynamicBackgroundNative localDynamicBackgroundNative2 = this.gfQ;
          if (localDynamicBackgroundNative2 != null)
          {
            localDynamicBackgroundNative2.setColor(((a)localObject).ggg, ((a)localObject).ggh, ((a)localObject).ggi, ((a)localObject).ggj, ((a)localObject).ggk);
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
            DynamicBackgroundNative localDynamicBackgroundNative1 = this.gfQ;
            if (localDynamicBackgroundNative1 != null) {
              localDynamicBackgroundNative1.nativeInit();
            }
            this.ggc = true;
            AppMethodBeat.o(103098);
            return;
          }
          catch (Throwable localThrowable2)
          {
            com.tencent.mm.dynamicbackground.model.c localc = this.ggd;
            if (localc == null) {
              break label186;
            }
            localc.adN();
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
    
    public final void adW()
    {
      AppMethodBeat.i(103099);
      try
      {
        init();
        Object localObject1 = (Context)this.gfR.get();
        if (localObject1 == null)
        {
          AppMethodBeat.o(103099);
          return;
        }
        Object localObject2 = this.ggd;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).ci((Context)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Point(0, 0);
        }
        this.gfT = ((Point)localObject1).x;
        this.gfU = ((Point)localObject1).y;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.gfT), Integer.valueOf(this.gfU) });
        adY();
        localObject1 = this.ggd;
        if (localObject1 != null)
        {
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).adI() != true) {
            break label233;
          }
          localObject1 = this.ggd;
          if (localObject1 == null) {
            break label219;
          }
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).adP()) {
            break label233;
          }
          localObject1 = this.ggd;
          if (localObject1 == null) {
            break label226;
          }
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).adO();
          AppMethodBeat.o(103099);
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.ggd;
        if (localc != null)
        {
          localc.adN();
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
    
    public final void adX()
    {
      AppMethodBeat.i(103100);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
      this.gfZ = 0;
      AppMethodBeat.o(103100);
    }
    
    public final void adZ()
    {
      AppMethodBeat.i(103103);
      for (;;)
      {
        try
        {
          localObject1 = this.ggd;
          if (localObject1 == null) {
            continue;
          }
          l = ((com.tencent.mm.dynamicbackground.model.c)localObject1).adT();
          Thread.sleep(l);
        }
        catch (Exception localException)
        {
          Object localObject1;
          long l;
          Object localObject2;
          continue;
        }
        localObject1 = this.ggd;
        if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).adQ() == true))
        {
          localObject1 = this.ggd;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).adR();
          }
        }
        try
        {
          localObject1 = this.gfQ;
          if (localObject1 != null) {
            ((DynamicBackgroundNative)localObject1).draw();
          }
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
          localObject2 = this.ggd;
          if (localObject2 == null) {
            continue;
          }
          ((com.tencent.mm.dynamicbackground.model.c)localObject2).adJ();
          continue;
          AppMethodBeat.o(103103);
          return;
        }
        localObject1 = this.ggd;
        if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).adQ() == true))
        {
          this.gfZ += 1;
          if (this.gfZ >= 2)
          {
            localObject1 = this.ggd;
            if (localObject1 != null) {
              ((com.tencent.mm.dynamicbackground.model.c)localObject1).adS();
            }
          }
        }
        if ((this.gfO) || (this.gfX)) {
          continue;
        }
        this.gfX = true;
        localObject1 = this.gfV;
        if (localObject1 == null) {
          continue;
        }
        ((View)localObject1).post((Runnable)new c(this));
        AppMethodBeat.o(103103);
        return;
        l = 16L;
      }
      if (this.gfO)
      {
        localObject2 = this.gfV;
        if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
        {
          localObject2 = this.gfV;
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
    
    public final void aea()
    {
      AppMethodBeat.i(103107);
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.ggd;
      if (localc != null)
      {
        localc.adM();
        AppMethodBeat.o(103107);
        return;
      }
      AppMethodBeat.o(103107);
    }
    
    public final void cu(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(103101);
      try
      {
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if ((this.gfT != paramInt1) && (this.gfU != paramInt2))
        {
          init();
          this.gfT = paramInt1;
          this.gfU = paramInt2;
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.gfT), Integer.valueOf(this.gfU) });
          adY();
          AppMethodBeat.o(103101);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.ggd;
        if (localc != null)
        {
          localc.adJ();
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
        DynamicBackgroundNative localDynamicBackgroundNative = this.gfQ;
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
      this.gga = true;
      AppMethodBeat.o(103104);
    }
    
    @l(gfx={1, 1, 11}, gfy={""}, gfz={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"})
    public static final class a
    {
      public final int ggg;
      public final int ggh;
      public final int ggi;
      public final int ggj;
      public final int ggk;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        this.ggg = paramInt1;
        this.ggh = paramInt2;
        this.ggi = paramInt3;
        this.ggj = paramInt4;
        this.ggk = paramInt5;
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
          if (this.ggg != paramObject.ggg) {
            break label127;
          }
          i = 1;
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.ggh != paramObject.ggh) {
            break label132;
          }
          i = 1;
          label56:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.ggi != paramObject.ggi) {
            break label137;
          }
          i = 1;
          label76:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.ggj != paramObject.ggj) {
            break label142;
          }
          i = 1;
          label96:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.ggk != paramObject.ggk) {
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
        return (((this.ggg * 31 + this.ggh) * 31 + this.ggi) * 31 + this.ggj) * 31 + this.ggk;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(220349);
        String str = "ColorInfo(particleColor1=" + this.ggg + ", particleColor2=" + this.ggh + ", particleColor3=" + this.ggi + ", bgColor1=" + this.ggj + ", bgColor2=" + this.ggk + ")";
        AppMethodBeat.o(220349);
        return str;
      }
    }
    
    @l(gfx={1, 1, 11}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103095);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.ggl);
        if (localObject != null)
        {
          if ((((View)localObject).getVisibility() == 0) && (!this.ggl.gfW))
          {
            localObject = DynamicBackgroundGLSurfaceView.b.b(this.ggl);
            if (localObject != null) {
              ((GameGLSurfaceView)localObject).setVisibility(0);
            }
            this.ggl.gfW = true;
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.ggl);
            if (localObject != null) {
              ((View)localObject).setAlpha(1.0F);
            }
            com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.ggl);
            if (localObject != null)
            {
              localObject = ((View)localObject).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.aeb());
                  if (localObject != null)
                  {
                    localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                    {
                      public final void onAnimationCancel(Animator paramAnonymousAnimator)
                      {
                        this.ggm.ggl.gfW = false;
                      }
                      
                      public final void onAnimationEnd(Animator paramAnonymousAnimator)
                      {
                        AppMethodBeat.i(103094);
                        paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.ggm.ggl);
                        if (paramAnonymousAnimator != null) {
                          paramAnonymousAnimator.setVisibility(4);
                        }
                        this.ggm.ggl.gfW = false;
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
    
    @l(gfx={1, 1, 11}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103097);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.ggl);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = DynamicBackgroundGLSurfaceView.b.a(this.ggl);
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
        com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
        localObject = DynamicBackgroundGLSurfaceView.b.b(this.ggl);
        if (localObject != null)
        {
          ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103096);
              GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.ggn.ggl);
              if (localGameGLSurfaceView != null) {
                localGameGLSurfaceView.onPause();
              }
              localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.ggn.ggl);
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