package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNoWifiUI
  extends MMActivity
{
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494174;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25117);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25116);
        FreeWifiNoWifiUI.this.finish();
        AppMethodBeat.o(25116);
        return true;
      }
    });
    AppMethodBeat.o(25117);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoWifiUI
 * JD-Core Version:    0.7.0.1
 */