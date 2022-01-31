package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$b
  implements av.a
{
  private int bLN;
  private Bitmap bitmap;
  private String kGp;
  private long kGq;
  private int kGr;
  String mFilePath;
  
  public a$b(a parama, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    this(parama, paramString1, paramInt, paramString2, paramLong, (byte)0);
  }
  
  private a$b(a parama, String paramString1, int paramInt, String paramString2, long paramLong, byte paramByte)
  {
    this.mFilePath = paramString1;
    this.kGq = paramLong;
    this.kGp = paramString2;
    this.kGr = 12288;
    this.bLN = paramInt;
  }
  
  /* Error */
  public final boolean JS()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 29	com/tencent/mm/plugin/gallery/model/a$b:kGm	Lcom/tencent/mm/plugin/gallery/model/a;
    //   7: invokestatic 50	com/tencent/mm/plugin/gallery/model/a:a	(Lcom/tencent/mm/plugin/gallery/model/a;)Lcom/tencent/mm/plugin/gallery/model/b;
    //   10: astore 7
    //   12: ldc 52
    //   14: iconst_3
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: getfield 34	com/tencent/mm/plugin/gallery/model/a$b:mFilePath	Ljava/lang/String;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_0
    //   28: getfield 38	com/tencent/mm/plugin/gallery/model/a$b:kGp	Ljava/lang/String;
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: aload_0
    //   35: getfield 36	com/tencent/mm/plugin/gallery/model/a$b:kGq	J
    //   38: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   41: aastore
    //   42: invokestatic 64	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   45: astore 8
    //   47: aload 7
    //   49: getfield 70	com/tencent/mm/plugin/gallery/model/b:kGt	Lcom/tencent/mm/plugin/gallery/model/d;
    //   52: ifnonnull +43 -> 95
    //   55: aconst_null
    //   56: astore 7
    //   58: aload_0
    //   59: aload 7
    //   61: putfield 72	com/tencent/mm/plugin/gallery/model/a$b:bitmap	Landroid/graphics/Bitmap;
    //   64: aload_0
    //   65: getfield 72	com/tencent/mm/plugin/gallery/model/a$b:bitmap	Landroid/graphics/Bitmap;
    //   68: ifnull +45 -> 113
    //   71: ldc 74
    //   73: ldc 76
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: aload_0
    //   82: getfield 34	com/tencent/mm/plugin/gallery/model/a$b:mFilePath	Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 82	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: iconst_1
    //   90: istore 4
    //   92: iload 4
    //   94: ireturn
    //   95: aload 7
    //   97: getfield 70	com/tencent/mm/plugin/gallery/model/b:kGt	Lcom/tencent/mm/plugin/gallery/model/d;
    //   100: aload 8
    //   102: invokevirtual 86	java/lang/String:hashCode	()I
    //   105: invokevirtual 92	com/tencent/mm/plugin/gallery/model/d:rL	(I)Landroid/graphics/Bitmap;
    //   108: astore 7
    //   110: goto -52 -> 58
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 36	com/tencent/mm/plugin/gallery/model/a$b:kGq	J
    //   118: aload_0
    //   119: getfield 42	com/tencent/mm/plugin/gallery/model/a$b:bLN	I
    //   122: aload_0
    //   123: getfield 34	com/tencent/mm/plugin/gallery/model/a$b:mFilePath	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 38	com/tencent/mm/plugin/gallery/model/a$b:kGp	Ljava/lang/String;
    //   130: invokestatic 97	com/tencent/mm/plugin/gallery/model/j:a	(JILjava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   133: putfield 72	com/tencent/mm/plugin/gallery/model/a$b:bitmap	Landroid/graphics/Bitmap;
    //   136: aload_0
    //   137: getfield 72	com/tencent/mm/plugin/gallery/model/a$b:bitmap	Landroid/graphics/Bitmap;
    //   140: ifnull -48 -> 92
    //   143: aload_0
    //   144: getfield 29	com/tencent/mm/plugin/gallery/model/a$b:kGm	Lcom/tencent/mm/plugin/gallery/model/a;
    //   147: invokestatic 50	com/tencent/mm/plugin/gallery/model/a:a	(Lcom/tencent/mm/plugin/gallery/model/a;)Lcom/tencent/mm/plugin/gallery/model/b;
    //   150: astore 7
    //   152: aload_0
    //   153: getfield 34	com/tencent/mm/plugin/gallery/model/a$b:mFilePath	Ljava/lang/String;
    //   156: astore 9
    //   158: aload_0
    //   159: getfield 38	com/tencent/mm/plugin/gallery/model/a$b:kGp	Ljava/lang/String;
    //   162: astore 10
    //   164: aload_0
    //   165: getfield 36	com/tencent/mm/plugin/gallery/model/a$b:kGq	J
    //   168: lstore 5
    //   170: aload_0
    //   171: getfield 72	com/tencent/mm/plugin/gallery/model/a$b:bitmap	Landroid/graphics/Bitmap;
    //   174: astore 8
    //   176: aload 8
    //   178: ifnull +81 -> 259
    //   181: ldc 52
    //   183: iconst_3
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload 9
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: aload 10
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: lload 5
    //   201: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   204: aastore
    //   205: invokestatic 64	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   208: astore 10
    //   210: aload 7
    //   212: getfield 70	com/tencent/mm/plugin/gallery/model/b:kGt	Lcom/tencent/mm/plugin/gallery/model/d;
    //   215: ifnull +44 -> 259
    //   218: aload 7
    //   220: getfield 70	com/tencent/mm/plugin/gallery/model/b:kGt	Lcom/tencent/mm/plugin/gallery/model/d;
    //   223: astore 9
    //   225: aload 10
    //   227: invokevirtual 86	java/lang/String:hashCode	()I
    //   230: istore_3
    //   231: aload 9
    //   233: getfield 101	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   236: ifnull +16 -> 252
    //   239: aload 9
    //   241: getfield 101	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   244: invokeinterface 106 1 0
    //   249: ifgt +12 -> 261
    //   252: ldc 108
    //   254: ldc 110
    //   256: invokestatic 114	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: iconst_1
    //   260: ireturn
    //   261: aload 8
    //   263: ifnonnull +13 -> 276
    //   266: ldc 108
    //   268: ldc 116
    //   270: invokestatic 114	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: goto -14 -> 259
    //   276: ldc 108
    //   278: ldc 118
    //   280: iconst_3
    //   281: anewarray 4	java/lang/Object
    //   284: dup
    //   285: iconst_0
    //   286: iload_3
    //   287: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: aload 8
    //   295: invokevirtual 128	android/graphics/Bitmap:getWidth	()I
    //   298: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: dup
    //   303: iconst_2
    //   304: aload 8
    //   306: invokevirtual 131	android/graphics/Bitmap:getHeight	()I
    //   309: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: aastore
    //   313: invokestatic 82	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload 9
    //   318: getfield 101	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   321: ifnull +16 -> 337
    //   324: aload 9
    //   326: getfield 101	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   329: invokeinterface 106 1 0
    //   334: ifgt +19 -> 353
    //   337: iconst_m1
    //   338: istore_1
    //   339: iload_1
    //   340: ifge +105 -> 445
    //   343: ldc 108
    //   345: ldc 133
    //   347: invokestatic 114	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: goto -91 -> 259
    //   353: aload 9
    //   355: invokevirtual 136	com/tencent/mm/plugin/gallery/model/d:aXm	()I
    //   358: istore_2
    //   359: iload_2
    //   360: istore_1
    //   361: iload_2
    //   362: ifge +69 -> 431
    //   365: ldc 108
    //   367: ldc 138
    //   369: iconst_1
    //   370: anewarray 4	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: aload 9
    //   377: getfield 141	com/tencent/mm/plugin/gallery/model/d:kGM	I
    //   380: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: invokestatic 82	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload 9
    //   389: getfield 141	com/tencent/mm/plugin/gallery/model/d:kGM	I
    //   392: iconst_1
    //   393: iadd
    //   394: bipush 25
    //   396: if_icmplt +38 -> 434
    //   399: iconst_0
    //   400: istore_1
    //   401: ldc 108
    //   403: ldc 143
    //   405: iconst_1
    //   406: anewarray 4	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: iload_1
    //   412: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: invokestatic 82	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: aload 9
    //   421: iload_1
    //   422: invokevirtual 147	com/tencent/mm/plugin/gallery/model/d:rK	(I)V
    //   425: aload 9
    //   427: iload_1
    //   428: invokevirtual 150	com/tencent/mm/plugin/gallery/model/d:rJ	(I)V
    //   431: goto -92 -> 339
    //   434: aload 9
    //   436: getfield 141	com/tencent/mm/plugin/gallery/model/d:kGM	I
    //   439: iconst_1
    //   440: iadd
    //   441: istore_1
    //   442: goto -41 -> 401
    //   445: aload 9
    //   447: getfield 154	com/tencent/mm/plugin/gallery/model/d:kGL	Landroid/util/SparseArray;
    //   450: iload_3
    //   451: invokevirtual 160	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   454: checkcast 162	com/tencent/mm/protocal/c/aqi
    //   457: astore 7
    //   459: aload 7
    //   461: ifnonnull +290 -> 751
    //   464: new 162	com/tencent/mm/protocal/c/aqi
    //   467: dup
    //   468: invokespecial 163	com/tencent/mm/protocal/c/aqi:<init>	()V
    //   471: astore 7
    //   473: aload 7
    //   475: iload_3
    //   476: putfield 166	com/tencent/mm/protocal/c/aqi:key	I
    //   479: new 168	java/io/ByteArrayOutputStream
    //   482: dup
    //   483: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   486: astore 10
    //   488: aload 8
    //   490: getstatic 175	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   493: bipush 100
    //   495: aload 10
    //   497: invokevirtual 179	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   500: pop
    //   501: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   504: lstore 5
    //   506: aload 9
    //   508: getfield 101	com/tencent/mm/plugin/gallery/model/d:kGK	Ljava/util/List;
    //   511: iload_1
    //   512: invokeinterface 186 2 0
    //   517: checkcast 188	java/io/RandomAccessFile
    //   520: astore 8
    //   522: aload 7
    //   524: aload 8
    //   526: invokevirtual 191	java/io/RandomAccessFile:length	()J
    //   529: putfield 194	com/tencent/mm/protocal/c/aqi:tmo	J
    //   532: aload 7
    //   534: iload_1
    //   535: putfield 197	com/tencent/mm/protocal/c/aqi:tmp	I
    //   538: aload 7
    //   540: aload 10
    //   542: invokevirtual 198	java/io/ByteArrayOutputStream:size	()I
    //   545: putfield 200	com/tencent/mm/protocal/c/aqi:length	I
    //   548: aload 10
    //   550: invokevirtual 204	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   553: astore 11
    //   555: aload 8
    //   557: aload 7
    //   559: getfield 194	com/tencent/mm/protocal/c/aqi:tmo	J
    //   562: invokevirtual 208	java/io/RandomAccessFile:seek	(J)V
    //   565: aload 8
    //   567: aload 11
    //   569: invokevirtual 212	java/io/RandomAccessFile:write	([B)V
    //   572: aload 9
    //   574: iload_1
    //   575: putfield 141	com/tencent/mm/plugin/gallery/model/d:kGM	I
    //   578: ldc 108
    //   580: ldc 214
    //   582: iconst_5
    //   583: anewarray 4	java/lang/Object
    //   586: dup
    //   587: iconst_0
    //   588: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   591: lload 5
    //   593: lsub
    //   594: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   597: aastore
    //   598: dup
    //   599: iconst_1
    //   600: aload 7
    //   602: getfield 166	com/tencent/mm/protocal/c/aqi:key	I
    //   605: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   608: aastore
    //   609: dup
    //   610: iconst_2
    //   611: aload 7
    //   613: getfield 194	com/tencent/mm/protocal/c/aqi:tmo	J
    //   616: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   619: aastore
    //   620: dup
    //   621: iconst_3
    //   622: aload 7
    //   624: getfield 200	com/tencent/mm/protocal/c/aqi:length	I
    //   627: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   630: aastore
    //   631: dup
    //   632: iconst_4
    //   633: aload 7
    //   635: getfield 197	com/tencent/mm/protocal/c/aqi:tmp	I
    //   638: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: aastore
    //   642: invokestatic 82	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   645: aload 10
    //   647: invokestatic 217	com/tencent/mm/plugin/gallery/model/d:d	(Ljava/io/Closeable;)V
    //   650: aload 9
    //   652: iconst_1
    //   653: putfield 221	com/tencent/mm/plugin/gallery/model/d:dirty	Z
    //   656: aload 9
    //   658: getfield 154	com/tencent/mm/plugin/gallery/model/d:kGL	Landroid/util/SparseArray;
    //   661: iload_3
    //   662: aload 7
    //   664: invokevirtual 225	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   667: goto -408 -> 259
    //   670: astore 7
    //   672: ldc 108
    //   674: ldc 227
    //   676: iconst_1
    //   677: anewarray 4	java/lang/Object
    //   680: dup
    //   681: iconst_0
    //   682: aload 7
    //   684: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   687: aastore
    //   688: invokestatic 233	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   691: ldc 108
    //   693: aload 7
    //   695: ldc 235
    //   697: iconst_0
    //   698: anewarray 4	java/lang/Object
    //   701: invokestatic 239	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: aload 10
    //   706: invokestatic 217	com/tencent/mm/plugin/gallery/model/d:d	(Ljava/io/Closeable;)V
    //   709: goto -450 -> 259
    //   712: astore 7
    //   714: ldc 108
    //   716: ldc 241
    //   718: iconst_1
    //   719: anewarray 4	java/lang/Object
    //   722: dup
    //   723: iconst_0
    //   724: aload 7
    //   726: invokevirtual 231	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   729: aastore
    //   730: invokestatic 233	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   733: aload 10
    //   735: invokestatic 217	com/tencent/mm/plugin/gallery/model/d:d	(Ljava/io/Closeable;)V
    //   738: goto -479 -> 259
    //   741: astore 7
    //   743: aload 10
    //   745: invokestatic 217	com/tencent/mm/plugin/gallery/model/d:d	(Ljava/io/Closeable;)V
    //   748: aload 7
    //   750: athrow
    //   751: goto -272 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	754	0	this	b
    //   338	237	1	i	int
    //   358	4	2	j	int
    //   230	432	3	k	int
    //   1	92	4	bool	boolean
    //   168	424	5	l	long
    //   10	653	7	localObject1	Object
    //   670	24	7	localException1	java.lang.Exception
    //   712	13	7	localException2	java.lang.Exception
    //   741	8	7	localObject2	Object
    //   45	521	8	localObject3	Object
    //   156	501	9	localObject4	Object
    //   162	582	10	localObject5	Object
    //   553	15	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   488	501	670	java/lang/Exception
    //   501	645	712	java/lang/Exception
    //   501	645	741	finally
    //   714	733	741	finally
  }
  
  public final boolean JT()
  {
    y.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", new Object[] { this.mFilePath });
    a.b(this.kGm).bn(this.mFilePath);
    y.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", new Object[] { Integer.valueOf(a.b(this.kGm).size()) });
    if (this.bitmap == null)
    {
      y.e("MircoMsg.CacheService", "decode file failed, %s ", new Object[] { this.mFilePath });
      return false;
    }
    b localb = a.a(this.kGm);
    String str = this.mFilePath;
    Bitmap localBitmap = this.bitmap;
    int i = this.kGr;
    if (localb.kGs == null) {
      y.e("MicroMsg.GalleryCache", "cache is null");
    }
    for (;;)
    {
      this.bitmap = null;
      return true;
      localb.kGs.f(str, new b.a(localb, localBitmap, i));
      localb.ebu.bV(str);
      localb.ebu.doNotify();
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (!(paramObject instanceof b));
    paramObject = (b)paramObject;
    return bk.aM(this.mFilePath, "").equals(paramObject.mFilePath);
  }
  
  public final int hashCode()
  {
    return bk.aM(this.mFilePath, "").hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a.b
 * JD-Core Version:    0.7.0.1
 */