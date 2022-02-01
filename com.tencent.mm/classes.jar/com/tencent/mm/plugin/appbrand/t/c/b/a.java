package com.tencent.mm.plugin.appbrand.t.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "()V", "params2JobMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;", "Lkotlin/collections/HashMap;", "fetchCaIssuers", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "url", "", "timeoutMills", "", "maxRespBytes", "markJobDone", "", "reqParams", "Companion", "NetJob", "RequestImpl", "RequestParams", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public static final a tpu;
  private static final boolean tpw;
  private final HashMap<d, b> tpv;
  
  static
  {
    AppMethodBeat.i(319248);
    tpu = new a((byte)0);
    tpw = com.tencent.mm.plugin.appbrand.t.c.c.a.cCQ();
    AppMethodBeat.o(319248);
  }
  
  public a()
  {
    AppMethodBeat.i(319235);
    this.tpv = new HashMap();
    AppMethodBeat.o(319235);
  }
  
  private final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(319240);
      if (tpw) {
        Log.d("MicroMsg.Verify.DefaultCertNetFetcher", s.X("markJobDone, reqParams: ", paramd));
      }
      this.tpv.remove(paramd);
      AppMethodBeat.o(319240);
      return;
    }
    finally {}
  }
  
  public final c.b aej(String paramString)
  {
    AppMethodBeat.i(319251);
    s.u(paramString, "url");
    Log.i("MicroMsg.Verify.DefaultCertNetFetcher", "fetchCaIssuers, url: " + paramString + ", timeoutMills: 15000, maxRespBytes: 65536");
    for (;;)
    {
      try
      {
        Object localObject = new d(paramString, 15000, 65536);
        Map localMap = (Map)this.tpv;
        paramString = localMap.get(localObject);
        if (paramString == null)
        {
          paramString = new b(this, (d)localObject);
          localMap.put(localObject, paramString);
          localObject = ah.aiuX;
          paramString = (c.b)((b)paramString).cCN();
          AppMethodBeat.o(319251);
          return paramString;
        }
      }
      finally
      {
        AppMethodBeat.o(319251);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$Companion;", "", "()V", "DEBUG_FETCHER", "", "TAG", "", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;", "", "fetcher", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher;", "reqParams", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher;Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;)V", "executeThread", "Ljava/lang/Thread;", "isExecuteStarted", "", "requests", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestImpl;", "Lkotlin/collections/HashSet;", "result", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "resultCondition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "resultLock", "Ljava/util/concurrent/locks/ReentrantLock;", "doExecute", "", "urlStr", "", "timeoutMills", "", "maxRespBytes", "execute", "getResultLocked", "", "waitForResult", "Companion", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final a tpx;
    private final HashSet<a.c> tpA;
    private boolean tpB;
    private final ReentrantLock tpC;
    private final Condition tpD;
    private a.b.a.a tpE;
    private Thread tpF;
    private final a tpy;
    private final a.d tpz;
    
    static
    {
      AppMethodBeat.i(319237);
      tpx = new a((byte)0);
      AppMethodBeat.o(319237);
    }
    
    public b(a parama, a.d paramd)
    {
      AppMethodBeat.i(319216);
      this.tpy = parama;
      this.tpz = paramd;
      this.tpA = new HashSet();
      this.tpC = new ReentrantLock();
      this.tpD = this.tpC.newCondition();
      AppMethodBeat.o(319216);
    }
    
    /* Error */
    private final void Y(String paramString, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: ldc 127
      //   2: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 133	android/os/SystemClock:elapsedRealtime	()J
      //   8: lstore 5
      //   10: invokestatic 137	com/tencent/mm/plugin/appbrand/t/c/b/a:cCM	()Z
      //   13: ifeq +33 -> 46
      //   16: ldc 139
      //   18: new 141	java/lang/StringBuilder
      //   21: dup
      //   22: ldc 143
      //   24: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   27: aload_1
      //   28: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   31: ldc 152
      //   33: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: iload_2
      //   37: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   40: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   43: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   46: new 170	java/net/URL
      //   49: dup
      //   50: aload_1
      //   51: invokespecial 171	java/net/URL:<init>	(Ljava/lang/String;)V
      //   54: astore_1
      //   55: aload_1
      //   56: invokestatic 175	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a:c	(Ljava/net/URL;)Z
      //   59: ifne +112 -> 171
      //   62: new 177	com/tencent/mm/plugin/appbrand/t/c/b/b
      //   65: dup
      //   66: new 141	java/lang/StringBuilder
      //   69: dup
      //   70: ldc 179
      //   72: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   75: aload_1
      //   76: invokevirtual 182	java/net/URL:getProtocol	()Ljava/lang/String;
      //   79: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   82: ldc 184
      //   84: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   90: invokespecial 185	com/tencent/mm/plugin/appbrand/t/c/b/b:<init>	(Ljava/lang/String;)V
      //   93: astore_1
      //   94: ldc 127
      //   96: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   99: aload_1
      //   100: athrow
      //   101: astore_1
      //   102: aload_0
      //   103: getfield 116	com/tencent/mm/plugin/appbrand/t/c/b/a$b:tpC	Ljava/util/concurrent/locks/ReentrantLock;
      //   106: checkcast 187	java/util/concurrent/locks/Lock
      //   109: astore 7
      //   111: aload 7
      //   113: invokeinterface 190 1 0
      //   118: aload_1
      //   119: instanceof 177
      //   122: ifeq +411 -> 533
      //   125: aload_1
      //   126: checkcast 177	com/tencent/mm/plugin/appbrand/t/c/b/b
      //   129: astore_1
      //   130: aload_0
      //   131: new 14	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a$a
      //   134: dup
      //   135: aload_1
      //   136: invokespecial 193	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/t/c/b/b;)V
      //   139: checkcast 12	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a
      //   142: putfield 195	com/tencent/mm/plugin/appbrand/t/c/b/a$b:tpE	Lcom/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a;
      //   145: aload_0
      //   146: getfield 122	com/tencent/mm/plugin/appbrand/t/c/b/a$b:tpD	Ljava/util/concurrent/locks/Condition;
      //   149: invokeinterface 200 1 0
      //   154: getstatic 206	kotlin/ah:aiuX	Lkotlin/ah;
      //   157: astore_1
      //   158: aload 7
      //   160: invokeinterface 209 1 0
      //   165: ldc 127
      //   167: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   170: return
      //   171: aload_1
      //   172: invokevirtual 213	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   175: astore_1
      //   176: aload_1
      //   177: ifnonnull +20 -> 197
      //   180: new 215	java/lang/NullPointerException
      //   183: dup
      //   184: ldc 217
      //   186: invokespecial 218	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
      //   189: astore_1
      //   190: ldc 127
      //   192: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   195: aload_1
      //   196: athrow
      //   197: aload_1
      //   198: checkcast 220	java/net/HttpURLConnection
      //   201: astore 7
      //   203: aload 7
      //   205: iconst_0
      //   206: invokevirtual 224	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   209: aload 7
      //   211: iload_2
      //   212: invokevirtual 227	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   215: aload 7
      //   217: iload_2
      //   218: invokevirtual 230	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   221: aload 7
      //   223: invokevirtual 234	java/net/HttpURLConnection:getResponseCode	()I
      //   226: istore 4
      //   228: sipush 300
      //   231: iload 4
      //   233: if_icmpeq +43 -> 276
      //   236: sipush 301
      //   239: iload 4
      //   241: if_icmpeq +35 -> 276
      //   244: sipush 302
      //   247: iload 4
      //   249: if_icmpeq +27 -> 276
      //   252: sipush 303
      //   255: iload 4
      //   257: if_icmpeq +19 -> 276
      //   260: sipush 307
      //   263: iload 4
      //   265: if_icmpeq +11 -> 276
      //   268: sipush 308
      //   271: iload 4
      //   273: if_icmpne +56 -> 329
      //   276: aload 7
      //   278: ldc 236
      //   280: invokevirtual 240	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   283: astore_1
      //   284: iload_2
      //   285: invokestatic 133	android/os/SystemClock:elapsedRealtime	()J
      //   288: lload 5
      //   290: lsub
      //   291: l2i
      //   292: isub
      //   293: istore_2
      //   294: iload_2
      //   295: ifle +17 -> 312
      //   298: ldc 139
      //   300: ldc 242
      //   302: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   305: aload_0
      //   306: aload_1
      //   307: iload_2
      //   308: iload_3
      //   309: invokespecial 244	com/tencent/mm/plugin/appbrand/t/c/b/a$b:Y	(Ljava/lang/String;II)V
      //   312: new 177	com/tencent/mm/plugin/appbrand/t/c/b/b
      //   315: dup
      //   316: ldc 246
      //   318: invokespecial 185	com/tencent/mm/plugin/appbrand/t/c/b/b:<init>	(Ljava/lang/String;)V
      //   321: astore_1
      //   322: ldc 127
      //   324: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   327: aload_1
      //   328: athrow
      //   329: sipush 200
      //   332: iload 4
      //   334: if_icmpeq +40 -> 374
      //   337: new 177	com/tencent/mm/plugin/appbrand/t/c/b/b
      //   340: dup
      //   341: new 141	java/lang/StringBuilder
      //   344: dup
      //   345: ldc 248
      //   347: invokespecial 146	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   350: iload 4
      //   352: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   355: ldc 250
      //   357: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   363: invokespecial 185	com/tencent/mm/plugin/appbrand/t/c/b/b:<init>	(Ljava/lang/String;)V
      //   366: astore_1
      //   367: ldc 127
      //   369: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   372: aload_1
      //   373: athrow
      //   374: aload 7
      //   376: ldc 252
      //   378: invokevirtual 240	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   381: astore_1
      //   382: aload_1
      //   383: ifnonnull +70 -> 453
      //   386: aconst_null
      //   387: astore_1
      //   388: invokestatic 137	com/tencent/mm/plugin/appbrand/t/c/b/a:cCM	()Z
      //   391: ifeq +14 -> 405
      //   394: ldc 139
      //   396: ldc 254
      //   398: aload_1
      //   399: invokestatic 258	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   402: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   405: aload 7
      //   407: invokevirtual 262	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   410: astore 7
      //   412: aload 7
      //   414: ldc_w 264
      //   417: invokestatic 267	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   420: aload 7
      //   422: aload_1
      //   423: invokestatic 270	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a:a	(Ljava/io/InputStream;Ljava/lang/Integer;)[B
      //   426: astore 7
      //   428: iload_3
      //   429: aload 7
      //   431: arraylength
      //   432: if_icmpge +29 -> 461
      //   435: new 177	com/tencent/mm/plugin/appbrand/t/c/b/b
      //   438: dup
      //   439: ldc_w 272
      //   442: invokespecial 185	com/tencent/mm/plugin/appbrand/t/c/b/b:<init>	(Ljava/lang/String;)V
      //   445: astore_1
      //   446: ldc 127
      //   448: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   451: aload_1
      //   452: athrow
      //   453: aload_1
      //   454: invokestatic 278	kotlin/n/n:bJF	(Ljava/lang/String;)Ljava/lang/Integer;
      //   457: astore_1
      //   458: goto -70 -> 388
      //   461: aload_0
      //   462: getfield 116	com/tencent/mm/plugin/appbrand/t/c/b/a$b:tpC	Ljava/util/concurrent/locks/ReentrantLock;
      //   465: checkcast 187	java/util/concurrent/locks/Lock
      //   468: astore_1
      //   469: aload_1
      //   470: invokeinterface 190 1 0
      //   475: aload_0
      //   476: new 16	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a$b
      //   479: dup
      //   480: aload 7
      //   482: invokespecial 281	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a$b:<init>	([B)V
      //   485: checkcast 12	com/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a
      //   488: putfield 195	com/tencent/mm/plugin/appbrand/t/c/b/a$b:tpE	Lcom/tencent/mm/plugin/appbrand/t/c/b/a$b$a$a;
      //   491: aload_0
      //   492: getfield 122	com/tencent/mm/plugin/appbrand/t/c/b/a$b:tpD	Ljava/util/concurrent/locks/Condition;
      //   495: invokeinterface 200 1 0
      //   500: getstatic 206	kotlin/ah:aiuX	Lkotlin/ah;
      //   503: astore 7
      //   505: aload_1
      //   506: invokeinterface 209 1 0
      //   511: ldc 127
      //   513: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   516: return
      //   517: astore 7
      //   519: aload_1
      //   520: invokeinterface 209 1 0
      //   525: ldc 127
      //   527: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   530: aload 7
      //   532: athrow
      //   533: new 177	com/tencent/mm/plugin/appbrand/t/c/b/b
      //   536: dup
      //   537: aload_1
      //   538: checkcast 283	java/lang/Throwable
      //   541: invokespecial 286	com/tencent/mm/plugin/appbrand/t/c/b/b:<init>	(Ljava/lang/Throwable;)V
      //   544: astore_1
      //   545: goto -415 -> 130
      //   548: astore_1
      //   549: aload 7
      //   551: invokeinterface 209 1 0
      //   556: ldc 127
      //   558: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   561: aload_1
      //   562: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	563	0	this	b
      //   0	563	1	paramString	String
      //   0	563	2	paramInt1	int
      //   0	563	3	paramInt2	int
      //   226	125	4	i	int
      //   8	281	5	l	long
      //   109	395	7	localObject1	Object
      //   517	33	7	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   5	46	101	java/lang/Exception
      //   46	101	101	java/lang/Exception
      //   171	176	101	java/lang/Exception
      //   180	197	101	java/lang/Exception
      //   197	228	101	java/lang/Exception
      //   276	294	101	java/lang/Exception
      //   298	312	101	java/lang/Exception
      //   312	329	101	java/lang/Exception
      //   337	374	101	java/lang/Exception
      //   374	382	101	java/lang/Exception
      //   388	405	101	java/lang/Exception
      //   405	453	101	java/lang/Exception
      //   453	458	101	java/lang/Exception
      //   461	475	101	java/lang/Exception
      //   505	516	101	java/lang/Exception
      //   519	533	101	java/lang/Exception
      //   475	505	517	finally
      //   118	130	548	finally
      //   130	158	548	finally
      //   533	545	548	finally
    }
    
    private final byte[] cCP()
    {
      a.b.a.a locala = this.tpE;
      if (locala == null) {
        return null;
      }
      if ((locala instanceof a.b.a.a.b)) {
        return (byte[])locala.value;
      }
      throw ((b)locala.value);
    }
    
    public final a.c cCN()
    {
      AppMethodBeat.i(319241);
      Object localObject = new a.c(this);
      try
      {
        this.tpA.add(localObject);
        if (!this.tpB) {
          break label100;
        }
        if (a.cCM())
        {
          Log.d("MicroMsg.Verify.DefaultCertNetFetcher", "execute, already started");
          if (s.p(Thread.currentThread(), this.tpF))
          {
            localObject = new b("execute is non-reentrant");
            AppMethodBeat.o(319241);
            throw ((Throwable)localObject);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(319241);
      }
      AppMethodBeat.o(319241);
      return localc;
      label100:
      this.tpB = true;
      if (a.cCM()) {
        this.tpF = Thread.currentThread();
      }
      ah localah = ah.aiuX;
      Y(this.tpz.url, this.tpz.tpH, this.tpz.tpI);
      a.a(this.tpy, this.tpz);
      AppMethodBeat.o(319241);
      return localc;
    }
    
    public final byte[] cCO()
    {
      AppMethodBeat.i(319245);
      Lock localLock = (Lock)this.tpC;
      localLock.lock();
      try
      {
        byte[] arrayOfByte = cCP();
        if (arrayOfByte != null) {
          return arrayOfByte;
        }
        this.tpD.await();
        arrayOfByte = cCP();
        s.checkNotNull(arrayOfByte);
        return arrayOfByte;
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(319245);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion;", "", "()V", "HTTP_HEADER_FIELD_CONTENT_LENGTH", "", "HTTP_HEADER_FIELD_LOCATION", "HTTP_PERM_REDIRECT", "", "HTTP_TEMP_REDIRECT", "PROTOCOL_HTTP", "canIFetch", "", "Ljava/net/URL;", "toByteArray", "", "Ljava/io/InputStream;", "lenHint", "(Ljava/io/InputStream;Ljava/lang/Integer;)[B", "Result", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      static byte[] a(InputStream paramInputStream, Integer paramInteger)
      {
        int i = 4096;
        AppMethodBeat.i(319238);
        if (paramInteger == null) {}
        for (;;)
        {
          paramInteger = (Closeable)new ByteArrayOutputStream(i);
          try
          {
            ByteArrayOutputStream localByteArrayOutputStream = (ByteArrayOutputStream)paramInteger;
            byte[] arrayOfByte = new byte[4096];
            i = paramInputStream.read(arrayOfByte);
            for (;;)
            {
              if (-1 != i)
              {
                localByteArrayOutputStream.write(arrayOfByte, 0, i);
                i = paramInputStream.read(arrayOfByte);
                continue;
                i = paramInteger.intValue();
                break;
              }
            }
            paramInputStream = localByteArrayOutputStream.toByteArray();
            s.s(paramInputStream, "outputStream.toByteArray()");
            kotlin.f.b.a(paramInteger, null);
            AppMethodBeat.o(319238);
            return paramInputStream;
          }
          finally
          {
            try
            {
              AppMethodBeat.o(319238);
              throw paramInputStream;
            }
            finally
            {
              kotlin.f.b.a(paramInteger, paramInputStream);
              AppMethodBeat.o(319238);
            }
          }
        }
      }
      
      static boolean c(URL paramURL)
      {
        AppMethodBeat.i(319230);
        boolean bool = s.p("http", paramURL.getProtocol());
        AppMethodBeat.o(319230);
        return bool;
      }
      
      @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Failure", "Success", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Success;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Failure;", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
      static abstract class a
      {
        final Object value;
        
        private a(Object paramObject)
        {
          this.value = paramObject;
        }
        
        @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Failure;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "fetchException", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/FetchException;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/FetchException;)V", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
        public static final class a
          extends a.b.a.a
        {
          public a(b paramb)
          {
            super((byte)0);
            AppMethodBeat.i(319232);
            AppMethodBeat.o(319232);
          }
        }
        
        @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Success;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "data", "", "([B)V", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
        public static final class b
          extends a.b.a.a
        {
          public b(byte[] paramArrayOfByte)
          {
            super((byte)0);
            AppMethodBeat.i(319236);
            AppMethodBeat.o(319236);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestImpl;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "job", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;)V", "waitForResult", "", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements c.b
  {
    private final a.b tpG;
    
    public c(a.b paramb)
    {
      AppMethodBeat.i(319218);
      this.tpG = paramb;
      AppMethodBeat.o(319218);
    }
    
    public final byte[] cCO()
    {
      AppMethodBeat.i(319222);
      Log.i("MicroMsg.Verify.DefaultCertNetFetcher", "waitForResult");
      try
      {
        byte[] arrayOfByte = this.tpG.cCO();
        AppMethodBeat.o(319222);
        return arrayOfByte;
      }
      catch (b localb1)
      {
        AppMethodBeat.o(319222);
        throw localb1;
      }
      catch (Exception localException)
      {
        b localb2 = new b((Throwable)localException);
        AppMethodBeat.o(319222);
        throw localb2;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;", "", "url", "", "timeoutMills", "", "maxRespBytes", "(Ljava/lang/String;II)V", "getMaxRespBytes", "()I", "getTimeoutMills", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
  {
    final int tpH;
    final int tpI;
    final String url;
    
    public d(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(319211);
      this.url = paramString;
      this.tpH = 15000;
      this.tpI = 65536;
      AppMethodBeat.o(319211);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(319227);
      if (this == paramObject)
      {
        AppMethodBeat.o(319227);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(319227);
        return false;
      }
      paramObject = (d)paramObject;
      if (!s.p(this.url, paramObject.url))
      {
        AppMethodBeat.o(319227);
        return false;
      }
      if (this.tpH != paramObject.tpH)
      {
        AppMethodBeat.o(319227);
        return false;
      }
      if (this.tpI != paramObject.tpI)
      {
        AppMethodBeat.o(319227);
        return false;
      }
      AppMethodBeat.o(319227);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(319220);
      int i = this.url.hashCode();
      int j = this.tpH;
      int k = this.tpI;
      AppMethodBeat.o(319220);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(319215);
      String str = "RequestParams(url=" + this.url + ", timeoutMills=" + this.tpH + ", maxRespBytes=" + this.tpI + ')';
      AppMethodBeat.o(319215);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.b.a
 * JD-Core Version:    0.7.0.1
 */