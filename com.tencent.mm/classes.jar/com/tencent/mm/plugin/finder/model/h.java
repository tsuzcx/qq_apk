package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class h
  extends g.b
  implements i
{
  public int count;
  public String uNR = "";
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166372);
    p.h(parami, "obj");
    AppMethodBeat.o(166372);
    return 0;
  }
  
  public final int cxn()
  {
    return -5;
  }
  
  public final long lT()
  {
    return 512L;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(166371);
    p.h(paramString, "<set-?>");
    this.uNR = paramString;
    AppMethodBeat.o(166371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.h
 * JD-Core Version:    0.7.0.1
 */