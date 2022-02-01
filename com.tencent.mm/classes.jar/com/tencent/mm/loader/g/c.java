package com.tencent.mm.loader.g;

import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/loader/IWorkTask;", "", "()V", "<set-?>", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "loader", "getLoader", "()Lcom/tencent/mm/loader/loader/ITaskLoader;", "watch", "Lcom/tencent/mm/loader/loader/WorkTaskWrap$IWorkTaskWrap;", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "", "libimageloader_release"})
public abstract class c
{
  protected b gLv;
  i.a gLw;
  
  public final void a(h paramh)
  {
    k.h(paramh, "status");
    i.a locala = this.gLw;
    if (locala == null) {
      k.aVY("watch");
    }
    locala.b(this, paramh);
  }
  
  public abstract String acg();
  
  public abstract void call();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.c
 * JD-Core Version:    0.7.0.1
 */