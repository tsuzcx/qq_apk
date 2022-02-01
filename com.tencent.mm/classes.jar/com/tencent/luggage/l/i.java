package com.tencent.luggage.l;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.luggage.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  private static j exa = null;
  
  public static void a(j paramj)
  {
    exa = paramj;
  }
  
  public static boolean a(Activity paramActivity, f paramf, final String paramString1, final int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219978);
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME)))
    {
      AppMethodBeat.o(219978);
      return true;
    }
    if ((exa != null) && (paramf != null) && (exa.cGU()))
    {
      if (exa.a(paramActivity, paramf, paramString1))
      {
        AppMethodBeat.o(219978);
        return true;
      }
      exa.a(paramActivity, paramf, paramString1, new i..ExternalSyntheticLambda0(paramf, paramInt, paramString1));
      AppMethodBeat.o(219978);
      return false;
    }
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(paramActivity, paramString1);
      if (i == 0)
      {
        AppMethodBeat.o(219978);
        return true;
      }
    }
    catch (Exception paramActivity)
    {
      Log.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
      AppMethodBeat.o(219978);
      return true;
    }
    if (!Util.isNullOrNil(paramString3))
    {
      paramf = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(140518);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = i.this;
          String str = paramString1;
          paramAnonymousInt = paramInt;
          androidx.core.app.a.a(paramAnonymousDialogInterface, new String[] { str }, paramAnonymousInt);
          AppMethodBeat.o(140518);
        }
      };
      paramString1 = paramActivity.getString(a.g.permission_dialog_ok);
      String str = paramActivity.getString(a.g.permission_dialog_cancel);
      paramActivity = new AlertDialog.Builder(paramActivity);
      paramActivity.setMessage(paramString3).setTitle(paramString2).setCancelable(false).setPositiveButton(paramString1, paramf).setNegativeButton(str, null);
      paramActivity.show();
    }
    for (;;)
    {
      AppMethodBeat.o(219978);
      return false;
      androidx.core.app.a.a(paramActivity, new String[] { paramString1 }, paramInt);
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219969);
    boolean bool = a(paramActivity, null, paramString1, 115, paramString2, paramString3);
    AppMethodBeat.o(219969);
    return bool;
  }
  
  public static boolean a(Context paramContext, f paramf, String paramString)
  {
    AppMethodBeat.i(219988);
    if ((exa != null) && (paramf != null) && (exa.cGU()))
    {
      boolean bool = exa.a((Activity)paramContext, paramf, paramString);
      AppMethodBeat.o(219988);
      return bool;
    }
    int i;
    try
    {
      i = androidx.core.content.a.checkSelfPermission(paramContext, paramString);
      if (i != 0)
      {
        AppMethodBeat.o(219988);
        return false;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(219988);
      return false;
    }
    if (!Util.isNullOrNil(null)) {}
    try
    {
      i = androidx.core.content.a.checkSelfPermission(paramContext, null);
      if (i == 0)
      {
        AppMethodBeat.o(219988);
        return true;
      }
    }
    catch (Exception paramContext)
    {
      Log.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
      AppMethodBeat.o(219988);
      return false;
    }
    AppMethodBeat.o(219988);
    return false;
  }
  
  public static boolean s(Context paramContext, String paramString)
  {
    AppMethodBeat.i(140520);
    boolean bool = a(paramContext, null, paramString);
    AppMethodBeat.o(140520);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.l.i
 * JD-Core Version:    0.7.0.1
 */