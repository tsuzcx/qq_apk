package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class r
  implements Runnable
{
  private final f bKT;
  private final long bLG;
  private final PowerManager.WakeLock bLH;
  private final FirebaseInstanceId bLI;
  
  @VisibleForTesting
  r(FirebaseInstanceId paramFirebaseInstanceId, f paramf, long paramLong)
  {
    AppMethodBeat.i(4201);
    this.bLI = paramFirebaseInstanceId;
    this.bKT = paramf;
    this.bLG = paramLong;
    this.bLH = ((PowerManager)getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.bLH.setReferenceCounted(false);
    AppMethodBeat.o(4201);
  }
  
  private final boolean bT(String paramString)
  {
    AppMethodBeat.i(4205);
    Object localObject1 = paramString.split("!");
    int j;
    if (localObject1.length == 2)
    {
      paramString = localObject1[0];
      localObject1 = localObject1[1];
      j = -1;
    }
    FirebaseInstanceId localFirebaseInstanceId;
    Object localObject2;
    try
    {
      int k = paramString.hashCode();
      int i = j;
      switch (k)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          AppMethodBeat.o(4205);
          return true;
          i = j;
          if (paramString.equals("S"))
          {
            i = 0;
            continue;
            i = j;
            if (paramString.equals("U")) {
              i = 1;
            }
          }
          break;
        }
      }
      localFirebaseInstanceId = this.bLI;
      localObject2 = localFirebaseInstanceId.xW();
      if ((localObject2 != null) && (!((q)localObject2).bS(localFirebaseInstanceId.bKT.yf()))) {
        break label219;
      }
      paramString = new IOException("token not available");
      AppMethodBeat.o(4205);
      throw paramString;
    }
    catch (IOException paramString)
    {
      paramString = String.valueOf(paramString.getMessage());
      if (paramString.length() == 0) {
        break label526;
      }
    }
    "Topic sync failed: ".concat(paramString);
    for (;;)
    {
      AppMethodBeat.o(4205);
      return false;
      label219:
      Bundle localBundle = new Bundle();
      paramString = String.valueOf("/topics/");
      String str = String.valueOf(localObject1);
      if (str.length() != 0)
      {
        paramString = paramString.concat(str);
        label256:
        localBundle.putString("gcm.topic", paramString);
        localObject2 = ((q)localObject2).bLE;
        paramString = String.valueOf("/topics/");
        localObject1 = String.valueOf(localObject1);
        if (((String)localObject1).length() == 0) {
          break label331;
        }
      }
      label331:
      for (paramString = paramString.concat((String)localObject1);; paramString = new String(paramString))
      {
        localFirebaseInstanceId.b((String)localObject2, paramString, localBundle);
        if (!FirebaseInstanceId.xY()) {
          break;
        }
        break;
        paramString = new String(paramString);
        break label256;
      }
      localFirebaseInstanceId = this.bLI;
      localObject2 = localFirebaseInstanceId.xW();
      if ((localObject2 == null) || (((q)localObject2).bS(localFirebaseInstanceId.bKT.yf())))
      {
        paramString = new IOException("token not available");
        AppMethodBeat.o(4205);
        throw paramString;
      }
      localBundle = new Bundle();
      paramString = String.valueOf("/topics/");
      str = String.valueOf(localObject1);
      if (str.length() != 0)
      {
        paramString = paramString.concat(str);
        label432:
        localBundle.putString("gcm.topic", paramString);
        localBundle.putString("delete", "1");
        localObject2 = ((q)localObject2).bLE;
        paramString = String.valueOf("/topics/");
        localObject1 = String.valueOf(localObject1);
        if (((String)localObject1).length() == 0) {
          break label514;
        }
      }
      label514:
      for (paramString = paramString.concat((String)localObject1);; paramString = new String(paramString))
      {
        localFirebaseInstanceId.b((String)localObject2, paramString, localBundle);
        FirebaseInstanceId.xY();
        break;
        paramString = new String(paramString);
        break label432;
      }
      label526:
      new String("Topic sync failed: ");
    }
  }
  
  @VisibleForTesting
  private final boolean yl()
  {
    AppMethodBeat.i(4203);
    Object localObject3 = this.bLI.xW();
    if ((localObject3 != null) && (!((q)localObject3).bS(this.bKT.yf())))
    {
      AppMethodBeat.o(4203);
      return true;
    }
    try
    {
      Object localObject1 = this.bLI;
      localObject4 = f.b(((FirebaseInstanceId)localObject1).bKS);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        localObject1 = new IOException("MAIN_THREAD");
        AppMethodBeat.o(4203);
        throw ((Throwable)localObject1);
      }
    }
    catch (IOException localIOException)
    {
      Object localObject4;
      Object localObject2 = String.valueOf(localIOException.getMessage());
      if (((String)localObject2).length() != 0) {
        "Token retrieval failed: ".concat((String)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(4203);
        return false;
        if (("*".isEmpty()) || ("*".equalsIgnoreCase("fcm")) || ("*".equalsIgnoreCase("gcm"))) {
          break;
        }
        q localq = FirebaseInstanceId.bKQ.c("", (String)localObject4, "*");
        if ((localq != null) && (!localq.bS(((FirebaseInstanceId)localObject2).bKT.yf()))) {}
        for (localObject2 = localq.bLE; localObject2 == null; localObject2 = ((FirebaseInstanceId)localObject2).bKV.a((String)localObject4, "*", new aa((FirebaseInstanceId)localObject2, (String)localObject4, "*")).zzp())
        {
          AppMethodBeat.o(4203);
          return false;
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        if ((localObject3 == null) || ((localObject3 != null) && (!((String)localObject2).equals(((q)localObject3).bLE))))
        {
          localObject2 = getContext();
          localObject3 = new Intent("com.google.firebase.iid.TOKEN_REFRESH");
          localObject4 = new Intent("com.google.firebase.INSTANCE_ID_EVENT");
          ((Intent)localObject4).setClass((Context)localObject2, FirebaseInstanceIdReceiver.class);
          ((Intent)localObject4).putExtra("wrapped_intent", (Parcelable)localObject3);
          ((Context)localObject2).sendBroadcast((Intent)localObject4);
        }
        AppMethodBeat.o(4203);
        return true;
        new String("Token retrieval failed: ");
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
  }
  
  @VisibleForTesting
  private final boolean ym()
  {
    AppMethodBeat.i(4204);
    for (;;)
    {
      synchronized (this.bLI)
      {
        String str1 = FirebaseInstanceId.xX().yk();
        if (str1 == null)
        {
          AppMethodBeat.o(4204);
          return true;
        }
        if (!bT(str1))
        {
          AppMethodBeat.o(4204);
          return false;
        }
      }
      FirebaseInstanceId.xX().zzf(str2);
    }
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(4206);
    Context localContext = this.bLI.bKS.getApplicationContext();
    AppMethodBeat.o(4206);
    return localContext;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: sipush 4202
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 54	com/google/firebase/iid/r:bLH	Landroid/os/PowerManager$WakeLock;
    //   12: invokevirtual 279	android/os/PowerManager$WakeLock:acquire	()V
    //   15: aload_0
    //   16: getfield 28	com/google/firebase/iid/r:bLI	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   19: iconst_1
    //   20: invokevirtual 282	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   23: aload_0
    //   24: getfield 30	com/google/firebase/iid/r:bKT	Lcom/google/firebase/iid/f;
    //   27: invokevirtual 285	com/google/firebase/iid/f:zzx	()I
    //   30: ifeq +29 -> 59
    //   33: iload_1
    //   34: ifne +30 -> 64
    //   37: aload_0
    //   38: getfield 28	com/google/firebase/iid/r:bLI	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   41: iconst_0
    //   42: invokevirtual 282	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   45: aload_0
    //   46: getfield 54	com/google/firebase/iid/r:bLH	Landroid/os/PowerManager$WakeLock;
    //   49: invokevirtual 288	android/os/PowerManager$WakeLock:release	()V
    //   52: sipush 4202
    //   55: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: iconst_0
    //   60: istore_1
    //   61: goto -28 -> 33
    //   64: aload_0
    //   65: invokevirtual 291	com/google/firebase/iid/r:zzaj	()Z
    //   68: ifne +54 -> 122
    //   71: new 293	com/google/firebase/iid/s
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 296	com/google/firebase/iid/s:<init>	(Lcom/google/firebase/iid/r;)V
    //   79: astore_2
    //   80: invokestatic 151	com/google/firebase/iid/FirebaseInstanceId:xY	()Z
    //   83: pop
    //   84: new 298	android/content/IntentFilter
    //   87: dup
    //   88: ldc_w 300
    //   91: invokespecial 301	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   94: astore_3
    //   95: aload_2
    //   96: getfield 305	com/google/firebase/iid/s:bLJ	Lcom/google/firebase/iid/r;
    //   99: invokevirtual 36	com/google/firebase/iid/r:getContext	()Landroid/content/Context;
    //   102: aload_2
    //   103: aload_3
    //   104: invokevirtual 309	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   107: pop
    //   108: aload_0
    //   109: getfield 54	com/google/firebase/iid/r:bLH	Landroid/os/PowerManager$WakeLock;
    //   112: invokevirtual 288	android/os/PowerManager$WakeLock:release	()V
    //   115: sipush 4202
    //   118: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: aload_0
    //   123: invokespecial 311	com/google/firebase/iid/r:yl	()Z
    //   126: ifeq +32 -> 158
    //   129: aload_0
    //   130: invokespecial 313	com/google/firebase/iid/r:ym	()Z
    //   133: ifeq +25 -> 158
    //   136: aload_0
    //   137: getfield 28	com/google/firebase/iid/r:bLI	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   140: iconst_0
    //   141: invokevirtual 282	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   144: aload_0
    //   145: getfield 54	com/google/firebase/iid/r:bLH	Landroid/os/PowerManager$WakeLock;
    //   148: invokevirtual 288	android/os/PowerManager$WakeLock:release	()V
    //   151: sipush 4202
    //   154: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: return
    //   158: aload_0
    //   159: getfield 28	com/google/firebase/iid/r:bLI	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   162: aload_0
    //   163: getfield 32	com/google/firebase/iid/r:bLG	J
    //   166: invokevirtual 316	com/google/firebase/iid/FirebaseInstanceId:zza	(J)V
    //   169: goto -25 -> 144
    //   172: astore_2
    //   173: aload_0
    //   174: getfield 54	com/google/firebase/iid/r:bLH	Landroid/os/PowerManager$WakeLock;
    //   177: invokevirtual 288	android/os/PowerManager$WakeLock:release	()V
    //   180: sipush 4202
    //   183: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_2
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	r
    //   1	60	1	i	int
    //   79	24	2	locals	s
    //   172	15	2	localObject	Object
    //   94	10	3	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   15	33	172	finally
    //   37	45	172	finally
    //   64	108	172	finally
    //   122	144	172	finally
    //   158	169	172	finally
  }
  
  final boolean zzaj()
  {
    AppMethodBeat.i(4207);
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    if (localObject != null) {}
    for (localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo(); (localObject != null) && (((NetworkInfo)localObject).isConnected()); localObject = null)
    {
      AppMethodBeat.o(4207);
      return true;
    }
    AppMethodBeat.o(4207);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.r
 * JD-Core Version:    0.7.0.1
 */