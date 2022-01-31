package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.at.b;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.so;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactVerifyUI
  extends MMWizardActivity
  implements f
{
  private String bSe;
  private SharedPreferences dnD;
  private boolean faM = false;
  private boolean fbC = false;
  private boolean fbD = false;
  private boolean fbY = false;
  private boolean fbZ = false;
  private boolean fca = false;
  private EditText fcd;
  private TextView fce;
  private Button fcf;
  private boolean fcg = false;
  private int fromScene = 0;
  private int status;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  protected final int getLayoutId()
  {
    return a.f.bindmcontact_verify;
  }
  
  protected final void initView()
  {
    this.bSe = ((String)g.DP().Dz().get(4097, null));
    this.fcd = ((EditText)findViewById(a.e.bind_mcontact_verify_num));
    this.fbC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.fbD = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.fbY = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
    this.fcg = getIntent().getBooleanExtra("BIND_FIND_ME_BY_MOBILE", false);
    this.fbZ = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
    this.fca = getIntent().getBooleanExtra("is_bind_for_reset_pwd", false);
    this.faM = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Button localButton = (Button)findViewById(a.e.bind_mcontact_verify_btn);
    if ((this.bSe == null) || (this.bSe.equals(""))) {
      this.bSe = ((String)g.DP().Dz().get(6, null));
    }
    BindMContactVerifyUI.1 local1 = new BindMContactVerifyUI.1(this);
    this.fcd.setFilters(new InputFilter[] { local1 });
    this.fcf = ((Button)findViewById(a.e.bind_mcontact_voice_code));
    this.fce = ((TextView)findViewById(a.e.bind_mcontact_verify_hint));
    boolean bool = this.fcg;
    if (!bool)
    {
      this.status |= 0x200;
      this.dnD.edit().putBoolean("settings_find_me_by_mobile", bool).commit();
      y.d("MicroMsg.BindMContactVerifyUI", "Bind mobile update = " + this.status);
      this.fce.setText(getString(a.i.bind_mcontact_input_verify_hint, new Object[] { this.bSe }));
      localButton.setOnClickListener(new BindMContactVerifyUI.2(this));
      setBackBtn(new BindMContactVerifyUI.3(this));
      localButton = this.fcf;
      if (!b.mA(this.bSe)) {
        break label419;
      }
    }
    label419:
    for (int i = 0;; i = 8)
    {
      localButton.setVisibility(i);
      this.fcf.setOnClickListener(new BindMContactVerifyUI.4(this));
      return;
      this.status &= 0xFFFFFDFF;
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(132, this);
    setMMTitle(a.i.bind_mcontact_title_verify);
    this.dnD = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.status = q.Gn();
    initView();
  }
  
  public void onDestroy()
  {
    g.Dk().b(132, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.BindMContactVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((((x)paramm).rN() != 2) && (((x)paramm).rN() != 19)) {}
    for (;;)
    {
      return;
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((((x)paramm).rN() == 2) || (((x)paramm).rN() == 19))
        {
          if (this.fromScene == 5)
          {
            y.i("MicroMsg.BindMContactVerifyUI", "onScene end, finish wizard from app brand reg phone");
            FW(-1);
            return;
          }
          if (this.fbC)
          {
            if (!q.Gr())
            {
              paramString = new so();
              paramString.ccd.cce = true;
              paramString.ccd.ccf = true;
              com.tencent.mm.sdk.b.a.udP.m(paramString);
            }
            FW(1);
            paramString = new Intent();
            paramString.addFlags(67108864);
            com.tencent.mm.plugin.account.a.a.eUR.c(this, paramString);
            return;
          }
          if (this.fbY)
          {
            FW(1);
            startActivity(new Intent(this, FindMContactAddUI.class));
            return;
          }
          if (this.fca)
          {
            y.i("MicroMsg.BindMContactVerifyUI", "to RegByMobileSetPwdUI for reset pwd");
            finish();
            paramString = new Intent();
            paramString.addFlags(603979776);
            paramString.putExtra("setpwd_ticket", ((x)paramm).NJ());
            d.b(this, "account", ".ui.RegByMobileSetPwdUI", paramString);
            return;
          }
          if ((this.status & 0x200) > 0)
          {
            paramInt1 = 1;
            g.DP().Dz().o(7, Integer.valueOf(this.status));
            paramString = new zr();
            paramString.sYS = 8;
            if (paramInt1 == 0) {
              break label505;
            }
            paramInt1 = 1;
            label361:
            paramString.nfn = paramInt1;
            ((j)g.r(j.class)).Fv().b(new i.a(23, paramString));
            com.tencent.mm.plugin.account.a.a.eUS.tk();
            if (!this.fbD) {
              ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
            }
            if (this.fbZ) {
              com.tencent.mm.ui.base.h.bC(this, getString(a.i.bind_mcontact_change_bind_success));
            }
            if (this.faM)
            {
              if (!this.fbD) {
                break label510;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.f(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
            }
          }
          for (;;)
          {
            C(this, new Intent(this, BindMContactStatusUI.class));
            return;
            paramInt1 = 0;
            break;
            label505:
            paramInt1 = 2;
            break label361;
            label510:
            com.tencent.mm.plugin.report.service.h.nFQ.f(11002, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
        }
      }
      else
      {
        paramm = com.tencent.mm.i.a.eI(paramString);
        if (paramm != null)
        {
          paramm.a(this, null, null);
          return;
        }
        int i;
        if (com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
          i = 1;
        }
        while (i == 0)
        {
          Toast.makeText(this, getString(a.i.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
          return;
          switch (paramInt2)
          {
          default: 
            i = 0;
            break;
          case -34: 
            Toast.makeText(this, a.i.bind_mcontact_err_freq_limit, 0).show();
            i = 1;
            break;
          case -43: 
            Toast.makeText(this, a.i.bind_mcontact_err_binded, 0).show();
            i = 1;
            break;
          case -214: 
            paramString = com.tencent.mm.i.a.eI(paramString);
            if (paramString != null) {
              paramString.a(this, null, null);
            }
            i = 1;
            break;
          case -41: 
            Toast.makeText(this, a.i.bind_mcontact_err_format, 0).show();
            i = 1;
            break;
          case -35: 
            Toast.makeText(this, a.i.bind_mcontact_err_binded_by_other, 0).show();
            i = 1;
            break;
          case -36: 
            Toast.makeText(this, a.i.bind_mcontact_err_unbinded_notbinded, 0).show();
            i = 1;
            break;
          case -32: 
            com.tencent.mm.ui.base.h.a(this, a.i.bind_mcontact_verify_err_unmatch_content, a.i.bind_mcontact_verify_tip, null);
            i = 1;
            break;
          case -33: 
            com.tencent.mm.ui.base.h.a(this, a.i.bind_mcontact_verify_err_time_out_content, a.i.bind_mcontact_verify_tip, null);
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI
 * JD-Core Version:    0.7.0.1
 */