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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRenderer", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "needPause", "", "showGradientView", "doInit", "", "onAttachedToWindow", "onDetachedFromWindow", "onResume", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "", "releaseAsyn", "l", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$ReleaseListener;", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceDestroyed", "Companion", "GLRenderer", "ReleaseListener", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class DynamicBackgroundGLSurfaceView
  extends GameGLSurfaceView
{
  public static final DynamicBackgroundGLSurfaceView.a mbI;
  private b mbF;
  private boolean mbG;
  private boolean mbH;
  
  static
  {
    AppMethodBeat.i(103118);
    mbI = new DynamicBackgroundGLSurfaceView.a((byte)0);
    AppMethodBeat.o(103118);
  }
  
  public DynamicBackgroundGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103117);
    setEGLContextClientVersion(2);
    aTM();
    setPreserveEGLContextOnPause(true);
    this.mbF = new b(paramContext);
    setRenderer((GameGLSurfaceView.o)this.mbF);
    aTL();
    getHolder().setFormat(-3);
    paramContext = this.mbF;
    if (paramContext != null)
    {
      paramAttributeSet = (GameGLSurfaceView)this;
      s.t(paramAttributeSet, "surfaceView");
      paramContext.mbR = paramAttributeSet;
      AppMethodBeat.o(103117);
      return;
    }
    AppMethodBeat.o(103117);
  }
  
  public final void j(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(233173);
    Object localObject = this.mbF;
    if (localObject != null)
    {
      ((b)localObject).mbU = new DynamicBackgroundGLSurfaceView.b.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      if (((b)localObject).mbV)
      {
        DynamicBackgroundNative localDynamicBackgroundNative = ((b)localObject).mbJ;
        if (localDynamicBackgroundNative != null)
        {
          DynamicBackgroundGLSurfaceView.b.a locala = ((b)localObject).mbU;
          if (locala == null) {
            s.klw();
          }
          paramInt1 = locala.mbZ;
          locala = ((b)localObject).mbU;
          if (locala == null) {
            s.klw();
          }
          paramInt2 = locala.mca;
          locala = ((b)localObject).mbU;
          if (locala == null) {
            s.klw();
          }
          paramInt3 = locala.mcb;
          locala = ((b)localObject).mbU;
          if (locala == null) {
            s.klw();
          }
          paramInt4 = locala.mcd;
          localObject = ((b)localObject).mbU;
          if (localObject == null) {
            s.klw();
          }
          localDynamicBackgroundNative.j(paramInt1, paramInt2, paramInt3, paramInt4, ((DynamicBackgroundGLSurfaceView.b.a)localObject).mce);
          AppMethodBeat.o(233173);
          return;
        }
      }
      AppMethodBeat.o(233173);
      return;
    }
    AppMethodBeat.o(233173);
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
    this.mbG = false;
    AppMethodBeat.o(103115);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(103114);
    s.t(paramView, "changedView");
    super.onVisibilityChanged(paramView, paramInt);
    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onVisibilityChanged: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (this.mbG))
    {
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo needPause", new Object[0]);
      this.mbG = false;
    }
    AppMethodBeat.o(103114);
  }
  
  public final void setGradientBackgroundView(View paramView)
  {
    AppMethodBeat.i(103116);
    s.t(paramView, "gradientColorBackgroundView");
    b localb = this.mbF;
    if (localb != null)
    {
      s.t(paramView, "gradientColorBackgroundView");
      localb.mbO = paramView;
      AppMethodBeat.o(103116);
      return;
    }
    AppMethodBeat.o(103116);
  }
  
  public final void setShowGradientView(boolean paramBoolean)
  {
    this.mbH = paramBoolean;
    b localb = this.mbF;
    if (localb != null)
    {
      localb.mbH = paramBoolean;
      if (!localb.mbH) {
        localb.mbQ = false;
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
    paramSurfaceHolder = this.mbF;
    if (paramSurfaceHolder != null)
    {
      paramSurfaceHolder.mbP = false;
      AppMethodBeat.o(103111);
      return;
    }
    AppMethodBeat.o(103111);
  }
  
  @Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer;", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView$Renderer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "colorInfo", "Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "drawCount", "", "hasPostAlphaAnimation", "", "isAlphaAnimating", "()Z", "setAlphaAnimating", "(Z)V", "mDynamicBgService", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "mGradientBgView", "Landroid/view/View;", "mLastDraw", "", "mNativeRenderer", "Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "nativeRenderInitialized", "needCheckBlack", "showGradientView", "surfaceView", "Lcom/tencent/mm/dynamicbackground/view/GameGLSurfaceView;", "viewHeight", "viewWidth", "doInit", "", "getSleepTime", "init", "initNativeView", "onDestroy", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "isPaused", "onEGLCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "onEGLSurfaceChanged", "onError", "e", "", "onPause", "onResume", "onSurfaceSizeChanged", "width", "height", "preDestroy", "release", "reset", "setColor", "particleColor1", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setGradientBackgroundView", "gradientColorBackgroundView", "setShowGradientView", "show", "setSurfaceView", "ColorInfo", "Companion", "dynamicbg_release"}, k=1, mv={1, 1, 11})
  public static final class b
    implements GameGLSurfaceView.o
  {
    private static long mbX;
    public static final DynamicBackgroundGLSurfaceView.b.b mbY;
    boolean mbH;
    DynamicBackgroundNative mbJ;
    private WeakReference<Context> mbK;
    private long mbL;
    int mbM;
    int mbN;
    View mbO;
    boolean mbP;
    boolean mbQ;
    GameGLSurfaceView mbR;
    private int mbS;
    private boolean mbT;
    a mbU;
    boolean mbV;
    private com.tencent.mm.dynamicbackground.model.c mbW;
    
    static
    {
      AppMethodBeat.i(103109);
      mbY = new DynamicBackgroundGLSurfaceView.b.b((byte)0);
      mbX = 500L;
      AppMethodBeat.o(103109);
    }
    
    public b(Context paramContext)
    {
      AppMethodBeat.i(103108);
      this.mbL = -1L;
      this.mbT = true;
      Object localObject = d.mbs;
      this.mbW = d.aTA();
      localObject = this.mbW;
      if ((localObject != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject).aTo() == true))
      {
        localObject = this.mbW;
        if ((localObject != null) && (!((com.tencent.mm.dynamicbackground.model.c)localObject).aTr())) {
          this.mbJ = new DynamicBackgroundNative();
        }
      }
      for (;;)
      {
        this.mbK = new WeakReference(paramContext);
        AppMethodBeat.o(103108);
        return;
        com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo AppBrandDesktopConfig not enableNativeDynamicBackground", new Object[0]);
      }
    }
    
    private void aTE()
    {
      AppMethodBeat.i(103102);
      Object localObject1 = this.mbJ;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).dE(this.mbM, this.mbN);
      }
      localObject1 = (Context)this.mbK.get();
      if (localObject1 == null)
      {
        AppMethodBeat.o(103102);
        return;
      }
      Object localObject2 = new StringBuilder();
      Object localObject3 = b.mbC;
      localObject2 = b.dq((Context)localObject1) + "scene_shaderv.glsl";
      localObject3 = new StringBuilder();
      Object localObject4 = b.mbC;
      localObject3 = b.dq((Context)localObject1) + "scene_shaderf.glsl";
      localObject4 = new StringBuilder();
      Object localObject5 = b.mbC;
      localObject4 = b.dq((Context)localObject1) + "vertex_framebuffer_plane.glsl";
      localObject5 = new StringBuilder();
      Object localObject6 = b.mbC;
      localObject5 = b.dq((Context)localObject1) + "frag_framebuffer_plane.glsl";
      localObject6 = new StringBuilder();
      Object localObject7 = b.mbC;
      localObject6 = b.dq((Context)localObject1) + "texture_vertex_shader.glsl";
      localObject7 = new StringBuilder();
      Object localObject8 = b.mbC;
      localObject7 = b.dq((Context)localObject1) + "texture_fragment_shader.glsl";
      localObject8 = new StringBuilder();
      Object localObject9 = b.mbC;
      localObject8 = b.dq((Context)localObject1) + "bg_gradient_vertex_shader.glsl";
      localObject9 = new StringBuilder();
      b localb = b.mbC;
      localObject1 = b.dq((Context)localObject1) + "bg_gradient_fragment_shader.glsl";
      localObject9 = this.mbJ;
      if (localObject9 != null) {
        ((DynamicBackgroundNative)localObject9).a((String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject1);
      }
      localObject1 = this.mbJ;
      if (localObject1 != null) {
        ((DynamicBackgroundNative)localObject1).initView();
      }
      this.mbS = 0;
      AppMethodBeat.o(103102);
    }
    
    private final void init()
    {
      AppMethodBeat.i(103098);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender init", new Object[0]);
      try
      {
        Object localObject1 = this.mbJ;
        if ((localObject1 != null) && (((DynamicBackgroundNative)localObject1).mbm <= 0L))
        {
          ((DynamicBackgroundNative)localObject1).mbm = ((DynamicBackgroundNative)localObject1).nativeInit();
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBackgroundNative", "create DynamicBackgroundNative inst: " + ((DynamicBackgroundNative)localObject1).mbm, new Object[0]);
        }
        this.mbV = true;
        localObject1 = this.mbU;
        if (localObject1 != null)
        {
          localObject4 = this.mbJ;
          if (localObject4 != null)
          {
            ((DynamicBackgroundNative)localObject4).j(((a)localObject1).mbZ, ((a)localObject1).mca, ((a)localObject1).mcb, ((a)localObject1).mcd, ((a)localObject1).mce);
            AppMethodBeat.o(103098);
            return;
          }
          AppMethodBeat.o(103098);
          return;
        }
      }
      finally
      {
        Object localObject4;
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeInit exception", new Object[0]);
        if ((localThrowable instanceof UnsatisfiedLinkError))
        {
          com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo nativeInit called failed, try to load so once more", new Object[0]);
          try
          {
            Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG("dynamicBg");
            localObject4 = new Object();
            com.tencent.mm.hellhoundlib.a.a.b(localObject4, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
            System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject4, "com/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer", "init", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
            localObject2 = this.mbJ;
            if (localObject2 != null) {
              ((DynamicBackgroundNative)localObject2).nativeInit();
            }
            this.mbV = true;
            AppMethodBeat.o(103098);
            return;
          }
          finally
          {
            com.tencent.mm.dynamicbackground.model.c localc = this.mbW;
            if (localc == null) {
              break label305;
            }
            localc.aTt();
            AppMethodBeat.o(103098);
            return;
          }
          AppMethodBeat.o(103098);
          return;
        }
        label305:
        AppMethodBeat.o(103098);
      }
    }
    
    public final void aTC()
    {
      AppMethodBeat.i(103099);
      try
      {
        init();
        Object localObject1 = (Context)this.mbK.get();
        if (localObject1 == null)
        {
          AppMethodBeat.o(103099);
          return;
        }
        Object localObject2 = this.mbW;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.dynamicbackground.model.c)localObject2).bf((Context)localObject1);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = new Point(0, 0);
        }
        this.mbM = ((Point)localObject1).x;
        this.mbN = ((Point)localObject1).y;
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.mbM), Integer.valueOf(this.mbN) });
        aTE();
        localObject1 = this.mbW;
        if (localObject1 != null)
        {
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aTo() != true) {
            break label233;
          }
          localObject1 = this.mbW;
          if (localObject1 == null) {
            break label219;
          }
          if (((com.tencent.mm.dynamicbackground.model.c)localObject1).aTv()) {
            break label233;
          }
          localObject1 = this.mbW;
          if (localObject1 == null) {
            break label226;
          }
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).aTu();
          AppMethodBeat.o(103099);
        }
      }
      finally
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onEGLCreated exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.mbW;
        if (localc != null)
        {
          localc.aTt();
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
    
    public final void aTD()
    {
      AppMethodBeat.i(103100);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onEGLSurfaceChanged and do nothing", new Object[0]);
      this.mbS = 0;
      AppMethodBeat.o(103100);
    }
    
    public final long aTF()
    {
      AppMethodBeat.i(233216);
      com.tencent.mm.dynamicbackground.model.c localc = this.mbW;
      if (localc != null)
      {
        long l = localc.aTz();
        AppMethodBeat.o(233216);
        return l;
      }
      AppMethodBeat.o(233216);
      return 16L;
    }
    
    public final void aTG()
    {
      AppMethodBeat.i(103103);
      Object localObject1 = this.mbW;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aTw() == true))
      {
        localObject1 = this.mbW;
        if (localObject1 != null) {
          ((com.tencent.mm.dynamicbackground.model.c)localObject1).aTx();
        }
      }
      try
      {
        localObject1 = this.mbJ;
        if ((localObject1 != null) && (((DynamicBackgroundNative)localObject1).mbm > 0L)) {
          ((DynamicBackgroundNative)localObject1).draw(((DynamicBackgroundNative)localObject1).mbm);
        }
      }
      finally
      {
        for (;;)
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onDraw exception", new Object[0]);
          localObject2 = this.mbW;
          if (localObject2 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject2).aTp();
          }
        }
        AppMethodBeat.o(103103);
        return;
      }
      localObject1 = this.mbW;
      if ((localObject1 != null) && (((com.tencent.mm.dynamicbackground.model.c)localObject1).aTw() == true))
      {
        this.mbS += 1;
        if (this.mbS >= 2)
        {
          localObject1 = this.mbW;
          if (localObject1 != null) {
            ((com.tencent.mm.dynamicbackground.model.c)localObject1).aTy();
          }
        }
      }
      if ((!this.mbH) && (!this.mbQ))
      {
        this.mbQ = true;
        localObject1 = this.mbO;
        if (localObject1 != null)
        {
          ((View)localObject1).post((Runnable)new c(this));
          AppMethodBeat.o(103103);
          return;
        }
      }
      Object localObject2;
      if (this.mbH)
      {
        localObject2 = this.mbO;
        if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0))
        {
          localObject2 = this.mbO;
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
    
    public final void aTH()
    {
      AppMethodBeat.i(233223);
      com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "preDestroy", new Object[0]);
      DynamicBackgroundNative localDynamicBackgroundNative = this.mbJ;
      if (localDynamicBackgroundNative != null)
      {
        if (localDynamicBackgroundNative.mbn <= 0L)
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBackgroundNative", "preRelease: " + localDynamicBackgroundNative.mbm, new Object[0]);
          localDynamicBackgroundNative.mbn = localDynamicBackgroundNative.mbm;
          localDynamicBackgroundNative.mbm = -1L;
        }
        AppMethodBeat.o(233223);
        return;
      }
      AppMethodBeat.o(233223);
    }
    
    public final void aTI()
    {
      AppMethodBeat.i(103107);
      com.tencent.mm.dynamicbackground.a.c.e("MicroMsg.DynamicBgSurfaceView", "alvinluo GLSurfaceView onError", new Object[0]);
      com.tencent.mm.dynamicbackground.model.c localc = this.mbW;
      if (localc != null)
      {
        localc.aTs();
        AppMethodBeat.o(103107);
        return;
      }
      AppMethodBeat.o(103107);
    }
    
    public final void dF(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(103101);
      try
      {
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged width: %d, height: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (((this.mbM != paramInt1) && (this.mbN == paramInt2)) || ((this.mbN != paramInt2) && (this.mbM != paramInt1)))
        {
          init();
          this.mbM = paramInt1;
          this.mbN = paramInt2;
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo onSurfaceSizeChanged reCreated width: %d, height: %d", new Object[] { Integer.valueOf(this.mbM), Integer.valueOf(this.mbN) });
          aTE();
          AppMethodBeat.o(103101);
          return;
        }
      }
      finally
      {
        com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo onSurfaceSizeChanged exception", new Object[0]);
        com.tencent.mm.dynamicbackground.model.c localc = this.mbW;
        if (localc != null)
        {
          localc.aTp();
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
        DynamicBackgroundNative localDynamicBackgroundNative = this.mbJ;
        if (localDynamicBackgroundNative != null)
        {
          localDynamicBackgroundNative.nativeRelease();
          AppMethodBeat.o(103105);
          return;
        }
        AppMethodBeat.o(103105);
        return;
      }
      finally
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
      this.mbT = true;
      AppMethodBeat.o(103104);
    }
    
    @Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/view/DynamicBackgroundGLSurfaceView$GLRenderer$ColorInfo;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "dynamicbg_release"}, k=1, mv={1, 1, 11})
    static final class a
    {
      final int mbZ;
      final int mca;
      final int mcb;
      final int mcd;
      final int mce;
      
      public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
      {
        this.mbZ = paramInt1;
        this.mca = paramInt2;
        this.mcb = paramInt3;
        this.mcd = paramInt4;
        this.mce = paramInt5;
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
          if (this.mbZ != paramObject.mbZ) {
            break label127;
          }
          i = 1;
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.mca != paramObject.mca) {
            break label132;
          }
          i = 1;
          label56:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.mcb != paramObject.mcb) {
            break label137;
          }
          i = 1;
          label76:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.mcd != paramObject.mcd) {
            break label142;
          }
          i = 1;
          label96:
          bool1 = bool2;
          if (i == 0) {
            break label125;
          }
          if (this.mce != paramObject.mce) {
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
        return (((this.mbZ * 31 + this.mca) * 31 + this.mcb) * 31 + this.mcd) * 31 + this.mce;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(233209);
        String str = "ColorInfo(particleColor1=" + this.mbZ + ", particleColor2=" + this.mca + ", particleColor3=" + this.mcb + ", bgColor1=" + this.mcd + ", bgColor2=" + this.mce + ")";
        AppMethodBeat.o(233209);
        return str;
      }
    }
    
    @Metadata(bv={1, 0, 2}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 11})
    static final class c
      implements Runnable
    {
      c(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103095);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.mcf);
        if (localObject != null)
        {
          if ((((View)localObject).getVisibility() == 0) && (!this.mcf.mbP))
          {
            localObject = DynamicBackgroundGLSurfaceView.b.b(this.mcf);
            if (localObject != null) {
              ((GameGLSurfaceView)localObject).setVisibility(0);
            }
            this.mcf.mbP = true;
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.mcf);
            if (localObject != null) {
              ((View)localObject).setAlpha(1.0F);
            }
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo GradientColorBackgroundView do alpha animation", new Object[0]);
            localObject = DynamicBackgroundGLSurfaceView.b.a(this.mcf);
            if (localObject != null)
            {
              localObject = ((View)localObject).animate();
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setDuration(DynamicBackgroundGLSurfaceView.b.aTJ());
                  if (localObject != null)
                  {
                    localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
                    {
                      public final void onAnimationCancel(Animator paramAnonymousAnimator)
                      {
                        this.mcg.mcf.mbP = false;
                      }
                      
                      public final void onAnimationEnd(Animator paramAnonymousAnimator)
                      {
                        AppMethodBeat.i(103094);
                        paramAnonymousAnimator = DynamicBackgroundGLSurfaceView.b.a(this.mcg.mcf);
                        if (paramAnonymousAnimator != null) {
                          paramAnonymousAnimator.setVisibility(4);
                        }
                        this.mcg.mcf.mbP = false;
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
    
    @Metadata(bv={1, 0, 2}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 11})
    static final class d
      implements Runnable
    {
      d(DynamicBackgroundGLSurfaceView.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(103097);
        Object localObject = DynamicBackgroundGLSurfaceView.b.a(this.mcf);
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = DynamicBackgroundGLSurfaceView.b.a(this.mcf);
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
        com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo showGradientView", new Object[0]);
        localObject = DynamicBackgroundGLSurfaceView.b.b(this.mcf);
        if (localObject != null)
        {
          ((GameGLSurfaceView)localObject).postDelayed((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103096);
              GameGLSurfaceView localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.mch.mcf);
              if (localGameGLSurfaceView != null) {
                localGameGLSurfaceView.onPause();
              }
              localGameGLSurfaceView = DynamicBackgroundGLSurfaceView.b.b(this.mch.mcf);
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
  
  @Metadata(bv={1, 0, 2}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 11})
  public static final class d
    implements Runnable
  {
    public d(DynamicBackgroundGLSurfaceView paramDynamicBackgroundGLSurfaceView, DynamicBackgroundGLSurfaceView.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(233199);
      DynamicBackgroundGLSurfaceView.b localb = DynamicBackgroundGLSurfaceView.a(this.mci);
      if (localb != null) {
        try
        {
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
          DynamicBackgroundNative localDynamicBackgroundNative = localb.mbJ;
          if (localDynamicBackgroundNative != null) {
            localDynamicBackgroundNative.nativeRelease();
          }
          localb.mbO = null;
          com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
          localb.mbM = 0;
          localb.mbN = 0;
          localb.mbV = false;
          localb.mbH = false;
          localb.mbQ = false;
          localb.mbP = false;
          AppMethodBeat.o(233199);
          return;
        }
        finally
        {
          com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", localThrowable, "alvinluo nativeRelease exception", new Object[0]);
          AppMethodBeat.o(233199);
          return;
        }
      }
      AppMethodBeat.o(233199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */