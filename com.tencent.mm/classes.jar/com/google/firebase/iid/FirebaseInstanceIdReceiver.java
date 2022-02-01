package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.Base64;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FirebaseInstanceIdReceiver
  extends WakefulBroadcastReceiver
{
  private static boolean dCB = false;
  private static y dCC;
  private static y dCD;
  
  private final void a(Context paramContext, Intent paramIntent, String paramString)
  {
    String str1 = null;
    int k = 0;
    int j = -1;
    AppMethodBeat.i(4144);
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18) {
      paramIntent.removeCategory(paramContext.getPackageName());
    }
    String str2 = paramIntent.getStringExtra("gcm.rawData64");
    if (str2 != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str2, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    if (("google.com/iid".equals(paramIntent.getStringExtra("from"))) || ("com.google.firebase.INSTANCE_ID_EVENT".equals(paramString)))
    {
      str1 = "com.google.firebase.INSTANCE_ID_EVENT";
      i = j;
      if (str1 != null)
      {
        i = k;
        if (PlatformVersion.isAtLeastO())
        {
          i = k;
          if (paramContext.getApplicationInfo().targetSdkVersion >= 26) {
            i = 1;
          }
        }
        if (i == 0) {
          break label223;
        }
        if (isOrderedBroadcast()) {
          setResultCode(-1);
        }
        n(paramContext, str1).a(paramIntent, goAsync());
      }
    }
    label223:
    for (int i = j;; i = o.Yw().a(paramContext, str1, paramIntent))
    {
      if (isOrderedBroadcast()) {
        setResultCode(i);
      }
      AppMethodBeat.o(4144);
      return;
      if ((!"com.google.android.c2dm.intent.RECEIVE".equals(paramString)) && (!"com.google.firebase.MESSAGING_EVENT".equals(paramString))) {
        break;
      }
      str1 = "com.google.firebase.MESSAGING_EVENT";
      break;
    }
  }
  
  /* Error */
  private static y n(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 4145
    //   6: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 125
    //   11: aload_1
    //   12: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +36 -> 51
    //   18: getstatic 136	com/google/firebase/iid/FirebaseInstanceIdReceiver:dCD	Lcom/google/firebase/iid/y;
    //   21: ifnonnull +15 -> 36
    //   24: new 115	com/google/firebase/iid/y
    //   27: dup
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 139	com/google/firebase/iid/y:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   33: putstatic 136	com/google/firebase/iid/FirebaseInstanceIdReceiver:dCD	Lcom/google/firebase/iid/y;
    //   36: getstatic 136	com/google/firebase/iid/FirebaseInstanceIdReceiver:dCD	Lcom/google/firebase/iid/y;
    //   39: astore_0
    //   40: sipush 4145
    //   43: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: getstatic 141	com/google/firebase/iid/FirebaseInstanceIdReceiver:dCC	Lcom/google/firebase/iid/y;
    //   54: ifnonnull +15 -> 69
    //   57: new 115	com/google/firebase/iid/y
    //   60: dup
    //   61: aload_0
    //   62: aload_1
    //   63: invokespecial 139	com/google/firebase/iid/y:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   66: putstatic 141	com/google/firebase/iid/FirebaseInstanceIdReceiver:dCC	Lcom/google/firebase/iid/y;
    //   69: getstatic 141	com/google/firebase/iid/FirebaseInstanceIdReceiver:dCC	Lcom/google/firebase/iid/y;
    //   72: astore_0
    //   73: sipush 4145
    //   76: invokestatic 121	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -33 -> 46
    //   82: astore_0
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramContext	Context
    //   0	88	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	36	82	finally
    //   36	46	82	finally
    //   51	69	82	finally
    //   69	79	82	finally
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(4143);
    if (paramIntent == null)
    {
      AppMethodBeat.o(4143);
      return;
    }
    Parcelable localParcelable = paramIntent.getParcelableExtra("wrapped_intent");
    if ((localParcelable instanceof Intent))
    {
      a(paramContext, (Intent)localParcelable, paramIntent.getAction());
      AppMethodBeat.o(4143);
      return;
    }
    a(paramContext, paramIntent, paramIntent.getAction());
    AppMethodBeat.o(4143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdReceiver
 * JD-Core Version:    0.7.0.1
 */