package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/model/FinderFeedTip;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "tip", "", "getTip", "()Ljava/lang/CharSequence;", "setTip", "(Ljava/lang/CharSequence;)V", "plugin-finder_release"})
public final class m
  extends BaseFinderFeed
{
  private CharSequence qDE;
  
  public m(FinderItem paramFinderItem)
  {
    super(paramFinderItem);
    AppMethodBeat.i(166388);
    this.qDE = ((CharSequence)paramFinderItem.getDescription());
    AppMethodBeat.o(166388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.m
 * JD-Core Version:    0.7.0.1
 */