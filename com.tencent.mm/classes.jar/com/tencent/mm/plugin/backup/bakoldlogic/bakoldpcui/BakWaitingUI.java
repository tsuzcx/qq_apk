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
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI
  extends MMWizardActivity
  implements e.c
{
  private int EX;
  private MMHandler handler;
  private boolean oSP;
  
  public BakWaitingUI()
  {
    AppMethodBeat.i(22044);
    this.handler = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(22044);
  }
  
  public final void Bx(int paramInt)
  {
    AppMethodBeat.i(22049);
    this.handler.post(new BakWaitingUI.3(this, paramInt));
    AppMethodBeat.o(22049);
  }
  
  final void chv()
  {
    AppMethodBeat.i(22050);
    if ((6 == this.EX) || (1 == this.EX))
    {
      Intent localIntent = new Intent(this, BakOperatingUI.class);
      localIntent.putExtra("cmd", this.EX);
      MMWizardActivity.ay(this, localIntent);
    }
    AppMethodBeat.o(22050);
  }
  
  public int getLayoutId()
  {
    return 2131493187;
  }
  
  public void initView()
  {
    AppMethodBeat.i(22046);
    setMMTitle(2131756443);
    if (this.oSP) {
      findViewById(2131297223).setVisibility(8);
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
      findViewById(2131297223).setVisibility(0);
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
    a.cgZ().cha().oRI = this;
    this.EX = a.cgZ().cha().oRP;
    this.oSP = getIntent().getBooleanExtra("from_back_finish", false);
    Log.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.EX), Boolean.valueOf(this.oSP) });
    initView();
    chv();
    AppMethodBeat.o(22045);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22048);
    super.onDestroy();
    a.cgZ().cha().oRI = null;
    Log.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[] { Integer.valueOf(this.EX), Boolean.valueOf(this.oSP) });
    AppMethodBeat.o(22048);
  }
  
  public final void onError(int paramInt)
  {
    AppMethodBeat.i(22052);
    this.handler.post(new BakWaitingUI.4(this, paramInt));
    AppMethodBeat.o(22052);
  }
  
  public final void onEvent(int paramInt)
  {
    AppMethodBeat.i(22047);
    this.EX = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22041);
        BakWaitingUI.this.chv();
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
      ala(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakWaitingUI
 * JD-Core Version:    0.7.0.1
 */