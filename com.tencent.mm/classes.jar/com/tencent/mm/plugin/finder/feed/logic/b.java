package com.tencent.mm.plugin.finder.feed.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderFeedTransformLogic;", "", "()V", "TAG", "", "checkTransformLongVideoToNormalVideoMedia", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Beo;
  
  static
  {
    AppMethodBeat.i(363726);
    Beo = new b();
    AppMethodBeat.o(363726);
  }
  
  public static LinkedList<dji> d(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(363722);
    s.u(paramFinderItem, "finderItem");
    if ((paramFinderItem.isReplaceLongVideoToNormal()) && (paramFinderItem.getMediaType() == 4) && (paramFinderItem.isLongVideo()))
    {
      paramFinderItem = paramFinderItem.getLongVideoMediaList();
      AppMethodBeat.o(363722);
      return paramFinderItem;
    }
    paramFinderItem = paramFinderItem.getMediaList();
    AppMethodBeat.o(363722);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.b
 * JD-Core Version:    0.7.0.1
 */