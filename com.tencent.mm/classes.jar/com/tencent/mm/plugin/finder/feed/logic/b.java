package com.tencent.mm.plugin.finder.feed.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/logic/FinderFeedTransformLogic;", "", "()V", "TAG", "", "checkTransformLongVideoToNormalVideoMedia", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class b
{
  public static final b tUw;
  
  static
  {
    AppMethodBeat.i(244538);
    tUw = new b();
    AppMethodBeat.o(244538);
  }
  
  public static LinkedList<cjl> b(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(244537);
    p.h(paramFinderItem, "finderItem");
    if ((paramFinderItem.isReplaceLongVideoToNormal()) && (paramFinderItem.getMediaType() == 4) && (paramFinderItem.isLongVideo()))
    {
      paramFinderItem = paramFinderItem.getLongVideoMediaList();
      AppMethodBeat.o(244537);
      return paramFinderItem;
    }
    paramFinderItem = paramFinderItem.getMediaList();
    AppMethodBeat.o(244537);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.logic.b
 * JD-Core Version:    0.7.0.1
 */