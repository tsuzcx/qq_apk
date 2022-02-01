package com.tencent.mm.plugin.finder.upload.postlogic.mvstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.postlogic.base.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/mvstage/MvSuccessStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/SuccStage;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "exec", "", "getStageType", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends i
{
  private final FinderItem Ged;
  
  public d(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343223);
    this.Ged = paramFinderItem;
    AppMethodBeat.o(343223);
  }
  
  public final void cpv() {}
  
  public final int fer()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.mvstage.d
 * JD-Core Version:    0.7.0.1
 */