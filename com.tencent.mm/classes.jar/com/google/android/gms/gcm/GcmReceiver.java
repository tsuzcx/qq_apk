package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.zzk;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class GcmReceiver
  extends WakefulBroadcastReceiver
{
  private static boolean zzq = false;
  private static zzk zzr;
  private static zzk zzs;
  
  /* Error */
  private final zzk zzd(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 3629
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 28
    //   10: aload_2
    //   11: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +35 -> 49
    //   17: getstatic 36	com/google/android/gms/gcm/GcmReceiver:zzs	Lcom/google/android/gms/iid/zzk;
    //   20: ifnonnull +15 -> 35
    //   23: new 38	com/google/android/gms/iid/zzk
    //   26: dup
    //   27: aload_1
    //   28: aload_2
    //   29: invokespecial 41	com/google/android/gms/iid/zzk:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   32: putstatic 36	com/google/android/gms/gcm/GcmReceiver:zzs	Lcom/google/android/gms/iid/zzk;
    //   35: getstatic 36	com/google/android/gms/gcm/GcmReceiver:zzs	Lcom/google/android/gms/iid/zzk;
    //   38: astore_1
    //   39: sipush 3629
    //   42: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: getstatic 46	com/google/android/gms/gcm/GcmReceiver:zzr	Lcom/google/android/gms/iid/zzk;
    //   52: ifnonnull +15 -> 67
    //   55: new 38	com/google/android/gms/iid/zzk
    //   58: dup
    //   59: aload_1
    //   60: aload_2
    //   61: invokespecial 41	com/google/android/gms/iid/zzk:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   64: putstatic 46	com/google/android/gms/gcm/GcmReceiver:zzr	Lcom/google/android/gms/iid/zzk;
    //   67: getstatic 46	com/google/android/gms/gcm/GcmReceiver:zzr	Lcom/google/android/gms/iid/zzk;
    //   70: astore_1
    //   71: sipush 3629
    //   74: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -32 -> 45
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	GcmReceiver
    //   0	85	1	paramContext	Context
    //   0	85	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	35	80	finally
    //   35	45	80	finally
    //   49	67	80	finally
    //   67	77	80	finally
  }
  
  private final void zzd(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(3630);
    if (isOrderedBroadcast()) {
      setResultCode(500);
    }
    Object localObject1 = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if ((localObject1 == null) || (((ResolveInfo)localObject1).serviceInfo == null)) {}
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {}
      for (paramContext = startWakefulService(paramContext, paramIntent);; paramContext = paramContext.startService(paramIntent))
      {
        if (paramContext != null) {
          break label300;
        }
        if (!isOrderedBroadcast()) {
          break label312;
        }
        setResultCode(404);
        AppMethodBeat.o(3630);
        return;
        Object localObject2 = ((ResolveInfo)localObject1).serviceInfo;
        if ((!paramContext.getPackageName().equals(((ServiceInfo)localObject2).packageName)) || (((ServiceInfo)localObject2).name == null))
        {
          localObject1 = ((ServiceInfo)localObject2).packageName;
          localObject2 = ((ServiceInfo)localObject2).name;
          new StringBuilder(String.valueOf(localObject1).length() + 94 + String.valueOf(localObject2).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append((String)localObject1).append("/").append((String)localObject2);
          break;
        }
        localObject2 = ((ServiceInfo)localObject2).name;
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("."))
        {
          localObject1 = String.valueOf(paramContext.getPackageName());
          localObject2 = String.valueOf(localObject2);
          if (((String)localObject2).length() != 0) {
            localObject1 = ((String)localObject1).concat((String)localObject2);
          }
        }
        else
        {
          label222:
          if (Log.isLoggable("GcmReceiver", 3))
          {
            localObject2 = String.valueOf(localObject1);
            if (((String)localObject2).length() == 0) {
              break label278;
            }
            "Restricting intent to a specific service: ".concat((String)localObject2);
          }
        }
        for (;;)
        {
          paramIntent.setClassName(paramContext.getPackageName(), (String)localObject1);
          break;
          localObject1 = new String((String)localObject1);
          break label222;
          label278:
          new String("Restricting intent to a specific service: ");
        }
      }
      label300:
      if (isOrderedBroadcast()) {
        setResultCode(-1);
      }
      label312:
      AppMethodBeat.o(3630);
      return;
    }
    catch (SecurityException paramContext)
    {
      if (isOrderedBroadcast()) {
        setResultCode(401);
      }
      AppMethodBeat.o(3630);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(3628);
    Log.isLoggable("GcmReceiver", 3);
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18) {
      paramIntent.removeCategory(paramContext.getPackageName());
    }
    if ("google.com/iid".equals(paramIntent.getStringExtra("from"))) {
      paramIntent.setAction("com.google.android.gms.iid.InstanceID");
    }
    String str = paramIntent.getStringExtra("gcm.rawData64");
    if (str != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    int i = j;
    if (PlatformVersion.isAtLeastO())
    {
      i = j;
      if (paramContext.getApplicationInfo().targetSdkVersion >= 26) {
        i = 1;
      }
    }
    if (i != 0)
    {
      if (isOrderedBroadcast()) {
        setResultCode(-1);
      }
      zzd(paramContext, paramIntent.getAction()).zzd(paramIntent, goAsync());
      AppMethodBeat.o(3628);
      return;
    }
    "com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction());
    zzd(paramContext, paramIntent);
    if ((isOrderedBroadcast()) && (getResultCode() == 0)) {
      setResultCode(-1);
    }
    AppMethodBeat.o(3628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmReceiver
 * JD-Core Version:    0.7.0.1
 */