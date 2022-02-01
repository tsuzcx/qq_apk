package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.storage.u;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "finderMention", "getFinderMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "showBeforeSplitView", "", "getShowBeforeSplitView", "()Z", "setShowBeforeSplitView", "(Z)V", "getItemId", "", "plugin-finder_release"})
public abstract class a
  implements h, com.tencent.mm.view.recyclerview.a
{
  public final u ruv;
  public boolean ruw;
  
  public a(u paramu)
  {
    this.ruv = paramu;
  }
  
  public final long lx()
  {
    return this.ruv.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.a
 * JD-Core Version:    0.7.0.1
 */