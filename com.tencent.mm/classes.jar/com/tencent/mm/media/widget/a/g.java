package com.tencent.mm.media.widget.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", "res", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private final String TAG;
  private final Object lock;
  private boolean nGG;
  private d.a.a nve;
  
  public g()
  {
    AppMethodBeat.i(94063);
    this.TAG = "MicroMsg.SightCamera.OpenCameraThread";
    this.lock = new Object();
    AppMethodBeat.o(94063);
  }
  
  /* Error */
  private static final void a(g paramg, long paramLong1, long paramLong2, Context paramContext, int paramInt, android.os.Looper paramLooper)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 66
    //   8: invokestatic 72	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 59	com/tencent/mm/media/widget/a/g:TAG	Ljava/lang/String;
    //   15: ldc 74
    //   17: iconst_3
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: lload_1
    //   24: invokestatic 80	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: invokestatic 86	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   33: invokevirtual 90	java/lang/Thread:getId	()J
    //   36: invokestatic 80	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: invokestatic 95	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   45: lload_3
    //   46: lsub
    //   47: invokestatic 80	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   50: aastore
    //   51: invokestatic 100	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_0
    //   55: getfield 61	com/tencent/mm/media/widget/a/g:lock	Ljava/lang/Object;
    //   58: astore 8
    //   60: aload 8
    //   62: monitorenter
    //   63: aload_0
    //   64: aload 5
    //   66: iload 6
    //   68: aload 7
    //   70: invokestatic 105	com/tencent/mm/compatible/deviceinfo/d:a	(Landroid/content/Context;ILandroid/os/Looper;)Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   73: putfield 107	com/tencent/mm/media/widget/a/g:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   76: aload_0
    //   77: getfield 109	com/tencent/mm/media/widget/a/g:nGG	Z
    //   80: ifeq +73 -> 153
    //   83: aload_0
    //   84: getfield 107	com/tencent/mm/media/widget/a/g:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   87: ifnull +66 -> 153
    //   90: aload_0
    //   91: getfield 59	com/tencent/mm/media/widget/a/g:TAG	Ljava/lang/String;
    //   94: ldc 111
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: invokestatic 95	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   105: lload_3
    //   106: lsub
    //   107: invokestatic 80	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: aastore
    //   111: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: getfield 107	com/tencent/mm/media/widget/a/g:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   118: astore 5
    //   120: aload 5
    //   122: invokestatic 118	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   125: aload 5
    //   127: getfield 124	com/tencent/mm/compatible/deviceinfo/d$a$a:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   130: astore 5
    //   132: aload 5
    //   134: aconst_null
    //   135: invokevirtual 129	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   138: aload 5
    //   140: invokevirtual 132	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   143: aload 5
    //   145: invokevirtual 135	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 107	com/tencent/mm/media/widget/a/g:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   153: aload_0
    //   154: getfield 61	com/tencent/mm/media/widget/a/g:lock	Ljava/lang/Object;
    //   157: invokevirtual 138	java/lang/Object:notify	()V
    //   160: getstatic 144	kotlin/ah:aiuX	Lkotlin/ah;
    //   163: astore_0
    //   164: aload 8
    //   166: monitorexit
    //   167: ldc 64
    //   169: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: astore 5
    //   175: aload_0
    //   176: getfield 59	com/tencent/mm/media/widget/a/g:TAG	Ljava/lang/String;
    //   179: ldc 146
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 5
    //   189: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 107	com/tencent/mm/media/widget/a/g:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   201: goto -125 -> 76
    //   204: astore_0
    //   205: aload 8
    //   207: monitorexit
    //   208: ldc 64
    //   210: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_0
    //   214: athrow
    //   215: astore 5
    //   217: aload_0
    //   218: getfield 59	com/tencent/mm/media/widget/a/g:TAG	Ljava/lang/String;
    //   221: ldc 152
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload 5
    //   231: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   234: aastore
    //   235: invokestatic 114	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: goto -85 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramg	g
    //   0	241	1	paramLong1	long
    //   0	241	3	paramLong2	long
    //   0	241	5	paramContext	Context
    //   0	241	6	paramInt	int
    //   0	241	7	paramLooper	android.os.Looper
    //   58	148	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   63	76	173	java/lang/Exception
    //   63	76	204	finally
    //   76	114	204	finally
    //   114	153	204	finally
    //   153	164	204	finally
    //   175	201	204	finally
    //   217	238	204	finally
    //   114	153	215	java/lang/Exception
  }
  
  public final d.a.a P(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(237605);
    if (paramContext == null)
    {
      AppMethodBeat.o(237605);
      return null;
    }
    long l1 = Util.nowMilliSecond();
    long l2 = Thread.currentThread().getId();
    synchronized (this.lock)
    {
      this.nGG = false;
      this.nve = null;
      ThreadPool.post(new g..ExternalSyntheticLambda0(this, l2, l1, paramContext, paramInt, null), "SightCamera_openCamera");
      try
      {
        this.lock.wait(30000L);
        if (this.nve != null)
        {
          paramContext = this.nve;
          s.checkNotNull(paramContext);
          if (paramContext.lTN != null)
          {
            paramContext = this.TAG;
            long l3 = Util.nowMilliSecond();
            d.a.a locala = this.nve;
            s.checkNotNull(locala);
            Log.i(paramContext, "Open Camera Succ thread:%d Time:%d camera:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3 - l1), locala.lTN });
            paramContext = this.nve;
            AppMethodBeat.o(237605);
            return paramContext;
          }
        }
      }
      catch (InterruptedException paramContext)
      {
        for (;;)
        {
          Log.e(this.TAG, "Lock wait failed e:%s", new Object[] { paramContext.getMessage() });
        }
      }
    }
    this.nGG = true;
    Log.e(this.TAG, "Open Camera Timeout:%d", new Object[] { Long.valueOf(Util.nowMilliSecond() - l1) });
    AppMethodBeat.o(237605);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.g
 * JD-Core Version:    0.7.0.1
 */