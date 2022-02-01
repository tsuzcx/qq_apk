package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class a
  extends e
  implements SurfaceTexture.OnFrameAvailableListener
{
  private float[] A;
  private c B;
  private TXSVideoFrame C;
  private TXCYuvTextureRender D;
  private Object E;
  private Object F;
  private h G;
  private TXCYuvTextureRender H;
  private boolean I;
  private final Queue<Runnable> J;
  g a;
  a b;
  a c;
  private final int r;
  private final int s;
  private final int t;
  private final int u;
  private Object v;
  private b w;
  private SurfaceTexture x;
  private c y;
  private boolean z;
  
  public a()
  {
    AppMethodBeat.i(16847);
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.v = new Object();
    this.E = null;
    this.F = new Object();
    this.J = new LinkedList();
    this.A = new float[16];
    this.I = false;
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
    AppMethodBeat.i(229685);
    boolean bool;
    try
    {
      TXSVideoFrame localTXSVideoFrame;
      if (this.z)
      {
        bool = this.z;
        this.z = false;
        localTXSVideoFrame = null;
      }
      for (;;)
      {
        if ((paramInt1 > 0) && (paramInt2 > 0)) {
          break label88;
        }
        AppMethodBeat.o(229685);
        return false;
        if (this.C == null) {
          break;
        }
        localTXSVideoFrame = this.C;
        this.C = null;
        bool = false;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(229685);
    }
    label88:
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    if (this.m == 1) {}
    for (Object localObject2 = b();; localObject2 = null)
    {
      a locala = this.c;
      if (bool)
      {
        if (this.x != null)
        {
          this.x.updateTexImage();
          this.x.getTransformMatrix(this.A);
        }
        if (this.a != null)
        {
          if (this.y != null) {
            this.a.a(this.y.a(), this.A);
          }
          if (locala != null)
          {
            paramInt1 = this.y.a();
            if (this.G == null)
            {
              this.G = new h(Boolean.TRUE);
              this.G.b();
              this.G.a(true);
              this.G.b(180);
              this.G.a(h.a);
            }
            this.G.a(this.A);
            this.G.b(this.i, this.j);
            this.G.a(this.i, this.j);
            locala.onTextureProcess(this.G.d(paramInt1), h(), i(), this.l);
          }
          if ((this.m == 1) && (this.y != null)) {
            a(localObject2, this.y.a(), this.A, true);
          }
        }
      }
      Bundle localBundle;
      while ((localBundle == null) || (this.D == null)) {
        for (;;)
        {
          if (!this.I)
          {
            localBundle = new Bundle();
            localBundle.putString("EVT_USERID", getID());
            localBundle.putInt("EVT_ID", 2003);
            localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
            localBundle.putCharSequence("EVT_MSG", "Render the first video frame(IDR)");
            localBundle.putInt("EVT_PARAM1", this.i);
            localBundle.putInt("EVT_PARAM2", this.j);
            com.tencent.liteav.basic.util.h.a(this.q, 2003, localBundle);
            this.I = true;
          }
          if (!this.d)
          {
            TXCLog.w("TXCVideoRender", "onDrawFrame " + getID() + ", " + this + ", player view changed. notify first frame render");
            this.d = true;
            localBundle = new Bundle();
            com.tencent.liteav.basic.util.h.a(this.q, 2032, localBundle);
          }
          AppMethodBeat.o(229685);
          return true;
          if (this.y != null)
          {
            GLES20.glBindFramebuffer(36160, 0);
            this.y.a(this.x);
          }
        }
      }
      if (this.b != null)
      {
        this.D.setHasFrameBuffer(this.i, this.j);
        paramInt1 = this.D.drawToTexture(localBundle);
        this.b.onTextureProcess(paramInt1, h(), i(), this.l);
      }
      for (;;)
      {
        if (this.m == 1)
        {
          paramInt2 = paramInt1;
          if (paramInt1 == -1)
          {
            this.D.setHasFrameBuffer(this.i, this.j);
            paramInt2 = this.D.drawToTexture(localBundle);
          }
          a(localObject2, paramInt2, null, false);
        }
        if (locala == null) {
          break;
        }
        if (this.H == null)
        {
          this.H = new TXCYuvTextureRender();
          this.H.createTexture();
          this.H.flipVertical(false);
        }
        this.H.setHasFrameBuffer(this.i, this.j);
        locala.onTextureProcess(this.H.drawToTexture(localBundle), h(), i(), this.l);
        break;
        if (this.m == 0)
        {
          GLES20.glBindFramebuffer(36160, 0);
          this.D.drawFrame(localBundle);
        }
        paramInt1 = -1;
      }
    }
  }
  
  private void p()
  {
    AppMethodBeat.i(16857);
    this.y = new c(true);
    this.D = new TXCYuvTextureRender();
    this.B = new c(false);
    AppMethodBeat.o(16857);
  }
  
  public SurfaceTexture a()
  {
    return this.x;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16855);
    super.a(paramInt1, paramInt2);
    if (this.D != null) {
      this.D.setVideoSize(paramInt1, paramInt2);
    }
    if (this.y != null) {
      this.y.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(16855);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(16851);
    GLES20.glViewport(0, 0, f(), g());
    if (this.B != null) {
      this.B.a(paramInt1, paramBoolean, paramInt4);
    }
    super.a(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4);
    synchronized (this.v)
    {
      if (this.w != null) {
        this.w.c();
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
    //   9: getfield 108	com/tencent/liteav/renderer/a:C	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   12: ifnull +10 -> 22
    //   15: aload_0
    //   16: getfield 108	com/tencent/liteav/renderer/a:C	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   19: invokevirtual 360	com/tencent/liteav/basic/structs/TXSVideoFrame:release	()V
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 108	com/tencent/liteav/renderer/a:C	Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_0
    //   30: aload_1
    //   31: iload_2
    //   32: iload_3
    //   33: iload 4
    //   35: invokespecial 362	com/tencent/liteav/renderer/e:a	(Lcom/tencent/liteav/basic/structs/TXSVideoFrame;III)V
    //   38: aload_0
    //   39: getfield 66	com/tencent/liteav/renderer/a:v	Ljava/lang/Object;
    //   42: astore_1
    //   43: aload_1
    //   44: monitorenter
    //   45: aload_0
    //   46: getfield 344	com/tencent/liteav/renderer/a:w	Lcom/tencent/liteav/renderer/b;
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: getfield 344	com/tencent/liteav/renderer/a:w	Lcom/tencent/liteav/renderer/b;
    //   56: invokevirtual 348	com/tencent/liteav/renderer/b:c	()V
    //   59: aload_1
    //   60: monitorexit
    //   61: sipush 16850
    //   64: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: sipush 16850
    //   74: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    //   79: astore 5
    //   81: aload_1
    //   82: monitorexit
    //   83: sipush 16850
    //   86: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if ((parama != null) && (this.D != null)) {
      this.D.setHasFrameBuffer(this.i, this.j);
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
    synchronized (this.F)
    {
      this.E = paramObject;
      TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender initTextureRender ".concat(String.valueOf(this)));
      p();
      if (this.f != null)
      {
        this.f.a(this.g, this.h);
        this.f.b(this.i, this.j);
      }
      if (this.y != null)
      {
        this.y.b();
        this.x = new SurfaceTexture(this.y.a());
        this.x.setOnFrameAvailableListener(this);
      }
      if (this.D != null) {
        this.D.createTexture();
      }
      if ((this.b != null) && (this.D != null)) {
        this.D.setHasFrameBuffer(this.i, this.j);
      }
      if (this.B != null) {
        this.B.b();
      }
      if (this.p != null) {
        this.p.onSurfaceTextureAvailable(this.x);
      }
      AppMethodBeat.o(16856);
      return;
    }
  }
  
  public Object b()
  {
    AppMethodBeat.i(229702);
    synchronized (this.v)
    {
      if (this.w != null)
      {
        localObject1 = this.w.a();
        AppMethodBeat.o(229702);
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
    if ((parama != null) && (this.D != null)) {
      this.D.setHasFrameBuffer(this.i, this.j);
    }
    AppMethodBeat.o(16849);
  }
  
  void b(Object paramObject)
  {
    AppMethodBeat.i(16858);
    synchronized (this.F)
    {
      if (this.E != paramObject)
      {
        TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender destroyTextureRender ignore when not the same gl thread ".concat(String.valueOf(this)));
        AppMethodBeat.o(16858);
        return;
      }
      this.E = null;
      this.I = false;
      TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender destroyTextureRender ".concat(String.valueOf(this)));
      try
      {
        if (this.p != null) {
          this.p.onSurfaceTextureDestroy(this.x);
        }
        if (this.y != null)
        {
          this.y.c();
          this.y = null;
        }
        if (this.D != null)
        {
          this.D.onSurfaceDestroy();
          this.D = null;
        }
        if (this.B != null)
        {
          this.B.c();
          this.B = null;
        }
        this.x = null;
        if (this.G != null)
        {
          this.G.c();
          this.G = null;
        }
        if (this.H != null)
        {
          this.H.onSurfaceDestroy();
          this.H = null;
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
    AppMethodBeat.i(229712);
    while (a(this.J)) {}
    boolean bool = e(paramInt1, paramInt2);
    AppMethodBeat.o(229712);
    return bool;
  }
  
  SurfaceTexture c()
  {
    AppMethodBeat.i(229714);
    if (this.e != null)
    {
      SurfaceTexture localSurfaceTexture = this.e.getSurfaceTexture();
      AppMethodBeat.o(229714);
      return localSurfaceTexture;
    }
    AppMethodBeat.o(229714);
    return null;
  }
  
  public void c(Object paramObject)
  {
    AppMethodBeat.i(229717);
    synchronized (this.v)
    {
      if (this.w == null)
      {
        this.w = new b(new WeakReference(this));
        this.w.a(paramObject);
        this.w.start();
        this.w.c();
        TXCLog.w("TXCVideoRender", "play:vrender: start render thread id " + getID() + ", glContext " + paramObject + ", " + this);
        AppMethodBeat.o(229717);
        return;
      }
      TXCLog.w("TXCVideoRender", "play:vrender: start render thread when running " + getID() + ", " + this);
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(229720);
    synchronized (this.v)
    {
      if (this.w != null)
      {
        this.w.b();
        this.w.c();
        this.w = null;
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread id" + getID() + ", " + this);
      }
      AppMethodBeat.o(229720);
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
    //   0: ldc_w 478
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 106	com/tencent/liteav/renderer/a:z	Z
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_0
    //   16: getfield 66	com/tencent/liteav/renderer/a:v	Ljava/lang/Object;
    //   19: astore_1
    //   20: aload_1
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 344	com/tencent/liteav/renderer/a:w	Lcom/tencent/liteav/renderer/b;
    //   26: ifnull +10 -> 36
    //   29: aload_0
    //   30: getfield 344	com/tencent/liteav/renderer/a:w	Lcom/tencent/liteav/renderer/b;
    //   33: invokevirtual 348	com/tencent/liteav/renderer/b:c	()V
    //   36: aload_1
    //   37: monitorexit
    //   38: ldc_w 478
    //   41: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 478
    //   51: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: monitorexit
    //   59: ldc_w 478
    //   62: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.renderer.a
 * JD-Core Version:    0.7.0.1
 */