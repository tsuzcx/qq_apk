package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.Map;

public class SecurityAccountVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.ah.f
{
  private String bPS;
  private String bPU;
  private String bSe;
  private am byQ;
  private ProgressDialog dnm = null;
  private String fcX;
  private Button fkB;
  private EditText fkF;
  private TextView fkG;
  private TextView fkH;
  private Button fkI;
  private boolean fkJ = false;
  private String fky;
  
  private void Wc()
  {
    cancel();
    FW(1);
  }
  
  private boolean h(int paramInt1, int paramInt2, String paramString)
  {
    if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
      return true;
    }
    switch (paramInt2)
    {
    default: 
      return false;
    case -32: 
      h.a(this.mController.uMN, a.d.bind_mcontact_verify_err_unmatch_content, a.d.bind_mcontact_verify_tip, null);
      return true;
    case -33: 
      h.a(this.mController.uMN, a.d.bind_mcontact_verify_err_time_out_content, a.d.bind_mcontact_verify_tip, null);
      return true;
    case -34: 
      Toast.makeText(this, a.d.bind_mcontact_err_freq_limit, 0).show();
      return true;
    case -57: 
    case -1: 
      Toast.makeText(this.mController.uMN, a.d.app_err_system_busy_tip, 0).show();
      return true;
    case -41: 
      Toast.makeText(this.mController.uMN, a.d.bind_mcontact_err_format, 0).show();
      return true;
    }
    h.a(this.mController.uMN, a.d.bind_mcontact_err_BindPhone_NeedAdjust, a.d.app_tip, null);
    return true;
  }
  
  protected final int getLayoutId()
  {
    return a.b.security_account_verify;
  }
  
  protected final void initView()
  {
    this.bSe = getIntent().getStringExtra("binded_mobile");
    this.fky = getIntent().getStringExtra("auth_ticket");
    this.fkJ = getIntent().getBooleanExtra("re_open_verify", false);
    this.fkF = ((EditText)findViewById(a.a.bind_mcontact_verify_num));
    this.fkG = ((TextView)findViewById(a.a.mobile_number_tv));
    this.fkH = ((TextView)findViewById(a.a.resend_verify_code_tips_tv));
    this.fkI = ((Button)findViewById(a.a.resend_verify_code_btn));
    this.fkF.addTextChangedListener(new SecurityAccountVerifyUI.1(this));
    this.fkG.setText(bk.ZZ(this.bSe));
    this.fkH.setTag(Integer.valueOf(60));
    this.byQ = new am(new SecurityAccountVerifyUI.2(this), true);
    this.fkI.setOnClickListener(new SecurityAccountVerifyUI.3(this));
    if (!this.fkJ)
    {
      this.fkB = ((Button)findViewById(a.a.close_account_protect_btn));
      this.fkB.setVisibility(0);
      this.fkB.setOnClickListener(new SecurityAccountVerifyUI.4(this));
    }
    setBackBtn(new SecurityAccountVerifyUI.5(this));
    addTextOptionMenu(0, getString(a.d.app_nextstep), new SecurityAccountVerifyUI.6(this));
    enableOptionMenu(false);
    setMMTitle(a.d.safe_device_input_verify_code);
    this.byQ.S(1000L, 1000L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.byQ.stopTimer();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    g.Dk().b(145, this);
    g.Dk().b(132, this);
    super.onPause();
    if (!this.fkJ)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L600_200,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L600_200") + ",2");
    }
  }
  
  protected void onResume()
  {
    g.Dk().a(145, this);
    g.Dk().a(132, this);
    super.onResume();
    if (!this.fkJ)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L600_200,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L600_200") + ",1");
      com.tencent.mm.plugin.b.a.qi("L600_200");
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    switch (paramm.getType())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramm = (com.tencent.mm.modelfriend.a)paramm;
          if (paramm.rN() != 10) {
            break;
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            y.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
            return;
          }
          y.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        } while (h(paramInt1, paramInt2, paramString));
        Toast.makeText(this.mController.uMN, getString(a.d.safe_device_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        return;
        if (paramm.rN() != 11) {
          break;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.fky = paramm.NK();
          y.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.fky);
          paramInt1 = getIntent().getIntExtra("from_source", 1);
          Intent localIntent = new Intent();
          localIntent.putExtra("from_source", paramInt1);
          localIntent.putExtra("binded_mobile", this.bSe);
          switch (paramInt1)
          {
          case 4: 
          default: 
            FW(1);
            return;
          case 3: 
            localIntent.addFlags(67108864);
            localIntent.putExtra("auth_ticket", this.fky);
            paramm = getIntent().getStringExtra("WizardTransactionId");
            paramString = paramm;
            if (paramm == null) {
              paramString = "";
            }
            paramString = (Intent)uOD.get(paramString);
            uOD.clear();
            if (paramString != null) {
              com.tencent.mm.plugin.account.a.a.eUR.a(this, localIntent, paramString);
            }
            for (;;)
            {
              finish();
              return;
              com.tencent.mm.plugin.account.a.a.eUR.a(this, localIntent, null);
            }
          }
          localIntent.addFlags(67108864);
          localIntent.putExtra("auth_ticket", this.fky);
          com.tencent.mm.plugin.account.a.a.eUR.a(this, localIntent, null);
          finish();
          return;
        }
        y.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      } while (h(paramInt1, paramInt2, paramString));
      Toast.makeText(this.mController.uMN, getString(a.d.safe_device_verify_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
      y.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[] { Integer.valueOf(paramm.rN()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.security.a.f.m(true, true);
        paramString = new Intent(this, MySafeDeviceListUI.class);
        paramString.addFlags(67108864);
        startActivity(paramString);
        finish();
        return;
      }
    } while (h(paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(a.d.safe_device_verify_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI
 * JD-Core Version:    0.7.0.1
 */