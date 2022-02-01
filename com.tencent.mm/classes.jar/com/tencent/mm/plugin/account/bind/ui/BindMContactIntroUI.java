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
import com.tencent.mm.ak.t;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;

public class BindMContactIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.i
{
  private String dSf;
  private boolean jZU = false;
  private ImageView kaB;
  private TextView kaC;
  private TextView kaD;
  private Button kaE;
  private Button kaF;
  private l.a kaG;
  private com.tencent.mm.plugin.account.friend.ui.i kaH;
  private String kaI = null;
  private String kaJ = null;
  private int kaK;
  private int kaL = 0;
  private com.tencent.mm.ui.base.q tipDialog = null;
  
  private void bnm()
  {
    AppMethodBeat.i(109871);
    hideVKB();
    if (this.kaK == 2)
    {
      cancel();
      finish();
      AppMethodBeat.o(109871);
      return;
    }
    ala(1);
    AppMethodBeat.o(109871);
  }
  
  private void gi(boolean paramBoolean)
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
        localObject = com.tencent.mm.aw.b.bs((String)localObject, getString(2131758198));
        if (localObject != null)
        {
          localIntent.putExtra("country_name", ((b.a)localObject).jbZ);
          localIntent.putExtra("couttry_code", ((b.a)localObject).jbY);
        }
      }
      ay(this, localIntent);
      AppMethodBeat.o(109872);
      return;
      localIntent.putExtra("bind_scene", 0);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493226;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109869);
    this.kaK = getIntent().getIntExtra("bind_scene", 0);
    this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.kaL = getIntent().getIntExtra("key_upload_scene", 0);
    this.kaG = com.tencent.mm.plugin.account.friend.a.l.bnZ();
    Log.d("MicroMsg.BindMContactIntroUI", "state " + this.kaG);
    this.dSf = ((String)g.aAh().azQ().get(6, null));
    if ((this.dSf == null) || (this.dSf.equals(""))) {
      this.dSf = ((String)g.aAh().azQ().get(4097, null));
    }
    this.kaB = ((ImageView)findViewById(2131307680));
    this.kaC = ((TextView)findViewById(2131307678));
    this.kaD = ((TextView)findViewById(2131307677));
    this.kaE = ((Button)findViewById(2131307676));
    this.kaF = ((Button)findViewById(2131307679));
    this.kaE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109850);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        BindMContactIntroUI.a(BindMContactIntroUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109850);
      }
    });
    this.kaF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(109854);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        BindMContactIntroUI.b(BindMContactIntroUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(109854);
      }
    });
    if (getIntent().getBooleanExtra("skip", false))
    {
      addTextOptionMenu(0, getString(2131755877), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109857);
          BindMContactIntroUI.c(BindMContactIntroUI.this);
          AppMethodBeat.o(109857);
          return true;
        }
      });
      if ((this.kaG == l.a.keM) || (this.kaG == l.a.keL))
      {
        String str = com.tencent.mm.n.h.aqJ().getValue("ShowUnbindPhone");
        final int i = 2;
        if (!Util.isNullOrNil(str)) {
          i = Util.safeParseInt(str);
        }
        if (i != 0) {
          addIconOptionMenu(1, 2131690843, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(109861);
              paramAnonymousMenuItem = new com.tencent.mm.ui.tools.l(BindMContactIntroUI.this.getContext());
              paramAnonymousMenuItem.HLX = new o.f()
              {
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
                {
                  AppMethodBeat.i(109859);
                  paramAnonymous2m.setHeaderTitle(2131756613);
                  if ((BindMContactIntroUI.23.this.kaP & 0x2) != 0) {
                    paramAnonymous2m.kV(0, 2131756632);
                  }
                  if ((BindMContactIntroUI.23.this.kaP & 0x1) != 0) {
                    paramAnonymous2m.kV(1, 2131756592);
                  }
                  AppMethodBeat.o(109859);
                }
              };
              paramAnonymousMenuItem.HLY = new o.g()
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
                    c.b(BindMContactIntroUI.this, "setting", ".ui.setting.SettingsPrivacyUI", paramAnonymous2MenuItem);
                  }
                }
              };
              paramAnonymousMenuItem.gXI();
              AppMethodBeat.o(109861);
              return false;
            }
          });
        }
      }
      switch (BindMContactIntroUI.20.kaO[this.kaG.ordinal()])
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
      this.kaB.setImageResource(2131691106);
      this.kaD.setVisibility(0);
      this.kaF.setVisibility(8);
      this.kaC.setText(2131756608);
      this.kaD.setText(2131756607);
      this.kaE.setText(2131756582);
      AppMethodBeat.o(109869);
      return;
      showOptionMenu(1, false);
      this.kaB.setImageResource(2131691106);
      this.kaD.setVisibility(0);
      this.kaF.setVisibility(0);
      this.kaC.setText(String.format(getString(2131756647), new Object[] { this.dSf }));
      this.kaD.setText(2131756636);
      this.kaE.setText(2131756641);
      this.kaF.setText(2131756593);
      AppMethodBeat.o(109869);
      return;
      showOptionMenu(1, true);
      this.kaB.setImageResource(2131691105);
      this.kaD.setVisibility(0);
      this.kaF.setVisibility(0);
      this.kaC.setText(String.format(getString(2131756647), new Object[] { this.dSf }));
      this.kaD.setText(2131756637);
      this.kaE.setText(2131756638);
      this.kaF.setText(2131756591);
      AppMethodBeat.o(109869);
      return;
      showOptionMenu(1, true);
      this.kaB.setImageResource(2131691105);
      this.kaD.setVisibility(0);
      this.kaF.setVisibility(0);
      this.kaC.setText(String.format(getString(2131756647), new Object[] { this.dSf }));
      this.kaD.setText(2131756589);
      this.kaE.setText(2131756606);
      this.kaF.setText(2131756591);
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
        Log.i("MicroMsg.BindMContactIntroUI", "summerunbind REQUEST_CODE_SET_PSW ok and start NetSceneCheckUnBind again mobile: " + this.dSf);
        paramIntent = new aa(aa.kfi);
        g.azz().a(paramIntent, 0);
        getString(2131755998);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
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
    g.azz().a(132, this);
    g.azz().a(255, this);
    g.azz().a(254, this);
    setMMTitle(2131756625);
    AppMethodBeat.o(109866);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109867);
    g.azz().b(132, this);
    g.azz().b(255, this);
    g.azz().b(254, this);
    if (this.kaH != null) {
      this.kaH.recycle();
    }
    super.onDestroy();
    AppMethodBeat.o(109867);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109870);
    if (paramInt == 4)
    {
      bnm();
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
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
      if (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() == 3)
      {
        ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).removeSelfAccount(this);
        if (!Util.isNullOrNil(this.kaJ))
        {
          com.tencent.mm.ui.base.h.a(this, this.kaJ, "", getString(2131755874), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(109864);
              MMWizardActivity.ay(BindMContactIntroUI.this, new Intent(BindMContactIntroUI.this, BindMContactStatusUI.class));
              AppMethodBeat.o(109864);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        ay(this, new Intent(this, BindMContactStatusUI.class));
      }
      AppMethodBeat.o(109873);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString)) {
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
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null) {
          paramString.a(this, null, null);
        }
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, 2131756598, 0).show();
        i = 1;
        break;
      case -43: 
        Toast.makeText(this, 2131756595, 0).show();
        i = 1;
        break;
      case -41: 
        Toast.makeText(this, 2131756597, 0).show();
        i = 1;
        break;
      case -35: 
        Toast.makeText(this, 2131756596, 0).show();
        i = 1;
        break;
      case -36: 
        Toast.makeText(this, 2131756600, 0).show();
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
        this.kaJ = ((aa)paramq).bol().Lle;
        this.kaI = ((aa)paramq).bok();
        if (!Util.isNullOrNil(this.kaJ))
        {
          paramString = new com.tencent.mm.plugin.account.friend.a.z(this.dSf, 3, "", 0, "");
          g.azz().a(paramString, 0);
          paramq = getContext();
          getString(2131755998);
          this.tipDialog = com.tencent.mm.ui.base.h.a(paramq, getString(2131756635), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(109865);
              g.azz().a(paramString);
              AppMethodBeat.o(109865);
            }
          });
          AppMethodBeat.o(109873);
          return;
        }
        paramString = new u(2);
        g.azz().a(paramString, 0);
        AppMethodBeat.o(109873);
        return;
      }
      if (paramInt2 == -3)
      {
        Log.d("MicroMsg.BindMContactIntroUI", "summerunbind MMFunc_QueryHasPasswd err and set psw");
        com.tencent.mm.ui.base.h.a(getContext(), getString(2131765664), null, getString(2131765665), getString(2131765663), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(109851);
            paramAnonymousDialogInterface = new Intent();
            if (WeChatBrands.AppInfo.current().isMainland()) {
              paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131765661));
            }
            for (;;)
            {
              paramAnonymousDialogInterface.putExtra("from_unbind", true);
              c.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
              AppMethodBeat.o(109851);
              return;
              paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131765662));
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
        break label998;
      }
      paramString = new com.tencent.mm.plugin.account.friend.a.z(this.dSf, 3, "", 0, "");
      g.azz().a(paramString, 0);
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.tipDialog = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131756635), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(109852);
          g.azz().a(paramString);
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
        if (((com.tencent.mm.plugin.account.friend.a.z)paramq).Vj() == 3)
        {
          if (paramInt2 == -82)
          {
            com.tencent.mm.ui.base.h.a(this, 2131765304, 2131755998, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
            if (paramInt2 == -81)
            {
              com.tencent.mm.ui.base.h.a(this, 2131765303, 2131755998, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -82)
            {
              com.tencent.mm.ui.base.h.a(this, 2131765304, 2131755998, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -83)
            {
              com.tencent.mm.ui.base.h.a(this, 2131765301, 2131755998, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -84)
            {
              com.tencent.mm.ui.base.h.a(this, 2131765302, 2131755998, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 == -85)
            {
              com.tencent.mm.ui.base.h.a(this, 2131765298, 2131755998, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
              });
              break;
            }
            if (paramInt2 != -86) {
              break;
            }
            com.tencent.mm.ui.base.h.a(this, 2131765306, 2131755998, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            break;
            label998:
            Log.i("MicroMsg.BindMContactIntroUI", "summerunbind old err_password");
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131765664), null, getString(2131765665), getString(2131765663), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(109853);
                paramAnonymousDialogInterface = new Intent();
                if (WeChatBrands.AppInfo.current().isMainland()) {
                  paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131765661));
                }
                for (;;)
                {
                  paramAnonymousDialogInterface.putExtra("from_unbind", true);
                  c.b(BindMContactIntroUI.this, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", paramAnonymousDialogInterface, 1);
                  AppMethodBeat.o(109853);
                  return;
                  paramAnonymousDialogInterface.putExtra("kintent_hint", BindMContactIntroUI.this.getString(2131765662));
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
            com.tencent.mm.ui.base.h.a(this, 2131765301, 2131755998, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -84)
          {
            com.tencent.mm.ui.base.h.a(this, 2131765302, 2131755998, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          if (paramInt2 == -85)
          {
            com.tencent.mm.ui.base.h.a(this, 2131765298, 2131755998, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
            });
            AppMethodBeat.o(109873);
            return;
          }
          Toast.makeText(this, getString(2131756631, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI
 * JD-Core Version:    0.7.0.1
 */