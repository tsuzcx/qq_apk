package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.plugin.appbrand.v.m;
import com.tencent.mm.sdk.platformtools.bk;
import java.nio.ByteBuffer;

abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<p>
{
  /* Error */
  static boolean d(String paramString, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 18	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 21	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 25	java/io/File:getParentFile	()Ljava/io/File;
    //   13: invokevirtual 29	java/io/File:mkdirs	()Z
    //   16: pop
    //   17: new 31	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 34	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_0
    //   28: sipush 4096
    //   31: newarray byte
    //   33: astore 4
    //   35: aload_3
    //   36: astore_0
    //   37: aload_1
    //   38: aload 4
    //   40: iconst_0
    //   41: sipush 4096
    //   44: invokevirtual 40	java/io/InputStream:read	([BII)I
    //   47: istore_2
    //   48: iload_2
    //   49: iconst_m1
    //   50: if_icmpeq +46 -> 96
    //   53: aload_3
    //   54: astore_0
    //   55: aload_3
    //   56: aload 4
    //   58: iconst_0
    //   59: iload_2
    //   60: invokevirtual 44	java/io/FileOutputStream:write	([BII)V
    //   63: goto -28 -> 35
    //   66: astore 4
    //   68: aload_3
    //   69: astore_0
    //   70: ldc 46
    //   72: ldc 48
    //   74: iconst_1
    //   75: anewarray 50	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload 4
    //   82: aastore
    //   83: invokestatic 56	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: aload_3
    //   87: invokestatic 62	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   90: aload_1
    //   91: invokestatic 62	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_3
    //   97: astore_0
    //   98: aload_3
    //   99: invokevirtual 65	java/io/FileOutputStream:flush	()V
    //   102: aload_3
    //   103: invokestatic 62	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   106: aload_1
    //   107: invokestatic 62	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 62	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   119: aload_1
    //   120: invokestatic 62	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   123: aload_3
    //   124: athrow
    //   125: astore_3
    //   126: goto -11 -> 115
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: goto -65 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   0	136	1	paramInputStream	java.io.InputStream
    //   47	13	2	i	int
    //   25	78	3	localFileOutputStream	java.io.FileOutputStream
    //   112	12	3	localObject1	Object
    //   125	1	3	localObject2	Object
    //   132	1	3	localObject3	Object
    //   33	24	4	arrayOfByte	byte[]
    //   66	15	4	localException1	java.lang.Exception
    //   129	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	35	66	java/lang/Exception
    //   37	48	66	java/lang/Exception
    //   55	63	66	java/lang/Exception
    //   98	102	66	java/lang/Exception
    //   0	26	112	finally
    //   28	35	125	finally
    //   37	48	125	finally
    //   55	63	125	finally
    //   70	86	125	finally
    //   98	102	125	finally
    //   0	26	129	java/lang/Exception
  }
  
  abstract boolean ui(String paramString);
  
  abstract String uj(String paramString);
  
  abstract void uk(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.a
 * JD-Core Version:    0.7.0.1
 */