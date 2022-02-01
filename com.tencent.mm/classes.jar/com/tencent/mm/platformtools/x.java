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
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class x
{
  private Runnable jNB;
  private boolean jNC = false;
  
  private void d(Activity paramActivity, Runnable paramRunnable)
  {
    AppMethodBeat.i(169126);
    boolean bool = b.a(paramActivity, "android.permission.READ_PHONE_STATE", 96, "", "");
    Log.i("MicroMsg.PermissionCheckHelper", "check init, summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      e.Cxv.idkeyStat(462L, 20L, 1L, true);
      this.jNB = paramRunnable;
      AppMethodBeat.o(169126);
      return;
    }
    q.aoy();
    if (paramRunnable != null) {
      paramRunnable.run();
    }
    AppMethodBeat.o(169126);
  }
  
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
        e.Cxv.idkeyStat(462L, 19L, 1L, true);
        if (paramInt != 32) {
          break label308;
        }
        d(paramActivity, this.jNB);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(169127);
      return true;
      if (paramInt != 96) {
        break;
      }
      e.Cxv.idkeyStat(462L, 21L, 1L, true);
      q.aoH();
      q.aoy();
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
      if (this.jNB != null) {
        this.jNB.run();
      }
    }
  }
  
  public final void b(final Activity paramActivity, final Runnable paramRunnable)
  {
    int i = 0;
    AppMethodBeat.i(169124);
    if (!this.jNC) {
      if (!b.e(paramActivity, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" }))
      {
        this.jNC = true;
        h.a(paramActivity, paramActivity.getString(2131763872), paramActivity.getString(2131763890), paramActivity.getString(2131763873), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(161688);
            x.this.c(paramActivity, paramRunnable);
            AppMethodBeat.o(161688);
          }
        });
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(169124);
      return;
      i = 1;
    }
    c(paramActivity, paramRunnable);
    AppMethodBeat.o(169124);
  }
  
  final void c(Activity paramActivity, Runnable paramRunnable)
  {
    AppMethodBeat.i(169125);
    boolean bool = b.a(paramActivity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "");
    Log.i("MicroMsg.PermissionCheckHelper", "check init, summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      e.Cxv.idkeyStat(462L, 18L, 1L, true);
      this.jNB = paramRunnable;
      AppMethodBeat.o(169125);
      return;
    }
    d(paramActivity, paramRunnable);
    AppMethodBeat.o(169125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.x
 * JD-Core Version:    0.7.0.1
 */