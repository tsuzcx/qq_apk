package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FreeWifiMIGNoAuthStateUI
  extends FreeWifiNoAuthStateUI
{
  protected final String dNQ()
  {
    AppMethodBeat.i(25066);
    String str = getString(2131763048);
    AppMethodBeat.o(25066);
    return str;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiMIGNoAuthStateUI
 * JD-Core Version:    0.7.0.1
 */