package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
{
  private static SparseArray<b> eFP;
  private static final byte[] eFQ;
  private static ak mHandler;
  
  static
  {
    AppMethodBeat.i(77206);
    eFP = new SparseArray();
    mHandler = new ak(Looper.getMainLooper());
    eFQ = new byte[0];
    AppMethodBeat.o(77206);
  }
  
  public static void Qh()
  {
    AppMethodBeat.i(77202);
    c.Ql();
    AppMethodBeat.o(77202);
  }
  
  public static void Qi()
  {
    AppMethodBeat.i(77203);
    c.detach();
    AppMethodBeat.o(77203);
  }
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    AppMethodBeat.i(77204);
    synchronized (eFQ)
    {
      b localb2 = (b)eFP.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        eFP.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.eFU.containsKey(paramString)) {
        localb1.eFU.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.mf(paramString);
      paramWakerLock = mHandler;
      if (!localb1.eFS)
      {
        localb1.eFS = true;
        paramWakerLock.postDelayed(localb1.eFT, 60000L);
      }
      AppMethodBeat.o(77204);
      return;
    }
  }
  
  public static void c(WakerLock paramWakerLock)
  {
    AppMethodBeat.i(77205);
    synchronized (eFQ)
    {
      paramWakerLock = (b)eFP.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label114;
      }
      Object localObject = mHandler;
      if (paramWakerLock.eFS)
      {
        paramWakerLock.eFS = false;
        ((ak)localObject).removeCallbacks(paramWakerLock.eFT);
      }
      localObject = paramWakerLock.eFU.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.mg(((a.b.a)((Iterator)localObject).next()).eFV);
      }
    }
    paramWakerLock.eFU.clear();
    label114:
    AppMethodBeat.o(77205);
  }
  
  static final class a
    implements Runnable
  {
    private WakerLock eFR = null;
    
    public a(WakerLock paramWakerLock)
    {
      this.eFR = paramWakerLock;
    }
    
    public final void run()
    {
      AppMethodBeat.i(77185);
      Object localObject2;
      int k;
      int m;
      for (;;)
      {
        int i;
        synchronized (a.Qj())
        {
          localObject2 = (a.b)a.Qk().get(this.eFR.hashCode());
          if (localObject2 == null) {
            break label274;
          }
          k = this.eFR.hashCode();
          m = this.eFR.innerWakeLockHashCode();
          String str = this.eFR.getCreatePosStackLine();
          Object localObject3 = ((a.b)localObject2).eFU.values();
          localObject2 = new StringBuilder();
          i = 1;
          localObject3 = ((Collection)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          a.b.a locala = (a.b.a)((Iterator)localObject3).next();
          if (i != 0)
          {
            j = 0;
            i = j;
            if (locala.eFW == 0L) {
              continue;
            }
            ((StringBuilder)localObject2).append('{').append(locala.eFV).append(',').append(SystemClock.elapsedRealtime() - locala.eFW).append('}');
            i = j;
          }
        }
        ((StringBuilder)localObject2).append(',');
        int j = i;
      }
      if (((StringBuilder)localObject2).length() == 0) {
        ((StringBuilder)localObject2).append("<empty>");
      }
      ab.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), localObject1, ((StringBuilder)localObject2).toString() });
      for (;;)
      {
        this.eFR.unLock();
        AppMethodBeat.o(77185);
        return;
        label274:
        ab.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(this.eFR.hashCode()), Integer.valueOf(this.eFR.innerWakeLockHashCode()), this.eFR.getCreatePosStackLine(), "#lost-trace-state#" });
      }
    }
  }
  
  static final class b
  {
    volatile boolean eFS;
    a.a eFT;
    Map<String, a> eFU;
    
    public b(WakerLock paramWakerLock)
    {
      AppMethodBeat.i(77186);
      this.eFS = false;
      this.eFT = null;
      this.eFU = new HashMap();
      this.eFT = new a.a(paramWakerLock);
      AppMethodBeat.o(77186);
    }
    
    static final class a
    {
      public String eFV = null;
      public long eFW = 0L;
      
      public a(String paramString, long paramLong)
      {
        this.eFV = paramString;
        this.eFW = paramLong;
      }
    }
  }
  
  static final class c
  {
    private static int eFX = 0;
    private static long eFY = 0L;
    private static HashMap<String, a> eFZ = null;
    private static final byte[] eGa = new byte[0];
    private static BroadcastReceiver eGb = null;
    private static long mLastReportTime = 0L;
    
    /* Error */
    public static void Ql()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc 45
      //   4: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: getstatic 28	com/tencent/mm/jni/a/a$c:eFX	I
      //   10: ifne +125 -> 135
      //   13: invokestatic 57	android/os/Process:myPid	()I
      //   16: putstatic 28	com/tencent/mm/jni/a/a$c:eFX	I
      //   19: new 9	com/tencent/mm/jni/a/a$c$1
      //   22: dup
      //   23: invokespecial 60	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   26: putstatic 38	com/tencent/mm/jni/a/a$c:eGb	Landroid/content/BroadcastReceiver;
      //   29: getstatic 36	com/tencent/mm/jni/a/a$c:eGa	[B
      //   32: astore_3
      //   33: aload_3
      //   34: monitorenter
      //   35: new 62	java/io/ObjectInputStream
      //   38: dup
      //   39: new 64	com/tencent/mm/vfs/b
      //   42: dup
      //   43: invokestatic 70	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
      //   46: invokevirtual 76	android/content/Context:getCacheDir	()Ljava/io/File;
      //   49: ldc 78
      //   51: invokespecial 81	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   54: invokestatic 87	com/tencent/mm/vfs/e:q	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
      //   57: invokespecial 90	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   60: astore_0
      //   61: aload_0
      //   62: invokevirtual 94	java/io/ObjectInputStream:readLong	()J
      //   65: putstatic 30	com/tencent/mm/jni/a/a$c:mLastReportTime	J
      //   68: aload_0
      //   69: invokevirtual 98	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   72: checkcast 100	java/util/HashMap
      //   75: putstatic 34	com/tencent/mm/jni/a/a$c:eFZ	Ljava/util/HashMap;
      //   78: aload_0
      //   79: invokevirtual 103	java/io/ObjectInputStream:close	()V
      //   82: aload_3
      //   83: monitorexit
      //   84: new 105	android/content/IntentFilter
      //   87: dup
      //   88: invokespecial 106	android/content/IntentFilter:<init>	()V
      //   91: astore_0
      //   92: aload_0
      //   93: ldc 108
      //   95: invokevirtual 112	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   98: aload_0
      //   99: ldc 114
      //   101: invokevirtual 112	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   104: invokestatic 70	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
      //   107: getstatic 38	com/tencent/mm/jni/a/a$c:eGb	Landroid/content/BroadcastReceiver;
      //   110: aload_0
      //   111: ldc 116
      //   113: aconst_null
      //   114: invokevirtual 120	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   117: pop
      //   118: ldc 122
      //   120: ldc 124
      //   122: iconst_1
      //   123: anewarray 4	java/lang/Object
      //   126: dup
      //   127: iconst_0
      //   128: invokestatic 128	com/tencent/mm/sdk/platformtools/ah:getProcessName	()Ljava/lang/String;
      //   131: aastore
      //   132: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   135: ldc 45
      //   137: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   140: return
      //   141: astore_0
      //   142: aconst_null
      //   143: astore_0
      //   144: ldc 122
      //   146: ldc 138
      //   148: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   151: invokestatic 147	android/os/SystemClock:elapsedRealtime	()J
      //   154: putstatic 30	com/tencent/mm/jni/a/a$c:mLastReportTime	J
      //   157: new 100	java/util/HashMap
      //   160: dup
      //   161: invokespecial 148	java/util/HashMap:<init>	()V
      //   164: putstatic 34	com/tencent/mm/jni/a/a$c:eFZ	Ljava/util/HashMap;
      //   167: aload_0
      //   168: ifnull -86 -> 82
      //   171: aload_0
      //   172: invokevirtual 103	java/io/ObjectInputStream:close	()V
      //   175: goto -93 -> 82
      //   178: astore_0
      //   179: goto -97 -> 82
      //   182: astore_1
      //   183: aload_2
      //   184: astore_0
      //   185: aload_0
      //   186: ifnull +7 -> 193
      //   189: aload_0
      //   190: invokevirtual 103	java/io/ObjectInputStream:close	()V
      //   193: ldc 45
      //   195: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   198: aload_1
      //   199: athrow
      //   200: astore_0
      //   201: aload_3
      //   202: monitorexit
      //   203: ldc 45
      //   205: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   208: aload_0
      //   209: athrow
      //   210: astore_0
      //   211: goto -129 -> 82
      //   214: astore_0
      //   215: goto -22 -> 193
      //   218: astore_1
      //   219: goto -34 -> 185
      //   222: astore_1
      //   223: goto -38 -> 185
      //   226: astore_1
      //   227: goto -83 -> 144
      // Local variable table:
      //   start	length	slot	name	signature
      //   60	51	0	localObject1	Object
      //   141	1	0	localException1	java.lang.Exception
      //   143	29	0	localObject2	Object
      //   178	1	0	localException2	java.lang.Exception
      //   184	6	0	localObject3	Object
      //   200	9	0	localObject4	Object
      //   210	1	0	localException3	java.lang.Exception
      //   214	1	0	localException4	java.lang.Exception
      //   182	17	1	localObject5	Object
      //   218	1	1	localObject6	Object
      //   222	1	1	localObject7	Object
      //   226	1	1	localException5	java.lang.Exception
      //   1	183	2	localObject8	Object
      //   32	170	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   35	61	141	java/lang/Exception
      //   171	175	178	java/lang/Exception
      //   35	61	182	finally
      //   78	82	200	finally
      //   82	84	200	finally
      //   171	175	200	finally
      //   189	193	200	finally
      //   193	200	200	finally
      //   201	203	200	finally
      //   78	82	210	java/lang/Exception
      //   189	193	214	java/lang/Exception
      //   61	78	218	finally
      //   144	167	222	finally
      //   61	78	226	java/lang/Exception
    }
    
    private static void Qm()
    {
      AppMethodBeat.i(77198);
      long l;
      for (;;)
      {
        synchronized (eGa)
        {
          l = SystemClock.elapsedRealtime();
          if (l - mLastReportTime < 21600000L) {
            break label293;
          }
          if (eFZ.isEmpty()) {
            break label289;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = eFZ.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).eGf <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).mProcessName).append(',').append(((a)localObject2).eFV.replace(",", "##")).append(',').append(((a)localObject2).eGf).append(',').append(((a)localObject2).eGe).append(',').append(((a)localObject2).eGg).append(',');
          if (((a)localObject2).eGd)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).eGc);
            localObject2 = localStringBuilder.toString();
            localObject3 = new ot();
            ((ot)localObject3).cFr.cFs = ((String)localObject2);
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
            ab.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      eFZ.clear();
      label289:
      mLastReportTime = l;
      label293:
      AppMethodBeat.o(77198);
    }
    
    /* Error */
    private static void Qn()
    {
      // Byte code:
      //   0: ldc_w 268
      //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: getstatic 36	com/tencent/mm/jni/a/a$c:eGa	[B
      //   9: astore_3
      //   10: aload_3
      //   11: monitorenter
      //   12: aconst_null
      //   13: astore_1
      //   14: aconst_null
      //   15: astore_2
      //   16: aload_1
      //   17: astore_0
      //   18: new 64	com/tencent/mm/vfs/b
      //   21: dup
      //   22: invokestatic 70	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
      //   25: invokevirtual 76	android/content/Context:getCacheDir	()Ljava/io/File;
      //   28: ldc_w 270
      //   31: invokespecial 81	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   34: astore 4
      //   36: aload_1
      //   37: astore_0
      //   38: aload 4
      //   40: invokevirtual 274	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
      //   43: invokestatic 280	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
      //   46: invokestatic 284	com/tencent/mm/vfs/e:um	(Ljava/lang/String;)Z
      //   49: ifne +94 -> 143
      //   52: aload_1
      //   53: astore_0
      //   54: new 267	java/io/IOException
      //   57: dup
      //   58: new 158	java/lang/StringBuilder
      //   61: dup
      //   62: ldc_w 286
      //   65: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   68: aload 4
      //   70: invokevirtual 274	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
      //   73: invokestatic 280	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
      //   76: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: ldc_w 290
      //   82: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokespecial 291	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   91: astore 4
      //   93: aload_1
      //   94: astore_0
      //   95: ldc_w 268
      //   98: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   101: aload_1
      //   102: astore_0
      //   103: aload 4
      //   105: athrow
      //   106: astore_0
      //   107: aload_2
      //   108: astore_1
      //   109: aload_0
      //   110: astore_2
      //   111: aload_1
      //   112: astore_0
      //   113: ldc 122
      //   115: aload_2
      //   116: ldc_w 293
      //   119: iconst_0
      //   120: anewarray 4	java/lang/Object
      //   123: invokestatic 297	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   126: aload_1
      //   127: ifnull +7 -> 134
      //   130: aload_1
      //   131: invokevirtual 300	java/io/ObjectOutputStream:close	()V
      //   134: aload_3
      //   135: monitorexit
      //   136: ldc_w 268
      //   139: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: return
      //   143: aload_1
      //   144: astore_0
      //   145: new 299	java/io/ObjectOutputStream
      //   148: dup
      //   149: new 64	com/tencent/mm/vfs/b
      //   152: dup
      //   153: aload 4
      //   155: ldc_w 302
      //   158: invokespecial 305	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
      //   161: invokestatic 309	com/tencent/mm/vfs/e:r	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
      //   164: invokespecial 312	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   167: astore_1
      //   168: aload_1
      //   169: getstatic 30	com/tencent/mm/jni/a/a$c:mLastReportTime	J
      //   172: invokevirtual 316	java/io/ObjectOutputStream:writeLong	(J)V
      //   175: aload_1
      //   176: getstatic 34	com/tencent/mm/jni/a/a$c:eFZ	Ljava/util/HashMap;
      //   179: invokevirtual 320	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   182: aload_1
      //   183: invokevirtual 300	java/io/ObjectOutputStream:close	()V
      //   186: goto -52 -> 134
      //   189: astore_0
      //   190: goto -56 -> 134
      //   193: astore_2
      //   194: aload_0
      //   195: astore_1
      //   196: aload_2
      //   197: astore_0
      //   198: aload_1
      //   199: ifnull +7 -> 206
      //   202: aload_1
      //   203: invokevirtual 300	java/io/ObjectOutputStream:close	()V
      //   206: ldc_w 268
      //   209: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_0
      //   213: athrow
      //   214: astore_0
      //   215: aload_3
      //   216: monitorexit
      //   217: ldc_w 268
      //   220: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   223: aload_0
      //   224: athrow
      //   225: astore_0
      //   226: goto -92 -> 134
      //   229: astore_1
      //   230: goto -24 -> 206
      //   233: astore_0
      //   234: goto -36 -> 198
      //   237: astore_2
      //   238: goto -127 -> 111
      // Local variable table:
      //   start	length	slot	name	signature
      //   17	86	0	localObject1	Object
      //   106	4	0	localIOException1	java.io.IOException
      //   112	33	0	localObject2	Object
      //   189	6	0	localException1	java.lang.Exception
      //   197	16	0	localObject3	Object
      //   214	10	0	localObject4	Object
      //   225	1	0	localException2	java.lang.Exception
      //   233	1	0	localObject5	Object
      //   13	190	1	localObject6	Object
      //   229	1	1	localException3	java.lang.Exception
      //   15	101	2	localObject7	Object
      //   193	4	2	localObject8	Object
      //   237	1	2	localIOException2	java.io.IOException
      //   9	207	3	arrayOfByte	byte[]
      //   34	120	4	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   18	36	106	java/io/IOException
      //   38	52	106	java/io/IOException
      //   54	93	106	java/io/IOException
      //   95	101	106	java/io/IOException
      //   103	106	106	java/io/IOException
      //   145	168	106	java/io/IOException
      //   182	186	189	java/lang/Exception
      //   18	36	193	finally
      //   38	52	193	finally
      //   54	93	193	finally
      //   95	101	193	finally
      //   103	106	193	finally
      //   113	126	193	finally
      //   145	168	193	finally
      //   130	134	214	finally
      //   134	136	214	finally
      //   182	186	214	finally
      //   202	206	214	finally
      //   206	214	214	finally
      //   215	217	214	finally
      //   130	134	225	java/lang/Exception
      //   202	206	229	java/lang/Exception
      //   168	182	233	finally
      //   168	182	237	java/io/IOException
    }
    
    private static void c(String paramString1, String paramString2, long paramLong)
    {
      AppMethodBeat.i(77196);
      String str = paramString1 + "_" + paramString2;
      synchronized (eGa)
      {
        a locala2 = (a)eFZ.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locala1.mProcessName = paramString1;
          locala1.eFV = paramString2;
          locala1.eGg = 0L;
          locala1.eGe = 0;
          locala1.eGf = 0;
          eFZ.put(str, locala1);
        }
        if (locala1.eGi.getAndIncrement() == 0)
        {
          locala1.eGh = paramLong;
          locala1.eGc = at.getNetTypeString(ah.getContext());
          locala1.eGd = com.tencent.mm.sdk.a.b.foreground;
        }
        AppMethodBeat.o(77196);
        return;
      }
    }
    
    private static void d(String arg0, String paramString2, long paramLong)
    {
      AppMethodBeat.i(77197);
      paramString2 = ??? + "_" + paramString2;
      long l2 = 0L;
      synchronized (eGa)
      {
        paramString2 = (a)eFZ.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.eGi.get() > 0)
          {
            paramString2.eGe += 1;
            l1 = l2;
            if (paramString2.eGi.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.eGh;
              paramString2.eGg += l1;
              paramString2.eGf += 1;
            }
          }
        }
        Qm();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - eFY >= 3600000L))
        {
          ab.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          Qn();
          eFY = paramLong;
        }
        AppMethodBeat.o(77197);
        return;
      }
    }
    
    public static void detach()
    {
      AppMethodBeat.i(77192);
      if (eFX > 0)
      {
        ah.getContext().unregisterReceiver(eGb);
        Qn();
        eFX = 0;
        ab.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { ah.getProcessName() });
      }
      AppMethodBeat.o(77192);
    }
    
    public static void mf(String paramString)
    {
      AppMethodBeat.i(77193);
      s(paramString, true);
      AppMethodBeat.o(77193);
    }
    
    public static void mg(String paramString)
    {
      AppMethodBeat.i(77194);
      s(paramString, false);
      AppMethodBeat.o(77194);
    }
    
    private static void s(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(77195);
      int i = Process.myPid();
      String str = ah.getProcessName();
      if (i == eFX)
      {
        if (paramBoolean)
        {
          c(str, paramString, SystemClock.elapsedRealtime());
          AppMethodBeat.o(77195);
          return;
        }
        d(str, paramString, SystemClock.elapsedRealtime());
        AppMethodBeat.o(77195);
        return;
      }
      if (paramBoolean)
      {
        localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
        localIntent.putExtra("pid", i);
        localIntent.putExtra("processName", str);
        localIntent.putExtra("traceMsg", paramString);
        localIntent.putExtra("tick", SystemClock.elapsedRealtime());
        ah.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(77195);
        return;
      }
      Intent localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
      localIntent.putExtra("pid", i);
      localIntent.putExtra("processName", str);
      localIntent.putExtra("traceMsg", paramString);
      localIntent.putExtra("tick", SystemClock.elapsedRealtime());
      ah.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(77195);
    }
    
    static final class a
      implements Externalizable
    {
      public String eFV;
      public String eGc;
      public boolean eGd;
      public int eGe;
      public int eGf;
      public long eGg;
      public long eGh;
      public AtomicInteger eGi;
      public String mProcessName;
      
      private a()
      {
        AppMethodBeat.i(77188);
        this.mProcessName = "";
        this.eFV = "";
        this.eGc = "";
        this.eGd = false;
        this.eGe = 0;
        this.eGf = 0;
        this.eGg = 0L;
        this.eGh = 0L;
        this.eGi = new AtomicInteger(0);
        AppMethodBeat.o(77188);
      }
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        AppMethodBeat.i(77189);
        synchronized (a.c.Io())
        {
          this.mProcessName = paramObjectInput.readUTF();
          this.eFV = paramObjectInput.readUTF();
          this.eGe = paramObjectInput.readInt();
          this.eGf = paramObjectInput.readInt();
          this.eGg = paramObjectInput.readLong();
          this.eGc = "";
          this.eGd = false;
          this.eGh = 0L;
          this.eGi = new AtomicInteger(0);
          AppMethodBeat.o(77189);
          return;
        }
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        AppMethodBeat.i(77190);
        synchronized (a.c.Io())
        {
          paramObjectOutput.writeUTF(this.mProcessName);
          paramObjectOutput.writeUTF(this.eFV);
          paramObjectOutput.writeInt(this.eGe);
          paramObjectOutput.writeInt(this.eGf);
          paramObjectOutput.writeLong(this.eGg);
          AppMethodBeat.o(77190);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.jni.a.a
 * JD-Core Version:    0.7.0.1
 */