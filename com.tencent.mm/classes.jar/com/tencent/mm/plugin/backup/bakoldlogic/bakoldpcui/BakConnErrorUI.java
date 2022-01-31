package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI
  extends MMWizardActivity
{
  private int jIs;
  
  public int getLayoutId()
  {
    return 2130968812;
  }
  
  public void initView()
  {
    AppMethodBeat.i(17917);
    setMMTitle(2131297432);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(17915);
        BakConnErrorUI.a(BakConnErrorUI.this);
        AppMethodBeat.o(17915);
        return true;
      }
    });
    AppMethodBeat.o(17917);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(17916);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(17916);
      return;
    }
    this.jIs = getIntent().getIntExtra("cmd", -1);
    ab.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.jIs) });
    initView();
    a.aUU().aUV().jHK = -1;
    AppMethodBeat.o(17916);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(17918);
    super.onDestroy();
    a.aUU().aUV().jHC = null;
    ab.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.jIs) });
    AppMethodBeat.o(17918);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(17919);
    if (paramInt == 4)
    {
      Oi(1);
      AppMethodBeat.o(17919);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(17919);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI
 * JD-Core Version:    0.7.0.1
 */