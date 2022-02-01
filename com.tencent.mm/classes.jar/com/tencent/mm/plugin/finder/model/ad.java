package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedSearchHotScrollTipsData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "wording", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;)V", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class ad
  implements bu
{
  public String wording;
  
  public ad(FinderItem paramFinderItem, String paramString)
  {
    AppMethodBeat.i(281608);
    this.wording = paramString;
    AppMethodBeat.o(281608);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(281606);
    p.k(paramk, "obj");
    AppMethodBeat.o(281606);
    return -1;
  }
  
  public final void aDu(String paramString)
  {
    AppMethodBeat.i(281607);
    p.k(paramString, "<set-?>");
    this.wording = paramString;
    AppMethodBeat.o(281607);
  }
  
  public final int bAQ()
  {
    return -11;
  }
  
  public final long mf()
  {
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.ad
 * JD-Core Version:    0.7.0.1
 */