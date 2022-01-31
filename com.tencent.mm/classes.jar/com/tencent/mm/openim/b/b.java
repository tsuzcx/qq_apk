package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public String ePQ;
  
  public b(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ch();
    ((b.a)localObject).ecI = new ci();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimcontact";
    ((b.a)localObject).ecG = 667;
    this.dmK = ((b.a)localObject).Kt();
    this.ePQ = paramString1;
    localObject = (ch)this.dmK.ecE.ecN;
    ((ch)localObject).ePQ = paramString1;
    ((ch)localObject).svT = paramString2;
    y.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", new Object[] { paramString1, paramString2 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePQ });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 667;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openim.b.b
 * JD-Core Version:    0.7.0.1
 */