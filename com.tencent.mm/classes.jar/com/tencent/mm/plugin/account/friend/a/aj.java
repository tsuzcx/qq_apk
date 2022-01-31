package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bpr;

public final class aj
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public aj(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bpq();
    locala.ecI = new bpr();
    locala.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
    locala.ecG = 108;
    locala.ecJ = 43;
    locala.ecK = 1000000043;
    this.dmK = locala.Kt();
    ((bpq)this.dmK.ecE.ecN).sQs = new bml().YI(paramString);
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
    return 108;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj
 * JD-Core Version:    0.7.0.1
 */