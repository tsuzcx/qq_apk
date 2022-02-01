package com.tencent.mm.loader.b.a;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.io.OutputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "save", "data", "", "libimageloader_release"})
public final class c
{
  private static final String TAG = "MicroMsg.Loader.DiskFunction";
  public static final c giE = new c();
  
  /* Error */
  public static boolean a(String paramString, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 97
    //   5: invokestatic 57	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 59
    //   11: invokestatic 57	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 103	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   18: ifeq +74 -> 92
    //   21: aload_0
    //   22: invokestatic 107	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +65 -> 92
    //   30: aload_0
    //   31: checkcast 109	java/io/Closeable
    //   34: astore 4
    //   36: aload 4
    //   38: checkcast 111	java/io/InputStream
    //   41: astore_0
    //   42: sipush 4096
    //   45: newarray byte
    //   47: astore 5
    //   49: aload_0
    //   50: aload 5
    //   52: invokevirtual 115	java/io/InputStream:read	([B)I
    //   55: istore_2
    //   56: iload_2
    //   57: iconst_m1
    //   58: if_icmpeq +26 -> 84
    //   61: aload_1
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_2
    //   66: invokevirtual 121	java/io/OutputStream:write	([BII)V
    //   69: goto -20 -> 49
    //   72: astore_1
    //   73: aload_1
    //   74: athrow
    //   75: astore_0
    //   76: aload 4
    //   78: aload_1
    //   79: invokestatic 126	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: athrow
    //   84: aload 4
    //   86: aconst_null
    //   87: invokestatic 126	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   90: iconst_1
    //   91: ireturn
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: aload_3
    //   96: astore_1
    //   97: goto -21 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramString	String
    //   0	100	1	paramOutputStream	OutputStream
    //   55	11	2	i	int
    //   1	95	3	localObject	Object
    //   34	51	4	localCloseable	java.io.Closeable
    //   47	16	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   36	49	72	java/lang/Throwable
    //   49	56	72	java/lang/Throwable
    //   61	69	72	java/lang/Throwable
    //   73	75	75	finally
    //   36	49	94	finally
    //   49	56	94	finally
    //   61	69	94	finally
  }
  
  public static boolean a(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    k.h(paramArrayOfByte, "data");
    k.h(paramOutputStream, "stream");
    paramOutputStream.write(paramArrayOfByte);
    return true;
  }
  
  public static OutputStream re(String paramString)
  {
    k.h(paramString, "filePath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    try
    {
      e locale = new e(paramString).fhT();
      if (locale != null) {
        locale.mkdirs();
      }
      paramString = i.vu(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e(TAG, "obtainOutputStream:%s", new Object[] { paramString });
        paramString = null;
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.c
 * JD-Core Version:    0.7.0.1
 */