package com.tencent.mm.loader.g.a;

import a.f.b.j;
import a.f.b.v;
import a.l;
import a.y;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/loader/cfg/LoaderCoreFactory;", "", "()V", "DEFAULT_THREAD_POOL_SIZE", "", "DEFAULT_THREAD_PRIORITY", "TAG", "", "getTAG", "()Ljava/lang/String;", "_instance", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getInstance", "newLoader", "configuration", "Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "libimageloader_release"})
public final class e
{
  private static final String TAG = "MicroMsg.Loader.LoaderFactory";
  private static volatile com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> ePL;
  public static final e ePM = new e();
  
  public static com.tencent.mm.loader.g.d<com.tencent.mm.loader.g.c> TT()
  {
    if (ePL == null) {}
    synchronized (v.aG(com.tencent.mm.loader.g.d.class))
    {
      ePL = new com.tencent.mm.loader.g.d((d)new g((c)new a(2147483647), new h(3), new h(3), new h(3), 3, "imageLoader"));
      y localy = y.BMg;
      ??? = ePL;
      if (??? == null) {
        j.ebi();
      }
      return ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.e
 * JD-Core Version:    0.7.0.1
 */