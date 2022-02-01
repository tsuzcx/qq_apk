package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class d
  extends d.b
  implements i
{
  public int count;
  public String qDs = "";
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166372);
    k.h(parami, "obj");
    AppMethodBeat.o(166372);
    return 0;
  }
  
  public final long bMs()
  {
    return 256L;
  }
  
  public final int bMt()
  {
    return -2;
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(166371);
    k.h(paramString, "<set-?>");
    this.qDs = paramString;
    AppMethodBeat.o(166371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.d
 * JD-Core Version:    0.7.0.1
 */