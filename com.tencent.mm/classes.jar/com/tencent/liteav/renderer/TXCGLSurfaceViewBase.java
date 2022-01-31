package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class TXCGLSurfaceViewBase
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final TXCGLSurfaceViewBase.j a;
  protected boolean b;
  protected boolean c;
  protected final WeakReference<TXCGLSurfaceViewBase> d;
  protected boolean e;
  protected boolean f;
  private TXCGLSurfaceViewBase.i g;
  private GLSurfaceView.Renderer h;
  private boolean i;
  private TXCGLSurfaceViewBase.e j;
  private TXCGLSurfaceViewBase.f k;
  private TXCGLSurfaceViewBase.g l;
  private TXCGLSurfaceViewBase.k m;
  private int n;
  private int o;
  private boolean p;
  
  static
  {
    AppMethodBeat.i(67335);
    a = new TXCGLSurfaceViewBase.j(null);
    AppMethodBeat.o(67335);
  }
  
  public TXCGLSurfaceViewBase(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(67313);
    this.b = false;
    this.c = false;
    this.d = new WeakReference(this);
    a();
    AppMethodBeat.o(67313);
  }
  
  public TXCGLSurfaceViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67314);
    this.b = false;
    this.c = false;
    this.d = new WeakReference(this);
    a();
    AppMethodBeat.o(67314);
  }
  
  private void a()
  {
    AppMethodBeat.i(67316);
    getHolder().addCallback(this);
    AppMethodBeat.o(67316);
  }
  
  private void f()
  {
    AppMethodBeat.i(67332);
    if (this.g != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(67332);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(67332);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(67322);
    setEGLConfigChooser(new TXCGLSurfaceViewBase.b(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
    AppMethodBeat.o(67322);
  }
  
  protected void b() {}
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(67329);
    this.b = paramBoolean;
    if ((!this.b) && (this.c) && (this.g != null))
    {
      TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
      this.g.a(new TXCGLSurfaceViewBase.2(this));
      this.g.f();
    }
    AppMethodBeat.o(67329);
  }
  
  protected int c()
  {
    return 0;
  }
  
  public int d()
  {
    AppMethodBeat.i(67333);
    int i1 = this.g.a();
    AppMethodBeat.o(67333);
    return i1;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(67315);
    try
    {
      if (this.g != null) {
        this.g.g();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(67315);
    }
  }
  
  public int getDebugFlags()
  {
    return this.n;
  }
  
  public TXCGLSurfaceViewBase.h getEGLHelper()
  {
    AppMethodBeat.i(67334);
    TXCGLSurfaceViewBase.h localh = this.g.b();
    AppMethodBeat.o(67334);
    return localh;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.p;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(67325);
    int i1 = this.g.d();
    AppMethodBeat.o(67325);
    return i1;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(67330);
    super.onAttachedToWindow();
    if ((this.i) && (this.h != null)) {
      if (this.g == null) {
        break label84;
      }
    }
    label84:
    for (int i1 = this.g.d();; i1 = 1)
    {
      this.g = new TXCGLSurfaceViewBase.i(this.d);
      if (i1 != 1) {
        this.g.a(i1);
      }
      this.g.start();
      this.i = false;
      AppMethodBeat.o(67330);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(67331);
    if (this.g != null) {
      this.g.g();
    }
    this.i = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(67331);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setEGLConfigChooser(TXCGLSurfaceViewBase.e parame)
  {
    AppMethodBeat.i(67320);
    f();
    this.j = parame;
    AppMethodBeat.o(67320);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(67321);
    setEGLConfigChooser(new TXCGLSurfaceViewBase.m(this, paramBoolean));
    AppMethodBeat.o(67321);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(67323);
    f();
    this.o = paramInt;
    AppMethodBeat.o(67323);
  }
  
  public void setEGLContextFactory(TXCGLSurfaceViewBase.f paramf)
  {
    AppMethodBeat.i(67318);
    f();
    this.k = paramf;
    AppMethodBeat.o(67318);
  }
  
  public void setEGLWindowSurfaceFactory(TXCGLSurfaceViewBase.g paramg)
  {
    AppMethodBeat.i(67319);
    f();
    this.l = paramg;
    AppMethodBeat.o(67319);
  }
  
  public void setGLWrapper(TXCGLSurfaceViewBase.k paramk)
  {
    this.m = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(67324);
    this.g.a(paramInt);
    AppMethodBeat.o(67324);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    AppMethodBeat.i(67317);
    f();
    if (this.j == null) {
      this.j = new TXCGLSurfaceViewBase.m(this, true);
    }
    if (this.k == null) {
      this.k = new TXCGLSurfaceViewBase.c(this, null);
    }
    if (this.l == null) {
      this.l = new TXCGLSurfaceViewBase.d(null);
    }
    this.h = paramRenderer;
    this.g = new TXCGLSurfaceViewBase.i(this.d);
    this.g.start();
    TXCLog.i("TXCGLSurfaceViewBase", "setRenderer-->mGLThread.start");
    AppMethodBeat.o(67317);
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(67328);
    this.g.a(paramInt2, paramInt3);
    AppMethodBeat.o(67328);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(67326);
    this.g.e();
    setRunInBackground(false);
    AppMethodBeat.o(67326);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(67327);
    setRunInBackground(true);
    if (!this.b)
    {
      this.g.a(new TXCGLSurfaceViewBase.1(this));
      this.g.f();
    }
    AppMethodBeat.o(67327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase
 * JD-Core Version:    0.7.0.1
 */