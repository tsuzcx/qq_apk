package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FreeWifiMIGNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  protected final String bBn()
  {
    AppMethodBeat.i(21007);
    String str = getString(2131301562);
    AppMethodBeat.o(21007);
    return str;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiMIGNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */