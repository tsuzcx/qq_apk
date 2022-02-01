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
import com.tencent.mm.f.a.td;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
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
  private static SparseArray<b> kaA;
  private static MMHandler mHandler;
  private static final byte[] mLock;
  
  static
  {
    AppMethodBeat.i(153439);
    kaA = new SparseArray();
    mHandler = new MMHandler(Looper.getMainLooper());
    mLock = new byte[0];
    AppMethodBeat.o(153439);
  }
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    AppMethodBeat.i(153437);
    synchronized (mLock)
    {
      b localb2 = (b)kaA.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        kaA.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.kaE.containsKey(paramString)) {
        localb1.kaE.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.Mv(paramString);
      paramWakerLock = mHandler;
      if (!localb1.kaC)
      {
        localb1.kaC = true;
        paramWakerLock.postDelayed(localb1.kaD, 60000L);
      }
      AppMethodBeat.o(153437);
      return;
    }
  }
  
  public static void aFT()
  {
    AppMethodBeat.i(153435);
    c.lT();
    AppMethodBeat.o(153435);
  }
  
  public static void aFU()
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
      paramWakerLock = (b)kaA.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label114;
      }
      Object localObject = mHandler;
      if (paramWakerLock.kaC)
      {
        paramWakerLock.kaC = false;
        ((MMHandler)localObject).removeCallbacks(paramWakerLock.kaD);
      }
      localObject = paramWakerLock.kaE.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.Mw(((a.b.a)((Iterator)localObject).next()).kaF);
      }
    }
    paramWakerLock.kaE.clear();
    label114:
    AppMethodBeat.o(153438);
  }
  
  static final class a
    implements Runnable
  {
    private WakerLock kaB = null;
    
    public a(WakerLock paramWakerLock)
    {
      this.kaB = paramWakerLock;
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
        synchronized (a.aFV())
        {
          localObject2 = (a.b)a.aFW().get(this.kaB.hashCode());
          if (localObject2 == null) {
            break label274;
          }
          k = this.kaB.hashCode();
          m = this.kaB.innerWakeLockHashCode();
          String str = this.kaB.getCreatePosStackLine();
          Object localObject3 = ((a.b)localObject2).kaE.values();
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
            if (locala.kaG == 0L) {
              continue;
            }
            ((StringBuilder)localObject2).append('{').append(locala.kaF).append(',').append(SystemClock.elapsedRealtime() - locala.kaG).append('}');
            i = j;
          }
        }
        ((StringBuilder)localObject2).append(',');
        int j = i;
      }
      if (((StringBuilder)localObject2).length() == 0) {
        ((StringBuilder)localObject2).append("<empty>");
      }
      Log.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), localObject1, ((StringBuilder)localObject2).toString() });
      for (;;)
      {
        this.kaB.unLock();
        AppMethodBeat.o(153418);
        return;
        label274:
        Log.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(this.kaB.hashCode()), Integer.valueOf(this.kaB.innerWakeLockHashCode()), this.kaB.getCreatePosStackLine(), "#lost-trace-state#" });
      }
    }
  }
  
  static final class b
  {
    volatile boolean kaC;
    a.a kaD;
    Map<String, a> kaE;
    
    public b(WakerLock paramWakerLock)
    {
      AppMethodBeat.i(153419);
      this.kaC = false;
      this.kaD = null;
      this.kaE = new HashMap();
      this.kaD = new a.a(paramWakerLock);
      AppMethodBeat.o(153419);
    }
    
    static final class a
    {
      public String kaF = null;
      public long kaG = 0L;
      
      public a(String paramString, long paramLong)
      {
        this.kaF = paramString;
        this.kaG = paramLong;
      }
    }
  }
  
  static final class c
  {
    private static int kaH;
    private static long kaI;
    private static long kaJ;
    private static final HashMap<String, a> kaK;
    private static final byte[] kaL;
    private static BroadcastReceiver kaM;
    
    static
    {
      AppMethodBeat.i(183797);
      kaH = 0;
      kaI = 0L;
      kaJ = 0L;
      kaK = new HashMap();
      kaL = new byte[0];
      kaM = null;
      AppMethodBeat.o(183797);
    }
    
    public static void Mv(String paramString)
    {
      AppMethodBeat.i(153426);
      w(paramString, true);
      AppMethodBeat.o(153426);
    }
    
    public static void Mw(String paramString)
    {
      AppMethodBeat.i(153427);
      w(paramString, false);
      AppMethodBeat.o(153427);
    }
    
    private static void aFX()
    {
      AppMethodBeat.i(153431);
      long l;
      for (;;)
      {
        synchronized (kaL)
        {
          l = SystemClock.elapsedRealtime();
          if (l - kaI < 21600000L) {
            break label292;
          }
          if (kaK.isEmpty()) {
            break label288;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = kaK.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).kaQ <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).mProcessName).append(',').append(((a)localObject2).kaF.replace(",", "##")).append(',').append(((a)localObject2).kaQ).append(',').append(((a)localObject2).kaP).append(',').append(((a)localObject2).kaR).append(',');
          if (((a)localObject2).kaO)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).kaN);
            localObject2 = localStringBuilder.toString();
            localObject3 = new td();
            ((td)localObject3).fSx.fSy = ((String)localObject2);
            EventCenter.instance.publish((IEvent)localObject3);
            Log.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      kaK.clear();
      label288:
      kaI = l;
      label292:
      AppMethodBeat.o(153431);
    }
    
    /* Error */
    private static void aFY()
    {
      // Byte code:
      //   0: ldc 198
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 48	com/tencent/mm/jni/a/a$c:kaL	[B
      //   8: astore_3
      //   9: aload_3
      //   10: monitorenter
      //   11: aconst_null
      //   12: astore_1
      //   13: aconst_null
      //   14: astore_2
      //   15: aload_1
      //   16: astore_0
      //   17: new 200	com/tencent/mm/vfs/q
      //   20: dup
      //   21: invokestatic 206	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   24: invokevirtual 212	android/content/Context:getCacheDir	()Ljava/io/File;
      //   27: ldc 214
      //   29: invokespecial 217	com/tencent/mm/vfs/q:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   32: astore 4
      //   34: aload_1
      //   35: astore_0
      //   36: aload 4
      //   38: invokevirtual 220	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   41: invokestatic 226	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
      //   44: ifne +86 -> 130
      //   47: aload_1
      //   48: astore_0
      //   49: new 195	java/io/IOException
      //   52: dup
      //   53: new 79	java/lang/StringBuilder
      //   56: dup
      //   57: ldc 228
      //   59: invokespecial 230	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   62: aload 4
      //   64: invokevirtual 220	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   67: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: ldc 232
      //   72: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   75: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   78: invokespecial 233	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   81: astore 4
      //   83: aload_1
      //   84: astore_0
      //   85: ldc 198
      //   87: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   90: aload_1
      //   91: astore_0
      //   92: aload 4
      //   94: athrow
      //   95: astore_0
      //   96: aload_2
      //   97: astore_1
      //   98: aload_0
      //   99: astore_2
      //   100: aload_1
      //   101: astore_0
      //   102: ldc 181
      //   104: aload_2
      //   105: ldc 235
      //   107: iconst_0
      //   108: anewarray 4	java/lang/Object
      //   111: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   114: aload_1
      //   115: ifnull +7 -> 122
      //   118: aload_1
      //   119: invokevirtual 244	java/io/ObjectOutputStream:close	()V
      //   122: aload_3
      //   123: monitorexit
      //   124: ldc 198
      //   126: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: aload_1
      //   131: astore_0
      //   132: new 241	java/io/ObjectOutputStream
      //   135: dup
      //   136: new 200	com/tencent/mm/vfs/q
      //   139: dup
      //   140: aload 4
      //   142: ldc 246
      //   144: invokespecial 249	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
      //   147: invokestatic 253	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
      //   150: invokespecial 256	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   153: astore_1
      //   154: aload_1
      //   155: getstatic 37	com/tencent/mm/jni/a/a$c:kaI	J
      //   158: invokevirtual 260	java/io/ObjectOutputStream:writeLong	(J)V
      //   161: aload_1
      //   162: getstatic 46	com/tencent/mm/jni/a/a$c:kaK	Ljava/util/HashMap;
      //   165: invokevirtual 264	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   168: aload_1
      //   169: invokevirtual 244	java/io/ObjectOutputStream:close	()V
      //   172: goto -50 -> 122
      //   175: astore_0
      //   176: goto -54 -> 122
      //   179: astore_2
      //   180: aload_0
      //   181: astore_1
      //   182: aload_2
      //   183: astore_0
      //   184: aload_1
      //   185: ifnull +7 -> 192
      //   188: aload_1
      //   189: invokevirtual 244	java/io/ObjectOutputStream:close	()V
      //   192: ldc 198
      //   194: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aload_0
      //   198: athrow
      //   199: astore_0
      //   200: aload_3
      //   201: monitorexit
      //   202: ldc 198
      //   204: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: aload_0
      //   208: athrow
      //   209: astore_0
      //   210: goto -88 -> 122
      //   213: astore_1
      //   214: goto -22 -> 192
      //   217: astore_0
      //   218: goto -34 -> 184
      //   221: astore_2
      //   222: goto -122 -> 100
      // Local variable table:
      //   start	length	slot	name	signature
      //   16	76	0	localObject1	Object
      //   95	4	0	localIOException1	java.io.IOException
      //   101	31	0	localObject2	Object
      //   175	6	0	localException1	java.lang.Exception
      //   183	15	0	localObject3	Object
      //   199	9	0	localObject4	Object
      //   209	1	0	localException2	java.lang.Exception
      //   217	1	0	localObject5	Object
      //   12	177	1	localObject6	Object
      //   213	1	1	localException3	java.lang.Exception
      //   14	91	2	localObject7	Object
      //   179	4	2	localObject8	Object
      //   221	1	2	localIOException2	java.io.IOException
      //   8	193	3	arrayOfByte	byte[]
      //   32	109	4	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   17	34	95	java/io/IOException
      //   36	47	95	java/io/IOException
      //   49	83	95	java/io/IOException
      //   85	90	95	java/io/IOException
      //   92	95	95	java/io/IOException
      //   132	154	95	java/io/IOException
      //   168	172	175	java/lang/Exception
      //   17	34	179	finally
      //   36	47	179	finally
      //   49	83	179	finally
      //   85	90	179	finally
      //   92	95	179	finally
      //   102	114	179	finally
      //   132	154	179	finally
      //   118	122	199	finally
      //   122	124	199	finally
      //   168	172	199	finally
      //   188	192	199	finally
      //   192	199	199	finally
      //   118	122	209	java/lang/Exception
      //   188	192	213	java/lang/Exception
      //   154	168	217	finally
      //   154	168	221	java/io/IOException
    }
    
    private static void c(String paramString1, String paramString2, long paramLong)
    {
      AppMethodBeat.i(153429);
      String str = paramString1 + "_" + paramString2;
      synchronized (kaL)
      {
        a locala2 = (a)kaK.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locala1.mProcessName = paramString1;
          locala1.kaF = paramString2;
          locala1.kaR = 0L;
          locala1.kaP = 0;
          locala1.kaQ = 0;
          kaK.put(str, locala1);
        }
        if (locala1.kaT.getAndIncrement() == 0)
        {
          locala1.kaS = paramLong;
          locala1.kaN = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
          locala1.kaO = CrashReportFactory.foreground;
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
      synchronized (kaL)
      {
        paramString2 = (a)kaK.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.kaT.get() > 0)
          {
            paramString2.kaP += 1;
            l1 = l2;
            if (paramString2.kaT.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.kaS;
              paramString2.kaR += l1;
              paramString2.kaQ += 1;
            }
          }
        }
        aFX();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - kaJ >= 3600000L))
        {
          Log.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          aFY();
          kaJ = paramLong;
        }
        AppMethodBeat.o(153430);
        return;
      }
    }
    
    public static void detach()
    {
      AppMethodBeat.i(153425);
      if (kaH > 0)
      {
        MMApplicationContext.getContext().unregisterReceiver(kaM);
        aFY();
        kaH = 0;
        Log.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { MMApplicationContext.getProcessName() });
      }
      AppMethodBeat.o(153425);
    }
    
    /* Error */
    public static void lT()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: ldc_w 349
      //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 35	com/tencent/mm/jni/a/a$c:kaH	I
      //   11: ifne +232 -> 243
      //   14: invokestatic 354	android/os/Process:myPid	()I
      //   17: putstatic 35	com/tencent/mm/jni/a/a$c:kaH	I
      //   20: new 9	com/tencent/mm/jni/a/a$c$1
      //   23: dup
      //   24: invokespecial 355	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   27: putstatic 50	com/tencent/mm/jni/a/a$c:kaM	Landroid/content/BroadcastReceiver;
      //   30: getstatic 48	com/tencent/mm/jni/a/a$c:kaL	[B
      //   33: astore_3
      //   34: aload_3
      //   35: monitorenter
      //   36: new 357	java/io/ObjectInputStream
      //   39: dup
      //   40: new 200	com/tencent/mm/vfs/q
      //   43: dup
      //   44: invokestatic 206	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   47: invokevirtual 212	android/content/Context:getCacheDir	()Ljava/io/File;
      //   50: ldc_w 359
      //   53: invokespecial 217	com/tencent/mm/vfs/q:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   56: invokestatic 363	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
      //   59: invokespecial 366	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   62: astore_0
      //   63: aload_0
      //   64: invokevirtual 369	java/io/ObjectInputStream:readLong	()J
      //   67: putstatic 37	com/tencent/mm/jni/a/a$c:kaI	J
      //   70: aload_0
      //   71: invokevirtual 372	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   74: checkcast 41	java/util/HashMap
      //   77: astore_1
      //   78: aload_1
      //   79: ifnull +10 -> 89
      //   82: getstatic 46	com/tencent/mm/jni/a/a$c:kaK	Ljava/util/HashMap;
      //   85: aload_1
      //   86: invokevirtual 376	java/util/HashMap:putAll	(Ljava/util/Map;)V
      //   89: aload_0
      //   90: invokevirtual 377	java/io/ObjectInputStream:close	()V
      //   93: aload_3
      //   94: monitorexit
      //   95: new 379	android/content/IntentFilter
      //   98: dup
      //   99: invokespecial 380	android/content/IntentFilter:<init>	()V
      //   102: astore_0
      //   103: aload_0
      //   104: ldc_w 382
      //   107: invokevirtual 385	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   110: aload_0
      //   111: ldc_w 387
      //   114: invokevirtual 385	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   117: invokestatic 206	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   120: getstatic 50	com/tencent/mm/jni/a/a$c:kaM	Landroid/content/BroadcastReceiver;
      //   123: aload_0
      //   124: invokestatic 392	com/tencent/mm/sdk/platformtools/WeChatPermissions:PERMISSION_MM_MESSAGE	()Ljava/lang/String;
      //   127: aconst_null
      //   128: invokevirtual 396	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   131: pop
      //   132: ldc 181
      //   134: ldc_w 398
      //   137: iconst_1
      //   138: anewarray 4	java/lang/Object
      //   141: dup
      //   142: iconst_0
      //   143: invokestatic 335	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
      //   146: aastore
      //   147: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: ldc_w 349
      //   153: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: return
      //   157: astore_0
      //   158: aload_1
      //   159: astore_0
      //   160: ldc 181
      //   162: ldc_w 400
      //   165: invokestatic 402	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   168: invokestatic 71	android/os/SystemClock:elapsedRealtime	()J
      //   171: putstatic 37	com/tencent/mm/jni/a/a$c:kaI	J
      //   174: getstatic 46	com/tencent/mm/jni/a/a$c:kaK	Ljava/util/HashMap;
      //   177: invokevirtual 192	java/util/HashMap:clear	()V
      //   180: aload_0
      //   181: ifnull -88 -> 93
      //   184: aload_0
      //   185: invokevirtual 377	java/io/ObjectInputStream:close	()V
      //   188: goto -95 -> 93
      //   191: astore_0
      //   192: goto -99 -> 93
      //   195: astore_0
      //   196: aconst_null
      //   197: astore_1
      //   198: aload_1
      //   199: ifnull +7 -> 206
      //   202: aload_1
      //   203: invokevirtual 377	java/io/ObjectInputStream:close	()V
      //   206: ldc_w 349
      //   209: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_0
      //   213: athrow
      //   214: astore_0
      //   215: aload_3
      //   216: monitorexit
      //   217: ldc_w 349
      //   220: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   223: aload_0
      //   224: athrow
      //   225: astore_0
      //   226: ldc 181
      //   228: aload_0
      //   229: ldc_w 404
      //   232: iconst_0
      //   233: anewarray 4	java/lang/Object
      //   236: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   239: iconst_0
      //   240: putstatic 35	com/tencent/mm/jni/a/a$c:kaH	I
      //   243: ldc_w 349
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
      //   95	150	225	java/lang/Throwable
      //   89	93	250	java/lang/Exception
      //   202	206	254	java/lang/Exception
      //   63	78	258	finally
      //   82	89	258	finally
      //   160	180	268	finally
      //   63	78	278	java/lang/Throwable
      //   82	89	278	java/lang/Throwable
    }
    
    private static void w(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(153428);
      int i = Process.myPid();
      String str = MMApplicationContext.getProcessName();
      if (i == kaH)
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
        MMApplicationContext.getContext().sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
        AppMethodBeat.o(153428);
        return;
      }
      Intent localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
      localIntent.putExtra("pid", i);
      localIntent.putExtra("processName", str);
      localIntent.putExtra("traceMsg", paramString);
      localIntent.putExtra("tick", SystemClock.elapsedRealtime());
      MMApplicationContext.getContext().sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
      AppMethodBeat.o(153428);
    }
    
    static final class a
      implements Externalizable
    {
      public String kaF;
      public String kaN;
      public boolean kaO;
      public int kaP;
      public int kaQ;
      public long kaR;
      public long kaS;
      public AtomicInteger kaT;
      public String mProcessName;
      
      private a()
      {
        AppMethodBeat.i(153421);
        this.mProcessName = "";
        this.kaF = "";
        this.kaN = "";
        this.kaO = false;
        this.kaP = 0;
        this.kaQ = 0;
        this.kaR = 0L;
        this.kaS = 0L;
        this.kaT = new AtomicInteger(0);
        AppMethodBeat.o(153421);
      }
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        AppMethodBeat.i(153422);
        synchronized (a.c.aFZ())
        {
          this.mProcessName = paramObjectInput.readUTF();
          this.kaF = paramObjectInput.readUTF();
          this.kaP = paramObjectInput.readInt();
          this.kaQ = paramObjectInput.readInt();
          this.kaR = paramObjectInput.readLong();
          this.kaN = "";
          this.kaO = false;
          this.kaS = 0L;
          this.kaT = new AtomicInteger(0);
          AppMethodBeat.o(153422);
          return;
        }
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        AppMethodBeat.i(153423);
        synchronized (a.c.aFZ())
        {
          paramObjectOutput.writeUTF(this.mProcessName);
          paramObjectOutput.writeUTF(this.kaF);
          paramObjectOutput.writeInt(this.kaP);
          paramObjectOutput.writeInt(this.kaQ);
          paramObjectOutput.writeLong(this.kaR);
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