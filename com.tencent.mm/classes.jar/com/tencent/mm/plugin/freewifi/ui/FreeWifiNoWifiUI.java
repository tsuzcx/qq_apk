package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.os.Bundle;
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
    return 2130969632;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(21058);
    super.onCreate(paramBundle);
    setBackBtn(new FreeWifiNoWifiUI.1(this));
    AppMethodBeat.o(21058);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNoWifiUI
 * JD-Core Version:    0.7.0.1
 */