package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.broadcast.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u.a;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.plugin.account.friend.model.i.a;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;

public final class v
{
  public static void Sj(String paramString)
  {
    AppMethodBeat.i(127747);
    bg.okT.bc("login_user_name", paramString);
    AppMethodBeat.o(127747);
  }
  
  public static void a(Context paramContext, u.a parama, int paramInt)
  {
    AppMethodBeat.i(127750);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.hFb);
    paramContext.putExtra("KVoiceHelpUrl", parama.oSR);
    paramContext.putExtra("KVoiceHelpWording", parama.wording);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.oSS != null) {
      paramContext.getExtras().putAll(parama.oSS);
    }
    AppMethodBeat.o(127750);
  }
  
  public static void ei(Context paramContext)
  {
    AppMethodBeat.i(127748);
    String str1 = paramContext.getString(r.j.alpha_version_tip_login);
    String str2 = paramContext.getString(r.j.alpha_version_open_offical_url);
    k.b(paramContext, str1, "", paramContext.getString(r.j.confirm_dialog_ok), paramContext.getString(r.j.confirm_dialog_cancel), new v.3(str2, paramContext), null);
    AppMethodBeat.o(127748);
  }
  
  public static void f(Context paramContext, String paramString, final int paramInt)
  {
    AppMethodBeat.i(127751);
    final com.tencent.mm.broadcast.a locala = com.tencent.mm.broadcast.a.CH(paramString);
    if (locala != null)
    {
      if (locala.hAN == 8)
      {
        com.tencent.mm.plugin.account.sdk.c.a.b(paramContext, locala.url, paramInt, false);
        AppMethodBeat.o(127751);
        return;
      }
      Object localObject1 = locala.lvp.lvB;
      Object localObject2 = locala.lvp.lvC;
      paramString = (String)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramString = paramContext.getString(r.j.app_ok);
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramContext.getString(r.j.app_cancel);
      }
      localObject2 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127744);
          com.tencent.mm.plugin.account.sdk.c.a.b(v.this, locala.url, paramInt, false);
          AppMethodBeat.o(127744);
        }
      };
      if ((locala.hAN == 1) || (locala.hAN == 4))
      {
        if (Util.isNullOrNil(locala.url))
        {
          k.c(paramContext, locala.desc, locala.hAP, true);
          AppMethodBeat.o(127751);
          return;
        }
        k.b(paramContext, locala.desc, locala.hAP, paramString, (String)localObject1, (DialogInterface.OnClickListener)localObject2, null);
      }
      AppMethodBeat.o(127751);
      return;
    }
    AppMethodBeat.o(127751);
  }
  
  public static void r(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127749);
    paramString1 = com.tencent.mm.broadcast.a.CH(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new v.4(paramString2, paramContext), null);
    }
    AppMethodBeat.o(127749);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127745);
    if ((i.bWW() != i.a.pSQ) && (i.bWW() != i.a.pSR)) {
      Log.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    do
    {
      for (;;)
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(127745);
        return;
        if (Util.nullAsFalse((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12322, null)))
        {
          Log.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
        }
        else if ((!paramBoolean) && (Util.nullAsFalse((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12323, null))))
        {
          Log.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
        }
        else
        {
          i.hN(false);
          Log.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", new Object[] { Util.getStack() });
          String str = Util.nullAsNil(Util.getLine1Number(paramActivity));
          if ((str.length() <= 0) || (!str.equals(com.tencent.mm.kernel.h.baE().ban().d(6, null)))) {
            break;
          }
          i.hN(true);
          Log.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
        }
      }
    } while (paramInt == 2);
    k.a(paramActivity, r.j.bind_mcontact_bind_alert_content, r.j.app_tip, r.j.app_yes, r.j.app_no, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127740);
        Log.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.lyQ) });
        com.tencent.mm.plugin.report.service.h.OAn.b(11438, new Object[] { Integer.valueOf(this.lyQ) });
        i.hN(true);
        v.syncUploadMContactStatus(true, false);
        a.bTl();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127740);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127741);
        i.hN(false);
        v.syncUploadMContactStatus(false, false);
        if (v.this != null) {
          v.this.run();
        }
        paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127741);
      }
    });
    com.tencent.mm.kernel.h.baE().ban().B(12323, Boolean.TRUE);
    AppMethodBeat.o(127745);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127746);
    int i = z.bAQ();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      Log.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      com.tencent.mm.kernel.h.baE().ban().B(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      cas localcas = new cas();
      localcas.aajJ = 17;
      localcas.NkL = i;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, localcas));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.sdk.a.pFo.aDx();
      }
      AppMethodBeat.o(127746);
      return;
      i |= 0x20000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.v
 * JD-Core Version:    0.7.0.1
 */