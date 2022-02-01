package com.tencent.mm.plugin.lite.ui;

import com.tencent.liteapp.ui.WxaLiteAppUI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;

public class WxaLiteAppLiteUI
  extends WxaLiteAppUI
{
  public final boolean isDarkMode()
  {
    AppMethodBeat.i(271448);
    boolean bool = aw.isDarkMode();
    AppMethodBeat.o(271448);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppLiteUI
 * JD-Core Version:    0.7.0.1
 */