package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private String bJY = null;
  private TextView foy;
  private TextView frb;
  private View frc;
  private View frd;
  private TextView fre;
  public View frf;
  public EditText frg;
  private String frh = null;
  private boolean fri = false;
  public boolean frj;
  private int frk = 0;
  private bmk frl = null;
  
  protected final m XZ()
  {
    if (bk.bl(this.bJY)) {
      this.bJY = ((String)g.DP().Dz().get(77830, null));
    }
    return new com.tencent.mm.modelsimple.y(this.fsy, this.bJY, this.frk, this.frl);
  }
  
  protected final String Ya()
  {
    return ((EditText)findViewById(q.f.regbymobilereg_pass_et)).getText().toString();
  }
  
  protected final String Yb()
  {
    return ((EditText)findViewById(q.f.regbymobilereg_pass_again_et)).getText().toString();
  }
  
  protected final void Yg()
  {
    if ((bk.bl(this.bJY)) && (this.frj))
    {
      ab localab = new ab(this.frg.getText().toString(), "", "", "");
      g.Dk().a(localab, 0);
      getString(q.j.app_tip);
      this.dnm = h.b(this, getString(q.j.app_sending), false, null);
      return;
    }
    super.Yg();
  }
  
  public final boolean Yh()
  {
    return true;
  }
  
  protected final void a(a.a parama)
  {
    switch (RegByMobileSetPwdUI.3.fjL[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      h.h(this, q.j.regbymobile_reg_setpwd_alert_diff, q.j.regbymobile_reg_setpwd_alert_title);
      return;
    case 2: 
      h.h(this, q.j.regbymobile_reg_setpwd_alert_more_byte, q.j.regbymobile_reg_setpwd_alert_title);
      return;
    case 3: 
      h.h(this, q.j.verify_password_all_num_tip, q.j.regbymobile_reg_setpwd_alert_title);
      return;
    }
    h.h(this, q.j.verify_password_tip, q.j.regbymobile_reg_setpwd_alert_title);
  }
  
  protected final int getLayoutId()
  {
    return q.g.regbymobilesetpwd_reg;
  }
  
  protected final boolean i(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      finish();
      return true;
    }
    return h(paramInt1, paramInt2, paramString);
  }
  
  protected final void initView()
  {
    if (!this.fsA) {
      czr();
    }
    setMMTitle(q.j.regbymobile_reg_setpwd_title);
    this.frb = ((TextView)findViewById(q.f.username_tv));
    this.frd = findViewById(q.f.account_container);
    this.foy = ((TextView)findViewById(q.f.regbymobilerag_pass_hint));
    this.fre = ((TextView)findViewById(q.f.account_wording));
    if ((this.frh != null) && (this.frh.length() > 0)) {
      this.foy.setText(this.frh);
    }
    this.frf = findViewById(q.f.regbymobile_reg_old_pwd_container);
    this.frg = ((EditText)this.frf.findViewById(q.f.regbymobilereg_old_pwd_et));
    this.frc = findViewById(q.f.forgot_old_password);
    this.frc.setOnClickListener(new RegByMobileSetPwdUI.1(this));
    if ((this.fri) || (!g.DN().Dc()))
    {
      this.frd.setVisibility(8);
      localObject1 = (TextView)findViewById(q.f.old_password_wording);
      localObject2 = (TextView)findViewById(q.f.password_wording);
      TextView localTextView = (TextView)findViewById(q.f.confirm_wording);
      EditText localEditText1 = (EditText)findViewById(q.f.regbymobilereg_pass_et);
      EditText localEditText2 = (EditText)findViewById(q.f.regbymobilereg_pass_again_et);
      if (!x.cqF())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        localTextView.setTextSize(1, 14.0F);
        localEditText1.setTextSize(1, 14.0F);
        localEditText2.setTextSize(1, 14.0F);
      }
      float f1 = this.fre.getPaint().measureText(this.fre.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      float f4 = localTextView.getPaint().measureText(localTextView.getText().toString());
      f1 = Math.max(Math.max(Math.max(f1, f3), f4), f2);
      ((TextView)localObject1).setWidth((int)f1);
      this.fre.setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      ((TextView)localObject2).setWidth((int)f1);
      return;
    }
    this.frd.setVisibility(0);
    Object localObject2 = q.Gk();
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2))
    {
      localObject2 = q.Gj();
      localObject1 = localObject2;
      if (ad.aaX((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (bk.bl((String)localObject1))
    {
      localObject2 = (String)g.DP().Dz().get(6, null);
      localObject1 = (String)g.DP().Dz().get(5, null);
      if (!bk.bl((String)localObject2)) {
        if (bk.aaa((String)localObject2).booleanValue())
        {
          new ar();
          localObject1 = "86";
          if (!((String)localObject2).startsWith("+")) {
            break label699;
          }
          localObject2 = ((String)localObject2).replace("+", "");
          localObject1 = ar.Ga((String)localObject2);
          if (localObject1 == null) {
            break label696;
          }
          localObject2 = ((String)localObject2).substring(((String)localObject1).length());
        }
      }
    }
    label696:
    label699:
    for (;;)
    {
      localObject1 = ar.formatNumber((String)localObject1, (String)localObject2);
      this.fre.setText(q.j.settings_mobile);
      this.frb.setText((CharSequence)localObject1);
      this.foy.setText(q.j.regbymobile_reg_setpwd_title_mobile);
      break;
      if (!bk.bl((String)localObject1))
      {
        this.frb.setText((CharSequence)localObject1);
        this.fre.setText(q.j.settings_email_addr);
        this.foy.setText(q.j.regbymobile_reg_setpwd_title_email);
        break;
      }
      this.frd.setVisibility(8);
      break;
      this.fre.setText(q.j.settings_username);
      this.frb.setText((CharSequence)localObject1);
      break;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("setpwd_ticket");
      com.tencent.mm.sdk.platformtools.y.i("MicorMsg.RegByMobileSetPwdUI", "get reset pwd ticket %s", new Object[] { paramIntent });
      if (!bk.bl(paramIntent))
      {
        this.bJY = paramIntent;
        this.frk = 6;
        this.frf.setVisibility(8);
        this.frc.setVisibility(8);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.frh = getIntent().getStringExtra("kintent_hint");
    this.fsA = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.fri = getIntent().getBooleanExtra("from_unbind", false);
    g.Dk().a(384, this);
    g.Dk().a(255, this);
    initView();
    paramBundle = bk.ZM(av.HD().getString("_auth_key", ""));
    fa localfa = new fa();
    if (!bk.bE(paramBundle)) {}
    for (this.frl = new bmk().bs(paramBundle);; this.frl = new bmk().bs(new byte[0])) {
      try
      {
        localfa.aH(paramBundle);
        paramBundle = new r(1);
        g.Dk().a(paramBundle, 0);
        getString(q.j.app_tip);
        this.dnm = h.b(this, getString(q.j.app_loading), false, null);
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicorMsg.RegByMobileSetPwdUI", paramBundle, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g.Dk().b(384, this);
    g.Dk().b(255, this);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("setpwd_ticket");
    com.tencent.mm.sdk.platformtools.y.i("MicorMsg.RegByMobileSetPwdUI", "onNewIntent get reset pwd ticket %s", new Object[] { paramIntent });
    if (!bk.bl(paramIntent))
    {
      this.bJY = paramIntent;
      this.frk = 4;
      this.frf.setVisibility(8);
      this.frc.setVisibility(8);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicorMsg.RegByMobileSetPwdUI", "errorCode %d, errorMsg %s, scene %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm });
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    if (paramm.getType() == 255) {
      if (((r)paramm).ezS == 1)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label91;
        }
        this.frf.setVisibility(0);
        this.frc.setVisibility(0);
        this.frj = true;
      }
    }
    label91:
    while (paramm.getType() != 384)
    {
      do
      {
        return;
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          this.frj = false;
          return;
        }
        this.frf.setVisibility(0);
        this.frc.setVisibility(0);
        paramString = com.tencent.mm.i.a.eI(paramString);
      } while (paramString == null);
      com.tencent.mm.sdk.platformtools.y.i("MicorMsg.RegByMobileSetPwdUI", "summertips errCode[%d], showType[%d], url[%s], desc[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramString.showType), paramString.url, paramString.desc });
      h.a(this, paramString.desc, paramString.bGw, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          RegByMobileSetPwdUI.this.finish();
        }
      });
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.DP().Dz().o(77830, ((ab)paramm).NJ());
      Yu();
      return;
    }
    h.h(this, q.j.regbymobile_reg_setpwd_old_pwd_alert, q.j.app_tip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI
 * JD-Core Version:    0.7.0.1
 */