package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ajz;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  public final b dWV;
  private f dmL;
  
  public o()
  {
    b.a locala = new b.a();
    locala.ecH = new ajz();
    locala.ecI = new aka();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.ecG = 725;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dWV = locala.Kt();
    ((ajz)this.dWV.ecE.ecN).hQR = 0;
    y.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), bk.csb() });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    h.nFQ.a(405L, 1L, 1L, true);
    return a(parame, this.dWV, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.nFQ.a(405L, 2L, 1L, true);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 725;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.o
 * JD-Core Version:    0.7.0.1
 */