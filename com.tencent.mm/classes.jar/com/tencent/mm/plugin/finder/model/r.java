package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/FinderFeedTip;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "tip", "", "getTip", "()Ljava/lang/CharSequence;", "setTip", "(Ljava/lang/CharSequence;)V", "plugin-finder_release"})
public final class r
  extends BaseFinderFeed
{
  private CharSequence ruT;
  
  public r(FinderItem paramFinderItem)
  {
    super(paramFinderItem);
    AppMethodBeat.i(166388);
    this.ruT = ((CharSequence)paramFinderItem.getDescription());
    AppMethodBeat.o(166388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.r
 * JD-Core Version:    0.7.0.1
 */