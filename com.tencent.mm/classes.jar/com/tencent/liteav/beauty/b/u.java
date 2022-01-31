package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;

public class u
{
  private static final String b = u.class.getSimpleName();
  SurfaceTexture.OnFrameAvailableListener a;
  private SurfaceTexture c;
  private int d = -1;
  private boolean e = false;
  private MediaExtractor f;
  private AssetFileDescriptor g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private long l;
  private MediaCodec m;
  private boolean n = false;
  private boolean o;
  private Handler p;
  private Object q = new Object();
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/liteav/beauty/b/u:e	Z
    //   4: ifeq +46 -> 50
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 50	com/tencent/liteav/beauty/b/u:e	Z
    //   12: aload_0
    //   13: getfield 67	com/tencent/liteav/beauty/b/u:f	Landroid/media/MediaExtractor;
    //   16: ifnull +15 -> 31
    //   19: aload_0
    //   20: getfield 67	com/tencent/liteav/beauty/b/u:f	Landroid/media/MediaExtractor;
    //   23: invokevirtual 72	android/media/MediaExtractor:release	()V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 67	com/tencent/liteav/beauty/b/u:f	Landroid/media/MediaExtractor;
    //   31: aload_0
    //   32: getfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   35: invokevirtual 79	android/media/MediaCodec:stop	()V
    //   38: aload_0
    //   39: getfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   42: invokevirtual 80	android/media/MediaCodec:release	()V
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   57: return
    //   58: astore_1
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   64: aload_1
    //   65: athrow
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   71: invokevirtual 80	android/media/MediaCodec:release	()V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   100: invokevirtual 80	android/media/MediaCodec:release	()V
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   108: aload_1
    //   109: athrow
    //   110: astore_2
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   116: goto -8 -> 108
    //   119: astore_1
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 74	com/tencent/liteav/beauty/b/u:m	Landroid/media/MediaCodec;
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	u
    //   51	1	1	localException1	Exception
    //   58	7	1	localObject1	Object
    //   66	1	1	localException2	Exception
    //   80	1	1	localException3	Exception
    //   87	7	1	localObject2	Object
    //   95	14	1	localObject3	Object
    //   119	7	1	localObject4	Object
    //   110	1	2	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   38	45	51	java/lang/Exception
    //   38	45	58	finally
    //   31	38	66	java/lang/Exception
    //   67	74	80	java/lang/Exception
    //   67	74	87	finally
    //   31	38	95	finally
    //   96	103	110	java/lang/Exception
    //   96	103	119	finally
  }
  
  private void c()
  {
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
      label98:
      this.g = null;
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      break label98;
    }
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/tencent/liteav/beauty/b/u:q	Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 98	com/tencent/liteav/beauty/b/u:p	Landroid/os/Handler;
    //   13: ifnull +20 -> 33
    //   16: invokestatic 128	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   19: aload_0
    //   20: getfield 98	com/tencent/liteav/beauty/b/u:p	Landroid/os/Handler;
    //   23: invokevirtual 108	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   26: if_acmpne +12 -> 38
    //   29: aload_0
    //   30: invokespecial 83	com/tencent/liteav/beauty/b/u:c	()V
    //   33: aload_1
    //   34: monitorexit
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: new 130	com/tencent/liteav/beauty/b/u$1
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 132	com/tencent/liteav/beauty/b/u$1:<init>	(Lcom/tencent/liteav/beauty/b/u;)V
    //   46: astore_2
    //   47: aload_0
    //   48: getfield 98	com/tencent/liteav/beauty/b/u:p	Landroid/os/Handler;
    //   51: aconst_null
    //   52: invokevirtual 104	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   55: aload_0
    //   56: getfield 98	com/tencent/liteav/beauty/b/u:p	Landroid/os/Handler;
    //   59: aload_2
    //   60: invokevirtual 136	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   63: pop
    //   64: aload_0
    //   65: getfield 98	com/tencent/liteav/beauty/b/u:p	Landroid/os/Handler;
    //   68: invokevirtual 108	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   71: invokevirtual 139	android/os/Looper:quitSafely	()V
    //   74: aload_0
    //   75: getfield 62	com/tencent/liteav/beauty/b/u:q	Ljava/lang/Object;
    //   78: invokevirtual 142	java/lang/Object:wait	()V
    //   81: goto -48 -> 33
    //   84: astore_2
    //   85: goto -11 -> 74
    //   88: astore_2
    //   89: aload_1
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	u
    //   93	4	1	localObject2	Object
    //   46	14	2	local1	u.1
    //   84	1	2	localInterruptedException	java.lang.InterruptedException
    //   88	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   74	81	84	java/lang/InterruptedException
    //   9	33	88	finally
    //   33	35	88	finally
    //   38	74	88	finally
    //   74	81	88	finally
    //   89	91	88	finally
    //   2	9	93	finally
    //   91	93	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.u
 * JD-Core Version:    0.7.0.1
 */