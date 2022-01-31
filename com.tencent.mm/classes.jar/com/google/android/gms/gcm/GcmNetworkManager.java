package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.List;

public class GcmNetworkManager
{
  public static final int RESULT_FAILURE = 2;
  public static final int RESULT_RESCHEDULE = 1;
  public static final int RESULT_SUCCESS = 0;
  private static GcmNetworkManager zzbgp;
  private Context mContext;
  private final PendingIntent mPendingIntent;
  
  private GcmNetworkManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent().setPackage("com.google.example.invalidpackage"), 0);
  }
  
  public static GcmNetworkManager getInstance(Context paramContext)
  {
    try
    {
      if (zzbgp == null) {
        zzbgp = new GcmNetworkManager(paramContext.getApplicationContext());
      }
      paramContext = zzbgp;
      return paramContext;
    }
    finally {}
  }
  
  private Intent zzGO()
  {
    String str = GoogleCloudMessaging.zzbv(this.mContext);
    int i = -1;
    if (str != null) {
      i = GoogleCloudMessaging.zzbw(this.mContext);
    }
    if ((str == null) || (i < GoogleCloudMessaging.zzbgB))
    {
      new StringBuilder(91).append("Google Play Services is not available, dropping GcmNetworkManager request. code=").append(i);
      return null;
    }
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage(str);
    localIntent.putExtra("app", this.mPendingIntent);
    localIntent.putExtra("source", 4);
    localIntent.putExtra("source_version", 10298000);
    return localIntent;
  }
  
  private void zza(ComponentName paramComponentName)
  {
    zzez(paramComponentName.getClassName());
    Intent localIntent = zzGO();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "CANCEL_ALL");
    localIntent.putExtra("component", paramComponentName);
    this.mContext.sendBroadcast(localIntent);
  }
  
  private void zza(String paramString, ComponentName paramComponentName)
  {
    zzey(paramString);
    zzez(paramComponentName.getClassName());
    Intent localIntent = zzGO();
    if (localIntent == null) {
      return;
    }
    localIntent.putExtra("scheduler_action", "CANCEL_TASK");
    localIntent.putExtra("tag", paramString);
    localIntent.putExtra("component", paramComponentName);
    this.mContext.sendBroadcast(localIntent);
  }
  
  static void zzey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Must provide a valid tag.");
    }
    if (100 < paramString.length()) {
      throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
    }
  }
  
  private void zzez(String paramString)
  {
    boolean bool2 = true;
    zzac.zzb(paramString, "GcmTaskService must not be null.");
    Object localObject = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
    ((Intent)localObject).setPackage(this.mContext.getPackageName());
    localObject = this.mContext.getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      bool1 = true;
      zzac.zzb(bool1, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((ResolveInfo)((Iterator)localObject).next()).serviceInfo.name.equals(paramString));
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzac.zzb(bool1, String.valueOf(paramString).length() + 119 + "The GcmTaskService class you provided " + paramString + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.");
      return;
      bool1 = false;
      break;
    }
  }
  
  public void cancelAllTasks(Class<? extends GcmTaskService> paramClass)
  {
    zzd(paramClass);
  }
  
  public void cancelTask(String paramString, Class<? extends GcmTaskService> paramClass)
  {
    zzb(paramString, paramClass);
  }
  
  public void schedule(Task paramTask)
  {
    zzez(paramTask.getServiceName());
    Intent localIntent = zzGO();
    if (localIntent == null) {
      return;
    }
    Bundle localBundle = localIntent.getExtras();
    localBundle.putString("scheduler_action", "SCHEDULE_TASK");
    paramTask.toBundle(localBundle);
    localIntent.putExtras(localBundle);
    this.mContext.sendBroadcast(localIntent);
  }
  
  public void zzb(String paramString, Class<? extends Service> paramClass)
  {
    zza(paramString, new ComponentName(this.mContext, paramClass));
  }
  
  public void zzd(Class<? extends Service> paramClass)
  {
    zza(new ComponentName(this.mContext, paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmNetworkManager
 * JD-Core Version:    0.7.0.1
 */