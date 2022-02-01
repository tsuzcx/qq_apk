package com.tencent.mm.loader.b.a;

import android.system.ErrnoException;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.OutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "save", "data", "", "libimageloader_release"})
public final class c
{
  private static final String TAG = "MicroMsg.Loader.DiskFunction";
  public static final c kNn = new c();
  
  public static OutputStream Or(String paramString)
  {
    p.k(paramString, "filePath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    try
    {
      q localq = new q(paramString).ifB();
      if (localq != null) {
        localq.ifL();
      }
      paramString = u.Te(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(TAG, "obtainOutputStream:%s", new Object[] { paramString });
        paramString = null;
      }
    }
    return paramString;
  }
  
  /* Error */
  public static boolean a(String paramString, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 48
    //   5: invokestatic 54	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 96
    //   11: invokestatic 54	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 129	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   18: ifeq +106 -> 124
    //   21: aload_0
    //   22: invokestatic 133	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore 4
    //   27: aload 4
    //   29: ifnull +95 -> 124
    //   32: aload 4
    //   34: checkcast 135	java/io/Closeable
    //   37: astore 4
    //   39: aload 4
    //   41: checkcast 137	java/io/InputStream
    //   44: astore 5
    //   46: sipush 4096
    //   49: newarray byte
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 141	java/io/InputStream:read	([B)I
    //   60: istore_2
    //   61: iload_2
    //   62: iconst_m1
    //   63: if_icmpeq +63 -> 126
    //   66: aload_1
    //   67: aload 6
    //   69: iconst_0
    //   70: iload_2
    //   71: invokevirtual 147	java/io/OutputStream:write	([BII)V
    //   74: goto -21 -> 53
    //   77: astore_3
    //   78: aload_3
    //   79: athrow
    //   80: astore_1
    //   81: aload 4
    //   83: aload_3
    //   84: invokestatic 152	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: getstatic 158	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
    //   93: ldc2_w 159
    //   96: ldc2_w 161
    //   99: lconst_1
    //   100: iconst_0
    //   101: invokevirtual 166	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
    //   104: getstatic 41	com/tencent/mm/loader/b/a/c:TAG	Ljava/lang/String;
    //   107: aload_1
    //   108: ldc 168
    //   110: aload_0
    //   111: invokestatic 174	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokevirtual 178	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: iconst_0
    //   125: ireturn
    //   126: aload 4
    //   128: aconst_null
    //   129: invokestatic 152	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    //   77	7	3	localThrowable	Throwable
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
    p.k(paramArrayOfByte, "data");
    p.k(paramOutputStream, "stream");
    try
    {
      paramOutputStream.write(paramArrayOfByte);
      return true;
    }
    catch (ErrnoException paramArrayOfByte)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramArrayOfByte, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.c
 * JD-Core Version:    0.7.0.1
 */