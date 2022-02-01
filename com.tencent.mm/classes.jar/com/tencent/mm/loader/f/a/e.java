package com.tencent.mm.loader.f.a;

import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final String TAG = "MicroMsg.Loader.LoaderFactory";
  public static final e nrV = new e();
  private static volatile com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> nrW;
  
  public static com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> a(f paramf)
  {
    s.u(paramf, "configuration");
    return new com.tencent.mm.loader.f.d((d)paramf);
  }
  
  public static com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> blX()
  {
    if (nrW == null) {}
    synchronized (ai.cz(com.tencent.mm.loader.f.d.class))
    {
      nrW = new com.tencent.mm.loader.f.d((d)new f((c)new a(2147483647), new g(3), new g(3), new g(3), 3, "imageLoader"));
      ah localah = ah.aiuX;
      ??? = nrW;
      s.checkNotNull(???);
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.a.e
 * JD-Core Version:    0.7.0.1
 */