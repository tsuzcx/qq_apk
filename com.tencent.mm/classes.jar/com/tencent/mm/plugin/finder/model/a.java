package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ac;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "finderMention", "getFinderMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "showBeforeSplitView", "", "getShowBeforeSplitView", "()Z", "setShowBeforeSplitView", "(Z)V", "getItemId", "", "plugin-finder_release"})
public abstract class a
  implements i, com.tencent.mm.view.recyclerview.a
{
  public final ac ssK;
  public boolean ssL;
  
  public a(ac paramac)
  {
    this.ssK = paramac;
  }
  
  public final long lP()
  {
    return this.ssK.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.a
 * JD-Core Version:    0.7.0.1
 */