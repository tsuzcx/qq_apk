package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.view.recyclerview.h.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class h
  extends h.b
  implements k
{
  public String avatar = "";
  public int count;
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(166372);
    p.k(paramk, "obj");
    AppMethodBeat.o(166372);
    return 0;
  }
  
  public final int bAQ()
  {
    return -5;
  }
  
  public final long mf()
  {
    return 512L;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(166371);
    p.k(paramString, "<set-?>");
    this.avatar = paramString;
    AppMethodBeat.o(166371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.h
 * JD-Core Version:    0.7.0.1
 */