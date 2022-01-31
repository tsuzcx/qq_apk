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
import com.tencent.mm.model.av;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class z
{
  public static void a(Context paramContext, s.a parama, int paramInt)
  {
    AppMethodBeat.i(124592);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.crs);
    paramContext.putExtra("KVoiceHelpUrl", parama.fPF);
    paramContext.putExtra("KVoiceHelpWording", parama.cyA);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.fPG != null) {
      paramContext.getExtras().putAll(parama.fPG);
    }
    AppMethodBeat.o(124592);
  }
  
  public static void cA(Context paramContext)
  {
    AppMethodBeat.i(124590);
    String str1 = paramContext.getString(2131296531);
    String str2 = paramContext.getString(2131296530);
    com.tencent.mm.ui.base.h.d(paramContext, str1, "", paramContext.getString(2131298501), paramContext.getString(2131298499), new z.3(str2, paramContext), null);
    AppMethodBeat.o(124590);
  }
  
  public static void f(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(124593);
    paramString = com.tencent.mm.h.a.kO(paramString);
    if (paramString != null)
    {
      if (paramString.showType == 8)
      {
        com.tencent.mm.plugin.account.a.b.a.b(paramContext, paramString.url, paramInt, false);
        AppMethodBeat.o(124593);
        return;
      }
      String str1 = paramContext.getString(2131297018);
      String str2 = paramContext.getString(2131296888);
      z.5 local5 = new z.5(paramContext, paramString, paramInt);
      if ((paramString.showType == 1) || (paramString.showType == 4))
      {
        if (bo.isNullOrNil(paramString.url))
        {
          com.tencent.mm.ui.base.h.b(paramContext, paramString.desc, paramString.Title, true);
          AppMethodBeat.o(124593);
          return;
        }
        com.tencent.mm.ui.base.h.d(paramContext, paramString.desc, paramString.Title, str1, str2, local5, null);
      }
      AppMethodBeat.o(124593);
      return;
    }
    AppMethodBeat.o(124593);
  }
  
  public static void o(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124591);
    paramString1 = com.tencent.mm.h.a.kO(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new z.4(paramString2, paramContext), null);
    }
    AppMethodBeat.o(124591);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(124587);
    if ((l.aqq() != l.a.gxB) && (l.aqq() != l.a.gxC)) {
      ab.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(124587);
      return;
      if (bo.e((Boolean)g.RL().Ru().get(12322, null)))
      {
        ab.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (bo.e((Boolean)g.RL().Ru().get(12323, null))))
      {
        ab.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        l.dx(false);
        String str = bo.nullAsNil(bo.hh(paramActivity));
        if ((str.length() <= 0) || (!str.equals(g.RL().Ru().get(6, null)))) {
          break;
        }
        l.dx(true);
        ab.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.h.a(paramActivity, 2131297553, 2131297087, 2131297115, 2131297014, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(124582);
        ab.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.fwD) });
        com.tencent.mm.plugin.report.service.h.qsU.e(11438, new Object[] { Integer.valueOf(this.fwD) });
        l.dx(true);
        z.syncUploadMContactStatus(true, false);
        a.aof();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(ah.dsP(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(124582);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(124583);
        l.dx(false);
        z.syncUploadMContactStatus(false, false);
        if (this.gjS != null) {
          this.gjS.run();
        }
        paramActivity.getSharedPreferences(ah.dsP(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(124583);
      }
    });
    g.RL().Ru().set(12323, Boolean.TRUE);
    AppMethodBeat.o(124587);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(124588);
    int i = r.Zr();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      ab.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      g.RL().Ru().set(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      aek localaek = new aek();
      localaek.wXn = 17;
      localaek.pKC = i;
      ((j)g.E(j.class)).Yz().c(new j.a(23, localaek));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.a.a.gmP.BO();
      }
      AppMethodBeat.o(124588);
      return;
      i |= 0x20000;
      break;
    }
  }
  
  public static void wz(String paramString)
  {
    AppMethodBeat.i(124589);
    av.flM.ao("login_user_name", paramString);
    AppMethodBeat.o(124589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.z
 * JD-Core Version:    0.7.0.1
 */