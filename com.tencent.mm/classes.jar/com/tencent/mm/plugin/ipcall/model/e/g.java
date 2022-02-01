package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;

public final class g
  extends n
  implements k
{
  private f callback;
  private b rr;
  private blt uZa;
  public blu uZb;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.uZa = null;
    this.uZb = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new blt();
    ((b.a)localObject).hQG = new blu();
    ((b.a)localObject).funcId = 257;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    this.uZa = ((blt)this.rr.hQD.hQJ);
    this.uZa.Scene = paramInt;
    localObject = this.uZa;
    bc.aCg();
    ((blt)localObject).GYM = ((Integer)c.ajA().get(am.a.INv, Integer.valueOf(0))).intValue();
    localObject = this.uZa;
    bc.aCg();
    ((blt)localObject).GYN = ((Integer)c.ajA().get(am.a.INj, Integer.valueOf(0))).intValue();
    ae.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.uZa.Scene), Integer.valueOf(this.uZa.GYM), Integer.valueOf(this.uZa.GYN) });
    AppMethodBeat.o(25469);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25470);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZb = ((blu)((b)paramq).hQE.hQJ);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.uZb;
      if (paramq != null) {
        ae.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { paramq.GYR, paramq.GYS, paramq.GYO, paramq.urq, paramq.Title, paramq.Desc, paramq.GYP, paramq.GYQ, paramq.GYT, paramq.GYZ });
      }
    }
    try
    {
      bc.aCg();
      c.ajA().set(am.a.IOr, bu.cH(paramq.toByteArray()));
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
        ae.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[] { paramq.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */