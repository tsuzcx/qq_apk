package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.h.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.t.a;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class y
{
  public static void ZV(String paramString)
  {
    AppMethodBeat.i(127747);
    bg.ltv.aS("login_user_name", paramString);
    AppMethodBeat.o(127747);
  }
  
  public static void a(Context paramContext, t.a parama, int paramInt)
  {
    AppMethodBeat.i(127750);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.fAo);
    paramContext.putExtra("KVoiceHelpUrl", parama.maa);
    paramContext.putExtra("KVoiceHelpWording", parama.wording);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.mab != null) {
      paramContext.getExtras().putAll(parama.mab);
    }
    AppMethodBeat.o(127750);
  }
  
  public static void dw(Context paramContext)
  {
    AppMethodBeat.i(127748);
    String str1 = paramContext.getString(r.j.alpha_version_tip_login);
    String str2 = paramContext.getString(r.j.alpha_version_open_offical_url);
    com.tencent.mm.ui.base.h.c(paramContext, str1, "", paramContext.getString(r.j.confirm_dialog_ok), paramContext.getString(r.j.confirm_dialog_cancel), new y.3(str2, paramContext), null);
    AppMethodBeat.o(127748);
  }
  
  public static void f(Context paramContext, String paramString, final int paramInt)
  {
    AppMethodBeat.i(127751);
    final com.tencent.mm.h.a locala = com.tencent.mm.h.a.Kb(paramString);
    if (locala != null)
    {
      if (locala.fwp == 8)
      {
        com.tencent.mm.plugin.account.sdk.b.a.b(paramContext, locala.url, paramInt, false);
        AppMethodBeat.o(127751);
        return;
      }
      Object localObject1 = locala.iTk.iTw;
      Object localObject2 = locala.iTk.iTx;
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
          com.tencent.mm.plugin.account.sdk.b.a.b(this.val$context, locala.url, paramInt, false);
          AppMethodBeat.o(127744);
        }
      };
      if ((locala.fwp == 1) || (locala.fwp == 4))
      {
        if (Util.isNullOrNil(locala.url))
        {
          com.tencent.mm.ui.base.h.c(paramContext, locala.desc, locala.fwr, true);
          AppMethodBeat.o(127751);
          return;
        }
        com.tencent.mm.ui.base.h.c(paramContext, locala.desc, locala.fwr, paramString, (String)localObject1, (DialogInterface.OnClickListener)localObject2, null);
      }
      AppMethodBeat.o(127751);
      return;
    }
    AppMethodBeat.o(127751);
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127749);
    paramString1 = com.tencent.mm.h.a.Kb(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new y.4(paramString2, paramContext), null);
    }
    AppMethodBeat.o(127749);
  }
  
  public static void showAddrBookUploadConfirm(Activity paramActivity, Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127745);
    if ((com.tencent.mm.plugin.account.friend.a.l.byi() != l.a.mWk) && (com.tencent.mm.plugin.account.friend.a.l.byi() != l.a.mWl)) {
      Log.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(127745);
      return;
      if (Util.nullAsFalse((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(12322, null)))
      {
        Log.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (Util.nullAsFalse((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(12323, null))))
      {
        Log.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        com.tencent.mm.plugin.account.friend.a.l.gX(false);
        Log.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", new Object[] { Util.getStack() });
        String str = Util.nullAsNil(Util.getLine1Number(paramActivity));
        if ((str.length() <= 0) || (!str.equals(com.tencent.mm.kernel.h.aHG().aHp().b(6, null)))) {
          break;
        }
        com.tencent.mm.plugin.account.friend.a.l.gX(true);
        Log.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.h.a(paramActivity, r.j.bind_mcontact_bind_alert_content, r.j.app_tip, r.j.app_yes, r.j.app_no, new y.1(paramInt, paramActivity, paramRunnable), new y.2(paramRunnable, paramActivity));
    com.tencent.mm.kernel.h.aHG().aHp().i(12323, Boolean.TRUE);
    AppMethodBeat.o(127745);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127746);
    int i = z.bdd();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      Log.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      com.tencent.mm.kernel.h.aHG().aHp().i(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      bmy localbmy = new bmy();
      localbmy.SXP = 17;
      localbmy.HmX = i;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, localbmy));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.sdk.a.mIH.abC();
      }
      AppMethodBeat.o(127746);
      return;
      i |= 0x20000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.y
 * JD-Core Version:    0.7.0.1
 */