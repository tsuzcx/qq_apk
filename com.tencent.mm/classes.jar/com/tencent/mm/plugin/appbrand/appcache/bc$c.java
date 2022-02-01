package com.tencent.mm.plugin.appbrand.appcache;

import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.pluginsdk.k.a.c.m.a;
import com.tencent.mm.vfs.q;

final class bc$c
  extends m.a<a>
{
  private static final ThreadLocal<bc.a> nGQ;
  private String nGR;
  final af.a nGS;
  
  static
  {
    AppMethodBeat.i(90609);
    nGQ = new ThreadLocal() {};
    AppMethodBeat.o(90609);
  }
  
  bc$c(a parama)
  {
    super(parama);
    AppMethodBeat.i(90602);
    this.nGR = null;
    af.a locala = af.b(parama);
    parama = locala;
    if (locala == null) {
      parama = m.nEq;
    }
    this.nGS = parama;
    AppMethodBeat.o(90602);
  }
  
  public final boolean Hj(long paramLong)
  {
    AppMethodBeat.i(90606);
    StatFs localStatFs = new StatFs(new q(getFilePath()).ifB().bOF());
    long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
    if ((l < 0L) || (l > paramLong))
    {
      AppMethodBeat.o(90606);
      return true;
    }
    AppMethodBeat.o(90606);
    return false;
  }
  
  /* Error */
  public final com.tencent.mm.pluginsdk.k.a.c.l a(com.tencent.mm.pluginsdk.k.a.c.j paramj)
  {
    // Byte code:
    //   0: ldc 89
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 93	com/tencent/mm/pluginsdk/k/a/c/m$a:bHA	()Lcom/tencent/mm/pluginsdk/k/a/c/f$b;
    //   9: checkcast 95	com/tencent/mm/plugin/appbrand/appcache/a/a
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 96	com/tencent/mm/plugin/appbrand/appcache/a/a:getFilePath	()Ljava/lang/String;
    //   17: invokestatic 102	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   20: pop
    //   21: aload_0
    //   22: aload_3
    //   23: getfield 107	com/tencent/mm/pluginsdk/k/a/c/k:url	Ljava/lang/String;
    //   26: putfield 42	com/tencent/mm/plugin/appbrand/appcache/bc$c:nGR	Ljava/lang/String;
    //   29: aload_0
    //   30: getfield 55	com/tencent/mm/plugin/appbrand/appcache/bc$c:nGS	Lcom/tencent/mm/plugin/appbrand/appcache/af$a;
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 42	com/tencent/mm/plugin/appbrand/appcache/bc$c:nGR	Ljava/lang/String;
    //   38: ldc 109
    //   40: invokevirtual 114	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_2
    //   45: invokeinterface 119 1 0
    //   50: getstatic 31	com/tencent/mm/plugin/appbrand/appcache/bc$c:nGQ	Ljava/lang/ThreadLocal;
    //   53: invokevirtual 125	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   56: checkcast 127	com/tencent/mm/plugin/appbrand/appcache/bc$a
    //   59: astore_2
    //   60: new 129	com/tencent/mm/f/a/acl
    //   63: dup
    //   64: invokespecial 130	com/tencent/mm/f/a/acl:<init>	()V
    //   67: astore 4
    //   69: aload 4
    //   71: getfield 134	com/tencent/mm/f/a/acl:gcJ	Lcom/tencent/mm/f/a/acl$a;
    //   74: aload_0
    //   75: invokespecial 93	com/tencent/mm/pluginsdk/k/a/c/m$a:bHA	()Lcom/tencent/mm/pluginsdk/k/a/c/f$b;
    //   78: checkcast 95	com/tencent/mm/plugin/appbrand/appcache/a/a
    //   81: putfield 140	com/tencent/mm/f/a/acl$a:gcK	Lcom/tencent/mm/plugin/appbrand/appcache/a/a;
    //   84: aload 4
    //   86: getfield 134	com/tencent/mm/f/a/acl:gcJ	Lcom/tencent/mm/f/a/acl$a;
    //   89: iconst_1
    //   90: putfield 144	com/tencent/mm/f/a/acl$a:event	I
    //   93: getstatic 150	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   96: aload 4
    //   98: invokestatic 156	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   101: invokevirtual 160	com/tencent/mm/sdk/event/EventCenter:asyncPublish	(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
    //   104: aload_2
    //   105: aload_0
    //   106: invokevirtual 163	com/tencent/mm/plugin/appbrand/appcache/bc$a:a	(Lcom/tencent/mm/plugin/appbrand/appcache/bc$c;)Lcom/tencent/mm/pluginsdk/k/a/c/l;
    //   109: astore_2
    //   110: new 129	com/tencent/mm/f/a/acl
    //   113: dup
    //   114: invokespecial 130	com/tencent/mm/f/a/acl:<init>	()V
    //   117: astore 4
    //   119: aload 4
    //   121: getfield 134	com/tencent/mm/f/a/acl:gcJ	Lcom/tencent/mm/f/a/acl$a;
    //   124: aload_0
    //   125: invokespecial 93	com/tencent/mm/pluginsdk/k/a/c/m$a:bHA	()Lcom/tencent/mm/pluginsdk/k/a/c/f$b;
    //   128: checkcast 95	com/tencent/mm/plugin/appbrand/appcache/a/a
    //   131: putfield 140	com/tencent/mm/f/a/acl$a:gcK	Lcom/tencent/mm/plugin/appbrand/appcache/a/a;
    //   134: aload 4
    //   136: getfield 134	com/tencent/mm/f/a/acl:gcJ	Lcom/tencent/mm/f/a/acl$a;
    //   139: aload_2
    //   140: putfield 167	com/tencent/mm/f/a/acl$a:gcL	Lcom/tencent/mm/pluginsdk/k/a/c/l;
    //   143: aload 4
    //   145: getfield 134	com/tencent/mm/f/a/acl:gcJ	Lcom/tencent/mm/f/a/acl$a;
    //   148: iconst_2
    //   149: putfield 144	com/tencent/mm/f/a/acl$a:event	I
    //   152: getstatic 150	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   155: aload 4
    //   157: invokestatic 156	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   160: invokevirtual 160	com/tencent/mm/sdk/event/EventCenter:asyncPublish	(Lcom/tencent/mm/sdk/event/IEvent;Landroid/os/Looper;)V
    //   163: aload_2
    //   164: ifnull +11 -> 175
    //   167: aload_2
    //   168: getfield 172	com/tencent/mm/pluginsdk/k/a/c/l:status	I
    //   171: iconst_3
    //   172: if_icmpne +124 -> 296
    //   175: ldc 174
    //   177: ldc 176
    //   179: iconst_1
    //   180: anewarray 178	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload_3
    //   186: getfield 181	com/tencent/mm/pluginsdk/k/a/c/k:QYU	Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: aload_0
    //   194: getfield 55	com/tencent/mm/plugin/appbrand/appcache/bc$c:nGS	Lcom/tencent/mm/plugin/appbrand/appcache/af$a;
    //   197: invokeinterface 190 1 0
    //   202: aload_0
    //   203: aload_1
    //   204: invokespecial 192	com/tencent/mm/pluginsdk/k/a/c/m$a:a	(Lcom/tencent/mm/pluginsdk/k/a/c/j;)Lcom/tencent/mm/pluginsdk/k/a/c/l;
    //   207: astore_3
    //   208: aload_3
    //   209: astore_1
    //   210: aload_3
    //   211: ifnull +15 -> 226
    //   214: aload_3
    //   215: getfield 196	com/tencent/mm/pluginsdk/k/a/c/l:bundle	Landroid/os/Bundle;
    //   218: ldc 198
    //   220: iconst_1
    //   221: invokevirtual 204	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   224: aload_3
    //   225: astore_1
    //   226: aload_0
    //   227: getfield 55	com/tencent/mm/plugin/appbrand/appcache/bc$c:nGS	Lcom/tencent/mm/plugin/appbrand/appcache/af$a;
    //   230: aload_1
    //   231: invokeinterface 207 2 0
    //   236: aload_1
    //   237: ifnonnull +40 -> 277
    //   240: new 169	com/tencent/mm/pluginsdk/k/a/c/l
    //   243: dup
    //   244: aload_0
    //   245: aconst_null
    //   246: iconst_m1
    //   247: iconst_3
    //   248: invokespecial 210	com/tencent/mm/pluginsdk/k/a/c/l:<init>	(Lcom/tencent/mm/pluginsdk/k/a/c/e;Ljava/lang/Exception;II)V
    //   251: astore_1
    //   252: ldc 89
    //   254: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: aload_1
    //   258: areturn
    //   259: astore_2
    //   260: aconst_null
    //   261: astore_1
    //   262: ldc 174
    //   264: aload_2
    //   265: ldc 212
    //   267: iconst_0
    //   268: anewarray 178	java/lang/Object
    //   271: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -38 -> 236
    //   277: ldc 89
    //   279: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aload_1
    //   283: areturn
    //   284: astore_3
    //   285: aload_2
    //   286: astore_1
    //   287: aload_3
    //   288: astore_2
    //   289: goto -27 -> 262
    //   292: astore_2
    //   293: goto -31 -> 262
    //   296: aload_2
    //   297: astore_1
    //   298: goto -72 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	c
    //   0	301	1	paramj	com.tencent.mm.pluginsdk.k.a.c.j
    //   33	135	2	localObject1	java.lang.Object
    //   259	27	2	localException1	java.lang.Exception
    //   288	1	2	localException2	java.lang.Exception
    //   292	5	2	localException3	java.lang.Exception
    //   12	213	3	localObject2	java.lang.Object
    //   284	4	3	localException4	java.lang.Exception
    //   67	89	4	localacl	com.tencent.mm.f.a.acl
    // Exception table:
    //   from	to	target	type
    //   5	163	259	java/lang/Exception
    //   167	175	284	java/lang/Exception
    //   175	208	284	java/lang/Exception
    //   214	224	284	java/lang/Exception
    //   226	236	292	java/lang/Exception
  }
  
  public final String aCt()
  {
    return "AppBrandWxaPkgDownloader";
  }
  
  protected final a bHu()
  {
    AppMethodBeat.i(90603);
    a locala = (a)super.bHA();
    AppMethodBeat.o(90603);
    return locala;
  }
  
  public final boolean bHv()
  {
    return true;
  }
  
  public final boolean bHw()
  {
    return false;
  }
  
  public final boolean bHx()
  {
    return true;
  }
  
  public final boolean bHy()
  {
    return false;
  }
  
  public final boolean bHz()
  {
    AppMethodBeat.i(90607);
    switch (ac.avq())
    {
    default: 
      AppMethodBeat.o(90607);
      return false;
    case 0: 
      AppMethodBeat.o(90607);
      return false;
    }
    boolean bool = super.bHz();
    AppMethodBeat.o(90607);
    return bool;
  }
  
  public final String btD()
  {
    return this.nGR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc.c
 * JD-Core Version:    0.7.0.1
 */