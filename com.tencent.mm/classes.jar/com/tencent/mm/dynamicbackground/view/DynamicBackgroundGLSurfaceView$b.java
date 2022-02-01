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

@l(fvt={1, 1, 11}, fvu={""}, fvv={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"})
public final class DynamicBackgroundGLSurfaceView$b
  implements GameGLSurfaceView.n
{
  private static long fIY;
  public static final DynamicBackgroundGLSurfaceView.b.b fIZ;
  boolean fII;
  public DynamicBackgroundNative fIK;
  private WeakReference<Context> fIL;
  private long fIM;
  public int fIN;
  public int fIO;
  View fIP;
  boolean fIQ;
  boolean fIR;
  GameGLSurfaceView fIS;
  private int fIT;
  private boolean fIU;
  public a fIV;
  public boolean fIW;
  private com.tencent.mm.dynamicbackground.model.c fIX;
  
  static
  {
    AppMethodBeat.i(103109);
    fIZ = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
    fIY = 500L;
    AppMethodBeat.o(103109);
  }
  
  public DynamicBackgroundGLSurfaceView$b(Context paramContext)
  {
    AppMethodBeat.i(103108);
    this.fIM = -1L;
    this.fIU = true;
    Object localObject = d.fIt;
    this.fIX = d.aar();
    localObject = this.fIX;
    if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).aaf() == true))
    {
      localObject = this.fIX;
      if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).aai())) {
        this.fIK = new DynamicBackgroundNative();
      }
    }
    for (;;)
    {
      this.fIL = new WeakReference(paramContext);
      AppMethodBeat.o(103108);
      return;
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
    }
  }
  
  private final void aav()
  {
    AppMethodBeat.i(103102);
    Object localObject1 = this.fIK;
    if (localObject1 != null) {
      ((DynamicBackgroundNative)localObject1).surfaceCreated(this.fIN, this.fIO);
    }
    localObject1 = (Context)this.fIL.get();
    if (localObject1 == null)
    {
      AppMethodBeat.o(103102);
      return;
    }
    DynamicBackgroundNative localDynamicBackgroundNative = this.fIK;
    if (localDynamicBackgroundNative != null)
    {
      Object localObject2 = new StringBuilder();
      Object localObject3 = b.fID;
      localObject2 = b.cg((Context)localObject1) + "scene_shaderv.glsl";
      localObject3 = new StringBuilder();
      Object localObject4 = b.fID;
      localObject3 = b.cg((Context)localObject1) + "scene_shaderf.glsl";
      localObject4 = new StringBuilder();
      Object localObject5 = b.fID;
      localObject4 = b.cg((Context)localObject1) + "vertex_framebuffer_plane.glsl";
      localObject5 = new StringBuilder();
      Object localObject6 = b.fID;
      localObject5 = b.cg((Context)localObject1) + "frag_framebuffer_plane.glsl";
      localObject6 = new StringBuilder();
      Object localObject7 = b.fID;
      localObject6 = b.cg((Context)localObject1) + "texture_vertex_shader.glsl";
      localObject7 = new StringBuilder();
      Object localObject8 = b.fID;
      localObject7 = b.cg((Context)localObject1) + "texture_fragment_shader.glsl";
      localObject8 = new StringBuilder();
      Object localObject9 = b.fID;
      localObject8 = b.cg((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
      localObject9 = new StringBuilder();
      b localb = b.fID;
      localDynamicBackgroundNative.setupGlslFiles((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, b.cg((Context)localObject1) + "bg_gradient_fragment_shader.glsl");
    }
    localObject1 = this.fIK;
    if (localObject1 != null) {
      ((DynamicBackgroundNative)localObject1).initView();
    }
    this.fIT = 0;
    AppMethodBeat.o(103102);
  }
  
  private final void init()
  {
    AppMethodBeat.i(103098);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
    try
    {
      Object localObject = this.fIK;
      if (localObject != null) {
        ((DynamicBackgroundNative)localObject).nativeInit();
      }
      this.fIW = true;
      localObject = this.fIV;
      if (localObject != null)
      {
        DynamicBackgroundNative localDynamicBackgroundNative2 = this.fIK;
        if (localDynamicBackgroundNative2 != null)
        {
          localDynamicBackgroundNative2.setColor(((a)localObject).fJa, ((a)localObject).fJb, ((a)localObject).fJc, ((a)localObject).fJd, ((a)localObject).fJe);
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
          DynamicBackgroundNative localDynamicBackgroundNative1 = this.fIK;
          if (localDynamicBackgroundNative1 != null) {
            localDynamicBackgroundNative1.nativeInit();
          }
          this.fIW = true;
          AppMethodBeat.o(103098);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.dynamicbackground.model.c localc = this.fIX;
          if (localc == null) {
            break label186;
          }
          localc.aak();
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
  
  public final void aat()
  {
    AppMethodBeat.i(103099);
    try
    {
      init();
      Object localObject1 = (Context)this.fIL.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103099);
        return;
      }
      Object localObject2 = this.fIX;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).cf((Context)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = new Point(0, 0);
      }
      this.fIN = ((Point)localObject1).x;
      this.fIO = ((Point)localObject1).y;
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.fIN), Integer.valueOf(this.fIO) });
      aav();
      localObject1 = this.fIX;
      if (localObject1 != null)
      {
        if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aaf() != true) {
          break label233;
        }
        localObject1 = this.fIX;
        if (localObject1 == null) {
          break label219;
        }
        if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aam()) {
          break label233;
        }
        localObject1 = this.fIX;
        if (localObject1 == null) {
          break label226;
        }
        ((com.tencent.mm.dynamicbackground.model.c)localObject1).aal();
        AppMethodBeat.o(103099);
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.fIX;
      if (localc != null)
      {
        localc.aak();
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
  
  public final void aau()
  {
    AppMethodBeat.i(103100);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
    this.fIT = 0;
    AppMethodBeat.o(103100);
  }
  
  public final void aaw()
  {
    AppMethodBeat.i(103103);
    for (;;)
    {
      try
      {
        localObject1 = this.fIX;
        if (localObject1 == null) {
          continue;
        }
        l = ((com.tencent.mm.dynamicbackground.model.c)localObject1).aaq();
        Thread.sleep(l);
      }
      catch (Exception localException)
      {
        Object localObject1;
        long l;
        Object localObject2;
        continue;
      }
      localObject1 = this.fIX;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aan() == true))
      {
        localObject1 = this.fIX;
        if (localObject1 != null) {
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).aao();
        }
      }
      try
      {
        localObject1 = this.fIK;
        if (localObject1 != null) {
          ((DynamicBackgroundNative)localObject1).draw();
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
        localObject2 = this.fIX;
        if (localObject2 == null) {
          continue;
        }
        ((com.tencent.mm.dynamicbackground.model.c)localObject2).aag();
        continue;
        AppMethodBeat.o(103103);
        return;
      }
      localObject1 = this.fIX;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aan() == true))
      {
        this.fIT += 1;
        if (this.fIT >= 2)
        {
          localObject1 = this.fIX;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).aap();
          }
        }
      }
      if ((this.fII) || (this.fIR)) {
        continue;
      }
      this.fIR = true;
      localObject1 = this.fIP;
      if (localObject1 == null) {
        continue;
      }
      ((View)localObject1).post((Runnable)new c(this));
      AppMethodBeat.o(103103);
      return;
      l = 16L;
    }
    if (this.fII)
    {
      localObject2 = this.fIP;
      if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
      {
        localObject2 = this.fIP;
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
  
  public final void aax()
  {
    AppMethodBeat.i(103107);
    com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
    com.tencent.mm.dynamicbackground.model.c localc = this.fIX;
    if (localc != null)
    {
      localc.aaj();
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
      if ((this.fIN != paramInt1) && (this.fIO != paramInt2))
      {
        init();
        this.fIN = paramInt1;
        this.fIO = paramInt2;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.fIN), Integer.valueOf(this.fIO) });
        aav();
        AppMethodBeat.o(103101);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.fIX;
      if (localc != null)
      {
        localc.aag();
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
      DynamicBackgroundNative localDynamicBackgroundNative = this.fIK;
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
    this.fIU = true;
    AppMethodBeat.o(103104);
  }
  
  @l(fvt={1, 1, 11}, fvu={""}, fvv={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"})
  public static final class a
  {
    public final int fJa;
    public final int fJb;
    public final int fJc;
    public final int fJd;
    public final int fJe;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.fJa = paramInt1;
      this.fJb = paramInt2;
      this.fJc = paramInt3;
      this.fJd = paramInt4;
      this.fJe = paramInt5;
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
        if (this.fJa != paramObject.fJa) {
          break label127;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fJb != paramObject.fJb) {
          break label132;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fJc != paramObject.fJc) {
          break label137;
        }
        i = 1;
        label76:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fJd != paramObject.fJd) {
          break label142;
        }
        i = 1;
        label96:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.fJe != paramObject.fJe) {
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
      return (((this.fJa * 31 + this.fJb) * 31 + this.fJc) * 31 + this.fJd) * 31 + this.fJe;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189978);
      String str = "ColorInfo(particleColor1=" + this.fJa + ", particleColor2=" + this.fJb + ", particleColor3=" + this.fJc + ", bgColor1=" + this.fJd + ", bgColor2=" + this.fJe + ")";
      AppMethodBeat.o(189978);
      return str;
    }
  }
  
  @l(fvt={1, 1, 11}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(DynamicBackgroundGLSurfaceView.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(103095);
      Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.fJf);
      if (localObject != null)
      {
        if ((((View)localObject).getVisibility() == 0) && (!this.fJf.fIQ))
        {
          localObject = DynamicBackgroundGLSurfaceView.b.b(this.fJf);
          if (localObject != null) {
            ((GameGLSurfaceView)localObject).setVisibility(0);
          }
          this.fJf.fIQ = true;
          localObject = DynamicBackgroundGLSurfaceView.b.a(this.fJf);
          if (localObject != null) {
            ((View)localObject).setAlpha(1.0F);
          }
          com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
          localObject = DynamicBackgroundGLSurfaceView.b.a(this.fJf);
          if (localObject != null)
          {
            localObject = ((View)localObject).animate();
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.aay());
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                  {
                    public final void onAnimationCancel(Animator paramAnonymousAnimator)
                    {
                      this.fJg.fJf.fIQ = false;
                    }
                    
                    public final void onAnimationEnd(Animator paramAnonymousAnimator)
                    {
                      AppMethodBeat.i(103094);
                      paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.fJg.fJf);
                      if (paramAnonymousAnimator != null) {
                        paramAnonymousAnimator.setVisibility(4);
                      }
                      this.fJg.fJf.fIQ = false;
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
  
  @l(fvt={1, 1, 11}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(DynamicBackgroundGLSurfaceView.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(103097);
      Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.fJf);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = DynamicBackgroundGLSurfaceView.b.a(this.fJf);
      if (localObject != null) {
        ((View)localObject).setAlpha(1.0F);
      }
      com.tencent.mm.dynamicbackground.a.c.d("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
      localObject = DynamicBackgroundGLSurfaceView.b.b(this.fJf);
      if (localObject != null)
      {
        ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(103096);
            GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.fJh.fJf);
            if (localGameGLSurfaceView != null) {
              localGameGLSurfaceView.onPause();
            }
            localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.fJh.fJf);
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