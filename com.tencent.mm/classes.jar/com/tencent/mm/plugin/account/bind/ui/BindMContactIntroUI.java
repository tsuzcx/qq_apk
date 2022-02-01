package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.b.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.al.g
{
  private String dpO;
  private boolean ifG = false;
  private ImageView ign;
  private TextView igo;
  private TextView igp;
  private Button igq;
  private Button igr;
  private l.a igs;
  private i igt;
  private String igu = null;
  private String igv = null;
  private int igw;
  private int igx = 0;
  private p tipDialog = null;
  
  private void aHX()
  {
    AppMethodBeat.i(109871);
    hideVKB();
    if (this.igw == 2)
    {
      cancel();
      finish();
      AppMethodBeat.o(109871);
      return;
    }
    Xo(1);
    AppMethodBeat.o(109871);
  }
  
  private void eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(109872);
    Intent localIntent = new Intent(this, BindMContactUI.class);
    if (paramBoolean) {
      localIntent.putExtra("bind_scene", 3);
    }
    for (;;)
    {
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = b.bh((String)localObject, getString(2131757950));
        if (localObject != null)
        {
          localIntent.putExtra("country_name", ((b.a)localObject).hkO);
          localIntent.putExtra("couttry_code", ((b.a)localObject).hkN);
        }
      }
      V(this, localIntent);
      AppMethodBeat.o(109872);
      return;
      localIntent.putExtra("bind_scene", 0);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493180;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109869);
    this.igw = getIntent().getIntExtra("bind_scene", 0);
    this.ifG = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.igx = getIntent().getIntExtra("key_upload_scene", 0);
    this.igs = com.tencent.mm.plugin.account.friend.a.l.aIL();
    ad.d("MicroMsg.BindMContactIntroUI", "state " + this.igs);
    this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(6, null));
    if ((this.dpO == null) || (this.dpO.equals(""))) {
      this.dpO = ((String)com.tencent.mm.kernel.g.afB().afk().get(4097, null));
    }
    this.ign = ((ImageView)findViewById(2131304628));
    this.igo = ((TextView)findViewById(2131304626));
    this.igp = ((TextView)findViewById(2131304625));
    this.igq = ((Button)findViewById(2131304624));
    this.igr = ((Button)findViewById(2131304627));
    this.igq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109850);
        BindMContactIntroUI.a(BindMContactIntroUI.this);
        AppMethodBeat.o(109850);
      }
    });
    this.igr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109854);
        BindMContactIntroUI.b(BindMContactIntroUI.this);
        AppMethodBeat.o(109854);
      }
    });
    if (getIntent().getBooleanExtra("skip", false))
    {
      addTextOptionMenu(0, getString(2131755796), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109857);
          BindMContactIntroUI.c(BindMContactIntroUI.this);
          AppMethodBeat.o(109857);
          return true;
        }
      });
      if ((this.igs == l.a.ikz) || (this.igs == l.a.iky))
      {
        String str = com.tencent.mm.m.g.Zd().getValue("ShowUnbindPhone");
        final int i = 2;
        if (!bt.isNullOrNil(str)) {
          i = bt.aGh(str);
        }
        if (i != 0) {
          addIconOptionMenu(1, 2131690603, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(109861);
              paramAnonymousMenuItem = new com.tencent.mm.ui.tools.l(BindMContactIntroUI.this.getContext());
              paramAnonymousMenuItem.HrX = new n.c()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
                {
                  AppMethodBeat.i(109859);
                  paramAnonymous2l.setHeaderTitle(2131756477);
                  if ((BindMContactIntroUI.23.this.igB & 0x2) != 0) {
                    paramAnonymous2l.jj(0, 2131756496);
                  }
                  if ((BindMContactIntroUI.23.this.igB & 0x1) != 0) {
                    paramAnonymous2l.jj(1, 2131756456);
                  }
                  AppMethodBeat.o(109859);
                }
              };
              paramAnonymousMenuItem.HrY = new n.d()
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
                    BindMContactIntroUI.d(BindMContactIntroUI.this);
                    AppMethodBeat.o(109860);
                    return;
                    paramAnonymous2MenuItem = new Intent();
                    paramAnonymous2MenuItem.putExtra("need_matte_high_light_item", "settings_find_me_by_mobile");
                    d.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymous2MenuItem);
                  }
                }
              };
              paramAnonymousMenuItem.fdQ();
              AppMethodBeat.o(109861);
              return false;
            }
          });
        }
      }
      switch (20.igA[this.igs.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(109869);
      return;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109858);
          BindMContactIntroUI.c(BindMContactIntroUI.this);
          AppMethodBeat.o(109858);
          return true;
        }
      });
      break;
      showOptionMenu(1, false);
      this.ign.setImageResource(2131690820);
      this.igp.setVisibility(0);
      this.igr.setVisibility(8);
      this.igo.setText(2131756472);
      this.igp.setText(2131756471);
      this.igq.setText(2131756446);
      AppMethodBeat.o(109869);
      return;
      showOptionMenu(1, false);
      this.ign.setImageResource(2131690820);
      this.igp.setVisibility(0);
      this.igr.setVisibility(0);
      this.igo.setText(String.format(getString(2131756511), new Object[] { this.dpO }));
      this.igp.setText(2131756500);
      this.igq.setText(2131756505);
      this.igr.setText(2131756457);
      AppMethodBeat.o(109869);
      return;
      showOptionMenu(1, true);
      this.ign.setImageResource(2131690819);
      this.igp.setVisibility(0);
      this.igr.setVisibility(0);
      this.igo.setText(String.format(getString(2131756511), new Object[] { this.dpO }));
      this.igp.setText(2131756501);
      this.igq.setText(2131756502);
      this.igr.setText(2131756455);
      AppMethodBeat.o(109869);
      return;
      showOptionMenu(1, true);
      this.ign.setImageResource(2131690819);
      this.igp.setVisibility(0);
      this.igr.setVisibility(0);
      this.igo.setText(String.format(getString(2131756511), new Object[] { this.dpO }));
      this.igp.setText(2131756453);
      this.igq.setText(2131756470);
      this.igr.setText(2131756455);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109874);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.d("MicroMsg.BindMContactIntroUI", "summerunbind onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109874);
      return;
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.dpO);
        paramIntent = new aa(aa.ikV);
        com.tencent.mm.kernel.g.aeS().a(paramIntent, 0);
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755804), true, new DialogInterface.OnCancelListener()
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
    com.tencent.mm.kernel.g.aeS().a(132, this);
    com.tencent.mm.kernel.g.aeS().a(255, this);
    com.tencent.mm.kernel.g.aeS().a(254, this);
    setMMTitle(2131756489);
    AppMethodBeat.o(109866);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109867);
    com.tencent.mm.kernel.g.aeS().b(132, this);
    com.tencent.mm.kernel.g.aeS().b(255, this);
    com.tencent.mm.kernel.g.aeS().b(254, this);
    if (this.igt != null) {
      this.igt.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(109867);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109870);
    if (paramInt == 4)
    {
      aHX();
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
    AppMethodBeat.o(109868);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(109873);
    ad.i("MicroMsg.BindMContactIntroUI", "summerunbind onSceneEnd type: " + paramn.getType() + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramn.getType() == 132) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (((z)paramn).JJ() == 3)
      {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
        if (!bt.isNullOrNil(this.igv))
        {
          com.tencent.mm.ui.base.h.a(this, this.igv, "", getString(2131755793), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(109864);
              MMWizardActivity.V(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
              AppMethodBeat.o(109864);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        V(this, new Intent(this, BindMContactStatusUI.class));
      }
      AppMethodBeat.o(109873);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.hYu.a(this, paramInt1, paramInt2, paramString)) {
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
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131756462, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756459, 0).show();
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756461, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, 2131756460, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756464, 0).show();
        i = 1;
      }
    }
    if (paramn.getType() == 254)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.igv = ((aa)paramn).aIX().CXU;
        this.igu = ((aa)paramn).aIW();
        if (!bt.isNullOrNil(this.igv))
        {
          paramString = new z(this.dpO, 3, "", 0, "");
          com.tencent.mm.kernel.g.aeS().a(paramString, 0);
          paramn = getContext();
          getString(2131755906);
          this.tipDialog = com.tencent.mm.ui.base.h.b(paramn, getString(2131756499), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(109865);
              com.tencent.mm.kernel.g.aeS().a(paramString);
              AppMethodBeat.o(109865);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        paramString = new t(2);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        AppMethodBeat.o(109873);
        return;
      }
      if (paramInt2 == -3)
      {
        ad.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131763480), null, getString(2131763481), getString(2131763479), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109851);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131763478));
            paramAnonymousDialogInterface.putExtra("from_unbind", true);
            d.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
            AppMethodBeat.o(109851);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
    }
    else if (paramn.getType() == 255)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if (paramInt2 != 0) {
        break label998;
      }
      paramString = new z(this.dpO, 3, "", 0, "");
      com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131756499), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109852);
          com.tencent.mm.kernel.g.aeS().a(paramString);
          AppMethodBeat.o(109852);
        }
      });
    }
    for (;;)
    {
      if (paramn.getType() == 132)
      {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if (((z)paramn).JJ() == 3)
        {
          if (paramInt2 == -82)
          {
            com.tencent.mm.ui.base.h.a(this, 2131763138, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
            if (paramInt2 == -81)
            {
              com.tencent.mm.ui.base.h.a(this, 2131763137, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -82)
            {
              com.tencent.mm.ui.base.h.a(this, 2131763138, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -83)
            {
              com.tencent.mm.ui.base.h.a(this, 2131763135, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -84)
            {
              com.tencent.mm.ui.base.h.a(this, 2131763136, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -85)
            {
              com.tencent.mm.ui.base.h.a(this, 2131763132, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 != -86) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this, 2131763140, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            break;
            label998:
            ad.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131763480), null, getString(2131763481), getString(2131763479), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(109853);
                paramAnonymousDialogInterface = new Intent();
                paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131763478));
                paramAnonymousDialogInterface.putExtra("from_unbind", true);
                d.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
                AppMethodBeat.o(109853);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            continue;
          }
          if (paramInt2 == -83)
          {
            com.tencent.mm.ui.base.h.a(this, 2131763135, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -84)
          {
            com.tencent.mm.ui.base.h.a(this, 2131763136, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -85)
          {
            com.tencent.mm.ui.base.h.a(this, 2131763132, 2131755906, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          Toast.makeText(this, getString(2131756495, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        }
      }
    }
    AppMethodBeat.o(109873);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */