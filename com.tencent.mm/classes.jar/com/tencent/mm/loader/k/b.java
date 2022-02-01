package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  com.tencent.mm.loader.e.b.d<R> gJa;
  public String gJb;
  a<T> gLg;
  h gNi;
  com.tencent.mm.loader.f<T, R> gNj;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.gLg = parama;
    this.gJa = paramd;
    this.gNj = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.gNi = h.gLL;
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.h.c<R> paramc)
  {
    Object localObject = this.gNj;
    if (((com.tencent.mm.loader.f)localObject).gII != null) {
      ((com.tencent.mm.loader.f)localObject).anU();
    }
    com.tencent.mm.loader.f.d locald = ((com.tencent.mm.loader.f)localObject).gIG;
    a locala = this.gLg;
    localObject = ((com.tencent.mm.loader.f)localObject).anU().gKS;
    if (paramc != null) {}
    for (paramc = paramc.value;; paramc = null)
    {
      locald.a(locala, (g)localObject, paramc);
      return;
    }
  }
  
  public final void a(com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, b<T, R> paramb)
  {
    k.h(paramf, "httpResponse");
    k.h(parame1, "source");
    k.h(paramb, "task");
    if (this.gNj.gIF.gKd) {
      this.gNj.gIL.a(this.gLg, paramf, parame1, parame2, this.gNj.gIF, this.gNj);
    }
  }
  
  public final String acg()
  {
    String str = this.gLg.toString();
    k.g(str, "url.toString()");
    return str;
  }
  
  public final void b(h paramh)
  {
    k.h(paramh, "<set-?>");
    this.gNi = paramh;
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.gNj.gIF.gKf, (a)new b(this));
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static abstract interface a<RR>
  {
    public abstract void aqi();
    
    public abstract void b(com.tencent.mm.loader.h.c<RR> paramc);
    
    public abstract void c(com.tencent.mm.loader.h.c<RR> paramc);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static final class b
    implements b.a<R>
  {
    public final void aqi()
    {
      this.gNk.b(h.gLO);
      ac.i(this.gNk.TAG, "onTaskFail " + this.gNk.gLg);
      this.gNk.a(this.gNk.gNi);
    }
    
    public final void b(com.tencent.mm.loader.h.c<R> paramc)
    {
      k.h(paramc, "resultData");
      this.gNk.b(h.gLN);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ac.i(this.gNk.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.gNk.gLg + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.gKY;
          e.a.aox().a(this.gNk.gLg, paramc);
        }
        this.gNk.a(paramc);
        this.gNk.a(this.gNk.gNi);
        return;
      }
    }
    
    public final void c(com.tencent.mm.loader.h.c<R> paramc)
    {
      k.h(paramc, "resultData");
      this.gNk.b(h.gLN);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ac.i(this.gNk.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.gNk.gLg + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.gKY;
          e.a.aox().a(this.gNk.gLg, paramc);
        }
        this.gNk.a(paramc);
        this.gNk.a(this.gNk.gNi);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */