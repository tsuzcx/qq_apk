package com.google.android.gms.common.util;

import android.os.Process;

public class zzu
{
  private static String zzaIn = null;
  private static final int zzaIo = Process.myPid();
  
  /* Error */
  static String zzdq(int paramInt)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifgt +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 31	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   9: astore_2
    //   10: new 33	java/io/BufferedReader
    //   13: dup
    //   14: new 35	java/io/FileReader
    //   17: dup
    //   18: new 37	java/lang/StringBuilder
    //   21: dup
    //   22: bipush 25
    //   24: invokespecial 41	java/lang/StringBuilder:<init>	(I)V
    //   27: ldc 43
    //   29: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_0
    //   33: invokevirtual 50	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc 52
    //   38: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 59	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 62	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore_1
    //   51: aload_2
    //   52: invokestatic 66	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   55: aload_1
    //   56: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: invokevirtual 74	java/lang/String:trim	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_1
    //   64: invokestatic 80	com/google/android/gms/common/util/zzp:zzb	(Ljava/io/Closeable;)V
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: aload_2
    //   71: invokestatic 66	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   74: aload_1
    //   75: athrow
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: invokestatic 80	com/google/android/gms/common/util/zzp:zzb	(Ljava/io/Closeable;)V
    //   83: aconst_null
    //   84: areturn
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_2
    //   88: aload_2
    //   89: invokestatic 80	com/google/android/gms/common/util/zzp:zzb	(Ljava/io/Closeable;)V
    //   92: aload_1
    //   93: athrow
    //   94: astore_2
    //   95: aload_1
    //   96: astore_3
    //   97: aload_2
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: goto -13 -> 88
    //   104: astore_2
    //   105: goto -26 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramInt	int
    //   50	14	1	localBufferedReader	java.io.BufferedReader
    //   69	6	1	localObject1	Object
    //   76	1	1	localIOException1	java.io.IOException
    //   78	2	1	localCloseable	java.io.Closeable
    //   85	11	1	localObject2	Object
    //   98	1	1	localObject3	Object
    //   9	80	2	localObject4	Object
    //   94	4	2	localObject5	Object
    //   100	1	2	localObject6	Object
    //   104	1	2	localIOException2	java.io.IOException
    //   96	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   10	51	69	finally
    //   6	10	76	java/io/IOException
    //   70	76	76	java/io/IOException
    //   6	10	85	finally
    //   70	76	85	finally
    //   51	63	94	finally
    //   51	63	104	java/io/IOException
  }
  
  public static String zzzq()
  {
    if (zzaIn == null) {
      zzaIn = zzdq(zzaIo);
    }
    return zzaIn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.zzu
 * JD-Core Version:    0.7.0.1
 */