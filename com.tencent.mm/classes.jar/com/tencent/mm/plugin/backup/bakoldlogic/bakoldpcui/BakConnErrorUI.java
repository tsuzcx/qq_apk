package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI
  extends MMWizardActivity
{
  private int mzJ;
  
  public int getLayoutId()
  {
    return 2131493141;
  }
  
  public void initView()
  {
    AppMethodBeat.i(21973);
    setMMTitle(2131756308);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(21971);
        BakConnErrorUI.a(BakConnErrorUI.this);
        AppMethodBeat.o(21971);
        return true;
      }
    });
    AppMethodBeat.o(21973);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21972);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(21972);
      return;
    }
    this.mzJ = getIntent().getIntExtra("cmd", -1);
    ad.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[] { Integer.valueOf(this.mzJ) });
    initView();
    a.byd().bye().mzc = -1;
    AppMethodBeat.o(21972);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(21974);
    super.onDestroy();
    a.byd().bye().myU = null;
    ad.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[] { Integer.valueOf(this.mzJ) });
    AppMethodBeat.o(21974);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(21975);
    if (paramInt == 4)
    {
      Xo(1);
      AppMethodBeat.o(21975);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(21975);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI
 * JD-Core Version:    0.7.0.1
 */