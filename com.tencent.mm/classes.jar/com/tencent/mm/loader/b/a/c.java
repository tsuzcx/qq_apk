package com.tencent.mm.loader.b.a;

import a.f.b.j;
import a.l;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.OutputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/cache/disk/DiskFunction;", "", "()V", "TAG", "", "compress", "", "bm", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "stream", "Ljava/io/OutputStream;", "obtainOutputStream", "filePath", "ctx", "Lcom/tencent/mm/modelsfs/SFSContext;", "save", "data", "", "libimageloader_release"})
public final class c
{
  private static final String TAG = "MicroMsg.Loader.DiskFunction";
  public static final c eNn = new c();
  
  public static OutputStream a(String paramString, SFSContext paramSFSContext)
  {
    j.q(paramString, "filePath");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    if (paramSFSContext == null)
    {
      paramSFSContext = new b(paramString).dQI();
      if ((paramSFSContext != null) && (!paramSFSContext.exists())) {
        paramSFSContext.mkdirs();
      }
      return e.qC(paramString);
    }
    return paramSFSContext.qC(paramString);
  }
  
  /* Error */
  public static boolean a(String paramString, OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 48
    //   5: invokestatic 54	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   8: aload_1
    //   9: ldc 94
    //   11: invokestatic 54	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_0
    //   15: invokestatic 133	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   18: ifeq +74 -> 92
    //   21: aload_0
    //   22: invokestatic 137	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +65 -> 92
    //   30: aload_0
    //   31: checkcast 139	java/io/Closeable
    //   34: astore 4
    //   36: aload 4
    //   38: checkcast 141	java/io/InputStream
    //   41: astore_0
    //   42: sipush 4096
    //   45: newarray byte
    //   47: astore 5
    //   49: aload_0
    //   50: aload 5
    //   52: invokevirtual 145	java/io/InputStream:read	([B)I
    //   55: istore_2
    //   56: iload_2
    //   57: iconst_m1
    //   58: if_icmpeq +26 -> 84
    //   61: aload_1
    //   62: aload 5
    //   64: iconst_0
    //   65: iload_2
    //   66: invokevirtual 151	java/io/OutputStream:write	([BII)V
    //   69: goto -20 -> 49
    //   72: astore_1
    //   73: aload_1
    //   74: athrow
    //   75: astore_0
    //   76: aload 4
    //   78: aload_1
    //   79: invokestatic 156	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: athrow
    //   84: aload 4
    //   86: aconst_null
    //   87: invokestatic 156	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    j.q(paramArrayOfByte, "data");
    j.q(paramOutputStream, "stream");
    paramOutputStream.write(paramArrayOfByte);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.b.a.c
 * JD-Core Version:    0.7.0.1
 */