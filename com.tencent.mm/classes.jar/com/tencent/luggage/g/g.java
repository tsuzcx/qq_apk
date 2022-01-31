package com.tencent.luggage.g;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.a;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
{
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(90907);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(90907);
      return true;
    }
    try
    {
      int i = b.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(90907);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      ab.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(90907);
      return true;
    }
    if (!bo.isNullOrNil(paramString3))
    {
      paramString1 = new g.1(paramActivity, paramString1, paramInt);
      String str1 = paramActivity.getString(2131302071);
      String str2 = paramActivity.getString(2131302070);
      paramActivity = new AlertDialog.Builder(paramActivity);
      paramActivity.setMessage(paramString3).setTitle(paramString2).setCancelable(false).setPositiveButton(str1, paramString1).setNegativeButton(str2, null);
      paramActivity.show();
    }
    for (;;)
    {
      AppMethodBeat.o(90907);
      return false;
      a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90908);
    int i;
    try
    {
      i = b.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(90908);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      ab.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(90908);
      return false;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (bo.isNullOrNil(str)) {
        break label128;
      }
    }
    label128:
    for (;;)
    {
      try
      {
        i = b.checkSelfPermission(paramContext, str);
        if (i != 0) {
          break label121;
        }
        AppMethodBeat.o(90908);
        return true;
      }
      catch (Exception paramContext)
      {
        ab.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
        AppMethodBeat.o(90908);
        return false;
      }
      if (!paramString.equals("android.permission.WRITE_CONTACTS")) {
        break;
      }
      str = "android.permission.READ_CONTACTS";
      break;
      label121:
      AppMethodBeat.o(90908);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.g.g
 * JD-Core Version:    0.7.0.1
 */