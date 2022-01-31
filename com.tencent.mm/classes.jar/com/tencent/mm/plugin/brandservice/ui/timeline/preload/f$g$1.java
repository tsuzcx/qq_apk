package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.a.m;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"getDuractionMatrix", "", "", "start", "end", "invoke", "(JJ)[Ljava/lang/Long;"})
final class f$g$1
  extends k
  implements m<Long, Long, Long[]>
{
  f$g$1(f.g paramg)
  {
    super(2);
  }
  
  public final Long[] F(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(14811);
    Long[] arrayOfLong = f.a(new Long[] { Long.valueOf(paramLong2 - paramLong1), Long.valueOf(paramLong2 - this.kbv.kbu.kad) }, new long[] { paramLong1, paramLong2 });
    AppMethodBeat.o(14811);
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f.g.1
 * JD-Core Version:    0.7.0.1
 */