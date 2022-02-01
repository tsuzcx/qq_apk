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
  private static final int b;
  private static final int c;
  private static final int d;
  public static ThreadPoolExecutor e;
  
  static
  {
    AppMethodBeat.i(196927);
    int i = Runtime.getRuntime().availableProcessors();
    b = i;
    c = i + 1;
    d = i * 2 + 1;
    e = new ThreadPoolExecutor(c, d, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(196927);
  }
  
  /* Error */
  public static int a(android.content.ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 67
    //   7: ldc 69
    //   9: invokestatic 74	com/tencent/mm/opensdk/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   27: invokevirtual 80	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   30: astore_0
    //   31: aload_0
    //   32: ifnonnull +18 -> 50
    //   35: aload_0
    //   36: ifnull +7 -> 43
    //   39: aload_0
    //   40: invokevirtual 85	java/io/InputStream:close	()V
    //   43: ldc 65
    //   45: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_0
    //   49: ireturn
    //   50: aload_0
    //   51: astore_3
    //   52: aload_0
    //   53: astore 4
    //   55: aload_0
    //   56: invokevirtual 88	java/io/InputStream:available	()I
    //   59: istore_2
    //   60: aload_0
    //   61: invokevirtual 85	java/io/InputStream:close	()V
    //   64: ldc 65
    //   66: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iload_2
    //   70: ireturn
    //   71: astore_0
    //   72: aload_3
    //   73: astore 4
    //   75: ldc 67
    //   77: new 90	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 92
    //   83: invokespecial 95	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokevirtual 99	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   90: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 109	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_3
    //   100: ifnull +7 -> 107
    //   103: aload_3
    //   104: invokevirtual 85	java/io/InputStream:close	()V
    //   107: ldc 65
    //   109: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: aload 4
    //   117: ifnull +8 -> 125
    //   120: aload 4
    //   122: invokevirtual 85	java/io/InputStream:close	()V
    //   125: ldc 65
    //   127: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: athrow
    //   132: ldc 67
    //   134: ldc 111
    //   136: invokestatic 109	com/tencent/mm/opensdk/utils/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: ldc 65
    //   141: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(196925);
    if ((paramString != null) && (paramString.length() != 0))
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        if ((a != null) && (paramString.startsWith("content"))) {
          try
          {
            i = a(a.getContentResolver(), Uri.parse(paramString));
            AppMethodBeat.o(196925);
            return i;
          }
          catch (Exception paramString)
          {
            AppMethodBeat.o(196925);
            return 0;
          }
        }
        AppMethodBeat.o(196925);
        return 0;
      }
      int i = (int)localFile.length();
      AppMethodBeat.o(196925);
      return i;
    }
    AppMethodBeat.o(196925);
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(196924);
    int i = paramInt;
    if (paramString != null) {
      i = paramInt;
    }
    try
    {
      if (paramString.length() > 0) {
        i = Integer.parseInt(paramString);
      }
      AppMethodBeat.o(196924);
      return i;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(196924);
    }
    return paramInt;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 36) || (paramInt == 46);
  }
  
  public static boolean b(String paramString)
  {
    AppMethodBeat.i(196923);
    if ((paramString != null) && (paramString.length() > 0))
    {
      AppMethodBeat.o(196923);
      return false;
    }
    AppMethodBeat.o(196923);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.b
 * JD-Core Version:    0.7.0.1
 */