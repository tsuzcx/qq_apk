package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.autogen.a.abs;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.x;
import com.tencent.mm.plugin.account.friend.ui.i.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  private String hRk;
  private boolean pNU = false;
  protected ImageView pOB;
  protected TextView pOC;
  protected TextView pOD;
  protected Button pOE;
  protected Button pOF;
  com.tencent.mm.plugin.account.friend.model.i.a pOG;
  private com.tencent.mm.plugin.account.friend.ui.i pOH;
  private String pOI = null;
  int pOJ;
  int pOK = 0;
  private com.tencent.mm.ui.base.w tipDialog = null;
  
  private void hK(boolean paramBoolean)
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
        localObject = b.bH((String)localObject, getString(a.i.country_code));
        if (localObject != null)
        {
          localIntent.putExtra("country_name", ((b.a)localObject).oLl);
          localIntent.putExtra("couttry_code", ((b.a)localObject).oLk);
        }
      }
      aQ(this, localIntent);
      AppMethodBeat.o(109872);
      return;
      localIntent.putExtra("bind_scene", 0);
    }
  }
  
  protected void bWj()
  {
    AppMethodBeat.i(109871);
    hideVKB();
    if (this.pOJ == 2)
    {
      cancel();
      finish();
      AppMethodBeat.o(109871);
      return;
    }
    aAp(1);
    AppMethodBeat.o(109871);
  }
  
  public final void bWk()
  {
    AppMethodBeat.i(304896);
    switch (20.pON[this.pOG.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(304896);
      return;
      hK(false);
      AppMethodBeat.o(304896);
      return;
      Object localObject = this.hRk;
      if (this.pOH == null) {
        this.pOH = new com.tencent.mm.plugin.account.friend.ui.i(i.b.pWc, this, new com.tencent.mm.plugin.account.friend.ui.i.a()
        {
          public final void k(int paramAnonymousInt, Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(109863);
            if (paramAnonymousInt == 2)
            {
              if (BindMContactIntroUI.this.pOJ == 1)
              {
                if (!z.bBc())
                {
                  paramAnonymousBundle = new abs();
                  paramAnonymousBundle.ifi.hAJ = true;
                  paramAnonymousBundle.ifi.ifj = true;
                  paramAnonymousBundle.publish();
                }
                BindMContactIntroUI.d(BindMContactIntroUI.this);
                paramAnonymousBundle = new Intent();
                paramAnonymousBundle.addFlags(67108864);
                com.tencent.mm.plugin.account.sdk.a.pFn.e(BindMContactIntroUI.this, paramAnonymousBundle);
                AppMethodBeat.o(109863);
                return;
              }
              MMWizardActivity.aQ(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class).putExtra("bind_scene", BindMContactIntroUI.this.pOJ));
              if (BindMContactIntroUI.e(BindMContactIntroUI.this))
              {
                if (BindMContactIntroUI.this.pOJ == 2)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.b(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
                  AppMethodBeat.o(109863);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(11002, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
                AppMethodBeat.o(109863);
              }
            }
            else if (paramAnonymousInt == 1)
            {
              paramAnonymousBundle = new Intent(BindMContactIntroUI.this, BindMContactVerifyUI.class);
              paramAnonymousBundle.putExtra("bindmcontact_mobile", this.pOR);
              paramAnonymousBundle.putExtra("bind_scene", BindMContactIntroUI.this.pOJ);
              paramAnonymousBundle.putExtra("KEnterFromBanner", BindMContactIntroUI.e(BindMContactIntroUI.this));
              MMWizardActivity.aQ(BindMContactIntroUI.this, paramAnonymousBundle);
            }
            AppMethodBeat.o(109863);
          }
        });
      }
      com.tencent.mm.plugin.account.friend.ui.i locali = this.pOH;
      if ((this.pOJ == 0) || (this.pOJ == 3)) {}
      for (boolean bool = true;; bool = false)
      {
        locali.pVZ = bool;
        this.pOH.Tl((String)localObject);
        AppMethodBeat.o(304896);
        return;
      }
      localObject = new Intent(this, MobileFriendUI.class);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI", "onClickMainButton", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI", "onClickMainButton", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(304896);
      return;
      com.tencent.mm.plugin.account.friend.model.i.hN(false);
      ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).showAddrBookUploadConfirm(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(109855);
          if (com.tencent.mm.plugin.account.friend.model.i.bWU())
          {
            BindMContactIntroUI.bWl();
            BindMContactIntroUI.this.pOE.setText(BindMContactIntroUI.this.getString(a.i.bind_mcontact_friend_btn_text));
            BindMContactIntroUI.this.pOG = com.tencent.mm.plugin.account.friend.model.i.a.pSQ;
            boolean bool = Util.nullAs((Boolean)com.tencent.mm.kernel.h.baE().ban().d(12322, Boolean.FALSE), false);
            if ((BindMContactIntroUI.e(BindMContactIntroUI.this)) && (bool)) {
              com.tencent.mm.plugin.report.service.h.OAn.b(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
            }
          }
          AppMethodBeat.o(109855);
        }
      }, true, this.pOK);
    }
  }
  
  public int getLayoutId()
  {
    return a.f.bindmcontact_intro;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109869);
    this.pOJ = getIntent().getIntExtra("bind_scene", 0);
    this.pNU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.pOK = getIntent().getIntExtra("key_upload_scene", 0);
    this.pOG = com.tencent.mm.plugin.account.friend.model.i.bWW();
    Log.d("MicroMsg.BindMContactIntroUI", "state " + this.pOG);
    this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(6, null));
    if ((this.hRk == null) || (this.hRk.equals(""))) {
      this.hRk = ((String)com.tencent.mm.kernel.h.baE().ban().d(4097, null));
    }
    this.pOB = ((ImageView)findViewById(a.e.setting_bind_moblie_state_icon));
    this.pOC = ((TextView)findViewById(a.e.setting_bind_mobile_msg_title));
    this.pOD = ((TextView)findViewById(a.e.setting_bind_mobile_msg_hit));
    this.pOE = ((Button)findViewById(a.e.setting_bind_mobile_main_btn));
    this.pOF = ((Button)findViewById(a.e.setting_bind_mobile_sub_btn));
    this.pOE.setOnClickListener(new BindMContactIntroUI.1(this));
    this.pOF.setOnClickListener(new BindMContactIntroUI.12(this));
    if (getIntent().getBooleanExtra("skip", false))
    {
      addTextOptionMenu(0, getString(a.i.app_ignore_it), new BindMContactIntroUI.21(this));
      if ((this.pOG == com.tencent.mm.plugin.account.friend.model.i.a.pSR) || (this.pOG == com.tencent.mm.plugin.account.friend.model.i.a.pSQ))
      {
        localObject = com.tencent.mm.k.i.aRC().getValue("ShowUnbindPhone");
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
              paramAnonymousMenuItem = new com.tencent.mm.ui.tools.l(BindMContactIntroUI.this.getContext());
              paramAnonymousMenuItem.Vtg = new u.g()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
                {
                  AppMethodBeat.i(109859);
                  paramAnonymous2s.setHeaderTitle(a.i.bind_mcontact_list_menu_title);
                  if ((BindMContactIntroUI.23.this.pOO & 0x2) != 0) {
                    paramAnonymous2s.oh(0, a.i.bind_mcontact_unbind_mobile_text);
                  }
                  if ((BindMContactIntroUI.23.this.pOO & 0x1) != 0) {
                    paramAnonymous2s.oh(1, a.i.bind_mcontact_change_privacy);
                  }
                  AppMethodBeat.o(109859);
                }
              };
              paramAnonymousMenuItem.GAC = new u.i()
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
                    BindMContactIntroUI.b(BindMContactIntroUI.this);
                    AppMethodBeat.o(109860);
                    return;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                    c.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymous2MenuItem);
                  }
                }
              };
              paramAnonymousMenuItem.jDd();
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
    Object localObject = new BindMContactIntroUI.22(this);
    if (this.pOK == 9) {}
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
        Log.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.hRk);
        paramIntent = new x(x.pTo);
        com.tencent.mm.kernel.h.aZW().a(paramIntent, 0);
        getString(a.i.app_tip);
        this.tipDialog = k.a(this, getString(a.i.app_loading), true, new BindMContactIntroUI.19(this));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109866);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(255, this);
    com.tencent.mm.kernel.h.aZW().a(254, this);
    setMMTitle(a.i.bind_mcontact_title_setting);
    AppMethodBeat.o(109866);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109867);
    com.tencent.mm.kernel.h.aZW().b(255, this);
    com.tencent.mm.kernel.h.aZW().b(254, this);
    if (this.pOH != null) {
      this.pOH.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(109867);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109870);
    if (paramInt == 4)
    {
      bWj();
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
    com.tencent.mm.kernel.h.aZW().a(132, this);
    AppMethodBeat.o(109868);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(109873);
    Log.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + paramp.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramp.getType() == 132) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 3)
      {
        ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).removeSelfAccount(this);
        if (!Util.isNullOrNil(this.pOI))
        {
          k.a(this, this.pOI, "", getString(a.i.app_i_known), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(109864);
              MMWizardActivity.aQ(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
              AppMethodBeat.o(109864);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        aQ(this, new Intent(this, BindMContactStatusUI.class));
      }
      AppMethodBeat.o(109873);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString)) {
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
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
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
    if (paramp.getType() == 254)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.pOI = ((x)paramp).bXi().Zkz;
        if (!Util.isNullOrNil(this.pOI))
        {
          paramString = new com.tencent.mm.plugin.account.friend.model.w(this.hRk, 3, "", 0, "", "");
          com.tencent.mm.kernel.h.aZW().a(paramString, 0);
          paramp = getContext();
          getString(a.i.app_tip);
          this.tipDialog = k.a(paramp, getString(a.i.bind_mcontact_unbinding), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(109865);
              com.tencent.mm.kernel.h.aZW().a(paramString);
              AppMethodBeat.o(109865);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        paramString = new v(2);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        AppMethodBeat.o(109873);
        return;
      }
      if (paramInt2 == -3)
      {
        Log.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        k.a(getContext(), getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    else if (paramp.getType() == 255)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 != 0) {
        break label992;
      }
      paramString = new com.tencent.mm.plugin.account.friend.model.w(this.hRk, 3, "", 0, "", "");
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(a.i.app_tip);
      this.tipDialog = k.a(localAppCompatActivity, getString(a.i.bind_mcontact_unbinding), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109852);
          com.tencent.mm.kernel.h.aZW().a(paramString);
          AppMethodBeat.o(109852);
        }
      });
    }
    for (;;)
    {
      if (paramp.getType() == 132)
      {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if (((com.tencent.mm.plugin.account.friend.model.w)paramp).bIO() == 3)
        {
          if (paramInt2 == -82)
          {
            k.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
            if (paramInt2 == -81)
            {
              k.a(this, a.i.setting_unbind_qq_err_norbindqq, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -82)
            {
              k.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -83)
            {
              k.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -84)
            {
              k.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -85)
            {
              k.a(this, a.i.setting_unbind_mobile_err_bindedbyother, a.i.app_tip, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 != -86) {
              break;
            }
            k.a(this, a.i.setting_unbind_qq_err_qmail, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            break;
            label992:
            Log.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
            k.a(getContext(), getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
            k.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -84)
          {
            k.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -85)
          {
            k.a(this, a.i.setting_unbind_mobile_err_bindedbyother, a.i.app_tip, new DialogInterface.OnClickListener()
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
    AppMethodBeat.i(304890);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    super.onStop();
    AppMethodBeat.o(304890);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void updateView()
  {
    AppMethodBeat.i(304893);
    switch (20.pON[this.pOG.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(304893);
      return;
      showOptionMenu(1, false);
      this.pOB.setImageResource(a.h.mobile_unbind_icon);
      this.pOD.setVisibility(0);
      this.pOF.setVisibility(8);
      this.pOC.setText(getString(a.i.bind_mcontact_hint_title));
      this.pOD.setText(getString(a.i.bind_mcontact_hint));
      this.pOE.setText(a.i.bind_mcontact_bind_btn_text);
      AppMethodBeat.o(304893);
      return;
      showOptionMenu(1, false);
      this.pOB.setImageResource(a.h.mobile_unbind_icon);
      this.pOD.setVisibility(0);
      this.pOF.setVisibility(0);
      this.pOC.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.hRk }));
      this.pOD.setText(a.i.bind_mcontact_unverify_mobile);
      this.pOE.setText(a.i.bind_mcontact_verify_btn_text);
      this.pOF.setText(a.i.bind_mcontact_del_btn_text);
      AppMethodBeat.o(304893);
      return;
      showOptionMenu(1, true);
      this.pOB.setImageResource(a.h.mobile_binded_icon);
      this.pOD.setVisibility(0);
      this.pOF.setVisibility(0);
      this.pOC.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.hRk }));
      this.pOD.setText(a.i.bind_mcontact_upload_addressbook_hint);
      this.pOE.setText(a.i.bind_mcontact_upload_btn_text);
      this.pOF.setText(a.i.bind_mcontact_change_mobile_text);
      AppMethodBeat.o(304893);
      return;
      showOptionMenu(1, true);
      this.pOB.setImageResource(a.h.mobile_binded_icon);
      this.pOD.setVisibility(0);
      this.pOF.setVisibility(0);
      this.pOC.setText(String.format(getString(a.i.bind_mcontact_verify_mobile), new Object[] { this.hRk }));
      this.pOD.setText(a.i.bind_mcontact_change_hint);
      this.pOE.setText(a.i.bind_mcontact_friend_btn_text);
      this.pOF.setText(a.i.bind_mcontact_change_mobile_text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */