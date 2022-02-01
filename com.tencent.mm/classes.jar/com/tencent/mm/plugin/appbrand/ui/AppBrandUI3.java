package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandUI3
  extends AppBrandUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI3
 * JD-Core Version:    0.7.0.1
 */