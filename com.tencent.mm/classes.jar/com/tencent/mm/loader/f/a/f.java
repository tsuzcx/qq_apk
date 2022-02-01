package com.tencent.mm.loader.f.a;

import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements d
{
  private final String TAG;
  private final String name;
  private final c nrX;
  private final g nrY;
  private final g nrZ;
  private final g nsa;
  private final int nsb;
  
  public f(c paramc, g paramg, int paramInt, String paramString)
  {
    this(paramc, paramg, paramg, paramg, paramInt, paramString);
  }
  
  public f(c paramc, g paramg1, g paramg2, g paramg3, int paramInt, String paramString)
  {
    this.nrX = paramc;
    this.nrY = paramg1;
    this.nrZ = paramg2;
    this.nsa = paramg3;
    this.nsb = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.f.a blT()
  {
    Log.i(this.TAG, "pool light poolSize " + this.nrY.num + " priority " + this.nrY.num + " name: " + this.name);
    return (com.tencent.mm.loader.f.a)new b(this.name, this.nrY.num, this.nrY.num, (BlockingQueue)new com.tencent.mm.loader.h.a());
  }
  
  public final com.tencent.mm.loader.f.a blU()
  {
    Log.i(this.TAG, "pool heavy poolSize " + this.nrZ.num + " priority " + this.nrZ.num + " name: " + this.name);
    return (com.tencent.mm.loader.f.a)new b(this.name, this.nrZ.num, this.nrZ.num, (BlockingQueue)new com.tencent.mm.loader.h.a());
  }
  
  public final int blV()
  {
    return this.nsb;
  }
  
  public final c blW()
  {
    return this.nrX;
  }
  
  public final String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.a.f
 * JD-Core Version:    0.7.0.1
 */