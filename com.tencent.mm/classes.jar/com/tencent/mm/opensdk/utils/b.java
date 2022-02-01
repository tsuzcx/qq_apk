package com.tencent.mm.opensdk.utils;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  public static Context a;
  public static ThreadPoolExecutor b;
  
  static
  {
    AppMethodBeat.i(242951);
    b = new ThreadPoolExecutor(5, 9, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(242951);
  }
  
  /* Error */
  public static int a(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 45
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 47
    //   7: ldc 49
    //   9: invokestatic 54	com/tencent/mm/opensdk/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: ifnull +119 -> 132
    //   16: aload_1
    //   17: ifnull +115 -> 132
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore_3
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 60	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +18 -> 50
    //   35: aload_0
    //   36: ifnull +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 65	java/io/InputStream:close	()V
    //   43: ldc 45
    //   45: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_0
    //   49: ireturn
    //   50: aload_0
    //   51: astore_3
    //   52: aload_0
    //   53: astore 4
    //   55: aload_0
    //   56: invokevirtual 69	java/io/InputStream:available	()I
    //   59: istore_2
    //   60: aload_0
    //   61: invokevirtual 65	java/io/InputStream:close	()V
    //   64: ldc 45
    //   66: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iload_2
    //   70: ireturn
    //   71: astore_0
    //   72: aload_3
    //   73: astore 4
    //   75: ldc 47
    //   77: new 71	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 73
    //   83: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokevirtual 80	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 90	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 65	java/io/InputStream:close	()V
    //   107: ldc 45
    //   109: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: aload 4
    //   117: ifnull +8 -> 125
    //   120: aload 4
    //   122: invokevirtual 65	java/io/InputStream:close	()V
    //   125: ldc 45
    //   127: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: athrow
    //   132: ldc 47
    //   134: ldc 92
    //   136: invokestatic 90	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 45
    //   141: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: goto -104 -> 43
    //   150: astore_0
    //   151: goto -87 -> 64
    //   154: astore_0
    //   155: goto -48 -> 107
    //   158: astore_1
    //   159: goto -34 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContentResolver	android.content.ContentResolver
    //   0	162	1	paramUri	Uri
    //   59	11	2	i	int
    //   24	80	3	localContentResolver	android.content.ContentResolver
    //   21	100	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   25	31	71	java/lang/Exception
    //   55	60	71	java/lang/Exception
    //   25	31	114	finally
    //   55	60	114	finally
    //   75	99	114	finally
    //   39	43	146	java/io/IOException
    //   60	64	150	java/io/IOException
    //   103	107	154	java/io/IOException
    //   120	125	158	java/io/IOException
  }
  
  public static int a(String paramString)
  {
    AppMethodBeat.i(242948);
    if ((paramString != null) && (paramString.length() != 0))
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        if ((a != null) && (paramString.startsWith("content"))) {
          try
          {
            i = a(a.getContentResolver(), Uri.parse(paramString));
            AppMethodBeat.o(242948);
            return i;
          }
          catch (Exception paramString)
          {
            AppMethodBeat.o(242948);
            return 0;
          }
        }
        AppMethodBeat.o(242948);
        return 0;
      }
      int i = (int)localFile.length();
      AppMethodBeat.o(242948);
      return i;
    }
    AppMethodBeat.o(242948);
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(242943);
    int i = paramInt;
    if (paramString != null) {
      i = paramInt;
    }
    try
    {
      if (paramString.length() > 0) {
        i = Integer.parseInt(paramString);
      }
      AppMethodBeat.o(242943);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(242943);
    }
    return paramInt;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    AppMethodBeat.i(242939);
    if ((paramString != null) && (paramString.length() > 0))
    {
      AppMethodBeat.o(242939);
      return false;
    }
    AppMethodBeat.o(242939);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.b
 * JD-Core Version:    0.7.0.1
 */