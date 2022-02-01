package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public final class u
{
  Runnable pBm;
  
  public final boolean a(Activity paramActivity, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169127);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      if (paramArrayOfInt == null) {}
      for (int i = -1;; i = paramArrayOfInt.length)
      {
        Log.w("MicroMsg.PermissionCheckHelper", "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, Util.getStack() });
        AppMethodBeat.o(169127);
        return true;
      }
    }
    Log.i("MicroMsg.PermissionCheckHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(169127);
      return false;
    }
    if (paramArrayOfInt[0] == 0) {
      if (paramInt == 32)
      {
        f.Ozc.idkeyStat(462L, 19L, 1L, true);
        if (paramInt != 32) {
          break label308;
        }
        c(paramActivity, this.pBm);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(169127);
      return true;
      if (paramInt != 96) {
        break;
      }
      f.Ozc.idkeyStat(462L, 21L, 1L, true);
      q.aPh();
      q.aOX();
      break;
      paramArrayOfInt = paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
      SharedPreferences.Editor localEditor = paramArrayOfInt.edit();
      if (paramInt == 32) {}
      for (paramArrayOfString = "SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE";; paramArrayOfString = "SP_PERMISSION_HAD_REQUEST_PERMISSION_PHONE")
      {
        localEditor.putBoolean(paramArrayOfString, true).apply();
        paramArrayOfInt.edit().putInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", MMApplicationContext.getContext().getApplicationInfo().uid).apply();
        break;
      }
      label308:
      if (this.pBm != null) {
        this.pBm.run();
      }
    }
  }
  
  public final void b(final Activity paramActivity, final Runnable paramRunnable)
  {
    int j = 1;
    AppMethodBeat.i(169124);
    int i = j;
    if (!MultiProcessMMKV.getDefault().getBoolean("had_show_permission_guild", true))
    {
      i = j;
      if (!b.g(paramActivity, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" }))
      {
        k.a(paramActivity, r.j.permission_launcher_guide, r.j.permission_tips_title, r.j.permission_launcher_guide_i_know, r.j.app_cancel, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(161688);
            MultiProcessMMKV.getDefault().putBoolean("had_show_permission_guild", true).apply();
            paramAnonymousDialogInterface = u.this;
            Activity localActivity = paramActivity;
            Runnable localRunnable = paramRunnable;
            boolean bool = b.a(localActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "");
            Log.i("MicroMsg.PermissionCheckHelper", "check init, summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
            if (!bool)
            {
              f.Ozc.idkeyStat(462L, 18L, 1L, true);
              paramAnonymousDialogInterface.pBm = localRunnable;
              AppMethodBeat.o(161688);
              return;
            }
            paramAnonymousDialogInterface.c(localActivity, localRunnable);
            AppMethodBeat.o(161688);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(161689);
            AppMethodBeat.o(161689);
          }
        });
        i = 0;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(169124);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(169124);
  }
  
  final void c(Activity paramActivity, Runnable paramRunnable)
  {
    AppMethodBeat.i(169126);
    boolean bool = b.a(paramActivity, "android.permission.READ_PHONE_STATE", 96, "");
    Log.i("MicroMsg.PermissionCheckHelper", "check init, summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      f.Ozc.idkeyStat(462L, 20L, 1L, true);
      this.pBm = paramRunnable;
      AppMethodBeat.o(169126);
      return;
    }
    q.aOX();
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(169126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.u
 * JD-Core Version:    0.7.0.1
 */