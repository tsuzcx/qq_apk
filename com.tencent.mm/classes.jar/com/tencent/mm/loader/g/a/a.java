package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a> kOR;
  private final int kQl;
  private final int kQm;
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
    this.kQm = 2147483647;
    this.kQl = 100;
    this.kOR = new d(this.kQl);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    p.k(paramc, "task");
    if (this.kOR.check(paramc.aBG()))
    {
      long l = Util.nowSecond();
      a locala2 = (a)this.kOR.aX(paramc.aBG());
      if ((locala2.kQn >= this.retryCount) && (l - locala2.kje < this.kQm))
      {
        Log.w("DefaultRetrySg", "check block by recentdown: " + paramc.aBG() + " count " + locala2.kQn + "  time: " + (l - locala2.kje));
        return false;
      }
      a locala1 = locala2;
      if (l - locala2.kje > this.kQm)
      {
        Log.v("DefaultRetrySg", "reset: " + paramc.aBG());
        locala1 = new a(l, 0);
      }
      locala1.kQn += 1;
      locala1.kje = l;
      this.kOR.put(paramc.aBG(), locala1);
    }
    for (;;)
    {
      return true;
      this.kOR.put(paramc.aBG(), new a(Util.nowSecond(), 1));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
  public final class a
  {
    int kQn;
    long kje;
    
    public a(int paramInt)
    {
      this.kje = ???;
      int i;
      this.kQn = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */