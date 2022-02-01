package com.tencent.mm.plugin.appbrand.z.a;

import com.tencent.e.i;
import com.tencent.e.i.e;
import com.tencent.e.i.g;
import com.tencent.mm.plugin.appbrand.z.c;
import com.tencent.mm.plugin.appbrand.z.e.f;
import com.tencent.mm.sdk.platformtools.ae;
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
  extends com.tencent.mm.plugin.appbrand.z.b
  implements e, g, com.tencent.mm.plugin.appbrand.z.a, Runnable
{
  private Future dkp;
  private Map<String, String> headers;
  private String iIu;
  private Timer mTimer = null;
  protected URI mVG = null;
  public c mVH = null;
  private InputStream mVI;
  OutputStream mVJ;
  private Proxy mVK = Proxy.NO_PROXY;
  private Runnable mVL;
  private CountDownLatch mVM = new CountDownLatch(1);
  private CountDownLatch mVN = new CountDownLatch(1);
  private int mVO = 0;
  private com.tencent.mm.plugin.appbrand.z.b.a mVx;
  private Socket socket = null;
  
  public a(URI paramURI, com.tencent.mm.plugin.appbrand.z.b.a parama, Map<String, String> paramMap, int paramInt)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (parama == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.mVG = paramURI;
    this.mVx = parama;
    this.headers = paramMap;
    this.mVO = paramInt;
    this.mVH = new c(this, parama);
    this.mVm = false;
  }
  
  private void bCx()
  {
    Object localObject2 = this.mVG.getRawPath();
    Object localObject3 = this.mVG.getRawQuery();
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
    localObject3 = new StringBuilder().append(this.mVG.getHost());
    if (i != 80) {}
    for (Object localObject1 = ":".concat(String.valueOf(i));; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new com.tencent.mm.plugin.appbrand.z.e.d();
      ((com.tencent.mm.plugin.appbrand.z.e.d)localObject1).VS((String)localObject2);
      ((com.tencent.mm.plugin.appbrand.z.e.d)localObject1).put("Host", (String)localObject3);
      if (this.headers == null) {
        break;
      }
      localObject2 = this.headers.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((com.tencent.mm.plugin.appbrand.z.e.d)localObject1).put((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.mVH;
    ((c)localObject2).mVB = ((c)localObject2).mVx.a((com.tencent.mm.plugin.appbrand.z.e.b)localObject1);
    ((c)localObject2).mVF = ((com.tencent.mm.plugin.appbrand.z.e.b)localObject1).bCH();
    if (((c)localObject2).mVF != null) {}
    try
    {
      ((c)localObject2).mVv.b(((c)localObject2).mVB);
      ((c)localObject2).bI(com.tencent.mm.plugin.appbrand.z.b.a.e(((c)localObject2).mVB));
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.z.c.b localb)
    {
      throw new com.tencent.mm.plugin.appbrand.z.c.d("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((c)localObject2).mVv.k(localRuntimeException);
      throw new com.tencent.mm.plugin.appbrand.z.c.d("rejected because of".concat(String.valueOf(localRuntimeException)));
    }
  }
  
  private int getPort()
  {
    int j = this.mVG.getPort();
    int i = j;
    String str;
    if (j == -1)
    {
      str = this.mVG.getScheme();
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
  
  public abstract void ON(String paramString);
  
  public final void RU(String paramString)
  {
    this.iIu = paramString;
  }
  
  public final void RV(String paramString)
  {
    this.mVH.RV(paramString);
  }
  
  public final void VQ(String paramString)
  {
    ON(paramString);
  }
  
  public void a(com.tencent.mm.plugin.appbrand.z.d.d paramd) {}
  
  public abstract void a(com.tencent.mm.plugin.appbrand.z.e.h paramh);
  
  public final void a(Socket paramSocket)
  {
    if (this.socket != null)
    {
      ae.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
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
    this.dkp = paramFuture;
  }
  
  public final String aOZ()
  {
    return this.iIu;
  }
  
  public abstract void ab(int paramInt, String paramString);
  
  public final void av(int paramInt, String paramString)
  {
    this.mVM.countDown();
    this.mVN.countDown();
    if (this.dkp != null) {
      this.dkp.cancel(false);
    }
    if ((this.mVL != null) && ((this.mVL instanceof a))) {
      ((a)this.mVL).isStop = true;
    }
    try
    {
      if (this.socket != null) {
        this.socket.close();
      }
      ab(paramInt, paramString);
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
  
  public final void aw(int paramInt, String paramString)
  {
    this.mVH.c(paramInt, paramString, false);
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.z.d.d paramd)
  {
    this.mVH.b(paramd);
  }
  
  public final void bL(String paramString, int paramInt)
  {
    if (this.mVL != null) {
      aw(paramInt, paramString);
    }
  }
  
  public final Timer bpH()
  {
    return this.mTimer;
  }
  
  public final void c(com.tencent.mm.plugin.appbrand.z.d.d paramd)
  {
    a(paramd);
  }
  
  public final void close()
  {
    if (this.mVL != null) {
      this.mVH.c(1000, "", false);
    }
  }
  
  public final void connect()
  {
    if (this.mVL != null)
    {
      ae.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
      return;
    }
    this.mVL = this;
    com.tencent.e.h.MqF.aO(this.mVL);
  }
  
  public final void d(f paramf)
  {
    this.mVM.countDown();
    a((com.tencent.mm.plugin.appbrand.z.e.h)paramf);
  }
  
  public final String getKey()
  {
    return "WebsocketWriteThread";
  }
  
  public final Socket getSocket()
  {
    return this.socket;
  }
  
  public final boolean isOpen()
  {
    return this.mVH.isOpen();
  }
  
  public final void k(Exception paramException)
  {
    onError(paramException);
  }
  
  public void l(ByteBuffer paramByteBuffer) {}
  
  public final void o(ByteBuffer paramByteBuffer)
  {
    this.mVH.o(paramByteBuffer);
  }
  
  public abstract void onError(Exception paramException);
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   4: ifnonnull +185 -> 189
    //   7: aload_0
    //   8: new 105	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 63	com/tencent/mm/plugin/appbrand/z/a/a:mVK	Ljava/net/Proxy;
    //   16: invokespecial 376	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   26: aload_0
    //   27: getfield 97	com/tencent/mm/plugin/appbrand/z/b:mVm	Z
    //   30: invokevirtual 380	java/net/Socket:setTcpNoDelay	(Z)V
    //   33: aload_0
    //   34: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   37: invokevirtual 383	java/net/Socket:isBound	()Z
    //   40: ifne +32 -> 72
    //   43: aload_0
    //   44: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   47: new 385	java/net/InetSocketAddress
    //   50: dup
    //   51: aload_0
    //   52: getfield 52	com/tencent/mm/plugin/appbrand/z/a/a:mVG	Ljava/net/URI;
    //   55: invokevirtual 158	java/net/URI:getHost	()Ljava/lang/String;
    //   58: aload_0
    //   59: invokespecial 155	com/tencent/mm/plugin/appbrand/z/a/a:getPort	()I
    //   62: invokespecial 387	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   65: aload_0
    //   66: getfield 74	com/tencent/mm/plugin/appbrand/z/a/a:mVO	I
    //   69: invokevirtual 390	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   77: invokevirtual 394	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   80: putfield 396	com/tencent/mm/plugin/appbrand/z/a/a:mVI	Ljava/io/InputStream;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   88: invokevirtual 400	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   91: putfield 402	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
    //   94: aload_0
    //   95: invokespecial 404	com/tencent/mm/plugin/appbrand/z/a/a:bCx	()V
    //   98: aload_0
    //   99: new 14	com/tencent/mm/plugin/appbrand/z/a/a$a
    //   102: dup
    //   103: aload_0
    //   104: iconst_0
    //   105: invokespecial 407	com/tencent/mm/plugin/appbrand/z/a/a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/z/a/a;B)V
    //   108: putfield 317	com/tencent/mm/plugin/appbrand/z/a/a:mVL	Ljava/lang/Runnable;
    //   111: getstatic 346	com/tencent/e/h:MqF	Lcom/tencent/e/i;
    //   114: aload_0
    //   115: getfield 317	com/tencent/mm/plugin/appbrand/z/a/a:mVL	Ljava/lang/Runnable;
    //   118: invokeinterface 352 2 0
    //   123: pop
    //   124: getstatic 410	com/tencent/mm/plugin/appbrand/z/c:mVn	I
    //   127: newarray byte
    //   129: astore_2
    //   130: aload_0
    //   131: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   134: invokevirtual 413	com/tencent/mm/plugin/appbrand/z/c:bCw	()Z
    //   137: ifne +84 -> 221
    //   140: aload_0
    //   141: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   144: invokevirtual 416	com/tencent/mm/plugin/appbrand/z/c:isClosed	()Z
    //   147: ifne +74 -> 221
    //   150: aload_0
    //   151: getfield 396	com/tencent/mm/plugin/appbrand/z/a/a:mVI	Ljava/io/InputStream;
    //   154: aload_2
    //   155: invokevirtual 422	java/io/InputStream:read	([B)I
    //   158: istore_1
    //   159: iload_1
    //   160: iconst_m1
    //   161: if_icmpeq +60 -> 221
    //   164: aload_0
    //   165: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   168: aload_2
    //   169: iconst_0
    //   170: iload_1
    //   171: invokestatic 428	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   174: invokevirtual 431	com/tencent/mm/plugin/appbrand/z/c:r	(Ljava/nio/ByteBuffer;)V
    //   177: goto -47 -> 130
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   185: invokevirtual 118	com/tencent/mm/plugin/appbrand/z/c:bCv	()V
    //   188: return
    //   189: aload_0
    //   190: getfield 56	com/tencent/mm/plugin/appbrand/z/a/a:socket	Ljava/net/Socket;
    //   193: invokevirtual 432	java/net/Socket:isClosed	()Z
    //   196: ifeq -174 -> 22
    //   199: new 103	java/io/IOException
    //   202: dup
    //   203: invokespecial 433	java/io/IOException:<init>	()V
    //   206: athrow
    //   207: astore_2
    //   208: aload_0
    //   209: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   212: iconst_m1
    //   213: aload_2
    //   214: invokevirtual 436	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 439	com/tencent/mm/plugin/appbrand/z/c:au	(ILjava/lang/String;)V
    //   220: return
    //   221: aload_0
    //   222: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   225: invokevirtual 118	com/tencent/mm/plugin/appbrand/z/c:bCv	()V
    //   228: return
    //   229: astore_2
    //   230: aload_0
    //   231: aload_2
    //   232: invokevirtual 112	com/tencent/mm/plugin/appbrand/z/a/a:onError	(Ljava/lang/Exception;)V
    //   235: aload_0
    //   236: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
    //   239: sipush 1006
    //   242: aload_2
    //   243: invokevirtual 440	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 439	com/tencent/mm/plugin/appbrand/z/c:au	(ILjava/lang/String;)V
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
  
  final class a
    implements com.tencent.e.i.h
  {
    volatile boolean isStop = false;
    
    private a() {}
    
    public final String getKey()
    {
      return "WebsocketWriteThread";
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 38
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 22	com/tencent/mm/plugin/appbrand/z/a/a$a:isStop	Z
      //   9: ifne +218 -> 227
      //   12: invokestatic 50	java/lang/Thread:interrupted	()Z
      //   15: ifne +212 -> 227
      //   18: aload_0
      //   19: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   22: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
      //   25: getfield 60	com/tencent/mm/plugin/appbrand/z/c:mVr	Ljava/util/concurrent/BlockingQueue;
      //   28: invokeinterface 65 1 0
      //   33: ifne +189 -> 222
      //   36: iconst_1
      //   37: istore_1
      //   38: iload_1
      //   39: ifeq -34 -> 5
      //   42: aload_0
      //   43: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   46: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
      //   49: getfield 60	com/tencent/mm/plugin/appbrand/z/c:mVr	Ljava/util/concurrent/BlockingQueue;
      //   52: ldc2_w 66
      //   55: getstatic 73	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   58: invokeinterface 77 4 0
      //   63: checkcast 79	java/nio/ByteBuffer
      //   66: astore_2
      //   67: aload_2
      //   68: ifnull -63 -> 5
      //   71: aload_0
      //   72: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   75: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   78: aload_2
      //   79: invokevirtual 87	java/nio/ByteBuffer:array	()[B
      //   82: iconst_0
      //   83: aload_2
      //   84: invokevirtual 91	java/nio/ByteBuffer:limit	()I
      //   87: invokevirtual 97	java/io/OutputStream:write	([BII)V
      //   90: aload_0
      //   91: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   94: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   97: invokevirtual 100	java/io/OutputStream:flush	()V
      //   100: goto -95 -> 5
      //   103: astore_2
      //   104: aload_0
      //   105: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   108: getfield 54	com/tencent/mm/plugin/appbrand/z/a/a:mVH	Lcom/tencent/mm/plugin/appbrand/z/c;
      //   111: getfield 60	com/tencent/mm/plugin/appbrand/z/c:mVr	Ljava/util/concurrent/BlockingQueue;
      //   114: invokeinterface 104 1 0
      //   119: astore_2
      //   120: aload_2
      //   121: invokeinterface 109 1 0
      //   126: ifeq +101 -> 227
      //   129: aload_2
      //   130: invokeinterface 113 1 0
      //   135: checkcast 79	java/nio/ByteBuffer
      //   138: astore_3
      //   139: aload_0
      //   140: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   143: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   146: aload_3
      //   147: invokevirtual 87	java/nio/ByteBuffer:array	()[B
      //   150: iconst_0
      //   151: aload_3
      //   152: invokevirtual 91	java/nio/ByteBuffer:limit	()I
      //   155: invokevirtual 97	java/io/OutputStream:write	([BII)V
      //   158: aload_0
      //   159: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   162: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   165: invokevirtual 100	java/io/OutputStream:flush	()V
      //   168: goto -48 -> 120
      //   171: astore_2
      //   172: aload_0
      //   173: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   176: aload_2
      //   177: invokestatic 116	com/tencent/mm/plugin/appbrand/z/a/a:a	(Lcom/tencent/mm/plugin/appbrand/z/a/a;Ljava/lang/Exception;)V
      //   180: ldc 118
      //   182: aload_2
      //   183: ldc 120
      //   185: iconst_0
      //   186: anewarray 4	java/lang/Object
      //   189: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   192: ldc 118
      //   194: ldc 128
      //   196: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   199: aload_0
      //   200: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   203: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   206: invokevirtual 135	java/io/OutputStream:close	()V
      //   209: aload_0
      //   210: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   213: invokestatic 137	com/tencent/mm/plugin/appbrand/z/a/a:a	(Lcom/tencent/mm/plugin/appbrand/z/a/a;)V
      //   216: ldc 38
      //   218: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: return
      //   222: iconst_0
      //   223: istore_1
      //   224: goto -186 -> 38
      //   227: ldc 118
      //   229: ldc 128
      //   231: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   234: aload_0
      //   235: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   238: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   241: invokevirtual 135	java/io/OutputStream:close	()V
      //   244: aload_0
      //   245: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   248: invokestatic 137	com/tencent/mm/plugin/appbrand/z/a/a:a	(Lcom/tencent/mm/plugin/appbrand/z/a/a;)V
      //   251: ldc 38
      //   253: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   256: return
      //   257: astore_2
      //   258: aload_0
      //   259: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   262: aload_2
      //   263: invokestatic 116	com/tencent/mm/plugin/appbrand/z/a/a:a	(Lcom/tencent/mm/plugin/appbrand/z/a/a;Ljava/lang/Exception;)V
      //   266: ldc 118
      //   268: aload_2
      //   269: ldc 142
      //   271: iconst_0
      //   272: anewarray 4	java/lang/Object
      //   275: invokestatic 126	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   278: ldc 118
      //   280: ldc 128
      //   282: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   285: aload_0
      //   286: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   289: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   292: invokevirtual 135	java/io/OutputStream:close	()V
      //   295: aload_0
      //   296: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   299: invokestatic 137	com/tencent/mm/plugin/appbrand/z/a/a:a	(Lcom/tencent/mm/plugin/appbrand/z/a/a;)V
      //   302: ldc 38
      //   304: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   307: return
      //   308: astore_2
      //   309: ldc 118
      //   311: ldc 128
      //   313: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   316: aload_0
      //   317: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   320: getfield 83	com/tencent/mm/plugin/appbrand/z/a/a:mVJ	Ljava/io/OutputStream;
      //   323: invokevirtual 135	java/io/OutputStream:close	()V
      //   326: aload_0
      //   327: getfield 17	com/tencent/mm/plugin/appbrand/z/a/a$a:mVP	Lcom/tencent/mm/plugin/appbrand/z/a/a;
      //   330: invokestatic 137	com/tencent/mm/plugin/appbrand/z/a/a:a	(Lcom/tencent/mm/plugin/appbrand/z/a/a;)V
      //   333: ldc 38
      //   335: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   338: aload_2
      //   339: athrow
      //   340: astore_3
      //   341: goto -15 -> 326
      //   344: astore_2
      //   345: goto -50 -> 295
      //   348: astore_2
      //   349: goto -140 -> 209
      //   352: astore_2
      //   353: goto -109 -> 244
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	356	0	this	a
      //   37	187	1	i	int
      //   66	18	2	localByteBuffer1	ByteBuffer
      //   103	1	2	localInterruptedException	java.lang.InterruptedException
      //   119	11	2	localIterator	Iterator
      //   171	12	2	localIOException1	IOException
      //   257	12	2	localException	Exception
      //   308	31	2	localObject	Object
      //   344	1	2	localIOException2	IOException
      //   348	1	2	localIOException3	IOException
      //   352	1	2	localIOException4	IOException
      //   138	14	3	localByteBuffer2	ByteBuffer
      //   340	1	3	localIOException5	IOException
      // Exception table:
      //   from	to	target	type
      //   5	36	103	java/lang/InterruptedException
      //   42	67	103	java/lang/InterruptedException
      //   71	100	103	java/lang/InterruptedException
      //   5	36	171	java/io/IOException
      //   42	67	171	java/io/IOException
      //   71	100	171	java/io/IOException
      //   104	120	171	java/io/IOException
      //   120	168	171	java/io/IOException
      //   5	36	257	java/lang/Exception
      //   42	67	257	java/lang/Exception
      //   71	100	257	java/lang/Exception
      //   104	120	257	java/lang/Exception
      //   120	168	257	java/lang/Exception
      //   5	36	308	finally
      //   42	67	308	finally
      //   71	100	308	finally
      //   104	120	308	finally
      //   120	168	308	finally
      //   172	192	308	finally
      //   258	278	308	finally
      //   316	326	340	java/io/IOException
      //   285	295	344	java/io/IOException
      //   199	209	348	java/io/IOException
      //   234	244	352	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.z.a.a
 * JD-Core Version:    0.7.0.1
 */