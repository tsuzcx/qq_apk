package com.tencent.mm.bz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

final class k
{
  static int ae(long paramLong, int paramInt)
  {
    AppMethodBeat.i(194844);
    if ((paramLong < -2147483648L) || (paramLong > 2147483647L))
    {
      a.a.log(5, "MicroMsg.recovery.utils", paramLong + " cannot be cast to int without changing its value.");
      AppMethodBeat.o(194844);
      return paramInt;
    }
    paramInt = (int)paramLong;
    AppMethodBeat.o(194844);
    return paramInt;
  }
  
  static boolean bV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(194841);
    if ((hN(paramContext) != null) && (hN(paramContext).equals(paramContext.getPackageName() + paramString)))
    {
      AppMethodBeat.o(194841);
      return true;
    }
    AppMethodBeat.o(194841);
    return false;
  }
  
  static <T> T checkNotNull(T paramT, String paramString)
  {
    AppMethodBeat.i(194840);
    if (paramT == null)
    {
      paramT = new RuntimeException(String.valueOf(paramString));
      AppMethodBeat.o(194840);
      throw paramT;
    }
    AppMethodBeat.o(194840);
    return paramT;
  }
  
  public static File hM(Context paramContext)
  {
    AppMethodBeat.i(194839);
    paramContext = new File(paramContext.getFilesDir().getParentFile(), "MicroMsg/recovery");
    AppMethodBeat.o(194839);
    return paramContext;
  }
  
  /* Error */
  private static String hN(Context paramContext)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 111	android/os/Process:myPid	()I
    //   8: istore_1
    //   9: aload_0
    //   10: ldc 113
    //   12: invokevirtual 117	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast 119	android/app/ActivityManager
    //   18: invokevirtual 123	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   21: astore 4
    //   23: aload_0
    //   24: invokevirtual 65	android/content/Context:getPackageName	()Ljava/lang/String;
    //   27: astore_0
    //   28: aload 4
    //   30: invokeinterface 129 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 135 1 0
    //   44: ifeq +58 -> 102
    //   47: aload 4
    //   49: invokeinterface 139 1 0
    //   54: checkcast 141	android/app/ActivityManager$RunningAppProcessInfo
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 145	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   64: iload_1
    //   65: if_icmpne -28 -> 37
    //   68: aload_0
    //   69: aload 5
    //   71: getfield 149	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   74: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq -40 -> 37
    //   80: aload 5
    //   82: getfield 149	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: astore_0
    //   86: ldc 105
    //   88: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: areturn
    //   93: astore_0
    //   94: iconst_5
    //   95: ldc 24
    //   97: ldc 151
    //   99: invokestatic 49	com/tencent/mm/bz/a$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   102: sipush 128
    //   105: newarray byte
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: new 153	java/io/FileInputStream
    //   115: dup
    //   116: new 26	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 155
    //   122: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: iload_1
    //   126: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc 161
    //   131: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 162	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   140: astore_0
    //   141: aload_0
    //   142: aload 5
    //   144: invokevirtual 166	java/io/FileInputStream:read	([B)I
    //   147: istore_3
    //   148: iload_3
    //   149: ifle +40 -> 189
    //   152: iconst_0
    //   153: istore_1
    //   154: goto +117 -> 271
    //   157: new 67	java/lang/String
    //   160: dup
    //   161: aload 5
    //   163: iconst_0
    //   164: iload_2
    //   165: invokespecial 169	java/lang/String:<init>	([BII)V
    //   168: astore 4
    //   170: aload_0
    //   171: invokestatic 173	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
    //   174: ldc 105
    //   176: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload 4
    //   181: areturn
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: goto +85 -> 271
    //   189: aload_0
    //   190: invokestatic 173	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
    //   193: ldc 105
    //   195: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: ldc 175
    //   200: areturn
    //   201: astore_0
    //   202: aload 4
    //   204: astore_0
    //   205: iconst_5
    //   206: ldc 24
    //   208: ldc 177
    //   210: invokestatic 49	com/tencent/mm/bz/a$a:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: invokestatic 173	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
    //   217: goto -24 -> 193
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: invokestatic 173	com/tencent/mm/bz/k$b:closeQuietly	(Ljava/lang/Object;)V
    //   229: ldc 105
    //   231: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: athrow
    //   236: astore 4
    //   238: aload_0
    //   239: astore 5
    //   241: aload 4
    //   243: astore_0
    //   244: aload 5
    //   246: astore 4
    //   248: goto -24 -> 224
    //   251: astore 4
    //   253: aload_0
    //   254: astore 5
    //   256: aload 4
    //   258: astore_0
    //   259: aload 5
    //   261: astore 4
    //   263: goto -39 -> 224
    //   266: astore 4
    //   268: goto -63 -> 205
    //   271: iload_3
    //   272: istore_2
    //   273: iload_1
    //   274: iload_3
    //   275: if_icmpge -118 -> 157
    //   278: aload 5
    //   280: iload_1
    //   281: baload
    //   282: sipush 128
    //   285: if_icmpgt +10 -> 295
    //   288: aload 5
    //   290: iload_1
    //   291: baload
    //   292: ifgt -110 -> 182
    //   295: iload_1
    //   296: istore_2
    //   297: goto -140 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramContext	Context
    //   8	288	1	i	int
    //   164	133	2	j	int
    //   147	129	3	k	int
    //   21	204	4	localObject1	Object
    //   236	6	4	localObject2	Object
    //   246	1	4	localObject3	Object
    //   251	6	4	localObject4	Object
    //   261	1	4	localObject5	Object
    //   266	1	4	localException	java.lang.Exception
    //   57	232	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	37	93	java/lang/Exception
    //   37	86	93	java/lang/Exception
    //   112	141	201	java/lang/Exception
    //   112	141	220	finally
    //   141	148	236	finally
    //   157	170	236	finally
    //   205	213	251	finally
    //   141	148	266	java/lang/Exception
    //   157	170	266	java/lang/Exception
  }
  
  static String hO(Context paramContext)
  {
    AppMethodBeat.i(194843);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        paramContext = paramContext.versionName;
        AppMethodBeat.o(194843);
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      a.w("MicroMsg.recovery.utils", "get version name fail", paramContext);
      AppMethodBeat.o(194843);
      return null;
      AppMethodBeat.o(194843);
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label35:
      break label35;
    }
  }
  
  static boolean isNumeric(String paramString)
  {
    AppMethodBeat.i(194845);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(194845);
      return false;
    }
    if (paramString.startsWith("-"))
    {
      bool = TextUtils.isDigitsOnly(paramString.substring(1));
      AppMethodBeat.o(194845);
      return bool;
    }
    boolean bool = TextUtils.isDigitsOnly(paramString);
    AppMethodBeat.o(194845);
    return bool;
  }
  
  @SuppressLint({"LongLogTag"})
  public static final class b
  {
    public static boolean J(File paramFile)
    {
      AppMethodBeat.i(194834);
      if (paramFile == null)
      {
        AppMethodBeat.o(194834);
        return false;
      }
      if (paramFile.isDirectory())
      {
        bool = K(paramFile);
        AppMethodBeat.o(194834);
        return bool;
      }
      boolean bool = safeDeleteFile(paramFile);
      AppMethodBeat.o(194834);
      return bool;
    }
    
    private static boolean K(File paramFile)
    {
      int i = 0;
      AppMethodBeat.i(194836);
      if ((paramFile == null) || (!paramFile.exists()))
      {
        AppMethodBeat.o(194836);
        return false;
      }
      if (paramFile.isFile()) {
        safeDeleteFile(paramFile);
      }
      for (;;)
      {
        AppMethodBeat.o(194836);
        return true;
        if (paramFile.isDirectory())
        {
          File[] arrayOfFile = paramFile.listFiles();
          if (arrayOfFile != null)
          {
            int j = arrayOfFile.length;
            while (i < j)
            {
              K(arrayOfFile[i]);
              i += 1;
            }
            safeDeleteFile(paramFile);
          }
        }
      }
    }
    
    static void L(File paramFile)
    {
      AppMethodBeat.i(194837);
      if (paramFile == null)
      {
        paramFile = new IOException("File is null.");
        AppMethodBeat.o(194837);
        throw paramFile;
      }
      if (paramFile.exists()) {
        J(paramFile);
      }
      File localFile = paramFile.getParentFile();
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      if (!paramFile.createNewFile())
      {
        paramFile = new IOException("Create file fail, file already exists.");
        AppMethodBeat.o(194837);
        throw paramFile;
      }
      AppMethodBeat.o(194837);
    }
    
    public static File[] M(File paramFile)
    {
      AppMethodBeat.i(194838);
      try
      {
        paramFile = paramFile.listFiles();
        AppMethodBeat.o(194838);
        return paramFile;
      }
      catch (Throwable paramFile)
      {
        AppMethodBeat.o(194838);
      }
      return new File[0];
    }
    
    @SuppressLint({"NewApi"})
    static void closeQuietly(Object paramObject)
    {
      AppMethodBeat.i(194833);
      if (paramObject == null)
      {
        AppMethodBeat.o(194833);
        return;
      }
      if ((paramObject instanceof Closeable)) {
        try
        {
          ((Closeable)paramObject).close();
          AppMethodBeat.o(194833);
          return;
        }
        catch (Throwable paramObject)
        {
          AppMethodBeat.o(194833);
          return;
        }
      }
      if ((Build.VERSION.SDK_INT >= 19) && ((paramObject instanceof AutoCloseable))) {
        try
        {
          ((AutoCloseable)paramObject).close();
          AppMethodBeat.o(194833);
          return;
        }
        catch (Throwable paramObject) {}
      }
      AppMethodBeat.o(194833);
    }
    
    private static boolean safeDeleteFile(File paramFile)
    {
      AppMethodBeat.i(194835);
      if (paramFile == null)
      {
        AppMethodBeat.o(194835);
        return true;
      }
      if (paramFile.exists())
      {
        boolean bool = paramFile.delete();
        if (!bool)
        {
          new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(paramFile.getPath());
          paramFile.deleteOnExit();
        }
        AppMethodBeat.o(194835);
        return bool;
      }
      AppMethodBeat.o(194835);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.k
 * JD-Core Version:    0.7.0.1
 */