package com.tencent.mm.plugin.appbrand.s.b.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "()V", "params2JobMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;", "Lkotlin/collections/HashMap;", "fetchCaIssuers", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "url", "", "timeoutMills", "", "maxRespBytes", "markJobDone", "", "reqParams", "Companion", "NetJob", "RequestImpl", "RequestParams", "luggage-commons_release"})
public final class a
  implements c
{
  private static final boolean qky;
  public static final a qkz;
  private final HashMap<d, b> qkx;
  
  static
  {
    AppMethodBeat.i(207468);
    qkz = new a((byte)0);
    qky = com.tencent.mm.plugin.appbrand.s.b.c.a.ccu();
    AppMethodBeat.o(207468);
  }
  
  public a()
  {
    AppMethodBeat.i(207467);
    this.qkx = new HashMap();
    AppMethodBeat.o(207467);
  }
  
  private final void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(207465);
      if (qky) {
        Log.d("MicroMsg.Verify.DefaultCertNetFetcher", "markJobDone, reqParams: ".concat(String.valueOf(paramd)));
      }
      this.qkx.remove(paramd);
      AppMethodBeat.o(207465);
      return;
    }
    finally {}
  }
  
  public final c.b alc(String paramString)
  {
    AppMethodBeat.i(207463);
    p.k(paramString, "url");
    Log.i("MicroMsg.Verify.DefaultCertNetFetcher", "fetchCaIssuers, url: " + paramString + ", timeoutMills: 15000, maxRespBytes: 65536");
    for (;;)
    {
      try
      {
        Object localObject = new d(paramString, 15000, 65536);
        Map localMap = (Map)this.qkx;
        paramString = localMap.get(localObject);
        if (paramString == null)
        {
          paramString = new b(this, (d)localObject);
          localMap.put(localObject, paramString);
          paramString = (b)paramString;
          localObject = x.aazN;
          paramString = (c.b)paramString.ccr();
          AppMethodBeat.o(207463);
          return paramString;
        }
      }
      finally
      {
        AppMethodBeat.o(207463);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$Companion;", "", "()V", "DEBUG_FETCHER", "", "TAG", "", "luggage-commons_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;", "", "fetcher", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher;", "reqParams", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher;Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;)V", "executeThread", "Ljava/lang/Thread;", "isExecuteStarted", "", "requests", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestImpl;", "Lkotlin/collections/HashSet;", "result", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "resultCondition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "resultLock", "Ljava/util/concurrent/locks/ReentrantLock;", "doExecute", "", "urlStr", "", "timeoutMills", "", "maxRespBytes", "execute", "getResultLocked", "", "waitForResult", "Companion", "luggage-commons_release"})
  static final class b
  {
    public static final a qkI;
    private final HashSet<a.c> qkA;
    private boolean qkB;
    private final ReentrantLock qkC;
    private final Condition qkD;
    private a.b.a.a qkE;
    private Thread qkF;
    private final a qkG;
    private final a.d qkH;
    
    static
    {
      AppMethodBeat.i(208497);
      qkI = new a((byte)0);
      AppMethodBeat.o(208497);
    }
    
    public b(a parama, a.d paramd)
    {
      AppMethodBeat.i(208496);
      this.qkG = parama;
      this.qkH = paramd;
      this.qkA = new HashSet();
      this.qkC = new ReentrantLock();
      this.qkD = this.qkC.newCondition();
      AppMethodBeat.o(208496);
    }
    
    private final void U(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(208493);
      long l;
      Object localObject1;
      try
      {
        l = SystemClock.elapsedRealtime();
        if (a.ccq()) {
          Log.d("MicroMsg.Verify.DefaultCertNetFetcher", "doExecute, urlStr: " + paramString + ", timeoutMills: " + paramInt1);
        }
        paramString = new URL(paramString);
        if (!a.c(paramString))
        {
          paramString = (Throwable)new b("Protocol " + paramString.getProtocol() + " fetch is not supported.");
          AppMethodBeat.o(208493);
          throw paramString;
        }
      }
      catch (Exception paramString)
      {
        localObject1 = (Lock)this.qkC;
        ((Lock)localObject1).lock();
      }
      label574:
      for (;;)
      {
        try
        {
          if ((paramString instanceof b))
          {
            paramString = (b)paramString;
            this.qkE = ((a.b.a.a)new a.b.a.a.a(paramString));
            this.qkD.signalAll();
            paramString = x.aazN;
            ((Lock)localObject1).unlock();
            AppMethodBeat.o(208493);
            return;
            paramString = paramString.openConnection();
            if (paramString == null)
            {
              paramString = new t("null cannot be cast to non-null type java.net.HttpURLConnection");
              AppMethodBeat.o(208493);
              throw paramString;
            }
            localObject1 = (HttpURLConnection)paramString;
            ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
            ((HttpURLConnection)localObject1).setConnectTimeout(paramInt1);
            ((HttpURLConnection)localObject1).setReadTimeout(paramInt1);
            int i = ((HttpURLConnection)localObject1).getResponseCode();
            if ((300 == i) || (301 == i) || (302 == i) || (303 == i) || (307 == i) || (308 == i))
            {
              paramString = ((HttpURLConnection)localObject1).getHeaderField("Location");
              paramInt1 -= (int)(SystemClock.elapsedRealtime() - l);
              if (paramInt1 > 0)
              {
                Log.d("MicroMsg.Verify.DefaultCertNetFetcher", "doExecute, do redirect");
                U(paramString, paramInt1, paramInt2);
              }
              paramString = (Throwable)new b("Fetch timeout.");
              AppMethodBeat.o(208493);
              throw paramString;
            }
            if (200 != i)
            {
              paramString = (Throwable)new b("Response code " + i + " is not OK.");
              AppMethodBeat.o(208493);
              throw paramString;
            }
            paramString = ((HttpURLConnection)localObject1).getHeaderField("Content-Length");
            if (paramString == null) {
              break label574;
            }
            paramString = n.bHC(paramString);
            if (a.ccq()) {
              Log.d("MicroMsg.Verify.DefaultCertNetFetcher", "doExecute, lenHint: ".concat(String.valueOf(paramString)));
            }
            localObject1 = ((HttpURLConnection)localObject1).getInputStream();
            p.j(localObject1, "connection.inputStream");
            localObject1 = a.a((InputStream)localObject1, paramString);
            if (paramInt2 < localObject1.length)
            {
              paramString = (Throwable)new b("Response body is too large.");
              AppMethodBeat.o(208493);
              throw paramString;
            }
            paramString = (Lock)this.qkC;
            paramString.lock();
            try
            {
              this.qkE = ((a.b.a.a)new a.b.a.a.b((byte[])localObject1));
              this.qkD.signalAll();
              localObject1 = x.aazN;
              return;
            }
            finally {}
          }
          paramString = new b((Throwable)paramString);
          continue;
          paramString = null;
        }
        finally
        {
          localObject2.unlock();
          AppMethodBeat.o(208493);
        }
      }
    }
    
    private final byte[] cct()
    {
      AppMethodBeat.i(208495);
      Object localObject = this.qkE;
      if (localObject == null)
      {
        AppMethodBeat.o(208495);
        return null;
      }
      if ((localObject instanceof a.b.a.a.b))
      {
        localObject = ((a.b.a.a)localObject).value;
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.ByteArray");
          AppMethodBeat.o(208495);
          throw ((Throwable)localObject);
        }
        localObject = (byte[])localObject;
        AppMethodBeat.o(208495);
        return localObject;
      }
      localObject = ((a.b.a.a)localObject).value;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.network.workaround.fetch.FetchException");
        AppMethodBeat.o(208495);
        throw ((Throwable)localObject);
      }
      localObject = (Throwable)localObject;
      AppMethodBeat.o(208495);
      throw ((Throwable)localObject);
    }
    
    public final a.c ccr()
    {
      AppMethodBeat.i(208489);
      Object localObject = new a.c(this);
      try
      {
        this.qkA.add(localObject);
        if (!this.qkB) {
          break label103;
        }
        if (a.ccq())
        {
          Log.d("MicroMsg.Verify.DefaultCertNetFetcher", "execute, already started");
          if (p.h(Thread.currentThread(), this.qkF))
          {
            localObject = (Throwable)new b("execute is non-reentrant");
            AppMethodBeat.o(208489);
            throw ((Throwable)localObject);
          }
        }
      }
      finally
      {
        AppMethodBeat.o(208489);
      }
      AppMethodBeat.o(208489);
      return localc;
      label103:
      this.qkB = true;
      if (a.ccq()) {
        this.qkF = Thread.currentThread();
      }
      x localx = x.aazN;
      U(this.qkH.url, this.qkH.qkK, this.qkH.qkL);
      a.a(this.qkG, this.qkH);
      AppMethodBeat.o(208489);
      return localc;
    }
    
    public final byte[] ccs()
    {
      AppMethodBeat.i(208490);
      Lock localLock = (Lock)this.qkC;
      localLock.lock();
      try
      {
        byte[] arrayOfByte = cct();
        if (arrayOfByte != null) {
          return arrayOfByte;
        }
        this.qkD.await();
        arrayOfByte = cct();
        if (arrayOfByte == null) {
          p.iCn();
        }
        return arrayOfByte;
      }
      finally
      {
        localLock.unlock();
        AppMethodBeat.o(208490);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion;", "", "()V", "HTTP_HEADER_FIELD_CONTENT_LENGTH", "", "HTTP_HEADER_FIELD_LOCATION", "HTTP_PERM_REDIRECT", "", "HTTP_TEMP_REDIRECT", "PROTOCOL_HTTP", "canIFetch", "", "Ljava/net/URL;", "toByteArray", "", "Ljava/io/InputStream;", "lenHint", "(Ljava/io/InputStream;Ljava/lang/Integer;)[B", "Result", "luggage-commons_release"})
    public static final class a
    {
      /* Error */
      static byte[] a(InputStream paramInputStream, java.lang.Integer paramInteger)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: sipush 4096
        //   5: istore_2
        //   6: ldc 48
        //   8: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   11: aload_1
        //   12: ifnull +8 -> 20
        //   15: aload_1
        //   16: invokevirtual 60	java/lang/Integer:intValue	()I
        //   19: istore_2
        //   20: new 62	java/io/ByteArrayOutputStream
        //   23: dup
        //   24: iload_2
        //   25: invokespecial 64	java/io/ByteArrayOutputStream:<init>	(I)V
        //   28: checkcast 66	java/io/Closeable
        //   31: astore 4
        //   33: aload 4
        //   35: checkcast 62	java/io/ByteArrayOutputStream
        //   38: astore_1
        //   39: sipush 4096
        //   42: newarray byte
        //   44: astore 5
        //   46: aload_0
        //   47: aload 5
        //   49: invokevirtual 72	java/io/InputStream:read	([B)I
        //   52: istore_2
        //   53: iconst_m1
        //   54: iload_2
        //   55: if_icmpeq +21 -> 76
        //   58: aload_1
        //   59: aload 5
        //   61: iconst_0
        //   62: iload_2
        //   63: invokevirtual 76	java/io/ByteArrayOutputStream:write	([BII)V
        //   66: aload_0
        //   67: aload 5
        //   69: invokevirtual 72	java/io/InputStream:read	([B)I
        //   72: istore_2
        //   73: goto -20 -> 53
        //   76: aload_1
        //   77: invokevirtual 79	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   80: astore_0
        //   81: aload_0
        //   82: ldc 81
        //   84: invokestatic 87	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
        //   87: aload 4
        //   89: aconst_null
        //   90: invokestatic 92	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   93: ldc 48
        //   95: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   98: aload_0
        //   99: areturn
        //   100: astore_1
        //   101: ldc 48
        //   103: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   106: aload_1
        //   107: athrow
        //   108: astore_0
        //   109: aload 4
        //   111: aload_1
        //   112: invokestatic 92	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   115: ldc 48
        //   117: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   120: aload_0
        //   121: athrow
        //   122: astore_0
        //   123: aload_3
        //   124: astore_1
        //   125: goto -16 -> 109
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	128	0	paramInputStream	InputStream
        //   0	128	1	paramInteger	java.lang.Integer
        //   5	68	2	i	int
        //   1	123	3	localObject	Object
        //   31	79	4	localCloseable	java.io.Closeable
        //   44	24	5	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   33	53	100	java/lang/Throwable
        //   58	73	100	java/lang/Throwable
        //   76	87	100	java/lang/Throwable
        //   101	108	108	finally
        //   33	53	122	finally
        //   58	73	122	finally
        //   76	87	122	finally
      }
      
      static boolean c(URL paramURL)
      {
        AppMethodBeat.i(210164);
        boolean bool = p.h("http", paramURL.getProtocol());
        AppMethodBeat.o(210164);
        return bool;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Failure", "Success", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Success;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Failure;", "luggage-commons_release"})
      static abstract class a
      {
        final Object value;
        
        private a(Object paramObject)
        {
          this.value = paramObject;
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Failure;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "fetchException", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/FetchException;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/FetchException;)V", "luggage-commons_release"})
        public static final class a
          extends a.b.a.a
        {
          public a(b paramb)
          {
            super((byte)0);
            AppMethodBeat.i(209356);
            AppMethodBeat.o(209356);
          }
        }
        
        @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result$Success;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob$Companion$Result;", "data", "", "([B)V", "luggage-commons_release"})
        public static final class b
          extends a.b.a.a
        {
          public b(byte[] paramArrayOfByte)
          {
            super((byte)0);
            AppMethodBeat.i(208803);
            AppMethodBeat.o(208803);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestImpl;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher$IRequest;", "job", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$NetJob;)V", "waitForResult", "", "luggage-commons_release"})
  static final class c
    implements c.b
  {
    private final a.b qkJ;
    
    public c(a.b paramb)
    {
      AppMethodBeat.i(210006);
      this.qkJ = paramb;
      AppMethodBeat.o(210006);
    }
    
    public final byte[] ccs()
    {
      AppMethodBeat.i(210004);
      Log.i("MicroMsg.Verify.DefaultCertNetFetcher", "waitForResult");
      try
      {
        byte[] arrayOfByte = this.qkJ.ccs();
        AppMethodBeat.o(210004);
        return arrayOfByte;
      }
      catch (b localb)
      {
        Throwable localThrowable1 = (Throwable)localb;
        AppMethodBeat.o(210004);
        throw localThrowable1;
      }
      catch (Exception localException)
      {
        Throwable localThrowable2 = (Throwable)new b((Throwable)localException);
        AppMethodBeat.o(210004);
        throw localThrowable2;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/DefaultCertNetFetcher$RequestParams;", "", "url", "", "timeoutMills", "", "maxRespBytes", "(Ljava/lang/String;II)V", "getMaxRespBytes", "()I", "getTimeoutMills", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "luggage-commons_release"})
  static final class d
  {
    final int qkK;
    final int qkL;
    final String url;
    
    public d(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210426);
      this.url = paramString;
      this.qkK = 15000;
      this.qkL = 65536;
      AppMethodBeat.o(210426);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(210432);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((!p.h(this.url, paramObject.url)) || (this.qkK != paramObject.qkK) || (this.qkL != paramObject.qkL)) {}
        }
      }
      else
      {
        AppMethodBeat.o(210432);
        return true;
      }
      AppMethodBeat.o(210432);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(210430);
      String str = this.url;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        int j = this.qkK;
        int k = this.qkL;
        AppMethodBeat.o(210430);
        return (i * 31 + j) * 31 + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(210427);
      String str = "RequestParams(url=" + this.url + ", timeoutMills=" + this.qkK + ", maxRespBytes=" + this.qkL + ")";
      AppMethodBeat.o(210427);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.b.a
 * JD-Core Version:    0.7.0.1
 */