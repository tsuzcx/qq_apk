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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class y
{
  public static void FH(String paramString)
  {
    AppMethodBeat.i(127747);
    ay.hnA.aL("login_user_name", paramString);
    AppMethodBeat.o(127747);
  }
  
  public static void a(Context paramContext, s.a parama, int paramInt)
  {
    AppMethodBeat.i(127750);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.ddJ);
    paramContext.putExtra("KVoiceHelpUrl", parama.hSM);
    paramContext.putExtra("KVoiceHelpWording", parama.dlQ);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.hSN != null) {
      paramContext.getExtras().putAll(parama.hSN);
    }
    AppMethodBeat.o(127750);
  }
  
  public static void de(Context paramContext)
  {
    AppMethodBeat.i(127748);
    String str1 = paramContext.getString(2131755265);
    String str2 = paramContext.getString(2131755264);
    com.tencent.mm.ui.base.h.d(paramContext, str1, "", paramContext.getString(2131757560), paramContext.getString(2131757558), new y.3(str2, paramContext), null);
    AppMethodBeat.o(127748);
  }
  
  public static void g(Context paramContext, String paramString, final int paramInt)
  {
    AppMethodBeat.i(127751);
    final com.tencent.mm.h.a locala = com.tencent.mm.h.a.rM(paramString);
    if (locala != null)
    {
      if (locala.cZX == 8)
      {
        com.tencent.mm.plugin.account.a.b.a.b(paramContext, locala.url, paramInt, false);
        AppMethodBeat.o(127751);
        return;
      }
      Object localObject1 = locala.fpB.fpN;
      Object localObject2 = locala.fpB.fpO;
      paramString = (String)localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        paramString = paramContext.getString(2131755835);
      }
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
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
      if ((locala.cZX == 1) || (locala.cZX == 4))
      {
        if (bs.isNullOrNil(locala.url))
        {
          com.tencent.mm.ui.base.h.c(paramContext, locala.desc, locala.Title, true);
          AppMethodBeat.o(127751);
          return;
        }
        com.tencent.mm.ui.base.h.d(paramContext, locala.desc, locala.Title, paramString, (String)localObject1, (DialogInterface.OnClickListener)localObject2, null);
      }
      AppMethodBeat.o(127751);
      return;
    }
    AppMethodBeat.o(127751);
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127749);
    paramString1 = com.tencent.mm.h.a.rM(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new y.4(paramString2, paramContext), null);
    }
    AppMethodBeat.o(127749);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127745);
    if ((l.aPC() != l.a.iKF) && (l.aPC() != l.a.iKG)) {
      ac.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(127745);
      return;
      if (bs.l((Boolean)g.agR().agA().get(12322, null)))
      {
        ac.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (bs.l((Boolean)g.agR().agA().get(12323, null))))
      {
        ac.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        l.fn(false);
        ac.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", new Object[] { bs.eWi() });
        String str = bs.nullAsNil(bs.iV(paramActivity));
        if ((str.length() <= 0) || (!str.equals(g.agR().agA().get(6, null)))) {
          break;
        }
        l.fn(true);
        ac.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.h.b(paramActivity, 2131756445, 2131755906, 2131755939, 2131755831, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127740);
        ac.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.fsL) });
        com.tencent.mm.plugin.report.service.h.wUl.f(11438, new Object[] { Integer.valueOf(this.fsL) });
        l.fn(true);
        y.syncUploadMContactStatus(true, false);
        a.aMY();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(ai.eUX(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127740);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127741);
        l.fn(false);
        y.syncUploadMContactStatus(false, false);
        if (this.iuO != null) {
          this.iuO.run();
        }
        paramActivity.getSharedPreferences(ai.eUX(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127741);
      }
    });
    g.agR().agA().set(12323, Boolean.TRUE);
    AppMethodBeat.o(127745);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127746);
    int i = u.axA();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      ac.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      g.agR().agA().set(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      aqc localaqc = new aqc();
      localaqc.EIY = 17;
      localaqc.vVH = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(23, localaqc));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.a.a.iyy.Lj();
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