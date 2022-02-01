package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import com.tencent.liteapp.ui.WxaLiteAppUI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class WxaLiteAppLiteUI
  extends WxaLiteAppUI
{
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(198949);
    boolean bool = ao.isDarkMode();
    AppMethodBeat.o(198949);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppLiteUI
 * JD-Core Version:    0.7.0.1
 */