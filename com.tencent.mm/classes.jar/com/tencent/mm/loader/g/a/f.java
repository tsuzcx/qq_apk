package com.tencent.mm.loader.g.a;

import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.concurrent.BlockingQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class f
  implements d
{
  private final String TAG;
  private final c hiQ;
  private final g hiR;
  private final g hiS;
  private final g hiT;
  private final int hiU;
  private final String name;
  
  public f(c paramc, g paramg, int paramInt, String paramString)
  {
    this(paramc, paramg, paramg, paramg, paramInt, paramString);
  }
  
  public f(c paramc, g paramg1, g paramg2, g paramg3, int paramInt, String paramString)
  {
    this.hiQ = paramc;
    this.hiR = paramg1;
    this.hiS = paramg2;
    this.hiT = paramg3;
    this.hiU = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.g.a arE()
  {
    ae.i(this.TAG, "pool light poolSize " + this.hiR.hiV + " priority " + this.hiR.hiV + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.hiR.hiV, this.hiR.hiV, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final com.tencent.mm.loader.g.a arF()
  {
    ae.i(this.TAG, "pool heavy poolSize " + this.hiS.hiV + " priority " + this.hiS.hiV + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.hiS.hiV, this.hiS.hiV, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final int arG()
  {
    return this.hiU;
  }
  
  public final c arH()
  {
    return this.hiQ;
  }
  
  public final String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.f
 * JD-Core Version:    0.7.0.1
 */