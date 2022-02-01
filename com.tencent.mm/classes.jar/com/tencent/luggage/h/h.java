package com.tencent.luggage.h;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.a;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
{
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140519);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(140519);
      return true;
    }
    try
    {
      int i = b.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(140519);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      ac.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(140519);
      return true;
    }
    if (!bs.isNullOrNil(paramString3))
    {
      paramString1 = new h.1(paramActivity, paramString1, paramInt);
      String str1 = paramActivity.getString(2131761864);
      String str2 = paramActivity.getString(2131761863);
      paramActivity = new AlertDialog.Builder(paramActivity);
      paramActivity.setMessage(paramString3).setTitle(paramString2).setCancelable(false).setPositiveButton(str1, paramString1).setNegativeButton(str2, null);
      paramActivity.show();
    }
    for (;;)
    {
      AppMethodBeat.o(140519);
      return false;
      a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(140520);
    int i;
    try
    {
      i = b.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(140520);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      ac.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(140520);
      return false;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (bs.isNullOrNil(str)) {
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
        AppMethodBeat.o(140520);
        return true;
      }
      catch (Exception paramContext)
      {
        ac.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
        AppMethodBeat.o(140520);
        return false;
      }
      if (!paramString.equals("android.permission.WRITE_CONTACTS")) {
        break;
      }
      str = "android.permission.READ_CONTACTS";
      break;
      label121:
      AppMethodBeat.o(140520);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.h
 * JD-Core Version:    0.7.0.1
 */