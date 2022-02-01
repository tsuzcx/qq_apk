package com.tencent.mm.graphics;

public final class b
{
  /* Error */
  public static android.graphics.Bitmap a(java.io.InputStream paramInputStream, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: sipush 1012
    //   6: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_1
    //   11: invokestatic 20	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 4
    //   21: aload_1
    //   22: aload_2
    //   23: invokevirtual 24	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore 5
    //   28: aload 5
    //   30: astore_3
    //   31: aload 4
    //   33: ifnull +11 -> 44
    //   36: aload 4
    //   38: invokevirtual 28	android/graphics/BitmapRegionDecoder:recycle	()V
    //   41: aload 5
    //   43: astore_3
    //   44: aload_3
    //   45: ifnonnull +136 -> 181
    //   48: ldc 30
    //   50: ldc 32
    //   52: invokestatic 38	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: aconst_null
    //   57: aload_2
    //   58: invokestatic 43	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: astore_2
    //   62: aload 6
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull +47 -> 113
    //   69: aload_2
    //   70: aload_1
    //   71: getfield 49	android/graphics/Rect:left	I
    //   74: aload_1
    //   75: getfield 52	android/graphics/Rect:top	I
    //   78: aload_1
    //   79: getfield 55	android/graphics/Rect:right	I
    //   82: aload_1
    //   83: getfield 49	android/graphics/Rect:left	I
    //   86: isub
    //   87: aload_1
    //   88: getfield 58	android/graphics/Rect:bottom	I
    //   91: aload_1
    //   92: getfield 52	android/graphics/Rect:top	I
    //   95: isub
    //   96: invokestatic 64	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   99: astore_1
    //   100: aload_1
    //   101: astore_0
    //   102: aload_1
    //   103: aload_2
    //   104: if_acmpeq +9 -> 113
    //   107: aload_2
    //   108: invokevirtual 65	android/graphics/Bitmap:recycle	()V
    //   111: aload_1
    //   112: astore_0
    //   113: sipush 1012
    //   116: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: aload_0
    //   120: areturn
    //   121: astore 5
    //   123: aconst_null
    //   124: astore 4
    //   126: aload 4
    //   128: astore_3
    //   129: ldc 30
    //   131: aload 5
    //   133: ldc 70
    //   135: invokestatic 74	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   138: aload 4
    //   140: ifnull +46 -> 186
    //   143: aload 4
    //   145: invokevirtual 28	android/graphics/BitmapRegionDecoder:recycle	()V
    //   148: aconst_null
    //   149: astore_3
    //   150: goto -106 -> 44
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_3
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 28	android/graphics/BitmapRegionDecoder:recycle	()V
    //   164: sipush 1012
    //   167: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: aload_0
    //   171: athrow
    //   172: astore_0
    //   173: goto -17 -> 156
    //   176: astore 5
    //   178: goto -52 -> 126
    //   181: aload_3
    //   182: astore_0
    //   183: goto -70 -> 113
    //   186: aconst_null
    //   187: astore_3
    //   188: goto -144 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramInputStream	java.io.InputStream
    //   0	191	1	paramRect	android.graphics.Rect
    //   0	191	2	paramOptions	android.graphics.BitmapFactory.Options
    //   18	170	3	localObject1	Object
    //   14	130	4	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   26	16	5	localBitmap	android.graphics.Bitmap
    //   121	11	5	localThrowable1	java.lang.Throwable
    //   176	1	5	localThrowable2	java.lang.Throwable
    //   1	62	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	16	121	java/lang/Throwable
    //   9	16	153	finally
    //   19	28	172	finally
    //   129	138	172	finally
    //   19	28	176	java/lang/Throwable
  }
  
  /* Error */
  public static android.graphics.Bitmap a(byte[] paramArrayOfByte, int paramInt, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: sipush 1013
    //   6: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_0
    //   11: iload_1
    //   12: iconst_1
    //   13: invokestatic 79	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   16: astore 5
    //   18: aload 5
    //   20: astore 4
    //   22: aload 5
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 24	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore 6
    //   31: aload 6
    //   33: astore 4
    //   35: aload 5
    //   37: ifnull +12 -> 49
    //   40: aload 5
    //   42: invokevirtual 28	android/graphics/BitmapRegionDecoder:recycle	()V
    //   45: aload 6
    //   47: astore 4
    //   49: aload 4
    //   51: ifnonnull +142 -> 193
    //   54: ldc 30
    //   56: ldc 32
    //   58: invokestatic 38	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: iconst_0
    //   63: iload_1
    //   64: aload_3
    //   65: invokestatic 83	com/tencent/mm/graphics/MMBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   68: astore_3
    //   69: aload 7
    //   71: astore_0
    //   72: aload_3
    //   73: ifnull +47 -> 120
    //   76: aload_3
    //   77: aload_2
    //   78: getfield 49	android/graphics/Rect:left	I
    //   81: aload_2
    //   82: getfield 52	android/graphics/Rect:top	I
    //   85: aload_2
    //   86: getfield 55	android/graphics/Rect:right	I
    //   89: aload_2
    //   90: getfield 49	android/graphics/Rect:left	I
    //   93: isub
    //   94: aload_2
    //   95: getfield 58	android/graphics/Rect:bottom	I
    //   98: aload_2
    //   99: getfield 52	android/graphics/Rect:top	I
    //   102: isub
    //   103: invokestatic 64	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   106: astore_2
    //   107: aload_2
    //   108: astore_0
    //   109: aload_2
    //   110: aload_3
    //   111: if_acmpeq +9 -> 120
    //   114: aload_3
    //   115: invokevirtual 65	android/graphics/Bitmap:recycle	()V
    //   118: aload_2
    //   119: astore_0
    //   120: sipush 1013
    //   123: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_0
    //   127: areturn
    //   128: astore 6
    //   130: aconst_null
    //   131: astore 5
    //   133: aload 5
    //   135: astore 4
    //   137: ldc 30
    //   139: aload 6
    //   141: ldc 70
    //   143: invokestatic 74	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   146: aload 5
    //   148: ifnull +51 -> 199
    //   151: aload 5
    //   153: invokevirtual 28	android/graphics/BitmapRegionDecoder:recycle	()V
    //   156: aconst_null
    //   157: astore 4
    //   159: goto -110 -> 49
    //   162: astore_0
    //   163: aconst_null
    //   164: astore 4
    //   166: aload 4
    //   168: ifnull +8 -> 176
    //   171: aload 4
    //   173: invokevirtual 28	android/graphics/BitmapRegionDecoder:recycle	()V
    //   176: sipush 1013
    //   179: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: goto -19 -> 166
    //   188: astore 6
    //   190: goto -57 -> 133
    //   193: aload 4
    //   195: astore_0
    //   196: goto -76 -> 120
    //   199: aconst_null
    //   200: astore 4
    //   202: goto -153 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	paramArrayOfByte	byte[]
    //   0	205	1	paramInt	int
    //   0	205	2	paramRect	android.graphics.Rect
    //   0	205	3	paramOptions	android.graphics.BitmapFactory.Options
    //   20	181	4	localObject1	Object
    //   16	136	5	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   29	17	6	localBitmap	android.graphics.Bitmap
    //   128	12	6	localThrowable1	java.lang.Throwable
    //   188	1	6	localThrowable2	java.lang.Throwable
    //   1	69	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	128	java/lang/Throwable
    //   9	18	162	finally
    //   22	31	184	finally
    //   137	146	184	finally
    //   22	31	188	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.graphics.b
 * JD-Core Version:    0.7.0.1
 */