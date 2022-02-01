package com.tencent.mm.plugin.finder.nearby.trace;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingTraceHelper;", "", "()V", "nearbyHomeTrace", "Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyHomeTimeConsumingTrace;", "getNearbyHomeTrace", "Action", "plugin-finder-nearby_release"})
public final class c
{
  private static final a zJC;
  public static final c zJD;
  
  static
  {
    AppMethodBeat.i(199684);
    zJD = new c();
    zJC = new a("NearbyHome");
    AppMethodBeat.o(199684);
  }
  
  public static a dMD()
  {
    return zJC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.trace.c
 * JD-Core Version:    0.7.0.1
 */