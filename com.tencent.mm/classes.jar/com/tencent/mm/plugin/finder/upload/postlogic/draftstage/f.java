package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.j;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/FinderDraftPrepareStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "setDraftItem", "getStageType", "", "onFailed", "", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "postFinderFeed", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  private i ABX;
  private final String TAG;
  
  public f(i parami)
  {
    super(j.e(parami));
    AppMethodBeat.i(343071);
    this.ABX = parami;
    this.TAG = "LogPost.FinderDraftPrepareStage";
    AppMethodBeat.o(343071);
  }
  
  public final void d(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343085);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343085);
  }
  
  public final void e(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343091);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343091);
  }
  
  public final void f(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(343099);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343099);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.e feo()
  {
    AppMethodBeat.i(343079);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.FNC;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.faq().qm(this.ABX.field_localId);
    if (localObject1 == null)
    {
      Log.i(this.TAG, s.X("draftItem is deleted, ", this.ABX.eYN()));
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((i)localObject1, c.feu());
      AppMethodBeat.o(343079);
      return localObject1;
    }
    Log.i(this.TAG, s.X("refresh draftItem, ", this.ABX.eYN()));
    this.ABX = ((i)localObject1);
    localObject1 = this.ABX.eYK().getPostInfo();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Boolean)com.tencent.mm.plugin.finder.storage.d.eSL().bmg()).booleanValue()) && (Log.getLogLevel() >= 0))
    {
      Log.i(this.TAG, "debug failed");
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.eSL().reset();
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new a(this.ABX, "failed for debug");
      AppMethodBeat.o(343079);
      return localObject1;
    }
    localObject2 = com.tencent.mm.plugin.finder.upload.postlogic.c.GdI;
    if (com.tencent.mm.plugin.finder.upload.postlogic.c.b((djj)localObject1))
    {
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new a(this.ABX, "try to post this feed too many times!");
      AppMethodBeat.o(343079);
      return localObject1;
    }
    localObject1 = i.c.FoQ;
    i.c.tD(this.ABX.eYK().isLongVideo());
    localObject1 = com.tencent.mm.plugin.finder.upload.postlogic.c.GdI;
    com.tencent.mm.plugin.finder.upload.postlogic.c.j(this.ABX);
    Log.i(this.TAG, s.X("try post need upload task ", Long.valueOf(this.ABX.field_localId)));
    if (this.ABX.eYK().getFinderObject().objectDesc != null)
    {
      localObject1 = com.tencent.mm.plugin.finder.upload.postlogic.b.GdH;
      com.tencent.mm.plugin.finder.upload.postlogic.b.i(this.ABX);
      localObject1 = j.FKc;
      if (!j.pX(this.ABX.field_localId))
      {
        Log.i(this.TAG, "post before mediaprocess cancel because feed is deleted");
        localObject1 = this.ABX;
        localObject2 = c.GdZ;
        localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new c((i)localObject1, c.feu());
        AppMethodBeat.o(343079);
        return localObject1;
      }
      localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new d(this.ABX);
      AppMethodBeat.o(343079);
      return localObject1;
    }
    localObject1 = (com.tencent.mm.plugin.finder.upload.postlogic.base.e)new e(this.ABX);
    AppMethodBeat.o(343079);
    return localObject1;
  }
  
  public final int fer()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.f
 * JD-Core Version:    0.7.0.1
 */