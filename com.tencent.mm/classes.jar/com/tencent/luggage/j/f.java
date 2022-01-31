package com.tencent.luggage.j;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.a;
import android.support.v4.content.b;
import com.tencent.luggage.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
{
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME))) {
      return true;
    }
    for (;;)
    {
      try
      {
        int i = b.checkSelfPermission(paramActivity, paramString1);
        if (i == 0) {
          break;
        }
        if (!bk.bl(paramString3))
        {
          paramString1 = new f.1(paramActivity, paramString1, paramInt);
          String str1 = paramActivity.getString(a.c.permission_dialog_ok);
          String str2 = paramActivity.getString(a.c.permission_dialog_cancel);
          paramActivity = new AlertDialog.Builder(paramActivity);
          paramActivity.setMessage(paramString3).setTitle(paramString2).setCancelable(false).setPositiveButton(str1, paramString1).setNegativeButton(str2, null);
          paramActivity.show();
          return false;
        }
      }
      catch (Exception paramActivity)
      {
        y.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
        return true;
      }
      a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean j(Context paramContext, String paramString)
  {
    int i;
    try
    {
      i = b.checkSelfPermission(paramContext, paramString);
      if (i != 0) {
        return false;
      }
    }
    catch (Exception paramContext)
    {
      y.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      return false;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (bk.bl(str)) {
        break label98;
      }
    }
    label96:
    label98:
    for (;;)
    {
      try
      {
        i = b.checkSelfPermission(paramContext, str);
        if (i != 0) {
          break label96;
        }
        return true;
      }
      catch (Exception paramContext)
      {
        y.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
        return false;
      }
      if (!paramString.equals("android.permission.WRITE_CONTACTS")) {
        break;
      }
      str = "android.permission.READ_CONTACTS";
      break;
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.j.f
 * JD-Core Version:    0.7.0.1
 */