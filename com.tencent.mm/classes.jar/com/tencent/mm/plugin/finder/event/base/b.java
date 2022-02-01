package com.tencent.mm.plugin.finder.event.base;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/Event;", "", "()V", "timestamp", "", "getTimestamp", "()J", "timestampMs", "getTimestampMs", "plugin-finder_release"})
public class b
{
  public final long tHW;
  private final long timestamp;
  
  public b()
  {
    AppMethodBeat.i(165551);
    this.timestamp = SystemClock.uptimeMillis();
    this.tHW = cl.aWA();
    AppMethodBeat.o(165551);
  }
  
  public final long dao()
  {
    return this.tHW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.b
 * JD-Core Version:    0.7.0.1
 */