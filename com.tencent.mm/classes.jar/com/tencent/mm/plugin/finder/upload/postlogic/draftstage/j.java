package com.tencent.mm.plugin.finder.upload.postlogic.draftstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.postlogic.b;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.plugin.finder.upload.postlogic.f;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/draftstage/MvDraftPrepareStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "draftItem", "Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;)V", "TAG", "", "getDraftItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderDraftItem;", "getStageType", "", "onFailed", "", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "postMvFeed", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends f
{
  private final com.tencent.mm.plugin.finder.storage.i ABX;
  private final String TAG;
  
  public j(com.tencent.mm.plugin.finder.storage.i parami)
  {
    super(com.tencent.mm.plugin.finder.storage.j.e(parami));
    AppMethodBeat.i(343029);
    this.ABX = parami;
    this.TAG = "LogPost.MvDraftPrepareStage";
    AppMethodBeat.o(343029);
  }
  
  public final void d(e parame)
  {
    AppMethodBeat.i(343037);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343037);
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(343046);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343046);
  }
  
  public final void f(e parame)
  {
    AppMethodBeat.i(343050);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343050);
  }
  
  public final e feo()
  {
    AppMethodBeat.i(343034);
    Object localObject1 = this.ABX.eYK().getPostInfo();
    Object localObject2 = d.FAy;
    if ((((Boolean)d.eSL().bmg()).booleanValue()) && (Log.getLogLevel() >= 0))
    {
      Log.i(this.TAG, "debug failed");
      localObject1 = d.FAy;
      d.eSL().reset();
      localObject1 = (e)new a(this.ABX, "failed for debug");
      AppMethodBeat.o(343034);
      return localObject1;
    }
    localObject2 = com.tencent.mm.plugin.finder.upload.postlogic.c.GdI;
    if (com.tencent.mm.plugin.finder.upload.postlogic.c.b((djj)localObject1))
    {
      localObject1 = (e)new a(this.ABX, "try to post this feed too many times!");
      AppMethodBeat.o(343034);
      return localObject1;
    }
    localObject1 = i.c.FoQ;
    i.c.tD(this.ABX.eYK().isLongVideo());
    localObject1 = com.tencent.mm.plugin.finder.upload.postlogic.c.GdI;
    com.tencent.mm.plugin.finder.upload.postlogic.c.j(this.ABX);
    localObject1 = b.GdH;
    b.i(this.ABX);
    localObject1 = com.tencent.mm.plugin.finder.storage.j.FKc;
    if (!com.tencent.mm.plugin.finder.storage.j.pX(this.ABX.field_localId))
    {
      Log.i(this.TAG, "post before mediaprocess cancel because feed is deleted");
      localObject1 = this.ABX;
      localObject2 = c.GdZ;
      localObject1 = (e)new c((com.tencent.mm.plugin.finder.storage.i)localObject1, c.feu());
      AppMethodBeat.o(343034);
      return localObject1;
    }
    localObject1 = (e)new i(this.ABX);
    AppMethodBeat.o(343034);
    return localObject1;
  }
  
  public final int fer()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.draftstage.j
 * JD-Core Version:    0.7.0.1
 */