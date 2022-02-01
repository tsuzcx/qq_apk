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
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.MMWizardActivity;

public class BakToPcUI
  extends MMWizardActivity
  implements e.a
{
  private int CW;
  private Button gAJ;
  private Button gCY;
  private ao handler;
  private TextView nbY;
  private TextView nbZ;
  
  public BakToPcUI()
  {
    AppMethodBeat.i(22028);
    this.CW = -1;
    this.handler = new ao(Looper.getMainLooper());
    AppMethodBeat.o(22028);
  }
  
  private void bFu()
  {
    AppMethodBeat.i(22033);
    if (this.CW == 0)
    {
      this.gAJ.setEnabled(true);
      this.gCY.setEnabled(true);
      AppMethodBeat.o(22033);
      return;
    }
    this.gAJ.setEnabled(false);
    this.gCY.setEnabled(false);
    AppMethodBeat.o(22033);
  }
  
  public final void bFm()
  {
    AppMethodBeat.i(22032);
    this.CW = 0;
    this.gAJ.setVisibility(0);
    this.gCY.setVisibility(0);
    new ao(Looper.getMainLooper()).post(new Runnable()
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
        a.bEZ().bFa().xe(1);
        BakToPcUI.a(BakToPcUI.this);
        AppMethodBeat.o(22023);
        return true;
      }
    });
    this.gAJ = ((Button)findViewById(2131297075));
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22024);
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          a.bEZ().bFb().hnS = 1;
          a.bEZ().bFa().xe(0);
          paramAnonymousView = new Intent(BakToPcUI.this, BakWaitingUI.class);
          MMWizardActivity.aj(BakToPcUI.this, paramAnonymousView);
        }
        AppMethodBeat.o(22024);
      }
    });
    this.gCY = ((Button)findViewById(2131297073));
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(22025);
        if (BakToPcUI.b(BakToPcUI.this) == 0)
        {
          a.bEZ().bFb().hnS = 2;
          a.bEZ().bFb().azv();
          a.bEZ().bFa().xe(1);
          BakToPcUI.c(BakToPcUI.this);
        }
        AppMethodBeat.o(22025);
      }
    });
    this.nbY = ((TextView)findViewById(2131297080));
    this.nbY.setText(a.bEZ().bFa().nbb);
    this.nbZ = ((TextView)findViewById(2131297081));
    this.nbZ.setText(a.bEZ().bFa().nbc);
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
    this.CW = a.bEZ().bFa().nba;
    ac.i("MicroMsg.BakToPcUI", "BakToPcUI auth onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.CW) });
    a.bEZ().bFa().naU = this;
    bFu();
    AppMethodBeat.o(22029);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22031);
    super.onDestroy();
    ac.i("MicroMsg.BakToPcUI", "BakToPcUI auth onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.CW) });
    a.bEZ().bFa().naU = null;
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
        ac.d("MicroMsg.BakToPcUI", "BakToPcUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ac.d("MicroMsg.BakToPcUI", "BakToPcUI jump tips");
          Intent localIntent = new Intent();
          localIntent.putExtra("title", BakToPcUI.this.getString(2131756219));
          localIntent.putExtra("rawUrl", BakToPcUI.this.getString(2131756178, new Object[] { ab.eUO() }));
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
      a.bEZ().bFb().hnS = 3;
      a.bEZ().bFb().azv();
      a.bEZ().bFa().xe(1);
      ZA(1);
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