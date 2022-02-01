package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.k;
import java.util.Map;

public final class a
{
  public static boolean a(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(304985);
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(304985);
      return false;
    }
    Log.i("MicroMsg.AccountExpiredUtil", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(304985);
      return false;
      Log.e("MicroMsg.AccountExpiredUtil", "account expired=".concat(String.valueOf(paramInt2)));
      if (!bXV()) {
        k.a(paramActivity, r.j.main_err_relogin, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305221);
            if (a.this != null)
            {
              paramActivity.finish();
              paramAnonymousDialogInterface = paramActivity;
              Object localObject = a.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              b.aR(paramActivity, a.this);
            }
            AppMethodBeat.o(305221);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(304985);
        return true;
        if (paramIntent != null)
        {
          paramActivity.finish();
          paramIntent.putExtra("key_errType", paramInt1);
          paramIntent.putExtra("key_errCode", paramInt2);
          paramIntent.putExtra("key_errMsg", MMApplicationContext.getContext().getString(r.j.main_err_relogin));
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString.aYi(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil", "accountExpired", "(Landroid/app/Activity;IILandroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil", "accountExpired", "(Landroid/app/Activity;IILandroid/content/Intent;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          b.aR(paramActivity, paramIntent);
        }
      }
      Log.e("MicroMsg.AccountExpiredUtil", "account expired=".concat(String.valueOf(paramInt2)));
      k.a(paramActivity, r.j.alpha_version_tip_login, r.j.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(305218);
          if (a.this != null)
          {
            paramActivity.finish();
            paramAnonymousDialogInterface = paramActivity;
            Object localObject = a.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.aR(paramActivity, a.this);
          }
          AppMethodBeat.o(305218);
        }
      });
      AppMethodBeat.o(304985);
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
        k.d(paramActivity, str, MMApplicationContext.getContext().getString(r.j.app_tip), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305224);
            if (a.this != null)
            {
              paramActivity.finish();
              paramAnonymousDialogInterface = paramActivity;
              Object localObject = a.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/account/ui/AccountExpiredUtil$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              b.aR(paramActivity, a.this);
            }
            AppMethodBeat.o(305224);
          }
        });
        AppMethodBeat.o(304985);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      Log.i("MicroMsg.AccountExpiredUtil", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  private static boolean bXV()
  {
    AppMethodBeat.i(304991);
    try
    {
      bool = ((c)h.ax(c.class)).a(c.a.ztH, false);
      Log.i("MicroMsg.AccountExpiredUtil", "accountExpriredEnable is: %s!!", new Object[] { Boolean.valueOf(bool) });
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
        bool = true;
      }
      AppMethodBeat.o(304991);
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
  
  public static boolean fb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304986);
    if ((paramInt2 == -100) || (paramInt2 == -2023))
    {
      Log.i("MicroMsg.AccountExpiredUtil", "process,errType %d,errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(304986);
      return true;
    }
    AppMethodBeat.o(304986);
    return false;
  }
  
  public static boolean fc(int paramInt1, int paramInt2)
  {
    return ((paramInt2 == -100) || (paramInt2 == -2023) || (paramInt2 == -3) || (paramInt2 == -4) || (paramInt2 == -9) || (paramInt2 == -205) || (paramInt2 == -72)) && (paramInt1 == 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.a
 * JD-Core Version:    0.7.0.1
 */