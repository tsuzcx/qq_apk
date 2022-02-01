package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.l;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class m
{
  private static AtomicInteger kRq;
  private static AtomicInteger kRr;
  private volatile boolean aDV;
  private int jJr;
  com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a kPL;
  private int kRo;
  private boolean kRp;
  private final ExecutorService kRs;
  private final p kRt;
  private Map<String, d> kRu;
  private ConcurrentHashMap<String, e> kRv;
  private Map<String, h> kRw;
  private Map<String, h> kRx;
  private Map<String, h> kRy;
  private ServerSocket serverSocket;
  private Thread waitConnectionThread;
  
  static
  {
    AppMethodBeat.i(194307);
    kRq = new AtomicInteger(10000);
    kRr = new AtomicInteger(10000);
    AppMethodBeat.o(194307);
  }
  
  public m()
  {
    AppMethodBeat.i(194297);
    this.kRo = 0;
    this.kRp = true;
    this.kRu = new HashMap();
    this.kRv = new ConcurrentHashMap(8, 0.75F, 2);
    this.kRw = new ConcurrentHashMap();
    this.kRx = new ConcurrentHashMap();
    this.kRy = new ConcurrentHashMap();
    Object localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().getCacheDir();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "initCache, cache dir:" + com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().getCacheDir());
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.kPL = null;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPI.sR(-1);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPr.sR(-1);
      localObject2 = new StringBuilder("initCache, cache:");
      if (this.kPL != null) {
        break label429;
      }
    }
    label429:
    for (localObject1 = "null";; localObject1 = this.kPL)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", localObject1);
      this.kRt = new p();
      this.kRs = new com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.b(TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      try
      {
        localObject1 = InetAddress.getByName("0.0.0.0");
        this.serverSocket = new ServerSocket(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.bkf(), 10, (InetAddress)localObject1);
        this.jJr = this.serverSocket.getLocalPort();
        localObject1 = new CountDownLatch(1);
        this.waitConnectionThread = new Thread(new c((CountDownLatch)localObject1), "video_proxy_wait_for_connection_thread");
        this.waitConnectionThread.start();
        ((CountDownLatch)localObject1).await();
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "proxy server start success, port:" + this.jJr);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPI.sR(0);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPr.sR(0);
        AppMethodBeat.o(194297);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        final long l;
        this.kRs.shutdown();
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "proxy server start failed " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.h(localInterruptedException));
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPI.sR(-2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPr.sR(-2);
        AppMethodBeat.o(194297);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label438;
      }
      catch (IOException localIOException)
      {
        break label438;
      }
      l = Math.min(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Nw((String)localObject1), com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPE);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "initCache, cache availableSpace=".concat(String.valueOf(l)));
      localObject2 = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h(l);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194293);
          long l1 = 0L;
          long l3 = System.currentTimeMillis();
          try
          {
            long l2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Nx(this.kRz);
            l1 = l2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, "VideoProxy", "initCache, calculate cacheSize OOM usedSpace set to 0");
            }
          }
          l1 = Math.min(l1 + l, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPE);
          this.kRB.bvX = l1;
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "initCache, update cacheSize=" + l1 + ", timeCost=" + (System.currentTimeMillis() - l3));
          AppMethodBeat.o(194293);
        }
      }, "VideoProxy");
      this.kPL = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i(new com.tencent.mm.vfs.e((String)localObject1), (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.d)localObject2);
      break;
    }
  }
  
  private a a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g paramg, String paramString1, String paramString2, n paramn, Socket paramSocket, String paramString3)
  {
    AppMethodBeat.i(194301);
    locala = new a((byte)0);
    locala.kRD = 0L;
    com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, dataSpec=" + paramg.toString());
    if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NB(paramString1)) {
      parame.a(paramg);
    }
    for (;;)
    {
      AppMethodBeat.o(194301);
      return locala;
      com.tencent.mm.vfs.e locale = null;
      try
      {
        if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPK != null) {
          locale = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPK.cw(paramString1);
        }
        if ((locale != null) && (locale.exists())) {}
        for (locala.kRF = locale;; locala.kRF = a(parame, paramg, paramString1, paramn))
        {
          if (locala.kRF == null) {
            break label503;
          }
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, localPlaylist generate success:" + locala.kRF.toString());
          parame = new com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k()
          {
            public final c bjR()
            {
              AppMethodBeat.i(194294);
              c localc = c.Nr(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.c.kSk);
              AppMethodBeat.o(194294);
              return localc;
            }
          };
          parame.a(new com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g(Uri.fromFile(new File(com.tencent.mm.vfs.i.k(q.B(locala.kRF.mUri), false))), paramg.absoluteStreamPosition, paramg.position, paramg.length, paramg.key, paramg.flags, paramg.uuid, paramg.priority));
          locala.kRE = parame;
          break;
        }
        try
        {
          int j;
          int i;
          label503:
          paramSocket.close();
          this.kRt.a(paramn);
          if (paramn.sW(2))
          {
            paramn.sV(256);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, videoRequest is interrupted:".concat(String.valueOf(paramn)));
            paramn.bjY();
            paramn.kRJ = true;
            locala.Xz = true;
            AppMethodBeat.o(194301);
            return locala;
          }
        }
        catch (IOException parame)
        {
          for (;;)
          {
            com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, paramString2, "openDataSource, socket close exception", parame);
            continue;
            paramn.sV(257);
          }
        }
      }
      catch (g parame)
      {
        j = 0;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy/" + paramn.kRO, "openDataSource, localPlaylist generate livePlayListException ".concat(String.valueOf(parame)));
        if (parame.getCause() != null)
        {
          i = j;
          if (!(parame.getCause() instanceof l.b))
          {
            i = j;
            if (!(parame.getCause() instanceof l.c)) {
              i = 17;
            }
          }
        }
        for (;;)
        {
          if ((paramn.priority == 90) && (i != 0))
          {
            locala.kRD = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.B(i, -99999L);
            if ((d)this.kRu.get(paramString3) != null)
            {
              System.currentTimeMillis();
              new HashMap();
            }
          }
          try
          {
            paramSocket.close();
            this.kRt.a(paramn);
            if (paramn.sW(2))
            {
              paramn.sV(256);
              com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, videoRequest is interrupted:".concat(String.valueOf(paramn)));
              paramn.bjY();
              paramn.kRJ = true;
              locala.Xz = true;
              AppMethodBeat.o(194301);
              return locala;
              i = 16;
            }
          }
          catch (IOException parame)
          {
            for (;;)
            {
              com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, paramString2, "openDataSource, socket close exception", parame);
              continue;
              paramn.sV(257);
            }
          }
        }
        if (paramn.priority == 90)
        {
          locala.kRD = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.B(18L, -99999L);
          if ((d)this.kRu.get(paramString3) != null)
          {
            new HashMap();
            System.currentTimeMillis();
          }
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, localPlaylist generate fail, see previous logs");
      }
    }
  }
  
  /* Error */
  private com.tencent.mm.vfs.e a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g paramg, String paramString, n paramn)
  {
    // Byte code:
    //   0: ldc_w 475
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 115	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 400
    //   13: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload 4
    //   18: getfield 405	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRO	I
    //   21: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 23
    //   29: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   32: invokevirtual 478	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjN	()Ljava/lang/String;
    //   35: astore 17
    //   37: aload 17
    //   39: ifnonnull +21 -> 60
    //   42: bipush 6
    //   44: aload 23
    //   46: ldc_w 480
    //   49: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   52: ldc_w 475
    //   55: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aconst_null
    //   59: areturn
    //   60: new 278	com/tencent/mm/vfs/e
    //   63: dup
    //   64: aload 17
    //   66: invokespecial 279	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   69: astore 18
    //   71: aload 18
    //   73: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   76: ifne +9 -> 85
    //   79: aload 18
    //   81: invokevirtual 483	com/tencent/mm/vfs/e:mkdirs	()Z
    //   84: pop
    //   85: new 278	com/tencent/mm/vfs/e
    //   88: dup
    //   89: new 115	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   96: aload 17
    //   98: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 486
    //   104: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   110: getstatic 64	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRr	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: invokevirtual 489	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   116: i2l
    //   117: ladd
    //   118: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   121: ldc_w 494
    //   124: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 279	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   133: astore 24
    //   135: iconst_4
    //   136: aload 23
    //   138: ldc_w 496
    //   141: aload 24
    //   143: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   152: iconst_0
    //   153: istore 10
    //   155: iconst_m1
    //   156: istore 11
    //   158: iconst_m1
    //   159: istore 6
    //   161: iconst_1
    //   162: istore 9
    //   164: aconst_null
    //   165: astore 17
    //   167: aload 4
    //   169: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   172: bipush 10
    //   174: if_icmpne +3624 -> 3798
    //   177: iconst_1
    //   178: istore 5
    //   180: aload 4
    //   182: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   185: astore 25
    //   187: aconst_null
    //   188: astore 18
    //   190: aload 4
    //   192: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   195: bipush 10
    //   197: if_icmpne +3607 -> 3804
    //   200: iconst_1
    //   201: istore 13
    //   203: iconst_4
    //   204: aload 23
    //   206: ldc_w 499
    //   209: iload 13
    //   211: invokestatic 502	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   214: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   220: aload 4
    //   222: aload 4
    //   224: getfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   227: iconst_5
    //   228: ior
    //   229: putfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   232: ldc_w 507
    //   235: bipush 34
    //   237: invokestatic 513	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   240: astore 26
    //   242: aload_1
    //   243: aload_2
    //   244: invokeinterface 317 2 0
    //   249: pop2
    //   250: new 515	java/io/BufferedReader
    //   253: dup
    //   254: new 517	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/f
    //   257: dup
    //   258: aload_1
    //   259: ldc_w 519
    //   262: invokespecial 522	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/f:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;Ljava/lang/String;)V
    //   265: invokespecial 525	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   268: astore_2
    //   269: aload 24
    //   271: invokestatic 529	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   274: astore_1
    //   275: aload_1
    //   276: astore 17
    //   278: aload_2
    //   279: astore 19
    //   281: aload 17
    //   283: astore 20
    //   285: new 115	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   292: astore 27
    //   294: iconst_0
    //   295: istore 8
    //   297: aload_2
    //   298: astore 19
    //   300: aload 17
    //   302: astore 20
    //   304: iconst_4
    //   305: aload 23
    //   307: ldc_w 531
    //   310: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   313: aload 18
    //   315: astore_1
    //   316: iload 5
    //   318: istore 7
    //   320: iload 11
    //   322: istore 5
    //   324: aload_2
    //   325: astore 19
    //   327: aload 17
    //   329: astore 20
    //   331: invokestatic 534	java/lang/Thread:interrupted	()Z
    //   334: ifne +3476 -> 3810
    //   337: iconst_1
    //   338: istore 11
    //   340: iload 11
    //   342: ifeq +1687 -> 2029
    //   345: aload_2
    //   346: astore 19
    //   348: aload 17
    //   350: astore 20
    //   352: aload 4
    //   354: iconst_1
    //   355: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   358: ifne +1671 -> 2029
    //   361: aload_2
    //   362: astore 19
    //   364: aload 17
    //   366: astore 20
    //   368: aload_2
    //   369: invokevirtual 537	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   372: astore 28
    //   374: aload 28
    //   376: ifnull +1653 -> 2029
    //   379: aload_2
    //   380: astore 19
    //   382: aload 17
    //   384: astore 20
    //   386: iconst_4
    //   387: aload 23
    //   389: aload 28
    //   391: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   394: aload_2
    //   395: astore 19
    //   397: aload 17
    //   399: astore 20
    //   401: aload 28
    //   403: ldc_w 539
    //   406: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   409: ifeq +1367 -> 1776
    //   412: aload_2
    //   413: astore 19
    //   415: aload 17
    //   417: astore 20
    //   419: aload 28
    //   421: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   424: ldc_w 547
    //   427: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifeq +3323 -> 3753
    //   433: aload_2
    //   434: astore 19
    //   436: aload 17
    //   438: astore 20
    //   440: aload_0
    //   441: getfield 97	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRw	Ljava/util/Map;
    //   444: aload 25
    //   446: invokeinterface 554 2 0
    //   451: ifne +3302 -> 3753
    //   454: aload_2
    //   455: astore 19
    //   457: aload 17
    //   459: astore 20
    //   461: new 556	java/util/ArrayList
    //   464: dup
    //   465: invokespecial 557	java/util/ArrayList:<init>	()V
    //   468: astore 18
    //   470: aload_2
    //   471: astore 19
    //   473: aload 17
    //   475: astore 20
    //   477: aload_0
    //   478: getfield 97	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRw	Ljava/util/Map;
    //   481: aload 25
    //   483: new 559	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h
    //   486: dup
    //   487: invokespecial 560	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:<init>	()V
    //   490: invokeinterface 564 3 0
    //   495: pop
    //   496: aload_2
    //   497: astore 19
    //   499: aload 17
    //   501: astore 20
    //   503: aload 28
    //   505: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   508: ldc_w 566
    //   511: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +3224 -> 3738
    //   517: iload 8
    //   519: ifne +37 -> 556
    //   522: aload_2
    //   523: astore 19
    //   525: aload 17
    //   527: astore 20
    //   529: iconst_4
    //   530: aload 23
    //   532: ldc_w 568
    //   535: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   538: aload_2
    //   539: astore 19
    //   541: aload 17
    //   543: astore 20
    //   545: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   548: getfield 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   551: invokeinterface 571 1 0
    //   556: iconst_1
    //   557: istore 11
    //   559: iconst_0
    //   560: istore 12
    //   562: aload_2
    //   563: astore 19
    //   565: aload 17
    //   567: astore 20
    //   569: aload 4
    //   571: aload 4
    //   573: getfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   576: bipush 251
    //   578: iand
    //   579: putfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   582: iconst_1
    //   583: istore 7
    //   585: aload_2
    //   586: astore 19
    //   588: aload 17
    //   590: astore 20
    //   592: aload 28
    //   594: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   597: ldc_w 573
    //   600: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   603: ifeq +29 -> 632
    //   606: iconst_1
    //   607: istore 11
    //   609: iconst_0
    //   610: istore 12
    //   612: aload_2
    //   613: astore 19
    //   615: aload 17
    //   617: astore 20
    //   619: aload 4
    //   621: aload 4
    //   623: getfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   626: bipush 251
    //   628: iand
    //   629: putfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   632: aload_2
    //   633: astore 19
    //   635: aload 17
    //   637: astore 20
    //   639: aload 28
    //   641: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   644: ldc_w 575
    //   647: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   650: ifeq +3085 -> 3735
    //   653: aload_2
    //   654: astore 19
    //   656: aload 17
    //   658: astore 20
    //   660: aload 28
    //   662: invokestatic 579	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ND	(Ljava/lang/String;)I
    //   665: istore 5
    //   667: aload_2
    //   668: astore 19
    //   670: aload 17
    //   672: astore 20
    //   674: aload 28
    //   676: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   679: ldc_w 581
    //   682: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   685: ifeq +3047 -> 3732
    //   688: aload_2
    //   689: astore 19
    //   691: aload 17
    //   693: astore 20
    //   695: aload 28
    //   697: invokestatic 579	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ND	(Ljava/lang/String;)I
    //   700: istore 6
    //   702: iload 11
    //   704: istore 9
    //   706: iload 12
    //   708: istore 8
    //   710: aload_2
    //   711: astore 19
    //   713: aload 17
    //   715: astore 20
    //   717: aload 28
    //   719: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   722: ldc_w 583
    //   725: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   728: ifeq +61 -> 789
    //   731: iload 11
    //   733: istore 9
    //   735: iload 12
    //   737: istore 8
    //   739: aload_2
    //   740: astore 19
    //   742: aload 17
    //   744: astore 20
    //   746: aload 28
    //   748: invokestatic 586	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:NC	(Ljava/lang/String;)Ljava/lang/String;
    //   751: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   754: ldc_w 588
    //   757: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   760: ifeq +29 -> 789
    //   763: iconst_1
    //   764: istore 9
    //   766: iconst_0
    //   767: istore 8
    //   769: aload_2
    //   770: astore 19
    //   772: aload 17
    //   774: astore 20
    //   776: aload 4
    //   778: aload 4
    //   780: getfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   783: bipush 251
    //   785: iand
    //   786: putfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   789: aload_2
    //   790: astore 19
    //   792: aload 17
    //   794: astore 20
    //   796: aload 28
    //   798: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   801: ldc_w 590
    //   804: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   807: ifeq +536 -> 1343
    //   810: aload_2
    //   811: astore 19
    //   813: aload 17
    //   815: astore 20
    //   817: aload 26
    //   819: aload 28
    //   821: invokevirtual 594	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   824: astore_1
    //   825: aload_2
    //   826: astore 19
    //   828: aload 17
    //   830: astore 20
    //   832: aload_1
    //   833: invokevirtual 599	java/util/regex/Matcher:matches	()Z
    //   836: ifeq +449 -> 1285
    //   839: aload_2
    //   840: astore 19
    //   842: aload 17
    //   844: astore 20
    //   846: aload_1
    //   847: invokevirtual 602	java/util/regex/Matcher:groupCount	()I
    //   850: ifle +435 -> 1285
    //   853: aload_2
    //   854: astore 19
    //   856: aload 17
    //   858: astore 20
    //   860: aload_1
    //   861: iconst_1
    //   862: invokevirtual 605	java/util/regex/Matcher:start	(I)I
    //   865: istore 11
    //   867: aload_2
    //   868: astore 19
    //   870: aload 17
    //   872: astore 20
    //   874: aload_1
    //   875: iconst_1
    //   876: invokevirtual 608	java/util/regex/Matcher:end	(I)I
    //   879: istore 12
    //   881: aload_2
    //   882: astore 19
    //   884: aload 17
    //   886: astore 20
    //   888: aload 28
    //   890: iconst_0
    //   891: iload 11
    //   893: invokevirtual 612	java/lang/String:substring	(II)Ljava/lang/String;
    //   896: astore 22
    //   898: aload_2
    //   899: astore 19
    //   901: aload 17
    //   903: astore 20
    //   905: aload 28
    //   907: iload 11
    //   909: iload 12
    //   911: invokevirtual 612	java/lang/String:substring	(II)Ljava/lang/String;
    //   914: astore_1
    //   915: aload_2
    //   916: astore 19
    //   918: aload 17
    //   920: astore 20
    //   922: aload 28
    //   924: iload 12
    //   926: invokevirtual 614	java/lang/String:substring	(I)Ljava/lang/String;
    //   929: astore 29
    //   931: aload_2
    //   932: astore 19
    //   934: aload 17
    //   936: astore 20
    //   938: aload_0
    //   939: aload_3
    //   940: aload_1
    //   941: invokestatic 618	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:dy	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   944: iconst_0
    //   945: iconst_0
    //   946: ldc_w 620
    //   949: bipush 90
    //   951: invokevirtual 623	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   954: astore 21
    //   956: aload 21
    //   958: astore_1
    //   959: aload_2
    //   960: astore 19
    //   962: aload 17
    //   964: astore 20
    //   966: aload 4
    //   968: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   971: ifnull +68 -> 1039
    //   974: aload_2
    //   975: astore 19
    //   977: aload 17
    //   979: astore 20
    //   981: new 115	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   988: aload 21
    //   990: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 625
    //   996: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: aload 4
    //   1001: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1004: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: astore_1
    //   1011: aload_2
    //   1012: astore 19
    //   1014: aload 17
    //   1016: astore 20
    //   1018: new 115	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   1025: aload_1
    //   1026: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: ldc_w 627
    //   1032: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: astore_1
    //   1039: aload_2
    //   1040: astore 19
    //   1042: aload 17
    //   1044: astore 20
    //   1046: aload 27
    //   1048: aload 22
    //   1050: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload_1
    //   1054: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: aload 29
    //   1059: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1062: ldc_w 629
    //   1065: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aconst_null
    //   1070: astore_1
    //   1071: iload 7
    //   1073: istore 11
    //   1075: iload 9
    //   1077: istore 12
    //   1079: iload 8
    //   1081: istore 9
    //   1083: iload 5
    //   1085: istore 8
    //   1087: iload 6
    //   1089: istore 7
    //   1091: iload 12
    //   1093: istore 6
    //   1095: iload 11
    //   1097: istore 5
    //   1099: aload_2
    //   1100: astore 19
    //   1102: aload 17
    //   1104: astore 20
    //   1106: aload 28
    //   1108: ldc_w 539
    //   1111: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1114: ifne +2645 -> 3759
    //   1117: aload_2
    //   1118: astore 19
    //   1120: aload 17
    //   1122: astore 20
    //   1124: aload 28
    //   1126: ldc_w 631
    //   1129: invokevirtual 634	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1132: ifne +21 -> 1153
    //   1135: aload_2
    //   1136: astore 19
    //   1138: aload 17
    //   1140: astore 20
    //   1142: aload 28
    //   1144: ldc_w 636
    //   1147: invokevirtual 634	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1150: ifeq +2609 -> 3759
    //   1153: aload 18
    //   1155: ifnull +2607 -> 3762
    //   1158: iload 10
    //   1160: iload 13
    //   1162: if_icmpge +2600 -> 3762
    //   1165: aload_2
    //   1166: astore 19
    //   1168: aload 17
    //   1170: astore 20
    //   1172: aload_1
    //   1173: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1176: ifne +2586 -> 3762
    //   1179: aload_2
    //   1180: astore 19
    //   1182: aload 17
    //   1184: astore 20
    //   1186: aload_0
    //   1187: aload_1
    //   1188: iconst_1
    //   1189: iconst_1
    //   1190: ldc_w 638
    //   1193: bipush 10
    //   1195: invokevirtual 623	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   1198: astore 21
    //   1200: aload_2
    //   1201: astore 19
    //   1203: aload 17
    //   1205: astore 20
    //   1207: iconst_4
    //   1208: aload 23
    //   1210: ldc_w 640
    //   1213: aload 21
    //   1215: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1218: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1221: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1224: aload_2
    //   1225: astore 19
    //   1227: aload 17
    //   1229: astore 20
    //   1231: new 642	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i
    //   1234: dup
    //   1235: invokespecial 643	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i:<init>	()V
    //   1238: astore 22
    //   1240: aload_2
    //   1241: astore 19
    //   1243: aload 17
    //   1245: astore 20
    //   1247: aload 22
    //   1249: aload 21
    //   1251: putfield 646	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i:kQY	Ljava/lang/String;
    //   1254: aload_2
    //   1255: astore 19
    //   1257: aload 17
    //   1259: astore 20
    //   1261: aload 22
    //   1263: aload_1
    //   1264: putfield 649	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i:kQX	Ljava/lang/String;
    //   1267: aload_2
    //   1268: astore 19
    //   1270: aload 17
    //   1272: astore 20
    //   1274: aload 18
    //   1276: aload 22
    //   1278: invokevirtual 652	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1281: pop
    //   1282: goto +2480 -> 3762
    //   1285: aload_2
    //   1286: astore 19
    //   1288: aload 17
    //   1290: astore 20
    //   1292: aload 27
    //   1294: aload 28
    //   1296: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: ldc_w 629
    //   1302: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aconst_null
    //   1307: astore_1
    //   1308: iload 9
    //   1310: istore 11
    //   1312: iload 8
    //   1314: istore 9
    //   1316: iload 6
    //   1318: istore 8
    //   1320: iload 5
    //   1322: istore 12
    //   1324: iload 7
    //   1326: istore 5
    //   1328: iload 11
    //   1330: istore 6
    //   1332: iload 8
    //   1334: istore 7
    //   1336: iload 12
    //   1338: istore 8
    //   1340: goto -241 -> 1099
    //   1343: aload_2
    //   1344: astore 19
    //   1346: aload 17
    //   1348: astore 20
    //   1350: aload 28
    //   1352: invokevirtual 545	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1355: ldc_w 654
    //   1358: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1361: ifeq +357 -> 1718
    //   1364: aload_2
    //   1365: astore 19
    //   1367: aload 17
    //   1369: astore 20
    //   1371: aload 26
    //   1373: aload 28
    //   1375: invokevirtual 594	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   1378: astore_1
    //   1379: aload_2
    //   1380: astore 19
    //   1382: aload 17
    //   1384: astore 20
    //   1386: aload_1
    //   1387: invokevirtual 599	java/util/regex/Matcher:matches	()Z
    //   1390: ifeq +270 -> 1660
    //   1393: aload_2
    //   1394: astore 19
    //   1396: aload 17
    //   1398: astore 20
    //   1400: aload_1
    //   1401: invokevirtual 602	java/util/regex/Matcher:groupCount	()I
    //   1404: ifle +256 -> 1660
    //   1407: aload_2
    //   1408: astore 19
    //   1410: aload 17
    //   1412: astore 20
    //   1414: aload_1
    //   1415: iconst_1
    //   1416: invokevirtual 605	java/util/regex/Matcher:start	(I)I
    //   1419: istore 11
    //   1421: aload_2
    //   1422: astore 19
    //   1424: aload 17
    //   1426: astore 20
    //   1428: aload_1
    //   1429: iconst_1
    //   1430: invokevirtual 608	java/util/regex/Matcher:end	(I)I
    //   1433: istore 12
    //   1435: aload_2
    //   1436: astore 19
    //   1438: aload 17
    //   1440: astore 20
    //   1442: aload 28
    //   1444: iconst_0
    //   1445: iload 11
    //   1447: invokevirtual 612	java/lang/String:substring	(II)Ljava/lang/String;
    //   1450: astore 22
    //   1452: aload_2
    //   1453: astore 19
    //   1455: aload 17
    //   1457: astore 20
    //   1459: aload 28
    //   1461: iload 11
    //   1463: iload 12
    //   1465: invokevirtual 612	java/lang/String:substring	(II)Ljava/lang/String;
    //   1468: astore_1
    //   1469: aload_2
    //   1470: astore 19
    //   1472: aload 17
    //   1474: astore 20
    //   1476: aload 28
    //   1478: iload 12
    //   1480: invokevirtual 614	java/lang/String:substring	(I)Ljava/lang/String;
    //   1483: astore 29
    //   1485: aload_2
    //   1486: astore 19
    //   1488: aload 17
    //   1490: astore 20
    //   1492: aload_0
    //   1493: aload_3
    //   1494: aload_1
    //   1495: invokestatic 618	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:dy	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1498: iconst_0
    //   1499: iconst_0
    //   1500: ldc_w 638
    //   1503: bipush 90
    //   1505: invokevirtual 623	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   1508: astore 21
    //   1510: aload 21
    //   1512: astore_1
    //   1513: aload_2
    //   1514: astore 19
    //   1516: aload 17
    //   1518: astore 20
    //   1520: aload 4
    //   1522: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1525: ifnull +68 -> 1593
    //   1528: aload_2
    //   1529: astore 19
    //   1531: aload 17
    //   1533: astore 20
    //   1535: new 115	java/lang/StringBuilder
    //   1538: dup
    //   1539: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   1542: aload 21
    //   1544: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: ldc_w 625
    //   1550: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: aload 4
    //   1555: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1558: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: astore_1
    //   1565: aload_2
    //   1566: astore 19
    //   1568: aload 17
    //   1570: astore 20
    //   1572: new 115	java/lang/StringBuilder
    //   1575: dup
    //   1576: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   1579: aload_1
    //   1580: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: ldc_w 656
    //   1586: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1589: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1592: astore_1
    //   1593: aload_2
    //   1594: astore 19
    //   1596: aload 17
    //   1598: astore 20
    //   1600: aload 27
    //   1602: aload 22
    //   1604: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: aload_1
    //   1608: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: aload 29
    //   1613: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1616: ldc_w 629
    //   1619: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: pop
    //   1623: aconst_null
    //   1624: astore_1
    //   1625: iload 9
    //   1627: istore 11
    //   1629: iload 8
    //   1631: istore 9
    //   1633: iload 6
    //   1635: istore 8
    //   1637: iload 5
    //   1639: istore 12
    //   1641: iload 7
    //   1643: istore 5
    //   1645: iload 11
    //   1647: istore 6
    //   1649: iload 8
    //   1651: istore 7
    //   1653: iload 12
    //   1655: istore 8
    //   1657: goto -558 -> 1099
    //   1660: aload_2
    //   1661: astore 19
    //   1663: aload 17
    //   1665: astore 20
    //   1667: aload 27
    //   1669: aload 28
    //   1671: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1674: ldc_w 629
    //   1677: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: aconst_null
    //   1682: astore_1
    //   1683: iload 9
    //   1685: istore 11
    //   1687: iload 8
    //   1689: istore 9
    //   1691: iload 6
    //   1693: istore 8
    //   1695: iload 5
    //   1697: istore 12
    //   1699: iload 7
    //   1701: istore 5
    //   1703: iload 11
    //   1705: istore 6
    //   1707: iload 8
    //   1709: istore 7
    //   1711: iload 12
    //   1713: istore 8
    //   1715: goto -616 -> 1099
    //   1718: aload_2
    //   1719: astore 19
    //   1721: aload 17
    //   1723: astore 20
    //   1725: aload 27
    //   1727: aload 28
    //   1729: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: ldc_w 629
    //   1735: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: pop
    //   1739: aconst_null
    //   1740: astore_1
    //   1741: iload 9
    //   1743: istore 11
    //   1745: iload 8
    //   1747: istore 9
    //   1749: iload 6
    //   1751: istore 8
    //   1753: iload 5
    //   1755: istore 12
    //   1757: iload 7
    //   1759: istore 5
    //   1761: iload 11
    //   1763: istore 6
    //   1765: iload 8
    //   1767: istore 7
    //   1769: iload 12
    //   1771: istore 8
    //   1773: goto -674 -> 1099
    //   1776: aload_2
    //   1777: astore 19
    //   1779: aload 17
    //   1781: astore 20
    //   1783: ldc_w 658
    //   1786: aload 28
    //   1788: invokevirtual 661	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1791: ifne +181 -> 1972
    //   1794: aload_2
    //   1795: astore 19
    //   1797: aload 17
    //   1799: astore 20
    //   1801: aload_3
    //   1802: aload 28
    //   1804: invokestatic 618	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:dy	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1807: astore 21
    //   1809: aload_2
    //   1810: astore 19
    //   1812: aload 17
    //   1814: astore 20
    //   1816: aload_0
    //   1817: aload 21
    //   1819: iconst_0
    //   1820: iconst_0
    //   1821: ldc_w 638
    //   1824: bipush 90
    //   1826: invokevirtual 623	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   1829: astore 22
    //   1831: aload 22
    //   1833: astore 18
    //   1835: aload_2
    //   1836: astore 19
    //   1838: aload 17
    //   1840: astore 20
    //   1842: aload 4
    //   1844: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1847: ifnull +71 -> 1918
    //   1850: aload_2
    //   1851: astore 19
    //   1853: aload 17
    //   1855: astore 20
    //   1857: new 115	java/lang/StringBuilder
    //   1860: dup
    //   1861: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   1864: aload 22
    //   1866: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: ldc_w 625
    //   1872: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload 4
    //   1877: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1880: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: astore 18
    //   1888: aload_2
    //   1889: astore 19
    //   1891: aload 17
    //   1893: astore 20
    //   1895: new 115	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   1902: aload 18
    //   1904: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: ldc_w 656
    //   1910: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1916: astore 18
    //   1918: aload_2
    //   1919: astore 19
    //   1921: aload 17
    //   1923: astore 20
    //   1925: aload 27
    //   1927: aload 18
    //   1929: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: ldc_w 629
    //   1935: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1938: pop
    //   1939: aload_1
    //   1940: astore 18
    //   1942: iload 6
    //   1944: istore 11
    //   1946: iload 5
    //   1948: istore 12
    //   1950: aload 21
    //   1952: astore_1
    //   1953: iload 8
    //   1955: istore 5
    //   1957: iload 7
    //   1959: istore 6
    //   1961: iload 11
    //   1963: istore 7
    //   1965: iload 12
    //   1967: istore 8
    //   1969: goto -870 -> 1099
    //   1972: aload_2
    //   1973: astore 19
    //   1975: aload 17
    //   1977: astore 20
    //   1979: aload 27
    //   1981: aload 28
    //   1983: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: ldc_w 629
    //   1989: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: pop
    //   1993: aconst_null
    //   1994: astore 19
    //   1996: aload_1
    //   1997: astore 18
    //   1999: iload 6
    //   2001: istore 11
    //   2003: iload 5
    //   2005: istore 12
    //   2007: aload 19
    //   2009: astore_1
    //   2010: iload 8
    //   2012: istore 5
    //   2014: iload 7
    //   2016: istore 6
    //   2018: iload 11
    //   2020: istore 7
    //   2022: iload 12
    //   2024: istore 8
    //   2026: goto -927 -> 1099
    //   2029: aload_2
    //   2030: astore 19
    //   2032: aload 17
    //   2034: astore 20
    //   2036: aload 4
    //   2038: iconst_1
    //   2039: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2042: ifeq +148 -> 2190
    //   2045: aload_2
    //   2046: astore 19
    //   2048: aload 17
    //   2050: astore 20
    //   2052: new 296	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2055: dup
    //   2056: ldc_w 663
    //   2059: invokespecial 664	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   2062: astore_1
    //   2063: aload_2
    //   2064: astore 19
    //   2066: aload 17
    //   2068: astore 20
    //   2070: ldc_w 475
    //   2073: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2076: aload_2
    //   2077: astore 19
    //   2079: aload 17
    //   2081: astore 20
    //   2083: aload_1
    //   2084: athrow
    //   2085: astore_3
    //   2086: aload_2
    //   2087: astore_1
    //   2088: aload 17
    //   2090: astore_2
    //   2091: aload 4
    //   2093: iconst_1
    //   2094: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2097: ifeq +1248 -> 3345
    //   2100: aload 4
    //   2102: invokevirtual 667	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjZ	()V
    //   2105: aload_1
    //   2106: ifnull +7 -> 2113
    //   2109: aload_1
    //   2110: invokevirtual 668	java/io/BufferedReader:close	()V
    //   2113: aload_2
    //   2114: ifnull +7 -> 2121
    //   2117: aload_2
    //   2118: invokevirtual 671	java/io/OutputStream:close	()V
    //   2121: aload 24
    //   2123: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2126: ifeq +56 -> 2182
    //   2129: aload 24
    //   2131: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2134: ifeq +48 -> 2182
    //   2137: aload 24
    //   2139: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   2142: istore 14
    //   2144: iconst_4
    //   2145: aload 23
    //   2147: new 115	java/lang/StringBuilder
    //   2150: dup
    //   2151: ldc_w 679
    //   2154: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2157: aload 24
    //   2159: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2162: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: ldc_w 681
    //   2168: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: iload 14
    //   2173: invokevirtual 684	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2176: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2179: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2182: ldc_w 475
    //   2185: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2188: aconst_null
    //   2189: areturn
    //   2190: aload_1
    //   2191: ifnull +52 -> 2243
    //   2194: aload_2
    //   2195: astore 19
    //   2197: aload 17
    //   2199: astore 20
    //   2201: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2204: getfield 687	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPx	Z
    //   2207: ifeq +36 -> 2243
    //   2210: aload_2
    //   2211: astore 19
    //   2213: aload 17
    //   2215: astore 20
    //   2217: aload 4
    //   2219: iconst_1
    //   2220: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2223: ifne +20 -> 2243
    //   2226: aload_2
    //   2227: astore 19
    //   2229: aload 17
    //   2231: astore 20
    //   2233: invokestatic 693	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:bjV	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/l;
    //   2236: aload_1
    //   2237: ldc_w 695
    //   2240: invokevirtual 698	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:b	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   2243: iload 9
    //   2245: ifeq +493 -> 2738
    //   2248: aload_2
    //   2249: astore 19
    //   2251: aload 17
    //   2253: astore 20
    //   2255: aload 4
    //   2257: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   2260: astore_1
    //   2261: aload_2
    //   2262: astore 19
    //   2264: aload 17
    //   2266: astore 20
    //   2268: aload_0
    //   2269: getfield 99	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRx	Ljava/util/Map;
    //   2272: aload_1
    //   2273: invokeinterface 554 2 0
    //   2278: ifne +28 -> 2306
    //   2281: aload_2
    //   2282: astore 19
    //   2284: aload 17
    //   2286: astore 20
    //   2288: aload_0
    //   2289: getfield 99	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRx	Ljava/util/Map;
    //   2292: aload_1
    //   2293: new 559	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h
    //   2296: dup
    //   2297: invokespecial 560	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:<init>	()V
    //   2300: invokeinterface 564 3 0
    //   2305: pop
    //   2306: aload_2
    //   2307: astore 19
    //   2309: aload 17
    //   2311: astore 20
    //   2313: aload_0
    //   2314: getfield 99	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRx	Ljava/util/Map;
    //   2317: aload_1
    //   2318: invokeinterface 429 2 0
    //   2323: checkcast 559	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h
    //   2326: astore_1
    //   2327: iload 5
    //   2329: iconst_m1
    //   2330: if_icmpne +158 -> 2488
    //   2333: aload_2
    //   2334: astore 19
    //   2336: aload 17
    //   2338: astore 20
    //   2340: new 296	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2343: dup
    //   2344: ldc_w 700
    //   2347: invokespecial 664	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   2350: astore_1
    //   2351: aload_2
    //   2352: astore 19
    //   2354: aload 17
    //   2356: astore 20
    //   2358: ldc_w 475
    //   2361: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2364: aload_2
    //   2365: astore 19
    //   2367: aload 17
    //   2369: astore 20
    //   2371: aload_1
    //   2372: athrow
    //   2373: astore_1
    //   2374: aload 17
    //   2376: astore_3
    //   2377: aload_2
    //   2378: astore 19
    //   2380: aload_3
    //   2381: astore 20
    //   2383: aload 4
    //   2385: iconst_1
    //   2386: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2389: ifeq +1074 -> 3463
    //   2392: aload_2
    //   2393: astore 19
    //   2395: aload_3
    //   2396: astore 20
    //   2398: aload 4
    //   2400: invokevirtual 667	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjZ	()V
    //   2403: aload_2
    //   2404: ifnull +7 -> 2411
    //   2407: aload_2
    //   2408: invokevirtual 668	java/io/BufferedReader:close	()V
    //   2411: aload_3
    //   2412: ifnull +7 -> 2419
    //   2415: aload_3
    //   2416: invokevirtual 671	java/io/OutputStream:close	()V
    //   2419: aload 24
    //   2421: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2424: ifeq +56 -> 2480
    //   2427: aload 24
    //   2429: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2432: ifeq +48 -> 2480
    //   2435: aload 24
    //   2437: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   2440: istore 14
    //   2442: iconst_4
    //   2443: aload 23
    //   2445: new 115	java/lang/StringBuilder
    //   2448: dup
    //   2449: ldc_w 679
    //   2452: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2455: aload 24
    //   2457: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2460: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2463: ldc_w 681
    //   2466: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2469: iload 14
    //   2471: invokevirtual 684	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2474: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2477: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2480: ldc_w 475
    //   2483: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2486: aconst_null
    //   2487: areturn
    //   2488: iload 6
    //   2490: iconst_m1
    //   2491: if_icmpne +143 -> 2634
    //   2494: aload_2
    //   2495: astore 19
    //   2497: aload 17
    //   2499: astore 20
    //   2501: new 296	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2504: dup
    //   2505: ldc_w 702
    //   2508: invokespecial 664	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   2511: astore_1
    //   2512: aload_2
    //   2513: astore 19
    //   2515: aload 17
    //   2517: astore 20
    //   2519: ldc_w 475
    //   2522: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2525: aload_2
    //   2526: astore 19
    //   2528: aload 17
    //   2530: astore 20
    //   2532: aload_1
    //   2533: athrow
    //   2534: astore_1
    //   2535: iconst_0
    //   2536: istore 5
    //   2538: aload 20
    //   2540: astore_3
    //   2541: aload 19
    //   2543: astore_2
    //   2544: aload_2
    //   2545: ifnull +7 -> 2552
    //   2548: aload_2
    //   2549: invokevirtual 668	java/io/BufferedReader:close	()V
    //   2552: aload_3
    //   2553: ifnull +7 -> 2560
    //   2556: aload_3
    //   2557: invokevirtual 671	java/io/OutputStream:close	()V
    //   2560: iload 5
    //   2562: ifeq +64 -> 2626
    //   2565: aload 24
    //   2567: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2570: ifeq +56 -> 2626
    //   2573: aload 24
    //   2575: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2578: ifeq +48 -> 2626
    //   2581: aload 24
    //   2583: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   2586: istore 14
    //   2588: iconst_4
    //   2589: aload 23
    //   2591: new 115	java/lang/StringBuilder
    //   2594: dup
    //   2595: ldc_w 679
    //   2598: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2601: aload 24
    //   2603: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2606: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: ldc_w 681
    //   2612: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2615: iload 14
    //   2617: invokevirtual 684	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2620: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2623: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2626: ldc_w 475
    //   2629: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2632: aload_1
    //   2633: athrow
    //   2634: aload_2
    //   2635: astore 19
    //   2637: aload 17
    //   2639: astore 20
    //   2641: aload_1
    //   2642: getfield 705	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQV	I
    //   2645: iconst_m1
    //   2646: if_icmpne +337 -> 2983
    //   2649: aload_2
    //   2650: astore 19
    //   2652: aload 17
    //   2654: astore 20
    //   2656: aload_0
    //   2657: getfield 101	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRy	Ljava/util/Map;
    //   2660: aload_3
    //   2661: invokeinterface 429 2 0
    //   2666: ifnull +21 -> 2687
    //   2669: aload_2
    //   2670: astore 19
    //   2672: aload 17
    //   2674: astore 20
    //   2676: aload_0
    //   2677: getfield 101	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRy	Ljava/util/Map;
    //   2680: aload_3
    //   2681: invokeinterface 429 2 0
    //   2686: pop
    //   2687: aload_2
    //   2688: astore 19
    //   2690: aload 17
    //   2692: astore 20
    //   2694: iconst_3
    //   2695: aload 23
    //   2697: ldc_w 707
    //   2700: iload 5
    //   2702: invokestatic 502	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2705: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2708: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2711: aload_2
    //   2712: astore 19
    //   2714: aload 17
    //   2716: astore 20
    //   2718: aload_1
    //   2719: iload 5
    //   2721: putfield 705	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQV	I
    //   2724: aload_2
    //   2725: astore 19
    //   2727: aload 17
    //   2729: astore 20
    //   2731: aload_1
    //   2732: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   2735: putfield 710	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQW	J
    //   2738: aload_2
    //   2739: astore 19
    //   2741: aload 17
    //   2743: astore 20
    //   2745: iconst_4
    //   2746: aload 23
    //   2748: ldc_w 712
    //   2751: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2754: aload_2
    //   2755: astore 19
    //   2757: aload 17
    //   2759: astore 20
    //   2761: aload 27
    //   2763: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2766: astore_3
    //   2767: iload 7
    //   2769: ifeq +439 -> 3208
    //   2772: aload_2
    //   2773: astore 19
    //   2775: aload 17
    //   2777: astore 20
    //   2779: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2782: getfield 715	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPz	Z
    //   2785: ifeq +423 -> 3208
    //   2788: ldc_w 717
    //   2791: astore_1
    //   2792: aload_2
    //   2793: astore 19
    //   2795: aload 17
    //   2797: astore 20
    //   2799: aload_3
    //   2800: ldc_w 719
    //   2803: aload_1
    //   2804: invokevirtual 722	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2807: astore_1
    //   2808: aload_2
    //   2809: astore 19
    //   2811: aload 17
    //   2813: astore 20
    //   2815: iconst_4
    //   2816: aload 23
    //   2818: ldc_w 724
    //   2821: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2824: aload_2
    //   2825: astore 19
    //   2827: aload 17
    //   2829: astore 20
    //   2831: iconst_4
    //   2832: aload 23
    //   2834: aload_1
    //   2835: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2838: aload_2
    //   2839: astore 19
    //   2841: aload 17
    //   2843: astore 20
    //   2845: iconst_4
    //   2846: aload 23
    //   2848: ldc_w 726
    //   2851: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2854: aload_2
    //   2855: astore 19
    //   2857: aload 17
    //   2859: astore 20
    //   2861: aload 17
    //   2863: aload_1
    //   2864: invokevirtual 730	java/lang/String:getBytes	()[B
    //   2867: invokevirtual 734	java/io/OutputStream:write	([B)V
    //   2870: aload_2
    //   2871: invokevirtual 668	java/io/BufferedReader:close	()V
    //   2874: iconst_0
    //   2875: istore 5
    //   2877: iload 5
    //   2879: istore 6
    //   2881: aload 17
    //   2883: ifnull +12 -> 2895
    //   2886: aload 17
    //   2888: invokevirtual 671	java/io/OutputStream:close	()V
    //   2891: iload 5
    //   2893: istore 6
    //   2895: iload 11
    //   2897: ifne +679 -> 3576
    //   2900: aload 4
    //   2902: iconst_1
    //   2903: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2906: ifeq +8 -> 2914
    //   2909: aload 4
    //   2911: invokevirtual 667	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjZ	()V
    //   2914: aload 24
    //   2916: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2919: ifeq +56 -> 2975
    //   2922: aload 24
    //   2924: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2927: ifeq +48 -> 2975
    //   2930: aload 24
    //   2932: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   2935: istore 14
    //   2937: iconst_4
    //   2938: aload 23
    //   2940: new 115	java/lang/StringBuilder
    //   2943: dup
    //   2944: ldc_w 736
    //   2947: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2950: aload 24
    //   2952: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2955: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2958: ldc_w 681
    //   2961: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2964: iload 14
    //   2966: invokevirtual 684	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2969: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2972: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2975: ldc_w 475
    //   2978: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2981: aconst_null
    //   2982: areturn
    //   2983: aload_2
    //   2984: astore 19
    //   2986: aload 17
    //   2988: astore 20
    //   2990: iload 5
    //   2992: aload_1
    //   2993: getfield 705	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQV	I
    //   2996: if_icmpge +81 -> 3077
    //   2999: aload_2
    //   3000: astore 19
    //   3002: aload 17
    //   3004: astore 20
    //   3006: new 296	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3009: dup
    //   3010: new 115	java/lang/StringBuilder
    //   3013: dup
    //   3014: ldc_w 738
    //   3017: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3020: aload_1
    //   3021: getfield 705	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQV	I
    //   3024: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3027: ldc_w 740
    //   3030: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3033: iload 5
    //   3035: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3038: ldc_w 742
    //   3041: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: aload_3
    //   3045: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3048: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3051: invokespecial 664	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   3054: astore_1
    //   3055: aload_2
    //   3056: astore 19
    //   3058: aload 17
    //   3060: astore 20
    //   3062: ldc_w 475
    //   3065: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3068: aload_2
    //   3069: astore 19
    //   3071: aload 17
    //   3073: astore 20
    //   3075: aload_1
    //   3076: athrow
    //   3077: aload_2
    //   3078: astore 19
    //   3080: aload 17
    //   3082: astore 20
    //   3084: iload 5
    //   3086: aload_1
    //   3087: getfield 705	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQV	I
    //   3090: if_icmpne -379 -> 2711
    //   3093: aload_2
    //   3094: astore 19
    //   3096: aload 17
    //   3098: astore 20
    //   3100: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   3103: aload_1
    //   3104: getfield 710	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:kQW	J
    //   3107: lsub
    //   3108: lstore 15
    //   3110: lload 15
    //   3112: iload 6
    //   3114: sipush 1000
    //   3117: imul
    //   3118: i2l
    //   3119: lcmp
    //   3120: ifle -382 -> 2738
    //   3123: aload_2
    //   3124: astore 19
    //   3126: aload 17
    //   3128: astore 20
    //   3130: aload_0
    //   3131: getfield 101	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRy	Ljava/util/Map;
    //   3134: aload_3
    //   3135: aload_1
    //   3136: invokeinterface 564 3 0
    //   3141: pop
    //   3142: aload_2
    //   3143: astore 19
    //   3145: aload 17
    //   3147: astore 20
    //   3149: new 296	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3152: dup
    //   3153: new 115	java/lang/StringBuilder
    //   3156: dup
    //   3157: ldc_w 744
    //   3160: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3163: lload 15
    //   3165: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3168: ldc_w 746
    //   3171: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3174: iload 6
    //   3176: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3179: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3182: invokespecial 664	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   3185: astore_1
    //   3186: aload_2
    //   3187: astore 19
    //   3189: aload 17
    //   3191: astore 20
    //   3193: ldc_w 475
    //   3196: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3199: aload_2
    //   3200: astore 19
    //   3202: aload 17
    //   3204: astore 20
    //   3206: aload_1
    //   3207: athrow
    //   3208: ldc_w 748
    //   3211: astore_1
    //   3212: goto -420 -> 2792
    //   3215: astore_1
    //   3216: bipush 6
    //   3218: aload 23
    //   3220: new 115	java/lang/StringBuilder
    //   3223: dup
    //   3224: ldc_w 750
    //   3227: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3230: aload_1
    //   3231: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3234: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3237: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3240: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3243: iconst_1
    //   3244: istore 5
    //   3246: goto -369 -> 2877
    //   3249: astore_1
    //   3250: bipush 6
    //   3252: aload 23
    //   3254: new 115	java/lang/StringBuilder
    //   3257: dup
    //   3258: ldc_w 752
    //   3261: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3264: aload_1
    //   3265: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3268: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3271: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3274: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3277: iconst_1
    //   3278: istore 6
    //   3280: goto -385 -> 2895
    //   3283: astore_1
    //   3284: bipush 6
    //   3286: aload 23
    //   3288: new 115	java/lang/StringBuilder
    //   3291: dup
    //   3292: ldc_w 750
    //   3295: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3298: aload_1
    //   3299: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3302: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3305: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3308: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3311: goto -1198 -> 2113
    //   3314: astore_1
    //   3315: bipush 6
    //   3317: aload 23
    //   3319: new 115	java/lang/StringBuilder
    //   3322: dup
    //   3323: ldc_w 752
    //   3326: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3329: aload_1
    //   3330: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3333: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3339: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3342: goto -1221 -> 2121
    //   3345: bipush 6
    //   3347: aload 23
    //   3349: new 115	java/lang/StringBuilder
    //   3352: dup
    //   3353: ldc_w 754
    //   3356: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3359: aload_3
    //   3360: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3363: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3369: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3372: ldc_w 475
    //   3375: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3378: aload_3
    //   3379: athrow
    //   3380: astore 17
    //   3382: aload_1
    //   3383: astore_3
    //   3384: aload_2
    //   3385: astore 4
    //   3387: iconst_1
    //   3388: istore 5
    //   3390: aload 17
    //   3392: astore_1
    //   3393: aload_3
    //   3394: astore_2
    //   3395: aload 4
    //   3397: astore_3
    //   3398: goto -854 -> 2544
    //   3401: astore_1
    //   3402: bipush 6
    //   3404: aload 23
    //   3406: new 115	java/lang/StringBuilder
    //   3409: dup
    //   3410: ldc_w 750
    //   3413: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3416: aload_1
    //   3417: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3420: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3426: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3429: goto -1018 -> 2411
    //   3432: astore_1
    //   3433: bipush 6
    //   3435: aload 23
    //   3437: new 115	java/lang/StringBuilder
    //   3440: dup
    //   3441: ldc_w 752
    //   3444: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3447: aload_1
    //   3448: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3451: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3457: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3460: goto -1041 -> 2419
    //   3463: bipush 6
    //   3465: aload 23
    //   3467: new 115	java/lang/StringBuilder
    //   3470: dup
    //   3471: ldc_w 756
    //   3474: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3477: aload_1
    //   3478: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3481: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3490: new 296	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3493: dup
    //   3494: aload_1
    //   3495: invokespecial 759	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/Throwable;)V
    //   3498: astore_1
    //   3499: ldc_w 475
    //   3502: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3505: aload_1
    //   3506: athrow
    //   3507: astore_1
    //   3508: iconst_1
    //   3509: istore 5
    //   3511: goto -967 -> 2544
    //   3514: astore_2
    //   3515: bipush 6
    //   3517: aload 23
    //   3519: new 115	java/lang/StringBuilder
    //   3522: dup
    //   3523: ldc_w 750
    //   3526: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3529: aload_2
    //   3530: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3533: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3536: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3539: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3542: goto -990 -> 2552
    //   3545: astore_2
    //   3546: bipush 6
    //   3548: aload 23
    //   3550: new 115	java/lang/StringBuilder
    //   3553: dup
    //   3554: ldc_w 752
    //   3557: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3560: aload_2
    //   3561: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3564: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3570: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3573: goto -1013 -> 2560
    //   3576: iload 6
    //   3578: ifeq +72 -> 3650
    //   3581: aload 24
    //   3583: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   3586: ifeq +56 -> 3642
    //   3589: aload 24
    //   3591: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   3594: ifeq +48 -> 3642
    //   3597: aload 24
    //   3599: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   3602: istore 14
    //   3604: iconst_4
    //   3605: aload 23
    //   3607: new 115	java/lang/StringBuilder
    //   3610: dup
    //   3611: ldc_w 761
    //   3614: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3617: aload 24
    //   3619: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   3622: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: ldc_w 681
    //   3628: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: iload 14
    //   3633: invokevirtual 684	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3636: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3639: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3642: ldc_w 475
    //   3645: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3648: aconst_null
    //   3649: areturn
    //   3650: ldc_w 475
    //   3653: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3656: aload 24
    //   3658: areturn
    //   3659: astore_1
    //   3660: aconst_null
    //   3661: astore_2
    //   3662: aconst_null
    //   3663: astore_3
    //   3664: iconst_0
    //   3665: istore 5
    //   3667: goto -1123 -> 2544
    //   3670: astore_1
    //   3671: aconst_null
    //   3672: astore_3
    //   3673: iconst_0
    //   3674: istore 5
    //   3676: goto -1132 -> 2544
    //   3679: astore 17
    //   3681: aload_1
    //   3682: astore_3
    //   3683: aload_2
    //   3684: astore 4
    //   3686: iconst_0
    //   3687: istore 5
    //   3689: aload 17
    //   3691: astore_1
    //   3692: aload_3
    //   3693: astore_2
    //   3694: aload 4
    //   3696: astore_3
    //   3697: goto -1153 -> 2544
    //   3700: astore_1
    //   3701: aconst_null
    //   3702: astore_2
    //   3703: aconst_null
    //   3704: astore_3
    //   3705: goto -1328 -> 2377
    //   3708: astore_1
    //   3709: aconst_null
    //   3710: astore_3
    //   3711: goto -1334 -> 2377
    //   3714: astore_3
    //   3715: aconst_null
    //   3716: astore_1
    //   3717: aload 17
    //   3719: astore_2
    //   3720: goto -1629 -> 2091
    //   3723: astore_3
    //   3724: aload_2
    //   3725: astore_1
    //   3726: aload 17
    //   3728: astore_2
    //   3729: goto -1638 -> 2091
    //   3732: goto -3030 -> 702
    //   3735: goto -3068 -> 667
    //   3738: iload 7
    //   3740: istore 11
    //   3742: iload 9
    //   3744: istore 12
    //   3746: iload 8
    //   3748: istore 7
    //   3750: goto -3165 -> 585
    //   3753: aload_1
    //   3754: astore 18
    //   3756: goto -3260 -> 496
    //   3759: goto +9 -> 3768
    //   3762: iload 10
    //   3764: iconst_1
    //   3765: iadd
    //   3766: istore 10
    //   3768: iload 5
    //   3770: istore 11
    //   3772: aload 18
    //   3774: astore_1
    //   3775: iload 6
    //   3777: istore 12
    //   3779: iload 7
    //   3781: istore 6
    //   3783: iload 8
    //   3785: istore 5
    //   3787: iload 11
    //   3789: istore 8
    //   3791: iload 12
    //   3793: istore 7
    //   3795: goto -3471 -> 324
    //   3798: iconst_0
    //   3799: istore 5
    //   3801: goto -3621 -> 180
    //   3804: iconst_3
    //   3805: istore 13
    //   3807: goto -3604 -> 203
    //   3810: iconst_0
    //   3811: istore 11
    //   3813: goto -3473 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3816	0	this	m
    //   0	3816	1	parame	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e
    //   0	3816	2	paramg	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g
    //   0	3816	3	paramString	String
    //   0	3816	4	paramn	n
    //   178	3622	5	i	int
    //   159	3623	6	j	int
    //   318	3476	7	k	int
    //   295	3495	8	m	int
    //   162	3581	9	n	int
    //   153	3614	10	i1	int
    //   156	3656	11	i2	int
    //   560	3232	12	i3	int
    //   201	3605	13	i4	int
    //   2142	1490	14	bool	boolean
    //   3108	56	15	l	long
    //   35	3168	17	localObject1	Object
    //   3380	11	17	localObject2	Object
    //   3679	48	17	localObject3	Object
    //   69	3704	18	localObject4	Object
    //   279	2922	19	localg	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g
    //   283	2922	20	localObject5	Object
    //   954	997	21	str1	String
    //   896	969	22	localObject6	Object
    //   27	3579	23	str2	String
    //   133	3524	24	locale	com.tencent.mm.vfs.e
    //   185	297	25	str3	String
    //   240	1132	26	localPattern	java.util.regex.Pattern
    //   292	2470	27	localStringBuilder	StringBuilder
    //   372	1610	28	str4	String
    //   929	683	29	str5	String
    // Exception table:
    //   from	to	target	type
    //   285	294	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   304	313	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   331	337	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   352	361	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   368	374	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   386	394	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   401	412	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   419	433	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   440	454	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   461	470	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   477	496	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   503	517	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   529	538	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   545	556	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   569	582	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   592	606	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   619	632	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   639	653	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   660	667	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   674	688	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   695	702	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   717	731	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   746	763	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   776	789	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   796	810	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   817	825	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   832	839	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   846	853	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   860	867	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   874	881	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   888	898	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   905	915	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   922	931	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   938	956	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   966	974	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   981	1011	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1018	1039	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1046	1069	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1106	1117	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1124	1135	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1142	1153	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1172	1179	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1186	1200	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1207	1224	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1231	1240	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1247	1254	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1261	1267	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1274	1282	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1292	1306	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1350	1364	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1371	1379	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1386	1393	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1400	1407	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1414	1421	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1428	1435	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1442	1452	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1459	1469	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1476	1485	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1492	1510	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1520	1528	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1535	1565	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1572	1593	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1600	1623	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1667	1681	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1725	1739	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1783	1794	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1801	1809	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1816	1831	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1842	1850	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1857	1888	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1895	1918	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1925	1939	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   1979	1993	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2036	2045	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2052	2063	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2070	2076	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2083	2085	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2201	2210	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2217	2226	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2233	2243	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2255	2261	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2268	2281	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2288	2306	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2313	2327	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2340	2351	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2358	2364	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2371	2373	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2501	2512	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2519	2525	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2532	2534	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2641	2649	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2656	2669	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2676	2687	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2694	2711	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2718	2724	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2731	2738	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2745	2754	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2761	2767	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2779	2788	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2799	2808	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2815	2824	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2831	2838	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2845	2854	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2861	2870	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2990	2999	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3006	3055	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3062	3068	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3075	3077	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3084	3093	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3100	3110	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3130	3142	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3149	3186	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3193	3199	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3206	3208	2085	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   285	294	2373	java/lang/Exception
    //   304	313	2373	java/lang/Exception
    //   331	337	2373	java/lang/Exception
    //   352	361	2373	java/lang/Exception
    //   368	374	2373	java/lang/Exception
    //   386	394	2373	java/lang/Exception
    //   401	412	2373	java/lang/Exception
    //   419	433	2373	java/lang/Exception
    //   440	454	2373	java/lang/Exception
    //   461	470	2373	java/lang/Exception
    //   477	496	2373	java/lang/Exception
    //   503	517	2373	java/lang/Exception
    //   529	538	2373	java/lang/Exception
    //   545	556	2373	java/lang/Exception
    //   569	582	2373	java/lang/Exception
    //   592	606	2373	java/lang/Exception
    //   619	632	2373	java/lang/Exception
    //   639	653	2373	java/lang/Exception
    //   660	667	2373	java/lang/Exception
    //   674	688	2373	java/lang/Exception
    //   695	702	2373	java/lang/Exception
    //   717	731	2373	java/lang/Exception
    //   746	763	2373	java/lang/Exception
    //   776	789	2373	java/lang/Exception
    //   796	810	2373	java/lang/Exception
    //   817	825	2373	java/lang/Exception
    //   832	839	2373	java/lang/Exception
    //   846	853	2373	java/lang/Exception
    //   860	867	2373	java/lang/Exception
    //   874	881	2373	java/lang/Exception
    //   888	898	2373	java/lang/Exception
    //   905	915	2373	java/lang/Exception
    //   922	931	2373	java/lang/Exception
    //   938	956	2373	java/lang/Exception
    //   966	974	2373	java/lang/Exception
    //   981	1011	2373	java/lang/Exception
    //   1018	1039	2373	java/lang/Exception
    //   1046	1069	2373	java/lang/Exception
    //   1106	1117	2373	java/lang/Exception
    //   1124	1135	2373	java/lang/Exception
    //   1142	1153	2373	java/lang/Exception
    //   1172	1179	2373	java/lang/Exception
    //   1186	1200	2373	java/lang/Exception
    //   1207	1224	2373	java/lang/Exception
    //   1231	1240	2373	java/lang/Exception
    //   1247	1254	2373	java/lang/Exception
    //   1261	1267	2373	java/lang/Exception
    //   1274	1282	2373	java/lang/Exception
    //   1292	1306	2373	java/lang/Exception
    //   1350	1364	2373	java/lang/Exception
    //   1371	1379	2373	java/lang/Exception
    //   1386	1393	2373	java/lang/Exception
    //   1400	1407	2373	java/lang/Exception
    //   1414	1421	2373	java/lang/Exception
    //   1428	1435	2373	java/lang/Exception
    //   1442	1452	2373	java/lang/Exception
    //   1459	1469	2373	java/lang/Exception
    //   1476	1485	2373	java/lang/Exception
    //   1492	1510	2373	java/lang/Exception
    //   1520	1528	2373	java/lang/Exception
    //   1535	1565	2373	java/lang/Exception
    //   1572	1593	2373	java/lang/Exception
    //   1600	1623	2373	java/lang/Exception
    //   1667	1681	2373	java/lang/Exception
    //   1725	1739	2373	java/lang/Exception
    //   1783	1794	2373	java/lang/Exception
    //   1801	1809	2373	java/lang/Exception
    //   1816	1831	2373	java/lang/Exception
    //   1842	1850	2373	java/lang/Exception
    //   1857	1888	2373	java/lang/Exception
    //   1895	1918	2373	java/lang/Exception
    //   1925	1939	2373	java/lang/Exception
    //   1979	1993	2373	java/lang/Exception
    //   2036	2045	2373	java/lang/Exception
    //   2052	2063	2373	java/lang/Exception
    //   2070	2076	2373	java/lang/Exception
    //   2083	2085	2373	java/lang/Exception
    //   2201	2210	2373	java/lang/Exception
    //   2217	2226	2373	java/lang/Exception
    //   2233	2243	2373	java/lang/Exception
    //   2255	2261	2373	java/lang/Exception
    //   2268	2281	2373	java/lang/Exception
    //   2288	2306	2373	java/lang/Exception
    //   2313	2327	2373	java/lang/Exception
    //   2340	2351	2373	java/lang/Exception
    //   2358	2364	2373	java/lang/Exception
    //   2371	2373	2373	java/lang/Exception
    //   2501	2512	2373	java/lang/Exception
    //   2519	2525	2373	java/lang/Exception
    //   2532	2534	2373	java/lang/Exception
    //   2641	2649	2373	java/lang/Exception
    //   2656	2669	2373	java/lang/Exception
    //   2676	2687	2373	java/lang/Exception
    //   2694	2711	2373	java/lang/Exception
    //   2718	2724	2373	java/lang/Exception
    //   2731	2738	2373	java/lang/Exception
    //   2745	2754	2373	java/lang/Exception
    //   2761	2767	2373	java/lang/Exception
    //   2779	2788	2373	java/lang/Exception
    //   2799	2808	2373	java/lang/Exception
    //   2815	2824	2373	java/lang/Exception
    //   2831	2838	2373	java/lang/Exception
    //   2845	2854	2373	java/lang/Exception
    //   2861	2870	2373	java/lang/Exception
    //   2990	2999	2373	java/lang/Exception
    //   3006	3055	2373	java/lang/Exception
    //   3062	3068	2373	java/lang/Exception
    //   3075	3077	2373	java/lang/Exception
    //   3084	3093	2373	java/lang/Exception
    //   3100	3110	2373	java/lang/Exception
    //   3130	3142	2373	java/lang/Exception
    //   3149	3186	2373	java/lang/Exception
    //   3193	3199	2373	java/lang/Exception
    //   3206	3208	2373	java/lang/Exception
    //   285	294	2534	finally
    //   304	313	2534	finally
    //   331	337	2534	finally
    //   352	361	2534	finally
    //   368	374	2534	finally
    //   386	394	2534	finally
    //   401	412	2534	finally
    //   419	433	2534	finally
    //   440	454	2534	finally
    //   461	470	2534	finally
    //   477	496	2534	finally
    //   503	517	2534	finally
    //   529	538	2534	finally
    //   545	556	2534	finally
    //   569	582	2534	finally
    //   592	606	2534	finally
    //   619	632	2534	finally
    //   639	653	2534	finally
    //   660	667	2534	finally
    //   674	688	2534	finally
    //   695	702	2534	finally
    //   717	731	2534	finally
    //   746	763	2534	finally
    //   776	789	2534	finally
    //   796	810	2534	finally
    //   817	825	2534	finally
    //   832	839	2534	finally
    //   846	853	2534	finally
    //   860	867	2534	finally
    //   874	881	2534	finally
    //   888	898	2534	finally
    //   905	915	2534	finally
    //   922	931	2534	finally
    //   938	956	2534	finally
    //   966	974	2534	finally
    //   981	1011	2534	finally
    //   1018	1039	2534	finally
    //   1046	1069	2534	finally
    //   1106	1117	2534	finally
    //   1124	1135	2534	finally
    //   1142	1153	2534	finally
    //   1172	1179	2534	finally
    //   1186	1200	2534	finally
    //   1207	1224	2534	finally
    //   1231	1240	2534	finally
    //   1247	1254	2534	finally
    //   1261	1267	2534	finally
    //   1274	1282	2534	finally
    //   1292	1306	2534	finally
    //   1350	1364	2534	finally
    //   1371	1379	2534	finally
    //   1386	1393	2534	finally
    //   1400	1407	2534	finally
    //   1414	1421	2534	finally
    //   1428	1435	2534	finally
    //   1442	1452	2534	finally
    //   1459	1469	2534	finally
    //   1476	1485	2534	finally
    //   1492	1510	2534	finally
    //   1520	1528	2534	finally
    //   1535	1565	2534	finally
    //   1572	1593	2534	finally
    //   1600	1623	2534	finally
    //   1667	1681	2534	finally
    //   1725	1739	2534	finally
    //   1783	1794	2534	finally
    //   1801	1809	2534	finally
    //   1816	1831	2534	finally
    //   1842	1850	2534	finally
    //   1857	1888	2534	finally
    //   1895	1918	2534	finally
    //   1925	1939	2534	finally
    //   1979	1993	2534	finally
    //   2036	2045	2534	finally
    //   2052	2063	2534	finally
    //   2070	2076	2534	finally
    //   2083	2085	2534	finally
    //   2201	2210	2534	finally
    //   2217	2226	2534	finally
    //   2233	2243	2534	finally
    //   2255	2261	2534	finally
    //   2268	2281	2534	finally
    //   2288	2306	2534	finally
    //   2313	2327	2534	finally
    //   2340	2351	2534	finally
    //   2358	2364	2534	finally
    //   2371	2373	2534	finally
    //   2383	2392	2534	finally
    //   2398	2403	2534	finally
    //   2501	2512	2534	finally
    //   2519	2525	2534	finally
    //   2532	2534	2534	finally
    //   2641	2649	2534	finally
    //   2656	2669	2534	finally
    //   2676	2687	2534	finally
    //   2694	2711	2534	finally
    //   2718	2724	2534	finally
    //   2731	2738	2534	finally
    //   2745	2754	2534	finally
    //   2761	2767	2534	finally
    //   2779	2788	2534	finally
    //   2799	2808	2534	finally
    //   2815	2824	2534	finally
    //   2831	2838	2534	finally
    //   2845	2854	2534	finally
    //   2861	2870	2534	finally
    //   2990	2999	2534	finally
    //   3006	3055	2534	finally
    //   3062	3068	2534	finally
    //   3075	3077	2534	finally
    //   3084	3093	2534	finally
    //   3100	3110	2534	finally
    //   3130	3142	2534	finally
    //   3149	3186	2534	finally
    //   3193	3199	2534	finally
    //   3206	3208	2534	finally
    //   2870	2874	3215	java/io/IOException
    //   2886	2891	3249	java/io/IOException
    //   2109	2113	3283	java/io/IOException
    //   2117	2121	3314	java/io/IOException
    //   3345	3380	3380	finally
    //   2407	2411	3401	java/io/IOException
    //   2415	2419	3432	java/io/IOException
    //   3463	3507	3507	finally
    //   2548	2552	3514	java/io/IOException
    //   2556	2560	3545	java/io/IOException
    //   242	269	3659	finally
    //   269	275	3670	finally
    //   2091	2105	3679	finally
    //   242	269	3700	java/lang/Exception
    //   269	275	3708	java/lang/Exception
    //   242	269	3714	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   269	275	3723	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
  }
  
  /* Error */
  private void a(Socket paramSocket, String paramString, java.io.OutputStream paramOutputStream, n paramn)
  {
    // Byte code:
    //   0: ldc_w 978
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 115	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 400
    //   13: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload 4
    //   18: getfield 405	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRO	I
    //   21: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 34
    //   29: new 115	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 484	java/lang/StringBuilder:<init>	()V
    //   36: aload 34
    //   38: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 486
    //   44: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 28
    //   52: aload 4
    //   54: getfield 910	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRT	Ljava/lang/String;
    //   57: astore 35
    //   59: aload_0
    //   60: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRv	Ljava/util/concurrent/ConcurrentHashMap;
    //   63: aload 35
    //   65: invokevirtual 979	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 981	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/e
    //   71: astore 29
    //   73: new 983	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/i
    //   76: dup
    //   77: aload_0
    //   78: getfield 141	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kPL	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/a;
    //   81: aload 29
    //   83: aload 4
    //   85: invokespecial 986	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/i:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/a;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/e;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/n;)V
    //   88: aload_2
    //   89: aload 28
    //   91: invokeinterface 992 3 0
    //   96: astore 28
    //   98: aload 28
    //   100: ifnonnull +20 -> 120
    //   103: bipush 6
    //   105: aload 34
    //   107: ldc_w 994
    //   110: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   113: ldc_w 978
    //   116: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: iconst_0
    //   121: istore 6
    //   123: iconst_0
    //   124: istore 8
    //   126: iconst_0
    //   127: istore 7
    //   129: ldc2_w 995
    //   132: lstore 21
    //   134: ldc_w 997
    //   137: newarray byte
    //   139: astore 32
    //   141: getstatic 1003	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:kQO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   144: astore 30
    //   146: ldc2_w 995
    //   149: lstore 15
    //   151: aload 4
    //   153: getfield 916	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRR	J
    //   156: lstore 25
    //   158: aload 4
    //   160: getfield 913	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRQ	J
    //   163: lstore 17
    //   165: lload 15
    //   167: lstore 13
    //   169: lload 25
    //   171: ldc2_w 995
    //   174: lcmp
    //   175: ifeq +25 -> 200
    //   178: lload 15
    //   180: lstore 13
    //   182: lload 25
    //   184: ldc2_w 1004
    //   187: lcmp
    //   188: ifeq +12 -> 200
    //   191: lload 25
    //   193: lload 17
    //   195: lsub
    //   196: lconst_1
    //   197: ladd
    //   198: lstore 13
    //   200: aload_2
    //   201: invokestatic 1009	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   204: astore 29
    //   206: lload 17
    //   208: ldc2_w 995
    //   211: lcmp
    //   212: ifne +157 -> 369
    //   215: lconst_0
    //   216: lstore 15
    //   218: lload 17
    //   220: ldc2_w 995
    //   223: lcmp
    //   224: ifne +152 -> 376
    //   227: lconst_0
    //   228: lstore 19
    //   230: new 307	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g
    //   233: dup
    //   234: aload 29
    //   236: lload 15
    //   238: lload 19
    //   240: lload 13
    //   242: aload 35
    //   244: iconst_0
    //   245: aload 4
    //   247: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   250: aload 4
    //   252: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   255: invokespecial 391	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;I)V
    //   258: astore 33
    //   260: new 1011	java/io/BufferedOutputStream
    //   263: dup
    //   264: aload_3
    //   265: invokespecial 1014	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   268: astore 36
    //   270: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   273: lstore 23
    //   275: iconst_1
    //   276: istore 5
    //   278: ldc2_w 420
    //   281: lstore 19
    //   283: aload_0
    //   284: aload 28
    //   286: aload 33
    //   288: aload_2
    //   289: aload 34
    //   291: aload 4
    //   293: aload_1
    //   294: aload 35
    //   296: invokespecial 1016	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/n;Ljava/net/Socket;Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a;
    //   299: astore_3
    //   300: aload_3
    //   301: getfield 463	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:Xz	Z
    //   304: ifeq +110 -> 414
    //   307: iconst_4
    //   308: aload 34
    //   310: ldc_w 1018
    //   313: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   316: iconst_4
    //   317: aload 34
    //   319: new 115	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 1020
    //   326: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: lload 17
    //   331: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc_w 1022
    //   337: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 25
    //   342: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   351: aload 28
    //   353: invokeinterface 1023 1 0
    //   358: aload_1
    //   359: invokevirtual 442	java/net/Socket:close	()V
    //   362: ldc_w 978
    //   365: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: lload 17
    //   371: lstore 15
    //   373: goto -155 -> 218
    //   376: lload 17
    //   378: lstore 19
    //   380: goto -150 -> 230
    //   383: astore_2
    //   384: iconst_5
    //   385: aload 34
    //   387: ldc_w 1025
    //   390: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   393: goto -35 -> 358
    //   396: astore_1
    //   397: iconst_5
    //   398: aload 34
    //   400: ldc_w 1027
    //   403: aload_1
    //   404: invokestatic 468	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   407: ldc_w 978
    //   410: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: return
    //   414: aload_3
    //   415: getfield 303	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:kRD	J
    //   418: lstore 13
    //   420: aload_3
    //   421: getfield 335	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:kRF	Lcom/tencent/mm/vfs/e;
    //   424: astore 29
    //   426: aload_3
    //   427: getfield 395	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:kRE	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   430: ifnull +1551 -> 1981
    //   433: aload_3
    //   434: getfield 395	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:kRE	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   437: astore_3
    //   438: aload_3
    //   439: invokeinterface 1028 1 0
    //   444: lstore 15
    //   446: aload_3
    //   447: invokeinterface 1032 1 0
    //   452: astore 31
    //   454: aload 31
    //   456: astore 30
    //   458: aload 4
    //   460: lload 15
    //   462: aload 31
    //   464: invokevirtual 1035	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:a	(JLcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;)V
    //   467: aload 31
    //   469: astore 30
    //   471: aload 31
    //   473: getstatic 1003	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:kQO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   476: invokevirtual 1036	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:equals	(Ljava/lang/Object;)Z
    //   479: ifeq +17 -> 496
    //   482: aload 31
    //   484: astore 30
    //   486: bipush 6
    //   488: aload 34
    //   490: ldc_w 1038
    //   493: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   496: aload 31
    //   498: astore 30
    //   500: aload 31
    //   502: invokevirtual 1039	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:toString	()Ljava/lang/String;
    //   505: astore 28
    //   507: aload 31
    //   509: astore 30
    //   511: aload_2
    //   512: invokestatic 312	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:NB	(Ljava/lang/String;)Z
    //   515: ifne +1597 -> 2112
    //   518: iconst_1
    //   519: istore 27
    //   521: aload 31
    //   523: astore 30
    //   525: lload 17
    //   527: lload 25
    //   529: lload 15
    //   531: aload 28
    //   533: iload 27
    //   535: invokestatic 1042	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:a	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   538: astore 28
    //   540: aload 31
    //   542: astore 30
    //   544: iconst_4
    //   545: aload 34
    //   547: new 115	java/lang/StringBuilder
    //   550: dup
    //   551: ldc_w 1044
    //   554: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   557: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   560: lload 23
    //   562: lsub
    //   563: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   566: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   572: aload 31
    //   574: astore 30
    //   576: iconst_4
    //   577: aload 34
    //   579: new 115	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 1046
    //   586: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: lload 15
    //   591: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   594: ldc_w 1048
    //   597: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload 28
    //   602: invokestatic 893	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:NH	(Ljava/lang/String;)Ljava/lang/String;
    //   605: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   614: aload 31
    //   616: astore 30
    //   618: aload 36
    //   620: aload 28
    //   622: ldc_w 519
    //   625: invokevirtual 1051	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   628: invokevirtual 734	java/io/OutputStream:write	([B)V
    //   631: aload 31
    //   633: astore 30
    //   635: aload 36
    //   637: invokevirtual 1054	java/io/OutputStream:flush	()V
    //   640: aload 31
    //   642: astore 30
    //   644: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   647: lstore 21
    //   649: iconst_1
    //   650: istore 5
    //   652: iconst_0
    //   653: istore 6
    //   655: iload 5
    //   657: istore 8
    //   659: iload 6
    //   661: istore 7
    //   663: iload 5
    //   665: istore 10
    //   667: iload 6
    //   669: istore 9
    //   671: iload 6
    //   673: istore 11
    //   675: invokestatic 534	java/lang/Thread:interrupted	()Z
    //   678: ifne +1440 -> 2118
    //   681: iconst_1
    //   682: istore 5
    //   684: iload 5
    //   686: ifeq +1823 -> 2509
    //   689: iload 5
    //   691: istore 8
    //   693: iload 6
    //   695: istore 7
    //   697: iload 5
    //   699: istore 10
    //   701: iload 6
    //   703: istore 9
    //   705: iload 6
    //   707: istore 11
    //   709: aload 4
    //   711: iconst_1
    //   712: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   715: ifne +1794 -> 2509
    //   718: iload 5
    //   720: istore 8
    //   722: iload 6
    //   724: istore 7
    //   726: iload 5
    //   728: istore 10
    //   730: iload 6
    //   732: istore 9
    //   734: iload 6
    //   736: istore 11
    //   738: aload_3
    //   739: aload 32
    //   741: iconst_0
    //   742: ldc_w 997
    //   745: invokeinterface 1058 4 0
    //   750: istore 12
    //   752: iload 12
    //   754: iconst_m1
    //   755: if_icmpeq +1754 -> 2509
    //   758: iload 5
    //   760: istore 8
    //   762: iload 6
    //   764: istore 7
    //   766: iload 5
    //   768: istore 10
    //   770: iload 6
    //   772: istore 9
    //   774: iload 6
    //   776: istore 11
    //   778: aload 4
    //   780: getfield 904	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRW	Ljava/lang/String;
    //   783: ifnull +1341 -> 2124
    //   786: iload 5
    //   788: istore 8
    //   790: iload 6
    //   792: istore 7
    //   794: iload 5
    //   796: istore 10
    //   798: iload 6
    //   800: istore 9
    //   802: iload 6
    //   804: istore 11
    //   806: aload 4
    //   808: getfield 904	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRW	Ljava/lang/String;
    //   811: invokevirtual 1061	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   814: ldc_w 1063
    //   817: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   820: ifeq +1304 -> 2124
    //   823: iconst_1
    //   824: istore 7
    //   826: iload 7
    //   828: ifne +1681 -> 2509
    //   831: iload 5
    //   833: istore 8
    //   835: iload 6
    //   837: istore 7
    //   839: iload 5
    //   841: istore 10
    //   843: iload 6
    //   845: istore 9
    //   847: iload 6
    //   849: istore 11
    //   851: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   854: lload 21
    //   856: lsub
    //   857: lstore 21
    //   859: lload 21
    //   861: ldc2_w 1064
    //   864: lcmp
    //   865: ifle +53 -> 918
    //   868: iload 5
    //   870: istore 8
    //   872: iload 6
    //   874: istore 7
    //   876: iload 5
    //   878: istore 10
    //   880: iload 6
    //   882: istore 9
    //   884: iload 6
    //   886: istore 11
    //   888: iconst_5
    //   889: aload 34
    //   891: new 115	java/lang/StringBuilder
    //   894: dup
    //   895: ldc_w 1067
    //   898: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   901: lload 21
    //   903: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   906: ldc_w 1069
    //   909: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   918: iload 5
    //   920: istore 8
    //   922: iload 6
    //   924: istore 7
    //   926: iload 5
    //   928: istore 10
    //   930: iload 6
    //   932: istore 9
    //   934: iload 6
    //   936: istore 11
    //   938: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   941: lstore 21
    //   943: iload 6
    //   945: ifne +1248 -> 2193
    //   948: lload 17
    //   950: lconst_0
    //   951: lcmp
    //   952: ifne +1241 -> 2193
    //   955: aconst_null
    //   956: astore 28
    //   958: iload 5
    //   960: istore 8
    //   962: iload 6
    //   964: istore 7
    //   966: iload 5
    //   968: istore 10
    //   970: iload 6
    //   972: istore 9
    //   974: iload 6
    //   976: istore 11
    //   978: aload_3
    //   979: instanceof 1071
    //   982: ifeq +1148 -> 2130
    //   985: iload 5
    //   987: istore 8
    //   989: iload 6
    //   991: istore 7
    //   993: iload 5
    //   995: istore 10
    //   997: iload 6
    //   999: istore 9
    //   1001: iload 6
    //   1003: istore 11
    //   1005: aload_3
    //   1006: checkcast 1071	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c
    //   1009: getfield 1074	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c:kPW	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   1012: astore 28
    //   1014: iload 5
    //   1016: istore 8
    //   1018: iload 6
    //   1020: istore 7
    //   1022: iload 5
    //   1024: istore 10
    //   1026: iload 6
    //   1028: istore 9
    //   1030: iload 6
    //   1032: istore 11
    //   1034: aload 28
    //   1036: instanceof 1076
    //   1039: ifeq +1154 -> 2193
    //   1042: iload 5
    //   1044: istore 8
    //   1046: iload 6
    //   1048: istore 7
    //   1050: iload 5
    //   1052: istore 10
    //   1054: iload 6
    //   1056: istore 9
    //   1058: iload 6
    //   1060: istore 11
    //   1062: aload 28
    //   1064: checkcast 1076	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l
    //   1067: invokeinterface 1080 1 0
    //   1072: astore 28
    //   1074: aload 28
    //   1076: ifnull +1087 -> 2163
    //   1079: iload 5
    //   1081: istore 8
    //   1083: iload 6
    //   1085: istore 7
    //   1087: iload 5
    //   1089: istore 10
    //   1091: iload 6
    //   1093: istore 9
    //   1095: iload 6
    //   1097: istore 11
    //   1099: aload 28
    //   1101: aload 32
    //   1103: invokeinterface 1086 2 0
    //   1108: ifne +1085 -> 2193
    //   1111: iload 5
    //   1113: istore 8
    //   1115: iload 6
    //   1117: istore 7
    //   1119: iload 5
    //   1121: istore 10
    //   1123: iload 6
    //   1125: istore 9
    //   1127: iload 6
    //   1129: istore 11
    //   1131: new 1088	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$d
    //   1134: dup
    //   1135: ldc_w 1090
    //   1138: aload 33
    //   1140: invokespecial 1093	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;)V
    //   1143: astore 28
    //   1145: iload 5
    //   1147: istore 8
    //   1149: iload 6
    //   1151: istore 7
    //   1153: iload 5
    //   1155: istore 10
    //   1157: iload 6
    //   1159: istore 9
    //   1161: iload 6
    //   1163: istore 11
    //   1165: ldc_w 978
    //   1168: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1171: iload 5
    //   1173: istore 8
    //   1175: iload 6
    //   1177: istore 7
    //   1179: iload 5
    //   1181: istore 10
    //   1183: iload 6
    //   1185: istore 9
    //   1187: iload 6
    //   1189: istore 11
    //   1191: aload 28
    //   1193: athrow
    //   1194: astore 32
    //   1196: iload 8
    //   1198: istore 5
    //   1200: aload 31
    //   1202: astore 30
    //   1204: iload 7
    //   1206: istore 6
    //   1208: aload_3
    //   1209: astore 28
    //   1211: aload 32
    //   1213: astore_3
    //   1214: aload_3
    //   1215: astore 32
    //   1217: aload_3
    //   1218: instanceof 1095
    //   1221: ifeq +1864 -> 3085
    //   1224: aload_3
    //   1225: astore 32
    //   1227: aload_3
    //   1228: checkcast 1095	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f
    //   1231: astore 37
    //   1233: aload_3
    //   1234: astore 32
    //   1236: aload_3
    //   1237: astore 33
    //   1239: aload 4
    //   1241: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   1244: bipush 90
    //   1246: if_icmpne +3608 -> 4854
    //   1249: aload_3
    //   1250: astore 31
    //   1252: aload_3
    //   1253: astore 32
    //   1255: aload 37
    //   1257: getfield 1098	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:responseCode	I
    //   1260: sipush 416
    //   1263: if_icmpne +281 -> 1544
    //   1266: ldc2_w 995
    //   1269: lstore 19
    //   1271: aload_3
    //   1272: astore 32
    //   1274: aload_0
    //   1275: getfield 169	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRt	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/p;
    //   1278: aload 35
    //   1280: iconst_m1
    //   1281: invokevirtual 1102	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/p:bE	(Ljava/lang/String;I)Ljava/util/ArrayList;
    //   1284: invokevirtual 1106	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1287: astore 31
    //   1289: aload_3
    //   1290: astore 32
    //   1292: aload 31
    //   1294: invokeinterface 1111 1 0
    //   1299: ifeq +3567 -> 4866
    //   1302: aload_3
    //   1303: astore 32
    //   1305: aload 31
    //   1307: invokeinterface 1115 1 0
    //   1312: checkcast 402	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n
    //   1315: astore 33
    //   1317: aload_3
    //   1318: astore 32
    //   1320: aload 33
    //   1322: aload 4
    //   1324: invokevirtual 1116	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1327: ifne -38 -> 1289
    //   1330: aload_3
    //   1331: astore 32
    //   1333: aload 33
    //   1335: invokevirtual 958	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:aXm	()J
    //   1338: ldc2_w 995
    //   1341: lcmp
    //   1342: ifeq -53 -> 1289
    //   1345: aload_3
    //   1346: astore 32
    //   1348: aload 33
    //   1350: invokevirtual 958	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:aXm	()J
    //   1353: lstore 19
    //   1355: aload_3
    //   1356: astore 32
    //   1358: aload 33
    //   1360: invokevirtual 1117	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjR	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   1363: astore 30
    //   1365: aload_3
    //   1366: astore 31
    //   1368: lload 19
    //   1370: ldc2_w 995
    //   1373: lcmp
    //   1374: ifeq +170 -> 1544
    //   1377: aload_3
    //   1378: astore 31
    //   1380: lload 19
    //   1382: lload 17
    //   1384: lcmp
    //   1385: ifne +159 -> 1544
    //   1388: aload_3
    //   1389: astore 31
    //   1391: lload 25
    //   1393: ldc2_w 1004
    //   1396: lcmp
    //   1397: ifne +147 -> 1544
    //   1400: aload_3
    //   1401: astore 32
    //   1403: aload 30
    //   1405: invokevirtual 1039	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:toString	()Ljava/lang/String;
    //   1408: astore 31
    //   1410: aload_3
    //   1411: astore 32
    //   1413: aload_2
    //   1414: invokestatic 312	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:NB	(Ljava/lang/String;)Z
    //   1417: ifne +1460 -> 2877
    //   1420: iconst_1
    //   1421: istore 27
    //   1423: aload_3
    //   1424: astore 32
    //   1426: lload 17
    //   1428: lload 25
    //   1430: lload 19
    //   1432: aload 31
    //   1434: iload 27
    //   1436: invokestatic 1042	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:a	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   1439: astore 31
    //   1441: aload_3
    //   1442: astore 32
    //   1444: aload 30
    //   1446: getstatic 1003	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:kQO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   1449: invokevirtual 1036	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:equals	(Ljava/lang/Object;)Z
    //   1452: ifeq +16 -> 1468
    //   1455: aload_3
    //   1456: astore 32
    //   1458: bipush 6
    //   1460: aload 34
    //   1462: ldc_w 1119
    //   1465: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1468: aload_3
    //   1469: astore 32
    //   1471: iconst_4
    //   1472: aload 34
    //   1474: new 115	java/lang/StringBuilder
    //   1477: dup
    //   1478: ldc_w 1121
    //   1481: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1484: lload 15
    //   1486: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1489: ldc_w 1048
    //   1492: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: aload 31
    //   1497: invokestatic 893	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:NH	(Ljava/lang/String;)Ljava/lang/String;
    //   1500: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1509: aload_3
    //   1510: astore 32
    //   1512: aload 36
    //   1514: aload 31
    //   1516: ldc_w 519
    //   1519: invokevirtual 1051	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1522: invokevirtual 734	java/io/OutputStream:write	([B)V
    //   1525: aload_3
    //   1526: astore 32
    //   1528: aload 36
    //   1530: invokevirtual 1054	java/io/OutputStream:flush	()V
    //   1533: aload_3
    //   1534: astore 32
    //   1536: aload 36
    //   1538: invokevirtual 671	java/io/OutputStream:close	()V
    //   1541: aconst_null
    //   1542: astore 31
    //   1544: aload 31
    //   1546: astore 33
    //   1548: aload 31
    //   1550: ifnull +3304 -> 4854
    //   1553: aload 31
    //   1555: astore 32
    //   1557: iconst_4
    //   1558: aload 34
    //   1560: new 115	java/lang/StringBuilder
    //   1563: dup
    //   1564: ldc_w 1123
    //   1567: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1570: aload 4
    //   1572: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   1575: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: ldc_w 1125
    //   1581: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: aload 37
    //   1586: getfield 1128	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:headerFields	Ljava/util/Map;
    //   1589: invokestatic 1131	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:J	(Ljava/util/Map;)Ljava/lang/String;
    //   1592: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1601: aload 31
    //   1603: astore 32
    //   1605: aload 37
    //   1607: getfield 1128	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:headerFields	Ljava/util/Map;
    //   1610: invokestatic 1135	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:K	(Ljava/util/Map;)J
    //   1613: lstore 15
    //   1615: aload 31
    //   1617: astore 32
    //   1619: aload 37
    //   1621: getfield 1098	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:responseCode	I
    //   1624: i2l
    //   1625: lload 15
    //   1627: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   1630: lstore 13
    //   1632: aload 31
    //   1634: astore_3
    //   1635: aload 4
    //   1637: iconst_1
    //   1638: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   1641: ifeq +8 -> 1649
    //   1644: aload 4
    //   1646: invokevirtual 667	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjZ	()V
    //   1649: iconst_4
    //   1650: aload 34
    //   1652: new 115	java/lang/StringBuilder
    //   1655: dup
    //   1656: ldc_w 1137
    //   1659: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1662: iload 6
    //   1664: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1667: ldc_w 1139
    //   1670: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: lload 17
    //   1675: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1678: ldc_w 1022
    //   1681: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: lload 25
    //   1686: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1689: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1692: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1695: aload 28
    //   1697: invokeinterface 1023 1 0
    //   1702: aload_3
    //   1703: ifnonnull +7 -> 1710
    //   1706: aload_1
    //   1707: invokevirtual 442	java/net/Socket:close	()V
    //   1710: aload 29
    //   1712: ifnull +3127 -> 4839
    //   1715: aload 29
    //   1717: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   1720: ifeq +3119 -> 4839
    //   1723: aload 29
    //   1725: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   1728: ifeq +3111 -> 4839
    //   1731: iconst_4
    //   1732: aload 34
    //   1734: new 115	java/lang/StringBuilder
    //   1737: dup
    //   1738: ldc_w 1141
    //   1741: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1744: aload 29
    //   1746: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   1749: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1755: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1758: aload 29
    //   1760: invokevirtual 1145	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   1763: invokestatic 353	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   1766: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1769: invokevirtual 478	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjN	()Ljava/lang/String;
    //   1772: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1775: ifeq +3064 -> 4839
    //   1778: aload 29
    //   1780: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   1783: ifne +30 -> 1813
    //   1786: iconst_5
    //   1787: aload 34
    //   1789: new 115	java/lang/StringBuilder
    //   1792: dup
    //   1793: ldc_w 1147
    //   1796: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1799: aload 29
    //   1801: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   1804: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1810: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1813: aload_0
    //   1814: getfield 169	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRt	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/p;
    //   1817: aload 4
    //   1819: invokevirtual 445	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/p:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/n;)V
    //   1822: aload 4
    //   1824: iconst_2
    //   1825: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   1828: ifeq +2474 -> 4302
    //   1831: aload 4
    //   1833: invokevirtual 457	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjY	()V
    //   1836: aload 4
    //   1838: iconst_1
    //   1839: putfield 460	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRJ	Z
    //   1842: ldc_w 658
    //   1845: astore_1
    //   1846: aload 4
    //   1848: getfield 497	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1851: astore 29
    //   1853: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   1856: lload 23
    //   1858: lsub
    //   1859: l2i
    //   1860: istore 5
    //   1862: aload_0
    //   1863: getfield 86	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:kRu	Ljava/util/Map;
    //   1866: aload 35
    //   1868: invokeinterface 429 2 0
    //   1873: checkcast 431	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/d
    //   1876: astore 30
    //   1878: aload_3
    //   1879: instanceof 1095
    //   1882: ifeq +2435 -> 4317
    //   1885: ldc_w 1149
    //   1888: astore_1
    //   1889: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1892: getfield 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1895: ifnull +70 -> 1965
    //   1898: lload 13
    //   1900: lload 15
    //   1902: invokestatic 952	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:C	(JJ)J
    //   1905: lstore 17
    //   1907: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1910: getfield 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1913: aload 29
    //   1915: aload_2
    //   1916: aload 4
    //   1918: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   1921: aload 4
    //   1923: getfield 913	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRQ	J
    //   1926: aload 4
    //   1928: getfield 916	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRR	J
    //   1931: aload 4
    //   1933: invokevirtual 958	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:aXm	()J
    //   1936: aload 4
    //   1938: getfield 505	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRP	I
    //   1941: aload 4
    //   1943: getfield 904	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRW	Ljava/lang/String;
    //   1946: aload 4
    //   1948: invokevirtual 961	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjX	()J
    //   1951: lload 13
    //   1953: lload 15
    //   1955: lload 17
    //   1957: aload_1
    //   1958: iload 5
    //   1960: invokeinterface 964 22 0
    //   1965: iconst_4
    //   1966: aload 34
    //   1968: ldc_w 1151
    //   1971: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1974: ldc_w 978
    //   1977: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1980: return
    //   1981: aload 28
    //   1983: instanceof 1071
    //   1986: ifeq +103 -> 2089
    //   1989: aload 28
    //   1991: checkcast 1071	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c
    //   1994: getfield 1074	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c:kPW	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   1997: astore_3
    //   1998: aload_3
    //   1999: instanceof 1076
    //   2002: ifeq +64 -> 2066
    //   2005: aload_3
    //   2006: checkcast 1076	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l
    //   2009: invokeinterface 1154 1 0
    //   2014: astore 31
    //   2016: aload 31
    //   2018: ifnull +26 -> 2044
    //   2021: iconst_4
    //   2022: aload 34
    //   2024: ldc_w 1156
    //   2027: aload 31
    //   2029: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2032: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2035: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2038: aload 28
    //   2040: astore_3
    //   2041: goto -1603 -> 438
    //   2044: iconst_4
    //   2045: aload 34
    //   2047: ldc_w 1158
    //   2050: aload_3
    //   2051: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2054: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2057: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2060: aload 28
    //   2062: astore_3
    //   2063: goto -1625 -> 438
    //   2066: bipush 6
    //   2068: aload 34
    //   2070: ldc_w 1160
    //   2073: aload_3
    //   2074: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2077: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2080: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2083: aload 28
    //   2085: astore_3
    //   2086: goto -1648 -> 438
    //   2089: iconst_4
    //   2090: aload 34
    //   2092: ldc_w 1162
    //   2095: aload 28
    //   2097: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2100: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2103: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2106: aload 28
    //   2108: astore_3
    //   2109: goto -1671 -> 438
    //   2112: iconst_0
    //   2113: istore 27
    //   2115: goto -1594 -> 521
    //   2118: iconst_0
    //   2119: istore 5
    //   2121: goto -1437 -> 684
    //   2124: iconst_0
    //   2125: istore 7
    //   2127: goto -1301 -> 826
    //   2130: iload 5
    //   2132: istore 8
    //   2134: iload 6
    //   2136: istore 7
    //   2138: iload 5
    //   2140: istore 10
    //   2142: iload 6
    //   2144: istore 9
    //   2146: iload 6
    //   2148: istore 11
    //   2150: aload_3
    //   2151: instanceof 1076
    //   2154: ifeq -1140 -> 1014
    //   2157: aload_3
    //   2158: astore 28
    //   2160: goto -1146 -> 1014
    //   2163: iload 5
    //   2165: istore 8
    //   2167: iload 6
    //   2169: istore 7
    //   2171: iload 5
    //   2173: istore 10
    //   2175: iload 6
    //   2177: istore 9
    //   2179: iload 6
    //   2181: istore 11
    //   2183: bipush 6
    //   2185: aload 34
    //   2187: ldc_w 1164
    //   2190: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2193: iload 5
    //   2195: istore 8
    //   2197: iload 6
    //   2199: istore 7
    //   2201: iload 5
    //   2203: istore 10
    //   2205: iload 6
    //   2207: istore 9
    //   2209: iload 6
    //   2211: istore 11
    //   2213: aload 36
    //   2215: aload 32
    //   2217: iconst_0
    //   2218: iload 12
    //   2220: invokevirtual 1167	java/io/OutputStream:write	([BII)V
    //   2223: iload 6
    //   2225: iload 12
    //   2227: iadd
    //   2228: istore 6
    //   2230: iload 5
    //   2232: istore 8
    //   2234: iload 6
    //   2236: istore 7
    //   2238: iload 5
    //   2240: istore 10
    //   2242: iload 6
    //   2244: istore 9
    //   2246: iload 6
    //   2248: istore 11
    //   2250: aload 4
    //   2252: iload 12
    //   2254: invokevirtual 1170	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sU	(I)V
    //   2257: iload 5
    //   2259: istore 8
    //   2261: iload 6
    //   2263: istore 7
    //   2265: iload 5
    //   2267: istore 10
    //   2269: iload 6
    //   2271: istore 9
    //   2273: iload 6
    //   2275: istore 11
    //   2277: aload 4
    //   2279: iload 6
    //   2281: invokevirtual 1173	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sT	(I)V
    //   2284: goto -1629 -> 655
    //   2287: astore 28
    //   2289: iload 10
    //   2291: istore 5
    //   2293: iload 9
    //   2295: istore 6
    //   2297: iconst_4
    //   2298: aload 34
    //   2300: new 115	java/lang/StringBuilder
    //   2303: dup
    //   2304: ldc_w 1175
    //   2307: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2310: aload 28
    //   2312: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2315: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2318: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2321: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2324: aload 4
    //   2326: iconst_1
    //   2327: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2330: ifeq +8 -> 2338
    //   2333: aload 4
    //   2335: invokevirtual 667	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjZ	()V
    //   2338: iconst_4
    //   2339: aload 34
    //   2341: new 115	java/lang/StringBuilder
    //   2344: dup
    //   2345: ldc_w 1137
    //   2348: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2351: iload 6
    //   2353: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2356: ldc_w 1139
    //   2359: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2362: lload 17
    //   2364: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2367: ldc_w 1022
    //   2370: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: lload 25
    //   2375: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2378: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2381: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2384: aload_3
    //   2385: invokeinterface 1023 1 0
    //   2390: aload 29
    //   2392: ifnull +2431 -> 4823
    //   2395: aload 29
    //   2397: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2400: ifeq +2423 -> 4823
    //   2403: aload 29
    //   2405: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2408: ifeq +2415 -> 4823
    //   2411: iconst_4
    //   2412: aload 34
    //   2414: new 115	java/lang/StringBuilder
    //   2417: dup
    //   2418: ldc_w 1141
    //   2421: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2424: aload 29
    //   2426: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2429: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2432: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2435: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2438: aload 29
    //   2440: invokevirtual 1145	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   2443: invokestatic 353	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   2446: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2449: invokevirtual 478	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjN	()Ljava/lang/String;
    //   2452: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2455: ifeq +2368 -> 4823
    //   2458: aload 29
    //   2460: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   2463: ifne +30 -> 2493
    //   2466: iconst_5
    //   2467: aload 34
    //   2469: new 115	java/lang/StringBuilder
    //   2472: dup
    //   2473: ldc_w 1147
    //   2476: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2479: aload 29
    //   2481: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2484: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2490: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2493: aload 28
    //   2495: astore_1
    //   2496: ldc2_w 420
    //   2499: lstore 15
    //   2501: aload_3
    //   2502: astore 28
    //   2504: aload_1
    //   2505: astore_3
    //   2506: goto -693 -> 1813
    //   2509: iload 5
    //   2511: ifne +60 -> 2571
    //   2514: iload 5
    //   2516: istore 8
    //   2518: iload 6
    //   2520: istore 7
    //   2522: iload 5
    //   2524: istore 10
    //   2526: iload 6
    //   2528: istore 9
    //   2530: iload 6
    //   2532: istore 11
    //   2534: aload 4
    //   2536: sipush 256
    //   2539: invokevirtual 452	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sV	(I)V
    //   2542: iload 5
    //   2544: istore 8
    //   2546: iload 6
    //   2548: istore 7
    //   2550: iload 5
    //   2552: istore 10
    //   2554: iload 6
    //   2556: istore 9
    //   2558: iload 6
    //   2560: istore 11
    //   2562: iconst_4
    //   2563: aload 34
    //   2565: ldc_w 1177
    //   2568: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2571: iload 5
    //   2573: istore 8
    //   2575: iload 6
    //   2577: istore 7
    //   2579: iload 5
    //   2581: istore 10
    //   2583: iload 6
    //   2585: istore 9
    //   2587: iload 6
    //   2589: istore 11
    //   2591: aload 4
    //   2593: iconst_1
    //   2594: invokevirtual 449	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sW	(I)Z
    //   2597: ifeq +28 -> 2625
    //   2600: iload 5
    //   2602: istore 8
    //   2604: iload 6
    //   2606: istore 7
    //   2608: iload 5
    //   2610: istore 10
    //   2612: iload 6
    //   2614: istore 9
    //   2616: iload 6
    //   2618: istore 11
    //   2620: aload 4
    //   2622: invokevirtual 667	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bjZ	()V
    //   2625: iload 5
    //   2627: istore 8
    //   2629: iload 6
    //   2631: istore 7
    //   2633: iload 5
    //   2635: istore 10
    //   2637: iload 6
    //   2639: istore 9
    //   2641: iload 6
    //   2643: istore 11
    //   2645: aload 36
    //   2647: invokevirtual 1054	java/io/OutputStream:flush	()V
    //   2650: iload 5
    //   2652: istore 8
    //   2654: iload 6
    //   2656: istore 7
    //   2658: iload 5
    //   2660: istore 10
    //   2662: iload 6
    //   2664: istore 9
    //   2666: iload 6
    //   2668: istore 11
    //   2670: aload 36
    //   2672: invokevirtual 671	java/io/OutputStream:close	()V
    //   2675: iconst_4
    //   2676: aload 34
    //   2678: new 115	java/lang/StringBuilder
    //   2681: dup
    //   2682: ldc_w 1137
    //   2685: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2688: iload 6
    //   2690: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2693: ldc_w 1139
    //   2696: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2699: lload 17
    //   2701: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2704: ldc_w 1022
    //   2707: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: lload 25
    //   2712: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2715: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2718: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2721: aload_3
    //   2722: invokeinterface 1023 1 0
    //   2727: aload_1
    //   2728: invokevirtual 442	java/net/Socket:close	()V
    //   2731: aload 29
    //   2733: ifnull +2136 -> 4869
    //   2736: aload 29
    //   2738: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2741: ifeq +2128 -> 4869
    //   2744: aload 29
    //   2746: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2749: ifeq +2120 -> 4869
    //   2752: iconst_4
    //   2753: aload 34
    //   2755: new 115	java/lang/StringBuilder
    //   2758: dup
    //   2759: ldc_w 1141
    //   2762: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2765: aload 29
    //   2767: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2770: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2773: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2776: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2779: aload 29
    //   2781: invokevirtual 1145	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   2784: invokestatic 353	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   2787: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2790: invokevirtual 478	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjN	()Ljava/lang/String;
    //   2793: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2796: ifeq +2073 -> 4869
    //   2799: aload 29
    //   2801: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   2804: ifne +30 -> 2834
    //   2807: iconst_5
    //   2808: aload 34
    //   2810: new 115	java/lang/StringBuilder
    //   2813: dup
    //   2814: ldc_w 1147
    //   2817: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2820: aload 29
    //   2822: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   2825: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2828: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2831: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2834: aconst_null
    //   2835: astore_1
    //   2836: ldc2_w 420
    //   2839: lstore 15
    //   2841: aload_3
    //   2842: astore 28
    //   2844: aload_1
    //   2845: astore_3
    //   2846: goto -1033 -> 1813
    //   2849: astore 28
    //   2851: iconst_5
    //   2852: aload 34
    //   2854: ldc_w 1025
    //   2857: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2860: goto -133 -> 2727
    //   2863: astore_1
    //   2864: iconst_5
    //   2865: aload 34
    //   2867: ldc_w 1027
    //   2870: aload_1
    //   2871: invokestatic 468	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2874: goto -143 -> 2731
    //   2877: iconst_0
    //   2878: istore 27
    //   2880: goto -1457 -> 1423
    //   2883: astore 30
    //   2885: aload_3
    //   2886: astore 32
    //   2888: iconst_4
    //   2889: aload 34
    //   2891: ldc_w 1179
    //   2894: aload 30
    //   2896: invokestatic 468	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2899: aload_3
    //   2900: astore 31
    //   2902: goto -1358 -> 1544
    //   2905: astore_2
    //   2906: aload 32
    //   2908: astore_3
    //   2909: iload 6
    //   2911: istore 5
    //   2913: iconst_4
    //   2914: aload 34
    //   2916: new 115	java/lang/StringBuilder
    //   2919: dup
    //   2920: ldc_w 1137
    //   2923: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2926: iload 5
    //   2928: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2931: ldc_w 1139
    //   2934: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2937: lload 17
    //   2939: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2942: ldc_w 1022
    //   2945: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2948: lload 25
    //   2950: invokevirtual 492	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2953: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2956: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2959: aload 28
    //   2961: invokeinterface 1023 1 0
    //   2966: aload_3
    //   2967: ifnonnull +7 -> 2974
    //   2970: aload_1
    //   2971: invokevirtual 442	java/net/Socket:close	()V
    //   2974: aload 29
    //   2976: ifnull +101 -> 3077
    //   2979: aload 29
    //   2981: invokevirtual 674	com/tencent/mm/vfs/e:isFile	()Z
    //   2984: ifeq +93 -> 3077
    //   2987: aload 29
    //   2989: invokevirtual 331	com/tencent/mm/vfs/e:exists	()Z
    //   2992: ifeq +85 -> 3077
    //   2995: iconst_4
    //   2996: aload 34
    //   2998: new 115	java/lang/StringBuilder
    //   3001: dup
    //   3002: ldc_w 1141
    //   3005: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3008: aload 29
    //   3010: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   3013: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3019: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3022: aload 29
    //   3024: invokevirtual 1145	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   3027: invokestatic 353	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   3030: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   3033: invokevirtual 478	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjN	()Ljava/lang/String;
    //   3036: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3039: ifeq +38 -> 3077
    //   3042: aload 29
    //   3044: invokevirtual 677	com/tencent/mm/vfs/e:delete	()Z
    //   3047: ifne +30 -> 3077
    //   3050: iconst_5
    //   3051: aload 34
    //   3053: new 115	java/lang/StringBuilder
    //   3056: dup
    //   3057: ldc_w 1147
    //   3060: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3063: aload 29
    //   3065: invokevirtual 338	com/tencent/mm/vfs/e:toString	()Ljava/lang/String;
    //   3068: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3074: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3077: ldc_w 978
    //   3080: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3083: aload_2
    //   3084: athrow
    //   3085: aload_3
    //   3086: astore 32
    //   3088: aload_3
    //   3089: instanceof 1181
    //   3092: ifeq +105 -> 3197
    //   3095: aload_3
    //   3096: astore 32
    //   3098: aload_3
    //   3099: checkcast 1181	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$e
    //   3102: astore 30
    //   3104: aload_3
    //   3105: astore 32
    //   3107: iconst_4
    //   3108: aload 34
    //   3110: new 115	java/lang/StringBuilder
    //   3113: dup
    //   3114: ldc_w 1123
    //   3117: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3120: aload 4
    //   3122: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3125: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3128: ldc_w 1183
    //   3131: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3134: aload 30
    //   3136: getfield 1184	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$e:headerFields	Ljava/util/Map;
    //   3139: invokestatic 1131	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:J	(Ljava/util/Map;)Ljava/lang/String;
    //   3142: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3148: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3151: aload_3
    //   3152: astore 32
    //   3154: lload 19
    //   3156: lstore 15
    //   3158: aload 4
    //   3160: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3163: bipush 90
    //   3165: if_icmpne +1719 -> 4884
    //   3168: aload_3
    //   3169: astore 32
    //   3171: aload 30
    //   3173: getfield 1184	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$e:headerFields	Ljava/util/Map;
    //   3176: invokestatic 1135	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:K	(Ljava/util/Map;)J
    //   3179: lstore 15
    //   3181: aload_3
    //   3182: astore 32
    //   3184: ldc2_w 1185
    //   3187: lload 15
    //   3189: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   3192: lstore 13
    //   3194: goto +1690 -> 4884
    //   3197: aload_3
    //   3198: astore 32
    //   3200: aload_3
    //   3201: instanceof 1088
    //   3204: ifeq +73 -> 3277
    //   3207: aload_3
    //   3208: astore 32
    //   3210: iconst_4
    //   3211: aload 34
    //   3213: new 115	java/lang/StringBuilder
    //   3216: dup
    //   3217: ldc_w 1123
    //   3220: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3223: aload 4
    //   3225: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3228: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: ldc_w 1188
    //   3234: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3237: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3240: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3243: aload_3
    //   3244: astore 32
    //   3246: aload 4
    //   3248: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3251: bipush 90
    //   3253: if_icmpne +973 -> 4226
    //   3256: aload_3
    //   3257: astore 32
    //   3259: ldc2_w 1189
    //   3262: ldc2_w 420
    //   3265: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   3268: lstore 13
    //   3270: lload 19
    //   3272: lstore 15
    //   3274: goto -1639 -> 1635
    //   3277: aload_3
    //   3278: astore 32
    //   3280: aload_3
    //   3281: instanceof 1192
    //   3284: ifeq +73 -> 3357
    //   3287: aload_3
    //   3288: astore 32
    //   3290: iconst_4
    //   3291: aload 34
    //   3293: new 115	java/lang/StringBuilder
    //   3296: dup
    //   3297: ldc_w 1123
    //   3300: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3303: aload 4
    //   3305: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3308: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: ldc_w 1194
    //   3314: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3320: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3323: aload_3
    //   3324: astore 32
    //   3326: aload 4
    //   3328: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3331: bipush 90
    //   3333: if_icmpne +893 -> 4226
    //   3336: aload_3
    //   3337: astore 32
    //   3339: ldc2_w 1195
    //   3342: ldc2_w 420
    //   3345: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   3348: lstore 13
    //   3350: lload 19
    //   3352: lstore 15
    //   3354: goto -1719 -> 1635
    //   3357: aload_3
    //   3358: astore 32
    //   3360: aload_3
    //   3361: instanceof 416
    //   3364: ifeq +60 -> 3424
    //   3367: aload_3
    //   3368: astore 32
    //   3370: aload 4
    //   3372: sipush 256
    //   3375: invokevirtual 452	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sV	(I)V
    //   3378: aload_3
    //   3379: astore 32
    //   3381: iconst_5
    //   3382: aload 34
    //   3384: new 115	java/lang/StringBuilder
    //   3387: dup
    //   3388: ldc_w 1123
    //   3391: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3394: aload 4
    //   3396: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3399: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3402: ldc_w 1198
    //   3405: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3408: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3411: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3414: iconst_0
    //   3415: istore 5
    //   3417: lload 19
    //   3419: lstore 15
    //   3421: goto -1786 -> 1635
    //   3424: aload_3
    //   3425: astore 32
    //   3427: aload_3
    //   3428: instanceof 418
    //   3431: ifeq +60 -> 3491
    //   3434: aload_3
    //   3435: astore 32
    //   3437: aload 4
    //   3439: sipush 256
    //   3442: invokevirtual 452	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sV	(I)V
    //   3445: aload_3
    //   3446: astore 32
    //   3448: iconst_5
    //   3449: aload 34
    //   3451: new 115	java/lang/StringBuilder
    //   3454: dup
    //   3455: ldc_w 1123
    //   3458: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3461: aload 4
    //   3463: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3466: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3469: ldc_w 1200
    //   3472: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3475: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3478: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3481: iconst_0
    //   3482: istore 5
    //   3484: lload 19
    //   3486: lstore 15
    //   3488: goto -1853 -> 1635
    //   3491: aload_3
    //   3492: astore 32
    //   3494: aload_3
    //   3495: instanceof 1202
    //   3498: ifeq +250 -> 3748
    //   3501: aload_3
    //   3502: astore 32
    //   3504: iconst_5
    //   3505: aload 34
    //   3507: new 115	java/lang/StringBuilder
    //   3510: dup
    //   3511: ldc_w 1123
    //   3514: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3517: aload 4
    //   3519: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3522: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3525: ldc_w 1204
    //   3528: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3531: aload_3
    //   3532: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3535: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3538: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3541: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3544: aload_3
    //   3545: astore 32
    //   3547: aload 4
    //   3549: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3552: bipush 90
    //   3554: if_icmpne +672 -> 4226
    //   3557: aload_3
    //   3558: astore 32
    //   3560: aload 28
    //   3562: instanceof 1071
    //   3565: ifeq +141 -> 3706
    //   3568: aload_3
    //   3569: astore 32
    //   3571: aload 28
    //   3573: checkcast 1071	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c
    //   3576: getfield 1074	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c:kPW	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   3579: astore 30
    //   3581: aload_3
    //   3582: astore 32
    //   3584: aload 30
    //   3586: instanceof 1206
    //   3589: ifeq +91 -> 3680
    //   3592: aload_3
    //   3593: astore 32
    //   3595: aload 30
    //   3597: checkcast 1206	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j
    //   3600: getfield 1210	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:kPN	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;
    //   3603: astore 30
    //   3605: aload 30
    //   3607: ifnull +1235 -> 4842
    //   3610: aload_3
    //   3611: astore 32
    //   3613: aload 30
    //   3615: getfield 1213	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:uri	Landroid/net/Uri;
    //   3618: astore 30
    //   3620: aload 30
    //   3622: ifnull +1220 -> 4842
    //   3625: aload_3
    //   3626: astore 32
    //   3628: aload 30
    //   3630: invokevirtual 1216	android/net/Uri:getHost	()Ljava/lang/String;
    //   3633: ifnull +1209 -> 4842
    //   3636: aload_3
    //   3637: astore 32
    //   3639: aload 30
    //   3641: invokevirtual 1216	android/net/Uri:getHost	()Ljava/lang/String;
    //   3644: ldc_w 1218
    //   3647: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3650: ifeq +1192 -> 4842
    //   3653: iconst_1
    //   3654: istore 7
    //   3656: goto +1231 -> 4887
    //   3659: aload_3
    //   3660: astore 32
    //   3662: iload 7
    //   3664: i2l
    //   3665: ldc2_w 420
    //   3668: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   3671: lstore 13
    //   3673: lload 19
    //   3675: lstore 15
    //   3677: goto -2042 -> 1635
    //   3680: aload_3
    //   3681: astore 32
    //   3683: iconst_4
    //   3684: aload 34
    //   3686: ldc_w 1220
    //   3689: aload 28
    //   3691: invokestatic 410	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3694: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3697: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3700: aconst_null
    //   3701: astore 30
    //   3703: goto -98 -> 3605
    //   3706: aload_3
    //   3707: astore 32
    //   3709: aload 28
    //   3711: instanceof 1206
    //   3714: ifeq +1134 -> 4848
    //   3717: aload_3
    //   3718: astore 32
    //   3720: aload 28
    //   3722: checkcast 1206	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j
    //   3725: getfield 1210	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:kPN	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;
    //   3728: astore 30
    //   3730: goto -125 -> 3605
    //   3733: aload_3
    //   3734: astore 32
    //   3736: invokestatic 1223	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   3739: ifeq +1160 -> 4899
    //   3742: iconst_5
    //   3743: istore 7
    //   3745: goto -86 -> 3659
    //   3748: aload_3
    //   3749: astore 32
    //   3751: aload_3
    //   3752: instanceof 1225
    //   3755: ifeq +82 -> 3837
    //   3758: aload_3
    //   3759: astore 32
    //   3761: iconst_5
    //   3762: aload 34
    //   3764: new 115	java/lang/StringBuilder
    //   3767: dup
    //   3768: ldc_w 1123
    //   3771: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3774: aload 4
    //   3776: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3779: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3782: ldc_w 1227
    //   3785: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3788: aload_3
    //   3789: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3792: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3795: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3798: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3801: aload_3
    //   3802: astore 32
    //   3804: aload 4
    //   3806: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3809: bipush 90
    //   3811: if_icmpne +415 -> 4226
    //   3814: aload_3
    //   3815: astore 32
    //   3817: aload_3
    //   3818: invokestatic 1231	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:g	(Ljava/lang/Throwable;)I
    //   3821: i2l
    //   3822: ldc2_w 420
    //   3825: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   3828: lstore 13
    //   3830: lload 19
    //   3832: lstore 15
    //   3834: goto -2199 -> 1635
    //   3837: aload_3
    //   3838: astore 32
    //   3840: aload 28
    //   3842: instanceof 1233
    //   3845: ifeq +90 -> 3935
    //   3848: aload_3
    //   3849: astore 32
    //   3851: aload_3
    //   3852: instanceof 1235
    //   3855: ifeq +80 -> 3935
    //   3858: aload_3
    //   3859: astore 32
    //   3861: iconst_5
    //   3862: aload 34
    //   3864: new 115	java/lang/StringBuilder
    //   3867: dup
    //   3868: ldc_w 1123
    //   3871: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3874: aload 4
    //   3876: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3879: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3882: ldc_w 1237
    //   3885: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3888: aload_3
    //   3889: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3892: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3895: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3898: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3901: aload_3
    //   3902: astore 32
    //   3904: aload 4
    //   3906: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3909: bipush 90
    //   3911: if_icmpne +315 -> 4226
    //   3914: aload_3
    //   3915: astore 32
    //   3917: ldc2_w 1238
    //   3920: ldc2_w 420
    //   3923: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   3926: lstore 13
    //   3928: lload 19
    //   3930: lstore 15
    //   3932: goto -2297 -> 1635
    //   3935: aload_3
    //   3936: astore 32
    //   3938: aload_3
    //   3939: instanceof 1241
    //   3942: ifeq +78 -> 4020
    //   3945: aload_3
    //   3946: astore 32
    //   3948: iconst_5
    //   3949: aload 34
    //   3951: new 115	java/lang/StringBuilder
    //   3954: dup
    //   3955: ldc_w 1123
    //   3958: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3961: aload 4
    //   3963: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   3966: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3969: ldc_w 1243
    //   3972: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3975: aload_3
    //   3976: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3979: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3982: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3985: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3988: aload_3
    //   3989: astore 32
    //   3991: aload 4
    //   3993: getfield 419	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3996: bipush 90
    //   3998: if_icmpne +228 -> 4226
    //   4001: aload_3
    //   4002: astore 32
    //   4004: lconst_1
    //   4005: ldc2_w 420
    //   4008: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:B	(JJ)J
    //   4011: lstore 13
    //   4013: lload 19
    //   4015: lstore 15
    //   4017: goto -2382 -> 1635
    //   4020: aload_3
    //   4021: astore 32
    //   4023: aload_3
    //   4024: instanceof 1245
    //   4027: ifeq +60 -> 4087
    //   4030: aload_3
    //   4031: astore 32
    //   4033: aload 4
    //   4035: sipush 256
    //   4038: invokevirtual 452	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sV	(I)V
    //   4041: aload_3
    //   4042: astore 32
    //   4044: iconst_4
    //   4045: aload 34
    //   4047: new 115	java/lang/StringBuilder
    //   4050: dup
    //   4051: ldc_w 1123
    //   4054: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4057: aload 4
    //   4059: getfield 907	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kRU	Ljava/lang/String;
    //   4062: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4065: ldc_w 1247
    //   4068: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4071: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4074: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4077: iconst_0
    //   4078: istore 5
    //   4080: lload 19
    //   4082: lstore 15
    //   4084: goto -2449 -> 1635
    //   4087: aload_3
    //   4088: astore 32
    //   4090: aload_0
    //   4091: getfield 1249	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:aDV	Z
    //   4094: ifeq +22 -> 4116
    //   4097: aload_3
    //   4098: astore 32
    //   4100: iconst_5
    //   4101: aload 34
    //   4103: ldc_w 1251
    //   4106: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4109: lload 19
    //   4111: lstore 15
    //   4113: goto -2478 -> 1635
    //   4116: aload_3
    //   4117: astore 32
    //   4119: aload_3
    //   4120: invokevirtual 969	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4123: ldc_w 1253
    //   4126: invokevirtual 1255	java/lang/String:matches	(Ljava/lang/String;)Z
    //   4129: ifeq +22 -> 4151
    //   4132: aload_3
    //   4133: astore 32
    //   4135: iconst_5
    //   4136: aload 34
    //   4138: ldc_w 1257
    //   4141: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4144: lload 19
    //   4146: lstore 15
    //   4148: goto -2513 -> 1635
    //   4151: aload_3
    //   4152: astore 32
    //   4154: aload_3
    //   4155: invokevirtual 1258	java/lang/Exception:toString	()Ljava/lang/String;
    //   4158: ldc_w 1260
    //   4161: invokevirtual 634	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4164: ifeq +22 -> 4186
    //   4167: aload_3
    //   4168: astore 32
    //   4170: iconst_5
    //   4171: aload 34
    //   4173: ldc_w 1262
    //   4176: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4179: lload 19
    //   4181: lstore 15
    //   4183: goto -2548 -> 1635
    //   4186: aload_3
    //   4187: astore 32
    //   4189: iconst_5
    //   4190: aload 34
    //   4192: new 115	java/lang/StringBuilder
    //   4195: dup
    //   4196: ldc_w 1123
    //   4199: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4202: aload 4
    //   4204: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4207: ldc_w 1264
    //   4210: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4213: aload_3
    //   4214: invokestatic 293	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4217: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4220: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4223: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4226: lload 19
    //   4228: lstore 15
    //   4230: goto -2595 -> 1635
    //   4233: astore 30
    //   4235: iconst_5
    //   4236: aload 34
    //   4238: ldc_w 1025
    //   4241: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4244: goto -2542 -> 1702
    //   4247: astore_1
    //   4248: iconst_5
    //   4249: aload 34
    //   4251: ldc_w 1027
    //   4254: aload_1
    //   4255: invokestatic 468	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4258: goto -2548 -> 1710
    //   4261: astore_1
    //   4262: iconst_5
    //   4263: aload 34
    //   4265: ldc_w 1025
    //   4268: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4271: goto -1881 -> 2390
    //   4274: astore 4
    //   4276: iconst_5
    //   4277: aload 34
    //   4279: ldc_w 1025
    //   4282: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4285: goto -1319 -> 2966
    //   4288: astore_1
    //   4289: iconst_5
    //   4290: aload 34
    //   4292: ldc_w 1027
    //   4295: aload_1
    //   4296: invokestatic 468	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4299: goto -1325 -> 2974
    //   4302: iload 5
    //   4304: ifeq -2468 -> 1836
    //   4307: aload 4
    //   4309: bipush 16
    //   4311: invokevirtual 452	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:sV	(I)V
    //   4314: goto -2478 -> 1836
    //   4317: aload_3
    //   4318: instanceof 1181
    //   4321: ifeq +10 -> 4331
    //   4324: ldc_w 1266
    //   4327: astore_1
    //   4328: goto -2439 -> 1889
    //   4331: aload_3
    //   4332: instanceof 1088
    //   4335: ifeq +27 -> 4362
    //   4338: ldc_w 1268
    //   4341: astore_3
    //   4342: aload_3
    //   4343: astore_1
    //   4344: aload 30
    //   4346: ifnull -2457 -> 1889
    //   4349: new 83	java/util/HashMap
    //   4352: dup
    //   4353: invokespecial 84	java/util/HashMap:<init>	()V
    //   4356: pop
    //   4357: aload_3
    //   4358: astore_1
    //   4359: goto -2470 -> 1889
    //   4362: aload_3
    //   4363: instanceof 1192
    //   4366: ifeq +27 -> 4393
    //   4369: ldc_w 1270
    //   4372: astore_3
    //   4373: aload_3
    //   4374: astore_1
    //   4375: aload 30
    //   4377: ifnull -2488 -> 1889
    //   4380: new 83	java/util/HashMap
    //   4383: dup
    //   4384: invokespecial 84	java/util/HashMap:<init>	()V
    //   4387: pop
    //   4388: aload_3
    //   4389: astore_1
    //   4390: goto -2501 -> 1889
    //   4393: aload_3
    //   4394: instanceof 416
    //   4397: ifeq +31 -> 4428
    //   4400: ldc_w 1272
    //   4403: astore_3
    //   4404: aload_3
    //   4405: astore_1
    //   4406: aload 30
    //   4408: ifnull -2519 -> 1889
    //   4411: invokestatic 1223	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   4414: pop
    //   4415: new 83	java/util/HashMap
    //   4418: dup
    //   4419: invokespecial 84	java/util/HashMap:<init>	()V
    //   4422: pop
    //   4423: aload_3
    //   4424: astore_1
    //   4425: goto -2536 -> 1889
    //   4428: aload_3
    //   4429: instanceof 418
    //   4432: ifeq +31 -> 4463
    //   4435: ldc_w 1274
    //   4438: astore_3
    //   4439: aload_3
    //   4440: astore_1
    //   4441: aload 30
    //   4443: ifnull -2554 -> 1889
    //   4446: invokestatic 1223	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   4449: pop
    //   4450: new 83	java/util/HashMap
    //   4453: dup
    //   4454: invokespecial 84	java/util/HashMap:<init>	()V
    //   4457: pop
    //   4458: aload_3
    //   4459: astore_1
    //   4460: goto -2571 -> 1889
    //   4463: aload_3
    //   4464: instanceof 1202
    //   4467: ifeq +31 -> 4498
    //   4470: ldc_w 1276
    //   4473: astore_3
    //   4474: aload_3
    //   4475: astore_1
    //   4476: aload 30
    //   4478: ifnull -2589 -> 1889
    //   4481: invokestatic 1223	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   4484: pop
    //   4485: new 83	java/util/HashMap
    //   4488: dup
    //   4489: invokespecial 84	java/util/HashMap:<init>	()V
    //   4492: pop
    //   4493: aload_3
    //   4494: astore_1
    //   4495: goto -2606 -> 1889
    //   4498: aload_3
    //   4499: instanceof 1225
    //   4502: ifeq +35 -> 4537
    //   4505: ldc_w 1278
    //   4508: astore 28
    //   4510: aload 28
    //   4512: astore_1
    //   4513: aload 30
    //   4515: ifnull -2626 -> 1889
    //   4518: aload_3
    //   4519: invokestatic 1231	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:g	(Ljava/lang/Throwable;)I
    //   4522: pop
    //   4523: new 83	java/util/HashMap
    //   4526: dup
    //   4527: invokespecial 84	java/util/HashMap:<init>	()V
    //   4530: pop
    //   4531: aload 28
    //   4533: astore_1
    //   4534: goto -2645 -> 1889
    //   4537: aload 28
    //   4539: instanceof 1233
    //   4542: ifeq +26 -> 4568
    //   4545: aload_3
    //   4546: instanceof 1235
    //   4549: ifeq +19 -> 4568
    //   4552: ldc_w 1280
    //   4555: astore_3
    //   4556: aload_3
    //   4557: astore_1
    //   4558: aload 30
    //   4560: ifnull -2671 -> 1889
    //   4563: aload_3
    //   4564: astore_1
    //   4565: goto -2676 -> 1889
    //   4568: aload_3
    //   4569: instanceof 1241
    //   4572: ifeq -2683 -> 1889
    //   4575: ldc_w 1282
    //   4578: astore_3
    //   4579: aload_3
    //   4580: astore_1
    //   4581: aload 30
    //   4583: ifnull -2694 -> 1889
    //   4586: new 83	java/util/HashMap
    //   4589: dup
    //   4590: invokespecial 84	java/util/HashMap:<init>	()V
    //   4593: pop
    //   4594: aload_3
    //   4595: astore_1
    //   4596: goto -2707 -> 1889
    //   4599: astore_2
    //   4600: aconst_null
    //   4601: astore 29
    //   4603: aconst_null
    //   4604: astore_3
    //   4605: iload 8
    //   4607: istore 5
    //   4609: goto -1696 -> 2913
    //   4612: astore_2
    //   4613: aconst_null
    //   4614: astore_3
    //   4615: iload 8
    //   4617: istore 5
    //   4619: goto -1706 -> 2913
    //   4622: astore_2
    //   4623: aconst_null
    //   4624: astore 4
    //   4626: aload_3
    //   4627: astore 28
    //   4629: aload 4
    //   4631: astore_3
    //   4632: iload 8
    //   4634: istore 5
    //   4636: goto -1723 -> 2913
    //   4639: astore_2
    //   4640: aconst_null
    //   4641: astore 4
    //   4643: iload 11
    //   4645: istore 5
    //   4647: aload_3
    //   4648: astore 28
    //   4650: aload 4
    //   4652: astore_3
    //   4653: goto -1740 -> 2913
    //   4656: astore_2
    //   4657: iload 6
    //   4659: istore 5
    //   4661: goto -1748 -> 2913
    //   4664: astore_2
    //   4665: aload 28
    //   4667: astore 4
    //   4669: aload_3
    //   4670: astore 28
    //   4672: aload 4
    //   4674: astore_3
    //   4675: iload 6
    //   4677: istore 5
    //   4679: goto -1766 -> 2913
    //   4682: astore 30
    //   4684: aconst_null
    //   4685: astore 29
    //   4687: lconst_0
    //   4688: lstore 13
    //   4690: iconst_1
    //   4691: istore 5
    //   4693: aload 28
    //   4695: astore_3
    //   4696: aload 30
    //   4698: astore 28
    //   4700: goto -2403 -> 2297
    //   4703: astore 30
    //   4705: aconst_null
    //   4706: astore 29
    //   4708: iconst_1
    //   4709: istore 5
    //   4711: aload 28
    //   4713: astore_3
    //   4714: aload 30
    //   4716: astore 28
    //   4718: goto -2421 -> 2297
    //   4721: astore 30
    //   4723: iconst_1
    //   4724: istore 5
    //   4726: aload 28
    //   4728: astore_3
    //   4729: aload 30
    //   4731: astore 28
    //   4733: goto -2436 -> 2297
    //   4736: astore 28
    //   4738: iconst_1
    //   4739: istore 5
    //   4741: goto -2444 -> 2297
    //   4744: astore_3
    //   4745: aconst_null
    //   4746: astore 29
    //   4748: lconst_0
    //   4749: lstore 13
    //   4751: lload 21
    //   4753: lstore 15
    //   4755: iload 7
    //   4757: istore 6
    //   4759: goto -3545 -> 1214
    //   4762: astore_3
    //   4763: aconst_null
    //   4764: astore 29
    //   4766: lload 21
    //   4768: lstore 15
    //   4770: iload 7
    //   4772: istore 6
    //   4774: goto -3560 -> 1214
    //   4777: astore_3
    //   4778: lload 21
    //   4780: lstore 15
    //   4782: iload 7
    //   4784: istore 6
    //   4786: goto -3572 -> 1214
    //   4789: astore 31
    //   4791: aload_3
    //   4792: astore 28
    //   4794: aload 31
    //   4796: astore_3
    //   4797: lload 21
    //   4799: lstore 15
    //   4801: iload 7
    //   4803: istore 6
    //   4805: goto -3591 -> 1214
    //   4808: astore 31
    //   4810: aload_3
    //   4811: astore 28
    //   4813: aload 31
    //   4815: astore_3
    //   4816: iload 7
    //   4818: istore 6
    //   4820: goto -3606 -> 1214
    //   4823: aload 28
    //   4825: astore_1
    //   4826: ldc2_w 420
    //   4829: lstore 15
    //   4831: aload_3
    //   4832: astore 28
    //   4834: aload_1
    //   4835: astore_3
    //   4836: goto -3023 -> 1813
    //   4839: goto -3026 -> 1813
    //   4842: iconst_0
    //   4843: istore 7
    //   4845: goto +42 -> 4887
    //   4848: aconst_null
    //   4849: astore 30
    //   4851: goto -1246 -> 3605
    //   4854: ldc2_w 420
    //   4857: lstore 15
    //   4859: aload 33
    //   4861: astore 31
    //   4863: goto -3231 -> 1632
    //   4866: goto -3501 -> 1365
    //   4869: aconst_null
    //   4870: astore_1
    //   4871: ldc2_w 420
    //   4874: lstore 15
    //   4876: aload_3
    //   4877: astore 28
    //   4879: aload_1
    //   4880: astore_3
    //   4881: goto -3068 -> 1813
    //   4884: goto -3249 -> 1635
    //   4887: iload 7
    //   4889: ifeq -1156 -> 3733
    //   4892: bipush 13
    //   4894: istore 7
    //   4896: goto -1237 -> 3659
    //   4899: bipush 9
    //   4901: istore 7
    //   4903: goto -1244 -> 3659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4906	0	this	m
    //   0	4906	1	paramSocket	Socket
    //   0	4906	2	paramString	String
    //   0	4906	3	paramOutputStream	java.io.OutputStream
    //   0	4906	4	paramn	n
    //   276	4464	5	i	int
    //   121	4698	6	j	int
    //   127	4775	7	k	int
    //   124	4509	8	m	int
    //   669	1996	9	n	int
    //   665	1996	10	i1	int
    //   673	3971	11	i2	int
    //   750	1503	12	i3	int
    //   167	4583	13	l1	long
    //   149	4726	15	l2	long
    //   163	2775	17	l3	long
    //   228	3999	19	l4	long
    //   132	4666	21	l5	long
    //   273	1584	23	l6	long
    //   156	2793	25	l7	long
    //   519	2360	27	bool	boolean
    //   50	2109	28	localObject1	Object
    //   2287	207	28	localException1	Exception
    //   2502	341	28	localOutputStream1	java.io.OutputStream
    //   2849	992	28	localIOException1	IOException
    //   4508	224	28	localObject2	Object
    //   4736	1	28	localException2	Exception
    //   4792	86	28	localOutputStream2	java.io.OutputStream
    //   71	4694	29	localObject3	Object
    //   144	1733	30	localObject4	Object
    //   2883	12	30	localException3	Exception
    //   3102	627	30	localObject5	Object
    //   4233	349	30	localIOException2	IOException
    //   4682	15	30	localException4	Exception
    //   4703	12	30	localException5	Exception
    //   4721	9	30	localException6	Exception
    //   4849	1	30	localObject6	Object
    //   452	2449	31	localObject7	Object
    //   4789	6	31	localIOException3	IOException
    //   4808	6	31	localIOException4	IOException
    //   4861	1	31	localObject8	Object
    //   139	963	32	arrayOfByte	byte[]
    //   1194	18	32	localIOException5	IOException
    //   1215	2973	32	localObject9	Object
    //   258	4602	33	localObject10	Object
    //   27	4264	34	str1	String
    //   57	1810	35	str2	String
    //   268	2403	36	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1231	389	37	localf	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.f
    // Exception table:
    //   from	to	target	type
    //   351	358	383	java/io/IOException
    //   358	362	396	java/io/IOException
    //   675	681	1194	java/io/IOException
    //   709	718	1194	java/io/IOException
    //   738	752	1194	java/io/IOException
    //   778	786	1194	java/io/IOException
    //   806	823	1194	java/io/IOException
    //   851	859	1194	java/io/IOException
    //   888	918	1194	java/io/IOException
    //   938	943	1194	java/io/IOException
    //   978	985	1194	java/io/IOException
    //   1005	1014	1194	java/io/IOException
    //   1034	1042	1194	java/io/IOException
    //   1062	1074	1194	java/io/IOException
    //   1099	1111	1194	java/io/IOException
    //   1131	1145	1194	java/io/IOException
    //   1165	1171	1194	java/io/IOException
    //   1191	1194	1194	java/io/IOException
    //   2150	2157	1194	java/io/IOException
    //   2183	2193	1194	java/io/IOException
    //   2213	2223	1194	java/io/IOException
    //   2250	2257	1194	java/io/IOException
    //   2277	2284	1194	java/io/IOException
    //   2534	2542	1194	java/io/IOException
    //   2562	2571	1194	java/io/IOException
    //   2591	2600	1194	java/io/IOException
    //   2620	2625	1194	java/io/IOException
    //   2645	2650	1194	java/io/IOException
    //   2670	2675	1194	java/io/IOException
    //   675	681	2287	java/lang/Exception
    //   709	718	2287	java/lang/Exception
    //   738	752	2287	java/lang/Exception
    //   778	786	2287	java/lang/Exception
    //   806	823	2287	java/lang/Exception
    //   851	859	2287	java/lang/Exception
    //   888	918	2287	java/lang/Exception
    //   938	943	2287	java/lang/Exception
    //   978	985	2287	java/lang/Exception
    //   1005	1014	2287	java/lang/Exception
    //   1034	1042	2287	java/lang/Exception
    //   1062	1074	2287	java/lang/Exception
    //   1099	1111	2287	java/lang/Exception
    //   1131	1145	2287	java/lang/Exception
    //   1165	1171	2287	java/lang/Exception
    //   1191	1194	2287	java/lang/Exception
    //   2150	2157	2287	java/lang/Exception
    //   2183	2193	2287	java/lang/Exception
    //   2213	2223	2287	java/lang/Exception
    //   2250	2257	2287	java/lang/Exception
    //   2277	2284	2287	java/lang/Exception
    //   2534	2542	2287	java/lang/Exception
    //   2562	2571	2287	java/lang/Exception
    //   2591	2600	2287	java/lang/Exception
    //   2620	2625	2287	java/lang/Exception
    //   2645	2650	2287	java/lang/Exception
    //   2670	2675	2287	java/lang/Exception
    //   2721	2727	2849	java/io/IOException
    //   2727	2731	2863	java/io/IOException
    //   1512	1525	2883	java/lang/Exception
    //   1528	1533	2883	java/lang/Exception
    //   1536	1541	2883	java/lang/Exception
    //   1217	1224	2905	finally
    //   1227	1233	2905	finally
    //   1239	1249	2905	finally
    //   1255	1266	2905	finally
    //   1274	1289	2905	finally
    //   1292	1302	2905	finally
    //   1305	1317	2905	finally
    //   1320	1330	2905	finally
    //   1333	1345	2905	finally
    //   1348	1355	2905	finally
    //   1358	1365	2905	finally
    //   1403	1410	2905	finally
    //   1413	1420	2905	finally
    //   1426	1441	2905	finally
    //   1444	1455	2905	finally
    //   1458	1468	2905	finally
    //   1471	1509	2905	finally
    //   1512	1525	2905	finally
    //   1528	1533	2905	finally
    //   1536	1541	2905	finally
    //   1557	1601	2905	finally
    //   1605	1615	2905	finally
    //   1619	1632	2905	finally
    //   2888	2899	2905	finally
    //   3088	3095	2905	finally
    //   3098	3104	2905	finally
    //   3107	3151	2905	finally
    //   3158	3168	2905	finally
    //   3171	3181	2905	finally
    //   3184	3194	2905	finally
    //   3200	3207	2905	finally
    //   3210	3243	2905	finally
    //   3246	3256	2905	finally
    //   3259	3270	2905	finally
    //   3280	3287	2905	finally
    //   3290	3323	2905	finally
    //   3326	3336	2905	finally
    //   3339	3350	2905	finally
    //   3360	3367	2905	finally
    //   3370	3378	2905	finally
    //   3381	3414	2905	finally
    //   3427	3434	2905	finally
    //   3437	3445	2905	finally
    //   3448	3481	2905	finally
    //   3494	3501	2905	finally
    //   3504	3544	2905	finally
    //   3547	3557	2905	finally
    //   3560	3568	2905	finally
    //   3571	3581	2905	finally
    //   3584	3592	2905	finally
    //   3595	3605	2905	finally
    //   3613	3620	2905	finally
    //   3628	3636	2905	finally
    //   3639	3653	2905	finally
    //   3662	3673	2905	finally
    //   3683	3700	2905	finally
    //   3709	3717	2905	finally
    //   3720	3730	2905	finally
    //   3736	3742	2905	finally
    //   3751	3758	2905	finally
    //   3761	3801	2905	finally
    //   3804	3814	2905	finally
    //   3817	3830	2905	finally
    //   3840	3848	2905	finally
    //   3851	3858	2905	finally
    //   3861	3901	2905	finally
    //   3904	3914	2905	finally
    //   3917	3928	2905	finally
    //   3938	3945	2905	finally
    //   3948	3988	2905	finally
    //   3991	4001	2905	finally
    //   4004	4013	2905	finally
    //   4023	4030	2905	finally
    //   4033	4041	2905	finally
    //   4044	4077	2905	finally
    //   4090	4097	2905	finally
    //   4100	4109	2905	finally
    //   4119	4132	2905	finally
    //   4135	4144	2905	finally
    //   4154	4167	2905	finally
    //   4170	4179	2905	finally
    //   4189	4226	2905	finally
    //   1695	1702	4233	java/io/IOException
    //   1706	1710	4247	java/io/IOException
    //   2384	2390	4261	java/io/IOException
    //   2959	2966	4274	java/io/IOException
    //   2970	2974	4288	java/io/IOException
    //   283	316	4599	finally
    //   414	420	4599	finally
    //   420	426	4599	finally
    //   426	438	4612	finally
    //   1981	2016	4612	finally
    //   2021	2038	4612	finally
    //   2044	2060	4612	finally
    //   2066	2083	4612	finally
    //   2089	2106	4612	finally
    //   438	446	4622	finally
    //   446	454	4622	finally
    //   458	467	4622	finally
    //   471	482	4622	finally
    //   486	496	4622	finally
    //   500	507	4622	finally
    //   511	518	4622	finally
    //   525	540	4622	finally
    //   544	572	4622	finally
    //   576	614	4622	finally
    //   618	631	4622	finally
    //   635	640	4622	finally
    //   644	649	4622	finally
    //   675	681	4639	finally
    //   709	718	4639	finally
    //   738	752	4639	finally
    //   778	786	4639	finally
    //   806	823	4639	finally
    //   851	859	4639	finally
    //   888	918	4639	finally
    //   938	943	4639	finally
    //   978	985	4639	finally
    //   1005	1014	4639	finally
    //   1034	1042	4639	finally
    //   1062	1074	4639	finally
    //   1099	1111	4639	finally
    //   1131	1145	4639	finally
    //   1165	1171	4639	finally
    //   1191	1194	4639	finally
    //   2150	2157	4639	finally
    //   2183	2193	4639	finally
    //   2213	2223	4639	finally
    //   2250	2257	4639	finally
    //   2277	2284	4639	finally
    //   2534	2542	4639	finally
    //   2562	2571	4639	finally
    //   2591	2600	4639	finally
    //   2620	2625	4639	finally
    //   2645	2650	4639	finally
    //   2670	2675	4639	finally
    //   1635	1649	4656	finally
    //   2297	2338	4664	finally
    //   283	316	4682	java/lang/Exception
    //   414	420	4682	java/lang/Exception
    //   420	426	4703	java/lang/Exception
    //   426	438	4721	java/lang/Exception
    //   1981	2016	4721	java/lang/Exception
    //   2021	2038	4721	java/lang/Exception
    //   2044	2060	4721	java/lang/Exception
    //   2066	2083	4721	java/lang/Exception
    //   2089	2106	4721	java/lang/Exception
    //   438	446	4736	java/lang/Exception
    //   446	454	4736	java/lang/Exception
    //   458	467	4736	java/lang/Exception
    //   471	482	4736	java/lang/Exception
    //   486	496	4736	java/lang/Exception
    //   500	507	4736	java/lang/Exception
    //   511	518	4736	java/lang/Exception
    //   525	540	4736	java/lang/Exception
    //   544	572	4736	java/lang/Exception
    //   576	614	4736	java/lang/Exception
    //   618	631	4736	java/lang/Exception
    //   635	640	4736	java/lang/Exception
    //   644	649	4736	java/lang/Exception
    //   283	316	4744	java/io/IOException
    //   414	420	4744	java/io/IOException
    //   420	426	4762	java/io/IOException
    //   426	438	4777	java/io/IOException
    //   1981	2016	4777	java/io/IOException
    //   2021	2038	4777	java/io/IOException
    //   2044	2060	4777	java/io/IOException
    //   2066	2083	4777	java/io/IOException
    //   2089	2106	4777	java/io/IOException
    //   438	446	4789	java/io/IOException
    //   446	454	4808	java/io/IOException
    //   458	467	4808	java/io/IOException
    //   471	482	4808	java/io/IOException
    //   486	496	4808	java/io/IOException
    //   500	507	4808	java/io/IOException
    //   511	518	4808	java/io/IOException
    //   525	540	4808	java/io/IOException
    //   544	572	4808	java/io/IOException
    //   576	614	4808	java/io/IOException
    //   618	631	4808	java/io/IOException
    //   635	640	4808	java/io/IOException
    //   644	649	4808	java/io/IOException
  }
  
  private static int g(Throwable paramThrowable)
  {
    AppMethodBeat.i(194303);
    int i;
    if (paramThrowable.toString().toLowerCase().contains("unexpected end of stream")) {
      i = 6;
    }
    for (;;)
    {
      AppMethodBeat.o(194303);
      return i;
      if ((paramThrowable.getCause() != null) && ((paramThrowable.getCause() instanceof SocketTimeoutException))) {
        i = 14;
      } else {
        i = 7;
      }
    }
  }
  
  public final long Nn(String paramString)
  {
    AppMethodBeat.i(194304);
    if ((TextUtils.isEmpty(paramString)) || (this.kPL == null))
    {
      AppMethodBeat.o(194304);
      return 0L;
    }
    paramString = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Nz(paramString);
    long l = this.kPL.Nn(paramString);
    AppMethodBeat.o(194304);
    return l;
  }
  
  public final String a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(194299);
    if ((!com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPx) || (this.kRo > 3) || (this.kRs.isShutdown()) || (this.kRs.isTerminated()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "getUrl, proxy disabled or server shutdown");
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPr.bjJ();
      paramString1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NE(paramString1);
      AppMethodBeat.o(194299);
      return paramString1;
    }
    str = paramString1;
    boolean bool = paramBoolean2;
    if (!URLUtil.isHttpUrl(paramString1))
    {
      str = paramString1;
      bool = paramBoolean2;
      if (!URLUtil.isHttpsUrl(paramString1))
      {
        str = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NE(paramString1);
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NF(str)) {
          break label165;
        }
        bool = false;
      }
    }
    for (;;)
    {
      localObject1 = paramString2;
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NB(str)) {
        break label199;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPA) {
        break label191;
      }
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "getUrl, hls proxy disabled");
      AppMethodBeat.o(194299);
      return str;
      label165:
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.NG(str)) {
        break;
      }
      bool = false;
      str = paramString1;
    }
    AppMethodBeat.o(194299);
    return str;
    label191:
    localObject1 = "application/vnd.apple.mpegurl";
    bool = false;
    label199:
    paramString1 = "";
    try
    {
      paramString2 = URLEncoder.encode(str, "UTF-8");
      paramString1 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "invalid url " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.h(paramString2));
      }
      paramString2 = Uri.parse(str).getLastPathSegment();
      paramString1 = bjW() + "/" + paramString2 + "?url=" + paramString1;
      paramString2 = paramString1;
      if (!bool) {
        break label361;
      }
      paramString2 = paramString1 + "&enableCache=1";
      if ((paramInt == 90) || (paramInt == 10)) {
        break label384;
      }
      paramString1 = paramString2;
      if (paramInt != -1) {
        break label411;
      }
      paramString1 = paramString2 + "&priority=" + paramInt;
      paramString2 = paramString1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label474;
      }
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "url is empty ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(194299);
      return str;
    }
    try
    {
      label361:
      paramString2 = URLEncoder.encode((String)localObject1, "UTF-8");
      label384:
      label411:
      localObject1 = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      try
      {
        paramString2 = paramString1 + "&secret=" + l.E("des", l.bki(), com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.Nz(str));
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "getUrl, url:" + str + ", proxyUrl:" + paramString2);
        AppMethodBeat.o(194299);
        return paramString2;
        paramString2 = paramString2;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "unable to encode contentType ".concat(String.valueOf(localObject1)));
        localObject1 = null;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "encode failed:" + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.h(paramString2));
          this.kRp = false;
          paramString2 = paramString1;
        }
      }
    }
    paramString2 = paramString1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString2 = paramString1 + "&contentType=" + (String)localObject1;
    }
    label474:
    localObject1 = localObject2;
    if (paramBoolean1) {
      localObject1 = System.currentTimeMillis() + kRq.getAndIncrement();
    }
    paramString1 = paramString2;
    if (localObject1 != null) {
      paramString1 = paramString2 + "&id=" + (String)localObject1;
    }
    paramString2 = paramString1;
    if (!this.kRp) {}
  }
  
  public final String bjW()
  {
    AppMethodBeat.i(194298);
    String str = "http://127.0.0.1:" + this.jJr;
    AppMethodBeat.o(194298);
    return str;
  }
  
  final class a
  {
    boolean Xz = false;
    long kRD = -1L;
    com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e kRE = null;
    com.tencent.mm.vfs.e kRF = null;
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    n kQy;
    Future<?> kRG;
    CountDownLatch kRH;
    Socket socket;
    
    public b(Socket paramSocket, CountDownLatch paramCountDownLatch)
    {
      this.socket = paramSocket;
      this.kRH = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(194295);
      try
      {
        this.kRH.await();
        this.kQy = new n();
        this.kQy.kRG = this.kRG;
        m.a(m.this, this.socket, this.kQy);
        AppMethodBeat.o(194295);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "SocketHandler run exception, reason " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.h(localInterruptedException));
        }
      }
    }
  }
  
  final class c
    implements Runnable
  {
    private CountDownLatch startSignal;
    
    public c(CountDownLatch paramCountDownLatch)
    {
      this.startSignal = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(194296);
      this.startSignal.countDown();
      m.a(m.this);
      AppMethodBeat.o(194296);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m
 * JD-Core Version:    0.7.0.1
 */