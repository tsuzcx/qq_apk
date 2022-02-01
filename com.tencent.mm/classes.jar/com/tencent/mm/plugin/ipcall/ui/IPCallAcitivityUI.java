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
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class IPCallAcitivityUI
  extends MMActivity
{
  private FrameLayout uPi;
  private TextView uPj;
  private TextView uPk;
  private Button uPl;
  private CdnImageView uPm;
  private boolean uPn = false;
  private com.tencent.mm.plugin.ipcall.model.h.a uPo;
  
  public void finish()
  {
    AppMethodBeat.i(25609);
    super.finish();
    overridePendingTransition(2130771986, 2130772100);
    if (this.uPn)
    {
      com.tencent.mm.plugin.ipcall.model.f.c.ID(1);
      AppMethodBeat.o(25609);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.f.c.ID(0);
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
    this.uPi = ((FrameLayout)findViewById(2131301118));
    this.uPj = ((TextView)findViewById(2131301124));
    this.uPk = ((TextView)findViewById(2131301120));
    this.uPl = ((Button)findViewById(2131301121));
    this.uPm = ((CdnImageView)findViewById(2131301122));
    ba.aBQ();
    String str = (String)com.tencent.mm.model.c.ajl().get(al.a.Itj, "");
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
      finish();
    }
    for (;;)
    {
      this.uPi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25603);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          IPCallAcitivityUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25603);
        }
      });
      this.uPl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25604);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if (IPCallAcitivityUI.a(IPCallAcitivityUI.this).nEf == 1)
          {
            ad.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
            localObject = new Intent();
            ((Intent)localObject).setClass(IPCallAcitivityUI.this.getContext(), IPCallShareCouponUI.class);
            paramAnonymousView = IPCallAcitivityUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject = new Intent();
            ((Intent)localObject).setClass(IPCallAcitivityUI.this.getContext(), IPCallPackageUI.class);
            paramAnonymousView = IPCallAcitivityUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
      this.uPo = com.tencent.mm.plugin.ipcall.model.h.a.anx(str);
      if (this.uPo == null)
      {
        ad.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
        finish();
      }
      else
      {
        this.uPj.setText(this.uPo.Title);
        this.uPk.setText(this.uPo.Desc);
        this.uPl.setText(this.uPo.uOp);
        this.uPm.setUrl(this.uPo.ImgUrl);
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