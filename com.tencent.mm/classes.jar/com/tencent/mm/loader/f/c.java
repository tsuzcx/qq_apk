package com.tencent.mm.loader.f;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/IWorkTask;", "", "()V", "<set-?>", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "loader", "getLoader", "()Lcom/tencent/mm/loader/loader/ITaskLoader;", "watch", "Lcom/tencent/mm/loader/loader/WorkTaskWrap$IWorkTaskWrap;", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isCanReplaceCallback", "", "newTask", "uniqueId", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
{
  protected b nre;
  j.a nrf;
  
  public void a(i parami)
  {
    s.u(parami, "status");
    j.a locala2 = this.nrf;
    j.a locala1 = locala2;
    if (locala2 == null)
    {
      s.bIx("watch");
      locala1 = null;
    }
    locala1.onTaskStatusCallback(this, parami);
  }
  
  public abstract String aUE();
  
  public boolean b(c paramc)
  {
    s.u(paramc, "newTask");
    return true;
  }
  
  public abstract void call();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.c
 * JD-Core Version:    0.7.0.1
 */