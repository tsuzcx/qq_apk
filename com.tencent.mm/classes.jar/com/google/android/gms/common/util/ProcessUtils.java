package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils
{
  private static String zzaai = null;
  private static int zzaaj = 0;
  
  @Nullable
  public static String getCallingProcessName()
  {
    AppMethodBeat.i(90256);
    int i = Binder.getCallingPid();
    if (i == zzde())
    {
      str = getMyProcessName();
      AppMethodBeat.o(90256);
      return str;
    }
    String str = zzl(i);
    AppMethodBeat.o(90256);
    return str;
  }
  
  @Nullable
  public static String getMyProcessName()
  {
    AppMethodBeat.i(90257);
    if (zzaai == null) {
      zzaai = zzl(zzde());
    }
    String str = zzaai;
    AppMethodBeat.o(90257);
    return str;
  }
  
  public static boolean hasSystemGroups()
  {
    AppMethodBeat.i(90258);
    Object localObject3 = null;
    BufferedReader localBufferedReader2 = null;
    BufferedReader localBufferedReader1 = localBufferedReader2;
    Object localObject1 = localObject3;
    try
    {
      int i = zzde();
      localBufferedReader1 = localBufferedReader2;
      localObject1 = localObject3;
      localBufferedReader2 = zzm(24 + "/proc/" + i + "/status");
      localBufferedReader1 = localBufferedReader2;
      localObject1 = localBufferedReader2;
      boolean bool = zzk(localBufferedReader2);
      IOUtils.closeQuietly(localBufferedReader2);
      AppMethodBeat.o(90258);
      return bool;
    }
    catch (IOException localIOException)
    {
      localObject1 = localBufferedReader1;
      ProcessUtils.SystemGroupsNotAvailableException localSystemGroupsNotAvailableException = new ProcessUtils.SystemGroupsNotAvailableException("Unable to access /proc/pid/status.", localIOException);
      localObject1 = localBufferedReader1;
      AppMethodBeat.o(90258);
      localObject1 = localBufferedReader1;
      throw localSystemGroupsNotAvailableException;
    }
    finally
    {
      IOUtils.closeQuietly((Closeable)localObject1);
      AppMethodBeat.o(90258);
    }
  }
  
  private static int zzde()
  {
    AppMethodBeat.i(90262);
    if (zzaaj == 0) {
      zzaaj = Process.myPid();
    }
    int i = zzaaj;
    AppMethodBeat.o(90262);
    return i;
  }
  
  private static boolean zzk(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(90259);
    String str2;
    for (String str1 = paramBufferedReader.readLine(); str1 != null; str2 = paramBufferedReader.readLine())
    {
      str1 = str1.trim();
      if (str1.startsWith("Groups:"))
      {
        paramBufferedReader = str1.substring(7).trim().split("\\s", -1);
        int j = paramBufferedReader.length;
        int i = 0;
        while (i < j)
        {
          str1 = paramBufferedReader[i];
          try
          {
            long l = Long.parseLong(str1);
            if ((l >= 1000L) && (l < 2000L))
            {
              AppMethodBeat.o(90259);
              return true;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            i += 1;
          }
        }
        AppMethodBeat.o(90259);
        return false;
      }
    }
    paramBufferedReader = new ProcessUtils.SystemGroupsNotAvailableException("Missing Groups entry from proc/pid/status.");
    AppMethodBeat.o(90259);
    throw paramBufferedReader;
  }
  
  /* Error */
  @Nullable
  private static String zzl(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 143
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_0
    //   8: ifgt +10 -> 18
    //   11: ldc 143
    //   13: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: new 58	java/lang/StringBuilder
    //   21: dup
    //   22: bipush 25
    //   24: invokespecial 60	java/lang/StringBuilder:<init>	(I)V
    //   27: ldc 62
    //   29: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_0
    //   33: invokevirtual 69	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc 145
    //   38: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 78	com/google/android/gms/common/util/ProcessUtils:zzm	(Ljava/lang/String;)Ljava/io/BufferedReader;
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: invokevirtual 112	java/lang/String:trim	()Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_1
    //   59: invokestatic 88	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   62: ldc 143
    //   64: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: invokestatic 88	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   76: goto -14 -> 62
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_2
    //   82: aload_2
    //   83: invokestatic 88	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   86: ldc 143
    //   88: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_1
    //   92: athrow
    //   93: astore_2
    //   94: aload_1
    //   95: astore_3
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: astore_2
    //   100: goto -18 -> 82
    //   103: astore_3
    //   104: goto -32 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramInt	int
    //   47	12	1	localBufferedReader	BufferedReader
    //   69	1	1	localIOException1	IOException
    //   71	2	1	localCloseable	Closeable
    //   79	16	1	localObject1	Object
    //   97	1	1	localObject2	Object
    //   1	82	2	localObject3	Object
    //   93	4	2	localObject4	Object
    //   99	1	2	localObject5	Object
    //   55	44	3	localObject6	Object
    //   103	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   18	48	69	java/io/IOException
    //   18	48	79	finally
    //   48	56	93	finally
    //   48	56	103	java/io/IOException
  }
  
  private static BufferedReader zzm(String paramString)
  {
    AppMethodBeat.i(90261);
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      paramString = new BufferedReader(new FileReader(paramString));
      return paramString;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
      AppMethodBeat.o(90261);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */