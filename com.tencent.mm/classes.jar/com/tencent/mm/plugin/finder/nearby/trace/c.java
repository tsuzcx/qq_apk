package com.tencent.mm.plugin.finder.nearby.trace;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyTimeConsumingTraceHelper;", "", "()V", "nearbyHomeTrace", "Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyHomeTimeConsumingTrace;", "getNearbyHomeTrace", "Action", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c ERD;
  private static final a ERE;
  
  static
  {
    AppMethodBeat.i(339611);
    ERD = new c();
    ERE = new a("NearbyHome");
    AppMethodBeat.o(339611);
  }
  
  public static a eGR()
  {
    return ERE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.trace.c
 * JD-Core Version:    0.7.0.1
 */