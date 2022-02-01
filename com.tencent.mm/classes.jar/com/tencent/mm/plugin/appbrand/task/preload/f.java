package com.tencent.mm.plugin.appbrand.task.preload;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.i;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class f
  extends i
{
  public static final f mEo;
  
  static
  {
    AppMethodBeat.i(51092);
    mEo = new f();
    AppMethodBeat.o(51092);
  }
  
  public static final void c(Application paramApplication)
  {
    AppMethodBeat.i(51090);
    p.h(paramApplication, "app");
    paramApplication.registerComponentCallbacks((ComponentCallbacks)mEo);
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
      d.onTrimMemory(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.f
 * JD-Core Version:    0.7.0.1
 */