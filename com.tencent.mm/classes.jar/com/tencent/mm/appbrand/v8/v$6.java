package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class v$6
  implements Runnable
{
  public v$6(v paramv, m paramm, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(216914);
    m localm = this.drc;
    String str = this.val$msg;
    if (localm.XJ().getType("onmessage") == 7) {
      try
      {
        V8Function localV8Function = (V8Function)localm.XJ().get("onmessage");
        V8Array localV8Array = localm.XJ().newV8Array();
        localV8Array.push(str);
        localV8Function.call(localm.XJ().getGlobalObject(), localV8Array);
        localV8Function.release();
        localV8Array.release();
        AppMethodBeat.o(216914);
        return;
      }
      catch (V8ScriptException localV8ScriptException)
      {
        Log.printErrStackTrace("MicroMsg.V8EngineWorkerManager", localV8ScriptException, "hy: js exception in worker!", new Object[0]);
        v.a(localm, localV8ScriptException.getMessage(), localV8ScriptException.getJSStackTrace());
      }
    }
    AppMethodBeat.o(216914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.v.6
 * JD-Core Version:    0.7.0.1
 */