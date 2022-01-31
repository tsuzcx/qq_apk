package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anx;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class l
  extends m
  implements k
{
  private final b dmK;
  private f dmL = null;
  
  public l(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new anx();
    locala.ecI = new any();
    locala.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
    locala.ecG = 339;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((anx)this.dmK.ecE.ecN).kWm = paramString;
    y.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :" + paramString);
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + paramInt2 + " " + paramInt3 + "  " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramInt1 = ((Integer)g.DP().Dz().get(135176, Integer.valueOf(0))).intValue();
    if (paramInt1 - 1 >= 0) {
      g.DP().Dz().o(135176, Integer.valueOf(paramInt1 - 1));
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 339;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.l
 * JD-Core Version:    0.7.0.1
 */