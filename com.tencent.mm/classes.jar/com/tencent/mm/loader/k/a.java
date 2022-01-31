package com.tencent.mm.loader.k;

import a.f.b.j;
import a.l;
import a.y;
import com.tencent.mm.loader.c.e.b;
import com.tencent.mm.loader.d.b.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/task/ImageLoadWorkTask;", "T", "R", "Lcom/tencent/mm/loader/task/LoadTask;", "_url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "isLocalFile", "", "()Z", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "producer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getProducer$libimageloader_release", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setProducer$libimageloader_release", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "batchGet", "", "readNetworkStart", "", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "executeTask", "loadFromDisk", "Lcom/tencent/mm/loader/model/LoadResult;", "producerThenCommitDisk", "Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "whenDataReady", "Companion", "LazyTask", "libimageloader_release"})
public final class a<T, R>
  extends b<T, R>
{
  public static final a.a eQD = new a.a((byte)0);
  private com.tencent.mm.loader.b.b.d<T, R> eNx = this.eQQ.eML;
  private com.tencent.mm.loader.b.a.d<T, R> eNy = this.eQQ.eMM;
  private com.tencent.mm.loader.d.d<R> eQC = this.eQQ.eMQ;
  
  public a(com.tencent.mm.loader.h.a.a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    super(parama, paramd, paramf);
  }
  
  private final boolean Um()
  {
    if (this.eOQ == null) {}
    do
    {
      return false;
      if (com.tencent.mm.loader.l.a.d(this.eOQ)) {
        return true;
      }
    } while (this.eQQ.eMG.Tv() != e.b.eOo);
    return true;
  }
  
  /* Error */
  private final com.tencent.mm.loader.h.c<R> Un()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 158	com/tencent/mm/loader/h/c
    //   6: dup
    //   7: invokespecial 160	com/tencent/mm/loader/h/c:<init>	()V
    //   10: astore 5
    //   12: getstatic 164	com/tencent/mm/loader/h/c:eQe	Lcom/tencent/mm/loader/h/c$a;
    //   15: astore_1
    //   16: aload 5
    //   18: invokestatic 168	com/tencent/mm/loader/h/c:Ua	()I
    //   21: putfield 172	com/tencent/mm/loader/h/c:from	I
    //   24: aload_0
    //   25: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   28: astore 7
    //   30: aload_0
    //   31: getfield 111	com/tencent/mm/loader/k/a:eNy	Lcom/tencent/mm/loader/b/a/d;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +253 -> 289
    //   39: aload_0
    //   40: getfield 128	com/tencent/mm/loader/k/b:eOQ	Lcom/tencent/mm/loader/h/a/a;
    //   43: astore_2
    //   44: aload 7
    //   46: getfield 138	com/tencent/mm/loader/f:eMG	Lcom/tencent/mm/loader/c/e;
    //   49: astore_3
    //   50: aload_2
    //   51: ldc 174
    //   53: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   56: aload_3
    //   57: ldc 176
    //   59: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   62: aload 7
    //   64: ldc 98
    //   66: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   69: aload_2
    //   70: ldc 174
    //   72: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload_3
    //   76: ldc 176
    //   78: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   81: aload 7
    //   83: ldc 98
    //   85: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   88: aload_1
    //   89: aload_2
    //   90: aload_3
    //   91: aload 7
    //   93: invokevirtual 182	com/tencent/mm/loader/b/a/d:c	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/c/e;Lcom/tencent/mm/loader/f;)Lcom/tencent/mm/loader/h/b/a;
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +191 -> 289
    //   101: aload_1
    //   102: checkcast 184	java/io/Closeable
    //   105: astore 6
    //   107: aload 6
    //   109: checkcast 186	com/tencent/mm/loader/h/b/a
    //   112: astore 8
    //   114: aload_0
    //   115: getfield 121	com/tencent/mm/loader/k/a:eQC	Lcom/tencent/mm/loader/d/d;
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull +172 -> 292
    //   123: aload_1
    //   124: aload 7
    //   126: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   129: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   132: aload 7
    //   134: aload 8
    //   136: invokevirtual 202	com/tencent/mm/loader/d/d:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/b/a;)Lcom/tencent/mm/loader/h/e;
    //   139: astore_1
    //   140: aload_1
    //   141: astore_2
    //   142: aload_1
    //   143: instanceof 204
    //   146: ifne +5 -> 151
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +220 -> 372
    //   155: aload 7
    //   157: getfield 208	com/tencent/mm/loader/f:eMS	Lcom/tencent/mm/loader/e/c/a;
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +135 -> 297
    //   165: aload_1
    //   166: aload 7
    //   168: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   171: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   174: aload 7
    //   176: aload_2
    //   177: getstatic 214	com/tencent/mm/loader/e/c/b$b:ePa	Lcom/tencent/mm/loader/e/c/b$b;
    //   180: invokevirtual 219	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   183: astore_3
    //   184: goto +182 -> 366
    //   187: aload_1
    //   188: ifnull +195 -> 383
    //   191: aload 7
    //   193: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   196: astore_2
    //   197: aload_2
    //   198: ifnull +104 -> 302
    //   201: aload_2
    //   202: aload 7
    //   204: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   207: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   210: aload 7
    //   212: aload_1
    //   213: getstatic 214	com/tencent/mm/loader/e/c/b$b:ePa	Lcom/tencent/mm/loader/e/c/b$b;
    //   216: invokevirtual 219	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   219: astore_3
    //   220: goto +157 -> 377
    //   223: aload_2
    //   224: ifnull +50 -> 274
    //   227: aload_2
    //   228: invokevirtual 225	com/tencent/mm/loader/h/e:isValid	()Z
    //   231: ifeq +76 -> 307
    //   234: aload_2
    //   235: ifnull +39 -> 274
    //   238: aload_0
    //   239: getfield 116	com/tencent/mm/loader/k/a:eNx	Lcom/tencent/mm/loader/b/b/d;
    //   242: astore_1
    //   243: aload_1
    //   244: ifnull +21 -> 265
    //   247: aload_1
    //   248: aload 7
    //   250: getfield 228	com/tencent/mm/loader/f:eMZ	Lcom/tencent/mm/loader/h/a/a;
    //   253: aload 7
    //   255: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   258: aload_2
    //   259: invokevirtual 232	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   262: invokevirtual 237	com/tencent/mm/loader/b/b/d:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/e/c/a;Ljava/lang/Object;)V
    //   265: aload 5
    //   267: aload_2
    //   268: invokevirtual 232	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   271: putfield 241	com/tencent/mm/loader/h/c:value	Ljava/lang/Object;
    //   274: aload 8
    //   276: invokevirtual 244	com/tencent/mm/loader/h/b/a:close	()V
    //   279: getstatic 250	a/y:BMg	La/y;
    //   282: astore_1
    //   283: aload 6
    //   285: aconst_null
    //   286: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   289: aload 5
    //   291: areturn
    //   292: aconst_null
    //   293: astore_1
    //   294: goto -154 -> 140
    //   297: aconst_null
    //   298: astore_3
    //   299: goto +67 -> 366
    //   302: aconst_null
    //   303: astore_3
    //   304: goto +73 -> 377
    //   307: aconst_null
    //   308: astore_2
    //   309: goto -75 -> 234
    //   312: astore_2
    //   313: aload_2
    //   314: athrow
    //   315: astore_1
    //   316: aload 6
    //   318: aload_2
    //   319: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   322: aload_1
    //   323: athrow
    //   324: astore_1
    //   325: ldc_w 257
    //   328: aload_1
    //   329: checkcast 156	java/lang/Throwable
    //   332: ldc_w 259
    //   335: iconst_2
    //   336: anewarray 261	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: aload_0
    //   342: getfield 128	com/tencent/mm/loader/k/b:eOQ	Lcom/tencent/mm/loader/h/a/a;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: aload_0
    //   349: getfield 265	com/tencent/mm/loader/k/b:eNb	Ljava/lang/String;
    //   352: aastore
    //   353: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   356: aload 5
    //   358: areturn
    //   359: astore_1
    //   360: aload 4
    //   362: astore_2
    //   363: goto -47 -> 316
    //   366: aload_3
    //   367: astore_1
    //   368: aload_3
    //   369: ifnonnull -182 -> 187
    //   372: aload_2
    //   373: astore_1
    //   374: goto -187 -> 187
    //   377: aload_3
    //   378: astore_2
    //   379: aload_3
    //   380: ifnonnull -157 -> 223
    //   383: aload_1
    //   384: astore_2
    //   385: goto -162 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	a
    //   15	279	1	localObject1	Object
    //   315	8	1	localObject2	Object
    //   324	5	1	localException	Exception
    //   359	1	1	localObject3	Object
    //   367	17	1	localObject4	Object
    //   43	266	2	localObject5	Object
    //   312	7	2	localThrowable	Throwable
    //   362	23	2	localObject6	Object
    //   49	331	3	localObject7	Object
    //   1	360	4	localObject8	Object
    //   10	347	5	localc	com.tencent.mm.loader.h.c
    //   105	212	6	localCloseable	java.io.Closeable
    //   28	226	7	localf	com.tencent.mm.loader.f
    //   112	163	8	locala	com.tencent.mm.loader.h.b.a
    // Exception table:
    //   from	to	target	type
    //   107	119	312	java/lang/Throwable
    //   123	140	312	java/lang/Throwable
    //   142	149	312	java/lang/Throwable
    //   155	161	312	java/lang/Throwable
    //   165	184	312	java/lang/Throwable
    //   191	197	312	java/lang/Throwable
    //   201	220	312	java/lang/Throwable
    //   227	234	312	java/lang/Throwable
    //   238	243	312	java/lang/Throwable
    //   247	265	312	java/lang/Throwable
    //   265	274	312	java/lang/Throwable
    //   274	283	312	java/lang/Throwable
    //   313	315	315	finally
    //   24	35	324	java/lang/Exception
    //   39	97	324	java/lang/Exception
    //   101	107	324	java/lang/Exception
    //   283	289	324	java/lang/Exception
    //   316	324	324	java/lang/Exception
    //   107	119	359	finally
    //   123	140	359	finally
    //   142	149	359	finally
    //   155	161	359	finally
    //   165	184	359	finally
    //   191	197	359	finally
    //   201	220	359	finally
    //   227	234	359	finally
    //   238	243	359	finally
    //   247	265	359	finally
    //   265	274	359	finally
    //   274	283	359	finally
  }
  
  /* Error */
  private final a.b<R> a(com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.b.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   7: astore 9
    //   9: aload_2
    //   10: checkcast 184	java/io/Closeable
    //   13: astore 8
    //   15: aload_0
    //   16: getfield 121	com/tencent/mm/loader/k/a:eQC	Lcom/tencent/mm/loader/d/d;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +226 -> 249
    //   26: aload 4
    //   28: aload 9
    //   30: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   33: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   36: aload_0
    //   37: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   40: aload_2
    //   41: invokevirtual 202	com/tencent/mm/loader/d/d:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/b/a;)Lcom/tencent/mm/loader/h/e;
    //   44: astore 4
    //   46: aload 4
    //   48: astore 5
    //   50: aload 4
    //   52: instanceof 204
    //   55: ifne +6 -> 61
    //   58: aconst_null
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +380 -> 443
    //   66: aload 9
    //   68: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   71: astore 11
    //   73: aload 11
    //   75: ifnull +333 -> 408
    //   78: getstatic 276	com/tencent/mm/loader/e/c/b$b:ePb	Lcom/tencent/mm/loader/e/c/b$b;
    //   81: astore 10
    //   83: aload 10
    //   85: ldc_w 278
    //   88: invokestatic 96	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload 11
    //   93: checkcast 216	com/tencent/mm/loader/e/c/a
    //   96: getfield 284	com/tencent/mm/loader/e/c/b:eOS	Lcom/tencent/mm/loader/e/c/b;
    //   99: astore 6
    //   101: aload 6
    //   103: astore 4
    //   105: aload 6
    //   107: instanceof 280
    //   110: ifne +360 -> 470
    //   113: aconst_null
    //   114: astore 4
    //   116: goto +354 -> 470
    //   119: aload 11
    //   121: checkcast 216	com/tencent/mm/loader/e/c/a
    //   124: getfield 284	com/tencent/mm/loader/e/c/b:eOS	Lcom/tencent/mm/loader/e/c/b;
    //   127: astore 6
    //   129: aload 6
    //   131: astore 4
    //   133: aload 6
    //   135: instanceof 280
    //   138: ifne +344 -> 482
    //   141: aconst_null
    //   142: astore 4
    //   144: goto +338 -> 482
    //   147: aload 11
    //   149: checkcast 216	com/tencent/mm/loader/e/c/a
    //   152: getfield 284	com/tencent/mm/loader/e/c/b:eOS	Lcom/tencent/mm/loader/e/c/b;
    //   155: astore 6
    //   157: aload 6
    //   159: astore 4
    //   161: aload 6
    //   163: instanceof 280
    //   166: ifne +328 -> 494
    //   169: aconst_null
    //   170: astore 4
    //   172: goto +322 -> 494
    //   175: iload_3
    //   176: iconst_1
    //   177: if_icmpne +231 -> 408
    //   180: aload 9
    //   182: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +256 -> 443
    //   190: aload_2
    //   191: aload 9
    //   193: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   196: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   199: aload 9
    //   201: aload 5
    //   203: getstatic 276	com/tencent/mm/loader/e/c/b$b:ePb	Lcom/tencent/mm/loader/e/c/b$b;
    //   206: invokevirtual 219	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull +232 -> 443
    //   214: aload_0
    //   215: aload_1
    //   216: aload 5
    //   218: aload_2
    //   219: aload_0
    //   220: checkcast 5	com/tencent/mm/loader/k/b
    //   223: invokevirtual 287	com/tencent/mm/loader/k/a:a	(Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/k/b;)V
    //   226: new 9	com/tencent/mm/loader/k/a$b
    //   229: dup
    //   230: aload_2
    //   231: getstatic 293	com/tencent/mm/loader/k/a$e:eQO	Lcom/tencent/mm/loader/k/a$e;
    //   234: checkcast 295	a/f/a/a
    //   237: invokespecial 298	com/tencent/mm/loader/k/a$b:<init>	(Lcom/tencent/mm/loader/h/e;La/f/a/a;)V
    //   240: astore_1
    //   241: aload 8
    //   243: aconst_null
    //   244: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   247: aload_1
    //   248: areturn
    //   249: aconst_null
    //   250: astore 4
    //   252: goto -206 -> 46
    //   255: aload 6
    //   257: getfield 302	com/tencent/mm/loader/e/c/b:eOT	Lcom/tencent/mm/loader/e/c/b$a;
    //   260: getstatic 307	com/tencent/mm/loader/e/c/b$a:eOX	Lcom/tencent/mm/loader/e/c/b$a;
    //   263: if_acmpne +18 -> 281
    //   266: aload 10
    //   268: aload 6
    //   270: getfield 310	com/tencent/mm/loader/e/c/b:eOU	Lcom/tencent/mm/loader/e/c/b$b;
    //   273: if_acmpne +8 -> 281
    //   276: iconst_1
    //   277: istore_3
    //   278: goto -103 -> 175
    //   281: aload 6
    //   283: getfield 284	com/tencent/mm/loader/e/c/b:eOS	Lcom/tencent/mm/loader/e/c/b;
    //   286: astore 6
    //   288: aload 6
    //   290: astore 4
    //   292: aload 6
    //   294: instanceof 280
    //   297: ifne +211 -> 508
    //   300: aconst_null
    //   301: astore 4
    //   303: goto +205 -> 508
    //   306: aload 6
    //   308: getfield 302	com/tencent/mm/loader/e/c/b:eOT	Lcom/tencent/mm/loader/e/c/b$a;
    //   311: getstatic 313	com/tencent/mm/loader/e/c/b$a:eOW	Lcom/tencent/mm/loader/e/c/b$a;
    //   314: if_acmpne +18 -> 332
    //   317: aload 10
    //   319: aload 6
    //   321: getfield 310	com/tencent/mm/loader/e/c/b:eOU	Lcom/tencent/mm/loader/e/c/b$b;
    //   324: if_acmpne +8 -> 332
    //   327: iconst_1
    //   328: istore_3
    //   329: goto -154 -> 175
    //   332: aload 6
    //   334: getfield 284	com/tencent/mm/loader/e/c/b:eOS	Lcom/tencent/mm/loader/e/c/b;
    //   337: astore 6
    //   339: aload 6
    //   341: astore 4
    //   343: aload 6
    //   345: instanceof 280
    //   348: ifne +172 -> 520
    //   351: aconst_null
    //   352: astore 4
    //   354: goto +166 -> 520
    //   357: aload 6
    //   359: getfield 302	com/tencent/mm/loader/e/c/b:eOT	Lcom/tencent/mm/loader/e/c/b$a;
    //   362: getstatic 316	com/tencent/mm/loader/e/c/b$a:eOV	Lcom/tencent/mm/loader/e/c/b$a;
    //   365: if_acmpne +18 -> 383
    //   368: aload 10
    //   370: aload 6
    //   372: getfield 310	com/tencent/mm/loader/e/c/b:eOU	Lcom/tencent/mm/loader/e/c/b$b;
    //   375: if_acmpne +8 -> 383
    //   378: iconst_1
    //   379: istore_3
    //   380: goto -205 -> 175
    //   383: aload 6
    //   385: getfield 284	com/tencent/mm/loader/e/c/b:eOS	Lcom/tencent/mm/loader/e/c/b;
    //   388: astore 6
    //   390: aload 6
    //   392: astore 4
    //   394: aload 6
    //   396: instanceof 280
    //   399: ifne +133 -> 532
    //   402: aconst_null
    //   403: astore 4
    //   405: goto +127 -> 532
    //   408: new 9	com/tencent/mm/loader/k/a$b
    //   411: dup
    //   412: aload 5
    //   414: new 318	com/tencent/mm/loader/k/a$d
    //   417: dup
    //   418: aload 5
    //   420: aload 9
    //   422: aload_0
    //   423: aload_2
    //   424: aload_1
    //   425: invokespecial 321	com/tencent/mm/loader/k/a$d:<init>	(Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/k/a;Lcom/tencent/mm/loader/h/b/a;Lcom/tencent/mm/loader/h/f;)V
    //   428: checkcast 295	a/f/a/a
    //   431: invokespecial 298	com/tencent/mm/loader/k/a$b:<init>	(Lcom/tencent/mm/loader/h/e;La/f/a/a;)V
    //   434: astore_1
    //   435: aload 8
    //   437: aconst_null
    //   438: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   441: aload_1
    //   442: areturn
    //   443: aload 8
    //   445: aconst_null
    //   446: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   449: aconst_null
    //   450: areturn
    //   451: astore_2
    //   452: aload_2
    //   453: athrow
    //   454: astore_1
    //   455: aload 8
    //   457: aload_2
    //   458: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   461: aload_1
    //   462: athrow
    //   463: astore_1
    //   464: aload 7
    //   466: astore_2
    //   467: goto -12 -> 455
    //   470: aload 4
    //   472: astore 6
    //   474: aload 4
    //   476: ifnonnull -221 -> 255
    //   479: goto -360 -> 119
    //   482: aload 4
    //   484: astore 6
    //   486: aload 4
    //   488: ifnonnull -182 -> 306
    //   491: goto -344 -> 147
    //   494: aload 4
    //   496: astore 6
    //   498: aload 4
    //   500: ifnonnull -143 -> 357
    //   503: iconst_0
    //   504: istore_3
    //   505: goto -330 -> 175
    //   508: aload 4
    //   510: astore 6
    //   512: aload 4
    //   514: ifnonnull -259 -> 255
    //   517: goto -398 -> 119
    //   520: aload 4
    //   522: astore 6
    //   524: aload 4
    //   526: ifnonnull -220 -> 306
    //   529: goto -382 -> 147
    //   532: aload 4
    //   534: astore 6
    //   536: aload 4
    //   538: ifnonnull -181 -> 357
    //   541: goto -38 -> 503
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	a
    //   0	544	1	paramf	com.tencent.mm.loader.h.f<?>
    //   0	544	2	parama	com.tencent.mm.loader.h.b.a
    //   175	330	3	i	int
    //   19	518	4	localObject1	Object
    //   48	371	5	localObject2	Object
    //   99	436	6	localObject3	Object
    //   1	464	7	localObject4	Object
    //   13	443	8	localCloseable	java.io.Closeable
    //   7	414	9	localf	com.tencent.mm.loader.f
    //   81	288	10	localb	com.tencent.mm.loader.e.c.b.b
    //   71	77	11	locala	com.tencent.mm.loader.e.c.a
    // Exception table:
    //   from	to	target	type
    //   15	21	451	java/lang/Throwable
    //   26	46	451	java/lang/Throwable
    //   50	58	451	java/lang/Throwable
    //   66	73	451	java/lang/Throwable
    //   78	101	451	java/lang/Throwable
    //   105	113	451	java/lang/Throwable
    //   119	129	451	java/lang/Throwable
    //   133	141	451	java/lang/Throwable
    //   147	157	451	java/lang/Throwable
    //   161	169	451	java/lang/Throwable
    //   180	186	451	java/lang/Throwable
    //   190	210	451	java/lang/Throwable
    //   214	241	451	java/lang/Throwable
    //   255	276	451	java/lang/Throwable
    //   281	288	451	java/lang/Throwable
    //   292	300	451	java/lang/Throwable
    //   306	327	451	java/lang/Throwable
    //   332	339	451	java/lang/Throwable
    //   343	351	451	java/lang/Throwable
    //   357	378	451	java/lang/Throwable
    //   383	390	451	java/lang/Throwable
    //   394	402	451	java/lang/Throwable
    //   408	435	451	java/lang/Throwable
    //   452	454	454	finally
    //   15	21	463	finally
    //   26	46	463	finally
    //   50	58	463	finally
    //   66	73	463	finally
    //   78	101	463	finally
    //   105	113	463	finally
    //   119	129	463	finally
    //   133	141	463	finally
    //   147	157	463	finally
    //   161	169	463	finally
    //   180	186	463	finally
    //   190	210	463	finally
    //   214	241	463	finally
    //   255	276	463	finally
    //   281	288	463	finally
    //   292	300	463	finally
    //   306	327	463	finally
    //   332	339	463	finally
    //   343	351	463	finally
    //   357	378	463	finally
    //   383	390	463	finally
    //   394	402	463	finally
    //   408	435	463	finally
  }
  
  /* Error */
  private final void a(com.tencent.mm.loader.h.f<?> paramf, b.a<R> parama)
  {
    // Byte code:
    //   0: new 158	com/tencent/mm/loader/h/c
    //   3: dup
    //   4: invokespecial 160	com/tencent/mm/loader/h/c:<init>	()V
    //   7: astore 7
    //   9: getstatic 164	com/tencent/mm/loader/h/c:eQe	Lcom/tencent/mm/loader/h/c$a;
    //   12: astore 4
    //   14: aload 7
    //   16: invokestatic 326	com/tencent/mm/loader/h/c:Ub	()I
    //   19: putfield 172	com/tencent/mm/loader/h/c:from	I
    //   22: aload_0
    //   23: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   26: astore 6
    //   28: aload_1
    //   29: ifnull +429 -> 458
    //   32: aload_1
    //   33: invokevirtual 330	com/tencent/mm/loader/h/f:value	()Ljava/lang/Object;
    //   36: ifnull +315 -> 351
    //   39: iconst_1
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +314 -> 356
    //   45: aload_1
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +408 -> 458
    //   53: aload_1
    //   54: invokevirtual 334	com/tencent/mm/loader/h/f:TU	()Lcom/tencent/mm/loader/h/b/a;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +397 -> 458
    //   64: aload 4
    //   66: checkcast 184	java/io/Closeable
    //   69: astore 5
    //   71: aload 5
    //   73: checkcast 186	com/tencent/mm/loader/h/b/a
    //   76: astore 4
    //   78: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   81: pop2
    //   82: aload_0
    //   83: aload_1
    //   84: aload 4
    //   86: invokespecial 342	com/tencent/mm/loader/k/a:a	(Lcom/tencent/mm/loader/h/f;Lcom/tencent/mm/loader/h/b/a;)Lcom/tencent/mm/loader/k/a$b;
    //   89: astore 8
    //   91: aload 8
    //   93: ifnull +291 -> 384
    //   96: aload 8
    //   98: getfield 346	com/tencent/mm/loader/k/a$b:eQE	Lcom/tencent/mm/loader/h/e;
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull +177 -> 282
    //   108: new 348	com/tencent/mm/ab/a
    //   111: dup
    //   112: ldc_w 350
    //   115: invokespecial 353	com/tencent/mm/ab/a:<init>	(Ljava/lang/String;)V
    //   118: astore 9
    //   120: aload 6
    //   122: getfield 208	com/tencent/mm/loader/f:eMS	Lcom/tencent/mm/loader/e/c/a;
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +235 -> 362
    //   130: aload_1
    //   131: aload 6
    //   133: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   136: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   139: aload 6
    //   141: aload 4
    //   143: getstatic 214	com/tencent/mm/loader/e/c/b$b:ePa	Lcom/tencent/mm/loader/e/c/b$b;
    //   146: invokevirtual 219	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   149: astore_1
    //   150: goto +420 -> 570
    //   153: aload 6
    //   155: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   158: astore 4
    //   160: aload 4
    //   162: ifnull +205 -> 367
    //   165: aload 4
    //   167: aload 6
    //   169: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   172: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   175: aload 6
    //   177: aload_1
    //   178: getstatic 214	com/tencent/mm/loader/e/c/b$b:ePa	Lcom/tencent/mm/loader/e/c/b$b;
    //   181: invokevirtual 219	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   184: astore 4
    //   186: goto +394 -> 580
    //   189: aload 6
    //   191: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   194: astore 4
    //   196: aload 4
    //   198: ifnull +175 -> 373
    //   201: aload 4
    //   203: aload 6
    //   205: invokevirtual 190	com/tencent/mm/loader/f:SY	()Lcom/tencent/mm/loader/e/b/d;
    //   208: getfield 196	com/tencent/mm/loader/e/b/d:eOC	Lcom/tencent/mm/loader/e/b/g;
    //   211: aload 6
    //   213: aload_1
    //   214: getstatic 356	com/tencent/mm/loader/e/c/b$b:eOZ	Lcom/tencent/mm/loader/e/c/b$b;
    //   217: invokevirtual 219	com/tencent/mm/loader/e/c/a:a	(Lcom/tencent/mm/loader/e/b/g;Lcom/tencent/mm/loader/f;Lcom/tencent/mm/loader/h/e;Lcom/tencent/mm/loader/e/c/b$b;)Lcom/tencent/mm/loader/h/e;
    //   220: astore 4
    //   222: goto +366 -> 588
    //   225: getstatic 250	a/y:BMg	La/y;
    //   228: astore 4
    //   230: aload 9
    //   232: invokevirtual 359	com/tencent/mm/ab/a:SS	()V
    //   235: aload_1
    //   236: invokevirtual 232	com/tencent/mm/loader/h/e:getValue	()Ljava/lang/Object;
    //   239: astore_1
    //   240: aload 7
    //   242: aload_1
    //   243: putfield 241	com/tencent/mm/loader/h/c:value	Ljava/lang/Object;
    //   246: aload_2
    //   247: aload 7
    //   249: invokeinterface 364 2 0
    //   254: aload_1
    //   255: ifnull +27 -> 282
    //   258: aload_0
    //   259: getfield 116	com/tencent/mm/loader/k/a:eNx	Lcom/tencent/mm/loader/b/b/d;
    //   262: astore_2
    //   263: aload_2
    //   264: ifnull +18 -> 282
    //   267: aload_2
    //   268: aload 6
    //   270: getfield 228	com/tencent/mm/loader/f:eMZ	Lcom/tencent/mm/loader/h/a/a;
    //   273: aload 6
    //   275: getfield 222	com/tencent/mm/loader/f:eMR	Lcom/tencent/mm/loader/e/c/a;
    //   278: aload_1
    //   279: invokevirtual 237	com/tencent/mm/loader/b/b/d:a	(Lcom/tencent/mm/loader/h/a/a;Lcom/tencent/mm/loader/e/c/a;Ljava/lang/Object;)V
    //   282: new 348	com/tencent/mm/ab/a
    //   285: dup
    //   286: ldc_w 366
    //   289: invokespecial 353	com/tencent/mm/ab/a:<init>	(Ljava/lang/String;)V
    //   292: astore_1
    //   293: aload 8
    //   295: getfield 370	com/tencent/mm/loader/k/a$b:eQF	La/f/a/a;
    //   298: invokeinterface 373 1 0
    //   303: pop
    //   304: getstatic 250	a/y:BMg	La/y;
    //   307: astore_2
    //   308: aload_1
    //   309: invokevirtual 359	com/tencent/mm/ab/a:SS	()V
    //   312: aload 6
    //   314: getfield 377	com/tencent/mm/loader/f:eMT	Lcom/tencent/mm/loader/f/a;
    //   317: ifnull +27 -> 344
    //   320: aload_0
    //   321: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   324: getfield 138	com/tencent/mm/loader/f:eMG	Lcom/tencent/mm/loader/c/e;
    //   327: astore_1
    //   328: aload_1
    //   329: ifnull +50 -> 379
    //   332: aload_1
    //   333: invokevirtual 381	com/tencent/mm/loader/c/e:TD	()[Ljava/lang/Object;
    //   336: astore_1
    //   337: aload_1
    //   338: aload_1
    //   339: arraylength
    //   340: invokestatic 387	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   343: pop
    //   344: aload 5
    //   346: aconst_null
    //   347: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   350: return
    //   351: iconst_0
    //   352: istore_3
    //   353: goto -312 -> 41
    //   356: aconst_null
    //   357: astore 4
    //   359: goto -311 -> 48
    //   362: aconst_null
    //   363: astore_1
    //   364: goto +206 -> 570
    //   367: aconst_null
    //   368: astore 4
    //   370: goto +210 -> 580
    //   373: aconst_null
    //   374: astore 4
    //   376: goto +212 -> 588
    //   379: aconst_null
    //   380: astore_1
    //   381: goto -44 -> 337
    //   384: getstatic 164	com/tencent/mm/loader/h/c:eQe	Lcom/tencent/mm/loader/h/c$a;
    //   387: astore_1
    //   388: aload 7
    //   390: invokestatic 390	com/tencent/mm/loader/h/c:TY	()I
    //   393: putfield 393	com/tencent/mm/loader/h/c:status	I
    //   396: aload 6
    //   398: getfield 377	com/tencent/mm/loader/f:eMT	Lcom/tencent/mm/loader/f/a;
    //   401: ifnull +27 -> 428
    //   404: aload_0
    //   405: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   408: getfield 138	com/tencent/mm/loader/f:eMG	Lcom/tencent/mm/loader/c/e;
    //   411: astore_1
    //   412: aload_1
    //   413: ifnull +28 -> 441
    //   416: aload_1
    //   417: invokevirtual 381	com/tencent/mm/loader/c/e:TD	()[Ljava/lang/Object;
    //   420: astore_1
    //   421: aload_1
    //   422: aload_1
    //   423: arraylength
    //   424: invokestatic 387	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   427: pop
    //   428: aload_2
    //   429: invokeinterface 396 1 0
    //   434: aload 5
    //   436: aconst_null
    //   437: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   440: return
    //   441: aconst_null
    //   442: astore_1
    //   443: goto -22 -> 421
    //   446: astore_2
    //   447: aload_2
    //   448: athrow
    //   449: astore_1
    //   450: aload 5
    //   452: aload_2
    //   453: invokestatic 255	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   456: aload_1
    //   457: athrow
    //   458: getstatic 164	com/tencent/mm/loader/h/c:eQe	Lcom/tencent/mm/loader/h/c$a;
    //   461: astore_1
    //   462: aload 7
    //   464: invokestatic 399	com/tencent/mm/loader/h/c:TX	()I
    //   467: putfield 393	com/tencent/mm/loader/h/c:status	I
    //   470: getstatic 403	com/tencent/mm/loader/c/e:DEBUG	Z
    //   473: ifeq +32 -> 505
    //   476: ldc_w 257
    //   479: ldc_w 405
    //   482: iconst_2
    //   483: anewarray 261	java/lang/Object
    //   486: dup
    //   487: iconst_0
    //   488: aload_0
    //   489: getfield 128	com/tencent/mm/loader/k/b:eOQ	Lcom/tencent/mm/loader/h/a/a;
    //   492: aastore
    //   493: dup
    //   494: iconst_1
    //   495: invokestatic 411	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   498: invokevirtual 417	com/tencent/mm/sdk/platformtools/an:toString	()Ljava/lang/String;
    //   501: aastore
    //   502: invokestatic 421	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   505: aload 6
    //   507: getfield 377	com/tencent/mm/loader/f:eMT	Lcom/tencent/mm/loader/f/a;
    //   510: ifnull +27 -> 537
    //   513: aload_0
    //   514: getfield 104	com/tencent/mm/loader/k/b:eQQ	Lcom/tencent/mm/loader/f;
    //   517: getfield 138	com/tencent/mm/loader/f:eMG	Lcom/tencent/mm/loader/c/e;
    //   520: astore_1
    //   521: aload_1
    //   522: ifnull +22 -> 544
    //   525: aload_1
    //   526: invokevirtual 381	com/tencent/mm/loader/c/e:TD	()[Ljava/lang/Object;
    //   529: astore_1
    //   530: aload_1
    //   531: aload_1
    //   532: arraylength
    //   533: invokestatic 387	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   536: pop
    //   537: aload_2
    //   538: invokeinterface 396 1 0
    //   543: return
    //   544: aconst_null
    //   545: astore_1
    //   546: goto -16 -> 530
    //   549: astore_1
    //   550: aconst_null
    //   551: astore_2
    //   552: goto -102 -> 450
    //   555: aload 4
    //   557: astore_1
    //   558: goto -333 -> 225
    //   561: aload 4
    //   563: astore_1
    //   564: goto -375 -> 189
    //   567: goto -414 -> 153
    //   570: aload_1
    //   571: ifnonnull -4 -> 567
    //   574: aload 4
    //   576: astore_1
    //   577: goto -424 -> 153
    //   580: aload 4
    //   582: ifnonnull -21 -> 561
    //   585: goto -396 -> 189
    //   588: aload 4
    //   590: ifnonnull -35 -> 555
    //   593: goto -368 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	a
    //   0	596	1	paramf	com.tencent.mm.loader.h.f<?>
    //   0	596	2	parama	b.a<R>
    //   40	313	3	i	int
    //   12	577	4	localObject	Object
    //   69	382	5	localCloseable	java.io.Closeable
    //   26	480	6	localf	com.tencent.mm.loader.f
    //   7	456	7	localc	com.tencent.mm.loader.h.c
    //   89	205	8	localb	a.b
    //   118	113	9	locala	com.tencent.mm.ab.a
    // Exception table:
    //   from	to	target	type
    //   71	91	446	java/lang/Throwable
    //   96	103	446	java/lang/Throwable
    //   108	126	446	java/lang/Throwable
    //   130	150	446	java/lang/Throwable
    //   153	160	446	java/lang/Throwable
    //   165	186	446	java/lang/Throwable
    //   189	196	446	java/lang/Throwable
    //   201	222	446	java/lang/Throwable
    //   225	254	446	java/lang/Throwable
    //   258	263	446	java/lang/Throwable
    //   267	282	446	java/lang/Throwable
    //   282	328	446	java/lang/Throwable
    //   332	337	446	java/lang/Throwable
    //   337	344	446	java/lang/Throwable
    //   384	412	446	java/lang/Throwable
    //   416	421	446	java/lang/Throwable
    //   421	428	446	java/lang/Throwable
    //   428	434	446	java/lang/Throwable
    //   447	449	449	finally
    //   71	91	549	finally
    //   96	103	549	finally
    //   108	126	549	finally
    //   130	150	549	finally
    //   153	160	549	finally
    //   165	186	549	finally
    //   189	196	549	finally
    //   201	222	549	finally
    //   225	254	549	finally
    //   258	263	549	finally
    //   267	282	549	finally
    //   282	328	549	finally
    //   332	337	549	finally
    //   337	344	549	finally
    //   384	412	549	finally
    //   416	421	549	finally
    //   421	428	549	finally
    //   428	434	549	finally
  }
  
  protected final void a(e.b paramb, b.a<R> parama)
  {
    boolean bool = true;
    j.q(paramb, "fileType");
    j.q(parama, "taskListener");
    for (;;)
    {
      try
      {
        System.currentTimeMillis();
        ab.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. key:" + this.eOQ + " fileType " + paramb + " [width:" + this.eNa + ".weakHolder.viewWidth height:" + this.eNa + ".weakHolder.viewHeight] diskCache " + this.eNy + " producer " + this.eQC + " isLocalFile: " + Um());
        Object localObject = Un();
        if ((!Um()) && (((com.tencent.mm.loader.h.c)localObject).value == null))
        {
          ab.i("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + localObject + " bitmap " + ((com.tencent.mm.loader.h.c)localObject).value + " isNeedDownload " + bool);
          if (!bool)
          {
            parama.b((com.tencent.mm.loader.h.c)localObject);
            return;
          }
          com.tencent.mm.loader.f localf = this.eQQ;
          long l;
          try
          {
            l = System.currentTimeMillis();
            ab.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from memory failed.now try to get from network. " + this.eOQ + " fileType: " + paramb);
            if (localf.eMJ != null) {
              localf.SY();
            }
            localObject = localf.eMK;
            if (localf.eMP.a(this.eOQ))
            {
              if (localObject != null) {
                continue;
              }
              a(null, parama);
              ab.i("MicroMsg.Loader.ImageLoadWorkTask", "can not download image, over limit " + this.eOQ);
              return;
            }
          }
          catch (Exception paramb)
          {
            ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", (Throwable)paramb, "[ImageLoader DownLoadException] run error %s [debug info %s]", new Object[] { this.eOQ, localf.eNb });
            paramb = y.BMg;
            return;
          }
          localObject = null;
          continue;
          localObject = localf.eMK;
          com.tencent.mm.loader.h.a.a locala = this.eOQ;
          com.tencent.mm.loader.f.f localf1 = localf.eMW;
          com.tencent.mm.loader.g.b localb = this.ePd;
          if (localb == null) {
            j.ays("loader");
          }
          paramb = (com.tencent.mm.loader.d.b.a)new a.c(localf, l, this, paramb, parama);
          j.q(locala, "url");
          j.q(localf1, "fileNameCreator");
          j.q(localb, "loader");
          j.q(paramb, "callback");
          localb.t((Runnable)new b.c((com.tencent.mm.loader.d.b)localObject, localb, locala, localf1, paramb));
          return;
        }
      }
      catch (Exception paramb)
      {
        ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", (Throwable)paramb, "[ImageLoader execute] " + paramb.getMessage() + " run error " + this.eOQ + " [debug info " + this.eNb + ']', new Object[0]);
        parama.Up();
        return;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.k.a
 * JD-Core Version:    0.7.0.1
 */