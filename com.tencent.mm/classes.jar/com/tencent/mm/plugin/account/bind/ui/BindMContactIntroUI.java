package com.tencent.mm.plugin.account.bind.ui;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.at.b;
import com.tencent.mm.at.b.a;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements f
{
  private String bSe;
  private boolean faM = false;
  private String fbA = null;
  private String fbB = null;
  private boolean fbC = false;
  private boolean fbD = false;
  private int fbE = 0;
  private ImageView fbt;
  private TextView fbu;
  private TextView fbv;
  private Button fbw;
  private Button fbx;
  private l.a fby;
  private i fbz;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private void Wc()
  {
    XM();
    if (this.fbD)
    {
      cancel();
      finish();
      return;
    }
    FW(1);
  }
  
  private void cs(boolean paramBoolean)
  {
    Intent localIntent = new Intent(this, BindMContactUI.class);
    localIntent.putExtra("is_bind_for_safe_device", this.fbC);
    localIntent.putExtra("is_bind_for_contact_sync", this.fbD);
    localIntent.putExtra("is_bind_for_change_mobile", paramBoolean);
    Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
    if (!bk.bl((String)localObject))
    {
      localObject = b.i(this, (String)localObject, getString(a.i.country_code));
      if (localObject != null)
      {
        localIntent.putExtra("country_name", ((b.a)localObject).esg);
        localIntent.putExtra("couttry_code", ((b.a)localObject).esf);
      }
    }
    C(this, localIntent);
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindmcontact_intro;
  }
  
  protected final void initView()
  {
    this.fbC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
    this.fbD = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
    this.faM = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fbE = getIntent().getIntExtra("key_upload_scene", 0);
    this.fby = com.tencent.mm.plugin.account.friend.a.l.WP();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BindMContactIntroUI", "state " + this.fby);
    this.bSe = ((String)com.tencent.mm.kernel.g.DP().Dz().get(6, null));
    if ((this.bSe == null) || (this.bSe.equals(""))) {
      this.bSe = ((String)com.tencent.mm.kernel.g.DP().Dz().get(4097, null));
    }
    this.fbt = ((ImageView)findViewById(a.e.setting_bind_moblie_state_icon));
    this.fbu = ((TextView)findViewById(a.e.setting_bind_mobile_msg_title));
    this.fbv = ((TextView)findViewById(a.e.setting_bind_mobile_msg_hit));
    this.fbw = ((Button)findViewById(a.e.setting_bind_mobile_main_btn));
    this.fbx = ((Button)findViewById(a.e.setting_bind_mobile_sub_btn));
    this.fbw.setOnClickListener(new BindMContactIntroUI.1(this));
    this.fbx.setOnClickListener(new BindMContactIntroUI.12(this));
    if (getIntent().getBooleanExtra("skip", false)) {
      addTextOptionMenu(0, getString(a.i.app_ignore_it), new BindMContactIntroUI.21(this));
    }
    for (;;)
    {
      if ((this.fby == l.a.ffU) || (this.fby == l.a.ffT))
      {
        String str = com.tencent.mm.m.g.AA().getValue("ShowUnbindPhone");
        int i = 2;
        if (!bk.bl(str)) {
          i = bk.ZR(str);
        }
        if (i != 0) {
          addIconOptionMenu(1, a.d.mm_title_btn_menu, new BindMContactIntroUI.23(this, i));
        }
      }
      switch (BindMContactIntroUI.20.fbH[this.fby.ordinal()])
      {
      default: 
        return;
        setBackBtn(new BindMContactIntroUI.22(this));
      }
    }
    showOptionMenu(1, false);
    this.fbt.setImageResource(a.h.mobile_unbind_icon);
    this.fbv.setVisibility(0);
    this.fbx.setVisibility(8);
    this.fbu.setText(a.i.bind_mcontact_hint_title);
    this.fbv.setText(a.i.bind_mcontact_hint);
    this.fbw.setText(a.i.bind_mcontact_bind_btn_text);
    return;
    showOptionMenu(1, false);
    this.fbt.setImageResource(a.h.mobile_unbind_icon);
    this.fbv.setVisibility(0);
    this.fbx.setVisibility(0);
    this.fbu.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.bSe }));
    this.fbv.setText(a.i.bind_mcontact_unverify_mobile);
    this.fbw.setText(a.i.bind_mcontact_verify_btn_text);
    this.fbx.setText(a.i.bind_mcontact_del_btn_text);
    return;
    showOptionMenu(1, true);
    this.fbt.setImageResource(a.h.mobile_binded_icon);
    this.fbv.setVisibility(0);
    this.fbx.setVisibility(0);
    this.fbu.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.bSe }));
    this.fbv.setText(a.i.bind_mcontact_change_hint);
    this.fbw.setText(a.i.bind_mcontact_upload_btn_text);
    this.fbx.setText(a.i.bind_mcontact_change_mobile_text);
    return;
    showOptionMenu(1, true);
    this.fbt.setImageResource(a.h.mobile_binded_icon);
    this.fbv.setVisibility(0);
    this.fbx.setVisibility(0);
    this.fbu.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.bSe }));
    this.fbv.setText(a.i.bind_mcontact_change_hint);
    this.fbw.setText(a.i.bind_mcontact_friend_btn_text);
    this.fbx.setText(a.i.bind_mcontact_change_mobile_text);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.bSe);
    paramIntent = new com.tencent.mm.plugin.account.friend.a.y(com.tencent.mm.plugin.account.friend.a.y.fgq);
    com.tencent.mm.kernel.g.Dk().a(paramIntent, 0);
    getString(a.i.app_tip);
    this.tipDialog = h.b(this, getString(a.i.app_loading), true, new BindMContactIntroUI.19(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.Dk().a(132, this);
    com.tencent.mm.kernel.g.Dk().a(255, this);
    com.tencent.mm.kernel.g.Dk().a(254, this);
    setMMTitle(a.i.bind_mcontact_title_setting);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(132, this);
    com.tencent.mm.kernel.g.Dk().b(255, this);
    com.tencent.mm.kernel.g.Dk().b(254, this);
    if (this.fbz != null)
    {
      getContentResolver().unregisterContentObserver(this.fbz);
      this.fbz.recycle();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Wc();
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
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt[0] != 0) || (this.fbz == null));
    this.fbz.Xt();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + paramm.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramm.getType() == 132) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (((x)paramm).rN() == 3)
      {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
        if (bk.bl(this.fbB)) {
          break label159;
        }
        h.a(this, this.fbB, "", getString(a.i.app_i_known), new BindMContactIntroUI.26(this));
      }
    }
    label1025:
    for (;;)
    {
      return;
      label159:
      C(this, new Intent(this, BindMContactStatusUI.class));
      return;
      int i;
      if (com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label391;
        }
        if (this.tipDialog == null) {
          break;
        }
        this.tipDialog.dismiss();
        this.tipDialog = null;
        return;
        i = 0;
        switch (paramInt2)
        {
        default: 
          break;
        case -214: 
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null) {
            paramString.a(this, null, null);
          }
          i = 1;
          break;
        case -34: 
          Toast.makeText(this, a.i.bind_mcontact_err_freq_limit, 0).show();
          i = 1;
          break;
        case -43: 
          Toast.makeText(this, a.i.bind_mcontact_err_binded, 0).show();
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
        }
      }
      label391:
      if (paramm.getType() == 254)
      {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.fbB = ((com.tencent.mm.plugin.account.friend.a.y)paramm).WY().sNI;
          this.fbA = ((com.tencent.mm.plugin.account.friend.a.y)paramm).WX();
          if (!bk.bl(this.fbB))
          {
            paramString = new x(this.bSe, 3, "", 0, "");
            com.tencent.mm.kernel.g.Dk().a(paramString, 0);
            paramm = this.mController.uMN;
            getString(a.i.app_tip);
            this.tipDialog = h.b(paramm, getString(a.i.bind_mcontact_unbinding), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                com.tencent.mm.kernel.g.Dk().c(paramString);
              }
            });
            return;
          }
          paramString = new r(2);
          com.tencent.mm.kernel.g.Dk().a(paramString, 0);
          return;
        }
        if (paramInt2 == -3)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
          h.a(this.mController.uMN, getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new BindMContactIntroUI.2(this), new BindMContactIntroUI.3(this));
        }
      }
      else
      {
        label623:
        if (paramm.getType() == 255)
        {
          if (this.tipDialog != null)
          {
            this.tipDialog.dismiss();
            this.tipDialog = null;
          }
          if (paramInt2 != 0) {
            break label965;
          }
          paramString = new x(this.bSe, 3, "", 0, "");
          com.tencent.mm.kernel.g.Dk().a(paramString, 0);
          AppCompatActivity localAppCompatActivity = this.mController.uMN;
          getString(a.i.app_tip);
          this.tipDialog = h.b(localAppCompatActivity, getString(a.i.bind_mcontact_unbinding), true, new BindMContactIntroUI.10(this, paramString));
        }
      }
      for (;;)
      {
        if (paramm.getType() != 132) {
          break label1025;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if (((x)paramm).rN() != 3) {
          break;
        }
        if (paramInt2 != -82) {
          break label1027;
        }
        h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        return;
        if (paramInt2 == -81)
        {
          h.a(this, a.i.setting_unbind_qq_err_norbindqq, a.i.app_tip, new BindMContactIntroUI.4(this));
          break label623;
        }
        if (paramInt2 == -82)
        {
          h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new BindMContactIntroUI.5(this));
          break label623;
        }
        if (paramInt2 == -83)
        {
          h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new BindMContactIntroUI.6(this));
          break label623;
        }
        if (paramInt2 == -84)
        {
          h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new BindMContactIntroUI.7(this));
          break label623;
        }
        if (paramInt2 == -85)
        {
          h.a(this, a.i.setting_unbind_mobile_err_bindedbyother, a.i.app_tip, new BindMContactIntroUI.8(this));
          break label623;
        }
        if (paramInt2 != -86) {
          break label623;
        }
        h.a(this, a.i.setting_unbind_qq_err_qmail, a.i.app_tip, new BindMContactIntroUI.9(this));
        break label623;
        label965:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
        h.a(this.mController.uMN, getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new BindMContactIntroUI.11(this), new BindMContactIntroUI.13(this));
      }
    }
    label1027:
    if (paramInt2 == -83)
    {
      h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new BindMContactIntroUI.15(this));
      return;
    }
    if (paramInt2 == -84)
    {
      h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return;
    }
    if (paramInt2 == -85)
    {
      h.a(this, a.i.setting_unbind_mobile_err_bindedbyother, a.i.app_tip, new BindMContactIntroUI.17(this));
      return;
    }
    Toast.makeText(this, getString(a.i.bind_mcontact_unbind_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */