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
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class h
{
  private String account = "";
  private String fXu;
  boolean neP = false;
  private String neZ = "";
  private a nfa;
  private String username = "";
  
  public h(a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.neZ = paramString2;
    this.nfa = parama;
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128263);
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.h.aGY().a(new bv(new bv.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128260);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128260);
            return;
          }
          paramAnonymousg = paramAnonymousg.biw();
          com.tencent.mm.kernel.h.aHE();
          int i = b.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128260);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
        this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        b.aGG();
        com.tencent.mm.platformtools.t.jdMethod_do(paramMMActivity);
        y.ZV(this.account);
        y.showAddrBookUploadConfirm(paramMMActivity, new h.3(this, paramMMActivity), false, 2);
        if (this.neP)
        {
          paramMMActivity = MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.avK()).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.IzE.a(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
        }
        AppMethodBeat.o(128263);
        return;
      }
      if (paramInt2 == -106)
      {
        y.f(paramMMActivity, paramString, 0);
        AppMethodBeat.o(128263);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(paramMMActivity, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(128263);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.mIH.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
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
          if (com.tencent.mm.kernel.h.aGY().bih() == 5)
          {
            com.tencent.mm.ui.base.h.p(paramMMActivity, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
            i = 1;
          }
          break;
        case -4: 
        case -3: 
          com.tencent.mm.ui.base.h.p(paramMMActivity, r.j.errcode_password, r.j.login_err_title);
          i = 1;
          break;
        case -9: 
          com.tencent.mm.ui.base.h.p(paramMMActivity, r.j.login_err_mailnotverify, r.j.login_err_title);
          i = 1;
          break;
        case -72: 
          com.tencent.mm.ui.base.h.p(paramMMActivity, r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
          i = 1;
          break;
        case -75: 
          com.tencent.mm.ui.base.h.p(paramMMActivity, r.j.alpha_version_tip_login, r.j.app_tip);
          i = 1;
          break;
        case -2023: 
        case -100: 
          b.aGF();
          com.tencent.mm.kernel.h.aHE();
          if (TextUtils.isEmpty(b.aGs())) {}
          for (paramString = com.tencent.mm.ci.a.ba(paramMMActivity, r.j.main_err_another_place);; paramString = b.aGs())
          {
            com.tencent.mm.ui.base.h.a(paramMMActivity, paramString, paramMMActivity.getString(r.j.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            }, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
            });
            i = 1;
            break;
            com.tencent.mm.kernel.h.aHE();
          }
        case -140: 
          if (!Util.isNullOrNil(this.fXu)) {
            y.p(paramMMActivity, paramString, this.fXu);
          }
          i = 1;
        }
      }
      Toast.makeText(paramMMActivity, paramMMActivity.getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128263);
      return;
    }
  }
  
  public final void c(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(128262);
    Object localObject = this.account;
    if (Util.isNullOrNil(this.account)) {
      localObject = this.username;
    }
    localObject = new com.tencent.mm.modelsimple.t((String)localObject, this.neZ, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    a locala = this.nfa;
    paramMMActivity.getString(r.j.app_tip);
    locala.a(com.tencent.mm.ui.base.h.a(paramMMActivity, paramMMActivity.getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128259);
        com.tencent.mm.kernel.h.aGY().a(this.ndz);
        AppMethodBeat.o(128259);
      }
    }));
    AppMethodBeat.o(128262);
  }
  
  public static abstract interface a
  {
    public abstract void a(ProgressDialog paramProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */