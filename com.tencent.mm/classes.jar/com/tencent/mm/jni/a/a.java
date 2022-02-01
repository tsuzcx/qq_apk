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
import com.tencent.mm.g.a.sc;
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
  private static SparseArray<b> hoJ;
  private static MMHandler mHandler;
  private static final byte[] mLock;
  
  static
  {
    AppMethodBeat.i(153439);
    hoJ = new SparseArray();
    mHandler = new MMHandler(Looper.getMainLooper());
    mLock = new byte[0];
    AppMethodBeat.o(153439);
  }
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    AppMethodBeat.i(153437);
    synchronized (mLock)
    {
      b localb2 = (b)hoJ.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        hoJ.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.hoN.containsKey(paramString)) {
        localb1.hoN.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.Fv(paramString);
      paramWakerLock = mHandler;
      if (!localb1.hoL)
      {
        localb1.hoL = true;
        paramWakerLock.postDelayed(localb1.hoM, 60000L);
      }
      AppMethodBeat.o(153437);
      return;
    }
  }
  
  public static void ayA()
  {
    AppMethodBeat.i(153435);
    c.lH();
    AppMethodBeat.o(153435);
  }
  
  public static void ayB()
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
      paramWakerLock = (b)hoJ.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label114;
      }
      Object localObject = mHandler;
      if (paramWakerLock.hoL)
      {
        paramWakerLock.hoL = false;
        ((MMHandler)localObject).removeCallbacks(paramWakerLock.hoM);
      }
      localObject = paramWakerLock.hoN.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.Fw(((a.b.a)((Iterator)localObject).next()).hoO);
      }
    }
    paramWakerLock.hoN.clear();
    label114:
    AppMethodBeat.o(153438);
  }
  
  static final class a
    implements Runnable
  {
    private WakerLock hoK = null;
    
    public a(WakerLock paramWakerLock)
    {
      this.hoK = paramWakerLock;
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
        synchronized (a.ayC())
        {
          localObject2 = (a.b)a.ayD().get(this.hoK.hashCode());
          if (localObject2 == null) {
            break label274;
          }
          k = this.hoK.hashCode();
          m = this.hoK.innerWakeLockHashCode();
          String str = this.hoK.getCreatePosStackLine();
          Object localObject3 = ((a.b)localObject2).hoN.values();
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
            if (locala.hoP == 0L) {
              continue;
            }
            ((StringBuilder)localObject2).append('{').append(locala.hoO).append(',').append(SystemClock.elapsedRealtime() - locala.hoP).append('}');
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
        this.hoK.unLock();
        AppMethodBeat.o(153418);
        return;
        label274:
        Log.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(this.hoK.hashCode()), Integer.valueOf(this.hoK.innerWakeLockHashCode()), this.hoK.getCreatePosStackLine(), "#lost-trace-state#" });
      }
    }
  }
  
  static final class b
  {
    volatile boolean hoL;
    a.a hoM;
    Map<String, a> hoN;
    
    public b(WakerLock paramWakerLock)
    {
      AppMethodBeat.i(153419);
      this.hoL = false;
      this.hoM = null;
      this.hoN = new HashMap();
      this.hoM = new a.a(paramWakerLock);
      AppMethodBeat.o(153419);
    }
    
    static final class a
    {
      public String hoO = null;
      public long hoP = 0L;
      
      public a(String paramString, long paramLong)
      {
        this.hoO = paramString;
        this.hoP = paramLong;
      }
    }
  }
  
  static final class c
  {
    private static int hoQ;
    private static long hoR;
    private static long hoS;
    private static final HashMap<String, a> hoT;
    private static final byte[] hoU;
    private static BroadcastReceiver hoV;
    
    static
    {
      AppMethodBeat.i(183797);
      hoQ = 0;
      hoR = 0L;
      hoS = 0L;
      hoT = new HashMap();
      hoU = new byte[0];
      hoV = null;
      AppMethodBeat.o(183797);
    }
    
    public static void Fv(String paramString)
    {
      AppMethodBeat.i(153426);
      u(paramString, true);
      AppMethodBeat.o(153426);
    }
    
    public static void Fw(String paramString)
    {
      AppMethodBeat.i(153427);
      u(paramString, false);
      AppMethodBeat.o(153427);
    }
    
    private static void ayE()
    {
      AppMethodBeat.i(153431);
      long l;
      for (;;)
      {
        synchronized (hoU)
        {
          l = SystemClock.elapsedRealtime();
          if (l - hoR < 21600000L) {
            break label292;
          }
          if (hoT.isEmpty()) {
            break label288;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = hoT.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).hoZ <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).mProcessName).append(',').append(((a)localObject2).hoO.replace(",", "##")).append(',').append(((a)localObject2).hoZ).append(',').append(((a)localObject2).hoY).append(',').append(((a)localObject2).hpa).append(',');
          if (((a)localObject2).hoX)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).hoW);
            localObject2 = localStringBuilder.toString();
            localObject3 = new sc();
            ((sc)localObject3).dYF.dYG = ((String)localObject2);
            EventCenter.instance.publish((IEvent)localObject3);
            Log.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      hoT.clear();
      label288:
      hoR = l;
      label292:
      AppMethodBeat.o(153431);
    }
    
    /* Error */
    private static void ayF()
    {
      // Byte code:
      //   0: ldc 198
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 48	com/tencent/mm/jni/a/a$c:hoU	[B
      //   8: astore_3
      //   9: aload_3
      //   10: monitorenter
      //   11: aconst_null
      //   12: astore_1
      //   13: aconst_null
      //   14: astore_2
      //   15: aload_1
      //   16: astore_0
      //   17: new 200	com/tencent/mm/vfs/o
      //   20: dup
      //   21: invokestatic 206	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   24: invokevirtual 212	android/content/Context:getCacheDir	()Ljava/io/File;
      //   27: ldc 214
      //   29: invokespecial 217	com/tencent/mm/vfs/o:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   32: astore 4
      //   34: aload_1
      //   35: astore_0
      //   36: aload 4
      //   38: invokevirtual 221	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
      //   41: invokestatic 227	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
      //   44: invokestatic 233	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
      //   47: ifne +89 -> 136
      //   50: aload_1
      //   51: astore_0
      //   52: new 195	java/io/IOException
      //   55: dup
      //   56: new 79	java/lang/StringBuilder
      //   59: dup
      //   60: ldc 235
      //   62: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload 4
      //   67: invokevirtual 221	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
      //   70: invokestatic 227	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
      //   73: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: ldc 239
      //   78: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   81: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   84: invokespecial 240	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   87: astore 4
      //   89: aload_1
      //   90: astore_0
      //   91: ldc 198
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
      //   108: ldc 181
      //   110: aload_2
      //   111: ldc 242
      //   113: iconst_0
      //   114: anewarray 4	java/lang/Object
      //   117: invokestatic 246	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aload_1
      //   121: ifnull +7 -> 128
      //   124: aload_1
      //   125: invokevirtual 251	java/io/ObjectOutputStream:close	()V
      //   128: aload_3
      //   129: monitorexit
      //   130: ldc 198
      //   132: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   135: return
      //   136: aload_1
      //   137: astore_0
      //   138: new 248	java/io/ObjectOutputStream
      //   141: dup
      //   142: new 200	com/tencent/mm/vfs/o
      //   145: dup
      //   146: aload 4
      //   148: ldc 253
      //   150: invokespecial 256	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
      //   153: invokestatic 260	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
      //   156: invokespecial 263	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   159: astore_1
      //   160: aload_1
      //   161: getstatic 37	com/tencent/mm/jni/a/a$c:hoR	J
      //   164: invokevirtual 267	java/io/ObjectOutputStream:writeLong	(J)V
      //   167: aload_1
      //   168: getstatic 46	com/tencent/mm/jni/a/a$c:hoT	Ljava/util/HashMap;
      //   171: invokevirtual 271	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   174: aload_1
      //   175: invokevirtual 251	java/io/ObjectOutputStream:close	()V
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
      //   195: invokevirtual 251	java/io/ObjectOutputStream:close	()V
      //   198: ldc 198
      //   200: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   203: aload_0
      //   204: athrow
      //   205: astore_0
      //   206: aload_3
      //   207: monitorexit
      //   208: ldc 198
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
      synchronized (hoU)
      {
        a locala2 = (a)hoT.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locala1.mProcessName = paramString1;
          locala1.hoO = paramString2;
          locala1.hpa = 0L;
          locala1.hoY = 0;
          locala1.hoZ = 0;
          hoT.put(str, locala1);
        }
        if (locala1.hpc.getAndIncrement() == 0)
        {
          locala1.hpb = paramLong;
          locala1.hoW = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
          locala1.hoX = CrashReportFactory.foreground;
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
      synchronized (hoU)
      {
        paramString2 = (a)hoT.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.hpc.get() > 0)
          {
            paramString2.hoY += 1;
            l1 = l2;
            if (paramString2.hpc.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.hpb;
              paramString2.hpa += l1;
              paramString2.hoZ += 1;
            }
          }
        }
        ayE();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - hoS >= 3600000L))
        {
          Log.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          ayF();
          hoS = paramLong;
        }
        AppMethodBeat.o(153430);
        return;
      }
    }
    
    public static void detach()
    {
      AppMethodBeat.i(153425);
      if (hoQ > 0)
      {
        MMApplicationContext.getContext().unregisterReceiver(hoV);
        ayF();
        hoQ = 0;
        Log.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { MMApplicationContext.getProcessName() });
      }
      AppMethodBeat.o(153425);
    }
    
    /* Error */
    public static void lH()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: ldc_w 356
      //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: getstatic 35	com/tencent/mm/jni/a/a$c:hoQ	I
      //   11: ifne +232 -> 243
      //   14: invokestatic 361	android/os/Process:myPid	()I
      //   17: putstatic 35	com/tencent/mm/jni/a/a$c:hoQ	I
      //   20: new 9	com/tencent/mm/jni/a/a$c$1
      //   23: dup
      //   24: invokespecial 362	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   27: putstatic 50	com/tencent/mm/jni/a/a$c:hoV	Landroid/content/BroadcastReceiver;
      //   30: getstatic 48	com/tencent/mm/jni/a/a$c:hoU	[B
      //   33: astore_3
      //   34: aload_3
      //   35: monitorenter
      //   36: new 364	java/io/ObjectInputStream
      //   39: dup
      //   40: new 200	com/tencent/mm/vfs/o
      //   43: dup
      //   44: invokestatic 206	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   47: invokevirtual 212	android/content/Context:getCacheDir	()Ljava/io/File;
      //   50: ldc_w 366
      //   53: invokespecial 217	com/tencent/mm/vfs/o:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   56: invokestatic 370	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
      //   59: invokespecial 373	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   62: astore_0
      //   63: aload_0
      //   64: invokevirtual 376	java/io/ObjectInputStream:readLong	()J
      //   67: putstatic 37	com/tencent/mm/jni/a/a$c:hoR	J
      //   70: aload_0
      //   71: invokevirtual 379	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   74: checkcast 41	java/util/HashMap
      //   77: astore_1
      //   78: aload_1
      //   79: ifnull +10 -> 89
      //   82: getstatic 46	com/tencent/mm/jni/a/a$c:hoT	Ljava/util/HashMap;
      //   85: aload_1
      //   86: invokevirtual 383	java/util/HashMap:putAll	(Ljava/util/Map;)V
      //   89: aload_0
      //   90: invokevirtual 384	java/io/ObjectInputStream:close	()V
      //   93: aload_3
      //   94: monitorexit
      //   95: new 386	android/content/IntentFilter
      //   98: dup
      //   99: invokespecial 387	android/content/IntentFilter:<init>	()V
      //   102: astore_0
      //   103: aload_0
      //   104: ldc_w 389
      //   107: invokevirtual 392	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   110: aload_0
      //   111: ldc_w 394
      //   114: invokevirtual 392	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   117: invokestatic 206	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   120: getstatic 50	com/tencent/mm/jni/a/a$c:hoV	Landroid/content/BroadcastReceiver;
      //   123: aload_0
      //   124: invokestatic 399	com/tencent/mm/sdk/platformtools/WeChatPermissions:PERMISSION_MM_MESSAGE	()Ljava/lang/String;
      //   127: aconst_null
      //   128: invokevirtual 403	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   131: pop
      //   132: ldc 181
      //   134: ldc_w 405
      //   137: iconst_1
      //   138: anewarray 4	java/lang/Object
      //   141: dup
      //   142: iconst_0
      //   143: invokestatic 342	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
      //   146: aastore
      //   147: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   150: ldc_w 356
      //   153: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   156: return
      //   157: astore_0
      //   158: aload_1
      //   159: astore_0
      //   160: ldc 181
      //   162: ldc_w 407
      //   165: invokestatic 409	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   168: invokestatic 71	android/os/SystemClock:elapsedRealtime	()J
      //   171: putstatic 37	com/tencent/mm/jni/a/a$c:hoR	J
      //   174: getstatic 46	com/tencent/mm/jni/a/a$c:hoT	Ljava/util/HashMap;
      //   177: invokevirtual 192	java/util/HashMap:clear	()V
      //   180: aload_0
      //   181: ifnull -88 -> 93
      //   184: aload_0
      //   185: invokevirtual 384	java/io/ObjectInputStream:close	()V
      //   188: goto -95 -> 93
      //   191: astore_0
      //   192: goto -99 -> 93
      //   195: astore_0
      //   196: aconst_null
      //   197: astore_1
      //   198: aload_1
      //   199: ifnull +7 -> 206
      //   202: aload_1
      //   203: invokevirtual 384	java/io/ObjectInputStream:close	()V
      //   206: ldc_w 356
      //   209: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_0
      //   213: athrow
      //   214: astore_0
      //   215: aload_3
      //   216: monitorexit
      //   217: ldc_w 356
      //   220: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   223: aload_0
      //   224: athrow
      //   225: astore_0
      //   226: ldc 181
      //   228: aload_0
      //   229: ldc_w 411
      //   232: iconst_0
      //   233: anewarray 4	java/lang/Object
      //   236: invokestatic 246	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   239: iconst_0
      //   240: putstatic 35	com/tencent/mm/jni/a/a$c:hoQ	I
      //   243: ldc_w 356
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
    
    private static void u(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(153428);
      int i = Process.myPid();
      String str = MMApplicationContext.getProcessName();
      if (i == hoQ)
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
      public String hoO;
      public String hoW;
      public boolean hoX;
      public int hoY;
      public int hoZ;
      public long hpa;
      public long hpb;
      public AtomicInteger hpc;
      public String mProcessName;
      
      private a()
      {
        AppMethodBeat.i(153421);
        this.mProcessName = "";
        this.hoO = "";
        this.hoW = "";
        this.hoX = false;
        this.hoY = 0;
        this.hoZ = 0;
        this.hpa = 0L;
        this.hpb = 0L;
        this.hpc = new AtomicInteger(0);
        AppMethodBeat.o(153421);
      }
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        AppMethodBeat.i(153422);
        synchronized (a.c.ayG())
        {
          this.mProcessName = paramObjectInput.readUTF();
          this.hoO = paramObjectInput.readUTF();
          this.hoY = paramObjectInput.readInt();
          this.hoZ = paramObjectInput.readInt();
          this.hpa = paramObjectInput.readLong();
          this.hoW = "";
          this.hoX = false;
          this.hpb = 0L;
          this.hpc = new AtomicInteger(0);
          AppMethodBeat.o(153422);
          return;
        }
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        AppMethodBeat.i(153423);
        synchronized (a.c.ayG())
        {
          paramObjectOutput.writeUTF(this.mProcessName);
          paramObjectOutput.writeUTF(this.hoO);
          paramObjectOutput.writeInt(this.hoY);
          paramObjectOutput.writeInt(this.hoZ);
          paramObjectOutput.writeLong(this.hpa);
          AppMethodBeat.o(153423);
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