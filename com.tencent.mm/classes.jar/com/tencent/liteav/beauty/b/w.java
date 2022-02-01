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
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: sipush 15043
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 59	com/tencent/liteav/beauty/b/w:e	Z
    //   10: ifeq +171 -> 181
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield 59	com/tencent/liteav/beauty/b/w:e	Z
    //   18: aload_0
    //   19: getfield 76	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   22: ifnull +15 -> 37
    //   25: aload_0
    //   26: getfield 76	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   29: invokevirtual 81	android/media/MediaExtractor:release	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield 76	com/tencent/liteav/beauty/b/w:f	Landroid/media/MediaExtractor;
    //   37: aload_0
    //   38: getfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   41: invokevirtual 88	android/media/MediaCodec:stop	()V
    //   44: aload_0
    //   45: getfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   48: invokevirtual 89	android/media/MediaCodec:release	()V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   56: sipush 15043
    //   59: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   69: sipush 15043
    //   72: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: return
    //   76: astore_1
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   82: sipush 15043
    //   85: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: aload_0
    //   92: getfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   95: invokevirtual 89	android/media/MediaCodec:release	()V
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   103: sipush 15043
    //   106: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   116: sipush 15043
    //   119: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: astore_1
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   129: sipush 15043
    //   132: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: getfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   142: invokevirtual 89	android/media/MediaCodec:release	()V
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   150: sipush 15043
    //   153: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: astore_2
    //   159: aload_0
    //   160: aconst_null
    //   161: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   164: goto -14 -> 150
    //   167: astore_1
    //   168: aload_0
    //   169: aconst_null
    //   170: putfield 83	com/tencent/liteav/beauty/b/w:m	Landroid/media/MediaCodec;
    //   173: sipush 15043
    //   176: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: sipush 15043
    //   184: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	w
    //   63	1	1	localException1	Exception
    //   76	13	1	localObject1	Object
    //   90	1	1	localException2	Exception
    //   110	1	1	localException3	Exception
    //   123	13	1	localObject2	Object
    //   137	20	1	localObject3	Object
    //   167	13	1	localObject4	Object
    //   158	1	2	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   44	51	63	java/lang/Exception
    //   44	51	76	finally
    //   37	44	90	java/lang/Exception
    //   91	98	110	java/lang/Exception
    //   91	98	123	finally
    //   37	44	137	finally
    //   138	145	158	java/lang/Exception
    //   138	145	167	finally
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
    //   16: getfield 107	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   19: ifnull +20 -> 39
    //   22: invokestatic 137	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   25: aload_0
    //   26: getfield 107	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   29: invokevirtual 117	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   32: if_acmpne +18 -> 50
    //   35: aload_0
    //   36: invokespecial 92	com/tencent/liteav/beauty/b/w:c	()V
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
    //   55: invokespecial 139	com/tencent/liteav/beauty/b/w$1:<init>	(Lcom/tencent/liteav/beauty/b/w;)V
    //   58: astore_2
    //   59: aload_0
    //   60: getfield 107	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   63: aconst_null
    //   64: invokevirtual 113	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   67: aload_0
    //   68: getfield 107	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   71: aload_2
    //   72: invokevirtual 143	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 107	com/tencent/liteav/beauty/b/w:p	Landroid/os/Handler;
    //   80: invokevirtual 117	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   83: invokevirtual 146	android/os/Looper:quitSafely	()V
    //   86: aload_0
    //   87: getfield 71	com/tencent/liteav/beauty/b/w:q	Ljava/lang/Object;
    //   90: invokevirtual 149	java/lang/Object:wait	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.w
 * JD-Core Version:    0.7.0.1
 */