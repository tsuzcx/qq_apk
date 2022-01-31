package com.tencent.mm.ah;

import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$b<_Resp extends bly>
  extends m
{
  f dIJ = null;
  com.tencent.mm.vending.g.b ecA;
  a ecB;
  private k ecC = new a.b.1(this);
  final m ecy = this;
  b ecz;
  final long mStartTime = bk.UY();
  
  public a$b(a parama)
  {
    this.ecB = parama;
  }
  
  protected final int Ka()
  {
    return 1;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    int i = a(parame, this.ecz, this.ecC);
    y.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", new Object[] { Integer.valueOf(this.ecy.hashCode()), Integer.valueOf(this.ecz.ecG), Integer.valueOf(i), Long.valueOf(bk.UY() - this.mStartTime) });
    if (i < 0) {
      com.tencent.mm.vending.g.f.a(this.ecA, new Object[] { a.a.a(3, -1, "", (bly)this.ecz.ecF.ecN, this, this.ecB) });
    }
    return i;
  }
  
  public final int getType()
  {
    return this.ecz.ecG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ah.a.b
 * JD-Core Version:    0.7.0.1
 */