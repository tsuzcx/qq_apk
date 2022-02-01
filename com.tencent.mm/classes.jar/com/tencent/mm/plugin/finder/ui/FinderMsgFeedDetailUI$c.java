package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.d.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class FinderMsgFeedDetailUI$c
  implements Runnable
{
  FinderMsgFeedDetailUI$c(FinderMsgFeedDetailUI paramFinderMsgFeedDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(199275);
    BaseFinderFeed localBaseFinderFeed = this.qNX.qHv;
    if (localBaseFinderFeed != null)
    {
      FinderMsgFeedDetailUI.b(this.qNX).fSZ().p(localBaseFinderFeed.feedObject);
      AppMethodBeat.o(199275);
      return;
    }
    AppMethodBeat.o(199275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI.c
 * JD-Core Version:    0.7.0.1
 */