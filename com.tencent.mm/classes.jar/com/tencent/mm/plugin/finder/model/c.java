package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "getTabType", "()I", "setTabType", "(I)V", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class c
  extends d.b
  implements i
{
  public int IoU;
  public CharSequence qDr;
  public int type;
  
  private c(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(166369);
    this.qDr = paramCharSequence;
    this.type = 0;
    this.IoU = 0;
    AppMethodBeat.o(166369);
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(166367);
    k.h(parami, "obj");
    AppMethodBeat.o(166367);
    return 0;
  }
  
  public final void aK(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198623);
    k.h(paramCharSequence, "<set-?>");
    this.qDr = paramCharSequence;
    AppMethodBeat.o(198623);
  }
  
  public final long bMs()
  {
    AppMethodBeat.i(198622);
    long l = hashCode();
    AppMethodBeat.o(198622);
    return l;
  }
  
  public final int bMt()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.c
 * JD-Core Version:    0.7.0.1
 */