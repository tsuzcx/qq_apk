package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.blx;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/RelatedLivingOfLiveFeed;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "relateLiving", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "relatedExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedExtInfo;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/util/List;Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedExtInfo;)V", "getRelateLiving", "()Ljava/util/List;", "getRelatedExtInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveRelatedExtInfo;", "getItemType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bk
  extends x
{
  public final List<FinderObject> BbK;
  public final blx BbL;
  
  public bk(FinderItem paramFinderItem, List<? extends FinderObject> paramList, blx paramblx)
  {
    super(paramFinderItem);
    AppMethodBeat.i(362761);
    this.BbK = paramList;
    this.BbL = paramblx;
    AppMethodBeat.o(362761);
  }
  
  public final int bZB()
  {
    return 2021;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bk
 * JD-Core Version:    0.7.0.1
 */