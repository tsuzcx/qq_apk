package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "taskEndBefore", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  public String hfA;
  com.tencent.mm.loader.e.b.d<R> hfz;
  a<T> hhJ;
  j hjT;
  com.tencent.mm.loader.f<T, R> hjU;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.hhJ = parama;
    this.hfz = paramd;
    this.hjU = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.hjT = j.hiw;
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.h.c<R> paramc)
  {
    Object localObject = this.hjU;
    if (((com.tencent.mm.loader.f)localObject).hfh != null) {
      ((com.tencent.mm.loader.f)localObject).aqV();
    }
    com.tencent.mm.loader.f.e locale = ((com.tencent.mm.loader.f)localObject).hfe;
    a locala = this.hhJ;
    localObject = ((com.tencent.mm.loader.f)localObject).aqV().hhv;
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
    if (this.hjU.hfd.hgC) {
      this.hjU.hfk.a(this.hhJ, paramf, parame1, parame2, this.hjU.hfd, this.hjU);
    }
  }
  
  public final String aeW()
  {
    String str = this.hhJ.toString();
    p.g(str, "url.toString()");
    return str;
  }
  
  public final void b(j paramj)
  {
    p.h(paramj, "<set-?>");
    this.hjT = paramj;
  }
  
  protected final void b(com.tencent.mm.loader.h.c<R> paramc)
  {
    p.h(paramc, "resultData");
    com.tencent.mm.loader.f localf = this.hjU;
    if (paramc.isValid()) {}
    for (;;)
    {
      if (paramc != null)
      {
        paramc = localf.hff;
        if (paramc != null) {
          paramc.a(localf.aqV().hhv);
        }
      }
      return;
      paramc = null;
    }
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.hjU.hfd.hgE, (a)new b(this));
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static abstract interface a<RR>
  {
    public abstract void atm();
    
    public abstract void c(com.tencent.mm.loader.h.c<RR> paramc);
    
    public abstract void d(com.tencent.mm.loader.h.c<RR> paramc);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static final class b
    implements b.a<R>
  {
    public final void atm()
    {
      this.hjV.b(j.hiz);
      ae.i(this.hjV.TAG, "onTaskFail " + this.hjV.hhJ);
      this.hjV.a(this.hjV.hjT);
    }
    
    public final void c(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.h(paramc, "resultData");
      this.hjV.b(j.hiy);
      this.hjV.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ae.i(this.hjV.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.hjV.hhJ + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.hhB;
          e.a.ary().a(this.hjV.hhJ, paramc);
        }
        this.hjV.a(paramc);
        this.hjV.a(this.hjV.hjT);
        return;
      }
    }
    
    public final void d(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.h(paramc, "resultData");
      this.hjV.b(j.hiy);
      this.hjV.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ae.i(this.hjV.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.hjV.hhJ + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.hhB;
          e.a.ary().a(this.hjV.hhJ, paramc);
        }
        this.hjV.a(paramc);
        this.hjV.a(this.hjV.hjT);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */