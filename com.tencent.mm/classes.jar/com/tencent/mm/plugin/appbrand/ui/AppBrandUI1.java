package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandUI1
  extends AppBrandUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(133152);
    super.onCreate(paramBundle);
    AppMethodBeat.o(133152);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(133153);
    super.onResume();
    AppMethodBeat.o(133153);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI1
 * JD-Core Version:    0.7.0.1
 */