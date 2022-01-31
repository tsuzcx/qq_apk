package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;

public final class q
{
  public static String UL()
  {
    String str = com.tencent.mm.compatible.util.e.dzD;
    return str.substring(str.indexOf("tencent/MicroMsg"));
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (bk.bl(paramString)) {
      return;
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.vfs.e.aeP(paramString)));
    y.i("MicroMsg.ExportImgUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
  }
  
  public static boolean a(String paramString, Context paramContext, int paramInt)
  {
    if (o.Za(paramString))
    {
      if (!bk.bl(paramString))
      {
        String str = pd("gif");
        com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(str));
        if (com.tencent.mm.vfs.e.r(paramString, str) >= 0L)
        {
          a(str, paramContext);
          Toast.makeText(paramContext, paramContext.getString(paramInt, new Object[] { UL() }), 1).show();
          return true;
        }
      }
      return false;
    }
    return a(paramString, paramContext, true, paramInt);
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +39 -> 40
    //   4: aload_0
    //   5: ldc 110
    //   7: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifne +30 -> 40
    //   13: ldc 116
    //   15: invokestatic 75	com/tencent/mm/platformtools/q:pd	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 9
    //   20: aload 9
    //   22: invokestatic 78	com/tencent/mm/vfs/e:aeS	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 81	com/tencent/mm/vfs/e:nb	(Ljava/lang/String;)Z
    //   28: pop
    //   29: aload_0
    //   30: aload 9
    //   32: invokestatic 85	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   35: lconst_0
    //   36: lcmp
    //   37: ifge +5 -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: aload 9
    //   44: invokestatic 121	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   47: ifeq +102 -> 149
    //   50: aconst_null
    //   51: astore 8
    //   53: aconst_null
    //   54: astore 7
    //   56: aload 8
    //   58: astore 6
    //   60: aload 9
    //   62: invokestatic 126	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:YS	(Ljava/lang/String;)I
    //   65: istore 5
    //   67: aload 8
    //   69: astore 6
    //   71: aload 9
    //   73: invokestatic 130	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   76: astore_0
    //   77: aload 7
    //   79: astore 6
    //   81: aload_0
    //   82: ifnull +57 -> 139
    //   85: iload 5
    //   87: i2f
    //   88: fstore 4
    //   90: aload 8
    //   92: astore 6
    //   94: aload_0
    //   95: fload 4
    //   97: invokestatic 136	com/tencent/mm/sdk/platformtools/c:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   100: astore 7
    //   102: aload 8
    //   104: astore 6
    //   106: getstatic 142	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   109: astore 10
    //   111: aload 8
    //   113: astore 6
    //   115: aload 9
    //   117: iconst_0
    //   118: invokestatic 146	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   121: astore_0
    //   122: aload_0
    //   123: astore 6
    //   125: aload 7
    //   127: aload 10
    //   129: bipush 80
    //   131: aload_0
    //   132: invokevirtual 152	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   135: pop
    //   136: aload_0
    //   137: astore 6
    //   139: aload 6
    //   141: ifnull +8 -> 149
    //   144: aload 6
    //   146: invokevirtual 157	java/io/OutputStream:close	()V
    //   149: aload 9
    //   151: aload_1
    //   152: invokestatic 87	com/tencent/mm/platformtools/q:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   155: iload_2
    //   156: ifeq +26 -> 182
    //   159: aload_1
    //   160: aload_1
    //   161: iload_3
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: invokestatic 89	com/tencent/mm/platformtools/q:UL	()Ljava/lang/String;
    //   171: aastore
    //   172: invokevirtual 93	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   175: iconst_1
    //   176: invokestatic 99	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   179: invokevirtual 103	android/widget/Toast:show	()V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore 7
    //   186: aload 8
    //   188: astore 6
    //   190: ldc 55
    //   192: aload 7
    //   194: ldc 159
    //   196: iconst_0
    //   197: anewarray 4	java/lang/Object
    //   200: invokestatic 163	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload_0
    //   204: astore 7
    //   206: goto -104 -> 102
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 9
    //   214: invokestatic 166	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   217: pop
    //   218: aload_0
    //   219: ifnull -179 -> 40
    //   222: aload_0
    //   223: invokevirtual 157	java/io/OutputStream:close	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_0
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_0
    //   232: aload 6
    //   234: ifnull +8 -> 242
    //   237: aload 6
    //   239: invokevirtual 157	java/io/OutputStream:close	()V
    //   242: aload_0
    //   243: athrow
    //   244: astore_0
    //   245: goto -96 -> 149
    //   248: astore_1
    //   249: goto -7 -> 242
    //   252: astore_1
    //   253: aload_0
    //   254: astore 6
    //   256: aload_1
    //   257: astore_0
    //   258: goto -26 -> 232
    //   261: astore_1
    //   262: goto -50 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramString	String
    //   0	265	1	paramContext	Context
    //   0	265	2	paramBoolean	boolean
    //   0	265	3	paramInt	int
    //   88	8	4	f	float
    //   65	21	5	i	int
    //   58	197	6	localObject1	Object
    //   54	72	7	localBitmap	android.graphics.Bitmap
    //   184	9	7	localException	java.lang.Exception
    //   204	1	7	str1	String
    //   51	136	8	localObject2	Object
    //   18	195	9	str2	String
    //   109	19	10	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   94	102	184	java/lang/Exception
    //   60	67	209	java/lang/Exception
    //   71	77	209	java/lang/Exception
    //   106	111	209	java/lang/Exception
    //   115	122	209	java/lang/Exception
    //   190	203	209	java/lang/Exception
    //   222	226	228	java/lang/Exception
    //   60	67	231	finally
    //   71	77	231	finally
    //   94	102	231	finally
    //   106	111	231	finally
    //   115	122	231	finally
    //   125	136	231	finally
    //   190	203	231	finally
    //   144	149	244	java/lang/Exception
    //   237	242	248	java/lang/Exception
    //   212	218	252	finally
    //   125	136	261	java/lang/Exception
  }
  
  public static String pd(String paramString)
  {
    return com.tencent.mm.compatible.util.e.dzD + String.format("%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.platformtools.q
 * JD-Core Version:    0.7.0.1
 */