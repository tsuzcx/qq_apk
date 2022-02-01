package com.tencent.mm.plugin.appbrand.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d.d.a;
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
  public static int rkB;
  public static final List<com.tencent.mm.plugin.appbrand.af.b.a> rkC;
  public SelectionKey rkD;
  public ByteChannel rkE;
  public final BlockingQueue<ByteBuffer> rkF;
  public final BlockingQueue<ByteBuffer> rkG;
  private volatile boolean rkH;
  private a.a rkI;
  public final d rkJ;
  private List<com.tencent.mm.plugin.appbrand.af.b.a> rkK;
  public com.tencent.mm.plugin.appbrand.af.b.a rkL;
  public a.b rkM;
  private d.a rkN;
  private ByteBuffer rkO;
  public com.tencent.mm.plugin.appbrand.af.e.a rkP;
  private String rkQ;
  private Integer rkR;
  private Boolean rkS;
  public String rkT;
  
  static
  {
    AppMethodBeat.i(156623);
    rkB = 16384;
    DEBUG = false;
    ArrayList localArrayList = new ArrayList(4);
    rkC = localArrayList;
    localArrayList.add(new com.tencent.mm.plugin.appbrand.af.b.c());
    rkC.add(new com.tencent.mm.plugin.appbrand.af.b.b());
    rkC.add(new com.tencent.mm.plugin.appbrand.af.b.d());
    AppMethodBeat.o(156623);
  }
  
  public c(d paramd, com.tencent.mm.plugin.appbrand.af.b.a parama)
  {
    AppMethodBeat.i(156604);
    this.rkH = false;
    this.rkI = a.a.rkr;
    this.rkL = null;
    this.rkN = null;
    this.rkO = ByteBuffer.allocate(0);
    this.rkP = null;
    this.rkQ = null;
    this.rkR = null;
    this.rkS = null;
    this.rkT = null;
    if ((parama == null) && (this.rkM == a.b.rky))
    {
      paramd = new IllegalArgumentException("parameters must not be null");
      AppMethodBeat.o(156604);
      throw paramd;
    }
    this.rkF = new LinkedBlockingQueue();
    this.rkG = new LinkedBlockingQueue();
    this.rkJ = paramd;
    this.rkM = a.b.rkx;
    if (parama != null) {
      this.rkL = parama.cmy();
    }
    AppMethodBeat.o(156604);
  }
  
  private void Dp(int paramInt)
  {
    AppMethodBeat.i(156610);
    az(paramInt, "");
    AppMethodBeat.o(156610);
  }
  
  private void a(com.tencent.mm.plugin.appbrand.af.c.b paramb)
  {
    AppMethodBeat.i(156613);
    c(paramb.rlu, paramb.getMessage(), false);
    AppMethodBeat.o(156613);
  }
  
  private void c(com.tencent.mm.plugin.appbrand.af.e.f paramf)
  {
    AppMethodBeat.i(156620);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.rkL.getClass().getSimpleName());
    }
    this.rkI = a.a.rkt;
    try
    {
      this.rkJ.d(paramf);
      AppMethodBeat.o(156620);
      return;
    }
    catch (RuntimeException paramf)
    {
      this.rkJ.j(paramf);
      AppMethodBeat.o(156620);
    }
  }
  
  /* Error */
  private void d(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 219
    //   4: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 89	com/tencent/mm/plugin/appbrand/af/c:rkH	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 219
    //   16: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iload_1
    //   24: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: putfield 114	com/tencent/mm/plugin/appbrand/af/c:rkR	Ljava/lang/Integer;
    //   30: aload_0
    //   31: aload_2
    //   32: putfield 112	com/tencent/mm/plugin/appbrand/af/c:rkQ	Ljava/lang/String;
    //   35: aload_0
    //   36: iload_3
    //   37: invokestatic 230	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: putfield 116	com/tencent/mm/plugin/appbrand/af/c:rkS	Ljava/lang/Boolean;
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 89	com/tencent/mm/plugin/appbrand/af/c:rkH	Z
    //   48: aload_0
    //   49: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   52: ifnull +10 -> 62
    //   55: aload_0
    //   56: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   59: invokevirtual 233	com/tencent/mm/plugin/appbrand/af/b/a:reset	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 110	com/tencent/mm/plugin/appbrand/af/c:rkP	Lcom/tencent/mm/plugin/appbrand/af/e/a;
    //   67: ldc 219
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
  private boolean p(ByteBuffer paramByteBuffer)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   9: invokevirtual 244	java/nio/ByteBuffer:capacity	()I
    //   12: ifne +115 -> 127
    //   15: aload_1
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 248	java/nio/ByteBuffer:mark	()Ljava/nio/Buffer;
    //   23: pop
    //   24: aload_0
    //   25: getfield 120	com/tencent/mm/plugin/appbrand/af/c:rkM	Lcom/tencent/mm/plugin/appbrand/af/a$b;
    //   28: getstatic 125	com/tencent/mm/plugin/appbrand/af/a$b:rky	Lcom/tencent/mm/plugin/appbrand/af/a$b;
    //   31: if_acmpne +496 -> 527
    //   34: aload_0
    //   35: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   38: ifnonnull +399 -> 437
    //   41: aload_0
    //   42: getfield 250	com/tencent/mm/plugin/appbrand/af/c:rkK	Ljava/util/List;
    //   45: invokeinterface 254 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: invokeinterface 260 1 0
    //   59: ifeq +353 -> 412
    //   62: aload 5
    //   64: invokeinterface 264 1 0
    //   69: checkcast 146	com/tencent/mm/plugin/appbrand/af/b/a
    //   72: invokevirtual 150	com/tencent/mm/plugin/appbrand/af/b/a:cmy	()Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   75: astore 6
    //   77: aload 6
    //   79: aload_0
    //   80: getfield 120	com/tencent/mm/plugin/appbrand/af/c:rkM	Lcom/tencent/mm/plugin/appbrand/af/a$b;
    //   83: invokevirtual 267	com/tencent/mm/plugin/appbrand/af/b/a:a	(Lcom/tencent/mm/plugin/appbrand/af/a$b;)V
    //   86: aload 4
    //   88: invokevirtual 269	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   91: pop
    //   92: aload 6
    //   94: aload 4
    //   96: invokevirtual 273	com/tencent/mm/plugin/appbrand/af/b/a:v	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/af/e/f;
    //   99: astore 7
    //   101: aload 7
    //   103: instanceof 275
    //   106: ifne +102 -> 208
    //   109: aload_0
    //   110: sipush 1002
    //   113: ldc_w 277
    //   116: iconst_0
    //   117: invokespecial 279	com/tencent/mm/plugin/appbrand/af/c:d	(ILjava/lang/String;Z)V
    //   120: ldc 240
    //   122: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: iconst_0
    //   126: ireturn
    //   127: aload_0
    //   128: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   131: invokevirtual 282	java/nio/ByteBuffer:remaining	()I
    //   134: aload_1
    //   135: invokevirtual 282	java/nio/ByteBuffer:remaining	()I
    //   138: if_icmpge +44 -> 182
    //   141: aload_0
    //   142: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   145: invokevirtual 244	java/nio/ByteBuffer:capacity	()I
    //   148: aload_1
    //   149: invokevirtual 282	java/nio/ByteBuffer:remaining	()I
    //   152: iadd
    //   153: invokestatic 106	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   156: astore 4
    //   158: aload_0
    //   159: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   162: invokevirtual 285	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   165: pop
    //   166: aload 4
    //   168: aload_0
    //   169: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   172: invokevirtual 289	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   175: pop
    //   176: aload_0
    //   177: aload 4
    //   179: putfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   182: aload_0
    //   183: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   186: aload_1
    //   187: invokevirtual 289	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   190: pop
    //   191: aload_0
    //   192: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   195: invokevirtual 285	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   198: pop
    //   199: aload_0
    //   200: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   203: astore 4
    //   205: goto -187 -> 18
    //   208: aload 7
    //   210: checkcast 275	com/tencent/mm/plugin/appbrand/af/e/a
    //   213: astore 7
    //   215: aload 6
    //   217: aload 7
    //   219: invokevirtual 292	com/tencent/mm/plugin/appbrand/af/b/a:c	(Lcom/tencent/mm/plugin/appbrand/af/e/a;)Lcom/tencent/mm/plugin/appbrand/af/b/a$b;
    //   222: getstatic 298	com/tencent/mm/plugin/appbrand/af/b/a$b:rll	Lcom/tencent/mm/plugin/appbrand/af/b/a$b;
    //   225: if_acmpne -173 -> 52
    //   228: aload_0
    //   229: aload 7
    //   231: invokeinterface 301 1 0
    //   236: putfield 118	com/tencent/mm/plugin/appbrand/af/c:rkT	Ljava/lang/String;
    //   239: aload_0
    //   240: getfield 141	com/tencent/mm/plugin/appbrand/af/c:rkJ	Lcom/tencent/mm/plugin/appbrand/af/d;
    //   243: invokeinterface 305 1 0
    //   248: astore 8
    //   250: aload_0
    //   251: aload 6
    //   253: aload 7
    //   255: aload 8
    //   257: invokevirtual 308	com/tencent/mm/plugin/appbrand/af/b/a:a	(Lcom/tencent/mm/plugin/appbrand/af/e/a;Lcom/tencent/mm/plugin/appbrand/af/e/i;)Lcom/tencent/mm/plugin/appbrand/af/e/c;
    //   260: invokestatic 312	com/tencent/mm/plugin/appbrand/af/b/a:f	(Lcom/tencent/mm/plugin/appbrand/af/e/f;)Ljava/util/List;
    //   263: invokevirtual 316	com/tencent/mm/plugin/appbrand/af/c:bT	(Ljava/util/List;)V
    //   266: aload_0
    //   267: aload 6
    //   269: putfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   272: aload_0
    //   273: aload 7
    //   275: invokespecial 318	com/tencent/mm/plugin/appbrand/af/c:c	(Lcom/tencent/mm/plugin/appbrand/af/e/f;)V
    //   278: ldc 240
    //   280: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore 6
    //   287: aload_0
    //   288: aload 6
    //   290: getfield 166	com/tencent/mm/plugin/appbrand/af/c/b:rlu	I
    //   293: aload 6
    //   295: invokevirtual 170	com/tencent/mm/plugin/appbrand/af/c/b:getMessage	()Ljava/lang/String;
    //   298: iconst_0
    //   299: invokespecial 279	com/tencent/mm/plugin/appbrand/af/c:d	(ILjava/lang/String;Z)V
    //   302: ldc 240
    //   304: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: iconst_0
    //   308: ireturn
    //   309: astore 6
    //   311: aload_0
    //   312: getfield 141	com/tencent/mm/plugin/appbrand/af/c:rkJ	Lcom/tencent/mm/plugin/appbrand/af/d;
    //   315: aload 6
    //   317: invokeinterface 218 2 0
    //   322: aload_0
    //   323: iconst_m1
    //   324: aload 6
    //   326: invokevirtual 319	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   329: iconst_0
    //   330: invokespecial 279	com/tencent/mm/plugin/appbrand/af/c:d	(ILjava/lang/String;Z)V
    //   333: ldc 240
    //   335: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: iconst_0
    //   339: ireturn
    //   340: astore 6
    //   342: ldc 180
    //   344: new 182	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 321
    //   351: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload 6
    //   356: invokevirtual 322	com/tencent/mm/plugin/appbrand/af/c/d:toString	()Ljava/lang/String;
    //   359: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: goto -316 -> 52
    //   371: astore 5
    //   373: ldc 180
    //   375: new 182	java/lang/StringBuilder
    //   378: dup
    //   379: ldc_w 327
    //   382: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload 5
    //   387: invokevirtual 322	com/tencent/mm/plugin/appbrand/af/c/d:toString	()Ljava/lang/String;
    //   390: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload_0
    //   400: aload 5
    //   402: invokespecial 329	com/tencent/mm/plugin/appbrand/af/c:a	(Lcom/tencent/mm/plugin/appbrand/af/c/b;)V
    //   405: ldc 240
    //   407: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: iconst_0
    //   411: ireturn
    //   412: aload_0
    //   413: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   416: ifnonnull +14 -> 430
    //   419: aload_0
    //   420: sipush 1002
    //   423: ldc_w 331
    //   426: iconst_0
    //   427: invokevirtual 174	com/tencent/mm/plugin/appbrand/af/c:c	(ILjava/lang/String;Z)V
    //   430: ldc 240
    //   432: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: iconst_0
    //   436: ireturn
    //   437: aload_0
    //   438: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   441: aload 4
    //   443: invokevirtual 273	com/tencent/mm/plugin/appbrand/af/b/a:v	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/af/e/f;
    //   446: astore 5
    //   448: aload 5
    //   450: instanceof 275
    //   453: ifne +21 -> 474
    //   456: aload_0
    //   457: sipush 1002
    //   460: ldc_w 277
    //   463: iconst_0
    //   464: invokespecial 279	com/tencent/mm/plugin/appbrand/af/c:d	(ILjava/lang/String;Z)V
    //   467: ldc 240
    //   469: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   472: iconst_0
    //   473: ireturn
    //   474: aload 5
    //   476: checkcast 275	com/tencent/mm/plugin/appbrand/af/e/a
    //   479: astore 5
    //   481: aload_0
    //   482: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   485: aload 5
    //   487: invokevirtual 292	com/tencent/mm/plugin/appbrand/af/b/a:c	(Lcom/tencent/mm/plugin/appbrand/af/e/a;)Lcom/tencent/mm/plugin/appbrand/af/b/a$b;
    //   490: getstatic 298	com/tencent/mm/plugin/appbrand/af/b/a$b:rll	Lcom/tencent/mm/plugin/appbrand/af/b/a$b;
    //   493: if_acmpne +16 -> 509
    //   496: aload_0
    //   497: aload 5
    //   499: invokespecial 318	com/tencent/mm/plugin/appbrand/af/c:c	(Lcom/tencent/mm/plugin/appbrand/af/e/f;)V
    //   502: ldc 240
    //   504: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   507: iconst_1
    //   508: ireturn
    //   509: aload_0
    //   510: sipush 1002
    //   513: ldc_w 333
    //   516: iconst_0
    //   517: invokevirtual 174	com/tencent/mm/plugin/appbrand/af/c:c	(ILjava/lang/String;Z)V
    //   520: ldc 240
    //   522: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: iconst_0
    //   526: ireturn
    //   527: aload_0
    //   528: getfield 120	com/tencent/mm/plugin/appbrand/af/c:rkM	Lcom/tencent/mm/plugin/appbrand/af/a$b;
    //   531: getstatic 144	com/tencent/mm/plugin/appbrand/af/a$b:rkx	Lcom/tencent/mm/plugin/appbrand/af/a$b;
    //   534: if_acmpne -129 -> 405
    //   537: aload_0
    //   538: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   541: aload_0
    //   542: getfield 120	com/tencent/mm/plugin/appbrand/af/c:rkM	Lcom/tencent/mm/plugin/appbrand/af/a$b;
    //   545: invokevirtual 267	com/tencent/mm/plugin/appbrand/af/b/a:a	(Lcom/tencent/mm/plugin/appbrand/af/a$b;)V
    //   548: aload_0
    //   549: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   552: aload 4
    //   554: invokevirtual 273	com/tencent/mm/plugin/appbrand/af/b/a:v	(Ljava/nio/ByteBuffer;)Lcom/tencent/mm/plugin/appbrand/af/e/f;
    //   557: astore 5
    //   559: aload 5
    //   561: instanceof 335
    //   564: ifne +21 -> 585
    //   567: aload_0
    //   568: sipush 1002
    //   571: ldc_w 277
    //   574: iconst_0
    //   575: invokespecial 279	com/tencent/mm/plugin/appbrand/af/c:d	(ILjava/lang/String;Z)V
    //   578: ldc 240
    //   580: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   583: iconst_0
    //   584: ireturn
    //   585: aload 5
    //   587: checkcast 335	com/tencent/mm/plugin/appbrand/af/e/h
    //   590: astore 5
    //   592: aload_0
    //   593: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   596: aload_0
    //   597: getfield 110	com/tencent/mm/plugin/appbrand/af/c:rkP	Lcom/tencent/mm/plugin/appbrand/af/e/a;
    //   600: aload 5
    //   602: invokevirtual 338	com/tencent/mm/plugin/appbrand/af/b/a:a	(Lcom/tencent/mm/plugin/appbrand/af/e/a;Lcom/tencent/mm/plugin/appbrand/af/e/h;)Lcom/tencent/mm/plugin/appbrand/af/b/a$b;
    //   605: getstatic 298	com/tencent/mm/plugin/appbrand/af/b/a$b:rll	Lcom/tencent/mm/plugin/appbrand/af/b/a$b;
    //   608: if_acmpne +16 -> 624
    //   611: aload_0
    //   612: aload 5
    //   614: invokespecial 318	com/tencent/mm/plugin/appbrand/af/c:c	(Lcom/tencent/mm/plugin/appbrand/af/e/f;)V
    //   617: ldc 240
    //   619: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: iconst_1
    //   623: ireturn
    //   624: aload_0
    //   625: sipush 1002
    //   628: new 182	java/lang/StringBuilder
    //   631: dup
    //   632: ldc_w 340
    //   635: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   638: aload 5
    //   640: invokeinterface 344 1 0
    //   645: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   648: ldc_w 349
    //   651: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload 5
    //   656: invokeinterface 352 1 0
    //   661: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: iconst_0
    //   668: invokevirtual 174	com/tencent/mm/plugin/appbrand/af/c:c	(ILjava/lang/String;Z)V
    //   671: goto -266 -> 405
    //   674: astore 5
    //   676: ldc 180
    //   678: new 182	java/lang/StringBuilder
    //   681: dup
    //   682: ldc_w 327
    //   685: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   688: aload 5
    //   690: invokevirtual 353	com/tencent/mm/plugin/appbrand/af/c/a:toString	()Ljava/lang/String;
    //   693: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 325	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: aload_0
    //   703: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   706: invokevirtual 244	java/nio/ByteBuffer:capacity	()I
    //   709: ifne +50 -> 759
    //   712: aload 4
    //   714: invokevirtual 269	java/nio/ByteBuffer:reset	()Ljava/nio/Buffer;
    //   717: pop
    //   718: aload 5
    //   720: getfield 356	com/tencent/mm/plugin/appbrand/af/c/a:rlt	I
    //   723: istore_3
    //   724: iload_3
    //   725: istore_2
    //   726: iload_3
    //   727: ifne +12 -> 739
    //   730: aload 4
    //   732: invokevirtual 244	java/nio/ByteBuffer:capacity	()I
    //   735: bipush 16
    //   737: iadd
    //   738: istore_2
    //   739: aload_0
    //   740: iload_2
    //   741: invokestatic 106	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   744: putfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   747: aload_0
    //   748: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   751: aload_1
    //   752: invokevirtual 289	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   755: pop
    //   756: goto -351 -> 405
    //   759: aload_0
    //   760: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   763: aload_0
    //   764: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   767: invokevirtual 359	java/nio/ByteBuffer:limit	()I
    //   770: invokevirtual 363	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   773: pop
    //   774: aload_0
    //   775: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   778: aload_0
    //   779: getfield 108	com/tencent/mm/plugin/appbrand/af/c:rkO	Ljava/nio/ByteBuffer;
    //   782: invokevirtual 244	java/nio/ByteBuffer:capacity	()I
    //   785: invokevirtual 365	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   788: pop
    //   789: goto -384 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	this	c
    //   0	792	1	paramByteBuffer	ByteBuffer
    //   725	16	2	i	int
    //   723	4	3	j	int
    //   16	715	4	localByteBuffer	ByteBuffer
    //   50	13	5	localIterator	Iterator
    //   371	30	5	locald1	com.tencent.mm.plugin.appbrand.af.c.d
    //   446	209	5	localObject1	Object
    //   674	45	5	locala	com.tencent.mm.plugin.appbrand.af.c.a
    //   75	193	6	locala1	com.tencent.mm.plugin.appbrand.af.b.a
    //   285	9	6	localb	com.tencent.mm.plugin.appbrand.af.c.b
    //   309	16	6	localRuntimeException	RuntimeException
    //   340	15	6	locald2	com.tencent.mm.plugin.appbrand.af.c.d
    //   99	175	7	localObject2	Object
    //   248	8	8	locali	com.tencent.mm.plugin.appbrand.af.e.i
    // Exception table:
    //   from	to	target	type
    //   239	250	285	com/tencent/mm/plugin/appbrand/af/c/b
    //   239	250	309	java/lang/RuntimeException
    //   77	120	340	com/tencent/mm/plugin/appbrand/af/c/d
    //   208	239	340	com/tencent/mm/plugin/appbrand/af/c/d
    //   239	250	340	com/tencent/mm/plugin/appbrand/af/c/d
    //   250	278	340	com/tencent/mm/plugin/appbrand/af/c/d
    //   287	302	340	com/tencent/mm/plugin/appbrand/af/c/d
    //   311	333	340	com/tencent/mm/plugin/appbrand/af/c/d
    //   24	52	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   52	77	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   342	368	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   412	430	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   437	467	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   474	502	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   509	520	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   527	578	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   585	617	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   624	671	371	com/tencent/mm/plugin/appbrand/af/c/d
    //   24	52	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   52	77	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   77	120	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   208	239	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   239	250	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   250	278	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   287	302	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   311	333	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   342	368	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   373	405	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   412	430	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   437	467	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   474	502	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   509	520	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   527	578	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   585	617	674	com/tencent/mm/plugin/appbrand/af/c/a
    //   624	671	674	com/tencent/mm/plugin/appbrand/af/c/a
  }
  
  private void q(ByteBuffer paramByteBuffer)
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
        Iterator localIterator = this.rkL.u(paramByteBuffer).iterator();
        if (!localIterator.hasNext()) {
          break label525;
        }
        paramByteBuffer = (com.tencent.mm.plugin.appbrand.af.d.d)localIterator.next();
        if (DEBUG) {
          Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: ".concat(String.valueOf(paramByteBuffer)));
        }
        locala1 = paramByteBuffer.cmF();
        bool = paramByteBuffer.cmD();
        if (locala1 != d.a.rlB) {
          break label216;
        }
        i = 1005;
        if (!(paramByteBuffer instanceof com.tencent.mm.plugin.appbrand.af.d.a)) {
          break label532;
        }
        paramByteBuffer = (com.tencent.mm.plugin.appbrand.af.d.a)paramByteBuffer;
        i = paramByteBuffer.cmz();
        paramByteBuffer = paramByteBuffer.getMessage();
        if (this.rkI == a.a.rku)
        {
          az(i, paramByteBuffer);
          continue;
        }
        if (this.rkL.cmx() != com.tencent.mm.plugin.appbrand.af.b.a.a.rlj) {
          break label206;
        }
      }
      catch (com.tencent.mm.plugin.appbrand.af.c.b paramByteBuffer)
      {
        Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + paramByteBuffer.toString());
        this.rkJ.j(paramByteBuffer);
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
      if (locala1 == d.a.rlz)
      {
        this.rkJ.a(this, paramByteBuffer);
      }
      else if (locala1 != d.a.rlA)
      {
        if ((!bool) || (locala1 == d.a.rlw))
        {
          if (locala1 != d.a.rlw)
          {
            if (this.rkN != null)
            {
              paramByteBuffer = new com.tencent.mm.plugin.appbrand.af.c.b("Previous continuous frame sequence not completed.");
              AppMethodBeat.o(156607);
              throw paramByteBuffer;
            }
            this.rkN = locala1;
          }
          label363:
          do
          {
            for (;;)
            {
              try
              {
                this.rkJ.c(paramByteBuffer);
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.rkJ.j(paramByteBuffer);
              }
              break;
              if (!bool) {
                break label363;
              }
              if (this.rkN == null)
              {
                paramByteBuffer = new com.tencent.mm.plugin.appbrand.af.c.b("Continuous frame sequence was not started.");
                AppMethodBeat.o(156607);
                throw paramByteBuffer;
              }
              this.rkN = null;
            }
          } while (this.rkN != null);
          paramByteBuffer = new com.tencent.mm.plugin.appbrand.af.c.b("Continuous frame sequence was not started.");
          AppMethodBeat.o(156607);
          throw paramByteBuffer;
        }
        if (this.rkN != null)
        {
          paramByteBuffer = new com.tencent.mm.plugin.appbrand.af.c.b("Continuous frame sequence not completed.");
          AppMethodBeat.o(156607);
          throw paramByteBuffer;
        }
        d.a locala2 = d.a.rlx;
        if (locala1 == locala2)
        {
          try
          {
            this.rkJ.anr(com.tencent.mm.plugin.appbrand.af.f.b.y(paramByteBuffer.cmC()));
          }
          catch (RuntimeException paramByteBuffer)
          {
            this.rkJ.j(paramByteBuffer);
          }
        }
        else
        {
          locala2 = d.a.rly;
          if (locala1 == locala2)
          {
            try
            {
              this.rkJ.s(paramByteBuffer.cmC());
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.rkJ.j(paramByteBuffer);
            }
          }
          else
          {
            paramByteBuffer = new com.tencent.mm.plugin.appbrand.af.c.b("non control or continious frame expected");
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
  
  private void r(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156618);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
    }
    this.rkF.add(paramByteBuffer);
    AppMethodBeat.o(156618);
  }
  
  /* Error */
  public final void az(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 475
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 96	com/tencent/mm/plugin/appbrand/af/c:rkI	Lcom/tencent/mm/plugin/appbrand/af/a$a;
    //   12: getstatic 478	com/tencent/mm/plugin/appbrand/af/a$a:rkv	Lcom/tencent/mm/plugin/appbrand/af/a$a;
    //   15: if_acmpne +12 -> 27
    //   18: ldc_w 475
    //   21: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 480	com/tencent/mm/plugin/appbrand/af/c:rkD	Ljava/nio/channels/SelectionKey;
    //   31: ifnull +10 -> 41
    //   34: aload_0
    //   35: getfield 480	com/tencent/mm/plugin/appbrand/af/c:rkD	Ljava/nio/channels/SelectionKey;
    //   38: invokevirtual 485	java/nio/channels/SelectionKey:cancel	()V
    //   41: aload_0
    //   42: getfield 487	com/tencent/mm/plugin/appbrand/af/c:rkE	Ljava/nio/channels/ByteChannel;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +12 -> 59
    //   50: aload_0
    //   51: getfield 487	com/tencent/mm/plugin/appbrand/af/c:rkE	Ljava/nio/channels/ByteChannel;
    //   54: invokeinterface 492 1 0
    //   59: aload_0
    //   60: getfield 141	com/tencent/mm/plugin/appbrand/af/c:rkJ	Lcom/tencent/mm/plugin/appbrand/af/d;
    //   63: iload_1
    //   64: aload_2
    //   65: invokeinterface 495 3 0
    //   70: aload_0
    //   71: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 98	com/tencent/mm/plugin/appbrand/af/c:rkL	Lcom/tencent/mm/plugin/appbrand/af/b/a;
    //   81: invokevirtual 233	com/tencent/mm/plugin/appbrand/af/b/a:reset	()V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 110	com/tencent/mm/plugin/appbrand/af/c:rkP	Lcom/tencent/mm/plugin/appbrand/af/e/a;
    //   89: aload_0
    //   90: getstatic 478	com/tencent/mm/plugin/appbrand/af/a$a:rkv	Lcom/tencent/mm/plugin/appbrand/af/a$a;
    //   93: putfield 96	com/tencent/mm/plugin/appbrand/af/c:rkI	Lcom/tencent/mm/plugin/appbrand/af/a$a;
    //   96: aload_0
    //   97: getfield 137	com/tencent/mm/plugin/appbrand/af/c:rkF	Ljava/util/concurrent/BlockingQueue;
    //   100: invokeinterface 498 1 0
    //   105: ldc_w 475
    //   108: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: goto -87 -> 24
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 141	com/tencent/mm/plugin/appbrand/af/c:rkJ	Lcom/tencent/mm/plugin/appbrand/af/d;
    //   124: aload_3
    //   125: invokeinterface 218 2 0
    //   130: goto -71 -> 59
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 141	com/tencent/mm/plugin/appbrand/af/c:rkJ	Lcom/tencent/mm/plugin/appbrand/af/d;
    //   138: aload_2
    //   139: invokeinterface 218 2 0
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
  
  public final void b(com.tencent.mm.plugin.appbrand.af.d.d paramd)
  {
    AppMethodBeat.i(156617);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
    }
    r(this.rkL.d(paramd));
    AppMethodBeat.o(156617);
  }
  
  public final void bT(List<ByteBuffer> paramList)
  {
    AppMethodBeat.i(156619);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      r((ByteBuffer)paramList.next());
    }
    AppMethodBeat.o(156619);
  }
  
  public final void c(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156608);
    if ((this.rkI != a.a.rku) && (this.rkI != a.a.rkv))
    {
      if (this.rkI == a.a.rkt)
      {
        if (paramInt == 1006)
        {
          this.rkI = a.a.rku;
          d(paramInt, paramString, false);
          AppMethodBeat.o(156608);
          return;
        }
        if (this.rkL.cmx() == com.tencent.mm.plugin.appbrand.af.b.a.a.rlh) {}
      }
      for (;;)
      {
        try
        {
          b(new com.tencent.mm.plugin.appbrand.af.d.b(paramInt, paramString));
          d(paramInt, paramString, paramBoolean);
          if (paramInt == 1002) {
            d(paramInt, paramString, paramBoolean);
          }
          this.rkI = a.a.rku;
          this.rkO = null;
          AppMethodBeat.o(156608);
          return;
        }
        catch (com.tencent.mm.plugin.appbrand.af.c.b localb)
        {
          Log.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + localb.toString());
          this.rkJ.j(localb);
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
  
  public final void cmu()
  {
    AppMethodBeat.i(156612);
    if (this.rkI == a.a.rkr)
    {
      Dp(-1);
      AppMethodBeat.o(156612);
      return;
    }
    if (this.rkH)
    {
      int i = this.rkR.intValue();
      String str = this.rkQ;
      this.rkS.booleanValue();
      az(i, str);
      AppMethodBeat.o(156612);
      return;
    }
    if (this.rkL.cmx() == com.tencent.mm.plugin.appbrand.af.b.a.a.rlh)
    {
      Dp(1000);
      AppMethodBeat.o(156612);
      return;
    }
    if ((this.rkL.cmx() == com.tencent.mm.plugin.appbrand.af.b.a.a.rli) && (this.rkM != a.b.rky))
    {
      Dp(1000);
      AppMethodBeat.o(156612);
      return;
    }
    Dp(1006);
    AppMethodBeat.o(156612);
  }
  
  public final boolean cmv()
  {
    return this.rkI == a.a.rku;
  }
  
  public final void g(Collection<com.tencent.mm.plugin.appbrand.af.d.d> paramCollection)
  {
    AppMethodBeat.i(156616);
    if (!isOpen())
    {
      paramCollection = new com.tencent.mm.plugin.appbrand.af.c.f();
      AppMethodBeat.o(156616);
      throw paramCollection;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      b((com.tencent.mm.plugin.appbrand.af.d.d)paramCollection.next());
    }
    AppMethodBeat.o(156616);
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
    return this.rkI == a.a.rkv;
  }
  
  public final boolean isOpen()
  {
    return this.rkI == a.a.rkt;
  }
  
  public final void l(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156615);
    if (paramByteBuffer == null)
    {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
      AppMethodBeat.o(156615);
      return;
    }
    com.tencent.mm.plugin.appbrand.af.b.a locala = this.rkL;
    if (this.rkM == a.b.rkx) {}
    for (boolean bool = true;; bool = false)
    {
      g(locala.a(paramByteBuffer, bool));
      AppMethodBeat.o(156615);
      return;
    }
  }
  
  public final void o(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(156605);
    if (DEBUG) {
      Log.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
    }
    if (this.rkI != a.a.rkr)
    {
      if (this.rkI == a.a.rkt)
      {
        q(paramByteBuffer);
        AppMethodBeat.o(156605);
      }
    }
    else if ((p(paramByteBuffer)) && (!cmv()) && (!isClosed()))
    {
      if (paramByteBuffer.hasRemaining())
      {
        q(paramByteBuffer);
        AppMethodBeat.o(156605);
        return;
      }
      if (this.rkO.hasRemaining()) {
        q(this.rkO);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af.c
 * JD-Core Version:    0.7.0.1
 */