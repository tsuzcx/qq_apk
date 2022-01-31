package com.tencent.mm.plugin.account.bind.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.at.b;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.so;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String bSe;
  private String countryCode = null;
  private String esg = null;
  private boolean faM = false;
  private boolean fbC = false;
  private boolean fbD = false;
  private EditText fbQ;
  private LinearLayout fbR;
  private TextView fbS;
  private TextView fbT;
  private TextView fbU;
  private CheckBox fbV;
  private LinearLayout fbW;
  private String fbX = null;
  private boolean fbY = false;
  private boolean fbZ = false;
  private i fbz;
  private boolean fca = false;
  private int fromScene = 0;
  
  private void We()
  {
    if ((this.fbC) || (this.fbD))
    {
      uOD.clear();
      FW(1);
      return;
    }
    int i;
    if (this.fbZ)
    {
      i = a.i.bind_mcontact_exit_content_for_change_mobile;
      if (!this.fbZ) {
        break label74;
      }
    }
    label74:
    for (int j = a.i.bind_mcontact_exit_tip_for_change_mobile;; j = a.i.bind_mcontact_exit_tip)
    {
      com.tencent.mm.ui.base.h.a(this, i, j, new BindMContactUI.1(this), null);
      return;
      i = a.i.bind_mcontact_exit_content;
      break;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindmcontact;
  }
  
  protected final void initView()
  {
    this.fbC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.fbD = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.fbY = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
    this.fbZ = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
    this.fca = getIntent().getBooleanExtra("is_bind_for_reset_pwd", false);
    this.faM = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    y.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.fbQ = ((EditText)findViewById(a.e.bind_mcontact_mobile));
    this.fbR = ((LinearLayout)findViewById(a.e.country_code_ll));
    this.fbT = ((TextView)findViewById(a.e.country_name));
    this.fbU = ((TextView)findViewById(a.e.country_code));
    this.fbV = ((CheckBox)findViewById(a.e.bind_mcontact_find_me_by_mobile_cb));
    this.fbW = ((LinearLayout)findViewById(a.e.bind_mcontact_find_me_by_mobile_ll));
    this.fbS = ((TextView)findViewById(a.e.setting_bind_mobile_binded_mobile));
    String str2;
    if (this.fbZ)
    {
      String str1 = (String)g.DP().Dz().get(6, null);
      if (!bk.bl(str1))
      {
        if (!str1.startsWith("+")) {
          break label518;
        }
        str2 = ar.Ga(str1);
        str1 = str1.substring(str2.length() + 1);
        new ar();
        str1 = ar.formatNumber(str2, str1);
        this.fbS.setText(getString(a.i.bind_mcontact_change_mobile_hint, new Object[] { str1 }));
      }
    }
    if ((this.esg != null) && (!this.esg.equals(""))) {
      this.fbT.setText(this.esg);
    }
    if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
      this.fbU.setText("+" + this.countryCode);
    }
    if ((this.fbX != null) && (!this.fbX.equals("")))
    {
      this.fbQ.setText(this.fbX);
      this.fbQ.setSelection(this.fbX.length());
    }
    for (;;)
    {
      if (b.Pf())
      {
        this.fbW.setVisibility(4);
        this.fbV.setChecked(true);
      }
      addTextOptionMenu(0, getString(a.i.app_nextstep), new BindMContactUI.3(this));
      this.fbQ.requestFocus();
      setBackBtn(new BindMContactUI.4(this));
      this.fbR.setOnClickListener(new BindMContactUI.5(this));
      return;
      label518:
      str2 = "86";
      break;
      g.DS().a(new BindMContactUI.2(this));
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
            com.tencent.mm.ui.base.h.a(this, getString(a.i.regbymobile_reg_verify_mobile_msg) + this.bSe, getString(a.i.regbymobile_reg_verify_mobile_title), new BindMContactUI.6(this), null);
            return;
          } while (paramIntent == null);
          paramIntent = paramIntent.getBundleExtra("result_data");
        } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("agree_privacy")));
        ai.l(new BindMContactUI.7(this), 100L);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("birthdayComfirmOK")));
    com.tencent.mm.ui.base.h.a(this, getString(a.i.regbymobile_reg_verify_mobile_msg) + this.bSe, getString(a.i.regbymobile_reg_verify_mobile_title), new BindMContactUI.8(this), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_title_bind);
    this.esg = bk.aM(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bk.aM(getIntent().getStringExtra("couttry_code"), "");
    this.fbX = bk.aM(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
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
      We();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI
 * JD-Core Version:    0.7.0.1
 */