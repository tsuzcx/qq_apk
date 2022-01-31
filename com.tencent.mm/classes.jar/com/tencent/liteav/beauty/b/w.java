package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
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
    AppMethodBeat.i(146379);
    b = w.class.getSimpleName();
    AppMethodBeat.o(146379);
  }
  
  w()
  {
    AppMethodBeat.i(146374);
    this.d = -1;
    this.e = false;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.k = -1;
    this.n = false;
    this.q = new Object();
    AppMethodBeat.o(146374);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: ldc 75
    //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 59	com/tencent/liteav/beauty/b/w:e	Z
    //   9: ifeq +163 -> 172
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 59	com/tencent/liteav/beauty/b/w:e	Z
    //   17: aload_0
    //   18: getfield 77	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   21: ifnull +15 -> 36
    //   24: aload_0
    //   25: getfield 77	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   28: invokevirtual 82	android/media/MediaExtractor:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 77	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   36: aload_0
    //   37: getfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   40: invokevirtual 89	android/media/MediaCodec:stop	()V
    //   43: aload_0
    //   44: getfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   47: invokevirtual 90	android/media/MediaCodec:release	()V
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   55: ldc 75
    //   57: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   67: ldc 75
    //   69: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   79: ldc 75
    //   81: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   91: invokevirtual 90	android/media/MediaCodec:release	()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   99: ldc 75
    //   101: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: astore_1
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   111: ldc 75
    //   113: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: astore_1
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   123: ldc 75
    //   125: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    //   130: astore_1
    //   131: aload_0
    //   132: getfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   135: invokevirtual 90	android/media/MediaCodec:release	()V
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   143: ldc 75
    //   145: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_1
    //   149: athrow
    //   150: astore_2
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   156: goto -13 -> 143
    //   159: astore_1
    //   160: aload_0
    //   161: aconst_null
    //   162: putfield 84	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   165: ldc 75
    //   167: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_1
    //   171: athrow
    //   172: ldc 75
    //   174: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	w
    //   61	1	1	localException1	Exception
    //   73	12	1	localObject1	Object
    //   86	1	1	localException2	Exception
    //   105	1	1	localException3	Exception
    //   117	12	1	localObject2	Object
    //   130	19	1	localObject3	Object
    //   159	12	1	localObject4	Object
    //   150	1	2	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   43	50	61	java/lang/Exception
    //   43	50	73	finally
    //   36	43	86	java/lang/Exception
    //   87	94	105	java/lang/Exception
    //   87	94	117	finally
    //   36	43	130	finally
    //   131	138	150	java/lang/Exception
    //   131	138	159	finally
  }
  
  private void c()
  {
    AppMethodBeat.i(146377);
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
      label103:
      this.g = null;
      AppMethodBeat.o(146377);
      return;
      localObject2 = finally;
      AppMethodBeat.o(146377);
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label103;
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 71	com/tencent/liteav/beauty/b/w:q	Ljava/lang/Object;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 110	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   18: ifnull +20 -> 38
    //   21: invokestatic 141	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   24: aload_0
    //   25: getfield 110	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   28: invokevirtual 120	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   31: if_acmpne +17 -> 48
    //   34: aload_0
    //   35: invokespecial 94	com/tencent/liteav/beauty/b/w:c	()V
    //   38: aload_1
    //   39: monitorexit
    //   40: ldc 138
    //   42: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: new 143	com/tencent/liteav/beauty/b/w$1
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 145	com/tencent/liteav/beauty/b/w$1:<init>	(Lcom/tencent/liteav/beauty/b/w;)V
    //   56: astore_2
    //   57: aload_0
    //   58: getfield 110	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   61: aconst_null
    //   62: invokevirtual 116	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   65: aload_0
    //   66: getfield 110	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   69: aload_2
    //   70: invokevirtual 149	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: aload_0
    //   75: getfield 110	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   78: invokevirtual 120	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   81: invokevirtual 152	android/os/Looper:quitSafely	()V
    //   84: aload_0
    //   85: getfield 71	com/tencent/liteav/beauty/b/w:q	Ljava/lang/Object;
    //   88: invokevirtual 155	java/lang/Object:wait	()V
    //   91: goto -53 -> 38
    //   94: astore_2
    //   95: goto -11 -> 84
    //   98: astore_2
    //   99: aload_1
    //   100: monitorexit
    //   101: ldc 138
    //   103: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	w
    //   108	4	1	localObject2	Object
    //   56	14	2	local1	w.1
    //   94	1	2	localInterruptedException	java.lang.InterruptedException
    //   98	9	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   84	91	94	java/lang/InterruptedException
    //   14	38	98	finally
    //   38	40	98	finally
    //   48	84	98	finally
    //   84	91	98	finally
    //   99	101	98	finally
    //   2	14	108	finally
    //   40	45	108	finally
    //   101	108	108	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.w
 * JD-Core Version:    0.7.0.1
 */