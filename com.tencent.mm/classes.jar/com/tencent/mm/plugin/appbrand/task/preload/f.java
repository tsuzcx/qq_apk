package com.tencent.mm.plugin.appbrand.task.preload;

import android.app.Application;
import android.content.ComponentCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.o;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadMemoryStressReceiver;", "Lcom/tencent/mm/plugin/appbrand/utils/ApplicationTrimMemoryListener;", "()V", "onTrimMemory", "", "level", "", "setup", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends o
{
  public static final f tXn;
  
  static
  {
    AppMethodBeat.i(51092);
    tXn = new f();
    AppMethodBeat.o(51092);
  }
  
  public static final void f(Application paramApplication)
  {
    AppMethodBeat.i(51090);
    s.u(paramApplication, "app");
    paramApplication.registerComponentCallbacks((ComponentCallbacks)tXn);
    AppMethodBeat.o(51090);
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.preload.f
 * JD-Core Version:    0.7.0.1
 */