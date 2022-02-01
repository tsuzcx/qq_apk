package com.tencent.mm.plugin.lite.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WxaLiteAppMMUI
  extends WxaLiteAppUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.ui.WxaLiteAppMMUI
 * JD-Core Version:    0.7.0.1
 */