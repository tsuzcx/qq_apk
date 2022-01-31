package com.tencent.mm.loader.g.a;

import a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class g
  implements d
{
  private final String TAG;
  private final c ePP;
  private final h ePQ;
  private final h ePR;
  private final h ePS;
  private final int ePT;
  private final String name;
  
  public g(c paramc, h paramh, int paramInt, String paramString)
  {
    this(paramc, paramh, paramh, paramh, paramInt, paramString);
  }
  
  public g(c paramc, h paramh1, h paramh2, h paramh3, int paramInt, String paramString)
  {
    this.ePP = paramc;
    this.ePQ = paramh1;
    this.ePR = paramh2;
    this.ePS = paramh3;
    this.ePT = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.g.a TP()
  {
    ab.i(this.TAG, "pool light poolSize " + this.ePQ.ePU + " priority " + this.ePQ.ePU + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.ePQ.ePU, this.ePQ.ePU, TimeUnit.MILLISECONDS, (BlockingQueue)new com.tencent.mm.loader.i.a(), (ThreadFactory)new f(this.ePQ.priority, this.name));
  }
  
  public final com.tencent.mm.loader.g.a TQ()
  {
    ab.i(this.TAG, "pool heavy poolSize " + this.ePR.ePU + " priority " + this.ePR.ePU + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.ePR.ePU, this.ePR.ePU, TimeUnit.MILLISECONDS, (BlockingQueue)new com.tencent.mm.loader.i.a(), (ThreadFactory)new f(this.ePR.priority, this.name));
  }
  
  public final int TR()
  {
    return this.ePT;
  }
  
  public final c TS()
  {
    return this.ePP;
  }
  
  public final String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.g
 * JD-Core Version:    0.7.0.1
 */