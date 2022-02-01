package com.tencent.mm.plugin.finder.feed.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.csg;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderFeedTransformLogic;", "", "()V", "TAG", "", "checkTransformLongVideoToNormalVideoMedia", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder-base_release"})
public final class b
{
  public static final b xFr;
  
  static
  {
    AppMethodBeat.i(263321);
    xFr = new b();
    AppMethodBeat.o(263321);
  }
  
  public static LinkedList<csg> c(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(263318);
    p.k(paramFinderItem, "finderItem");
    if ((paramFinderItem.isReplaceLongVideoToNormal()) && (paramFinderItem.getMediaType() == 4) && (paramFinderItem.isLongVideo()))
    {
      paramFinderItem = paramFinderItem.getLongVideoMediaList();
      AppMethodBeat.o(263318);
      return paramFinderItem;
    }
    paramFinderItem = paramFinderItem.getMediaList();
    AppMethodBeat.o(263318);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.b
 * JD-Core Version:    0.7.0.1
 */