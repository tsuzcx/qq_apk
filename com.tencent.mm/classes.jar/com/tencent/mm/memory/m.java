package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends l
{
  private static int liN = -1;
  
  /* Error */
  private static Bitmap b(java.io.InputStream paramInputStream, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 31	com/tencent/mm/memory/h:liI	Lcom/tencent/mm/memory/h;
    //   8: invokevirtual 35	com/tencent/mm/memory/h:acquire	()Ljava/lang/Object;
    //   11: checkcast 37	java/nio/ByteBuffer
    //   14: astore_3
    //   15: aload_2
    //   16: astore 4
    //   18: aload_2
    //   19: ifnonnull +12 -> 31
    //   22: new 39	android/graphics/BitmapFactory$Options
    //   25: dup
    //   26: invokespecial 40	android/graphics/BitmapFactory$Options:<init>	()V
    //   29: astore 4
    //   31: aload_3
    //   32: ifnull +12 -> 44
    //   35: aload 4
    //   37: aload_3
    //   38: invokevirtual 44	java/nio/ByteBuffer:array	()[B
    //   41: putfield 48	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   44: aload 4
    //   46: iconst_1
    //   47: putfield 52	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: aload 4
    //   54: invokestatic 57	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aload 4
    //   60: getfield 60	android/graphics/BitmapFactory$Options:outWidth	I
    //   63: iconst_m1
    //   64: if_icmpeq +12 -> 76
    //   67: aload 4
    //   69: getfield 63	android/graphics/BitmapFactory$Options:outHeight	I
    //   72: iconst_m1
    //   73: if_icmpne +60 -> 133
    //   76: new 65	java/lang/IllegalArgumentException
    //   79: dup
    //   80: ldc 67
    //   82: invokespecial 70	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: ldc 19
    //   88: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: astore_1
    //   94: aload_3
    //   95: astore_0
    //   96: ldc 75
    //   98: ldc 77
    //   100: iconst_1
    //   101: anewarray 79	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_1
    //   107: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: ifnull +11 -> 126
    //   118: getstatic 31	com/tencent/mm/memory/h:liI	Lcom/tencent/mm/memory/h;
    //   121: aload_0
    //   122: invokevirtual 93	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: ldc 19
    //   128: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aconst_null
    //   132: areturn
    //   133: ldc 75
    //   135: ldc 95
    //   137: iconst_1
    //   138: anewarray 79	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload 4
    //   145: getfield 99	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload 4
    //   154: iconst_1
    //   155: putfield 104	android/graphics/BitmapFactory$Options:inDither	Z
    //   158: aload 4
    //   160: iconst_1
    //   161: putfield 107	android/graphics/BitmapFactory$Options:inMutable	Z
    //   164: aload 4
    //   166: iconst_1
    //   167: putfield 110	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   170: aload 4
    //   172: iconst_1
    //   173: putfield 113	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   176: aload 4
    //   178: iconst_0
    //   179: putfield 52	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   182: aload 4
    //   184: invokestatic 119	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   187: aload_0
    //   188: invokestatic 123	com/tencent/mm/memory/m:s	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   191: astore_0
    //   192: aload_0
    //   193: invokestatic 127	com/tencent/mm/memory/m:t	(Ljava/io/InputStream;)V
    //   196: aload_0
    //   197: aload_1
    //   198: aload 4
    //   200: invokestatic 130	com/tencent/mm/memory/m:c	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   203: astore_0
    //   204: aload_3
    //   205: ifnull +11 -> 216
    //   208: getstatic 31	com/tencent/mm/memory/h:liI	Lcom/tencent/mm/memory/h;
    //   211: aload_3
    //   212: invokevirtual 93	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   215: pop
    //   216: ldc 19
    //   218: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_0
    //   222: areturn
    //   223: astore_1
    //   224: aconst_null
    //   225: astore_0
    //   226: aload_0
    //   227: ifnull +11 -> 238
    //   230: getstatic 31	com/tencent/mm/memory/h:liI	Lcom/tencent/mm/memory/h;
    //   233: aload_0
    //   234: invokevirtual 93	com/tencent/mm/memory/h:release	(Ljava/lang/Object;)Z
    //   237: pop
    //   238: ldc 19
    //   240: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: aload_3
    //   247: astore_0
    //   248: goto -22 -> 226
    //   251: astore_1
    //   252: goto -26 -> 226
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_0
    //   258: goto -162 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramInputStream	java.io.InputStream
    //   0	261	1	paramRect	android.graphics.Rect
    //   0	261	2	paramOptions	android.graphics.BitmapFactory.Options
    //   14	233	3	localByteBuffer	java.nio.ByteBuffer
    //   16	183	4	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   22	31	93	java/lang/Exception
    //   35	44	93	java/lang/Exception
    //   44	76	93	java/lang/Exception
    //   76	93	93	java/lang/Exception
    //   133	204	93	java/lang/Exception
    //   5	15	223	finally
    //   22	31	245	finally
    //   35	44	245	finally
    //   44	76	245	finally
    //   76	93	245	finally
    //   133	204	245	finally
    //   96	114	251	finally
    //   5	15	255	java/lang/Exception
  }
  
  /* Error */
  private static Bitmap c(java.io.InputStream paramInputStream, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_m1
    //   6: istore 5
    //   8: aload_0
    //   9: ifnull +140 -> 149
    //   12: iload 5
    //   14: istore 4
    //   16: aload_0
    //   17: invokevirtual 137	java/io/InputStream:available	()I
    //   20: istore_3
    //   21: iload_3
    //   22: istore 4
    //   24: iload_3
    //   25: istore 5
    //   27: getstatic 143	com/tencent/mm/memory/g:liH	Lcom/tencent/mm/memory/g;
    //   30: iload_3
    //   31: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: invokevirtual 153	com/tencent/mm/memory/g:g	(Ljava/lang/Integer;)Ljava/lang/Object;
    //   37: checkcast 154	[B
    //   40: astore 6
    //   42: aload 6
    //   44: ifnonnull +230 -> 274
    //   47: iload_3
    //   48: newarray byte
    //   50: astore 7
    //   52: aload 7
    //   54: astore 6
    //   56: aload 6
    //   58: astore 7
    //   60: iload_3
    //   61: istore 4
    //   63: aload_0
    //   64: aload 6
    //   66: invokevirtual 158	java/io/InputStream:read	([B)I
    //   69: pop
    //   70: aload_1
    //   71: ifnonnull +59 -> 130
    //   74: aload 6
    //   76: astore 7
    //   78: iload_3
    //   79: istore 4
    //   81: aload 6
    //   83: iconst_0
    //   84: iload_3
    //   85: aload_2
    //   86: invokestatic 162	com/tencent/mm/graphics/MMBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore_1
    //   90: aload 6
    //   92: astore 7
    //   94: iload_3
    //   95: istore 4
    //   97: aload_1
    //   98: invokestatic 166	com/tencent/mm/graphics/MMBitmapFactory:pinBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   101: astore_1
    //   102: aload_0
    //   103: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   106: iload_3
    //   107: ifle +16 -> 123
    //   110: aload 6
    //   112: ifnull +11 -> 123
    //   115: getstatic 143	com/tencent/mm/memory/g:liH	Lcom/tencent/mm/memory/g;
    //   118: aload 6
    //   120: invokevirtual 176	com/tencent/mm/memory/g:as	([B)V
    //   123: ldc 131
    //   125: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: areturn
    //   130: aload 6
    //   132: astore 7
    //   134: iload_3
    //   135: istore 4
    //   137: aload 6
    //   139: iload_3
    //   140: aload_1
    //   141: aload_2
    //   142: invokestatic 182	com/tencent/mm/graphics/b:a	([BILandroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   145: astore_1
    //   146: goto -56 -> 90
    //   149: aload_0
    //   150: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   153: ldc 131
    //   155: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aconst_null
    //   162: astore 6
    //   164: iload 4
    //   166: istore_3
    //   167: aload 6
    //   169: astore 7
    //   171: iload_3
    //   172: istore 4
    //   174: ldc 75
    //   176: ldc 184
    //   178: iconst_1
    //   179: anewarray 79	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload_1
    //   185: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   196: iload_3
    //   197: ifle -44 -> 153
    //   200: aload 6
    //   202: ifnull -49 -> 153
    //   205: getstatic 143	com/tencent/mm/memory/g:liH	Lcom/tencent/mm/memory/g;
    //   208: aload 6
    //   210: invokevirtual 176	com/tencent/mm/memory/g:as	([B)V
    //   213: goto -60 -> 153
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 7
    //   220: iload 5
    //   222: istore_3
    //   223: aload_0
    //   224: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   227: iload_3
    //   228: ifle +16 -> 244
    //   231: aload 7
    //   233: ifnull +11 -> 244
    //   236: getstatic 143	com/tencent/mm/memory/g:liH	Lcom/tencent/mm/memory/g;
    //   239: aload 7
    //   241: invokevirtual 176	com/tencent/mm/memory/g:as	([B)V
    //   244: ldc 131
    //   246: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: aload 6
    //   254: astore 7
    //   256: goto -33 -> 223
    //   259: astore_1
    //   260: iload 4
    //   262: istore_3
    //   263: goto -40 -> 223
    //   266: astore_1
    //   267: goto -100 -> 167
    //   270: astore_1
    //   271: goto -104 -> 167
    //   274: goto -218 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramInputStream	java.io.InputStream
    //   0	277	1	paramRect	android.graphics.Rect
    //   0	277	2	paramOptions	android.graphics.BitmapFactory.Options
    //   20	243	3	i	int
    //   14	247	4	j	int
    //   6	215	5	k	int
    //   40	213	6	localObject1	Object
    //   50	205	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   16	21	160	java/lang/Exception
    //   27	42	160	java/lang/Exception
    //   16	21	216	finally
    //   27	42	216	finally
    //   47	52	251	finally
    //   63	70	259	finally
    //   81	90	259	finally
    //   97	102	259	finally
    //   137	146	259	finally
    //   174	192	259	finally
    //   47	52	266	java/lang/Exception
    //   63	70	270	java/lang/Exception
    //   81	90	270	java/lang/Exception
    //   97	102	270	java/lang/Exception
    //   137	146	270	java/lang/Exception
  }
  
  /* Error */
  public final Bitmap a(java.lang.String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 192	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_3
    //   10: aload_3
    //   11: astore_1
    //   12: aload_3
    //   13: aconst_null
    //   14: aload_2
    //   15: invokestatic 194	com/tencent/mm/memory/m:b	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   18: astore_2
    //   19: aload_3
    //   20: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   23: ldc 186
    //   25: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_2
    //   29: areturn
    //   30: astore_2
    //   31: aconst_null
    //   32: astore_3
    //   33: aload_3
    //   34: astore_1
    //   35: ldc 75
    //   37: ldc 196
    //   39: iconst_1
    //   40: anewarray 79	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_2
    //   46: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   49: aastore
    //   50: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aload_3
    //   54: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   57: ldc 186
    //   59: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   71: ldc 186
    //   73: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: athrow
    //   78: astore_2
    //   79: goto -12 -> 67
    //   82: astore_2
    //   83: goto -50 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	m
    //   0	86	1	paramString	java.lang.String
    //   0	86	2	paramOptions	android.graphics.BitmapFactory.Options
    //   9	45	3	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   5	10	30	java/lang/Exception
    //   5	10	64	finally
    //   12	19	78	finally
    //   35	53	78	finally
    //   12	19	82	java/lang/Exception
  }
  
  /* Error */
  public final Bitmap a(java.lang.String paramString, android.graphics.Rect paramRect, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 192	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore 4
    //   11: aload 4
    //   13: astore_1
    //   14: aload 4
    //   16: aload_2
    //   17: aload_3
    //   18: invokestatic 194	com/tencent/mm/memory/m:b	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   21: astore_2
    //   22: aload 4
    //   24: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   27: ldc 198
    //   29: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_2
    //   33: areturn
    //   34: astore_2
    //   35: aconst_null
    //   36: astore 4
    //   38: aload 4
    //   40: astore_1
    //   41: ldc 75
    //   43: ldc 196
    //   45: iconst_1
    //   46: anewarray 79	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_2
    //   52: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   55: aastore
    //   56: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 4
    //   61: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   64: ldc 198
    //   66: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   78: ldc 198
    //   80: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_2
    //   84: athrow
    //   85: astore_2
    //   86: goto -12 -> 74
    //   89: astore_2
    //   90: goto -52 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	m
    //   0	93	1	paramString	java.lang.String
    //   0	93	2	paramRect	android.graphics.Rect
    //   0	93	3	paramOptions	android.graphics.BitmapFactory.Options
    //   9	51	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   5	11	34	java/lang/Exception
    //   5	11	71	finally
    //   14	22	85	finally
    //   41	59	85	finally
    //   14	22	89	java/lang/Exception
  }
  
  public final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156436);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        Log.i("MicroMsg.PurgeableBitmapFactory", "bitmap recycle %s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      AppMethodBeat.o(156436);
      return;
    }
    catch (Exception paramBitmap)
    {
      Log.e("MicroMsg.PurgeableBitmapFactory", "recycle error: %s", new Object[] { paramBitmap.getMessage() });
      AppMethodBeat.o(156436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.m
 * JD-Core Version:    0.7.0.1
 */