package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class a
{
  private static final String a = "com.tencent.process.exit";
  private static BroadcastReceiver b;
  
  private static String a(ArrayList paramArrayList, boolean paramBoolean)
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
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  static void a()
  {
    IntentFilter localIntentFilter;
    if (b == null)
    {
      b = new a();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName());
    }
    try
    {
      MobileQQ.getMobileQQ().registerReceiver(b, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  static void a(String paramString)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginRuntime.exitProcess");
    }
    Object localObject1 = PluginStatic.a();
    try
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IPluginActivity)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((IPluginActivity)localObject2).IFinish();
        }
      }
      String str;
      return;
    }
    catch (Exception localException)
    {
      str = MobileQQ.getMobileQQ().getProcessName();
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = new Intent("com.tencent.process.exit");
        ((Intent)localObject2).putExtra("K_EXCEP", paramString);
        ((Intent)localObject2).putExtra("exit_type", 0);
        paramString = new ArrayList();
        paramString.add(str);
        ((Intent)localObject2).putStringArrayListExtra("procNameList", paramString);
        ((Intent)localObject2).putExtra("verify", a(paramString, false));
        MobileQQ.getMobileQQ().sendBroadcast((Intent)localObject2);
      }
    }
  }
  
  static void b()
  {
    if (b != null)
    {
      MobileQQ.getMobileQQ().unregisterReceiver(b);
      b = null;
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
      String str;
      do
      {
        do
        {
          do
          {
            return;
            str = paramIntent.getAction();
            if (DebugHelper.sDebug) {
              DebugHelper.log("PluginRuntime.AccountReceiver.onReceive: " + str);
            }
          } while (paramContext.getPackageName().equals(MobileQQ.processName));
          if (!"mqq.intent.action.ACCOUNT_CHANGED".equals(str)) {
            break;
          }
        } while (paramIntent.getStringExtra("account") == null);
        return;
      } while ((!"mqq.intent.action.LOGOUT".equals(str)) && (!("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName()).equals(str)));
      a.a(paramIntent.getStringExtra("K_EXCEP"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.a
 * JD-Core Version:    0.7.0.1
 */