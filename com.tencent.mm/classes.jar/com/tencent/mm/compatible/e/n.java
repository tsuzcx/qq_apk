package com.tencent.mm.compatible.e;

import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.regex.Pattern;

public final class n
{
  private static Map<String, String> dxO = null;
  
  private static String b(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  private static boolean d(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  private static String eY(String paramString)
  {
    localObject = paramString;
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
            if (d(paramString.charAt(0))) {
              break;
            }
            str = paramString;
            if (paramString.length() == 1) {
              return null;
            }
            str = paramString;
            paramString = paramString.substring(1);
          }
        }
        return localObject;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("CpuFeatures", paramString, "", new Object[0]);
        localObject = str;
      }
    }
  }
  
  private static String eZ(String paramString)
  {
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      try
      {
        if ((!d(paramString.charAt(i))) || (paramString.length() <= j))
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
          return str;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("CpuFeatures", localException, "", new Object[0]);
        return paramString;
      }
    }
  }
  
  public static int getNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new a()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public static Map<String, String> yV()
  {
    if (dxO == null) {
      dxO = za();
    }
    return dxO;
  }
  
  public static String yW()
  {
    if (dxO == null) {
      dxO = za();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": ");
    localStringBuilder.append(b(dxO, "Features"));
    localStringBuilder.append(": ");
    localStringBuilder.append(b(dxO, "Processor"));
    localStringBuilder.append(": ");
    localStringBuilder.append(b(dxO, "CPU architecture"));
    localStringBuilder.append(": ");
    localStringBuilder.append(b(dxO, "Hardware"));
    localStringBuilder.append(": ");
    localStringBuilder.append(b(dxO, "Serial"));
    return localStringBuilder.toString();
  }
  
  public static boolean yX()
  {
    if (dxO == null) {
      dxO = za();
    }
    if (dxO != null)
    {
      String str = b(dxO, "Features");
      if ((str != null) && (str.contains("neon"))) {}
      while ((str != null) && (str.contains("asimd"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean yY()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 4) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = yX();
        if (!bool) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      y.printErrStackTrace("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
      throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError));
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean yZ()
  {
    boolean bool2 = false;
    if (dxO == null) {
      dxO = za();
    }
    boolean bool1 = bool2;
    String str;
    if (dxO != null)
    {
      str = b(dxO, "CPU architecture");
      y.d("CpuFeatures", "arch " + str);
      bool1 = bool2;
      if (str != null) {
        bool1 = bool2;
      }
    }
    try
    {
      if (str.length() > 0)
      {
        int i = bk.getInt(eZ(eY(str)), 0);
        y.d("CpuFeatures", "armarch " + i);
        bool1 = bool2;
        if (i >= 6) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("CpuFeatures", localException, "", new Object[0]);
    }
    return false;
  }
  
  /* Error */
  public static java.util.HashMap<String, String> za()
  {
    // Byte code:
    //   0: new 167	java/util/HashMap
    //   3: dup
    //   4: invokespecial 168	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 170	java/io/BufferedReader
    //   11: dup
    //   12: new 172	java/io/InputStreamReader
    //   15: dup
    //   16: new 174	java/io/FileInputStream
    //   19: dup
    //   20: ldc 176
    //   22: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: ldc 179
    //   27: invokespecial 182	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   30: invokespecial 185	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 188	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +93 -> 135
    //   45: aload_1
    //   46: astore_0
    //   47: aload_2
    //   48: ldc 190
    //   50: iconst_2
    //   51: invokevirtual 194	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: ifnull -24 -> 34
    //   61: aload_1
    //   62: astore_0
    //   63: aload 4
    //   65: arraylength
    //   66: iconst_2
    //   67: if_icmplt -33 -> 34
    //   70: aload_1
    //   71: astore_0
    //   72: aload 4
    //   74: iconst_0
    //   75: aaload
    //   76: invokevirtual 197	java/lang/String:trim	()Ljava/lang/String;
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload 4
    //   84: iconst_1
    //   85: aaload
    //   86: invokevirtual 197	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore 4
    //   91: aload_1
    //   92: astore_0
    //   93: aload_3
    //   94: aload_2
    //   95: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: ifnonnull -64 -> 34
    //   101: aload_1
    //   102: astore_0
    //   103: aload_3
    //   104: aload_2
    //   105: aload 4
    //   107: invokevirtual 202	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: goto -77 -> 34
    //   114: astore_2
    //   115: aload_1
    //   116: astore_0
    //   117: ldc 49
    //   119: aload_2
    //   120: ldc 204
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 57	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_1
    //   130: invokestatic 207	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   133: aload_3
    //   134: areturn
    //   135: aload_1
    //   136: invokestatic 207	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   139: aload_3
    //   140: areturn
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: invokestatic 207	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: goto -7 -> 144
    //   154: astore_2
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -42 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	110	0	localBufferedReader1	java.io.BufferedReader
    //   33	103	1	localBufferedReader2	java.io.BufferedReader
    //   141	8	1	localObject1	Object
    //   150	1	1	localObject2	Object
    //   156	1	1	localObject3	Object
    //   40	65	2	str	String
    //   114	6	2	localIOException1	java.io.IOException
    //   154	1	2	localIOException2	java.io.IOException
    //   7	133	3	localHashMap	java.util.HashMap
    //   54	52	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	114	java/io/IOException
    //   47	56	114	java/io/IOException
    //   63	70	114	java/io/IOException
    //   72	80	114	java/io/IOException
    //   82	91	114	java/io/IOException
    //   93	101	114	java/io/IOException
    //   103	111	114	java/io/IOException
    //   8	34	141	finally
    //   36	41	150	finally
    //   47	56	150	finally
    //   63	70	150	finally
    //   72	80	150	finally
    //   82	91	150	finally
    //   93	101	150	finally
    //   103	111	150	finally
    //   117	129	150	finally
    //   8	34	154	java/io/IOException
  }
  
  final class a
    implements FileFilter
  {
    public final boolean accept(File paramFile)
    {
      return Pattern.matches("cpu[0-9]", paramFile.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.n
 * JD-Core Version:    0.7.0.1
 */