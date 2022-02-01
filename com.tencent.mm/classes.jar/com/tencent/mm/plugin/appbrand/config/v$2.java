package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ee;
import org.json.JSONObject;

final class v$2
  implements Runnable
{
  v$2(v paramv, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(44904);
    try
    {
      ee localee = r.x(new JSONObject(this.jeG));
      p.b(this.val$appId, localee.Cyu);
      AppMethodBeat.o(44904);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(44904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v.2
 * JD-Core Version:    0.7.0.1
 */