package com.tencent.mm.plugin.appbrand.af.a;

import com.tencent.e.i;
import com.tencent.e.i.e;
import com.tencent.e.i.g;
import com.tencent.mm.plugin.appbrand.af.a.b;
import com.tencent.mm.plugin.appbrand.af.c;
import com.tencent.mm.plugin.appbrand.af.e.f;
import com.tencent.mm.sdk.platformtools.Log;
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
  extends com.tencent.mm.plugin.appbrand.af.b
  implements e, g, com.tencent.mm.plugin.appbrand.af.a, Runnable
{
  private Socket aFp = null;
  private int connectTimeout = 0;
  private Future fuk;
  private Map<String, String> headers;
  private Timer mTimer = null;
  private String mvB;
  private com.tencent.mm.plugin.appbrand.af.b.a rkL;
  protected URI rkU = null;
  public c rkV = null;
  private InputStream rkW;
  OutputStream rkX;
  private Proxy rkY = Proxy.NO_PROXY;
  private Runnable rkZ;
  private CountDownLatch rla = new CountDownLatch(1);
  private CountDownLatch rlb = new CountDownLatch(1);
  
  public a(URI paramURI, com.tencent.mm.plugin.appbrand.af.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.rkU = paramURI;
    this.rkL = parama;
    this.headers = paramMap;
    this.connectTimeout = paramInt;
    this.rkV = new c(this, parama);
    setTcpNoDelay(false);
  }
  
  private void cmw()
  {
    Object localObject2 = this.rkU.getRawPath();
    Object localObject3 = this.rkU.getRawQuery();
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
    localObject3 = new StringBuilder().append(this.rkU.getHost());
    if (i != 80) {}
    for (Object localObject1 = ":".concat(String.valueOf(i));; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.tencent.mm.plugin.appbrand.af.e.d();
      ((com.tencent.mm.plugin.appbrand.af.e.d)localObject1).ant((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.af.e.d)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.mm.plugin.appbrand.af.e.d)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.rkV;
    ((c)localObject2).rkP = ((c)localObject2).rkL.a((com.tencent.mm.plugin.appbrand.af.e.b)localObject1);
    ((c)localObject2).rkT = ((com.tencent.mm.plugin.appbrand.af.e.b)localObject1).cmG();
    if (((c)localObject2).rkT != null) {}
    try
    {
      ((c)localObject2).rkJ.b(((c)localObject2).rkP);
      ((c)localObject2).bT(com.tencent.mm.plugin.appbrand.af.b.a.e(((c)localObject2).rkP));
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.af.c.b localb)
    {
      throw new com.tencent.mm.plugin.appbrand.af.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((c)localObject2).rkJ.j(localRuntimeException);
      throw new com.tencent.mm.plugin.appbrand.af.c.d("rejected because of".concat(String.valueOf(localRuntimeException)));
    }
  }
  
  private int getPort()
  {
    int j = this.rkU.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.rkU.getScheme();
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
  
  public void a(com.tencent.mm.plugin.appbrand.af.d.d paramd) {}
  
  public abstract void a(com.tencent.mm.plugin.appbrand.af.e.h paramh);
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final void a(Future paramFuture)
  {
    this.fuk = paramFuture;
  }
  
  public final void aA(int paramInt, String paramString)
  {
    this.rla.countDown();
    this.rlb.countDown();
    if (this.fuk != null) {
      this.fuk.cancel(false);
    }
    if ((this.rkZ != null) && ((this.rkZ instanceof a.a))) {
      ((a.a)this.rkZ).isStop = true;
    }
    try
    {
      if (this.aFp != null) {
        this.aFp.close();
      }
      ah(paramInt, paramString);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        onError(localIOException);
      }
    }
  }
  
  public final void aB(int paramInt, String paramString)
  {
    this.rkV.c(paramInt, paramString, false);
  }
  
  public abstract void afL(String paramString);
  
  public abstract void ah(int paramInt, String paramString);
  
  public final void ajt(String paramString)
  {
    this.mvB = paramString;
  }
  
  public final void aju(String paramString)
  {
    c localc = this.rkV;
    if (paramString == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      return;
    }
    com.tencent.mm.plugin.appbrand.af.b.a locala = localc.rkL;
    if (localc.rkM == a.b.rkx) {}
    for (boolean bool = true;; bool = false)
    {
      localc.g(locala.aH(paramString, bool));
      return;
    }
  }
  
  public final void anr(String paramString)
  {
    afL(paramString);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.af.d.d paramd)
  {
    this.rkV.b(paramd);
  }
  
  public final void b(Socket paramSocket)
  {
    if (this.aFp != null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
      return;
    }
    this.aFp = paramSocket;
  }
  
  public final Timer bXn()
  {
    return this.mTimer;
  }
  
  public final Socket bXo()
  {
    return this.aFp;
  }
  
  public final String bsL()
  {
    return this.mvB;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.af.d.d paramd)
  {
    a(paramd);
  }
  
  public final void close()
  {
    if (this.rkZ != null) {
      this.rkV.c(1000, "", false);
    }
  }
  
  public final void cn(String paramString, int paramInt)
  {
    if (this.rkZ != null) {
      aB(paramInt, paramString);
    }
  }
  
  public final void connect()
  {
    if (this.rkZ != null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.rkZ = this;
    com.tencent.e.h.ZvG.be(this.rkZ);
  }
  
  public final void d(f paramf)
  {
    this.rla.countDown();
    a((com.tencent.mm.plugin.appbrand.af.e.h)paramf);
  }
  
  public String getKey()
  {
    return "WebsocketWriteThread";
  }
  
  public void i(ByteBuffer paramByteBuffer) {}
  
  public final boolean isOpen()
  {
    return this.rkV.isOpen();
  }
  
  public final void j(Exception paramException)
  {
    onError(paramException);
  }
  
  public final void l(ByteBuffer paramByteBuffer)
  {
    this.rkV.l(paramByteBuffer);
  }
  
  public abstract void onError(Exception paramException);
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   4: ifnonnull +185 -> 189
    //   7: aload_0
    //   8: new 105	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 62	com/tencent/mm/plugin/appbrand/af/a/a:rkY	Ljava/net/Proxy;
    //   16: invokespecial 395	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   26: aload_0
    //   27: invokevirtual 398	com/tencent/mm/plugin/appbrand/af/a/a:cmt	()Z
    //   30: invokevirtual 399	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   37: invokevirtual 402	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   47: new 404	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 51	com/tencent/mm/plugin/appbrand/af/a/a:rkU	Ljava/net/URI;
    //   55: invokevirtual 158	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 155	com/tencent/mm/plugin/appbrand/af/a/a:getPort	()I
    //   62: invokespecial 406	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 73	com/tencent/mm/plugin/appbrand/af/a/a:connectTimeout	I
    //   69: invokevirtual 409	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   77: invokevirtual 413	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 415	com/tencent/mm/plugin/appbrand/af/a/a:rkW	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   88: invokevirtual 419	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 421	com/tencent/mm/plugin/appbrand/af/a/a:rkX	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 423	com/tencent/mm/plugin/appbrand/af/a/a:cmw	()V
    //   98: aload_0
    //   99: new 14	com/tencent/mm/plugin/appbrand/af/a/a$a
    //   102: dup
    //   103: aload_0
    //   104: iconst_0
    //   105: invokespecial 426	com/tencent/mm/plugin/appbrand/af/a/a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/af/a/a;B)V
    //   108: putfield 295	com/tencent/mm/plugin/appbrand/af/a/a:rkZ	Ljava/lang/Runnable;
    //   111: getstatic 368	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   114: aload_0
    //   115: getfield 295	com/tencent/mm/plugin/appbrand/af/a/a:rkZ	Ljava/lang/Runnable;
    //   118: invokeinterface 374 2 0
    //   123: pop
    //   124: getstatic 429	com/tencent/mm/plugin/appbrand/af/c:rkB	I
    //   127: newarray byte
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   134: invokevirtual 432	com/tencent/mm/plugin/appbrand/af/c:cmv	()Z
    //   137: ifne +84 -> 221
    //   140: aload_0
    //   141: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   144: invokevirtual 435	com/tencent/mm/plugin/appbrand/af/c:isClosed	()Z
    //   147: ifne +74 -> 221
    //   150: aload_0
    //   151: getfield 415	com/tencent/mm/plugin/appbrand/af/a/a:rkW	Ljava/io/InputStream;
    //   154: aload_2
    //   155: invokevirtual 441	java/io/InputStream:read	([B)I
    //   158: istore_1
    //   159: iload_1
    //   160: iconst_m1
    //   161: if_icmpeq +60 -> 221
    //   164: aload_0
    //   165: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   168: aload_2
    //   169: iconst_0
    //   170: iload_1
    //   171: invokestatic 447	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   174: invokevirtual 450	com/tencent/mm/plugin/appbrand/af/c:o	(Ljava/nio/ByteBuffer;)V
    //   177: goto -47 -> 130
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   185: invokevirtual 118	com/tencent/mm/plugin/appbrand/af/c:cmu	()V
    //   188: return
    //   189: aload_0
    //   190: getfield 55	com/tencent/mm/plugin/appbrand/af/a/a:aFp	Ljava/net/Socket;
    //   193: invokevirtual 451	java/net/Socket:isClosed	()Z
    //   196: ifeq -174 -> 22
    //   199: new 103	java/io/IOException
    //   202: dup
    //   203: invokespecial 452	java/io/IOException:<init>	()V
    //   206: athrow
    //   207: astore_2
    //   208: aload_0
    //   209: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   212: iconst_m1
    //   213: aload_2
    //   214: invokevirtual 455	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 458	com/tencent/mm/plugin/appbrand/af/c:az	(ILjava/lang/String;)V
    //   220: return
    //   221: aload_0
    //   222: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   225: invokevirtual 118	com/tencent/mm/plugin/appbrand/af/c:cmu	()V
    //   228: return
    //   229: astore_2
    //   230: aload_0
    //   231: aload_2
    //   232: invokevirtual 112	com/tencent/mm/plugin/appbrand/af/a/a:onError	(Ljava/lang/Exception;)V
    //   235: aload_0
    //   236: getfield 53	com/tencent/mm/plugin/appbrand/af/a/a:rkV	Lcom/tencent/mm/plugin/appbrand/af/c;
    //   239: sipush 1006
    //   242: aload_2
    //   243: invokevirtual 459	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 458	com/tencent/mm/plugin/appbrand/af/c:az	(ILjava/lang/String;)V
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
  
  public final void s(ByteBuffer paramByteBuffer)
  {
    i(paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.a.a
 * JD-Core Version:    0.7.0.1
 */