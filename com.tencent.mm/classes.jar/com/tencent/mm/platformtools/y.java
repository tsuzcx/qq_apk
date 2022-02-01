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
import com.tencent.mm.h.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;

public final class y
{
  public static void IW(String paramString)
  {
    AppMethodBeat.i(127747);
    az.hFS.aM("login_user_name", paramString);
    AppMethodBeat.o(127747);
  }
  
  public static void a(Context paramContext, s.a parama, int paramInt)
  {
    AppMethodBeat.i(127750);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.dpf);
    paramContext.putExtra("KVoiceHelpUrl", parama.imd);
    paramContext.putExtra("KVoiceHelpWording", parama.dxD);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.ime != null) {
      paramContext.getExtras().putAll(parama.ime);
    }
    AppMethodBeat.o(127750);
  }
  
  public static void dc(Context paramContext)
  {
    AppMethodBeat.i(127748);
    String str1 = paramContext.getString(2131755265);
    String str2 = paramContext.getString(2131755264);
    h.e(paramContext, str1, "", paramContext.getString(2131757560), paramContext.getString(2131757558), new y.3(str2, paramContext), null);
    AppMethodBeat.o(127748);
  }
  
  public static void g(Context paramContext, String paramString, final int paramInt)
  {
    AppMethodBeat.i(127751);
    final com.tencent.mm.h.a locala = com.tencent.mm.h.a.uz(paramString);
    if (locala != null)
    {
      if (locala.dlp == 8)
      {
        com.tencent.mm.plugin.account.a.b.a.b(paramContext, locala.url, paramInt, false);
        AppMethodBeat.o(127751);
        return;
      }
      Object localObject1 = locala.fHI.fHU;
      Object localObject2 = locala.fHI.fHV;
      paramString = (String)localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        paramString = paramContext.getString(2131755835);
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = paramContext.getString(2131755691);
      }
      localObject2 = new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127744);
          com.tencent.mm.plugin.account.a.b.a.b(this.val$context, locala.url, paramInt, false);
          AppMethodBeat.o(127744);
        }
      };
      if ((locala.dlp == 1) || (locala.dlp == 4))
      {
        if (bt.isNullOrNil(locala.url))
        {
          h.c(paramContext, locala.desc, locala.Title, true);
          AppMethodBeat.o(127751);
          return;
        }
        h.e(paramContext, locala.desc, locala.Title, paramString, (String)localObject1, (DialogInterface.OnClickListener)localObject2, null);
      }
      AppMethodBeat.o(127751);
      return;
    }
    AppMethodBeat.o(127751);
  }
  
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127749);
    paramString1 = com.tencent.mm.h.a.uz(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new y.4(paramString2, paramContext), null);
    }
    AppMethodBeat.o(127749);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127745);
    if ((com.tencent.mm.plugin.account.friend.a.l.aSO() != l.a.jdO) && (com.tencent.mm.plugin.account.friend.a.l.aSO() != l.a.jdP)) {
      ad.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(127745);
      return;
      if (bt.o((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(12322, null)))
      {
        ad.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (bt.o((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(12323, null))))
      {
        ad.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        com.tencent.mm.plugin.account.friend.a.l.fr(false);
        ad.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", new Object[] { bt.flS() });
        String str = bt.nullAsNil(bt.jf(paramActivity));
        if ((str.length() <= 0) || (!str.equals(com.tencent.mm.kernel.g.ajC().ajl().get(6, null)))) {
          break;
        }
        com.tencent.mm.plugin.account.friend.a.l.fr(true);
        ad.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    h.a(paramActivity, 2131756445, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127740);
        ad.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.fLl) });
        com.tencent.mm.plugin.report.service.g.yhR.f(11438, new Object[] { Integer.valueOf(this.fLl) });
        com.tencent.mm.plugin.account.friend.a.l.fr(true);
        y.syncUploadMContactStatus(true, false);
        a.aQj();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(aj.fkC(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127740);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127741);
        com.tencent.mm.plugin.account.friend.a.l.fr(false);
        y.syncUploadMContactStatus(false, false);
        if (this.iNR != null) {
          this.iNR.run();
        }
        paramActivity.getSharedPreferences(aj.fkC(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127741);
      }
    });
    com.tencent.mm.kernel.g.ajC().ajl().set(12323, Boolean.TRUE);
    AppMethodBeat.o(127745);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127746);
    int i = u.aAq();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      ad.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      com.tencent.mm.kernel.g.ajC().ajl().set(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      aty localaty = new aty();
      localaty.GrZ = 17;
      localaty.xcI = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(new k.a(23, localaty));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.a.a.iRH.MR();
      }
      AppMethodBeat.o(127746);
      return;
      i |= 0x20000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.y
 * JD-Core Version:    0.7.0.1
 */