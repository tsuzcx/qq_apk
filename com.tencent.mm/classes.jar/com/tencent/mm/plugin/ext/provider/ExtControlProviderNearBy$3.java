package com.tencent.mm.plugin.ext.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.kr.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class ExtControlProviderNearBy$3
  extends com.tencent.mm.pluginsdk.c.b
{
  ExtControlProviderNearBy$3(ExtControlProviderNearBy paramExtControlProviderNearBy) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.sdk.b.b paramb)
  {
    AppMethodBeat.i(20364);
    if ((paramb instanceof kr))
    {
      if (ExtControlProviderNearBy.c(this.meN) == null)
      {
        AppMethodBeat.o(20364);
        return;
      }
      paramString = (kr)paramb;
      ab.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + paramInt2 + ", errType: " + paramInt1);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label273;
      }
      ExtControlProviderNearBy.a(this.meN, paramString.cAG.cAN);
      if ((ExtControlProviderNearBy.d(this.meN) != null) && (ExtControlProviderNearBy.d(this.meN).size() != 0)) {
        break label146;
      }
      ab.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
      ExtControlProviderNearBy.c(this.meN).countDown();
    }
    for (;;)
    {
      ExtControlProviderNearBy.f(this.meN);
      AppMethodBeat.o(20364);
      return;
      label146:
      if (ExtControlProviderNearBy.d(this.meN).size() > 10)
      {
        ab.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + ExtControlProviderNearBy.d(this.meN).size());
        ExtControlProviderNearBy.d(this.meN).subList(10, ExtControlProviderNearBy.d(this.meN).size()).clear();
      }
      ExtControlProviderNearBy.a(this.meN, new CountDownLatch(ExtControlProviderNearBy.d(this.meN).size()));
      ExtControlProviderNearBy.c(this.meN).countDown();
      ExtControlProviderNearBy.e(this.meN);
      continue;
      label273:
      ab.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + paramInt2 + ", errType=" + paramInt1);
      ExtControlProviderNearBy.c(this.meN).countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderNearBy.3
 * JD-Core Version:    0.7.0.1
 */