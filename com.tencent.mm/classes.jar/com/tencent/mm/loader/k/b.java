package com.tencent.mm.loader.k;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.c.e.b;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.loader.h.a.a;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/task/LoadTask;", "T", "R", "Lcom/tencent/mm/loader/loader/IWorkTask;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "REAPER", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "getREAPER", "()Lcom/tencent/mm/loader/Reaper;", "setREAPER", "(Lcom/tencent/mm/loader/Reaper;)V", "TAG", "", "debugInfo", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "taskStatus", "Lcom/tencent/mm/loader/loader/WorkStatus;", "getTaskStatus", "()Lcom/tencent/mm/loader/loader/WorkStatus;", "setTaskStatus", "(Lcom/tencent/mm/loader/loader/WorkStatus;)V", "getUrl", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUrl", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "cacheImageToDisk", "", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "task", "call", "debugCheck", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "isAddTaskWhePause", "", "reportReadCacheTime", "time", "", "taskEnd", "resultData", "Lcom/tencent/mm/loader/model/LoadResult;", "uniqueId", "ITask", "libimageloader_release"})
public abstract class b<T, R>
  extends c
{
  final String TAG;
  com.tencent.mm.loader.e.b.d<R> eNa;
  public String eNb;
  a<T> eOQ;
  h eQP;
  com.tencent.mm.loader.f<T, R> eQQ;
  
  public b(a<T> parama, com.tencent.mm.loader.e.b.d<R> paramd, com.tencent.mm.loader.f<T, R> paramf)
  {
    this.eOQ = parama;
    this.eNa = paramd;
    this.eQQ = paramf;
    this.TAG = "MicroMsg.Loader.ImageLoader.ImageLoadTask";
    this.eQP = h.ePt;
  }
  
  public final String Oy()
  {
    String str = this.eOQ.toString();
    j.p(str, "url.toString()");
    return str;
  }
  
  protected final void Uo()
  {
    Object localObject = this.eQQ;
    if (((com.tencent.mm.loader.f)localObject).eMJ != null) {
      ((com.tencent.mm.loader.f)localObject).SY();
    }
    ((com.tencent.mm.loader.f)localObject).SY();
    localObject = this.eQQ.eMG.TD();
    Arrays.copyOf((Object[])localObject, localObject.length);
  }
  
  protected abstract void a(e.b paramb, b.a<R> parama);
  
  public final void a(com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<R> parame1, com.tencent.mm.loader.h.e<R> parame2, b<T, R> paramb)
  {
    j.q(paramf, "httpResponse");
    j.q(parame1, "source");
    j.q(paramb, "task");
    if (this.eQQ.eMG.Tq()) {
      this.eQQ.eMM.a(this.eOQ, paramf, parame1, parame2, this.eQQ.eMG, this.eQQ);
    }
    if (this.eQQ.eMG.Tr()) {
      this.eQQ.eMM.a(this.eOQ, paramf, parame1, parame2, this.eQQ.eMG, this.eQQ);
    }
  }
  
  public final void b(h paramh)
  {
    j.q(paramh, "<set-?>");
    this.eQP = paramh;
  }
  
  public final void call()
  {
    System.currentTimeMillis();
    e.b localb = this.eQQ.eMG.Tv();
    j.p(localb, "fileType");
    a(localb, (b.a)new b.b(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.k.b
 * JD-Core Version:    0.7.0.1
 */