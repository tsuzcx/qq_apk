package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  extends com.tencent.mm.ah.m
  implements k
{
  private final b dmK;
  private f dmL;
  private final String ePP;
  
  public m(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bmf();
    ((b.a)localObject).ecI = new bmg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
    ((b.a)localObject).ecG = 772;
    this.dmK = ((b.a)localObject).Kt();
    this.ePP = paramString1;
    localObject = (bmf)this.dmK.ecE.ecN;
    ((bmf)localObject).ePP = paramString1;
    ((bmf)localObject).bTq = paramString2;
    y.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", new Object[] { paramString1, paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 772;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.m
 * JD-Core Version:    0.7.0.1
 */