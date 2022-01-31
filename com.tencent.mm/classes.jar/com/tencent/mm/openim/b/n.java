package com.tencent.mm.openim.b;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private String ePW;
  public bob ePX;
  public String ePY;
  
  public n(String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new boc();
    ((b.a)localObject).ecI = new bod();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((b.a)localObject).ecG = 372;
    this.dmK = ((b.a)localObject).Kt();
    y.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.ePW });
    localObject = (boc)this.dmK.ecE.ecN;
    ((boc)localObject).tGI = "";
    ((boc)localObject).bSe = paramString;
    ((boc)localObject).tGJ = 1;
  }
  
  public n(String paramString, byte paramByte)
  {
    this.ePW = paramString;
    b.a locala = new b.a();
    locala.ecH = new boc();
    locala.ecI = new bod();
    locala.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    locala.ecG = 372;
    this.dmK = locala.Kt();
    y.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    ((boc)this.dmK.ecE.ecN).tGI = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.ePY = ((bod)this.dmK.ecF.ecN).url;
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.ePX = ((bod)this.dmK.ecF.ecN).tGK;
    paramq = new h();
    paramq.username = this.ePX.hPY;
    paramq.ebT = this.ePX.sLD;
    paramq.ebS = this.ePX.sLE;
    paramq.bcw = -1;
    y.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { paramq.getUsername(), paramq.JX(), paramq.JY() });
    paramq.cCq = 3;
    paramq.bK(true);
    o.Kh().a(paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 372;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.n
 * JD-Core Version:    0.7.0.1
 */