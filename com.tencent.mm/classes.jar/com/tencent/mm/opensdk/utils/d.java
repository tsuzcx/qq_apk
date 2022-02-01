package com.tencent.mm.opensdk.utils;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d
{
  public static Context D;
  private static final int E;
  private static final int F;
  private static final int G;
  public static ThreadPoolExecutor H;
  
  static
  {
    AppMethodBeat.i(3763);
    int i = Runtime.getRuntime().availableProcessors();
    E = i;
    F = i + 1;
    G = E * 2 + 1;
    H = new ThreadPoolExecutor(F, G, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(3763);
  }
  
  /* Error */
  private static int a(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: sipush 3762
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 66
    //   8: ldc 68
    //   10: invokestatic 73	com/tencent/mm/opensdk/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: ifnull +7 -> 21
    //   17: aload_1
    //   18: ifnonnull +18 -> 36
    //   21: ldc 66
    //   23: ldc 75
    //   25: invokestatic 78	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: sipush 3762
    //   31: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aconst_null
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 84	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +19 -> 67
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 89	java/io/InputStream:close	()V
    //   59: sipush 3762
    //   62: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: iconst_0
    //   66: ireturn
    //   67: aload_0
    //   68: astore_3
    //   69: aload_0
    //   70: astore 4
    //   72: aload_0
    //   73: invokevirtual 92	java/io/InputStream:available	()I
    //   76: istore_2
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 89	java/io/InputStream:close	()V
    //   85: sipush 3762
    //   88: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iload_2
    //   92: ireturn
    //   93: astore_0
    //   94: aload_3
    //   95: astore 4
    //   97: ldc 66
    //   99: new 94	java/lang/StringBuilder
    //   102: dup
    //   103: ldc 96
    //   105: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: invokevirtual 103	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 78	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 89	java/io/InputStream:close	()V
    //   129: sipush 3762
    //   132: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_0
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 89	java/io/InputStream:close	()V
    //   148: sipush 3762
    //   151: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: goto -98 -> 59
    //   160: astore_0
    //   161: goto -76 -> 85
    //   164: astore_0
    //   165: goto -36 -> 129
    //   168: astore_1
    //   169: goto -21 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContentResolver	android.content.ContentResolver
    //   0	172	1	paramUri	Uri
    //   76	16	2	i	int
    //   40	86	3	localContentResolver	android.content.ContentResolver
    //   37	107	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	47	93	java/lang/Exception
    //   72	77	93	java/lang/Exception
    //   41	47	137	finally
    //   72	77	137	finally
    //   97	121	137	finally
    //   55	59	156	java/io/IOException
    //   81	85	160	java/io/IOException
    //   125	129	164	java/io/IOException
    //   143	148	168	java/io/IOException
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    AppMethodBeat.i(3759);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(3759);
      return true;
    }
    AppMethodBeat.o(3759);
    return false;
  }
  
  public static int c(String paramString)
  {
    AppMethodBeat.i(3760);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(3760);
        return 0;
      }
      int i = Integer.parseInt(paramString);
      AppMethodBeat.o(3760);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(3760);
    }
    return 0;
  }
  
  public static int getFileSize(String paramString)
  {
    AppMethodBeat.i(3761);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(3761);
      return 0;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if ((D != null) && (paramString.startsWith("content"))) {
        try
        {
          i = a(D.getContentResolver(), Uri.parse(paramString));
          AppMethodBeat.o(3761);
          return i;
        }
        catch (Exception paramString)
        {
          AppMethodBeat.o(3761);
          return 0;
        }
      }
      AppMethodBeat.o(3761);
      return 0;
    }
    int i = (int)localFile.length();
    AppMethodBeat.o(3761);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.d
 * JD-Core Version:    0.7.0.1
 */