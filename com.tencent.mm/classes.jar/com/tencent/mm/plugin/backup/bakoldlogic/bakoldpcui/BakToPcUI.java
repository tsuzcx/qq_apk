package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI
  extends MMWizardActivity
  implements e.a
{
  private int EN;
  private Button gXc;
  private Button gZv;
  private aq handler;
  private TextView nHQ;
  private TextView nHR;
  
  public BakToPcUI()
  {
    AppMethodBeat.i(22028);
    this.EN = -1;
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(22028);
  }
  
  private void bKB()
  {
    AppMethodBeat.i(22033);
    if (this.EN == 0)
    {
      this.gXc.setEnabled(true);
      this.gZv.setEnabled(true);
      AppMethodBeat.o(22033);
      return;
    }
    this.gXc.setEnabled(false);
    this.gZv.setEnabled(false);
    AppMethodBeat.o(22033);
  }
  
  public final void bKt()
  {
    AppMethodBeat.i(22032);
    this.EN = 0;
    this.gXc.setVisibility(0);
    this.gZv.setVisibility(0);
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22026);
        BakToPcUI.d(BakToPcUI.this);
        AppMethodBeat.o(22026);
      }
    });
    AppMethodBeat.o(22032);
  }
  
  public int getLayoutId()
  {
    return 2131493140;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22030);
    setMMTitle(2131756308);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22023);
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().xO(1);
        BakToPcUI.a(BakToPcUI.this);
        AppMethodBeat.o(22023);
        return true;
      }
    });
    this.gXc = ((Button)findViewById(2131297075));
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22024);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().hJc = 1;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().xO(0);
          paramAnonymousView = new Intent(BakToPcUI.this, BakWaitingUI.class);
          MMWizardActivity.al(BakToPcUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22024);
      }
    });
    this.gZv = ((Button)findViewById(2131297073));
    this.gZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22025);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().hJc = 2;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().aCO();
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().xO(1);
          BakToPcUI.c(BakToPcUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22025);
      }
    });
    this.nHQ = ((TextView)findViewById(2131297080));
    this.nHQ.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().nGT);
    this.nHR = ((TextView)findViewById(2131297081));
    this.nHR.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().nGU);
    AppMethodBeat.o(22030);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22029);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(22029);
      return;
    }
    initView();
    this.EN = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().nGS;
    ae.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.EN) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().nGM = this;
    bKB();
    AppMethodBeat.o(22029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22031);
    super.onDestroy();
    ae.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.EN) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().nGM = null;
    AppMethodBeat.o(22031);
  }
  
  public final void onError(final int paramInt)
  {
    AppMethodBeat.i(22034);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22027);
        ae.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ae.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
          Intent localIntent = new Intent();
          localIntent.putExtra("title", BakToPcUI.this.getString(2131756219));
          localIntent.putExtra("rawUrl", BakToPcUI.this.getString(2131756178, new Object[] { ad.fom() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          d.b(BakToPcUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(22027);
          return;
        }
        BakToPcUI.e(BakToPcUI.this);
        AppMethodBeat.o(22027);
      }
    });
    AppMethodBeat.o(22034);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22035);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().hJc = 3;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKi().aCO();
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bKg().bKh().xO(1);
      acs(1);
      AppMethodBeat.o(22035);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22035);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI
 * JD-Core Version:    0.7.0.1
 */