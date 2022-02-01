package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static Intent a(Context paramContext, ComponentName paramComponentName)
  {
    AppMethodBeat.i(250245);
    String str = b(paramContext, paramComponentName);
    if (str == null)
    {
      AppMethodBeat.o(250245);
      return null;
    }
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    if (b(paramContext, paramComponentName) == null)
    {
      paramContext = Intent.makeMainActivity(paramComponentName);
      AppMethodBeat.o(250245);
      return paramContext;
    }
    paramContext = new Intent().setComponent(paramComponentName);
    AppMethodBeat.o(250245);
    return paramContext;
  }
  
  private static String b(Context paramContext, ComponentName paramComponentName)
  {
    AppMethodBeat.i(250247);
    Object localObject = paramContext.getPackageManager();
    int i = Build.VERSION.SDK_INT;
    i = 640;
    if (Build.VERSION.SDK_INT >= 29) {
      i = 269222528;
    }
    for (;;)
    {
      paramComponentName = ((PackageManager)localObject).getActivityInfo(paramComponentName, i);
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      localObject = paramComponentName.parentActivityName;
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(250247);
      return localObject;
      if (Build.VERSION.SDK_INT >= 24) {
        i = 787072;
      }
    }
    if (paramComponentName.metaData == null)
    {
      AppMethodBeat.o(250247);
      return null;
    }
    localObject = paramComponentName.metaData.getString("android.support.PARENT_ACTIVITY");
    if (localObject == null)
    {
      AppMethodBeat.o(250247);
      return null;
    }
    paramComponentName = (ComponentName)localObject;
    if (((String)localObject).charAt(0) == '.') {
      paramComponentName = paramContext.getPackageName() + (String)localObject;
    }
    AppMethodBeat.o(250247);
    return paramComponentName;
  }
  
  public static Intent f(Activity paramActivity)
  {
    AppMethodBeat.i(250244);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = paramActivity.getParentActivityIntent();
      if (localObject != null)
      {
        AppMethodBeat.o(250244);
        return localObject;
      }
    }
    Object localObject = g(paramActivity);
    if (localObject == null)
    {
      AppMethodBeat.o(250244);
      return null;
    }
    ComponentName localComponentName = new ComponentName(paramActivity, (String)localObject);
    try
    {
      if (b(paramActivity, localComponentName) == null)
      {
        paramActivity = Intent.makeMainActivity(localComponentName);
        AppMethodBeat.o(250244);
        return paramActivity;
      }
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      new StringBuilder("getParentActivityIntent: bad parentActivityName '").append((String)localObject).append("' in manifest");
      AppMethodBeat.o(250244);
      return null;
    }
    paramActivity = new Intent().setComponent(localComponentName);
    AppMethodBeat.o(250244);
    return paramActivity;
  }
  
  public static String g(Activity paramActivity)
  {
    AppMethodBeat.i(250246);
    try
    {
      paramActivity = b(paramActivity, paramActivity.getComponentName());
      AppMethodBeat.o(250246);
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      paramActivity = new IllegalArgumentException(paramActivity);
      AppMethodBeat.o(250246);
      throw paramActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.app.c
 * JD-Core Version:    0.7.0.1
 */