package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.protocal.c.ahu;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private final String ePP;
  
  public e(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new ahu();
    locala.ecI = new ahv();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
    locala.ecG = 407;
    this.dmK = locala.Kt();
    this.ePP = paramString;
    ((ahu)this.dmK.ecE.ecN).ePR = paramString;
    y.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", new Object[] { paramString });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePP });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ahv)((b)paramq).ecF.ecN;
      if (paramq.tfm != null) {
        a.a(paramq.tfm);
      }
    }
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 407;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.e
 * JD-Core Version:    0.7.0.1
 */