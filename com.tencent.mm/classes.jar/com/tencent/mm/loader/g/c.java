package com.tencent.mm.loader.g;

import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/IWorkTask;", "", "()V", "<set-?>", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "loader", "getLoader", "()Lcom/tencent/mm/loader/loader/ITaskLoader;", "watch", "Lcom/tencent/mm/loader/loader/WorkTaskWrap$IWorkTaskWrap;", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "", "libimageloader_release"})
public abstract class c
{
  protected b hfk;
  k.a hfl;
  
  public final void a(j paramj)
  {
    p.h(paramj, "status");
    k.a locala = this.hfl;
    if (locala == null) {
      p.bcb("watch");
    }
    locala.b(this, paramj);
  }
  
  public abstract String aeK();
  
  public abstract void call();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.c
 * JD-Core Version:    0.7.0.1
 */