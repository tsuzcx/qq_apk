package com.tencent.mm.loader.b.a;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.io.OutputStream;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "save", "data", "", "libimageloader_release"})
public final class c
{
  private static final String TAG = "MicroMsg.Loader.DiskFunction";
  public static final c hfO = new c();
  
  /* Error */
  public static boolean a(String paramString, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 97
    //   5: invokestatic 57	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 59
    //   11: invokestatic 57	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 103	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   18: ifeq +106 -> 124
    //   21: aload_0
    //   22: invokestatic 107	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnull +95 -> 124
    //   32: aload 4
    //   34: checkcast 109	java/io/Closeable
    //   37: astore 4
    //   39: aload 4
    //   41: checkcast 111	java/io/InputStream
    //   44: astore 5
    //   46: sipush 4096
    //   49: newarray byte
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 115	java/io/InputStream:read	([B)I
    //   60: istore_2
    //   61: iload_2
    //   62: iconst_m1
    //   63: if_icmpeq +63 -> 126
    //   66: aload_1
    //   67: aload 6
    //   69: iconst_0
    //   70: iload_2
    //   71: invokevirtual 121	java/io/OutputStream:write	([BII)V
    //   74: goto -21 -> 53
    //   77: astore_3
    //   78: aload_3
    //   79: athrow
    //   80: astore_1
    //   81: aload 4
    //   83: aload_3
    //   84: invokestatic 126	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: getstatic 132	com/tencent/mm/plugin/report/e:ywz	Lcom/tencent/mm/plugin/report/e;
    //   93: ldc2_w 133
    //   96: ldc2_w 135
    //   99: lconst_1
    //   100: iconst_0
    //   101: invokevirtual 140	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
    //   104: getstatic 41	com/tencent/mm/loader/b/a/c:TAG	Ljava/lang/String;
    //   107: aload_1
    //   108: ldc 142
    //   110: aload_0
    //   111: invokestatic 148	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokevirtual 152	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 156	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: iconst_0
    //   125: ireturn
    //   126: aload 4
    //   128: aconst_null
    //   129: invokestatic 126	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_1
    //   135: goto -54 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   0	138	1	paramOutputStream	OutputStream
    //   60	11	2	i	int
    //   1	1	3	localObject1	Object
    //   77	7	3	localThrowable	java.lang.Throwable
    //   25	102	4	localObject2	Object
    //   44	10	5	localInputStream	java.io.InputStream
    //   51	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   39	53	77	java/lang/Throwable
    //   53	61	77	java/lang/Throwable
    //   66	74	77	java/lang/Throwable
    //   78	80	80	finally
    //   21	27	89	java/lang/Throwable
    //   32	39	89	java/lang/Throwable
    //   81	89	89	java/lang/Throwable
    //   126	132	89	java/lang/Throwable
    //   39	53	134	finally
    //   53	61	134	finally
    //   66	74	134	finally
  }
  
  public static boolean a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    p.h(paramArrayOfByte, "data");
    p.h(paramOutputStream, "stream");
    paramOutputStream.write(paramArrayOfByte);
    return true;
  }
  
  public static OutputStream yH(String paramString)
  {
    p.h(paramString, "filePath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    try
    {
      k localk = new k(paramString).fTg();
      if (localk != null) {
        localk.mkdirs();
      }
      paramString = o.Db(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e(TAG, "obtainOutputStream:%s", new Object[] { paramString });
        paramString = null;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.c
 * JD-Core Version:    0.7.0.1
 */