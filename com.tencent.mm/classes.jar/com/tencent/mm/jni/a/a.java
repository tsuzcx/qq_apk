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
import com.tencent.mm.g.a.qu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static SparseArray<b> gfD;
  private static ao mHandler;
  private static final byte[] mLock;
  
  static
  {
    AppMethodBeat.i(153439);
    gfD = new SparseArray();
    mHandler = new ao(Looper.getMainLooper());
    mLock = new byte[0];
    AppMethodBeat.o(153439);
  }
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    AppMethodBeat.i(153437);
    synchronized (mLock)
    {
      b localb2 = (b)gfD.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        gfD.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.gfH.containsKey(paramString)) {
        localb1.gfH.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.tK(paramString);
      paramWakerLock = mHandler;
      if (!localb1.gfF)
      {
        localb1.gfF = true;
        paramWakerLock.postDelayed(localb1.gfG, 60000L);
      }
      AppMethodBeat.o(153437);
      return;
    }
  }
  
  public static void afj()
  {
    AppMethodBeat.i(153435);
    c.lm();
    AppMethodBeat.o(153435);
  }
  
  public static void afk()
  {
    AppMethodBeat.i(153436);
    c.detach();
    AppMethodBeat.o(153436);
  }
  
  public static void c(WakerLock paramWakerLock)
  {
    AppMethodBeat.i(153438);
    synchronized (mLock)
    {
      paramWakerLock = (b)gfD.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label114;
      }
      Object localObject = mHandler;
      if (paramWakerLock.gfF)
      {
        paramWakerLock.gfF = false;
        ((ao)localObject).removeCallbacks(paramWakerLock.gfG);
      }
      localObject = paramWakerLock.gfH.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.tL(((a.b.a)((Iterator)localObject).next()).gfI);
      }
    }
    paramWakerLock.gfH.clear();
    label114:
    AppMethodBeat.o(153438);
  }
  
  static final class a
    implements Runnable
  {
    private WakerLock gfE = null;
    
    public a(WakerLock paramWakerLock)
    {
      this.gfE = paramWakerLock;
    }
    
    public final void run()
    {
      AppMethodBeat.i(153418);
      Object localObject2;
      int k;
      int m;
      for (;;)
      {
        int i;
        synchronized (a.afl())
        {
          localObject2 = (a.b)a.afm().get(this.gfE.hashCode());
          if (localObject2 == null) {
            break label274;
          }
          k = this.gfE.hashCode();
          m = this.gfE.innerWakeLockHashCode();
          String str = this.gfE.getCreatePosStackLine();
          Object localObject3 = ((a.b)localObject2).gfH.values();
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
            if (locala.gfJ == 0L) {
              continue;
            }
            ((StringBuilder)localObject2).append('{').append(locala.gfI).append(',').append(SystemClock.elapsedRealtime() - locala.gfJ).append('}');
            i = j;
          }
        }
        ((StringBuilder)localObject2).append(',');
        int j = i;
      }
      if (((StringBuilder)localObject2).length() == 0) {
        ((StringBuilder)localObject2).append("<empty>");
      }
      ac.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), localObject1, ((StringBuilder)localObject2).toString() });
      for (;;)
      {
        this.gfE.unLock();
        AppMethodBeat.o(153418);
        return;
        label274:
        ac.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(this.gfE.hashCode()), Integer.valueOf(this.gfE.innerWakeLockHashCode()), this.gfE.getCreatePosStackLine(), "#lost-trace-state#" });
      }
    }
  }
  
  static final class b
  {
    volatile boolean gfF;
    a.a gfG;
    Map<String, a> gfH;
    
    public b(WakerLock paramWakerLock)
    {
      AppMethodBeat.i(153419);
      this.gfF = false;
      this.gfG = null;
      this.gfH = new HashMap();
      this.gfG = new a.a(paramWakerLock);
      AppMethodBeat.o(153419);
    }
    
    static final class a
    {
      public String gfI = null;
      public long gfJ = 0L;
      
      public a(String paramString, long paramLong)
      {
        this.gfI = paramString;
        this.gfJ = paramLong;
      }
    }
  }
  
  static final class c
  {
    private static int gfK;
    private static long gfL;
    private static long gfM;
    private static final HashMap<String, a> gfN;
    private static final byte[] gfO;
    private static BroadcastReceiver gfP;
    
    static
    {
      AppMethodBeat.i(183797);
      gfK = 0;
      gfL = 0L;
      gfM = 0L;
      gfN = new HashMap();
      gfO = new byte[0];
      gfP = null;
      AppMethodBeat.o(183797);
    }
    
    private static void afn()
    {
      AppMethodBeat.i(153431);
      long l;
      for (;;)
      {
        synchronized (gfO)
        {
          l = SystemClock.elapsedRealtime();
          if (l - gfL < 21600000L) {
            break label292;
          }
          if (gfN.isEmpty()) {
            break label288;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = gfN.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).gfT <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).mProcessName).append(',').append(((a)localObject2).gfI.replace(",", "##")).append(',').append(((a)localObject2).gfT).append(',').append(((a)localObject2).gfS).append(',').append(((a)localObject2).gfU).append(',');
          if (((a)localObject2).gfR)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).gfQ);
            localObject2 = localStringBuilder.toString();
            localObject3 = new qu();
            ((qu)localObject3).dtO.dtP = ((String)localObject2);
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
            ac.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      gfN.clear();
      label288:
      gfL = l;
      label292:
      AppMethodBeat.o(153431);
    }
    
    /* Error */
    private static void afo()
    {
      // Byte code:
      //   0: ldc 189
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 48	com/tencent/mm/jni/a/a$c:gfO	[B
      //   8: astore_3
      //   9: aload_3
      //   10: monitorenter
      //   11: aconst_null
      //   12: astore_1
      //   13: aconst_null
      //   14: astore_2
      //   15: aload_1
      //   16: astore_0
      //   17: new 191	com/tencent/mm/vfs/e
      //   20: dup
      //   21: invokestatic 197	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
      //   24: invokevirtual 203	android/content/Context:getCacheDir	()Ljava/io/File;
      //   27: ldc 205
      //   29: invokespecial 208	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   32: astore 4
      //   34: aload_1
      //   35: astore_0
      //   36: aload 4
      //   38: invokevirtual 212	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
      //   41: invokestatic 218	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   44: invokestatic 224	com/tencent/mm/vfs/i:aSh	(Ljava/lang/String;)Z
      //   47: ifne +89 -> 136
      //   50: aload_1
      //   51: astore_0
      //   52: new 186	java/io/IOException
      //   55: dup
      //   56: new 70	java/lang/StringBuilder
      //   59: dup
      //   60: ldc 226
      //   62: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload 4
      //   67: invokevirtual 212	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
      //   70: invokestatic 218	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   73: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: ldc 231
      //   78: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   84: invokespecial 232	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   87: astore 4
      //   89: aload_1
      //   90: astore_0
      //   91: ldc 189
      //   93: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aload_1
      //   97: astore_0
      //   98: aload 4
      //   100: athrow
      //   101: astore_0
      //   102: aload_2
      //   103: astore_1
      //   104: aload_0
      //   105: astore_2
      //   106: aload_1
      //   107: astore_0
      //   108: ldc 172
      //   110: aload_2
      //   111: ldc 234
      //   113: iconst_0
      //   114: anewarray 4	java/lang/Object
      //   117: invokestatic 238	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aload_1
      //   121: ifnull +7 -> 128
      //   124: aload_1
      //   125: invokevirtual 243	java/io/ObjectOutputStream:close	()V
      //   128: aload_3
      //   129: monitorexit
      //   130: ldc 189
      //   132: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   135: return
      //   136: aload_1
      //   137: astore_0
      //   138: new 240	java/io/ObjectOutputStream
      //   141: dup
      //   142: new 191	com/tencent/mm/vfs/e
      //   145: dup
      //   146: aload 4
      //   148: ldc 245
      //   150: invokespecial 248	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
      //   153: invokestatic 252	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
      //   156: invokespecial 255	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   159: astore_1
      //   160: aload_1
      //   161: getstatic 37	com/tencent/mm/jni/a/a$c:gfL	J
      //   164: invokevirtual 259	java/io/ObjectOutputStream:writeLong	(J)V
      //   167: aload_1
      //   168: getstatic 46	com/tencent/mm/jni/a/a$c:gfN	Ljava/util/HashMap;
      //   171: invokevirtual 263	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   174: aload_1
      //   175: invokevirtual 243	java/io/ObjectOutputStream:close	()V
      //   178: goto -50 -> 128
      //   181: astore_0
      //   182: goto -54 -> 128
      //   185: astore_2
      //   186: aload_0
      //   187: astore_1
      //   188: aload_2
      //   189: astore_0
      //   190: aload_1
      //   191: ifnull +7 -> 198
      //   194: aload_1
      //   195: invokevirtual 243	java/io/ObjectOutputStream:close	()V
      //   198: ldc 189
      //   200: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   203: aload_0
      //   204: athrow
      //   205: astore_0
      //   206: aload_3
      //   207: monitorexit
      //   208: ldc 189
      //   210: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   213: aload_0
      //   214: athrow
      //   215: astore_0
      //   216: goto -88 -> 128
      //   219: astore_1
      //   220: goto -22 -> 198
      //   223: astore_0
      //   224: goto -34 -> 190
      //   227: astore_2
      //   228: goto -122 -> 106
      // Local variable table:
      //   start	length	slot	name	signature
      //   16	82	0	localObject1	Object
      //   101	4	0	localIOException1	java.io.IOException
      //   107	31	0	localObject2	Object
      //   181	6	0	localException1	java.lang.Exception
      //   189	15	0	localObject3	Object
      //   205	9	0	localObject4	Object
      //   215	1	0	localException2	java.lang.Exception
      //   223	1	0	localObject5	Object
      //   12	183	1	localObject6	Object
      //   219	1	1	localException3	java.lang.Exception
      //   14	97	2	localObject7	Object
      //   185	4	2	localObject8	Object
      //   227	1	2	localIOException2	java.io.IOException
      //   8	199	3	arrayOfByte	byte[]
      //   32	115	4	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   17	34	101	java/io/IOException
      //   36	50	101	java/io/IOException
      //   52	89	101	java/io/IOException
      //   91	96	101	java/io/IOException
      //   98	101	101	java/io/IOException
      //   138	160	101	java/io/IOException
      //   174	178	181	java/lang/Exception
      //   17	34	185	finally
      //   36	50	185	finally
      //   52	89	185	finally
      //   91	96	185	finally
      //   98	101	185	finally
      //   108	120	185	finally
      //   138	160	185	finally
      //   124	128	205	finally
      //   128	130	205	finally
      //   174	178	205	finally
      //   194	198	205	finally
      //   198	205	205	finally
      //   206	208	205	finally
      //   124	128	215	java/lang/Exception
      //   194	198	219	java/lang/Exception
      //   160	174	223	finally
      //   160	174	227	java/io/IOException
    }
    
    private static void c(String paramString1, String paramString2, long paramLong)
    {
      AppMethodBeat.i(153429);
      String str = paramString1 + "_" + paramString2;
      synchronized (gfO)
      {
        a locala2 = (a)gfN.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locala1.mProcessName = paramString1;
          locala1.gfI = paramString2;
          locala1.gfU = 0L;
          locala1.gfS = 0;
          locala1.gfT = 0;
          gfN.put(str, locala1);
        }
        if (locala1.gfW.getAndIncrement() == 0)
        {
          locala1.gfV = paramLong;
          locala1.gfQ = ax.getNetTypeString(ai.getContext());
          locala1.gfR = com.tencent.mm.sdk.a.b.foreground;
        }
        AppMethodBeat.o(153429);
        return;
      }
    }
    
    private static void d(String arg0, String paramString2, long paramLong)
    {
      AppMethodBeat.i(153430);
      paramString2 = ??? + "_" + paramString2;
      long l2 = 0L;
      synchronized (gfO)
      {
        paramString2 = (a)gfN.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.gfW.get() > 0)
          {
            paramString2.gfS += 1;
            l1 = l2;
            if (paramString2.gfW.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.gfV;
              paramString2.gfU += l1;
              paramString2.gfT += 1;
            }
          }
        }
        afn();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - gfM >= 3600000L))
        {
          ac.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          afo();
          gfM = paramLong;
        }
        AppMethodBeat.o(153430);
        return;
      }
    }
    
    public static void detach()
    {
      AppMethodBeat.i(153425);
      if (gfK > 0)
      {
        ai.getContext().unregisterReceiver(gfP);
        afo();
        gfK = 0;
        ac.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { ai.getProcessName() });
      }
      AppMethodBeat.o(153425);
    }
    
    /* Error */
    public static void lm()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: ldc_w 348
      //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 35	com/tencent/mm/jni/a/a$c:gfK	I
      //   11: ifne +232 -> 243
      //   14: invokestatic 353	android/os/Process:myPid	()I
      //   17: putstatic 35	com/tencent/mm/jni/a/a$c:gfK	I
      //   20: new 9	com/tencent/mm/jni/a/a$c$1
      //   23: dup
      //   24: invokespecial 354	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   27: putstatic 50	com/tencent/mm/jni/a/a$c:gfP	Landroid/content/BroadcastReceiver;
      //   30: getstatic 48	com/tencent/mm/jni/a/a$c:gfO	[B
      //   33: astore_3
      //   34: aload_3
      //   35: monitorenter
      //   36: new 356	java/io/ObjectInputStream
      //   39: dup
      //   40: new 191	com/tencent/mm/vfs/e
      //   43: dup
      //   44: invokestatic 197	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
      //   47: invokevirtual 203	android/content/Context:getCacheDir	()Ljava/io/File;
      //   50: ldc_w 358
      //   53: invokespecial 208	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   56: invokestatic 362	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
      //   59: invokespecial 365	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   62: astore_0
      //   63: aload_0
      //   64: invokevirtual 368	java/io/ObjectInputStream:readLong	()J
      //   67: putstatic 37	com/tencent/mm/jni/a/a$c:gfL	J
      //   70: aload_0
      //   71: invokevirtual 371	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   74: checkcast 41	java/util/HashMap
      //   77: astore_1
      //   78: aload_1
      //   79: ifnull +10 -> 89
      //   82: getstatic 46	com/tencent/mm/jni/a/a$c:gfN	Ljava/util/HashMap;
      //   85: aload_1
      //   86: invokevirtual 375	java/util/HashMap:putAll	(Ljava/util/Map;)V
      //   89: aload_0
      //   90: invokevirtual 376	java/io/ObjectInputStream:close	()V
      //   93: aload_3
      //   94: monitorexit
      //   95: new 378	android/content/IntentFilter
      //   98: dup
      //   99: invokespecial 379	android/content/IntentFilter:<init>	()V
      //   102: astore_0
      //   103: aload_0
      //   104: ldc_w 381
      //   107: invokevirtual 384	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   110: aload_0
      //   111: ldc_w 386
      //   114: invokevirtual 384	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   117: invokestatic 197	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
      //   120: getstatic 50	com/tencent/mm/jni/a/a$c:gfP	Landroid/content/BroadcastReceiver;
      //   123: aload_0
      //   124: ldc_w 388
      //   127: aconst_null
      //   128: invokevirtual 392	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   131: pop
      //   132: ldc 172
      //   134: ldc_w 394
      //   137: iconst_1
      //   138: anewarray 4	java/lang/Object
      //   141: dup
      //   142: iconst_0
      //   143: invokestatic 334	com/tencent/mm/sdk/platformtools/ai:getProcessName	()Ljava/lang/String;
      //   146: aastore
      //   147: invokestatic 336	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: ldc_w 348
      //   153: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: return
      //   157: astore_0
      //   158: aload_1
      //   159: astore_0
      //   160: ldc 172
      //   162: ldc_w 396
      //   165: invokestatic 398	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   168: invokestatic 62	android/os/SystemClock:elapsedRealtime	()J
      //   171: putstatic 37	com/tencent/mm/jni/a/a$c:gfL	J
      //   174: getstatic 46	com/tencent/mm/jni/a/a$c:gfN	Ljava/util/HashMap;
      //   177: invokevirtual 183	java/util/HashMap:clear	()V
      //   180: aload_0
      //   181: ifnull -88 -> 93
      //   184: aload_0
      //   185: invokevirtual 376	java/io/ObjectInputStream:close	()V
      //   188: goto -95 -> 93
      //   191: astore_0
      //   192: goto -99 -> 93
      //   195: astore_0
      //   196: aconst_null
      //   197: astore_1
      //   198: aload_1
      //   199: ifnull +7 -> 206
      //   202: aload_1
      //   203: invokevirtual 376	java/io/ObjectInputStream:close	()V
      //   206: ldc_w 348
      //   209: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_0
      //   213: athrow
      //   214: astore_0
      //   215: aload_3
      //   216: monitorexit
      //   217: ldc_w 348
      //   220: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   223: aload_0
      //   224: athrow
      //   225: astore_0
      //   226: ldc 172
      //   228: aload_0
      //   229: ldc_w 400
      //   232: iconst_0
      //   233: anewarray 4	java/lang/Object
      //   236: invokestatic 238	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   239: iconst_0
      //   240: putstatic 35	com/tencent/mm/jni/a/a$c:gfK	I
      //   243: ldc_w 348
      //   246: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   249: return
      //   250: astore_0
      //   251: goto -158 -> 93
      //   254: astore_1
      //   255: goto -49 -> 206
      //   258: astore_1
      //   259: aload_0
      //   260: astore_2
      //   261: aload_1
      //   262: astore_0
      //   263: aload_2
      //   264: astore_1
      //   265: goto -67 -> 198
      //   268: astore_1
      //   269: aload_0
      //   270: astore_2
      //   271: aload_1
      //   272: astore_0
      //   273: aload_2
      //   274: astore_1
      //   275: goto -77 -> 198
      //   278: astore_1
      //   279: goto -119 -> 160
      // Local variable table:
      //   start	length	slot	name	signature
      //   62	62	0	localObject1	Object
      //   157	1	0	localThrowable1	java.lang.Throwable
      //   159	26	0	localHashMap1	HashMap
      //   191	1	0	localException1	java.lang.Exception
      //   195	18	0	localObject2	Object
      //   214	10	0	localObject3	Object
      //   225	4	0	localThrowable2	java.lang.Throwable
      //   250	10	0	localException2	java.lang.Exception
      //   262	11	0	localObject4	Object
      //   1	202	1	localHashMap2	HashMap
      //   254	1	1	localException3	java.lang.Exception
      //   258	4	1	localObject5	Object
      //   264	1	1	localObject6	Object
      //   268	4	1	localObject7	Object
      //   274	1	1	localObject8	Object
      //   278	1	1	localThrowable3	java.lang.Throwable
      //   260	14	2	localObject9	Object
      //   33	183	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   36	63	157	java/lang/Throwable
      //   184	188	191	java/lang/Exception
      //   36	63	195	finally
      //   89	93	214	finally
      //   93	95	214	finally
      //   184	188	214	finally
      //   202	206	214	finally
      //   206	214	214	finally
      //   215	217	214	finally
      //   95	150	225	java/lang/Throwable
      //   89	93	250	java/lang/Exception
      //   202	206	254	java/lang/Exception
      //   63	78	258	finally
      //   82	89	258	finally
      //   160	180	268	finally
      //   63	78	278	java/lang/Throwable
      //   82	89	278	java/lang/Throwable
    }
    
    private static void t(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(153428);
      int i = Process.myPid();
      String str = ai.getProcessName();
      if (i == gfK)
      {
        if (paramBoolean)
        {
          c(str, paramString, SystemClock.elapsedRealtime());
          AppMethodBeat.o(153428);
          return;
        }
        d(str, paramString, SystemClock.elapsedRealtime());
        AppMethodBeat.o(153428);
        return;
      }
      if (paramBoolean)
      {
        localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
        localIntent.putExtra("pid", i);
        localIntent.putExtra("processName", str);
        localIntent.putExtra("traceMsg", paramString);
        localIntent.putExtra("tick", SystemClock.elapsedRealtime());
        ai.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(153428);
        return;
      }
      Intent localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
      localIntent.putExtra("pid", i);
      localIntent.putExtra("processName", str);
      localIntent.putExtra("traceMsg", paramString);
      localIntent.putExtra("tick", SystemClock.elapsedRealtime());
      ai.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
      AppMethodBeat.o(153428);
    }
    
    public static void tK(String paramString)
    {
      AppMethodBeat.i(153426);
      t(paramString, true);
      AppMethodBeat.o(153426);
    }
    
    public static void tL(String paramString)
    {
      AppMethodBeat.i(153427);
      t(paramString, false);
      AppMethodBeat.o(153427);
    }
    
    static final class a
      implements Externalizable
    {
      public String gfI;
      public String gfQ;
      public boolean gfR;
      public int gfS;
      public int gfT;
      public long gfU;
      public long gfV;
      public AtomicInteger gfW;
      public String mProcessName;
      
      private a()
      {
        AppMethodBeat.i(153421);
        this.mProcessName = "";
        this.gfI = "";
        this.gfQ = "";
        this.gfR = false;
        this.gfS = 0;
        this.gfT = 0;
        this.gfU = 0L;
        this.gfV = 0L;
        this.gfW = new AtomicInteger(0);
        AppMethodBeat.o(153421);
      }
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        AppMethodBeat.i(153422);
        synchronized (a.c.afp())
        {
          this.mProcessName = paramObjectInput.readUTF();
          this.gfI = paramObjectInput.readUTF();
          this.gfS = paramObjectInput.readInt();
          this.gfT = paramObjectInput.readInt();
          this.gfU = paramObjectInput.readLong();
          this.gfQ = "";
          this.gfR = false;
          this.gfV = 0L;
          this.gfW = new AtomicInteger(0);
          AppMethodBeat.o(153422);
          return;
        }
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        AppMethodBeat.i(153423);
        synchronized (a.c.afp())
        {
          paramObjectOutput.writeUTF(this.mProcessName);
          paramObjectOutput.writeUTF(this.gfI);
          paramObjectOutput.writeInt(this.gfS);
          paramObjectOutput.writeInt(this.gfT);
          paramObjectOutput.writeLong(this.gfU);
          AppMethodBeat.o(153423);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.jni.a.a
 * JD-Core Version:    0.7.0.1
 */