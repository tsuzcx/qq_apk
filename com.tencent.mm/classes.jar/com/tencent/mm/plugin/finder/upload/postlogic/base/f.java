package com.tencent.mm.plugin.finder.upload.postlogic.base;

import com.tencent.mm.model.cn;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageCostTimeMonitor;", "T", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageRecord;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageMonitor;", "()V", "taskStageRecords", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "Lkotlin/collections/HashMap;", "getTaskStageRecords", "()Ljava/util/HashMap;", "begin", "", "taskId", "beginStage", "end", "endStage", "genStageRecord", "()Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageRecord;", "stageFinish", "stage", "costTime", "", "isSucc", "", "record", "(Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;JZLcom/tencent/mm/plugin/finder/upload/postlogic/base/StageRecord;)V", "transfer", "from", "to", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f<T extends h>
  implements g
{
  private final HashMap<String, HashMap<e, T>> GdV = new HashMap();
  
  public abstract void a(e parame, long paramLong, T paramT);
  
  public final void a(String paramString, e parame1, e parame2)
  {
    s.u(paramString, "taskId");
    s.u(parame1, "from");
    s.u(parame2, "to");
    long l = cn.bDw();
    Map localMap = (Map)this.GdV;
    Object localObject = localMap.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      localMap.put(paramString, localObject);
    }
    for (;;)
    {
      localMap = (Map)localObject;
      localObject = localMap.get(parame1);
      if (localObject == null)
      {
        localObject = fes();
        localMap.put(parame1, localObject);
      }
      for (;;)
      {
        localObject = (h)localObject;
        ((h)localObject).GdW = l;
        if (((parame2 instanceof j)) || ((parame2 instanceof i))) {
          ((h)localObject).hPw = true;
        }
        a(parame1, ((h)localObject).GdW - ((h)localObject).enterTime, (h)localObject);
        localObject = (Map)this.GdV;
        parame1 = ((Map)localObject).get(paramString);
        if (parame1 == null)
        {
          parame1 = new HashMap();
          ((Map)localObject).put(paramString, parame1);
        }
        for (paramString = parame1;; paramString = parame1)
        {
          parame1 = (Map)paramString;
          paramString = parame1.get(parame2);
          if (paramString == null)
          {
            paramString = fes();
            parame1.put(parame2, paramString);
          }
          for (;;)
          {
            ((h)paramString).enterTime = l;
            return;
          }
        }
      }
    }
  }
  
  public final void b(String paramString, e parame)
  {
    s.u(paramString, "taskId");
    s.u(parame, "beginStage");
    this.GdV.remove(paramString);
    Map localMap = (Map)this.GdV;
    Object localObject = localMap.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      localMap.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = (Map)paramString;
      paramString = ((Map)localObject).get(parame);
      if (paramString == null)
      {
        paramString = fes();
        ((Map)localObject).put(parame, paramString);
      }
      for (;;)
      {
        ((h)paramString).enterTime = cn.bDw();
        return;
      }
    }
  }
  
  public final void c(String paramString, e parame)
  {
    s.u(paramString, "taskId");
    s.u(parame, "endStage");
    Map localMap = (Map)this.GdV;
    Object localObject = localMap.get(paramString);
    if (localObject == null)
    {
      localObject = new HashMap();
      localMap.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = (String)localObject)
    {
      localObject = (Map)paramString;
      paramString = ((Map)localObject).get(parame);
      if (paramString == null)
      {
        paramString = fes();
        ((Map)localObject).put(parame, paramString);
      }
      for (;;)
      {
        ((h)paramString).GdW = cn.bDw();
        return;
      }
    }
  }
  
  public abstract T fes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.base.f
 * JD-Core Version:    0.7.0.1
 */