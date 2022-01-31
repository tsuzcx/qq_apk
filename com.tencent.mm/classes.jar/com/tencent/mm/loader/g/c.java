package com.tencent.mm.loader.g;

import a.f.b.j;
import a.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/loader/IWorkTask;", "", "()V", "<set-?>", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "loader", "getLoader", "()Lcom/tencent/mm/loader/loader/ITaskLoader;", "setLoader", "(Lcom/tencent/mm/loader/loader/ITaskLoader;)V", "watch", "Lcom/tencent/mm/loader/loader/WorkTaskWrap$IWorkTaskWrap;", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "", "libimageloader_release"})
public abstract class c
{
  protected b ePd;
  i.a ePe;
  
  public abstract String Oy();
  
  public final void a(h paramh)
  {
    j.q(paramh, "status");
    i.a locala = this.ePe;
    if (locala == null) {
      j.ays("watch");
    }
    locala.b(this, paramh);
  }
  
  public abstract void call();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.c
 * JD-Core Version:    0.7.0.1
 */