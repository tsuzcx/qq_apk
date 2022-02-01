package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.l;

public class BindQQUI
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  private String pOI = null;
  private String pPR = null;
  w tipDialog;
  private int type = 0;
  
  public int getLayoutId()
  {
    return a.f.bindqq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109983);
    long l = new com.tencent.mm.b.p(Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null))).longValue();
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
      addTextOptionMenu(0, getString(a.i.app_ignore_it), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109971);
          BindQQUI.a(BindQQUI.this);
          AppMethodBeat.o(109971);
          return true;
        }
      });
      AppMethodBeat.o(109983);
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
      ((Button)localObject).setOnClickListener(new BindQQUI.6(this));
      addIconOptionMenu(1, a.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109977);
          paramAnonymousMenuItem = new l(BindQQUI.this.getContext());
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
            {
              AppMethodBeat.i(109975);
              paramAnonymous2s.setHeaderTitle(a.i.bind_mcontact_list_menu_title);
              paramAnonymous2s.oh(0, a.i.unbind_qq);
              AppMethodBeat.o(109975);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(109976);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(109976);
                return;
                paramAnonymous2MenuItem = BindQQUI.this;
                x localx = new x(x.pTn);
                com.tencent.mm.kernel.h.aZW().a(localx, 0);
                paramAnonymous2MenuItem.getString(a.i.app_tip);
                paramAnonymous2MenuItem.tipDialog = k.a(paramAnonymous2MenuItem, paramAnonymous2MenuItem.getString(a.i.app_loading), true, new BindQQUI.2(paramAnonymous2MenuItem));
              }
            }
          };
          paramAnonymousMenuItem.jDd();
          AppMethodBeat.o(109977);
          return false;
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(109972);
        BindQQUI.this.hideVKB();
        BindQQUI.this.finish();
        AppMethodBeat.o(109972);
        return true;
      }
    });
    AppMethodBeat.o(109983);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109985);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.BindQQUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109985);
      return;
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.BindQQUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again qq");
        paramIntent = new x(x.pTn);
        com.tencent.mm.kernel.h.aZW().a(paramIntent, 0);
        getString(a.i.app_tip);
        this.tipDialog = k.a(this, getString(a.i.app_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109980);
    super.onCreate(paramBundle);
    this.type = getIntent().getIntExtra("bindqq_regbymobile", 0);
    com.tencent.mm.kernel.h.aZW().a(254, this);
    com.tencent.mm.kernel.h.aZW().a(255, this);
    AppMethodBeat.o(109980);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109981);
    com.tencent.mm.kernel.h.aZW().b(254, this);
    com.tencent.mm.kernel.h.aZW().b(255, this);
    super.onDestroy();
    AppMethodBeat.o(109981);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109982);
    super.onResume();
    initView();
    AppMethodBeat.o(109982);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(109984);
    Log.d("MicroMsg.BindQQUI", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramp.getType());
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramp.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.pPR = ((x)paramp).bXh();
        if ((this.pPR != null) && (this.pPR.length() > 0)) {
          com.tencent.mm.kernel.h.baE().ban().B(102407, this.pPR);
        }
        if (!Util.isNullOrNil(this.pOI))
        {
          paramString = new Intent(this, StartUnbindQQ.class);
          paramString.putExtra("notice", this.pOI);
          aQ(this, paramString);
          AppMethodBeat.o(109984);
          return;
        }
        paramString = new v(2);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        AppMethodBeat.o(109984);
        return;
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 == -3)
      {
        Log.d("MicroMsg.BindQQUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        k.a(getContext(), getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109978);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(a.i.settings_unbind_set_password_tip));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            c.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(109978);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -81)
      {
        k.a(this, a.i.setting_unbind_qq_err_norbindqq, a.i.app_tip, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -82)
      {
        k.a(this, a.i.setting_unbind_qq_err_one_left, a.i.app_tip, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -83)
      {
        k.a(this, a.i.setting_unbind_qq_err_has_unbind, a.i.app_tip, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -84)
      {
        k.a(this, a.i.setting_unbind_qq_err_hasbinded, a.i.app_tip, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -85)
      {
        k.a(this, a.i.setting_unbind_qq_err_bindedbyother, a.i.app_tip, null);
        AppMethodBeat.o(109984);
        return;
      }
      if (paramInt2 == -86)
      {
        k.a(this, a.i.setting_unbind_qq_err_qmail, a.i.app_tip, null);
        AppMethodBeat.o(109984);
      }
    }
    else if (paramp.getType() == 255)
    {
      if (paramInt2 == 0)
      {
        aQ(this, new Intent(this, StartUnbindQQ.class));
        AppMethodBeat.o(109984);
        return;
      }
      k.a(getContext(), getString(a.i.settings_unbind_tips_set_user_password), null, getString(a.i.settings_unbind_tips_unbind_btn), getString(a.i.settings_unbind_tips_cancel_btn), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109979);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("kintent_hint", BindQQUI.this.getString(a.i.settings_unbind_set_password_tip));
          paramAnonymousDialogInterface.putExtra("from_unbind", true);
          c.b(BindQQUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
          AppMethodBeat.o(109979);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    AppMethodBeat.o(109984);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI
 * JD-Core Version:    0.7.0.1
 */