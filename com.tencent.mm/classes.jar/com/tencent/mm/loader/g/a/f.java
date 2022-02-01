package com.tencent.mm.loader.g.a;

import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.concurrent.BlockingQueue;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/loader/cfg/TaskLoaderConfiguration;", "Lcom/tencent/mm/loader/loader/cfg/ITaskLoaderConfiguration;", "lightWork", "Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;", "parallelTask", "", "name", "", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "retrySg", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "heavyWork", "ioWork", "(Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "(Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;Lcom/tencent/mm/loader/loader/cfg/ThreadConfiguration;ILjava/lang/String;)V", "TAG", "createHeavyExecutor", "Lcom/tencent/mm/loader/loader/ILoaderExecutor;", "createIoExecutor", "createLightExecutor", "retryStrategy", "libimageloader_release"})
public final class f
  implements d
{
  private final String TAG;
  private final c gls;
  private final g glt;
  private final g glu;
  private final g glv;
  private final int glw;
  private final String name;
  
  public f(c paramc, g paramg, int paramInt, String paramString)
  {
    this(paramc, paramg, paramg, paramg, paramInt, paramString);
  }
  
  public f(c paramc, g paramg1, g paramg2, g paramg3, int paramInt, String paramString)
  {
    this.gls = paramc;
    this.glt = paramg1;
    this.glu = paramg2;
    this.glv = paramg3;
    this.glw = paramInt;
    this.name = paramString;
    this.TAG = "MicroMsg.Loader.TaskLoaderConfiguration";
  }
  
  public final com.tencent.mm.loader.g.a ahA()
  {
    ad.i(this.TAG, "pool light poolSize " + this.glt.glx + " priority " + this.glt.glx + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.glt.glx, this.glt.glx, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final com.tencent.mm.loader.g.a ahB()
  {
    ad.i(this.TAG, "pool heavy poolSize " + this.glu.glx + " priority " + this.glu.glx + " name: " + this.name);
    return (com.tencent.mm.loader.g.a)new b(this.name, this.glu.glx, this.glu.glx, (BlockingQueue)new com.tencent.mm.loader.i.a());
  }
  
  public final int ahC()
  {
    return this.glw;
  }
  
  public final c ahD()
  {
    return this.gls;
  }
  
  public final String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.f
 * JD-Core Version:    0.7.0.1
 */