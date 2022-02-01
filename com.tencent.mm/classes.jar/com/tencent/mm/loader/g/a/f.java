package com.tencent.mm.loader.g.a;

import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.concurrent.BlockingQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class f
  implements d
{
  private final String TAG;
  private final c gMf;
  private final g gMg;
  private final g gMh;
  private final g gMi;
  private final int gMj;
  private final String name;
  
  public f(c paramc, g paramg, int paramInt, String paramString)
  {
    this(paramc, paramg, paramg, paramg, paramInt, paramString);
  }
  
  public f(c paramc, g paramg1, g paramg2, g paramg3, int paramInt, String paramString)
  {
    this.gMf = paramc;
    this.gMg = paramg1;
    this.gMh = paramg2;
    this.gMi = paramg3;
    this.gMj = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.g.a aoC()
  {
    ac.i(this.TAG, "pool light poolSize " + this.gMg.gMk + " priority " + this.gMg.gMk + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.gMg.gMk, this.gMg.gMk, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final com.tencent.mm.loader.g.a aoD()
  {
    ac.i(this.TAG, "pool heavy poolSize " + this.gMh.gMk + " priority " + this.gMh.gMk + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.gMh.gMk, this.gMh.gMk, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final int aoE()
  {
    return this.gMj;
  }
  
  public final c aoF()
  {
    return this.gMf;
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