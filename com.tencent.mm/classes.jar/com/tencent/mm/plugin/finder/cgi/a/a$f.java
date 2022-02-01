package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$getStream$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
public final class a$f
  implements g.a
{
  public a$f(a.g paramg) {}
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(197345);
    k.h(paramc, "info");
    Object localObject = this.KKc;
    if (paramc.qyr > 0)
    {
      bool1 = true;
      a.a((a)localObject, bool1);
      localObject = this.KKc;
      if (paramc.qyr != 1) {
        break label394;
      }
    }
    label394:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((a)localObject).KJW = bool1;
      bool1 = paramc.qyu;
      boolean bool2 = paramc.isNeedClear;
      ad.i("Finder.FinderLbsFeedFetcher", "[getStream] tabType=" + a.b(this.KKc) + " isGetHistory=" + a.a(this.KKc) + " isShowHistoryTip=" + this.KKc.KJW + " ret_flag=" + paramc.qyr + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramc.qyu + ' ' + "size=" + paramc.incrementList.size() + " errorType=" + paramc.errType + " errorCode=" + paramc.errCode);
      a.b(paramc.isNeedClear, paramc.incrementList.size(), paramc.qyr, paramInt);
      localObject = b.qJA;
      if ((b.fUt() == 2) || (paramc.errType != 0) || (paramc.errCode != 0) || (!a.a(this.KKc)) || (!bool1)) {
        break label399;
      }
      this.KKc.KJV = true;
      this.KKc.KJS.KJY = 3;
      a.a(this.KKc, (g.a)this.KKk, this.KKc.KJV, paramInt, paramc.qyo, bool2);
      ad.i("Finder.FinderLbsFeedFetcher", "get history to fill... tabType=" + a.b(this.KKc) + " pullType=" + paramInt + " isHistoryFirstPage=" + this.KKc.KJV);
      this.KKc.KJV = false;
      AppMethodBeat.o(197345);
      return;
      bool1 = false;
      break;
    }
    label399:
    if ((paramc.errType == 0) && (paramc.errCode == 0))
    {
      e.vIY.idkeyStat(1279L, 1L, 1L, false);
      if ((paramc.incrementList.isEmpty()) && (!a.a(this.KKc)))
      {
        paramc.qys = 1;
        a.aVg("[finderstream]tabType=" + a.b(this.KKc) + " server error[list=0:ret_flag=0]");
        ad.i("Finder.FinderLbsFeedFetcher", "tabType=" + a.b(this.KKc) + " this time get finderstream return list=" + paramc.incrementList.size() + " continue_flag=" + paramc.qys + " pullType=" + paramInt);
      }
    }
    for (;;)
    {
      this.KKk.a(paramc, paramInt);
      AppMethodBeat.o(197345);
      return;
      ((Collection)paramc.incrementList).isEmpty();
      paramc.qys = 1;
      break;
      e.vIY.idkeyStat(1279L, 2L, 1L, false);
      paramc.qys = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.a.f
 * JD-Core Version:    0.7.0.1
 */