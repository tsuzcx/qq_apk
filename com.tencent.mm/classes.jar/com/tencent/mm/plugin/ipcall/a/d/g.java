package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class g
  extends m
  implements k
{
  private b dmK = null;
  private f dmL;
  private amr lrB = null;
  public ams lrC = null;
  
  public g(int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new amr();
    ((b.a)localObject).ecI = new ams();
    ((b.a)localObject).ecG = 257;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.lrB = ((amr)this.dmK.ecE.ecN);
    this.lrB.pyo = paramInt;
    localObject = this.lrB;
    au.Hx();
    ((amr)localObject).tiB = ((Integer)c.Dz().get(ac.a.uqw, Integer.valueOf(0))).intValue();
    localObject = this.lrB;
    au.Hx();
    ((amr)localObject).tiC = ((Integer)c.Dz().get(ac.a.uqk, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.lrB.pyo), Integer.valueOf(this.lrB.tiB), Integer.valueOf(this.lrB.tiC) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.lrC = ((ams)((b)paramq).ecF.ecN);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.lrC;
      if (paramq != null) {
        y.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { paramq.tiG, paramq.tiH, paramq.tiD, paramq.lsL, paramq.bGw, paramq.kRN, paramq.tiE, paramq.tiF, paramq.tiI, paramq.tiO });
      }
    }
    try
    {
      au.Hx();
      c.Dz().c(ac.a.urs, bk.bG(paramq.toByteArray()));
      if (this.dmL != null) {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      return;
    }
    catch (IOException paramq)
    {
      for (;;)
      {
        y.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[] { paramq.getMessage() });
      }
    }
  }
  
  public final int getType()
  {
    return 257;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.g
 * JD-Core Version:    0.7.0.1
 */