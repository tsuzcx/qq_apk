package com.tencent.mm.platformtools;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;

public final class q
{
  @Deprecated
  public static void a(String paramString, Context paramContext)
  {
    AppMethodBeat.i(79005);
    b.a(paramString, paramContext);
    AppMethodBeat.o(79005);
  }
  
  public static boolean a(String paramString, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(79003);
    if (r.aoY(paramString))
    {
      if (!bo.isNullOrNil(paramString))
      {
        String str = b.TY("gif");
        com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(str));
        if (com.tencent.mm.vfs.e.C(paramString, str) >= 0L)
        {
          b.a(str, paramContext);
          Toast.makeText(paramContext, paramContext.getString(paramInt, new Object[] { b.dpF() }), 1).show();
          AppMethodBeat.o(79003);
          return true;
        }
      }
      AppMethodBeat.o(79003);
      return false;
    }
    boolean bool = a(paramString, paramContext, true, paramInt);
    AppMethodBeat.o(79003);
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +260 -> 266
    //   9: aload_0
    //   10: ldc 82
    //   12: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifne +251 -> 266
    //   18: ldc 90
    //   20: invokestatic 42	com/tencent/mm/sdk/f/b:TY	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 9
    //   25: aload 9
    //   27: invokestatic 47	com/tencent/mm/vfs/e:avK	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokestatic 50	com/tencent/mm/vfs/e:um	(Ljava/lang/String;)Z
    //   33: pop
    //   34: aload_0
    //   35: aload 9
    //   37: invokestatic 54	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifge +10 -> 52
    //   45: ldc 80
    //   47: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_0
    //   51: ireturn
    //   52: aload 9
    //   54: invokestatic 95	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   57: ifeq +102 -> 159
    //   60: aconst_null
    //   61: astore 8
    //   63: aconst_null
    //   64: astore 7
    //   66: aload 8
    //   68: astore 6
    //   70: aload 9
    //   72: invokestatic 101	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:bY	(Ljava/lang/String;)I
    //   75: istore 5
    //   77: aload 8
    //   79: astore 6
    //   81: aload 9
    //   83: invokestatic 105	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   86: astore_0
    //   87: aload 7
    //   89: astore 6
    //   91: aload_0
    //   92: ifnull +57 -> 149
    //   95: iload 5
    //   97: i2f
    //   98: fstore 4
    //   100: aload 8
    //   102: astore 6
    //   104: aload_0
    //   105: fload 4
    //   107: invokestatic 111	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   110: astore 7
    //   112: aload 8
    //   114: astore 6
    //   116: getstatic 117	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   119: astore 10
    //   121: aload 8
    //   123: astore 6
    //   125: aload 9
    //   127: iconst_0
    //   128: invokestatic 121	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   131: astore_0
    //   132: aload_0
    //   133: astore 6
    //   135: aload 7
    //   137: aload 10
    //   139: bipush 80
    //   141: aload_0
    //   142: invokevirtual 127	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   145: pop
    //   146: aload_0
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull +8 -> 159
    //   154: aload 6
    //   156: invokevirtual 132	java/io/OutputStream:close	()V
    //   159: aload 9
    //   161: aload_1
    //   162: invokestatic 18	com/tencent/mm/sdk/f/b:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   165: iload_2
    //   166: ifeq +26 -> 192
    //   169: aload_1
    //   170: aload_1
    //   171: iload_3
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: invokestatic 58	com/tencent/mm/sdk/f/b:dpF	()Ljava/lang/String;
    //   181: aastore
    //   182: invokevirtual 64	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   185: iconst_1
    //   186: invokestatic 70	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   189: invokevirtual 74	android/widget/Toast:show	()V
    //   192: ldc 80
    //   194: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore 7
    //   201: aload 8
    //   203: astore 6
    //   205: ldc 134
    //   207: aload 7
    //   209: ldc 136
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 142	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_0
    //   219: astore 7
    //   221: goto -109 -> 112
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_0
    //   227: aload 9
    //   229: invokestatic 145	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   232: pop
    //   233: aload_0
    //   234: ifnull +7 -> 241
    //   237: aload_0
    //   238: invokevirtual 132	java/io/OutputStream:close	()V
    //   241: ldc 80
    //   243: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_0
    //   249: aload 6
    //   251: ifnull +8 -> 259
    //   254: aload 6
    //   256: invokevirtual 132	java/io/OutputStream:close	()V
    //   259: ldc 80
    //   261: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   264: aload_0
    //   265: athrow
    //   266: ldc 80
    //   268: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_0
    //   274: goto -115 -> 159
    //   277: astore_0
    //   278: goto -37 -> 241
    //   281: astore_1
    //   282: goto -23 -> 259
    //   285: astore_1
    //   286: aload_0
    //   287: astore 6
    //   289: aload_1
    //   290: astore_0
    //   291: goto -42 -> 249
    //   294: astore_1
    //   295: goto -68 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramString	String
    //   0	298	1	paramContext	Context
    //   0	298	2	paramBoolean	boolean
    //   0	298	3	paramInt	int
    //   98	8	4	f	float
    //   75	21	5	i	int
    //   68	220	6	localObject1	Object
    //   64	72	7	localBitmap	android.graphics.Bitmap
    //   199	9	7	localException	java.lang.Exception
    //   219	1	7	str1	String
    //   61	141	8	localObject2	Object
    //   23	205	9	str2	String
    //   119	19	10	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   104	112	199	java/lang/Exception
    //   70	77	224	java/lang/Exception
    //   81	87	224	java/lang/Exception
    //   116	121	224	java/lang/Exception
    //   125	132	224	java/lang/Exception
    //   205	218	224	java/lang/Exception
    //   70	77	248	finally
    //   81	87	248	finally
    //   104	112	248	finally
    //   116	121	248	finally
    //   125	132	248	finally
    //   135	146	248	finally
    //   205	218	248	finally
    //   154	159	273	java/lang/Exception
    //   237	241	277	java/lang/Exception
    //   254	259	281	java/lang/Exception
    //   227	233	285	finally
    //   135	146	294	java/lang/Exception
  }
  
  @Deprecated
  public static String aok()
  {
    return com.tencent.mm.compatible.util.e.esr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.q
 * JD-Core Version:    0.7.0.1
 */