package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.mm.protocal.c.mk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class a$1
  implements Runnable
{
  a$1(a parama, int paramInt1, int paramInt2, mk parammk, long paramLong) {}
  
  public final void run()
  {
    if (a.a(this.fKw))
    {
      y.i("MicroMsg.AppBrandRecommendLogic", "location is valid");
      a.a(this.fKw, this.fKs, this.fKt, this.fKu, this.fKv);
      return;
    }
    y.i("MicroMsg.AppBrandRecommendLogic", "location is invalid, startLocation");
    a.b localb = new a.b(this.fKw);
    localb.fKx = this.fKs;
    localb.fKy = this.fKu;
    localb.filterType = this.fKt;
    localb.fKz = this.fKv;
    this.fKw.fKn.add(localb);
    a.b(this.fKw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.a.1
 * JD-Core Version:    0.7.0.1
 */