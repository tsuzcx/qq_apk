package com.tencent.mm.plugin.finder.upload.postlogic.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/base/PipelineCore;", "", "()V", "taskStages", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "Lkotlin/collections/HashMap;", "getTaskStages", "()Ljava/util/HashMap;", "getExecutor", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Executor;", "stage", "getStageMonitor", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageMonitor;", "onTaskFinish", "", "taskId", "finalStage", "onTaskTransfer", "from", "to", "start", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/TaskStage;", "stages", "", "PipelineTask", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  final HashMap<String, e> GdS = new HashMap();
  
  public final void a(j paramj)
  {
    s.u(paramj, "stage");
    synchronized (this.GdS)
    {
      boolean bool = this.GdS.containsKey(paramj.taskId);
      if (bool) {
        return;
      }
      Object localObject2 = ah.aiuX;
      ??? = b((e)paramj);
      ((Map)this.GdS).put(paramj.taskId, paramj);
      localObject2 = fem();
      if (localObject2 != null) {
        ((g)localObject2).b(paramj.taskId, (e)paramj);
      }
      ((b)???).a(new a((e)paramj));
      return;
    }
  }
  
  public void a(String paramString, e parame)
  {
    s.u(paramString, "taskId");
    s.u(parame, "finalStage");
  }
  
  public abstract b b(e parame);
  
  public g fem()
  {
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/base/PipelineCore$PipelineTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "stage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "(Lcom/tencent/mm/plugin/finder/upload/postlogic/base/PipelineCore;Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;)V", "getStage", "()Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "call", "", "dealNextStage", "current", "next", "uniqueId", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.loader.f.c
  {
    final e GdT;
    
    public a()
    {
      AppMethodBeat.i(343227);
      this.GdT = localObject;
      AppMethodBeat.o(343227);
    }
    
    public final String aUE()
    {
      AppMethodBeat.i(343251);
      String str = this.GdT.getClass().getSimpleName() + '_' + this.GdT.feq();
      AppMethodBeat.o(343251);
      return str;
    }
    
    public final void call()
    {
      AppMethodBeat.i(343242);
      e locale1;
      e locale2;
      Object localObject1;
      label64:
      Object localObject4;
      if ((this.GdT instanceof j))
      {
        locale1 = ((j)this.GdT).fen();
        locale2 = this.GdT;
        if ((locale1 instanceof j))
        {
          localObject1 = this.GdT;
          if ((localObject1 instanceof j))
          {
            localObject1 = (j)localObject1;
            if (localObject1 != null) {
              ((j)localObject1).d(locale1);
            }
            localObject1 = d.this.GdS;
            localObject4 = d.this;
          }
        }
      }
      for (;;)
      {
        try
        {
          ((Map)((d)localObject4).GdS).put(this.GdT.feq(), locale1);
          localObject4 = ah.aiuX;
          s.u(this.GdT.feq(), "taskId");
          s.u(locale2, "from");
          s.u(locale1, "to");
          localObject1 = d.this.fem();
          if (localObject1 != null) {
            ((g)localObject1).a(this.GdT.feq(), locale2, locale1);
          }
          d.this.b(locale1).a(new a(d.this, locale1));
        }
        finally
        {
          AppMethodBeat.o(343242);
        }
        a(com.tencent.mm.loader.f.i.nrG);
        AppMethodBeat.o(343242);
        return;
        localObject1 = null;
        break;
        if ((locale1 instanceof i))
        {
          localObject1 = this.GdT;
          if ((localObject1 instanceof j))
          {
            localObject1 = (j)localObject1;
            if (localObject1 == null) {
              continue;
            }
            ((j)localObject1).d(locale1);
            break label64;
          }
          localObject1 = null;
          continue;
          break label64;
        }
        if ((locale1 instanceof c))
        {
          localObject1 = this.GdT;
          if ((localObject1 instanceof j))
          {
            localObject1 = (j)localObject1;
            if (localObject1 == null) {
              continue;
            }
            ((j)localObject1).e(locale1);
            break label64;
          }
          localObject1 = null;
          continue;
          break label64;
        }
        if (!(locale1 instanceof k)) {
          break label64;
        }
        localObject1 = this.GdT;
        if ((localObject1 instanceof j))
        {
          localObject1 = (j)localObject1;
          if (localObject1 == null) {
            continue;
          }
          ((j)localObject1).f(locale1);
          break label64;
        }
        localObject1 = null;
        continue;
        break label64;
        localObject1 = d.this.GdS;
        d locald = d.this;
        try
        {
          locald.GdS.remove(this.GdT.feq());
          localObject1 = d.this.fem();
          if (localObject1 != null) {
            ((g)localObject1).c(this.GdT.feq(), this.GdT);
          }
          d.this.a(((a)this.GdT).taskId, this.GdT);
        }
        finally
        {
          AppMethodBeat.o(343242);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.base.d
 * JD-Core Version:    0.7.0.1
 */