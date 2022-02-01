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

public class a
  extends e
  implements SurfaceTexture.OnFrameAvailableListener
{
  private c A;
  private TXSVideoFrame B;
  private TXCYuvTextureRender C;
  private Object D;
  private Object E;
  private h F;
  private TXCYuvTextureRender G;
  private final Queue<Runnable> H;
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
    this.H = new LinkedList();
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
  
  private boolean e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221494);
    boolean bool;
    try
    {
      TXSVideoFrame localTXSVideoFrame1;
      if (this.y)
      {
        bool = this.y;
        this.y = false;
        localTXSVideoFrame1 = null;
      }
      for (;;)
      {
        if ((paramInt1 > 0) && (paramInt2 > 0)) {
          break label88;
        }
        AppMethodBeat.o(221494);
        return false;
        if (this.B == null) {
          break;
        }
        localTXSVideoFrame1 = this.B;
        this.B = null;
        bool = false;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(221494);
    }
    label88:
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.l == 1) {}
    for (Object localObject = b();; localObject = null)
    {
      a locala = this.c;
      if (bool)
      {
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
          if (locala != null)
          {
            paramInt1 = this.x.a();
            if (this.F == null)
            {
              this.F = new h(Boolean.TRUE);
              this.F.b();
              this.F.a(true);
              this.F.b(180);
              this.F.a(h.a);
            }
            this.F.a(this.z);
            this.F.b(this.h, this.i);
            this.F.a(this.h, this.i);
            locala.onTextureProcess(this.F.d(paramInt1), h(), i(), this.k);
          }
          if ((this.l == 1) && (this.x != null)) {
            a(localObject, this.x.a(), this.z, true);
          }
        }
      }
      while ((localTXSVideoFrame2 == null) || (this.C == null)) {
        for (;;)
        {
          AppMethodBeat.o(221494);
          return true;
          if (this.x != null)
          {
            GLES20.glBindFramebuffer(36160, 0);
            this.x.a(this.w);
          }
        }
      }
      if (this.b != null)
      {
        this.C.setHasFrameBuffer(this.h, this.i);
        paramInt1 = this.C.drawToTexture(localTXSVideoFrame2);
        this.b.onTextureProcess(paramInt1, h(), i(), this.k);
      }
      for (;;)
      {
        if (this.l == 1)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == -1)
          {
            this.C.setHasFrameBuffer(this.h, this.i);
            paramInt2 = this.C.drawToTexture(localTXSVideoFrame2);
          }
          a(localObject, paramInt2, null, false);
        }
        if (locala == null) {
          break;
        }
        if (this.G == null)
        {
          this.G = new TXCYuvTextureRender();
          this.G.createTexture();
          this.G.flipVertical(false);
        }
        this.G.setHasFrameBuffer(this.h, this.i);
        locala.onTextureProcess(this.G.drawToTexture(localTXSVideoFrame2), h(), i(), this.k);
        break;
        if (this.l == 0)
        {
          GLES20.glBindFramebuffer(36160, 0);
          this.C.drawFrame(localTXSVideoFrame2);
        }
        paramInt1 = -1;
      }
    }
  }
  
  private void p()
  {
    AppMethodBeat.i(16857);
    this.x = new c(true);
    this.C = new TXCYuvTextureRender();
    this.A = new c(false);
    AppMethodBeat.o(16857);
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
    GLES20.glViewport(0, 0, f(), g());
    if (this.A != null) {
      this.A.a(paramInt1, paramBoolean, paramInt4);
    }
    super.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
    synchronized (this.u)
    {
      if (this.v != null) {
        this.v.c();
      }
      AppMethodBeat.o(16851);
      return;
    }
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16853);
    super.a(paramSurfaceTexture);
    TXCLog.w("TXCVideoRender", "play:vrender: create render thread when onSurfaceCreate");
    c(null);
    AppMethodBeat.o(16853);
  }
  
  /* Error */
  public void a(TXSVideoFrame arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 16850
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 106	com/tencent/liteav/renderer/a:B	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 106	com/tencent/liteav/renderer/a:B	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   19: invokevirtual 278	com/tencent/liteav/basic/structs/TXSVideoFrame:release	()V
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 106	com/tencent/liteav/renderer/a:B	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_0
    //   30: aload_1
    //   31: iload_2
    //   32: iload_3
    //   33: iload 4
    //   35: invokespecial 280	com/tencent/liteav/renderer/e:a	(Lcom/tencent/liteav/basic/structs/TXSVideoFrame;III)V
    //   38: aload_0
    //   39: getfield 66	com/tencent/liteav/renderer/a:u	Ljava/lang/Object;
    //   42: astore_1
    //   43: aload_1
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 255	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: getfield 255	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   56: invokevirtual 259	com/tencent/liteav/renderer/b:c	()V
    //   59: aload_1
    //   60: monitorexit
    //   61: sipush 16850
    //   64: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: sipush 16850
    //   74: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    //   79: astore 5
    //   81: aload_1
    //   82: monitorexit
    //   83: sipush 16850
    //   86: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload 5
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   0	92	2	paramInt1	int
    //   0	92	3	paramInt2	int
    //   0	92	4	paramInt3	int
    //   79	11	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	22	68	finally
    //   22	29	68	finally
    //   45	59	79	finally
    //   59	61	79	finally
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
  
  public Object b()
  {
    AppMethodBeat.i(221437);
    synchronized (this.u)
    {
      if (this.v != null)
      {
        localObject1 = this.v.a();
        AppMethodBeat.o(221437);
        return localObject1;
      }
      Object localObject1 = null;
    }
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16854);
    super.b(paramSurfaceTexture);
    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when onSurfaceRelease");
    d();
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
      try
      {
        if (this.o != null) {
          this.o.onSurfaceTextureDestroy(this.w);
        }
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
        if (this.F != null)
        {
          this.F.c();
          this.F = null;
        }
        if (this.G != null)
        {
          this.G.onSurfaceDestroy();
          this.G = null;
        }
        AppMethodBeat.o(16858);
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          TXCLog.e("TXCVideoRender", "callback failed.", paramObject);
        }
      }
    }
  }
  
  boolean b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221454);
    while (a(this.H)) {}
    boolean bool = e(paramInt1, paramInt2);
    AppMethodBeat.o(221454);
    return bool;
  }
  
  SurfaceTexture c()
  {
    AppMethodBeat.i(221457);
    if (this.d != null)
    {
      SurfaceTexture localSurfaceTexture = this.d.getSurfaceTexture();
      AppMethodBeat.o(221457);
      return localSurfaceTexture;
    }
    AppMethodBeat.o(221457);
    return null;
  }
  
  public void c(Object paramObject)
  {
    AppMethodBeat.i(221465);
    synchronized (this.u)
    {
      if (this.v == null)
      {
        this.v = new b(new WeakReference(this));
        this.v.a(paramObject);
        this.v.start();
        this.v.c();
        TXCLog.w("TXCVideoRender", "play:vrender: start render thread id " + getID() + ", glContext " + paramObject + ", " + this);
        AppMethodBeat.o(221465);
        return;
      }
      TXCLog.w("TXCVideoRender", "play:vrender: start render thread when running " + getID() + ", " + this);
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(221467);
    synchronized (this.u)
    {
      if (this.v != null)
      {
        this.v.b();
        this.v.c();
        this.v = null;
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread id" + getID() + ", " + this);
      }
      AppMethodBeat.o(221467);
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
      d();
      AppMethodBeat.o(16865);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCVideoRender", "quit render thread failed.", localException);
      AppMethodBeat.o(16865);
    }
  }
  
  /* Error */
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    // Byte code:
    //   0: ldc_w 417
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 104	com/tencent/liteav/renderer/a:y	Z
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: getfield 66	com/tencent/liteav/renderer/a:u	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 255	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   26: ifnull +10 -> 36
    //   29: aload_0
    //   30: getfield 255	com/tencent/liteav/renderer/a:v	Lcom/tencent/liteav/renderer/b;
    //   33: invokevirtual 259	com/tencent/liteav/renderer/b:c	()V
    //   36: aload_1
    //   37: monitorexit
    //   38: ldc_w 417
    //   41: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 417
    //   51: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: monitorexit
    //   59: ldc_w 417
    //   62: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	a
    //   56	10	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	45	finally
    //   22	36	56	finally
    //   36	38	56	finally
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