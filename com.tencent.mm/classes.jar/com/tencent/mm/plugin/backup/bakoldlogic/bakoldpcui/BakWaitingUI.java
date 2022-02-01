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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI
  extends MMWizardActivity
  implements e.c
{
  private int Vh;
  private MMHandler handler;
  private boolean rUO;
  
  public BakWaitingUI()
  {
    AppMethodBeat.i(22044);
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(22044);
  }
  
  public final void EY(final int paramInt)
  {
    AppMethodBeat.i(22049);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22042);
        Log.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          Log.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
          Intent localIntent = new Intent();
          localIntent.putExtra("title", BakWaitingUI.this.getString(R.l.ero));
          localIntent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.backup_not_support_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          c.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
        }
        AppMethodBeat.o(22042);
      }
    });
    AppMethodBeat.o(22049);
  }
  
  final void cuG()
  {
    AppMethodBeat.i(22050);
    if ((6 == this.Vh) || (1 == this.Vh))
    {
      Intent localIntent = new Intent(this, BakOperatingUI.class);
      localIntent.putExtra("cmd", this.Vh);
      MMWizardActivity.aH(this, localIntent);
    }
    AppMethodBeat.o(22050);
  }
  
  public int getLayoutId()
  {
    return R.i.ebY;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22046);
    setMMTitle(R.l.esv);
    if (this.rUO) {
      findViewById(R.h.dsU).setVisibility(8);
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
      findViewById(R.h.dsU).setVisibility(0);
    }
  }
  
  public final void kv(final int paramInt)
  {
    AppMethodBeat.i(22052);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22043);
        Log.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt == -1)
        {
          Log.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
          localIntent = new Intent();
          localIntent.putExtra("title", BakWaitingUI.this.getString(R.l.ero));
          localIntent.putExtra("rawUrl", BakWaitingUI.this.getString(R.l.backup_not_support_doc, new Object[] { LocaleUtil.getApplicationLanguage() }));
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          c.b(BakWaitingUI.this, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(22043);
          return;
        }
        Intent localIntent = new Intent(BakWaitingUI.this, BakConnErrorUI.class);
        MMWizardActivity.aH(BakWaitingUI.this, localIntent);
        AppMethodBeat.o(22043);
      }
    });
    AppMethodBeat.o(22052);
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
    a.cuk().cul().rTH = this;
    this.Vh = a.cuk().cul().rTO;
    this.rUO = getIntent().getBooleanExtra("from_back_finish", false);
    Log.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.Vh), Boolean.valueOf(this.rUO) });
    initView();
    cuG();
    AppMethodBeat.o(22045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22048);
    super.onDestroy();
    a.cuk().cul().rTH = null;
    Log.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.Vh), Boolean.valueOf(this.rUO) });
    AppMethodBeat.o(22048);
  }
  
  public final void onEvent(int paramInt)
  {
    AppMethodBeat.i(22047);
    this.Vh = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22041);
        BakWaitingUI.this.cuG();
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
      atX(1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI
 * JD-Core Version:    0.7.0.1
 */