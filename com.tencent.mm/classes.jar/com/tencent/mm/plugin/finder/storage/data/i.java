package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ake;
import d.g.a.b;
import d.g.b.v.a;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"})
public final class i
{
  private static boolean DEBUG = false;
  private static final int MAX_CACHE_SIZE = 20;
  private static final Integer[] rER;
  private static final Integer[] rES;
  private static final j rET;
  private static j rEU;
  public static final i.a rEV;
  
  static
  {
    AppMethodBeat.i(167083);
    rEV = new i.a((byte)0);
    MAX_CACHE_SIZE = 20;
    rER = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    rES = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    j localj = new j(new a[] { new a(0, "main_v2", new ajy(), 0), new a(1, "profile_v2", new ajy(), 0), new a(2, "like_v2", new ajy(), 0), new a(3, "others_v2", new ajy(), 0), new a(4, "prefetch_v2", new ajy(), 0), new a(5, "friend_tab_v2", new ajy(), 0), new a(6, "lbs_tab_v2", new ajy(), 0), new a(7, "follow_v2", new ajy(), 0), new a(8, "machine_v2", new ajy(), 0), new a(9, "lbs_tab_section_v2", new ajy(), 0), new a(10, "fav_v2", new ajy(), 0) });
    rET = localj;
    rEU = localj;
    AppMethodBeat.o(167083);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$cacheToFile$1$1"})
  static final class a$a
    extends d.g.b.l
    implements b<ake, Boolean>
  {
    a$a(String paramString, ake paramake, LinkedList paramLinkedList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$deletePageData$1$1"})
  public static final class a$b
    extends d.g.b.l
    implements b<ajr, Boolean>
  {
    public a$b(v.a parama, HashSet paramHashSet)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i
 * JD-Core Version:    0.7.0.1
 */