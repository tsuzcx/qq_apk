package com.tencent.mm.graphics;

public final class a
{
  /* Error */
  public static android.graphics.Bitmap a(java.io.InputStream paramInputStream, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 9
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: iconst_1
    //   10: invokestatic 21	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   13: astore 4
    //   15: aload 4
    //   17: astore_3
    //   18: aload 4
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 25	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: astore 5
    //   27: aload 5
    //   29: astore_3
    //   30: aload 4
    //   32: ifnull +11 -> 43
    //   35: aload 4
    //   37: invokevirtual 29	android/graphics/BitmapRegionDecoder:recycle	()V
    //   40: aload 5
    //   42: astore_3
    //   43: aload_3
    //   44: ifnonnull +134 -> 178
    //   47: ldc 31
    //   49: ldc 33
    //   51: invokestatic 39	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: aconst_null
    //   56: aload_2
    //   57: invokestatic 44	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: astore_2
    //   61: aload 6
    //   63: astore_0
    //   64: aload_2
    //   65: ifnull +47 -> 112
    //   68: aload_2
    //   69: aload_1
    //   70: getfield 50	android/graphics/Rect:left	I
    //   73: aload_1
    //   74: getfield 53	android/graphics/Rect:top	I
    //   77: aload_1
    //   78: getfield 56	android/graphics/Rect:right	I
    //   81: aload_1
    //   82: getfield 50	android/graphics/Rect:left	I
    //   85: isub
    //   86: aload_1
    //   87: getfield 59	android/graphics/Rect:bottom	I
    //   90: aload_1
    //   91: getfield 53	android/graphics/Rect:top	I
    //   94: isub
    //   95: invokestatic 65	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   98: astore_1
    //   99: aload_1
    //   100: astore_0
    //   101: aload_1
    //   102: aload_2
    //   103: if_acmpeq +9 -> 112
    //   106: aload_2
    //   107: invokevirtual 66	android/graphics/Bitmap:recycle	()V
    //   110: aload_1
    //   111: astore_0
    //   112: ldc 9
    //   114: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: areturn
    //   119: astore 5
    //   121: aconst_null
    //   122: astore 4
    //   124: aload 4
    //   126: astore_3
    //   127: ldc 31
    //   129: aload 5
    //   131: ldc 71
    //   133: invokestatic 75	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   136: aload 4
    //   138: ifnull +45 -> 183
    //   141: aload 4
    //   143: invokevirtual 29	android/graphics/BitmapRegionDecoder:recycle	()V
    //   146: aconst_null
    //   147: astore_3
    //   148: goto -105 -> 43
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 29	android/graphics/BitmapRegionDecoder:recycle	()V
    //   162: ldc 9
    //   164: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: goto -16 -> 154
    //   173: astore 5
    //   175: goto -51 -> 124
    //   178: aload_3
    //   179: astore_0
    //   180: goto -68 -> 112
    //   183: aconst_null
    //   184: astore_3
    //   185: goto -142 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramInputStream	java.io.InputStream
    //   0	188	1	paramRect	android.graphics.Rect
    //   0	188	2	paramOptions	android.graphics.BitmapFactory.Options
    //   17	168	3	localObject1	Object
    //   13	129	4	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   25	16	5	localBitmap	android.graphics.Bitmap
    //   119	11	5	localThrowable1	java.lang.Throwable
    //   173	1	5	localThrowable2	java.lang.Throwable
    //   1	61	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	15	119	java/lang/Throwable
    //   8	15	151	finally
    //   18	27	169	finally
    //   127	136	169	finally
    //   18	27	173	java/lang/Throwable
  }
  
  /* Error */
  public static android.graphics.Bitmap a(byte[] paramArrayOfByte, int paramInt, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 78
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: iconst_0
    //   10: iload_1
    //   11: iconst_1
    //   12: invokestatic 81	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: aload_2
    //   24: aload_3
    //   25: invokevirtual 25	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   28: astore 6
    //   30: aload 6
    //   32: astore 4
    //   34: aload 5
    //   36: ifnull +12 -> 48
    //   39: aload 5
    //   41: invokevirtual 29	android/graphics/BitmapRegionDecoder:recycle	()V
    //   44: aload 6
    //   46: astore 4
    //   48: aload 4
    //   50: ifnonnull +140 -> 190
    //   53: ldc 31
    //   55: ldc 33
    //   57: invokestatic 39	com/tencent/f/a/b:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: iconst_0
    //   62: iload_1
    //   63: aload_3
    //   64: invokestatic 85	com/tencent/mm/graphics/MMBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   67: astore_3
    //   68: aload 7
    //   70: astore_0
    //   71: aload_3
    //   72: ifnull +47 -> 119
    //   75: aload_3
    //   76: aload_2
    //   77: getfield 50	android/graphics/Rect:left	I
    //   80: aload_2
    //   81: getfield 53	android/graphics/Rect:top	I
    //   84: aload_2
    //   85: getfield 56	android/graphics/Rect:right	I
    //   88: aload_2
    //   89: getfield 50	android/graphics/Rect:left	I
    //   92: isub
    //   93: aload_2
    //   94: getfield 59	android/graphics/Rect:bottom	I
    //   97: aload_2
    //   98: getfield 53	android/graphics/Rect:top	I
    //   101: isub
    //   102: invokestatic 65	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   105: astore_2
    //   106: aload_2
    //   107: astore_0
    //   108: aload_2
    //   109: aload_3
    //   110: if_acmpeq +9 -> 119
    //   113: aload_3
    //   114: invokevirtual 66	android/graphics/Bitmap:recycle	()V
    //   117: aload_2
    //   118: astore_0
    //   119: ldc 78
    //   121: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_0
    //   125: areturn
    //   126: astore 6
    //   128: aconst_null
    //   129: astore 5
    //   131: aload 5
    //   133: astore 4
    //   135: ldc 31
    //   137: aload 6
    //   139: ldc 71
    //   141: invokestatic 75	com/tencent/f/a/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   144: aload 5
    //   146: ifnull +50 -> 196
    //   149: aload 5
    //   151: invokevirtual 29	android/graphics/BitmapRegionDecoder:recycle	()V
    //   154: aconst_null
    //   155: astore 4
    //   157: goto -109 -> 48
    //   160: astore_0
    //   161: aconst_null
    //   162: astore 4
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 29	android/graphics/BitmapRegionDecoder:recycle	()V
    //   174: ldc 78
    //   176: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: goto -18 -> 164
    //   185: astore 6
    //   187: goto -56 -> 131
    //   190: aload 4
    //   192: astore_0
    //   193: goto -74 -> 119
    //   196: aconst_null
    //   197: astore 4
    //   199: goto -151 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramArrayOfByte	byte[]
    //   0	202	1	paramInt	int
    //   0	202	2	paramRect	android.graphics.Rect
    //   0	202	3	paramOptions	android.graphics.BitmapFactory.Options
    //   19	179	4	localObject1	Object
    //   15	135	5	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   28	17	6	localBitmap	android.graphics.Bitmap
    //   126	12	6	localThrowable1	java.lang.Throwable
    //   185	1	6	localThrowable2	java.lang.Throwable
    //   1	68	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	126	java/lang/Throwable
    //   8	17	160	finally
    //   21	30	181	finally
    //   135	144	181	finally
    //   21	30	185	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.graphics.a
 * JD-Core Version:    0.7.0.1
 */