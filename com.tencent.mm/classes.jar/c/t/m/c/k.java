package c.t.m.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class k
{
  private static boolean a = false;
  private File b;
  private File c;
  private Context d;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(136374);
    if (paramContext == null)
    {
      AppMethodBeat.o(136374);
      return;
    }
    this.d = paramContext.getApplicationContext();
    try
    {
      this.b = new File(paramContext.getExternalFilesDir("data").getAbsolutePath() + "/d_l");
      AppMethodBeat.o(136374);
      return;
    }
    catch (Throwable paramContext)
    {
      this.b = null;
      AppMethodBeat.o(136374);
    }
  }
  
  private File a()
  {
    AppMethodBeat.i(136376);
    try
    {
      File localFile = this.b;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(localFile, "d_".concat(String.valueOf(q.a(String.valueOf(System.currentTimeMillis())))));
      AppMethodBeat.o(136376);
      return localFile;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(136376);
    }
    return null;
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: arraylength
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +9 -> 22
    //   16: ldc 110
    //   18: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: getfield 112	c/t/m/c/k:c	Ljava/io/File;
    //   26: ifnonnull +11 -> 37
    //   29: aload_0
    //   30: aload_0
    //   31: invokespecial 114	c/t/m/c/k:a	()Ljava/io/File;
    //   34: putfield 112	c/t/m/c/k:c	Ljava/io/File;
    //   37: aload_0
    //   38: getfield 112	c/t/m/c/k:c	Ljava/io/File;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull +9 -> 52
    //   46: ldc 110
    //   48: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: new 116	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 118	java/io/FileOutputStream
    //   59: dup
    //   60: aload_0
    //   61: getfield 112	c/t/m/c/k:c	Ljava/io/File;
    //   64: iconst_1
    //   65: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   68: invokespecial 124	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 127	java/io/BufferedOutputStream:write	([B)V
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 130	java/io/BufferedOutputStream:flush	()V
    //   90: aload 4
    //   92: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 112	c/t/m/c/k:c	Ljava/io/File;
    //   100: ldc 110
    //   102: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore_3
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 112	c/t/m/c/k:c	Ljava/io/File;
    //   116: aload_1
    //   117: ifnull +21 -> 138
    //   120: aload_1
    //   121: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   124: ldc 110
    //   126: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore_1
    //   131: ldc 110
    //   133: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: astore_1
    //   138: ldc 110
    //   140: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: return
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_3
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 133	java/io/BufferedOutputStream:close	()V
    //   155: ldc 110
    //   157: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: goto -68 -> 95
    //   166: astore_3
    //   167: goto -12 -> 155
    //   170: astore_1
    //   171: goto -24 -> 147
    //   174: astore_1
    //   175: aload 4
    //   177: astore_1
    //   178: goto -69 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	k
    //   0	181	1	paramArrayOfByte	byte[]
    //   11	2	2	i	int
    //   41	111	3	localObject	Object
    //   166	1	3	localIOException	java.io.IOException
    //   71	105	4	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   52	73	106	java/io/IOException
    //   9	12	130	java/lang/Throwable
    //   22	37	130	java/lang/Throwable
    //   37	42	130	java/lang/Throwable
    //   90	95	130	java/lang/Throwable
    //   95	100	130	java/lang/Throwable
    //   120	124	130	java/lang/Throwable
    //   124	129	130	java/lang/Throwable
    //   151	155	130	java/lang/Throwable
    //   155	162	130	java/lang/Throwable
    //   120	124	137	java/io/IOException
    //   52	73	144	finally
    //   90	95	162	java/io/IOException
    //   151	155	166	java/io/IOException
    //   76	82	170	finally
    //   85	90	170	finally
    //   111	116	170	finally
    //   76	82	174	java/io/IOException
    //   85	90	174	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.k
 * JD-Core Version:    0.7.0.1
 */