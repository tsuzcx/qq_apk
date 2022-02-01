package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

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
  private int bUl;
  private MMHandler handler;
  private Button nhC;
  private Button njI;
  private TextView vga;
  private TextView vgb;
  
  public BakToPcUI()
  {
    AppMethodBeat.i(22028);
    this.bUl = -1;
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(22028);
  }
  
  private void cXp()
  {
    AppMethodBeat.i(22033);
    if (this.bUl == 0)
    {
      this.nhC.setEnabled(true);
      this.njI.setEnabled(true);
      AppMethodBeat.o(22033);
      return;
    }
    this.nhC.setEnabled(false);
    this.njI.setEnabled(false);
    AppMethodBeat.o(22033);
  }
  
  public final void cXh()
  {
    AppMethodBeat.i(22032);
    this.bUl = 0;
    this.nhC.setVisibility(0);
    this.njI.setVisibility(0);
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
    return R.i.geC;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22030);
    setMMTitle(R.l.gvw);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(22023);
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().Fw(1);
        BakToPcUI.a(BakToPcUI.this);
        AppMethodBeat.o(22023);
        return true;
      }
    });
    this.nhC = ((Button)findViewById(R.h.fti));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22024);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().olm = 1;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().Fw(0);
          paramAnonymousView = new Intent(BakToPcUI.this, BakWaitingUI.class);
          MMWizardActivity.aQ(BakToPcUI.this, paramAnonymousView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22024);
      }
    });
    this.njI = ((Button)findViewById(R.h.ftg));
    this.njI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22025);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().olm = 2;
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().bDh();
          com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().Fw(1);
          BakToPcUI.c(BakToPcUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakToPcUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(22025);
      }
    });
    this.vga = ((TextView)findViewById(R.h.ftm));
    this.vga.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vff);
    this.vgb = ((TextView)findViewById(R.h.ftn));
    this.vgb.setText(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfg);
    AppMethodBeat.o(22030);
  }
  
  public final void oc(final int paramInt)
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
          localIntent.putExtra("title", BakToPcUI.this.getString(R.l.gup));
          localIntent.putExtra("rawUrl", BakToPcUI.this.getString(R.l.backup_not_support_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          com.tencent.mm.br.c.b(BakToPcUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
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
    this.bUl = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfe;
    Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.bUl) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().veY = this;
    cXp();
    AppMethodBeat.o(22029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22031);
    super.onDestroy();
    Log.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.bUl) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().veY = null;
    AppMethodBeat.o(22031);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22035);
    if (paramInt == 4)
    {
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().olm = 3;
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWW().bDh();
      com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().Fw(1);
      aAp(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI
 * JD-Core Version:    0.7.0.1
 */