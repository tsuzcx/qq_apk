package androidx.core.content;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static int a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(195516);
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1)
    {
      AppMethodBeat.o(195516);
      return -1;
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramString1 = AppOpsManager.permissionToOp(paramString1); paramString1 == null; paramString1 = null)
    {
      AppMethodBeat.o(195516);
      return 0;
    }
    String str = paramString2;
    if (paramString2 == null)
    {
      paramString2 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
      if ((paramString2 == null) || (paramString2.length <= 0))
      {
        AppMethodBeat.o(195516);
        return -1;
      }
      str = paramString2[0];
    }
    if (Build.VERSION.SDK_INT >= 23) {}
    for (paramInt1 = ((AppOpsManager)paramContext.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(paramString1, str); paramInt1 != 0; paramInt1 = 1)
    {
      AppMethodBeat.o(195516);
      return -2;
    }
    AppMethodBeat.o(195516);
    return 0;
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195532);
    int i = a(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
    AppMethodBeat.o(195532);
    return i;
  }
  
  public static int d(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(195548);
    if (Binder.getCallingPid() == Process.myPid())
    {
      AppMethodBeat.o(195548);
      return -1;
    }
    int i = a(paramContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2);
    AppMethodBeat.o(195548);
    return i;
  }
  
  public static int h(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195559);
    if (Binder.getCallingPid() == Process.myPid()) {}
    for (String str = paramContext.getPackageName();; str = null)
    {
      int i = a(paramContext, paramString, Binder.getCallingPid(), Binder.getCallingUid(), str);
      AppMethodBeat.o(195559);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.content.c
 * JD-Core Version:    0.7.0.1
 */