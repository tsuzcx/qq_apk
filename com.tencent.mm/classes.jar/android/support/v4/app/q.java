package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class q
{
  public static Intent a(Context paramContext, ComponentName paramComponentName)
  {
    String str = b(paramContext, paramComponentName);
    if (str == null) {
      return null;
    }
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    if (b(paramContext, paramComponentName) == null) {
      return Intent.makeMainActivity(paramComponentName);
    }
    return new Intent().setComponent(paramComponentName);
  }
  
  private static String b(Context paramContext, ComponentName paramComponentName)
  {
    Object localObject = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramComponentName = ((ActivityInfo)localObject).parentActivityName;
      if (paramComponentName == null) {}
    }
    do
    {
      return paramComponentName;
      if (((ActivityInfo)localObject).metaData == null) {
        return null;
      }
      localObject = ((ActivityInfo)localObject).metaData.getString("android.support.PARENT_ACTIVITY");
      if (localObject == null) {
        return null;
      }
      paramComponentName = (ComponentName)localObject;
    } while (((String)localObject).charAt(0) != '.');
    return paramContext.getPackageName() + (String)localObject;
  }
  
  public static Intent h(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = paramActivity.getParentActivityIntent();
      if (localObject != null) {
        return localObject;
      }
    }
    Object localObject = i(paramActivity);
    if (localObject == null) {
      return null;
    }
    ComponentName localComponentName = new ComponentName(paramActivity, (String)localObject);
    try
    {
      if (b(paramActivity, localComponentName) == null) {
        return Intent.makeMainActivity(localComponentName);
      }
      paramActivity = new Intent().setComponent(localComponentName);
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      new StringBuilder("getParentActivityIntent: bad parentActivityName '").append((String)localObject).append("' in manifest");
    }
    return null;
  }
  
  public static String i(Activity paramActivity)
  {
    try
    {
      paramActivity = b(paramActivity, paramActivity.getComponentName());
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      throw new IllegalArgumentException(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.q
 * JD-Core Version:    0.7.0.1
 */