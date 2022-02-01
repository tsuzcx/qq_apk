package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedSearchHotScrollTipsData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "wording", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;)V", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  implements cc
{
  public String wording;
  
  public af(FinderItem paramFinderItem, String paramString)
  {
    AppMethodBeat.i(332108);
    this.wording = paramString;
    AppMethodBeat.o(332108);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332131);
    s.u(paramk, "obj");
    AppMethodBeat.o(332131);
    return -1;
  }
  
  public final void ayQ(String paramString)
  {
    AppMethodBeat.i(332114);
    s.u(paramString, "<set-?>");
    this.wording = paramString;
    AppMethodBeat.o(332114);
  }
  
  public final long bZA()
  {
    return -1L;
  }
  
  public final int bZB()
  {
    return -11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.af
 * JD-Core Version:    0.7.0.1
 */