package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.view.recyclerview.d.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "getTabType", "()I", "setTabType", "(I)V", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class e
  extends d.b
  implements h
{
  public int diw;
  public CharSequence ruA;
  public int type;
  
  private e(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(166369);
    this.ruA = paramCharSequence;
    this.type = 0;
    this.diw = 0;
    AppMethodBeat.o(166369);
  }
  
  public final void M(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(202550);
    k.h(paramCharSequence, "<set-?>");
    this.ruA = paramCharSequence;
    AppMethodBeat.o(202550);
  }
  
  public final int a(h paramh)
  {
    AppMethodBeat.i(166367);
    k.h(paramh, "obj");
    AppMethodBeat.o(166367);
    return 0;
  }
  
  public final int bTF()
  {
    return -1;
  }
  
  public final long lx()
  {
    AppMethodBeat.i(210187);
    long l = hashCode();
    AppMethodBeat.o(210187);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.e
 * JD-Core Version:    0.7.0.1
 */