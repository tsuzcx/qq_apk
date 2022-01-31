package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public final class g
{
  private String account = "";
  private String caS;
  boolean fnK = false;
  private String fnT = "";
  private g.a fnU;
  private String username = "";
  
  public g(g.a parama, String paramString1, String paramString2, String paramString3)
  {
    this.username = paramString1;
    this.account = paramString3;
    this.fnT = paramString2;
    this.fnU = parama;
  }
  
  public final void a(MMActivity paramMMActivity)
  {
    q localq = new q(this.username, this.fnT, 0, "", "", "", 0, "", false, true);
    com.tencent.mm.kernel.g.Dk().a(localq, 0);
    g.a locala = this.fnU;
    paramMMActivity.getString(q.j.app_tip);
    locala.a(com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(q.j.login_logining), true, new g.1(this, localq)));
  }
  
  public final void a(MMActivity paramMMActivity, int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.Dk().a(new bi(new g.2(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramm instanceof q)) {
        this.caS = ((q)paramm).Qy();
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        w.bL(paramMMActivity);
        z.pi(this.account);
        z.showAddrBookUploadConfirm(paramMMActivity, new g.3(this, paramMMActivity), false, 2);
        if (this.fnK)
        {
          paramMMActivity = ae.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
          com.tencent.mm.plugin.report.service.h.nFQ.f(11930, new Object[] { paramMMActivity, Integer.valueOf(4) });
        }
      }
      for (;;)
      {
        return;
        if (paramInt2 == -106)
        {
          z.e(paramMMActivity, paramString, 0);
          return;
        }
        if (paramInt2 == -217)
        {
          z.a(paramMMActivity, e.a((q)paramm), paramInt2);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.eUS.a(paramMMActivity, paramInt1, paramInt2, paramString)) {
          i = 1;
        }
        while (i == 0)
        {
          Toast.makeText(paramMMActivity, paramMMActivity.getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
          return;
          if (paramInt1 == 4) {}
          switch (paramInt2)
          {
          default: 
            i = 0;
            break;
          case -1: 
            if (com.tencent.mm.kernel.g.Dk().KG() == 5)
            {
              com.tencent.mm.ui.base.h.h(paramMMActivity, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
              i = 1;
            }
            break;
          case -4: 
          case -3: 
            com.tencent.mm.ui.base.h.h(paramMMActivity, q.j.errcode_password, q.j.login_err_title);
            i = 1;
            break;
          case -9: 
            com.tencent.mm.ui.base.h.h(paramMMActivity, q.j.login_err_mailnotverify, q.j.login_err_title);
            i = 1;
            break;
          case -72: 
            com.tencent.mm.ui.base.h.h(paramMMActivity, q.j.regbyqq_auth_err_failed_niceqq, q.j.app_tip);
            i = 1;
            break;
          case -75: 
            com.tencent.mm.ui.base.h.h(paramMMActivity, q.j.alpha_version_tip_login, q.j.app_tip);
            i = 1;
            break;
          case -100: 
            com.tencent.mm.kernel.a.hold();
            com.tencent.mm.kernel.g.DN();
            if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
            for (paramString = com.tencent.mm.cb.a.ac(paramMMActivity, q.j.main_err_another_place);; paramString = com.tencent.mm.kernel.a.CM())
            {
              com.tencent.mm.ui.base.h.a(paramMMActivity, paramString, paramMMActivity.getString(q.j.app_tip), new g.4(this), new g.5(this));
              i = 1;
              break;
              com.tencent.mm.kernel.g.DN();
            }
          case -140: 
            if (!bk.bl(this.caS)) {
              z.l(paramMMActivity, paramString, this.caS);
            }
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */