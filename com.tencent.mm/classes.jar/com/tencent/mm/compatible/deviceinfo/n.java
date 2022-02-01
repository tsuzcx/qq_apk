package com.tencent.mm.compatible.deviceinfo;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import java.util.Map;
import java.util.regex.Pattern;

public final class n
{
  private static Map<String, String> fDf = null;
  
  public static Map<String, String> WJ()
  {
    AppMethodBeat.i(155667);
    if (fDf == null) {
      fDf = WP();
    }
    Map localMap = fDf;
    AppMethodBeat.o(155667);
    return localMap;
  }
  
  public static String WK()
  {
    AppMethodBeat.i(155668);
    if (fDf == null) {
      fDf = WP();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(a(fDf, "Features"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(a(fDf, "Processor"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(a(fDf, "CPU architecture"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(a(fDf, "Hardware"));
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(a(fDf, "Serial"));
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(155668);
    return localObject;
  }
  
  public static boolean WL()
  {
    AppMethodBeat.i(155669);
    if (fDf == null) {
      fDf = WP();
    }
    if (fDf != null)
    {
      String str = a(fDf, "Features");
      if ((str != null) && (str.contains("neon")))
      {
        AppMethodBeat.o(155669);
        return true;
      }
      if ((str != null) && (str.contains("asimd")))
      {
        AppMethodBeat.o(155669);
        return true;
      }
    }
    AppMethodBeat.o(155669);
    return false;
  }
  
  public static boolean WM()
  {
    AppMethodBeat.i(155670);
    try
    {
      if (Build.VERSION.SDK_INT >= 4) {}
      for (int i = 1; (i != 0) && (WL()); i = 0)
      {
        AppMethodBeat.o(155670);
        return true;
      }
      AppMethodBeat.o(155670);
      return false;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError1)
    {
      ad.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError1, "May cause dvmFindCatchBlock crash!", new Object[0]);
      IncompatibleClassChangeError localIncompatibleClassChangeError2 = (IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError1);
      AppMethodBeat.o(155670);
      throw localIncompatibleClassChangeError2;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(155670);
    }
    return false;
  }
  
  public static boolean WN()
  {
    AppMethodBeat.i(155671);
    if (fDf == null) {
      fDf = WP();
    }
    if (fDf != null)
    {
      String str = a(fDf, "CPU architecture");
      ad.d("CpuFeatures", "arch ".concat(String.valueOf(str)));
      if (str != null) {
        try
        {
          if (str.length() > 0)
          {
            int i = bt.getInt(pf(pe(str)), 0);
            ad.d("CpuFeatures", "armarch ".concat(String.valueOf(i)));
            if (i >= 6)
            {
              AppMethodBeat.o(155671);
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("CpuFeatures", localException, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(155671);
    return false;
  }
  
  public static int WO()
  {
    AppMethodBeat.i(155672);
    try
    {
      int i = new e("/sys/devices/system/cpu/").a(new a()).length;
      AppMethodBeat.o(155672);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(155672);
    }
    return 1;
  }
  
  /* Error */
  public static java.util.HashMap<String, String> WP()
  {
    // Byte code:
    //   0: ldc 164
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 166	java/util/HashMap
    //   8: dup
    //   9: invokespecial 167	java/util/HashMap:<init>	()V
    //   12: astore_3
    //   13: new 169	java/io/BufferedReader
    //   16: dup
    //   17: new 171	java/io/InputStreamReader
    //   20: dup
    //   21: ldc 173
    //   23: invokestatic 179	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: ldc 181
    //   28: invokespecial 184	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   31: invokespecial 187	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 190	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +98 -> 141
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: ldc 192
    //   51: iconst_2
    //   52: invokevirtual 196	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnull -24 -> 35
    //   62: aload_1
    //   63: astore_0
    //   64: aload 4
    //   66: arraylength
    //   67: iconst_2
    //   68: if_icmplt -33 -> 35
    //   71: aload_1
    //   72: astore_0
    //   73: aload 4
    //   75: iconst_0
    //   76: aaload
    //   77: invokevirtual 199	java/lang/String:trim	()Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload 4
    //   85: iconst_1
    //   86: aaload
    //   87: invokevirtual 199	java/lang/String:trim	()Ljava/lang/String;
    //   90: astore 4
    //   92: aload_1
    //   93: astore_0
    //   94: aload_3
    //   95: aload_2
    //   96: invokevirtual 203	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   99: ifnonnull -64 -> 35
    //   102: aload_1
    //   103: astore_0
    //   104: aload_3
    //   105: aload_2
    //   106: aload 4
    //   108: invokevirtual 207	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: goto -77 -> 35
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: ldc 113
    //   120: aload_2
    //   121: ldc 209
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_1
    //   131: invokestatic 212	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   134: ldc 164
    //   136: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_3
    //   140: areturn
    //   141: aload_1
    //   142: invokestatic 212	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   145: goto -11 -> 134
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: invokestatic 212	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   155: ldc 164
    //   157: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: goto -12 -> 151
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_1
    //   169: goto -53 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	116	0	localBufferedReader1	java.io.BufferedReader
    //   34	108	1	localBufferedReader2	java.io.BufferedReader
    //   148	13	1	localObject1	Object
    //   162	1	1	localObject2	Object
    //   168	1	1	localObject3	Object
    //   41	65	2	str	String
    //   115	6	2	localIOException1	java.io.IOException
    //   166	1	2	localIOException2	java.io.IOException
    //   12	128	3	localHashMap	java.util.HashMap
    //   55	52	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	115	java/io/IOException
    //   48	57	115	java/io/IOException
    //   64	71	115	java/io/IOException
    //   73	81	115	java/io/IOException
    //   83	92	115	java/io/IOException
    //   94	102	115	java/io/IOException
    //   104	112	115	java/io/IOException
    //   13	35	148	finally
    //   37	42	162	finally
    //   48	57	162	finally
    //   64	71	162	finally
    //   73	81	162	finally
    //   83	92	162	finally
    //   94	102	162	finally
    //   104	112	162	finally
    //   118	130	162	finally
    //   13	35	166	java/io/IOException
  }
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(155675);
    paramMap = (String)paramMap.get(paramString);
    AppMethodBeat.o(155675);
    return paramMap;
  }
  
  private static String pe(String paramString)
  {
    AppMethodBeat.i(155673);
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
            if (u(paramString.charAt(0))) {
              break;
            }
            str = paramString;
            int i = paramString.length();
            if (i == 1)
            {
              AppMethodBeat.o(155673);
              return null;
            }
            str = paramString;
            paramString = paramString.substring(1);
          }
        }
        AppMethodBeat.o(155673);
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("CpuFeatures", paramString, "", new Object[0]);
        localObject = str;
      }
    }
    return localObject;
  }
  
  private static String pf(String paramString)
  {
    AppMethodBeat.i(155674);
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      try
      {
        if ((!u(paramString.charAt(i))) || (paramString.length() <= j))
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
          AppMethodBeat.o(155674);
          return str;
        }
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("CpuFeatures", localException, "", new Object[0]);
        AppMethodBeat.o(155674);
        return paramString;
      }
    }
  }
  
  private static boolean u(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  final class a
    implements g
  {
    public final boolean accept(e parame)
    {
      AppMethodBeat.i(175895);
      if (Pattern.matches("cpu[0-9]", parame.getName()))
      {
        AppMethodBeat.o(175895);
        return true;
      }
      AppMethodBeat.o(175895);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.n
 * JD-Core Version:    0.7.0.1
 */