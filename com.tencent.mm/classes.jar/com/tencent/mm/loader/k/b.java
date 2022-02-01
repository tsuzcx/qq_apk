package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "taskEndBefore", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  com.tencent.mm.loader.e.b.d<R> hYt;
  public String hYu;
  a<T> iaG;
  j icQ;
  com.tencent.mm.loader.f<T, R> icR;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.iaG = parama;
    this.hYt = paramd;
    this.icR = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.icQ = j.ibu;
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.h.c<R> paramc)
  {
    Object localObject = this.icR;
    if (((com.tencent.mm.loader.f)localObject).hYb != null) {
      ((com.tencent.mm.loader.f)localObject).aJt();
    }
    com.tencent.mm.loader.f.e locale = ((com.tencent.mm.loader.f)localObject).hXY;
    a locala = this.iaG;
    localObject = ((com.tencent.mm.loader.f)localObject).aJt().ias;
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
    if (this.icR.hXX.hZx) {
      this.icR.hYe.a(this.iaG, paramf, parame1, parame2, this.icR.hXX, this.icR);
    }
  }
  
  public final String auK()
  {
    String str = this.iaG.toString();
    p.g(str, "url.toString()");
    return str;
  }
  
  public final void b(j paramj)
  {
    p.h(paramj, "<set-?>");
    this.icQ = paramj;
  }
  
  protected final void b(com.tencent.mm.loader.h.c<R> paramc)
  {
    p.h(paramc, "resultData");
    com.tencent.mm.loader.f localf = this.icR;
    if (paramc.isValid()) {}
    for (;;)
    {
      if (paramc != null)
      {
        paramc = localf.hXZ;
        if (paramc != null) {
          paramc.a(localf.aJt().ias);
        }
      }
      return;
      paramc = null;
    }
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.icR.hXX.hZy, (a)new b(this));
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static abstract interface a<RR>
  {
    public abstract void aLM();
    
    public abstract void c(com.tencent.mm.loader.h.c<RR> paramc);
    
    public abstract void d(com.tencent.mm.loader.h.c<RR> paramc);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static final class b
    implements b.a<R>
  {
    public final void aLM()
    {
      this.icS.b(j.ibx);
      Log.i(this.icS.TAG, "onTaskFail " + this.icS.iaG);
      this.icS.a(this.icS.icQ);
    }
    
    public final void c(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.h(paramc, "resultData");
      this.icS.b(j.ibw);
      this.icS.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          Log.i(this.icS.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.icS.iaG + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.iay;
          e.a.aJX().a(this.icS.iaG, paramc);
        }
        this.icS.a(paramc);
        this.icS.a(this.icS.icQ);
        return;
      }
    }
    
    public final void d(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.h(paramc, "resultData");
      this.icS.b(j.ibw);
      this.icS.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          Log.i(this.icS.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.icS.iaG + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.iay;
          e.a.aJX().a(this.icS.iaG, paramc);
        }
        this.icS.a(paramc);
        this.icS.a(this.icS.icQ);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */