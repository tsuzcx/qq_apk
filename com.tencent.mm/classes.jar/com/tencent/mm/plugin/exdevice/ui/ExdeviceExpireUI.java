package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2130969452;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(19967);
    super.onCreate(paramBundle);
    setMMTitle(2131299461);
    setBackBtn(new ExdeviceExpireUI.1(this));
    AppMethodBeat.o(19967);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceExpireUI
 * JD-Core Version:    0.7.0.1
 */