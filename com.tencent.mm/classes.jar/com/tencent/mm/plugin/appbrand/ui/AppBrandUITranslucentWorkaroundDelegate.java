package com.tencent.mm.plugin.appbrand.ui;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;

class AppBrandUITranslucentWorkaroundDelegate
  implements LifecycleObserver, b.a
{
  final AppBrandUI nXT;
  boolean nXU = false;
  boolean nXV = false;
  
  AppBrandUITranslucentWorkaroundDelegate(AppBrandUI paramAppBrandUI)
  {
    this.nXT = paramAppBrandUI;
  }
  
  public final void bXA()
  {
    this.nXU = true;
  }
  
  public final void bXB()
  {
    this.nXU = false;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  void onActivityResumed()
  {
    AppMethodBeat.i(227705);
    if (this.nXV)
    {
      b.bp(this.nXT);
      this.nXV = false;
    }
    AppMethodBeat.o(227705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUITranslucentWorkaroundDelegate
 * JD-Core Version:    0.7.0.1
 */