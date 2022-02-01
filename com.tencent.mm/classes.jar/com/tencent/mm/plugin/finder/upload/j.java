package com.tencent.mm.plugin.finder.upload;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "()V", "TAG", "", "costTime", "", "taskStartTime", "getTaskStartTime", "()J", "setTaskStartTime", "(J)V", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskCostTime", "resetCost", "start", "plugin-finder_release"})
public abstract class j
  extends c
{
  private final String TAG = "Finder.LogPost.FinderTask";
  private long costTime;
  private long taskStartTime;
  
  public final void a(com.tencent.mm.loader.g.j paramj)
  {
    p.k(paramj, "status");
    Log.i(this.TAG, "task-" + aBG() + " callback, " + paramj.name());
    this.costTime = (cm.bfD() - this.taskStartTime);
    super.a(paramj);
  }
  
  public void call()
  {
    Log.i(this.TAG, "task-" + aBG() + " start");
    ecr();
    start();
  }
  
  public final long ecq()
  {
    if (this.costTime == 0L) {
      return cm.bfD() - this.taskStartTime;
    }
    return this.costTime;
  }
  
  public final void ecr()
  {
    this.taskStartTime = cm.bfD();
    this.costTime = 0L;
  }
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.j
 * JD-Core Version:    0.7.0.1
 */