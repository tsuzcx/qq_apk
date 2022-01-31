package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

public final class FirebaseInstanceIdReceiver
  extends WakefulBroadcastReceiver
{
  private static boolean bfc = false;
  @GuardedBy("FirebaseInstanceIdReceiver.class")
  private static y bfd;
  @GuardedBy("FirebaseInstanceIdReceiver.class")
  private static y bfe;
  
  private final void a(Context paramContext, Intent paramIntent, String paramString)
  {
    String str1 = null;
    int k = 0;
    int j = -1;
    AppMethodBeat.i(108708);
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
          break label221;
        }
        if (isOrderedBroadcast()) {
          setResultCode(-1);
        }
        j(paramContext, str1).a(paramIntent, goAsync());
      }
    }
    label221:
    for (int i = j;; i = o.sa().a(paramContext, str1, paramIntent))
    {
      if (isOrderedBroadcast()) {
        setResultCode(i);
      }
      AppMethodBeat.o(108708);
      return;
      if ((!"com.google.android.c2dm.intent.RECEIVE".equals(paramString)) && (!"com.google.firebase.MESSAGING_EVENT".equals(paramString))) {
        break;
      }
      str1 = "com.google.firebase.MESSAGING_EVENT";
      break;
    }
  }
  
  /* Error */
  private static y j(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 139
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 129
    //   10: aload_1
    //   11: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +35 -> 49
    //   17: getstatic 141	com/google/firebase/iid/FirebaseInstanceIdReceiver:bfe	Lcom/google/firebase/iid/y;
    //   20: ifnonnull +15 -> 35
    //   23: new 119	com/google/firebase/iid/y
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: invokespecial 144	com/google/firebase/iid/y:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   32: putstatic 141	com/google/firebase/iid/FirebaseInstanceIdReceiver:bfe	Lcom/google/firebase/iid/y;
    //   35: getstatic 141	com/google/firebase/iid/FirebaseInstanceIdReceiver:bfe	Lcom/google/firebase/iid/y;
    //   38: astore_0
    //   39: ldc 139
    //   41: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: areturn
    //   49: getstatic 146	com/google/firebase/iid/FirebaseInstanceIdReceiver:bfd	Lcom/google/firebase/iid/y;
    //   52: ifnonnull +15 -> 67
    //   55: new 119	com/google/firebase/iid/y
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: invokespecial 144	com/google/firebase/iid/y:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   64: putstatic 146	com/google/firebase/iid/FirebaseInstanceIdReceiver:bfd	Lcom/google/firebase/iid/y;
    //   67: getstatic 146	com/google/firebase/iid/FirebaseInstanceIdReceiver:bfd	Lcom/google/firebase/iid/y;
    //   70: astore_0
    //   71: ldc 139
    //   73: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -32 -> 44
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramContext	Context
    //   0	85	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	35	79	finally
    //   35	44	79	finally
    //   49	67	79	finally
    //   67	76	79	finally
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(108707);
    if (paramIntent == null)
    {
      AppMethodBeat.o(108707);
      return;
    }
    Parcelable localParcelable = paramIntent.getParcelableExtra("wrapped_intent");
    if ((localParcelable instanceof Intent))
    {
      a(paramContext, (Intent)localParcelable, paramIntent.getAction());
      AppMethodBeat.o(108707);
      return;
    }
    a(paramContext, paramIntent, paramIntent.getAction());
    AppMethodBeat.o(108707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdReceiver
 * JD-Core Version:    0.7.0.1
 */