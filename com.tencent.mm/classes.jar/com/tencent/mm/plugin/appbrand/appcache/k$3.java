package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.y;

final class k$3
  extends c
{
  k$3(k paramk) {}
  
  public final void enter()
  {
    super.enter();
    y.i("MicroMsg.LibIncrementalTestCase[incremental]", "FetchNewestLibAndDoIncremental enter");
    ad.cI(true);
    g.DO().dJT.a(1168, new k.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.k.3
 * JD-Core Version:    0.7.0.1
 */