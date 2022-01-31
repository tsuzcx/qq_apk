package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public i.b ePV;
  private int opType;
  
  public l(i.b paramb)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bbr();
    ((b.a)localObject).ecI = new bbs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((b.a)localObject).ecG = 806;
    this.dmK = ((b.a)localObject).Kt();
    this.opType = paramb.mdz;
    this.ePV = paramb;
    y.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (bbr)this.dmK.ecE.ecN;
    ((bbr)localObject).type = this.opType;
    ((bbr)localObject).txp = new com.tencent.mm.bv.b(paramb.getBuffer());
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.opType) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 806;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.l
 * JD-Core Version:    0.7.0.1
 */