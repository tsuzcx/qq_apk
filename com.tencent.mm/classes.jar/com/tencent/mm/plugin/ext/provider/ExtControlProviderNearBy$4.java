package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.h.a.ke;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class ExtControlProviderNearBy$4
  implements a.a
{
  ExtControlProviderNearBy$4(ExtControlProviderNearBy paramExtControlProviderNearBy) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (ExtControlProviderNearBy.g(this.jKJ)) {}
    ke localke;
    do
    {
      return false;
      ExtControlProviderNearBy.h(this.jKJ);
      if (!paramBoolean)
      {
        y.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
        ExtControlProviderNearBy.f(this.jKJ);
        ExtControlProviderNearBy.c(this.jKJ).countDown();
        return false;
      }
      localke = new ke();
      localke.bTa.bMC = ExtControlProviderNearBy.i(this.jKJ);
      localke.bTa.bTc = paramFloat1;
      localke.bTa.bRt = paramFloat2;
      localke.bTa.bTd = ((int)paramDouble2);
      localke.bTa.bTe = paramInt;
      localke.bTa.bTf = "";
      localke.bTa.bTg = "";
    } while (!a.udP.m(localke));
    y.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.4
 * JD-Core Version:    0.7.0.1
 */