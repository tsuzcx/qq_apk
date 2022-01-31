package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class h
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private String ePQ;
  private String ePR;
  public bbd ePS;
  private int ret;
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    b.a locala = new b.a();
    locala.ecH = new aia();
    locala.ecI = new aib();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimcontact";
    locala.ecG = 881;
    this.dmK = locala.Kt();
    this.ePQ = paramString1;
    this.ePR = bk.aM(paramString2, "");
    y.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "get openim username: %s, roomname: %s, ticket:%s", new Object[] { paramString1, this.ePR, paramString3 });
    paramString2 = (aia)this.dmK.ecE.ecN;
    paramString2.ePQ = paramString1;
    paramString2.ePP = this.ePR;
    paramString2.bJY = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.Openim.NetSceneGetOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePQ });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (aib)this.dmK.ecF.ecN;
    this.ePS = paramq.tfr;
    this.ret = r.a(paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 881;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openim.b.h
 * JD-Core Version:    0.7.0.1
 */