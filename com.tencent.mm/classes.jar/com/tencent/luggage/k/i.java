package com.tencent.luggage.k;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.luggage.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  public static boolean a(Activity paramActivity, final String paramString1, final int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140519);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(140519);
      return true;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(140519);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(140519);
      return true;
    }
    if (!Util.isNullOrNil(paramString3))
    {
      paramString1 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(140518);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = this.val$activity;
          String str = paramString1;
          paramAnonymousInt = paramInt;
          androidx.core.app.a.a(paramAnonymousDialogInterface, new String[] { str }, paramAnonymousInt);
          AppMethodBeat.o(140518);
        }
      };
      String str1 = paramActivity.getString(a.g.permission_dialog_ok);
      String str2 = paramActivity.getString(a.g.permission_dialog_cancel);
      paramActivity = new AlertDialog.Builder(paramActivity);
      paramActivity.setMessage(paramString3).setTitle(paramString2).setCancelable(false).setPositiveButton(str1, paramString1).setNegativeButton(str2, null);
      paramActivity.show();
    }
    for (;;)
    {
      AppMethodBeat.o(140519);
      return false;
      androidx.core.app.a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(140520);
    int i;
    try
    {
      i = androidx.core.content.a.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(140520);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(140520);
      return false;
    }
    String str = null;
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      str = "android.permission.WRITE_CONTACTS";
      if (Util.isNullOrNil(str)) {
        break label128;
      }
    }
    label128:
    for (;;)
    {
      try
      {
        i = androidx.core.content.a.checkSelfPermission(paramContext, str);
        if (i != 0) {
          break label121;
        }
        AppMethodBeat.o(140520);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.i
 * JD-Core Version:    0.7.0.1
 */