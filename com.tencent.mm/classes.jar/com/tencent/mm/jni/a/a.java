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
import com.tencent.mm.autogen.a.us;
import com.tencent.mm.sdk.crash.CrashReportFactory;
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
  private static SparseArray<b> mAE;
  private static MMHandler mHandler;
  private static final byte[] mLock;
  
  static
  {
    AppMethodBeat.i(153439);
    mAE = new SparseArray();
    mHandler = new MMHandler(Looper.getMainLooper());
    mLock = new byte[0];
    AppMethodBeat.o(153439);
  }
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    AppMethodBeat.i(153437);
    synchronized (mLock)
    {
      b localb2 = (b)mAE.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        mAE.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.mAI.containsKey(paramString)) {
        localb1.mAI.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.Fe(paramString);
      paramWakerLock = mHandler;
      if (!localb1.mAG)
      {
        localb1.mAG = true;
        paramWakerLock.postDelayed(localb1.mAH, 60000L);
      }
      AppMethodBeat.o(153437);
      return;
    }
  }
  
  public static void aYT()
  {
    AppMethodBeat.i(153435);
    c.vX();
    AppMethodBeat.o(153435);
  }
  
  public static void aYU()
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
      paramWakerLock = (b)mAE.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label114;
      }
      Object localObject = mHandler;
      if (paramWakerLock.mAG)
      {
        paramWakerLock.mAG = false;
        ((MMHandler)localObject).removeCallbacks(paramWakerLock.mAH);
      }
      localObject = paramWakerLock.mAI.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.Ff(((a.b.a)((Iterator)localObject).next()).mAJ);
      }
    }
    paramWakerLock.mAI.clear();
    label114:
    AppMethodBeat.o(153438);
  }
  
  static final class a
    implements Runnable
  {
    private WakerLock mAF = null;
    
    public a(WakerLock paramWakerLock)
    {
      this.mAF = paramWakerLock;
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
        synchronized (a.aCv())
        {
          localObject2 = (a.b)a.aYV().get(this.mAF.hashCode());
          if (localObject2 == null) {
            break label274;
          }
          k = this.mAF.hashCode();
          m = this.mAF.innerWakeLockHashCode();
          String str = this.mAF.getCreatePosStackLine();
          Object localObject3 = ((a.b)localObject2).mAI.values();
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
            if (locala.mAK == 0L) {
              continue;
            }
            ((StringBuilder)localObject2).append('{').append(locala.mAJ).append(',').append(SystemClock.elapsedRealtime() - locala.mAK).append('}');
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
        this.mAF.unLock();
        AppMethodBeat.o(153418);
        return;
        label274:
        Log.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(this.mAF.hashCode()), Integer.valueOf(this.mAF.innerWakeLockHashCode()), this.mAF.getCreatePosStackLine(), "#lost-trace-state#" });
      }
    }
  }
  
  static final class b
  {
    volatile boolean mAG;
    a.a mAH;
    Map<String, a> mAI;
    
    public b(WakerLock paramWakerLock)
    {
      AppMethodBeat.i(153419);
      this.mAG = false;
      this.mAH = null;
      this.mAI = new HashMap();
      this.mAH = new a.a(paramWakerLock);
      AppMethodBeat.o(153419);
    }
    
    static final class a
    {
      public String mAJ = null;
      public long mAK = 0L;
      
      public a(String paramString, long paramLong)
      {
        this.mAJ = paramString;
        this.mAK = paramLong;
      }
    }
  }
  
  static final class c
  {
    private static int mAL;
    private static long mAM;
    private static long mAN;
    private static final HashMap<String, a> mAO;
    private static final byte[] mAP;
    private static BroadcastReceiver mAQ;
    
    static
    {
      AppMethodBeat.i(183797);
      mAL = 0;
      mAM = 0L;
      mAN = 0L;
      mAO = new HashMap();
      mAP = new byte[0];
      mAQ = null;
      AppMethodBeat.o(183797);
    }
    
    public static void Fe(String paramString)
    {
      AppMethodBeat.i(153426);
      y(paramString, true);
      AppMethodBeat.o(153426);
    }
    
    public static void Ff(String paramString)
    {
      AppMethodBeat.i(153427);
      y(paramString, false);
      AppMethodBeat.o(153427);
    }
    
    private static void aYW()
    {
      AppMethodBeat.i(153431);
      long l;
      for (;;)
      {
        synchronized (mAP)
        {
          l = SystemClock.elapsedRealtime();
          if (l - mAM < 21600000L) {
            break label289;
          }
          if (mAO.isEmpty()) {
            break label285;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = mAO.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).mAU <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).mProcessName).append(',').append(((a)localObject2).mAJ.replace(",", "##")).append(',').append(((a)localObject2).mAU).append(',').append(((a)localObject2).mAT).append(',').append(((a)localObject2).mAV).append(',');
          if (((a)localObject2).mAS)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).mAR);
            localObject2 = localStringBuilder.toString();
            localObject3 = new us();
            ((us)localObject3).hYu.hYv = ((String)localObject2);
            ((us)localObject3).publish();
            Log.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      mAO.clear();
      label285:
      mAM = l;
      label289:
      AppMethodBeat.o(153431);
    }
    
    /* Error */
    private static void aYX()
    {
      // Byte code:
      //   0: ldc 191
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 48	com/tencent/mm/jni/a/a$c:mAP	[B
      //   8: astore_3
      //   9: aload_3
      //   10: monitorenter
      //   11: aconst_null
      //   12: astore_1
      //   13: aconst_null
      //   14: astore_2
      //   15: aload_1
      //   16: astore_0
      //   17: new 193	com/tencent/mm/vfs/u
      //   20: dup
      //   21: invokestatic 199	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   24: invokevirtual 205	android/content/Context:getCacheDir	()Ljava/io/File;
      //   27: ldc 207
      //   29: invokespecial 210	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   32: astore 4
      //   34: aload_1
      //   35: astore_0
      //   36: aload 4
      //   38: invokevirtual 214	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
      //   41: invokestatic 220	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
      //   44: invokestatic 226	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
      //   47: ifne +89 -> 136
      //   50: aload_1
      //   51: astore_0
      //   52: new 188	java/io/IOException
      //   55: dup
      //   56: new 79	java/lang/StringBuilder
      //   59: dup
      //   60: ldc 228
      //   62: invokespecial 230	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload 4
      //   67: invokevirtual 214	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
      //   70: invokestatic 220	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
      //   73: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: ldc 232
      //   78: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   84: invokespecial 233	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   87: astore 4
      //   89: aload_1
      //   90: astore_0
      //   91: ldc 191
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
      //   108: ldc 174
      //   110: aload_2
      //   111: ldc 235
      //   113: iconst_0
      //   114: anewarray 4	java/lang/Object
      //   117: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aload_1
      //   121: ifnull +7 -> 128
      //   124: aload_1
      //   125: invokevirtual 244	java/io/ObjectOutputStream:close	()V
      //   128: aload_3
      //   129: monitorexit
      //   130: ldc 191
      //   132: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   135: return
      //   136: aload_1
      //   137: astore_0
      //   138: new 241	java/io/ObjectOutputStream
      //   141: dup
      //   142: new 193	com/tencent/mm/vfs/u
      //   145: dup
      //   146: aload 4
      //   148: ldc 246
      //   150: invokespecial 249	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
      //   153: invokestatic 253	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
      //   156: invokespecial 256	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   159: astore_1
      //   160: aload_1
      //   161: getstatic 37	com/tencent/mm/jni/a/a$c:mAM	J
      //   164: invokevirtual 260	java/io/ObjectOutputStream:writeLong	(J)V
      //   167: aload_1
      //   168: getstatic 46	com/tencent/mm/jni/a/a$c:mAO	Ljava/util/HashMap;
      //   171: invokevirtual 264	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   174: aload_1
      //   175: invokevirtual 244	java/io/ObjectOutputStream:close	()V
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
      //   195: invokevirtual 244	java/io/ObjectOutputStream:close	()V
      //   198: ldc 191
      //   200: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   203: aload_0
      //   204: athrow
      //   205: astore_0
      //   206: aload_3
      //   207: monitorexit
      //   208: ldc 191
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
      //   124	128	215	java/lang/Exception
      //   194	198	219	java/lang/Exception
      //   160	174	223	finally
      //   160	174	227	java/io/IOException
    }
    
    private static void c(String paramString1, String paramString2, long paramLong)
    {
      AppMethodBeat.i(153429);
      String str = paramString1 + "_" + paramString2;
      synchronized (mAP)
      {
        a locala2 = (a)mAO.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locala1.mProcessName = paramString1;
          locala1.mAJ = paramString2;
          locala1.mAV = 0L;
          locala1.mAT = 0;
          locala1.mAU = 0;
          mAO.put(str, locala1);
        }
        if (locala1.mAX.getAndIncrement() == 0)
        {
          locala1.mAW = paramLong;
          locala1.mAR = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
          locala1.mAS = CrashReportFactory.foreground;
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
      synchronized (mAP)
      {
        paramString2 = (a)mAO.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.mAX.get() > 0)
          {
            paramString2.mAT += 1;
            l1 = l2;
            if (paramString2.mAX.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.mAW;
              paramString2.mAV += l1;
              paramString2.mAU += 1;
            }
          }
        }
        aYW();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - mAN >= 3600000L))
        {
          Log.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          aYX();
          mAN = paramLong;
        }
        AppMethodBeat.o(153430);
        return;
      }
    }
    
    public static void detach()
    {
      AppMethodBeat.i(153425);
      if (mAL > 0)
      {
        MMApplicationContext.getContext().unregisterReceiver(mAQ);
        aYX();
        mAL = 0;
        Log.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { MMApplicationContext.getProcessName() });
      }
      AppMethodBeat.o(153425);
    }
    
    /* Error */
    public static void vX()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: ldc_w 347
      //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 35	com/tencent/mm/jni/a/a$c:mAL	I
      //   11: ifne +230 -> 241
      //   14: invokestatic 352	android/os/Process:myPid	()I
      //   17: putstatic 35	com/tencent/mm/jni/a/a$c:mAL	I
      //   20: new 9	com/tencent/mm/jni/a/a$c$1
      //   23: dup
      //   24: invokespecial 353	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   27: putstatic 50	com/tencent/mm/jni/a/a$c:mAQ	Landroid/content/BroadcastReceiver;
      //   30: getstatic 48	com/tencent/mm/jni/a/a$c:mAP	[B
      //   33: astore_2
      //   34: aload_2
      //   35: monitorenter
      //   36: new 355	java/io/ObjectInputStream
      //   39: dup
      //   40: new 193	com/tencent/mm/vfs/u
      //   43: dup
      //   44: invokestatic 199	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   47: invokevirtual 205	android/content/Context:getCacheDir	()Ljava/io/File;
      //   50: ldc_w 357
      //   53: invokespecial 210	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   56: invokestatic 361	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
      //   59: invokespecial 364	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   62: astore_0
      //   63: aload_0
      //   64: invokevirtual 367	java/io/ObjectInputStream:readLong	()J
      //   67: putstatic 37	com/tencent/mm/jni/a/a$c:mAM	J
      //   70: aload_0
      //   71: invokevirtual 370	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   74: checkcast 41	java/util/HashMap
      //   77: astore_1
      //   78: aload_1
      //   79: ifnull +10 -> 89
      //   82: getstatic 46	com/tencent/mm/jni/a/a$c:mAO	Ljava/util/HashMap;
      //   85: aload_1
      //   86: invokevirtual 374	java/util/HashMap:putAll	(Ljava/util/Map;)V
      //   89: aload_0
      //   90: invokevirtual 375	java/io/ObjectInputStream:close	()V
      //   93: aload_2
      //   94: monitorexit
      //   95: new 377	android/content/IntentFilter
      //   98: dup
      //   99: invokespecial 378	android/content/IntentFilter:<init>	()V
      //   102: astore_0
      //   103: aload_0
      //   104: ldc_w 380
      //   107: invokevirtual 383	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   110: aload_0
      //   111: ldc_w 385
      //   114: invokevirtual 383	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   117: invokestatic 199	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   120: getstatic 50	com/tencent/mm/jni/a/a$c:mAQ	Landroid/content/BroadcastReceiver;
      //   123: aload_0
      //   124: invokestatic 390	com/tencent/mm/sdk/platformtools/WeChatPermissions:PERMISSION_MM_MESSAGE	()Ljava/lang/String;
      //   127: aconst_null
      //   128: invokevirtual 394	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   131: pop
      //   132: ldc 174
      //   134: ldc_w 396
      //   137: iconst_1
      //   138: anewarray 4	java/lang/Object
      //   141: dup
      //   142: iconst_0
      //   143: invokestatic 335	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
      //   146: aastore
      //   147: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: ldc_w 347
      //   153: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: return
      //   157: astore_0
      //   158: aload_1
      //   159: astore_0
      //   160: ldc 174
      //   162: ldc_w 398
      //   165: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   168: invokestatic 71	android/os/SystemClock:elapsedRealtime	()J
      //   171: putstatic 37	com/tencent/mm/jni/a/a$c:mAM	J
      //   174: getstatic 46	com/tencent/mm/jni/a/a$c:mAO	Ljava/util/HashMap;
      //   177: invokevirtual 185	java/util/HashMap:clear	()V
      //   180: aload_0
      //   181: ifnull -88 -> 93
      //   184: aload_0
      //   185: invokevirtual 375	java/io/ObjectInputStream:close	()V
      //   188: goto -95 -> 93
      //   191: astore_0
      //   192: goto -99 -> 93
      //   195: astore_1
      //   196: aload_0
      //   197: ifnull +7 -> 204
      //   200: aload_0
      //   201: invokevirtual 375	java/io/ObjectInputStream:close	()V
      //   204: ldc_w 347
      //   207: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   210: aload_1
      //   211: athrow
      //   212: astore_0
      //   213: aload_2
      //   214: monitorexit
      //   215: ldc_w 347
      //   218: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: aload_0
      //   222: athrow
      //   223: astore_0
      //   224: ldc 174
      //   226: aload_0
      //   227: ldc_w 402
      //   230: iconst_0
      //   231: anewarray 4	java/lang/Object
      //   234: invokestatic 239	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   237: iconst_0
      //   238: putstatic 35	com/tencent/mm/jni/a/a$c:mAL	I
      //   241: ldc_w 347
      //   244: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   247: return
      //   248: astore_0
      //   249: goto -156 -> 93
      //   252: astore_0
      //   253: goto -49 -> 204
      //   256: astore_1
      //   257: goto -97 -> 160
      // Local variable table:
      //   start	length	slot	name	signature
      //   62	62	0	localObject1	Object
      //   157	1	0	localObject2	Object
      //   159	26	0	localHashMap1	HashMap
      //   191	10	0	localException1	java.lang.Exception
      //   212	10	0	localObject3	Object
      //   223	4	0	localThrowable	java.lang.Throwable
      //   248	1	0	localException2	java.lang.Exception
      //   252	1	0	localException3	java.lang.Exception
      //   1	158	1	localHashMap2	HashMap
      //   195	16	1	localObject4	Object
      //   256	1	1	localObject5	Object
      //   33	181	2	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   36	63	157	finally
      //   184	188	191	java/lang/Exception
      //   160	180	195	finally
      //   89	93	212	finally
      //   93	95	212	finally
      //   184	188	212	finally
      //   200	204	212	finally
      //   204	212	212	finally
      //   95	150	223	finally
      //   89	93	248	java/lang/Exception
      //   200	204	252	java/lang/Exception
      //   63	78	256	finally
      //   82	89	256	finally
    }
    
    private static void y(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(153428);
      int i = Process.myPid();
      String str = MMApplicationContext.getProcessName();
      if (i == mAL)
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
      public String mAJ;
      public String mAR;
      public boolean mAS;
      public int mAT;
      public int mAU;
      public long mAV;
      public long mAW;
      public AtomicInteger mAX;
      public String mProcessName;
      
      private a()
      {
        AppMethodBeat.i(153421);
        this.mProcessName = "";
        this.mAJ = "";
        this.mAR = "";
        this.mAS = false;
        this.mAT = 0;
        this.mAU = 0;
        this.mAV = 0L;
        this.mAW = 0L;
        this.mAX = new AtomicInteger(0);
        AppMethodBeat.o(153421);
      }
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        AppMethodBeat.i(153422);
        synchronized (a.c.aYY())
        {
          this.mProcessName = paramObjectInput.readUTF();
          this.mAJ = paramObjectInput.readUTF();
          this.mAT = paramObjectInput.readInt();
          this.mAU = paramObjectInput.readInt();
          this.mAV = paramObjectInput.readLong();
          this.mAR = "";
          this.mAS = false;
          this.mAW = 0L;
          this.mAX = new AtomicInteger(0);
          AppMethodBeat.o(153422);
          return;
        }
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        AppMethodBeat.i(153423);
        synchronized (a.c.aYY())
        {
          paramObjectOutput.writeUTF(this.mProcessName);
          paramObjectOutput.writeUTF(this.mAJ);
          paramObjectOutput.writeInt(this.mAT);
          paramObjectOutput.writeInt(this.mAU);
          paramObjectOutput.writeLong(this.mAV);
          AppMethodBeat.o(153423);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.jni.a.a
 * JD-Core Version:    0.7.0.1
 */