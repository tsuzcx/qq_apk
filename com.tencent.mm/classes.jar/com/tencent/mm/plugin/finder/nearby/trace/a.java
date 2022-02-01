package com.tencent.mm.plugin.finder.nearby.trace;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.report.j.a;
import com.tencent.mm.plugin.findersdk.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/trace/NearbyHomeTimeConsumingTrace;", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "traceName", "", "(Ljava/lang/String;)V", "activityHashCode", "", "endTrace", "", "node", "setActivityHashCode", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public int hzl;
  
  public a(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(339602);
    AppMethodBeat.o(339602);
  }
  
  public final void gG(String paramString)
  {
    AppMethodBeat.i(339616);
    s.u(paramString, "node");
    long l = SystemClock.elapsedRealtime();
    super.gG(paramString);
    paramString = j.Fpm;
    j.Sf(this.hzl);
    paramString = j.Fpm;
    int i = this.hzl;
    paramString = ftd();
    s.u(paramString, "json");
    j.a locala = j.Sg(i);
    if (locala != null) {
      locala.Fps = paramString;
    }
    Log.i("NearbyHomeTimeConsumingTrace", s.X("time:", Long.valueOf(SystemClock.elapsedRealtime() - l)));
    AppMethodBeat.o(339616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.trace.a
 * JD-Core Version:    0.7.0.1
 */