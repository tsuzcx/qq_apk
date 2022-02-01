package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderBlockSubTitleData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class m
  extends g.b
  implements i
{
  public String title;
  
  public m(String paramString)
  {
    AppMethodBeat.i(248721);
    this.title = paramString;
    AppMethodBeat.o(248721);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248719);
    p.h(parami, "obj");
    AppMethodBeat.o(248719);
    return 2147483647;
  }
  
  public final int cxn()
  {
    return -8;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(248720);
    long l = hashCode();
    AppMethodBeat.o(248720);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.m
 * JD-Core Version:    0.7.0.1
 */