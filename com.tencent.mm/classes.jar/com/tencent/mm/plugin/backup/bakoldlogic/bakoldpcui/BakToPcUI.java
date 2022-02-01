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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI
  extends MMWizardActivity
  implements e.a
{
  private int Vh;
  private MMHandler handler;
  private Button kEt;
  private Button kGN;
  private TextView rUL;
  private TextView rUM;
  
  public BakToPcUI()
  {
    AppMethodBeat.i(22028);
    this.Vh = -1;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(22028);
  }
  
  private void cuF()
  {
    AppMethodBeat.i(22033);
    if (this.Vh == 0)
    {
      this.kEt.setEnabled(true);
      this.kGN.setEnabled(true);
      AppMethodBeat.o(22033);
      return;
    }
    this.kEt.setEnabled(false);
    this.kGN.setEnabled(false);
    AppMethodBeat.o(22033);
  }
  
  public final void cux()
  {
    AppMethodBeat.i(22032);
    this.Vh = 0;
    this.kEt.setVisibility(0);
    this.kGN.setVisibility(0);
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
    return R.i.ebU;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22030);
    setMMTitle(R.l.esv);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22023);
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().EV(1);
        BakToPcUI.a(BakToPcUI.this);
        AppMethodBeat.o(22023);
        return true;
      }
    });
    this.kEt = ((Button)findViewById(R.h.dsR));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22024);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cum().ltN = 1;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().EV(0);
          paramAnonymousView = new Intent(BakToPcUI.this, BakWaitingUI.class);
          MMWizardActivity.aH(BakToPcUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22024);
      }
    });
    this.kGN = ((Button)findViewById(R.h.dsP));
    this.kGN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22025);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cum().ltN = 2;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cum().bfq();
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().EV(1);
          BakToPcUI.c(BakToPcUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22025);
      }
    });
    this.rUL = ((TextView)findViewById(R.h.dsV));
    this.rUL.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTP);
    this.rUM = ((TextView)findViewById(R.h.dsW));
    this.rUM.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTQ);
    AppMethodBeat.o(22030);
  }
  
  public final void kv(final int paramInt)
  {
    AppMethodBeat.i(22034);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22027);
        Log.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          Log.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
          Intent localIntent = new Intent();
          localIntent.putExtra("title", BakToPcUI.this.getString(R.l.ero));
          localIntent.putExtra("rawUrl", BakToPcUI.this.getString(R.l.backup_not_support_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          com.tencent.mm.by.c.b(BakToPcUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(22027);
          return;
        }
        BakToPcUI.e(BakToPcUI.this);
        AppMethodBeat.o(22027);
      }
    });
    AppMethodBeat.o(22034);
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
    this.Vh = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTO;
    Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.Vh) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTI = this;
    cuF();
    AppMethodBeat.o(22029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22031);
    super.onDestroy();
    Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.Vh) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTI = null;
    AppMethodBeat.o(22031);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22035);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cum().ltN = 3;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cum().bfq();
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().EV(1);
      atX(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI
 * JD-Core Version:    0.7.0.1
 */