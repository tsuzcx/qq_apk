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
    AppMethodBeat.i(5277);
    int i = Binder.getCallingPid();
    if (i == zzde())
    {
      str = getMyProcessName();
      AppMethodBeat.o(5277);
      return str;
    }
    String str = zzl(i);
    AppMethodBeat.o(5277);
    return str;
  }
  
  @Nullable
  public static String getMyProcessName()
  {
    AppMethodBeat.i(5278);
    if (zzaai == null) {
      zzaai = zzl(zzde());
    }
    String str = zzaai;
    AppMethodBeat.o(5278);
    return str;
  }
  
  public static boolean hasSystemGroups()
  {
    AppMethodBeat.i(5279);
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
      AppMethodBeat.o(5279);
      return bool;
    }
    catch (IOException localIOException)
    {
      localObject1 = localBufferedReader1;
      SystemGroupsNotAvailableException localSystemGroupsNotAvailableException = new SystemGroupsNotAvailableException("Unable to access /proc/pid/status.", localIOException);
      localObject1 = localBufferedReader1;
      AppMethodBeat.o(5279);
      localObject1 = localBufferedReader1;
      throw localSystemGroupsNotAvailableException;
    }
    finally
    {
      IOUtils.closeQuietly((Closeable)localObject1);
      AppMethodBeat.o(5279);
    }
  }
  
  private static int zzde()
  {
    AppMethodBeat.i(5283);
    if (zzaaj == 0) {
      zzaaj = Process.myPid();
    }
    int i = zzaaj;
    AppMethodBeat.o(5283);
    return i;
  }
  
  private static boolean zzk(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(5280);
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
              AppMethodBeat.o(5280);
              return true;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            i += 1;
          }
        }
        AppMethodBeat.o(5280);
        return false;
      }
    }
    paramBufferedReader = new SystemGroupsNotAvailableException("Missing Groups entry from proc/pid/status.");
    AppMethodBeat.o(5280);
    throw paramBufferedReader;
  }
  
  /* Error */
  @Nullable
  private static String zzl(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 5281
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_0
    //   9: ifgt +11 -> 20
    //   12: sipush 5281
    //   15: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aconst_null
    //   19: areturn
    //   20: new 56	java/lang/StringBuilder
    //   23: dup
    //   24: bipush 25
    //   26: invokespecial 58	java/lang/StringBuilder:<init>	(I)V
    //   29: ldc 60
    //   31: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_0
    //   35: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: ldc 140
    //   40: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 76	com/google/android/gms/common/util/ProcessUtils:zzm	(Ljava/lang/String;)Ljava/io/BufferedReader;
    //   49: astore_1
    //   50: aload_1
    //   51: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: invokevirtual 108	java/lang/String:trim	()Ljava/lang/String;
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: aload_1
    //   61: invokestatic 86	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   64: sipush 5281
    //   67: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_2
    //   71: areturn
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 86	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   79: goto -15 -> 64
    //   82: astore_1
    //   83: aconst_null
    //   84: astore_2
    //   85: aload_2
    //   86: invokestatic 86	com/google/android/gms/common/util/IOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   89: sipush 5281
    //   92: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_2
    //   98: aload_1
    //   99: astore_3
    //   100: aload_2
    //   101: astore_1
    //   102: aload_3
    //   103: astore_2
    //   104: goto -19 -> 85
    //   107: astore_3
    //   108: goto -33 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramInt	int
    //   49	12	1	localBufferedReader	BufferedReader
    //   72	1	1	localIOException1	IOException
    //   74	2	1	localCloseable	Closeable
    //   82	17	1	localObject1	Object
    //   101	1	1	localObject2	Object
    //   1	85	2	localObject3	Object
    //   97	4	2	localObject4	Object
    //   103	1	2	localObject5	Object
    //   57	46	3	localObject6	Object
    //   107	1	3	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   20	50	72	java/io/IOException
    //   20	50	82	finally
    //   50	58	97	finally
    //   50	58	107	java/io/IOException
  }
  
  private static BufferedReader zzm(String paramString)
  {
    AppMethodBeat.i(5282);
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      paramString = new BufferedReader(new FileReader(paramString));
      return paramString;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
      AppMethodBeat.o(5282);
    }
  }
  
  public static class SystemGroupsNotAvailableException
    extends Exception
  {
    SystemGroupsNotAvailableException(String paramString)
    {
      super();
    }
    
    SystemGroupsNotAvailableException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */