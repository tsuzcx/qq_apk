package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ
  extends MMWizardActivity
{
  public int getLayoutId()
  {
    return 2131495732;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110200);
    setMMTitle(2131764550);
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110196);
        SuccUnbindQQ.a(SuccUnbindQQ.this);
        AppMethodBeat.o(110196);
        return true;
      }
    });
    AppMethodBeat.o(110200);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110197);
    super.onCreate(paramBundle);
    AppMethodBeat.o(110197);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110198);
    super.onDestroy();
    AppMethodBeat.o(110198);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110199);
    super.onResume();
    initView();
    AppMethodBeat.o(110199);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.SuccUnbindQQ
 * JD-Core Version:    0.7.0.1
 */