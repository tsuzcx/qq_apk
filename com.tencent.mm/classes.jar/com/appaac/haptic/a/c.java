package com.appaac.haptic.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends Thread
{
  private final String TAG;
  public final Object cqM;
  public volatile boolean cqN;
  public List<b> cqO;
  final Context mContext;
  public final Object mLock;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(208367);
    this.TAG = "NonRichTapThread";
    this.mLock = new Object();
    this.cqM = new Object();
    this.cqN = false;
    this.cqO = new ArrayList();
    this.mContext = paramContext;
    AppMethodBeat.o(208367);
  }
  
  private boolean Np()
  {
    AppMethodBeat.i(208373);
    synchronized (this.cqM)
    {
      Iterator localIterator = this.cqO.iterator();
      while (localIterator.hasNext()) {
        if (((b)localIterator.next()).Nl)
        {
          AppMethodBeat.o(208373);
          return true;
        }
      }
      AppMethodBeat.o(208373);
      return false;
    }
  }
  
  /* Error */
  public final void No()
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 39	com/appaac/haptic/a/c:cqM	Ljava/lang/Object;
    //   16: astore_2
    //   17: aload_2
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 46	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   23: invokeinterface 82 1 0
    //   28: ifeq +13 -> 41
    //   31: aload_2
    //   32: monitorexit
    //   33: aload_1
    //   34: monitorexit
    //   35: ldc 79
    //   37: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: aload_0
    //   42: getfield 46	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   45: iconst_0
    //   46: invokeinterface 86 2 0
    //   51: checkcast 72	com/appaac/haptic/a/b
    //   54: astore_3
    //   55: aload_3
    //   56: getfield 75	com/appaac/haptic/a/b:Nl	Z
    //   59: ifeq +8 -> 67
    //   62: aload_3
    //   63: iconst_0
    //   64: putfield 75	com/appaac/haptic/a/b:Nl	Z
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_0
    //   70: getfield 37	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   73: invokevirtual 89	java/lang/Object:notify	()V
    //   76: aload_1
    //   77: monitorexit
    //   78: ldc 79
    //   80: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: astore_3
    //   85: aload_2
    //   86: monitorexit
    //   87: ldc 79
    //   89: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_3
    //   93: athrow
    //   94: astore_2
    //   95: goto -19 -> 76
    //   98: astore_2
    //   99: aload_1
    //   100: monitorexit
    //   101: ldc 79
    //   103: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	c
    //   9	91	1	localObject1	Object
    //   94	1	2	localException	Exception
    //   98	9	2	localObject3	Object
    //   54	9	3	localb	b
    //   84	9	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	33	84	finally
    //   41	67	84	finally
    //   67	69	84	finally
    //   12	19	94	java/lang/Exception
    //   69	76	94	java/lang/Exception
    //   85	94	94	java/lang/Exception
    //   12	19	98	finally
    //   33	35	98	finally
    //   69	76	98	finally
    //   76	78	98	finally
    //   85	94	98	finally
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(208388);
    synchronized (this.mLock)
    {
      paramb.cqK = (d.aF(this.mContext).aW(paramb.cqE) + paramb.cqG);
      paramb.cqJ = 0L;
      synchronized (this.cqM)
      {
        if (this.cqO.size() > 0) {
          ((b)this.cqO.get(0)).Nl = false;
        }
        this.cqO.add(0, paramb);
      }
    }
    try
    {
      this.mLock.notify();
      label96:
      AppMethodBeat.o(208388);
      return;
      paramb = finally;
      AppMethodBeat.o(208388);
      throw paramb;
      paramb = finally;
      AppMethodBeat.o(208388);
      throw paramb;
    }
    catch (Exception paramb)
    {
      break label96;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 41	com/appaac/haptic/a/c:cqN	Z
    //   9: ifne +343 -> 352
    //   12: aload_0
    //   13: getfield 46	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   16: ifnull -11 -> 5
    //   19: aload_0
    //   20: getfield 46	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   23: invokeinterface 82 1 0
    //   28: ifne +10 -> 38
    //   31: aload_0
    //   32: invokespecial 128	com/appaac/haptic/a/c:Np	()Z
    //   35: ifne +80 -> 115
    //   38: aload_0
    //   39: getfield 37	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   42: astore 5
    //   44: aload 5
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 39	com/appaac/haptic/a/c:cqM	Ljava/lang/Object;
    //   51: astore 6
    //   53: aload 6
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 46	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   60: invokeinterface 131 1 0
    //   65: aload 6
    //   67: monitorexit
    //   68: aload_0
    //   69: getfield 37	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   72: invokevirtual 134	java/lang/Object:wait	()V
    //   75: aload 5
    //   77: monitorexit
    //   78: goto -73 -> 5
    //   81: astore 6
    //   83: aload 5
    //   85: monitorexit
    //   86: ldc 126
    //   88: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload 6
    //   93: athrow
    //   94: astore 7
    //   96: aload 6
    //   98: monitorexit
    //   99: ldc 126
    //   101: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload 7
    //   106: athrow
    //   107: astore 6
    //   109: aload 5
    //   111: monitorexit
    //   112: goto -107 -> 5
    //   115: invokestatic 140	android/os/SystemClock:elapsedRealtime	()J
    //   118: lstore_1
    //   119: aload_0
    //   120: getfield 46	com/appaac/haptic/a/c:cqO	Ljava/util/List;
    //   123: iconst_0
    //   124: invokeinterface 86 2 0
    //   129: checkcast 72	com/appaac/haptic/a/b
    //   132: astore 6
    //   134: aload 6
    //   136: getfield 75	com/appaac/haptic/a/b:Nl	Z
    //   139: ifeq -134 -> 5
    //   142: aload 6
    //   144: getfield 116	com/appaac/haptic/a/b:cqJ	J
    //   147: lload_1
    //   148: lcmp
    //   149: ifle +66 -> 215
    //   152: aload 6
    //   154: getfield 116	com/appaac/haptic/a/b:cqJ	J
    //   157: lstore_3
    //   158: aload_0
    //   159: getfield 37	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   162: astore 5
    //   164: aload 5
    //   166: monitorenter
    //   167: aload_0
    //   168: getfield 37	com/appaac/haptic/a/c:mLock	Ljava/lang/Object;
    //   171: lload_3
    //   172: lload_1
    //   173: lsub
    //   174: invokevirtual 143	java/lang/Object:wait	(J)V
    //   177: aload 5
    //   179: monitorexit
    //   180: aload 6
    //   182: getfield 146	com/appaac/haptic/a/b:cqL	I
    //   185: aload 6
    //   187: getfield 149	com/appaac/haptic/a/b:cqF	I
    //   190: if_icmple -185 -> 5
    //   193: aload 6
    //   195: iconst_0
    //   196: putfield 75	com/appaac/haptic/a/b:Nl	Z
    //   199: goto -194 -> 5
    //   202: astore 6
    //   204: aload 5
    //   206: monitorexit
    //   207: ldc 126
    //   209: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload 6
    //   214: athrow
    //   215: aload_0
    //   216: getfield 48	com/appaac/haptic/a/c:mContext	Landroid/content/Context;
    //   219: invokestatic 98	com/appaac/haptic/a/d:aF	(Landroid/content/Context;)Lcom/appaac/haptic/a/d;
    //   222: aload 6
    //   224: getfield 101	com/appaac/haptic/a/b:cqE	Ljava/lang/String;
    //   227: aload 6
    //   229: getfield 149	com/appaac/haptic/a/b:cqF	I
    //   232: aload 6
    //   234: getfield 152	com/appaac/haptic/a/b:cqH	I
    //   237: invokevirtual 156	com/appaac/haptic/a/d:h	(Ljava/lang/String;II)V
    //   240: aload 6
    //   242: aload 6
    //   244: getfield 146	com/appaac/haptic/a/b:cqL	I
    //   247: iconst_1
    //   248: iadd
    //   249: putfield 146	com/appaac/haptic/a/b:cqL	I
    //   252: new 158	java/lang/StringBuilder
    //   255: dup
    //   256: ldc 160
    //   258: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload 6
    //   263: getfield 146	com/appaac/haptic/a/b:cqL	I
    //   266: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 6
    //   272: getfield 146	com/appaac/haptic/a/b:cqL	I
    //   275: aload 6
    //   277: getfield 149	com/appaac/haptic/a/b:cqF	I
    //   280: if_icmplt +12 -> 292
    //   283: aload 6
    //   285: iconst_0
    //   286: putfield 75	com/appaac/haptic/a/b:Nl	Z
    //   289: goto -284 -> 5
    //   292: aload 6
    //   294: invokestatic 140	android/os/SystemClock:elapsedRealtime	()J
    //   297: aload 6
    //   299: getfield 112	com/appaac/haptic/a/b:cqK	I
    //   302: i2l
    //   303: ladd
    //   304: putfield 116	com/appaac/haptic/a/b:cqJ	J
    //   307: new 158	java/lang/StringBuilder
    //   310: dup
    //   311: ldc 169
    //   313: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: invokestatic 140	android/os/SystemClock:elapsedRealtime	()J
    //   319: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: ldc 174
    //   324: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 6
    //   329: getfield 116	com/appaac/haptic/a/b:cqJ	J
    //   332: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: ldc 179
    //   337: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload 6
    //   342: getfield 112	com/appaac/haptic/a/b:cqK	I
    //   345: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: goto -344 -> 5
    //   352: ldc 126
    //   354: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: return
    //   358: astore 7
    //   360: goto -183 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	c
    //   118	55	1	l1	long
    //   157	15	3	l2	long
    //   81	16	6	localObject3	Object
    //   107	1	6	localException1	Exception
    //   132	62	6	localb	b
    //   202	139	6	localObject4	Object
    //   94	11	7	localObject5	Object
    //   358	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   47	56	81	finally
    //   68	75	81	finally
    //   75	78	81	finally
    //   96	107	81	finally
    //   56	68	94	finally
    //   47	56	107	java/lang/Exception
    //   68	75	107	java/lang/Exception
    //   96	107	107	java/lang/Exception
    //   167	177	202	finally
    //   177	180	202	finally
    //   167	177	358	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.appaac.haptic.a.c
 * JD-Core Version:    0.7.0.1
 */