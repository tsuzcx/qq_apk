package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements f
{
  private String cCL;
  private String cCM;
  private ProgressDialog ecf;
  private boolean faU = false;
  private String faV;
  private boolean faW = false;
  private boolean faX = false;
  private boolean faY = false;
  private Bundle faZ;
  private boolean fba = false;
  private boolean fbb = false;
  private TextView fbc;
  private TextView fbd;
  private View fbe;
  private MMSwitchBtn fbf;
  private TextView fbg;
  private TextView fbh;
  private TextView fbi;
  private String fbj;
  private String fbk;
  private String fbl;
  private String fbm;
  private String name;
  private int status;
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    this.fbi.setVisibility(8);
    if (paramBoolean1)
    {
      this.fbd.setVisibility(8);
      this.fbc.setVisibility(0);
      py(paramString);
      this.fbe.setVisibility(0);
      this.fbg.setVisibility(8);
      if (paramBoolean2) {
        this.fbh.setVisibility(0);
      }
      this.fbf.setCheck(paramBoolean3);
      this.fbf.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void cr(boolean paramAnonymousBoolean)
        {
          BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
        }
      });
      return;
    }
    this.fbc.setVisibility(8);
    this.fbc.setText(getString(a.i.contact_info_linkedin_account_info_unbind));
    this.fbd.setVisibility(0);
    this.fbe.setVisibility(8);
    this.fbg.setVisibility(0);
    this.fbh.setVisibility(8);
  }
  
  private void aZ()
  {
    int i = 1;
    if ((this.faX) && (this.faZ == null))
    {
      y.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      return;
    }
    if (this.faY)
    {
      a(this.faU, false, this.name, this.faW);
      return;
    }
    if (this.faX)
    {
      if ((this.faU) && (this.faV.equals(this.cCL))) {}
      boolean bool;
      for (;;)
      {
        String str = this.cCM;
        bool = this.faW;
        this.fbc.setVisibility(0);
        py(str);
        this.fbe.setVisibility(0);
        this.fbh.setVisibility(8);
        if (i == 0) {
          break;
        }
        this.fbd.setVisibility(8);
        this.fbg.setVisibility(8);
        this.fbi.setVisibility(8);
        this.fbf.setCheck(bool);
        this.fbf.setSwitchListener(new MMSwitchBtn.a()
        {
          public final void cr(boolean paramAnonymousBoolean)
          {
            BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
          }
        });
        return;
        i = 0;
      }
      this.fbd.setVisibility(0);
      this.fbg.setVisibility(0);
      this.fbi.setVisibility(0);
      this.fbf.setCheck(bool);
      this.fbf.setSwitchListener(new BindLinkedInUI.2(this));
      return;
    }
    a(this.faU, true, this.name, this.faW);
  }
  
  private void cq(boolean paramBoolean)
  {
    if (this.faZ == null)
    {
      y.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      return;
    }
    if (this.fbf.wjS) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.cCL, this.cCM, "", this.fbj, this.fbk, this.fbl, this.fbm);
      if (!paramBoolean) {
        this.ecf = com.tencent.mm.ui.base.h.b(this, getString(a.i.loading_tips), false, new BindLinkedInUI.11(this, locala));
      }
      g.Dk().a(locala, 0);
      return;
    }
  }
  
  private void goBack()
  {
    if (this.faX)
    {
      if (this.fbb)
      {
        Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
        localIntent.addFlags(603979776);
        localIntent.putExtra("preferred_tab", 2);
        startActivity(localIntent);
        return;
      }
      setResult(-1);
      finish();
      return;
    }
    setResult(-1);
    finish();
  }
  
  private void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.status |= 0x400000;
      if (!paramBoolean1) {
        break label120;
      }
    }
    label120:
    for (int i = 1;; i = 2)
    {
      g.DP().Dz().o(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        zr localzr = new zr();
        localzr.sYS = 33;
        localzr.nfn = i;
        ((j)g.r(j.class)).Fv().b(new i.a(23, localzr));
        com.tencent.mm.plugin.account.a.a.eUS.tk();
      }
      return;
      this.status &= 0xFFBFFFFF;
      break;
    }
  }
  
  private void py(String paramString)
  {
    int i = getString(a.i.contact_info_linkedin_account_info_binded).indexOf("%s");
    Object localObject = getString(a.i.contact_info_linkedin_account_info_binded, new Object[] { paramString });
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    ((Spannable)localObject).setSpan(new BindLinkedInUI.12(this), i, paramString.length() + i, 33);
    this.fbc.setText((CharSequence)localObject);
  }
  
  private void xK()
  {
    boolean bool2 = true;
    this.faV = ((String)g.DP().Dz().get(286721, null));
    if (!bk.bl(this.faV))
    {
      bool1 = true;
      this.faU = bool1;
      this.name = ((String)g.DP().Dz().get(286722, null));
      this.status = q.Gn();
      if ((this.status & 0x400000) == 0) {
        break label90;
      }
    }
    label90:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.faW = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindlinkedin;
  }
  
  protected final void initView()
  {
    if (this.faX) {
      setMMTitle(a.i.contact_info_linkedin_qrcode_title);
    }
    for (;;)
    {
      this.fbc = ((TextView)findViewById(a.e.setting_bind_linkedin_account));
      this.fbd = ((TextView)findViewById(a.e.setting_bind_linkedin_brief));
      this.fbe = findViewById(a.e.show_name_option);
      this.fbf = ((MMSwitchBtn)findViewById(a.e.show_name_checkbox));
      this.fbg = ((TextView)findViewById(a.e.bind_linkedin_btn));
      this.fbh = ((TextView)findViewById(a.e.unbind_linkedin_btn));
      this.fbi = ((TextView)findViewById(a.e.cancel_bind_linkedin_btn));
      this.fbc.setOnClickListener(new BindLinkedInUI.6(this));
      this.fbg.setOnClickListener(new BindLinkedInUI.7(this));
      this.fbh.setOnClickListener(new BindLinkedInUI.8(this));
      this.fbi.setOnClickListener(new BindLinkedInUI.9(this));
      setBackBtn(new BindLinkedInUI.10(this));
      aZ();
      return;
      if (this.faY) {
        setMMTitle(a.i.contact_info_linkedin_title);
      } else {
        setMMTitle(a.i.contact_info_linkedin_bind_info);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      y.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
      return;
    }
    Object localObject = paramIntent.getBundleExtra("result_data");
    paramIntent = ((Bundle)localObject).getString("ret");
    String str1 = ((Bundle)localObject).getString("limid");
    String str2 = ((Bundle)localObject).getString("liname");
    String str3 = ((Bundle)localObject).getString("liurl");
    localObject = ((Bundle)localObject).getString("liswitch");
    if (bk.bl(paramIntent))
    {
      y.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      return;
    }
    paramInt1 = bk.ZR(paramIntent);
    if (paramInt1 != 0)
    {
      y.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 == 1) {}
      for (paramInt1 = a.i.contact_info_linkedin_err_bound;; paramInt1 = a.i.contact_info_linkedin_err_bind_failed)
      {
        com.tencent.mm.ui.base.h.b(this, getString(paramInt1), null, true);
        return;
      }
    }
    if (bk.bl(str1))
    {
      y.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      return;
    }
    y.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    g.DP().Dz().o(286722, str2);
    g.DP().Dz().o(286721, str1);
    g.DP().Dz().o(286723, str3);
    if (!bk.bl((String)localObject)) {
      if (bk.ZR((String)localObject) != 1) {
        break label346;
      }
    }
    label346:
    for (boolean bool = true;; bool = false)
    {
      l(bool, false);
      xK();
      aZ();
      paramIntent = getString(a.i.contact_info_linkedin_bind_ok);
      new BindLinkedInUI.4(this);
      com.tencent.mm.ui.base.h.bC(this, paramIntent);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(549, this);
    g.Dk().a(550, this);
    this.faZ = getIntent().getBundleExtra("qrcode_bundle");
    if (this.faZ != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.faX = bool;
      if (this.faZ != null)
      {
        this.cCL = this.faZ.getString("i");
        this.cCM = this.faZ.getString("n");
        this.fbj = this.faZ.getString("t");
        this.fbk = this.faZ.getString("o");
        this.fbl = this.faZ.getString("s");
        this.fbm = this.faZ.getString("r");
        if ((this.cCL == null) || (this.cCM == null) || (this.fbj == null) || (this.fbl == null) || (this.fbm == null)) {
          com.tencent.mm.ui.base.h.a(this, getString(a.i.contact_info_linkedin_account_params_error), null, false, new BindLinkedInUI.1(this));
        }
      }
      this.faY = getIntent().getBooleanExtra("oversea_entry", false);
      xK();
      if (this.faX) {
        this.faW = true;
      }
      initView();
      if ((this.faZ != null) && (this.faU) && (this.faV.equals(this.cCL)))
      {
        this.fba = true;
        cq(true);
      }
      return;
    }
  }
  
  protected void onDestroy()
  {
    g.Dk().b(550, this);
    g.Dk().b(549, this);
    super.onDestroy();
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
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if (this.ecf != null)
    {
      this.ecf.dismiss();
      this.ecf = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramm.getType() == 549) {
        if (paramInt2 == 1) {
          paramInt1 = a.i.contact_info_linkedin_err_bound;
        }
      }
      for (;;)
      {
        com.tencent.mm.ui.base.h.b(this, getString(paramInt1), null, true);
        do
        {
          return;
          paramInt1 = a.i.contact_info_linkedin_err_bind_failed;
          break;
        } while (paramm.getType() != 550);
        paramInt1 = a.i.contact_info_linkedin_err_unbind_failed;
      }
    }
    if (paramm.getType() == 549)
    {
      this.fbb = true;
      if (!this.fba) {
        paramInt1 = a.i.contact_info_linkedin_bind_ok;
      }
    }
    for (;;)
    {
      paramString = getString(paramInt1);
      new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      };
      com.tencent.mm.ui.base.h.bC(this, paramString);
      xK();
      this.faW = this.fbf.wjS;
      aZ();
      return;
      paramInt1 = a.i.contact_info_linkedin_bind_update_ok;
      continue;
      if (paramm.getType() != 550) {
        break;
      }
      paramInt1 = a.i.contact_info_linkedin_unbind_ok;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */