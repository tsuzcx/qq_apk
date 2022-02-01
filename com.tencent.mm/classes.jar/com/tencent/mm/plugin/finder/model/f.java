package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class f
  extends d.b
  implements h
{
  public int count;
  public String ruB = "";
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(166372);
    k.h(paramh, "obj");
    AppMethodBeat.o(166372);
    return 0;
  }
  
  public final int bTF()
  {
    return -2;
  }
  
  public final long lx()
  {
    return 256L;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(166371);
    k.h(paramString, "<set-?>");
    this.ruB = paramString;
    AppMethodBeat.o(166371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.f
 * JD-Core Version:    0.7.0.1
 */