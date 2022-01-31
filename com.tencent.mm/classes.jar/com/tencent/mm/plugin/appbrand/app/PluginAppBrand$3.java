package com.tencent.mm.plugin.appbrand.app;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class PluginAppBrand$3
  implements ComponentCallbacks
{
  PluginAppBrand$3(PluginAppBrand paramPluginAppBrand) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(154847);
    PluginAppBrand.access$000();
    AppMethodBeat.o(154847);
  }
  
  public final void onLowMemory() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.3
 * JD-Core Version:    0.7.0.1
 */