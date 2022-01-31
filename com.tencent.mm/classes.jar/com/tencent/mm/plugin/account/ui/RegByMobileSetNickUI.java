package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.ui.BindQQUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.MMEditText.c;

@Deprecated
public class RegByMobileSetNickUI
  extends MMActivity
  implements f
{
  private String bSe;
  private ProgressDialog dnm = null;
  private EditText fqV;
  private r fqW = null;
  private boolean fqX;
  
  protected final int getLayoutId()
  {
    return q.g.regbymobilesetnick_reg;
  }
  
  protected final void initView()
  {
    setMMTitle(q.j.regbymobile_reg_setnick_title);
    this.fqV = ((EditText)findViewById(q.f.regbymobilereg_nick_et));
    this.fqV.addTextChangedListener(new MMEditText.c(this.fqV, null, 16));
    addTextOptionMenu(0, getString(q.j.app_finish), new RegByMobileSetNickUI.1(this));
    setBackBtn(new RegByMobileSetNickUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fqX = getIntent().getBooleanExtra("is_sync_addr", false);
    this.bSe = getIntent().getExtras().getString("bindmcontact_mobile");
    initView();
    g.Dk().a(126, this);
  }
  
  public void onDestroy()
  {
    if (this.fqW != null)
    {
      r localr = this.fqW;
      com.tencent.mm.ui.base.s locals = localr.fqd;
      locals.cancel();
      locals.byQ.stopTimer();
      locals.reset();
      localr.text = null;
    }
    g.Dk().b(126, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.RegByMobileSetNickUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (!bk.bU(this)) {}
    for (;;)
    {
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = q.Gn();
        y.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile status = " + paramInt1 + " isSync = " + this.fqX);
        if (this.fqX)
        {
          paramInt1 &= 0xFFFDFFFF;
          com.tencent.mm.plugin.account.friend.a.l.WM();
          getApplicationContext();
          com.tencent.mm.platformtools.a.UG();
          y.d("MicroMsg.RegByMobileSetNickUI", "Reg By mobile update = " + paramInt1);
          g.DP().Dz().o(7, Integer.valueOf(paramInt1));
          if (this.fqX) {
            break label320;
          }
        }
        label320:
        for (paramInt1 = 1;; paramInt1 = 2)
        {
          paramString = new zr();
          paramString.sYS = 17;
          paramString.nfn = paramInt1;
          ((j)g.r(j.class)).Fv().b(new i.a(23, paramString));
          com.tencent.mm.plugin.account.a.a.eUS.tk();
          at.dVC.Y("login_user_name", this.bSe);
          paramString = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
          paramString.putExtra("LauncherUI.enter_from_reg", true);
          paramString.addFlags(67108864);
          if (!((com.tencent.mm.modelsimple.s)paramm).eAc) {
            break label325;
          }
          MMWizardActivity.b(this, new Intent(this, BindQQUI.class).putExtra("bindqq_regbymobile", 1), paramString);
          return;
          paramInt1 |= 0x20000;
          break;
        }
        label325:
        MMWizardActivity.b(this, new Intent(this, BindFacebookUI.class), paramString);
        return;
      }
      if (paramm.getType() == 126)
      {
        paramm = com.tencent.mm.i.a.eI(paramString);
        if (paramm != null)
        {
          paramm.a(this, null, null);
          return;
        }
      }
      int i;
      if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i == 0)
      {
        Toast.makeText(this, getString(q.j.fmt_reg_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        return;
        switch (paramInt1)
        {
        }
        do
        {
          i = 0;
          break;
          if ((paramInt2 == -7) || (paramInt2 == -10))
          {
            com.tencent.mm.ui.base.h.h(this, q.j.reg_username_exist_tip, q.j.reg_username_exist_title);
            i = 1;
            break;
          }
        } while (paramInt2 != -75);
        com.tencent.mm.ui.base.h.h(this, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetNickUI
 * JD-Core Version:    0.7.0.1
 */