package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public final class b
{
  /* Error */
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, x.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload 5
    //   2: i2f
    //   3: ldc 9
    //   5: fmul
    //   6: f2i
    //   7: istore 8
    //   9: iload 5
    //   11: i2f
    //   12: ldc 10
    //   14: fmul
    //   15: f2i
    //   16: istore 9
    //   18: iload 5
    //   20: i2f
    //   21: ldc 11
    //   23: fmul
    //   24: f2i
    //   25: istore 5
    //   27: new 13	android/graphics/Paint
    //   30: dup
    //   31: invokespecial 17	android/graphics/Paint:<init>	()V
    //   34: astore 13
    //   36: aload 13
    //   38: iconst_1
    //   39: invokevirtual 21	android/graphics/Paint:setAntiAlias	(Z)V
    //   42: ldc 23
    //   44: ldc 25
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: iload 9
    //   54: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: iload 8
    //   62: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: invokestatic 37	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: iload 8
    //   71: iload 8
    //   73: getstatic 43	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   76: invokestatic 49	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   79: astore 12
    //   81: aconst_null
    //   82: astore 11
    //   84: aload 11
    //   86: astore 10
    //   88: iload_3
    //   89: iconst_1
    //   90: if_icmpne +35 -> 125
    //   93: aload 11
    //   95: astore 10
    //   97: aload 4
    //   99: invokestatic 55	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   102: ifne +23 -> 125
    //   105: new 57	com/tencent/mm/plugin/collect/b/c
    //   108: dup
    //   109: aload 4
    //   111: invokespecial 60	com/tencent/mm/plugin/collect/b/c:<init>	(Ljava/lang/String;)V
    //   114: invokestatic 65	com/tencent/mm/platformtools/x:a	(Lcom/tencent/mm/platformtools/v;)Landroid/graphics/Bitmap;
    //   117: astore 10
    //   119: aload 6
    //   121: invokestatic 69	com/tencent/mm/platformtools/x:b	(Lcom/tencent/mm/platformtools/x$a;)Z
    //   124: pop
    //   125: aload 10
    //   127: astore 4
    //   129: aload 10
    //   131: ifnonnull +20 -> 151
    //   134: aload_2
    //   135: iload 9
    //   137: iload 9
    //   139: iload 9
    //   141: i2f
    //   142: ldc 70
    //   144: fmul
    //   145: f2i
    //   146: invokestatic 76	com/tencent/mm/ag/b:c	(Ljava/lang/String;III)Landroid/graphics/Bitmap;
    //   149: astore 4
    //   151: aload 4
    //   153: astore_2
    //   154: aload 4
    //   156: ifnonnull +36 -> 192
    //   159: invokestatic 82	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   162: invokevirtual 88	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   165: ldc 90
    //   167: invokevirtual 96	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   170: aconst_null
    //   171: invokestatic 102	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   174: invokestatic 107	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$b:a	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   177: astore_2
    //   178: aload_2
    //   179: iconst_0
    //   180: ldc 70
    //   182: aload_2
    //   183: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   186: i2f
    //   187: fmul
    //   188: invokestatic 116	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   191: astore_2
    //   192: aload_2
    //   193: astore 4
    //   195: aload_2
    //   196: ifnull +26 -> 222
    //   199: aload_2
    //   200: astore 4
    //   202: iload 7
    //   204: ifeq +18 -> 222
    //   207: aload_2
    //   208: iconst_0
    //   209: aload_2
    //   210: invokevirtual 111	android/graphics/Bitmap:getWidth	()I
    //   213: i2f
    //   214: ldc 117
    //   216: fmul
    //   217: invokestatic 116	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   220: astore 4
    //   222: new 119	android/graphics/Canvas
    //   225: dup
    //   226: aload 12
    //   228: invokespecial 122	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   231: astore_2
    //   232: iload 8
    //   234: iload 9
    //   236: isub
    //   237: iconst_2
    //   238: idiv
    //   239: istore_3
    //   240: aload_2
    //   241: aload 4
    //   243: aconst_null
    //   244: new 124	android/graphics/Rect
    //   247: dup
    //   248: iload_3
    //   249: iload_3
    //   250: iload 8
    //   252: iload_3
    //   253: isub
    //   254: iload 8
    //   256: iload_3
    //   257: isub
    //   258: invokespecial 127	android/graphics/Rect:<init>	(IIII)V
    //   261: aload 13
    //   263: invokevirtual 131	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   266: aload_2
    //   267: aload_0
    //   268: invokevirtual 135	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   271: getstatic 141	com/tencent/mm/plugin/wxpay/a$e:collect_ftf_avatar_icon	I
    //   274: invokevirtual 147	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   277: invokestatic 153	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   280: aconst_null
    //   281: new 124	android/graphics/Rect
    //   284: dup
    //   285: iload 8
    //   287: iload 5
    //   289: isub
    //   290: iload 8
    //   292: iload 5
    //   294: isub
    //   295: iload 8
    //   297: iload 8
    //   299: invokespecial 127	android/graphics/Rect:<init>	(IIII)V
    //   302: aload 13
    //   304: invokevirtual 131	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   307: ldc 154
    //   309: newarray byte
    //   311: astore_2
    //   312: iconst_2
    //   313: newarray int
    //   315: astore 4
    //   317: aload_2
    //   318: aload 4
    //   320: aload_1
    //   321: bipush 12
    //   323: iconst_3
    //   324: ldc 156
    //   326: invokestatic 161	com/tencent/qbar/QbarNative:a	([B[ILjava/lang/String;IILjava/lang/String;)I
    //   329: istore_3
    //   330: invokestatic 164	com/tencent/qbar/QbarNative:nativeRelease	()I
    //   333: pop
    //   334: iload_3
    //   335: ifne +84 -> 419
    //   338: aload_0
    //   339: aload 12
    //   341: aload_2
    //   342: aload 4
    //   344: invokestatic 169	com/tencent/mm/by/a/a:a	(Landroid/content/Context;Landroid/graphics/Bitmap;[B[I)Landroid/graphics/Bitmap;
    //   347: astore_0
    //   348: aload_0
    //   349: ifnonnull +37 -> 386
    //   352: ldc 171
    //   354: ldc 173
    //   356: iconst_2
    //   357: anewarray 4	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: iload_3
    //   363: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: dup
    //   368: iconst_1
    //   369: invokestatic 177	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   372: invokevirtual 183	com/tencent/mm/sdk/platformtools/ak:toString	()Ljava/lang/String;
    //   375: aastore
    //   376: invokestatic 37	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: aload 12
    //   381: invokevirtual 186	android/graphics/Bitmap:recycle	()V
    //   384: aload_0
    //   385: areturn
    //   386: ldc 171
    //   388: ldc 188
    //   390: iconst_1
    //   391: anewarray 4	java/lang/Object
    //   394: dup
    //   395: iconst_0
    //   396: aload_0
    //   397: aastore
    //   398: invokestatic 37	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: goto -22 -> 379
    //   404: astore_0
    //   405: ldc 23
    //   407: aload_0
    //   408: ldc 190
    //   410: iconst_0
    //   411: anewarray 4	java/lang/Object
    //   414: invokestatic 194	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   417: aconst_null
    //   418: areturn
    //   419: ldc 171
    //   421: ldc 196
    //   423: iconst_2
    //   424: anewarray 4	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: iload_3
    //   430: invokestatic 31	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: aastore
    //   434: dup
    //   435: iconst_1
    //   436: invokestatic 177	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   439: invokevirtual 183	com/tencent/mm/sdk/platformtools/ak:toString	()Ljava/lang/String;
    //   442: aastore
    //   443: invokestatic 37	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   446: aconst_null
    //   447: astore_0
    //   448: goto -69 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	paramContext	Context
    //   0	451	1	paramString1	String
    //   0	451	2	paramString2	String
    //   0	451	3	paramInt1	int
    //   0	451	4	paramString3	String
    //   0	451	5	paramInt2	int
    //   0	451	6	parama	x.a
    //   0	451	7	paramBoolean	boolean
    //   7	291	8	i	int
    //   16	221	9	j	int
    //   86	44	10	localObject1	Object
    //   82	12	11	localObject2	Object
    //   79	301	12	localBitmap	Bitmap
    //   34	269	13	localPaint	android.graphics.Paint
    // Exception table:
    //   from	to	target	type
    //   27	81	404	java/lang/Exception
    //   97	125	404	java/lang/Exception
    //   134	151	404	java/lang/Exception
    //   159	192	404	java/lang/Exception
    //   207	222	404	java/lang/Exception
    //   222	334	404	java/lang/Exception
    //   338	348	404	java/lang/Exception
    //   352	379	404	java/lang/Exception
    //   379	384	404	java/lang/Exception
    //   386	401	404	java/lang/Exception
    //   419	446	404	java/lang/Exception
  }
  
  public static Bitmap a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, x.a parama, boolean paramBoolean)
  {
    return a(paramContext, paramString1, paramString2, paramInt, paramString3, BackwardSupportUtil.b.b(paramContext, 197.0F), parama, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.b
 * JD-Core Version:    0.7.0.1
 */