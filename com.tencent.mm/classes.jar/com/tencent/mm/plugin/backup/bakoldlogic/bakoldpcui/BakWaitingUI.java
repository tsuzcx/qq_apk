package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI
  extends MMWizardActivity
  implements e.c
{
  private int EN;
  private aq handler;
  private boolean nHT;
  
  public BakWaitingUI()
  {
    AppMethodBeat.i(22044);
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(22044);
  }
  
  final void bKC()
  {
    AppMethodBeat.i(22050);
    if ((6 == this.EN) || (1 == this.EN))
    {
      Intent localIntent = new Intent(this, BakOperatingUI.class);
      localIntent.putExtra("cmd", this.EN);
      MMWizardActivity.al(this, localIntent);
    }
    AppMethodBeat.o(22050);
  }
  
  public int getLayoutId()
  {
    return 2131493144;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22046);
    setMMTitle(2131756308);
    if (this.nHT) {
      findViewById(2131297078).setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(22040);
          BakWaitingUI.a(BakWaitingUI.this);
          AppMethodBeat.o(22040);
          return true;
        }
      });
      AppMethodBeat.o(22046);
      return;
      findViewById(2131297078).setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22045);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(22045);
      return;
    }
    a.bKg().bKh().nGL = this;
    this.EN = a.bKg().bKh().nGS;
    this.nHT = getIntent().getBooleanExtra("from_back_finish", false);
    ae.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.EN), Boolean.valueOf(this.nHT) });
    initView();
    bKC();
    AppMethodBeat.o(22045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22048);
    super.onDestroy();
    a.bKg().bKh().nGL = null;
    ae.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.EN), Boolean.valueOf(this.nHT) });
    AppMethodBeat.o(22048);
  }
  
  public final void onError(final int paramInt)
  {
    AppMethodBeat.i(22052);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22043);
        ae.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ae.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
          localIntent = new Intent();
          localIntent.putExtra("title", BakWaitingUI.this.getString(2131756219));
          localIntent.putExtra("rawUrl", BakWaitingUI.this.getString(2131756178, new Object[] { ad.fom() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(22043);
          return;
        }
        Intent localIntent = new Intent(BakWaitingUI.this, BakConnErrorUI.class);
        MMWizardActivity.al(BakWaitingUI.this, localIntent);
        AppMethodBeat.o(22043);
      }
    });
    AppMethodBeat.o(22052);
  }
  
  public final void onEvent(int paramInt)
  {
    AppMethodBeat.i(22047);
    this.EN = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22041);
        BakWaitingUI.this.bKC();
        AppMethodBeat.o(22041);
      }
    });
    AppMethodBeat.o(22047);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(22051);
    if (paramInt == 4)
    {
      acs(1);
      AppMethodBeat.o(22051);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(22051);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void xR(final int paramInt)
  {
    AppMethodBeat.i(22049);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22042);
        ae.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          ae.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
          Intent localIntent = new Intent();
          localIntent.putExtra("title", BakWaitingUI.this.getString(2131756219));
          localIntent.putExtra("rawUrl", BakWaitingUI.this.getString(2131756178, new Object[] { ad.fom() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          d.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(22042);
      }
    });
    AppMethodBeat.o(22049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI
 * JD-Core Version:    0.7.0.1
 */