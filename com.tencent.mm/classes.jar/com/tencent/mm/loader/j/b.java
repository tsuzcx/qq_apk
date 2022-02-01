package com.tencent.mm.loader.j;

import com.tencent.mm.loader.b.e.c;
import com.tencent.mm.loader.d.b.e.a;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "imageLoadListenerQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "imageLoaderListenerQueue", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "isCanReplaceCallback", "", "newTask", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "taskEndBefore", "uniqueId", "ITask", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<T, R>
  extends com.tencent.mm.loader.f.c
{
  final String TAG;
  private com.tencent.mm.loader.d.b.d<R> noQ;
  public String noR;
  com.tencent.mm.loader.g.a.a<T> nqP;
  private com.tencent.mm.loader.f<T, R> nsW;
  i nsX;
  private final ConcurrentLinkedQueue<com.tencent.mm.loader.e.c<T>> nsY;
  private final ConcurrentLinkedQueue<com.tencent.mm.loader.e.e<T, R>> nsZ;
  
  public b(com.tencent.mm.loader.g.a.a<T> parama, com.tencent.mm.loader.d.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.nqP = parama;
    this.noQ = paramd;
    this.nsW = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.nsX = i.nrE;
    this.nsY = new ConcurrentLinkedQueue();
    this.nsZ = new ConcurrentLinkedQueue();
    parama = this.nsW;
    paramd = parama.noy;
    if (paramd != null) {
      this.nsY.add(paramd);
    }
    this.nsZ.add(parama.nov);
  }
  
  protected abstract void a(e.c paramc, a<R> parama);
  
  protected final void a(com.tencent.mm.loader.g.c<R> paramc)
  {
    Object localObject = ((Iterable)this.nsY).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.loader.e.c)((Iterator)localObject).next()).b(this.nqP);
    }
    Iterator localIterator = ((Iterable)this.nsZ).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.loader.e.e locale = (com.tencent.mm.loader.e.e)localIterator.next();
      com.tencent.mm.loader.g.a.a locala = this.nqP;
      g localg = this.noQ.nqG;
      if (paramc == null) {}
      for (localObject = null;; localObject = paramc.value)
      {
        locale.onImageLoadComplete(locala, localg, localObject);
        break;
      }
    }
  }
  
  public final void a(com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<R> parame1, com.tencent.mm.loader.g.e<R> parame2, b<T, R> paramb)
  {
    s.u(paramf, "httpResponse");
    s.u(parame1, "source");
    s.u(paramb, "task");
    if (this.nsW.nou.npS) {
      this.nsW.noB.a(this.nqP, paramf, parame1, parame2, this.nsW.nou, this.nsW);
    }
  }
  
  public final String aUE()
  {
    String str = this.nqP.toString();
    s.s(str, "url.toString()");
    return str;
  }
  
  public final void b(i parami)
  {
    s.u(parami, "<set-?>");
    this.nsX = parami;
  }
  
  protected final void b(com.tencent.mm.loader.g.c<R> paramc)
  {
    s.u(paramc, "resultData");
    com.tencent.mm.loader.f localf = this.nsW;
    if (paramc.isValid()) {}
    for (;;)
    {
      if (paramc != null)
      {
        paramc = localf.now;
        if (paramc != null) {
          paramc.a(localf.bli().nqG);
        }
      }
      return;
      paramc = null;
    }
  }
  
  public final boolean b(com.tencent.mm.loader.f.c paramc)
  {
    s.u(paramc, "newTask");
    boolean bool;
    if (!(this.noQ instanceof com.tencent.mm.loader.d.b.a)) {
      bool = true;
    }
    while ((!bool) && ((paramc instanceof b)))
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.nsY;
      Object localObject2 = (Iterable)((b)paramc).nsY;
      Object localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if ((localObject3 instanceof com.tencent.mm.loader.e.c))
          {
            ((Collection)localObject1).add(localObject3);
            continue;
            bool = false;
            break;
          }
        }
      }
      localConcurrentLinkedQueue.addAll((Collection)localObject1);
      localConcurrentLinkedQueue = this.nsZ;
      localObject1 = (Iterable)((b)paramc).nsZ;
      paramc = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.loader.e.e)) {
          paramc.add(localObject2);
        }
      }
      localConcurrentLinkedQueue.addAll((Collection)paramc);
    }
    return bool;
  }
  
  public final com.tencent.mm.loader.d.b.d<R> bli()
  {
    return this.noQ;
  }
  
  public final com.tencent.mm.loader.f<T, R> bnG()
  {
    return this.nsW;
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    a(this.nsW.nou.npT, (a)new b(this));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/task/LoadTask$ITask;", "RR", "", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskLoadFin", "onTaskRemove", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a<RR>
  {
    public abstract void bnH();
    
    public abstract void c(com.tencent.mm.loader.g.c<RR> paramc);
    
    public abstract void d(com.tencent.mm.loader.g.c<RR> paramc);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/task/LoadTask$call$1", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "onTaskDownFin", "", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "onTaskFail", "onTaskLoadFin", "onTaskRemove", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a<R>
  {
    b(b<T, R> paramb) {}
    
    public final void bnH()
    {
      this.nta.b(i.nrH);
      Log.i(this.nta.TAG, s.X("onTaskFail ", this.nta.nqP));
      this.nta.a(this.nta.nsX);
    }
    
    public final void c(com.tencent.mm.loader.g.c<R> paramc)
    {
      s.u(paramc, "resultData");
      this.nta.b(i.nrG);
      this.nta.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          localObject = this.nta;
          Log.i(((b)localObject).TAG, "[ImageLoader] onTaskDownFin. get bitmap successs. " + ((b)localObject).nqP + ' ' + paramc.value);
          e.a locala = com.tencent.mm.loader.d.b.e.nqH;
          e.a.blM().a(((b)localObject).nqP, paramc);
        }
        this.nta.a(paramc);
        this.nta.a(this.nta.nsX);
        return;
      }
    }
    
    public final void d(com.tencent.mm.loader.g.c<R> paramc)
    {
      s.u(paramc, "resultData");
      this.nta.b(i.nrG);
      this.nta.b(paramc);
      if (paramc.isValid()) {}
      for (Object localObject = paramc;; localObject = null)
      {
        if (localObject != null)
        {
          localObject = this.nta;
          Log.i(((b)localObject).TAG, "[ImageLoader] ontaskLoadFin. get bitmap successs. " + ((b)localObject).nqP + ' ' + paramc.value);
          e.a locala = com.tencent.mm.loader.d.b.e.nqH;
          e.a.blM().a(((b)localObject).nqP, paramc);
        }
        this.nta.a(paramc);
        this.nta.a(this.nta.nsX);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.j.b
 * JD-Core Version:    0.7.0.1
 */