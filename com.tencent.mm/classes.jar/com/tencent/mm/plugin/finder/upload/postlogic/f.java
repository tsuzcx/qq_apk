package com.tencent.mm.plugin.finder.upload.postlogic;

import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.plugin.finder.upload.postlogic.base.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/FinderTaskStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/TaskStage;", "taskId", "", "(Ljava/lang/String;)V", "TAG", "costTime", "", "taskStartTime", "getTaskStartTime", "()J", "setTaskStartTime", "(J)V", "exec", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "getTaskCostTime", "resetCost", "", "start", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
  extends j
{
  private final String TAG = "Finder.FinderTaskStage";
  private long costTime;
  private long taskStartTime;
  
  public f(String paramString)
  {
    super(paramString);
  }
  
  public final e fen()
  {
    Log.i(this.TAG, "task-" + this.taskId + " start");
    this.taskStartTime = cn.bDv();
    this.costTime = 0L;
    e locale = feo();
    this.costTime = (cn.bDv() - this.taskStartTime);
    Log.i(this.TAG, "task-" + this.taskId + " end");
    return locale;
  }
  
  public abstract e feo();
  
  public final long fep()
  {
    if (this.costTime == 0L) {
      return cn.bDv() - this.taskStartTime;
    }
    return this.costTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.f
 * JD-Core Version:    0.7.0.1
 */