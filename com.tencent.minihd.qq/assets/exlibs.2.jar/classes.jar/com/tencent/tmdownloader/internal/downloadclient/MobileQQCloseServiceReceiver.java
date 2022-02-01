package com.tencent.tmdownloader.internal.downloadclient;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.format.Time;
import com.tencent.tmassistantbase.a.g;
import com.tencent.tmassistantbase.a.k;
import java.util.ArrayList;
import java.util.List;

public class MobileQQCloseServiceReceiver
  extends BroadcastReceiver
{
  protected static MobileQQCloseServiceReceiver b = null;
  public boolean a = false;
  public HandlerThread c = new HandlerThread("checkIsAllFinishThread");
  public Handler d = null;
  
  public static MobileQQCloseServiceReceiver a()
  {
    try
    {
      if (b == null) {
        b = new MobileQQCloseServiceReceiver();
      }
      MobileQQCloseServiceReceiver localMobileQQCloseServiceReceiver = b;
      return localMobileQQCloseServiceReceiver;
    }
    finally {}
  }
  
  private String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = g.a(localStringBuilder.toString());
      return g.a(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.process.exit");
      paramContext.registerReceiver(this, localIntentFilter);
      this.a = true;
    }
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {}
    while (!this.a) {
      return;
    }
    paramContext.unregisterReceiver(this);
    this.a = false;
  }
  
  public String c(Context paramContext)
  {
    ComponentName localComponentName = new ComponentName(paramContext, "com.tencent.tmdownloader.TMAssistantDownloadService");
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(localComponentName, 0);
      if (paramContext != null) {
        return paramContext.processName;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
    return "com.tencent.tmassistantsdk.Service";
  }
  
  public int d(Context paramContext)
  {
    int i = 0;
    String str = c(paramContext);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int k;
    for (int j = 0; i < paramContext.size(); j = k)
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
      int m = ((ActivityManager.RunningAppProcessInfo)localObject).pid;
      localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
      k = j;
      if (str.equals(localObject))
      {
        k.c("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;process name: " + (String)localObject + " pid: " + m);
        k.c("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;killProcess pid-->" + m);
        Process.killProcess(m);
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = 0;
    k.c("MobileQQCloseServiceReceiver", "receive broadcast close all service");
    if ((paramContext != null) && (paramIntent != null))
    {
      localObject = paramIntent.getAction();
      if ((localObject != null) && (((String)localObject).equals("com.tencent.process.exit")) && (paramIntent.getExtras() != null)) {}
    }
    else
    {
      return;
      break label97;
    }
    label46:
    Object localObject = paramIntent.getExtras().getStringArrayList("procNameList");
    paramIntent = paramIntent.getExtras().getString("verify");
    int i;
    if ((paramIntent == null) || (paramIntent.length() == 0)) {
      i = 0;
    }
    for (;;)
    {
      int m;
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        m = 1;
        label97:
        if ((i == 0) || (m == 0)) {
          break label46;
        }
        if (!this.c.isAlive())
        {
          this.c.start();
          this.d = new Handler(this.c.getLooper());
        }
        if (this.d == null) {
          break label46;
        }
        this.d.post(new a(this, paramContext));
        return;
        if ((!paramIntent.equals(a((ArrayList)localObject, false))) && (!paramIntent.equals(a((ArrayList)localObject, true)))) {
          break label248;
        }
        i = 1;
        continue;
      }
      paramIntent = c(paramContext);
      int j = 0;
      for (;;)
      {
        m = j;
        if (k >= ((ArrayList)localObject).size()) {
          break;
        }
        if (paramIntent.equals(((ArrayList)localObject).get(k))) {
          j = 1;
        }
        k += 1;
      }
      label248:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver
 * JD-Core Version:    0.7.0.1
 */