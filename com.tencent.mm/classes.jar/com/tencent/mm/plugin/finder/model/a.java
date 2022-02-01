package com.tencent.mm.plugin.finder.model;

import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ao;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "(Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;)V", "finderMention", "getFinderMention", "()Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "showBeforeSplitView", "", "getShowBeforeSplitView", "()Z", "setShowBeforeSplitView", "(Z)V", "getItemId", "", "plugin-finder_release"})
public abstract class a
  implements i, com.tencent.mm.view.recyclerview.a
{
  public final ao uNF;
  public boolean uNG;
  
  public a(ao paramao)
  {
    this.uNF = paramao;
  }
  
  public final long lT()
  {
    return this.uNF.field_id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.a
 * JD-Core Version:    0.7.0.1
 */