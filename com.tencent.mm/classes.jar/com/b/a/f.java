package com.b.a;

import android.net.Uri;
import com.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private final Object aFj;
  final ExecutorService aFk;
  private final Map<String, g> aFl;
  final ServerSocket aFm;
  private final Thread aFn;
  private final c aFo;
  private final int port;
  
  private f(c paramc)
  {
    AppMethodBeat.i(183572);
    this.aFj = new Object();
    this.aFk = Executors.newFixedThreadPool(8);
    this.aFl = new ConcurrentHashMap();
    this.aFo = ((c)l.checkNotNull(paramc));
    try
    {
      this.aFm = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
      this.port = this.aFm.getLocalPort();
      i.l("127.0.0.1", this.port);
      paramc = new CountDownLatch(1);
      this.aFn = new Thread(new c(paramc));
      this.aFn.start();
      paramc.await();
      AppMethodBeat.o(183572);
      return;
    }
    catch (InterruptedException paramc)
    {
      this.aFk.shutdown();
      paramc = new IllegalStateException("Error starting local proxy server", paramc);
      AppMethodBeat.o(183572);
      throw paramc;
    }
    catch (IOException paramc)
    {
      label137:
      break label137;
    }
  }
  
  /* Error */
  static void a(Socket paramSocket)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 145	java/net/Socket:isInputShutdown	()Z
    //   9: ifne +7 -> 16
    //   12: aload_0
    //   13: invokevirtual 148	java/net/Socket:shutdownInput	()V
    //   16: aload_0
    //   17: invokevirtual 151	java/net/Socket:isOutputShutdown	()Z
    //   20: ifne +7 -> 27
    //   23: aload_0
    //   24: invokevirtual 154	java/net/Socket:shutdownOutput	()V
    //   27: aload_0
    //   28: invokevirtual 157	java/net/Socket:isClosed	()Z
    //   31: ifne +7 -> 38
    //   34: aload_0
    //   35: invokevirtual 160	java/net/Socket:close	()V
    //   38: ldc 139
    //   40: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: astore_1
    //   45: invokestatic 165	com/b/a/k:pn	()V
    //   48: goto -32 -> 16
    //   51: astore_1
    //   52: new 167	com/b/a/n
    //   55: dup
    //   56: ldc 169
    //   58: aload_1
    //   59: invokespecial 170	com/b/a/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: pop
    //   63: invokestatic 173	com/b/a/k:pq	()V
    //   66: goto -50 -> 16
    //   69: astore_1
    //   70: invokestatic 176	com/b/a/k:pp	()V
    //   73: goto -46 -> 27
    //   76: astore_0
    //   77: new 167	com/b/a/n
    //   80: dup
    //   81: ldc 178
    //   83: aload_0
    //   84: invokespecial 170	com/b/a/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: pop
    //   88: invokestatic 173	com/b/a/k:pq	()V
    //   91: ldc 139
    //   93: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramSocket	Socket
    //   44	1	1	localSocketException	java.net.SocketException
    //   51	8	1	localIOException1	IOException
    //   69	1	1	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   5	16	44	java/net/SocketException
    //   5	16	51	java/io/IOException
    //   16	27	69	java/io/IOException
    //   27	38	76	java/io/IOException
  }
  
  private File aR(String paramString)
  {
    AppMethodBeat.i(183573);
    paramString = new File(this.aFo.aEY, this.aFo.aEZ.aW(paramString));
    AppMethodBeat.o(183573);
    return paramString;
  }
  
  public final String aQ(String paramString)
  {
    AppMethodBeat.i(186246);
    if (aR(paramString).exists())
    {
      paramString = aR(paramString);
      try
      {
        this.aFo.aFa.q(paramString);
        paramString = Uri.fromFile(paramString).toString();
        AppMethodBeat.o(186246);
        return paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          "Error touching file ".concat(String.valueOf(paramString));
          k.pq();
        }
      }
    }
    paramString = String.format(Locale.US, "http://%s:%d/%s", new Object[] { "127.0.0.1", Integer.valueOf(this.port), o.aT(paramString) });
    AppMethodBeat.o(186246);
    return paramString;
  }
  
  final g aS(String paramString)
  {
    AppMethodBeat.i(183574);
    synchronized (this.aFj)
    {
      g localg2 = (g)this.aFl.get(paramString);
      g localg1 = localg2;
      if (localg2 == null)
      {
        localg1 = new g(paramString, this.aFo);
        this.aFl.put(paramString, localg1);
      }
      AppMethodBeat.o(183574);
      return localg1;
    }
  }
  
  final int pi()
  {
    AppMethodBeat.i(183575);
    synchronized (this.aFj)
    {
      Iterator localIterator = this.aFl.values().iterator();
      for (int i = 0; localIterator.hasNext(); i = ((g)localIterator.next()).aFs.get() + i) {}
      AppMethodBeat.o(183575);
      return i;
    }
  }
  
  final class b
    implements Runnable
  {
    private final Socket aFp;
    
    public b(Socket paramSocket)
    {
      this.aFp = paramSocket;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 31
      //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 17	com/b/a/f$b:aFq	Lcom/b/a/f;
      //   9: astore 11
      //   11: aload_0
      //   12: getfield 22	com/b/a/f$b:aFp	Ljava/net/Socket;
      //   15: astore 12
      //   17: aload 12
      //   19: invokevirtual 43	java/net/Socket:getInputStream	()Ljava/io/InputStream;
      //   22: invokestatic 49	com/b/a/d:e	(Ljava/io/InputStream;)Lcom/b/a/d;
      //   25: astore 14
      //   27: ldc 51
      //   29: aload 14
      //   31: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   34: invokevirtual 61	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   37: pop
      //   38: invokestatic 66	com/b/a/k:pn	()V
      //   41: aload 11
      //   43: aload 14
      //   45: getfield 70	com/b/a/d:uri	Ljava/lang/String;
      //   48: invokestatic 75	com/b/a/o:aU	(Ljava/lang/String;)Ljava/lang/String;
      //   51: invokevirtual 79	com/b/a/f:aS	(Ljava/lang/String;)Lcom/b/a/g;
      //   54: astore 13
      //   56: aload 13
      //   58: invokevirtual 84	com/b/a/g:pj	()V
      //   61: aload 13
      //   63: getfield 88	com/b/a/g:aFs	Ljava/util/concurrent/atomic/AtomicInteger;
      //   66: invokevirtual 94	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
      //   69: pop
      //   70: aload 13
      //   72: getfield 98	com/b/a/g:aFt	Lcom/b/a/e;
      //   75: astore 15
      //   77: new 100	java/io/BufferedOutputStream
      //   80: dup
      //   81: aload 12
      //   83: invokevirtual 104	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
      //   86: invokespecial 107	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   89: astore 16
      //   91: aload 15
      //   93: getfield 113	com/b/a/e:aFg	Lcom/b/a/h;
      //   96: invokevirtual 119	com/b/a/h:pm	()Ljava/lang/String;
      //   99: astore 17
      //   101: aload 17
      //   103: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   106: ifne +347 -> 453
      //   109: iconst_1
      //   110: istore_1
      //   111: aload 15
      //   113: getfield 129	com/b/a/e:aFh	Lcom/b/a/a/b;
      //   116: invokevirtual 135	com/b/a/a/b:isCompleted	()Z
      //   119: ifeq +339 -> 458
      //   122: aload 15
      //   124: getfield 129	com/b/a/e:aFh	Lcom/b/a/a/b;
      //   127: invokevirtual 139	com/b/a/a/b:available	()J
      //   130: lstore 4
      //   132: goto +493 -> 625
      //   135: aload 14
      //   137: getfield 143	com/b/a/d:aFf	Z
      //   140: ifeq +507 -> 647
      //   143: lload 4
      //   145: aload 14
      //   147: getfield 147	com/b/a/d:aFe	J
      //   150: lsub
      //   151: lstore 6
      //   153: iload_2
      //   154: ifeq +500 -> 654
      //   157: aload 14
      //   159: getfield 143	com/b/a/d:aFf	Z
      //   162: ifeq +492 -> 654
      //   165: iconst_1
      //   166: istore_3
      //   167: new 149	java/lang/StringBuilder
      //   170: dup
      //   171: invokespecial 150	java/lang/StringBuilder:<init>	()V
      //   174: astore 18
      //   176: aload 14
      //   178: getfield 143	com/b/a/d:aFf	Z
      //   181: ifeq +478 -> 659
      //   184: ldc 152
      //   186: astore 10
      //   188: aload 18
      //   190: aload 10
      //   192: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   195: ldc 158
      //   197: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: astore 18
      //   202: iload_2
      //   203: ifeq +463 -> 666
      //   206: ldc 160
      //   208: iconst_1
      //   209: anewarray 4	java/lang/Object
      //   212: dup
      //   213: iconst_0
      //   214: lload 6
      //   216: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   219: aastore
      //   220: invokestatic 169	com/b/a/e:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   223: astore 10
      //   225: aload 18
      //   227: aload 10
      //   229: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: astore 18
      //   234: iload_3
      //   235: ifeq +438 -> 673
      //   238: ldc 171
      //   240: iconst_3
      //   241: anewarray 4	java/lang/Object
      //   244: dup
      //   245: iconst_0
      //   246: aload 14
      //   248: getfield 147	com/b/a/d:aFe	J
      //   251: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   254: aastore
      //   255: dup
      //   256: iconst_1
      //   257: lload 4
      //   259: lconst_1
      //   260: lsub
      //   261: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   264: aastore
      //   265: dup
      //   266: iconst_2
      //   267: lload 4
      //   269: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   272: aastore
      //   273: invokestatic 169	com/b/a/e:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   276: astore 10
      //   278: aload 18
      //   280: aload 10
      //   282: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   285: astore 18
      //   287: iload_1
      //   288: ifeq +392 -> 680
      //   291: ldc 173
      //   293: iconst_1
      //   294: anewarray 4	java/lang/Object
      //   297: dup
      //   298: iconst_0
      //   299: aload 17
      //   301: aastore
      //   302: invokestatic 169	com/b/a/e:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   305: astore 10
      //   307: aload 16
      //   309: aload 18
      //   311: aload 10
      //   313: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: ldc 175
      //   318: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   321: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   324: ldc 180
      //   326: invokevirtual 184	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   329: invokevirtual 190	java/io/OutputStream:write	([B)V
      //   332: aload 14
      //   334: getfield 147	com/b/a/d:aFe	J
      //   337: lstore 4
      //   339: aload 15
      //   341: getfield 113	com/b/a/e:aFg	Lcom/b/a/h;
      //   344: invokevirtual 193	com/b/a/h:length	()J
      //   347: lstore 6
      //   349: lload 6
      //   351: lconst_0
      //   352: lcmp
      //   353: ifle +334 -> 687
      //   356: iconst_1
      //   357: istore_1
      //   358: aload 15
      //   360: getfield 129	com/b/a/e:aFh	Lcom/b/a/a/b;
      //   363: invokevirtual 139	com/b/a/a/b:available	()J
      //   366: lstore 8
      //   368: iload_1
      //   369: ifeq +268 -> 637
      //   372: aload 14
      //   374: getfield 143	com/b/a/d:aFf	Z
      //   377: ifeq +260 -> 637
      //   380: aload 14
      //   382: getfield 147	com/b/a/d:aFe	J
      //   385: l2f
      //   386: lload 8
      //   388: l2f
      //   389: lload 6
      //   391: l2f
      //   392: ldc 194
      //   394: fmul
      //   395: fadd
      //   396: fcmpg
      //   397: ifgt +295 -> 692
      //   400: goto +237 -> 637
      //   403: iload_1
      //   404: ifeq +67 -> 471
      //   407: aload 15
      //   409: aload 16
      //   411: lload 4
      //   413: invokevirtual 198	com/b/a/e:a	(Ljava/io/OutputStream;J)V
      //   416: aload 13
      //   418: invokevirtual 201	com/b/a/g:pk	()V
      //   421: aload 12
      //   423: invokestatic 204	com/b/a/f:a	(Ljava/net/Socket;)V
      //   426: new 149	java/lang/StringBuilder
      //   429: dup
      //   430: ldc 206
      //   432: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   435: aload 11
      //   437: invokevirtual 212	com/b/a/f:pi	()I
      //   440: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   443: pop
      //   444: invokestatic 66	com/b/a/k:pn	()V
      //   447: ldc 31
      //   449: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   452: return
      //   453: iconst_0
      //   454: istore_1
      //   455: goto -344 -> 111
      //   458: aload 15
      //   460: getfield 113	com/b/a/e:aFg	Lcom/b/a/h;
      //   463: invokevirtual 193	com/b/a/h:length	()J
      //   466: lstore 4
      //   468: goto +157 -> 625
      //   471: aload 15
      //   473: aload 16
      //   475: lload 4
      //   477: invokevirtual 220	com/b/a/e:b	(Ljava/io/OutputStream;J)V
      //   480: goto -64 -> 416
      //   483: astore 10
      //   485: aload 13
      //   487: invokevirtual 201	com/b/a/g:pk	()V
      //   490: ldc 31
      //   492: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   495: aload 10
      //   497: athrow
      //   498: astore 10
      //   500: invokestatic 66	com/b/a/k:pn	()V
      //   503: aload 12
      //   505: invokestatic 204	com/b/a/f:a	(Ljava/net/Socket;)V
      //   508: new 149	java/lang/StringBuilder
      //   511: dup
      //   512: ldc 206
      //   514: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   517: aload 11
      //   519: invokevirtual 212	com/b/a/f:pi	()I
      //   522: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   525: pop
      //   526: invokestatic 66	com/b/a/k:pn	()V
      //   529: ldc 31
      //   531: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   534: return
      //   535: astore 10
      //   537: new 28	com/b/a/n
      //   540: dup
      //   541: ldc 222
      //   543: aload 10
      //   545: invokespecial 225	com/b/a/n:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   548: pop
      //   549: invokestatic 228	com/b/a/k:pq	()V
      //   552: aload 12
      //   554: invokestatic 204	com/b/a/f:a	(Ljava/net/Socket;)V
      //   557: new 149	java/lang/StringBuilder
      //   560: dup
      //   561: ldc 206
      //   563: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   566: aload 11
      //   568: invokevirtual 212	com/b/a/f:pi	()I
      //   571: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   574: pop
      //   575: invokestatic 66	com/b/a/k:pn	()V
      //   578: ldc 31
      //   580: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   583: return
      //   584: astore 10
      //   586: aload 12
      //   588: invokestatic 204	com/b/a/f:a	(Ljava/net/Socket;)V
      //   591: new 149	java/lang/StringBuilder
      //   594: dup
      //   595: ldc 206
      //   597: invokespecial 209	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   600: aload 11
      //   602: invokevirtual 212	com/b/a/f:pi	()I
      //   605: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   608: pop
      //   609: invokestatic 66	com/b/a/k:pn	()V
      //   612: ldc 31
      //   614: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   617: aload 10
      //   619: athrow
      //   620: astore 10
      //   622: goto -85 -> 537
      //   625: lload 4
      //   627: lconst_0
      //   628: lcmp
      //   629: iflt +13 -> 642
      //   632: iconst_1
      //   633: istore_2
      //   634: goto -499 -> 135
      //   637: iconst_1
      //   638: istore_1
      //   639: goto -236 -> 403
      //   642: iconst_0
      //   643: istore_2
      //   644: goto -509 -> 135
      //   647: lload 4
      //   649: lstore 6
      //   651: goto -498 -> 153
      //   654: iconst_0
      //   655: istore_3
      //   656: goto -489 -> 167
      //   659: ldc 230
      //   661: astore 10
      //   663: goto -475 -> 188
      //   666: ldc 232
      //   668: astore 10
      //   670: goto -445 -> 225
      //   673: ldc 232
      //   675: astore 10
      //   677: goto -399 -> 278
      //   680: ldc 232
      //   682: astore 10
      //   684: goto -377 -> 307
      //   687: iconst_0
      //   688: istore_1
      //   689: goto -331 -> 358
      //   692: iconst_0
      //   693: istore_1
      //   694: goto -291 -> 403
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	697	0	this	b
      //   110	584	1	i	int
      //   153	491	2	j	int
      //   166	490	3	k	int
      //   130	518	4	l1	long
      //   151	499	6	l2	long
      //   366	21	8	l3	long
      //   186	126	10	str1	String
      //   483	13	10	localObject1	Object
      //   498	1	10	localSocketException	java.net.SocketException
      //   535	9	10	localn	n
      //   584	34	10	localObject2	Object
      //   620	1	10	localIOException	IOException
      //   661	22	10	str2	String
      //   9	592	11	localf	f
      //   15	572	12	localSocket	Socket
      //   54	432	13	localg	g
      //   25	356	14	locald	d
      //   75	397	15	locale	e
      //   89	385	16	localBufferedOutputStream	java.io.BufferedOutputStream
      //   99	201	17	str3	String
      //   174	136	18	localStringBuilder	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   61	109	483	finally
      //   111	132	483	finally
      //   135	153	483	finally
      //   157	165	483	finally
      //   167	184	483	finally
      //   188	202	483	finally
      //   206	225	483	finally
      //   225	234	483	finally
      //   238	278	483	finally
      //   278	287	483	finally
      //   291	307	483	finally
      //   307	349	483	finally
      //   358	368	483	finally
      //   372	400	483	finally
      //   407	416	483	finally
      //   458	468	483	finally
      //   471	480	483	finally
      //   17	61	498	java/net/SocketException
      //   416	421	498	java/net/SocketException
      //   485	498	498	java/net/SocketException
      //   17	61	535	com/b/a/n
      //   416	421	535	com/b/a/n
      //   485	498	535	com/b/a/n
      //   17	61	584	finally
      //   416	421	584	finally
      //   485	498	584	finally
      //   500	503	584	finally
      //   537	552	584	finally
      //   17	61	620	java/io/IOException
      //   416	421	620	java/io/IOException
      //   485	498	620	java/io/IOException
    }
  }
  
  final class c
    implements Runnable
  {
    private final CountDownLatch aFr;
    
    public c(CountDownLatch paramCountDownLatch)
    {
      this.aFr = paramCountDownLatch;
    }
    
    public final void run()
    {
      AppMethodBeat.i(183571);
      this.aFr.countDown();
      f localf = f.this;
      try
      {
        while (!Thread.currentThread().isInterrupted())
        {
          Socket localSocket = localf.aFm.accept();
          "Accept new socket ".concat(String.valueOf(localSocket));
          k.pn();
          localf.aFk.submit(new f.b(localf, localSocket));
        }
        AppMethodBeat.o(183571);
      }
      catch (IOException localIOException)
      {
        new n("Error during waiting connection", localIOException);
        k.pq();
        AppMethodBeat.o(183571);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.f
 * JD-Core Version:    0.7.0.1
 */