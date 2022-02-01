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
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.t.a;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class y
{
  public static void St(String paramString)
  {
    AppMethodBeat.i(127747);
    bf.iDu.aO("login_user_name", paramString);
    AppMethodBeat.o(127747);
  }
  
  public static void a(Context paramContext, t.a parama, int paramInt)
  {
    AppMethodBeat.i(127750);
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.dHx);
    paramContext.putExtra("KVoiceHelpUrl", parama.jke);
    paramContext.putExtra("KVoiceHelpWording", parama.dQx);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.jkf != null) {
      paramContext.getExtras().putAll(parama.jkf);
    }
    AppMethodBeat.o(127750);
  }
  
  public static void dz(Context paramContext)
  {
    AppMethodBeat.i(127748);
    String str1 = paramContext.getString(2131755300);
    String str2 = paramContext.getString(2131755299);
    com.tencent.mm.ui.base.h.c(paramContext, str1, "", paramContext.getString(2131757787), paramContext.getString(2131757785), new y.3(str2, paramContext), null);
    AppMethodBeat.o(127748);
  }
  
  public static void g(Context paramContext, String paramString, final int paramInt)
  {
    AppMethodBeat.i(127751);
    final com.tencent.mm.h.a locala = com.tencent.mm.h.a.Dk(paramString);
    if (locala != null)
    {
      if (locala.dDG == 8)
      {
        com.tencent.mm.plugin.account.a.b.a.b(paramContext, locala.url, paramInt, false);
        AppMethodBeat.o(127751);
        return;
      }
      Object localObject1 = locala.gpb.gpn;
      Object localObject2 = locala.gpb.gpo;
      paramString = (String)localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        paramString = paramContext.getString(2131755921);
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramContext.getString(2131755761);
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
      if ((locala.dDG == 1) || (locala.dDG == 4))
      {
        if (Util.isNullOrNil(locala.url))
        {
          com.tencent.mm.ui.base.h.c(paramContext, locala.desc, locala.Title, true);
          AppMethodBeat.o(127751);
          return;
        }
        com.tencent.mm.ui.base.h.c(paramContext, locala.desc, locala.Title, paramString, (String)localObject1, (DialogInterface.OnClickListener)localObject2, null);
      }
      AppMethodBeat.o(127751);
      return;
    }
    AppMethodBeat.o(127751);
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127749);
    paramString1 = com.tencent.mm.h.a.Dk(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new y.4(paramString2, paramContext), null);
    }
    AppMethodBeat.o(127749);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(127745);
    if ((com.tencent.mm.plugin.account.friend.a.l.bnZ() != l.a.keL) && (com.tencent.mm.plugin.account.friend.a.l.bnZ() != l.a.keM)) {
      Log.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      AppMethodBeat.o(127745);
      return;
      if (Util.nullAsFalse((Boolean)g.aAh().azQ().get(12322, null)))
      {
        Log.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (Util.nullAsFalse((Boolean)g.aAh().azQ().get(12323, null))))
      {
        Log.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        com.tencent.mm.plugin.account.friend.a.l.gl(false);
        Log.d("MicroMsg.PostLoginUtil", "READ_PHONE_STATE.getLine1Number %s", new Object[] { Util.getStack() });
        String str = Util.nullAsNil(Util.getLine1Number(paramActivity));
        if ((str.length() <= 0) || (!str.equals(g.aAh().azQ().get(6, null)))) {
          break;
        }
        com.tencent.mm.plugin.account.friend.a.l.gl(true);
        Log.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.h.a(paramActivity, 2131756581, 2131755998, 2131756033, 2131755917, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(127740);
        Log.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.gsA) });
        com.tencent.mm.plugin.report.service.h.CyF.a(11438, new Object[] { Integer.valueOf(this.gsA) });
        com.tencent.mm.plugin.account.friend.a.l.gl(true);
        y.syncUploadMContactStatus(true, false);
        a.blm();
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
        com.tencent.mm.plugin.account.friend.a.l.gl(false);
        y.syncUploadMContactStatus(false, false);
        if (this.jNF != null) {
          this.jNF.run();
        }
        paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
        AppMethodBeat.o(127741);
      }
    });
    g.aAh().azQ().set(12323, Boolean.TRUE);
    AppMethodBeat.o(127745);
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(127746);
    int i = z.aUc();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      Log.d("MicroMsg.PostLoginUtil", "Reg By mobile update = ".concat(String.valueOf(i)));
      g.aAh().azQ().set(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label132;
      }
    }
    label132:
    for (i = 1;; i = 2)
    {
      bfx localbfx = new bfx();
      localbfx.LPB = 17;
      localbfx.BsD = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(23, localbfx));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
      }
      AppMethodBeat.o(127746);
      return;
      i |= 0x20000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.y
 * JD-Core Version:    0.7.0.1
 */