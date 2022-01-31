package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Vector;

public final class c
{
  private static final int ncz;
  private volatile boolean isDecoding;
  d ncA;
  private c.a ncB;
  private h<String> ncC;
  private h<b> ncD;
  
  static
  {
    AppMethodBeat.i(21239);
    if (com.tencent.mm.compatible.util.d.fw(14)) {}
    for (int i = 20;; i = 40)
    {
      ncz = i;
      AppMethodBeat.o(21239);
      return;
    }
  }
  
  public c()
  {
    AppMethodBeat.i(21232);
    this.isDecoding = false;
    this.ncA = new d();
    this.ncB = new c.a(this, (byte)0);
    this.ncC = new h();
    this.ncD = new h();
    AppMethodBeat.o(21232);
  }
  
  private void bDN()
  {
    AppMethodBeat.i(21235);
    if (this.isDecoding)
    {
      ab.w("MircoMsg.CacheService", "is decoding now, wait a minute");
      AppMethodBeat.o(21235);
      return;
    }
    if ((this.ncD != null) && (this.ncD.size() > 0))
    {
      this.isDecoding = true;
      c((b)this.ncD.bEi());
      AppMethodBeat.o(21235);
      return;
    }
    ab.i("MircoMsg.CacheService", "all job empty");
    if (e.bDR() == null)
    {
      AppMethodBeat.o(21235);
      return;
    }
    e.bDR().T(new c.1(this));
    AppMethodBeat.o(21235);
  }
  
  private void c(az.a parama)
  {
    AppMethodBeat.i(21236);
    if (parama == null)
    {
      ab.e("MircoMsg.CacheService", "obj is null");
      this.isDecoding = false;
      bDN();
      AppMethodBeat.o(21236);
      return;
    }
    this.ncB.d(parama);
    AppMethodBeat.o(21236);
  }
  
  public final Bitmap Pz(String paramString)
  {
    AppMethodBeat.i(21234);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MircoMsg.CacheService", "file path is null");
      AppMethodBeat.o(21234);
      return null;
    }
    Bitmap localBitmap = this.ncA.getBitmap(paramString);
    if (localBitmap != null)
    {
      ab.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[] { paramString });
      AppMethodBeat.o(21234);
      return localBitmap;
    }
    AppMethodBeat.o(21234);
    return null;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(21237);
    d locald = this.ncA;
    if (locald.gjA.size() > 64) {
      ab.i("MicroMsg.GalleryCache", "has exceed the max listener size[%d], remove some listeners[%s]", new Object[] { Integer.valueOf(64), (d.b)locald.gjA.remove(0) });
    }
    ab.v("MicroMsg.GalleryCache", "try add listener[%s]", new Object[] { paramb });
    if (!locald.gjA.contains(paramb))
    {
      ab.d("MicroMsg.GalleryCache", "add listener[%s] ok", new Object[] { paramb });
      locald.gjA.add(paramb);
    }
    AppMethodBeat.o(21237);
  }
  
  public final Bitmap b(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(21233);
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MircoMsg.CacheService", "file path is null");
      AppMethodBeat.o(21233);
      return null;
    }
    Object localObject = this.ncA.getBitmap(paramString1);
    if (localObject != null)
    {
      ab.v("MircoMsg.CacheService", "get bitmap from cache: %s", new Object[] { paramString1 });
      AppMethodBeat.o(21233);
      return localObject;
    }
    ab.v("MircoMsg.CacheService", "filePathInService size is : [%d]", new Object[] { Integer.valueOf(this.ncC.size()) });
    if (this.ncC.Z(paramString1))
    {
      ab.w("MircoMsg.CacheService", "has already getting bitmap from file, %s", new Object[] { paramString1 });
      bDN();
      AppMethodBeat.o(21233);
      return null;
    }
    if (this.ncC.size() > ncz)
    {
      ab.w("MircoMsg.CacheService", "filePathInService size: [%d], waitingDecodeTask size:[%d]", new Object[] { Integer.valueOf(this.ncC.size()), Integer.valueOf(this.ncD.size()) });
      if (!this.ncD.isEmpty())
      {
        localObject = (b)this.ncD.bEi();
        if (localObject != null)
        {
          localObject = ((b)localObject).mFilePath;
          this.ncC.bO(localObject);
          ab.w("MircoMsg.CacheService", "the running task has exceed 40, remove the first one! path:%s", new Object[] { localObject });
        }
      }
    }
    this.ncC.add(paramString1);
    this.ncD.add(new b(paramString1, paramInt, paramString2, paramLong));
    bDN();
    AppMethodBeat.o(21233);
    return null;
  }
  
  public final void b(d.b paramb)
  {
    AppMethodBeat.i(138608);
    d locald = this.ncA;
    if (paramb == null)
    {
      if (locald.gjA != null) {
        locald.gjA.clear();
      }
      AppMethodBeat.o(138608);
      return;
    }
    if ((locald.gjA != null) && (locald.gjA.contains(paramb))) {
      locald.gjA.remove(paramb);
    }
    AppMethodBeat.o(138608);
  }
  
  final class b
    implements az.a
  {
    private Bitmap bitmap;
    private int cth;
    String mFilePath;
    private String ncH;
    private long ncI;
    private int ncJ;
    
    public b(String paramString1, int paramInt, String paramString2, long paramLong)
    {
      this(paramString1, paramInt, paramString2, paramLong, (byte)0);
    }
    
    private b(String paramString1, int paramInt, String paramString2, long paramLong, byte paramByte)
    {
      this.mFilePath = paramString1;
      this.ncI = paramLong;
      this.ncH = paramString2;
      this.ncJ = 12288;
      this.cth = paramInt;
    }
    
    /* Error */
    public final boolean acS()
    {
      // Byte code:
      //   0: sipush 21228
      //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 29	com/tencent/mm/plugin/gallery/model/c$b:ncE	Lcom/tencent/mm/plugin/gallery/model/c;
      //   10: invokestatic 56	com/tencent/mm/plugin/gallery/model/c:a	(Lcom/tencent/mm/plugin/gallery/model/c;)Lcom/tencent/mm/plugin/gallery/model/d;
      //   13: astore 6
      //   15: ldc 58
      //   17: iconst_3
      //   18: anewarray 4	java/lang/Object
      //   21: dup
      //   22: iconst_0
      //   23: aload_0
      //   24: getfield 34	com/tencent/mm/plugin/gallery/model/c$b:mFilePath	Ljava/lang/String;
      //   27: aastore
      //   28: dup
      //   29: iconst_1
      //   30: aload_0
      //   31: getfield 38	com/tencent/mm/plugin/gallery/model/c$b:ncH	Ljava/lang/String;
      //   34: aastore
      //   35: dup
      //   36: iconst_2
      //   37: aload_0
      //   38: getfield 36	com/tencent/mm/plugin/gallery/model/c$b:ncI	J
      //   41: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   44: aastore
      //   45: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   48: astore 7
      //   50: aload 6
      //   52: getfield 76	com/tencent/mm/plugin/gallery/model/d:ncL	Lcom/tencent/mm/plugin/gallery/model/f;
      //   55: ifnonnull +45 -> 100
      //   58: aconst_null
      //   59: astore 6
      //   61: aload_0
      //   62: aload 6
      //   64: putfield 78	com/tencent/mm/plugin/gallery/model/c$b:bitmap	Landroid/graphics/Bitmap;
      //   67: aload_0
      //   68: getfield 78	com/tencent/mm/plugin/gallery/model/c$b:bitmap	Landroid/graphics/Bitmap;
      //   71: ifnull +47 -> 118
      //   74: ldc 80
      //   76: ldc 82
      //   78: iconst_1
      //   79: anewarray 4	java/lang/Object
      //   82: dup
      //   83: iconst_0
      //   84: aload_0
      //   85: getfield 34	com/tencent/mm/plugin/gallery/model/c$b:mFilePath	Ljava/lang/String;
      //   88: aastore
      //   89: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   92: sipush 21228
      //   95: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: iconst_1
      //   99: ireturn
      //   100: aload 6
      //   102: getfield 76	com/tencent/mm/plugin/gallery/model/d:ncL	Lcom/tencent/mm/plugin/gallery/model/f;
      //   105: aload 7
      //   107: invokevirtual 95	java/lang/String:hashCode	()I
      //   110: invokevirtual 101	com/tencent/mm/plugin/gallery/model/f:wJ	(I)Landroid/graphics/Bitmap;
      //   113: astore 6
      //   115: goto -54 -> 61
      //   118: aload_0
      //   119: aload_0
      //   120: getfield 36	com/tencent/mm/plugin/gallery/model/c$b:ncI	J
      //   123: aload_0
      //   124: getfield 42	com/tencent/mm/plugin/gallery/model/c$b:cth	I
      //   127: aload_0
      //   128: getfield 34	com/tencent/mm/plugin/gallery/model/c$b:mFilePath	Ljava/lang/String;
      //   131: aload_0
      //   132: getfield 38	com/tencent/mm/plugin/gallery/model/c$b:ncH	Ljava/lang/String;
      //   135: invokestatic 106	com/tencent/mm/plugin/gallery/model/k:a	(JILjava/lang/String;Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   138: putfield 78	com/tencent/mm/plugin/gallery/model/c$b:bitmap	Landroid/graphics/Bitmap;
      //   141: aload_0
      //   142: getfield 78	com/tencent/mm/plugin/gallery/model/c$b:bitmap	Landroid/graphics/Bitmap;
      //   145: ifnull +623 -> 768
      //   148: aload_0
      //   149: getfield 29	com/tencent/mm/plugin/gallery/model/c$b:ncE	Lcom/tencent/mm/plugin/gallery/model/c;
      //   152: invokestatic 56	com/tencent/mm/plugin/gallery/model/c:a	(Lcom/tencent/mm/plugin/gallery/model/c;)Lcom/tencent/mm/plugin/gallery/model/d;
      //   155: astore 6
      //   157: aload_0
      //   158: getfield 34	com/tencent/mm/plugin/gallery/model/c$b:mFilePath	Ljava/lang/String;
      //   161: astore 8
      //   163: aload_0
      //   164: getfield 38	com/tencent/mm/plugin/gallery/model/c$b:ncH	Ljava/lang/String;
      //   167: astore 9
      //   169: aload_0
      //   170: getfield 36	com/tencent/mm/plugin/gallery/model/c$b:ncI	J
      //   173: lstore 4
      //   175: aload_0
      //   176: getfield 78	com/tencent/mm/plugin/gallery/model/c$b:bitmap	Landroid/graphics/Bitmap;
      //   179: astore 7
      //   181: aload 7
      //   183: ifnull +81 -> 264
      //   186: ldc 58
      //   188: iconst_3
      //   189: anewarray 4	java/lang/Object
      //   192: dup
      //   193: iconst_0
      //   194: aload 8
      //   196: aastore
      //   197: dup
      //   198: iconst_1
      //   199: aload 9
      //   201: aastore
      //   202: dup
      //   203: iconst_2
      //   204: lload 4
      //   206: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   209: aastore
      //   210: invokestatic 70	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   213: astore 9
      //   215: aload 6
      //   217: getfield 76	com/tencent/mm/plugin/gallery/model/d:ncL	Lcom/tencent/mm/plugin/gallery/model/f;
      //   220: ifnull +44 -> 264
      //   223: aload 6
      //   225: getfield 76	com/tencent/mm/plugin/gallery/model/d:ncL	Lcom/tencent/mm/plugin/gallery/model/f;
      //   228: astore 8
      //   230: aload 9
      //   232: invokevirtual 95	java/lang/String:hashCode	()I
      //   235: istore_3
      //   236: aload 8
      //   238: getfield 110	com/tencent/mm/plugin/gallery/model/f:ndc	Ljava/util/List;
      //   241: ifnull +16 -> 257
      //   244: aload 8
      //   246: getfield 110	com/tencent/mm/plugin/gallery/model/f:ndc	Ljava/util/List;
      //   249: invokeinterface 115 1 0
      //   254: ifgt +18 -> 272
      //   257: ldc 117
      //   259: ldc 119
      //   261: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   264: sipush 21228
      //   267: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   270: iconst_1
      //   271: ireturn
      //   272: aload 7
      //   274: ifnonnull +13 -> 287
      //   277: ldc 117
      //   279: ldc 125
      //   281: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   284: goto -20 -> 264
      //   287: ldc 117
      //   289: ldc 127
      //   291: iconst_3
      //   292: anewarray 4	java/lang/Object
      //   295: dup
      //   296: iconst_0
      //   297: iload_3
      //   298: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   301: aastore
      //   302: dup
      //   303: iconst_1
      //   304: aload 7
      //   306: invokevirtual 137	android/graphics/Bitmap:getWidth	()I
      //   309: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   312: aastore
      //   313: dup
      //   314: iconst_2
      //   315: aload 7
      //   317: invokevirtual 140	android/graphics/Bitmap:getHeight	()I
      //   320: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   323: aastore
      //   324: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   327: aload 8
      //   329: getfield 110	com/tencent/mm/plugin/gallery/model/f:ndc	Ljava/util/List;
      //   332: ifnull +16 -> 348
      //   335: aload 8
      //   337: getfield 110	com/tencent/mm/plugin/gallery/model/f:ndc	Ljava/util/List;
      //   340: invokeinterface 115 1 0
      //   345: ifgt +19 -> 364
      //   348: iconst_m1
      //   349: istore_1
      //   350: iload_1
      //   351: ifge +105 -> 456
      //   354: ldc 117
      //   356: ldc 142
      //   358: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   361: goto -97 -> 264
      //   364: aload 8
      //   366: invokevirtual 145	com/tencent/mm/plugin/gallery/model/f:bEb	()I
      //   369: istore_2
      //   370: iload_2
      //   371: istore_1
      //   372: iload_2
      //   373: ifge +69 -> 442
      //   376: ldc 117
      //   378: ldc 147
      //   380: iconst_1
      //   381: anewarray 4	java/lang/Object
      //   384: dup
      //   385: iconst_0
      //   386: aload 8
      //   388: getfield 150	com/tencent/mm/plugin/gallery/model/f:nde	I
      //   391: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   394: aastore
      //   395: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   398: aload 8
      //   400: getfield 150	com/tencent/mm/plugin/gallery/model/f:nde	I
      //   403: iconst_1
      //   404: iadd
      //   405: bipush 25
      //   407: if_icmplt +38 -> 445
      //   410: iconst_0
      //   411: istore_1
      //   412: ldc 117
      //   414: ldc 152
      //   416: iconst_1
      //   417: anewarray 4	java/lang/Object
      //   420: dup
      //   421: iconst_0
      //   422: iload_1
      //   423: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   426: aastore
      //   427: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   430: aload 8
      //   432: iload_1
      //   433: invokevirtual 155	com/tencent/mm/plugin/gallery/model/f:wI	(I)V
      //   436: aload 8
      //   438: iload_1
      //   439: invokevirtual 158	com/tencent/mm/plugin/gallery/model/f:wH	(I)V
      //   442: goto -92 -> 350
      //   445: aload 8
      //   447: getfield 150	com/tencent/mm/plugin/gallery/model/f:nde	I
      //   450: iconst_1
      //   451: iadd
      //   452: istore_1
      //   453: goto -41 -> 412
      //   456: aload 8
      //   458: getfield 162	com/tencent/mm/plugin/gallery/model/f:ndd	Landroid/util/SparseArray;
      //   461: iload_3
      //   462: invokevirtual 168	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   465: checkcast 170	com/tencent/mm/protocal/protobuf/awk
      //   468: astore 6
      //   470: aload 6
      //   472: ifnonnull +304 -> 776
      //   475: new 170	com/tencent/mm/protocal/protobuf/awk
      //   478: dup
      //   479: invokespecial 171	com/tencent/mm/protocal/protobuf/awk:<init>	()V
      //   482: astore 6
      //   484: aload 6
      //   486: iload_3
      //   487: putfield 174	com/tencent/mm/protocal/protobuf/awk:key	I
      //   490: new 176	java/io/ByteArrayOutputStream
      //   493: dup
      //   494: invokespecial 177	java/io/ByteArrayOutputStream:<init>	()V
      //   497: astore 9
      //   499: aload 7
      //   501: getstatic 183	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
      //   504: bipush 100
      //   506: aload 9
      //   508: invokevirtual 187	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   511: pop
      //   512: invokestatic 193	java/lang/System:currentTimeMillis	()J
      //   515: lstore 4
      //   517: aload 8
      //   519: getfield 110	com/tencent/mm/plugin/gallery/model/f:ndc	Ljava/util/List;
      //   522: iload_1
      //   523: invokeinterface 194 2 0
      //   528: checkcast 196	java/io/RandomAccessFile
      //   531: astore 7
      //   533: aload 6
      //   535: aload 7
      //   537: invokevirtual 199	java/io/RandomAccessFile:length	()J
      //   540: putfield 202	com/tencent/mm/protocal/protobuf/awk:xlU	J
      //   543: aload 6
      //   545: iload_1
      //   546: putfield 205	com/tencent/mm/protocal/protobuf/awk:xlV	I
      //   549: aload 6
      //   551: aload 9
      //   553: invokevirtual 206	java/io/ByteArrayOutputStream:size	()I
      //   556: putfield 208	com/tencent/mm/protocal/protobuf/awk:length	I
      //   559: aload 9
      //   561: invokevirtual 212	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   564: astore 10
      //   566: aload 7
      //   568: aload 6
      //   570: getfield 202	com/tencent/mm/protocal/protobuf/awk:xlU	J
      //   573: invokevirtual 216	java/io/RandomAccessFile:seek	(J)V
      //   576: aload 7
      //   578: aload 10
      //   580: invokevirtual 220	java/io/RandomAccessFile:write	([B)V
      //   583: aload 8
      //   585: iload_1
      //   586: putfield 150	com/tencent/mm/plugin/gallery/model/f:nde	I
      //   589: ldc 117
      //   591: ldc 222
      //   593: iconst_5
      //   594: anewarray 4	java/lang/Object
      //   597: dup
      //   598: iconst_0
      //   599: invokestatic 193	java/lang/System:currentTimeMillis	()J
      //   602: lload 4
      //   604: lsub
      //   605: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   608: aastore
      //   609: dup
      //   610: iconst_1
      //   611: aload 6
      //   613: getfield 174	com/tencent/mm/protocal/protobuf/awk:key	I
      //   616: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   619: aastore
      //   620: dup
      //   621: iconst_2
      //   622: aload 6
      //   624: getfield 202	com/tencent/mm/protocal/protobuf/awk:xlU	J
      //   627: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   630: aastore
      //   631: dup
      //   632: iconst_3
      //   633: aload 6
      //   635: getfield 208	com/tencent/mm/protocal/protobuf/awk:length	I
      //   638: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   641: aastore
      //   642: dup
      //   643: iconst_4
      //   644: aload 6
      //   646: getfield 205	com/tencent/mm/protocal/protobuf/awk:xlV	I
      //   649: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   652: aastore
      //   653: invokestatic 88	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   656: aload 9
      //   658: invokestatic 225	com/tencent/mm/plugin/gallery/model/f:d	(Ljava/io/Closeable;)V
      //   661: aload 8
      //   663: iconst_1
      //   664: putfield 229	com/tencent/mm/plugin/gallery/model/f:dirty	Z
      //   667: aload 8
      //   669: getfield 162	com/tencent/mm/plugin/gallery/model/f:ndd	Landroid/util/SparseArray;
      //   672: iload_3
      //   673: aload 6
      //   675: invokevirtual 233	android/util/SparseArray:put	(ILjava/lang/Object;)V
      //   678: goto -414 -> 264
      //   681: astore 6
      //   683: ldc 117
      //   685: ldc 235
      //   687: iconst_1
      //   688: anewarray 4	java/lang/Object
      //   691: dup
      //   692: iconst_0
      //   693: aload 6
      //   695: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   698: aastore
      //   699: invokestatic 241	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   702: ldc 117
      //   704: aload 6
      //   706: ldc 243
      //   708: iconst_0
      //   709: anewarray 4	java/lang/Object
      //   712: invokestatic 247	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   715: aload 9
      //   717: invokestatic 225	com/tencent/mm/plugin/gallery/model/f:d	(Ljava/io/Closeable;)V
      //   720: goto -456 -> 264
      //   723: astore 6
      //   725: ldc 117
      //   727: ldc 249
      //   729: iconst_1
      //   730: anewarray 4	java/lang/Object
      //   733: dup
      //   734: iconst_0
      //   735: aload 6
      //   737: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   740: aastore
      //   741: invokestatic 241	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   744: aload 9
      //   746: invokestatic 225	com/tencent/mm/plugin/gallery/model/f:d	(Ljava/io/Closeable;)V
      //   749: goto -485 -> 264
      //   752: astore 6
      //   754: aload 9
      //   756: invokestatic 225	com/tencent/mm/plugin/gallery/model/f:d	(Ljava/io/Closeable;)V
      //   759: sipush 21228
      //   762: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   765: aload 6
      //   767: athrow
      //   768: sipush 21228
      //   771: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   774: iconst_1
      //   775: ireturn
      //   776: goto -286 -> 490
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	779	0	this	b
      //   349	237	1	i	int
      //   369	4	2	j	int
      //   235	438	3	k	int
      //   173	430	4	l	long
      //   13	661	6	localObject1	Object
      //   681	24	6	localException1	java.lang.Exception
      //   723	13	6	localException2	java.lang.Exception
      //   752	14	6	localObject2	Object
      //   48	529	7	localObject3	Object
      //   161	507	8	localObject4	Object
      //   167	588	9	localObject5	Object
      //   564	15	10	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   499	512	681	java/lang/Exception
      //   512	656	723	java/lang/Exception
      //   512	656	752	finally
      //   725	744	752	finally
    }
    
    public final boolean acT()
    {
      AppMethodBeat.i(21229);
      ab.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", new Object[] { this.mFilePath });
      c.b(c.this).bO(this.mFilePath);
      ab.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", new Object[] { Integer.valueOf(c.b(c.this).size()) });
      if (this.bitmap == null)
      {
        ab.e("MircoMsg.CacheService", "decode file failed, %s ", new Object[] { this.mFilePath });
        AppMethodBeat.o(21229);
        return false;
      }
      d locald = c.a(c.this);
      String str = this.mFilePath;
      Bitmap localBitmap = this.bitmap;
      int i = this.ncJ;
      if (locald.ncK == null) {
        ab.e("MicroMsg.GalleryCache", "cache is null");
      }
      for (;;)
      {
        this.bitmap = null;
        AppMethodBeat.o(21229);
        return true;
        locald.ncK.f(str, new d.a(locald, localBitmap, i));
        locald.frK.cy(str);
        locald.frK.doNotify();
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(21230);
      if (paramObject == null)
      {
        AppMethodBeat.o(21230);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(21230);
        return true;
      }
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        boolean bool = bo.bf(this.mFilePath, "").equals(paramObject.mFilePath);
        AppMethodBeat.o(21230);
        return bool;
      }
      AppMethodBeat.o(21230);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(21231);
      int i = bo.bf(this.mFilePath, "").hashCode();
      AppMethodBeat.o(21231);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.c
 * JD-Core Version:    0.7.0.1
 */