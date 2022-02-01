package com.tencent.mm.plugin.finder.upload.postlogic.mvstage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/mvstage/MvPostPrepareStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "TAG", "", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getStageType", "", "onFailed", "", "nextStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "onSuccess", "onWait", "postMvFeed", "postInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.upload.postlogic.f
{
  public final FinderItem Ged;
  private final String TAG;
  
  public c(FinderItem paramFinderItem)
  {
    super(String.valueOf(paramFinderItem.getLocalId()));
    AppMethodBeat.i(343225);
    this.Ged = paramFinderItem;
    this.TAG = "LogPost.MvPostPrepareStage";
    AppMethodBeat.o(343225);
  }
  
  public final void d(e parame)
  {
    AppMethodBeat.i(343243);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343243);
  }
  
  public final void e(e parame)
  {
    AppMethodBeat.i(343249);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343249);
  }
  
  public final void f(e parame)
  {
    AppMethodBeat.i(343255);
    s.u(parame, "nextStage");
    AppMethodBeat.o(343255);
  }
  
  public final e feo()
  {
    AppMethodBeat.i(343236);
    Object localObject1 = this.Ged.getPostInfo();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if ((((Boolean)com.tencent.mm.plugin.finder.storage.d.eSL().bmg()).booleanValue()) && (Log.getLogLevel() >= 0))
    {
      Log.i(this.TAG, "debug failed");
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      com.tencent.mm.plugin.finder.storage.d.eSL().reset();
      localObject1 = (e)new com.tencent.mm.plugin.finder.upload.postlogic.finderstage.a(this.Ged, "failed for debug");
      AppMethodBeat.o(343236);
      return localObject1;
    }
    localObject2 = com.tencent.mm.plugin.finder.upload.postlogic.c.GdI;
    if (com.tencent.mm.plugin.finder.upload.postlogic.c.a((djj)localObject1))
    {
      localObject1 = (e)new com.tencent.mm.plugin.finder.upload.postlogic.finderstage.a(this.Ged, "try to post this feed too many times!");
      AppMethodBeat.o(343236);
      return localObject1;
    }
    localObject2 = ah.d.Ftw;
    ah.d.tD(this.Ged.isLongVideo());
    localObject2 = com.tencent.mm.plugin.finder.upload.postlogic.c.GdI;
    com.tencent.mm.plugin.finder.upload.postlogic.c.z(this.Ged);
    localObject2 = com.tencent.mm.plugin.finder.upload.postlogic.b.GdH;
    com.tencent.mm.plugin.finder.upload.postlogic.b.w(this.Ged);
    if (((djj)localObject1).aaPu == 1)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      if (d.a.pX(this.Ged.getLocalId()))
      {
        localObject1 = (e)new b(this.Ged);
        AppMethodBeat.o(343236);
        return localObject1;
      }
      Log.i(this.TAG, "post before doscene2 cancel because feed is deleted");
      localObject1 = this.Ged;
      localObject2 = f.Gfh;
      localObject1 = (e)new f((FinderItem)localObject1, f.feu());
      AppMethodBeat.o(343236);
      return localObject1;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
    if (!d.a.pX(this.Ged.getLocalId()))
    {
      Log.i(this.TAG, "post before mediaprocess cancel because feed is deleted");
      localObject1 = this.Ged;
      localObject2 = f.Gfh;
      localObject1 = (e)new f((FinderItem)localObject1, f.feu());
      AppMethodBeat.o(343236);
      return localObject1;
    }
    localObject1 = (e)new a(this.Ged);
    AppMethodBeat.o(343236);
    return localObject1;
  }
  
  public final int fer()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.mvstage.c
 * JD-Core Version:    0.7.0.1
 */