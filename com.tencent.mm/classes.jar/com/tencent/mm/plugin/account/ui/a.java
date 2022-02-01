package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a
{
  public static boolean a(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(221500);
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(221500);
      return false;
    }
    Log.i("MicroMsg.AccountExpiredUtil", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(221500);
      return false;
      Log.e("MicroMsg.AccountExpiredUtil", "account expired=".concat(String.valueOf(paramInt2)));
      if (!bzg()) {
        com.tencent.mm.ui.base.h.a(paramActivity, r.j.main_err_relogin, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(221012);
            if (this.nbF != null)
            {
              paramActivity.finish();
              paramAnonymousDialogInterface = paramActivity;
              Object localObject = this.nbF;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.ui.base.b.aI(paramActivity, this.nbF);
              t.dp(paramActivity);
            }
            AppMethodBeat.o(221012);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(221500);
        return true;
        if (paramIntent != null)
        {
          paramActivity.finish();
          paramIntent.putExtra("key_errType", paramInt1);
          paramIntent.putExtra("key_errCode", paramInt2);
          paramIntent.putExtra("key_errMsg", MMApplicationContext.getContext().getString(r.j.main_err_relogin));
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aFh(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil", "accountExpired", "(Landroid/app/Activity;IILandroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil", "accountExpired", "(Landroid/app/Activity;IILandroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.aI(paramActivity, paramIntent);
          t.dp(paramActivity);
        }
      }
      Log.e("MicroMsg.AccountExpiredUtil", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, r.j.alpha_version_tip_login, r.j.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(220387);
          if (this.nbF != null)
          {
            paramActivity.finish();
            paramAnonymousDialogInterface = paramActivity;
            Object localObject = this.nbF;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.aI(paramActivity, this.nbF);
            t.dp(paramActivity);
          }
          AppMethodBeat.o(220387);
        }
      });
      AppMethodBeat.o(221500);
      return true;
      Log.e("MicroMsg.AccountExpiredUtil", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      String str;
      if ((!Util.isNullOrNil(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!Util.isNullOrNil(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            Map localMap = XmlParser.parseXml(str, "e", null);
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!Util.isNullOrNil((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (Util.isNullOrNil(paramString)) {
          str = MMApplicationContext.getContext().getString(r.j.main_err_relogin);
        }
        com.tencent.mm.ui.base.h.d(paramActivity, str, MMApplicationContext.getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(221591);
            if (this.nbF != null)
            {
              paramActivity.finish();
              paramAnonymousDialogInterface = paramActivity;
              Object localObject = this.nbF;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.ui.base.b.aI(paramActivity, this.nbF);
              t.dp(paramActivity);
            }
            AppMethodBeat.o(221591);
          }
        });
        AppMethodBeat.o(221500);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      Log.i("MicroMsg.AccountExpiredUtil", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  private static boolean bzg()
  {
    AppMethodBeat.i(221509);
    try
    {
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.waf, false);
      Log.i("MicroMsg.AccountExpiredUtil", "accountExpriredEnable is: %s!!", new Object[] { Boolean.valueOf(bool) });
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        bool = true;
      }
      AppMethodBeat.o(221509);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AccountExpiredUtil", localException, "accountExpriredEnable", new Object[0]);
        boolean bool = false;
      }
    }
  }
  
  public static boolean eh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221502);
    if ((paramInt2 == -100) || (paramInt2 == -2023))
    {
      Log.i("MicroMsg.AccountExpiredUtil", "process,errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(221502);
      return true;
    }
    AppMethodBeat.o(221502);
    return false;
  }
  
  public static boolean ei(int paramInt1, int paramInt2)
  {
    return ((paramInt2 == -100) || (paramInt2 == -2023) || (paramInt2 == -3) || (paramInt2 == -4) || (paramInt2 == -9) || (paramInt2 == -205) || (paramInt2 == -72)) && (paramInt1 == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */