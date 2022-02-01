package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fo;
import org.json.JSONObject;

final class af$2
  implements Runnable
{
  af$2(af paramaf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(44904);
    try
    {
      fo localfo = x.R(new JSONObject(this.rbg));
      if (localfo != null) {
        s.b(this.etl, localfo.YGZ);
      }
      AppMethodBeat.o(44904);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(44904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.af.2
 * JD-Core Version:    0.7.0.1
 */