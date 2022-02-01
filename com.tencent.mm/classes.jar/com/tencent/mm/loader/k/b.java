package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "taskEndBefore", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  private com.tencent.mm.loader.e.b.d<R> kMX;
  public String kMY;
  a<T> kPm;
  j kRx;
  private com.tencent.mm.loader.f<T, R> kRy;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.kPm = parama;
    this.kMX = paramd;
    this.kRy = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.kRx = j.kQb;
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.h.c<R> paramc)
  {
    Object localObject = this.kRy;
    if (((com.tencent.mm.loader.f)localObject).kMF != null) {
      ((com.tencent.mm.loader.f)localObject).aRt();
    }
    com.tencent.mm.loader.f.e locale = ((com.tencent.mm.loader.f)localObject).kMC;
    a locala = this.kPm;
    localObject = ((com.tencent.mm.loader.f)localObject).aRt().kOY;
    if (paramc != null) {}
    for (paramc = paramc.value;; paramc = null)
    {
      locale.a(locala, (g)localObject, paramc);
      return;
    }
  }
  
  public final void a(com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, b<T, R> paramb)
  {
    p.k(paramf, "httpResponse");
    p.k(parame1, "source");
    p.k(paramb, "task");
    if (this.kRy.kMB.kOd) {
      this.kRy.kMI.a(this.kPm, paramf, parame1, parame2, this.kRy.kMB, this.kRy);
    }
  }
  
  public final String aBG()
  {
    String str = this.kPm.toString();
    p.j(str, "url.toString()");
    return str;
  }
  
  public final com.tencent.mm.loader.e.b.d<R> aRt()
  {
    return this.kMX;
  }
  
  public final com.tencent.mm.loader.f<T, R> aTR()
  {
    return this.kRy;
  }
  
  public final void b(j paramj)
  {
    p.k(paramj, "<set-?>");
    this.kRx = paramj;
  }
  
  protected final void b(com.tencent.mm.loader.h.c<R> paramc)
  {
    p.k(paramc, "resultData");
    com.tencent.mm.loader.f localf = this.kRy;
    if (paramc.isValid()) {}
    for (;;)
    {
      if (paramc != null)
      {
        paramc = localf.kMD;
        if (paramc != null) {
          paramc.a(localf.aRt().kOY);
        }
      }
      return;
      paramc = null;
    }
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.kRy.kMB.kOe, (a)new b(this));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static abstract interface a<RR>
  {
    public abstract void aTS();
    
    public abstract void c(com.tencent.mm.loader.h.c<RR> paramc);
    
    public abstract void d(com.tencent.mm.loader.h.c<RR> paramc);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static final class b
    implements b.a<R>
  {
    public final void aTS()
    {
      this.kRz.b(j.kQe);
      Log.i(this.kRz.TAG, "onTaskFail " + this.kRz.kPm);
      this.kRz.a(this.kRz.kRx);
    }
    
    public final void c(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.k(paramc, "resultData");
      this.kRz.b(j.kQd);
      this.kRz.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          Log.i(this.kRz.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.kRz.kPm + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.kPe;
          e.a.aRX().a(this.kRz.kPm, paramc);
        }
        this.kRz.a(paramc);
        this.kRz.a(this.kRz.kRx);
        return;
      }
    }
    
    public final void d(com.tencent.mm.loader.h.c<R> paramc)
    {
      p.k(paramc, "resultData");
      this.kRz.b(j.kQd);
      this.kRz.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          Log.i(this.kRz.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.kRz.kPm + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.kPe;
          e.a.aRX().a(this.kRz.kPm, paramc);
        }
        this.kRz.a(paramc);
        this.kRz.a(this.kRz.kRx);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */