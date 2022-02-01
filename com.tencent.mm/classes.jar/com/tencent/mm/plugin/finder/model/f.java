package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "getTabType", "()I", "setTabType", "(I)V", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class f
  extends d.b
  implements i
{
  public int duh;
  public CharSequence sjT;
  public int type;
  
  private f(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(166369);
    this.sjT = paramCharSequence;
    this.type = 0;
    this.duh = 0;
    AppMethodBeat.o(166369);
  }
  
  public final void M(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(202944);
    p.h(paramCharSequence, "<set-?>");
    this.sjT = paramCharSequence;
    AppMethodBeat.o(202944);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166367);
    p.h(parami, "obj");
    AppMethodBeat.o(166367);
    return 0;
  }
  
  public final int bYk()
  {
    return -1;
  }
  
  public final long lP()
  {
    AppMethodBeat.i(221471);
    long l = hashCode();
    AppMethodBeat.o(221471);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.f
 * JD-Core Version:    0.7.0.1
 */