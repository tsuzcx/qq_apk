package com.tencent.mm.compatible.e;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.regex.Pattern;

public final class n
{
  private static Map<String, String> epO = null;
  
  public static Map<String, String> Ls()
  {
    AppMethodBeat.i(92946);
    if (epO == null) {
      epO = Lx();
    }
    Map localMap = epO;
    AppMethodBeat.o(92946);
    return localMap;
  }
  
  public static String Lt()
  {
    AppMethodBeat.i(92947);
    if (epO == null) {
      epO = Lx();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(b(epO, "Features"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(b(epO, "Processor"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(b(epO, "CPU architecture"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(b(epO, "Hardware"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(b(epO, "Serial"));
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(92947);
    return localObject;
  }
  
  public static boolean Lu()
  {
    AppMethodBeat.i(92948);
    if (epO == null) {
      epO = Lx();
    }
    if (epO != null)
    {
      String str = b(epO, "Features");
      if ((str != null) && (str.contains("neon")))
      {
        AppMethodBeat.o(92948);
        return true;
      }
      if ((str != null) && (str.contains("asimd")))
      {
        AppMethodBeat.o(92948);
        return true;
      }
    }
    AppMethodBeat.o(92948);
    return false;
  }
  
  public static boolean Lv()
  {
    AppMethodBeat.i(92949);
    try
    {
      if (Build.VERSION.SDK_INT >= 4) {}
      for (int i = 1; (i != 0) && (Lu()); i = 0)
      {
        AppMethodBeat.o(92949);
        return true;
      }
      AppMethodBeat.o(92949);
      return false;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError1)
    {
      ab.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError1, "May cause dvmFindCatchBlock crash!", new Object[0]);
      IncompatibleClassChangeError localIncompatibleClassChangeError2 = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError1);
      AppMethodBeat.o(92949);
      throw localIncompatibleClassChangeError2;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(92949);
    }
    return false;
  }
  
  public static boolean Lw()
  {
    AppMethodBeat.i(92950);
    if (epO == null) {
      epO = Lx();
    }
    if (epO != null)
    {
      String str = b(epO, "CPU architecture");
      ab.d("CpuFeatures", "arch ".concat(String.valueOf(str)));
      if (str != null) {
        try
        {
          if (str.length() > 0)
          {
            int i = bo.getInt(lj(li(str)), 0);
            ab.d("CpuFeatures", "armarch ".concat(String.valueOf(i)));
            if (i >= 6)
            {
              AppMethodBeat.o(92950);
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("CpuFeatures", localException, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(92950);
    return false;
  }
  
  /* Error */
  public static java.util.HashMap<String, String> Lx()
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 156	java/util/HashMap
    //   8: dup
    //   9: invokespecial 157	java/util/HashMap:<init>	()V
    //   12: astore_3
    //   13: new 159	java/io/BufferedReader
    //   16: dup
    //   17: new 161	java/io/InputStreamReader
    //   20: dup
    //   21: new 163	java/io/FileInputStream
    //   24: dup
    //   25: ldc 165
    //   27: invokespecial 166	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: ldc 168
    //   32: invokespecial 171	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   35: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +98 -> 145
    //   50: aload_1
    //   51: astore_0
    //   52: aload_2
    //   53: ldc 179
    //   55: iconst_2
    //   56: invokevirtual 183	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull -24 -> 39
    //   66: aload_1
    //   67: astore_0
    //   68: aload 4
    //   70: arraylength
    //   71: iconst_2
    //   72: if_icmplt -33 -> 39
    //   75: aload_1
    //   76: astore_0
    //   77: aload 4
    //   79: iconst_0
    //   80: aaload
    //   81: invokevirtual 186	java/lang/String:trim	()Ljava/lang/String;
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: aload 4
    //   89: iconst_1
    //   90: aaload
    //   91: invokevirtual 186	java/lang/String:trim	()Ljava/lang/String;
    //   94: astore 4
    //   96: aload_1
    //   97: astore_0
    //   98: aload_3
    //   99: aload_2
    //   100: invokevirtual 190	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: ifnonnull -64 -> 39
    //   106: aload_1
    //   107: astore_0
    //   108: aload_3
    //   109: aload_2
    //   110: aload 4
    //   112: invokevirtual 194	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: goto -77 -> 39
    //   119: astore_2
    //   120: aload_1
    //   121: astore_0
    //   122: ldc 114
    //   124: aload_2
    //   125: ldc 196
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 101	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload_1
    //   135: invokestatic 199	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   138: ldc 154
    //   140: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_3
    //   144: areturn
    //   145: aload_1
    //   146: invokestatic 199	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   149: goto -11 -> 138
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_0
    //   155: aload_0
    //   156: invokestatic 199	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   159: ldc 154
    //   161: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: goto -12 -> 155
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: goto -53 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	116	0	localBufferedReader1	java.io.BufferedReader
    //   38	108	1	localBufferedReader2	java.io.BufferedReader
    //   152	13	1	localObject1	Object
    //   166	1	1	localObject2	Object
    //   172	1	1	localObject3	Object
    //   45	65	2	str	String
    //   119	6	2	localIOException1	java.io.IOException
    //   170	1	2	localIOException2	java.io.IOException
    //   12	132	3	localHashMap	java.util.HashMap
    //   59	52	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   41	46	119	java/io/IOException
    //   52	61	119	java/io/IOException
    //   68	75	119	java/io/IOException
    //   77	85	119	java/io/IOException
    //   87	96	119	java/io/IOException
    //   98	106	119	java/io/IOException
    //   108	116	119	java/io/IOException
    //   13	39	152	finally
    //   41	46	166	finally
    //   52	61	166	finally
    //   68	75	166	finally
    //   77	85	166	finally
    //   87	96	166	finally
    //   98	106	166	finally
    //   108	116	166	finally
    //   122	134	166	finally
    //   13	39	170	java/io/IOException
  }
  
  private static String b(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(92954);
    paramMap = (String)paramMap.get(paramString);
    AppMethodBeat.o(92954);
    return paramMap;
  }
  
  public static int getNumCores()
  {
    AppMethodBeat.i(92951);
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
      AppMethodBeat.o(92951);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(92951);
    }
    return 1;
  }
  
  private static String li(String paramString)
  {
    AppMethodBeat.i(92952);
    Object localObject = paramString;
    if (paramString != null)
    {
      String str = paramString;
      localObject = paramString;
      try
      {
        if (paramString.length() > 0) {
          for (;;)
          {
            str = paramString;
            localObject = paramString;
            if (t(paramString.charAt(0))) {
              break;
            }
            str = paramString;
            int i = paramString.length();
            if (i == 1)
            {
              AppMethodBeat.o(92952);
              return null;
            }
            str = paramString;
            paramString = paramString.substring(1);
          }
        }
        AppMethodBeat.o(92952);
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("CpuFeatures", paramString, "", new Object[0]);
        localObject = str;
      }
    }
    return localObject;
  }
  
  private static String lj(String paramString)
  {
    AppMethodBeat.i(92953);
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      try
      {
        if ((!t(paramString.charAt(i))) || (paramString.length() <= j))
        {
          i = j - 1;
          String str = paramString;
          if (paramString.length() > i + 1)
          {
            str = paramString;
            if (i > 0) {
              str = paramString.substring(0, i);
            }
          }
          AppMethodBeat.o(92953);
          return str;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("CpuFeatures", localException, "", new Object[0]);
        AppMethodBeat.o(92953);
        return paramString;
      }
    }
  }
  
  private static boolean t(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      AppMethodBeat.i(92945);
      if (Pattern.matches("cpu[0-9]", paramFile.getName()))
      {
        AppMethodBeat.o(92945);
        return true;
      }
      AppMethodBeat.o(92945);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.n
 * JD-Core Version:    0.7.0.1
 */