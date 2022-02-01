package com.tencent.mm.ci;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
  public static a Jme;
  public static d Jmj;
  private static int Jmk;
  public static final String Jmm;
  static aq gKO;
  private volatile boolean Jml;
  private LinkedBlockingQueue<a> Jmn;
  ExecutorService Jmo;
  public WeakReference<b> Jmp;
  private volatile boolean ipD;
  
  static
  {
    AppMethodBeat.i(145613);
    Jmk = 5242880;
    Jmm = Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/";
    Jme = null;
    gKO = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(145597);
        ae.i("MicroMsg.TraceDebugManager", "TRACE handle msg :%d ", new Object[] { Integer.valueOf(paramAnonymousMessage.what) });
        if (paramAnonymousMessage.what == 0) {
          d.Jmj.b((d.a)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(145597);
          return;
          if (paramAnonymousMessage.what == 1)
          {
            if (d.c(d.Jmj) != null)
            {
              d.b localb = (d.b)d.c(d.Jmj).get();
              if (localb != null) {
                localb.fyA();
              }
            }
          }
          else {
            d.a(d.Jmj, (d.a)paramAnonymousMessage.obj);
          }
        }
      }
    };
    AppMethodBeat.o(145613);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(145601);
    if (this.Jml)
    {
      AppMethodBeat.o(145601);
      return;
    }
    if (!c.abo())
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
      AppMethodBeat.o(145601);
      return;
    }
    fyz();
    for (;;)
    {
      try
      {
        Object localObject = new k(Jmm);
        if ((parama.dMv != 6) && (((k)localObject).exists()))
        {
          ae.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
          o.dd(w.B(((k)localObject).mUri), true);
        }
        ((k)localObject).mkdirs();
        localObject = parama.savePath;
        if (parama.Jms > 0) {
          continue;
        }
        i = Jmk;
        Debug.startMethodTracing((String)localObject, i);
        this.Jml = true;
      }
      catch (IncompatibleClassChangeError parama)
      {
        int i;
        ae.printErrStackTrace("MicroMsg.Crash", parama, "May cause dvmFindCatchBlock crash!", new Object[0]);
        parama = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(parama);
        AppMethodBeat.o(145601);
        throw parama;
      }
      catch (Throwable localThrowable)
      {
        this.Jml = false;
        ae.printErrStackTrace("MicroMsg.TraceDebugManager", localThrowable, "TRACE startMethodTracing ERROR", new Object[0]);
        continue;
        if (this.Jml) {
          continue;
        }
        AppMethodBeat.o(145601);
        return;
        Message localMessage = Message.obtain();
        localMessage.what = 0;
        localMessage.obj = parama;
        if ((!bu.isNullOrNil(parama.className)) && (parama.dMv != 5)) {
          continue;
        }
        gKO.sendMessageDelayed(localMessage, 15000L);
        AppMethodBeat.o(145601);
        return;
        gKO.sendMessageDelayed(localMessage, 10000L);
        AppMethodBeat.o(145601);
      }
      if (parama.dMv != 6) {
        continue;
      }
      ae.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
      AppMethodBeat.o(145601);
      return;
      i = parama.Jms;
      i = i * 1024 * 1024;
    }
  }
  
  private void abX(final int paramInt)
  {
    AppMethodBeat.i(145609);
    this.Jmo.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(145598);
        d locald = d.this;
        if (paramInt == 4) {}
        for (String str = "/data/anr/";; str = d.Jmm)
        {
          d.a(locald, str);
          AppMethodBeat.o(145598);
          return;
        }
      }
    });
    AppMethodBeat.o(145609);
  }
  
  private static String ad(k paramk)
  {
    AppMethodBeat.i(170139);
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramk.isDirectory())
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
      paramk = paramk.fTj();
      if (paramk == null)
      {
        ae.e("MicroMsg.TraceDebugManager", " get file list failed");
        AppMethodBeat.o(170139);
        return null;
      }
      i = 0;
      while (i < paramk.length)
      {
        localArrayList.add(w.B(paramk[i].fTh()));
        i += 1;
      }
    }
    localArrayList.add(w.B(paramk.fTh()));
    paramk = new k(Jmm + bu.fpO() + ".zip");
    try
    {
      o.t(localArrayList, w.B(paramk.fTh()));
      i = 0;
      while (i < localArrayList.size())
      {
        new k((String)localArrayList.get(i)).delete();
        i += 1;
      }
      if (paramk.length() <= 3145728L) {
        break label261;
      }
    }
    catch (Exception paramk)
    {
      ae.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[] { bu.o(paramk) });
      ae.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[] { paramk.getMessage() });
      AppMethodBeat.o(170139);
      return null;
    }
    ae.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[] { Long.valueOf(paramk.length()) });
    AppMethodBeat.o(170139);
    return null;
    label261:
    paramk = w.B(paramk.fTh());
    AppMethodBeat.o(170139);
    return paramk;
  }
  
  public static d fyy()
  {
    AppMethodBeat.i(145600);
    if (Jmj == null) {
      Jmj = new d();
    }
    d locald = Jmj;
    AppMethodBeat.o(145600);
    return locald;
  }
  
  private static void fyz()
  {
    AppMethodBeat.i(145602);
    gKO.removeMessages(0);
    gKO.removeMessages(2);
    gKO.removeMessages(1);
    AppMethodBeat.o(145602);
  }
  
  final void aWG(String paramString)
  {
    AppMethodBeat.i(145607);
    if (paramString == null)
    {
      AppMethodBeat.o(145607);
      return;
    }
    this.ipD = true;
    if (bu.isNullOrNil(paramString)) {
      ae.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[] { paramString });
    }
    for (;;)
    {
      this.ipD = false;
      AppMethodBeat.o(145607);
      return;
      if (!c.abo())
      {
        ae.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
      }
      else
      {
        k localk = new k(paramString);
        if (!localk.exists())
        {
          ae.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
        }
        else
        {
          if (localk.isDirectory()) {
            paramString = ad(localk);
          }
          if ((paramString != null) && (new k(paramString).length() >= 131072L)) {
            if (Jme == null)
            {
              ae.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
            }
            else
            {
              boolean bool = Jme.avC(paramString);
              ae.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[] { Boolean.valueOf(bool) });
              if (bool) {
                o.dd(Jmm, true);
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean b(final a parama)
  {
    AppMethodBeat.i(145604);
    fyz();
    if ((!this.Jml) || (this.ipD))
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[] { Boolean.valueOf(this.Jml), Boolean.valueOf(this.ipD) });
      AppMethodBeat.o(145604);
      return false;
    }
    if (!c.abo())
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
      AppMethodBeat.o(145604);
      return false;
    }
    this.Jmo.execute(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 33
        //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 44	android/os/Debug:stopMethodTracing	()V
        //   8: aload_0
        //   9: getfield 21	com/tencent/mm/ci/d$1:Jmq	Lcom/tencent/mm/ci/d$a;
        //   12: getfield 50	com/tencent/mm/ci/d$a:savePath	Ljava/lang/String;
        //   15: astore 4
        //   17: aload_0
        //   18: getfield 21	com/tencent/mm/ci/d$1:Jmq	Lcom/tencent/mm/ci/d$a;
        //   21: getfield 54	com/tencent/mm/ci/d$a:Jmt	I
        //   24: istore_1
        //   25: aload_0
        //   26: getfield 21	com/tencent/mm/ci/d$1:Jmq	Lcom/tencent/mm/ci/d$a;
        //   29: getfield 50	com/tencent/mm/ci/d$a:savePath	Ljava/lang/String;
        //   32: astore 5
        //   34: aload 5
        //   36: ifnonnull +17 -> 53
        //   39: aload_0
        //   40: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   43: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   46: pop
        //   47: ldc 33
        //   49: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   52: return
        //   53: new 62	com/tencent/mm/vfs/k
        //   56: dup
        //   57: aload 4
        //   59: invokespecial 65	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
        //   62: astore 5
        //   64: new 62	com/tencent/mm/vfs/k
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
        //   99: invokespecial 65	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
        //   102: astore 4
        //   104: invokestatic 94	java/lang/System:currentTimeMillis	()J
        //   107: lstore_2
        //   108: aload 5
        //   110: aload 4
        //   112: invokevirtual 98	com/tencent/mm/vfs/k:ag	(Lcom/tencent/mm/vfs/k;)Z
        //   115: pop
        //   116: aload 5
        //   118: invokevirtual 102	com/tencent/mm/vfs/k:delete	()Z
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
        //   144: invokestatic 115	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   147: bipush 10
        //   149: invokestatic 120	android/os/Process:setThreadPriority	(I)V
        //   152: aload_0
        //   153: getfield 21	com/tencent/mm/ci/d$1:Jmq	Lcom/tencent/mm/ci/d$a;
        //   156: getfield 123	com/tencent/mm/ci/d$a:dMv	I
        //   159: bipush 6
        //   161: if_icmpne +138 -> 299
        //   164: new 125	java/util/ArrayList
        //   167: dup
        //   168: invokespecial 126	java/util/ArrayList:<init>	()V
        //   171: astore 5
        //   173: aload 5
        //   175: aload 4
        //   177: invokevirtual 130	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
        //   180: invokestatic 136	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   183: invokevirtual 140	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   186: pop
        //   187: new 67	java/lang/StringBuilder
        //   190: dup
        //   191: invokespecial 68	java/lang/StringBuilder:<init>	()V
        //   194: aload 4
        //   196: invokevirtual 130	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
        //   199: invokestatic 136	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
        //   202: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   205: ldc 142
        //   207: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   213: astore 4
        //   215: aload 5
        //   217: aload 4
        //   219: invokestatic 148	com/tencent/mm/vfs/o:t	(Ljava/util/List;Ljava/lang/String;)Z
        //   222: pop
        //   223: getstatic 152	com/tencent/mm/ci/d:gKO	Lcom/tencent/mm/sdk/platformtools/aq;
        //   226: iconst_1
        //   227: invokevirtual 158	com/tencent/mm/sdk/platformtools/aq:sendEmptyMessage	(I)Z
        //   230: pop
        //   231: aload_0
        //   232: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
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
        //   259: invokestatic 165	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
        //   262: aastore
        //   263: invokestatic 169	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   266: ldc 104
        //   268: ldc 171
        //   270: iconst_1
        //   271: anewarray 4	java/lang/Object
        //   274: dup
        //   275: iconst_0
        //   276: aload 4
        //   278: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   281: aastore
        //   282: invokestatic 169	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   285: aload_0
        //   286: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   289: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   292: pop
        //   293: ldc 33
        //   295: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   298: return
        //   299: aload_0
        //   300: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   303: invokestatic 178	com/tencent/mm/ci/d:a	(Lcom/tencent/mm/ci/d;)Ljava/util/concurrent/LinkedBlockingQueue;
        //   306: ifnull +16 -> 322
        //   309: aload_0
        //   310: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   313: invokestatic 178	com/tencent/mm/ci/d:a	(Lcom/tencent/mm/ci/d;)Ljava/util/concurrent/LinkedBlockingQueue;
        //   316: invokevirtual 184	java/util/concurrent/LinkedBlockingQueue:size	()I
        //   319: ifne +50 -> 369
        //   322: aload 4
        //   324: invokestatic 188	com/tencent/mm/ci/d:ae	(Lcom/tencent/mm/vfs/k;)Ljava/lang/String;
        //   327: astore 4
        //   329: aload 4
        //   331: invokestatic 192	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
        //   334: ifne +35 -> 369
        //   337: aload_0
        //   338: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   341: astore 5
        //   343: iload_1
        //   344: iconst_1
        //   345: if_icmpeq +17 -> 362
        //   348: iload_1
        //   349: iconst_3
        //   350: if_icmpne +19 -> 369
        //   353: invokestatic 198	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
        //   356: invokestatic 204	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
        //   359: ifeq +10 -> 369
        //   362: aload 5
        //   364: aload 4
        //   366: invokevirtual 207	com/tencent/mm/ci/d:aWG	(Ljava/lang/String;)V
        //   369: aload_0
        //   370: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   373: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   376: pop
        //   377: ldc 33
        //   379: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   382: return
        //   383: astore 4
        //   385: ldc 209
        //   387: aload 4
        //   389: ldc 211
        //   391: iconst_0
        //   392: anewarray 4	java/lang/Object
        //   395: invokestatic 215	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   398: new 28	java/lang/IncompatibleClassChangeError
        //   401: dup
        //   402: ldc 211
        //   404: invokespecial 216	java/lang/IncompatibleClassChangeError:<init>	(Ljava/lang/String;)V
        //   407: aload 4
        //   409: invokevirtual 220	java/lang/IncompatibleClassChangeError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
        //   412: checkcast 28	java/lang/IncompatibleClassChangeError
        //   415: checkcast 28	java/lang/IncompatibleClassChangeError
        //   418: astore 4
        //   420: ldc 33
        //   422: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   425: aload 4
        //   427: athrow
        //   428: astore 4
        //   430: aload_0
        //   431: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
        //   434: invokestatic 57	com/tencent/mm/ci/d:b	(Lcom/tencent/mm/ci/d;)Z
        //   437: pop
        //   438: ldc 33
        //   440: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   443: aload 4
        //   445: athrow
        //   446: astore 4
        //   448: ldc 104
        //   450: aload 4
        //   452: ldc 222
        //   454: iconst_0
        //   455: anewarray 4	java/lang/Object
        //   458: invokestatic 215	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   461: aload_0
        //   462: getfield 19	com/tencent/mm/ci/d$1:Jmr	Lcom/tencent/mm/ci/d;
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
  
  public final void c(a parama)
  {
    AppMethodBeat.i(145608);
    if (parama.dMv <= 0)
    {
      AppMethodBeat.o(145608);
      return;
    }
    if (this.Jmo == null) {
      this.Jmo = Executors.newSingleThreadExecutor();
    }
    if ((this.ipD) || (this.Jml))
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[] { Boolean.valueOf(this.ipD), Boolean.valueOf(this.Jml) });
      AppMethodBeat.o(145608);
      return;
    }
    gKO.removeMessages(0);
    if ((parama.Jmt == 4) || (parama.Jmt == 5)) {
      abX(parama.Jmt);
    }
    for (;;)
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[] { parama.className, Integer.valueOf(parama.dMv), Integer.valueOf(parama.Jmt) });
      AppMethodBeat.o(145608);
      return;
      if ((parama.dMv == 6) || (parama.dMv == 5))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = parama;
        if (parama.dMv == 5) {
          gKO.sendMessage(localMessage);
        } else {
          gKO.sendMessageDelayed(localMessage, 500L);
        }
      }
      else
      {
        if (this.Jmn == null) {
          this.Jmn = new LinkedBlockingQueue();
        }
        this.Jmn.clear();
        this.Jmn.add(parama);
      }
    }
  }
  
  public final void gC(String paramString, int paramInt)
  {
    AppMethodBeat.i(145606);
    if ((this.Jmn != null) && (this.Jmn.size() > 0))
    {
      ae.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[] { Boolean.valueOf(this.ipD), Boolean.valueOf(this.Jml), paramString, Integer.valueOf(paramInt) });
      if ((!this.ipD) && (!this.Jml))
      {
        Iterator localIterator = this.Jmn.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.className != null)
          {
            if ((locala.className.equals(paramString)) && (locala.dMv == paramInt))
            {
              a(locala);
              this.Jmn.remove(locala);
              AppMethodBeat.o(145606);
            }
          }
          else
          {
            a(null);
            this.Jmn.remove(locala);
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
    int Jms;
    int Jmt;
    String className;
    int dMv;
    String savePath;
    
    public a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(145599);
      this.className = paramString;
      this.dMv = paramInt1;
      this.Jms = paramInt2;
      this.Jmt = paramInt3;
      StringBuilder localStringBuilder1 = new StringBuilder();
      if (bu.isNullOrNil(paramString))
      {
        localStringBuilder1.append(d.Jmm).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
        ae.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", new Object[] { localStringBuilder1.toString(), Integer.valueOf(paramInt2) });
        this.savePath = localStringBuilder1.toString();
        AppMethodBeat.o(145599);
        return;
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append(d.Jmm).append(paramString).append("_");
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
    public abstract void fyA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ci.d
 * JD-Core Version:    0.7.0.1
 */