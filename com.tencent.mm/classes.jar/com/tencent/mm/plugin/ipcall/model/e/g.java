package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b rr;
  private bgt tKA;
  public bgu tKB;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.tKA = null;
    this.tKB = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bgt();
    ((b.a)localObject).hvu = new bgu();
    ((b.a)localObject).funcId = 257;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    this.tKA = ((bgt)this.rr.hvr.hvw);
    this.tKA.Scene = paramInt;
    localObject = this.tKA;
    az.ayM();
    ((bgt)localObject).EVN = ((Integer)c.agA().get(ah.a.GGH, Integer.valueOf(0))).intValue();
    localObject = this.tKA;
    az.ayM();
    ((bgt)localObject).EVO = ((Integer)c.agA().get(ah.a.GGv, Integer.valueOf(0))).intValue();
    ac.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.tKA.Scene), Integer.valueOf(this.tKA.EVN), Integer.valueOf(this.tKA.EVO) });
    AppMethodBeat.o(25469);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(25470);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25470);
    return i;
  }
  
  public final int getType()
  {
    return 257;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25471);
    ac.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKB = ((bgu)((b)paramq).hvs.hvw);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.tKB;
      if (paramq != null) {
        ac.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { paramq.EVS, paramq.EVT, paramq.EVP, paramq.tLG, paramq.Title, paramq.Desc, paramq.EVQ, paramq.EVR, paramq.EVU, paramq.EWa });
      }
    }
    try
    {
      az.ayM();
      c.agA().set(ah.a.GHC, bs.cx(paramq.toByteArray()));
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(25471);
      return;
    }
    catch (IOException paramq)
    {
      for (;;)
      {
        ac.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[] { paramq.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */