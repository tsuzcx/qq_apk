package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements k<Bitmap>
{
  public static final h<Integer> aKK;
  public static final h<Bitmap.CompressFormat> aKL;
  private final b aCo;
  
  static
  {
    AppMethodBeat.i(77355);
    aKK = h.c("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));
    aKL = h.Q("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    AppMethodBeat.o(77355);
  }
  
  @Deprecated
  public c()
  {
    this.aCo = null;
  }
  
  public c(b paramb)
  {
    this.aCo = paramb;
  }
  
  /* Error */
  private boolean a(com.bumptech.glide.load.b.v<Bitmap> paramv, java.io.File paramFile, i parami)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokeinterface 70 1 0
    //   11: checkcast 72	android/graphics/Bitmap
    //   14: astore 11
    //   16: aload_3
    //   17: getstatic 47	com/bumptech/glide/load/d/a/c:aKL	Lcom/bumptech/glide/load/h;
    //   20: invokevirtual 77	com/bumptech/glide/load/i:a	(Lcom/bumptech/glide/load/h;)Ljava/lang/Object;
    //   23: checkcast 79	android/graphics/Bitmap$CompressFormat
    //   26: astore 8
    //   28: aload 8
    //   30: ifnull +201 -> 231
    //   33: aload 11
    //   35: invokevirtual 83	android/graphics/Bitmap:getWidth	()I
    //   38: pop
    //   39: aload 11
    //   41: invokevirtual 86	android/graphics/Bitmap:getHeight	()I
    //   44: pop
    //   45: invokestatic 92	com/bumptech/glide/g/f:qt	()J
    //   48: lstore 5
    //   50: aload_3
    //   51: getstatic 39	com/bumptech/glide/load/d/a/c:aKK	Lcom/bumptech/glide/load/h;
    //   54: invokevirtual 77	com/bumptech/glide/load/i:a	(Lcom/bumptech/glide/load/h;)Ljava/lang/Object;
    //   57: checkcast 27	java/lang/Integer
    //   60: invokevirtual 95	java/lang/Integer:intValue	()I
    //   63: istore 4
    //   65: new 97	java/io/FileOutputStream
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore 10
    //   75: aload 10
    //   77: astore_2
    //   78: aload 10
    //   80: astore_1
    //   81: aload 10
    //   83: astore 9
    //   85: aload_0
    //   86: getfield 57	com/bumptech/glide/load/d/a/c:aCo	Lcom/bumptech/glide/load/b/a/b;
    //   89: ifnull +24 -> 113
    //   92: aload 10
    //   94: astore_1
    //   95: aload 10
    //   97: astore 9
    //   99: new 102	com/bumptech/glide/load/a/c
    //   102: dup
    //   103: aload 10
    //   105: aload_0
    //   106: getfield 57	com/bumptech/glide/load/d/a/c:aCo	Lcom/bumptech/glide/load/b/a/b;
    //   109: invokespecial 105	com/bumptech/glide/load/a/c:<init>	(Ljava/io/OutputStream;Lcom/bumptech/glide/load/b/a/b;)V
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: aload_2
    //   116: astore 9
    //   118: aload 11
    //   120: aload 8
    //   122: iload 4
    //   124: aload_2
    //   125: invokevirtual 109	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   128: pop
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: astore 9
    //   134: aload_2
    //   135: invokevirtual 114	java/io/OutputStream:close	()V
    //   138: aload_2
    //   139: invokevirtual 114	java/io/OutputStream:close	()V
    //   142: iconst_1
    //   143: istore 7
    //   145: ldc 116
    //   147: iconst_2
    //   148: invokestatic 122	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   151: ifeq +72 -> 223
    //   154: new 124	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 126
    //   160: invokespecial 129	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload 8
    //   165: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: ldc 135
    //   170: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 11
    //   175: invokestatic 144	com/bumptech/glide/g/k:k	(Landroid/graphics/Bitmap;)I
    //   178: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: ldc 149
    //   183: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: lload 5
    //   188: invokestatic 153	com/bumptech/glide/g/f:p	(J)D
    //   191: invokevirtual 156	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   194: ldc 158
    //   196: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_3
    //   200: getstatic 47	com/bumptech/glide/load/d/a/c:aKL	Lcom/bumptech/glide/load/h;
    //   203: invokevirtual 77	com/bumptech/glide/load/i:a	(Lcom/bumptech/glide/load/h;)Ljava/lang/Object;
    //   206: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: ldc 160
    //   211: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 11
    //   216: invokevirtual 164	android/graphics/Bitmap:hasAlpha	()Z
    //   219: invokevirtual 167	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 64
    //   225: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: iload 7
    //   230: ireturn
    //   231: aload 11
    //   233: invokevirtual 164	android/graphics/Bitmap:hasAlpha	()Z
    //   236: ifeq +11 -> 247
    //   239: getstatic 171	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   242: astore 8
    //   244: goto -211 -> 33
    //   247: getstatic 174	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   250: astore 8
    //   252: goto -219 -> 33
    //   255: astore_1
    //   256: iconst_1
    //   257: istore 7
    //   259: goto -114 -> 145
    //   262: astore_1
    //   263: aconst_null
    //   264: astore 9
    //   266: aload 9
    //   268: astore_1
    //   269: ldc 116
    //   271: iconst_3
    //   272: invokestatic 122	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   275: pop
    //   276: aload 9
    //   278: ifnull +59 -> 337
    //   281: aload 9
    //   283: invokevirtual 114	java/io/OutputStream:close	()V
    //   286: iconst_0
    //   287: istore 7
    //   289: goto -144 -> 145
    //   292: astore_1
    //   293: iconst_0
    //   294: istore 7
    //   296: goto -151 -> 145
    //   299: astore_2
    //   300: aconst_null
    //   301: astore_1
    //   302: aload_1
    //   303: ifnull +7 -> 310
    //   306: aload_1
    //   307: invokevirtual 114	java/io/OutputStream:close	()V
    //   310: ldc 64
    //   312: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload_2
    //   316: athrow
    //   317: astore_1
    //   318: ldc 64
    //   320: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: aload_1
    //   324: athrow
    //   325: astore_1
    //   326: goto -16 -> 310
    //   329: astore_2
    //   330: goto -28 -> 302
    //   333: astore_1
    //   334: goto -68 -> 266
    //   337: iconst_0
    //   338: istore 7
    //   340: goto -195 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	c
    //   0	343	1	paramv	com.bumptech.glide.load.b.v<Bitmap>
    //   0	343	2	paramFile	java.io.File
    //   0	343	3	parami	i
    //   63	60	4	i	int
    //   48	139	5	l	long
    //   143	196	7	bool	boolean
    //   26	225	8	localCompressFormat	Bitmap.CompressFormat
    //   83	199	9	localObject	Object
    //   73	31	10	localFileOutputStream	java.io.FileOutputStream
    //   14	218	11	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   138	142	255	java/io/IOException
    //   65	75	262	java/io/IOException
    //   281	286	292	java/io/IOException
    //   65	75	299	finally
    //   45	65	317	finally
    //   138	142	317	finally
    //   145	223	317	finally
    //   281	286	317	finally
    //   306	310	317	finally
    //   310	317	317	finally
    //   306	310	325	java/io/IOException
    //   85	92	329	finally
    //   99	113	329	finally
    //   118	129	329	finally
    //   134	138	329	finally
    //   269	276	329	finally
    //   85	92	333	java/io/IOException
    //   99	113	333	java/io/IOException
    //   118	129	333	java/io/IOException
    //   134	138	333	java/io/IOException
  }
  
  public final com.bumptech.glide.load.c b(i parami)
  {
    return com.bumptech.glide.load.c.aER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.c
 * JD-Core Version:    0.7.0.1
 */