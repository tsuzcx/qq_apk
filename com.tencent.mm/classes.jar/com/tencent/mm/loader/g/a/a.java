package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a> gKO;
  private final int gLV;
  private final int gLW;
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
    this.gLW = 2147483647;
    this.gLV = 100;
    this.gKO = new d(this.gLV);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    k.h(paramc, "task");
    if (this.gKO.aK(paramc.acg()))
    {
      long l = bs.aNx();
      a locala2 = (a)this.gKO.aJ(paramc.acg());
      if ((locala2.gLY >= this.retryCount) && (l - locala2.gLX < this.gLW))
      {
        ac.w("DefaultRetrySg", "check block by recentdown: " + paramc.acg() + " count " + locala2.gLY + "  time: " + (l - locala2.gLX));
        return false;
      }
      a locala1 = locala2;
      if (l - locala2.gLX > this.gLW)
      {
        ac.v("DefaultRetrySg", "reset: " + paramc.acg());
        locala1 = new a(l, 0);
      }
      locala1.gLY += 1;
      locala1.gLX = l;
      this.gKO.put(paramc.acg(), locala1);
    }
    for (;;)
    {
      return true;
      this.gKO.put(paramc.acg(), new a(bs.aNx(), 1));
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
  public final class a
  {
    long gLX;
    int gLY;
    
    public a(int paramInt)
    {
      this.gLX = ???;
      int i;
      this.gLY = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */