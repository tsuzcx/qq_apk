package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.ui.widget.MMEditText;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter$onAttach$6$1"})
final class b$r
  implements Runnable
{
  b$r(MMEditText paramMMEditText, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(197642);
    this.KNc.requestFocus();
    if (!this.quL.qqF)
    {
      Object localObject = this.quL.quv;
      if (localObject != null)
      {
        localObject = ((a)localObject).csW();
        if (localObject != null)
        {
          ((FinderCommentFooter)localObject).bV(true);
          AppMethodBeat.o(197642);
          return;
        }
      }
    }
    AppMethodBeat.o(197642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.r
 * JD-Core Version:    0.7.0.1
 */