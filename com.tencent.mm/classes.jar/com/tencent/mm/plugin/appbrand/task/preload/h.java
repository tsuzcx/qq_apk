package com.tencent.mm.plugin.appbrand.task.preload;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class h
  extends i
{
  public static final h nRd;
  
  static
  {
    AppMethodBeat.i(51092);
    nRd = new h();
    AppMethodBeat.o(51092);
  }
  
  public static final void c(Application paramApplication)
  {
    AppMethodBeat.i(51090);
    p.h(paramApplication, "app");
    paramApplication.registerComponentCallbacks((ComponentCallbacks)nRd);
    AppMethodBeat.o(51090);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(51091);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51091);
      return;
      e.onTrimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.h
 * JD-Core Version:    0.7.0.1
 */