package com.tencent.mm.plugin.appbrand.w.a;

import com.tencent.mm.plugin.appbrand.w.a.b;
import com.tencent.mm.plugin.appbrand.w.c;
import com.tencent.mm.plugin.appbrand.w.e.f;
import com.tencent.mm.plugin.appbrand.w.e.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.w.b
  implements com.tencent.mm.plugin.appbrand.w.a, Runnable
{
  public String gep;
  private Map<String, String> headers;
  protected URI hmC = null;
  public c hmD = null;
  private Socket hmE = null;
  private InputStream hmF;
  OutputStream hmG;
  private Proxy hmH = Proxy.NO_PROXY;
  public Runnable hmI;
  private CountDownLatch hmJ = new CountDownLatch(1);
  private CountDownLatch hmK = new CountDownLatch(1);
  private int hmL = 0;
  private com.tencent.mm.plugin.appbrand.w.b.a hmt;
  public Timer mTimer = null;
  
  public a(URI paramURI, com.tencent.mm.plugin.appbrand.w.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.hmC = paramURI;
    this.hmt = parama;
    this.headers = paramMap;
    this.hmL = paramInt;
    this.hmD = new c(this, parama);
    this.hmi = false;
  }
  
  private void aqG()
  {
    Object localObject2 = this.hmC.getPath();
    Object localObject3 = this.hmC.getQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = (String)localObject1 + "?" + (String)localObject3;
    }
    int i = getPort();
    localObject3 = new StringBuilder().append(this.hmC.getHost());
    if (i != 80) {}
    for (Object localObject1 = ":" + i;; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.tencent.mm.plugin.appbrand.w.e.d();
      ((com.tencent.mm.plugin.appbrand.w.e.d)localObject1).wQ((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.w.e.d)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.mm.plugin.appbrand.w.e.d)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.hmD;
    ((c)localObject2).hmx = ((c)localObject2).hmt.a((com.tencent.mm.plugin.appbrand.w.e.b)localObject1);
    ((c)localObject2).hmB = ((com.tencent.mm.plugin.appbrand.w.e.b)localObject1).aqO();
    if (((c)localObject2).hmB != null) {}
    try
    {
      ((c)localObject2).hmr.b(((c)localObject2).hmx);
      localObject1 = ((c)localObject2).hmt;
      localObject1 = ((c)localObject2).hmx;
      localObject3 = ((c)localObject2).hmu;
      ((c)localObject2).aD(com.tencent.mm.plugin.appbrand.w.b.a.e((f)localObject1));
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.w.c.b localb)
    {
      throw new com.tencent.mm.plugin.appbrand.w.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((c)localObject2).hmr.e(localRuntimeException);
      throw new com.tencent.mm.plugin.appbrand.w.c.d("rejected because of" + localRuntimeException);
    }
  }
  
  private int getPort()
  {
    int j = this.hmC.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.hmC.getScheme();
      if (str.equals("wss")) {
        i = 443;
      }
    }
    else
    {
      return i;
    }
    if (str.equals("ws")) {
      return 80;
    }
    throw new RuntimeException("unkonow scheme" + str);
  }
  
  public abstract void D(int paramInt, String paramString);
  
  public final void R(int paramInt, String paramString)
  {
    this.hmJ.countDown();
    this.hmK.countDown();
    if (this.hmI != null) {
      e.Y(this.hmI);
    }
    try
    {
      if (this.hmE != null) {
        this.hmE.close();
      }
      D(paramInt, paramString);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        b(localIOException);
      }
    }
  }
  
  public final void S(int paramInt, String paramString)
  {
    this.hmD.d(paramInt, paramString, false);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.w.d.d paramd) {}
  
  public final void a(Socket paramSocket)
  {
    if (this.hmE != null)
    {
      y.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
      return;
    }
    this.hmE = paramSocket;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.w.d.d paramd)
  {
    this.hmD.b(paramd);
  }
  
  public abstract void b(h paramh);
  
  public abstract void b(Exception paramException);
  
  public final void c(com.tencent.mm.plugin.appbrand.w.d.d paramd)
  {
    a(paramd);
  }
  
  public final void close()
  {
    if (this.hmI != null) {
      this.hmD.d(1000, "", false);
    }
  }
  
  public final void connect()
  {
    if (this.hmI != null)
    {
      y.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.hmI = this;
    e.post(this.hmI, "WebsocketWriteThread");
  }
  
  public final void d(f paramf)
  {
    this.hmJ.countDown();
    b((h)paramf);
  }
  
  public final void e(Exception paramException)
  {
    b(paramException);
  }
  
  public void h(ByteBuffer paramByteBuffer) {}
  
  public final void p(ByteBuffer paramByteBuffer)
  {
    h(paramByteBuffer);
  }
  
  public final void q(ByteBuffer paramByteBuffer)
  {
    c localc = this.hmD;
    if (paramByteBuffer == null)
    {
      y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      return;
    }
    com.tencent.mm.plugin.appbrand.w.b.a locala = localc.hmt;
    if (localc.hmu == a.b.hmf) {}
    for (boolean bool = true;; bool = false)
    {
      localc.d(locala.a(paramByteBuffer, bool));
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   4: ifnonnull +182 -> 186
    //   7: aload_0
    //   8: new 242	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 57	com/tencent/mm/plugin/appbrand/w/a/a:hmH	Ljava/net/Proxy;
    //   16: invokespecial 341	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   26: aload_0
    //   27: getfield 91	com/tencent/mm/plugin/appbrand/w/b:hmi	Z
    //   30: invokevirtual 345	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   37: invokevirtual 348	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   47: new 350	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 46	com/tencent/mm/plugin/appbrand/w/a/a:hmC	Ljava/net/URI;
    //   55: invokevirtual 134	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 131	com/tencent/mm/plugin/appbrand/w/a/a:getPort	()I
    //   62: invokespecial 353	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 68	com/tencent/mm/plugin/appbrand/w/a/a:hmL	I
    //   69: invokevirtual 356	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   77: invokevirtual 360	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 362	com/tencent/mm/plugin/appbrand/w/a/a:hmF	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   88: invokevirtual 366	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 368	com/tencent/mm/plugin/appbrand/w/a/a:hmG	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 370	com/tencent/mm/plugin/appbrand/w/a/a:aqG	()V
    //   98: aload_0
    //   99: new 10	com/tencent/mm/plugin/appbrand/w/a/a$a
    //   102: dup
    //   103: aload_0
    //   104: iconst_0
    //   105: invokespecial 373	com/tencent/mm/plugin/appbrand/w/a/a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/w/a/a;B)V
    //   108: putfield 270	com/tencent/mm/plugin/appbrand/w/a/a:hmI	Ljava/lang/Runnable;
    //   111: aload_0
    //   112: getfield 270	com/tencent/mm/plugin/appbrand/w/a/a:hmI	Ljava/lang/Runnable;
    //   115: ldc_w 305
    //   118: invokestatic 309	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   121: getstatic 376	com/tencent/mm/plugin/appbrand/w/c:hmj	I
    //   124: newarray byte
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   131: invokevirtual 379	com/tencent/mm/plugin/appbrand/w/c:aqF	()Z
    //   134: ifne +84 -> 218
    //   137: aload_0
    //   138: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   141: invokevirtual 382	com/tencent/mm/plugin/appbrand/w/c:isClosed	()Z
    //   144: ifne +74 -> 218
    //   147: aload_0
    //   148: getfield 362	com/tencent/mm/plugin/appbrand/w/a/a:hmF	Ljava/io/InputStream;
    //   151: aload_2
    //   152: invokevirtual 388	java/io/InputStream:read	([B)I
    //   155: istore_1
    //   156: iload_1
    //   157: iconst_m1
    //   158: if_icmpeq +60 -> 218
    //   161: aload_0
    //   162: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   165: aload_2
    //   166: iconst_0
    //   167: iload_1
    //   168: invokestatic 394	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   171: invokevirtual 397	com/tencent/mm/plugin/appbrand/w/c:l	(Ljava/nio/ByteBuffer;)V
    //   174: goto -47 -> 127
    //   177: astore_2
    //   178: aload_0
    //   179: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   182: invokevirtual 400	com/tencent/mm/plugin/appbrand/w/c:aqE	()V
    //   185: return
    //   186: aload_0
    //   187: getfield 50	com/tencent/mm/plugin/appbrand/w/a/a:hmE	Ljava/net/Socket;
    //   190: invokevirtual 401	java/net/Socket:isClosed	()Z
    //   193: ifeq -171 -> 22
    //   196: new 240	java/io/IOException
    //   199: dup
    //   200: invokespecial 402	java/io/IOException:<init>	()V
    //   203: athrow
    //   204: astore_2
    //   205: aload_0
    //   206: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   209: iconst_m1
    //   210: aload_2
    //   211: invokevirtual 405	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   214: invokevirtual 408	com/tencent/mm/plugin/appbrand/w/c:Q	(ILjava/lang/String;)V
    //   217: return
    //   218: aload_0
    //   219: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   222: invokevirtual 400	com/tencent/mm/plugin/appbrand/w/c:aqE	()V
    //   225: return
    //   226: astore_2
    //   227: aload_0
    //   228: aload_2
    //   229: invokevirtual 247	com/tencent/mm/plugin/appbrand/w/a/a:b	(Ljava/lang/Exception;)V
    //   232: aload_0
    //   233: getfield 48	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
    //   236: sipush 1006
    //   239: aload_2
    //   240: invokevirtual 409	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 408	com/tencent/mm/plugin/appbrand/w/c:Q	(ILjava/lang/String;)V
    //   246: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	a
    //   155	13	1	i	int
    //   126	40	2	arrayOfByte	byte[]
    //   177	1	2	localIOException	IOException
    //   204	7	2	localException	Exception
    //   226	14	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   127	156	177	java/io/IOException
    //   161	174	177	java/io/IOException
    //   218	225	177	java/io/IOException
    //   0	22	204	java/lang/Exception
    //   22	72	204	java/lang/Exception
    //   72	98	204	java/lang/Exception
    //   186	204	204	java/lang/Exception
    //   127	156	226	java/lang/RuntimeException
    //   161	174	226	java/lang/RuntimeException
    //   218	225	226	java/lang/RuntimeException
  }
  
  public abstract void sQ(String paramString);
  
  public final void wN(String paramString)
  {
    sQ(paramString);
  }
  
  public final void wO(String paramString)
  {
    c localc = this.hmD;
    if (paramString == null)
    {
      y.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      return;
    }
    com.tencent.mm.plugin.appbrand.w.b.a locala = localc.hmt;
    if (localc.hmu == a.b.hmf) {}
    for (boolean bool = true;; bool = false)
    {
      localc.d(locala.ak(paramString, bool));
      return;
    }
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: invokestatic 33	java/lang/Thread:interrupted	()Z
      //   3: ifne +155 -> 158
      //   6: aload_0
      //   7: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   10: getfield 37	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
      //   13: getfield 43	com/tencent/mm/plugin/appbrand/w/c:hmn	Ljava/util/concurrent/BlockingQueue;
      //   16: invokeinterface 49 1 0
      //   21: checkcast 51	java/nio/ByteBuffer
      //   24: astore_1
      //   25: aload_0
      //   26: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   29: getfield 55	com/tencent/mm/plugin/appbrand/w/a/a:hmG	Ljava/io/OutputStream;
      //   32: aload_1
      //   33: invokevirtual 59	java/nio/ByteBuffer:array	()[B
      //   36: iconst_0
      //   37: aload_1
      //   38: invokevirtual 63	java/nio/ByteBuffer:limit	()I
      //   41: invokevirtual 69	java/io/OutputStream:write	([BII)V
      //   44: aload_0
      //   45: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   48: getfield 55	com/tencent/mm/plugin/appbrand/w/a/a:hmG	Ljava/io/OutputStream;
      //   51: invokevirtual 72	java/io/OutputStream:flush	()V
      //   54: goto -54 -> 0
      //   57: astore_1
      //   58: aload_0
      //   59: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   62: getfield 37	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
      //   65: getfield 43	com/tencent/mm/plugin/appbrand/w/c:hmn	Ljava/util/concurrent/BlockingQueue;
      //   68: invokeinterface 76 1 0
      //   73: astore_1
      //   74: aload_1
      //   75: invokeinterface 81 1 0
      //   80: ifeq +78 -> 158
      //   83: aload_1
      //   84: invokeinterface 84 1 0
      //   89: checkcast 51	java/nio/ByteBuffer
      //   92: astore_2
      //   93: aload_0
      //   94: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   97: getfield 55	com/tencent/mm/plugin/appbrand/w/a/a:hmG	Ljava/io/OutputStream;
      //   100: aload_2
      //   101: invokevirtual 59	java/nio/ByteBuffer:array	()[B
      //   104: iconst_0
      //   105: aload_2
      //   106: invokevirtual 63	java/nio/ByteBuffer:limit	()I
      //   109: invokevirtual 69	java/io/OutputStream:write	([BII)V
      //   112: aload_0
      //   113: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   116: getfield 55	com/tencent/mm/plugin/appbrand/w/a/a:hmG	Ljava/io/OutputStream;
      //   119: invokevirtual 72	java/io/OutputStream:flush	()V
      //   122: goto -48 -> 74
      //   125: astore_1
      //   126: aload_0
      //   127: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   130: astore_2
      //   131: aload_1
      //   132: instanceof 86
      //   135: ifeq +8 -> 143
      //   138: aload_2
      //   139: aload_1
      //   140: invokevirtual 90	com/tencent/mm/plugin/appbrand/w/a/a:b	(Ljava/lang/Exception;)V
      //   143: aload_2
      //   144: getfield 37	com/tencent/mm/plugin/appbrand/w/a/a:hmD	Lcom/tencent/mm/plugin/appbrand/w/c;
      //   147: invokevirtual 93	com/tencent/mm/plugin/appbrand/w/c:aqE	()V
      //   150: aload_0
      //   151: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   154: invokestatic 96	com/tencent/mm/plugin/appbrand/w/a/a:e	(Lcom/tencent/mm/plugin/appbrand/w/a/a;)V
      //   157: return
      //   158: aload_0
      //   159: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   162: invokestatic 96	com/tencent/mm/plugin/appbrand/w/a/a:e	(Lcom/tencent/mm/plugin/appbrand/w/a/a;)V
      //   165: return
      //   166: astore_1
      //   167: aload_0
      //   168: getfield 15	com/tencent/mm/plugin/appbrand/w/a/a$a:hmM	Lcom/tencent/mm/plugin/appbrand/w/a/a;
      //   171: invokestatic 96	com/tencent/mm/plugin/appbrand/w/a/a:e	(Lcom/tencent/mm/plugin/appbrand/w/a/a;)V
      //   174: aload_1
      //   175: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	176	0	this	a
      //   24	14	1	localByteBuffer	ByteBuffer
      //   57	1	1	localInterruptedException	java.lang.InterruptedException
      //   73	11	1	localIterator	Iterator
      //   125	15	1	localIOException	IOException
      //   166	9	1	localObject1	Object
      //   92	52	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   0	54	57	java/lang/InterruptedException
      //   0	54	125	java/io/IOException
      //   58	74	125	java/io/IOException
      //   74	122	125	java/io/IOException
      //   0	54	166	finally
      //   58	74	166	finally
      //   74	122	166	finally
      //   126	143	166	finally
      //   143	150	166	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a.a
 * JD-Core Version:    0.7.0.1
 */