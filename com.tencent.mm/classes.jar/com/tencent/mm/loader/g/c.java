package com.tencent.mm.loader.g;

import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/IWorkTask;", "", "()V", "<set-?>", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "loader", "getLoader", "()Lcom/tencent/mm/loader/loader/ITaskLoader;", "watch", "Lcom/tencent/mm/loader/loader/WorkTaskWrap$IWorkTaskWrap;", "call", "", "callback", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "uniqueId", "", "libimageloader_release"})
public abstract class c
{
  protected b iaV;
  k.a iaW;
  
  public void a(j paramj)
  {
    p.h(paramj, "status");
    k.a locala = this.iaW;
    if (locala == null) {
      p.btv("watch");
    }
    locala.b(this, paramj);
  }
  
  public abstract String auK();
  
  public abstract void call();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.g.c
 * JD-Core Version:    0.7.0.1
 */