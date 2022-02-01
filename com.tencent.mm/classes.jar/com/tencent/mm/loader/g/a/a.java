package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a> gkb;
  private final int gli;
  private final int glj;
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
    this.glj = 2147483647;
    this.gli = 100;
    this.gkb = new d(this.gli);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    k.h(paramc, "task");
    if (this.gkb.aN(paramc.abi()))
    {
      long l = bt.aGK();
      a locala2 = (a)this.gkb.aM(paramc.abi());
      if ((locala2.gll >= this.retryCount) && (l - locala2.glk < this.glj))
      {
        ad.w("DefaultRetrySg", "check block by recentdown: " + paramc.abi() + " count " + locala2.gll + "  time: " + (l - locala2.glk));
        return false;
      }
      a locala1 = locala2;
      if (l - locala2.glk > this.glj)
      {
        ad.v("DefaultRetrySg", "reset: " + paramc.abi());
        locala1 = new a(l, 0);
      }
      locala1.gll += 1;
      locala1.glk = l;
      this.gkb.put(paramc.abi(), locala1);
    }
    for (;;)
    {
      return true;
      this.gkb.put(paramc.abi(), new a(bt.aGK(), 1));
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
  public final class a
  {
    long glk;
    int gll;
    
    public a(int paramInt)
    {
      this.glk = ???;
      int i;
      this.gll = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */