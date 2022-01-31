package android.support.v4.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Process;

public final class f
{
  public static int a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1) {}
    do
    {
      return -1;
      if (Build.VERSION.SDK_INT >= 23) {}
      for (paramString1 = AppOpsManager.permissionToOp(paramString1); paramString1 == null; paramString1 = null) {
        return 0;
      }
      str = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString2 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
    } while ((paramString2 == null) || (paramString2.length <= 0));
    String str = paramString2[0];
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramInt1 = ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, str); paramInt1 != 0; paramInt1 = 1) {
      return -2;
    }
    return 0;
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
  
  public static int f(Context paramContext, String paramString)
  {
    if (Binder.getCallingPid() == Process.myPid()) {}
    for (String str = paramContext.getPackageName();; str = null) {
      return a(paramContext, paramString, Binder.getCallingPid(), Binder.getCallingUid(), str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.f
 * JD-Core Version:    0.7.0.1
 */