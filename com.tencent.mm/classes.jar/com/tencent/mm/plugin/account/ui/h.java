package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public final class h
{
  private String account = "";
  private String idu;
  boolean qbB = false;
  private String qch = "";
  private a qci;
  private String username = "";
  
  public h(a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.qch = paramString2;
    this.qci = parama;
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128263);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
      {
        public final void b(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128260);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128260);
            return;
          }
          paramAnonymousg = paramAnonymousg.bGg();
          com.tencent.mm.kernel.h.baC();
          int i = b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128260);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramp instanceof u)) {
        this.idu = ((u)paramp).bMh();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        b.aZI();
        v.Sj(this.account);
        v.showAddrBookUploadConfirm(paramMMActivity, new h.3(this, paramMMActivity), false, 2);
        if (this.qbB)
        {
          paramMMActivity = MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.aQe()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.OAn.b(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
        }
        AppMethodBeat.o(128263);
        return;
      }
      if (paramInt2 == -106)
      {
        v.f(paramMMActivity, paramString, 0);
        AppMethodBeat.o(128263);
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(paramMMActivity, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
        AppMethodBeat.o(128263);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.pFo.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(128263);
        return;
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
          {
            k.s(paramMMActivity, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          k.s(paramMMActivity, r.j.errcode_password, r.j.login_err_title);
          i = 1;
          break;
        case -9: 
          k.s(paramMMActivity, r.j.login_err_mailnotverify, r.j.login_err_title);
          i = 1;
          break;
        case -72: 
          k.s(paramMMActivity, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
          i = 1;
          break;
        case -75: 
          k.s(paramMMActivity, r.j.alpha_version_tip_login, r.j.app_tip);
          i = 1;
          break;
        case -2023: 
        case -100: 
          b.aZH();
          com.tencent.mm.kernel.h.baC();
          if (TextUtils.isEmpty(b.aZu())) {}
          for (paramString = com.tencent.mm.cd.a.bt(paramMMActivity, r.j.main_err_another_place);; paramString = b.aZu())
          {
            k.a(paramMMActivity, paramString, paramMMActivity.getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.h.baC();
          }
        case -140: 
          if (!Util.isNullOrNil(this.idu)) {
            v.r(paramMMActivity, paramString, this.idu);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128263);
      return;
    }
  }
  
  public final void d(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(128262);
    Object localObject = this.account;
    if (Util.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new u((String)localObject, this.qch, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    a locala = this.qci;
    paramMMActivity.getString(r.j.app_tip);
    locala.b(k.a(paramMMActivity, paramMMActivity.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128259);
        com.tencent.mm.kernel.h.aZW().a(this.pZE);
        AppMethodBeat.o(128259);
      }
    }));
    AppMethodBeat.o(128262);
  }
  
  public static abstract interface a
  {
    public abstract void b(ProgressDialog paramProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */