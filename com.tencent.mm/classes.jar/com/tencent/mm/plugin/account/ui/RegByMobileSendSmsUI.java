package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class RegByMobileSendSmsUI
  extends MMActivity
  implements f
{
  private String aVr;
  private String bJY;
  private int countDown = 15;
  private String flx = "";
  private int foZ;
  private g foc;
  private String fog = "";
  private String foj;
  private String fqJ = "";
  private String fqK = "";
  private ProgressDialog fqL;
  private int fqM;
  private Button fqN;
  private Button fqO;
  private am fqP;
  private SecurityImage fqQ;
  private boolean fqq;
  
  private void goBack()
  {
    h.a(this, getString(q.j.regbymobile_reg_quit_send_sms), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        RegByMobileSendSmsUI.q(RegByMobileSendSmsUI.this);
        RegByMobileSendSmsUI.this.finish();
      }
    }, null);
  }
  
  private k qf(String paramString)
  {
    k localk = new k(paramString);
    y.d("MicroMsg.RegByMobileSendSmsUI", "content: %s", new Object[] { paramString });
    int i = paramString.indexOf(' ') + 1;
    localk.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(q.d.HugersTextSize)), i, paramString.length(), 33);
    localk.setSpan(new ForegroundColorSpan(getResources().getColor(q.c.green_text_color)), i, paramString.length(), 33);
    return localk;
  }
  
  private void stopTimer()
  {
    if (this.fqP != null) {
      this.fqP.stopTimer();
    }
    this.fqO.setText(q.j.regbymobile_reg_no_sim_send_sms_btn_title);
    this.fqO.setEnabled(true);
  }
  
  protected final int getLayoutId()
  {
    return q.g.regbymobile_send_sms;
  }
  
  protected final void initView()
  {
    super.initView();
    ((TextView)findViewById(q.f.send_sms_tip)).setText(getString(q.j.regbymobile_reg_send_sms_tip, new Object[] { this.fqJ }));
    ((TextView)findViewById(q.f.send_sms_content)).setText(qf(getString(q.j.regbymobile_reg_send_sms_content, new Object[] { this.flx })));
    ((TextView)findViewById(q.f.send_sms_to)).setText(qf(getString(q.j.regbymobile_reg_send_sms_to, new Object[] { this.fqK })));
    this.fqN = ((Button)findViewById(q.f.send_sms_btn));
    this.fqO = ((Button)findViewById(q.f.go_to_reg_btn));
    if (bk.H(new String[] { this.fqJ, this.fqK, this.flx }))
    {
      this.fqN.setEnabled(false);
      this.fqO.setEnabled(false);
      if (!bk.bl(q.getSimCountryIso())) {
        break label236;
      }
      this.fqN.setVisibility(8);
    }
    for (;;)
    {
      setMMTitle(q.j.regbymobile_reg_send_sms_title);
      setBackBtn(new RegByMobileSendSmsUI.10(this));
      return;
      this.fqO.setOnClickListener(new RegByMobileSendSmsUI.1(this));
      break;
      label236:
      this.fqN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setAction("android.intent.action.SENDTO");
          paramAnonymousView.setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(RegByMobileSendSmsUI.this)));
          paramAnonymousView.putExtra("sms_body", RegByMobileSendSmsUI.c(RegByMobileSendSmsUI.this));
          try
          {
            RegByMobileSendSmsUI.this.startActivity(paramAnonymousView);
            RegByMobileSendSmsUI.this.overridePendingTransition(q.a.slide_right_in, q.a.slide_left_out);
            return;
          }
          catch (Exception paramAnonymousView)
          {
            y.e("MicroMsg.RegByMobileSendSmsUI", paramAnonymousView.getMessage());
          }
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.foZ = getIntent().getIntExtra("key_reg_style", 1);
    this.fqJ = bk.pm(getIntent().getStringExtra("from_mobile"));
    this.fqK = bk.pm(getIntent().getStringExtra("to_mobile"));
    this.flx = bk.pm(getIntent().getStringExtra("verify_code"));
    this.fog = bk.pm(getIntent().getStringExtra("regsession_id"));
    this.aVr = bk.pm(getIntent().getStringExtra("kintent_nickname"));
    this.foj = bk.pm(getIntent().getStringExtra("kintent_password"));
    this.fqq = getIntent().getBooleanExtra("kintent_hasavatar", false);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.kernel.g.Dk().a(145, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.RegByMobileSendSmsUI", "errType %s, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.fqL != null) {
      this.fqL.dismiss();
    }
    if ((paramm.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramm).rN() == 15))
    {
      paramm = (com.tencent.mm.modelfriend.a)paramm;
      this.bJY = paramm.NJ();
      if (paramInt2 == 0)
      {
        stopTimer();
        if (this.foZ == 1)
        {
          com.tencent.mm.kernel.g.Dk().a(126, this);
          paramString = new s("", this.foj, this.aVr, 0, "", this.fqJ, "", "", this.bJY, 1, "", "", "", true, this.fqq);
          paramString.ne(this.fog);
          paramString.jc(1);
          com.tencent.mm.kernel.g.Dk().a(paramString, 0);
          getString(q.j.app_tip);
          this.fqL = h.b(this, getString(q.j.regbyqq_reg_waiting), true, new RegByMobileSendSmsUI.11(this, paramString));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramString = new Intent();
            paramString.putExtra("regsetinfo_ticket", this.bJY);
            paramString.putExtra("regsetinfo_user", this.fqJ);
            paramString.putExtra("regsession_id", this.fog);
            paramString.putExtra("mobile_check_type", 1);
            paramString.putExtra("regsetinfo_ismobile", 4);
            paramString.putExtra("regsetinfo_NextControl", paramm.NP());
            paramString.putExtra("key_reg_style", this.foZ);
            paramString.setClass(this, RegSetInfoUI.class);
            startActivity(paramString);
            return;
            if (paramInt2 == -35)
            {
              stopTimer();
              paramString = com.tencent.mm.i.a.eI(paramString);
              if (paramString != null)
              {
                paramString.a(this, new RegByMobileSendSmsUI.12(this, paramm), new RegByMobileSendSmsUI.13(this));
                return;
              }
              h.a(this, getString(q.j.bind_mcontact_already_bind_relogin), null, new RegByMobileSendSmsUI.14(this, paramm), new RegByMobileSendSmsUI.15(this));
              return;
            }
            if (paramInt2 == -212)
            {
              stopTimer();
              paramString = new Intent(this, MobileLoginOrForceReg.class);
              paramString.putExtra("ticket", this.bJY);
              paramString.putExtra("moble", this.fqJ);
              paramString.putExtra("regsession_id", this.fog);
              paramString.putExtra("next_controll", paramm.NP());
              paramString.putExtra("username", paramm.getUsername());
              paramString.putExtra("password", paramm.NI());
              paramString.putExtra("nickname", paramm.NV());
              paramString.putExtra("avatar_url", paramm.NU());
              paramString.putExtra("mobile_check_type", 1);
              paramString.putExtra("kintent_hasavatar", this.fqq);
              paramString.putExtra("kintent_nickname", this.aVr);
              paramString.putExtra("kintent_password", this.foj);
              paramString.putExtra("key_reg_style", this.foZ);
              startActivity(paramString);
              return;
            }
          } while ((bk.bl(paramString)) || (this.fqM < 4));
          paramString = com.tencent.mm.i.a.eI(paramString);
        } while ((paramString == null) || (!paramString.a(this, null, null)));
        return;
      } while (paramm.getType() != 126);
      s locals = (s)paramm;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.fqQ == null)
        {
          this.fqQ = SecurityImage.a.a(this, q.j.regbyqq_secimg_title, 0, locals.QA(), locals.Qz(), "", new RegByMobileSendSmsUI.16(this, locals), null, new RegByMobileSendSmsUI.2(this), new RegByMobileSendSmsUI.3(this, locals));
          return;
        }
        this.fqQ.a(0, ((s)paramm).QA(), ((s)paramm).Qz(), "");
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.fqJ;
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.bF(true);
        if (this.fqq)
        {
          paramm = com.tencent.mm.compatible.util.e.dzK + "temp.avatar";
          String str = com.tencent.mm.compatible.util.e.dzK + "temp.avatar.hd";
          com.tencent.mm.vfs.e.aA(paramm, str);
          com.tencent.mm.vfs.e.deleteFile(paramm);
          c.c(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, paramm);
          new com.tencent.mm.ag.m(this, com.tencent.mm.compatible.util.e.dzK + "temp.avatar").a(new RegByMobileSendSmsUI.4(this, locals, paramString), new RegByMobileSendSmsUI.5(this, locals, paramString));
          return;
        }
        this.bJY = locals.QI();
        at.dVC.Y("login_user_name", paramString);
        paramString = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
        paramString.addFlags(67108864);
        paramString.putExtra("LauncherUI.enter_from_reg", true);
        startActivity(paramString);
        finish();
        com.tencent.mm.plugin.b.a.qj("RE900_100");
        paramString = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        paramString = paramString.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_600") + ",4");
        return;
      }
      paramString = com.tencent.mm.i.a.eI(paramString);
    } while (paramString == null);
    paramString.a(this, null, null);
  }
  
  protected void onStop()
  {
    super.onStop();
    stopTimer();
    com.tencent.mm.kernel.g.Dk().b(145, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI
 * JD-Core Version:    0.7.0.1
 */