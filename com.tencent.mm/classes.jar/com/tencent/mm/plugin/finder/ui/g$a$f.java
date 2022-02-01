package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/ShareRelPresenter$buildItemCoverts$1$getItemConvert$6", "Lcom/tencent/mm/plugin/finder/convert/FinderMoreSimilarTopicConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
public final class g$a$f
  extends ai
{
  public final void a(e parame, com.tencent.mm.plugin.finder.model.b paramb, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(204906);
    p.h(parame, "holder");
    p.h(paramb, "item");
    super.a(parame, paramb, paramInt1, paramInt2, paramBoolean, paramList);
    paramb = this.sTI.sTH.sTG;
    if (paramb != null)
    {
      parame = parame.auu;
      p.g(parame, "holder.itemView");
      paramb.invoke(parame);
      AppMethodBeat.o(204906);
      return;
    }
    AppMethodBeat.o(204906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g.a.f
 * JD-Core Version:    0.7.0.1
 */