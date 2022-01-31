package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzi;
import com.tencent.mm.protocal.c.bzj;

public final class d
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public d(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bzi();
    locala.ecI = new bzj();
    locala.uri = "/cgi-bin/micromsg-bin/unbindqq";
    locala.ecG = 253;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bzi)this.dmK.ecE.ecN).sRr = paramString;
  }
  
  public final int a(e parame, f paramf)
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
    return 253;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.d
 * JD-Core Version:    0.7.0.1
 */