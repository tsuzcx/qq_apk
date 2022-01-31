package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class RegByQQAuthUI
  extends MMActivity
  implements f
{
  private String account;
  private String bJY;
  private String bVH;
  private ProgressDialog dnm = null;
  private String fey;
  private EditText frJ = null;
  private int frK;
  
  protected final int getLayoutId()
  {
    return q.g.regbyqq_auth;
  }
  
  protected final void initView()
  {
    this.frK = getIntent().getIntExtra("RegByQQ_BindUin", 0);
    this.fey = getIntent().getStringExtra("RegByQQ_RawPsw");
    this.account = getIntent().getStringExtra("RegByQQ_Account");
    this.bJY = getIntent().getStringExtra("RegByQQ_Ticket");
    this.bVH = getIntent().getStringExtra("RegByQQ_Nick");
    y.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.frK + "  pass:" + this.fey + "  ticket:" + this.bJY);
    this.frJ = ((EditText)findViewById(q.f.nick_et));
    if ((this.bVH != null) && (!this.bVH.equals(""))) {
      this.frJ.setText(this.bVH);
    }
    setMMTitle(q.j.regbyqq_auth_title);
    addTextOptionMenu(0, getString(q.j.app_nextstep), new RegByQQAuthUI.1(this));
    setBackBtn(new RegByQQAuthUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    g.Dk().b(126, this);
  }
  
  public void onResume()
  {
    super.onResume();
    g.Dk().a(126, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
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
        switch (paramm.getType())
        {
        default: 
          return;
        }
        com.tencent.mm.kernel.a.unhold();
        at.dVC.Y("login_user_name", this.account);
        paramString = new Intent(this, BindMContactIntroUI.class);
        paramString.putExtra("key_upload_scene", 1);
        paramString.putExtra("skip", true);
        paramm = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
        paramm.addFlags(67108864);
        paramm.putExtra("LauncherUI.enter_from_reg", true);
        MMWizardActivity.b(this, paramString, paramm);
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
        if (paramInt1 == 4) {}
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -1: 
          if (g.Dk().KG() == 5)
          {
            h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
            i = 1;
          }
          break;
        case -3: 
          h.h(this, q.j.app_err_password, q.j.regbyqq_auth_err_title);
          i = 1;
          break;
        case -4: 
          h.h(this, q.j.app_err_nouser, q.j.regbyqq_auth_err_title);
          i = 1;
          break;
        case -12: 
          h.h(this, q.j.regbyqq_auth_err_uinexsit, q.j.regbyqq_auth_err_title);
          i = 1;
          break;
        case -11: 
          h.h(this, q.j.regbyqq_auth_err_nickinvalid, q.j.regbyqq_auth_err_title);
          i = 1;
          break;
        case -72: 
          h.h(this.mController.uMN, q.j.regbyqq_auth_err_failed_niceqq, q.j.app_tip);
          i = 1;
          break;
        case -75: 
          h.h(this.mController.uMN, q.j.alpha_version_tip_reg, q.j.app_tip);
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI
 * JD-Core Version:    0.7.0.1
 */