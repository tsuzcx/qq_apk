package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.l.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "pullType", "", "plugin-finder_release"})
public final class a$f
  implements l.a
{
  public a$f(a.g paramg) {}
  
  public final void a(com.tencent.mm.plugin.finder.feed.model.a parama, int paramInt)
  {
    AppMethodBeat.i(201223);
    k.h(parama, "info");
    Object localObject = this.qZf;
    if (parama.rmr > 0)
    {
      bool1 = true;
      a.a((a)localObject, bool1);
      localObject = this.qZf;
      if (parama.rmr != 1) {
        break label394;
      }
    }
    label394:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((a)localObject).qYZ = bool1;
      bool1 = parama.rms;
      boolean bool2 = parama.isNeedClear;
      ac.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + a.b(this.qZf) + " isGetHistory=" + a.a(this.qZf) + " isShowHistoryTip=" + this.qZf.qYZ + " ret_flag=" + parama.rmr + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + parama.rms + ' ' + "size=" + parama.incrementList.size() + " errorType=" + parama.errType + " errorCode=" + parama.errCode);
      a.b(parama.isNeedClear, parama.incrementList.size(), parama.rmr, paramInt);
      localObject = b.rCU;
      if ((b.czQ() == 2) || (parama.errType != 0) || (parama.errCode != 0) || (!a.a(this.qZf)) || (!bool1)) {
        break label399;
      }
      this.qZf.qYY = true;
      this.qZf.qYW.qZb = 3;
      a.a(this.qZf, (l.a)this.qZn, this.qZf.qYY, paramInt, parama.rmo, bool2);
      ac.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + a.b(this.qZf) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.qZf.qYY);
      this.qZf.qYY = false;
      AppMethodBeat.o(201223);
      return;
      bool1 = false;
      break;
    }
    label399:
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      e.wTc.idkeyStat(1279L, 1L, 1L, false);
      if ((parama.incrementList.isEmpty()) && (!a.a(this.qZf)))
      {
        parama.qXl = 1;
        a.ado("[finderstream]tabType=" + a.b(this.qZf) + " server error[list=0:ret_flag=0]");
        ac.i("Finder.FinderLbsFeedFetcher", "tabType=" + a.b(this.qZf) + " this time get finderstream return list=" + parama.incrementList.size() + " continue_flag=" + parama.qXl + " pullType=" + paramInt);
      }
    }
    for (;;)
    {
      this.qZn.a(parama, paramInt);
      AppMethodBeat.o(201223);
      return;
      ((Collection)parama.incrementList).isEmpty();
      parama.qXl = 1;
      break;
      e.wTc.idkeyStat(1279L, 2L, 1L, false);
      parama.qXl = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a.f
 * JD-Core Version:    0.7.0.1
 */