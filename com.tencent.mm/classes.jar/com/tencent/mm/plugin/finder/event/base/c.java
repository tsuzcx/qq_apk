package com.tencent.mm.plugin.finder.event.base;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/Event;", "", "()V", "timestamp", "", "getTimestamp", "()J", "timestampMs", "getTimestampMs", "plugin-finder_release"})
public class c
{
  public final long KLZ;
  private final long timestamp;
  
  public c()
  {
    AppMethodBeat.i(165551);
    this.timestamp = SystemClock.uptimeMillis();
    this.KLZ = ce.asS();
    AppMethodBeat.o(165551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.c
 * JD-Core Version:    0.7.0.1
 */