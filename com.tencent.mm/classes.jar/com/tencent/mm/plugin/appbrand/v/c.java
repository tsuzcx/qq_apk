package com.tencent.mm.plugin.appbrand.v;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.j.h;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static final Set<Object> geC = new HashSet();
  private static final String hle = ;
  private static final char[] hlf = { 60, 62, 34, 39, 38, 32, 39 };
  private static final String[] hlg = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;" };
  
  @Deprecated
  public static ai DS()
  {
    return n.DS();
  }
  
  public static <T> T aU(T paramT)
  {
    if (paramT != null) {
      geC.add(paramT);
    }
    return paramT;
  }
  
  public static void aa(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    geC.remove(paramObject);
  }
  
  @Deprecated
  public static void aqp() {}
  
  public static void aqu()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(hle, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    ae.getContext().sendBroadcast(localIntent);
    localIntent = new Intent();
    localIntent.setComponent(new ComponentName(hle, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    ae.getContext().sendBroadcast(localIntent);
  }
  
  public static long aqv()
  {
    return bk.UX();
  }
  
  public static String b(ComponentName paramComponentName)
  {
    if (paramComponentName == null) {}
    for (;;)
    {
      return "[UNKNOWN]";
      PackageManager localPackageManager = ae.getContext().getPackageManager();
      if (localPackageManager != null) {
        try
        {
          paramComponentName = localPackageManager.getActivityInfo(paramComponentName, 128);
          if (paramComponentName != null)
          {
            paramComponentName = paramComponentName.taskAffinity;
            return paramComponentName;
          }
        }
        catch (Exception paramComponentName)
        {
          y.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[] { paramComponentName });
        }
      }
    }
    return "[UNKNOWN]";
  }
  
  @Deprecated
  public static void c(Map paramMap)
  {
    h.c(paramMap);
  }
  
  public static int cz(Context paramContext)
  {
    return Math.round(paramContext.getResources().getDisplayMetrics().density * 1.0F);
  }
  
  public static String getMMString(int paramInt, Object... paramVarArgs)
  {
    return ae.getResources().getString(paramInt, paramVarArgs);
  }
  
  @Deprecated
  public static void runOnUiThread(Runnable paramRunnable)
  {
    n.runOnUiThread(paramRunnable);
  }
  
  public static String wG(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramString.length();
    int i = 0;
    while (i < m)
    {
      int j = 0;
      while (j < hlf.length)
      {
        String str = hlg[j];
        int k = 0;
        while ((k < str.length()) && (i + k < m) && (str.charAt(k) == paramString.charAt(i + k))) {
          k += 1;
        }
        if (k == str.length()) {
          break;
        }
        j += 1;
      }
      if (j != hlf.length)
      {
        localStringBuffer.append(hlf[j]);
        i = hlg[j].length() + i;
      }
      else
      {
        localStringBuffer.append(paramString.charAt(i));
        i += 1;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String wH(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace(' ', '\n').replace(' ', '\n');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c
 * JD-Core Version:    0.7.0.1
 */