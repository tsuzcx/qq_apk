package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  private static boolean rDe = false;
  
  private static boolean l(f paramf)
  {
    AppMethodBeat.i(327772);
    paramf = (a)paramf.T(a.class);
    if (paramf != null) {}
    for (boolean bool = paramf.cqg();; bool = false)
    {
      Log.i("MicroMsg.Audio.AudioInterruptionEventDispatcher", "isOpenAudioInterruption:%b ", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(327772);
      return bool;
    }
  }
  
  public static void m(f paramf)
  {
    AppMethodBeat.i(327774);
    if (!l(paramf))
    {
      AppMethodBeat.o(327774);
      return;
    }
    new q().i(paramf).cpV();
    Log.i("MicroMsg.Audio.AudioInterruptionEventDispatcher", "dispatchInterruptionBegin");
    rDe = true;
    AppMethodBeat.o(327774);
  }
  
  public static void n(f paramf)
  {
    AppMethodBeat.i(327777);
    if (!l(paramf))
    {
      AppMethodBeat.o(327777);
      return;
    }
    if (!rDe)
    {
      AppMethodBeat.o(327777);
      return;
    }
    rDe = false;
    new r().i(paramf).cpV();
    Log.i("MicroMsg.Audio.AudioInterruptionEventDispatcher", "dispatchInterruptionEnd");
    AppMethodBeat.o(327777);
  }
  
  public static abstract interface a
    extends b
  {
    public abstract boolean cqg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.d
 * JD-Core Version:    0.7.0.1
 */