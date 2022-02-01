package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.g.a;
import com.tencent.mm.plugin.finder.feed.model.aa;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderTimelineFeedFetcher$innerFetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FetchFinderTimelineInfo;", "pullType", "", "plugin-finder_release"})
public final class b$h
  implements g.a
{
  b$h(g.a parama) {}
  
  public final void a(c paramc, int paramInt)
  {
    AppMethodBeat.i(197361);
    k.h(paramc, "info");
    Object localObject = this.KKp;
    boolean bool1;
    label48:
    boolean bool2;
    StringBuilder localStringBuilder;
    if (paramc.qyr > 0)
    {
      bool1 = true;
      b.a((b)localObject, bool1);
      localObject = this.KKp;
      if (paramc.qyr != 1) {
        break label544;
      }
      bool1 = true;
      ((b)localObject).KJW = bool1;
      bool1 = paramc.qyu;
      bool2 = paramc.isNeedClear;
      ad.i("Finder.TimelineFeedFetcher", "[getStream] tabType=" + this.KKp.IoU + " isGetHistory=" + b.b(this.KKp) + " isShowHistoryTip=" + this.KKp.KJW + " ret_flag=" + paramc.qyr + ' ' + "pullType=" + paramInt + " isNeedClear=" + bool2 + " isFetchHistoryNow=" + paramc.qyu + " size=" + paramc.incrementList.size() + "size=" + paramc.incrementList.size() + " errorType=" + paramc.errType + " errorCode=" + paramc.errCode + " h:" + String.valueOf(this.KKp.hashCode()));
      b.c(paramc.isNeedClear, paramc.incrementList.size(), paramc.qyr, paramInt);
      if (this.KKp.KKm == null) {
        this.KKp.KKm = new aa();
      }
      localObject = this.KKp.KKm;
      if (localObject == null) {
        k.fvU();
      }
      ((aa)localObject).KQm = paramc.KPH;
      localStringBuilder = new StringBuilder("recommendTopic size = ");
      localObject = paramc.KPH;
      if (localObject == null) {
        break label549;
      }
      localObject = ((dzx)localObject).Lxq;
      if (localObject == null) {
        break label549;
      }
    }
    label544:
    label549:
    for (localObject = Integer.valueOf(((LinkedList)localObject).size());; localObject = null)
    {
      ad.d("Finder.TimelineFeedFetcher", localObject);
      localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
      if ((com.tencent.mm.plugin.finder.storage.b.fUt() == 2) || (paramc.errType != 0) || (paramc.errCode != 0) || (!b.b(this.KKp)) || (!bool1)) {
        break label555;
      }
      this.KKp.KJV = true;
      b.a(this.KKp, this.KKj, this.KKp.KJV, paramInt, paramc.qyo, bool2, this.KKp.KJW);
      ad.i("Finder.TimelineFeedFetcher", "get history to fill... tabType=" + this.KKp.IoU + " pullType=" + paramInt + " isHistoryFirstPage=" + this.KKp.KJV + " h:" + String.valueOf(this.KKp.hashCode()));
      this.KKp.KJV = false;
      AppMethodBeat.o(197361);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label48;
    }
    label555:
    if ((paramc.errType == 0) && (paramc.errCode == 0))
    {
      e.vIY.idkeyStat(1279L, 1L, 1L, false);
      if ((paramc.incrementList.isEmpty()) && (!b.b(this.KKp)))
      {
        paramc.qys = 1;
        b.aVh("[finderstream]tabType=" + this.KKp.IoU + " server error[list=0:ret_flag=0] h:" + String.valueOf(this.KKp.hashCode()));
        ad.i("Finder.TimelineFeedFetcher", "tabType=" + this.KKp.IoU + " this time get finderstream return list=" + paramc.incrementList.size() + " continue_flag=" + paramc.qys + " pullType=" + paramInt + " h:" + String.valueOf(this.KKp.hashCode()));
      }
    }
    for (;;)
    {
      this.KKj.a(paramc, paramInt);
      AppMethodBeat.o(197361);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.b.h
 * JD-Core Version:    0.7.0.1
 */