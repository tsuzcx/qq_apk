package com.tencent.mm.loader.g.a;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class f
  implements d
{
  private final String TAG;
  private final c ibN;
  private final g ibO;
  private final g ibP;
  private final g ibQ;
  private final int ibR;
  private final String name;
  
  public f(c paramc, g paramg, int paramInt, String paramString)
  {
    this(paramc, paramg, paramg, paramg, paramInt, paramString);
  }
  
  public f(c paramc, g paramg1, g paramg2, g paramg3, int paramInt, String paramString)
  {
    this.ibN = paramc;
    this.ibO = paramg1;
    this.ibP = paramg2;
    this.ibQ = paramg3;
    this.ibR = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.g.a aKd()
  {
    Log.i(this.TAG, "pool light poolSize " + this.ibO.ibS + " priority " + this.ibO.ibS + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.ibO.ibS, this.ibO.ibS, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final com.tencent.mm.loader.g.a aKe()
  {
    Log.i(this.TAG, "pool heavy poolSize " + this.ibP.ibS + " priority " + this.ibP.ibS + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.ibP.ibS, this.ibP.ibS, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final int aKf()
  {
    return this.ibR;
  }
  
  public final c aKg()
  {
    return this.ibN;
  }
  
  public final String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.f
 * JD-Core Version:    0.7.0.1
 */