package com.tencent.mm.plugin.appbrand;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingWatchDog$SystemLowMemoryListenerImpl;", "Landroid/content/ComponentCallbacks2;", "()V", "alive", "", "dead", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onTrimMemory", "level", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class t$a
  implements ComponentCallbacks2
{
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    s.u(paramConfiguration, "newConfig");
  }
  
  public void onTrimMemory(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    onLowMemory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a
 * JD-Core Version:    0.7.0.1
 */