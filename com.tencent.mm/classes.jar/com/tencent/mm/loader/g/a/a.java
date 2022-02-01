package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a> heD;
  private final int hfS;
  private final int hfT;
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
    this.hfT = 2147483647;
    this.hfS = 100;
    this.heD = new d(this.hfS);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    p.h(paramc, "task");
    if (this.heD.aM(paramc.aeK()))
    {
      long l = bt.aQJ();
      a locala2 = (a)this.heD.aL(paramc.aeK());
      if ((locala2.hfV >= this.retryCount) && (l - locala2.hfU < this.hfT))
      {
        ad.w("DefaultRetrySg", "check block by recentdown: " + paramc.aeK() + " count " + locala2.hfV + "  time: " + (l - locala2.hfU));
        return false;
      }
      a locala1 = locala2;
      if (l - locala2.hfU > this.hfT)
      {
        ad.v("DefaultRetrySg", "reset: " + paramc.aeK());
        locala1 = new a(l, 0);
      }
      locala1.hfV += 1;
      locala1.hfU = l;
      this.heD.put(paramc.aeK(), locala1);
    }
    for (;;)
    {
      return true;
      this.heD.put(paramc.aeK(), new a(bt.aQJ(), 1));
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
  public final class a
  {
    long hfU;
    int hfV;
    
    public a(int paramInt)
    {
      this.hfU = ???;
      int i;
      this.hfV = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */