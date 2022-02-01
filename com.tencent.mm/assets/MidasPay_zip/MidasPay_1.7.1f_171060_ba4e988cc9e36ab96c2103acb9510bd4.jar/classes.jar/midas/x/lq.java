package midas.x;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;

public class lq
{
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return b(paramContext, paramString);
    }
    return paramContext.checkSelfPermission(paramString) == 0;
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    int i = 0;
    boolean bool1;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getApplicationContext().getPackageName(), 4096).requestedPermissions;
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        try
        {
          if (i >= paramContext.length) {
            break label76;
          }
          bool2 = paramContext[i].equals(paramString);
          if (bool2) {
            bool1 = true;
          }
          i += 1;
        }
        catch (Throwable paramContext) {}
      }
      lc.c("permission compare error", paramContext.toString());
    }
    catch (Throwable paramContext)
    {
      bool1 = false;
    }
    boolean bool2 = bool1;
    label76:
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lq
 * JD-Core Version:    0.7.0.1
 */