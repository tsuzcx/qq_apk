package com.bumptech.glide.c.c;

import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.d;
import java.io.InputStream;

public final class t
  implements d<InputStream>
{
  private final b aDH;
  
  public t(b paramb)
  {
    this.aDH = paramb;
  }
  
  /* Error */
  private boolean a(InputStream paramInputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 22
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 16	com/bumptech/glide/c/c/t:aDH	Lcom/bumptech/glide/c/b/a/b;
    //   9: ldc 29
    //   11: ldc 31
    //   13: invokeinterface 36 3 0
    //   18: checkcast 31	[B
    //   21: astore 6
    //   23: new 38	java/io/FileOutputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore 5
    //   33: aload 5
    //   35: astore_2
    //   36: aload_1
    //   37: aload 6
    //   39: invokevirtual 47	java/io/InputStream:read	([B)I
    //   42: istore_3
    //   43: iload_3
    //   44: iconst_m1
    //   45: if_icmpeq +61 -> 106
    //   48: aload 5
    //   50: astore_2
    //   51: aload 5
    //   53: aload 6
    //   55: iconst_0
    //   56: iload_3
    //   57: invokevirtual 53	java/io/OutputStream:write	([BII)V
    //   60: goto -27 -> 33
    //   63: astore_1
    //   64: aload 5
    //   66: astore_1
    //   67: aload_1
    //   68: astore_2
    //   69: ldc 55
    //   71: iconst_3
    //   72: invokestatic 61	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   75: pop
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 64	java/io/OutputStream:close	()V
    //   84: aload_0
    //   85: getfield 16	com/bumptech/glide/c/c/t:aDH	Lcom/bumptech/glide/c/b/a/b;
    //   88: aload 6
    //   90: invokeinterface 68 2 0
    //   95: iconst_0
    //   96: istore 4
    //   98: ldc 22
    //   100: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iload 4
    //   105: ireturn
    //   106: aload 5
    //   108: astore_2
    //   109: aload 5
    //   111: invokevirtual 64	java/io/OutputStream:close	()V
    //   114: aload 5
    //   116: invokevirtual 64	java/io/OutputStream:close	()V
    //   119: aload_0
    //   120: getfield 16	com/bumptech/glide/c/c/t:aDH	Lcom/bumptech/glide/c/b/a/b;
    //   123: aload 6
    //   125: invokeinterface 68 2 0
    //   130: iconst_1
    //   131: istore 4
    //   133: goto -35 -> 98
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 64	java/io/OutputStream:close	()V
    //   147: aload_0
    //   148: getfield 16	com/bumptech/glide/c/c/t:aDH	Lcom/bumptech/glide/c/b/a/b;
    //   151: aload 6
    //   153: invokeinterface 68 2 0
    //   158: ldc 22
    //   160: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: goto -47 -> 119
    //   169: astore_1
    //   170: goto -86 -> 84
    //   173: astore_2
    //   174: goto -27 -> 147
    //   177: astore_1
    //   178: goto -39 -> 139
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -117 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	t
    //   0	187	1	paramInputStream	InputStream
    //   0	187	2	paramFile	java.io.File
    //   42	15	3	i	int
    //   96	36	4	bool	boolean
    //   31	84	5	localFileOutputStream	java.io.FileOutputStream
    //   21	131	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   36	43	63	java/io/IOException
    //   51	60	63	java/io/IOException
    //   109	114	63	java/io/IOException
    //   23	33	136	finally
    //   114	119	165	java/io/IOException
    //   80	84	169	java/io/IOException
    //   143	147	173	java/io/IOException
    //   36	43	177	finally
    //   51	60	177	finally
    //   69	76	177	finally
    //   109	114	177	finally
    //   23	33	181	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.t
 * JD-Core Version:    0.7.0.1
 */