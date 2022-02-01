package com.tencent.mm.ci;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
  implements EventListener
{
  public static a OvX;
  public static d Owc;
  private static int Owd;
  public static final String Owf;
  static MMHandler hAk;
  private volatile boolean Owe;
  private LinkedBlockingQueue<a> Owg;
  ExecutorService Owh;
  public WeakReference<b> Owi;
  private volatile boolean jkK;
  
  static
  {
    AppMethodBeat.i(145613);
    Owd = 5242880;
    Owf = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/";
    OvX = null;
    hAk = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(145597);
        Log.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        if (paramAnonymousMessage.what == 0) {
          d.Owc.b((d.a)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(145597);
          return;
          if (paramAnonymousMessage.what == 1)
          {
            if (d.c(d.Owc) != null)
            {
              d.b localb = (d.b)d.c(d.Owc).get();
              if (localb != null) {
                localb.gGo();
              }
            }
          }
          else {
            d.a(d.Owc, (d.a)paramAnonymousMessage.obj);
          }
        }
      }
    };
    AppMethodBeat.o(145613);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(145601);
    if (this.Owe)
    {
      AppMethodBeat.o(145601);
      return;
    }
    if (!c.apn())
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
      AppMethodBeat.o(145601);
      return;
    }
    gGn();
    for (;;)
    {
      try
      {
        Object localObject = new o(Owf);
        if ((parama.een != 6) && (((o)localObject).exists()))
        {
          Log.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
          s.dy(aa.z(((o)localObject).mUri), true);
        }
        ((o)localObject).mkdirs();
        localObject = parama.savePath;
        if (parama.Owl > 0) {
          continue;
        }
        i = Owd;
        Debug.startMethodTracing((String)localObject, i);
        this.Owe = true;
      }
      catch (IncompatibleClassChangeError parama)
      {
        int i;
        Log.printErrStackTrace("MicroMsg.Crash", parama, "May cause dvmFindCatchBlock crash!", new Object[0]);
        parama = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(parama);
        AppMethodBeat.o(145601);
        throw parama;
      }
      catch (Throwable localThrowable)
      {
        this.Owe = false;
        Log.printErrStackTrace("MicroMsg.TraceDebugManager", localThrowable, "TRACE startMethodTracing ERROR", new Object[0]);
        continue;
        if (this.Owe) {
          continue;
        }
        AppMethodBeat.o(145601);
        return;
        Message localMessage = Message.obtain();
        localMessage.what = 0;
        localMessage.obj = parama;
        if ((!Util.isNullOrNil(parama.className)) && (parama.een != 5)) {
          continue;
        }
        hAk.sendMessageDelayed(localMessage, 15000L);
        AppMethodBeat.o(145601);
        return;
        hAk.sendMessageDelayed(localMessage, 10000L);
        AppMethodBeat.o(145601);
      }
      if (parama.een != 6) {
        continue;
      }
      Log.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
      AppMethodBeat.o(145601);
      return;
      i = parama.Owl;
      i = i * 1024 * 1024;
    }
  }
  
  private static String aj(o paramo)
  {
    AppMethodBeat.i(170139);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramo.isDirectory())
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
      paramo = paramo.het();
      if (paramo == null)
      {
        Log.e("MicroMsg.TraceDebugManager", " get file list failed");
        AppMethodBeat.o(170139);
        return null;
      }
      i = 0;
      while (i < paramo.length)
      {
        localArrayList.add(aa.z(paramo[i].her()));
        i += 1;
      }
    }
    localArrayList.add(aa.z(paramo.her()));
    paramo = new o(Owf + Util.nowMilliSecond() + ".zip");
    try
    {
      s.t(localArrayList, aa.z(paramo.her()));
      i = 0;
      while (i < localArrayList.size())
      {
        new o((String)localArrayList.get(i)).delete();
        i += 1;
      }
      if (paramo.length() <= 3145728L) {
        break label261;
      }
    }
    catch (Exception paramo)
    {
      Log.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[] { Util.stackTraceToString(paramo) });
      Log.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[] { paramo.getMessage() });
      AppMethodBeat.o(170139);
      return null;
    }
    Log.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[] { Long.valueOf(paramo.length()) });
    AppMethodBeat.o(170139);
    return null;
    label261:
    paramo = aa.z(paramo.her());
    AppMethodBeat.o(170139);
    return paramo;
  }
  
  private void akF(final int paramInt)
  {
    AppMethodBeat.i(145609);
    this.Owh.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145598);
        d locald = d.this;
        if (paramInt == 4) {}
        for (String str = "/data/anr/";; str = d.Owf)
        {
          d.a(locald, str);
          AppMethodBeat.o(145598);
          return;
        }
      }
    });
    AppMethodBeat.o(145609);
  }
  
  public static d gGm()
  {
    AppMethodBeat.i(145600);
    if (Owc == null) {
      Owc = new d();
    }
    d locald = Owc;
    AppMethodBeat.o(145600);
    return locald;
  }
  
  private static void gGn()
  {
    AppMethodBeat.i(145602);
    hAk.removeMessages(0);
    hAk.removeMessages(2);
    hAk.removeMessages(1);
    AppMethodBeat.o(145602);
  }
  
  public final boolean b(final a parama)
  {
    AppMethodBeat.i(145604);
    gGn();
    if ((!this.Owe) || (this.jkK))
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[] { Boolean.valueOf(this.Owe), Boolean.valueOf(this.jkK) });
      AppMethodBeat.o(145604);
      return false;
    }
    if (!c.apn())
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
      AppMethodBeat.o(145604);
      return false;
    }
    this.Owh.execute(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 33
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 44	android/os/Debug:stopMethodTracing	()V
        //   8: aload_0
        //   9: getfield 21	com/tencent/mm/ci/d$1:Owj	Lcom/tencent/mm/ci/d$a;
        //   12: getfield 50	com/tencent/mm/ci/d$a:savePath	Ljava/lang/String;
        //   15: astore 4
        //   17: aload_0
        //   18: getfield 21	com/tencent/mm/ci/d$1:Owj	Lcom/tencent/mm/ci/d$a;
        //   21: getfield 54	com/tencent/mm/ci/d$a:Owm	I
        //   24: istore_1
        //   25: aload_0
        //   26: getfield 21	com/tencent/mm/ci/d$1:Owj	Lcom/tencent/mm/ci/d$a;
        //   29: getfield 50	com/tencent/mm/ci/d$a:savePath	Ljava/lang/String;
        //   32: astore 5
        //   34: aload 5
        //   36: ifnonnull +17 -> 53
        //   39: aload_0
        //   40: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   43: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   46: pop
        //   47: ldc 33
        //   49: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   52: return
        //   53: new 62	com/tencent/mm/vfs/o
        //   56: dup
        //   57: aload 4
        //   59: invokespecial 65	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
        //   62: astore 5
        //   64: new 62	com/tencent/mm/vfs/o
        //   67: dup
        //   68: new 67	java/lang/StringBuilder
        //   71: dup
        //   72: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   75: aload 4
        //   77: iconst_0
        //   78: aload 4
        //   80: bipush 46
        //   82: invokevirtual 74	java/lang/String:lastIndexOf	(I)I
        //   85: invokevirtual 78	java/lang/String:substring	(II)Ljava/lang/String;
        //   88: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   91: ldc 84
        //   93: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   96: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   99: invokespecial 65	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
        //   102: astore 4
        //   104: invokestatic 94	java/lang/System:currentTimeMillis	()J
        //   107: lstore_2
        //   108: aload 5
        //   110: aload 4
        //   112: invokevirtual 98	com/tencent/mm/vfs/o:am	(Lcom/tencent/mm/vfs/o;)Z
        //   115: pop
        //   116: aload 5
        //   118: invokevirtual 102	com/tencent/mm/vfs/o:delete	()Z
        //   121: pop
        //   122: ldc 104
        //   124: new 67	java/lang/StringBuilder
        //   127: dup
        //   128: ldc 106
        //   130: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   133: invokestatic 94	java/lang/System:currentTimeMillis	()J
        //   136: lload_2
        //   137: lsub
        //   138: invokevirtual 110	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   141: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   144: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   147: bipush 10
        //   149: invokestatic 120	android/os/Process:setThreadPriority	(I)V
        //   152: aload_0
        //   153: getfield 21	com/tencent/mm/ci/d$1:Owj	Lcom/tencent/mm/ci/d$a;
        //   156: getfield 123	com/tencent/mm/ci/d$a:een	I
        //   159: bipush 6
        //   161: if_icmpne +138 -> 299
        //   164: new 125	java/util/ArrayList
        //   167: dup
        //   168: invokespecial 126	java/util/ArrayList:<init>	()V
        //   171: astore 5
        //   173: aload 5
        //   175: aload 4
        //   177: invokevirtual 130	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
        //   180: invokestatic 136	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
        //   183: invokevirtual 140	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   186: pop
        //   187: new 67	java/lang/StringBuilder
        //   190: dup
        //   191: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   194: aload 4
        //   196: invokevirtual 130	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
        //   199: invokestatic 136	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
        //   202: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   205: ldc 142
        //   207: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   213: astore 4
        //   215: aload 5
        //   217: aload 4
        //   219: invokestatic 148	com/tencent/mm/vfs/s:t	(Ljava/util/List;Ljava/lang/String;)Z
        //   222: pop
        //   223: getstatic 152	com/tencent/mm/ci/d:hAk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
        //   226: iconst_1
        //   227: invokevirtual 158	com/tencent/mm/sdk/platformtools/MMHandler:sendEmptyMessage	(I)Z
        //   230: pop
        //   231: aload_0
        //   232: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   235: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   238: pop
        //   239: ldc 33
        //   241: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   244: return
        //   245: astore 4
        //   247: ldc 104
        //   249: ldc 160
        //   251: iconst_1
        //   252: anewarray 4	java/lang/Object
        //   255: dup
        //   256: iconst_0
        //   257: aload 4
        //   259: invokestatic 166	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   262: aastore
        //   263: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   266: ldc 104
        //   268: ldc 172
        //   270: iconst_1
        //   271: anewarray 4	java/lang/Object
        //   274: dup
        //   275: iconst_0
        //   276: aload 4
        //   278: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   281: aastore
        //   282: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   285: aload_0
        //   286: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   289: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   292: pop
        //   293: ldc 33
        //   295: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   298: return
        //   299: aload_0
        //   300: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   303: invokestatic 179	com/tencent/mm/ci/d:a	(Lcom/tencent/mm/ci/d;)Ljava/util/concurrent/LinkedBlockingQueue;
        //   306: ifnull +16 -> 322
        //   309: aload_0
        //   310: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   313: invokestatic 179	com/tencent/mm/ci/d:a	(Lcom/tencent/mm/ci/d;)Ljava/util/concurrent/LinkedBlockingQueue;
        //   316: invokevirtual 185	java/util/concurrent/LinkedBlockingQueue:size	()I
        //   319: ifne +50 -> 369
        //   322: aload 4
        //   324: invokestatic 189	com/tencent/mm/ci/d:ak	(Lcom/tencent/mm/vfs/o;)Ljava/lang/String;
        //   327: astore 4
        //   329: aload 4
        //   331: invokestatic 193	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   334: ifne +35 -> 369
        //   337: aload_0
        //   338: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   341: astore 5
        //   343: iload_1
        //   344: iconst_1
        //   345: if_icmpeq +17 -> 362
        //   348: iload_1
        //   349: iconst_3
        //   350: if_icmpne +19 -> 369
        //   353: invokestatic 199	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
        //   356: invokestatic 205	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
        //   359: ifeq +10 -> 369
        //   362: aload 5
        //   364: aload 4
        //   366: invokevirtual 208	com/tencent/mm/ci/d:blF	(Ljava/lang/String;)V
        //   369: aload_0
        //   370: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   373: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   376: pop
        //   377: ldc 33
        //   379: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   382: return
        //   383: astore 4
        //   385: ldc 210
        //   387: aload 4
        //   389: ldc 212
        //   391: iconst_0
        //   392: anewarray 4	java/lang/Object
        //   395: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   398: new 28	java/lang/IncompatibleClassChangeError
        //   401: dup
        //   402: ldc 212
        //   404: invokespecial 217	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
        //   407: aload 4
        //   409: invokevirtual 221	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   412: checkcast 28	java/lang/IncompatibleClassChangeError
        //   415: checkcast 28	java/lang/IncompatibleClassChangeError
        //   418: astore 4
        //   420: ldc 33
        //   422: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   425: aload 4
        //   427: athrow
        //   428: astore 4
        //   430: aload_0
        //   431: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   434: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   437: pop
        //   438: ldc 33
        //   440: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   443: aload 4
        //   445: athrow
        //   446: astore 4
        //   448: ldc 104
        //   450: aload 4
        //   452: ldc 223
        //   454: iconst_0
        //   455: anewarray 4	java/lang/Object
        //   458: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   461: aload_0
        //   462: getfield 19	com/tencent/mm/ci/d$1:Owk	Lcom/tencent/mm/ci/d;
        //   465: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   468: pop
        //   469: ldc 33
        //   471: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   474: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	475	0	this	1
        //   24	327	1	i	int
        //   107	30	2	l	long
        //   15	203	4	localObject1	Object
        //   245	78	4	localException	Exception
        //   327	38	4	str	String
        //   383	25	4	localIncompatibleClassChangeError1	IncompatibleClassChangeError
        //   418	8	4	localIncompatibleClassChangeError2	IncompatibleClassChangeError
        //   428	16	4	localObject2	Object
        //   446	5	4	localThrowable	Throwable
        //   32	331	5	localObject3	Object
        // Exception table:
        //   from	to	target	type
        //   215	223	245	java/lang/Exception
        //   5	34	383	java/lang/IncompatibleClassChangeError
        //   53	215	383	java/lang/IncompatibleClassChangeError
        //   215	223	383	java/lang/IncompatibleClassChangeError
        //   223	231	383	java/lang/IncompatibleClassChangeError
        //   247	285	383	java/lang/IncompatibleClassChangeError
        //   299	322	383	java/lang/IncompatibleClassChangeError
        //   322	343	383	java/lang/IncompatibleClassChangeError
        //   353	362	383	java/lang/IncompatibleClassChangeError
        //   362	369	383	java/lang/IncompatibleClassChangeError
        //   5	34	428	finally
        //   53	215	428	finally
        //   215	223	428	finally
        //   223	231	428	finally
        //   247	285	428	finally
        //   299	322	428	finally
        //   322	343	428	finally
        //   353	362	428	finally
        //   362	369	428	finally
        //   385	428	428	finally
        //   448	461	428	finally
        //   5	34	446	java/lang/Throwable
        //   53	215	446	java/lang/Throwable
        //   215	223	446	java/lang/Throwable
        //   223	231	446	java/lang/Throwable
        //   247	285	446	java/lang/Throwable
        //   299	322	446	java/lang/Throwable
        //   322	343	446	java/lang/Throwable
        //   353	362	446	java/lang/Throwable
        //   362	369	446	java/lang/Throwable
      }
    });
    AppMethodBeat.o(145604);
    return true;
  }
  
  final void blF(String paramString)
  {
    AppMethodBeat.i(145607);
    if (paramString == null)
    {
      AppMethodBeat.o(145607);
      return;
    }
    this.jkK = true;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[] { paramString });
    }
    for (;;)
    {
      this.jkK = false;
      AppMethodBeat.o(145607);
      return;
      if (!c.apn())
      {
        Log.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
      }
      else
      {
        o localo = new o(paramString);
        if (!localo.exists())
        {
          Log.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
        }
        else
        {
          if (localo.isDirectory()) {
            paramString = aj(localo);
          }
          if ((paramString != null) && (new o(paramString).length() >= 131072L)) {
            if (OvX == null)
            {
              Log.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
            }
            else
            {
              boolean bool = OvX.aJP(paramString);
              Log.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                s.dy(Owf, true);
              }
            }
          }
        }
      }
    }
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(145608);
    if (parama.een <= 0)
    {
      AppMethodBeat.o(145608);
      return;
    }
    if (this.Owh == null) {
      this.Owh = Executors.newSingleThreadExecutor();
    }
    if ((this.jkK) || (this.Owe))
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[] { Boolean.valueOf(this.jkK), Boolean.valueOf(this.Owe) });
      AppMethodBeat.o(145608);
      return;
    }
    hAk.removeMessages(0);
    if ((parama.Owm == 4) || (parama.Owm == 5)) {
      akF(parama.Owm);
    }
    for (;;)
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[] { parama.className, Integer.valueOf(parama.een), Integer.valueOf(parama.Owm) });
      AppMethodBeat.o(145608);
      return;
      if ((parama.een == 6) || (parama.een == 5))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = parama;
        if (parama.een == 5) {
          hAk.sendMessage(localMessage);
        } else {
          hAk.sendMessageDelayed(localMessage, 500L);
        }
      }
      else
      {
        if (this.Owg == null) {
          this.Owg = new LinkedBlockingQueue();
        }
        this.Owg.clear();
        this.Owg.add(parama);
      }
    }
  }
  
  public final void gV(String paramString, int paramInt)
  {
    AppMethodBeat.i(145606);
    if ((this.Owg != null) && (this.Owg.size() > 0))
    {
      Log.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[] { Boolean.valueOf(this.jkK), Boolean.valueOf(this.Owe), paramString, Integer.valueOf(paramInt) });
      if ((!this.jkK) && (!this.Owe))
      {
        Iterator localIterator = this.Owg.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.className != null)
          {
            if ((locala.className.equals(paramString)) && (locala.een == paramInt))
            {
              a(locala);
              this.Owg.remove(locala);
              AppMethodBeat.o(145606);
            }
          }
          else
          {
            a(null);
            this.Owg.remove(locala);
            AppMethodBeat.o(145606);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(145606);
  }
  
  public static final class a
  {
    int Owl;
    int Owm;
    String className;
    int een;
    String savePath;
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(145599);
      this.className = paramString;
      this.een = paramInt1;
      this.Owl = paramInt2;
      this.Owm = paramInt3;
      StringBuilder localStringBuilder1 = new StringBuilder();
      if (Util.isNullOrNil(paramString))
      {
        localStringBuilder1.append(d.Owf).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
        Log.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", new Object[] { localStringBuilder1.toString(), Integer.valueOf(paramInt2) });
        this.savePath = localStringBuilder1.toString();
        AppMethodBeat.o(145599);
        return;
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append(d.Owf).append(paramString).append("_");
      paramString = "";
      switch (paramInt1)
      {
      }
      for (;;)
      {
        localStringBuilder2.append(paramString).append(".trace");
        break;
        paramString = "onResume";
        continue;
        paramString = "onCreate";
        continue;
        paramString = "onPause";
        continue;
        paramString = "onScrool";
        continue;
        paramString = "all";
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void gGo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ci.d
 * JD-Core Version:    0.7.0.1
 */