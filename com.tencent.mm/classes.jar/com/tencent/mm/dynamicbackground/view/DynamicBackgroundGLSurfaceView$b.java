package com.tencent.mm.dynamicbackground.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.b;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.model.d;
import d.l;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 11}, gka={""}, gkb={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView$b
  implements GameGLSurfaceView.n
{
  private static long giw;
  public static final DynamicBackgroundGLSurfaceView.b.b gix;
  boolean gig;
  public DynamicBackgroundNative gii;
  private WeakReference<Context> gij;
  private long gik;
  public int gil;
  public int gim;
  View gin;
  boolean gio;
  boolean gip;
  GameGLSurfaceView giq;
  private int gir;
  private boolean gis;
  public a git;
  public boolean giu;
  private com.tencent.mm.dynamicbackground.model.c giv;
  
  static
  {
    AppMethodBeat.i(103109);
    gix = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
    giw = 500L;
    AppMethodBeat.o(103109);
  }
  
  public DynamicBackgroundGLSurfaceView$b(Context paramContext)
  {
    AppMethodBeat.i(103108);
    this.gik = -1L;
    this.gis = true;
    Object localObject = d.ghR;
    this.giv = d.aeg();
    localObject = this.giv;
    if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).adU() == true))
    {
      localObject = this.giv;
      if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).adX())) {
        this.gii = new DynamicBackgroundNative();
      }
    }
    for (;;)
    {
      this.gij = new WeakReference(paramContext);
      AppMethodBeat.o(103108);
      return;
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
    }
  }
  
  private final void aek()
  {
    AppMethodBeat.i(103102);
    Object localObject1 = this.gii;
    if (localObject1 != null) {
      ((DynamicBackgroundNative)localObject1).surfaceCreated(this.gil, this.gim);
    }
    localObject1 = (Context)this.gij.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(103102);
      return;
    }
    DynamicBackgroundNative localDynamicBackgroundNative = this.gii;
    if (localDynamicBackgroundNative != null)
    {
      Object localObject2 = new StringBuilder();
      Object localObject3 = b.gib;
      localObject2 = b.cl((Context)localObject1) + "scene_shaderv.glsl";
      localObject3 = new StringBuilder();
      Object localObject4 = b.gib;
      localObject3 = b.cl((Context)localObject1) + "scene_shaderf.glsl";
      localObject4 = new StringBuilder();
      Object localObject5 = b.gib;
      localObject4 = b.cl((Context)localObject1) + "vertex_framebuffer_plane.glsl";
      localObject5 = new StringBuilder();
      Object localObject6 = b.gib;
      localObject5 = b.cl((Context)localObject1) + "frag_framebuffer_plane.glsl";
      localObject6 = new StringBuilder();
      Object localObject7 = b.gib;
      localObject6 = b.cl((Context)localObject1) + "texture_vertex_shader.glsl";
      localObject7 = new StringBuilder();
      Object localObject8 = b.gib;
      localObject7 = b.cl((Context)localObject1) + "texture_fragment_shader.glsl";
      localObject8 = new StringBuilder();
      Object localObject9 = b.gib;
      localObject8 = b.cl((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
      localObject9 = new StringBuilder();
      b localb = b.gib;
      localDynamicBackgroundNative.setupGlslFiles((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, b.cl((Context)localObject1) + "bg_gradient_fragment_shader.glsl");
    }
    localObject1 = this.gii;
    if (localObject1 != null) {
      ((DynamicBackgroundNative)localObject1).initView();
    }
    this.gir = 0;
    AppMethodBeat.o(103102);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103098);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
    try
    {
      Object localObject = this.gii;
      if (localObject != null) {
        ((DynamicBackgroundNative)localObject).nativeInit();
      }
      this.giu = true;
      localObject = this.git;
      if (localObject != null)
      {
        DynamicBackgroundNative localDynamicBackgroundNative2 = this.gii;
        if (localDynamicBackgroundNative2 != null)
        {
          localDynamicBackgroundNative2.setColor(((a)localObject).giy, ((a)localObject).giz, ((a)localObject).giA, ((a)localObject).giB, ((a)localObject).giC);
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
          DynamicBackgroundNative localDynamicBackgroundNative1 = this.gii;
          if (localDynamicBackgroundNative1 != null) {
            localDynamicBackgroundNative1.nativeInit();
          }
          this.giu = true;
          AppMethodBeat.o(103098);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.dynamicbackground.model.c localc = this.giv;
          if (localc == null) {
            break label186;
          }
          localc.adZ();
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
  
  public final void aei()
  {
    AppMethodBeat.i(103099);
    try
    {
      init();
      Object localObject1 = (Context)this.gij.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103099);
        return;
      }
      Object localObject2 = this.giv;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).ck((Context)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = new Point(0, 0);
      }
      this.gil = ((Point)localObject1).x;
      this.gim = ((Point)localObject1).y;
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.gil), Integer.valueOf(this.gim) });
      aek();
      localObject1 = this.giv;
      if (localObject1 != null)
      {
        if (((com.tencent.mm.dynamicbackground.model.c)localObject1).adU() != true) {
          break label233;
        }
        localObject1 = this.giv;
        if (localObject1 == null) {
          break label219;
        }
        if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aeb()) {
          break label233;
        }
        localObject1 = this.giv;
        if (localObject1 == null) {
          break label226;
        }
        ((com.tencent.mm.dynamicbackground.model.c)localObject1).aea();
        AppMethodBeat.o(103099);
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.giv;
      if (localc != null)
      {
        localc.adZ();
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
  
  public final void aej()
  {
    AppMethodBeat.i(103100);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
    this.gir = 0;
    AppMethodBeat.o(103100);
  }
  
  public final void ael()
  {
    AppMethodBeat.i(103103);
    for (;;)
    {
      try
      {
        localObject1 = this.giv;
        if (localObject1 == null) {
          continue;
        }
        l = ((com.tencent.mm.dynamicbackground.model.c)localObject1).aef();
        Thread.sleep(l);
      }
      catch (Exception localException)
      {
        Object localObject1;
        long l;
        Object localObject2;
        continue;
      }
      localObject1 = this.giv;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aec() == true))
      {
        localObject1 = this.giv;
        if (localObject1 != null) {
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).aed();
        }
      }
      try
      {
        localObject1 = this.gii;
        if (localObject1 != null) {
          ((DynamicBackgroundNative)localObject1).draw();
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
        localObject2 = this.giv;
        if (localObject2 == null) {
          continue;
        }
        ((com.tencent.mm.dynamicbackground.model.c)localObject2).adV();
        continue;
        AppMethodBeat.o(103103);
        return;
      }
      localObject1 = this.giv;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aec() == true))
      {
        this.gir += 1;
        if (this.gir >= 2)
        {
          localObject1 = this.giv;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).aee();
          }
        }
      }
      if ((this.gig) || (this.gip)) {
        continue;
      }
      this.gip = true;
      localObject1 = this.gin;
      if (localObject1 == null) {
        continue;
      }
      ((View)localObject1).post((Runnable)new c(this));
      AppMethodBeat.o(103103);
      return;
      l = 16L;
    }
    if (this.gig)
    {
      localObject2 = this.gin;
      if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
      {
        localObject2 = this.gin;
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
  
  public final void aem()
  {
    AppMethodBeat.i(103107);
    com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
    com.tencent.mm.dynamicbackground.model.c localc = this.giv;
    if (localc != null)
    {
      localc.adY();
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
      if ((this.gil != paramInt1) && (this.gim != paramInt2))
      {
        init();
        this.gil = paramInt1;
        this.gim = paramInt2;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.gil), Integer.valueOf(this.gim) });
        aek();
        AppMethodBeat.o(103101);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.giv;
      if (localc != null)
      {
        localc.adV();
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
      DynamicBackgroundNative localDynamicBackgroundNative = this.gii;
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
    this.gis = true;
    AppMethodBeat.o(103104);
  }
  
  @l(gjZ={1, 1, 11}, gka={""}, gkb={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"})
  public static final class a
  {
    public final int giA;
    public final int giB;
    public final int giC;
    public final int giy;
    public final int giz;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.giy = paramInt1;
      this.giz = paramInt2;
      this.giA = paramInt3;
      this.giB = paramInt4;
      this.giC = paramInt5;
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
        if (this.giy != paramObject.giy) {
          break label127;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.giz != paramObject.giz) {
          break label132;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.giA != paramObject.giA) {
          break label137;
        }
        i = 1;
        label76:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.giB != paramObject.giB) {
          break label142;
        }
        i = 1;
        label96:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.giC != paramObject.giC) {
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
      return (((this.giy * 31 + this.giz) * 31 + this.giA) * 31 + this.giB) * 31 + this.giC;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195401);
      String str = "ColorInfo(particleColor1=" + this.giy + ", particleColor2=" + this.giz + ", particleColor3=" + this.giA + ", bgColor1=" + this.giB + ", bgColor2=" + this.giC + ")";
      AppMethodBeat.o(195401);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 11}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(DynamicBackgroundGLSurfaceView.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(103095);
      Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.giD);
      if (localObject != null)
      {
        if ((((View)localObject).getVisibility() == 0) && (!this.giD.gio))
        {
          localObject = DynamicBackgroundGLSurfaceView.b.b(this.giD);
          if (localObject != null) {
            ((GameGLSurfaceView)localObject).setVisibility(0);
          }
          this.giD.gio = true;
          localObject = DynamicBackgroundGLSurfaceView.b.a(this.giD);
          if (localObject != null) {
            ((View)localObject).setAlpha(1.0F);
          }
          com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
          localObject = DynamicBackgroundGLSurfaceView.b.a(this.giD);
          if (localObject != null)
          {
            localObject = ((View)localObject).animate();
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.aen());
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                  {
                    public final void onAnimationCancel(Animator paramAnonymousAnimator)
                    {
                      this.giE.giD.gio = false;
                    }
                    
                    public final void onAnimationEnd(Animator paramAnonymousAnimator)
                    {
                      AppMethodBeat.i(103094);
                      paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.giE.giD);
                      if (paramAnonymousAnimator != null) {
                        paramAnonymousAnimator.setVisibility(4);
                      }
                      this.giE.giD.gio = false;
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
  
  @l(gjZ={1, 1, 11}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(DynamicBackgroundGLSurfaceView.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(103097);
      Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.giD);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = DynamicBackgroundGLSurfaceView.b.a(this.giD);
      if (localObject != null) {
        ((View)localObject).setAlpha(1.0F);
      }
      com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
      localObject = DynamicBackgroundGLSurfaceView.b.b(this.giD);
      if (localObject != null)
      {
        ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(103096);
            GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.giF.giD);
            if (localGameGLSurfaceView != null) {
              localGameGLSurfaceView.onPause();
            }
            localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.giF.giD);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */