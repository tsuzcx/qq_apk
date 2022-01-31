package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;

public class GcmReceiver
  extends WakefulBroadcastReceiver
{
  private static String zzbgu = "gcm.googleapis.com/refresh";
  
  private void doStartService(Context paramContext, Intent paramIntent)
  {
    if (isOrderedBroadcast()) {
      setResultCode(500);
    }
    zze(paramContext, paramIntent);
    try
    {
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {}
      for (paramContext = startWakefulService(paramContext, paramIntent); paramContext == null; paramContext = paramContext.startService(paramIntent))
      {
        if (!isOrderedBroadcast()) {
          return;
        }
        setResultCode(404);
        return;
      }
      if (isOrderedBroadcast())
      {
        setResultCode(-1);
        return;
      }
    }
    catch (SecurityException paramContext)
    {
      if (isOrderedBroadcast()) {
        setResultCode(401);
      }
    }
  }
  
  private void zze(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if ((localObject == null) || (((ResolveInfo)localObject).serviceInfo == null)) {
      return;
    }
    localObject = ((ResolveInfo)localObject).serviceInfo;
    if ((!paramContext.getPackageName().equals(((ServiceInfo)localObject).packageName)) || (((ServiceInfo)localObject).name == null))
    {
      paramContext = String.valueOf(((ServiceInfo)localObject).packageName);
      paramIntent = String.valueOf(((ServiceInfo)localObject).name);
      new StringBuilder(String.valueOf(paramContext).length() + 94 + String.valueOf(paramIntent).length()).append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ").append(paramContext).append("/").append(paramIntent);
      return;
    }
    String str = ((ServiceInfo)localObject).name;
    localObject = str;
    if (str.startsWith("."))
    {
      localObject = String.valueOf(paramContext.getPackageName());
      str = String.valueOf(str);
      if (str.length() != 0) {
        localObject = ((String)localObject).concat(str);
      }
    }
    else if (Log.isLoggable("GcmReceiver", 3))
    {
      str = String.valueOf(localObject);
      if (str.length() == 0) {
        break label212;
      }
      "Restricting intent to a specific service: ".concat(str);
    }
    for (;;)
    {
      paramIntent.setClassName(paramContext.getPackageName(), (String)localObject);
      return;
      localObject = new String((String)localObject);
      break;
      label212:
      new String("Restricting intent to a specific service: ");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18) {
      paramIntent.removeCategory(paramContext.getPackageName());
    }
    String str = paramIntent.getStringExtra("from");
    if (("com.google.android.c2dm.intent.REGISTRATION".equals(paramIntent.getAction())) || ("google.com/iid".equals(str)) || (zzbgu.equals(str))) {
      paramIntent.setAction("com.google.android.gms.iid.InstanceID");
    }
    str = paramIntent.getStringExtra("gcm.rawData64");
    if (str != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    if ("com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction())) {
      zzd(paramContext, paramIntent);
    }
    for (;;)
    {
      if ((isOrderedBroadcast()) && (getResultCode() == 0)) {
        setResultCode(-1);
      }
      return;
      doStartService(paramContext, paramIntent);
    }
  }
  
  public void zzd(Context paramContext, Intent paramIntent)
  {
    doStartService(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmReceiver
 * JD-Core Version:    0.7.0.1
 */