package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.u.d.d.a;
import com.tencent.mm.sdk.platformtools.ab;
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
  public static int iYI;
  public static final List<com.tencent.mm.plugin.appbrand.u.b.a> iYJ;
  public SelectionKey iYK;
  public ByteChannel iYL;
  public final BlockingQueue<ByteBuffer> iYM;
  public final BlockingQueue<ByteBuffer> iYN;
  private volatile boolean iYO;
  private a.a iYP;
  public final d iYQ;
  private List<com.tencent.mm.plugin.appbrand.u.b.a> iYR;
  public com.tencent.mm.plugin.appbrand.u.b.a iYS;
  public a.b iYT;
  private d.a iYU;
  private ByteBuffer iYV;
  public com.tencent.mm.plugin.appbrand.u.e.a iYW;
  private String iYX;
  private Integer iYY;
  private Boolean iYZ;
  public String iZa;
  
  static
  {
    AppMethodBeat.i(73225);
    iYI = 16384;
    DEBUG = false;
    ArrayList localArrayList = new ArrayList(4);
    iYJ = localArrayList;
    localArrayList.add(new com.tencent.mm.plugin.appbrand.u.b.c());
    iYJ.add(new com.tencent.mm.plugin.appbrand.u.b.b());
    iYJ.add(new com.tencent.mm.plugin.appbrand.u.b.d());
    AppMethodBeat.o(73225);
  }
  
  public c(d paramd, com.tencent.mm.plugin.appbrand.u.b.a parama)
  {
    AppMethodBeat.i(73207);
    this.iYO = false;
    this.iYP = a.a.iYy;
    this.iYS = null;
    this.iYU = null;
    this.iYV = ByteBuffer.allocate(0);
    this.iYW = null;
    this.iYX = null;
    this.iYY = null;
    this.iYZ = null;
    this.iZa = null;
    if ((parama == null) && (this.iYT == a.b.iYF))
    {
      paramd = new IllegalArgumentException("parameters must not be null");
      AppMethodBeat.o(73207);
      throw paramd;
    }
    this.iYM = new LinkedBlockingQueue();
    this.iYN = new LinkedBlockingQueue();
    this.iYQ = paramd;
    this.iYT = a.b.iYE;
    if (parama != null) {
      this.iYS = parama.aOh();
    }
    AppMethodBeat.o(73207);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.u.c.b paramb)
  {
    AppMethodBeat.i(73215);
    d(paramb.iZD, paramb.getMessage(), false);
    AppMethodBeat.o(73215);
  }
  
  private void c(com.tencent.mm.plugin.appbrand.u.e.f paramf)
  {
    AppMethodBeat.i(73222);
    if (DEBUG) {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.iYS.getClass().getSimpleName());
    }
    this.iYP = a.a.iYA;
    try
    {
      this.iYQ.d(paramf);
      AppMethodBeat.o(73222);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.iYQ.d(paramf);
      AppMethodBeat.o(73222);
    }
  }
  
  private void d(Collection<com.tencent.mm.plugin.appbrand.u.d.d> paramCollection)
  {
    AppMethodBeat.i(73218);
    if (!isOpen())
    {
      paramCollection = new com.tencent.mm.plugin.appbrand.u.c.f();
      AppMethodBeat.o(73218);
      throw paramCollection;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      b((com.tencent.mm.plugin.appbrand.u.d.d)paramCollection.next());
    }
    AppMethodBeat.o(73218);
  }
  
  /* Error */
  private void e(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 243
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 89	com/tencent/mm/plugin/appbrand/u/c:iYO	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 243
    //   16: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iload_1
    //   24: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: putfield 114	com/tencent/mm/plugin/appbrand/u/c:iYY	Ljava/lang/Integer;
    //   30: aload_0
    //   31: aload_2
    //   32: putfield 112	com/tencent/mm/plugin/appbrand/u/c:iYX	Ljava/lang/String;
    //   35: aload_0
    //   36: iload_3
    //   37: invokestatic 254	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: putfield 116	com/tencent/mm/plugin/appbrand/u/c:iYZ	Ljava/lang/Boolean;
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 89	com/tencent/mm/plugin/appbrand/u/c:iYO	Z
    //   48: aload_0
    //   49: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   52: ifnull +10 -> 62
    //   55: aload_0
    //   56: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   59: invokevirtual 257	com/tencent/mm/plugin/appbrand/u/b/a:reset	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 110	com/tencent/mm/plugin/appbrand/u/c:iYW	Lcom/tencent/mm/plugin/appbrand/u/e/a;
    //   67: ldc 243
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
  
  /* Error */
  private boolean o(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: ldc_w 263
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   10: invokevirtual 267	java/nio/ByteBuffer:capacity	()I
    //   13: ifne +116 -> 129
    //   16: aload_1
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 271	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   24: pop
    //   25: aload_0
    //   26: getfield 120	com/tencent/mm/plugin/appbrand/u/c:iYT	Lcom/tencent/mm/plugin/appbrand/u/a$b;
    //   29: getstatic 125	com/tencent/mm/plugin/appbrand/u/a$b:iYF	Lcom/tencent/mm/plugin/appbrand/u/a$b;
    //   32: if_acmpne +505 -> 537
    //   35: aload_0
    //   36: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   39: ifnonnull +405 -> 444
    //   42: aload_0
    //   43: getfield 273	com/tencent/mm/plugin/appbrand/u/c:iYR	Ljava/util/List;
    //   46: invokeinterface 274 1 0
    //   51: astore 5
    //   53: aload 5
    //   55: invokeinterface 229 1 0
    //   60: ifeq +358 -> 418
    //   63: aload 5
    //   65: invokeinterface 233 1 0
    //   70: checkcast 146	com/tencent/mm/plugin/appbrand/u/b/a
    //   73: invokevirtual 150	com/tencent/mm/plugin/appbrand/u/b/a:aOh	()Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   76: astore 6
    //   78: aload 6
    //   80: aload_0
    //   81: getfield 120	com/tencent/mm/plugin/appbrand/u/c:iYT	Lcom/tencent/mm/plugin/appbrand/u/a$b;
    //   84: invokevirtual 277	com/tencent/mm/plugin/appbrand/u/b/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a$b;)V
    //   87: aload 4
    //   89: invokevirtual 279	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   92: pop
    //   93: aload 6
    //   95: aload 4
    //   97: invokevirtual 283	com/tencent/mm/plugin/appbrand/u/b/a:u	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/u/e/f;
    //   100: astore 7
    //   102: aload 7
    //   104: instanceof 285
    //   107: ifne +103 -> 210
    //   110: aload_0
    //   111: sipush 1002
    //   114: ldc_w 287
    //   117: iconst_0
    //   118: invokespecial 289	com/tencent/mm/plugin/appbrand/u/c:e	(ILjava/lang/String;Z)V
    //   121: ldc_w 263
    //   124: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: iconst_0
    //   128: ireturn
    //   129: aload_0
    //   130: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   133: invokevirtual 292	java/nio/ByteBuffer:remaining	()I
    //   136: aload_1
    //   137: invokevirtual 292	java/nio/ByteBuffer:remaining	()I
    //   140: if_icmpge +44 -> 184
    //   143: aload_0
    //   144: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   147: invokevirtual 267	java/nio/ByteBuffer:capacity	()I
    //   150: aload_1
    //   151: invokevirtual 292	java/nio/ByteBuffer:remaining	()I
    //   154: iadd
    //   155: invokestatic 106	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   158: astore 4
    //   160: aload_0
    //   161: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   164: invokevirtual 295	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   167: pop
    //   168: aload 4
    //   170: aload_0
    //   171: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   174: invokevirtual 299	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   177: pop
    //   178: aload_0
    //   179: aload 4
    //   181: putfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   184: aload_0
    //   185: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   188: aload_1
    //   189: invokevirtual 299	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   192: pop
    //   193: aload_0
    //   194: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   197: invokevirtual 295	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   200: pop
    //   201: aload_0
    //   202: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   205: astore 4
    //   207: goto -188 -> 19
    //   210: aload 7
    //   212: checkcast 285	com/tencent/mm/plugin/appbrand/u/e/a
    //   215: astore 7
    //   217: aload 6
    //   219: aload 7
    //   221: invokevirtual 302	com/tencent/mm/plugin/appbrand/u/b/a:c	(Lcom/tencent/mm/plugin/appbrand/u/e/a;)Lcom/tencent/mm/plugin/appbrand/u/b/a$b;
    //   224: getstatic 308	com/tencent/mm/plugin/appbrand/u/b/a$b:iZu	Lcom/tencent/mm/plugin/appbrand/u/b/a$b;
    //   227: if_acmpne -174 -> 53
    //   230: aload_0
    //   231: aload 7
    //   233: invokeinterface 311 1 0
    //   238: putfield 118	com/tencent/mm/plugin/appbrand/u/c:iZa	Ljava/lang/String;
    //   241: aload_0
    //   242: getfield 141	com/tencent/mm/plugin/appbrand/u/c:iYQ	Lcom/tencent/mm/plugin/appbrand/u/d;
    //   245: invokeinterface 315 1 0
    //   250: astore 8
    //   252: aload_0
    //   253: aload 6
    //   255: aload 7
    //   257: aload 8
    //   259: invokevirtual 318	com/tencent/mm/plugin/appbrand/u/b/a:a	(Lcom/tencent/mm/plugin/appbrand/u/e/a;Lcom/tencent/mm/plugin/appbrand/u/e/i;)Lcom/tencent/mm/plugin/appbrand/u/e/c;
    //   262: invokestatic 322	com/tencent/mm/plugin/appbrand/u/b/a:f	(Lcom/tencent/mm/plugin/appbrand/u/e/f;)Ljava/util/List;
    //   265: invokevirtual 326	com/tencent/mm/plugin/appbrand/u/c:aN	(Ljava/util/List;)V
    //   268: aload_0
    //   269: aload 6
    //   271: putfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   274: aload_0
    //   275: aload 7
    //   277: invokespecial 328	com/tencent/mm/plugin/appbrand/u/c:c	(Lcom/tencent/mm/plugin/appbrand/u/e/f;)V
    //   280: ldc_w 263
    //   283: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iconst_1
    //   287: ireturn
    //   288: astore 6
    //   290: aload_0
    //   291: aload 6
    //   293: getfield 158	com/tencent/mm/plugin/appbrand/u/c/b:iZD	I
    //   296: aload 6
    //   298: invokevirtual 162	com/tencent/mm/plugin/appbrand/u/c/b:getMessage	()Ljava/lang/String;
    //   301: iconst_0
    //   302: invokespecial 289	com/tencent/mm/plugin/appbrand/u/c:e	(ILjava/lang/String;Z)V
    //   305: ldc_w 263
    //   308: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: iconst_0
    //   312: ireturn
    //   313: astore 6
    //   315: aload_0
    //   316: getfield 141	com/tencent/mm/plugin/appbrand/u/c:iYQ	Lcom/tencent/mm/plugin/appbrand/u/d;
    //   319: aload 6
    //   321: invokeinterface 209 2 0
    //   326: aload_0
    //   327: iconst_m1
    //   328: aload 6
    //   330: invokevirtual 329	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   333: iconst_0
    //   334: invokespecial 289	com/tencent/mm/plugin/appbrand/u/c:e	(ILjava/lang/String;Z)V
    //   337: ldc_w 263
    //   340: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: iconst_0
    //   344: ireturn
    //   345: astore 6
    //   347: ldc 173
    //   349: new 175	java/lang/StringBuilder
    //   352: dup
    //   353: ldc_w 331
    //   356: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: aload 6
    //   361: invokevirtual 332	com/tencent/mm/plugin/appbrand/u/c/d:toString	()Ljava/lang/String;
    //   364: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 334	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -320 -> 53
    //   376: astore 5
    //   378: ldc 173
    //   380: new 175	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 336
    //   387: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload 5
    //   392: invokevirtual 332	com/tencent/mm/plugin/appbrand/u/c/d:toString	()Ljava/lang/String;
    //   395: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 334	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: aload_0
    //   405: aload 5
    //   407: invokespecial 338	com/tencent/mm/plugin/appbrand/u/c:a	(Lcom/tencent/mm/plugin/appbrand/u/c/b;)V
    //   410: ldc_w 263
    //   413: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: iconst_0
    //   417: ireturn
    //   418: aload_0
    //   419: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   422: ifnonnull +14 -> 436
    //   425: aload_0
    //   426: sipush 1002
    //   429: ldc_w 340
    //   432: iconst_0
    //   433: invokevirtual 166	com/tencent/mm/plugin/appbrand/u/c:d	(ILjava/lang/String;Z)V
    //   436: ldc_w 263
    //   439: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: iconst_0
    //   443: ireturn
    //   444: aload_0
    //   445: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   448: aload 4
    //   450: invokevirtual 283	com/tencent/mm/plugin/appbrand/u/b/a:u	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/u/e/f;
    //   453: astore 5
    //   455: aload 5
    //   457: instanceof 285
    //   460: ifne +22 -> 482
    //   463: aload_0
    //   464: sipush 1002
    //   467: ldc_w 287
    //   470: iconst_0
    //   471: invokespecial 289	com/tencent/mm/plugin/appbrand/u/c:e	(ILjava/lang/String;Z)V
    //   474: ldc_w 263
    //   477: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   480: iconst_0
    //   481: ireturn
    //   482: aload 5
    //   484: checkcast 285	com/tencent/mm/plugin/appbrand/u/e/a
    //   487: astore 5
    //   489: aload_0
    //   490: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   493: aload 5
    //   495: invokevirtual 302	com/tencent/mm/plugin/appbrand/u/b/a:c	(Lcom/tencent/mm/plugin/appbrand/u/e/a;)Lcom/tencent/mm/plugin/appbrand/u/b/a$b;
    //   498: getstatic 308	com/tencent/mm/plugin/appbrand/u/b/a$b:iZu	Lcom/tencent/mm/plugin/appbrand/u/b/a$b;
    //   501: if_acmpne +17 -> 518
    //   504: aload_0
    //   505: aload 5
    //   507: invokespecial 328	com/tencent/mm/plugin/appbrand/u/c:c	(Lcom/tencent/mm/plugin/appbrand/u/e/f;)V
    //   510: ldc_w 263
    //   513: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: iconst_1
    //   517: ireturn
    //   518: aload_0
    //   519: sipush 1002
    //   522: ldc_w 342
    //   525: iconst_0
    //   526: invokevirtual 166	com/tencent/mm/plugin/appbrand/u/c:d	(ILjava/lang/String;Z)V
    //   529: ldc_w 263
    //   532: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   535: iconst_0
    //   536: ireturn
    //   537: aload_0
    //   538: getfield 120	com/tencent/mm/plugin/appbrand/u/c:iYT	Lcom/tencent/mm/plugin/appbrand/u/a$b;
    //   541: getstatic 144	com/tencent/mm/plugin/appbrand/u/a$b:iYE	Lcom/tencent/mm/plugin/appbrand/u/a$b;
    //   544: if_acmpne -134 -> 410
    //   547: aload_0
    //   548: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   551: aload_0
    //   552: getfield 120	com/tencent/mm/plugin/appbrand/u/c:iYT	Lcom/tencent/mm/plugin/appbrand/u/a$b;
    //   555: invokevirtual 277	com/tencent/mm/plugin/appbrand/u/b/a:a	(Lcom/tencent/mm/plugin/appbrand/u/a$b;)V
    //   558: aload_0
    //   559: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   562: aload 4
    //   564: invokevirtual 283	com/tencent/mm/plugin/appbrand/u/b/a:u	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/u/e/f;
    //   567: astore 5
    //   569: aload 5
    //   571: instanceof 344
    //   574: ifne +22 -> 596
    //   577: aload_0
    //   578: sipush 1002
    //   581: ldc_w 287
    //   584: iconst_0
    //   585: invokespecial 289	com/tencent/mm/plugin/appbrand/u/c:e	(ILjava/lang/String;Z)V
    //   588: ldc_w 263
    //   591: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   594: iconst_0
    //   595: ireturn
    //   596: aload 5
    //   598: checkcast 344	com/tencent/mm/plugin/appbrand/u/e/h
    //   601: astore 5
    //   603: aload_0
    //   604: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   607: aload_0
    //   608: getfield 110	com/tencent/mm/plugin/appbrand/u/c:iYW	Lcom/tencent/mm/plugin/appbrand/u/e/a;
    //   611: aload 5
    //   613: invokevirtual 347	com/tencent/mm/plugin/appbrand/u/b/a:a	(Lcom/tencent/mm/plugin/appbrand/u/e/a;Lcom/tencent/mm/plugin/appbrand/u/e/h;)Lcom/tencent/mm/plugin/appbrand/u/b/a$b;
    //   616: getstatic 308	com/tencent/mm/plugin/appbrand/u/b/a$b:iZu	Lcom/tencent/mm/plugin/appbrand/u/b/a$b;
    //   619: if_acmpne +17 -> 636
    //   622: aload_0
    //   623: aload 5
    //   625: invokespecial 328	com/tencent/mm/plugin/appbrand/u/c:c	(Lcom/tencent/mm/plugin/appbrand/u/e/f;)V
    //   628: ldc_w 263
    //   631: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   634: iconst_1
    //   635: ireturn
    //   636: aload_0
    //   637: sipush 1002
    //   640: new 175	java/lang/StringBuilder
    //   643: dup
    //   644: ldc_w 349
    //   647: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   650: aload 5
    //   652: invokeinterface 353 1 0
    //   657: invokevirtual 356	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: ldc_w 358
    //   663: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload 5
    //   668: invokeinterface 361 1 0
    //   673: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: iconst_0
    //   680: invokevirtual 166	com/tencent/mm/plugin/appbrand/u/c:d	(ILjava/lang/String;Z)V
    //   683: goto -273 -> 410
    //   686: astore 5
    //   688: ldc 173
    //   690: new 175	java/lang/StringBuilder
    //   693: dup
    //   694: ldc_w 336
    //   697: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   700: aload 5
    //   702: invokevirtual 362	com/tencent/mm/plugin/appbrand/u/c/a:toString	()Ljava/lang/String;
    //   705: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 334	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload_0
    //   715: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   718: invokevirtual 267	java/nio/ByteBuffer:capacity	()I
    //   721: ifne +50 -> 771
    //   724: aload 4
    //   726: invokevirtual 279	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   729: pop
    //   730: aload 5
    //   732: getfield 365	com/tencent/mm/plugin/appbrand/u/c/a:iZC	I
    //   735: istore_3
    //   736: iload_3
    //   737: istore_2
    //   738: iload_3
    //   739: ifne +12 -> 751
    //   742: aload 4
    //   744: invokevirtual 267	java/nio/ByteBuffer:capacity	()I
    //   747: bipush 16
    //   749: iadd
    //   750: istore_2
    //   751: aload_0
    //   752: iload_2
    //   753: invokestatic 106	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   756: putfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   759: aload_0
    //   760: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   763: aload_1
    //   764: invokevirtual 299	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   767: pop
    //   768: goto -358 -> 410
    //   771: aload_0
    //   772: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   775: aload_0
    //   776: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   779: invokevirtual 368	java/nio/ByteBuffer:limit	()I
    //   782: invokevirtual 372	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   785: pop
    //   786: aload_0
    //   787: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   790: aload_0
    //   791: getfield 108	com/tencent/mm/plugin/appbrand/u/c:iYV	Ljava/nio/ByteBuffer;
    //   794: invokevirtual 267	java/nio/ByteBuffer:capacity	()I
    //   797: invokevirtual 374	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
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
    //   376	30	5	locald1	com.tencent.mm.plugin.appbrand.u.c.d
    //   453	214	5	localObject1	Object
    //   686	45	5	locala	com.tencent.mm.plugin.appbrand.u.c.a
    //   76	194	6	locala1	com.tencent.mm.plugin.appbrand.u.b.a
    //   288	9	6	localb	com.tencent.mm.plugin.appbrand.u.c.b
    //   313	16	6	localRuntimeException	RuntimeException
    //   345	15	6	locald2	com.tencent.mm.plugin.appbrand.u.c.d
    //   100	176	7	localObject2	Object
    //   250	8	8	locali	com.tencent.mm.plugin.appbrand.u.e.i
    // Exception table:
    //   from	to	target	type
    //   241	252	288	com/tencent/mm/plugin/appbrand/u/c/b
    //   241	252	313	java/lang/RuntimeException
    //   78	121	345	com/tencent/mm/plugin/appbrand/u/c/d
    //   210	241	345	com/tencent/mm/plugin/appbrand/u/c/d
    //   241	252	345	com/tencent/mm/plugin/appbrand/u/c/d
    //   252	280	345	com/tencent/mm/plugin/appbrand/u/c/d
    //   290	305	345	com/tencent/mm/plugin/appbrand/u/c/d
    //   315	337	345	com/tencent/mm/plugin/appbrand/u/c/d
    //   25	53	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   53	78	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   347	373	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   418	436	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   444	474	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   482	510	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   518	529	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   537	588	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   596	628	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   636	683	376	com/tencent/mm/plugin/appbrand/u/c/d
    //   25	53	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   53	78	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   78	121	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   210	241	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   241	252	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   252	280	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   290	305	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   315	337	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   347	373	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   378	410	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   418	436	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   444	474	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   482	510	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   518	529	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   537	588	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   596	628	686	com/tencent/mm/plugin/appbrand/u/c/a
    //   636	683	686	com/tencent/mm/plugin/appbrand/u/c/a
  }
  
  private void p(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73210);
    label525:
    label532:
    for (;;)
    {
      d.a locala1;
      boolean bool;
      int i;
      try
      {
        Iterator localIterator = this.iYS.t(paramByteBuffer).iterator();
        if (!localIterator.hasNext()) {
          break label525;
        }
        paramByteBuffer = (com.tencent.mm.plugin.appbrand.u.d.d)localIterator.next();
        if (DEBUG) {
          ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: ".concat(String.valueOf(paramByteBuffer)));
        }
        locala1 = paramByteBuffer.aOo();
        bool = paramByteBuffer.aOm();
        if (locala1 != d.a.iZK) {
          break label216;
        }
        i = 1005;
        if (!(paramByteBuffer instanceof com.tencent.mm.plugin.appbrand.u.d.a)) {
          break label532;
        }
        paramByteBuffer = (com.tencent.mm.plugin.appbrand.u.d.a)paramByteBuffer;
        i = paramByteBuffer.aOi();
        paramByteBuffer = paramByteBuffer.getMessage();
        if (this.iYP == a.a.iYB)
        {
          af(i, paramByteBuffer);
          continue;
        }
        if (this.iYS.aOg() != com.tencent.mm.plugin.appbrand.u.b.a.a.iZs) {
          break label206;
        }
      }
      catch (com.tencent.mm.plugin.appbrand.u.c.b paramByteBuffer)
      {
        ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + paramByteBuffer.toString());
        this.iYQ.d(paramByteBuffer);
        a(paramByteBuffer);
        AppMethodBeat.o(73210);
        return;
      }
      d(i, paramByteBuffer, true);
      continue;
      label206:
      e(i, paramByteBuffer, false);
      continue;
      label216:
      if (locala1 == d.a.iZI)
      {
        this.iYQ.a(this, paramByteBuffer);
      }
      else if (locala1 != d.a.iZJ)
      {
        if ((!bool) || (locala1 == d.a.iZF))
        {
          if (locala1 != d.a.iZF)
          {
            if (this.iYU != null)
            {
              paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.b("Previous continuous frame sequence not completed.");
              AppMethodBeat.o(73210);
              throw paramByteBuffer;
            }
            this.iYU = locala1;
          }
          label363:
          do
          {
            for (;;)
            {
              try
              {
                this.iYQ.c(paramByteBuffer);
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.iYQ.d(paramByteBuffer);
              }
              break;
              if (!bool) {
                break label363;
              }
              if (this.iYU == null)
              {
                paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.b("Continuous frame sequence was not started.");
                AppMethodBeat.o(73210);
                throw paramByteBuffer;
              }
              this.iYU = null;
            }
          } while (this.iYU != null);
          paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.b("Continuous frame sequence was not started.");
          AppMethodBeat.o(73210);
          throw paramByteBuffer;
        }
        if (this.iYU != null)
        {
          paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.b("Continuous frame sequence not completed.");
          AppMethodBeat.o(73210);
          throw paramByteBuffer;
        }
        d.a locala2 = d.a.iZG;
        if (locala1 == locala2)
        {
          try
          {
            this.iYQ.Fu(com.tencent.mm.plugin.appbrand.u.f.b.x(paramByteBuffer.aOl()));
          }
          catch (RuntimeException paramByteBuffer)
          {
            this.iYQ.d(paramByteBuffer);
          }
        }
        else
        {
          locala2 = d.a.iZH;
          if (locala1 == locala2)
          {
            try
            {
              this.iYQ.r(paramByteBuffer.aOl());
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.iYQ.d(paramByteBuffer);
            }
          }
          else
          {
            paramByteBuffer = new com.tencent.mm.plugin.appbrand.u.c.b("non control or continious frame expected");
            AppMethodBeat.o(73210);
            throw paramByteBuffer;
            AppMethodBeat.o(73210);
            return;
            paramByteBuffer = "";
          }
        }
      }
    }
  }
  
  private void q(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73220);
    if (DEBUG) {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
    }
    this.iYM.add(paramByteBuffer);
    AppMethodBeat.o(73220);
  }
  
  public final void CZ(String paramString)
  {
    AppMethodBeat.i(73216);
    if (paramString == null)
    {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      AppMethodBeat.o(73216);
      return;
    }
    com.tencent.mm.plugin.appbrand.u.b.a locala = this.iYS;
    if (this.iYT == a.b.iYE) {}
    for (boolean bool = true;; bool = false)
    {
      d(locala.au(paramString, bool));
      AppMethodBeat.o(73216);
      return;
    }
  }
  
  public final void aN(List<ByteBuffer> paramList)
  {
    AppMethodBeat.i(73221);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      q((ByteBuffer)paramList.next());
    }
    AppMethodBeat.o(73221);
  }
  
  public final void aOd()
  {
    AppMethodBeat.i(73214);
    if (this.iYP == a.a.iYy)
    {
      af(-1, "");
      AppMethodBeat.o(73214);
      return;
    }
    if (this.iYO)
    {
      int i = this.iYY.intValue();
      String str = this.iYX;
      this.iYZ.booleanValue();
      af(i, str);
      AppMethodBeat.o(73214);
      return;
    }
    if (this.iYS.aOg() == com.tencent.mm.plugin.appbrand.u.b.a.a.iZq)
    {
      af(1000, "");
      AppMethodBeat.o(73214);
      return;
    }
    if ((this.iYS.aOg() == com.tencent.mm.plugin.appbrand.u.b.a.a.iZr) && (this.iYT != a.b.iYF))
    {
      af(1000, "");
      AppMethodBeat.o(73214);
      return;
    }
    af(1006, "");
    AppMethodBeat.o(73214);
  }
  
  public final boolean aOe()
  {
    return this.iYP == a.a.iYB;
  }
  
  /* Error */
  public final void af(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 516
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 96	com/tencent/mm/plugin/appbrand/u/c:iYP	Lcom/tencent/mm/plugin/appbrand/u/a$a;
    //   12: getstatic 519	com/tencent/mm/plugin/appbrand/u/a$a:iYC	Lcom/tencent/mm/plugin/appbrand/u/a$a;
    //   15: if_acmpne +12 -> 27
    //   18: ldc_w 516
    //   21: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 521	com/tencent/mm/plugin/appbrand/u/c:iYK	Ljava/nio/channels/SelectionKey;
    //   31: ifnull +10 -> 41
    //   34: aload_0
    //   35: getfield 521	com/tencent/mm/plugin/appbrand/u/c:iYK	Ljava/nio/channels/SelectionKey;
    //   38: invokevirtual 526	java/nio/channels/SelectionKey:cancel	()V
    //   41: aload_0
    //   42: getfield 528	com/tencent/mm/plugin/appbrand/u/c:iYL	Ljava/nio/channels/ByteChannel;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +12 -> 59
    //   50: aload_0
    //   51: getfield 528	com/tencent/mm/plugin/appbrand/u/c:iYL	Ljava/nio/channels/ByteChannel;
    //   54: invokeinterface 533 1 0
    //   59: aload_0
    //   60: getfield 141	com/tencent/mm/plugin/appbrand/u/c:iYQ	Lcom/tencent/mm/plugin/appbrand/u/d;
    //   63: iload_1
    //   64: aload_2
    //   65: invokeinterface 536 3 0
    //   70: aload_0
    //   71: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 98	com/tencent/mm/plugin/appbrand/u/c:iYS	Lcom/tencent/mm/plugin/appbrand/u/b/a;
    //   81: invokevirtual 257	com/tencent/mm/plugin/appbrand/u/b/a:reset	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 110	com/tencent/mm/plugin/appbrand/u/c:iYW	Lcom/tencent/mm/plugin/appbrand/u/e/a;
    //   89: aload_0
    //   90: getstatic 519	com/tencent/mm/plugin/appbrand/u/a$a:iYC	Lcom/tencent/mm/plugin/appbrand/u/a$a;
    //   93: putfield 96	com/tencent/mm/plugin/appbrand/u/c:iYP	Lcom/tencent/mm/plugin/appbrand/u/a$a;
    //   96: aload_0
    //   97: getfield 137	com/tencent/mm/plugin/appbrand/u/c:iYM	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 539 1 0
    //   105: ldc_w 516
    //   108: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -87 -> 24
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 141	com/tencent/mm/plugin/appbrand/u/c:iYQ	Lcom/tencent/mm/plugin/appbrand/u/d;
    //   124: aload_3
    //   125: invokeinterface 209 2 0
    //   130: goto -71 -> 59
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 141	com/tencent/mm/plugin/appbrand/u/c:iYQ	Lcom/tencent/mm/plugin/appbrand/u/d;
    //   138: aload_2
    //   139: invokeinterface 209 2 0
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
  
  public final void b(com.tencent.mm.plugin.appbrand.u.d.d paramd)
  {
    AppMethodBeat.i(73219);
    if (DEBUG) {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
    }
    q(this.iYS.d(paramd));
    AppMethodBeat.o(73219);
  }
  
  public final void d(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(73211);
    if ((this.iYP != a.a.iYB) && (this.iYP != a.a.iYC))
    {
      if (this.iYP == a.a.iYA)
      {
        if (paramInt == 1006)
        {
          this.iYP = a.a.iYB;
          e(paramInt, paramString, false);
          AppMethodBeat.o(73211);
          return;
        }
        if (this.iYS.aOg() == com.tencent.mm.plugin.appbrand.u.b.a.a.iZq) {}
      }
      for (;;)
      {
        try
        {
          b(new com.tencent.mm.plugin.appbrand.u.d.b(paramInt, paramString));
          e(paramInt, paramString, paramBoolean);
          if (paramInt == 1002) {
            e(paramInt, paramString, paramBoolean);
          }
          this.iYP = a.a.iYB;
          this.iYV = null;
          AppMethodBeat.o(73211);
          return;
        }
        catch (com.tencent.mm.plugin.appbrand.u.c.b localb)
        {
          ab.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + localb.toString());
          this.iYQ.d(localb);
          e(1006, "generated frame is invalid", false);
          continue;
        }
        if (paramInt == -3) {
          e(-3, paramString, true);
        } else {
          e(-1, paramString, false);
        }
      }
    }
    AppMethodBeat.o(73211);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(73223);
    int i = super.hashCode();
    AppMethodBeat.o(73223);
    return i;
  }
  
  public final boolean isClosed()
  {
    return this.iYP == a.a.iYC;
  }
  
  public final boolean isOpen()
  {
    return this.iYP == a.a.iYA;
  }
  
  public final void l(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73217);
    if (paramByteBuffer == null)
    {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      AppMethodBeat.o(73217);
      return;
    }
    com.tencent.mm.plugin.appbrand.u.b.a locala = this.iYS;
    if (this.iYT == a.b.iYE) {}
    for (boolean bool = true;; bool = false)
    {
      d(locala.a(paramByteBuffer, bool));
      AppMethodBeat.o(73217);
      return;
    }
  }
  
  public final void n(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(73208);
    if (DEBUG) {
      ab.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
    }
    if (this.iYP != a.a.iYy)
    {
      if (this.iYP == a.a.iYA)
      {
        p(paramByteBuffer);
        AppMethodBeat.o(73208);
      }
    }
    else if ((o(paramByteBuffer)) && (!aOe()) && (!isClosed()))
    {
      if (paramByteBuffer.hasRemaining())
      {
        p(paramByteBuffer);
        AppMethodBeat.o(73208);
        return;
      }
      if (this.iYV.hasRemaining()) {
        p(this.iYV);
      }
    }
    AppMethodBeat.o(73208);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(73224);
    String str = super.toString();
    AppMethodBeat.o(73224);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c
 * JD-Core Version:    0.7.0.1
 */