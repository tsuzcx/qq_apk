package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.az.b.a;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.zv;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.an.i
{
  private String fLC;
  protected ImageView mRU;
  protected TextView mRV;
  protected TextView mRW;
  protected Button mRX;
  protected Button mRY;
  l.a mRZ;
  private boolean mRn = false;
  private com.tencent.mm.plugin.account.friend.ui.i mSa;
  private String mSb = null;
  int mSc;
  int mSd = 0;
  private s tipDialog = null;
  
  private void gU(boolean paramBoolean)
  {
    AppMethodBeat.i(109872);
    Intent localIntent = new Intent(this, BindMContactUI.class);
    if (paramBoolean) {
      localIntent.putExtra("bind_scene", 3);
    }
    for (;;)
    {
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = com.tencent.mm.az.b.bw((String)localObject, getString(a.i.country_code));
        if (localObject != null)
        {
          localIntent.putExtra("country_name", ((b.a)localObject).lSz);
          localIntent.putExtra("couttry_code", ((b.a)localObject).lSy);
        }
      }
      aH(this, localIntent);
      AppMethodBeat.o(109872);
      return;
      localIntent.putExtra("bind_scene", 0);
    }
  }
  
  protected void bxv()
  {
    AppMethodBeat.i(109871);
    hideVKB();
    if (this.mSc == 2)
    {
      cancel();
      finish();
      AppMethodBeat.o(109871);
      return;
    }
    atX(1);
    AppMethodBeat.o(109871);
  }
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109869);
    this.mSc = getIntent().getIntExtra("bind_scene", 0);
    this.mRn = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.mSd = getIntent().getIntExtra("key_upload_scene", 0);
    this.mRZ = com.tencent.mm.plugin.account.friend.a.l.byi();
    Log.d("MicroMsg.BindMContactIntroUI", "state " + this.mRZ);
    this.fLC = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null));
    if ((this.fLC == null) || (this.fLC.equals(""))) {
      this.fLC = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(4097, null));
    }
    this.mRU = ((ImageView)findViewById(a.e.setting_bind_moblie_state_icon));
    this.mRV = ((TextView)findViewById(a.e.setting_bind_mobile_msg_title));
    this.mRW = ((TextView)findViewById(a.e.setting_bind_mobile_msg_hit));
    this.mRX = ((Button)findViewById(a.e.setting_bind_mobile_main_btn));
    this.mRY = ((Button)findViewById(a.e.setting_bind_mobile_sub_btn));
    this.mRX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109850);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BindMContactIntroUI.a(BindMContactIntroUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109850);
      }
    });
    this.mRY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109854);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        BindMContactIntroUI.b(BindMContactIntroUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109854);
      }
    });
    if (getIntent().getBooleanExtra("skip", false))
    {
      addTextOptionMenu(0, getString(a.i.app_ignore_it), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109857);
          BindMContactIntroUI.this.bxv();
          AppMethodBeat.o(109857);
          return true;
        }
      });
      if ((this.mRZ == l.a.mWl) || (this.mRZ == l.a.mWk))
      {
        localObject = com.tencent.mm.n.h.axc().getValue("ShowUnbindPhone");
        i = 2;
        if (!Util.isNullOrNil((String)localObject)) {
          i = Util.safeParseInt((String)localObject);
        }
        if (i != 0) {
          addIconOptionMenu(1, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(109861);
              paramAnonymousMenuItem = new com.tencent.mm.ui.tools.m(BindMContactIntroUI.this.getContext());
              paramAnonymousMenuItem.ODT = new q.f()
              {
                public final void onCreateMMMenu(o paramAnonymous2o)
                {
                  AppMethodBeat.i(109859);
                  paramAnonymous2o.setHeaderTitle(a.i.bind_mcontact_list_menu_title);
                  if ((BindMContactIntroUI.23.this.mSh & 0x2) != 0) {
                    paramAnonymous2o.mn(0, a.i.bind_mcontact_unbind_mobile_text);
                  }
                  if ((BindMContactIntroUI.23.this.mSh & 0x1) != 0) {
                    paramAnonymous2o.mn(1, a.i.bind_mcontact_change_privacy);
                  }
                  AppMethodBeat.o(109859);
                }
              };
              paramAnonymousMenuItem.ODU = new q.g()
              {
                public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(109860);
                  switch (paramAnonymous2MenuItem.getItemId())
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(109860);
                    return;
                    BindMContactIntroUI.c(BindMContactIntroUI.this);
                    AppMethodBeat.o(109860);
                    return;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                    c.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymous2MenuItem);
                  }
                }
              };
              paramAnonymousMenuItem.hYu();
              AppMethodBeat.o(109861);
              return false;
            }
          });
        }
      }
      updateView();
      AppMethodBeat.o(109869);
      return;
    }
    Object localObject = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109858);
        BindMContactIntroUI.this.bxv();
        AppMethodBeat.o(109858);
        return true;
      }
    };
    if (this.mSd == 9) {}
    for (final int i = a.h.actionbar_icon_close_black;; i = 0)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)localObject, i);
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109874);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109874);
      return;
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.fLC);
        paramIntent = new aa(aa.mWH);
        com.tencent.mm.kernel.h.aGY().a(paramIntent, 0);
        getString(a.i.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109866);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(255, this);
    com.tencent.mm.kernel.h.aGY().a(254, this);
    setMMTitle(a.i.bind_mcontact_title_setting);
    AppMethodBeat.o(109866);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109867);
    com.tencent.mm.kernel.h.aGY().b(255, this);
    com.tencent.mm.kernel.h.aGY().b(254, this);
    if (this.mSa != null) {
      this.mSa.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(109867);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109870);
    if (paramInt == 4)
    {
      bxv();
      AppMethodBeat.o(109870);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109870);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109868);
    super.onResume();
    initView();
    com.tencent.mm.kernel.h.aGY().a(132, this);
    AppMethodBeat.o(109868);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(109873);
    Log.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + paramq.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramq.getType() == 132) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (((com.tencent.mm.plugin.account.friend.a.z)paramq).ZB() == 3)
      {
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).removeSelfAccount(this);
        if (!Util.isNullOrNil(this.mSb))
        {
          com.tencent.mm.ui.base.h.a(this, this.mSb, "", getString(a.i.app_i_known), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(109864);
              MMWizardActivity.aH(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
              AppMethodBeat.o(109864);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        aH(this, new Intent(this, BindMContactStatusUI.class));
      }
      AppMethodBeat.o(109873);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      AppMethodBeat.o(109873);
      return;
      i = 0;
      switch (paramInt2)
      {
      default: 
        break;
      case -214: 
        paramString = com.tencent.mm.h.a.Kb(paramString);
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
    if (paramq.getType() == 254)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mSb = ((aa)paramq).byu().Smn;
        if (!Util.isNullOrNil(this.mSb))
        {
          paramString = new com.tencent.mm.plugin.account.friend.a.z(this.fLC, 3, "", 0, "");
          com.tencent.mm.kernel.h.aGY().a(paramString, 0);
          paramq = getContext();
          getString(a.i.app_tip);
          this.tipDialog = com.tencent.mm.ui.base.h.a(paramq, getString(a.i.bind_mcontact_unbinding), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(109865);
              com.tencent.mm.kernel.h.aGY().a(paramString);
              AppMethodBeat.o(109865);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        paramString = new u(2);
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        AppMethodBeat.o(109873);
        return;
      }
      if (paramInt2 == -3)
      {
        Log.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109851);
            paramAnonymousDialogInterface = new Intent();
            if (WeChatBrands.AppInfo.current().isMainland()) {
              paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(a.i.settings_unbind_set_password_tip));
            }
            for (;;)
            {
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              c.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
              AppMethodBeat.o(109851);
              return;
              paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(a.i.settings_unbind_set_password_tip_oversea));
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    else if (paramq.getType() == 255)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 != 0) {
        break label986;
      }
      paramString = new com.tencent.mm.plugin.account.friend.a.z(this.fLC, 3, "", 0, "");
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.i.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(a.i.bind_mcontact_unbinding), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109852);
          com.tencent.mm.kernel.h.aGY().a(paramString);
          AppMethodBeat.o(109852);
        }
      });
    }
    for (;;)
    {
      if (paramq.getType() == 132)
      {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if (((com.tencent.mm.plugin.account.friend.a.z)paramq).ZB() == 3)
        {
          if (paramInt2 == -82)
          {
            com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
            if (paramInt2 == -81)
            {
              com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_norbindqq, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -82)
            {
              com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -83)
            {
              com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -84)
            {
              com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -85)
            {
              com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_mobile_err_bindedbyother, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 != -86) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_qmail, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            break;
            label986:
            Log.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
            com.tencent.mm.ui.base.h.a(getContext(), getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(109853);
                paramAnonymousDialogInterface = new Intent();
                if (WeChatBrands.AppInfo.current().isMainland()) {
                  paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(a.i.settings_unbind_set_password_tip));
                }
                for (;;)
                {
                  paramAnonymousDialogInterface.putExtra("from_unbind", true);
                  c.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
                  AppMethodBeat.o(109853);
                  return;
                  paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(a.i.settings_unbind_set_password_tip_oversea));
                }
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            continue;
          }
          if (paramInt2 == -83)
          {
            com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -84)
          {
            com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -85)
          {
            com.tencent.mm.ui.base.h.a(this, a.i.setting_unbind_mobile_err_bindedbyother, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          Toast.makeText(this, getString(a.i.bind_mcontact_unbind_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        }
      }
    }
    AppMethodBeat.o(109873);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(241611);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    super.onStop();
    AppMethodBeat.o(241611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void updateView()
  {
    AppMethodBeat.i(241615);
    switch (BindMContactIntroUI.20.mSg[this.mRZ.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(241615);
      return;
      showOptionMenu(1, false);
      this.mRU.setImageResource(a.h.mobile_unbind_icon);
      this.mRW.setVisibility(0);
      this.mRY.setVisibility(8);
      this.mRV.setText(getString(a.i.bind_mcontact_hint_title));
      this.mRW.setText(getString(a.i.bind_mcontact_hint));
      this.mRX.setText(a.i.bind_mcontact_bind_btn_text);
      AppMethodBeat.o(241615);
      return;
      showOptionMenu(1, false);
      this.mRU.setImageResource(a.h.mobile_unbind_icon);
      this.mRW.setVisibility(0);
      this.mRY.setVisibility(0);
      this.mRV.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.fLC }));
      this.mRW.setText(a.i.bind_mcontact_unverify_mobile);
      this.mRX.setText(a.i.bind_mcontact_verify_btn_text);
      this.mRY.setText(a.i.bind_mcontact_del_btn_text);
      AppMethodBeat.o(241615);
      return;
      showOptionMenu(1, true);
      this.mRU.setImageResource(a.h.mobile_binded_icon);
      this.mRW.setVisibility(0);
      this.mRY.setVisibility(0);
      this.mRV.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.fLC }));
      this.mRW.setText(a.i.bind_mcontact_upload_addressbook_hint);
      this.mRX.setText(a.i.bind_mcontact_upload_btn_text);
      this.mRY.setText(a.i.bind_mcontact_change_mobile_text);
      AppMethodBeat.o(241615);
      return;
      showOptionMenu(1, true);
      this.mRU.setImageResource(a.h.mobile_binded_icon);
      this.mRW.setVisibility(0);
      this.mRY.setVisibility(0);
      this.mRV.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.fLC }));
      this.mRW.setText(a.i.bind_mcontact_change_hint);
      this.mRX.setText(a.i.bind_mcontact_friend_btn_text);
      this.mRY.setText(a.i.bind_mcontact_change_mobile_text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */