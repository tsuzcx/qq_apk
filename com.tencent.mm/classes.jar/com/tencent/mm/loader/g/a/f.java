package com.tencent.mm.loader.g.a;

import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.concurrent.BlockingQueue;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class f
  implements d
{
  private final String TAG;
  private final c hgc;
  private final g hgd;
  private final g hge;
  private final g hgf;
  private final int hgg;
  private final String name;
  
  public f(c paramc, g paramg, int paramInt, String paramString)
  {
    this(paramc, paramg, paramg, paramg, paramInt, paramString);
  }
  
  public f(c paramc, g paramg1, g paramg2, g paramg3, int paramInt, String paramString)
  {
    this.hgc = paramc;
    this.hgd = paramg1;
    this.hge = paramg2;
    this.hgf = paramg3;
    this.hgg = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.g.a arp()
  {
    ad.i(this.TAG, "pool light poolSize " + this.hgd.hgh + " priority " + this.hgd.hgh + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.hgd.hgh, this.hgd.hgh, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final com.tencent.mm.loader.g.a arq()
  {
    ad.i(this.TAG, "pool heavy poolSize " + this.hge.hgh + " priority " + this.hge.hgh + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.hge.hgh, this.hge.hgh, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final int arr()
  {
    return this.hgg;
  }
  
  public final c ars()
  {
    return this.hgc;
  }
  
  public final String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.f
 * JD-Core Version:    0.7.0.1
 */