package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.l;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static AtomicInteger pxp;
  private static AtomicInteger pxq;
  private ServerSocket aFm;
  private Thread aFn;
  private final ExecutorService executorService;
  private int ofp;
  com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a pvM;
  private int pxn;
  private boolean pxo;
  private volatile boolean pxr;
  private final p pxs;
  private Map<String, d> pxt;
  private ConcurrentHashMap<String, e> pxu;
  private Map<String, h> pxv;
  private Map<String, h> pxw;
  private Map<String, h> pxx;
  
  static
  {
    AppMethodBeat.i(228356);
    pxp = new AtomicInteger(10000);
    pxq = new AtomicInteger(10000);
    AppMethodBeat.o(228356);
  }
  
  public m()
  {
    AppMethodBeat.i(228221);
    this.pxn = 0;
    this.pxo = true;
    this.pxt = new HashMap();
    this.pxu = new ConcurrentHashMap(8, 0.75F, 2);
    this.pxv = new ConcurrentHashMap();
    this.pxw = new ConcurrentHashMap();
    this.pxx = new ConcurrentHashMap();
    Object localObject1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().getCacheDir();
    com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "initCache, cache dir:" + com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().getCacheDir());
    Object localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.pvM = null;
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvJ.AT(-1);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvu.AT(-1);
      localObject2 = new StringBuilder("initCache, cache:");
      if (this.pvM != null) {
        break label429;
      }
    }
    label429:
    for (localObject1 = "null";; localObject1 = this.pvM)
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", localObject1);
      this.pxs = new p();
      this.executorService = new com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.b(TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
      try
      {
        localObject1 = InetAddress.getByName("0.0.0.0");
        this.aFm = new ServerSocket(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.bVN(), 10, (InetAddress)localObject1);
        this.ofp = this.aFm.getLocalPort();
        localObject1 = new CountDownLatch(1);
        this.aFn = new Thread(new c((CountDownLatch)localObject1), "video_proxy_wait_for_connection_thread");
        this.aFn.start();
        ((CountDownLatch)localObject1).await();
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "proxy server start success, port:" + this.ofp);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvJ.AT(0);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvu.AT(0);
        AppMethodBeat.o(228221);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        final long l;
        this.executorService.shutdown();
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "proxy server start failed " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(localInterruptedException));
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvJ.AT(-2);
        com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvu.AT(-2);
        AppMethodBeat.o(228221);
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
      l = Math.min(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajc((String)localObject1), com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvF);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "initCache, cache availableSpace=".concat(String.valueOf(l)));
      localObject2 = new com.tencent.mm.plugin.appbrand.jsapi.video.b.a.h(l);
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229166);
          long l1 = 0L;
          long l3 = System.currentTimeMillis();
          try
          {
            long l2 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajd(this.pxy);
            l1 = l2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(5, "VideoProxy", "initCache, calculate cacheSize OOM usedSpace set to 0");
            }
          }
          l1 = Math.min(l1 + l, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvF);
          this.pxA.bqg = l1;
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "initCache, update cacheSize=" + l1 + ", timeCost=" + (System.currentTimeMillis() - l3));
          AppMethodBeat.o(229166);
        }
      }, "VideoProxy");
      this.pvM = new i(new q((String)localObject1), (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.d)localObject2);
      break;
    }
  }
  
  private a a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g paramg, String paramString1, String paramString2, n paramn, Socket paramSocket, String paramString3)
  {
    AppMethodBeat.i(228260);
    locala = new a((byte)0);
    locala.pxC = 0L;
    com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, dataSpec=" + paramg.toString());
    if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.aiP(paramString1)) {
      parame.a(paramg);
    }
    for (;;)
    {
      AppMethodBeat.o(228260);
      return locala;
      q localq = null;
      try
      {
        if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvL != null) {
          localq = com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvL.ev(paramString1);
        }
        if ((localq != null) && (localq.ifE())) {}
        for (locala.pxE = localq;; locala.pxE = a(parame, paramg, paramString1, paramn))
        {
          if (locala.pxE == null) {
            break label500;
          }
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, localPlaylist generate success:" + locala.pxE.toString());
          parame = new com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k()
          {
            public final c bVy()
            {
              AppMethodBeat.i(229075);
              c localc = c.aiX(com.tencent.mm.plugin.appbrand.jsapi.video.b.e.c.pyh);
              AppMethodBeat.o(229075);
              return localc;
            }
          };
          parame.a(new com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g(Uri.fromFile(new File(u.n(locala.pxE.getPath(), false))), paramg.bos, paramg.position, paramg.aFL, paramg.key, paramg.flags, paramg.uuid, paramg.priority));
          locala.pxD = parame;
          break;
        }
        try
        {
          int j;
          int i;
          label500:
          paramSocket.close();
          this.pxs.a(paramn);
          if (paramn.AY(2))
          {
            paramn.AX(256);
            com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, videoRequest is interrupted:".concat(String.valueOf(paramn)));
            paramn.bVG();
            paramn.kUD = true;
            locala.gY = true;
            AppMethodBeat.o(228260);
            return locala;
          }
        }
        catch (IOException parame)
        {
          for (;;)
          {
            com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.a(6, paramString2, "openDataSource, socket close exception", parame);
            continue;
            paramn.AX(257);
          }
        }
      }
      catch (g parame)
      {
        j = 0;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy/" + paramn.pxM, "openDataSource, localPlaylist generate livePlayListException ".concat(String.valueOf(parame)));
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
            locala.pxC = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.H(i, -99999L);
            if ((d)this.pxt.get(paramString3) != null)
            {
              System.currentTimeMillis();
              new HashMap();
            }
          }
          try
          {
            paramSocket.close();
            this.pxs.a(paramn);
            if (paramn.AY(2))
            {
              paramn.AX(256);
              com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, paramString2, "openDataSource, videoRequest is interrupted:".concat(String.valueOf(paramn)));
              paramn.bVG();
              paramn.kUD = true;
              locala.gY = true;
              AppMethodBeat.o(228260);
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
              paramn.AX(257);
            }
          }
        }
        if (paramn.priority == 90)
        {
          locala.pxC = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.H(18L, -99999L);
          if ((d)this.pxt.get(paramString3) != null)
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
  private q a(com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e parame, com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g paramg, String paramString, n paramn)
  {
    // Byte code:
    //   0: ldc_w 468
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 115	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 392
    //   13: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload 4
    //   18: getfield 397	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxM	I
    //   21: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 23
    //   29: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   32: invokevirtual 471	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVu	()Ljava/lang/String;
    //   35: astore 17
    //   37: aload 17
    //   39: ifnonnull +21 -> 60
    //   42: bipush 6
    //   44: aload 23
    //   46: ldc_w 473
    //   49: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   52: ldc_w 468
    //   55: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aconst_null
    //   59: areturn
    //   60: new 278	com/tencent/mm/vfs/q
    //   63: dup
    //   64: aload 17
    //   66: invokespecial 279	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   69: astore 18
    //   71: aload 18
    //   73: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   76: ifne +9 -> 85
    //   79: aload 18
    //   81: invokevirtual 476	com/tencent/mm/vfs/q:ifL	()Z
    //   84: pop
    //   85: new 278	com/tencent/mm/vfs/q
    //   88: dup
    //   89: new 115	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   96: aload 17
    //   98: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 479
    //   104: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   110: getstatic 64	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxq	Ljava/util/concurrent/atomic/AtomicInteger;
    //   113: invokevirtual 482	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   116: i2l
    //   117: ladd
    //   118: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   121: ldc_w 487
    //   124: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 279	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   133: astore 24
    //   135: iconst_4
    //   136: aload 23
    //   138: ldc_w 489
    //   141: aload 24
    //   143: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
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
    //   169: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   172: bipush 10
    //   174: if_icmpne +3624 -> 3798
    //   177: iconst_1
    //   178: istore 5
    //   180: aload 4
    //   182: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   185: astore 25
    //   187: aconst_null
    //   188: astore 18
    //   190: aload 4
    //   192: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   195: bipush 10
    //   197: if_icmpne +3607 -> 3804
    //   200: iconst_1
    //   201: istore 13
    //   203: iconst_4
    //   204: aload 23
    //   206: ldc_w 492
    //   209: iload 13
    //   211: invokestatic 495	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   214: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   220: aload 4
    //   222: aload 4
    //   224: getfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   227: iconst_5
    //   228: ior
    //   229: putfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   232: ldc_w 500
    //   235: bipush 34
    //   237: invokestatic 506	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   240: astore 26
    //   242: aload_1
    //   243: aload_2
    //   244: invokeinterface 316 2 0
    //   249: pop2
    //   250: new 508	java/io/BufferedReader
    //   253: dup
    //   254: new 510	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/f
    //   257: dup
    //   258: aload_1
    //   259: ldc_w 512
    //   262: invokespecial 515	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/f:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;Ljava/lang/String;)V
    //   265: invokespecial 518	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   268: astore_2
    //   269: aload 24
    //   271: invokestatic 522	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   274: astore_1
    //   275: aload_1
    //   276: astore 17
    //   278: aload_2
    //   279: astore 19
    //   281: aload 17
    //   283: astore 20
    //   285: new 115	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   292: astore 27
    //   294: iconst_0
    //   295: istore 8
    //   297: aload_2
    //   298: astore 19
    //   300: aload 17
    //   302: astore 20
    //   304: iconst_4
    //   305: aload 23
    //   307: ldc_w 524
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
    //   331: invokestatic 527	java/lang/Thread:interrupted	()Z
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
    //   355: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   358: ifne +1671 -> 2029
    //   361: aload_2
    //   362: astore 19
    //   364: aload 17
    //   366: astore 20
    //   368: aload_2
    //   369: invokevirtual 530	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   403: ldc_w 532
    //   406: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   409: ifeq +1367 -> 1776
    //   412: aload_2
    //   413: astore 19
    //   415: aload 17
    //   417: astore 20
    //   419: aload 28
    //   421: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   424: ldc_w 540
    //   427: invokevirtual 544	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifeq +3323 -> 3753
    //   433: aload_2
    //   434: astore 19
    //   436: aload 17
    //   438: astore 20
    //   440: aload_0
    //   441: getfield 97	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxv	Ljava/util/Map;
    //   444: aload 25
    //   446: invokeinterface 547 2 0
    //   451: ifne +3302 -> 3753
    //   454: aload_2
    //   455: astore 19
    //   457: aload 17
    //   459: astore 20
    //   461: new 549	java/util/ArrayList
    //   464: dup
    //   465: invokespecial 550	java/util/ArrayList:<init>	()V
    //   468: astore 18
    //   470: aload_2
    //   471: astore 19
    //   473: aload 17
    //   475: astore 20
    //   477: aload_0
    //   478: getfield 97	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxv	Ljava/util/Map;
    //   481: aload 25
    //   483: new 552	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h
    //   486: dup
    //   487: invokespecial 553	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:<init>	()V
    //   490: invokeinterface 557 3 0
    //   495: pop
    //   496: aload_2
    //   497: astore 19
    //   499: aload 17
    //   501: astore 20
    //   503: aload 28
    //   505: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   508: ldc_w 559
    //   511: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   514: ifeq +3224 -> 3738
    //   517: iload 8
    //   519: ifne +37 -> 556
    //   522: aload_2
    //   523: astore 19
    //   525: aload 17
    //   527: astore 20
    //   529: iconst_4
    //   530: aload 23
    //   532: ldc_w 561
    //   535: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   538: aload_2
    //   539: astore 19
    //   541: aload 17
    //   543: astore 20
    //   545: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   548: getfield 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:pvJ	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   551: invokeinterface 564 1 0
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
    //   573: getfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   576: bipush 251
    //   578: iand
    //   579: putfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   582: iconst_1
    //   583: istore 7
    //   585: aload_2
    //   586: astore 19
    //   588: aload 17
    //   590: astore 20
    //   592: aload 28
    //   594: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   597: ldc_w 566
    //   600: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
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
    //   623: getfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   626: bipush 251
    //   628: iand
    //   629: putfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   632: aload_2
    //   633: astore 19
    //   635: aload 17
    //   637: astore 20
    //   639: aload 28
    //   641: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   644: ldc_w 568
    //   647: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   650: ifeq +3085 -> 3735
    //   653: aload_2
    //   654: astore 19
    //   656: aload 17
    //   658: astore 20
    //   660: aload 28
    //   662: invokestatic 572	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:aji	(Ljava/lang/String;)I
    //   665: istore 5
    //   667: aload_2
    //   668: astore 19
    //   670: aload 17
    //   672: astore 20
    //   674: aload 28
    //   676: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   679: ldc_w 574
    //   682: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   685: ifeq +3047 -> 3732
    //   688: aload_2
    //   689: astore 19
    //   691: aload 17
    //   693: astore 20
    //   695: aload 28
    //   697: invokestatic 572	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:aji	(Ljava/lang/String;)I
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
    //   719: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   722: ldc_w 576
    //   725: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
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
    //   748: invokestatic 579	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ajh	(Ljava/lang/String;)Ljava/lang/String;
    //   751: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   754: ldc_w 581
    //   757: invokevirtual 544	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   780: getfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   783: bipush 251
    //   785: iand
    //   786: putfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   789: aload_2
    //   790: astore 19
    //   792: aload 17
    //   794: astore 20
    //   796: aload 28
    //   798: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   801: ldc_w 583
    //   804: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   807: ifeq +536 -> 1343
    //   810: aload_2
    //   811: astore 19
    //   813: aload 17
    //   815: astore 20
    //   817: aload 26
    //   819: aload 28
    //   821: invokevirtual 587	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   824: astore_1
    //   825: aload_2
    //   826: astore 19
    //   828: aload 17
    //   830: astore 20
    //   832: aload_1
    //   833: invokevirtual 592	java/util/regex/Matcher:matches	()Z
    //   836: ifeq +449 -> 1285
    //   839: aload_2
    //   840: astore 19
    //   842: aload 17
    //   844: astore 20
    //   846: aload_1
    //   847: invokevirtual 595	java/util/regex/Matcher:groupCount	()I
    //   850: ifle +435 -> 1285
    //   853: aload_2
    //   854: astore 19
    //   856: aload 17
    //   858: astore 20
    //   860: aload_1
    //   861: iconst_1
    //   862: invokevirtual 598	java/util/regex/Matcher:start	(I)I
    //   865: istore 11
    //   867: aload_2
    //   868: astore 19
    //   870: aload 17
    //   872: astore 20
    //   874: aload_1
    //   875: iconst_1
    //   876: invokevirtual 601	java/util/regex/Matcher:end	(I)I
    //   879: istore 12
    //   881: aload_2
    //   882: astore 19
    //   884: aload 17
    //   886: astore 20
    //   888: aload 28
    //   890: iconst_0
    //   891: iload 11
    //   893: invokevirtual 605	java/lang/String:substring	(II)Ljava/lang/String;
    //   896: astore 22
    //   898: aload_2
    //   899: astore 19
    //   901: aload 17
    //   903: astore 20
    //   905: aload 28
    //   907: iload 11
    //   909: iload 12
    //   911: invokevirtual 605	java/lang/String:substring	(II)Ljava/lang/String;
    //   914: astore_1
    //   915: aload_2
    //   916: astore 19
    //   918: aload 17
    //   920: astore 20
    //   922: aload 28
    //   924: iload 12
    //   926: invokevirtual 607	java/lang/String:substring	(I)Ljava/lang/String;
    //   929: astore 29
    //   931: aload_2
    //   932: astore 19
    //   934: aload 17
    //   936: astore 20
    //   938: aload_0
    //   939: aload_3
    //   940: aload_1
    //   941: invokestatic 611	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ec	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   944: iconst_0
    //   945: iconst_0
    //   946: ldc_w 613
    //   949: bipush 90
    //   951: invokevirtual 616	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   954: astore 21
    //   956: aload 21
    //   958: astore_1
    //   959: aload_2
    //   960: astore 19
    //   962: aload 17
    //   964: astore 20
    //   966: aload 4
    //   968: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   971: ifnull +68 -> 1039
    //   974: aload_2
    //   975: astore 19
    //   977: aload 17
    //   979: astore 20
    //   981: new 115	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   988: aload 21
    //   990: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 618
    //   996: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: aload 4
    //   1001: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1004: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: astore_1
    //   1011: aload_2
    //   1012: astore 19
    //   1014: aload 17
    //   1016: astore 20
    //   1018: new 115	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   1025: aload_1
    //   1026: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: ldc_w 620
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
    //   1062: ldc_w 622
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
    //   1108: ldc_w 532
    //   1111: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1114: ifne +2645 -> 3759
    //   1117: aload_2
    //   1118: astore 19
    //   1120: aload 17
    //   1122: astore 20
    //   1124: aload 28
    //   1126: ldc_w 624
    //   1129: invokevirtual 627	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1132: ifne +21 -> 1153
    //   1135: aload_2
    //   1136: astore 19
    //   1138: aload 17
    //   1140: astore 20
    //   1142: aload 28
    //   1144: ldc_w 629
    //   1147: invokevirtual 627	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
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
    //   1190: ldc_w 631
    //   1193: bipush 10
    //   1195: invokevirtual 616	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   1198: astore 21
    //   1200: aload_2
    //   1201: astore 19
    //   1203: aload 17
    //   1205: astore 20
    //   1207: iconst_4
    //   1208: aload 23
    //   1210: ldc_w 633
    //   1213: aload 21
    //   1215: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1218: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1221: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1224: aload_2
    //   1225: astore 19
    //   1227: aload 17
    //   1229: astore 20
    //   1231: new 635	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i
    //   1234: dup
    //   1235: invokespecial 636	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i:<init>	()V
    //   1238: astore 22
    //   1240: aload_2
    //   1241: astore 19
    //   1243: aload 17
    //   1245: astore 20
    //   1247: aload 22
    //   1249: aload 21
    //   1251: putfield 639	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i:proxyUrl	Ljava/lang/String;
    //   1254: aload_2
    //   1255: astore 19
    //   1257: aload 17
    //   1259: astore 20
    //   1261: aload 22
    //   1263: aload_1
    //   1264: putfield 642	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/i:pwX	Ljava/lang/String;
    //   1267: aload_2
    //   1268: astore 19
    //   1270: aload 17
    //   1272: astore 20
    //   1274: aload 18
    //   1276: aload 22
    //   1278: invokevirtual 645	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1281: pop
    //   1282: goto +2480 -> 3762
    //   1285: aload_2
    //   1286: astore 19
    //   1288: aload 17
    //   1290: astore 20
    //   1292: aload 27
    //   1294: aload 28
    //   1296: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: ldc_w 622
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
    //   1352: invokevirtual 538	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   1355: ldc_w 647
    //   1358: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1361: ifeq +357 -> 1718
    //   1364: aload_2
    //   1365: astore 19
    //   1367: aload 17
    //   1369: astore 20
    //   1371: aload 26
    //   1373: aload 28
    //   1375: invokevirtual 587	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   1378: astore_1
    //   1379: aload_2
    //   1380: astore 19
    //   1382: aload 17
    //   1384: astore 20
    //   1386: aload_1
    //   1387: invokevirtual 592	java/util/regex/Matcher:matches	()Z
    //   1390: ifeq +270 -> 1660
    //   1393: aload_2
    //   1394: astore 19
    //   1396: aload 17
    //   1398: astore 20
    //   1400: aload_1
    //   1401: invokevirtual 595	java/util/regex/Matcher:groupCount	()I
    //   1404: ifle +256 -> 1660
    //   1407: aload_2
    //   1408: astore 19
    //   1410: aload 17
    //   1412: astore 20
    //   1414: aload_1
    //   1415: iconst_1
    //   1416: invokevirtual 598	java/util/regex/Matcher:start	(I)I
    //   1419: istore 11
    //   1421: aload_2
    //   1422: astore 19
    //   1424: aload 17
    //   1426: astore 20
    //   1428: aload_1
    //   1429: iconst_1
    //   1430: invokevirtual 601	java/util/regex/Matcher:end	(I)I
    //   1433: istore 12
    //   1435: aload_2
    //   1436: astore 19
    //   1438: aload 17
    //   1440: astore 20
    //   1442: aload 28
    //   1444: iconst_0
    //   1445: iload 11
    //   1447: invokevirtual 605	java/lang/String:substring	(II)Ljava/lang/String;
    //   1450: astore 22
    //   1452: aload_2
    //   1453: astore 19
    //   1455: aload 17
    //   1457: astore 20
    //   1459: aload 28
    //   1461: iload 11
    //   1463: iload 12
    //   1465: invokevirtual 605	java/lang/String:substring	(II)Ljava/lang/String;
    //   1468: astore_1
    //   1469: aload_2
    //   1470: astore 19
    //   1472: aload 17
    //   1474: astore 20
    //   1476: aload 28
    //   1478: iload 12
    //   1480: invokevirtual 607	java/lang/String:substring	(I)Ljava/lang/String;
    //   1483: astore 29
    //   1485: aload_2
    //   1486: astore 19
    //   1488: aload 17
    //   1490: astore 20
    //   1492: aload_0
    //   1493: aload_3
    //   1494: aload_1
    //   1495: invokestatic 611	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ec	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1498: iconst_0
    //   1499: iconst_0
    //   1500: ldc_w 631
    //   1503: bipush 90
    //   1505: invokevirtual 616	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   1508: astore 21
    //   1510: aload 21
    //   1512: astore_1
    //   1513: aload_2
    //   1514: astore 19
    //   1516: aload 17
    //   1518: astore 20
    //   1520: aload 4
    //   1522: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1525: ifnull +68 -> 1593
    //   1528: aload_2
    //   1529: astore 19
    //   1531: aload 17
    //   1533: astore 20
    //   1535: new 115	java/lang/StringBuilder
    //   1538: dup
    //   1539: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   1542: aload 21
    //   1544: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: ldc_w 618
    //   1550: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1553: aload 4
    //   1555: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1558: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1561: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1564: astore_1
    //   1565: aload_2
    //   1566: astore 19
    //   1568: aload 17
    //   1570: astore 20
    //   1572: new 115	java/lang/StringBuilder
    //   1575: dup
    //   1576: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   1579: aload_1
    //   1580: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: ldc_w 649
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
    //   1616: ldc_w 622
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
    //   1674: ldc_w 622
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
    //   1732: ldc_w 622
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
    //   1783: ldc_w 651
    //   1786: aload 28
    //   1788: invokevirtual 654	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1791: ifne +181 -> 1972
    //   1794: aload_2
    //   1795: astore 19
    //   1797: aload 17
    //   1799: astore 20
    //   1801: aload_3
    //   1802: aload 28
    //   1804: invokestatic 611	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ec	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1807: astore 21
    //   1809: aload_2
    //   1810: astore 19
    //   1812: aload 17
    //   1814: astore 20
    //   1816: aload_0
    //   1817: aload 21
    //   1819: iconst_0
    //   1820: iconst_0
    //   1821: ldc_w 631
    //   1824: bipush 90
    //   1826: invokevirtual 616	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   1829: astore 22
    //   1831: aload 22
    //   1833: astore 18
    //   1835: aload_2
    //   1836: astore 19
    //   1838: aload 17
    //   1840: astore 20
    //   1842: aload 4
    //   1844: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1847: ifnull +71 -> 1918
    //   1850: aload_2
    //   1851: astore 19
    //   1853: aload 17
    //   1855: astore 20
    //   1857: new 115	java/lang/StringBuilder
    //   1860: dup
    //   1861: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   1864: aload 22
    //   1866: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: ldc_w 618
    //   1872: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: aload 4
    //   1877: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1880: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1883: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1886: astore 18
    //   1888: aload_2
    //   1889: astore 19
    //   1891: aload 17
    //   1893: astore 20
    //   1895: new 115	java/lang/StringBuilder
    //   1898: dup
    //   1899: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   1902: aload 18
    //   1904: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: ldc_w 649
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
    //   1932: ldc_w 622
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
    //   1986: ldc_w 622
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
    //   2039: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2042: ifeq +148 -> 2190
    //   2045: aload_2
    //   2046: astore 19
    //   2048: aload 17
    //   2050: astore 20
    //   2052: new 295	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2055: dup
    //   2056: ldc_w 656
    //   2059: invokespecial 657	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   2062: astore_1
    //   2063: aload_2
    //   2064: astore 19
    //   2066: aload 17
    //   2068: astore 20
    //   2070: ldc_w 468
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
    //   2094: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2097: ifeq +1248 -> 3345
    //   2100: aload 4
    //   2102: invokevirtual 660	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVH	()V
    //   2105: aload_1
    //   2106: ifnull +7 -> 2113
    //   2109: aload_1
    //   2110: invokevirtual 661	java/io/BufferedReader:close	()V
    //   2113: aload_2
    //   2114: ifnull +7 -> 2121
    //   2117: aload_2
    //   2118: invokevirtual 664	java/io/OutputStream:close	()V
    //   2121: aload 24
    //   2123: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2126: ifeq +56 -> 2182
    //   2129: aload 24
    //   2131: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2134: ifeq +48 -> 2182
    //   2137: aload 24
    //   2139: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   2142: istore 14
    //   2144: iconst_4
    //   2145: aload 23
    //   2147: new 115	java/lang/StringBuilder
    //   2150: dup
    //   2151: ldc_w 672
    //   2154: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2157: aload 24
    //   2159: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2162: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: ldc_w 674
    //   2168: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: iload 14
    //   2173: invokevirtual 677	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2176: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2179: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2182: ldc_w 468
    //   2185: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2188: aconst_null
    //   2189: areturn
    //   2190: aload_1
    //   2191: ifnull +52 -> 2243
    //   2194: aload_2
    //   2195: astore 19
    //   2197: aload 17
    //   2199: astore 20
    //   2201: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2204: getfield 680	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:pvz	Z
    //   2207: ifeq +36 -> 2243
    //   2210: aload_2
    //   2211: astore 19
    //   2213: aload 17
    //   2215: astore 20
    //   2217: aload 4
    //   2219: iconst_1
    //   2220: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2223: ifne +20 -> 2243
    //   2226: aload_2
    //   2227: astore 19
    //   2229: aload 17
    //   2231: astore 20
    //   2233: invokestatic 686	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:bVD	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/l;
    //   2236: aload_1
    //   2237: ldc_w 688
    //   2240: invokevirtual 691	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   2243: iload 9
    //   2245: ifeq +493 -> 2738
    //   2248: aload_2
    //   2249: astore 19
    //   2251: aload 17
    //   2253: astore 20
    //   2255: aload 4
    //   2257: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   2260: astore_1
    //   2261: aload_2
    //   2262: astore 19
    //   2264: aload 17
    //   2266: astore 20
    //   2268: aload_0
    //   2269: getfield 99	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxw	Ljava/util/Map;
    //   2272: aload_1
    //   2273: invokeinterface 547 2 0
    //   2278: ifne +28 -> 2306
    //   2281: aload_2
    //   2282: astore 19
    //   2284: aload 17
    //   2286: astore 20
    //   2288: aload_0
    //   2289: getfield 99	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxw	Ljava/util/Map;
    //   2292: aload_1
    //   2293: new 552	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h
    //   2296: dup
    //   2297: invokespecial 553	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:<init>	()V
    //   2300: invokeinterface 557 3 0
    //   2305: pop
    //   2306: aload_2
    //   2307: astore 19
    //   2309: aload 17
    //   2311: astore 20
    //   2313: aload_0
    //   2314: getfield 99	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxw	Ljava/util/Map;
    //   2317: aload_1
    //   2318: invokeinterface 422 2 0
    //   2323: checkcast 552	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h
    //   2326: astore_1
    //   2327: iload 5
    //   2329: iconst_m1
    //   2330: if_icmpne +158 -> 2488
    //   2333: aload_2
    //   2334: astore 19
    //   2336: aload 17
    //   2338: astore 20
    //   2340: new 295	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2343: dup
    //   2344: ldc_w 693
    //   2347: invokespecial 657	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   2350: astore_1
    //   2351: aload_2
    //   2352: astore 19
    //   2354: aload 17
    //   2356: astore 20
    //   2358: ldc_w 468
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
    //   2386: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2389: ifeq +1074 -> 3463
    //   2392: aload_2
    //   2393: astore 19
    //   2395: aload_3
    //   2396: astore 20
    //   2398: aload 4
    //   2400: invokevirtual 660	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVH	()V
    //   2403: aload_2
    //   2404: ifnull +7 -> 2411
    //   2407: aload_2
    //   2408: invokevirtual 661	java/io/BufferedReader:close	()V
    //   2411: aload_3
    //   2412: ifnull +7 -> 2419
    //   2415: aload_3
    //   2416: invokevirtual 664	java/io/OutputStream:close	()V
    //   2419: aload 24
    //   2421: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2424: ifeq +56 -> 2480
    //   2427: aload 24
    //   2429: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2432: ifeq +48 -> 2480
    //   2435: aload 24
    //   2437: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   2440: istore 14
    //   2442: iconst_4
    //   2443: aload 23
    //   2445: new 115	java/lang/StringBuilder
    //   2448: dup
    //   2449: ldc_w 672
    //   2452: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2455: aload 24
    //   2457: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2460: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2463: ldc_w 674
    //   2466: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2469: iload 14
    //   2471: invokevirtual 677	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2474: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2477: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2480: ldc_w 468
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
    //   2501: new 295	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   2504: dup
    //   2505: ldc_w 695
    //   2508: invokespecial 657	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   2511: astore_1
    //   2512: aload_2
    //   2513: astore 19
    //   2515: aload 17
    //   2517: astore 20
    //   2519: ldc_w 468
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
    //   2549: invokevirtual 661	java/io/BufferedReader:close	()V
    //   2552: aload_3
    //   2553: ifnull +7 -> 2560
    //   2556: aload_3
    //   2557: invokevirtual 664	java/io/OutputStream:close	()V
    //   2560: iload 5
    //   2562: ifeq +64 -> 2626
    //   2565: aload 24
    //   2567: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2570: ifeq +56 -> 2626
    //   2573: aload 24
    //   2575: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2578: ifeq +48 -> 2626
    //   2581: aload 24
    //   2583: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   2586: istore 14
    //   2588: iconst_4
    //   2589: aload 23
    //   2591: new 115	java/lang/StringBuilder
    //   2594: dup
    //   2595: ldc_w 672
    //   2598: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2601: aload 24
    //   2603: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2606: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2609: ldc_w 674
    //   2612: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2615: iload 14
    //   2617: invokevirtual 677	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2620: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2623: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2626: ldc_w 468
    //   2629: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2632: aload_1
    //   2633: athrow
    //   2634: aload_2
    //   2635: astore 19
    //   2637: aload 17
    //   2639: astore 20
    //   2641: aload_1
    //   2642: getfield 698	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwV	I
    //   2645: iconst_m1
    //   2646: if_icmpne +337 -> 2983
    //   2649: aload_2
    //   2650: astore 19
    //   2652: aload 17
    //   2654: astore 20
    //   2656: aload_0
    //   2657: getfield 101	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxx	Ljava/util/Map;
    //   2660: aload_3
    //   2661: invokeinterface 422 2 0
    //   2666: ifnull +21 -> 2687
    //   2669: aload_2
    //   2670: astore 19
    //   2672: aload 17
    //   2674: astore 20
    //   2676: aload_0
    //   2677: getfield 101	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxx	Ljava/util/Map;
    //   2680: aload_3
    //   2681: invokeinterface 422 2 0
    //   2686: pop
    //   2687: aload_2
    //   2688: astore 19
    //   2690: aload 17
    //   2692: astore 20
    //   2694: iconst_3
    //   2695: aload 23
    //   2697: ldc_w 700
    //   2700: iload 5
    //   2702: invokestatic 495	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2705: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2708: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2711: aload_2
    //   2712: astore 19
    //   2714: aload 17
    //   2716: astore 20
    //   2718: aload_1
    //   2719: iload 5
    //   2721: putfield 698	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwV	I
    //   2724: aload_2
    //   2725: astore 19
    //   2727: aload 17
    //   2729: astore 20
    //   2731: aload_1
    //   2732: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   2735: putfield 703	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwW	J
    //   2738: aload_2
    //   2739: astore 19
    //   2741: aload 17
    //   2743: astore 20
    //   2745: iconst_4
    //   2746: aload 23
    //   2748: ldc_w 705
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
    //   2779: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2782: getfield 708	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:pvB	Z
    //   2785: ifeq +423 -> 3208
    //   2788: ldc_w 710
    //   2791: astore_1
    //   2792: aload_2
    //   2793: astore 19
    //   2795: aload 17
    //   2797: astore 20
    //   2799: aload_3
    //   2800: ldc_w 712
    //   2803: aload_1
    //   2804: invokevirtual 715	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2807: astore_1
    //   2808: aload_2
    //   2809: astore 19
    //   2811: aload 17
    //   2813: astore 20
    //   2815: iconst_4
    //   2816: aload 23
    //   2818: ldc_w 717
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
    //   2848: ldc_w 719
    //   2851: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2854: aload_2
    //   2855: astore 19
    //   2857: aload 17
    //   2859: astore 20
    //   2861: aload 17
    //   2863: aload_1
    //   2864: invokevirtual 723	java/lang/String:getBytes	()[B
    //   2867: invokevirtual 727	java/io/OutputStream:write	([B)V
    //   2870: aload_2
    //   2871: invokevirtual 661	java/io/BufferedReader:close	()V
    //   2874: iconst_0
    //   2875: istore 5
    //   2877: iload 5
    //   2879: istore 6
    //   2881: aload 17
    //   2883: ifnull +12 -> 2895
    //   2886: aload 17
    //   2888: invokevirtual 664	java/io/OutputStream:close	()V
    //   2891: iload 5
    //   2893: istore 6
    //   2895: iload 11
    //   2897: ifne +679 -> 3576
    //   2900: aload 4
    //   2902: iconst_1
    //   2903: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2906: ifeq +8 -> 2914
    //   2909: aload 4
    //   2911: invokevirtual 660	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVH	()V
    //   2914: aload 24
    //   2916: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2919: ifeq +56 -> 2975
    //   2922: aload 24
    //   2924: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2927: ifeq +48 -> 2975
    //   2930: aload 24
    //   2932: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   2935: istore 14
    //   2937: iconst_4
    //   2938: aload 23
    //   2940: new 115	java/lang/StringBuilder
    //   2943: dup
    //   2944: ldc_w 729
    //   2947: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2950: aload 24
    //   2952: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2955: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2958: ldc_w 674
    //   2961: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2964: iload 14
    //   2966: invokevirtual 677	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2969: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2972: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2975: ldc_w 468
    //   2978: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2981: aconst_null
    //   2982: areturn
    //   2983: aload_2
    //   2984: astore 19
    //   2986: aload 17
    //   2988: astore 20
    //   2990: iload 5
    //   2992: aload_1
    //   2993: getfield 698	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwV	I
    //   2996: if_icmpge +81 -> 3077
    //   2999: aload_2
    //   3000: astore 19
    //   3002: aload 17
    //   3004: astore 20
    //   3006: new 295	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3009: dup
    //   3010: new 115	java/lang/StringBuilder
    //   3013: dup
    //   3014: ldc_w 731
    //   3017: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3020: aload_1
    //   3021: getfield 698	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwV	I
    //   3024: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3027: ldc_w 733
    //   3030: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3033: iload 5
    //   3035: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3038: ldc_w 735
    //   3041: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: aload_3
    //   3045: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3048: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3051: invokespecial 657	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   3054: astore_1
    //   3055: aload_2
    //   3056: astore 19
    //   3058: aload 17
    //   3060: astore 20
    //   3062: ldc_w 468
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
    //   3087: getfield 698	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwV	I
    //   3090: if_icmpne -379 -> 2711
    //   3093: aload_2
    //   3094: astore 19
    //   3096: aload 17
    //   3098: astore 20
    //   3100: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   3103: aload_1
    //   3104: getfield 703	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/h:pwW	J
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
    //   3131: getfield 101	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxx	Ljava/util/Map;
    //   3134: aload_3
    //   3135: aload_1
    //   3136: invokeinterface 557 3 0
    //   3141: pop
    //   3142: aload_2
    //   3143: astore 19
    //   3145: aload 17
    //   3147: astore 20
    //   3149: new 295	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3152: dup
    //   3153: new 115	java/lang/StringBuilder
    //   3156: dup
    //   3157: ldc_w 737
    //   3160: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3163: lload 15
    //   3165: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3168: ldc_w 739
    //   3171: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3174: iload 6
    //   3176: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3179: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3182: invokespecial 657	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/String;)V
    //   3185: astore_1
    //   3186: aload_2
    //   3187: astore 19
    //   3189: aload 17
    //   3191: astore 20
    //   3193: ldc_w 468
    //   3196: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3199: aload_2
    //   3200: astore 19
    //   3202: aload 17
    //   3204: astore 20
    //   3206: aload_1
    //   3207: athrow
    //   3208: ldc_w 741
    //   3211: astore_1
    //   3212: goto -420 -> 2792
    //   3215: astore_1
    //   3216: bipush 6
    //   3218: aload 23
    //   3220: new 115	java/lang/StringBuilder
    //   3223: dup
    //   3224: ldc_w 743
    //   3227: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3230: aload_1
    //   3231: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
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
    //   3258: ldc_w 745
    //   3261: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3264: aload_1
    //   3265: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
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
    //   3292: ldc_w 743
    //   3295: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3298: aload_1
    //   3299: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3302: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3305: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3308: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3311: goto -1198 -> 2113
    //   3314: astore_1
    //   3315: bipush 6
    //   3317: aload 23
    //   3319: new 115	java/lang/StringBuilder
    //   3322: dup
    //   3323: ldc_w 745
    //   3326: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3329: aload_1
    //   3330: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3333: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3339: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3342: goto -1221 -> 2121
    //   3345: bipush 6
    //   3347: aload 23
    //   3349: new 115	java/lang/StringBuilder
    //   3352: dup
    //   3353: ldc_w 747
    //   3356: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3359: aload_3
    //   3360: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3363: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3369: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3372: ldc_w 468
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
    //   3410: ldc_w 743
    //   3413: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3416: aload_1
    //   3417: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3420: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3426: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3429: goto -1018 -> 2411
    //   3432: astore_1
    //   3433: bipush 6
    //   3435: aload 23
    //   3437: new 115	java/lang/StringBuilder
    //   3440: dup
    //   3441: ldc_w 745
    //   3444: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3447: aload_1
    //   3448: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3451: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3454: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3457: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3460: goto -1041 -> 2419
    //   3463: bipush 6
    //   3465: aload 23
    //   3467: new 115	java/lang/StringBuilder
    //   3470: dup
    //   3471: ldc_w 749
    //   3474: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3477: aload_1
    //   3478: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3481: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3487: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3490: new 295	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g
    //   3493: dup
    //   3494: aload_1
    //   3495: invokespecial 752	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/g:<init>	(Ljava/lang/Throwable;)V
    //   3498: astore_1
    //   3499: ldc_w 468
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
    //   3523: ldc_w 743
    //   3526: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3529: aload_2
    //   3530: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3533: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3536: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3539: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3542: goto -990 -> 2552
    //   3545: astore_2
    //   3546: bipush 6
    //   3548: aload 23
    //   3550: new 115	java/lang/StringBuilder
    //   3553: dup
    //   3554: ldc_w 745
    //   3557: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3560: aload_2
    //   3561: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3564: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3570: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3573: goto -1013 -> 2560
    //   3576: iload 6
    //   3578: ifeq +72 -> 3650
    //   3581: aload 24
    //   3583: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   3586: ifeq +56 -> 3642
    //   3589: aload 24
    //   3591: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   3594: ifeq +48 -> 3642
    //   3597: aload 24
    //   3599: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   3602: istore 14
    //   3604: iconst_4
    //   3605: aload 23
    //   3607: new 115	java/lang/StringBuilder
    //   3610: dup
    //   3611: ldc_w 754
    //   3614: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3617: aload 24
    //   3619: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   3622: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: ldc_w 674
    //   3628: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3631: iload 14
    //   3633: invokevirtual 677	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3636: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3639: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3642: ldc_w 468
    //   3645: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3648: aconst_null
    //   3649: areturn
    //   3650: ldc_w 468
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
    //   133	3524	24	localq	q
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
    //   0: ldc_w 969
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 115	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 392
    //   13: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload 4
    //   18: getfield 397	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxM	I
    //   21: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 34
    //   29: new 115	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 477	java/lang/StringBuilder:<init>	()V
    //   36: aload 34
    //   38: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 479
    //   44: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 28
    //   52: aload 4
    //   54: getfield 902	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxR	Ljava/lang/String;
    //   57: astore 35
    //   59: aload_0
    //   60: getfield 94	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxu	Ljava/util/concurrent/ConcurrentHashMap;
    //   63: aload 35
    //   65: invokevirtual 970	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 972	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/e
    //   71: astore 29
    //   73: new 974	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/i
    //   76: dup
    //   77: aload_0
    //   78: getfield 141	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pvM	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/a;
    //   81: aload 29
    //   83: aload 4
    //   85: invokespecial 977	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/i:<init>	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a/a;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/e;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/n;)V
    //   88: aload_2
    //   89: aload 28
    //   91: invokeinterface 983 3 0
    //   96: astore 28
    //   98: aload 28
    //   100: ifnonnull +20 -> 120
    //   103: bipush 6
    //   105: aload 34
    //   107: ldc_w 985
    //   110: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   113: ldc_w 969
    //   116: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: return
    //   120: iconst_0
    //   121: istore 6
    //   123: iconst_0
    //   124: istore 8
    //   126: iconst_0
    //   127: istore 7
    //   129: ldc2_w 986
    //   132: lstore 21
    //   134: ldc_w 988
    //   137: newarray byte
    //   139: astore 32
    //   141: getstatic 994	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:pwO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   144: astore 30
    //   146: ldc2_w 986
    //   149: lstore 15
    //   151: aload 4
    //   153: getfield 908	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxP	J
    //   156: lstore 25
    //   158: aload 4
    //   160: getfield 905	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxO	J
    //   163: lstore 17
    //   165: lload 15
    //   167: lstore 13
    //   169: lload 25
    //   171: ldc2_w 986
    //   174: lcmp
    //   175: ifeq +25 -> 200
    //   178: lload 15
    //   180: lstore 13
    //   182: lload 25
    //   184: ldc2_w 995
    //   187: lcmp
    //   188: ifeq +12 -> 200
    //   191: lload 25
    //   193: lload 17
    //   195: lsub
    //   196: lconst_1
    //   197: ladd
    //   198: lstore 13
    //   200: aload_2
    //   201: invokestatic 1000	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   204: astore 29
    //   206: lload 17
    //   208: ldc2_w 986
    //   211: lcmp
    //   212: ifne +157 -> 369
    //   215: lconst_0
    //   216: lstore 15
    //   218: lload 17
    //   220: ldc2_w 986
    //   223: lcmp
    //   224: ifne +152 -> 376
    //   227: lconst_0
    //   228: lstore 19
    //   230: new 306	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g
    //   233: dup
    //   234: aload 29
    //   236: lload 15
    //   238: lload 19
    //   240: lload 13
    //   242: aload 35
    //   244: iconst_0
    //   245: aload 4
    //   247: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   250: aload 4
    //   252: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   255: invokespecial 383	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:<init>	(Landroid/net/Uri;JJJLjava/lang/String;ILjava/lang/String;I)V
    //   258: astore 33
    //   260: new 1002	java/io/BufferedOutputStream
    //   263: dup
    //   264: aload_3
    //   265: invokespecial 1005	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   268: astore 36
    //   270: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   273: lstore 23
    //   275: iconst_1
    //   276: istore 5
    //   278: ldc2_w 412
    //   281: lstore 19
    //   283: aload_0
    //   284: aload 28
    //   286: aload 33
    //   288: aload_2
    //   289: aload 34
    //   291: aload 4
    //   293: aload_1
    //   294: aload 35
    //   296: invokespecial 1007	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/n;Ljava/net/Socket;Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a;
    //   299: astore_3
    //   300: aload_3
    //   301: getfield 456	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:gY	Z
    //   304: ifeq +110 -> 414
    //   307: iconst_4
    //   308: aload 34
    //   310: ldc_w 1009
    //   313: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   316: iconst_4
    //   317: aload 34
    //   319: new 115	java/lang/StringBuilder
    //   322: dup
    //   323: ldc_w 1011
    //   326: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   329: lload 17
    //   331: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc_w 1013
    //   337: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 25
    //   342: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   351: aload 28
    //   353: invokeinterface 1014 1 0
    //   358: aload_1
    //   359: invokevirtual 435	java/net/Socket:close	()V
    //   362: ldc_w 969
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
    //   387: ldc_w 1016
    //   390: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   393: goto -35 -> 358
    //   396: astore_1
    //   397: iconst_5
    //   398: aload 34
    //   400: ldc_w 1018
    //   403: aload_1
    //   404: invokestatic 461	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   407: ldc_w 969
    //   410: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: return
    //   414: aload_3
    //   415: getfield 302	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:pxC	J
    //   418: lstore 13
    //   420: aload_3
    //   421: getfield 334	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:pxE	Lcom/tencent/mm/vfs/q;
    //   424: astore 29
    //   426: aload_3
    //   427: getfield 387	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:pxD	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   430: ifnull +1548 -> 1978
    //   433: aload_3
    //   434: getfield 387	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m$a:pxD	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   437: astore_3
    //   438: aload_3
    //   439: invokeinterface 1019 1 0
    //   444: lstore 15
    //   446: aload_3
    //   447: invokeinterface 1023 1 0
    //   452: astore 31
    //   454: aload 31
    //   456: astore 30
    //   458: aload 4
    //   460: lload 15
    //   462: aload 31
    //   464: invokevirtual 1026	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:a	(JLcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;)V
    //   467: aload 31
    //   469: astore 30
    //   471: aload 31
    //   473: getstatic 994	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:pwO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   476: invokevirtual 1027	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:equals	(Ljava/lang/Object;)Z
    //   479: ifeq +17 -> 496
    //   482: aload 31
    //   484: astore 30
    //   486: bipush 6
    //   488: aload 34
    //   490: ldc_w 1029
    //   493: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   496: aload 31
    //   498: astore 30
    //   500: aload 31
    //   502: invokevirtual 1030	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:toString	()Ljava/lang/String;
    //   505: astore 28
    //   507: aload 31
    //   509: astore 30
    //   511: aload_2
    //   512: invokestatic 311	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:aiP	(Ljava/lang/String;)Z
    //   515: ifne +1594 -> 2109
    //   518: iconst_1
    //   519: istore 27
    //   521: aload 31
    //   523: astore 30
    //   525: lload 17
    //   527: lload 25
    //   529: lload 15
    //   531: aload 28
    //   533: iload 27
    //   535: invokestatic 1033	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:a	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   538: astore 28
    //   540: aload 31
    //   542: astore 30
    //   544: iconst_4
    //   545: aload 34
    //   547: new 115	java/lang/StringBuilder
    //   550: dup
    //   551: ldc_w 1035
    //   554: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   557: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   560: lload 23
    //   562: lsub
    //   563: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   566: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   572: aload 31
    //   574: astore 30
    //   576: iconst_4
    //   577: aload 34
    //   579: new 115	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 1037
    //   586: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: lload 15
    //   591: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   594: ldc_w 1039
    //   597: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload 28
    //   602: invokestatic 885	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ajm	(Ljava/lang/String;)Ljava/lang/String;
    //   605: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   614: aload 31
    //   616: astore 30
    //   618: aload 36
    //   620: aload 28
    //   622: ldc_w 512
    //   625: invokevirtual 1042	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   628: invokevirtual 727	java/io/OutputStream:write	([B)V
    //   631: aload 31
    //   633: astore 30
    //   635: aload 36
    //   637: invokevirtual 1045	java/io/OutputStream:flush	()V
    //   640: aload 31
    //   642: astore 30
    //   644: invokestatic 430	java/lang/System:currentTimeMillis	()J
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
    //   675: invokestatic 527	java/lang/Thread:interrupted	()Z
    //   678: ifne +1437 -> 2115
    //   681: iconst_1
    //   682: istore 5
    //   684: iload 5
    //   686: ifeq +1817 -> 2503
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
    //   712: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   715: ifne +1788 -> 2503
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
    //   742: ldc_w 988
    //   745: invokeinterface 1049 4 0
    //   750: istore 12
    //   752: iload 12
    //   754: iconst_m1
    //   755: if_icmpeq +1748 -> 2503
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
    //   780: getfield 896	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxT	Ljava/lang/String;
    //   783: ifnull +1338 -> 2121
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
    //   808: getfield 896	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxT	Ljava/lang/String;
    //   811: invokevirtual 1052	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   814: ldc_w 1054
    //   817: invokevirtual 544	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   820: ifeq +1301 -> 2121
    //   823: iconst_1
    //   824: istore 7
    //   826: iload 7
    //   828: ifne +1675 -> 2503
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
    //   851: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   854: lload 21
    //   856: lsub
    //   857: lstore 21
    //   859: lload 21
    //   861: ldc2_w 1055
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
    //   895: ldc_w 1058
    //   898: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   901: lload 21
    //   903: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   906: ldc_w 1060
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
    //   938: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   941: lstore 21
    //   943: iload 6
    //   945: ifne +1245 -> 2190
    //   948: lload 17
    //   950: lconst_0
    //   951: lcmp
    //   952: ifne +1238 -> 2190
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
    //   979: instanceof 1062
    //   982: ifeq +1145 -> 2127
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
    //   1006: checkcast 1062	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c
    //   1009: getfield 1065	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c:pvW	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
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
    //   1036: instanceof 1067
    //   1039: ifeq +1151 -> 2190
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
    //   1064: checkcast 1067	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l
    //   1067: invokeinterface 1071 1 0
    //   1072: astore 28
    //   1074: aload 28
    //   1076: ifnull +1084 -> 2160
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
    //   1103: invokeinterface 1077 2 0
    //   1108: ifne +1082 -> 2190
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
    //   1131: new 1079	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$d
    //   1134: dup
    //   1135: ldc_w 1081
    //   1138: aload 33
    //   1140: invokespecial 1084	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$d:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;)V
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
    //   1165: ldc_w 969
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
    //   1218: instanceof 1086
    //   1221: ifeq +1852 -> 3073
    //   1224: aload_3
    //   1225: astore 32
    //   1227: aload_3
    //   1228: checkcast 1086	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f
    //   1231: astore 37
    //   1233: aload_3
    //   1234: astore 32
    //   1236: aload_3
    //   1237: astore 33
    //   1239: aload 4
    //   1241: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   1244: bipush 90
    //   1246: if_icmpne +3596 -> 4842
    //   1249: aload_3
    //   1250: astore 31
    //   1252: aload_3
    //   1253: astore 32
    //   1255: aload 37
    //   1257: getfield 1089	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:bpg	I
    //   1260: sipush 416
    //   1263: if_icmpne +281 -> 1544
    //   1266: ldc2_w 986
    //   1269: lstore 19
    //   1271: aload_3
    //   1272: astore 32
    //   1274: aload_0
    //   1275: getfield 169	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxs	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/p;
    //   1278: aload 35
    //   1280: iconst_m1
    //   1281: invokevirtual 1093	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/p:cm	(Ljava/lang/String;I)Ljava/util/ArrayList;
    //   1284: invokevirtual 1097	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1287: astore 31
    //   1289: aload_3
    //   1290: astore 32
    //   1292: aload 31
    //   1294: invokeinterface 1102 1 0
    //   1299: ifeq +3555 -> 4854
    //   1302: aload_3
    //   1303: astore 32
    //   1305: aload 31
    //   1307: invokeinterface 1106 1 0
    //   1312: checkcast 394	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n
    //   1315: astore 33
    //   1317: aload_3
    //   1318: astore 32
    //   1320: aload 33
    //   1322: aload 4
    //   1324: invokevirtual 1107	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   1327: ifne -38 -> 1289
    //   1330: aload_3
    //   1331: astore 32
    //   1333: aload 33
    //   1335: invokevirtual 949	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:getTotalLength	()J
    //   1338: ldc2_w 986
    //   1341: lcmp
    //   1342: ifeq -53 -> 1289
    //   1345: aload_3
    //   1346: astore 32
    //   1348: aload 33
    //   1350: invokevirtual 949	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:getTotalLength	()J
    //   1353: lstore 19
    //   1355: aload_3
    //   1356: astore 32
    //   1358: aload 33
    //   1360: invokevirtual 1108	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVy	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   1363: astore 30
    //   1365: aload_3
    //   1366: astore 31
    //   1368: lload 19
    //   1370: ldc2_w 986
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
    //   1393: ldc2_w 995
    //   1396: lcmp
    //   1397: ifne +147 -> 1544
    //   1400: aload_3
    //   1401: astore 32
    //   1403: aload 30
    //   1405: invokevirtual 1030	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:toString	()Ljava/lang/String;
    //   1408: astore 31
    //   1410: aload_3
    //   1411: astore 32
    //   1413: aload_2
    //   1414: invokestatic 311	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:aiP	(Ljava/lang/String;)Z
    //   1417: ifne +1451 -> 2868
    //   1420: iconst_1
    //   1421: istore 27
    //   1423: aload_3
    //   1424: astore 32
    //   1426: lload 17
    //   1428: lload 25
    //   1430: lload 19
    //   1432: aload 31
    //   1434: iload 27
    //   1436: invokestatic 1033	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:a	(JJJLjava/lang/String;Z)Ljava/lang/String;
    //   1439: astore 31
    //   1441: aload_3
    //   1442: astore 32
    //   1444: aload 30
    //   1446: getstatic 994	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:pwO	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/c;
    //   1449: invokevirtual 1027	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/c:equals	(Ljava/lang/Object;)Z
    //   1452: ifeq +16 -> 1468
    //   1455: aload_3
    //   1456: astore 32
    //   1458: bipush 6
    //   1460: aload 34
    //   1462: ldc_w 1110
    //   1465: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1468: aload_3
    //   1469: astore 32
    //   1471: iconst_4
    //   1472: aload 34
    //   1474: new 115	java/lang/StringBuilder
    //   1477: dup
    //   1478: ldc_w 1112
    //   1481: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1484: lload 15
    //   1486: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1489: ldc_w 1039
    //   1492: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: aload 31
    //   1497: invokestatic 885	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:ajm	(Ljava/lang/String;)Ljava/lang/String;
    //   1500: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1509: aload_3
    //   1510: astore 32
    //   1512: aload 36
    //   1514: aload 31
    //   1516: ldc_w 512
    //   1519: invokevirtual 1042	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   1522: invokevirtual 727	java/io/OutputStream:write	([B)V
    //   1525: aload_3
    //   1526: astore 32
    //   1528: aload 36
    //   1530: invokevirtual 1045	java/io/OutputStream:flush	()V
    //   1533: aload_3
    //   1534: astore 32
    //   1536: aload 36
    //   1538: invokevirtual 664	java/io/OutputStream:close	()V
    //   1541: aconst_null
    //   1542: astore 31
    //   1544: aload 31
    //   1546: astore 33
    //   1548: aload 31
    //   1550: ifnull +3292 -> 4842
    //   1553: aload 31
    //   1555: astore 32
    //   1557: iconst_4
    //   1558: aload 34
    //   1560: new 115	java/lang/StringBuilder
    //   1563: dup
    //   1564: ldc_w 1114
    //   1567: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1570: aload 4
    //   1572: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   1575: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: ldc_w 1116
    //   1581: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: aload 37
    //   1586: getfield 1119	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:bph	Ljava/util/Map;
    //   1589: invokestatic 1123	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:M	(Ljava/util/Map;)Ljava/lang/String;
    //   1592: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1601: aload 31
    //   1603: astore 32
    //   1605: aload 37
    //   1607: getfield 1119	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:bph	Ljava/util/Map;
    //   1610: invokestatic 1127	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:N	(Ljava/util/Map;)J
    //   1613: lstore 15
    //   1615: aload 31
    //   1617: astore 32
    //   1619: aload 37
    //   1621: getfield 1089	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$f:bpg	I
    //   1624: i2l
    //   1625: lload 15
    //   1627: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   1630: lstore 13
    //   1632: aload 31
    //   1634: astore_3
    //   1635: aload 4
    //   1637: iconst_1
    //   1638: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   1641: ifeq +8 -> 1649
    //   1644: aload 4
    //   1646: invokevirtual 660	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVH	()V
    //   1649: iconst_4
    //   1650: aload 34
    //   1652: new 115	java/lang/StringBuilder
    //   1655: dup
    //   1656: ldc_w 1129
    //   1659: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1662: iload 6
    //   1664: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1667: ldc_w 1131
    //   1670: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1673: lload 17
    //   1675: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1678: ldc_w 1013
    //   1681: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: lload 25
    //   1686: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1689: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1692: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1695: aload 28
    //   1697: invokeinterface 1014 1 0
    //   1702: aload_3
    //   1703: ifnonnull +7 -> 1710
    //   1706: aload_1
    //   1707: invokevirtual 435	java/net/Socket:close	()V
    //   1710: aload 29
    //   1712: ifnull +3115 -> 4827
    //   1715: aload 29
    //   1717: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   1720: ifeq +3107 -> 4827
    //   1723: aload 29
    //   1725: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   1728: ifeq +3099 -> 4827
    //   1731: iconst_4
    //   1732: aload 34
    //   1734: new 115	java/lang/StringBuilder
    //   1737: dup
    //   1738: ldc_w 1133
    //   1741: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1744: aload 29
    //   1746: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   1749: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1755: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1758: aload 29
    //   1760: invokevirtual 1136	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   1763: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1766: invokevirtual 471	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVu	()Ljava/lang/String;
    //   1769: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1772: ifeq +3055 -> 4827
    //   1775: aload 29
    //   1777: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   1780: ifne +30 -> 1810
    //   1783: iconst_5
    //   1784: aload 34
    //   1786: new 115	java/lang/StringBuilder
    //   1789: dup
    //   1790: ldc_w 1138
    //   1793: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1796: aload 29
    //   1798: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   1801: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1804: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1807: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1810: aload_0
    //   1811: getfield 169	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxs	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/p;
    //   1814: aload 4
    //   1816: invokevirtual 438	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/p:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/n;)V
    //   1819: aload 4
    //   1821: iconst_2
    //   1822: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   1825: ifeq +2465 -> 4290
    //   1828: aload 4
    //   1830: invokevirtual 450	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVG	()V
    //   1833: aload 4
    //   1835: iconst_1
    //   1836: putfield 453	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:kUD	Z
    //   1839: ldc_w 651
    //   1842: astore_1
    //   1843: aload 4
    //   1845: getfield 490	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:uuid	Ljava/lang/String;
    //   1848: astore 29
    //   1850: invokestatic 430	java/lang/System:currentTimeMillis	()J
    //   1853: lload 23
    //   1855: lsub
    //   1856: l2i
    //   1857: istore 5
    //   1859: aload_0
    //   1860: getfield 86	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxt	Ljava/util/Map;
    //   1863: aload 35
    //   1865: invokeinterface 422 2 0
    //   1870: checkcast 424	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/d
    //   1873: astore 30
    //   1875: aload_3
    //   1876: instanceof 1086
    //   1879: ifeq +2426 -> 4305
    //   1882: ldc_w 1140
    //   1885: astore_1
    //   1886: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1889: getfield 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:pvJ	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1892: ifnull +70 -> 1962
    //   1895: lload 13
    //   1897: lload 15
    //   1899: invokestatic 943	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:I	(JJ)J
    //   1902: lstore 17
    //   1904: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1907: getfield 145	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:pvJ	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1910: aload 29
    //   1912: aload_2
    //   1913: aload 4
    //   1915: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   1918: aload 4
    //   1920: getfield 905	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxO	J
    //   1923: aload 4
    //   1925: getfield 908	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxP	J
    //   1928: aload 4
    //   1930: invokevirtual 949	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:getTotalLength	()J
    //   1933: aload 4
    //   1935: getfield 498	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxN	I
    //   1938: aload 4
    //   1940: getfield 896	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:pxT	Ljava/lang/String;
    //   1943: aload 4
    //   1945: invokevirtual 952	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVF	()J
    //   1948: lload 13
    //   1950: lload 15
    //   1952: lload 17
    //   1954: aload_1
    //   1955: iload 5
    //   1957: invokeinterface 955 22 0
    //   1962: iconst_4
    //   1963: aload 34
    //   1965: ldc_w 1142
    //   1968: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1971: ldc_w 969
    //   1974: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1977: return
    //   1978: aload 28
    //   1980: instanceof 1062
    //   1983: ifeq +103 -> 2086
    //   1986: aload 28
    //   1988: checkcast 1062	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c
    //   1991: getfield 1065	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c:pvW	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   1994: astore_3
    //   1995: aload_3
    //   1996: instanceof 1067
    //   1999: ifeq +64 -> 2063
    //   2002: aload_3
    //   2003: checkcast 1067	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l
    //   2006: invokeinterface 1145 1 0
    //   2011: astore 31
    //   2013: aload 31
    //   2015: ifnull +26 -> 2041
    //   2018: iconst_4
    //   2019: aload 34
    //   2021: ldc_w 1147
    //   2024: aload 31
    //   2026: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2029: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2032: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2035: aload 28
    //   2037: astore_3
    //   2038: goto -1600 -> 438
    //   2041: iconst_4
    //   2042: aload 34
    //   2044: ldc_w 1149
    //   2047: aload_3
    //   2048: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2051: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2054: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2057: aload 28
    //   2059: astore_3
    //   2060: goto -1622 -> 438
    //   2063: bipush 6
    //   2065: aload 34
    //   2067: ldc_w 1151
    //   2070: aload_3
    //   2071: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2074: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2077: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2080: aload 28
    //   2082: astore_3
    //   2083: goto -1645 -> 438
    //   2086: iconst_4
    //   2087: aload 34
    //   2089: ldc_w 1153
    //   2092: aload 28
    //   2094: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2097: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2100: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2103: aload 28
    //   2105: astore_3
    //   2106: goto -1668 -> 438
    //   2109: iconst_0
    //   2110: istore 27
    //   2112: goto -1591 -> 521
    //   2115: iconst_0
    //   2116: istore 5
    //   2118: goto -1434 -> 684
    //   2121: iconst_0
    //   2122: istore 7
    //   2124: goto -1298 -> 826
    //   2127: iload 5
    //   2129: istore 8
    //   2131: iload 6
    //   2133: istore 7
    //   2135: iload 5
    //   2137: istore 10
    //   2139: iload 6
    //   2141: istore 9
    //   2143: iload 6
    //   2145: istore 11
    //   2147: aload_3
    //   2148: instanceof 1067
    //   2151: ifeq -1137 -> 1014
    //   2154: aload_3
    //   2155: astore 28
    //   2157: goto -1143 -> 1014
    //   2160: iload 5
    //   2162: istore 8
    //   2164: iload 6
    //   2166: istore 7
    //   2168: iload 5
    //   2170: istore 10
    //   2172: iload 6
    //   2174: istore 9
    //   2176: iload 6
    //   2178: istore 11
    //   2180: bipush 6
    //   2182: aload 34
    //   2184: ldc_w 1155
    //   2187: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2190: iload 5
    //   2192: istore 8
    //   2194: iload 6
    //   2196: istore 7
    //   2198: iload 5
    //   2200: istore 10
    //   2202: iload 6
    //   2204: istore 9
    //   2206: iload 6
    //   2208: istore 11
    //   2210: aload 36
    //   2212: aload 32
    //   2214: iconst_0
    //   2215: iload 12
    //   2217: invokevirtual 1158	java/io/OutputStream:write	([BII)V
    //   2220: iload 6
    //   2222: iload 12
    //   2224: iadd
    //   2225: istore 6
    //   2227: iload 5
    //   2229: istore 8
    //   2231: iload 6
    //   2233: istore 7
    //   2235: iload 5
    //   2237: istore 10
    //   2239: iload 6
    //   2241: istore 9
    //   2243: iload 6
    //   2245: istore 11
    //   2247: aload 4
    //   2249: iload 12
    //   2251: invokevirtual 1161	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AW	(I)V
    //   2254: iload 5
    //   2256: istore 8
    //   2258: iload 6
    //   2260: istore 7
    //   2262: iload 5
    //   2264: istore 10
    //   2266: iload 6
    //   2268: istore 9
    //   2270: iload 6
    //   2272: istore 11
    //   2274: aload 4
    //   2276: iload 6
    //   2278: invokevirtual 1164	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AV	(I)V
    //   2281: goto -1626 -> 655
    //   2284: astore 28
    //   2286: iload 10
    //   2288: istore 5
    //   2290: iload 9
    //   2292: istore 6
    //   2294: iconst_4
    //   2295: aload 34
    //   2297: new 115	java/lang/StringBuilder
    //   2300: dup
    //   2301: ldc_w 1166
    //   2304: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2307: aload 28
    //   2309: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2312: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2315: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2318: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2321: aload 4
    //   2323: iconst_1
    //   2324: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2327: ifeq +8 -> 2335
    //   2330: aload 4
    //   2332: invokevirtual 660	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVH	()V
    //   2335: iconst_4
    //   2336: aload 34
    //   2338: new 115	java/lang/StringBuilder
    //   2341: dup
    //   2342: ldc_w 1129
    //   2345: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2348: iload 6
    //   2350: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2353: ldc_w 1131
    //   2356: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2359: lload 17
    //   2361: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2364: ldc_w 1013
    //   2367: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2370: lload 25
    //   2372: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2375: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2378: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2381: aload_3
    //   2382: invokeinterface 1014 1 0
    //   2387: aload 29
    //   2389: ifnull +2422 -> 4811
    //   2392: aload 29
    //   2394: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2397: ifeq +2414 -> 4811
    //   2400: aload 29
    //   2402: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2405: ifeq +2406 -> 4811
    //   2408: iconst_4
    //   2409: aload 34
    //   2411: new 115	java/lang/StringBuilder
    //   2414: dup
    //   2415: ldc_w 1133
    //   2418: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2421: aload 29
    //   2423: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2426: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2429: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2432: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2435: aload 29
    //   2437: invokevirtual 1136	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   2440: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2443: invokevirtual 471	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVu	()Ljava/lang/String;
    //   2446: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2449: ifeq +2362 -> 4811
    //   2452: aload 29
    //   2454: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   2457: ifne +30 -> 2487
    //   2460: iconst_5
    //   2461: aload 34
    //   2463: new 115	java/lang/StringBuilder
    //   2466: dup
    //   2467: ldc_w 1138
    //   2470: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2473: aload 29
    //   2475: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2478: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2487: aload 28
    //   2489: astore_1
    //   2490: ldc2_w 412
    //   2493: lstore 15
    //   2495: aload_3
    //   2496: astore 28
    //   2498: aload_1
    //   2499: astore_3
    //   2500: goto -690 -> 1810
    //   2503: iload 5
    //   2505: ifne +60 -> 2565
    //   2508: iload 5
    //   2510: istore 8
    //   2512: iload 6
    //   2514: istore 7
    //   2516: iload 5
    //   2518: istore 10
    //   2520: iload 6
    //   2522: istore 9
    //   2524: iload 6
    //   2526: istore 11
    //   2528: aload 4
    //   2530: sipush 256
    //   2533: invokevirtual 445	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AX	(I)V
    //   2536: iload 5
    //   2538: istore 8
    //   2540: iload 6
    //   2542: istore 7
    //   2544: iload 5
    //   2546: istore 10
    //   2548: iload 6
    //   2550: istore 9
    //   2552: iload 6
    //   2554: istore 11
    //   2556: iconst_4
    //   2557: aload 34
    //   2559: ldc_w 1168
    //   2562: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2565: iload 5
    //   2567: istore 8
    //   2569: iload 6
    //   2571: istore 7
    //   2573: iload 5
    //   2575: istore 10
    //   2577: iload 6
    //   2579: istore 9
    //   2581: iload 6
    //   2583: istore 11
    //   2585: aload 4
    //   2587: iconst_1
    //   2588: invokevirtual 442	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AY	(I)Z
    //   2591: ifeq +28 -> 2619
    //   2594: iload 5
    //   2596: istore 8
    //   2598: iload 6
    //   2600: istore 7
    //   2602: iload 5
    //   2604: istore 10
    //   2606: iload 6
    //   2608: istore 9
    //   2610: iload 6
    //   2612: istore 11
    //   2614: aload 4
    //   2616: invokevirtual 660	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:bVH	()V
    //   2619: iload 5
    //   2621: istore 8
    //   2623: iload 6
    //   2625: istore 7
    //   2627: iload 5
    //   2629: istore 10
    //   2631: iload 6
    //   2633: istore 9
    //   2635: iload 6
    //   2637: istore 11
    //   2639: aload 36
    //   2641: invokevirtual 1045	java/io/OutputStream:flush	()V
    //   2644: iload 5
    //   2646: istore 8
    //   2648: iload 6
    //   2650: istore 7
    //   2652: iload 5
    //   2654: istore 10
    //   2656: iload 6
    //   2658: istore 9
    //   2660: iload 6
    //   2662: istore 11
    //   2664: aload 36
    //   2666: invokevirtual 664	java/io/OutputStream:close	()V
    //   2669: iconst_4
    //   2670: aload 34
    //   2672: new 115	java/lang/StringBuilder
    //   2675: dup
    //   2676: ldc_w 1129
    //   2679: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2682: iload 6
    //   2684: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2687: ldc_w 1131
    //   2690: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2693: lload 17
    //   2695: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2698: ldc_w 1013
    //   2701: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2704: lload 25
    //   2706: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2709: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2712: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2715: aload_3
    //   2716: invokeinterface 1014 1 0
    //   2721: aload_1
    //   2722: invokevirtual 435	java/net/Socket:close	()V
    //   2725: aload 29
    //   2727: ifnull +2130 -> 4857
    //   2730: aload 29
    //   2732: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2735: ifeq +2122 -> 4857
    //   2738: aload 29
    //   2740: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2743: ifeq +2114 -> 4857
    //   2746: iconst_4
    //   2747: aload 34
    //   2749: new 115	java/lang/StringBuilder
    //   2752: dup
    //   2753: ldc_w 1133
    //   2756: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2759: aload 29
    //   2761: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2764: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2767: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2770: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2773: aload 29
    //   2775: invokevirtual 1136	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   2778: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2781: invokevirtual 471	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVu	()Ljava/lang/String;
    //   2784: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2787: ifeq +2070 -> 4857
    //   2790: aload 29
    //   2792: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   2795: ifne +30 -> 2825
    //   2798: iconst_5
    //   2799: aload 34
    //   2801: new 115	java/lang/StringBuilder
    //   2804: dup
    //   2805: ldc_w 1138
    //   2808: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2811: aload 29
    //   2813: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   2816: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2822: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2825: aconst_null
    //   2826: astore_1
    //   2827: ldc2_w 412
    //   2830: lstore 15
    //   2832: aload_3
    //   2833: astore 28
    //   2835: aload_1
    //   2836: astore_3
    //   2837: goto -1027 -> 1810
    //   2840: astore 28
    //   2842: iconst_5
    //   2843: aload 34
    //   2845: ldc_w 1016
    //   2848: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2851: goto -130 -> 2721
    //   2854: astore_1
    //   2855: iconst_5
    //   2856: aload 34
    //   2858: ldc_w 1018
    //   2861: aload_1
    //   2862: invokestatic 461	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2865: goto -140 -> 2725
    //   2868: iconst_0
    //   2869: istore 27
    //   2871: goto -1448 -> 1423
    //   2874: astore 30
    //   2876: aload_3
    //   2877: astore 32
    //   2879: iconst_4
    //   2880: aload 34
    //   2882: ldc_w 1170
    //   2885: aload 30
    //   2887: invokestatic 461	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2890: aload_3
    //   2891: astore 31
    //   2893: goto -1349 -> 1544
    //   2896: astore_2
    //   2897: aload 32
    //   2899: astore_3
    //   2900: iload 6
    //   2902: istore 5
    //   2904: iconst_4
    //   2905: aload 34
    //   2907: new 115	java/lang/StringBuilder
    //   2910: dup
    //   2911: ldc_w 1129
    //   2914: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2917: iload 5
    //   2919: invokevirtual 235	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2922: ldc_w 1131
    //   2925: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2928: lload 17
    //   2930: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2933: ldc_w 1013
    //   2936: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: lload 25
    //   2941: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2944: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2947: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2950: aload 28
    //   2952: invokeinterface 1014 1 0
    //   2957: aload_3
    //   2958: ifnonnull +7 -> 2965
    //   2961: aload_1
    //   2962: invokevirtual 435	java/net/Socket:close	()V
    //   2965: aload 29
    //   2967: ifnull +98 -> 3065
    //   2970: aload 29
    //   2972: invokevirtual 667	com/tencent/mm/vfs/q:ifH	()Z
    //   2975: ifeq +90 -> 3065
    //   2978: aload 29
    //   2980: invokevirtual 330	com/tencent/mm/vfs/q:ifE	()Z
    //   2983: ifeq +82 -> 3065
    //   2986: iconst_4
    //   2987: aload 34
    //   2989: new 115	java/lang/StringBuilder
    //   2992: dup
    //   2993: ldc_w 1133
    //   2996: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2999: aload 29
    //   3001: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   3004: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3007: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3010: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3013: aload 29
    //   3015: invokevirtual 1136	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   3018: invokestatic 107	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVt	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   3021: invokevirtual 471	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bVu	()Ljava/lang/String;
    //   3024: invokevirtual 535	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   3027: ifeq +38 -> 3065
    //   3030: aload 29
    //   3032: invokevirtual 670	com/tencent/mm/vfs/q:cFq	()Z
    //   3035: ifne +30 -> 3065
    //   3038: iconst_5
    //   3039: aload 34
    //   3041: new 115	java/lang/StringBuilder
    //   3044: dup
    //   3045: ldc_w 1138
    //   3048: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3051: aload 29
    //   3053: invokevirtual 337	com/tencent/mm/vfs/q:toString	()Ljava/lang/String;
    //   3056: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3059: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3062: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3065: ldc_w 969
    //   3068: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3071: aload_2
    //   3072: athrow
    //   3073: aload_3
    //   3074: astore 32
    //   3076: aload_3
    //   3077: instanceof 1172
    //   3080: ifeq +105 -> 3185
    //   3083: aload_3
    //   3084: astore 32
    //   3086: aload_3
    //   3087: checkcast 1172	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$e
    //   3090: astore 30
    //   3092: aload_3
    //   3093: astore 32
    //   3095: iconst_4
    //   3096: aload 34
    //   3098: new 115	java/lang/StringBuilder
    //   3101: dup
    //   3102: ldc_w 1114
    //   3105: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3108: aload 4
    //   3110: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3113: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: ldc_w 1174
    //   3119: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3122: aload 30
    //   3124: getfield 1175	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$e:bph	Ljava/util/Map;
    //   3127: invokestatic 1123	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/f:M	(Ljava/util/Map;)Ljava/lang/String;
    //   3130: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3133: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3136: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3139: aload_3
    //   3140: astore 32
    //   3142: lload 19
    //   3144: lstore 15
    //   3146: aload 4
    //   3148: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3151: bipush 90
    //   3153: if_icmpne +1719 -> 4872
    //   3156: aload_3
    //   3157: astore 32
    //   3159: aload 30
    //   3161: getfield 1175	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$e:bph	Ljava/util/Map;
    //   3164: invokestatic 1127	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:N	(Ljava/util/Map;)J
    //   3167: lstore 15
    //   3169: aload_3
    //   3170: astore 32
    //   3172: ldc2_w 1176
    //   3175: lload 15
    //   3177: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3180: lstore 13
    //   3182: goto +1690 -> 4872
    //   3185: aload_3
    //   3186: astore 32
    //   3188: aload_3
    //   3189: instanceof 1079
    //   3192: ifeq +73 -> 3265
    //   3195: aload_3
    //   3196: astore 32
    //   3198: iconst_4
    //   3199: aload 34
    //   3201: new 115	java/lang/StringBuilder
    //   3204: dup
    //   3205: ldc_w 1114
    //   3208: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3211: aload 4
    //   3213: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3216: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3219: ldc_w 1179
    //   3222: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3225: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3228: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3231: aload_3
    //   3232: astore 32
    //   3234: aload 4
    //   3236: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3239: bipush 90
    //   3241: if_icmpne +973 -> 4214
    //   3244: aload_3
    //   3245: astore 32
    //   3247: ldc2_w 1180
    //   3250: ldc2_w 412
    //   3253: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3256: lstore 13
    //   3258: lload 19
    //   3260: lstore 15
    //   3262: goto -1627 -> 1635
    //   3265: aload_3
    //   3266: astore 32
    //   3268: aload_3
    //   3269: instanceof 1183
    //   3272: ifeq +73 -> 3345
    //   3275: aload_3
    //   3276: astore 32
    //   3278: iconst_4
    //   3279: aload 34
    //   3281: new 115	java/lang/StringBuilder
    //   3284: dup
    //   3285: ldc_w 1114
    //   3288: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3291: aload 4
    //   3293: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3296: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3299: ldc_w 1185
    //   3302: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3305: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3308: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3311: aload_3
    //   3312: astore 32
    //   3314: aload 4
    //   3316: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3319: bipush 90
    //   3321: if_icmpne +893 -> 4214
    //   3324: aload_3
    //   3325: astore 32
    //   3327: ldc2_w 1186
    //   3330: ldc2_w 412
    //   3333: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3336: lstore 13
    //   3338: lload 19
    //   3340: lstore 15
    //   3342: goto -1707 -> 1635
    //   3345: aload_3
    //   3346: astore 32
    //   3348: aload_3
    //   3349: instanceof 408
    //   3352: ifeq +60 -> 3412
    //   3355: aload_3
    //   3356: astore 32
    //   3358: aload 4
    //   3360: sipush 256
    //   3363: invokevirtual 445	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AX	(I)V
    //   3366: aload_3
    //   3367: astore 32
    //   3369: iconst_5
    //   3370: aload 34
    //   3372: new 115	java/lang/StringBuilder
    //   3375: dup
    //   3376: ldc_w 1114
    //   3379: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3382: aload 4
    //   3384: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3387: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3390: ldc_w 1189
    //   3393: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3396: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3399: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3402: iconst_0
    //   3403: istore 5
    //   3405: lload 19
    //   3407: lstore 15
    //   3409: goto -1774 -> 1635
    //   3412: aload_3
    //   3413: astore 32
    //   3415: aload_3
    //   3416: instanceof 410
    //   3419: ifeq +60 -> 3479
    //   3422: aload_3
    //   3423: astore 32
    //   3425: aload 4
    //   3427: sipush 256
    //   3430: invokevirtual 445	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AX	(I)V
    //   3433: aload_3
    //   3434: astore 32
    //   3436: iconst_5
    //   3437: aload 34
    //   3439: new 115	java/lang/StringBuilder
    //   3442: dup
    //   3443: ldc_w 1114
    //   3446: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3449: aload 4
    //   3451: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3454: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3457: ldc_w 1191
    //   3460: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3466: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3469: iconst_0
    //   3470: istore 5
    //   3472: lload 19
    //   3474: lstore 15
    //   3476: goto -1841 -> 1635
    //   3479: aload_3
    //   3480: astore 32
    //   3482: aload_3
    //   3483: instanceof 1193
    //   3486: ifeq +250 -> 3736
    //   3489: aload_3
    //   3490: astore 32
    //   3492: iconst_5
    //   3493: aload 34
    //   3495: new 115	java/lang/StringBuilder
    //   3498: dup
    //   3499: ldc_w 1114
    //   3502: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3505: aload 4
    //   3507: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3510: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: ldc_w 1195
    //   3516: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3519: aload_3
    //   3520: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3523: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3526: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3529: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3532: aload_3
    //   3533: astore 32
    //   3535: aload 4
    //   3537: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3540: bipush 90
    //   3542: if_icmpne +672 -> 4214
    //   3545: aload_3
    //   3546: astore 32
    //   3548: aload 28
    //   3550: instanceof 1062
    //   3553: ifeq +141 -> 3694
    //   3556: aload_3
    //   3557: astore 32
    //   3559: aload 28
    //   3561: checkcast 1062	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c
    //   3564: getfield 1065	com/tencent/mm/plugin/appbrand/jsapi/video/b/a/c:pvW	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/e;
    //   3567: astore 30
    //   3569: aload_3
    //   3570: astore 32
    //   3572: aload 30
    //   3574: instanceof 1197
    //   3577: ifeq +91 -> 3668
    //   3580: aload_3
    //   3581: astore 32
    //   3583: aload 30
    //   3585: checkcast 1197	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j
    //   3588: getfield 1201	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pvN	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;
    //   3591: astore 30
    //   3593: aload 30
    //   3595: ifnull +1235 -> 4830
    //   3598: aload_3
    //   3599: astore 32
    //   3601: aload 30
    //   3603: getfield 1205	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:uri	Landroid/net/Uri;
    //   3606: astore 30
    //   3608: aload 30
    //   3610: ifnull +1220 -> 4830
    //   3613: aload_3
    //   3614: astore 32
    //   3616: aload 30
    //   3618: invokevirtual 1208	android/net/Uri:getHost	()Ljava/lang/String;
    //   3621: ifnull +1209 -> 4830
    //   3624: aload_3
    //   3625: astore 32
    //   3627: aload 30
    //   3629: invokevirtual 1208	android/net/Uri:getHost	()Ljava/lang/String;
    //   3632: ldc_w 1210
    //   3635: invokevirtual 544	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3638: ifeq +1192 -> 4830
    //   3641: iconst_1
    //   3642: istore 7
    //   3644: goto +1231 -> 4875
    //   3647: aload_3
    //   3648: astore 32
    //   3650: iload 7
    //   3652: i2l
    //   3653: ldc2_w 412
    //   3656: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3659: lstore 13
    //   3661: lload 19
    //   3663: lstore 15
    //   3665: goto -2030 -> 1635
    //   3668: aload_3
    //   3669: astore 32
    //   3671: iconst_4
    //   3672: aload 34
    //   3674: ldc_w 1212
    //   3677: aload 28
    //   3679: invokestatic 402	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3682: invokevirtual 261	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3685: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3688: aconst_null
    //   3689: astore 30
    //   3691: goto -98 -> 3593
    //   3694: aload_3
    //   3695: astore 32
    //   3697: aload 28
    //   3699: instanceof 1197
    //   3702: ifeq +1134 -> 4836
    //   3705: aload_3
    //   3706: astore 32
    //   3708: aload 28
    //   3710: checkcast 1197	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j
    //   3713: getfield 1201	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:pvN	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/b/g;
    //   3716: astore 30
    //   3718: goto -125 -> 3593
    //   3721: aload_3
    //   3722: astore 32
    //   3724: invokestatic 1215	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   3727: ifeq +1160 -> 4887
    //   3730: iconst_5
    //   3731: istore 7
    //   3733: goto -86 -> 3647
    //   3736: aload_3
    //   3737: astore 32
    //   3739: aload_3
    //   3740: instanceof 1217
    //   3743: ifeq +82 -> 3825
    //   3746: aload_3
    //   3747: astore 32
    //   3749: iconst_5
    //   3750: aload 34
    //   3752: new 115	java/lang/StringBuilder
    //   3755: dup
    //   3756: ldc_w 1114
    //   3759: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3762: aload 4
    //   3764: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3767: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3770: ldc_w 1219
    //   3773: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3776: aload_3
    //   3777: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3780: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3783: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3786: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3789: aload_3
    //   3790: astore 32
    //   3792: aload 4
    //   3794: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3797: bipush 90
    //   3799: if_icmpne +415 -> 4214
    //   3802: aload_3
    //   3803: astore 32
    //   3805: aload_3
    //   3806: invokestatic 1223	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:h	(Ljava/lang/Throwable;)I
    //   3809: i2l
    //   3810: ldc2_w 412
    //   3813: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3816: lstore 13
    //   3818: lload 19
    //   3820: lstore 15
    //   3822: goto -2187 -> 1635
    //   3825: aload_3
    //   3826: astore 32
    //   3828: aload 28
    //   3830: instanceof 1225
    //   3833: ifeq +90 -> 3923
    //   3836: aload_3
    //   3837: astore 32
    //   3839: aload_3
    //   3840: instanceof 1227
    //   3843: ifeq +80 -> 3923
    //   3846: aload_3
    //   3847: astore 32
    //   3849: iconst_5
    //   3850: aload 34
    //   3852: new 115	java/lang/StringBuilder
    //   3855: dup
    //   3856: ldc_w 1114
    //   3859: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3862: aload 4
    //   3864: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3867: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3870: ldc_w 1229
    //   3873: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3876: aload_3
    //   3877: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3880: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3883: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3886: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3889: aload_3
    //   3890: astore 32
    //   3892: aload 4
    //   3894: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3897: bipush 90
    //   3899: if_icmpne +315 -> 4214
    //   3902: aload_3
    //   3903: astore 32
    //   3905: ldc2_w 1230
    //   3908: ldc2_w 412
    //   3911: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3914: lstore 13
    //   3916: lload 19
    //   3918: lstore 15
    //   3920: goto -2285 -> 1635
    //   3923: aload_3
    //   3924: astore 32
    //   3926: aload_3
    //   3927: instanceof 1233
    //   3930: ifeq +78 -> 4008
    //   3933: aload_3
    //   3934: astore 32
    //   3936: iconst_5
    //   3937: aload 34
    //   3939: new 115	java/lang/StringBuilder
    //   3942: dup
    //   3943: ldc_w 1114
    //   3946: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3949: aload 4
    //   3951: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   3954: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3957: ldc_w 1235
    //   3960: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3963: aload_3
    //   3964: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3967: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3970: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3973: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3976: aload_3
    //   3977: astore 32
    //   3979: aload 4
    //   3981: getfield 411	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:priority	I
    //   3984: bipush 90
    //   3986: if_icmpne +228 -> 4214
    //   3989: aload_3
    //   3990: astore 32
    //   3992: lconst_1
    //   3993: ldc2_w 412
    //   3996: invokestatic 416	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:H	(JJ)J
    //   3999: lstore 13
    //   4001: lload 19
    //   4003: lstore 15
    //   4005: goto -2370 -> 1635
    //   4008: aload_3
    //   4009: astore 32
    //   4011: aload_3
    //   4012: instanceof 1237
    //   4015: ifeq +60 -> 4075
    //   4018: aload_3
    //   4019: astore 32
    //   4021: aload 4
    //   4023: sipush 256
    //   4026: invokevirtual 445	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AX	(I)V
    //   4029: aload_3
    //   4030: astore 32
    //   4032: iconst_4
    //   4033: aload 34
    //   4035: new 115	java/lang/StringBuilder
    //   4038: dup
    //   4039: ldc_w 1114
    //   4042: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4045: aload 4
    //   4047: getfield 899	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:fVx	Ljava/lang/String;
    //   4050: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4053: ldc_w 1239
    //   4056: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4059: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4062: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4065: iconst_0
    //   4066: istore 5
    //   4068: lload 19
    //   4070: lstore 15
    //   4072: goto -2437 -> 1635
    //   4075: aload_3
    //   4076: astore 32
    //   4078: aload_0
    //   4079: getfield 1241	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:pxr	Z
    //   4082: ifeq +22 -> 4104
    //   4085: aload_3
    //   4086: astore 32
    //   4088: iconst_5
    //   4089: aload 34
    //   4091: ldc_w 1243
    //   4094: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4097: lload 19
    //   4099: lstore 15
    //   4101: goto -2466 -> 1635
    //   4104: aload_3
    //   4105: astore 32
    //   4107: aload_3
    //   4108: invokevirtual 960	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4111: ldc_w 1245
    //   4114: invokevirtual 1247	java/lang/String:matches	(Ljava/lang/String;)Z
    //   4117: ifeq +22 -> 4139
    //   4120: aload_3
    //   4121: astore 32
    //   4123: iconst_5
    //   4124: aload 34
    //   4126: ldc_w 1249
    //   4129: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4132: lload 19
    //   4134: lstore 15
    //   4136: goto -2501 -> 1635
    //   4139: aload_3
    //   4140: astore 32
    //   4142: aload_3
    //   4143: invokevirtual 1250	java/lang/Exception:toString	()Ljava/lang/String;
    //   4146: ldc_w 1252
    //   4149: invokevirtual 627	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   4152: ifeq +22 -> 4174
    //   4155: aload_3
    //   4156: astore 32
    //   4158: iconst_5
    //   4159: aload 34
    //   4161: ldc_w 1254
    //   4164: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4167: lload 19
    //   4169: lstore 15
    //   4171: goto -2536 -> 1635
    //   4174: aload_3
    //   4175: astore 32
    //   4177: iconst_5
    //   4178: aload 34
    //   4180: new 115	java/lang/StringBuilder
    //   4183: dup
    //   4184: ldc_w 1114
    //   4187: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4190: aload 4
    //   4192: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4195: ldc_w 1256
    //   4198: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4201: aload_3
    //   4202: invokestatic 292	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:i	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4205: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4208: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4211: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4214: lload 19
    //   4216: lstore 15
    //   4218: goto -2583 -> 1635
    //   4221: astore 30
    //   4223: iconst_5
    //   4224: aload 34
    //   4226: ldc_w 1016
    //   4229: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4232: goto -2530 -> 1702
    //   4235: astore_1
    //   4236: iconst_5
    //   4237: aload 34
    //   4239: ldc_w 1018
    //   4242: aload_1
    //   4243: invokestatic 461	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4246: goto -2536 -> 1710
    //   4249: astore_1
    //   4250: iconst_5
    //   4251: aload 34
    //   4253: ldc_w 1016
    //   4256: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4259: goto -1872 -> 2387
    //   4262: astore 4
    //   4264: iconst_5
    //   4265: aload 34
    //   4267: ldc_w 1016
    //   4270: invokestatic 133	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   4273: goto -1316 -> 2957
    //   4276: astore_1
    //   4277: iconst_5
    //   4278: aload 34
    //   4280: ldc_w 1018
    //   4283: aload_1
    //   4284: invokestatic 461	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4287: goto -1322 -> 2965
    //   4290: iload 5
    //   4292: ifeq -2459 -> 1833
    //   4295: aload 4
    //   4297: bipush 16
    //   4299: invokevirtual 445	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/n:AX	(I)V
    //   4302: goto -2469 -> 1833
    //   4305: aload_3
    //   4306: instanceof 1172
    //   4309: ifeq +10 -> 4319
    //   4312: ldc_w 1258
    //   4315: astore_1
    //   4316: goto -2430 -> 1886
    //   4319: aload_3
    //   4320: instanceof 1079
    //   4323: ifeq +27 -> 4350
    //   4326: ldc_w 1260
    //   4329: astore_3
    //   4330: aload_3
    //   4331: astore_1
    //   4332: aload 30
    //   4334: ifnull -2448 -> 1886
    //   4337: new 83	java/util/HashMap
    //   4340: dup
    //   4341: invokespecial 84	java/util/HashMap:<init>	()V
    //   4344: pop
    //   4345: aload_3
    //   4346: astore_1
    //   4347: goto -2461 -> 1886
    //   4350: aload_3
    //   4351: instanceof 1183
    //   4354: ifeq +27 -> 4381
    //   4357: ldc_w 1262
    //   4360: astore_3
    //   4361: aload_3
    //   4362: astore_1
    //   4363: aload 30
    //   4365: ifnull -2479 -> 1886
    //   4368: new 83	java/util/HashMap
    //   4371: dup
    //   4372: invokespecial 84	java/util/HashMap:<init>	()V
    //   4375: pop
    //   4376: aload_3
    //   4377: astore_1
    //   4378: goto -2492 -> 1886
    //   4381: aload_3
    //   4382: instanceof 408
    //   4385: ifeq +31 -> 4416
    //   4388: ldc_w 1264
    //   4391: astore_3
    //   4392: aload_3
    //   4393: astore_1
    //   4394: aload 30
    //   4396: ifnull -2510 -> 1886
    //   4399: invokestatic 1215	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   4402: pop
    //   4403: new 83	java/util/HashMap
    //   4406: dup
    //   4407: invokespecial 84	java/util/HashMap:<init>	()V
    //   4410: pop
    //   4411: aload_3
    //   4412: astore_1
    //   4413: goto -2527 -> 1886
    //   4416: aload_3
    //   4417: instanceof 410
    //   4420: ifeq +31 -> 4451
    //   4423: ldc_w 1266
    //   4426: astore_3
    //   4427: aload_3
    //   4428: astore_1
    //   4429: aload 30
    //   4431: ifnull -2545 -> 1886
    //   4434: invokestatic 1215	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   4437: pop
    //   4438: new 83	java/util/HashMap
    //   4441: dup
    //   4442: invokespecial 84	java/util/HashMap:<init>	()V
    //   4445: pop
    //   4446: aload_3
    //   4447: astore_1
    //   4448: goto -2562 -> 1886
    //   4451: aload_3
    //   4452: instanceof 1193
    //   4455: ifeq +31 -> 4486
    //   4458: ldc_w 1268
    //   4461: astore_3
    //   4462: aload_3
    //   4463: astore_1
    //   4464: aload 30
    //   4466: ifnull -2580 -> 1886
    //   4469: invokestatic 1215	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:isNetworkAvailable	()Z
    //   4472: pop
    //   4473: new 83	java/util/HashMap
    //   4476: dup
    //   4477: invokespecial 84	java/util/HashMap:<init>	()V
    //   4480: pop
    //   4481: aload_3
    //   4482: astore_1
    //   4483: goto -2597 -> 1886
    //   4486: aload_3
    //   4487: instanceof 1217
    //   4490: ifeq +35 -> 4525
    //   4493: ldc_w 1270
    //   4496: astore 28
    //   4498: aload 28
    //   4500: astore_1
    //   4501: aload 30
    //   4503: ifnull -2617 -> 1886
    //   4506: aload_3
    //   4507: invokestatic 1223	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:h	(Ljava/lang/Throwable;)I
    //   4510: pop
    //   4511: new 83	java/util/HashMap
    //   4514: dup
    //   4515: invokespecial 84	java/util/HashMap:<init>	()V
    //   4518: pop
    //   4519: aload 28
    //   4521: astore_1
    //   4522: goto -2636 -> 1886
    //   4525: aload 28
    //   4527: instanceof 1225
    //   4530: ifeq +26 -> 4556
    //   4533: aload_3
    //   4534: instanceof 1227
    //   4537: ifeq +19 -> 4556
    //   4540: ldc_w 1272
    //   4543: astore_3
    //   4544: aload_3
    //   4545: astore_1
    //   4546: aload 30
    //   4548: ifnull -2662 -> 1886
    //   4551: aload_3
    //   4552: astore_1
    //   4553: goto -2667 -> 1886
    //   4556: aload_3
    //   4557: instanceof 1233
    //   4560: ifeq -2674 -> 1886
    //   4563: ldc_w 1274
    //   4566: astore_3
    //   4567: aload_3
    //   4568: astore_1
    //   4569: aload 30
    //   4571: ifnull -2685 -> 1886
    //   4574: new 83	java/util/HashMap
    //   4577: dup
    //   4578: invokespecial 84	java/util/HashMap:<init>	()V
    //   4581: pop
    //   4582: aload_3
    //   4583: astore_1
    //   4584: goto -2698 -> 1886
    //   4587: astore_2
    //   4588: aconst_null
    //   4589: astore 29
    //   4591: aconst_null
    //   4592: astore_3
    //   4593: iload 8
    //   4595: istore 5
    //   4597: goto -1693 -> 2904
    //   4600: astore_2
    //   4601: aconst_null
    //   4602: astore_3
    //   4603: iload 8
    //   4605: istore 5
    //   4607: goto -1703 -> 2904
    //   4610: astore_2
    //   4611: aconst_null
    //   4612: astore 4
    //   4614: aload_3
    //   4615: astore 28
    //   4617: aload 4
    //   4619: astore_3
    //   4620: iload 8
    //   4622: istore 5
    //   4624: goto -1720 -> 2904
    //   4627: astore_2
    //   4628: aconst_null
    //   4629: astore 4
    //   4631: iload 11
    //   4633: istore 5
    //   4635: aload_3
    //   4636: astore 28
    //   4638: aload 4
    //   4640: astore_3
    //   4641: goto -1737 -> 2904
    //   4644: astore_2
    //   4645: iload 6
    //   4647: istore 5
    //   4649: goto -1745 -> 2904
    //   4652: astore_2
    //   4653: aload 28
    //   4655: astore 4
    //   4657: aload_3
    //   4658: astore 28
    //   4660: aload 4
    //   4662: astore_3
    //   4663: iload 6
    //   4665: istore 5
    //   4667: goto -1763 -> 2904
    //   4670: astore 30
    //   4672: aconst_null
    //   4673: astore 29
    //   4675: lconst_0
    //   4676: lstore 13
    //   4678: iconst_1
    //   4679: istore 5
    //   4681: aload 28
    //   4683: astore_3
    //   4684: aload 30
    //   4686: astore 28
    //   4688: goto -2394 -> 2294
    //   4691: astore 30
    //   4693: aconst_null
    //   4694: astore 29
    //   4696: iconst_1
    //   4697: istore 5
    //   4699: aload 28
    //   4701: astore_3
    //   4702: aload 30
    //   4704: astore 28
    //   4706: goto -2412 -> 2294
    //   4709: astore 30
    //   4711: iconst_1
    //   4712: istore 5
    //   4714: aload 28
    //   4716: astore_3
    //   4717: aload 30
    //   4719: astore 28
    //   4721: goto -2427 -> 2294
    //   4724: astore 28
    //   4726: iconst_1
    //   4727: istore 5
    //   4729: goto -2435 -> 2294
    //   4732: astore_3
    //   4733: aconst_null
    //   4734: astore 29
    //   4736: lconst_0
    //   4737: lstore 13
    //   4739: lload 21
    //   4741: lstore 15
    //   4743: iload 7
    //   4745: istore 6
    //   4747: goto -3533 -> 1214
    //   4750: astore_3
    //   4751: aconst_null
    //   4752: astore 29
    //   4754: lload 21
    //   4756: lstore 15
    //   4758: iload 7
    //   4760: istore 6
    //   4762: goto -3548 -> 1214
    //   4765: astore_3
    //   4766: lload 21
    //   4768: lstore 15
    //   4770: iload 7
    //   4772: istore 6
    //   4774: goto -3560 -> 1214
    //   4777: astore 31
    //   4779: aload_3
    //   4780: astore 28
    //   4782: aload 31
    //   4784: astore_3
    //   4785: lload 21
    //   4787: lstore 15
    //   4789: iload 7
    //   4791: istore 6
    //   4793: goto -3579 -> 1214
    //   4796: astore 31
    //   4798: aload_3
    //   4799: astore 28
    //   4801: aload 31
    //   4803: astore_3
    //   4804: iload 7
    //   4806: istore 6
    //   4808: goto -3594 -> 1214
    //   4811: aload 28
    //   4813: astore_1
    //   4814: ldc2_w 412
    //   4817: lstore 15
    //   4819: aload_3
    //   4820: astore 28
    //   4822: aload_1
    //   4823: astore_3
    //   4824: goto -3014 -> 1810
    //   4827: goto -3017 -> 1810
    //   4830: iconst_0
    //   4831: istore 7
    //   4833: goto +42 -> 4875
    //   4836: aconst_null
    //   4837: astore 30
    //   4839: goto -1246 -> 3593
    //   4842: ldc2_w 412
    //   4845: lstore 15
    //   4847: aload 33
    //   4849: astore 31
    //   4851: goto -3219 -> 1632
    //   4854: goto -3489 -> 1365
    //   4857: aconst_null
    //   4858: astore_1
    //   4859: ldc2_w 412
    //   4862: lstore 15
    //   4864: aload_3
    //   4865: astore 28
    //   4867: aload_1
    //   4868: astore_3
    //   4869: goto -3059 -> 1810
    //   4872: goto -3237 -> 1635
    //   4875: iload 7
    //   4877: ifeq -1156 -> 3721
    //   4880: bipush 13
    //   4882: istore 7
    //   4884: goto -1237 -> 3647
    //   4887: bipush 9
    //   4889: istore 7
    //   4891: goto -1244 -> 3647
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4894	0	this	m
    //   0	4894	1	paramSocket	Socket
    //   0	4894	2	paramString	String
    //   0	4894	3	paramOutputStream	java.io.OutputStream
    //   0	4894	4	paramn	n
    //   276	4452	5	i	int
    //   121	4686	6	j	int
    //   127	4763	7	k	int
    //   124	4497	8	m	int
    //   669	1990	9	n	int
    //   665	1990	10	i1	int
    //   673	3959	11	i2	int
    //   750	1500	12	i3	int
    //   167	4571	13	l1	long
    //   149	4714	15	l2	long
    //   163	2766	17	l3	long
    //   228	3987	19	l4	long
    //   132	4654	21	l5	long
    //   273	1581	23	l6	long
    //   156	2784	25	l7	long
    //   519	2351	27	bool	boolean
    //   50	2106	28	localObject1	Object
    //   2284	204	28	localException1	Exception
    //   2496	338	28	localOutputStream1	java.io.OutputStream
    //   2840	989	28	localIOException1	IOException
    //   4496	224	28	localObject2	Object
    //   4724	1	28	localException2	Exception
    //   4780	86	28	localOutputStream2	java.io.OutputStream
    //   71	4682	29	localObject3	Object
    //   144	1730	30	localObject4	Object
    //   2874	12	30	localException3	Exception
    //   3090	627	30	localObject5	Object
    //   4221	349	30	localIOException2	IOException
    //   4670	15	30	localException4	Exception
    //   4691	12	30	localException5	Exception
    //   4709	9	30	localException6	Exception
    //   4837	1	30	localObject6	Object
    //   452	2440	31	localObject7	Object
    //   4777	6	31	localIOException3	IOException
    //   4796	6	31	localIOException4	IOException
    //   4849	1	31	localObject8	Object
    //   139	963	32	arrayOfByte	byte[]
    //   1194	18	32	localIOException5	IOException
    //   1215	2961	32	localObject9	Object
    //   258	4590	33	localObject10	Object
    //   27	4252	34	str1	String
    //   57	1807	35	str2	String
    //   268	2397	36	localBufferedOutputStream	java.io.BufferedOutputStream
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
    //   2147	2154	1194	java/io/IOException
    //   2180	2190	1194	java/io/IOException
    //   2210	2220	1194	java/io/IOException
    //   2247	2254	1194	java/io/IOException
    //   2274	2281	1194	java/io/IOException
    //   2528	2536	1194	java/io/IOException
    //   2556	2565	1194	java/io/IOException
    //   2585	2594	1194	java/io/IOException
    //   2614	2619	1194	java/io/IOException
    //   2639	2644	1194	java/io/IOException
    //   2664	2669	1194	java/io/IOException
    //   675	681	2284	java/lang/Exception
    //   709	718	2284	java/lang/Exception
    //   738	752	2284	java/lang/Exception
    //   778	786	2284	java/lang/Exception
    //   806	823	2284	java/lang/Exception
    //   851	859	2284	java/lang/Exception
    //   888	918	2284	java/lang/Exception
    //   938	943	2284	java/lang/Exception
    //   978	985	2284	java/lang/Exception
    //   1005	1014	2284	java/lang/Exception
    //   1034	1042	2284	java/lang/Exception
    //   1062	1074	2284	java/lang/Exception
    //   1099	1111	2284	java/lang/Exception
    //   1131	1145	2284	java/lang/Exception
    //   1165	1171	2284	java/lang/Exception
    //   1191	1194	2284	java/lang/Exception
    //   2147	2154	2284	java/lang/Exception
    //   2180	2190	2284	java/lang/Exception
    //   2210	2220	2284	java/lang/Exception
    //   2247	2254	2284	java/lang/Exception
    //   2274	2281	2284	java/lang/Exception
    //   2528	2536	2284	java/lang/Exception
    //   2556	2565	2284	java/lang/Exception
    //   2585	2594	2284	java/lang/Exception
    //   2614	2619	2284	java/lang/Exception
    //   2639	2644	2284	java/lang/Exception
    //   2664	2669	2284	java/lang/Exception
    //   2715	2721	2840	java/io/IOException
    //   2721	2725	2854	java/io/IOException
    //   1512	1525	2874	java/lang/Exception
    //   1528	1533	2874	java/lang/Exception
    //   1536	1541	2874	java/lang/Exception
    //   1217	1224	2896	finally
    //   1227	1233	2896	finally
    //   1239	1249	2896	finally
    //   1255	1266	2896	finally
    //   1274	1289	2896	finally
    //   1292	1302	2896	finally
    //   1305	1317	2896	finally
    //   1320	1330	2896	finally
    //   1333	1345	2896	finally
    //   1348	1355	2896	finally
    //   1358	1365	2896	finally
    //   1403	1410	2896	finally
    //   1413	1420	2896	finally
    //   1426	1441	2896	finally
    //   1444	1455	2896	finally
    //   1458	1468	2896	finally
    //   1471	1509	2896	finally
    //   1512	1525	2896	finally
    //   1528	1533	2896	finally
    //   1536	1541	2896	finally
    //   1557	1601	2896	finally
    //   1605	1615	2896	finally
    //   1619	1632	2896	finally
    //   2879	2890	2896	finally
    //   3076	3083	2896	finally
    //   3086	3092	2896	finally
    //   3095	3139	2896	finally
    //   3146	3156	2896	finally
    //   3159	3169	2896	finally
    //   3172	3182	2896	finally
    //   3188	3195	2896	finally
    //   3198	3231	2896	finally
    //   3234	3244	2896	finally
    //   3247	3258	2896	finally
    //   3268	3275	2896	finally
    //   3278	3311	2896	finally
    //   3314	3324	2896	finally
    //   3327	3338	2896	finally
    //   3348	3355	2896	finally
    //   3358	3366	2896	finally
    //   3369	3402	2896	finally
    //   3415	3422	2896	finally
    //   3425	3433	2896	finally
    //   3436	3469	2896	finally
    //   3482	3489	2896	finally
    //   3492	3532	2896	finally
    //   3535	3545	2896	finally
    //   3548	3556	2896	finally
    //   3559	3569	2896	finally
    //   3572	3580	2896	finally
    //   3583	3593	2896	finally
    //   3601	3608	2896	finally
    //   3616	3624	2896	finally
    //   3627	3641	2896	finally
    //   3650	3661	2896	finally
    //   3671	3688	2896	finally
    //   3697	3705	2896	finally
    //   3708	3718	2896	finally
    //   3724	3730	2896	finally
    //   3739	3746	2896	finally
    //   3749	3789	2896	finally
    //   3792	3802	2896	finally
    //   3805	3818	2896	finally
    //   3828	3836	2896	finally
    //   3839	3846	2896	finally
    //   3849	3889	2896	finally
    //   3892	3902	2896	finally
    //   3905	3916	2896	finally
    //   3926	3933	2896	finally
    //   3936	3976	2896	finally
    //   3979	3989	2896	finally
    //   3992	4001	2896	finally
    //   4011	4018	2896	finally
    //   4021	4029	2896	finally
    //   4032	4065	2896	finally
    //   4078	4085	2896	finally
    //   4088	4097	2896	finally
    //   4107	4120	2896	finally
    //   4123	4132	2896	finally
    //   4142	4155	2896	finally
    //   4158	4167	2896	finally
    //   4177	4214	2896	finally
    //   1695	1702	4221	java/io/IOException
    //   1706	1710	4235	java/io/IOException
    //   2381	2387	4249	java/io/IOException
    //   2950	2957	4262	java/io/IOException
    //   2961	2965	4276	java/io/IOException
    //   283	316	4587	finally
    //   414	420	4587	finally
    //   420	426	4587	finally
    //   426	438	4600	finally
    //   1978	2013	4600	finally
    //   2018	2035	4600	finally
    //   2041	2057	4600	finally
    //   2063	2080	4600	finally
    //   2086	2103	4600	finally
    //   438	446	4610	finally
    //   446	454	4610	finally
    //   458	467	4610	finally
    //   471	482	4610	finally
    //   486	496	4610	finally
    //   500	507	4610	finally
    //   511	518	4610	finally
    //   525	540	4610	finally
    //   544	572	4610	finally
    //   576	614	4610	finally
    //   618	631	4610	finally
    //   635	640	4610	finally
    //   644	649	4610	finally
    //   675	681	4627	finally
    //   709	718	4627	finally
    //   738	752	4627	finally
    //   778	786	4627	finally
    //   806	823	4627	finally
    //   851	859	4627	finally
    //   888	918	4627	finally
    //   938	943	4627	finally
    //   978	985	4627	finally
    //   1005	1014	4627	finally
    //   1034	1042	4627	finally
    //   1062	1074	4627	finally
    //   1099	1111	4627	finally
    //   1131	1145	4627	finally
    //   1165	1171	4627	finally
    //   1191	1194	4627	finally
    //   2147	2154	4627	finally
    //   2180	2190	4627	finally
    //   2210	2220	4627	finally
    //   2247	2254	4627	finally
    //   2274	2281	4627	finally
    //   2528	2536	4627	finally
    //   2556	2565	4627	finally
    //   2585	2594	4627	finally
    //   2614	2619	4627	finally
    //   2639	2644	4627	finally
    //   2664	2669	4627	finally
    //   1635	1649	4644	finally
    //   2294	2335	4652	finally
    //   283	316	4670	java/lang/Exception
    //   414	420	4670	java/lang/Exception
    //   420	426	4691	java/lang/Exception
    //   426	438	4709	java/lang/Exception
    //   1978	2013	4709	java/lang/Exception
    //   2018	2035	4709	java/lang/Exception
    //   2041	2057	4709	java/lang/Exception
    //   2063	2080	4709	java/lang/Exception
    //   2086	2103	4709	java/lang/Exception
    //   438	446	4724	java/lang/Exception
    //   446	454	4724	java/lang/Exception
    //   458	467	4724	java/lang/Exception
    //   471	482	4724	java/lang/Exception
    //   486	496	4724	java/lang/Exception
    //   500	507	4724	java/lang/Exception
    //   511	518	4724	java/lang/Exception
    //   525	540	4724	java/lang/Exception
    //   544	572	4724	java/lang/Exception
    //   576	614	4724	java/lang/Exception
    //   618	631	4724	java/lang/Exception
    //   635	640	4724	java/lang/Exception
    //   644	649	4724	java/lang/Exception
    //   283	316	4732	java/io/IOException
    //   414	420	4732	java/io/IOException
    //   420	426	4750	java/io/IOException
    //   426	438	4765	java/io/IOException
    //   1978	2013	4765	java/io/IOException
    //   2018	2035	4765	java/io/IOException
    //   2041	2057	4765	java/io/IOException
    //   2063	2080	4765	java/io/IOException
    //   2086	2103	4765	java/io/IOException
    //   438	446	4777	java/io/IOException
    //   446	454	4796	java/io/IOException
    //   458	467	4796	java/io/IOException
    //   471	482	4796	java/io/IOException
    //   486	496	4796	java/io/IOException
    //   500	507	4796	java/io/IOException
    //   511	518	4796	java/io/IOException
    //   525	540	4796	java/io/IOException
    //   544	572	4796	java/io/IOException
    //   576	614	4796	java/io/IOException
    //   618	631	4796	java/io/IOException
    //   635	640	4796	java/io/IOException
    //   644	649	4796	java/io/IOException
  }
  
  private static int h(Throwable paramThrowable)
  {
    AppMethodBeat.i(228316);
    int i;
    if (paramThrowable.toString().toLowerCase().contains("unexpected end of stream")) {
      i = 6;
    }
    for (;;)
    {
      AppMethodBeat.o(228316);
      return i;
      if ((paramThrowable.getCause() != null) && ((paramThrowable.getCause() instanceof SocketTimeoutException))) {
        i = 14;
      } else {
        i = 7;
      }
    }
  }
  
  public final String a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(228226);
    if ((!com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvz) || (this.pxn > 3) || (this.executorService.isShutdown()) || (this.executorService.isTerminated()))
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "getUrl, proxy disabled or server shutdown");
      com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvu.bVq();
      paramString1 = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajj(paramString1);
      AppMethodBeat.o(228226);
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
        str = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajj(paramString1);
        if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajk(str)) {
          break label165;
        }
        bool = false;
      }
    }
    for (;;)
    {
      localObject1 = paramString2;
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.aiP(str)) {
        break label199;
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvC) {
        break label191;
      }
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "getUrl, hls proxy disabled");
      AppMethodBeat.o(228226);
      return str;
      label165:
      if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajl(str)) {
        break;
      }
      bool = false;
      str = paramString1;
    }
    AppMethodBeat.o(228226);
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
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "invalid url " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(paramString2));
      }
      paramString2 = Uri.parse(str).getLastPathSegment();
      paramString1 = bVE() + "/" + paramString2 + "?url=" + paramString1;
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
      AppMethodBeat.o(228226);
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
        paramString2 = paramString1 + "&secret=" + l.G("des", l.bVQ(), com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajf(str));
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(4, "VideoProxy", "getUrl, url:" + str + ", proxyUrl:" + paramString2);
        AppMethodBeat.o(228226);
        return paramString2;
        paramString2 = paramString2;
        com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "unable to encode contentType ".concat(String.valueOf(localObject1)));
        localObject1 = null;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "encode failed:" + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(paramString2));
          this.pxo = false;
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
      localObject1 = System.currentTimeMillis() + pxp.getAndIncrement();
    }
    paramString1 = paramString2;
    if (localObject1 != null) {
      paramString1 = paramString2 + "&id=" + (String)localObject1;
    }
    paramString2 = paramString1;
    if (!this.pxo) {}
  }
  
  public final long aiU(String paramString)
  {
    AppMethodBeat.i(228318);
    if ((TextUtils.isEmpty(paramString)) || (this.pvM == null))
    {
      AppMethodBeat.o(228318);
      return 0L;
    }
    paramString = com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.ajf(paramString);
    long l = this.pvM.aiU(paramString);
    AppMethodBeat.o(228318);
    return l;
  }
  
  public final String bVE()
  {
    AppMethodBeat.i(228222);
    String str = "http://127.0.0.1:" + this.ofp;
    AppMethodBeat.o(228222);
    return str;
  }
  
  final class a
  {
    boolean gY = false;
    long pxC = -1L;
    com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e pxD = null;
    q pxE = null;
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    Socket aFp;
    n pwy;
    Future<?> pxF;
    CountDownLatch pxG;
    
    public b(Socket paramSocket, CountDownLatch paramCountDownLatch)
    {
      this.aFp = paramSocket;
      this.pxG = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(229373);
      try
      {
        this.pxG.await();
        this.pwy = new n();
        this.pwy.pxF = this.pxF;
        m.a(m.this, this.aFp, this.pwy);
        AppMethodBeat.o(229373);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.log(6, "VideoProxy", "SocketHandler run exception, reason " + com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.i(localInterruptedException));
        }
      }
    }
  }
  
  final class c
    implements Runnable
  {
    private CountDownLatch aFr;
    
    public c(CountDownLatch paramCountDownLatch)
    {
      this.aFr = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(228064);
      this.aFr.countDown();
      m.a(m.this);
      AppMethodBeat.o(228064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.m
 * JD-Core Version:    0.7.0.1
 */