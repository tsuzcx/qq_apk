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
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class IPCallAcitivityUI
  extends MMActivity
{
  private com.tencent.mm.plugin.ipcall.model.h.a ytA;
  private FrameLayout ytu;
  private TextView ytv;
  private TextView ytw;
  private Button ytx;
  private CdnImageView yty;
  private boolean ytz = false;
  
  public void finish()
  {
    AppMethodBeat.i(25609);
    super.finish();
    overridePendingTransition(2130771986, 2130772124);
    if (this.ytz)
    {
      com.tencent.mm.plugin.ipcall.model.f.c.Pe(1);
      AppMethodBeat.o(25609);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.f.c.Pe(0);
    AppMethodBeat.o(25609);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495102;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25608);
    this.ytu = ((FrameLayout)findViewById(2131302772));
    this.ytv = ((TextView)findViewById(2131302778));
    this.ytw = ((TextView)findViewById(2131302774));
    this.ytx = ((Button)findViewById(2131302775));
    this.yty = ((CdnImageView)findViewById(2131302776));
    bg.aVF();
    String str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVI, "");
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
      finish();
    }
    for (;;)
    {
      this.ytu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25603);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          IPCallAcitivityUI.this.finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25603);
        }
      });
      this.ytx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25604);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (IPCallAcitivityUI.a(IPCallAcitivityUI.this).oUv == 1)
          {
            Log.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
            localObject = new Intent();
            ((Intent)localObject).setClass(IPCallAcitivityUI.this.getContext(), IPCallShareCouponUI.class);
            paramAnonymousView = IPCallAcitivityUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject = new Intent();
            ((Intent)localObject).setClass(IPCallAcitivityUI.this.getContext(), IPCallPackageUI.class);
            paramAnonymousView = IPCallAcitivityUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallAcitivityUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
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
      this.ytA = com.tencent.mm.plugin.ipcall.model.h.a.aBT(str);
      if (this.ytA == null)
      {
        Log.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
        finish();
      }
      else
      {
        this.ytv.setText(this.ytA.Title);
        this.ytw.setText(this.ytA.Desc);
        this.ytx.setText(this.ytA.ysC);
        this.yty.setUrl(this.ytA.ImgUrl);
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