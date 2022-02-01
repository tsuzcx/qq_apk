package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract;", "", "()V", "LbsStreamFeedPresenter", "LbsStreamFeedViewCallback", "plugin-finder_release"})
public final class o
{
  public static final o rhY;
  
  static
  {
    AppMethodBeat.i(201692);
    rhY = new o();
    AppMethodBeat.o(201692);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$loadInitData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a$b
    implements f
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201675);
      ac.i("LbsStreamFeedPresenter", "[loadInitData] incrementCount=".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(201675);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.o
 * JD-Core Version:    0.7.0.1
 */