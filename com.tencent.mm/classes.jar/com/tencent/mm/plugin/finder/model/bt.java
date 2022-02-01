package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bqj;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderQQMusicInfoData;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "qqMusicItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "qqMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getQqMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getQqMusicItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bt
  extends BaseFinderFeed
{
  public final bqj EDA;
  public final FinderItem EDz;
  
  public bt(FinderItem paramFinderItem)
  {
    super(paramFinderItem);
    AppMethodBeat.i(331900);
    this.EDz = paramFinderItem;
    paramFinderItem = this.EDz.getFinderObject().objectDesc;
    if (paramFinderItem == null) {}
    for (paramFinderItem = null;; paramFinderItem = paramFinderItem.musicInfo)
    {
      this.EDA = paramFinderItem;
      AppMethodBeat.o(331900);
      return;
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331922);
    s.u(paramk, "obj");
    if ((paramk instanceof bt)) {
      paramk = (bt)paramk;
    }
    while (paramk != null) {
      if ((paramk.EDz.getFeedObject().id != 0L) && (this.EDz.getFeedObject().id != 0L) && (paramk.EDz.getFeedObject().id == this.EDz.getFeedObject().id))
      {
        AppMethodBeat.o(331922);
        return 0;
        paramk = null;
      }
      else
      {
        if (this.EDz.getCreateTime() > paramk.EDz.getCreateTime())
        {
          AppMethodBeat.o(331922);
          return 1;
        }
        AppMethodBeat.o(331922);
        return -1;
      }
    }
    AppMethodBeat.o(331922);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331908);
    long l = this.EDz.getId();
    AppMethodBeat.o(331908);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331916);
    int i = bt.class.getName().hashCode();
    AppMethodBeat.o(331916);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.bt
 * JD-Core Version:    0.7.0.1
 */