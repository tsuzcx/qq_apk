package com.tencent.mm.loader.g.a;

import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"})
public final class e
{
  private static final String TAG = "MicroMsg.Loader.LoaderFactory";
  private static volatile com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> kQs;
  public static final e kQt = new e();
  
  public static com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> a(f paramf)
  {
    p.k(paramf, "configuration");
    return new com.tencent.mm.loader.g.d((d)paramf);
  }
  
  public static com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> aSi()
  {
    if (kQs == null) {}
    synchronized (ab.bO(com.tencent.mm.loader.g.d.class))
    {
      kQs = new com.tencent.mm.loader.g.d((d)new f((c)new a(2147483647), new g(3), new g(3), new g(3), 3, "imageLoader"));
      x localx = x.aazN;
      ??? = kQs;
      if (??? == null) {
        p.iCn();
      }
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.e
 * JD-Core Version:    0.7.0.1
 */