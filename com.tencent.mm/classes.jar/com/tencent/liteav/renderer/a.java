package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLContext;

public class a
  extends e
  implements SurfaceTexture.OnFrameAvailableListener
{
  private TXSVideoFrame A;
  private TXCYuvTextureRender B;
  private final Queue<Runnable> C;
  g a;
  a.a b;
  a.a c;
  private final int p;
  private final int q;
  private final int r;
  private final int s;
  private Object t;
  private b u;
  private SurfaceTexture v;
  private c w;
  private boolean x;
  private float[] y;
  private c z;
  
  public a()
  {
    AppMethodBeat.i(67153);
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = new Object();
    this.C = new LinkedList();
    this.y = new float[16];
    AppMethodBeat.o(67153);
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(67169);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(67169);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(67169);
    }
    localObject.run();
    AppMethodBeat.o(67169);
    return true;
  }
  
  private void s()
  {
    AppMethodBeat.i(146744);
    this.w = new c(true);
    this.B = new TXCYuvTextureRender();
    this.z = new c(false);
    AppMethodBeat.o(146744);
  }
  
  private boolean t()
  {
    AppMethodBeat.i(146745);
    for (;;)
    {
      EGLContext localEGLContext;
      try
      {
        boolean bool;
        Object localObject;
        if (this.x)
        {
          bool = this.x;
          this.x = false;
          localObject = null;
          GLES20.glViewport(0, 0, k(), l());
          if (this.k != 1) {
            break label393;
          }
          localEGLContext = b();
          if (!bool) {
            break label258;
          }
          if (this.v != null)
          {
            this.v.updateTexImage();
            this.v.getTransformMatrix(this.y);
          }
          if (this.a != null)
          {
            if (this.w != null) {
              this.a.a(this.w.a(), this.y);
            }
            localObject = this.c;
            if (localObject != null) {
              ((a.a)localObject).onTextureProcess(this.w.a(), m(), n());
            }
            if ((this.k == 1) && (this.w != null)) {
              a(localEGLContext, this.w.a(), this.y, true);
            }
            AppMethodBeat.o(146745);
            return true;
          }
        }
        else
        {
          if (this.A != null)
          {
            localObject = this.A;
            this.A = null;
            bool = false;
            continue;
          }
          return false;
        }
      }
      finally
      {
        AppMethodBeat.o(146745);
      }
      if (this.w != null)
      {
        this.w.a(this.v);
        continue;
        label258:
        if ((localTXSVideoFrame != null) && (this.B != null))
        {
          int i;
          if (this.b != null)
          {
            this.B.setHasFrameBuffer(this.h, this.i);
            i = this.B.drawToTexture(localTXSVideoFrame);
            this.b.onTextureProcess(i, m(), n());
          }
          for (;;)
          {
            if (this.k != 1) {
              break label391;
            }
            int j = i;
            if (i == -1)
            {
              this.B.setHasFrameBuffer(this.h, this.i);
              j = this.B.drawToTexture(localTXSVideoFrame);
            }
            a(localEGLContext, j, null, false);
            break;
            if (this.k == 0) {
              this.B.drawFrame(localTXSVideoFrame);
            }
            i = -1;
          }
          label391:
          continue;
          label393:
          localEGLContext = null;
        }
      }
    }
  }
  
  public SurfaceTexture a()
  {
    return this.v;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67160);
    super.a(paramInt1, paramInt2);
    if (this.B != null) {
      this.B.setVideoSize(paramInt1, paramInt2);
    }
    if (this.w != null) {
      this.w.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(67160);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(67156);
    GLES20.glViewport(0, 0, k(), l());
    if (this.z != null) {
      this.z.a(paramInt1, paramBoolean, paramInt4);
    }
    super.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
    if (this.u != null) {
      this.u.c();
    }
    AppMethodBeat.o(67156);
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67158);
    g();
    AppMethodBeat.o(67158);
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146743);
    try
    {
      this.A = paramTXSVideoFrame;
      super.a(paramTXSVideoFrame, paramInt1, paramInt2, paramInt3);
      if (this.u != null) {
        this.u.c();
      }
      AppMethodBeat.o(146743);
      return;
    }
    finally
    {
      AppMethodBeat.o(146743);
    }
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(67154);
    this.b = parama;
    if ((parama != null) && (this.B != null)) {
      this.B.setHasFrameBuffer(this.h, this.i);
    }
    AppMethodBeat.o(67154);
  }
  
  public void a(g paramg)
  {
    this.a = paramg;
  }
  
  public EGLContext b()
  {
    AppMethodBeat.i(67157);
    synchronized (this.t)
    {
      if (this.u != null)
      {
        localEGLContext = this.u.a();
        AppMethodBeat.o(67157);
        return localEGLContext;
      }
      EGLContext localEGLContext = null;
    }
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67159);
    h();
    AppMethodBeat.o(67159);
  }
  
  public void b(a.a parama)
  {
    AppMethodBeat.i(146742);
    this.c = parama;
    if ((parama != null) && (this.B != null)) {
      this.B.setHasFrameBuffer(this.h, this.i);
    }
    AppMethodBeat.o(146742);
  }
  
  void c()
  {
    AppMethodBeat.i(67161);
    TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender initTextureRender");
    s();
    if (this.e != null)
    {
      this.e.a(this.f, this.g);
      this.e.b(this.h, this.i);
    }
    if (this.w != null)
    {
      this.w.b();
      this.v = new SurfaceTexture(this.w.a());
      this.v.setOnFrameAvailableListener(this);
    }
    if (this.B != null) {
      this.B.createTexture();
    }
    if ((this.b != null) && (this.B != null)) {
      this.B.setHasFrameBuffer(this.h, this.i);
    }
    if (this.z != null) {
      this.z.b();
    }
    if (this.n != null) {
      this.n.onSurfaceTextureAvailable(this.v);
    }
    AppMethodBeat.o(67161);
  }
  
  void d()
  {
    AppMethodBeat.i(67163);
    try
    {
      if (this.n != null) {
        this.n.onSurfaceTextureDestroy(this.v);
      }
      label26:
      if (this.w != null)
      {
        this.w.c();
        this.w = null;
      }
      if (this.B != null)
      {
        this.B.onSurfaceDestroy();
        this.B = null;
      }
      if (this.z != null)
      {
        this.z.c();
        this.z = null;
      }
      this.v = null;
      AppMethodBeat.o(67163);
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  boolean e()
  {
    AppMethodBeat.i(67164);
    while (a(this.C)) {}
    boolean bool = t();
    AppMethodBeat.o(67164);
    return bool;
  }
  
  SurfaceTexture f()
  {
    AppMethodBeat.i(67165);
    if (this.d != null)
    {
      SurfaceTexture localSurfaceTexture = this.d.getSurfaceTexture();
      AppMethodBeat.o(67165);
      return localSurfaceTexture;
    }
    AppMethodBeat.o(67165);
    return null;
  }
  
  public void finalize()
  {
    AppMethodBeat.i(67170);
    super.finalize();
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
    try
    {
      h();
      AppMethodBeat.o(67170);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67170);
    }
  }
  
  protected void g()
  {
    AppMethodBeat.i(67166);
    synchronized (this.t)
    {
      if (this.u == null)
      {
        this.u = new b(new WeakReference(this));
        this.u.start();
        this.u.c();
        TXCLog.w("TXCVideoRender", "play:vrender: start render thread id " + getID() + ", " + this);
        AppMethodBeat.o(67166);
        return;
      }
      TXCLog.w("TXCVideoRender", "play:vrender: render thread is running " + getID() + ", " + this);
    }
  }
  
  protected void h()
  {
    AppMethodBeat.i(67167);
    synchronized (this.t)
    {
      if (this.u != null)
      {
        this.u.b();
        this.u.c();
        this.u = null;
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread id" + getID() + ", " + this);
      }
      AppMethodBeat.o(67167);
      return;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.x = true;
      return;
    }
    finally {}
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.renderer.a
 * JD-Core Version:    0.7.0.1
 */