package com.tencent.mm.loader.k;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.e.b.e;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.h.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
public final class b$b
  implements b.a<R>
{
  public final void Up()
  {
    this.eQR.b(h.ePw);
    this.eQR.a(this.eQR.eQP);
  }
  
  public final void a(c<R> paramc)
  {
    j.q(paramc, "resultData");
    this.eQR.b(h.ePv);
    if (paramc.isValid()) {}
    for (Object localObject = paramc;; localObject = null)
    {
      if (localObject != null)
      {
        ab.d(this.eQR.TAG, "[ImageLoader] run. get bitmap successs. %s", new Object[] { this.eQR.eOQ });
        localObject = e.eOI;
        e.a.TL().a(this.eQR.eOQ, paramc);
      }
      this.eQR.Uo();
      this.eQR.a(this.eQR.eQP);
      return;
    }
  }
  
  public final void b(c<R> paramc)
  {
    j.q(paramc, "resultData");
    this.eQR.b(h.ePv);
    if (paramc.isValid()) {}
    for (Object localObject = paramc;; localObject = null)
    {
      if (localObject != null)
      {
        ab.d(this.eQR.TAG, "[ImageLoader] run. get bitmap successs. %s", new Object[] { this.eQR.eOQ });
        localObject = e.eOI;
        e.a.TL().a(this.eQR.eOQ, paramc);
      }
      this.eQR.Uo();
      this.eQR.a(this.eQR.eQP);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.k.b.b
 * JD-Core Version:    0.7.0.1
 */