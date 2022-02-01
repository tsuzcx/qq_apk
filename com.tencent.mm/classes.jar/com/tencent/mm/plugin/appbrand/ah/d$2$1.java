package com.tencent.mm.plugin.appbrand.ah;

import com.tencent.luggage.sdk.b.a.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.List;

final class d$2$1
  extends a.a
{
  d$2$1(d.2 param2, f paramf)
  {
    super(paramf);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(293038);
    boolean bool = this.EVo.fiZ.fiy.doInnerLoopTask();
    AppMethodBeat.o(293038);
    return bool;
  }
  
  public final String nativeInvokeHandler(final String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(293036);
    if ((this.EVo.fjO == null) || (!this.EVo.fjO.contains(paramString1)))
    {
      AppMethodBeat.o(293036);
      return "fail:not supported";
    }
    try
    {
      paramString1 = this.EVo.EVl.a(paramString1, paramString2, paramInt, paramBoolean, this.EVo.fjP);
      AppMethodBeat.o(293036);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      Log.printErrStackTrace("MicroMsg.V8EngineWorkerManagerLU", paramString1, "IMBInvokeHandler.invoke", new Object[0]);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          throw paramString1;
        }
      });
      AppMethodBeat.o(293036);
    }
    return "";
  }
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(293037);
    this.EVo.fiZ.fiy.resumeLoopTasks();
    AppMethodBeat.o(293037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.d.2.1
 * JD-Core Version:    0.7.0.1
 */