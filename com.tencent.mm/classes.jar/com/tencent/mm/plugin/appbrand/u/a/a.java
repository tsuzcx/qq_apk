package com.tencent.mm.plugin.appbrand.u.a;

import com.tencent.mm.plugin.appbrand.u.c;
import com.tencent.mm.plugin.appbrand.u.e.f;
import com.tencent.mm.plugin.appbrand.u.e.h;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.platformtools.ab;
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
  extends com.tencent.mm.plugin.appbrand.u.b
  implements com.tencent.mm.plugin.appbrand.u.a, Runnable
{
  private Map<String, String> headers;
  private String hwp;
  private com.tencent.mm.plugin.appbrand.u.b.a iYS;
  protected URI iZb = null;
  public c iZc = null;
  private Socket iZd = null;
  private InputStream iZe;
  OutputStream iZf;
  private Proxy iZg = Proxy.NO_PROXY;
  private Runnable iZh;
  private CountDownLatch iZi = new CountDownLatch(1);
  private CountDownLatch iZj = new CountDownLatch(1);
  private int iZk = 0;
  private Timer mTimer = null;
  
  public a(URI paramURI, com.tencent.mm.plugin.appbrand.u.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.iZb = paramURI;
    this.iYS = parama;
    this.headers = paramMap;
    this.iZk = paramInt;
    this.iZc = new c(this, parama);
    this.iYH = false;
  }
  
  private void aOf()
  {
    Object localObject2 = this.iZb.getRawPath();
    Object localObject3 = this.iZb.getRawQuery();
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
    localObject3 = new StringBuilder().append(this.iZb.getHost());
    if (i != 80) {}
    for (Object localObject1 = ":".concat(String.valueOf(i));; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.tencent.mm.plugin.appbrand.u.e.d();
      ((com.tencent.mm.plugin.appbrand.u.e.d)localObject1).Fw((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.u.e.d)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.mm.plugin.appbrand.u.e.d)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.iZc;
    ((c)localObject2).iYW = ((c)localObject2).iYS.a((com.tencent.mm.plugin.appbrand.u.e.b)localObject1);
    ((c)localObject2).iZa = ((com.tencent.mm.plugin.appbrand.u.e.b)localObject1).aOp();
    if (((c)localObject2).iZa != null) {}
    try
    {
      ((c)localObject2).iYQ.b(((c)localObject2).iYW);
      ((c)localObject2).aN(com.tencent.mm.plugin.appbrand.u.b.a.e(((c)localObject2).iYW));
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.u.c.b localb)
    {
      throw new com.tencent.mm.plugin.appbrand.u.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((c)localObject2).iYQ.d(localRuntimeException);
      throw new com.tencent.mm.plugin.appbrand.u.c.d("rejected because of".concat(String.valueOf(localRuntimeException)));
    }
  }
  
  private int getPort()
  {
    int j = this.iZb.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.iZb.getScheme();
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
  
  public abstract void AR(String paramString);
  
  public final void CY(String paramString)
  {
    this.hwp = paramString;
  }
  
  public final void CZ(String paramString)
  {
    this.iZc.CZ(paramString);
  }
  
  public final void Fu(String paramString)
  {
    AR(paramString);
  }
  
  public abstract void P(int paramInt, String paramString);
  
  public void a(com.tencent.mm.plugin.appbrand.u.d.d paramd) {}
  
  public abstract void a(h paramh);
  
  public final void a(Socket paramSocket)
  {
    if (this.iZd != null)
    {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
      return;
    }
    this.iZd = paramSocket;
  }
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final String aAR()
  {
    return this.hwp;
  }
  
  public final Timer aGh()
  {
    return this.mTimer;
  }
  
  public final void ag(int paramInt, String paramString)
  {
    this.iZi.countDown();
    this.iZj.countDown();
    com.tencent.mm.sdk.g.d.ysm.remove(this.iZh);
    if ((this.iZh != null) && ((this.iZh instanceof a.a))) {
      ((a.a)this.iZh).isStop = true;
    }
    try
    {
      if (this.iZd != null) {
        this.iZd.close();
      }
      P(paramInt, paramString);
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
  
  public final void ah(int paramInt, String paramString)
  {
    this.iZc.d(paramInt, paramString, false);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.u.d.d paramd)
  {
    this.iZc.b(paramd);
  }
  
  public final void bj(String paramString, int paramInt)
  {
    if (this.iZh != null) {
      ah(paramInt, paramString);
    }
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.u.d.d paramd)
  {
    a(paramd);
  }
  
  public final void close()
  {
    if (this.iZh != null) {
      this.iZc.d(1000, "", false);
    }
  }
  
  public final void connect()
  {
    if (this.iZh != null)
    {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.iZh = this;
    com.tencent.mm.sdk.g.d.post(this.iZh, "WebsocketWriteThread");
  }
  
  public final void d(f paramf)
  {
    this.iZi.countDown();
    a((h)paramf);
  }
  
  public final void d(Exception paramException)
  {
    onError(paramException);
  }
  
  public final Socket getSocket()
  {
    return this.iZd;
  }
  
  public void i(ByteBuffer paramByteBuffer) {}
  
  public final boolean isOpen()
  {
    return this.iZc.isOpen();
  }
  
  public final void l(ByteBuffer paramByteBuffer)
  {
    this.iZc.l(paramByteBuffer);
  }
  
  public abstract void onError(Exception paramException);
  
  public final void r(ByteBuffer paramByteBuffer)
  {
    i(paramByteBuffer);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   4: ifnonnull +182 -> 186
    //   7: aload_0
    //   8: new 99	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 56	com/tencent/mm/plugin/appbrand/u/a/a:iZg	Ljava/net/Proxy;
    //   16: invokespecial 366	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   26: aload_0
    //   27: getfield 90	com/tencent/mm/plugin/appbrand/u/b:iYH	Z
    //   30: invokevirtual 370	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   37: invokevirtual 373	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   47: new 375	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 45	com/tencent/mm/plugin/appbrand/u/a/a:iZb	Ljava/net/URI;
    //   55: invokevirtual 152	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 149	com/tencent/mm/plugin/appbrand/u/a/a:getPort	()I
    //   62: invokespecial 377	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 67	com/tencent/mm/plugin/appbrand/u/a/a:iZk	I
    //   69: invokevirtual 380	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   77: invokevirtual 384	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 386	com/tencent/mm/plugin/appbrand/u/a/a:iZe	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   88: invokevirtual 390	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 392	com/tencent/mm/plugin/appbrand/u/a/a:iZf	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 394	com/tencent/mm/plugin/appbrand/u/a/a:aOf	()V
    //   98: aload_0
    //   99: new 10	com/tencent/mm/plugin/appbrand/u/a/a$a
    //   102: dup
    //   103: aload_0
    //   104: iconst_0
    //   105: invokespecial 397	com/tencent/mm/plugin/appbrand/u/a/a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/u/a/a;B)V
    //   108: putfield 310	com/tencent/mm/plugin/appbrand/u/a/a:iZh	Ljava/lang/Runnable;
    //   111: aload_0
    //   112: getfield 310	com/tencent/mm/plugin/appbrand/u/a/a:iZh	Ljava/lang/Runnable;
    //   115: ldc_w 339
    //   118: invokestatic 343	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   121: getstatic 400	com/tencent/mm/plugin/appbrand/u/c:iYI	I
    //   124: newarray byte
    //   126: astore_2
    //   127: aload_0
    //   128: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   131: invokevirtual 403	com/tencent/mm/plugin/appbrand/u/c:aOe	()Z
    //   134: ifne +84 -> 218
    //   137: aload_0
    //   138: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   141: invokevirtual 406	com/tencent/mm/plugin/appbrand/u/c:isClosed	()Z
    //   144: ifne +74 -> 218
    //   147: aload_0
    //   148: getfield 386	com/tencent/mm/plugin/appbrand/u/a/a:iZe	Ljava/io/InputStream;
    //   151: aload_2
    //   152: invokevirtual 412	java/io/InputStream:read	([B)I
    //   155: istore_1
    //   156: iload_1
    //   157: iconst_m1
    //   158: if_icmpeq +60 -> 218
    //   161: aload_0
    //   162: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   165: aload_2
    //   166: iconst_0
    //   167: iload_1
    //   168: invokestatic 418	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   171: invokevirtual 421	com/tencent/mm/plugin/appbrand/u/c:n	(Ljava/nio/ByteBuffer;)V
    //   174: goto -47 -> 127
    //   177: astore_2
    //   178: aload_0
    //   179: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   182: invokevirtual 112	com/tencent/mm/plugin/appbrand/u/c:aOd	()V
    //   185: return
    //   186: aload_0
    //   187: getfield 49	com/tencent/mm/plugin/appbrand/u/a/a:iZd	Ljava/net/Socket;
    //   190: invokevirtual 422	java/net/Socket:isClosed	()Z
    //   193: ifeq -171 -> 22
    //   196: new 97	java/io/IOException
    //   199: dup
    //   200: invokespecial 423	java/io/IOException:<init>	()V
    //   203: athrow
    //   204: astore_2
    //   205: aload_0
    //   206: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   209: iconst_m1
    //   210: aload_2
    //   211: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   214: invokevirtual 429	com/tencent/mm/plugin/appbrand/u/c:af	(ILjava/lang/String;)V
    //   217: return
    //   218: aload_0
    //   219: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   222: invokevirtual 112	com/tencent/mm/plugin/appbrand/u/c:aOd	()V
    //   225: return
    //   226: astore_2
    //   227: aload_0
    //   228: aload_2
    //   229: invokevirtual 106	com/tencent/mm/plugin/appbrand/u/a/a:onError	(Ljava/lang/Exception;)V
    //   232: aload_0
    //   233: getfield 47	com/tencent/mm/plugin/appbrand/u/a/a:iZc	Lcom/tencent/mm/plugin/appbrand/u/c;
    //   236: sipush 1006
    //   239: aload_2
    //   240: invokevirtual 430	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 429	com/tencent/mm/plugin/appbrand/u/c:af	(ILjava/lang/String;)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a.a
 * JD-Core Version:    0.7.0.1
 */