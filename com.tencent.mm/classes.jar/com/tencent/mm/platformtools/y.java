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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class y
{
  public static void BD(String paramString)
  {
    AppMethodBeat.i(127747);
    ay.gNa.aD("login_user_name", paramString);
    AppMethodBeat.o(127747);
  }
  
  public static void a(Context paramContext, s.a parama, int paramInt)
  {
    AppMethodBeat.i(127750);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.dgo);
    paramContext.putExtra("KVoiceHelpUrl", parama.hsk);
    paramContext.putExtra("KVoiceHelpWording", parama.doh);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.hsl != null) {
      paramContext.getExtras().putAll(parama.hsl);
    }
    AppMethodBeat.o(127750);
  }
  
  public static void cV(final Context paramContext)
  {
    AppMethodBeat.i(127748);
    String str1 = paramContext.getString(2131755265);
    String str2 = paramContext.getString(2131755264);
    com.tencent.mm.ui.base.h.d(paramContext, str1, "", paramContext.getString(2131757560), paramContext.getString(2131757558), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127742);
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.putExtra("rawUrl", this.hUL);
        paramAnonymousDialogInterface.putExtra("showShare", false);
        paramAnonymousDialogInterface.putExtra("show_bottom", false);
        paramAnonymousDialogInterface.putExtra("needRedirect", false);
        paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
        paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
        paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
        com.tencent.mm.plugin.account.a.a.hYt.i(paramAnonymousDialogInterface, paramContext);
        AppMethodBeat.o(127742);
      }
    }, null);
    AppMethodBeat.o(127748);
  }
  
  public static void g(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(127751);
    paramString = com.tencent.mm.h.a.oG(paramString);
    if (paramString != null)
    {
      if (paramString.dcz == 8)
      {
        com.tencent.mm.plugin.account.a.b.a.b(paramContext, paramString.url, paramInt, false);
        AppMethodBeat.o(127751);
        return;
      }
      String str1 = paramContext.getString(2131755835);
      String str2 = paramContext.getString(2131755691);
      DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127744);
          com.tencent.mm.plugin.account.a.b.a.b(this.val$context, paramString.url, paramInt, false);
          AppMethodBeat.o(127744);
        }
      };
      if ((paramString.dcz == 1) || (paramString.dcz == 4))
      {
        if (bt.isNullOrNil(paramString.url))
        {
          com.tencent.mm.ui.base.h.c(paramContext, paramString.desc, paramString.Title, true);
          AppMethodBeat.o(127751);
          return;
        }
        com.tencent.mm.ui.base.h.d(paramContext, paramString.desc, paramString.Title, str1, str2, local5, null);
      }
      AppMethodBeat.o(127751);
      return;
    }
    AppMethodBeat.o(127751);
  }
  
  public static void m(final Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127749);
    paramString1 = com.tencent.mm.h.a.oG(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127743);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", this.hUL);
          paramAnonymousDialogInterface.putExtra("showShare", false);
          paramAnonymousDialogInterface.putExtra("show_bottom", false);
          paramAnonymousDialogInterface.putExtra("needRedirect", false);
          paramAnonymousDialogInterface.putExtra("neverGetA8Key", true);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
          com.tencent.mm.plugin.account.a.a.hYt.i(paramAnonymousDialogInterface, paramContext);
          AppMethodBeat.o(127743);
        }
      }, null);
    }
    AppMethodBeat.o(127749);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127745);
    if ((com.tencent.mm.plugin.account.friend.a.l.aIL() != l.a.iky) && (com.tencent.mm.plugin.account.friend.a.l.aIL() != l.a.ikz)) {
      ad.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(127745);
      return;
      if (bt.l((Boolean)g.afB().afk().get(12322, null)))
      {
        ad.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (bt.l((Boolean)g.afB().afk().get(12323, null))))
      {
        ad.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        com.tencent.mm.plugin.account.friend.a.l.eT(false);
        ad.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", new Object[] { bt.eGN() });
        String str = bt.nullAsNil(bt.iK(paramActivity));
        if ((str.length() <= 0) || (!str.equals(g.afB().afk().get(6, null)))) {
          break;
        }
        com.tencent.mm.plugin.account.friend.a.l.eT(true);
        ad.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.h.b(paramActivity, 2131756445, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127740);
        ad.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.fpl) });
        com.tencent.mm.plugin.report.service.h.vKh.f(11438, new Object[] { Integer.valueOf(this.fpl) });
        com.tencent.mm.plugin.account.friend.a.l.eT(true);
        y.syncUploadMContactStatus(true, false);
        a.aGl();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(aj.eFD(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127740);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127741);
        com.tencent.mm.plugin.account.friend.a.l.eT(false);
        y.syncUploadMContactStatus(false, false);
        if (this.hUK != null) {
          this.hUK.run();
        }
        paramActivity.getSharedPreferences(aj.eFD(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127741);
      }
    });
    g.afB().afk().set(12323, Boolean.TRUE);
    AppMethodBeat.o(127745);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127746);
    int i = u.aqK();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      ad.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      g.afB().afk().set(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      amy localamy = new amy();
      localamy.DnY = 17;
      localamy.uMR = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(23, localamy));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.a.a.hYu.Ll();
      }
      AppMethodBeat.o(127746);
      return;
      i |= 0x20000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.y
 * JD-Core Version:    0.7.0.1
 */