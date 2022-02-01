package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.plugin.finder.upload.postlogic.base.k;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/DraftWaitStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/WaitStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "reason", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;I)V", "TAG", "", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getReason", "()I", "exec", "", "getStageType", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends k
{
  public static final c.a GdZ;
  private static final int Gea;
  private static final int Geb;
  private static final int Gec;
  private final i ABX;
  private final String TAG;
  private final int reason;
  
  static
  {
    AppMethodBeat.i(343088);
    GdZ = new c.a((byte)0);
    Gea = 1;
    Geb = 2;
    Gec = 3;
    AppMethodBeat.o(343088);
  }
  
  public c(i parami, int paramInt)
  {
    super(j.e(parami));
    AppMethodBeat.i(343070);
    this.ABX = parami;
    this.reason = paramInt;
    this.TAG = "Finder.FinderDraftWaitStage";
    AppMethodBeat.o(343070);
  }
  
  public final void cpv()
  {
    AppMethodBeat.i(343096);
    Log.i(this.TAG, "wait, reason:" + this.reason + ", localId:" + this.ABX.field_localId);
    AppMethodBeat.o(343096);
  }
  
  public final int fer()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.c
 * JD-Core Version:    0.7.0.1
 */