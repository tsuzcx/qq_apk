package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.q.a;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.BioHelperUI;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class z
{
  public static void a(Context paramContext, q.a parama, int paramInt)
  {
    paramContext = new Intent(paramContext, BioHelperUI.class);
    paramContext.putExtra("k_type", parama.type);
    paramContext.putExtra("KVoiceHelpCode", paramInt);
    paramContext.putExtra("Kvertify_key", parama.bJY);
    paramContext.putExtra("KVoiceHelpUrl", parama.ezP);
    paramContext.putExtra("KVoiceHelpWording", parama.bQZ);
    paramContext.putExtra("Kusername", parama.username);
    if (parama.ezQ != null) {
      paramContext.getExtras().putAll(parama.ezQ);
    }
  }
  
  public static void bT(Context paramContext)
  {
    String str1 = paramContext.getString(q.j.alpha_version_tip_login);
    String str2 = paramContext.getString(q.j.alpha_version_open_offical_url);
    com.tencent.mm.ui.base.h.a(paramContext, str1, "", paramContext.getString(q.j.confirm_dialog_ok), paramContext.getString(q.j.confirm_dialog_cancel), new z.3(str2, paramContext), null);
  }
  
  public static void e(Context paramContext, String paramString, int paramInt)
  {
    paramString = com.tencent.mm.i.a.eI(paramString);
    if (paramString != null)
    {
      if (paramString.showType != 8) {
        break label29;
      }
      com.tencent.mm.plugin.account.a.b.a.b(paramContext, paramString.url, paramInt, false);
    }
    label29:
    String str1;
    String str2;
    z.5 local5;
    do
    {
      return;
      str1 = paramContext.getString(q.j.app_ok);
      str2 = paramContext.getString(q.j.app_cancel);
      local5 = new z.5(paramContext, paramString, paramInt);
    } while ((paramString.showType != 1) && (paramString.showType != 4));
    if (bk.bl(paramString.url))
    {
      com.tencent.mm.ui.base.h.b(paramContext, paramString.desc, paramString.bGw, true);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramString.desc, paramString.bGw, str1, str2, local5, null);
  }
  
  public static void l(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = com.tencent.mm.i.a.eI(paramString1);
    if (paramString1 != null) {
      paramString1.a(paramContext, new z.4(paramString2, paramContext), null);
    }
  }
  
  public static void pi(String paramString)
  {
    at.dVC.Y("login_user_name", paramString);
  }
  
  public static void showAddrBookUploadConfirm(final Activity paramActivity, final Runnable paramRunnable, boolean paramBoolean, int paramInt)
  {
    if ((com.tencent.mm.plugin.account.friend.a.l.WP() != l.a.ffT) && (com.tencent.mm.plugin.account.friend.a.l.WP() != l.a.ffU)) {
      y.e("MicroMsg.PostLoginUtil", "not successfully binded, skip addrbook confirm");
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
      if (bk.d((Boolean)g.DP().Dz().get(12322, null)))
      {
        y.d("MicroMsg.PostLoginUtil", "addrbook upload confirmed");
      }
      else if ((!paramBoolean) && (bk.d((Boolean)g.DP().Dz().get(12323, null))))
      {
        y.d("MicroMsg.PostLoginUtil", "addrbook upload login confirmed showed");
      }
      else
      {
        g.DP().Dz().o(12322, Boolean.valueOf(false));
        String str = bk.pm(bk.fR(paramActivity));
        if ((str.length() <= 0) || (!str.equals(g.DP().Dz().get(6, null)))) {
          break;
        }
        g.DP().Dz().o(12322, Boolean.valueOf(true));
        y.i("MicroMsg.PostLoginUtil", "same none-nil phone number, leave it");
      }
    }
    com.tencent.mm.ui.base.h.a(paramActivity, q.j.bind_mcontact_bind_alert_content, q.j.app_tip, q.j.app_yes, q.j.app_no, new DialogInterface.OnClickListener()new z.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        y.i("MicroMsg.PostLoginUtil", "[cpan] kv report logid:%d scene:%d", new Object[] { Integer.valueOf(11438), Integer.valueOf(this.egz) });
        com.tencent.mm.plugin.report.service.h.nFQ.f(11438, new Object[] { Integer.valueOf(this.egz) });
        g.DP().Dz().o(12322, Boolean.valueOf(true));
        z.syncUploadMContactStatus(true, false);
        a.UG();
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        paramActivity.getSharedPreferences(ae.cqR(), 0).edit().putBoolean("login_upload_contacts_already_displayed", true).commit();
      }
    }, new z.2(paramRunnable, paramActivity));
    g.DP().Dz().o(12323, Boolean.valueOf(true));
  }
  
  public static void syncUploadMContactStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = q.Gn();
    if (paramBoolean1)
    {
      i &= 0xFFFDFFFF;
      y.d("MicroMsg.PostLoginUtil", "Reg By mobile update = " + i);
      g.DP().Dz().o(7, Integer.valueOf(i));
      if (paramBoolean1) {
        break label127;
      }
    }
    label127:
    for (i = 1;; i = 2)
    {
      zr localzr = new zr();
      localzr.sYS = 17;
      localzr.nfn = i;
      ((j)g.r(j.class)).Fv().b(new i.a(23, localzr));
      if (paramBoolean2) {
        com.tencent.mm.plugin.account.a.a.eUS.tk();
      }
      return;
      i |= 0x20000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.z
 * JD-Core Version:    0.7.0.1
 */