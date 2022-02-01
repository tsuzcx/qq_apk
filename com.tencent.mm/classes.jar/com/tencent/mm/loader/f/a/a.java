package com.tencent.mm.loader.f.a;

import com.tencent.mm.b.f;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  private final d<String, a> nqz;
  private final int nrO;
  private final int nrP;
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
    this.nrO = 2147483647;
    this.nrP = 100;
    this.nqz = new d(this.nrP);
  }
  
  public final boolean a(com.tencent.mm.loader.f.c paramc)
  {
    s.u(paramc, "task");
    if (this.nqz.check(paramc.aUE()))
    {
      long l = Util.nowSecond();
      Object localObject1 = this.nqz;
      Object localObject2 = paramc.aUE();
      if (((d)localObject1).nsn == null) {
        throw new NullPointerException("mData == null");
      }
      localObject2 = (a)((d)localObject1).nsn.ct(localObject2);
      if ((((a)localObject2).nrQ >= this.retryCount) && (l - ((a)localObject2).mJI < this.nrO))
      {
        Log.w("DefaultRetrySg", "check block by recentdown: " + paramc.aUE() + " count " + ((a)localObject2).nrQ + "  time: " + (l - ((a)localObject2).mJI));
        return false;
      }
      localObject1 = localObject2;
      if (l - ((a)localObject2).mJI > this.nrO)
      {
        Log.v("DefaultRetrySg", s.X("reset: ", paramc.aUE()));
        localObject1 = new a(l, 0);
      }
      ((a)localObject1).nrQ += 1;
      ((a)localObject1).mJI = l;
      this.nqz.put(paramc.aUE(), localObject1);
    }
    for (;;)
    {
      return true;
      this.nqz.put(paramc.aUE(), new a(Util.nowSecond(), 1));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    long mJI;
    int nrQ;
    
    public a(int paramInt)
    {
      this.mJI = ???;
      int i;
      this.nrQ = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f.a.a
 * JD-Core Version:    0.7.0.1
 */