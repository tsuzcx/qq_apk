package com.tencent.mm.plugin.appbrand.ae.a;

import com.tencent.f.i;
import com.tencent.f.i.e;
import com.tencent.f.i.g;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.plugin.appbrand.ae.e.f;
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
  extends com.tencent.mm.plugin.appbrand.ae.b
  implements e, g, com.tencent.mm.plugin.appbrand.ae.a, Runnable
{
  private int connectTimeout = 0;
  private Future dBz;
  private Map<String, String> headers;
  private String jEY;
  private Timer mTimer = null;
  protected URI oiG = null;
  public c oiH = null;
  private InputStream oiI;
  OutputStream oiJ;
  private Proxy oiK = Proxy.NO_PROXY;
  private Runnable oiL;
  private CountDownLatch oiM = new CountDownLatch(1);
  private CountDownLatch oiN = new CountDownLatch(1);
  private com.tencent.mm.plugin.appbrand.ae.b.a oix;
  private Socket socket = null;
  
  public a(URI paramURI, com.tencent.mm.plugin.appbrand.ae.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.oiG = paramURI;
    this.oix = parama;
    this.headers = paramMap;
    this.connectTimeout = paramInt;
    this.oiH = new c(this, parama);
    this.oim = false;
  }
  
  private void bZB()
  {
    Object localObject2 = this.oiG.getRawPath();
    Object localObject3 = this.oiG.getRawQuery();
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
    localObject3 = new StringBuilder().append(this.oiG.getHost());
    if (i != 80) {}
    for (Object localObject1 = ":".concat(String.valueOf(i));; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.tencent.mm.plugin.appbrand.ae.e.d();
      ((com.tencent.mm.plugin.appbrand.ae.e.d)localObject1).afO((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.ae.e.d)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.mm.plugin.appbrand.ae.e.d)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.oiH;
    ((c)localObject2).oiB = ((c)localObject2).oix.a((com.tencent.mm.plugin.appbrand.ae.e.b)localObject1);
    ((c)localObject2).oiF = ((com.tencent.mm.plugin.appbrand.ae.e.b)localObject1).bZL();
    if (((c)localObject2).oiF != null) {}
    try
    {
      ((c)localObject2).oiv.b(((c)localObject2).oiB);
      ((c)localObject2).bV(com.tencent.mm.plugin.appbrand.ae.b.a.e(((c)localObject2).oiB));
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.ae.c.b localb)
    {
      throw new com.tencent.mm.plugin.appbrand.ae.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((c)localObject2).oiv.k(localRuntimeException);
      throw new com.tencent.mm.plugin.appbrand.ae.c.d("rejected because of".concat(String.valueOf(localRuntimeException)));
    }
  }
  
  private int getPort()
  {
    int j = this.oiG.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.oiG.getScheme();
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
  
  public abstract void XY(String paramString);
  
  public void a(com.tencent.mm.plugin.appbrand.ae.d.d paramd) {}
  
  public abstract void a(com.tencent.mm.plugin.appbrand.ae.e.h paramh);
  
  public final void a(Socket paramSocket)
  {
    if (this.socket != null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
      return;
    }
    this.socket = paramSocket;
  }
  
  public final void a(Timer paramTimer)
  {
    this.mTimer = paramTimer;
  }
  
  public final void a(Future paramFuture)
  {
    this.dBz = paramFuture;
  }
  
  public final void abA(String paramString)
  {
    this.oiH.abA(paramString);
  }
  
  public final void abz(String paramString)
  {
    this.jEY = paramString;
  }
  
  public abstract void af(int paramInt, String paramString);
  
  public final void afM(String paramString)
  {
    XY(paramString);
  }
  
  public final void ay(int paramInt, String paramString)
  {
    this.oiM.countDown();
    this.oiN.countDown();
    if (this.dBz != null) {
      this.dBz.cancel(false);
    }
    if ((this.oiL != null) && ((this.oiL instanceof a.a))) {
      ((a.a)this.oiL).isStop = true;
    }
    try
    {
      if (this.socket != null) {
        this.socket.close();
      }
      af(paramInt, paramString);
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
  
  public final void az(int paramInt, String paramString)
  {
    this.oiH.c(paramInt, paramString, false);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.ae.d.d paramd)
  {
    this.oiH.b(paramd);
  }
  
  public final Timer bLn()
  {
    return this.mTimer;
  }
  
  public final void bQ(String paramString, int paramInt)
  {
    if (this.oiL != null) {
      az(paramInt, paramString);
    }
  }
  
  public final String bjl()
  {
    return this.jEY;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.ae.d.d paramd)
  {
    a(paramd);
  }
  
  public final void close()
  {
    if (this.oiL != null) {
      this.oiH.c(1000, "", false);
    }
  }
  
  public final void connect()
  {
    if (this.oiL != null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.oiL = this;
    com.tencent.f.h.RTc.aX(this.oiL);
  }
  
  public final void d(f paramf)
  {
    this.oiM.countDown();
    a((com.tencent.mm.plugin.appbrand.ae.e.h)paramf);
  }
  
  public String getKey()
  {
    return "WebsocketWriteThread";
  }
  
  public final Socket getSocket()
  {
    return this.socket;
  }
  
  public final boolean isOpen()
  {
    return this.oiH.isOpen();
  }
  
  public final void k(Exception paramException)
  {
    onError(paramException);
  }
  
  public void l(ByteBuffer paramByteBuffer) {}
  
  public final void o(ByteBuffer paramByteBuffer)
  {
    this.oiH.o(paramByteBuffer);
  }
  
  public abstract void onError(Exception paramException);
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   4: ifnonnull +185 -> 189
    //   7: aload_0
    //   8: new 105	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 62	com/tencent/mm/plugin/appbrand/ae/a/a:oiK	Ljava/net/Proxy;
    //   16: invokespecial 376	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   26: aload_0
    //   27: getfield 96	com/tencent/mm/plugin/appbrand/ae/b:oim	Z
    //   30: invokevirtual 380	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   37: invokevirtual 383	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   47: new 385	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 51	com/tencent/mm/plugin/appbrand/ae/a/a:oiG	Ljava/net/URI;
    //   55: invokevirtual 158	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 155	com/tencent/mm/plugin/appbrand/ae/a/a:getPort	()I
    //   62: invokespecial 387	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 73	com/tencent/mm/plugin/appbrand/ae/a/a:connectTimeout	I
    //   69: invokevirtual 390	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   77: invokevirtual 394	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 396	com/tencent/mm/plugin/appbrand/ae/a/a:oiI	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   88: invokevirtual 400	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 402	com/tencent/mm/plugin/appbrand/ae/a/a:oiJ	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 404	com/tencent/mm/plugin/appbrand/ae/a/a:bZB	()V
    //   98: aload_0
    //   99: new 14	com/tencent/mm/plugin/appbrand/ae/a/a$a
    //   102: dup
    //   103: aload_0
    //   104: iconst_0
    //   105: invokespecial 407	com/tencent/mm/plugin/appbrand/ae/a/a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/ae/a/a;B)V
    //   108: putfield 316	com/tencent/mm/plugin/appbrand/ae/a/a:oiL	Ljava/lang/Runnable;
    //   111: getstatic 346	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   114: aload_0
    //   115: getfield 316	com/tencent/mm/plugin/appbrand/ae/a/a:oiL	Ljava/lang/Runnable;
    //   118: invokeinterface 352 2 0
    //   123: pop
    //   124: getstatic 410	com/tencent/mm/plugin/appbrand/ae/c:oin	I
    //   127: newarray byte
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   134: invokevirtual 413	com/tencent/mm/plugin/appbrand/ae/c:bZA	()Z
    //   137: ifne +84 -> 221
    //   140: aload_0
    //   141: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   144: invokevirtual 416	com/tencent/mm/plugin/appbrand/ae/c:isClosed	()Z
    //   147: ifne +74 -> 221
    //   150: aload_0
    //   151: getfield 396	com/tencent/mm/plugin/appbrand/ae/a/a:oiI	Ljava/io/InputStream;
    //   154: aload_2
    //   155: invokevirtual 422	java/io/InputStream:read	([B)I
    //   158: istore_1
    //   159: iload_1
    //   160: iconst_m1
    //   161: if_icmpeq +60 -> 221
    //   164: aload_0
    //   165: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   168: aload_2
    //   169: iconst_0
    //   170: iload_1
    //   171: invokestatic 428	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   174: invokevirtual 431	com/tencent/mm/plugin/appbrand/ae/c:r	(Ljava/nio/ByteBuffer;)V
    //   177: goto -47 -> 130
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   185: invokevirtual 118	com/tencent/mm/plugin/appbrand/ae/c:bZz	()V
    //   188: return
    //   189: aload_0
    //   190: getfield 55	com/tencent/mm/plugin/appbrand/ae/a/a:socket	Ljava/net/Socket;
    //   193: invokevirtual 432	java/net/Socket:isClosed	()Z
    //   196: ifeq -174 -> 22
    //   199: new 103	java/io/IOException
    //   202: dup
    //   203: invokespecial 433	java/io/IOException:<init>	()V
    //   206: athrow
    //   207: astore_2
    //   208: aload_0
    //   209: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   212: iconst_m1
    //   213: aload_2
    //   214: invokevirtual 436	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 439	com/tencent/mm/plugin/appbrand/ae/c:ax	(ILjava/lang/String;)V
    //   220: return
    //   221: aload_0
    //   222: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   225: invokevirtual 118	com/tencent/mm/plugin/appbrand/ae/c:bZz	()V
    //   228: return
    //   229: astore_2
    //   230: aload_0
    //   231: aload_2
    //   232: invokevirtual 112	com/tencent/mm/plugin/appbrand/ae/a/a:onError	(Ljava/lang/Exception;)V
    //   235: aload_0
    //   236: getfield 53	com/tencent/mm/plugin/appbrand/ae/a/a:oiH	Lcom/tencent/mm/plugin/appbrand/ae/c;
    //   239: sipush 1006
    //   242: aload_2
    //   243: invokevirtual 440	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 439	com/tencent/mm/plugin/appbrand/ae/c:ax	(ILjava/lang/String;)V
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
  
  public final void v(ByteBuffer paramByteBuffer)
  {
    l(paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a
 * JD-Core Version:    0.7.0.1
 */