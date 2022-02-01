package com.tencent.mm.plugin.appbrand.ah.a;

import com.tencent.mm.plugin.appbrand.ah.a.b;
import com.tencent.mm.plugin.appbrand.ah.c;
import com.tencent.mm.plugin.appbrand.ah.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.e;
import com.tencent.threadpool.i.g;
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
import java.util.concurrent.Future;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.ah.b
  implements com.tencent.mm.plugin.appbrand.ah.a, e, g, Runnable
{
  private Socket cBb = null;
  private int connectTimeout = 0;
  private Future dBj;
  private Map<String, String> headers;
  private Timer mTimer = null;
  private String ppa;
  protected URI uuD = null;
  public c uuE = null;
  private InputStream uuF;
  OutputStream uuG;
  private Proxy uuH = Proxy.NO_PROXY;
  private Runnable uuI;
  private CountDownLatch uuJ = new CountDownLatch(1);
  private CountDownLatch uuK = new CountDownLatch(1);
  private com.tencent.mm.plugin.appbrand.ah.b.a uuu;
  
  public a(URI paramURI, com.tencent.mm.plugin.appbrand.ah.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.uuD = paramURI;
    this.uuu = parama;
    this.headers = paramMap;
    this.connectTimeout = paramInt;
    this.uuE = new c(this, parama);
    setTcpNoDelay(false);
  }
  
  private void cOh()
  {
    Object localObject2 = this.uuD.getRawPath();
    Object localObject3 = this.uuD.getRawQuery();
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
    localObject3 = new StringBuilder().append(this.uuD.getHost());
    if (i != 80) {}
    for (Object localObject1 = ":".concat(String.valueOf(i));; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.tencent.mm.plugin.appbrand.ah.e.d();
      ((com.tencent.mm.plugin.appbrand.ah.e.d)localObject1).agR((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.ah.e.d)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.mm.plugin.appbrand.ah.e.d)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.uuE;
    ((c)localObject2).uuy = ((c)localObject2).uuu.a((com.tencent.mm.plugin.appbrand.ah.e.b)localObject1);
    ((c)localObject2).uuC = ((com.tencent.mm.plugin.appbrand.ah.e.b)localObject1).cOr();
    if (((c)localObject2).uuC != null) {}
    try
    {
      ((c)localObject2).uus.b(((c)localObject2).uuy);
      ((c)localObject2).dK(com.tencent.mm.plugin.appbrand.ah.b.a.e(((c)localObject2).uuy));
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.ah.c.b localb)
    {
      throw new com.tencent.mm.plugin.appbrand.ah.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((c)localObject2).uus.k(localRuntimeException);
      throw new com.tencent.mm.plugin.appbrand.ah.c.d("rejected because of".concat(String.valueOf(localRuntimeException)));
    }
  }
  
  private int getPort()
  {
    int j = this.uuD.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.uuD.getScheme();
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
    throw new RuntimeException("unkonow scheme".concat(String.valueOf(str)));
  }
  
  public abstract void Yk(String paramString);
  
  public void a(com.tencent.mm.plugin.appbrand.ah.d.d paramd) {}
  
  public abstract void a(com.tencent.mm.plugin.appbrand.ah.e.h paramh);
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final void aN(int paramInt, String paramString)
  {
    this.uuJ.countDown();
    this.uuK.countDown();
    if (this.dBj != null) {
      this.dBj.cancel(false);
    }
    if ((this.uuI != null) && ((this.uuI instanceof a.a))) {
      ((a.a)this.uuI).isStop = true;
    }
    try
    {
      if (this.cBb != null) {
        this.cBb.close();
      }
      aq(paramInt, paramString);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        f(localIOException);
      }
    }
  }
  
  public final void aO(int paramInt, String paramString)
  {
    this.uuE.c(paramInt, paramString, false);
  }
  
  public final void acu(String paramString)
  {
    this.ppa = paramString;
  }
  
  public final void acv(String paramString)
  {
    c localc = this.uuE;
    if (paramString == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      return;
    }
    com.tencent.mm.plugin.appbrand.ah.b.a locala = localc.uuu;
    if (localc.uuv == a.b.uug) {}
    for (boolean bool = true;; bool = false)
    {
      localc.v(locala.aT(paramString, bool));
      return;
    }
  }
  
  public final void agP(String paramString)
  {
    Yk(paramString);
  }
  
  public abstract void aq(int paramInt, String paramString);
  
  public final void b(com.tencent.mm.plugin.appbrand.ah.d.d paramd)
  {
    this.uuE.b(paramd);
  }
  
  public final void b(Socket paramSocket)
  {
    if (this.cBb != null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
      return;
    }
    this.cBb = paramSocket;
  }
  
  public final String bQs()
  {
    return this.ppa;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.ah.d.d paramd)
  {
    a(paramd);
  }
  
  public final void c(Future paramFuture)
  {
    this.dBj = paramFuture;
  }
  
  public final void cN(String paramString, int paramInt)
  {
    if (this.uuI != null) {
      aO(paramInt, paramString);
    }
  }
  
  public final void close()
  {
    if (this.uuI != null) {
      this.uuE.c(1000, "", false);
    }
  }
  
  public final void connect()
  {
    if (this.uuI != null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.uuI = this;
    com.tencent.threadpool.h.ahAA.bm(this.uuI);
  }
  
  public final Socket cxA()
  {
    return this.cBb;
  }
  
  public final Timer cxz()
  {
    return this.mTimer;
  }
  
  public final void d(f paramf)
  {
    this.uuJ.countDown();
    a((com.tencent.mm.plugin.appbrand.ah.e.h)paramf);
  }
  
  public abstract void f(Exception paramException);
  
  public String getKey()
  {
    return "WebsocketWriteThread";
  }
  
  public final boolean isOpen()
  {
    return this.uuE.isOpen();
  }
  
  public final void k(Exception paramException)
  {
    f(paramException);
  }
  
  public void o(ByteBuffer paramByteBuffer) {}
  
  public final void r(ByteBuffer paramByteBuffer)
  {
    this.uuE.r(paramByteBuffer);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   4: ifnonnull +185 -> 189
    //   7: aload_0
    //   8: new 105	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 62	com/tencent/mm/plugin/appbrand/ah/a/a:uuH	Ljava/net/Proxy;
    //   16: invokespecial 396	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   26: aload_0
    //   27: invokevirtual 399	com/tencent/mm/plugin/appbrand/ah/a/a:cOe	()Z
    //   30: invokevirtual 400	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   37: invokevirtual 403	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   47: new 405	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 51	com/tencent/mm/plugin/appbrand/ah/a/a:uuD	Ljava/net/URI;
    //   55: invokevirtual 158	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 155	com/tencent/mm/plugin/appbrand/ah/a/a:getPort	()I
    //   62: invokespecial 407	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 73	com/tencent/mm/plugin/appbrand/ah/a/a:connectTimeout	I
    //   69: invokevirtual 410	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   77: invokevirtual 414	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 416	com/tencent/mm/plugin/appbrand/ah/a/a:uuF	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   88: invokevirtual 420	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 422	com/tencent/mm/plugin/appbrand/ah/a/a:uuG	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 424	com/tencent/mm/plugin/appbrand/ah/a/a:cOh	()V
    //   98: aload_0
    //   99: new 14	com/tencent/mm/plugin/appbrand/ah/a/a$a
    //   102: dup
    //   103: aload_0
    //   104: iconst_0
    //   105: invokespecial 427	com/tencent/mm/plugin/appbrand/ah/a/a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/ah/a/a;B)V
    //   108: putfield 295	com/tencent/mm/plugin/appbrand/ah/a/a:uuI	Ljava/lang/Runnable;
    //   111: getstatic 364	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   114: aload_0
    //   115: getfield 295	com/tencent/mm/plugin/appbrand/ah/a/a:uuI	Ljava/lang/Runnable;
    //   118: invokeinterface 370 2 0
    //   123: pop
    //   124: getstatic 430	com/tencent/mm/plugin/appbrand/ah/c:uuk	I
    //   127: newarray byte
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   134: invokevirtual 433	com/tencent/mm/plugin/appbrand/ah/c:cOg	()Z
    //   137: ifne +84 -> 221
    //   140: aload_0
    //   141: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   144: invokevirtual 436	com/tencent/mm/plugin/appbrand/ah/c:isClosed	()Z
    //   147: ifne +74 -> 221
    //   150: aload_0
    //   151: getfield 416	com/tencent/mm/plugin/appbrand/ah/a/a:uuF	Ljava/io/InputStream;
    //   154: aload_2
    //   155: invokevirtual 442	java/io/InputStream:read	([B)I
    //   158: istore_1
    //   159: iload_1
    //   160: iconst_m1
    //   161: if_icmpeq +60 -> 221
    //   164: aload_0
    //   165: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   168: aload_2
    //   169: iconst_0
    //   170: iload_1
    //   171: invokestatic 448	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   174: invokevirtual 451	com/tencent/mm/plugin/appbrand/ah/c:u	(Ljava/nio/ByteBuffer;)V
    //   177: goto -47 -> 130
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   185: invokevirtual 118	com/tencent/mm/plugin/appbrand/ah/c:cOf	()V
    //   188: return
    //   189: aload_0
    //   190: getfield 55	com/tencent/mm/plugin/appbrand/ah/a/a:cBb	Ljava/net/Socket;
    //   193: invokevirtual 452	java/net/Socket:isClosed	()Z
    //   196: ifeq -174 -> 22
    //   199: new 103	java/io/IOException
    //   202: dup
    //   203: invokespecial 453	java/io/IOException:<init>	()V
    //   206: athrow
    //   207: astore_2
    //   208: aload_0
    //   209: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   212: iconst_m1
    //   213: aload_2
    //   214: invokevirtual 456	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 459	com/tencent/mm/plugin/appbrand/ah/c:aM	(ILjava/lang/String;)V
    //   220: return
    //   221: aload_0
    //   222: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   225: invokevirtual 118	com/tencent/mm/plugin/appbrand/ah/c:cOf	()V
    //   228: return
    //   229: astore_2
    //   230: aload_0
    //   231: aload_2
    //   232: invokevirtual 112	com/tencent/mm/plugin/appbrand/ah/a/a:f	(Ljava/lang/Exception;)V
    //   235: aload_0
    //   236: getfield 53	com/tencent/mm/plugin/appbrand/ah/a/a:uuE	Lcom/tencent/mm/plugin/appbrand/ah/c;
    //   239: sipush 1006
    //   242: aload_2
    //   243: invokevirtual 460	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 459	com/tencent/mm/plugin/appbrand/ah/c:aM	(ILjava/lang/String;)V
    //   249: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	a
    //   158	13	1	i	int
    //   129	40	2	arrayOfByte	byte[]
    //   180	1	2	localIOException	IOException
    //   207	7	2	localException	Exception
    //   229	14	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   130	159	180	java/io/IOException
    //   164	177	180	java/io/IOException
    //   221	228	180	java/io/IOException
    //   0	22	207	java/lang/Exception
    //   22	72	207	java/lang/Exception
    //   72	98	207	java/lang/Exception
    //   189	207	207	java/lang/Exception
    //   130	159	229	java/lang/RuntimeException
    //   164	177	229	java/lang/RuntimeException
    //   221	228	229	java/lang/RuntimeException
  }
  
  public final void y(ByteBuffer paramByteBuffer)
  {
    o(paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.a.a
 * JD-Core Version:    0.7.0.1
 */