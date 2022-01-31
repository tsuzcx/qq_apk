package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private final String ePP;
  
  public g(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new ahy();
    locala.ecI = new ahz();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
    locala.ecG = 890;
    this.dmK = locala.Kt();
    this.ePP = paramString;
    ((ahy)this.dmK.ecE.ecN).ePR = paramString;
    y.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", new Object[] { paramString });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 890;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openim.b.g
 * JD-Core Version:    0.7.0.1
 */