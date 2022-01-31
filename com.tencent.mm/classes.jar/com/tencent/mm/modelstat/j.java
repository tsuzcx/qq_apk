package com.tencent.mm.modelstat;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends m
  implements k
{
  private f dIJ;
  final com.tencent.mm.ah.b eDB;
  
  public j(com.tencent.mm.bv.b paramb)
  {
    b.a locala = new b.a();
    afl localafl = new afl();
    localafl.ssJ = 0;
    localafl.tdp = paramb;
    locala.ecH = localafl;
    locala.ecI = new afm();
    locala.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
    locala.ecG = 1126;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eDB = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
    this.edh = true;
    this.dIJ = paramf;
    return a(parame, this.eDB, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1126;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */