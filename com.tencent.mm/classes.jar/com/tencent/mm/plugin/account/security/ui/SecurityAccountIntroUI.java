package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI
  extends MMWizardActivity
  implements f
{
  private String bSe;
  private ProgressDialog dnm = null;
  private String fcX;
  private boolean fkA = false;
  private Button fkB;
  private String fky;
  private String fkz;
  private String jumpUrl;
  
  private void Wc()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    cancel();
    FW(1);
  }
  
  protected final int getLayoutId()
  {
    return a.b.security_account_intro;
  }
  
  protected final void initView()
  {
    setMMTitle(a.d.safe_device_verify_phone_title);
    findViewById(a.a.operation_btn).setOnClickListener(new SecurityAccountIntroUI.1(this));
    if (!this.fkA)
    {
      this.fkB = ((Button)findViewById(a.a.close_account_protect_btn));
      if (!bk.bl(this.fkz)) {
        this.fkB.setText(this.fkz);
      }
      this.fkB.setVisibility(0);
      this.fkB.setOnClickListener(new SecurityAccountIntroUI.2(this));
    }
    setBackBtn(new SecurityAccountIntroUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.fky = getIntent().getStringExtra("auth_ticket");
    this.bSe = getIntent().getStringExtra("binded_mobile");
    this.fkA = getIntent().getBooleanExtra("re_open_verify", false);
    paramBundle = getIntent().getStringExtra("close_safe_device_style");
    y.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[] { bk.aac(this.fky), paramBundle });
    if (!bk.bl(paramBundle))
    {
      paramBundle = bn.s(paramBundle, "wording");
      if (paramBundle != null)
      {
        this.fkz = ((String)paramBundle.get(".wording.title"));
        this.jumpUrl = ((String)paramBundle.get(".wording.url"));
        y.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[] { this.fkz, this.jumpUrl });
      }
    }
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
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
    super.onPause();
    g.Dk().b(145, this);
    g.Dk().b(132, this);
    if (!this.fkA)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L600_100,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L600_100") + ",2");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(145, this);
    g.Dk().a(132, this);
    if (!this.fkA)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L600_100,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L600_100") + ",1");
      com.tencent.mm.plugin.b.a.qi("L600_100");
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!this.fkA) {}
      for (paramString = ((com.tencent.mm.modelfriend.a)paramm).NK();; paramString = ((ib)((x)paramm).dmK.ecF.ecN).syt)
      {
        y.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.fky + "duanyi test authTicket_check = " + paramString);
        paramm = new Intent(this, SecurityAccountVerifyUI.class);
        paramm.putExtra("auth_ticket", paramString);
        paramm.putExtra("binded_mobile", this.bSe);
        paramm.putExtra("re_open_verify", this.fkA);
        paramm.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
        C(this, paramm);
        if (getIntent().getIntExtra("from_source", 1) == 3) {
          finish();
        }
        return;
      }
    }
    int i;
    switch (paramInt2)
    {
    default: 
      i = 0;
    }
    while ((i == 0) && (!com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)))
    {
      Toast.makeText(this, getString(a.d.safe_device_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
      Toast.makeText(this, a.d.app_err_system_busy_tip, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, a.d.bind_mcontact_err_freq_limit, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, a.d.bind_mcontact_err_format, 0).show();
      i = 1;
      continue;
      h.a(this, a.d.bind_mcontact_err_BindPhone_NeedAdjust, a.d.app_tip, null);
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI
 * JD-Core Version:    0.7.0.1
 */