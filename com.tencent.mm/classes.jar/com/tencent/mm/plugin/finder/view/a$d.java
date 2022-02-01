package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.ui.base.n.c;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/CommentMenu$BottomSheetMenuListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "commentItem", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "feedUsername", "", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;Ljava/lang/String;)V", "getFeedUsername", "()Ljava/lang/String;", "onCreateMMMenu", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
public final class a$d
  implements n.c
{
  private h qVi;
  private final String qVj;
  
  public a$d(h paramh, String paramString)
  {
    AppMethodBeat.i(200018);
    this.qVi = paramh;
    this.qVj = paramString;
    AppMethodBeat.o(200018);
  }
  
  public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(200017);
    d.g.b.k.h(paraml, "menu");
    Object localObject = i.qTa;
    if (i.ZR(this.qVj))
    {
      paraml.jj(a.csB(), 2131755701);
      if (((d.g.b.k.g(this.qVi.qDA.getUsername(), u.aqO()) ^ true)) && ((d.g.b.k.g(this.qVi.qDA.getUsername(), u.aqG()) ^ true))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          paraml.jj(a.csC(), 2131755735);
        }
        paraml.jj(a.csD(), 2131755707);
        if (i == 0) {
          break label175;
        }
        localObject = i.qTa;
        if (!i.ZR(this.qVj)) {
          break label175;
        }
        if (!this.qVi.qDA.cqB()) {
          break;
        }
        localObject = b.qJA;
        if (!b.cqc()) {
          break label175;
        }
        paraml.jj(a.csE(), 2131759146);
        AppMethodBeat.o(200017);
        return;
      }
      paraml.jj(a.csE(), 2131759146);
    }
    label175:
    AppMethodBeat.o(200017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a.d
 * JD-Core Version:    0.7.0.1
 */