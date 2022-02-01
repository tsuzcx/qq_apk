package com.tencent.mm.plugin.appbrand.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;

public final class a
  implements b.f
{
  private int height;
  private int left;
  private int top;
  private int width;
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
  }
  
  public final String AL()
  {
    AppMethodBeat.i(134892);
    String str = String.format("Decoder_x%s_y%s_w%s_h%s", new Object[] { Integer.valueOf(this.left), Integer.valueOf(this.top), Integer.valueOf(this.width), Integer.valueOf(this.height) });
    AppMethodBeat.o(134892);
    return str;
  }
  
  /* Error */
  public final android.graphics.Bitmap u(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 60
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore 5
    //   8: aload_1
    //   9: astore 6
    //   11: aload_1
    //   12: astore 7
    //   14: aload_1
    //   15: astore 4
    //   17: aload_0
    //   18: getfield 22	com/tencent/mm/plugin/appbrand/luggage/a/a:width	I
    //   21: iflt +24 -> 45
    //   24: aload_1
    //   25: astore 5
    //   27: aload_1
    //   28: astore 6
    //   30: aload_1
    //   31: astore 7
    //   33: aload_1
    //   34: astore 4
    //   36: aload_0
    //   37: getfield 24	com/tencent/mm/plugin/appbrand/luggage/a/a:height	I
    //   40: istore_2
    //   41: iload_2
    //   42: ifge +18 -> 60
    //   45: aload_1
    //   46: ifnull +7 -> 53
    //   49: aload_1
    //   50: invokevirtual 65	java/io/InputStream:close	()V
    //   53: ldc 60
    //   55: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aconst_null
    //   59: areturn
    //   60: aload_1
    //   61: astore_3
    //   62: aload_1
    //   63: astore 5
    //   65: aload_1
    //   66: astore 6
    //   68: aload_1
    //   69: astore 7
    //   71: aload_1
    //   72: astore 4
    //   74: aload_1
    //   75: invokevirtual 69	java/io/InputStream:markSupported	()Z
    //   78: ifne +46 -> 124
    //   81: aload_1
    //   82: astore 5
    //   84: aload_1
    //   85: astore 6
    //   87: aload_1
    //   88: astore 7
    //   90: aload_1
    //   91: astore 4
    //   93: aload_1
    //   94: instanceof 71
    //   97: ifeq +169 -> 266
    //   100: aload_1
    //   101: astore 5
    //   103: aload_1
    //   104: astore 6
    //   106: aload_1
    //   107: astore 7
    //   109: aload_1
    //   110: astore 4
    //   112: new 73	com/tencent/mm/sdk/platformtools/n
    //   115: dup
    //   116: aload_1
    //   117: checkcast 71	java/io/FileInputStream
    //   120: invokespecial 76	com/tencent/mm/sdk/platformtools/n:<init>	(Ljava/io/FileInputStream;)V
    //   123: astore_3
    //   124: aload_3
    //   125: astore 5
    //   127: aload_3
    //   128: astore 6
    //   130: aload_3
    //   131: astore 7
    //   133: aload_3
    //   134: astore 4
    //   136: new 78	android/graphics/BitmapFactory$Options
    //   139: dup
    //   140: invokespecial 79	android/graphics/BitmapFactory$Options:<init>	()V
    //   143: astore 8
    //   145: aload_3
    //   146: astore 5
    //   148: aload_3
    //   149: astore 6
    //   151: aload_3
    //   152: astore 7
    //   154: aload_3
    //   155: astore 4
    //   157: aload 8
    //   159: iconst_1
    //   160: putfield 83	android/graphics/BitmapFactory$Options:inMutable	Z
    //   163: aload_3
    //   164: astore 5
    //   166: aload_3
    //   167: astore 6
    //   169: aload_3
    //   170: astore 7
    //   172: aload_3
    //   173: astore 4
    //   175: aload_3
    //   176: iconst_0
    //   177: invokestatic 89	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   180: astore_1
    //   181: aload_3
    //   182: astore 5
    //   184: aload_3
    //   185: astore 6
    //   187: aload_3
    //   188: astore 7
    //   190: aload_3
    //   191: astore 4
    //   193: aload_1
    //   194: new 91	android/graphics/Rect
    //   197: dup
    //   198: aload_0
    //   199: getfield 18	com/tencent/mm/plugin/appbrand/luggage/a/a:left	I
    //   202: aload_0
    //   203: getfield 20	com/tencent/mm/plugin/appbrand/luggage/a/a:top	I
    //   206: aload_0
    //   207: getfield 18	com/tencent/mm/plugin/appbrand/luggage/a/a:left	I
    //   210: aload_0
    //   211: getfield 22	com/tencent/mm/plugin/appbrand/luggage/a/a:width	I
    //   214: iadd
    //   215: aload_0
    //   216: getfield 20	com/tencent/mm/plugin/appbrand/luggage/a/a:top	I
    //   219: aload_0
    //   220: getfield 24	com/tencent/mm/plugin/appbrand/luggage/a/a:height	I
    //   223: iadd
    //   224: invokespecial 93	android/graphics/Rect:<init>	(IIII)V
    //   227: aload 8
    //   229: invokevirtual 97	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   232: astore 8
    //   234: aload_3
    //   235: astore 5
    //   237: aload_3
    //   238: astore 6
    //   240: aload_3
    //   241: astore 7
    //   243: aload_3
    //   244: astore 4
    //   246: aload_1
    //   247: invokevirtual 100	android/graphics/BitmapRegionDecoder:recycle	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 65	java/io/InputStream:close	()V
    //   258: ldc 60
    //   260: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload 8
    //   265: areturn
    //   266: aload_1
    //   267: astore_3
    //   268: aload_1
    //   269: astore 5
    //   271: aload_1
    //   272: astore 6
    //   274: aload_1
    //   275: astore 7
    //   277: aload_1
    //   278: astore 4
    //   280: aload_1
    //   281: invokevirtual 69	java/io/InputStream:markSupported	()Z
    //   284: ifne -160 -> 124
    //   287: aload_1
    //   288: astore 5
    //   290: aload_1
    //   291: astore 6
    //   293: aload_1
    //   294: astore 7
    //   296: aload_1
    //   297: astore 4
    //   299: new 102	java/io/BufferedInputStream
    //   302: dup
    //   303: aload_1
    //   304: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   307: astore_3
    //   308: goto -184 -> 124
    //   311: astore_1
    //   312: aload 5
    //   314: astore 4
    //   316: ldc 107
    //   318: ldc 109
    //   320: iconst_1
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload_1
    //   327: invokestatic 115	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   330: aastore
    //   331: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   334: aload 5
    //   336: ifnull +8 -> 344
    //   339: aload 5
    //   341: invokevirtual 65	java/io/InputStream:close	()V
    //   344: ldc 60
    //   346: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aconst_null
    //   350: areturn
    //   351: astore_1
    //   352: aload 6
    //   354: astore 4
    //   356: ldc 107
    //   358: ldc 109
    //   360: iconst_1
    //   361: anewarray 4	java/lang/Object
    //   364: dup
    //   365: iconst_0
    //   366: aload_1
    //   367: invokestatic 115	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   370: aastore
    //   371: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload 6
    //   376: ifnull -32 -> 344
    //   379: aload 6
    //   381: invokevirtual 65	java/io/InputStream:close	()V
    //   384: goto -40 -> 344
    //   387: astore_1
    //   388: goto -44 -> 344
    //   391: astore_1
    //   392: aload 7
    //   394: astore 4
    //   396: ldc 107
    //   398: ldc 109
    //   400: iconst_1
    //   401: anewarray 4	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: aload_1
    //   407: invokestatic 115	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   410: aastore
    //   411: invokestatic 121	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: aload 7
    //   416: ifnull -72 -> 344
    //   419: aload 7
    //   421: invokevirtual 65	java/io/InputStream:close	()V
    //   424: goto -80 -> 344
    //   427: astore_1
    //   428: goto -84 -> 344
    //   431: astore_1
    //   432: aload 4
    //   434: ifnull +8 -> 442
    //   437: aload 4
    //   439: invokevirtual 65	java/io/InputStream:close	()V
    //   442: ldc 60
    //   444: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aload_1
    //   448: athrow
    //   449: astore_1
    //   450: goto -397 -> 53
    //   453: astore_1
    //   454: goto -196 -> 258
    //   457: astore_1
    //   458: goto -114 -> 344
    //   461: astore_3
    //   462: goto -20 -> 442
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	a
    //   0	465	1	paramInputStream	java.io.InputStream
    //   40	2	2	i	int
    //   61	247	3	localObject1	Object
    //   461	1	3	localIOException	java.io.IOException
    //   15	423	4	localObject2	Object
    //   6	334	5	localObject3	Object
    //   9	371	6	localObject4	Object
    //   12	408	7	localObject5	Object
    //   143	121	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	311	java/io/IOException
    //   36	41	311	java/io/IOException
    //   74	81	311	java/io/IOException
    //   93	100	311	java/io/IOException
    //   112	124	311	java/io/IOException
    //   136	145	311	java/io/IOException
    //   157	163	311	java/io/IOException
    //   175	181	311	java/io/IOException
    //   193	234	311	java/io/IOException
    //   246	250	311	java/io/IOException
    //   280	287	311	java/io/IOException
    //   299	308	311	java/io/IOException
    //   17	24	351	java/lang/IllegalArgumentException
    //   36	41	351	java/lang/IllegalArgumentException
    //   74	81	351	java/lang/IllegalArgumentException
    //   93	100	351	java/lang/IllegalArgumentException
    //   112	124	351	java/lang/IllegalArgumentException
    //   136	145	351	java/lang/IllegalArgumentException
    //   157	163	351	java/lang/IllegalArgumentException
    //   175	181	351	java/lang/IllegalArgumentException
    //   193	234	351	java/lang/IllegalArgumentException
    //   246	250	351	java/lang/IllegalArgumentException
    //   280	287	351	java/lang/IllegalArgumentException
    //   299	308	351	java/lang/IllegalArgumentException
    //   379	384	387	java/io/IOException
    //   17	24	391	java/lang/OutOfMemoryError
    //   36	41	391	java/lang/OutOfMemoryError
    //   74	81	391	java/lang/OutOfMemoryError
    //   93	100	391	java/lang/OutOfMemoryError
    //   112	124	391	java/lang/OutOfMemoryError
    //   136	145	391	java/lang/OutOfMemoryError
    //   157	163	391	java/lang/OutOfMemoryError
    //   175	181	391	java/lang/OutOfMemoryError
    //   193	234	391	java/lang/OutOfMemoryError
    //   246	250	391	java/lang/OutOfMemoryError
    //   280	287	391	java/lang/OutOfMemoryError
    //   299	308	391	java/lang/OutOfMemoryError
    //   419	424	427	java/io/IOException
    //   17	24	431	finally
    //   36	41	431	finally
    //   74	81	431	finally
    //   93	100	431	finally
    //   112	124	431	finally
    //   136	145	431	finally
    //   157	163	431	finally
    //   175	181	431	finally
    //   193	234	431	finally
    //   246	250	431	finally
    //   280	287	431	finally
    //   299	308	431	finally
    //   316	334	431	finally
    //   356	374	431	finally
    //   396	414	431	finally
    //   49	53	449	java/io/IOException
    //   254	258	453	java/io/IOException
    //   339	344	457	java/io/IOException
    //   437	442	461	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a.a
 * JD-Core Version:    0.7.0.1
 */