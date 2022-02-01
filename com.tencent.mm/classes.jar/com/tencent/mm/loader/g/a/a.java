package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a> hhr;
  private final int hiG;
  private final int hiH;
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
    this.hiH = 2147483647;
    this.hiG = 100;
    this.hhr = new d(this.hiG);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    p.h(paramc, "task");
    if (this.hhr.aM(paramc.aeW()))
    {
      long l = bu.aRi();
      a locala2 = (a)this.hhr.aL(paramc.aeW());
      if ((locala2.hiJ >= this.retryCount) && (l - locala2.hiI < this.hiH))
      {
        ae.w("DefaultRetrySg", "check block by recentdown: " + paramc.aeW() + " count " + locala2.hiJ + "  time: " + (l - locala2.hiI));
        return false;
      }
      a locala1 = locala2;
      if (l - locala2.hiI > this.hiH)
      {
        ae.v("DefaultRetrySg", "reset: " + paramc.aeW());
        locala1 = new a(l, 0);
      }
      locala1.hiJ += 1;
      locala1.hiI = l;
      this.hhr.put(paramc.aeW(), locala1);
    }
    for (;;)
    {
      return true;
      this.hhr.put(paramc.aeW(), new a(bu.aRi(), 1));
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
  public final class a
  {
    long hiI;
    int hiJ;
    
    public a(int paramInt)
    {
      this.hiI = ???;
      int i;
      this.hiJ = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */