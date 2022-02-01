package com.tencent.mm.loader.k;

import com.tencent.mm.loader.c.e.c;
import com.tencent.mm.loader.e.b.e.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  com.tencent.mm.loader.e.b.d<R> gir;
  public String gis;
  a<T> gkt;
  h gmv;
  com.tencent.mm.loader.f<T, R> gmw;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.gkt = parama;
    this.gir = paramd;
    this.gmw = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.gmv = h.gkY;
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.h.c<R> paramc)
  {
    Object localObject = this.gmw;
    if (((com.tencent.mm.loader.f)localObject).ghZ != null) {
      ((com.tencent.mm.loader.f)localObject).agT();
    }
    com.tencent.mm.loader.f.d locald = ((com.tencent.mm.loader.f)localObject).ghX;
    a locala = this.gkt;
    localObject = ((com.tencent.mm.loader.f)localObject).agT().gkf;
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
    if (this.gmw.ghW.gjs) {
      this.gmw.gic.a(this.gkt, paramf, parame1, parame2, this.gmw.ghW, this.gmw);
    }
  }
  
  public final String abi()
  {
    String str = this.gkt.toString();
    k.g(str, "url.toString()");
    return str;
  }
  
  public final void b(h paramh)
  {
    k.h(paramh, "<set-?>");
    this.gmv = paramh;
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.gmw.ghW.gju, (a)new b(this));
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static abstract interface a<RR>
  {
    public abstract void aji();
    
    public abstract void b(com.tencent.mm.loader.h.c<RR> paramc);
    
    public abstract void c(com.tencent.mm.loader.h.c<RR> paramc);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskRemove", "ontaskLoadFin", "libimageloader_release"})
  public static final class b
    implements b.a<R>
  {
    public final void aji()
    {
      this.gmx.b(h.glb);
      ad.i(this.gmx.TAG, "onTaskFail " + this.gmx.gkt);
      this.gmx.a(this.gmx.gmv);
    }
    
    public final void b(com.tencent.mm.loader.h.c<R> paramc)
    {
      k.h(paramc, "resultData");
      this.gmx.b(h.gla);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ad.i(this.gmx.TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + this.gmx.gkt + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.gkl;
          e.a.ahv().a(this.gmx.gkt, paramc);
        }
        this.gmx.a(paramc);
        this.gmx.a(this.gmx.gmv);
        return;
      }
    }
    
    public final void c(com.tencent.mm.loader.h.c<R> paramc)
    {
      k.h(paramc, "resultData");
      this.gmx.b(h.gla);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          ad.i(this.gmx.TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + this.gmx.gkt + ' ' + paramc.value);
          localObject = com.tencent.mm.loader.e.b.e.gkl;
          e.a.ahv().a(this.gmx.gkt, paramc);
        }
        this.gmx.a(paramc);
        this.gmx.a(this.gmx.gmv);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */