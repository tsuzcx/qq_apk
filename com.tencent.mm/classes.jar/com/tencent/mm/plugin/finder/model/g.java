package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class g
  extends d.b
  implements i
{
  public int count;
  public String ssR = "";
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166372);
    p.h(parami, "obj");
    AppMethodBeat.o(166372);
    return 0;
  }
  
  public final int bZz()
  {
    return -5;
  }
  
  public final long lP()
  {
    return 512L;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(166371);
    p.h(paramString, "<set-?>");
    this.ssR = paramString;
    AppMethodBeat.o(166371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.g
 * JD-Core Version:    0.7.0.1
 */