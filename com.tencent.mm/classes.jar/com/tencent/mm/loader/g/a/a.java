package com.tencent.mm.loader.g.a;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a
  implements c
{
  private final d<String, a.a> eOy;
  private final int ePD;
  private final int ePE;
  private final int retryCount;
  
  public a()
  {
    this(5);
  }
  
  public a(int paramInt)
  {
    this.retryCount = paramInt;
    this.ePE = 2147483647;
    this.ePD = 100;
    this.eOy = new d(this.ePD);
  }
  
  public final boolean a(com.tencent.mm.loader.g.c paramc)
  {
    j.q(paramc, "task");
    if (this.eOy.Z(paramc.Oy()))
    {
      long l = bo.aox();
      a.a locala2 = (a.a)this.eOy.Y(paramc.Oy());
      if ((locala2.ePG >= this.retryCount) && (l - locala2.ePF < this.ePE))
      {
        ab.w("DefaultRetrySg", "check block by recentdown: " + paramc.Oy() + " count " + locala2.ePG + "  time: " + (l - locala2.ePF));
        return false;
      }
      a.a locala1 = locala2;
      if (l - locala2.ePF > this.ePE)
      {
        ab.v("DefaultRetrySg", "reset: " + paramc.Oy());
        locala1 = new a.a(this, l, 0);
      }
      locala1.ePG += 1;
      locala1.ePF = l;
      this.eOy.put(paramc.Oy(), locala1);
    }
    for (;;)
    {
      return true;
      this.eOy.put(paramc.Oy(), new a.a(this, bo.aox(), 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.loader.g.a.a
 * JD-Core Version:    0.7.0.1
 */