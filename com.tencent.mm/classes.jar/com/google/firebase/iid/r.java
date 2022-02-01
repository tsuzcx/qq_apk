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
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class r
  implements Runnable
{
  private final f dCw;
  private final long dDj;
  private final PowerManager.WakeLock dDk;
  private final FirebaseInstanceId dDl;
  
  r(FirebaseInstanceId paramFirebaseInstanceId, f paramf, long paramLong)
  {
    AppMethodBeat.i(4201);
    this.dDl = paramFirebaseInstanceId;
    this.dCw = paramf;
    this.dDj = paramLong;
    this.dDk = ((PowerManager)getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
    this.dDk.setReferenceCounted(false);
    AppMethodBeat.o(4201);
  }
  
  private final boolean Yy()
  {
    AppMethodBeat.i(4203);
    Object localObject3 = this.dDl.Yj();
    if ((localObject3 != null) && (!((q)localObject3).dE(this.dCw.Ys())))
    {
      AppMethodBeat.o(4203);
      return true;
    }
    try
    {
      Object localObject1 = this.dDl;
      localObject4 = f.b(((FirebaseInstanceId)localObject1).dCv);
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
        q localq = FirebaseInstanceId.dCt.g("", (String)localObject4, "*");
        if ((localq != null) && (!localq.dE(((FirebaseInstanceId)localObject2).dCw.Ys()))) {}
        for (localObject2 = localq.dDh; localObject2 == null; localObject2 = ((FirebaseInstanceId)localObject2).dCy.a((String)localObject4, "*", new aa((FirebaseInstanceId)localObject2, (String)localObject4, "*")).zzp())
        {
          AppMethodBeat.o(4203);
          return false;
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        if ((localObject3 == null) || ((localObject3 != null) && (!((String)localObject2).equals(((q)localObject3).dDh))))
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
  
  private final boolean Yz()
  {
    AppMethodBeat.i(4204);
    for (;;)
    {
      synchronized (this.dDl)
      {
        String str1 = FirebaseInstanceId.Yk().Yx();
        if (str1 == null)
        {
          AppMethodBeat.o(4204);
          return true;
        }
        if (!dF(str1))
        {
          AppMethodBeat.o(4204);
          return false;
        }
      }
      FirebaseInstanceId.Yk().zzf(str2);
    }
  }
  
  private final boolean dF(String paramString)
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
      localFirebaseInstanceId = this.dDl;
      localObject2 = localFirebaseInstanceId.Yj();
      if ((localObject2 != null) && (!((q)localObject2).dE(localFirebaseInstanceId.dCw.Ys()))) {
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
        break label528;
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
        localObject2 = ((q)localObject2).dDh;
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
        if (!FirebaseInstanceId.Yl()) {
          break;
        }
        break;
        paramString = new String(paramString);
        break label256;
      }
      localFirebaseInstanceId = this.dDl;
      localObject2 = localFirebaseInstanceId.Yj();
      if ((localObject2 == null) || (((q)localObject2).dE(localFirebaseInstanceId.dCw.Ys())))
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
        localObject2 = ((q)localObject2).dDh;
        paramString = String.valueOf("/topics/");
        localObject1 = String.valueOf(localObject1);
        if (((String)localObject1).length() == 0) {
          break label516;
        }
      }
      label516:
      for (paramString = paramString.concat((String)localObject1);; paramString = new String(paramString))
      {
        localFirebaseInstanceId.b((String)localObject2, paramString, localBundle);
        FirebaseInstanceId.Yl();
        break;
        paramString = new String(paramString);
        break label432;
      }
      label528:
      new String("Topic sync failed: ");
    }
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(4206);
    Context localContext = this.dDl.dCv.getApplicationContext();
    AppMethodBeat.o(4206);
    return localContext;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 4202
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 53	com/google/firebase/iid/r:dDk	Landroid/os/PowerManager$WakeLock;
    //   10: astore_2
    //   11: aload_2
    //   12: ldc_w 276
    //   15: ldc_w 277
    //   18: ldc_w 278
    //   21: ldc_w 280
    //   24: ldc_w 282
    //   27: ldc_w 278
    //   30: invokestatic 287	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_2
    //   34: invokevirtual 289	android/os/PowerManager$WakeLock:acquire	()V
    //   37: aload_2
    //   38: ldc_w 276
    //   41: ldc_w 277
    //   44: ldc_w 278
    //   47: ldc_w 280
    //   50: ldc_w 282
    //   53: ldc_w 278
    //   56: invokestatic 292	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 27	com/google/firebase/iid/r:dDl	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   63: iconst_1
    //   64: invokevirtual 295	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   67: aload_0
    //   68: getfield 29	com/google/firebase/iid/r:dCw	Lcom/google/firebase/iid/f;
    //   71: invokevirtual 298	com/google/firebase/iid/f:zzx	()I
    //   74: ifeq +77 -> 151
    //   77: iconst_1
    //   78: istore_1
    //   79: iload_1
    //   80: ifne +76 -> 156
    //   83: aload_0
    //   84: getfield 27	com/google/firebase/iid/r:dDl	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   87: iconst_0
    //   88: invokevirtual 295	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   91: aload_0
    //   92: getfield 53	com/google/firebase/iid/r:dDk	Landroid/os/PowerManager$WakeLock;
    //   95: astore_2
    //   96: aload_2
    //   97: ldc_w 276
    //   100: ldc_w 277
    //   103: ldc_w 278
    //   106: ldc_w 280
    //   109: ldc_w 300
    //   112: ldc_w 278
    //   115: invokestatic 287	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_2
    //   119: invokevirtual 302	android/os/PowerManager$WakeLock:release	()V
    //   122: aload_2
    //   123: ldc_w 276
    //   126: ldc_w 277
    //   129: ldc_w 278
    //   132: ldc_w 280
    //   135: ldc_w 300
    //   138: ldc_w 278
    //   141: invokestatic 292	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   144: sipush 4202
    //   147: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: iconst_0
    //   152: istore_1
    //   153: goto -74 -> 79
    //   156: aload_0
    //   157: invokevirtual 305	com/google/firebase/iid/r:zzaj	()Z
    //   160: ifne +100 -> 260
    //   163: new 307	com/google/firebase/iid/s
    //   166: dup
    //   167: aload_0
    //   168: invokespecial 310	com/google/firebase/iid/s:<init>	(Lcom/google/firebase/iid/r;)V
    //   171: astore_2
    //   172: invokestatic 264	com/google/firebase/iid/FirebaseInstanceId:Yl	()Z
    //   175: pop
    //   176: new 312	android/content/IntentFilter
    //   179: dup
    //   180: ldc_w 314
    //   183: invokespecial 315	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   186: astore_3
    //   187: aload_2
    //   188: getfield 319	com/google/firebase/iid/s:dDm	Lcom/google/firebase/iid/r;
    //   191: invokevirtual 35	com/google/firebase/iid/r:getContext	()Landroid/content/Context;
    //   194: aload_2
    //   195: aload_3
    //   196: invokevirtual 323	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   199: pop
    //   200: aload_0
    //   201: getfield 53	com/google/firebase/iid/r:dDk	Landroid/os/PowerManager$WakeLock;
    //   204: astore_2
    //   205: aload_2
    //   206: ldc_w 276
    //   209: ldc_w 277
    //   212: ldc_w 278
    //   215: ldc_w 280
    //   218: ldc_w 300
    //   221: ldc_w 278
    //   224: invokestatic 287	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_2
    //   228: invokevirtual 302	android/os/PowerManager$WakeLock:release	()V
    //   231: aload_2
    //   232: ldc_w 276
    //   235: ldc_w 277
    //   238: ldc_w 278
    //   241: ldc_w 280
    //   244: ldc_w 300
    //   247: ldc_w 278
    //   250: invokestatic 292	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   253: sipush 4202
    //   256: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: aload_0
    //   261: invokespecial 325	com/google/firebase/iid/r:Yy	()Z
    //   264: ifeq +78 -> 342
    //   267: aload_0
    //   268: invokespecial 327	com/google/firebase/iid/r:Yz	()Z
    //   271: ifeq +71 -> 342
    //   274: aload_0
    //   275: getfield 27	com/google/firebase/iid/r:dDl	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   278: iconst_0
    //   279: invokevirtual 295	com/google/firebase/iid/FirebaseInstanceId:zza	(Z)V
    //   282: aload_0
    //   283: getfield 53	com/google/firebase/iid/r:dDk	Landroid/os/PowerManager$WakeLock;
    //   286: astore_2
    //   287: aload_2
    //   288: ldc_w 276
    //   291: ldc_w 277
    //   294: ldc_w 278
    //   297: ldc_w 280
    //   300: ldc_w 300
    //   303: ldc_w 278
    //   306: invokestatic 287	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_2
    //   310: invokevirtual 302	android/os/PowerManager$WakeLock:release	()V
    //   313: aload_2
    //   314: ldc_w 276
    //   317: ldc_w 277
    //   320: ldc_w 278
    //   323: ldc_w 280
    //   326: ldc_w 300
    //   329: ldc_w 278
    //   332: invokestatic 292	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   335: sipush 4202
    //   338: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: return
    //   342: aload_0
    //   343: getfield 27	com/google/firebase/iid/r:dDl	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   346: aload_0
    //   347: getfield 31	com/google/firebase/iid/r:dDj	J
    //   350: invokevirtual 330	com/google/firebase/iid/FirebaseInstanceId:zza	(J)V
    //   353: goto -71 -> 282
    //   356: astore_2
    //   357: aload_0
    //   358: getfield 53	com/google/firebase/iid/r:dDk	Landroid/os/PowerManager$WakeLock;
    //   361: astore_3
    //   362: aload_3
    //   363: ldc_w 276
    //   366: ldc_w 277
    //   369: ldc_w 278
    //   372: ldc_w 280
    //   375: ldc_w 300
    //   378: ldc_w 278
    //   381: invokestatic 287	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   384: aload_3
    //   385: invokevirtual 302	android/os/PowerManager$WakeLock:release	()V
    //   388: aload_3
    //   389: ldc_w 276
    //   392: ldc_w 277
    //   395: ldc_w 278
    //   398: ldc_w 280
    //   401: ldc_w 300
    //   404: ldc_w 278
    //   407: invokestatic 292	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   410: sipush 4202
    //   413: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: aload_2
    //   417: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	r
    //   78	75	1	i	int
    //   10	304	2	localObject1	Object
    //   356	61	2	localObject2	Object
    //   186	203	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   59	77	356	finally
    //   83	91	356	finally
    //   156	200	356	finally
    //   260	282	356	finally
    //   342	353	356	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.r
 * JD-Core Version:    0.7.0.1
 */