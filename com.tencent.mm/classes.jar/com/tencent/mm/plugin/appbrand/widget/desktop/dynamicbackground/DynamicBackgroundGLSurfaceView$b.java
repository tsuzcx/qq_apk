package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import a.l;
import android.content.Context;
import android.graphics.Point;
import android.opengl.EGL14;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.af;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mGradientBgView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GradientColorBackgroundView;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundNative;", "needCheckBlack", "needCheckCrash", "showGradientView", "surfaceView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/GameGLSurfaceView;", "viewHeight", "viewWidth", "init", "", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "release", "reset", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "Companion", "plugin-appbrand-integration_release"})
public final class DynamicBackgroundGLSurfaceView$b
  implements GameGLSurfaceView.n
{
  private static long jgK;
  public static final DynamicBackgroundGLSurfaceView.b.a jgL;
  private Context context;
  private int eLv;
  GradientColorBackgroundView jdq;
  private DynamicBackgroundNative jgB;
  private long jgC;
  private int jgD;
  private int jgE;
  boolean jgF;
  boolean jgG;
  GameGLSurfaceView jgH;
  private boolean jgI;
  private boolean jgJ;
  boolean jgz;
  
  static
  {
    AppMethodBeat.i(135239);
    jgL = new DynamicBackgroundGLSurfaceView.b.a((byte)0);
    jgK = 500L;
    AppMethodBeat.o(135239);
  }
  
  public DynamicBackgroundGLSurfaceView$b(Context paramContext)
  {
    AppMethodBeat.i(135238);
    this.jgC = -1L;
    this.jgI = true;
    this.jgJ = true;
    if ((com.tencent.mm.plugin.appbrand.widget.desktop.b.aPg()) && (!d.aPZ())) {
      this.jgB = new DynamicBackgroundNative();
    }
    for (;;)
    {
      this.context = paramContext;
      AppMethodBeat.o(135238);
      return;
      ab.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground");
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(135229);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init");
    try
    {
      DynamicBackgroundNative localDynamicBackgroundNative1 = this.jgB;
      if (localDynamicBackgroundNative1 != null)
      {
        localDynamicBackgroundNative1.nativeInit();
        AppMethodBeat.o(135229);
        return;
      }
      AppMethodBeat.o(135229);
      return;
    }
    catch (Throwable localThrowable1)
    {
      ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable1, "alvinluo nativeInit exception", new Object[0]);
      if ((localThrowable1 instanceof UnsatisfiedLinkError))
      {
        ab.e("MicroMsg.DynamicBgSurfaceView", "alvinluo nativeInit called failed, try to load so once more");
        try
        {
          System.loadLibrary("dynamicBg");
          DynamicBackgroundNative localDynamicBackgroundNative2 = this.jgB;
          if (localDynamicBackgroundNative2 == null) {
            break label98;
          }
          localDynamicBackgroundNative2.nativeInit();
          AppMethodBeat.o(135229);
          return;
        }
        catch (Throwable localThrowable2)
        {
          d.aPS();
        }
      }
      else
      {
        AppMethodBeat.o(135229);
        return;
      }
    }
    label98:
    AppMethodBeat.o(135229);
  }
  
  public final void aPJ()
  {
    AppMethodBeat.i(135230);
    try
    {
      init();
      Object localObject1 = af.hQ(this.context);
      this.jgD = ((Point)localObject1).x;
      this.jgE = ((Point)localObject1).y;
      ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.jgD), Integer.valueOf(this.jgE) });
      ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo handle: %s, %s, %s", new Object[] { EGL14.eglGetCurrentContext(), EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentSurface(12377) });
      localObject1 = this.jgB;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).surfaceCreated(this.jgD, this.jgE);
      }
      localObject1 = this.jgB;
      if (localObject1 != null)
      {
        Object localObject2 = new StringBuilder();
        Object localObject3 = e.jgU;
        localObject2 = e.ds(this.context) + "scene_shaderv.glsl";
        localObject3 = new StringBuilder();
        Object localObject4 = e.jgU;
        localObject3 = e.ds(this.context) + "scene_shaderf.glsl";
        localObject4 = new StringBuilder();
        Object localObject5 = e.jgU;
        localObject4 = e.ds(this.context) + "vertex_framebuffer_plane.glsl";
        localObject5 = new StringBuilder();
        Object localObject6 = e.jgU;
        localObject5 = e.ds(this.context) + "frag_framebuffer_plane.glsl";
        localObject6 = new StringBuilder();
        Object localObject7 = e.jgU;
        localObject6 = e.ds(this.context) + "texture_vertex_shader.glsl";
        localObject7 = new StringBuilder();
        Object localObject8 = e.jgU;
        localObject7 = e.ds(this.context) + "texture_fragment_shader.glsl";
        localObject8 = new StringBuilder();
        Object localObject9 = e.jgU;
        localObject8 = e.ds(this.context) + "bg_gradient_vertex_shader.glsl";
        localObject9 = new StringBuilder();
        e locale = e.jgU;
        ((DynamicBackgroundNative)localObject1).setupGlslFiles((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, e.ds(this.context) + "bg_gradient_fragment_shader.glsl");
      }
      localObject1 = this.jgB;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).initView();
      }
      if ((com.tencent.mm.plugin.appbrand.widget.desktop.b.aPg()) && (!d.aPU()))
      {
        d.aPW();
        AppMethodBeat.o(135230);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
      d.aPS();
      AppMethodBeat.o(135230);
    }
  }
  
  public final void aPK()
  {
    AppMethodBeat.i(135231);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing");
    this.eLv = 0;
    AppMethodBeat.o(135231);
  }
  
  public final void aPL()
  {
    AppMethodBeat.i(135233);
    try
    {
      Object localObject = b.jgw;
      Thread.sleep(b.aPG());
      label17:
      if (d.aPP()) {
        d.aPX();
      }
      try
      {
        localObject = this.jgB;
        if (localObject != null) {
          ((DynamicBackgroundNative)localObject).draw();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
          com.tencent.mm.plugin.appbrand.widget.desktop.b.ff(false);
        }
        AppMethodBeat.o(135233);
        return;
      }
      if (d.aPP())
      {
        this.eLv += 1;
        if (this.eLv >= 2) {
          d.aPY();
        }
      }
      if ((!this.jgz) && (!this.jgG))
      {
        this.jgG = true;
        localObject = this.jdq;
        if (localObject != null)
        {
          ((GradientColorBackgroundView)localObject).post((Runnable)new DynamicBackgroundGLSurfaceView.b.b(this));
          AppMethodBeat.o(135233);
          return;
        }
      }
      if (this.jgz)
      {
        GradientColorBackgroundView localGradientColorBackgroundView = this.jdq;
        if ((localGradientColorBackgroundView == null) || (localGradientColorBackgroundView.getVisibility() != 0))
        {
          localGradientColorBackgroundView = this.jdq;
          if (localGradientColorBackgroundView != null)
          {
            localGradientColorBackgroundView.post((Runnable)new DynamicBackgroundGLSurfaceView.b.c(this));
            AppMethodBeat.o(135233);
            return;
          }
        }
      }
      AppMethodBeat.o(135233);
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public final void aPM()
  {
    AppMethodBeat.i(135237);
    ab.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError");
    d.aPT();
    AppMethodBeat.o(135237);
  }
  
  public final void dt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135232);
    try
    {
      ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((this.jgD != paramInt1) && (this.jgE != paramInt2))
      {
        init();
        this.jgD = paramInt1;
        this.jgE = paramInt2;
        ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.jgD), Integer.valueOf(this.jgE) });
        DynamicBackgroundNative localDynamicBackgroundNative = this.jgB;
        if (localDynamicBackgroundNative != null) {
          localDynamicBackgroundNative.surfaceCreated(this.jgD, this.jgE);
        }
        localDynamicBackgroundNative = this.jgB;
        if (localDynamicBackgroundNative != null)
        {
          Object localObject1 = new StringBuilder();
          Object localObject2 = e.jgU;
          localObject1 = e.ds(this.context) + "scene_shaderv.glsl";
          localObject2 = new StringBuilder();
          Object localObject3 = e.jgU;
          localObject2 = e.ds(this.context) + "scene_shaderf.glsl";
          localObject3 = new StringBuilder();
          Object localObject4 = e.jgU;
          localObject3 = e.ds(this.context) + "vertex_framebuffer_plane.glsl";
          localObject4 = new StringBuilder();
          Object localObject5 = e.jgU;
          localObject4 = e.ds(this.context) + "frag_framebuffer_plane.glsl";
          localObject5 = new StringBuilder();
          Object localObject6 = e.jgU;
          localObject5 = e.ds(this.context) + "texture_vertex_shader.glsl";
          localObject6 = new StringBuilder();
          Object localObject7 = e.jgU;
          localObject6 = e.ds(this.context) + "texture_fragment_shader.glsl";
          localObject7 = new StringBuilder();
          Object localObject8 = e.jgU;
          localObject7 = e.ds(this.context) + "bg_gradient_vertex_shader.glsl";
          localObject8 = new StringBuilder();
          e locale = e.jgU;
          localDynamicBackgroundNative.setupGlslFiles((String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, e.ds(this.context) + "bg_gradient_fragment_shader.glsl");
        }
        localDynamicBackgroundNative = this.jgB;
        if (localDynamicBackgroundNative != null) {
          localDynamicBackgroundNative.initView();
        }
        this.eLv = 0;
        AppMethodBeat.o(135232);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
      com.tencent.mm.plugin.appbrand.widget.desktop.b.ff(false);
      AppMethodBeat.o(135232);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135235);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onDestroy");
    try
    {
      DynamicBackgroundNative localDynamicBackgroundNative = this.jgB;
      if (localDynamicBackgroundNative != null)
      {
        localDynamicBackgroundNative.nativeRelease();
        AppMethodBeat.o(135235);
        return;
      }
      AppMethodBeat.o(135235);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeRelease exception", new Object[0]);
      AppMethodBeat.o(135235);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(135236);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onPause");
    AppMethodBeat.o(135236);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(135234);
    ab.i("MicroMsg.DynamicBgSurfaceView", "alvinluo DynamicBackgroundSurfaceView.Renderer onResume");
    this.jgJ = true;
    AppMethodBeat.o(135234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b
 * JD-Core Version:    0.7.0.1
 */