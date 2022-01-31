package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.h.a.nt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  private static SparseArray<b> dIm = new SparseArray();
  private static final byte[] dIn = new byte[0];
  private static ah mHandler = new ah(Looper.getMainLooper());
  
  public static void Co() {}
  
  public static void Cp() {}
  
  public static void a(WakerLock paramWakerLock, String paramString)
  {
    synchronized (dIn)
    {
      b localb2 = (b)dIm.get(paramWakerLock.hashCode());
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(paramWakerLock);
        dIm.put(paramWakerLock.hashCode(), localb1);
      }
      if (!localb1.dIr.containsKey(paramString)) {
        localb1.dIr.put(paramString, new a.b.a(paramString, SystemClock.elapsedRealtime()));
      }
      c.fK(paramString);
      paramWakerLock = mHandler;
      if (!localb1.dIp)
      {
        localb1.dIp = true;
        paramWakerLock.postDelayed(localb1.dIq, 60000L);
      }
      return;
    }
  }
  
  public static void c(WakerLock paramWakerLock)
  {
    synchronized (dIn)
    {
      paramWakerLock = (b)dIm.get(paramWakerLock.hashCode());
      if (paramWakerLock == null) {
        break label104;
      }
      Object localObject = mHandler;
      if (paramWakerLock.dIp)
      {
        paramWakerLock.dIp = false;
        ((ah)localObject).removeCallbacks(paramWakerLock.dIq);
      }
      localObject = paramWakerLock.dIr.values().iterator();
      if (((Iterator)localObject).hasNext()) {
        c.fL(((a.b.a)((Iterator)localObject).next()).dIs);
      }
    }
    paramWakerLock.dIr.clear();
    label104:
  }
  
  private static final class a
    implements Runnable
  {
    private WakerLock dIo = null;
    
    public a(WakerLock paramWakerLock)
    {
      this.dIo = paramWakerLock;
    }
    
    public final void run()
    {
      Object localObject2;
      int k;
      int m;
      for (;;)
      {
        int i;
        synchronized (a.dIn)
        {
          localObject2 = (a.b)a.Cq().get(this.dIo.hashCode());
          if (localObject2 == null) {
            break label259;
          }
          k = this.dIo.hashCode();
          m = this.dIo.innerWakeLockHashCode();
          String str = this.dIo.getCreatePosStackLine();
          Object localObject3 = ((a.b)localObject2).dIr.values();
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
            if (locala.dIt == 0L) {
              continue;
            }
            ((StringBuilder)localObject2).append('{').append(locala.dIs).append(',').append(SystemClock.elapsedRealtime() - locala.dIt).append('}');
            i = j;
          }
        }
        ((StringBuilder)localObject2).append(',');
        int j = i;
      }
      if (((StringBuilder)localObject2).length() == 0) {
        ((StringBuilder)localObject2).append("<empty>");
      }
      y.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), localObject1, ((StringBuilder)localObject2).toString() });
      for (;;)
      {
        this.dIo.unLock();
        return;
        label259:
        y.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", new Object[] { Integer.valueOf(this.dIo.hashCode()), Integer.valueOf(this.dIo.innerWakeLockHashCode()), this.dIo.getCreatePosStackLine(), "#lost-trace-state#" });
      }
    }
  }
  
  private static final class b
  {
    volatile boolean dIp = false;
    a.a dIq = null;
    Map<String, a> dIr = new HashMap();
    
    public b(WakerLock paramWakerLock)
    {
      this.dIq = new a.a(paramWakerLock);
    }
    
    private static final class a
    {
      public String dIs = null;
      public long dIt = 0L;
      
      public a(String paramString, long paramLong)
      {
        this.dIs = paramString;
        this.dIt = paramLong;
      }
    }
  }
  
  private static final class c
  {
    private static int dIu = 0;
    private static long dIv = 0L;
    private static long dIw = 0L;
    private static HashMap<String, a> dIx = null;
    private static final byte[] dIy = new byte[0];
    private static BroadcastReceiver dIz = null;
    
    /* Error */
    public static void Cr()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: getstatic 28	com/tencent/mm/jni/a/a$c:dIu	I
      //   5: ifne +125 -> 130
      //   8: invokestatic 48	android/os/Process:myPid	()I
      //   11: putstatic 28	com/tencent/mm/jni/a/a$c:dIu	I
      //   14: new 9	com/tencent/mm/jni/a/a$c$1
      //   17: dup
      //   18: invokespecial 51	com/tencent/mm/jni/a/a$c$1:<init>	()V
      //   21: putstatic 38	com/tencent/mm/jni/a/a$c:dIz	Landroid/content/BroadcastReceiver;
      //   24: getstatic 36	com/tencent/mm/jni/a/a$c:dIy	[B
      //   27: astore_3
      //   28: aload_3
      //   29: monitorenter
      //   30: new 53	java/io/ObjectInputStream
      //   33: dup
      //   34: new 55	com/tencent/mm/vfs/b
      //   37: dup
      //   38: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
      //   41: invokevirtual 67	android/content/Context:getCacheDir	()Ljava/io/File;
      //   44: ldc 69
      //   46: invokespecial 72	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   49: invokestatic 78	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
      //   52: invokespecial 81	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   55: astore_0
      //   56: aload_0
      //   57: invokevirtual 85	java/io/ObjectInputStream:readLong	()J
      //   60: putstatic 30	com/tencent/mm/jni/a/a$c:dIv	J
      //   63: aload_0
      //   64: invokevirtual 89	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   67: checkcast 91	java/util/HashMap
      //   70: putstatic 34	com/tencent/mm/jni/a/a$c:dIx	Ljava/util/HashMap;
      //   73: aload_0
      //   74: invokevirtual 94	java/io/ObjectInputStream:close	()V
      //   77: aload_3
      //   78: monitorexit
      //   79: new 96	android/content/IntentFilter
      //   82: dup
      //   83: invokespecial 97	android/content/IntentFilter:<init>	()V
      //   86: astore_0
      //   87: aload_0
      //   88: ldc 99
      //   90: invokevirtual 103	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   93: aload_0
      //   94: ldc 105
      //   96: invokevirtual 103	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
      //   99: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
      //   102: getstatic 38	com/tencent/mm/jni/a/a$c:dIz	Landroid/content/BroadcastReceiver;
      //   105: aload_0
      //   106: ldc 107
      //   108: aconst_null
      //   109: invokevirtual 111	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
      //   112: pop
      //   113: ldc 113
      //   115: ldc 115
      //   117: iconst_1
      //   118: anewarray 4	java/lang/Object
      //   121: dup
      //   122: iconst_0
      //   123: invokestatic 119	com/tencent/mm/sdk/platformtools/ae:getProcessName	()Ljava/lang/String;
      //   126: aastore
      //   127: invokestatic 125	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   130: return
      //   131: astore_0
      //   132: aconst_null
      //   133: astore_0
      //   134: ldc 113
      //   136: ldc 127
      //   138: invokestatic 131	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   141: invokestatic 136	android/os/SystemClock:elapsedRealtime	()J
      //   144: putstatic 30	com/tencent/mm/jni/a/a$c:dIv	J
      //   147: new 91	java/util/HashMap
      //   150: dup
      //   151: invokespecial 137	java/util/HashMap:<init>	()V
      //   154: putstatic 34	com/tencent/mm/jni/a/a$c:dIx	Ljava/util/HashMap;
      //   157: aload_0
      //   158: ifnull -81 -> 77
      //   161: aload_0
      //   162: invokevirtual 94	java/io/ObjectInputStream:close	()V
      //   165: goto -88 -> 77
      //   168: astore_0
      //   169: goto -92 -> 77
      //   172: astore_1
      //   173: aload_2
      //   174: astore_0
      //   175: aload_0
      //   176: ifnull +7 -> 183
      //   179: aload_0
      //   180: invokevirtual 94	java/io/ObjectInputStream:close	()V
      //   183: aload_1
      //   184: athrow
      //   185: astore_0
      //   186: aload_3
      //   187: monitorexit
      //   188: aload_0
      //   189: athrow
      //   190: astore_0
      //   191: goto -114 -> 77
      //   194: astore_0
      //   195: goto -12 -> 183
      //   198: astore_1
      //   199: goto -24 -> 175
      //   202: astore_1
      //   203: goto -28 -> 175
      //   206: astore_1
      //   207: goto -73 -> 134
      // Local variable table:
      //   start	length	slot	name	signature
      //   55	51	0	localObject1	Object
      //   131	1	0	localException1	java.lang.Exception
      //   133	29	0	localObject2	Object
      //   168	1	0	localException2	java.lang.Exception
      //   174	6	0	localObject3	Object
      //   185	4	0	localObject4	Object
      //   190	1	0	localException3	java.lang.Exception
      //   194	1	0	localException4	java.lang.Exception
      //   172	12	1	localObject5	Object
      //   198	1	1	localObject6	Object
      //   202	1	1	localObject7	Object
      //   206	1	1	localException5	java.lang.Exception
      //   1	173	2	localObject8	Object
      //   27	160	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   30	56	131	java/lang/Exception
      //   161	165	168	java/lang/Exception
      //   30	56	172	finally
      //   73	77	185	finally
      //   77	79	185	finally
      //   161	165	185	finally
      //   179	183	185	finally
      //   183	185	185	finally
      //   186	188	185	finally
      //   73	77	190	java/lang/Exception
      //   179	183	194	java/lang/Exception
      //   56	73	198	finally
      //   134	157	202	finally
      //   56	73	206	java/lang/Exception
    }
    
    private static void Cs()
    {
      long l;
      for (;;)
      {
        synchronized (dIy)
        {
          l = SystemClock.elapsedRealtime();
          if (l - dIv < 21600000L) {
            break label282;
          }
          if (dIx.isEmpty()) {
            break label278;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          Iterator localIterator = dIx.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject2 = (a)((Map.Entry)localIterator.next()).getValue();
          if (((a)localObject2).dIE <= 0) {
            continue;
          }
          localStringBuilder.setLength(0);
          Object localObject3 = localStringBuilder.append(((a)localObject2).dIA).append(',').append(((a)localObject2).dIs.replace(",", "##")).append(',').append(((a)localObject2).dIE).append(',').append(((a)localObject2).dID).append(',').append(((a)localObject2).dIF).append(',');
          if (((a)localObject2).dIC)
          {
            i = 1;
            ((StringBuilder)localObject3).append(i).append(',').append(((a)localObject2).dIB);
            localObject2 = localStringBuilder.toString();
            localObject3 = new nt();
            ((nt)localObject3).bXv.bXw = ((String)localObject2);
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
            y.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", new Object[] { localStringBuilder.toString() });
          }
        }
        int i = 0;
      }
      dIx.clear();
      label278:
      dIv = l;
      label282:
    }
    
    /* Error */
    private static void Ct()
    {
      // Byte code:
      //   0: getstatic 36	com/tencent/mm/jni/a/a$c:dIy	[B
      //   3: astore_3
      //   4: aload_3
      //   5: monitorenter
      //   6: aconst_null
      //   7: astore_1
      //   8: aconst_null
      //   9: astore_2
      //   10: aload_1
      //   11: astore_0
      //   12: new 55	com/tencent/mm/vfs/b
      //   15: dup
      //   16: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
      //   19: invokevirtual 67	android/content/Context:getCacheDir	()Ljava/io/File;
      //   22: ldc_w 258
      //   25: invokespecial 72	com/tencent/mm/vfs/b:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   28: astore 4
      //   30: aload_1
      //   31: astore_0
      //   32: aload 4
      //   34: invokevirtual 262	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
      //   37: invokestatic 268	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
      //   40: invokestatic 272	com/tencent/mm/vfs/e:nb	(Ljava/lang/String;)Z
      //   43: ifne +74 -> 117
      //   46: aload_1
      //   47: astore_0
      //   48: new 256	java/io/IOException
      //   51: dup
      //   52: new 146	java/lang/StringBuilder
      //   55: dup
      //   56: ldc_w 274
      //   59: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   62: aload 4
      //   64: invokevirtual 262	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
      //   67: invokestatic 268	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
      //   70: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: ldc_w 278
      //   76: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   82: invokespecial 279	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   85: athrow
      //   86: astore_0
      //   87: aload_2
      //   88: astore_1
      //   89: aload_0
      //   90: astore_2
      //   91: aload_1
      //   92: astore_0
      //   93: ldc 113
      //   95: aload_2
      //   96: ldc_w 281
      //   99: iconst_0
      //   100: anewarray 4	java/lang/Object
      //   103: invokestatic 285	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   106: aload_1
      //   107: ifnull +7 -> 114
      //   110: aload_1
      //   111: invokevirtual 288	java/io/ObjectOutputStream:close	()V
      //   114: aload_3
      //   115: monitorexit
      //   116: return
      //   117: aload_1
      //   118: astore_0
      //   119: new 287	java/io/ObjectOutputStream
      //   122: dup
      //   123: new 55	com/tencent/mm/vfs/b
      //   126: dup
      //   127: aload 4
      //   129: ldc_w 290
      //   132: invokespecial 293	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
      //   135: invokestatic 297	com/tencent/mm/vfs/e:p	(Lcom/tencent/mm/vfs/b;)Ljava/io/OutputStream;
      //   138: invokespecial 300	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   141: astore_1
      //   142: aload_1
      //   143: getstatic 30	com/tencent/mm/jni/a/a$c:dIv	J
      //   146: invokevirtual 304	java/io/ObjectOutputStream:writeLong	(J)V
      //   149: aload_1
      //   150: getstatic 34	com/tencent/mm/jni/a/a$c:dIx	Ljava/util/HashMap;
      //   153: invokevirtual 308	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
      //   156: aload_1
      //   157: invokevirtual 288	java/io/ObjectOutputStream:close	()V
      //   160: goto -46 -> 114
      //   163: astore_0
      //   164: goto -50 -> 114
      //   167: astore_2
      //   168: aload_0
      //   169: astore_1
      //   170: aload_2
      //   171: astore_0
      //   172: aload_1
      //   173: ifnull +7 -> 180
      //   176: aload_1
      //   177: invokevirtual 288	java/io/ObjectOutputStream:close	()V
      //   180: aload_0
      //   181: athrow
      //   182: astore_0
      //   183: aload_3
      //   184: monitorexit
      //   185: aload_0
      //   186: athrow
      //   187: astore_0
      //   188: goto -74 -> 114
      //   191: astore_1
      //   192: goto -12 -> 180
      //   195: astore_0
      //   196: goto -24 -> 172
      //   199: astore_2
      //   200: goto -109 -> 91
      // Local variable table:
      //   start	length	slot	name	signature
      //   11	37	0	localObject1	Object
      //   86	4	0	localIOException1	java.io.IOException
      //   92	27	0	localObject2	Object
      //   163	6	0	localException1	java.lang.Exception
      //   171	10	0	localObject3	Object
      //   182	4	0	localObject4	Object
      //   187	1	0	localException2	java.lang.Exception
      //   195	1	0	localObject5	Object
      //   7	170	1	localObject6	Object
      //   191	1	1	localException3	java.lang.Exception
      //   9	87	2	localObject7	Object
      //   167	4	2	localObject8	Object
      //   199	1	2	localIOException2	java.io.IOException
      //   3	181	3	arrayOfByte	byte[]
      //   28	100	4	localb	com.tencent.mm.vfs.b
      // Exception table:
      //   from	to	target	type
      //   12	30	86	java/io/IOException
      //   32	46	86	java/io/IOException
      //   48	86	86	java/io/IOException
      //   119	142	86	java/io/IOException
      //   156	160	163	java/lang/Exception
      //   12	30	167	finally
      //   32	46	167	finally
      //   48	86	167	finally
      //   93	106	167	finally
      //   119	142	167	finally
      //   110	114	182	finally
      //   114	116	182	finally
      //   156	160	182	finally
      //   176	180	182	finally
      //   180	182	182	finally
      //   183	185	182	finally
      //   110	114	187	java/lang/Exception
      //   176	180	191	java/lang/Exception
      //   142	156	195	finally
      //   142	156	199	java/io/IOException
    }
    
    private static void b(String paramString1, String paramString2, long paramLong)
    {
      String str = paramString1 + "_" + paramString2;
      synchronized (dIy)
      {
        a locala2 = (a)dIx.get(str);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new a((byte)0);
          locala1.dIA = paramString1;
          locala1.dIs = paramString2;
          locala1.dIF = 0L;
          locala1.dID = 0;
          locala1.dIE = 0;
          dIx.put(str, locala1);
        }
        if (locala1.dIH.getAndIncrement() == 0)
        {
          locala1.dIG = paramLong;
          locala1.dIB = aq.getNetTypeString(ae.getContext());
          locala1.dIC = com.tencent.mm.sdk.a.b.foreground;
        }
        return;
      }
    }
    
    private static void c(String arg0, String paramString2, long paramLong)
    {
      paramString2 = ??? + "_" + paramString2;
      long l2 = 0L;
      synchronized (dIy)
      {
        paramString2 = (a)dIx.get(paramString2);
        long l1 = l2;
        if (paramString2 != null)
        {
          l1 = l2;
          if (paramString2.dIH.get() > 0)
          {
            paramString2.dID += 1;
            l1 = l2;
            if (paramString2.dIH.decrementAndGet() == 0)
            {
              l1 = paramLong - paramString2.dIG;
              paramString2.dIF += l1;
              paramString2.dIE += 1;
            }
          }
        }
        Cs();
        paramLong = SystemClock.elapsedRealtime();
        if ((l1 >= 14000L) || (paramLong - dIw >= 3600000L))
        {
          y.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
          Ct();
          dIw = paramLong;
        }
        return;
      }
    }
    
    public static void detach()
    {
      if (dIu > 0)
      {
        ae.getContext().unregisterReceiver(dIz);
        Ct();
        dIu = 0;
        y.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", new Object[] { ae.getProcessName() });
      }
    }
    
    public static void fK(String paramString)
    {
      o(paramString, true);
    }
    
    public static void fL(String paramString)
    {
      o(paramString, false);
    }
    
    private static void o(String paramString, boolean paramBoolean)
    {
      int i = Process.myPid();
      String str = ae.getProcessName();
      if (i == dIu)
      {
        if (paramBoolean)
        {
          b(str, paramString, SystemClock.elapsedRealtime());
          return;
        }
        c(str, paramString, SystemClock.elapsedRealtime());
        return;
      }
      if (paramBoolean)
      {
        localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
        localIntent.putExtra("pid", i);
        localIntent.putExtra("processName", str);
        localIntent.putExtra("traceMsg", paramString);
        localIntent.putExtra("tick", SystemClock.elapsedRealtime());
        ae.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        return;
      }
      Intent localIntent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
      localIntent.putExtra("pid", i);
      localIntent.putExtra("processName", str);
      localIntent.putExtra("traceMsg", paramString);
      localIntent.putExtra("tick", SystemClock.elapsedRealtime());
      ae.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    }
    
    private static final class a
      implements Externalizable
    {
      public String dIA = "";
      public String dIB = "";
      public boolean dIC = false;
      public int dID = 0;
      public int dIE = 0;
      public long dIF = 0L;
      public long dIG = 0L;
      public AtomicInteger dIH = new AtomicInteger(0);
      public String dIs = "";
      
      public final void readExternal(ObjectInput paramObjectInput)
      {
        synchronized ()
        {
          this.dIA = paramObjectInput.readUTF();
          this.dIs = paramObjectInput.readUTF();
          this.dID = paramObjectInput.readInt();
          this.dIE = paramObjectInput.readInt();
          this.dIF = paramObjectInput.readLong();
          this.dIB = "";
          this.dIC = false;
          this.dIG = 0L;
          this.dIH = new AtomicInteger(0);
          return;
        }
      }
      
      public final void writeExternal(ObjectOutput paramObjectOutput)
      {
        synchronized ()
        {
          paramObjectOutput.writeUTF(this.dIA);
          paramObjectOutput.writeUTF(this.dIs);
          paramObjectOutput.writeInt(this.dID);
          paramObjectOutput.writeInt(this.dIE);
          paramObjectOutput.writeLong(this.dIF);
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