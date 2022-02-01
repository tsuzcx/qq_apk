package com.tencent.mm.plugin.appbrand.jsapi.af.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af.c;
import com.tencent.mm.sdk.platformtools.Log;

@TargetApi(5)
public class b
  extends a
{
  private com.tencent.mm.audio.d.a.a pEN;
  private Runnable pEO;
  
  public b()
  {
    AppMethodBeat.i(137896);
    this.pEO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137895);
        b.this.bXl();
        AppMethodBeat.o(137895);
      }
    };
    AppMethodBeat.o(137896);
  }
  
  public c bXl()
  {
    AppMethodBeat.i(137898);
    if (this.pEN == null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.b
 * JD-Core Version:    0.7.0.1
 */