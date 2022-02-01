package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandUI1
  extends AppBrandUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48859);
    super.onCreate(paramBundle);
    AppMethodBeat.o(48859);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(48860);
    super.onResume();
    AppMethodBeat.o(48860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI1
 * JD-Core Version:    0.7.0.1
 */