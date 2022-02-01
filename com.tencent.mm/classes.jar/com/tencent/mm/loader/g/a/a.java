package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a> ial;
  private final int ibE;
  private final int ibF;
  private final int retryCount;
  
  public a()
  {
    this(5);
  }
  
  public a(byte paramByte)
  {
    this(2147483647);
  }
  
  public a(int paramInt)
  {
    this.retryCount = paramInt;
    this.ibF = 2147483647;
    this.ibE = 100;
    this.ial = new d(this.ibE);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    p.h(paramc, "task");
    if (this.ial.check(paramc.auK()))
    {
      long l = Util.nowSecond();
      a locala2 = (a)this.ial.aT(paramc.auK());
      if ((locala2.ibG >= this.retryCount) && (l - locala2.hwQ < this.ibF))
      {
        Log.w("DefaultRetrySg", "check block by recentdown: " + paramc.auK() + " count " + locala2.ibG + "  time: " + (l - locala2.hwQ));
        return false;
      }
      a locala1 = locala2;
      if (l - locala2.hwQ > this.ibF)
      {
        Log.v("DefaultRetrySg", "reset: " + paramc.auK());
        locala1 = new a(l, 0);
      }
      locala1.ibG += 1;
      locala1.hwQ = l;
      this.ial.put(paramc.auK(), locala1);
    }
    for (;;)
    {
      return true;
      this.ial.put(paramc.auK(), new a(Util.nowSecond(), 1));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
  public final class a
  {
    long hwQ;
    int ibG;
    
    public a(int paramInt)
    {
      this.hwQ = ???;
      int i;
      this.ibG = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */