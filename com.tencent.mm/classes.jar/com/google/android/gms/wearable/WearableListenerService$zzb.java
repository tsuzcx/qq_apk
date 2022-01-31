package com.google.android.gms.wearable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class WearableListenerService$zzb
  extends Handler
{
  private boolean started;
  private final WearableListenerService.zza zzbTo = new WearableListenerService.zza(this.zzbTp, null);
  
  WearableListenerService$zzb(WearableListenerService paramWearableListenerService, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UntrackedBindService"})
  private void zzUh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 37
    //   16: iconst_2
    //   17: invokestatic 43	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   20: ifeq +41 -> 61
    //   23: aload_0
    //   24: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTp	Lcom/google/android/gms/wearable/WearableListenerService;
    //   27: invokestatic 47	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
    //   30: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: astore_2
    //   34: new 55	java/lang/StringBuilder
    //   37: dup
    //   38: aload_2
    //   39: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokevirtual 59	java/lang/String:length	()I
    //   45: bipush 13
    //   47: iadd
    //   48: invokespecial 62	java/lang/StringBuilder:<init>	(I)V
    //   51: ldc 64
    //   53: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_0
    //   62: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTp	Lcom/google/android/gms/wearable/WearableListenerService;
    //   65: aload_0
    //   66: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTp	Lcom/google/android/gms/wearable/WearableListenerService;
    //   69: invokestatic 71	com/google/android/gms/wearable/WearableListenerService:zzb	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/Intent;
    //   72: aload_0
    //   73: getfield 27	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTo	Lcom/google/android/gms/wearable/WearableListenerService$zza;
    //   76: iconst_1
    //   77: invokevirtual 75	com/google/android/gms/wearable/WearableListenerService:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   80: pop
    //   81: aload_0
    //   82: iconst_1
    //   83: putfield 35	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
    //   86: goto -75 -> 11
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	zzb
    //   6	2	1	bool	boolean
    //   33	24	2	str	java.lang.String
    //   89	4	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	7	89	finally
    //   14	61	89	finally
    //   61	86	89	finally
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UntrackedBindService"})
  private void zzio(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 37
    //   16: iconst_2
    //   17: invokestatic 43	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   20: ifeq +58 -> 78
    //   23: aload_0
    //   24: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTp	Lcom/google/android/gms/wearable/WearableListenerService;
    //   27: invokestatic 47	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
    //   30: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: astore_3
    //   34: new 55	java/lang/StringBuilder
    //   37: dup
    //   38: aload_1
    //   39: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokevirtual 59	java/lang/String:length	()I
    //   45: bipush 17
    //   47: iadd
    //   48: aload_3
    //   49: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   52: invokevirtual 59	java/lang/String:length	()I
    //   55: iadd
    //   56: invokespecial 62	java/lang/StringBuilder:<init>	(I)V
    //   59: ldc 82
    //   61: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 84
    //   70: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_3
    //   74: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_0
    //   79: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTp	Lcom/google/android/gms/wearable/WearableListenerService;
    //   82: aload_0
    //   83: getfield 27	com/google/android/gms/wearable/WearableListenerService$zzb:zzbTo	Lcom/google/android/gms/wearable/WearableListenerService$zza;
    //   86: invokevirtual 88	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 35	com/google/android/gms/wearable/WearableListenerService$zzb:started	Z
    //   94: goto -83 -> 11
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: goto -14 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	zzb
    //   0	106	1	paramString	java.lang.String
    //   6	2	2	bool	boolean
    //   33	41	3	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   14	78	97	finally
    //   78	89	97	finally
    //   89	94	97	finally
    //   78	89	102	java/lang/RuntimeException
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    zzUh();
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    finally
    {
      if (!hasMessages(0)) {
        zzio("dispatch");
      }
    }
  }
  
  final void quit()
  {
    getLooper().quit();
    zzio("quit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzb
 * JD-Core Version:    0.7.0.1
 */