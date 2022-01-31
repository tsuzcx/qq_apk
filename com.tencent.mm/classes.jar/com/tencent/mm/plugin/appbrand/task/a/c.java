package com.tencent.mm.plugin.appbrand.task.a;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.g;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c
  extends g
{
  public static final c iLu;
  
  static
  {
    AppMethodBeat.i(134973);
    iLu = new c();
    AppMethodBeat.o(134973);
  }
  
  public static final void f(Application paramApplication)
  {
    AppMethodBeat.i(134971);
    j.q(paramApplication, "app");
    paramApplication.registerComponentCallbacks((ComponentCallbacks)iLu);
    AppMethodBeat.o(134971);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(134972);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(134972);
      return;
      a.onTrimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.c
 * JD-Core Version:    0.7.0.1
 */