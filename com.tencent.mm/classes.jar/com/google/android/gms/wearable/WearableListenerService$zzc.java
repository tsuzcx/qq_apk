package com.google.android.gms.wearable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WearableListenerService$zzc
  extends Handler
{
  private boolean started;
  private final WearableListenerService.zzb zzal;
  
  WearableListenerService$zzc(WearableListenerService paramWearableListenerService, Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(70918);
    this.zzal = new WearableListenerService.zzb(this.zzak, null);
    AppMethodBeat.o(70918);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UntrackedBindService"})
  private final void zzb()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 44
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
    //   11: ifeq +11 -> 22
    //   14: ldc 44
    //   16: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: ldc 48
    //   24: iconst_2
    //   25: invokestatic 54	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   28: ifeq +41 -> 69
    //   31: aload_0
    //   32: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
    //   35: invokestatic 58	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
    //   38: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   41: astore_1
    //   42: new 66	java/lang/StringBuilder
    //   45: dup
    //   46: aload_1
    //   47: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 70	java/lang/String:length	()I
    //   53: bipush 13
    //   55: iadd
    //   56: invokespecial 72	java/lang/StringBuilder:<init>	(I)V
    //   59: ldc 74
    //   61: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_0
    //   70: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
    //   73: aload_0
    //   74: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
    //   77: invokestatic 81	com/google/android/gms/wearable/WearableListenerService:zzb	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/Intent;
    //   80: aload_0
    //   81: getfield 34	com/google/android/gms/wearable/WearableListenerService$zzc:zzal	Lcom/google/android/gms/wearable/WearableListenerService$zzb;
    //   84: iconst_1
    //   85: invokevirtual 85	com/google/android/gms/wearable/WearableListenerService:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   88: pop
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
    //   94: ldc 44
    //   96: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: goto -80 -> 19
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	zzc
    //   41	24	1	str	java.lang.String
    //   102	4	1	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	19	102	finally
    //   22	69	102	finally
    //   69	99	102	finally
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UntrackedBindService"})
  private final void zzb(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 90
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
    //   11: ifne +11 -> 22
    //   14: ldc 90
    //   16: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: ldc 48
    //   24: iconst_2
    //   25: invokestatic 54	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   28: ifeq +58 -> 86
    //   31: aload_0
    //   32: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
    //   35: invokestatic 58	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Landroid/content/ComponentName;
    //   38: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   41: astore_2
    //   42: new 66	java/lang/StringBuilder
    //   45: dup
    //   46: aload_1
    //   47: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 70	java/lang/String:length	()I
    //   53: bipush 17
    //   55: iadd
    //   56: aload_2
    //   57: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   60: invokevirtual 70	java/lang/String:length	()I
    //   63: iadd
    //   64: invokespecial 72	java/lang/StringBuilder:<init>	(I)V
    //   67: ldc 92
    //   69: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 94
    //   78: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_2
    //   82: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_0
    //   87: getfield 17	com/google/android/gms/wearable/WearableListenerService$zzc:zzak	Lcom/google/android/gms/wearable/WearableListenerService;
    //   90: aload_0
    //   91: getfield 34	com/google/android/gms/wearable/WearableListenerService$zzc:zzal	Lcom/google/android/gms/wearable/WearableListenerService$zzb;
    //   94: invokevirtual 98	com/google/android/gms/wearable/WearableListenerService:unbindService	(Landroid/content/ServiceConnection;)V
    //   97: aload_0
    //   98: iconst_0
    //   99: putfield 46	com/google/android/gms/wearable/WearableListenerService$zzc:started	Z
    //   102: ldc 90
    //   104: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: goto -88 -> 19
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -19 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	zzc
    //   0	119	1	paramString	java.lang.String
    //   41	41	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	19	110	finally
    //   22	86	110	finally
    //   86	97	110	finally
    //   97	107	110	finally
    //   86	97	115	java/lang/RuntimeException
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(70919);
    zzb();
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    finally
    {
      if (!hasMessages(0)) {
        zzb("dispatch");
      }
      AppMethodBeat.o(70919);
    }
    AppMethodBeat.o(70919);
  }
  
  final void quit()
  {
    AppMethodBeat.i(70920);
    getLooper().quit();
    zzb("quit");
    AppMethodBeat.o(70920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.WearableListenerService.zzc
 * JD-Core Version:    0.7.0.1
 */