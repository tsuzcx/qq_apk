package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  public String content = "";
  private b dmK;
  private f dmL;
  public int esw = 0;
  public String title = "";
  
  public d(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new agt();
    locala.ecI = new agu();
    locala.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
    locala.ecG = 1803;
    this.dmK = locala.Kt();
    ((agt)this.dmK.ecE.ecN).ten = paramInt;
    this.esw = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (agu)this.dmK.ecF.ecN;
      this.title = paramq.teo;
      this.content = paramq.tep;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1803;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.d
 * JD-Core Version:    0.7.0.1
 */