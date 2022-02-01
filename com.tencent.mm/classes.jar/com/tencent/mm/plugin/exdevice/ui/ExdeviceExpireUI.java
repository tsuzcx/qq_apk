package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return R.i.egr;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24036);
    super.onCreate(paramBundle);
    setMMTitle(R.l.eDY);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24035);
        ExdeviceExpireUI.this.finish();
        AppMethodBeat.o(24035);
        return false;
      }
    });
    AppMethodBeat.o(24036);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceExpireUI
 * JD-Core Version:    0.7.0.1
 */