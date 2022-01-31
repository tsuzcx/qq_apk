package com.tencent.mm.plugin.appbrand.j.a;

import com.tencent.mm.modelappbrand.a.b.e;

public final class a
  implements b.e
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
  
  /* Error */
  public final android.graphics.Bitmap o(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 5
    //   3: aload_1
    //   4: astore 6
    //   6: aload_1
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 22	com/tencent/mm/plugin/appbrand/j/a/a:width	I
    //   13: iflt +21 -> 34
    //   16: aload_1
    //   17: astore 5
    //   19: aload_1
    //   20: astore 6
    //   22: aload_1
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 24	com/tencent/mm/plugin/appbrand/j/a/a:height	I
    //   29: istore_2
    //   30: iload_2
    //   31: ifge +17 -> 48
    //   34: aload_1
    //   35: ifnull +7 -> 42
    //   38: aload_1
    //   39: invokevirtual 36	java/io/InputStream:close	()V
    //   42: aconst_null
    //   43: astore 4
    //   45: aload 4
    //   47: areturn
    //   48: aload_1
    //   49: astore_3
    //   50: aload_1
    //   51: astore 5
    //   53: aload_1
    //   54: astore 6
    //   56: aload_1
    //   57: astore 4
    //   59: aload_1
    //   60: invokevirtual 40	java/io/InputStream:markSupported	()Z
    //   63: ifne +40 -> 103
    //   66: aload_1
    //   67: astore 5
    //   69: aload_1
    //   70: astore 6
    //   72: aload_1
    //   73: astore 4
    //   75: aload_1
    //   76: instanceof 42
    //   79: ifeq +253 -> 332
    //   82: aload_1
    //   83: astore 5
    //   85: aload_1
    //   86: astore 6
    //   88: aload_1
    //   89: astore 4
    //   91: new 44	com/tencent/mm/sdk/platformtools/i
    //   94: dup
    //   95: aload_1
    //   96: checkcast 42	java/io/FileInputStream
    //   99: invokespecial 47	com/tencent/mm/sdk/platformtools/i:<init>	(Ljava/io/FileInputStream;)V
    //   102: astore_3
    //   103: aload_3
    //   104: astore 5
    //   106: aload_3
    //   107: astore 6
    //   109: aload_3
    //   110: astore 4
    //   112: aload_0
    //   113: getfield 22	com/tencent/mm/plugin/appbrand/j/a/a:width	I
    //   116: sipush 1920
    //   119: if_icmplt +49 -> 168
    //   122: aload_3
    //   123: astore 5
    //   125: aload_3
    //   126: astore 6
    //   128: aload_3
    //   129: astore 4
    //   131: ldc 49
    //   133: ldc 51
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: getfield 22	com/tencent/mm/plugin/appbrand/j/a/a:width	I
    //   145: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 63	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_3
    //   153: astore 5
    //   155: aload_3
    //   156: astore 6
    //   158: aload_3
    //   159: astore 4
    //   161: aload_0
    //   162: sipush 1920
    //   165: putfield 22	com/tencent/mm/plugin/appbrand/j/a/a:width	I
    //   168: aload_3
    //   169: astore 5
    //   171: aload_3
    //   172: astore 6
    //   174: aload_3
    //   175: astore 4
    //   177: aload_0
    //   178: getfield 24	com/tencent/mm/plugin/appbrand/j/a/a:height	I
    //   181: sipush 1440
    //   184: if_icmplt +49 -> 233
    //   187: aload_3
    //   188: astore 5
    //   190: aload_3
    //   191: astore 6
    //   193: aload_3
    //   194: astore 4
    //   196: ldc 49
    //   198: ldc 65
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_0
    //   207: getfield 24	com/tencent/mm/plugin/appbrand/j/a/a:height	I
    //   210: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: invokestatic 63	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload_3
    //   218: astore 5
    //   220: aload_3
    //   221: astore 6
    //   223: aload_3
    //   224: astore 4
    //   226: aload_0
    //   227: sipush 1440
    //   230: putfield 24	com/tencent/mm/plugin/appbrand/j/a/a:height	I
    //   233: aload_3
    //   234: astore 5
    //   236: aload_3
    //   237: astore 6
    //   239: aload_3
    //   240: astore 4
    //   242: new 67	android/graphics/BitmapFactory$Options
    //   245: dup
    //   246: invokespecial 68	android/graphics/BitmapFactory$Options:<init>	()V
    //   249: astore_1
    //   250: aload_3
    //   251: astore 5
    //   253: aload_3
    //   254: astore 6
    //   256: aload_3
    //   257: astore 4
    //   259: aload_1
    //   260: iconst_1
    //   261: putfield 72	android/graphics/BitmapFactory$Options:inMutable	Z
    //   264: aload_3
    //   265: astore 5
    //   267: aload_3
    //   268: astore 6
    //   270: aload_3
    //   271: astore 4
    //   273: aload_3
    //   274: iconst_0
    //   275: invokestatic 78	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   278: new 80	android/graphics/Rect
    //   281: dup
    //   282: aload_0
    //   283: getfield 18	com/tencent/mm/plugin/appbrand/j/a/a:left	I
    //   286: aload_0
    //   287: getfield 20	com/tencent/mm/plugin/appbrand/j/a/a:top	I
    //   290: aload_0
    //   291: getfield 18	com/tencent/mm/plugin/appbrand/j/a/a:left	I
    //   294: aload_0
    //   295: getfield 22	com/tencent/mm/plugin/appbrand/j/a/a:width	I
    //   298: iadd
    //   299: aload_0
    //   300: getfield 20	com/tencent/mm/plugin/appbrand/j/a/a:top	I
    //   303: aload_0
    //   304: getfield 24	com/tencent/mm/plugin/appbrand/j/a/a:height	I
    //   307: iadd
    //   308: invokespecial 82	android/graphics/Rect:<init>	(IIII)V
    //   311: aload_1
    //   312: invokevirtual 86	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   315: astore_1
    //   316: aload_1
    //   317: astore 4
    //   319: aload_3
    //   320: ifnull -275 -> 45
    //   323: aload_3
    //   324: invokevirtual 36	java/io/InputStream:close	()V
    //   327: aload_1
    //   328: areturn
    //   329: astore_3
    //   330: aload_1
    //   331: areturn
    //   332: aload_1
    //   333: astore_3
    //   334: aload_1
    //   335: astore 5
    //   337: aload_1
    //   338: astore 6
    //   340: aload_1
    //   341: astore 4
    //   343: aload_1
    //   344: invokevirtual 40	java/io/InputStream:markSupported	()Z
    //   347: ifne -244 -> 103
    //   350: aload_1
    //   351: astore 5
    //   353: aload_1
    //   354: astore 6
    //   356: aload_1
    //   357: astore 4
    //   359: new 88	java/io/BufferedInputStream
    //   362: dup
    //   363: aload_1
    //   364: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   367: astore_3
    //   368: goto -265 -> 103
    //   371: astore_1
    //   372: aload 5
    //   374: astore 4
    //   376: ldc 49
    //   378: ldc 93
    //   380: iconst_1
    //   381: anewarray 4	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload_1
    //   387: invokestatic 99	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   390: aastore
    //   391: invokestatic 102	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   394: aload 5
    //   396: ifnull +8 -> 404
    //   399: aload 5
    //   401: invokevirtual 36	java/io/InputStream:close	()V
    //   404: aconst_null
    //   405: areturn
    //   406: astore_1
    //   407: aload 6
    //   409: astore 4
    //   411: ldc 49
    //   413: ldc 93
    //   415: iconst_1
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: aload_1
    //   422: invokestatic 99	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 102	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   429: aload 6
    //   431: ifnull -27 -> 404
    //   434: aload 6
    //   436: invokevirtual 36	java/io/InputStream:close	()V
    //   439: goto -35 -> 404
    //   442: astore_1
    //   443: goto -39 -> 404
    //   446: astore_1
    //   447: aload 4
    //   449: ifnull +8 -> 457
    //   452: aload 4
    //   454: invokevirtual 36	java/io/InputStream:close	()V
    //   457: aload_1
    //   458: athrow
    //   459: astore_1
    //   460: goto -418 -> 42
    //   463: astore_1
    //   464: goto -60 -> 404
    //   467: astore_3
    //   468: goto -11 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	a
    //   0	471	1	paramInputStream	java.io.InputStream
    //   29	2	2	i	int
    //   49	275	3	localObject1	Object
    //   329	1	3	localIOException1	java.io.IOException
    //   333	35	3	localObject2	Object
    //   467	1	3	localIOException2	java.io.IOException
    //   7	446	4	localObject3	Object
    //   1	399	5	localObject4	Object
    //   4	431	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   323	327	329	java/io/IOException
    //   9	16	371	java/io/IOException
    //   25	30	371	java/io/IOException
    //   59	66	371	java/io/IOException
    //   75	82	371	java/io/IOException
    //   91	103	371	java/io/IOException
    //   112	122	371	java/io/IOException
    //   131	152	371	java/io/IOException
    //   161	168	371	java/io/IOException
    //   177	187	371	java/io/IOException
    //   196	217	371	java/io/IOException
    //   226	233	371	java/io/IOException
    //   242	250	371	java/io/IOException
    //   259	264	371	java/io/IOException
    //   273	316	371	java/io/IOException
    //   343	350	371	java/io/IOException
    //   359	368	371	java/io/IOException
    //   9	16	406	java/lang/IllegalArgumentException
    //   25	30	406	java/lang/IllegalArgumentException
    //   59	66	406	java/lang/IllegalArgumentException
    //   75	82	406	java/lang/IllegalArgumentException
    //   91	103	406	java/lang/IllegalArgumentException
    //   112	122	406	java/lang/IllegalArgumentException
    //   131	152	406	java/lang/IllegalArgumentException
    //   161	168	406	java/lang/IllegalArgumentException
    //   177	187	406	java/lang/IllegalArgumentException
    //   196	217	406	java/lang/IllegalArgumentException
    //   226	233	406	java/lang/IllegalArgumentException
    //   242	250	406	java/lang/IllegalArgumentException
    //   259	264	406	java/lang/IllegalArgumentException
    //   273	316	406	java/lang/IllegalArgumentException
    //   343	350	406	java/lang/IllegalArgumentException
    //   359	368	406	java/lang/IllegalArgumentException
    //   434	439	442	java/io/IOException
    //   9	16	446	finally
    //   25	30	446	finally
    //   59	66	446	finally
    //   75	82	446	finally
    //   91	103	446	finally
    //   112	122	446	finally
    //   131	152	446	finally
    //   161	168	446	finally
    //   177	187	446	finally
    //   196	217	446	finally
    //   226	233	446	finally
    //   242	250	446	finally
    //   259	264	446	finally
    //   273	316	446	finally
    //   343	350	446	finally
    //   359	368	446	finally
    //   376	394	446	finally
    //   411	429	446	finally
    //   38	42	459	java/io/IOException
    //   399	404	463	java/io/IOException
    //   452	457	467	java/io/IOException
  }
  
  public final String pU()
  {
    return String.format("Decoder_x%s_y%s_w%s_h%s", new Object[] { Integer.valueOf(this.left), Integer.valueOf(this.top), Integer.valueOf(this.width), Integer.valueOf(this.height) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a.a
 * JD-Core Version:    0.7.0.1
 */