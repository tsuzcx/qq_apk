package com.tencent.mm.plugin.appbrand.jsapi.ai.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.c;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a sJY;
  private Runnable sJZ;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.sJZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.cxx();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c cxx()
  {
    AppMethodBeat.i(137898);
    if (this.sJY == null)
    {
      Log.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
      c localc = new c("may be not start", new Object[0]);
      AppMethodBeat.o(137898);
      return localc;
    }
    AppMethodBeat.o(137898);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.a.b
 * JD-Core Version:    0.7.0.1
 */