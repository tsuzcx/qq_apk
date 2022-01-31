package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bph;

public final class f
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL = null;
  
  public f(bpg parambpg)
  {
    b.a locala = new b.a();
    locala.ecH = parambpg;
    locala.ecI = new bph();
    locala.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
    locala.ecG = 433;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 433;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */