package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.d.b.c;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/task/ImageLoadWorkTask;", "T", "R", "Lcom/tencent/mm/loader/task/LoadTask;", "_url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "isLocalFile", "", "()Z", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "producer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getProducer$libimageloader_release", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setProducer$libimageloader_release", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "batchGet", "", "readNetworkStart", "", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "executeTask", "loadFromDisk", "Lcom/tencent/mm/loader/model/LoadResult;", "producerThenCommitDisk", "Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "whenDataReady", "Companion", "LazyTask", "libimageloader_release"})
public final class a<T, R>
  extends b<T, R>
{
  public static final a.a hgT = new a.a((byte)0);
  private com.tencent.mm.loader.b.a.d<T, R> hdA = this.hhg.hcw;
  private com.tencent.mm.loader.b.b.e<T, R> hdz = this.hhg.hcv;
  private com.tencent.mm.loader.d.d<R> hgS = this.hhg.hcA;
  
  public a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    super(parama, paramd, paramf);
  }
  
  /* Error */
  private final b<R> a(final com.tencent.mm.loader.h.f<?> paramf, final com.tencent.mm.loader.h.b.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 109	com/tencent/mm/loader/k/b:hhg	Lcom/tencent/mm/loader/f;
    //   7: astore 9
    //   9: aload_2
    //   10: checkcast 134	java/io/Closeable
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 126	com/tencent/mm/loader/k/a:hgS	Lcom/tencent/mm/loader/d/d;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +225 -> 248
    //   26: aload 4
    //   28: aload 9
    //   30: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   33: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   36: aload_0
    //   37: getfield 109	com/tencent/mm/loader/k/b:hhg	Lcom/tencent/mm/loader/f;
    //   40: aload_2
    //   41: invokevirtual 149	com/tencent/mm/loader/d/d:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/b/a;)Lcom/tencent/mm/loader/h/e;
    //   44: astore 4
    //   46: aload 4
    //   48: astore 5
    //   50: aload 4
    //   52: instanceof 151
    //   55: ifne +6 -> 61
    //   58: aconst_null
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +379 -> 442
    //   66: aload 9
    //   68: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   71: astore 11
    //   73: aload 11
    //   75: ifnull +332 -> 407
    //   78: getstatic 161	com/tencent/mm/loader/e/c/b$b:hfg	Lcom/tencent/mm/loader/e/c/b$b;
    //   81: astore 10
    //   83: aload 10
    //   85: ldc 163
    //   87: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   90: aload 11
    //   92: checkcast 165	com/tencent/mm/loader/e/c/a
    //   95: getfield 171	com/tencent/mm/loader/e/c/b:heX	Lcom/tencent/mm/loader/e/c/b;
    //   98: astore 6
    //   100: aload 6
    //   102: astore 4
    //   104: aload 6
    //   106: instanceof 167
    //   109: ifne +360 -> 469
    //   112: aconst_null
    //   113: astore 4
    //   115: goto +354 -> 469
    //   118: aload 11
    //   120: checkcast 165	com/tencent/mm/loader/e/c/a
    //   123: getfield 171	com/tencent/mm/loader/e/c/b:heX	Lcom/tencent/mm/loader/e/c/b;
    //   126: astore 6
    //   128: aload 6
    //   130: astore 4
    //   132: aload 6
    //   134: instanceof 167
    //   137: ifne +344 -> 481
    //   140: aconst_null
    //   141: astore 4
    //   143: goto +338 -> 481
    //   146: aload 11
    //   148: checkcast 165	com/tencent/mm/loader/e/c/a
    //   151: getfield 171	com/tencent/mm/loader/e/c/b:heX	Lcom/tencent/mm/loader/e/c/b;
    //   154: astore 6
    //   156: aload 6
    //   158: astore 4
    //   160: aload 6
    //   162: instanceof 167
    //   165: ifne +328 -> 493
    //   168: aconst_null
    //   169: astore 4
    //   171: goto +322 -> 493
    //   174: iload_3
    //   175: iconst_1
    //   176: if_icmpne +231 -> 407
    //   179: aload 9
    //   181: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +256 -> 442
    //   189: aload_2
    //   190: aload 9
    //   192: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   195: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   198: aload 9
    //   200: aload 5
    //   202: getstatic 161	com/tencent/mm/loader/e/c/b$b:hfg	Lcom/tencent/mm/loader/e/c/b$b;
    //   205: invokevirtual 174	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   208: astore_2
    //   209: aload_2
    //   210: ifnull +232 -> 442
    //   213: aload_0
    //   214: aload_1
    //   215: aload 5
    //   217: aload_2
    //   218: aload_0
    //   219: checkcast 5	com/tencent/mm/loader/k/b
    //   222: invokevirtual 177	com/tencent/mm/loader/k/a:a	(Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/k/b;)V
    //   225: new 9	com/tencent/mm/loader/k/a$b
    //   228: dup
    //   229: aload_2
    //   230: getstatic 183	com/tencent/mm/loader/k/a$e:hhe	Lcom/tencent/mm/loader/k/a$e;
    //   233: checkcast 185	d/g/a/a
    //   236: invokespecial 188	com/tencent/mm/loader/k/a$b:<init>	(Lcom/tencent/mm/loader/h/e;Ld/g/a/a;)V
    //   239: astore_1
    //   240: aload 8
    //   242: aconst_null
    //   243: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: areturn
    //   248: aconst_null
    //   249: astore 4
    //   251: goto -205 -> 46
    //   254: aload 6
    //   256: getfield 197	com/tencent/mm/loader/e/c/b:heY	Lcom/tencent/mm/loader/e/c/b$a;
    //   259: getstatic 202	com/tencent/mm/loader/e/c/b$a:hfc	Lcom/tencent/mm/loader/e/c/b$a;
    //   262: if_acmpne +18 -> 280
    //   265: aload 10
    //   267: aload 6
    //   269: getfield 205	com/tencent/mm/loader/e/c/b:heZ	Lcom/tencent/mm/loader/e/c/b$b;
    //   272: if_acmpne +8 -> 280
    //   275: iconst_1
    //   276: istore_3
    //   277: goto -103 -> 174
    //   280: aload 6
    //   282: getfield 171	com/tencent/mm/loader/e/c/b:heX	Lcom/tencent/mm/loader/e/c/b;
    //   285: astore 6
    //   287: aload 6
    //   289: astore 4
    //   291: aload 6
    //   293: instanceof 167
    //   296: ifne +211 -> 507
    //   299: aconst_null
    //   300: astore 4
    //   302: goto +205 -> 507
    //   305: aload 6
    //   307: getfield 197	com/tencent/mm/loader/e/c/b:heY	Lcom/tencent/mm/loader/e/c/b$a;
    //   310: getstatic 208	com/tencent/mm/loader/e/c/b$a:hfb	Lcom/tencent/mm/loader/e/c/b$a;
    //   313: if_acmpne +18 -> 331
    //   316: aload 10
    //   318: aload 6
    //   320: getfield 205	com/tencent/mm/loader/e/c/b:heZ	Lcom/tencent/mm/loader/e/c/b$b;
    //   323: if_acmpne +8 -> 331
    //   326: iconst_1
    //   327: istore_3
    //   328: goto -154 -> 174
    //   331: aload 6
    //   333: getfield 171	com/tencent/mm/loader/e/c/b:heX	Lcom/tencent/mm/loader/e/c/b;
    //   336: astore 6
    //   338: aload 6
    //   340: astore 4
    //   342: aload 6
    //   344: instanceof 167
    //   347: ifne +172 -> 519
    //   350: aconst_null
    //   351: astore 4
    //   353: goto +166 -> 519
    //   356: aload 6
    //   358: getfield 197	com/tencent/mm/loader/e/c/b:heY	Lcom/tencent/mm/loader/e/c/b$a;
    //   361: getstatic 211	com/tencent/mm/loader/e/c/b$a:hfa	Lcom/tencent/mm/loader/e/c/b$a;
    //   364: if_acmpne +18 -> 382
    //   367: aload 10
    //   369: aload 6
    //   371: getfield 205	com/tencent/mm/loader/e/c/b:heZ	Lcom/tencent/mm/loader/e/c/b$b;
    //   374: if_acmpne +8 -> 382
    //   377: iconst_1
    //   378: istore_3
    //   379: goto -205 -> 174
    //   382: aload 6
    //   384: getfield 171	com/tencent/mm/loader/e/c/b:heX	Lcom/tencent/mm/loader/e/c/b;
    //   387: astore 6
    //   389: aload 6
    //   391: astore 4
    //   393: aload 6
    //   395: instanceof 167
    //   398: ifne +133 -> 531
    //   401: aconst_null
    //   402: astore 4
    //   404: goto +127 -> 531
    //   407: new 9	com/tencent/mm/loader/k/a$b
    //   410: dup
    //   411: aload 5
    //   413: new 14	com/tencent/mm/loader/k/a$d
    //   416: dup
    //   417: aload 5
    //   419: aload 9
    //   421: aload_0
    //   422: aload_2
    //   423: aload_1
    //   424: invokespecial 214	com/tencent/mm/loader/k/a$d:<init>	(Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/k/a;Lcom/tencent/mm/loader/h/b/a;Lcom/tencent/mm/loader/h/f;)V
    //   427: checkcast 185	d/g/a/a
    //   430: invokespecial 188	com/tencent/mm/loader/k/a$b:<init>	(Lcom/tencent/mm/loader/h/e;Ld/g/a/a;)V
    //   433: astore_1
    //   434: aload 8
    //   436: aconst_null
    //   437: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   440: aload_1
    //   441: areturn
    //   442: aload 8
    //   444: aconst_null
    //   445: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   448: aconst_null
    //   449: areturn
    //   450: astore_2
    //   451: aload_2
    //   452: athrow
    //   453: astore_1
    //   454: aload 8
    //   456: aload_2
    //   457: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   460: aload_1
    //   461: athrow
    //   462: astore_1
    //   463: aload 7
    //   465: astore_2
    //   466: goto -12 -> 454
    //   469: aload 4
    //   471: astore 6
    //   473: aload 4
    //   475: ifnonnull -221 -> 254
    //   478: goto -360 -> 118
    //   481: aload 4
    //   483: astore 6
    //   485: aload 4
    //   487: ifnonnull -182 -> 305
    //   490: goto -344 -> 146
    //   493: aload 4
    //   495: astore 6
    //   497: aload 4
    //   499: ifnonnull -143 -> 356
    //   502: iconst_0
    //   503: istore_3
    //   504: goto -330 -> 174
    //   507: aload 4
    //   509: astore 6
    //   511: aload 4
    //   513: ifnonnull -259 -> 254
    //   516: goto -398 -> 118
    //   519: aload 4
    //   521: astore 6
    //   523: aload 4
    //   525: ifnonnull -220 -> 305
    //   528: goto -382 -> 146
    //   531: aload 4
    //   533: astore 6
    //   535: aload 4
    //   537: ifnonnull -181 -> 356
    //   540: goto -38 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	a
    //   0	543	1	paramf	com.tencent.mm.loader.h.f<?>
    //   0	543	2	parama	com.tencent.mm.loader.h.b.a
    //   174	330	3	i	int
    //   19	517	4	localObject1	Object
    //   48	370	5	localObject2	Object
    //   98	436	6	localObject3	Object
    //   1	463	7	localObject4	Object
    //   13	442	8	localCloseable	java.io.Closeable
    //   7	413	9	localf	com.tencent.mm.loader.f
    //   81	287	10	localb	com.tencent.mm.loader.e.c.b.b
    //   71	76	11	locala	com.tencent.mm.loader.e.c.a
    // Exception table:
    //   from	to	target	type
    //   15	21	450	java/lang/Throwable
    //   26	46	450	java/lang/Throwable
    //   50	58	450	java/lang/Throwable
    //   66	73	450	java/lang/Throwable
    //   78	100	450	java/lang/Throwable
    //   104	112	450	java/lang/Throwable
    //   118	128	450	java/lang/Throwable
    //   132	140	450	java/lang/Throwable
    //   146	156	450	java/lang/Throwable
    //   160	168	450	java/lang/Throwable
    //   179	185	450	java/lang/Throwable
    //   189	209	450	java/lang/Throwable
    //   213	240	450	java/lang/Throwable
    //   254	275	450	java/lang/Throwable
    //   280	287	450	java/lang/Throwable
    //   291	299	450	java/lang/Throwable
    //   305	326	450	java/lang/Throwable
    //   331	338	450	java/lang/Throwable
    //   342	350	450	java/lang/Throwable
    //   356	377	450	java/lang/Throwable
    //   382	389	450	java/lang/Throwable
    //   393	401	450	java/lang/Throwable
    //   407	434	450	java/lang/Throwable
    //   451	453	453	finally
    //   15	21	462	finally
    //   26	46	462	finally
    //   50	58	462	finally
    //   66	73	462	finally
    //   78	100	462	finally
    //   104	112	462	finally
    //   118	128	462	finally
    //   132	140	462	finally
    //   146	156	462	finally
    //   160	168	462	finally
    //   179	185	462	finally
    //   189	209	462	finally
    //   213	240	462	finally
    //   254	275	462	finally
    //   280	287	462	finally
    //   291	299	462	finally
    //   305	326	462	finally
    //   331	338	462	finally
    //   342	350	462	finally
    //   356	377	462	finally
    //   382	389	462	finally
    //   393	401	462	finally
    //   407	434	462	finally
  }
  
  /* Error */
  private final void a(com.tencent.mm.loader.h.f<?> paramf, b.a<R> parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 218	com/tencent/mm/loader/h/c
    //   6: dup
    //   7: invokespecial 220	com/tencent/mm/loader/h/c:<init>	()V
    //   10: astore 8
    //   12: ldc 222
    //   14: new 224	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 226
    //   20: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 233	com/tencent/mm/loader/k/b:heV	Lcom/tencent/mm/loader/h/a/a;
    //   27: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: ldc 239
    //   32: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 252	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 256	com/tencent/mm/loader/h/c:hgr	Lcom/tencent/mm/loader/h/c$a;
    //   48: astore 4
    //   50: aload 8
    //   52: invokestatic 260	com/tencent/mm/loader/h/c:arB	()I
    //   55: putfield 264	com/tencent/mm/loader/h/c:from	I
    //   58: aload_0
    //   59: getfield 109	com/tencent/mm/loader/k/b:hhg	Lcom/tencent/mm/loader/f;
    //   62: astore 7
    //   64: aload_1
    //   65: ifnull +397 -> 462
    //   68: aload_1
    //   69: invokevirtual 270	com/tencent/mm/loader/h/f:value	()Ljava/lang/Object;
    //   72: ifnull +304 -> 376
    //   75: iconst_1
    //   76: istore_3
    //   77: iload_3
    //   78: ifeq +303 -> 381
    //   81: aload_1
    //   82: astore 4
    //   84: aload 4
    //   86: ifnull +376 -> 462
    //   89: aload_1
    //   90: invokevirtual 274	com/tencent/mm/loader/h/f:aru	()Lcom/tencent/mm/loader/h/b/a;
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +365 -> 462
    //   100: aload 4
    //   102: checkcast 134	java/io/Closeable
    //   105: astore 6
    //   107: aload 6
    //   109: checkcast 276	com/tencent/mm/loader/h/b/a
    //   112: astore 4
    //   114: invokestatic 282	java/lang/System:currentTimeMillis	()J
    //   117: pop2
    //   118: aload_0
    //   119: aload_1
    //   120: aload 4
    //   122: invokespecial 284	com/tencent/mm/loader/k/a:a	(Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/h/b/a;)Lcom/tencent/mm/loader/k/a$b;
    //   125: astore 9
    //   127: aload 9
    //   129: ifnull +275 -> 404
    //   132: aload 9
    //   134: getfield 288	com/tencent/mm/loader/k/a$b:hgU	Lcom/tencent/mm/loader/h/e;
    //   137: astore 4
    //   139: aload 4
    //   141: ifnull +177 -> 318
    //   144: new 290	com/tencent/mm/ad/b
    //   147: dup
    //   148: ldc_w 292
    //   151: invokespecial 293	com/tencent/mm/ad/b:<init>	(Ljava/lang/String;)V
    //   154: astore 10
    //   156: aload 7
    //   158: getfield 296	com/tencent/mm/loader/f:hcC	Lcom/tencent/mm/loader/e/c/a;
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +224 -> 387
    //   166: aload_1
    //   167: aload 7
    //   169: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   172: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   175: aload 7
    //   177: aload 4
    //   179: getstatic 299	com/tencent/mm/loader/e/c/b$b:hff	Lcom/tencent/mm/loader/e/c/b$b;
    //   182: invokevirtual 174	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   185: astore_1
    //   186: goto +366 -> 552
    //   189: aload 7
    //   191: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   194: astore 4
    //   196: aload 4
    //   198: ifnull +194 -> 392
    //   201: aload 4
    //   203: aload 7
    //   205: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   208: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   211: aload 7
    //   213: aload_1
    //   214: getstatic 299	com/tencent/mm/loader/e/c/b$b:hff	Lcom/tencent/mm/loader/e/c/b$b;
    //   217: invokevirtual 174	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   220: astore 4
    //   222: goto +340 -> 562
    //   225: aload 7
    //   227: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   230: astore 4
    //   232: aload 4
    //   234: ifnull +164 -> 398
    //   237: aload 4
    //   239: aload 7
    //   241: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   244: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   247: aload 7
    //   249: aload_1
    //   250: getstatic 302	com/tencent/mm/loader/e/c/b$b:hfe	Lcom/tencent/mm/loader/e/c/b$b;
    //   253: invokevirtual 174	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   256: astore 4
    //   258: goto +312 -> 570
    //   261: getstatic 308	d/z:MKo	Ld/z;
    //   264: astore 4
    //   266: aload 10
    //   268: invokevirtual 311	com/tencent/mm/ad/b:akO	()V
    //   271: aload_1
    //   272: invokevirtual 314	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   275: astore_1
    //   276: aload 8
    //   278: aload_1
    //   279: putfield 317	com/tencent/mm/loader/h/c:value	Ljava/lang/Object;
    //   282: aload_2
    //   283: aload 8
    //   285: invokeinterface 323 2 0
    //   290: aload_1
    //   291: ifnull +27 -> 318
    //   294: aload_0
    //   295: getfield 121	com/tencent/mm/loader/k/a:hdz	Lcom/tencent/mm/loader/b/b/e;
    //   298: astore_2
    //   299: aload_2
    //   300: ifnull +18 -> 318
    //   303: aload_2
    //   304: aload 7
    //   306: getfield 326	com/tencent/mm/loader/f:hcK	Lcom/tencent/mm/loader/h/a/a;
    //   309: aload 7
    //   311: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   314: aload_1
    //   315: invokevirtual 331	com/tencent/mm/loader/b/b/e:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/e/c/a;Ljava/lang/Object;)V
    //   318: new 290	com/tencent/mm/ad/b
    //   321: dup
    //   322: ldc_w 333
    //   325: invokespecial 293	com/tencent/mm/ad/b:<init>	(Ljava/lang/String;)V
    //   328: astore_1
    //   329: aload 9
    //   331: getfield 337	com/tencent/mm/loader/k/a$b:hgV	Ld/g/a/a;
    //   334: invokeinterface 340 1 0
    //   339: pop
    //   340: getstatic 308	d/z:MKo	Ld/z;
    //   343: astore_2
    //   344: aload_1
    //   345: invokevirtual 311	com/tencent/mm/ad/b:akO	()V
    //   348: aload 7
    //   350: getfield 344	com/tencent/mm/loader/f:hcD	Lcom/tencent/mm/loader/f/a;
    //   353: astore_1
    //   354: aload_1
    //   355: ifnull +14 -> 369
    //   358: aload_1
    //   359: iconst_1
    //   360: iconst_0
    //   361: anewarray 346	java/lang/Object
    //   364: invokeinterface 351 3 0
    //   369: aload 6
    //   371: aconst_null
    //   372: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   375: return
    //   376: iconst_0
    //   377: istore_3
    //   378: goto -301 -> 77
    //   381: aconst_null
    //   382: astore 4
    //   384: goto -300 -> 84
    //   387: aconst_null
    //   388: astore_1
    //   389: goto +163 -> 552
    //   392: aconst_null
    //   393: astore 4
    //   395: goto +167 -> 562
    //   398: aconst_null
    //   399: astore 4
    //   401: goto +169 -> 570
    //   404: getstatic 256	com/tencent/mm/loader/h/c:hgr	Lcom/tencent/mm/loader/h/c$a;
    //   407: astore_1
    //   408: aload 8
    //   410: invokestatic 354	com/tencent/mm/loader/h/c:ary	()I
    //   413: putfield 357	com/tencent/mm/loader/h/c:status	I
    //   416: aload 7
    //   418: getfield 344	com/tencent/mm/loader/f:hcD	Lcom/tencent/mm/loader/f/a;
    //   421: astore_1
    //   422: aload_1
    //   423: ifnull +14 -> 437
    //   426: aload_1
    //   427: iconst_0
    //   428: iconst_0
    //   429: anewarray 346	java/lang/Object
    //   432: invokeinterface 351 3 0
    //   437: aload_2
    //   438: invokeinterface 360 1 0
    //   443: aload 6
    //   445: aconst_null
    //   446: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   449: return
    //   450: astore_2
    //   451: aload_2
    //   452: athrow
    //   453: astore_1
    //   454: aload 6
    //   456: aload_2
    //   457: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   460: aload_1
    //   461: athrow
    //   462: getstatic 256	com/tencent/mm/loader/h/c:hgr	Lcom/tencent/mm/loader/h/c$a;
    //   465: astore_1
    //   466: aload 8
    //   468: invokestatic 363	com/tencent/mm/loader/h/c:arx	()I
    //   471: putfield 357	com/tencent/mm/loader/h/c:status	I
    //   474: ldc 222
    //   476: ldc_w 365
    //   479: iconst_2
    //   480: anewarray 346	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload_0
    //   486: getfield 233	com/tencent/mm/loader/k/b:heV	Lcom/tencent/mm/loader/h/a/a;
    //   489: aastore
    //   490: dup
    //   491: iconst_1
    //   492: invokestatic 371	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   495: invokevirtual 374	com/tencent/mm/sdk/platformtools/at:toString	()Ljava/lang/String;
    //   498: aastore
    //   499: invokestatic 377	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: aload 7
    //   504: getfield 344	com/tencent/mm/loader/f:hcD	Lcom/tencent/mm/loader/f/a;
    //   507: astore_1
    //   508: aload_1
    //   509: ifnull +14 -> 523
    //   512: aload_1
    //   513: iconst_0
    //   514: iconst_0
    //   515: anewarray 346	java/lang/Object
    //   518: invokeinterface 351 3 0
    //   523: aload_2
    //   524: invokeinterface 360 1 0
    //   529: return
    //   530: astore_1
    //   531: aload 5
    //   533: astore_2
    //   534: goto -80 -> 454
    //   537: aload 4
    //   539: astore_1
    //   540: goto -279 -> 261
    //   543: aload 4
    //   545: astore_1
    //   546: goto -321 -> 225
    //   549: goto -360 -> 189
    //   552: aload_1
    //   553: ifnonnull -4 -> 549
    //   556: aload 4
    //   558: astore_1
    //   559: goto -370 -> 189
    //   562: aload 4
    //   564: ifnonnull -21 -> 543
    //   567: goto -342 -> 225
    //   570: aload 4
    //   572: ifnonnull -35 -> 537
    //   575: goto -314 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	a
    //   0	578	1	paramf	com.tencent.mm.loader.h.f<?>
    //   0	578	2	parama	b.a<R>
    //   76	302	3	i	int
    //   48	523	4	localObject1	Object
    //   1	531	5	localObject2	Object
    //   105	350	6	localCloseable	java.io.Closeable
    //   62	441	7	localf	com.tencent.mm.loader.f
    //   10	457	8	localc	com.tencent.mm.loader.h.c
    //   125	205	9	localb	b
    //   154	113	10	localb1	com.tencent.mm.ad.b
    // Exception table:
    //   from	to	target	type
    //   107	127	450	java/lang/Throwable
    //   132	139	450	java/lang/Throwable
    //   144	162	450	java/lang/Throwable
    //   166	186	450	java/lang/Throwable
    //   189	196	450	java/lang/Throwable
    //   201	222	450	java/lang/Throwable
    //   225	232	450	java/lang/Throwable
    //   237	258	450	java/lang/Throwable
    //   261	290	450	java/lang/Throwable
    //   294	299	450	java/lang/Throwable
    //   303	318	450	java/lang/Throwable
    //   318	354	450	java/lang/Throwable
    //   358	369	450	java/lang/Throwable
    //   404	422	450	java/lang/Throwable
    //   426	437	450	java/lang/Throwable
    //   437	443	450	java/lang/Throwable
    //   451	453	453	finally
    //   107	127	530	finally
    //   132	139	530	finally
    //   144	162	530	finally
    //   166	186	530	finally
    //   189	196	530	finally
    //   201	222	530	finally
    //   225	232	530	finally
    //   237	258	530	finally
    //   261	290	530	finally
    //   294	299	530	finally
    //   303	318	530	finally
    //   318	354	530	finally
    //   358	369	530	finally
    //   404	422	530	finally
    //   426	437	530	finally
    //   437	443	530	finally
  }
  
  private final boolean asV()
  {
    if (this.heV == null) {}
    do
    {
      return false;
      if (com.tencent.mm.loader.l.a.d(this.heV)) {
        return true;
      }
    } while (this.hhg.hcp.hdQ != e.c.hep);
    return true;
  }
  
  /* Error */
  private final com.tencent.mm.loader.h.c<R> asW()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 218	com/tencent/mm/loader/h/c
    //   6: dup
    //   7: invokespecial 220	com/tencent/mm/loader/h/c:<init>	()V
    //   10: astore 5
    //   12: getstatic 256	com/tencent/mm/loader/h/c:hgr	Lcom/tencent/mm/loader/h/c$a;
    //   15: astore_1
    //   16: aload 5
    //   18: invokestatic 410	com/tencent/mm/loader/h/c:arA	()I
    //   21: putfield 264	com/tencent/mm/loader/h/c:from	I
    //   24: aload_0
    //   25: getfield 109	com/tencent/mm/loader/k/b:hhg	Lcom/tencent/mm/loader/f;
    //   28: astore 7
    //   30: aload_0
    //   31: getfield 116	com/tencent/mm/loader/k/a:hdA	Lcom/tencent/mm/loader/b/a/d;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +257 -> 293
    //   39: aload_0
    //   40: getfield 233	com/tencent/mm/loader/k/b:heV	Lcom/tencent/mm/loader/h/a/a;
    //   43: astore_2
    //   44: aload 7
    //   46: getfield 392	com/tencent/mm/loader/f:hcp	Lcom/tencent/mm/loader/c/e;
    //   49: astore_3
    //   50: aload_2
    //   51: ldc_w 412
    //   54: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   57: aload_3
    //   58: ldc_w 414
    //   61: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload 7
    //   66: ldc 103
    //   68: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   71: aload_2
    //   72: ldc_w 412
    //   75: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   78: aload_3
    //   79: ldc_w 414
    //   82: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aload 7
    //   87: ldc 103
    //   89: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   92: aload_1
    //   93: aload_2
    //   94: aload_3
    //   95: aload 7
    //   97: invokevirtual 419	com/tencent/mm/loader/b/a/d:b	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Lcom/tencent/mm/loader/h/b/a;
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +191 -> 293
    //   105: aload_1
    //   106: checkcast 134	java/io/Closeable
    //   109: astore 6
    //   111: aload 6
    //   113: checkcast 276	com/tencent/mm/loader/h/b/a
    //   116: astore 8
    //   118: aload_0
    //   119: getfield 126	com/tencent/mm/loader/k/a:hgS	Lcom/tencent/mm/loader/d/d;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +172 -> 296
    //   127: aload_1
    //   128: aload 7
    //   130: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   133: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   136: aload 7
    //   138: aload 8
    //   140: invokevirtual 149	com/tencent/mm/loader/d/d:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/b/a;)Lcom/tencent/mm/loader/h/e;
    //   143: astore_1
    //   144: aload_1
    //   145: astore_2
    //   146: aload_1
    //   147: instanceof 151
    //   150: ifne +5 -> 155
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: ifnull +219 -> 375
    //   159: aload 7
    //   161: getfield 296	com/tencent/mm/loader/f:hcC	Lcom/tencent/mm/loader/e/c/a;
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull +135 -> 301
    //   169: aload_1
    //   170: aload 7
    //   172: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   175: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   178: aload 7
    //   180: aload_2
    //   181: getstatic 299	com/tencent/mm/loader/e/c/b$b:hff	Lcom/tencent/mm/loader/e/c/b$b;
    //   184: invokevirtual 174	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   187: astore_3
    //   188: goto +181 -> 369
    //   191: aload_1
    //   192: ifnull +194 -> 386
    //   195: aload 7
    //   197: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   200: astore_2
    //   201: aload_2
    //   202: ifnull +104 -> 306
    //   205: aload_2
    //   206: aload 7
    //   208: invokevirtual 138	com/tencent/mm/loader/f:aqG	()Lcom/tencent/mm/loader/e/b/d;
    //   211: getfield 144	com/tencent/mm/loader/e/b/d:heH	Lcom/tencent/mm/loader/e/b/g;
    //   214: aload 7
    //   216: aload_1
    //   217: getstatic 299	com/tencent/mm/loader/e/c/b$b:hff	Lcom/tencent/mm/loader/e/c/b$b;
    //   220: invokevirtual 174	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   223: astore_3
    //   224: goto +156 -> 380
    //   227: aload_2
    //   228: ifnull +50 -> 278
    //   231: aload_2
    //   232: invokevirtual 422	com/tencent/mm/loader/h/e:isValid	()Z
    //   235: ifeq +76 -> 311
    //   238: aload_2
    //   239: ifnull +39 -> 278
    //   242: aload_0
    //   243: getfield 121	com/tencent/mm/loader/k/a:hdz	Lcom/tencent/mm/loader/b/b/e;
    //   246: astore_1
    //   247: aload_1
    //   248: ifnull +21 -> 269
    //   251: aload_1
    //   252: aload 7
    //   254: getfield 326	com/tencent/mm/loader/f:hcK	Lcom/tencent/mm/loader/h/a/a;
    //   257: aload 7
    //   259: getfield 155	com/tencent/mm/loader/f:hcB	Lcom/tencent/mm/loader/e/c/a;
    //   262: aload_2
    //   263: invokevirtual 314	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   266: invokevirtual 331	com/tencent/mm/loader/b/b/e:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/e/c/a;Ljava/lang/Object;)V
    //   269: aload 5
    //   271: aload_2
    //   272: invokevirtual 314	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   275: putfield 317	com/tencent/mm/loader/h/c:value	Ljava/lang/Object;
    //   278: aload 8
    //   280: invokevirtual 425	com/tencent/mm/loader/h/b/a:close	()V
    //   283: getstatic 308	d/z:MKo	Ld/z;
    //   286: astore_1
    //   287: aload 6
    //   289: aconst_null
    //   290: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   293: aload 5
    //   295: areturn
    //   296: aconst_null
    //   297: astore_1
    //   298: goto -154 -> 144
    //   301: aconst_null
    //   302: astore_3
    //   303: goto +66 -> 369
    //   306: aconst_null
    //   307: astore_3
    //   308: goto +72 -> 380
    //   311: aconst_null
    //   312: astore_2
    //   313: goto -75 -> 238
    //   316: astore_2
    //   317: aload_2
    //   318: athrow
    //   319: astore_1
    //   320: aload 6
    //   322: aload_2
    //   323: invokestatic 193	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   326: aload_1
    //   327: athrow
    //   328: astore_1
    //   329: ldc 222
    //   331: aload_1
    //   332: checkcast 132	java/lang/Throwable
    //   335: ldc_w 427
    //   338: iconst_2
    //   339: anewarray 346	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: aload_0
    //   345: getfield 233	com/tencent/mm/loader/k/b:heV	Lcom/tencent/mm/loader/h/a/a;
    //   348: aastore
    //   349: dup
    //   350: iconst_1
    //   351: aload_0
    //   352: getfield 431	com/tencent/mm/loader/k/b:hcM	Ljava/lang/String;
    //   355: aastore
    //   356: invokestatic 435	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: aload 5
    //   361: areturn
    //   362: astore_1
    //   363: aload 4
    //   365: astore_2
    //   366: goto -46 -> 320
    //   369: aload_3
    //   370: astore_1
    //   371: aload_3
    //   372: ifnonnull -181 -> 191
    //   375: aload_2
    //   376: astore_1
    //   377: goto -186 -> 191
    //   380: aload_3
    //   381: astore_2
    //   382: aload_3
    //   383: ifnonnull -156 -> 227
    //   386: aload_1
    //   387: astore_2
    //   388: goto -161 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	a
    //   15	283	1	localObject1	Object
    //   319	8	1	localObject2	Object
    //   328	4	1	localException	Exception
    //   362	1	1	localObject3	Object
    //   370	17	1	localObject4	Object
    //   43	270	2	localObject5	Object
    //   316	7	2	localThrowable	Throwable
    //   365	23	2	localObject6	Object
    //   49	334	3	localObject7	Object
    //   1	363	4	localObject8	Object
    //   10	350	5	localc	com.tencent.mm.loader.h.c
    //   109	212	6	localCloseable	java.io.Closeable
    //   28	230	7	localf	com.tencent.mm.loader.f
    //   116	163	8	locala	com.tencent.mm.loader.h.b.a
    // Exception table:
    //   from	to	target	type
    //   111	123	316	java/lang/Throwable
    //   127	144	316	java/lang/Throwable
    //   146	153	316	java/lang/Throwable
    //   159	165	316	java/lang/Throwable
    //   169	188	316	java/lang/Throwable
    //   195	201	316	java/lang/Throwable
    //   205	224	316	java/lang/Throwable
    //   231	238	316	java/lang/Throwable
    //   242	247	316	java/lang/Throwable
    //   251	269	316	java/lang/Throwable
    //   269	278	316	java/lang/Throwable
    //   278	287	316	java/lang/Throwable
    //   317	319	319	finally
    //   24	35	328	java/lang/Exception
    //   39	101	328	java/lang/Exception
    //   105	111	328	java/lang/Exception
    //   287	293	328	java/lang/Exception
    //   320	328	328	java/lang/Exception
    //   111	123	362	finally
    //   127	144	362	finally
    //   146	153	362	finally
    //   159	165	362	finally
    //   169	188	362	finally
    //   195	201	362	finally
    //   205	224	362	finally
    //   231	238	362	finally
    //   242	247	362	finally
    //   251	269	362	finally
    //   269	278	362	finally
    //   278	287	362	finally
  }
  
  protected final void a(final e.c paramc, final b.a<R> parama)
  {
    boolean bool = true;
    p.h(paramc, "fileType");
    p.h(parama, "taskListener");
    for (;;)
    {
      try
      {
        System.currentTimeMillis();
        ad.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. key:" + this.heV + " fileType " + paramc + " [width:" + this.hcL + ".weakHolder.viewWidth height:" + this.hcL + ".weakHolder.viewHeight] diskCache " + this.hdA + " producer " + this.hgS + " isLocalFile: " + asV());
        Object localObject = asW();
        if ((!asV()) && (((com.tencent.mm.loader.h.c)localObject).value == null))
        {
          ad.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + localObject + " bitmap " + ((com.tencent.mm.loader.h.c)localObject).value + " isNeedDownload " + bool);
          if (!bool)
          {
            parama.d((com.tencent.mm.loader.h.c)localObject);
            return;
          }
          com.tencent.mm.loader.f localf = this.hhg;
          final long l;
          try
          {
            l = System.currentTimeMillis();
            ad.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from memory failed.now try to get from network. " + this.heV + " fileType: " + paramc);
            if (localf.hct != null) {
              localf.aqG();
            }
            localObject = localf.hcu;
            if (localf.hcz.a(this.heV))
            {
              if (localObject != null) {
                continue;
              }
              a(null, parama);
              ad.i("MicroMsg.Loader.ImageLoadWorkTask", "can not download image, over limit " + this.heV);
              return;
            }
          }
          catch (Exception paramc)
          {
            ad.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", (Throwable)paramc, "[ImageLoader DownLoadException] run error %s [debug info %s]", new Object[] { this.heV, localf.hcM });
            paramc = z.MKo;
            return;
          }
          localObject = null;
          continue;
          localObject = localf.hcu;
          com.tencent.mm.loader.h.a.a locala = this.heV;
          g localg = localf.hcG;
          com.tencent.mm.loader.g.b localb = this.hfk;
          if (localb == null) {
            p.bcb("loader");
          }
          paramc = (com.tencent.mm.loader.d.b.a)new c(localf, l, this, paramc, parama);
          p.h(locala, "url");
          p.h(localg, "fileNameCreator");
          p.h(localb, "loader");
          p.h(paramc, "callback");
          localb.C((Runnable)new b.c((com.tencent.mm.loader.d.b)localObject, localb, locala, localg, paramc));
          return;
        }
      }
      catch (Exception paramc)
      {
        ad.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", (Throwable)paramc, "[ImageLoader execute] " + paramc.getMessage() + " run error " + this.heV + " [debug info " + this.hcM + ']', new Object[0]);
        parama.asX();
        return;
      }
      bool = false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "R", "", "result", "Lcom/tencent/mm/loader/model/Resource;", "block", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/loader/model/Resource;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getResult", "()Lcom/tencent/mm/loader/model/Resource;", "setResult", "(Lcom/tencent/mm/loader/model/Resource;)V", "commit", "libimageloader_release"})
  public static final class b<R>
  {
    com.tencent.mm.loader.h.e<R> hgU;
    final d.g.a.a<z> hgV;
    
    public b(com.tencent.mm.loader.h.e<R> parame, d.g.a.a<z> parama)
    {
      this.hgU = parame;
      this.hgV = parama;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/loader/task/ImageLoadWorkTask$executeTask$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$also$lambda$1"})
  public static final class c
    implements com.tencent.mm.loader.d.b.a
  {
    c(com.tencent.mm.loader.f paramf, long paramLong, a parama, e.c paramc, b.a parama1) {}
    
    public final void a(com.tencent.mm.loader.h.f<?> paramf)
    {
      p.h(paramf, "resp");
      a.a(paramc, paramf, this.hha);
    }
    
    public final void onError()
    {
      a.a(paramc, null, this.hha);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "R", "invoke", "com/tencent/mm/loader/task/ImageLoadWorkTask$producerThenCommitDisk$1$1$1$2", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$let$lambda$1", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$use$lambda$1"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(com.tencent.mm.loader.h.e parame, com.tencent.mm.loader.f paramf, a parama, com.tencent.mm.loader.h.b.a parama1, com.tencent.mm.loader.h.f paramf1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.k.a
 * JD-Core Version:    0.7.0.1
 */