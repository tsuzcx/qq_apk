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
  private c A;
  private TXSVideoFrame B;
  private TXCYuvTextureRender C;
  private Object D;
  private Object E;
  private final Queue<Runnable> F;
  g a;
  a b;
  a c;
  private final int q;
  private final int r;
  private final int s;
  private final int t;
  private Object u;
  private b v;
  private SurfaceTexture w;
  private c x;
  private boolean y;
  private float[] z;
  
  public a()
  {
    AppMethodBeat.i(16847);
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = new Object();
    this.D = null;
    this.E = new Object();
    this.F = new LinkedList();
    this.z = new float[16];
    AppMethodBeat.o(16847);
  }
  
  private boolean a(Queue<Runnable> paramQueue)
  {
    AppMethodBeat.i(16864);
    try
    {
      if (paramQueue.isEmpty()) {
        return false;
      }
      Runnable localRunnable = (Runnable)paramQueue.poll();
      if (localRunnable == null)
      {
        AppMethodBeat.o(16864);
        return false;
      }
    }
    finally
    {
      AppMethodBeat.o(16864);
    }
    localObject.run();
    AppMethodBeat.o(16864);
    return true;
  }
  
  private void p()
  {
    AppMethodBeat.i(16857);
    this.x = new c(true);
    this.C = new TXCYuvTextureRender();
    this.A = new c(false);
    AppMethodBeat.o(16857);
  }
  
  private boolean q()
  {
    AppMethodBeat.i(16863);
    for (;;)
    {
      EGLContext localEGLContext;
      try
      {
        boolean bool;
        Object localObject;
        if (this.y)
        {
          bool = this.y;
          this.y = false;
          localObject = null;
          GLES20.glViewport(0, 0, h(), i());
          if (this.l != 1) {
            break label405;
          }
          localEGLContext = b();
          if (!bool) {
            break label266;
          }
          if (this.w != null)
          {
            this.w.updateTexImage();
            this.w.getTransformMatrix(this.z);
          }
          if (this.a != null)
          {
            if (this.x != null) {
              this.a.a(this.x.a(), this.z);
            }
            localObject = this.c;
            if (localObject != null) {
              ((a)localObject).onTextureProcess(this.x.a(), j(), k(), this.k);
            }
            if ((this.l == 1) && (this.x != null)) {
              a(localEGLContext, this.x.a(), this.z, true);
            }
            AppMethodBeat.o(16863);
            return true;
          }
        }
        else
        {
          if (this.B != null)
          {
            localObject = this.B;
            this.B = null;
            bool = false;
            continue;
          }
          return false;
        }
      }
      finally
      {
        AppMethodBeat.o(16863);
      }
      if (this.x != null)
      {
        this.x.a(this.w);
        continue;
        label266:
        if ((localTXSVideoFrame != null) && (this.C != null))
        {
          int i;
          if (this.b != null)
          {
            this.C.setHasFrameBuffer(this.h, this.i);
            i = this.C.drawToTexture(localTXSVideoFrame);
            this.b.onTextureProcess(i, j(), k(), this.k);
          }
          for (;;)
          {
            if (this.l != 1) {
              break label403;
            }
            int j = i;
            if (i == -1)
            {
              this.C.setHasFrameBuffer(this.h, this.i);
              j = this.C.drawToTexture(localTXSVideoFrame);
            }
            a(localEGLContext, j, null, false);
            break;
            if (this.l == 0) {
              this.C.drawFrame(localTXSVideoFrame);
            }
            i = -1;
          }
          label403:
          continue;
          label405:
          localEGLContext = null;
        }
      }
    }
  }
  
  public SurfaceTexture a()
  {
    return this.w;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16855);
    super.a(paramInt1, paramInt2);
    if (this.C != null) {
      this.C.setVideoSize(paramInt1, paramInt2);
    }
    if (this.x != null) {
      this.x.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(16855);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(16851);
    GLES20.glViewport(0, 0, h(), i());
    if (this.A != null) {
      this.A.a(paramInt1, paramBoolean, paramInt4);
    }
    super.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
    if (this.v != null) {
      this.v.c();
    }
    AppMethodBeat.o(16851);
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16853);
    super.a(paramSurfaceTexture);
    TXCLog.w("TXCVideoRender", "play:vrender: create render thread when onSurfaceCreate");
    e();
    AppMethodBeat.o(16853);
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16850);
    try
    {
      if (this.B != null) {
        this.B.release();
      }
      this.B = paramTXSVideoFrame;
      super.a(paramTXSVideoFrame, paramInt1, paramInt2, paramInt3);
      if (this.v != null) {
        this.v.c();
      }
      AppMethodBeat.o(16850);
      return;
    }
    finally
    {
      AppMethodBeat.o(16850);
    }
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(16848);
    this.b = parama;
    if ((parama != null) && (this.C != null)) {
      this.C.setHasFrameBuffer(this.h, this.i);
    }
    AppMethodBeat.o(16848);
  }
  
  public void a(g paramg)
  {
    this.a = paramg;
  }
  
  void a(Object paramObject)
  {
    AppMethodBeat.i(16856);
    synchronized (this.E)
    {
      this.D = paramObject;
      TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender initTextureRender ".concat(String.valueOf(this)));
      p();
      if (this.e != null)
      {
        this.e.a(this.f, this.g);
        this.e.b(this.h, this.i);
      }
      if (this.x != null)
      {
        this.x.b();
        this.w = new SurfaceTexture(this.x.a());
        this.w.setOnFrameAvailableListener(this);
      }
      if (this.C != null) {
        this.C.createTexture();
      }
      if ((this.b != null) && (this.C != null)) {
        this.C.setHasFrameBuffer(this.h, this.i);
      }
      if (this.A != null) {
        this.A.b();
      }
      if (this.o != null) {
        this.o.onSurfaceTextureAvailable(this.w);
      }
      AppMethodBeat.o(16856);
      return;
    }
  }
  
  public EGLContext b()
  {
    AppMethodBeat.i(16852);
    synchronized (this.u)
    {
      if (this.v != null)
      {
        localEGLContext = this.v.a();
        AppMethodBeat.o(16852);
        return localEGLContext;
      }
      EGLContext localEGLContext = null;
    }
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16854);
    super.b(paramSurfaceTexture);
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when onSurfaceRelease");
    f();
    AppMethodBeat.o(16854);
  }
  
  public void b(a parama)
  {
    AppMethodBeat.i(16849);
    this.c = parama;
    if ((parama != null) && (this.C != null)) {
      this.C.setHasFrameBuffer(this.h, this.i);
    }
    AppMethodBeat.o(16849);
  }
  
  void b(Object paramObject)
  {
    AppMethodBeat.i(16858);
    synchronized (this.E)
    {
      if (this.D != paramObject)
      {
        TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender destroyTextureRender ignore when not the same gl thread ".concat(String.valueOf(this)));
        AppMethodBeat.o(16858);
        return;
      }
      this.D = null;
      TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender destroyTextureRender ".concat(String.valueOf(this)));
    }
    try
    {
      if (this.o != null) {
        this.o.onSurfaceTextureDestroy(this.w);
      }
      label85:
      if (this.x != null)
      {
        this.x.c();
        this.x = null;
      }
      if (this.C != null)
      {
        this.C.onSurfaceDestroy();
        this.C = null;
      }
      if (this.A != null)
      {
        this.A.c();
        this.A = null;
      }
      this.w = null;
      AppMethodBeat.o(16858);
      return;
      paramObject = finally;
      AppMethodBeat.o(16858);
      throw paramObject;
    }
    catch (Exception paramObject)
    {
      break label85;
    }
  }
  
  boolean c()
  {
    AppMethodBeat.i(16859);
    while (a(this.F)) {}
    boolean bool = q();
    AppMethodBeat.o(16859);
    return bool;
  }
  
  SurfaceTexture d()
  {
    AppMethodBeat.i(16860);
    if (this.d != null)
    {
      SurfaceTexture localSurfaceTexture = this.d.getSurfaceTexture();
      AppMethodBeat.o(16860);
      return localSurfaceTexture;
    }
    AppMethodBeat.o(16860);
    return null;
  }
  
  protected void e()
  {
    AppMethodBeat.i(16861);
    synchronized (this.u)
    {
      if (this.v == null)
      {
        this.v = new b(new WeakReference(this));
        this.v.start();
        this.v.c();
        TXCLog.w("TXCVideoRender", "play:vrender: start render thread id " + getID() + ", " + this);
        AppMethodBeat.o(16861);
        return;
      }
      TXCLog.w("TXCVideoRender", "play:vrender: render thread is running " + getID() + ", " + this);
    }
  }
  
  protected void f()
  {
    AppMethodBeat.i(16862);
    synchronized (this.u)
    {
      if (this.v != null)
      {
        this.v.b();
        this.v.c();
        this.v = null;
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread id" + getID() + ", " + this);
      }
      AppMethodBeat.o(16862);
      return;
    }
  }
  
  public void finalize()
  {
    AppMethodBeat.i(16865);
    super.finalize();
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
    try
    {
      f();
      AppMethodBeat.o(16865);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16865);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.y = true;
      return;
    }
    finally {}
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public static abstract interface a
  {
    public abstract void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.a
 * JD-Core Version:    0.7.0.1
 */