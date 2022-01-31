package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.w.c;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.sdk.platformtools.y;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class q
{
  com.tencent.mm.plugin.appbrand.w.a.a fSO;
  private SSLSocketFactory fSP;
  
  public q(com.tencent.mm.plugin.appbrand.o.a parama)
  {
    parama = j.a(parama);
    if (parama != null) {
      this.fSP = parama.getSocketFactory();
    }
  }
  
  /* Error */
  public final void a(java.lang.String paramString, com.tencent.mm.plugin.appbrand.o.k.b paramb)
  {
    // Byte code:
    //   0: ldc 33
    //   2: ldc 35
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 41	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: new 43	java/net/URI
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 46	java/net/URI:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: new 48	java/util/HashMap
    //   27: dup
    //   28: invokespecial 49	java/util/HashMap:<init>	()V
    //   31: astore 4
    //   33: aload_1
    //   34: ldc 51
    //   36: invokevirtual 57	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   39: ifeq +15 -> 54
    //   42: aload 4
    //   44: ldc 59
    //   46: ldc 61
    //   48: invokeinterface 67 3 0
    //   53: pop
    //   54: aload_0
    //   55: new 69	com/tencent/mm/plugin/appbrand/debugger/q$1
    //   58: dup
    //   59: aload_0
    //   60: aload_3
    //   61: new 71	com/tencent/mm/plugin/appbrand/w/b/d
    //   64: dup
    //   65: invokespecial 72	com/tencent/mm/plugin/appbrand/w/b/d:<init>	()V
    //   68: aload 4
    //   70: aload_2
    //   71: invokespecial 75	com/tencent/mm/plugin/appbrand/debugger/q$1:<init>	(Lcom/tencent/mm/plugin/appbrand/debugger/q;Ljava/net/URI;Lcom/tencent/mm/plugin/appbrand/w/b/a;Ljava/util/Map;Lcom/tencent/mm/plugin/appbrand/o/k$b;)V
    //   74: putfield 77	com/tencent/mm/plugin/appbrand/debugger/q:fSO	Lcom/tencent/mm/plugin/appbrand/w/a/a;
    //   77: aload_1
    //   78: ldc 79
    //   80: invokestatic 85	com/tencent/mm/pluginsdk/ui/tools/s:n	(Ljava/lang/String;Ljava/lang/String;)Z
    //   83: ifeq +58 -> 141
    //   86: new 87	java/net/Socket
    //   89: dup
    //   90: getstatic 93	java/net/Proxy:NO_PROXY	Ljava/net/Proxy;
    //   93: invokespecial 96	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 77	com/tencent/mm/plugin/appbrand/debugger/q:fSO	Lcom/tencent/mm/plugin/appbrand/w/a/a;
    //   101: aload_1
    //   102: invokevirtual 101	com/tencent/mm/plugin/appbrand/w/a/a:a	(Ljava/net/Socket;)V
    //   105: aload_0
    //   106: getfield 77	com/tencent/mm/plugin/appbrand/debugger/q:fSO	Lcom/tencent/mm/plugin/appbrand/w/a/a;
    //   109: invokevirtual 104	com/tencent/mm/plugin/appbrand/w/a/a:connect	()V
    //   112: return
    //   113: astore_1
    //   114: ldc 33
    //   116: ldc 106
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_1
    //   125: invokevirtual 110	java/lang/Exception:toString	()Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 113	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_2
    //   133: ldc 115
    //   135: invokeinterface 120 2 0
    //   140: return
    //   141: aload_0
    //   142: getfield 27	com/tencent/mm/plugin/appbrand/debugger/q:fSP	Ljavax/net/ssl/SSLSocketFactory;
    //   145: ifnull +49 -> 194
    //   148: aload_0
    //   149: getfield 27	com/tencent/mm/plugin/appbrand/debugger/q:fSP	Ljavax/net/ssl/SSLSocketFactory;
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 126	javax/net/ssl/SSLSocketFactory:createSocket	()Ljava/net/Socket;
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 77	com/tencent/mm/plugin/appbrand/debugger/q:fSO	Lcom/tencent/mm/plugin/appbrand/w/a/a;
    //   162: aload_1
    //   163: invokevirtual 101	com/tencent/mm/plugin/appbrand/w/a/a:a	(Ljava/net/Socket;)V
    //   166: aload_0
    //   167: getfield 77	com/tencent/mm/plugin/appbrand/debugger/q:fSO	Lcom/tencent/mm/plugin/appbrand/w/a/a;
    //   170: invokevirtual 104	com/tencent/mm/plugin/appbrand/w/a/a:connect	()V
    //   173: return
    //   174: astore_1
    //   175: ldc 33
    //   177: ldc 128
    //   179: iconst_1
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_1
    //   186: invokestatic 134	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 113	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: return
    //   194: invokestatic 138	javax/net/ssl/SSLSocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   197: checkcast 122	javax/net/ssl/SSLSocketFactory
    //   200: astore_1
    //   201: goto -48 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	q
    //   0	204	1	paramString	java.lang.String
    //   0	204	2	paramb	com.tencent.mm.plugin.appbrand.o.k.b
    //   23	38	3	localURI	java.net.URI
    //   31	38	4	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   15	24	113	java/lang/Exception
    //   54	112	174	java/lang/Exception
    //   141	153	174	java/lang/Exception
    //   153	173	174	java/lang/Exception
    //   194	201	174	java/lang/Exception
  }
  
  public final boolean a(cgk paramcgk)
  {
    y.d("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
    if (!isOpen())
    {
      y.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
      return false;
    }
    if (paramcgk == null)
    {
      y.w("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
      return false;
    }
    paramcgk = r.c(paramcgk);
    this.fSO.q(paramcgk);
    return true;
  }
  
  public final boolean isOpen()
  {
    if (this.fSO == null) {
      return false;
    }
    return this.fSO.hmD.isOpen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.q
 * JD-Core Version:    0.7.0.1
 */