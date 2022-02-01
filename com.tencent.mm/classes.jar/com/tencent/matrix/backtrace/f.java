package com.tencent.matrix.backtrace;

import android.content.Context;
import android.os.CancellationSignal;
import com.tencent.matrix.e.c;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class f
{
  static String G(String paramString, int paramInt)
  {
    return paramString + ":" + paramInt;
  }
  
  static String a(g.a parama)
  {
    return parama.mContext.getFilesDir().getAbsolutePath() + "/wechat-backtrace/saving-cache/";
  }
  
  static void a(Context paramContext, Map<String, Integer> paramMap)
  {
    paramContext = ba(paramContext);
    StringBuffer localStringBuffer = new StringBuffer();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuffer.append((String)localEntry.getKey() + "|" + localEntry.getValue() + "\n");
    }
    f(paramContext, localStringBuffer.toString());
  }
  
  static void a(File paramFile, CancellationSignal paramCancellationSignal, FileFilter paramFileFilter)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          a(paramFile[i], paramCancellationSignal, paramFileFilter);
          paramCancellationSignal.throwIfCanceled();
          i += 1;
        }
      }
    }
    else
    {
      paramFileFilter.accept(paramFile);
      paramCancellationSignal.throwIfCanceled();
    }
  }
  
  static File aX(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/wechat-backtrace/clean-up.timestamp");
    paramContext.getParentFile().mkdirs();
    return paramContext;
  }
  
  static File aY(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/wechat-backtrace/warmed-up");
    paramContext.getParentFile().mkdirs();
    return paramContext;
  }
  
  private static File aZ(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/wechat-backtrace/disk-usage.timestamp");
    paramContext.getParentFile().mkdirs();
    return paramContext;
  }
  
  static String b(g.a parama)
  {
    if (c(parama)) {
      return parama.cQR;
    }
    return a(parama);
  }
  
  static File ba(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir().getAbsolutePath() + "/wechat-backtrace/unfinished");
    paramContext.getParentFile().mkdirs();
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException localIOException)
    {
      c.printErrStackTrace("Matrix.Backtrace.WarmUp", localIOException, "", new Object[0]);
    }
    return paramContext;
  }
  
  static Map<String, Integer> bb(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    paramContext = ba(paramContext);
    String str = c(paramContext, 512000);
    if (str == null)
    {
      c.w("Matrix.Backtrace.WarmUp", "Read unfinished maps file failed, file size %s", new Object[] { Long.valueOf(paramContext.length()) });
      if (paramContext.length() > 512000L) {
        paramContext.delete();
      }
      return localHashMap;
    }
    paramContext = str.split("\n");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      str = paramContext[i];
      int k = str.lastIndexOf("|");
      if (k >= 0) {}
      try
      {
        localHashMap.put(str.substring(0, k), Integer.valueOf(Integer.parseInt(str.substring(k + 1))));
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          c.printErrStackTrace("Matrix.Backtrace.WarmUp", localThrowable, "", new Object[0]);
        }
      }
    }
  }
  
  static boolean bc(Context paramContext)
  {
    paramContext = aX(paramContext);
    if (!paramContext.exists()) {}
    while (System.currentTimeMillis() - paramContext.lastModified() < 259200000L) {
      try
      {
        paramContext.createNewFile();
        return false;
      }
      catch (IOException paramContext)
      {
        c.printErrStackTrace("Matrix.Backtrace.WarmUp", paramContext, "", new Object[0]);
        return false;
      }
    }
    return true;
  }
  
  static boolean bd(Context paramContext)
  {
    paramContext = aZ(paramContext);
    if (!paramContext.exists()) {}
    while (System.currentTimeMillis() - paramContext.lastModified() < 259200000L) {
      try
      {
        paramContext.createNewFile();
        return false;
      }
      catch (IOException paramContext)
      {
        c.printErrStackTrace("Matrix.Backtrace.WarmUp", paramContext, "", new Object[0]);
        return false;
      }
    }
    return true;
  }
  
  static void be(Context paramContext)
  {
    paramContext = aZ(paramContext);
    try
    {
      paramContext.createNewFile();
      paramContext.setLastModified(System.currentTimeMillis());
      return;
    }
    catch (IOException paramContext)
    {
      c.printErrStackTrace("Matrix.Backtrace.WarmUp", paramContext, "", new Object[0]);
    }
  }
  
  /* Error */
  static String c(File paramFile, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 264	java/io/File:isFile	()Z
    //   4: ifeq +81 -> 85
    //   7: new 11	java/lang/StringBuilder
    //   10: dup
    //   11: sipush 4096
    //   14: invokespecial 267	java/lang/StringBuilder:<init>	(I)V
    //   17: astore 5
    //   19: new 269	java/io/FileReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 272	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   27: astore 4
    //   29: aload 4
    //   31: astore_0
    //   32: sipush 1024
    //   35: newarray char
    //   37: astore 6
    //   39: iconst_0
    //   40: istore_2
    //   41: aload 4
    //   43: astore_0
    //   44: aload 4
    //   46: aload 6
    //   48: invokevirtual 276	java/io/FileReader:read	([C)I
    //   51: istore_3
    //   52: iload_3
    //   53: ifle +49 -> 102
    //   56: aload 4
    //   58: astore_0
    //   59: aload 5
    //   61: aload 6
    //   63: iconst_0
    //   64: iload_3
    //   65: invokevirtual 279	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: iload_2
    //   70: iload_3
    //   71: iadd
    //   72: istore_3
    //   73: iload_3
    //   74: istore_2
    //   75: iload_3
    //   76: iload_1
    //   77: if_icmple -36 -> 41
    //   80: aload 4
    //   82: invokevirtual 282	java/io/FileReader:close	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: ldc 168
    //   90: aload_0
    //   91: ldc 170
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aconst_null
    //   101: areturn
    //   102: aload 4
    //   104: astore_0
    //   105: aload 5
    //   107: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 5
    //   112: aload 4
    //   114: invokevirtual 282	java/io/FileReader:close	()V
    //   117: aload 5
    //   119: areturn
    //   120: astore_0
    //   121: ldc 168
    //   123: aload_0
    //   124: ldc 170
    //   126: iconst_0
    //   127: anewarray 4	java/lang/Object
    //   130: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: aload 5
    //   135: areturn
    //   136: astore 5
    //   138: aconst_null
    //   139: astore 4
    //   141: aload 4
    //   143: astore_0
    //   144: ldc 168
    //   146: aload 5
    //   148: ldc 170
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: aload 4
    //   159: ifnull -74 -> 85
    //   162: aload 4
    //   164: invokevirtual 282	java/io/FileReader:close	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_0
    //   170: ldc 168
    //   172: aload_0
    //   173: ldc 170
    //   175: iconst_0
    //   176: anewarray 4	java/lang/Object
    //   179: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aconst_null
    //   183: areturn
    //   184: astore 4
    //   186: aconst_null
    //   187: astore_0
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 282	java/io/FileReader:close	()V
    //   196: aload 4
    //   198: athrow
    //   199: astore_0
    //   200: ldc 168
    //   202: aload_0
    //   203: ldc 170
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -16 -> 196
    //   215: astore 4
    //   217: goto -29 -> 188
    //   220: astore 5
    //   222: goto -81 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramFile	File
    //   0	225	1	paramInt	int
    //   40	35	2	i	int
    //   51	27	3	j	int
    //   27	136	4	localFileReader	java.io.FileReader
    //   184	13	4	localObject1	Object
    //   215	1	4	localObject2	Object
    //   17	117	5	localObject3	Object
    //   136	11	5	localException1	java.lang.Exception
    //   220	1	5	localException2	java.lang.Exception
    //   37	25	6	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   112	117	120	java/io/IOException
    //   7	29	136	java/lang/Exception
    //   162	167	169	java/io/IOException
    //   7	29	184	finally
    //   192	196	199	java/io/IOException
    //   32	39	215	finally
    //   44	52	215	finally
    //   59	69	215	finally
    //   105	112	215	finally
    //   144	157	215	finally
    //   32	39	220	java/lang/Exception
    //   44	52	220	java/lang/Exception
    //   59	69	220	java/lang/Exception
    //   105	112	220	java/lang/Exception
  }
  
  private static boolean c(g.a parama)
  {
    if (parama.cQR == null) {
      return false;
    }
    File localFile = new File(parama.cQR);
    try
    {
      if (localFile.getCanonicalPath().startsWith(parama.mContext.getFilesDir().getParentFile().getCanonicalFile().getAbsolutePath())) {
        return true;
      }
      c.e("Matrix.Backtrace.WarmUp", "Saving path should under private storage path %s", new Object[] { parama.mContext.getFilesDir().getParentFile().getAbsolutePath() });
      return false;
    }
    catch (IOException parama)
    {
      c.printErrStackTrace("Matrix.Backtrace.WarmUp", parama, "", new Object[0]);
    }
    return false;
  }
  
  /* Error */
  static boolean f(File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_3
    //   3: istore_2
    //   4: aload_0
    //   5: invokevirtual 264	java/io/File:isFile	()Z
    //   8: ifeq +29 -> 37
    //   11: new 299	java/io/FileWriter
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 300	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 303	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   30: aload 4
    //   32: invokevirtual 304	java/io/FileWriter:close	()V
    //   35: iconst_1
    //   36: istore_2
    //   37: iload_2
    //   38: ireturn
    //   39: astore_0
    //   40: ldc 168
    //   42: aload_0
    //   43: ldc 170
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: goto -17 -> 35
    //   55: astore 5
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: ldc 168
    //   63: aload 5
    //   65: ldc 170
    //   67: iconst_0
    //   68: anewarray 4	java/lang/Object
    //   71: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: iload_3
    //   75: istore_2
    //   76: aload_1
    //   77: ifnull -40 -> 37
    //   80: aload_1
    //   81: invokevirtual 304	java/io/FileWriter:close	()V
    //   84: iconst_0
    //   85: ireturn
    //   86: astore_0
    //   87: ldc 168
    //   89: aload_0
    //   90: ldc 170
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: ifnull +7 -> 112
    //   108: aload_0
    //   109: invokevirtual 304	java/io/FileWriter:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: astore_0
    //   115: ldc 168
    //   117: aload_0
    //   118: ldc 170
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 176	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: goto -15 -> 112
    //   130: astore_1
    //   131: goto -27 -> 104
    //   134: astore 5
    //   136: aload 4
    //   138: astore_1
    //   139: goto -80 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramFile	File
    //   0	142	1	paramString	String
    //   3	73	2	bool1	boolean
    //   1	74	3	bool2	boolean
    //   19	118	4	localFileWriter	java.io.FileWriter
    //   55	9	5	localException1	java.lang.Exception
    //   134	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   30	35	39	java/io/IOException
    //   11	21	55	java/lang/Exception
    //   80	84	86	java/io/IOException
    //   11	21	101	finally
    //   108	112	114	java/io/IOException
    //   24	30	130	finally
    //   61	74	130	finally
    //   24	30	134	java/lang/Exception
  }
  
  static final class a
  {
    static Map<String, Integer> cSa;
    
    static int p(Context paramContext, String paramString)
    {
      if (cSa == null) {
        cSa = f.bb(paramContext);
      }
      paramContext = (Integer)cSa.get(paramString);
      if (paramContext != null) {
        return paramContext.intValue();
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.backtrace.f
 * JD-Core Version:    0.7.0.1
 */