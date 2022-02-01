package com.tencent.mm.plugin.finder.upload.postlogic.base;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/base/TaskStage;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "taskId", "", "(Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "belongTaskId", "exec", "onFailed", "", "nextStage", "onSuccess", "onWait", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class j
  implements e
{
  protected final String taskId;
  
  public j(String paramString)
  {
    this.taskId = paramString;
  }
  
  public abstract void d(e parame);
  
  public abstract void e(e parame);
  
  public abstract void f(e parame);
  
  public abstract e fen();
  
  public final String feq()
  {
    return this.taskId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.base.j
 * JD-Core Version:    0.7.0.1
 */