package com.tencent.mm.loader.g.a;

import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"})
public final class e
{
  private static final String TAG = "MicroMsg.Loader.LoaderFactory";
  private static volatile com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> hga;
  public static final e hgb = new e();
  
  public static com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> a(f paramf)
  {
    p.h(paramf, "configuration");
    return new com.tencent.mm.loader.g.d((d)paramf);
  }
  
  public static com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> art()
  {
    if (hga == null) {}
    synchronized (d.g.b.z.bp(com.tencent.mm.loader.g.d.class))
    {
      hga = new com.tencent.mm.loader.g.d((d)new f((c)new a(2147483647), new g(3), new g(3), new g(3), 3, "imageLoader"));
      d.z localz = d.z.MKo;
      ??? = hga;
      if (??? == null) {
        p.gfZ();
      }
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.e
 * JD-Core Version:    0.7.0.1
 */