package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoCompleteTextView;
import com.tencent.mm.ui.base.h;
import java.util.Map;
import java.util.Set;

public class RegByEmailUI
  extends MMActivity
  implements f
{
  private static String[] fqj;
  private String cCt;
  private ProgressDialog dnm = null;
  private String fcX;
  private String fey;
  private MMAutoCompleteTextView fqe;
  private EditText fqf;
  private CheckBox fqg;
  private String fqh;
  private Map<String, String> fqi;
  
  private void goBack()
  {
    h.a(this, q.j.regby_email_cancel_registion_tip, q.j.regby_email_err_tip_title, q.j.app_ok, q.j.app_cancel, new RegByEmailUI.2(this), null);
  }
  
  protected final int getLayoutId()
  {
    return q.g.reg_by_email;
  }
  
  protected final void initView()
  {
    this.fqe = ((MMAutoCompleteTextView)findViewById(q.f.reg_email));
    this.fqf = ((EditText)findViewById(q.f.reg_password));
    this.fqg = ((CheckBox)findViewById(q.f.agree_cb));
    if (!bk.bl(this.fqh))
    {
      this.fqf.postDelayed(new RegByEmailUI.1(this), 500L);
      this.fqe.setText(this.fqh);
    }
    if (fqj != null)
    {
      c localc = new c(this, fqj, "@");
      this.fqe.setSpilter("@");
      this.fqe.setDropDownAnchor(q.f.reg_email_ll);
      this.fqe.setDropDownVerticalOffset(this.fqe.getPaddingBottom());
      this.fqe.setAdapter(localc);
    }
    findViewById(q.f.agree_btn).setOnClickListener(new RegByEmailUI.5(this));
    this.fqg.setOnCheckedChangeListener(new RegByEmailUI.6(this));
    addTextOptionMenu(0, getString(q.j.app_nextstep), new RegByEmailUI.7(this));
    enableOptionMenu(false);
    this.fqe.addTextChangedListener(new RegByEmailUI.8(this));
    this.fqf.addTextChangedListener(new RegByEmailUI.9(this));
    this.fqf.setOnEditorActionListener(new RegByEmailUI.10(this));
    this.fqf.setOnKeyListener(new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((66 != paramAnonymousInt) || (paramAnonymousKeyEvent.getAction() != 0) || (!RegByEmailUI.d(RegByEmailUI.this).isChecked())) {
          return false;
        }
        RegByEmailUI.c(RegByEmailUI.this);
        return true;
      }
    });
    setBackBtn(new RegByEmailUI.12(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getString(q.j.regby_email_title);
    if (d.spd) {
      paramBundle = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
    }
    setMMTitle(paramBundle);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.fqh = w.bS(this);
    y.i("MicroMsg.RegByEmailUI", "get google account:[%s]", new Object[] { this.fqh });
    this.fqi = j.eRu.bK(this);
    if ((this.fqi != null) && (!this.fqi.isEmpty()))
    {
      fqj = new String[this.fqi.size()];
      this.fqi.keySet().toArray(fqj);
    }
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
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
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R500_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R500_100") + ",2");
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R500_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R500_100") + ",1");
    com.tencent.mm.plugin.b.a.qi("R500_100");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.RegByEmailUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((this.dnm != null) && (this.dnm.isShowing()))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (paramm.getType() != 481) {
      y.e("MicroMsg.RegByEmailUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramm.getType()) });
    }
    for (;;)
    {
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.b.a.qj("R500_200");
        paramString = new Intent(this, EmailVerifyUI.class);
        paramString.putExtra("email_address", this.cCt);
        paramString.putExtra("password", this.fey);
        if ((this.fqi != null) && (!this.fqi.isEmpty()))
        {
          paramm = this.cCt.split("@");
          if ((paramm != null) && (paramm.length == 2))
          {
            paramm = paramm[1];
            paramString.putExtra("email_login_page", (String)this.fqi.get(paramm));
          }
        }
        startActivity(paramString);
        return;
      }
      int i;
      if (com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      while (i == 0)
      {
        if (bk.bl(paramString)) {
          break label525;
        }
        paramString = bn.s(paramString, "e");
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label525;
        }
        paramString = (String)paramString.get(".e.Content");
        if (bk.bl(paramString)) {
          break label525;
        }
        h.b(this, paramString, getString(q.j.regby_email_err_tip_title), true);
        return;
        switch (paramInt2)
        {
        default: 
          i = 0;
          break;
        case -7: 
          paramm = new StringBuilder();
          g.DN();
          paramm = paramm.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R20_email_duplicate_confirm,");
          g.DN();
          com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R20_email_duplicate_confirm") + ",3");
          h.a(this, q.j.regby_email_user_already_exist, q.j.regby_email_err_tip_title, q.j.regby_email_user_already_exist_op_signin, q.j.regby_email_user_already_exist_op_cancel, new RegByEmailUI.4(this), null);
          i = 1;
          break;
        case -111: 
          h.h(this, q.j.regby_email_invaild_email, q.j.regby_email_err_tip_title);
          i = 1;
          break;
        case -34: 
          Toast.makeText(this, q.j.regby_email_err_freq_limit, 0).show();
          i = 1;
          break;
        case -75: 
          h.h(this, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
          i = 1;
        }
      }
    }
    label525:
    Toast.makeText(this, getString(q.j.regby_email_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByEmailUI
 * JD-Core Version:    0.7.0.1
 */