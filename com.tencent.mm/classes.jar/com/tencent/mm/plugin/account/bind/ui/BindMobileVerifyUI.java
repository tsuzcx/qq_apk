package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.at.b;
import com.tencent.mm.h.a.so;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Timer;
import java.util.TimerTask;

public class BindMobileVerifyUI
  extends MMWizardActivity
  implements f
{
  private String bSe;
  private boolean fbC = false;
  private boolean fbY = false;
  private boolean fcF = false;
  private TextView fcI;
  private TextView fcJ;
  private boolean fcK = false;
  private Integer fcL = Integer.valueOf(15);
  private EditText fcd;
  private Button fcf;
  private BindWordingContent fcr;
  private int fcs;
  private boolean fct;
  private boolean fcu;
  private Timer mTimer;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void Wf()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindmcontact_verify;
  }
  
  protected final void initView()
  {
    this.bSe = ((String)g.DP().Dz().get(4097, null));
    this.fcd = ((EditText)findViewById(a.e.bind_mcontact_verify_num));
    this.fcI = ((TextView)findViewById(a.e.bind_mcontact_verify_mobile_num));
    this.fcJ = ((TextView)findViewById(a.e.bind_mcontact_sms_time_hint));
    this.fbC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.fcK = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.fbY = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
    Object localObject = (Button)findViewById(a.e.bind_mcontact_verify_btn);
    if ((this.bSe == null) || (this.bSe.equals(""))) {
      this.bSe = ((String)g.DP().Dz().get(6, null));
    }
    if ((this.bSe != null) && (this.bSe.length() > 0))
    {
      this.fcI.setVisibility(0);
      this.fcI.setText(this.bSe);
    }
    BindMobileVerifyUI.1 local1 = new BindMobileVerifyUI.1(this);
    this.fcd.setFilters(new InputFilter[] { local1 });
    this.fcf = ((Button)findViewById(a.e.bind_mcontact_voice_code));
    ((Button)localObject).setVisibility(8);
    this.fcJ.setText(getResources().getQuantityString(a.g.mobileverify_send_code_tip, this.fcL.intValue(), new Object[] { this.fcL }));
    if (this.mTimer == null)
    {
      this.mTimer = new Timer();
      localObject = new BindMobileVerifyUI.5(this);
      if (this.mTimer != null) {
        this.mTimer.schedule((TimerTask)localObject, 1000L, 1000L);
      }
    }
    addTextOptionMenu(0, getString(a.i.app_nextstep), new BindMobileVerifyUI.2(this));
    setBackBtn(new BindMobileVerifyUI.3(this));
    localObject = this.fcf;
    if (b.mA(this.bSe)) {}
    for (int i = 0;; i = 8)
    {
      ((Button)localObject).setVisibility(i);
      this.fcf.setOnClickListener(new BindMobileVerifyUI.4(this));
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(132, this);
    setMMTitle(a.i.bind_mcontact_title_verify);
    this.fcr = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.fcs = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.fct = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
    this.fcu = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
    this.fcF = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
  }
  
  public void onDestroy()
  {
    g.Dk().b(132, this);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    boolean bool2 = true;
    y.i("MicroMsg.BindMobileVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (((x)paramm).rN() != 2) {}
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
        if (((x)paramm).rN() == 2)
        {
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
          if (this.fcF)
          {
            boolean bool1;
            if (!this.fct)
            {
              bool1 = true;
              if (this.fcu) {
                break label247;
              }
            }
            for (;;)
            {
              BindMobileStatusUI.c(this, bool1, bool2);
              exit(-1);
              return;
              bool1 = false;
              break;
              label247:
              bool2 = false;
            }
          }
          if (!this.fcK) {
            ((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
          }
          paramString = new Intent(this, BindMobileStatusUI.class);
          paramString.putExtra("kstyle_bind_wording", this.fcr);
          paramString.putExtra("kstyle_bind_recommend_show", this.fcs);
          paramString.putExtra("Kfind_friend_by_mobile_flag", this.fct);
          paramString.putExtra("Krecom_friends_by_mobile_flag", this.fcu);
          C(this, paramString);
        }
      }
      else
      {
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
            h.a(this, a.i.bind_mcontact_verify_err_unmatch_content, a.i.bind_mcontact_verify_tip, null);
            i = 1;
            break;
          case -33: 
            h.a(this, a.i.bind_mcontact_verify_err_time_out_content, a.i.bind_mcontact_verify_tip, null);
            i = 1;
          }
        }
      }
    }
  }
  
  protected void onStop()
  {
    Wf();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI
 * JD-Core Version:    0.7.0.1
 */