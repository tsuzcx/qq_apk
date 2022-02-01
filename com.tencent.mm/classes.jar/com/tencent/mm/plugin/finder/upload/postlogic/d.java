package com.tencent.mm.plugin.finder.upload.postlogic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.upload.postlogic.base.g;
import com.tencent.mm.plugin.finder.upload.postlogic.commonstage.a;
import com.tencent.mm.plugin.finder.upload.postlogic.draftstage.f;
import com.tencent.mm.plugin.finder.upload.postlogic.mvstage.c;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderPostPipeline;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/PipelineCore;", "()V", "TAG", "", "arranger", "", "", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Executor;", "getArranger", "()Ljava/util/Map;", "defaultExecutor", "getDefaultExecutor", "()Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Executor;", "resultExecutor", "getResultExecutor", "taskMonitor", "Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderStageMonitor;", "getTaskMonitor", "()Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderStageMonitor;", "checkNextPost", "", "finalStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "genBeginStage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/TaskStage;", "data", "", "getExecutor", "stage", "getStageMonitor", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageMonitor;", "onTaskFinish", "taskId", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.finder.upload.postlogic.base.d
{
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.b GdJ;
  private final com.tencent.mm.plugin.finder.upload.postlogic.base.b GdK;
  private final Map<Integer, com.tencent.mm.plugin.finder.upload.postlogic.base.b> GdL;
  private final e GdM;
  private final String TAG;
  
  public d()
  {
    AppMethodBeat.i(342973);
    this.TAG = "PostLog.FinderPipeline";
    this.GdJ = new com.tencent.mm.plugin.finder.upload.postlogic.base.b("FinderPlDefault");
    this.GdK = new com.tencent.mm.plugin.finder.upload.postlogic.base.b("FinderPlResult");
    Map localMap = (Map)new LinkedHashMap();
    localMap.put(Integer.valueOf(1), new com.tencent.mm.plugin.finder.upload.postlogic.base.b("FinderMediaProcessStage"));
    localMap.put(Integer.valueOf(2), new com.tencent.mm.plugin.finder.upload.postlogic.base.b("FinderMediaProcessStage"));
    localMap.put(Integer.valueOf(3), new com.tencent.mm.plugin.finder.upload.postlogic.base.b("FinderUploadStage"));
    localMap.put(Integer.valueOf(4), new com.tencent.mm.plugin.finder.upload.postlogic.base.b("FinderPostCgiStage"));
    localMap.put(Integer.valueOf(100), this.GdK);
    ah localah = ah.aiuX;
    this.GdL = localMap;
    this.GdM = new e();
    AppMethodBeat.o(342973);
  }
  
  private static com.tencent.mm.plugin.finder.upload.postlogic.base.j fD(Object paramObject)
  {
    AppMethodBeat.i(342980);
    if ((paramObject instanceof FinderItem))
    {
      if (((FinderItem)paramObject).isMvFeed())
      {
        paramObject = (com.tencent.mm.plugin.finder.upload.postlogic.base.j)new c((FinderItem)paramObject);
        AppMethodBeat.o(342980);
        return paramObject;
      }
      paramObject = (com.tencent.mm.plugin.finder.upload.postlogic.base.j)new com.tencent.mm.plugin.finder.upload.postlogic.finderstage.d((FinderItem)paramObject);
      AppMethodBeat.o(342980);
      return paramObject;
    }
    if ((paramObject instanceof i))
    {
      com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eQC().bmg()).intValue() == 0)
      {
        AppMethodBeat.o(342980);
        return null;
      }
      if (((i)paramObject).isMvFeed())
      {
        paramObject = (com.tencent.mm.plugin.finder.upload.postlogic.base.j)new com.tencent.mm.plugin.finder.upload.postlogic.draftstage.j((i)paramObject);
        AppMethodBeat.o(342980);
        return paramObject;
      }
      paramObject = (com.tencent.mm.plugin.finder.upload.postlogic.base.j)new f((i)paramObject);
      AppMethodBeat.o(342980);
      return paramObject;
    }
    AppMethodBeat.o(342980);
    return null;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(342996);
    s.u(paramString, "taskId");
    s.u(parame, "finalStage");
    super.a(paramString, parame);
    c(parame);
    AppMethodBeat.o(342996);
  }
  
  public final com.tencent.mm.plugin.finder.upload.postlogic.base.b b(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    AppMethodBeat.i(342986);
    s.u(parame, "stage");
    parame = (com.tencent.mm.plugin.finder.upload.postlogic.base.b)this.GdL.get(Integer.valueOf(parame.fer()));
    if (parame == null)
    {
      parame = this.GdJ;
      AppMethodBeat.o(342986);
      return parame;
    }
    AppMethodBeat.o(342986);
    return parame;
  }
  
  public final void c(com.tencent.mm.plugin.finder.upload.postlogic.base.e parame)
  {
    String str1 = null;
    AppMethodBeat.i(343004);
    Object localObject1 = ((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().eZh();
    if (localObject1 != null)
    {
      str1 = this.TAG;
      localObject2 = new StringBuilder("checking post-waiting finder feed from db, next will post: ").append(((FinderItem)localObject1).getLocalId()).append(' ').append(((FinderItem)localObject1).getCreateTime()).append(' ');
      parame = ((FinderItem)localObject1).getPostInfo();
      if (parame == null) {}
      for (parame = null;; parame = Integer.valueOf(parame.nrQ))
      {
        Log.i(str1, parame);
        parame = fD(localObject1);
        if (parame == null) {
          break;
        }
        a(parame);
        AppMethodBeat.o(343004);
        return;
      }
    }
    Object localObject2 = ((PluginFinder)h.az(PluginFinder.class)).getDraftStorage().fan();
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("checking post-waiting finder draft from db, next will post: ");
    if (localObject2 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(' ');
      if (localObject2 != null) {
        break label234;
      }
    }
    label234:
    for (localObject1 = str1;; localObject1 = Integer.valueOf(((i)localObject2).field_createTime))
    {
      Log.i(str2, localObject1);
      if (localObject2 == null) {
        break label246;
      }
      localObject1 = fD(localObject2);
      if (localObject1 == null) {
        break label246;
      }
      a((com.tencent.mm.plugin.finder.upload.postlogic.base.j)localObject1);
      AppMethodBeat.o(343004);
      return;
      localObject1 = Long.valueOf(((i)localObject2).field_localId);
      break;
    }
    label246:
    if (parame != null)
    {
      parame = parame.feq();
      localObject1 = a.GdX;
      if (!s.p(parame, a.fet())) {
        a((com.tencent.mm.plugin.finder.upload.postlogic.base.j)new a());
      }
    }
    AppMethodBeat.o(343004);
  }
  
  public final g fem()
  {
    return (g)this.GdM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.d
 * JD-Core Version:    0.7.0.1
 */