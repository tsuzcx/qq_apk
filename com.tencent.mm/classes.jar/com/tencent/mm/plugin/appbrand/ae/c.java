package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.d.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c
  implements a
{
  public static boolean DEBUG;
  public static int oin;
  public static final List<com.tencent.mm.plugin.appbrand.ae.b.a> oio;
  private ByteBuffer oiA;
  public com.tencent.mm.plugin.appbrand.ae.e.a oiB;
  private String oiC;
  private Integer oiD;
  private Boolean oiE;
  public String oiF;
  public SelectionKey oip;
  public ByteChannel oiq;
  public final BlockingQueue<ByteBuffer> oir;
  public final BlockingQueue<ByteBuffer> ois;
  private volatile boolean oit;
  private a.a oiu;
  public final d oiv;
  private List<com.tencent.mm.plugin.appbrand.ae.b.a> oiw;
  public com.tencent.mm.plugin.appbrand.ae.b.a oix;
  public a.b oiy;
  private d.a oiz;
  
  static
  {
    AppMethodBeat.i(156623);
    oin = 16384;
    DEBUG = false;
    ArrayList localArrayList = new ArrayList(4);
    oio = localArrayList;
    localArrayList.add(new com.tencent.mm.plugin.appbrand.ae.b.c());
    oio.add(new com.tencent.mm.plugin.appbrand.ae.b.b());
    oio.add(new com.tencent.mm.plugin.appbrand.ae.b.d());
    AppMethodBeat.o(156623);
  }
  
  public c(d paramd, com.tencent.mm.plugin.appbrand.ae.b.a parama)
  {
    AppMethodBeat.i(156604);
    this.oit = false;
    this.oiu = a.a.oid;
    this.oix = null;
    this.oiz = null;
    this.oiA = ByteBuffer.allocate(0);
    this.oiB = null;
    this.oiC = null;
    this.oiD = null;
    this.oiE = null;
    this.oiF = null;
    if ((parama == null) && (this.oiy == a.b.oik))
    {
      paramd = new IllegalArgumentException("parameters must not be null");
      AppMethodBeat.o(156604);
      throw paramd;
    }
    this.oir = new LinkedBlockingQueue();
    this.ois = new LinkedBlockingQueue();
    this.oiv = paramd;
    this.oiy = a.b.oij;
    if (parama != null) {
      this.oix = parama.bZD();
    }
    AppMethodBeat.o(156604);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.ae.c.b paramb)
  {
    AppMethodBeat.i(156613);
    c(paramb.ojg, paramb.getMessage(), false);
    AppMethodBeat.o(156613);
  }
  
  private void c(com.tencent.mm.plugin.appbrand.ae.e.f paramf)
  {
    AppMethodBeat.i(156620);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.oix.getClass().getSimpleName());
    }
    this.oiu = a.a.oif;
    try
    {
      this.oiv.d(paramf);
      AppMethodBeat.o(156620);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.oiv.k(paramf);
      AppMethodBeat.o(156620);
    }
  }
  
  /* Error */
  private void d(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 211
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 89	com/tencent/mm/plugin/appbrand/ae/c:oit	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 211
    //   16: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iload_1
    //   24: invokestatic 217	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: putfield 114	com/tencent/mm/plugin/appbrand/ae/c:oiD	Ljava/lang/Integer;
    //   30: aload_0
    //   31: aload_2
    //   32: putfield 112	com/tencent/mm/plugin/appbrand/ae/c:oiC	Ljava/lang/String;
    //   35: aload_0
    //   36: iload_3
    //   37: invokestatic 222	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: putfield 116	com/tencent/mm/plugin/appbrand/ae/c:oiE	Ljava/lang/Boolean;
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 89	com/tencent/mm/plugin/appbrand/ae/c:oit	Z
    //   48: aload_0
    //   49: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   52: ifnull +10 -> 62
    //   55: aload_0
    //   56: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   59: invokevirtual 225	com/tencent/mm/plugin/appbrand/ae/b/a:reset	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 110	com/tencent/mm/plugin/appbrand/ae/c:oiB	Lcom/tencent/mm/plugin/appbrand/ae/e/a;
    //   67: ldc 211
    //   69: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -53 -> 19
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	c
    //   0	80	1	paramInt	int
    //   0	80	2	paramString	String
    //   0	80	3	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	75	finally
    //   22	62	75	finally
    //   62	72	75	finally
  }
  
  private void g(Collection<com.tencent.mm.plugin.appbrand.ae.d.d> paramCollection)
  {
    AppMethodBeat.i(156616);
    if (!isOpen())
    {
      paramCollection = new com.tencent.mm.plugin.appbrand.ae.c.f();
      AppMethodBeat.o(156616);
      throw paramCollection;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      b((com.tencent.mm.plugin.appbrand.ae.d.d)paramCollection.next());
    }
    AppMethodBeat.o(156616);
  }
  
  /* Error */
  private boolean s(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: ldc_w 265
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   10: invokevirtual 269	java/nio/ByteBuffer:capacity	()I
    //   13: ifne +116 -> 129
    //   16: aload_1
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 273	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   24: pop
    //   25: aload_0
    //   26: getfield 120	com/tencent/mm/plugin/appbrand/ae/c:oiy	Lcom/tencent/mm/plugin/appbrand/ae/a$b;
    //   29: getstatic 125	com/tencent/mm/plugin/appbrand/ae/a$b:oik	Lcom/tencent/mm/plugin/appbrand/ae/a$b;
    //   32: if_acmpne +505 -> 537
    //   35: aload_0
    //   36: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   39: ifnonnull +405 -> 444
    //   42: aload_0
    //   43: getfield 275	com/tencent/mm/plugin/appbrand/ae/c:oiw	Ljava/util/List;
    //   46: invokeinterface 276 1 0
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 246 1 0
    //   60: ifeq +358 -> 418
    //   63: aload 5
    //   65: invokeinterface 250 1 0
    //   70: checkcast 146	com/tencent/mm/plugin/appbrand/ae/b/a
    //   73: invokevirtual 150	com/tencent/mm/plugin/appbrand/ae/b/a:bZD	()Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   76: astore 6
    //   78: aload 6
    //   80: aload_0
    //   81: getfield 120	com/tencent/mm/plugin/appbrand/ae/c:oiy	Lcom/tencent/mm/plugin/appbrand/ae/a$b;
    //   84: invokevirtual 279	com/tencent/mm/plugin/appbrand/ae/b/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a$b;)V
    //   87: aload 4
    //   89: invokevirtual 281	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   92: pop
    //   93: aload 6
    //   95: aload 4
    //   97: invokevirtual 285	com/tencent/mm/plugin/appbrand/ae/b/a:y	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/ae/e/f;
    //   100: astore 7
    //   102: aload 7
    //   104: instanceof 287
    //   107: ifne +103 -> 210
    //   110: aload_0
    //   111: sipush 1002
    //   114: ldc_w 289
    //   117: iconst_0
    //   118: invokespecial 291	com/tencent/mm/plugin/appbrand/ae/c:d	(ILjava/lang/String;Z)V
    //   121: ldc_w 265
    //   124: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_0
    //   130: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   133: invokevirtual 294	java/nio/ByteBuffer:remaining	()I
    //   136: aload_1
    //   137: invokevirtual 294	java/nio/ByteBuffer:remaining	()I
    //   140: if_icmpge +44 -> 184
    //   143: aload_0
    //   144: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   147: invokevirtual 269	java/nio/ByteBuffer:capacity	()I
    //   150: aload_1
    //   151: invokevirtual 294	java/nio/ByteBuffer:remaining	()I
    //   154: iadd
    //   155: invokestatic 106	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   158: astore 4
    //   160: aload_0
    //   161: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   164: invokevirtual 297	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   167: pop
    //   168: aload 4
    //   170: aload_0
    //   171: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   174: invokevirtual 301	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   177: pop
    //   178: aload_0
    //   179: aload 4
    //   181: putfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   184: aload_0
    //   185: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   188: aload_1
    //   189: invokevirtual 301	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   192: pop
    //   193: aload_0
    //   194: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   197: invokevirtual 297	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   200: pop
    //   201: aload_0
    //   202: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   205: astore 4
    //   207: goto -188 -> 19
    //   210: aload 7
    //   212: checkcast 287	com/tencent/mm/plugin/appbrand/ae/e/a
    //   215: astore 7
    //   217: aload 6
    //   219: aload 7
    //   221: invokevirtual 304	com/tencent/mm/plugin/appbrand/ae/b/a:c	(Lcom/tencent/mm/plugin/appbrand/ae/e/a;)Lcom/tencent/mm/plugin/appbrand/ae/b/a$b;
    //   224: getstatic 310	com/tencent/mm/plugin/appbrand/ae/b/a$b:oiX	Lcom/tencent/mm/plugin/appbrand/ae/b/a$b;
    //   227: if_acmpne -174 -> 53
    //   230: aload_0
    //   231: aload 7
    //   233: invokeinterface 313 1 0
    //   238: putfield 118	com/tencent/mm/plugin/appbrand/ae/c:oiF	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 141	com/tencent/mm/plugin/appbrand/ae/c:oiv	Lcom/tencent/mm/plugin/appbrand/ae/d;
    //   245: invokeinterface 317 1 0
    //   250: astore 8
    //   252: aload_0
    //   253: aload 6
    //   255: aload 7
    //   257: aload 8
    //   259: invokevirtual 320	com/tencent/mm/plugin/appbrand/ae/b/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/e/a;Lcom/tencent/mm/plugin/appbrand/ae/e/i;)Lcom/tencent/mm/plugin/appbrand/ae/e/c;
    //   262: invokestatic 324	com/tencent/mm/plugin/appbrand/ae/b/a:f	(Lcom/tencent/mm/plugin/appbrand/ae/e/f;)Ljava/util/List;
    //   265: invokevirtual 328	com/tencent/mm/plugin/appbrand/ae/c:bV	(Ljava/util/List;)V
    //   268: aload_0
    //   269: aload 6
    //   271: putfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   274: aload_0
    //   275: aload 7
    //   277: invokespecial 330	com/tencent/mm/plugin/appbrand/ae/c:c	(Lcom/tencent/mm/plugin/appbrand/ae/e/f;)V
    //   280: ldc_w 265
    //   283: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iconst_1
    //   287: ireturn
    //   288: astore 6
    //   290: aload_0
    //   291: aload 6
    //   293: getfield 158	com/tencent/mm/plugin/appbrand/ae/c/b:ojg	I
    //   296: aload 6
    //   298: invokevirtual 162	com/tencent/mm/plugin/appbrand/ae/c/b:getMessage	()Ljava/lang/String;
    //   301: iconst_0
    //   302: invokespecial 291	com/tencent/mm/plugin/appbrand/ae/c:d	(ILjava/lang/String;Z)V
    //   305: ldc_w 265
    //   308: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: iconst_0
    //   312: ireturn
    //   313: astore 6
    //   315: aload_0
    //   316: getfield 141	com/tencent/mm/plugin/appbrand/ae/c:oiv	Lcom/tencent/mm/plugin/appbrand/ae/d;
    //   319: aload 6
    //   321: invokeinterface 210 2 0
    //   326: aload_0
    //   327: iconst_m1
    //   328: aload 6
    //   330: invokevirtual 331	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   333: iconst_0
    //   334: invokespecial 291	com/tencent/mm/plugin/appbrand/ae/c:d	(ILjava/lang/String;Z)V
    //   337: ldc_w 265
    //   340: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: iconst_0
    //   344: ireturn
    //   345: astore 6
    //   347: ldc 172
    //   349: new 174	java/lang/StringBuilder
    //   352: dup
    //   353: ldc_w 333
    //   356: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: aload 6
    //   361: invokevirtual 334	com/tencent/mm/plugin/appbrand/ae/c/d:toString	()Ljava/lang/String;
    //   364: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -320 -> 53
    //   376: astore 5
    //   378: ldc 172
    //   380: new 174	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 339
    //   387: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload 5
    //   392: invokevirtual 334	com/tencent/mm/plugin/appbrand/ae/c/d:toString	()Ljava/lang/String;
    //   395: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_0
    //   405: aload 5
    //   407: invokespecial 341	com/tencent/mm/plugin/appbrand/ae/c:a	(Lcom/tencent/mm/plugin/appbrand/ae/c/b;)V
    //   410: ldc_w 265
    //   413: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: iconst_0
    //   417: ireturn
    //   418: aload_0
    //   419: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   422: ifnonnull +14 -> 436
    //   425: aload_0
    //   426: sipush 1002
    //   429: ldc_w 343
    //   432: iconst_0
    //   433: invokevirtual 166	com/tencent/mm/plugin/appbrand/ae/c:c	(ILjava/lang/String;Z)V
    //   436: ldc_w 265
    //   439: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: iconst_0
    //   443: ireturn
    //   444: aload_0
    //   445: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   448: aload 4
    //   450: invokevirtual 285	com/tencent/mm/plugin/appbrand/ae/b/a:y	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/ae/e/f;
    //   453: astore 5
    //   455: aload 5
    //   457: instanceof 287
    //   460: ifne +22 -> 482
    //   463: aload_0
    //   464: sipush 1002
    //   467: ldc_w 289
    //   470: iconst_0
    //   471: invokespecial 291	com/tencent/mm/plugin/appbrand/ae/c:d	(ILjava/lang/String;Z)V
    //   474: ldc_w 265
    //   477: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   480: iconst_0
    //   481: ireturn
    //   482: aload 5
    //   484: checkcast 287	com/tencent/mm/plugin/appbrand/ae/e/a
    //   487: astore 5
    //   489: aload_0
    //   490: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   493: aload 5
    //   495: invokevirtual 304	com/tencent/mm/plugin/appbrand/ae/b/a:c	(Lcom/tencent/mm/plugin/appbrand/ae/e/a;)Lcom/tencent/mm/plugin/appbrand/ae/b/a$b;
    //   498: getstatic 310	com/tencent/mm/plugin/appbrand/ae/b/a$b:oiX	Lcom/tencent/mm/plugin/appbrand/ae/b/a$b;
    //   501: if_acmpne +17 -> 518
    //   504: aload_0
    //   505: aload 5
    //   507: invokespecial 330	com/tencent/mm/plugin/appbrand/ae/c:c	(Lcom/tencent/mm/plugin/appbrand/ae/e/f;)V
    //   510: ldc_w 265
    //   513: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: iconst_1
    //   517: ireturn
    //   518: aload_0
    //   519: sipush 1002
    //   522: ldc_w 345
    //   525: iconst_0
    //   526: invokevirtual 166	com/tencent/mm/plugin/appbrand/ae/c:c	(ILjava/lang/String;Z)V
    //   529: ldc_w 265
    //   532: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   535: iconst_0
    //   536: ireturn
    //   537: aload_0
    //   538: getfield 120	com/tencent/mm/plugin/appbrand/ae/c:oiy	Lcom/tencent/mm/plugin/appbrand/ae/a$b;
    //   541: getstatic 144	com/tencent/mm/plugin/appbrand/ae/a$b:oij	Lcom/tencent/mm/plugin/appbrand/ae/a$b;
    //   544: if_acmpne -134 -> 410
    //   547: aload_0
    //   548: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   551: aload_0
    //   552: getfield 120	com/tencent/mm/plugin/appbrand/ae/c:oiy	Lcom/tencent/mm/plugin/appbrand/ae/a$b;
    //   555: invokevirtual 279	com/tencent/mm/plugin/appbrand/ae/b/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/a$b;)V
    //   558: aload_0
    //   559: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   562: aload 4
    //   564: invokevirtual 285	com/tencent/mm/plugin/appbrand/ae/b/a:y	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/ae/e/f;
    //   567: astore 5
    //   569: aload 5
    //   571: instanceof 347
    //   574: ifne +22 -> 596
    //   577: aload_0
    //   578: sipush 1002
    //   581: ldc_w 289
    //   584: iconst_0
    //   585: invokespecial 291	com/tencent/mm/plugin/appbrand/ae/c:d	(ILjava/lang/String;Z)V
    //   588: ldc_w 265
    //   591: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: iconst_0
    //   595: ireturn
    //   596: aload 5
    //   598: checkcast 347	com/tencent/mm/plugin/appbrand/ae/e/h
    //   601: astore 5
    //   603: aload_0
    //   604: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   607: aload_0
    //   608: getfield 110	com/tencent/mm/plugin/appbrand/ae/c:oiB	Lcom/tencent/mm/plugin/appbrand/ae/e/a;
    //   611: aload 5
    //   613: invokevirtual 350	com/tencent/mm/plugin/appbrand/ae/b/a:a	(Lcom/tencent/mm/plugin/appbrand/ae/e/a;Lcom/tencent/mm/plugin/appbrand/ae/e/h;)Lcom/tencent/mm/plugin/appbrand/ae/b/a$b;
    //   616: getstatic 310	com/tencent/mm/plugin/appbrand/ae/b/a$b:oiX	Lcom/tencent/mm/plugin/appbrand/ae/b/a$b;
    //   619: if_acmpne +17 -> 636
    //   622: aload_0
    //   623: aload 5
    //   625: invokespecial 330	com/tencent/mm/plugin/appbrand/ae/c:c	(Lcom/tencent/mm/plugin/appbrand/ae/e/f;)V
    //   628: ldc_w 265
    //   631: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   634: iconst_1
    //   635: ireturn
    //   636: aload_0
    //   637: sipush 1002
    //   640: new 174	java/lang/StringBuilder
    //   643: dup
    //   644: ldc_w 352
    //   647: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   650: aload 5
    //   652: invokeinterface 356 1 0
    //   657: invokevirtual 359	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: ldc_w 361
    //   663: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 5
    //   668: invokeinterface 364 1 0
    //   673: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: iconst_0
    //   680: invokevirtual 166	com/tencent/mm/plugin/appbrand/ae/c:c	(ILjava/lang/String;Z)V
    //   683: goto -273 -> 410
    //   686: astore 5
    //   688: ldc 172
    //   690: new 174	java/lang/StringBuilder
    //   693: dup
    //   694: ldc_w 339
    //   697: invokespecial 177	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   700: aload 5
    //   702: invokevirtual 365	com/tencent/mm/plugin/appbrand/ae/c/a:toString	()Ljava/lang/String;
    //   705: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload_0
    //   715: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   718: invokevirtual 269	java/nio/ByteBuffer:capacity	()I
    //   721: ifne +50 -> 771
    //   724: aload 4
    //   726: invokevirtual 281	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   729: pop
    //   730: aload 5
    //   732: getfield 368	com/tencent/mm/plugin/appbrand/ae/c/a:ojf	I
    //   735: istore_3
    //   736: iload_3
    //   737: istore_2
    //   738: iload_3
    //   739: ifne +12 -> 751
    //   742: aload 4
    //   744: invokevirtual 269	java/nio/ByteBuffer:capacity	()I
    //   747: bipush 16
    //   749: iadd
    //   750: istore_2
    //   751: aload_0
    //   752: iload_2
    //   753: invokestatic 106	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   756: putfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   759: aload_0
    //   760: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   763: aload_1
    //   764: invokevirtual 301	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   767: pop
    //   768: goto -358 -> 410
    //   771: aload_0
    //   772: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   775: aload_0
    //   776: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   779: invokevirtual 371	java/nio/ByteBuffer:limit	()I
    //   782: invokevirtual 375	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   785: pop
    //   786: aload_0
    //   787: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   790: aload_0
    //   791: getfield 108	com/tencent/mm/plugin/appbrand/ae/c:oiA	Ljava/nio/ByteBuffer;
    //   794: invokevirtual 269	java/nio/ByteBuffer:capacity	()I
    //   797: invokevirtual 377	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   800: pop
    //   801: goto -391 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	804	0	this	c
    //   0	804	1	paramByteBuffer	ByteBuffer
    //   737	16	2	i	int
    //   735	4	3	j	int
    //   17	726	4	localByteBuffer	ByteBuffer
    //   51	13	5	localIterator	Iterator
    //   376	30	5	locald1	com.tencent.mm.plugin.appbrand.ae.c.d
    //   453	214	5	localObject1	Object
    //   686	45	5	locala	com.tencent.mm.plugin.appbrand.ae.c.a
    //   76	194	6	locala1	com.tencent.mm.plugin.appbrand.ae.b.a
    //   288	9	6	localb	com.tencent.mm.plugin.appbrand.ae.c.b
    //   313	16	6	localRuntimeException	RuntimeException
    //   345	15	6	locald2	com.tencent.mm.plugin.appbrand.ae.c.d
    //   100	176	7	localObject2	Object
    //   250	8	8	locali	com.tencent.mm.plugin.appbrand.ae.e.i
    // Exception table:
    //   from	to	target	type
    //   241	252	288	com/tencent/mm/plugin/appbrand/ae/c/b
    //   241	252	313	java/lang/RuntimeException
    //   78	121	345	com/tencent/mm/plugin/appbrand/ae/c/d
    //   210	241	345	com/tencent/mm/plugin/appbrand/ae/c/d
    //   241	252	345	com/tencent/mm/plugin/appbrand/ae/c/d
    //   252	280	345	com/tencent/mm/plugin/appbrand/ae/c/d
    //   290	305	345	com/tencent/mm/plugin/appbrand/ae/c/d
    //   315	337	345	com/tencent/mm/plugin/appbrand/ae/c/d
    //   25	53	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   53	78	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   347	373	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   418	436	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   444	474	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   482	510	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   518	529	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   537	588	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   596	628	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   636	683	376	com/tencent/mm/plugin/appbrand/ae/c/d
    //   25	53	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   53	78	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   78	121	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   210	241	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   241	252	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   252	280	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   290	305	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   315	337	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   347	373	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   378	410	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   418	436	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   444	474	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   482	510	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   518	529	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   537	588	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   596	628	686	com/tencent/mm/plugin/appbrand/ae/c/a
    //   636	683	686	com/tencent/mm/plugin/appbrand/ae/c/a
  }
  
  private void t(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156607);
    label525:
    label532:
    for (;;)
    {
      d.a locala1;
      boolean bool;
      int i;
      try
      {
        Iterator localIterator = this.oix.x(paramByteBuffer).iterator();
        if (!localIterator.hasNext()) {
          break label525;
        }
        paramByteBuffer = (com.tencent.mm.plugin.appbrand.ae.d.d)localIterator.next();
        if (DEBUG) {
          Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: ".concat(String.valueOf(paramByteBuffer)));
        }
        locala1 = paramByteBuffer.bZK();
        bool = paramByteBuffer.bZI();
        if (locala1 != d.a.ojn) {
          break label216;
        }
        i = 1005;
        if (!(paramByteBuffer instanceof com.tencent.mm.plugin.appbrand.ae.d.a)) {
          break label532;
        }
        paramByteBuffer = (com.tencent.mm.plugin.appbrand.ae.d.a)paramByteBuffer;
        i = paramByteBuffer.bZE();
        paramByteBuffer = paramByteBuffer.getMessage();
        if (this.oiu == a.a.oig)
        {
          ax(i, paramByteBuffer);
          continue;
        }
        if (this.oix.bZC() != com.tencent.mm.plugin.appbrand.ae.b.a.a.oiV) {
          break label206;
        }
      }
      catch (com.tencent.mm.plugin.appbrand.ae.c.b paramByteBuffer)
      {
        Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + paramByteBuffer.toString());
        this.oiv.k(paramByteBuffer);
        a(paramByteBuffer);
        AppMethodBeat.o(156607);
        return;
      }
      c(i, paramByteBuffer, true);
      continue;
      label206:
      d(i, paramByteBuffer, false);
      continue;
      label216:
      if (locala1 == d.a.ojl)
      {
        this.oiv.a(this, paramByteBuffer);
      }
      else if (locala1 != d.a.ojm)
      {
        if ((!bool) || (locala1 == d.a.oji))
        {
          if (locala1 != d.a.oji)
          {
            if (this.oiz != null)
            {
              paramByteBuffer = new com.tencent.mm.plugin.appbrand.ae.c.b("Previous continuous frame sequence not completed.");
              AppMethodBeat.o(156607);
              throw paramByteBuffer;
            }
            this.oiz = locala1;
          }
          label363:
          do
          {
            for (;;)
            {
              try
              {
                this.oiv.c(paramByteBuffer);
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.oiv.k(paramByteBuffer);
              }
              break;
              if (!bool) {
                break label363;
              }
              if (this.oiz == null)
              {
                paramByteBuffer = new com.tencent.mm.plugin.appbrand.ae.c.b("Continuous frame sequence was not started.");
                AppMethodBeat.o(156607);
                throw paramByteBuffer;
              }
              this.oiz = null;
            }
          } while (this.oiz != null);
          paramByteBuffer = new com.tencent.mm.plugin.appbrand.ae.c.b("Continuous frame sequence was not started.");
          AppMethodBeat.o(156607);
          throw paramByteBuffer;
        }
        if (this.oiz != null)
        {
          paramByteBuffer = new com.tencent.mm.plugin.appbrand.ae.c.b("Continuous frame sequence not completed.");
          AppMethodBeat.o(156607);
          throw paramByteBuffer;
        }
        d.a locala2 = d.a.ojj;
        if (locala1 == locala2)
        {
          try
          {
            this.oiv.afM(com.tencent.mm.plugin.appbrand.ae.f.b.B(paramByteBuffer.bZH()));
          }
          catch (RuntimeException paramByteBuffer)
          {
            this.oiv.k(paramByteBuffer);
          }
        }
        else
        {
          locala2 = d.a.ojk;
          if (locala1 == locala2)
          {
            try
            {
              this.oiv.v(paramByteBuffer.bZH());
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.oiv.k(paramByteBuffer);
            }
          }
          else
          {
            paramByteBuffer = new com.tencent.mm.plugin.appbrand.ae.c.b("non control or continious frame expected");
            AppMethodBeat.o(156607);
            throw paramByteBuffer;
            AppMethodBeat.o(156607);
            return;
            paramByteBuffer = "";
          }
        }
      }
    }
  }
  
  private void u(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156618);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
    }
    this.oir.add(paramByteBuffer);
    AppMethodBeat.o(156618);
  }
  
  private void zG(int paramInt)
  {
    AppMethodBeat.i(156610);
    ax(paramInt, "");
    AppMethodBeat.o(156610);
  }
  
  public final void abA(String paramString)
  {
    AppMethodBeat.i(156614);
    if (paramString == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      AppMethodBeat.o(156614);
      return;
    }
    com.tencent.mm.plugin.appbrand.ae.b.a locala = this.oix;
    if (this.oiy == a.b.oij) {}
    for (boolean bool = true;; bool = false)
    {
      g(locala.aF(paramString, bool));
      AppMethodBeat.o(156614);
      return;
    }
  }
  
  /* Error */
  public final void ax(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 502
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 96	com/tencent/mm/plugin/appbrand/ae/c:oiu	Lcom/tencent/mm/plugin/appbrand/ae/a$a;
    //   12: getstatic 505	com/tencent/mm/plugin/appbrand/ae/a$a:oih	Lcom/tencent/mm/plugin/appbrand/ae/a$a;
    //   15: if_acmpne +12 -> 27
    //   18: ldc_w 502
    //   21: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 507	com/tencent/mm/plugin/appbrand/ae/c:oip	Ljava/nio/channels/SelectionKey;
    //   31: ifnull +10 -> 41
    //   34: aload_0
    //   35: getfield 507	com/tencent/mm/plugin/appbrand/ae/c:oip	Ljava/nio/channels/SelectionKey;
    //   38: invokevirtual 512	java/nio/channels/SelectionKey:cancel	()V
    //   41: aload_0
    //   42: getfield 514	com/tencent/mm/plugin/appbrand/ae/c:oiq	Ljava/nio/channels/ByteChannel;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +12 -> 59
    //   50: aload_0
    //   51: getfield 514	com/tencent/mm/plugin/appbrand/ae/c:oiq	Ljava/nio/channels/ByteChannel;
    //   54: invokeinterface 519 1 0
    //   59: aload_0
    //   60: getfield 141	com/tencent/mm/plugin/appbrand/ae/c:oiv	Lcom/tencent/mm/plugin/appbrand/ae/d;
    //   63: iload_1
    //   64: aload_2
    //   65: invokeinterface 522 3 0
    //   70: aload_0
    //   71: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 98	com/tencent/mm/plugin/appbrand/ae/c:oix	Lcom/tencent/mm/plugin/appbrand/ae/b/a;
    //   81: invokevirtual 225	com/tencent/mm/plugin/appbrand/ae/b/a:reset	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 110	com/tencent/mm/plugin/appbrand/ae/c:oiB	Lcom/tencent/mm/plugin/appbrand/ae/e/a;
    //   89: aload_0
    //   90: getstatic 505	com/tencent/mm/plugin/appbrand/ae/a$a:oih	Lcom/tencent/mm/plugin/appbrand/ae/a$a;
    //   93: putfield 96	com/tencent/mm/plugin/appbrand/ae/c:oiu	Lcom/tencent/mm/plugin/appbrand/ae/a$a;
    //   96: aload_0
    //   97: getfield 137	com/tencent/mm/plugin/appbrand/ae/c:oir	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 525 1 0
    //   105: ldc_w 502
    //   108: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -87 -> 24
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 141	com/tencent/mm/plugin/appbrand/ae/c:oiv	Lcom/tencent/mm/plugin/appbrand/ae/d;
    //   124: aload_3
    //   125: invokeinterface 210 2 0
    //   130: goto -71 -> 59
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 141	com/tencent/mm/plugin/appbrand/ae/c:oiv	Lcom/tencent/mm/plugin/appbrand/ae/d;
    //   138: aload_2
    //   139: invokeinterface 210 2 0
    //   144: goto -74 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	c
    //   0	147	1	paramInt	int
    //   0	147	2	paramString	String
    //   45	2	3	localByteChannel	ByteChannel
    //   119	6	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	24	114	finally
    //   27	41	114	finally
    //   41	46	114	finally
    //   50	59	114	finally
    //   59	70	114	finally
    //   70	84	114	finally
    //   84	111	114	finally
    //   120	130	114	finally
    //   134	144	114	finally
    //   50	59	119	java/io/IOException
    //   59	70	133	java/lang/RuntimeException
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.ae.d.d paramd)
  {
    AppMethodBeat.i(156617);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
    }
    u(this.oix.d(paramd));
    AppMethodBeat.o(156617);
  }
  
  public final void bV(List<ByteBuffer> paramList)
  {
    AppMethodBeat.i(156619);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      u((ByteBuffer)paramList.next());
    }
    AppMethodBeat.o(156619);
  }
  
  public final boolean bZA()
  {
    return this.oiu == a.a.oig;
  }
  
  public final void bZz()
  {
    AppMethodBeat.i(156612);
    if (this.oiu == a.a.oid)
    {
      zG(-1);
      AppMethodBeat.o(156612);
      return;
    }
    if (this.oit)
    {
      int i = this.oiD.intValue();
      String str = this.oiC;
      this.oiE.booleanValue();
      ax(i, str);
      AppMethodBeat.o(156612);
      return;
    }
    if (this.oix.bZC() == com.tencent.mm.plugin.appbrand.ae.b.a.a.oiT)
    {
      zG(1000);
      AppMethodBeat.o(156612);
      return;
    }
    if ((this.oix.bZC() == com.tencent.mm.plugin.appbrand.ae.b.a.a.oiU) && (this.oiy != a.b.oik))
    {
      zG(1000);
      AppMethodBeat.o(156612);
      return;
    }
    zG(1006);
    AppMethodBeat.o(156612);
  }
  
  public final void c(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156608);
    if ((this.oiu != a.a.oig) && (this.oiu != a.a.oih))
    {
      if (this.oiu == a.a.oif)
      {
        if (paramInt == 1006)
        {
          this.oiu = a.a.oig;
          d(paramInt, paramString, false);
          AppMethodBeat.o(156608);
          return;
        }
        if (this.oix.bZC() == com.tencent.mm.plugin.appbrand.ae.b.a.a.oiT) {}
      }
      for (;;)
      {
        try
        {
          b(new com.tencent.mm.plugin.appbrand.ae.d.b(paramInt, paramString));
          d(paramInt, paramString, paramBoolean);
          if (paramInt == 1002) {
            d(paramInt, paramString, paramBoolean);
          }
          this.oiu = a.a.oig;
          this.oiA = null;
          AppMethodBeat.o(156608);
          return;
        }
        catch (com.tencent.mm.plugin.appbrand.ae.c.b localb)
        {
          Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + localb.toString());
          this.oiv.k(localb);
          d(1006, "generated frame is invalid", false);
          continue;
        }
        if (paramInt == -3) {
          d(-3, paramString, true);
        } else {
          d(-1, paramString, false);
        }
      }
    }
    AppMethodBeat.o(156608);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(156621);
    int i = super.hashCode();
    AppMethodBeat.o(156621);
    return i;
  }
  
  public final boolean isClosed()
  {
    return this.oiu == a.a.oih;
  }
  
  public final boolean isOpen()
  {
    return this.oiu == a.a.oif;
  }
  
  public final void o(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156615);
    if (paramByteBuffer == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      AppMethodBeat.o(156615);
      return;
    }
    com.tencent.mm.plugin.appbrand.ae.b.a locala = this.oix;
    if (this.oiy == a.b.oij) {}
    for (boolean bool = true;; bool = false)
    {
      g(locala.a(paramByteBuffer, bool));
      AppMethodBeat.o(156615);
      return;
    }
  }
  
  public final void r(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156605);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
    }
    if (this.oiu != a.a.oid)
    {
      if (this.oiu == a.a.oif)
      {
        t(paramByteBuffer);
        AppMethodBeat.o(156605);
      }
    }
    else if ((s(paramByteBuffer)) && (!bZA()) && (!isClosed()))
    {
      if (paramByteBuffer.hasRemaining())
      {
        t(paramByteBuffer);
        AppMethodBeat.o(156605);
        return;
      }
      if (this.oiA.hasRemaining()) {
        t(this.oiA);
      }
    }
    AppMethodBeat.o(156605);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(156622);
    String str = super.toString();
    AppMethodBeat.o(156622);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.c
 * JD-Core Version:    0.7.0.1
 */