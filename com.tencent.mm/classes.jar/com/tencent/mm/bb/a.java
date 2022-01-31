package com.tencent.mm.bb;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public a(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new to();
    locala.ecI = new tp();
    locala.uri = "/cgi-bin/micromsg-bin/deletecardimg";
    locala.ecG = 576;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((to)this.dmK.ecE.ecN).sQG = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 576;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */