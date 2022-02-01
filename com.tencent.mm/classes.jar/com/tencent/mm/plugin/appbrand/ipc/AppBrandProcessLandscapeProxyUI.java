package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandProcessLandscapeProxyUI
  extends AppBrandProcessProxyUI
{
  public int getForceOrientation()
  {
    return 6;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessLandscapeProxyUI
 * JD-Core Version:    0.7.0.1
 */