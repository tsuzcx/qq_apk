package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "taskEndBefore", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  com.tencent.mm.loader.e.b.d<R> hcL;
  public String hcM;
  a<T> heV;
  j hhf;
  com.tencent.mm.loader.f<T, R> hhg;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.heV = parama;
    this.hcL = paramd;
    this.hhg = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.hhf = j.hfI;
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.h.c<R> paramc)
  {
    Object localObject = this.hhg;
    if (((com.tencent.mm.loader.f)localObject).hct != null) {
      ((com.tencent.mm.loader.f)localObject).aqG();
    }
    com.tencent.mm.loader.f.e locale = ((com.tencent.mm.loader.f)localObject).hcq;
    a locala = this.heV;
    localObject = ((com.tencent.mm.loader.f)localObject).aqG().heH;
    if (paramc != null) {}
    for (paramc = paramc.value;; paramc = null)
    {
      locale.a(locala, (g)localObject, paramc);
      return;
    }
  }
  
  public final void a(com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, b<T, R> paramb)
  {
    p.h(paramf, "httpResponse");
    p.h(parame1, "source");
    p.h(paramb, "task");
    if (this.hhg.hcp.hdO) {
      this.hhg.hcw.a(this.heV, paramf, parame1, parame2, this.hhg.hcp, this.hhg);
    }
  }
  
  public final String aeK()
  {
    String str = this.heV.toString();
    p.g(str, "url.toString()");
    return str;
  }
  
  public final void b(j paramj)
  {
    p.h(paramj, "<set-?>");
    this.hhf = paramj;
  }
  
  protected final void b(com.tencent.mm.loader.h.c<R> paramc)
  {
    p.h(paramc, "resultData");
    com.tencent.mm.loader.f localf = this.hhg;
    if (paramc.isValid()) {}
    for (;;)
    {
      if (paramc != null)
      {
        paramc = localf.hcr;
        if (paramc != null) {
          paramc.b(localf.aqG().heH);
        }
      }
      return;
      paramc = null;
    }
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.hhg.hcp.hdQ, (a)new b(this));
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static abstract interface a<RR>
  {
    public abstract void asX();
    
    public abstract void c(com.tencent.mm.loader.h.c<RR> paramc);
    
    public abstract void d(com.tencent.mm.loader.h.c<RR> paramc);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static final class b
    implements b.a<R>
  {
    public final void asX()
    {
      this.hhh.b(j.hfL);
      ad.i(this.hhh.TAG, "onTaskFail " + this.hhh.heV);
      this.hhh.a(this.hhh.hhf);
    }
    
    public final void c(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.h(paramc, "resultData");
      this.hhh.b(j.hfK);
      this.hhh.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ad.i(this.hhh.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.hhh.heV + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.heN;
          e.a.arj().a(this.hhh.heV, paramc);
        }
        this.hhh.a(paramc);
        this.hhh.a(this.hhh.hhf);
        return;
      }
    }
    
    public final void d(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.h(paramc, "resultData");
      this.hhh.b(j.hfK);
      this.hhh.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ad.i(this.hhh.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.hhh.heV + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.heN;
          e.a.arj().a(this.hhh.heV, paramc);
        }
        this.hhh.a(paramc);
        this.hhh.a(this.hhh.hhf);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */