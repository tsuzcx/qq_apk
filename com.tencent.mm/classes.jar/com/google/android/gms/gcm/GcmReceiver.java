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
    //   2: ldc 21
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 29
    //   9: aload_2
    //   10: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifeq +34 -> 47
    //   16: getstatic 37	com/google/android/gms/gcm/GcmReceiver:zzs	Lcom/google/android/gms/iid/zzk;
    //   19: ifnonnull +15 -> 34
    //   22: new 39	com/google/android/gms/iid/zzk
    //   25: dup
    //   26: aload_1
    //   27: aload_2
    //   28: invokespecial 42	com/google/android/gms/iid/zzk:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   31: putstatic 37	com/google/android/gms/gcm/GcmReceiver:zzs	Lcom/google/android/gms/iid/zzk;
    //   34: getstatic 37	com/google/android/gms/gcm/GcmReceiver:zzs	Lcom/google/android/gms/iid/zzk;
    //   37: astore_1
    //   38: ldc 21
    //   40: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: areturn
    //   47: getstatic 47	com/google/android/gms/gcm/GcmReceiver:zzr	Lcom/google/android/gms/iid/zzk;
    //   50: ifnonnull +15 -> 65
    //   53: new 39	com/google/android/gms/iid/zzk
    //   56: dup
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 42	com/google/android/gms/iid/zzk:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   62: putstatic 47	com/google/android/gms/gcm/GcmReceiver:zzr	Lcom/google/android/gms/iid/zzk;
    //   65: getstatic 47	com/google/android/gms/gcm/GcmReceiver:zzr	Lcom/google/android/gms/iid/zzk;
    //   68: astore_1
    //   69: ldc 21
    //   71: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -31 -> 43
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	GcmReceiver
    //   0	82	1	paramContext	Context
    //   0	82	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	34	77	finally
    //   34	43	77	finally
    //   47	65	77	finally
    //   65	74	77	finally
  }
  
  private final void zzd(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(69954);
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
          break label298;
        }
        if (!isOrderedBroadcast()) {
          break label310;
        }
        setResultCode(404);
        AppMethodBeat.o(69954);
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
          label220:
          if (Log.isLoggable("GcmReceiver", 3))
          {
            localObject2 = String.valueOf(localObject1);
            if (((String)localObject2).length() == 0) {
              break label276;
            }
            "Restricting intent to a specific service: ".concat((String)localObject2);
          }
        }
        for (;;)
        {
          paramIntent.setClassName(paramContext.getPackageName(), (String)localObject1);
          break;
          localObject1 = new String((String)localObject1);
          break label220;
          label276:
          new String("Restricting intent to a specific service: ");
        }
      }
      label298:
      if (isOrderedBroadcast()) {
        setResultCode(-1);
      }
      label310:
      AppMethodBeat.o(69954);
      return;
    }
    catch (SecurityException paramContext)
    {
      if (isOrderedBroadcast()) {
        setResultCode(401);
      }
      AppMethodBeat.o(69954);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    AppMethodBeat.i(69952);
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
      AppMethodBeat.o(69952);
      return;
    }
    "com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction());
    zzd(paramContext, paramIntent);
    if ((isOrderedBroadcast()) && (getResultCode() == 0)) {
      setResultCode(-1);
    }
    AppMethodBeat.o(69952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmReceiver
 * JD-Core Version:    0.7.0.1
 */