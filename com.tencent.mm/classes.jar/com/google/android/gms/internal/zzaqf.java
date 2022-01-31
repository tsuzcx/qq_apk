package com.google.android.gms.internal;

public class zzaqf
{
  /* Error */
  public static <T> T zzb(java.util.concurrent.Callable<T> paramCallable)
  {
    // Byte code:
    //   0: invokestatic 14	android/os/StrictMode:getThreadPolicy	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore_1
    //   4: getstatic 20	android/os/StrictMode$ThreadPolicy:LAX	Landroid/os/StrictMode$ThreadPolicy;
    //   7: invokestatic 24	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   10: aload_0
    //   11: invokeinterface 30 1 0
    //   16: astore_0
    //   17: aload_1
    //   18: invokestatic 24	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   21: aload_0
    //   22: areturn
    //   23: astore_0
    //   24: aload_1
    //   25: invokestatic 24	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   28: aconst_null
    //   29: areturn
    //   30: astore_0
    //   31: aload_1
    //   32: invokestatic 24	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramCallable	java.util.concurrent.Callable<T>
    //   3	29	1	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   4	17	23	java/lang/Throwable
    //   4	17	30	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqf
 * JD-Core Version:    0.7.0.1
 */