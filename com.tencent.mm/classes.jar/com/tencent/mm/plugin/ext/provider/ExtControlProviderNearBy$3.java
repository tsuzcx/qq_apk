package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.h.a.ke;
import com.tencent.mm.h.a.ke.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class ExtControlProviderNearBy$3
  extends com.tencent.mm.pluginsdk.c.b
{
  ExtControlProviderNearBy$3(ExtControlProviderNearBy paramExtControlProviderNearBy) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb)
  {
    if ((!(paramb instanceof ke)) || (ExtControlProviderNearBy.c(this.jKJ) == null)) {
      return;
    }
    paramString = (ke)paramb;
    y.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramInt2 + ", errType: " + paramInt1);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ExtControlProviderNearBy.a(this.jKJ, paramString.bTb.bTi);
      if ((ExtControlProviderNearBy.d(this.jKJ) == null) || (ExtControlProviderNearBy.d(this.jKJ).size() == 0))
      {
        y.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
        ExtControlProviderNearBy.c(this.jKJ).countDown();
      }
    }
    for (;;)
    {
      ExtControlProviderNearBy.f(this.jKJ);
      return;
      if (ExtControlProviderNearBy.d(this.jKJ).size() > 10)
      {
        y.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(this.jKJ).size());
        ExtControlProviderNearBy.d(this.jKJ).subList(10, ExtControlProviderNearBy.d(this.jKJ).size()).clear();
      }
      ExtControlProviderNearBy.a(this.jKJ, new CountDownLatch(ExtControlProviderNearBy.d(this.jKJ).size()));
      ExtControlProviderNearBy.c(this.jKJ).countDown();
      ExtControlProviderNearBy.e(this.jKJ);
      continue;
      y.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + paramInt2 + ", errType=" + paramInt1);
      ExtControlProviderNearBy.c(this.jKJ).countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.3
 * JD-Core Version:    0.7.0.1
 */