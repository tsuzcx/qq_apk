package com.tencent.mobileqq.msf.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.qphone.base.remote.IBaseService.Stub;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MsfService
  extends Service
{
  public static MsfCore core = new MsfCore();
  public static volatile boolean inited = false;
  static HashSet invalidUids = new HashSet();
  static e msfServiceReqHandler = new e();
  static g msfServiceRespHandler;
  static HashSet passedUids = new HashSet();
  public static volatile boolean sIsCreatedByAutoBoot = false;
  public static final String tag = "MSF.S.MsfService";
  private IBaseService.Stub binder = new d(this);
  
  public static MsfCore getCore()
  {
    return core;
  }
  
  public static boolean isSamePackage(Context paramContext, int paramInt, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (invalidUids.contains(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "found invalid uid call " + paramInt);
      }
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (passedUids.contains(Integer.valueOf(paramInt)));
    String[] arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
    paramContext = paramContext.getPackageName();
    int j = arrayOfString.length;
    int i = 0;
    label92:
    if (i < j) {
      if (arrayOfString[i].equals(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.MsfService", 2, "found accountSyncRequest from the same packeName application,");
        }
        passedUids.add(Integer.valueOf(paramInt));
      }
    }
    for (i = 0;; i = 1)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      invalidUids.add(Integer.valueOf(paramInt));
      paramContext = "";
      Object localObject = paramContext;
      if (arrayOfString != null)
      {
        i = arrayOfString.length;
        paramInt = 0;
        for (;;)
        {
          localObject = paramContext;
          if (paramInt >= i) {
            break;
          }
          localObject = arrayOfString[paramInt];
          paramContext = paramContext + " " + (String)localObject + ";";
          paramInt += 1;
        }
        i += 1;
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "found invalid uid call " + (String)localObject);
      }
      try
      {
        paramContext = new HashMap();
        paramContext.put("param_Reason", localObject);
        paramContext.put("method", paramString);
        core.getStatReporter().a("dim.Msf.invaildAppCall", true, 0L, 0L, paramContext, false, false);
        return false;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.S.MsfService", 2, "send invaild call error " + paramContext, paramContext);
          }
        }
      }
    }
  }
  
  public static void serviceInit(Context paramContext, boolean paramBoolean)
  {
    try
    {
      if (!inited)
      {
        core.init(paramContext, paramBoolean);
        c.a(paramContext, core);
        msfServiceRespHandler = new g(core);
        msfServiceRespHandler.setName("MsfServiceRespHandler");
        msfServiceRespHandler.start();
        inited = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void startForegroundCompat()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        startForeground(9527, new Notification());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void stopForegroundCompat()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        stopForeground(true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void handleAccountSyncRequest(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.S.MsfService", 2, "handleAccountSyncRequest toServiceMsg null!");
      }
    }
    do
    {
      do
      {
        return;
      } while (!paramToServiceMsg.getServiceCmd().equals("cmd_sync_syncuser"));
      try
      {
        core.handleAccountSyncRequest(paramContext, paramToServiceMsg, paramInt);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("MSF.S.MsfService", 2, "handleAccountSyncRequestReport error " + paramContext, paramContext);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Object localObject = null;
    try
    {
      paramIntent = paramIntent.getStringExtra("to_SenderProcessName");
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.MsfService", 2, "serivce onBind by :" + paramIntent);
      }
      if (a.V()) {
        a.a(false);
      }
      return this.binder;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
        paramIntent = localObject;
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    serviceInit(this, sIsCreatedByAutoBoot);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 2, "serivce onCreate... autoBoot[" + sIsCreatedByAutoBoot + "]");
    }
    sIsCreatedByAutoBoot = false;
    startForegroundCompat();
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplication.getContext().unregisterReceiver(core.netConnICenter);
      BaseApplication.getContext().unregisterReceiver(core.getNetFlowStore());
      BaseApplication.getContext().unregisterReceiver(core.getStandyModeManager());
      stopForegroundCompat();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MSF.S.MsfService", 1, "unregisterReceiver failed. " + localException, localException);
      }
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("to_SenderProcessName");
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.MsfService", 2, "serivce onUnbind by :" + str);
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.MsfService
 * JD-Core Version:    0.7.0.1
 */