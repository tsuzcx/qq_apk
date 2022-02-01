package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/DraftSuccessStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/SuccStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "exec", "", "getStageType", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.upload.postlogic.base.i
{
  private final com.tencent.mm.plugin.finder.storage.i ABX;
  private final String TAG;
  
  public b(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343074);
    this.ABX = parami;
    this.TAG = "Finder.FinderDraftSuccessStage";
    AppMethodBeat.o(343074);
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(343080);
    Log.i(this.TAG, s.X("succ, localId:", Long.valueOf(this.ABX.field_localId)));
    AppMethodBeat.o(343080);
  }
  
  public final int fer()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.b
 * JD-Core Version:    0.7.0.1
 */