package com.tencent.mm.plugin.appbrand.task.a;

import a.f.b.j;
import a.l;
import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "update", "", "plugin-appbrand-integration_release"})
final class a$b
  extends SparseLongArray
{
  public a$b()
  {
    super(a.a.values().length);
    AppMethodBeat.i(134965);
    AppMethodBeat.o(134965);
  }
  
  public final long c(a.a parama)
  {
    AppMethodBeat.i(143981);
    j.q(parama, "type");
    if (a.a.iLr == parama)
    {
      AppMethodBeat.o(143981);
      return 0L;
    }
    long l = super.get(parama.ordinal(), 0L);
    AppMethodBeat.o(143981);
    return l;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(143982);
    j.q(parama, "type");
    super.put(parama.ordinal(), bo.yB());
    AppMethodBeat.o(143982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.a.b
 * JD-Core Version:    0.7.0.1
 */