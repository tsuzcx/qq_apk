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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI
  extends MMWizardActivity
  implements e.a
{
  private int EX;
  private Button hPX;
  private Button hSq;
  private MMHandler handler;
  private TextView oSM;
  private TextView oSN;
  
  public BakToPcUI()
  {
    AppMethodBeat.i(22028);
    this.EX = -1;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(22028);
  }
  
  private void chu()
  {
    AppMethodBeat.i(22033);
    if (this.EX == 0)
    {
      this.hPX.setEnabled(true);
      this.hSq.setEnabled(true);
      AppMethodBeat.o(22033);
      return;
    }
    this.hPX.setEnabled(false);
    this.hSq.setEnabled(false);
    AppMethodBeat.o(22033);
  }
  
  public final void chm()
  {
    AppMethodBeat.i(22032);
    this.EX = 0;
    this.hPX.setVisibility(0);
    this.hSq.setVisibility(0);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
    return 2131493183;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22030);
    setMMTitle(2131756443);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22023);
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().Bu(1);
        BakToPcUI.a(BakToPcUI.this);
        AppMethodBeat.o(22023);
        return true;
      }
    });
    this.hPX = ((Button)findViewById(2131297220));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22024);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().iDM = 1;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().Bu(0);
          paramAnonymousView = new Intent(BakToPcUI.this, BakWaitingUI.class);
          MMWizardActivity.ay(BakToPcUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22024);
      }
    });
    this.hSq = ((Button)findViewById(2131297218));
    this.hSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22025);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().iDM = 2;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().aWm();
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().Bu(1);
          BakToPcUI.c(BakToPcUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22025);
      }
    });
    this.oSM = ((TextView)findViewById(2131297225));
    this.oSM.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRQ);
    this.oSN = ((TextView)findViewById(2131297226));
    this.oSN.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRR);
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
    this.EX = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRP;
    Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.EX) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRJ = this;
    chu();
    AppMethodBeat.o(22029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22031);
    super.onDestroy();
    Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.EX) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRJ = null;
    AppMethodBeat.o(22031);
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(22034);
    this.handler.post(new BakToPcUI.5(this, paramInt));
    AppMethodBeat.o(22034);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22035);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().iDM = 3;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().chb().aWm();
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().Bu(1);
      ala(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI
 * JD-Core Version:    0.7.0.1
 */