package com.tencent.mm.plugin.finder.nearby.trace;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.findersdk.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyHomeTimeConsumingTrace;", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "traceName", "", "(Ljava/lang/String;)V", "activityHashCode", "", "endTrace", "", "node", "setActivityHashCode", "plugin-finder-nearby_release"})
public final class a
  extends c
{
  public int fuR;
  
  public a(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(201093);
    AppMethodBeat.o(201093);
  }
  
  public final void fp(String paramString)
  {
    AppMethodBeat.i(201092);
    p.k(paramString, "node");
    long l = SystemClock.elapsedRealtime();
    super.fp(paramString);
    paramString = e.zUG;
    e.Pd(this.fuR);
    paramString = e.zUG;
    int i = this.fuR;
    paramString = eoa();
    p.k(paramString, "json");
    e.a locala = e.Pe(i);
    if (locala != null) {
      locala.zUM = paramString;
    }
    Log.i("NearbyHomeTimeConsumingTrace", "time:" + (SystemClock.elapsedRealtime() - l));
    AppMethodBeat.o(201092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.trace.a
 * JD-Core Version:    0.7.0.1
 */