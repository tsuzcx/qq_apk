package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.friend.a.r.a;
import com.tencent.mm.plugin.account.friend.a.r.b;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI
  extends MMActivity
  implements f
{
  private ProgressDialog dnm = null;
  private String fcX;
  private TextView flp;
  private TextView flq;
  private MMAutoSwitchEditTextView flr;
  private Button fls;
  private Button flt;
  private String flu;
  private String flv;
  private String flw;
  private String flx;
  private boolean fly = false;
  
  private void goBack()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return q.g.verify_email_address;
  }
  
  protected final void initView()
  {
    setMMTitle(q.j.regby_email_verify_email);
    this.flp = ((TextView)findViewById(q.f.verify_email_hint));
    String str = getString(q.j.regby_email_input_verify_tip);
    this.flp.setText(Html.fromHtml(str));
    this.flq = ((TextView)findViewById(q.f.email_address));
    this.flu = getIntent().getStringExtra("email_address");
    if (!bk.bl(this.flu))
    {
      this.flq.setText(this.flu);
      this.flw = getIntent().getStringExtra("password");
      this.flv = getIntent().getStringExtra("email_login_page");
      y.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[] { this.flu, this.flv });
      this.flr = ((MMAutoSwitchEditTextView)findViewById(q.f.auto_switch_ll));
      this.flr.setOnInputFinished(new EmailVerifyUI.1(this));
      this.flr.setOnTextChanged(new EmailVerifyUI.2(this));
      this.flt = ((Button)findViewById(q.f.re_send_verify_code_btn));
      this.flt.setOnClickListener(new EmailVerifyUI.3(this));
      this.fls = ((Button)findViewById(q.f.open_browser_btn));
      if ((!bk.bl(this.flv)) && (!bk.bl(this.flu))) {
        break label304;
      }
      this.fls.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new EmailVerifyUI.5(this));
      addTextOptionMenu(0, getString(q.j.app_nextstep), new EmailVerifyUI.6(this));
      enableOptionMenu(false);
      return;
      y.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
      break;
      label304:
      this.fls.setVisibility(0);
      this.fls.setOnClickListener(new EmailVerifyUI.4(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    this.fcX = com.tencent.mm.plugin.b.a.YA();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    g.Dk().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R500_200,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R500_200") + ",2");
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R500_200,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R500_200") + ",1");
    com.tencent.mm.plugin.b.a.qi("R500_200");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    this.fly = false;
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (paramm.getType() != 481) {
      y.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramm.getType()) });
    }
    int j;
    label579:
    do
    {
      for (;;)
      {
        return;
        j = ((r.a)((z)paramm).edR.Kv()).ffZ.syV;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (j == 2)
          {
            com.tencent.mm.plugin.b.a.qj("R200_900_email");
            paramString = new Intent(this, RegSetInfoUI.class);
            paramString.putExtra("regsetinfo_ticket", ((r.b)((z)paramm).edR.HF()).fga.sRr);
            paramString.putExtra("regsetinfo_user", this.flu);
            paramString.putExtra("regsetinfo_ismobile", 3);
            paramString.putExtra("regsetinfo_NextStyle", ((z)paramm).QJ());
            paramString.putExtra("regsetinfo_pwd", this.flw);
            paramString.putExtra("regsetinfo_bind_email", this.flu);
            startActivity(paramString);
            return;
          }
          if (j == 1)
          {
            paramString = new StringBuilder();
            g.DN();
            paramString = paramString.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
            g.DN();
            com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R22_resend_email_code_alert") + ",3");
            h.bC(this, getString(q.j.regby_email_send_verify_code_ok));
            return;
          }
          y.e("MicroMsg.EmailVerifyUI", "err opcode");
          return;
        }
        int i;
        if (com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
          i = 1;
        }
        while (i == 0)
        {
          if (j != 2) {
            break label579;
          }
          Toast.makeText(this, getString(q.j.regby_email_verify_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
          return;
          switch (paramInt2)
          {
          default: 
            i = 0;
            break;
          case -32: 
            h.a(this, q.j.regby_email_err_unmatch_content, q.j.regby_email_err_tip_title, null);
            paramString = new StringBuilder();
            g.DN();
            paramString = paramString.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R500_260,");
            g.DN();
            com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R500_260") + ",3");
            i = 1;
            break;
          case -33: 
            h.a(this, q.j.regby_email_err_time_out_content, q.j.regby_email_err_tip_title, null);
            i = 1;
            break;
          case -34: 
            Toast.makeText(this, q.j.regby_email_err_freq_limit, 0).show();
            i = 1;
          }
        }
      }
    } while (j != 1);
    Toast.makeText(this, getString(q.j.regby_email_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI
 * JD-Core Version:    0.7.0.1
 */