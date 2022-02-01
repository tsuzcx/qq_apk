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

public final class d
{
  public static Intent a(Context paramContext, ComponentName paramComponentName)
  {
    AppMethodBeat.i(196361);
    String str = b(paramContext, paramComponentName);
    if (str == null)
    {
      AppMethodBeat.o(196361);
      return null;
    }
    paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
    if (b(paramContext, paramComponentName) == null)
    {
      paramContext = Intent.makeMainActivity(paramComponentName);
      AppMethodBeat.o(196361);
      return paramContext;
    }
    paramContext = new Intent().setComponent(paramComponentName);
    AppMethodBeat.o(196361);
    return paramContext;
  }
  
  public static boolean a(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(196333);
    if (Build.VERSION.SDK_INT >= 16)
    {
      boolean bool = paramActivity.shouldUpRecreateTask(paramIntent);
      AppMethodBeat.o(196333);
      return bool;
    }
    paramActivity = paramActivity.getIntent().getAction();
    if ((paramActivity != null) && (!paramActivity.equals("android.intent.action.MAIN")))
    {
      AppMethodBeat.o(196333);
      return true;
    }
    AppMethodBeat.o(196333);
    return false;
  }
  
  private static String b(Context paramContext, ComponentName paramComponentName)
  {
    AppMethodBeat.i(196388);
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
      AppMethodBeat.o(196388);
      return localObject;
      if (Build.VERSION.SDK_INT >= 24) {
        i = 787072;
      }
    }
    if (paramComponentName.metaData == null)
    {
      AppMethodBeat.o(196388);
      return null;
    }
    localObject = paramComponentName.metaData.getString("android.support.PARENT_ACTIVITY");
    if (localObject == null)
    {
      AppMethodBeat.o(196388);
      return null;
    }
    paramComponentName = (ComponentName)localObject;
    if (((String)localObject).charAt(0) == '.') {
      paramComponentName = paramContext.getPackageName() + (String)localObject;
    }
    AppMethodBeat.o(196388);
    return paramComponentName;
  }
  
  public static void b(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(196342);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.navigateUpTo(paramIntent);
      AppMethodBeat.o(196342);
      return;
    }
    paramIntent.addFlags(67108864);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "androidx/core/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "androidx/core/app/NavUtils", "navigateUpTo", "(Landroid/app/Activity;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.finish();
    AppMethodBeat.o(196342);
  }
  
  public static Intent f(Activity paramActivity)
  {
    AppMethodBeat.i(196351);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject = paramActivity.getParentActivityIntent();
      if (localObject != null)
      {
        AppMethodBeat.o(196351);
        return localObject;
      }
    }
    Object localObject = g(paramActivity);
    if (localObject == null)
    {
      AppMethodBeat.o(196351);
      return null;
    }
    ComponentName localComponentName = new ComponentName(paramActivity, (String)localObject);
    try
    {
      if (b(paramActivity, localComponentName) == null)
      {
        paramActivity = Intent.makeMainActivity(localComponentName);
        AppMethodBeat.o(196351);
        return paramActivity;
      }
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      new StringBuilder("getParentActivityIntent: bad parentActivityName '").append((String)localObject).append("' in manifest");
      AppMethodBeat.o(196351);
      return null;
    }
    paramActivity = new Intent().setComponent(localComponentName);
    AppMethodBeat.o(196351);
    return paramActivity;
  }
  
  public static String g(Activity paramActivity)
  {
    AppMethodBeat.i(196374);
    try
    {
      paramActivity = b(paramActivity, paramActivity.getComponentName());
      AppMethodBeat.o(196374);
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      paramActivity = new IllegalArgumentException(paramActivity);
      AppMethodBeat.o(196374);
      throw paramActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.app.d
 * JD-Core Version:    0.7.0.1
 */