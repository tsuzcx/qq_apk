package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.List;

public class FindMContactIntroUI
  extends MMWizardActivity
{
  private String bSe;
  private ProgressDialog dnm = null;
  private String dqS = null;
  private f eBv = null;
  private String fcQ = "";
  private int fcR = 2;
  private boolean fcU = false;
  private List<String[]> fcV = null;
  private ag fcW;
  private String fcX;
  private Button fdj;
  private TextView fdk;
  private TextView fdl;
  
  private void Wc()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    XM();
    FW(1);
  }
  
  private void Wi()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[] { Boolean.valueOf(bool), bk.csb() });
    if (!bool) {
      return;
    }
    Object localObject = g.Dk();
    FindMContactIntroUI.9 local9 = new FindMContactIntroUI.9(this);
    this.eBv = local9;
    ((p)localObject).a(431, local9);
    localObject = this.mController.uMN;
    getString(a.i.app_tip);
    this.dnm = h.b((Context)localObject, getString(a.i.app_loading), true, new FindMContactIntroUI.10(this));
    g.DS().a(new FindMContactIntroUI.11(this));
  }
  
  protected final int getLayoutId()
  {
    return a.f.findmcontact_intro;
  }
  
  protected final void initView()
  {
    this.fdj = ((Button)findViewById(a.e.setting_bind_mobile_friend_btn));
    this.fdl = ((TextView)findViewById(a.e.findmcontact_skip_tv));
    this.fdk = ((TextView)findViewById(a.e.findmcontact_intro_tv));
    if ((this.fcQ != null) && (this.fcQ.contains("2"))) {
      this.fdk.setText(getString(a.i.find_mcontact_add_frined_tip));
    }
    for (;;)
    {
      this.bSe = ((String)g.DP().Dz().get(6, null));
      if ((this.bSe == null) || (this.bSe.equals(""))) {
        this.bSe = ((String)g.DP().Dz().get(4097, null));
      }
      this.fdj.setOnClickListener(new FindMContactIntroUI.1(this));
      this.fdl.setOnClickListener(new FindMContactIntroUI.4(this));
      return;
      this.fdk.setText(getString(a.i.find_mcontact_add_frined_tip_noinvite));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.find_mcontact_title);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.dqS = getIntent().getStringExtra("regsetinfo_ticket");
    this.fcQ = getIntent().getStringExtra("regsetinfo_NextStep");
    this.fcR = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    if (com.tencent.mm.plugin.account.friend.a.l.WP() != l.a.ffT) {}
    for (boolean bool = true;; bool = false)
    {
      this.fcU = bool;
      this.fcX = com.tencent.mm.plugin.b.a.YA();
      y.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", new Object[] { this.fcQ, Integer.valueOf(this.fcR) });
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.eBv != null)
    {
      g.Dk().b(431, this.eBv);
      this.eBv = null;
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.plugin.b.a.qj("RE900_100");
    if (this.fcU)
    {
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_100_QQ") + ",4");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R300_100_phone") + ",4");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      Wi();
      return;
    }
    h.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new FindMContactIntroUI.2(this), new FindMContactIntroUI.3(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    if (this.fcU)
    {
      localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_100_QQ,");
      g.DN();
      com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_100_QQ") + ",1");
      com.tencent.mm.plugin.b.a.qi("R300_100_QQ");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R300_100_phone,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R300_100_phone") + ",1");
    com.tencent.mm.plugin.b.a.qi("R300_100_phone");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */