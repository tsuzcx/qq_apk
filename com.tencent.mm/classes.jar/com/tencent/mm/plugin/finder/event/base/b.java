package com.tencent.mm.plugin.finder.event.base;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/Event;", "", "()V", "timestamp", "", "getTimestamp", "()J", "timestampMs", "getTimestampMs", "plugin-finder_release"})
public class b
{
  public final long rZe;
  private final long timestamp;
  
  public b()
  {
    AppMethodBeat.i(165551);
    this.timestamp = SystemClock.uptimeMillis();
    this.rZe = ch.aDc();
    AppMethodBeat.o(165551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.b
 * JD-Core Version:    0.7.0.1
 */