package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class IPCallAcitivityUI
  extends MMActivity
{
  private FrameLayout vaU;
  private TextView vaV;
  private TextView vaW;
  private Button vaX;
  private CdnImageView vaY;
  private boolean vaZ = false;
  private com.tencent.mm.plugin.ipcall.model.h.a vba;
  
  public void finish()
  {
    AppMethodBeat.i(25609);
    super.finish();
    overridePendingTransition(2130771986, 2130772100);
    if (this.vaZ)
    {
      com.tencent.mm.plugin.ipcall.model.f.c.Jb(1);
      AppMethodBeat.o(25609);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.f.c.Jb(0);
    AppMethodBeat.o(25609);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494510;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25608);
    this.vaU = ((FrameLayout)findViewById(2131301118));
    this.vaV = ((TextView)findViewById(2131301124));
    this.vaW = ((TextView)findViewById(2131301120));
    this.vaX = ((Button)findViewById(2131301121));
    this.vaY = ((CdnImageView)findViewById(2131301122));
    bc.aCg();
    String str = (String)com.tencent.mm.model.c.ajA().get(am.a.INF, "");
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
      finish();
    }
    for (;;)
    {
      this.vaU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25603);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          IPCallAcitivityUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25603);
        }
      });
      this.vaX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25604);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          if (IPCallAcitivityUI.a(IPCallAcitivityUI.this).nJA == 1)
          {
            ae.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
            localObject = new Intent();
            ((Intent)localObject).setClass(IPCallAcitivityUI.this.getContext(), IPCallShareCouponUI.class);
            paramAnonymousView = IPCallAcitivityUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject = new Intent();
            ((Intent)localObject).setClass(IPCallAcitivityUI.this.getContext(), IPCallPackageUI.class);
            paramAnonymousView = IPCallAcitivityUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          IPCallAcitivityUI.b(IPCallAcitivityUI.this);
          IPCallAcitivityUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25604);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(25605);
          IPCallAcitivityUI.this.finish();
          AppMethodBeat.o(25605);
          return true;
        }
      });
      AppMethodBeat.o(25608);
      return;
      this.vba = com.tencent.mm.plugin.ipcall.model.h.a.aoz(str);
      if (this.vba == null)
      {
        ae.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
        finish();
      }
      else
      {
        this.vaV.setText(this.vba.Title);
        this.vaW.setText(this.vba.Desc);
        this.vaX.setText(this.vba.vac);
        this.vaY.setUrl(this.vba.ImgUrl);
      }
    }
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(25610);
    super.onBackPressed();
    AppMethodBeat.o(25610);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25606);
    super.onCreate(paramBundle);
    getWindow().addFlags(131072);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    initView();
    AppMethodBeat.o(25606);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25607);
    super.onDestroy();
    AppMethodBeat.o(25607);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAcitivityUI
 * JD-Core Version:    0.7.0.1
 */