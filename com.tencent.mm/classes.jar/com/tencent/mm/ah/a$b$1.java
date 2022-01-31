package com.tencent.mm.ah;

import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$b$1
  implements k
{
  a$b$1(a.b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.vending.g.f.a(this.ecD.ecA, new Object[] { a.a.a(paramInt2, paramInt3, paramString, (bly)this.ecD.ecz.ecF.ecN, this.ecD, this.ecD.ecB) });
    this.ecD.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this.ecD.ecy);
    y.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", new Object[] { Integer.valueOf(this.ecD.ecy.hashCode()), Integer.valueOf(this.ecD.getType()), Long.valueOf(bk.UY() - this.ecD.mStartTime), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ah.a.b.1
 * JD-Core Version:    0.7.0.1
 */