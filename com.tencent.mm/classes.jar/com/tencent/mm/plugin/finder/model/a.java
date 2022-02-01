package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.storage.av;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "finderMention", "getFinderMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "showBeforeSplitView", "", "getShowBeforeSplitView", "()Z", "setShowBeforeSplitView", "(Z)V", "getItemId", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements k, com.tencent.mm.view.recyclerview.a
{
  public final av ECa;
  public boolean ECb;
  
  public a(av paramav)
  {
    this.ECa = paramav;
  }
  
  public final long bZA()
  {
    return this.ECa.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.a
 * JD-Core Version:    0.7.0.1
 */