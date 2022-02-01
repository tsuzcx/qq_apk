package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.o.k.b;
import com.tencent.mm.plugin.appbrand.z.c;
import com.tencent.mm.plugin.appbrand.z.d.d;
import com.tencent.mm.plugin.appbrand.z.d.d.a;
import com.tencent.mm.plugin.appbrand.z.e.h;
import com.tencent.mm.plugin.appbrand.z.f.b;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class u
{
  com.tencent.mm.plugin.appbrand.z.a.a kfj;
  private SSLSocketFactory kfk;
  
  public u(com.tencent.mm.plugin.appbrand.o.a parama)
  {
    AppMethodBeat.i(147090);
    parama = j.a(parama);
    if (parama != null) {
      this.kfk = parama.getSocketFactory();
    }
    AppMethodBeat.o(147090);
  }
  
  public final boolean OM(String paramString)
  {
    AppMethodBeat.i(147094);
    if (this.kfj == null)
    {
      ae.w("MicroMsg.RemoteDebugSocket", "client is null");
      AppMethodBeat.o(147094);
      return false;
    }
    this.kfj.aw(1000, paramString);
    ae.d("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", new Object[] { Integer.valueOf(1000), paramString });
    AppMethodBeat.o(147094);
    return true;
  }
  
  /* Error */
  public final void a(String paramString, final k.b paramb)
  {
    // Byte code:
    //   0: ldc 77
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 47
    //   7: ldc 79
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 81	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: new 83	java/net/URI
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 86	java/net/URI:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: new 88	java/util/HashMap
    //   32: dup
    //   33: invokespecial 89	java/util/HashMap:<init>	()V
    //   36: astore 4
    //   38: aload_1
    //   39: ldc 91
    //   41: invokevirtual 96	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifeq +15 -> 59
    //   47: aload 4
    //   49: ldc 98
    //   51: ldc 100
    //   53: invokeinterface 106 3 0
    //   58: pop
    //   59: aload_0
    //   60: new 6	com/tencent/mm/plugin/appbrand/debugger/u$1
    //   63: dup
    //   64: aload_0
    //   65: aload_3
    //   66: new 108	com/tencent/mm/plugin/appbrand/z/b/d
    //   69: dup
    //   70: invokespecial 109	com/tencent/mm/plugin/appbrand/z/b/d:<init>	()V
    //   73: aload 4
    //   75: aload_2
    //   76: invokespecial 112	com/tencent/mm/plugin/appbrand/debugger/u$1:<init>	(Lcom/tencent/mm/plugin/appbrand/debugger/u;Ljava/net/URI;Lcom/tencent/mm/plugin/appbrand/z/b/a;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/o/k$b;)V
    //   79: putfield 45	com/tencent/mm/plugin/appbrand/debugger/u:kfj	Lcom/tencent/mm/plugin/appbrand/z/a/a;
    //   82: aload_1
    //   83: ldc 114
    //   85: invokestatic 120	com/tencent/luggage/h/k:C	(Ljava/lang/String;Ljava/lang/String;)Z
    //   88: ifeq +68 -> 156
    //   91: new 122	java/net/Socket
    //   94: dup
    //   95: getstatic 128	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   98: invokespecial 131	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 45	com/tencent/mm/plugin/appbrand/debugger/u:kfj	Lcom/tencent/mm/plugin/appbrand/z/a/a;
    //   106: aload_1
    //   107: invokevirtual 134	com/tencent/mm/plugin/appbrand/z/a/a:a	(Ljava/net/Socket;)V
    //   110: aload_0
    //   111: getfield 45	com/tencent/mm/plugin/appbrand/debugger/u:kfj	Lcom/tencent/mm/plugin/appbrand/z/a/a;
    //   114: invokevirtual 137	com/tencent/mm/plugin/appbrand/z/a/a:connect	()V
    //   117: ldc 77
    //   119: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: astore_1
    //   124: ldc 47
    //   126: ldc 139
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: aload_1
    //   135: invokevirtual 143	java/lang/Exception:toString	()Ljava/lang/String;
    //   138: aastore
    //   139: invokestatic 146	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload_2
    //   143: ldc 148
    //   145: invokeinterface 153 2 0
    //   150: ldc 77
    //   152: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: return
    //   156: aload_0
    //   157: getfield 36	com/tencent/mm/plugin/appbrand/debugger/u:kfk	Ljavax/net/ssl/SSLSocketFactory;
    //   160: ifnull +34 -> 194
    //   163: aload_0
    //   164: getfield 36	com/tencent/mm/plugin/appbrand/debugger/u:kfk	Ljavax/net/ssl/SSLSocketFactory;
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 159	javax/net/ssl/SSLSocketFactory:createSocket	()Ljava/net/Socket;
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 45	com/tencent/mm/plugin/appbrand/debugger/u:kfj	Lcom/tencent/mm/plugin/appbrand/z/a/a;
    //   177: aload_1
    //   178: invokevirtual 134	com/tencent/mm/plugin/appbrand/z/a/a:a	(Ljava/net/Socket;)V
    //   181: aload_0
    //   182: getfield 45	com/tencent/mm/plugin/appbrand/debugger/u:kfj	Lcom/tencent/mm/plugin/appbrand/z/a/a;
    //   185: invokevirtual 137	com/tencent/mm/plugin/appbrand/z/a/a:connect	()V
    //   188: ldc 77
    //   190: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: invokestatic 163	javax/net/ssl/SSLSocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   197: checkcast 155	javax/net/ssl/SSLSocketFactory
    //   200: astore_1
    //   201: goto -33 -> 168
    //   204: astore_1
    //   205: ldc 47
    //   207: ldc 165
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: invokestatic 171	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   219: aastore
    //   220: invokestatic 146	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: ldc 77
    //   225: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	u
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
  
  public final boolean a(eay parameay)
  {
    AppMethodBeat.i(147093);
    ae.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
    if (!isOpen())
    {
      ae.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
      AppMethodBeat.o(147093);
      return false;
    }
    if (parameay == null)
    {
      ae.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
      AppMethodBeat.o(147093);
      return false;
    }
    parameay = v.g(parameay);
    this.kfj.o(parameay);
    AppMethodBeat.o(147093);
    return true;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(147092);
    if (this.kfj == null)
    {
      AppMethodBeat.o(147092);
      return false;
    }
    boolean bool = this.kfj.mVH.isOpen();
    AppMethodBeat.o(147092);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.u
 * JD-Core Version:    0.7.0.1
 */