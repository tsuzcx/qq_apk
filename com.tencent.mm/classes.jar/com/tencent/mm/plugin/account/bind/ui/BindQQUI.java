package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public class BindQQUI
  extends MMWizardActivity
  implements f
{
  private String fbA = null;
  private String fbB = null;
  com.tencent.mm.ui.base.p tipDialog;
  private int type = 0;
  
  protected final int getLayoutId()
  {
    return a.f.bindqq;
  }
  
  protected final void initView()
  {
    long l = new o(bk.g((Integer)g.DP().Dz().get(9, null))).longValue();
    Object localObject;
    if (l == 0L)
    {
      setMMTitle(a.i.bind_qq_start_title);
      localObject = (TextView)findViewById(a.e.setting_bind_qq_hint);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(a.i.bind_qq_start_hint);
      ((TextView)findViewById(a.e.setting_bind_qq_qq)).setVisibility(8);
      localObject = (Button)findViewById(a.e.bind_qq_start_btn);
      ((Button)localObject).setVisibility(0);
      ((Button)localObject).setText(a.i.bind_qq_start_btn);
      ((Button)localObject).setOnClickListener(new BindQQUI.5(this));
      removeOptionMenu(1);
    }
    while (this.type == 1)
    {
      addTextOptionMenu(0, getString(a.i.app_ignore_it), new BindQQUI.1(this));
      return;
      setMMTitle(a.i.bind_qq_finish_title);
      localObject = (TextView)findViewById(a.e.setting_bind_qq_hint);
      ((TextView)localObject).setVisibility(8);
      ((TextView)localObject).setText(a.i.bind_qq_finish_hint);
      localObject = (TextView)findViewById(a.e.setting_bind_qq_qq);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(getString(a.i.bind_qq_finish_textview_hint) + l);
      localObject = (Button)findViewById(a.e.bind_qq_start_btn);
      ((Button)localObject).setVisibility(8);
      ((Button)localObject).setText(a.i.hardcode_plugin_qqfriend_nick);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView) {}
      });
      addIconOptionMenu(1, a.d.mm_title_btn_menu, new BindQQUI.7(this));
    }
    setBackBtn(new BindQQUI.4(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
    paramIntent = new com.tencent.mm.plugin.account.friend.a.y(com.tencent.mm.plugin.account.friend.a.y.fgp);
    g.Dk().a(paramIntent, 0);
    getString(a.i.app_tip);
    this.tipDialog = h.b(this, getString(a.i.app_loading), true, new BindQQUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
    g.Dk().a(254, this);
    g.Dk().a(255, this);
  }
  
  public void onDestroy()
  {
    g.Dk().b(254, this);
    g.Dk().b(255, this);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BindQQUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramm.getType() == 254) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.fbA = ((com.tencent.mm.plugin.account.friend.a.y)paramm).WX();
        if ((this.fbA != null) && (this.fbA.length() > 0)) {
          g.DP().Dz().o(102407, this.fbA);
        }
        if (!bk.bl(this.fbB))
        {
          paramString = new Intent(this, StartUnbindQQ.class);
          paramString.putExtra("notice", this.fbB);
          C(this, paramString);
        }
      }
    }
    while (paramm.getType() != 255)
    {
      do
      {
        return;
        paramString = new r(2);
        g.Dk().a(paramString, 0);
        return;
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if (paramInt2 == -3)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
          h.a(this.mController.uMN, getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new BindQQUI.9
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface = new Intent();
              paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(a.i.settings_unbind_set_password_tip));
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              d.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            }
          }, new BindQQUI.9(this));
          return;
        }
        if (paramInt2 == -81)
        {
          h.a(this, a.i.setting_unbind_qq_err_norbindqq, a.i.app_tip, null);
          return;
        }
        if (paramInt2 == -82)
        {
          h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, null);
          return;
        }
        if (paramInt2 == -83)
        {
          h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, null);
          return;
        }
        if (paramInt2 == -84)
        {
          h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, null);
          return;
        }
        if (paramInt2 == -85)
        {
          h.a(this, a.i.setting_unbind_qq_err_bindedbyother, a.i.app_tip, null);
          return;
        }
      } while (paramInt2 != -86);
      h.a(this, a.i.setting_unbind_qq_err_qmail, a.i.app_tip, null);
      return;
    }
    if (paramInt2 == 0)
    {
      C(this, new Intent(this, StartUnbindQQ.class));
      return;
    }
    h.a(this.mController.uMN, getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new BindQQUI.10(this), new BindQQUI.11(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI
 * JD-Core Version:    0.7.0.1
 */