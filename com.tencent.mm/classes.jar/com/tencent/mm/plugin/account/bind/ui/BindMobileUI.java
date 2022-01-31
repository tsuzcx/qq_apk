package com.tencent.mm.plugin.account.bind.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.at.b;
import com.tencent.mm.at.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class BindMobileUI
  extends MMWizardActivity
{
  private String bSe;
  private String countryCode = null;
  private String esg = null;
  private EditText fbQ;
  private LinearLayout fbR;
  private TextView fbT;
  private TextView fbU;
  private CheckBox fbV;
  private String fbX = null;
  private i fbz;
  private TextView fcA;
  private TextView fcB;
  private CheckBox fcC;
  private LinearLayout fcD;
  private ImageView fcE;
  private boolean fcF;
  private BindWordingContent fcr;
  private int fcs;
  private TextView fcy;
  private Button fcz;
  
  private void pz(String paramString)
  {
    String str1 = this.mController.uMN.getString(a.i.bind_mcontact_verify_mobile_number);
    String str2 = String.format("%s\n%s", new Object[] { this.mController.uMN.getString(a.i.bind_mcontact_verify_mobile_number_hint), paramString });
    h.a(this.mController.uMN, str2, str1, new BindMobileUI.1(this, paramString), null);
  }
  
  protected final int getLayoutId()
  {
    return a.f.bind_mcontact_input_phonenum;
  }
  
  protected final void initView()
  {
    this.fbQ = ((EditText)findViewById(a.e.bind_mcontact_mobile));
    this.fbR = ((LinearLayout)findViewById(a.e.country_code_ll));
    this.fbT = ((TextView)findViewById(a.e.country_name));
    this.fbU = ((TextView)findViewById(a.e.country_code));
    this.fcy = ((TextView)findViewById(a.e.bind_mcontact_title_tv));
    this.fcz = ((Button)findViewById(a.e.bind_m_contact_bind_mobile));
    this.fcA = ((TextView)findViewById(a.e.bind_mcontact_skip_bind));
    this.fcy.setText(getString(a.i.bind_mcontact_security_bander_hint));
    this.fcB = ((TextView)findViewById(a.e.bind_m_contact_bind_mobile_hint));
    this.fcD = ((LinearLayout)findViewById(a.e.bind_mcontact_sync_contact_cb_ll));
    this.fcC = ((CheckBox)findViewById(a.e.bind_mcontact_agree_cb_recom_friend));
    this.fbV = ((CheckBox)findViewById(a.e.bind_mcontact_agree_cb));
    this.fcE = ((ImageView)findViewById(a.e.bind_mcontact_icon));
    if (this.fcr != null)
    {
      if ((this.fcr.title != null) && (this.fcr.title.length() > 0)) {
        this.fcy.setText(this.fcr.title);
      }
      if ((this.fcr.content != null) && (this.fcr.content.length() > 0)) {
        this.fcB.setText(this.fcr.content);
      }
    }
    switch (this.fcr.boJ.intValue())
    {
    default: 
      switch (this.fcs)
      {
      default: 
        label328:
        if ((bk.bl(this.esg)) && (bk.bl(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.esg != null) && (!this.esg.equals(""))) {
        this.fbT.setText(this.esg);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.fbU.setText("+" + this.countryCode);
      }
      if ((this.fbX != null) && (!this.fbX.equals(""))) {
        this.fbQ.setText(this.fbX);
      }
      this.fcz.setOnClickListener(new BindMobileUI.2(this));
      this.fcA.setOnClickListener(new BindMobileUI.3(this));
      if (this.fcF)
      {
        setMMTitle(a.i.bind_mcontact_bind_for_chatroom_title);
        this.fcE.setVisibility(8);
        this.fcy.setText(a.i.bind_mcontact_for_chatroom_title);
        this.fcD.setVisibility(8);
        this.fcC.setVisibility(8);
        this.fcC.setChecked(false);
        this.fbV.setVisibility(0);
        this.fbV.setChecked(false);
        this.fcB.setVisibility(8);
        this.fcB.setText(getString(a.i.bind_mcontact_bind_mobile_warnning_hint));
        this.fcA.setVisibility(8);
        this.fcz.setText(a.i.bind_mcontact_bind_for_chatroom_title);
        setBackBtn(new BindMobileUI.4(this));
      }
      this.fbR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.h(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.e(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.eUR.b(paramAnonymousView, BindMobileUI.this);
        }
      });
      this.fbR.setOnClickListener(new BindMobileUI.6(this));
      return;
      this.fcE.setImageResource(a.d.bind_mcontact_protect);
      break;
      this.fcE.setImageResource(a.d.bind_mcontact_warning);
      break;
      this.fcE.setImageResource(a.d.bind_mcontact_reco_friends);
      break;
      this.fcD.setVisibility(0);
      this.fcC.setVisibility(0);
      this.fcB.setVisibility(8);
      break label328;
      this.fcD.setVisibility(8);
      this.fcC.setVisibility(8);
      this.fcB.setVisibility(0);
      break label328;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      y.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()" + (String)localObject);
      if (bk.bl((String)localObject))
      {
        y.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = b.i(this, (String)localObject, getString(a.i.country_code));
        if (localObject == null)
        {
          y.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.esg = ((b.a)localObject).esg;
          this.countryCode = ((b.a)localObject).esf;
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    default: 
      switch (paramInt1)
      {
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.esg = bk.aM(paramIntent.getStringExtra("country_name"), "");
                this.countryCode = bk.aM(paramIntent.getStringExtra("couttry_code"), "");
                if (!this.esg.equals("")) {
                  this.fbT.setText(this.esg);
                }
                if (this.countryCode.equals("")) {
                  break;
                }
                this.fbU.setText("+" + this.countryCode);
                break;
              } while (paramIntent == null);
              paramIntent = paramIntent.getBundleExtra("result_data");
            } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("agree_privacy")));
            pz(this.bSe);
            return;
          } while (paramIntent == null);
          paramIntent = paramIntent.getBundleExtra("result_data");
        } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("agree_privacy")));
        com.tencent.mm.plugin.account.a.b.a.b(this, getString(a.i.gdpr_login_verifybirthday_url, new Object[] { x.cqJ() }), 30765, true);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("birthdayComfirmOK")));
    pz(this.bSe);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_security_title);
    this.esg = bk.aM(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bk.aM(getIntent().getStringExtra("couttry_code"), "");
    this.fbX = bk.aM(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.fcr = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.fcs = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.fcF = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.fbz != null)
    {
      getContentResolver().unregisterContentObserver(this.fbz);
      this.fbz.recycle();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      FW(1);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        y.w("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      y.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt[0] != 0) || (this.fbz == null));
    this.fbz.Xt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */