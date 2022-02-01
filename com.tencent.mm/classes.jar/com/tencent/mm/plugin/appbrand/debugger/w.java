package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.c;
import com.tencent.mm.plugin.appbrand.af.d.d;
import com.tencent.mm.plugin.appbrand.af.d.d.a;
import com.tencent.mm.plugin.appbrand.af.e.h;
import com.tencent.mm.plugin.appbrand.af.f.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k.b;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class w
{
  com.tencent.mm.plugin.appbrand.af.a.a odB;
  private SSLSocketFactory odC;
  
  public w(com.tencent.mm.plugin.appbrand.s.a parama)
  {
    AppMethodBeat.i(147090);
    parama = j.a(parama);
    if (parama != null) {
      this.odC = parama.getSocketFactory();
    }
    AppMethodBeat.o(147090);
  }
  
  /* Error */
  public final void a(String paramString, final k.b paramb)
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 46
    //   7: ldc 48
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 53	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 55	java/net/URI
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 58	java/net/URI:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: new 60	java/util/HashMap
    //   32: dup
    //   33: invokespecial 61	java/util/HashMap:<init>	()V
    //   36: astore 4
    //   38: aload_1
    //   39: ldc 63
    //   41: invokevirtual 69	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifeq +15 -> 59
    //   47: aload 4
    //   49: ldc 71
    //   51: ldc 73
    //   53: invokeinterface 79 3 0
    //   58: pop
    //   59: aload_0
    //   60: new 6	com/tencent/mm/plugin/appbrand/debugger/w$1
    //   63: dup
    //   64: aload_0
    //   65: aload_3
    //   66: new 81	com/tencent/mm/plugin/appbrand/af/b/d
    //   69: dup
    //   70: invokespecial 82	com/tencent/mm/plugin/appbrand/af/b/d:<init>	()V
    //   73: aload 4
    //   75: aload_2
    //   76: invokespecial 85	com/tencent/mm/plugin/appbrand/debugger/w$1:<init>	(Lcom/tencent/mm/plugin/appbrand/debugger/w;Ljava/net/URI;Lcom/tencent/mm/plugin/appbrand/af/b/a;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/s/k$b;)V
    //   79: putfield 87	com/tencent/mm/plugin/appbrand/debugger/w:odB	Lcom/tencent/mm/plugin/appbrand/af/a/a;
    //   82: aload_1
    //   83: ldc 89
    //   85: invokestatic 95	com/tencent/luggage/k/l:J	(Ljava/lang/String;Ljava/lang/String;)Z
    //   88: ifeq +68 -> 156
    //   91: new 97	java/net/Socket
    //   94: dup
    //   95: getstatic 103	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   98: invokespecial 106	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 87	com/tencent/mm/plugin/appbrand/debugger/w:odB	Lcom/tencent/mm/plugin/appbrand/af/a/a;
    //   106: aload_1
    //   107: invokevirtual 112	com/tencent/mm/plugin/appbrand/af/a/a:b	(Ljava/net/Socket;)V
    //   110: aload_0
    //   111: getfield 87	com/tencent/mm/plugin/appbrand/debugger/w:odB	Lcom/tencent/mm/plugin/appbrand/af/a/a;
    //   114: invokevirtual 115	com/tencent/mm/plugin/appbrand/af/a/a:connect	()V
    //   117: ldc 44
    //   119: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: astore_1
    //   124: ldc 46
    //   126: ldc 117
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: invokevirtual 121	java/lang/Exception:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_2
    //   143: ldc 126
    //   145: invokeinterface 131 2 0
    //   150: ldc 44
    //   152: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: aload_0
    //   157: getfield 36	com/tencent/mm/plugin/appbrand/debugger/w:odC	Ljavax/net/ssl/SSLSocketFactory;
    //   160: ifnull +34 -> 194
    //   163: aload_0
    //   164: getfield 36	com/tencent/mm/plugin/appbrand/debugger/w:odC	Ljavax/net/ssl/SSLSocketFactory;
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 137	javax/net/ssl/SSLSocketFactory:createSocket	()Ljava/net/Socket;
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 87	com/tencent/mm/plugin/appbrand/debugger/w:odB	Lcom/tencent/mm/plugin/appbrand/af/a/a;
    //   177: aload_1
    //   178: invokevirtual 112	com/tencent/mm/plugin/appbrand/af/a/a:b	(Ljava/net/Socket;)V
    //   181: aload_0
    //   182: getfield 87	com/tencent/mm/plugin/appbrand/debugger/w:odB	Lcom/tencent/mm/plugin/appbrand/af/a/a;
    //   185: invokevirtual 115	com/tencent/mm/plugin/appbrand/af/a/a:connect	()V
    //   188: ldc 44
    //   190: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: invokestatic 141	javax/net/ssl/SSLSocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   197: checkcast 133	javax/net/ssl/SSLSocketFactory
    //   200: astore_1
    //   201: goto -33 -> 168
    //   204: astore_1
    //   205: ldc 46
    //   207: ldc 143
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: invokestatic 149	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 124	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: ldc 44
    //   225: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	w
    //   0	229	1	paramString	String
    //   0	229	2	paramb	k.b
    //   28	38	3	localURI	URI
    //   36	38	4	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   20	29	123	java/lang/Exception
    //   59	122	204	java/lang/Exception
    //   156	168	204	java/lang/Exception
    //   168	188	204	java/lang/Exception
    //   194	201	204	java/lang/Exception
  }
  
  public final boolean a(ffr paramffr)
  {
    AppMethodBeat.i(147093);
    Log.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
    if (!isOpen())
    {
      Log.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
      AppMethodBeat.o(147093);
      return false;
    }
    if (paramffr == null)
    {
      Log.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
      AppMethodBeat.o(147093);
      return false;
    }
    paramffr = x.g(paramffr);
    this.odB.l(paramffr);
    AppMethodBeat.o(147093);
    return true;
  }
  
  public final boolean afK(String paramString)
  {
    AppMethodBeat.i(147094);
    if (this.odB == null)
    {
      Log.w("MicroMsg.RemoteDebugSocket", "client is null");
      AppMethodBeat.o(147094);
      return false;
    }
    this.odB.aB(1000, paramString);
    Log.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", new Object[] { Integer.valueOf(1000), paramString });
    AppMethodBeat.o(147094);
    return true;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(147092);
    if (this.odB == null)
    {
      AppMethodBeat.o(147092);
      return false;
    }
    boolean bool = this.odB.rkV.isOpen();
    AppMethodBeat.o(147092);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.w
 * JD-Core Version:    0.7.0.1
 */