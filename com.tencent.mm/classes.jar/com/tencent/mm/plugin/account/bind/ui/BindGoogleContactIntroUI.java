package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class BindGoogleContactIntroUI
  extends MMActivity
  implements f
{
  private w faA;
  private int faB;
  private View.OnClickListener faC = new BindGoogleContactIntroUI.1(this);
  private View.OnClickListener faD = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      h.a(BindGoogleContactIntroUI.this.mController.uMN, true, BindGoogleContactIntroUI.this.getString(a.i.unbind_gcontact_confirm), "", BindGoogleContactIntroUI.this.getString(a.i.unbind_gcontact_btn_setting), BindGoogleContactIntroUI.this.getString(a.i.app_cancel), new BindGoogleContactIntroUI.2.1(this), new BindGoogleContactIntroUI.2.2(this));
    }
  };
  private ImageView fas;
  private TextView fat;
  private Button fau;
  private Button fav;
  private boolean faw = false;
  private boolean fax = false;
  private String fay;
  private ProgressDialog faz;
  
  private void VV()
  {
    this.fav.setVisibility(8);
    this.fau.setVisibility(0);
    this.fas.setVisibility(0);
    this.fat.setVisibility(0);
    this.fat.setText(a.i.bind_gcontact_contenct_setting);
    this.fau.setText(a.i.bind_gcontact_btn_setting);
    this.fau.setOnClickListener(this.faC);
  }
  
  protected final int getLayoutId()
  {
    return a.f.bindgooglecontactintro;
  }
  
  protected final void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        BindGoogleContactIntroUI.this.finish();
        return true;
      }
    });
    this.fas = ((ImageView)findViewById(a.e.setting_bind_google_account_icon));
    this.fat = ((TextView)findViewById(a.e.setting_bind_google_account_text));
    this.fau = ((Button)findViewById(a.e.setting_bind_google_account_btn));
    this.fav = ((Button)findViewById(a.e.setting_unbind_google_account_btn));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1) {
      if (paramInt1 == 2005) {
        this.faw = paramIntent.getBooleanExtra("gpservices", false);
      }
    }
    while (paramInt1 != 2005) {
      return;
    }
    this.faw = paramIntent.getBooleanExtra("gpservices", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_gcontact_title_setting);
    this.faB = getIntent().getIntExtra("enter_scene", 0);
    this.faw = com.tencent.mm.plugin.account.friend.a.m.bX(this);
    if (this.faw) {
      startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.fay = ((String)g.DP().Dz().get(208903, null));
    if (TextUtils.isEmpty(this.fay))
    {
      this.fax = false;
      initView();
      if (!this.fax) {
        break label129;
      }
      this.fav.setVisibility(0);
      this.fau.setVisibility(8);
      this.fat.setVisibility(0);
      this.fat.setText(getString(a.i.bind_gcontact_contenct_binded, new Object[] { this.fay }));
      this.fav.setOnClickListener(this.faD);
    }
    for (;;)
    {
      g.Dk().a(487, this);
      return;
      this.fax = true;
      break;
      label129:
      VV();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    paramm = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramm = "";
    }
    y.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramm });
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.DP().Dz().o(208903, "");
      g.DP().Dz().o(208901, "");
      g.DP().Dz().o(208902, "");
      g.DP().Dz().o(208905, Boolean.valueOf(true));
      g.DP().Dz().mC(true);
      VV();
      h.bC(this, getString(a.i.unbind_gcontact_success_tip));
      return;
    }
    y.i("MicroMsg.GoogleContact.BindGoogleContactIntroUI", "unbind failed");
    Toast.makeText(this, a.i.gcontact_unbind_failed_msg, 0).show();
  }
  
  protected void onStop()
  {
    super.onStop();
    g.Dk().b(487, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI
 * JD-Core Version:    0.7.0.1
 */