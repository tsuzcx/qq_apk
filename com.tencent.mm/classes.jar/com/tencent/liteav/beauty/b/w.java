package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class w
{
  private static final String b;
  SurfaceTexture.OnFrameAvailableListener a;
  private SurfaceTexture c;
  private int d;
  private boolean e;
  private MediaExtractor f;
  private AssetFileDescriptor g;
  private int h;
  private int i;
  private int j;
  private int k;
  private long l;
  private MediaCodec m;
  private boolean n;
  private boolean o;
  private Handler p;
  private Object q;
  
  static
  {
    AppMethodBeat.i(15046);
    b = w.class.getSimpleName();
    AppMethodBeat.o(15046);
  }
  
  w()
  {
    AppMethodBeat.i(15041);
    this.d = -1;
    this.e = false;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.k = -1;
    this.n = false;
    this.q = new Object();
    AppMethodBeat.o(15041);
  }
  
  private void b()
  {
    AppMethodBeat.i(15043);
    if (this.e)
    {
      this.e = false;
      if (this.f != null)
      {
        this.f.release();
        this.f = null;
      }
      try
      {
        this.m.stop();
        try
        {
          this.m.release();
          return;
        }
        catch (Exception localException1)
        {
          TXCLog.e(b, "release decoder exception: " + localException1.toString());
          return;
        }
        finally
        {
          this.m = null;
          AppMethodBeat.o(15043);
        }
        AppMethodBeat.o(15043);
      }
      catch (Exception localException2)
      {
        TXCLog.e(b, "stop decoder Exception: " + localException2.toString());
        try
        {
          this.m.release();
          return;
        }
        catch (Exception localException3)
        {
          TXCLog.e(b, "release decoder exception: " + localException3.toString());
          return;
        }
        finally
        {
          this.m = null;
          AppMethodBeat.o(15043);
        }
      }
      finally
      {
        try
        {
          this.m.release();
          this.m = null;
        }
        catch (Exception localException4)
        {
          for (;;)
          {
            TXCLog.e(b, "release decoder exception: " + localException4.toString());
            this.m = null;
          }
        }
        finally
        {
          this.m = null;
          AppMethodBeat.o(15043);
        }
        AppMethodBeat.o(15043);
      }
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(15044);
    b();
    this.a = null;
    this.l = 0L;
    this.o = false;
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
    synchronized (this.q)
    {
      if (this.p != null)
      {
        this.p.removeCallbacksAndMessages(null);
        this.p.getLooper().quit();
        this.p = null;
        this.q.notify();
      }
      if (this.g == null) {}
    }
    try
    {
      this.g.close();
      label104:
      this.g = null;
      AppMethodBeat.o(15044);
      return;
      localObject2 = finally;
      AppMethodBeat.o(15044);
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label104;
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 15042
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 71	com/tencent/liteav/beauty/b/w:q	Ljava/lang/Object;
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 129	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   19: ifnull +20 -> 39
    //   22: invokestatic 159	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   25: aload_0
    //   26: getfield 129	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   29: invokevirtual 139	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   32: if_acmpne +18 -> 50
    //   35: aload_0
    //   36: invokespecial 114	com/tencent/liteav/beauty/b/w:c	()V
    //   39: aload_1
    //   40: monitorexit
    //   41: sipush 15042
    //   44: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: new 6	com/tencent/liteav/beauty/b/w$1
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 161	com/tencent/liteav/beauty/b/w$1:<init>	(Lcom/tencent/liteav/beauty/b/w;)V
    //   58: astore_2
    //   59: aload_0
    //   60: getfield 129	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   63: aconst_null
    //   64: invokevirtual 135	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   67: aload_0
    //   68: getfield 129	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   71: aload_2
    //   72: invokevirtual 165	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 129	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   80: invokevirtual 139	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   83: invokevirtual 168	android/os/Looper:quitSafely	()V
    //   86: aload_0
    //   87: getfield 71	com/tencent/liteav/beauty/b/w:q	Ljava/lang/Object;
    //   90: invokevirtual 171	java/lang/Object:wait	()V
    //   93: goto -54 -> 39
    //   96: astore_2
    //   97: goto -11 -> 86
    //   100: astore_2
    //   101: aload_1
    //   102: monitorexit
    //   103: sipush 15042
    //   106: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	w
    //   111	4	1	localObject2	Object
    //   58	14	2	local1	1
    //   96	1	2	localInterruptedException	java.lang.InterruptedException
    //   100	10	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   86	93	96	java/lang/InterruptedException
    //   15	39	100	finally
    //   39	41	100	finally
    //   50	86	100	finally
    //   86	93	100	finally
    //   101	103	100	finally
    //   2	15	111	finally
    //   41	47	111	finally
    //   103	111	111	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.w
 * JD-Core Version:    0.7.0.1
 */