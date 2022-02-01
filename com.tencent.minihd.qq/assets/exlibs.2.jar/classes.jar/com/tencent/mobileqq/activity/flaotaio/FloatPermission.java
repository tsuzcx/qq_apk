package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.util.List;

public class FloatPermission
{
  public static boolean a()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi");
  }
  
  public static boolean a(Context paramContext)
  {
    if (a())
    {
      if (b(paramContext)) {
        try
        {
          localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
          localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
          localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
          localIntent.setFlags(276824064);
          paramContext.startActivity(localIntent);
          return true;
        }
        catch (Exception paramContext)
        {
          return false;
        }
      }
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
      localIntent.setFlags(276824064);
      try
      {
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.i("app2", "open app detail error", paramContext);
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, Intent paramIntent)
  {
    return paramContext.getPackageManager().queryIntentActivities(paramIntent, 1).size() > 0;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    if (a(paramContext, localIntent)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatPermission
 * JD-Core Version:    0.7.0.1
 */