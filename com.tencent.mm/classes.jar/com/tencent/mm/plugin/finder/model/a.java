package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ac;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "finderMention", "getFinderMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "showBeforeSplitView", "", "getShowBeforeSplitView", "()Z", "setShowBeforeSplitView", "(Z)V", "getItemId", "", "plugin-finder_release"})
public abstract class a
  implements i, com.tencent.mm.view.recyclerview.a
{
  public final ac sjN;
  public boolean sjO;
  
  public a(ac paramac)
  {
    this.sjN = paramac;
  }
  
  public final long lP()
  {
    return this.sjN.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.a
 * JD-Core Version:    0.7.0.1
 */