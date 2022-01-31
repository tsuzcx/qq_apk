package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private bqs iHH;
  
  public o(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bqs();
    locala.ecI = new bqt();
    locala.ecG = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.eWr = locala.Kt();
    this.iHH = ((bqs)this.eWr.ecE.ecN);
    this.iHH.hQR = 3;
    this.iHH.tHF = paramString;
    y.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 304;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.o
 * JD-Core Version:    0.7.0.1
 */