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

@l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView$b
  implements GameGLSurfaceView.n
{
  private static long fME;
  public static final DynamicBackgroundGLSurfaceView.b.b fMF;
  private boolean fMA;
  public a fMB;
  public boolean fMC;
  private com.tencent.mm.dynamicbackground.model.c fMD;
  boolean fMo;
  public DynamicBackgroundNative fMq;
  private WeakReference<Context> fMr;
  private long fMs;
  public int fMt;
  public int fMu;
  View fMv;
  boolean fMw;
  boolean fMx;
  GameGLSurfaceView fMy;
  private int fMz;
  
  static
  {
    AppMethodBeat.i(103109);
    fMF = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
    fME = 500L;
    AppMethodBeat.o(103109);
  }
  
  public DynamicBackgroundGLSurfaceView$b(Context paramContext)
  {
    AppMethodBeat.i(103108);
    this.fMs = -1L;
    this.fMA = true;
    Object localObject = d.fLZ;
    this.fMD = d.abq();
    localObject = this.fMD;
    if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).abe() == true))
    {
      localObject = this.fMD;
      if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).abh())) {
        this.fMq = new DynamicBackgroundNative();
      }
    }
    for (;;)
    {
      this.fMr = new WeakReference(paramContext);
      AppMethodBeat.o(103108);
      return;
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
    }
  }
  
  private final void abu()
  {
    AppMethodBeat.i(103102);
    Object localObject1 = this.fMq;
    if (localObject1 != null) {
      ((DynamicBackgroundNative)localObject1).surfaceCreated(this.fMt, this.fMu);
    }
    localObject1 = (Context)this.fMr.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(103102);
      return;
    }
    DynamicBackgroundNative localDynamicBackgroundNative = this.fMq;
    if (localDynamicBackgroundNative != null)
    {
      Object localObject2 = new StringBuilder();
      Object localObject3 = b.fMj;
      localObject2 = b.cm((Context)localObject1) + "scene_shaderv.glsl";
      localObject3 = new StringBuilder();
      Object localObject4 = b.fMj;
      localObject3 = b.cm((Context)localObject1) + "scene_shaderf.glsl";
      localObject4 = new StringBuilder();
      Object localObject5 = b.fMj;
      localObject4 = b.cm((Context)localObject1) + "vertex_framebuffer_plane.glsl";
      localObject5 = new StringBuilder();
      Object localObject6 = b.fMj;
      localObject5 = b.cm((Context)localObject1) + "frag_framebuffer_plane.glsl";
      localObject6 = new StringBuilder();
      Object localObject7 = b.fMj;
      localObject6 = b.cm((Context)localObject1) + "texture_vertex_shader.glsl";
      localObject7 = new StringBuilder();
      Object localObject8 = b.fMj;
      localObject7 = b.cm((Context)localObject1) + "texture_fragment_shader.glsl";
      localObject8 = new StringBuilder();
      Object localObject9 = b.fMj;
      localObject8 = b.cm((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
      localObject9 = new StringBuilder();
      b localb = b.fMj;
      localDynamicBackgroundNative.setupGlslFiles((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, b.cm((Context)localObject1) + "bg_gradient_fragment_shader.glsl");
    }
    localObject1 = this.fMq;
    if (localObject1 != null) {
      ((DynamicBackgroundNative)localObject1).initView();
    }
    this.fMz = 0;
    AppMethodBeat.o(103102);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103098);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
    try
    {
      Object localObject = this.fMq;
      if (localObject != null) {
        ((DynamicBackgroundNative)localObject).nativeInit();
      }
      this.fMC = true;
      localObject = this.fMB;
      if (localObject != null)
      {
        DynamicBackgroundNative localDynamicBackgroundNative2 = this.fMq;
        if (localDynamicBackgroundNative2 != null)
        {
          localDynamicBackgroundNative2.setColor(((a)localObject).fMG, ((a)localObject).fMH, ((a)localObject).fMI, ((a)localObject).fMJ, ((a)localObject).fMK);
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
          DynamicBackgroundNative localDynamicBackgroundNative1 = this.fMq;
          if (localDynamicBackgroundNative1 != null) {
            localDynamicBackgroundNative1.nativeInit();
          }
          this.fMC = true;
          AppMethodBeat.o(103098);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.dynamicbackground.model.c localc = this.fMD;
          if (localc == null) {
            break label186;
          }
          localc.abj();
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
  
  public final void abs()
  {
    AppMethodBeat.i(103099);
    try
    {
      init();
      Object localObject1 = (Context)this.fMr.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103099);
        return;
      }
      Object localObject2 = this.fMD;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).cl((Context)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = new Point(0, 0);
      }
      this.fMt = ((Point)localObject1).x;
      this.fMu = ((Point)localObject1).y;
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.fMt), Integer.valueOf(this.fMu) });
      abu();
      localObject1 = this.fMD;
      if (localObject1 != null)
      {
        if (((com.tencent.mm.dynamicbackground.model.c)localObject1).abe() != true) {
          break label233;
        }
        localObject1 = this.fMD;
        if (localObject1 == null) {
          break label219;
        }
        if (((com.tencent.mm.dynamicbackground.model.c)localObject1).abl()) {
          break label233;
        }
        localObject1 = this.fMD;
        if (localObject1 == null) {
          break label226;
        }
        ((com.tencent.mm.dynamicbackground.model.c)localObject1).abk();
        AppMethodBeat.o(103099);
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.fMD;
      if (localc != null)
      {
        localc.abj();
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
  
  public final void abt()
  {
    AppMethodBeat.i(103100);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
    this.fMz = 0;
    AppMethodBeat.o(103100);
  }
  
  public final void abv()
  {
    AppMethodBeat.i(103103);
    for (;;)
    {
      try
      {
        localObject1 = this.fMD;
        if (localObject1 == null) {
          continue;
        }
        l = ((com.tencent.mm.dynamicbackground.model.c)localObject1).abp();
        Thread.sleep(l);
      }
      catch (Exception localException)
      {
        Object localObject1;
        long l;
        Object localObject2;
        continue;
      }
      localObject1 = this.fMD;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).abm() == true))
      {
        localObject1 = this.fMD;
        if (localObject1 != null) {
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).abn();
        }
      }
      try
      {
        localObject1 = this.fMq;
        if (localObject1 != null) {
          ((DynamicBackgroundNative)localObject1).draw();
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
        localObject2 = this.fMD;
        if (localObject2 == null) {
          continue;
        }
        ((com.tencent.mm.dynamicbackground.model.c)localObject2).abf();
        continue;
        AppMethodBeat.o(103103);
        return;
      }
      localObject1 = this.fMD;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).abm() == true))
      {
        this.fMz += 1;
        if (this.fMz >= 2)
        {
          localObject1 = this.fMD;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).abo();
          }
        }
      }
      if ((this.fMo) || (this.fMx)) {
        continue;
      }
      this.fMx = true;
      localObject1 = this.fMv;
      if (localObject1 == null) {
        continue;
      }
      ((View)localObject1).post((Runnable)new c(this));
      AppMethodBeat.o(103103);
      return;
      l = 16L;
    }
    if (this.fMo)
    {
      localObject2 = this.fMv;
      if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
      {
        localObject2 = this.fMv;
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
  
  public final void abw()
  {
    AppMethodBeat.i(103107);
    com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
    com.tencent.mm.dynamicbackground.model.c localc = this.fMD;
    if (localc != null)
    {
      localc.abi();
      AppMethodBeat.o(103107);
      return;
    }
    AppMethodBeat.o(103107);
  }
  
  public final void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103101);
    try
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((this.fMt != paramInt1) && (this.fMu != paramInt2))
      {
        init();
        this.fMt = paramInt1;
        this.fMu = paramInt2;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.fMt), Integer.valueOf(this.fMu) });
        abu();
        AppMethodBeat.o(103101);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.fMD;
      if (localc != null)
      {
        localc.abf();
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
      DynamicBackgroundNative localDynamicBackgroundNative = this.fMq;
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
    this.fMA = true;
    AppMethodBeat.o(103104);
  }
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"})
  public static final class a
  {
    public final int fMG;
    public final int fMH;
    public final int fMI;
    public final int fMJ;
    public final int fMK;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.fMG = paramInt1;
      this.fMH = paramInt2;
      this.fMI = paramInt3;
      this.fMJ = paramInt4;
      this.fMK = paramInt5;
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
        if (this.fMG != paramObject.fMG) {
          break label127;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fMH != paramObject.fMH) {
          break label132;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fMI != paramObject.fMI) {
          break label137;
        }
        i = 1;
        label76:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fMJ != paramObject.fMJ) {
          break label142;
        }
        i = 1;
        label96:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fMK != paramObject.fMK) {
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
      return (((this.fMG * 31 + this.fMH) * 31 + this.fMI) * 31 + this.fMJ) * 31 + this.fMK;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195757);
      String str = "ColorInfo(particleColor1=" + this.fMG + ", particleColor2=" + this.fMH + ", particleColor3=" + this.fMI + ", bgColor1=" + this.fMJ + ", bgColor2=" + this.fMK + ")";
      AppMethodBeat.o(195757);
      return str;
    }
  }
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(DynamicBackgroundGLSurfaceView.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(103095);
      Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.fML);
      if (localObject != null)
      {
        if ((((View)localObject).getVisibility() == 0) && (!this.fML.fMw))
        {
          localObject = DynamicBackgroundGLSurfaceView.b.b(this.fML);
          if (localObject != null) {
            ((GameGLSurfaceView)localObject).setVisibility(0);
          }
          this.fML.fMw = true;
          localObject = DynamicBackgroundGLSurfaceView.b.a(this.fML);
          if (localObject != null) {
            ((View)localObject).setAlpha(1.0F);
          }
          com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
          localObject = DynamicBackgroundGLSurfaceView.b.a(this.fML);
          if (localObject != null)
          {
            localObject = ((View)localObject).animate();
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.abx());
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                  {
                    public final void onAnimationCancel(Animator paramAnonymousAnimator)
                    {
                      this.fMM.fML.fMw = false;
                    }
                    
                    public final void onAnimationEnd(Animator paramAnonymousAnimator)
                    {
                      AppMethodBeat.i(103094);
                      paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.fMM.fML);
                      if (paramAnonymousAnimator != null) {
                        paramAnonymousAnimator.setVisibility(4);
                      }
                      this.fMM.fML.fMw = false;
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
  
  @l(fNY={1, 1, 11}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(DynamicBackgroundGLSurfaceView.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(103097);
      Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.fML);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = DynamicBackgroundGLSurfaceView.b.a(this.fML);
      if (localObject != null) {
        ((View)localObject).setAlpha(1.0F);
      }
      com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
      localObject = DynamicBackgroundGLSurfaceView.b.b(this.fML);
      if (localObject != null)
      {
        ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(103096);
            GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.fMN.fML);
            if (localGameGLSurfaceView != null) {
              localGameGLSurfaceView.onPause();
            }
            localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.fMN.fML);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */