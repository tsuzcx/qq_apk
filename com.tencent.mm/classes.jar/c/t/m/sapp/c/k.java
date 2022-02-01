package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class k
{
  public File a;
  public File b;
  public Context c;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(186141);
    if (paramContext == null)
    {
      AppMethodBeat.o(186141);
      return;
    }
    this.c = paramContext.getApplicationContext();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramContext = localStringBuilder.append(paramContext.getExternalFilesDir("data").getAbsolutePath());
      this.a = new File("/d_l");
      AppMethodBeat.o(186141);
      return;
    }
    finally
    {
      this.a = null;
      AppMethodBeat.o(186141);
    }
  }
  
  public final File a()
  {
    AppMethodBeat.i(186144);
    try
    {
      File localFile = this.a;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      long l = System.currentTimeMillis();
      Object localObject2 = new StringBuilder().append(l);
      localObject2 = r.c("");
      StringBuilder localStringBuilder = new StringBuilder();
      localFile = new File(localFile, "d_" + (String)localObject2);
      return localFile;
    }
    finally
    {
      AppMethodBeat.o(186144);
    }
    return null;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +146 -> 152
    //   9: aload_1
    //   10: arraylength
    //   11: ifeq +141 -> 152
    //   14: aload_0
    //   15: getfield 98	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   18: ifnonnull +11 -> 29
    //   21: aload_0
    //   22: aload_0
    //   23: invokevirtual 100	c/t/m/sapp/c/k:a	()Ljava/io/File;
    //   26: putfield 98	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   29: aload_0
    //   30: getfield 98	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +9 -> 44
    //   38: ldc 96
    //   40: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: new 102	java/io/BufferedOutputStream
    //   47: dup
    //   48: new 104	java/io/FileOutputStream
    //   51: dup
    //   52: aload_0
    //   53: getfield 98	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   56: iconst_1
    //   57: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   60: invokespecial 110	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   63: astore_3
    //   64: aload_3
    //   65: astore_2
    //   66: aload_3
    //   67: aload_1
    //   68: invokevirtual 113	java/io/BufferedOutputStream:write	([B)V
    //   71: aload_3
    //   72: astore_2
    //   73: aload_3
    //   74: invokevirtual 116	java/io/BufferedOutputStream:flush	()V
    //   77: aload_3
    //   78: invokevirtual 119	java/io/BufferedOutputStream:close	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 98	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   86: ldc 96
    //   88: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore_1
    //   93: ldc 96
    //   95: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_1
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 119	java/io/BufferedOutputStream:close	()V
    //   110: ldc 96
    //   112: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: astore_2
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 98	c/t/m/sapp/c/k:b	Ljava/io/File;
    //   127: aload_1
    //   128: ifnull +14 -> 142
    //   131: aload_1
    //   132: invokevirtual 119	java/io/BufferedOutputStream:close	()V
    //   135: ldc 96
    //   137: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_1
    //   142: ldc 96
    //   144: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: return
    //   148: astore_1
    //   149: goto -47 -> 102
    //   152: ldc 96
    //   154: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: astore_1
    //   159: goto -78 -> 81
    //   162: astore_2
    //   163: goto -53 -> 110
    //   166: astore_1
    //   167: aload_3
    //   168: astore_1
    //   169: goto -49 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	k
    //   0	172	1	paramArrayOfByte	byte[]
    //   33	89	2	localObject	Object
    //   162	1	2	localIOException	java.io.IOException
    //   63	105	3	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	29	92	finally
    //   29	34	92	finally
    //   77	81	92	finally
    //   81	91	92	finally
    //   106	110	92	finally
    //   110	117	92	finally
    //   131	140	92	finally
    //   44	64	99	finally
    //   44	64	117	java/io/IOException
    //   131	140	141	java/io/IOException
    //   66	71	148	finally
    //   73	77	148	finally
    //   122	127	148	finally
    //   77	81	158	java/io/IOException
    //   106	110	162	java/io/IOException
    //   66	71	166	java/io/IOException
    //   73	77	166	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.sapp.c.k
 * JD-Core Version:    0.7.0.1
 */