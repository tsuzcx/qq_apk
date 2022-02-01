package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.upload.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/report/FinderPostReportLogic$postListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-finder_release"})
public final class c$a
  implements k
{
  public final void onPostEnd(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166567);
    c localc = c.rxi;
    c.uq(paramLong);
    AppMethodBeat.o(166567);
  }
  
  public final void onPostNotify(long paramLong, boolean paramBoolean) {}
  
  public final void onPostOk(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(166568);
    c localc = c.rxi;
    c.up(paramLong2);
    AppMethodBeat.o(166568);
  }
  
  public final void onPostStart(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.c.a
 * JD-Core Version:    0.7.0.1
 */