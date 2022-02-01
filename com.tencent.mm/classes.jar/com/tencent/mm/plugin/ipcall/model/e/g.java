package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private b rr;
  private bdb sCS;
  public bdc sCT;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.sCS = null;
    this.sCT = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bdb();
    ((b.a)localObject).gUV = new bdc();
    ((b.a)localObject).funcId = 257;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    this.sCS = ((bdb)this.rr.gUS.gUX);
    this.sCS.Scene = paramInt;
    localObject = this.sCS;
    az.arV();
    ((bdb)localObject).DAr = ((Integer)c.afk().get(ae.a.FiS, Integer.valueOf(0))).intValue();
    localObject = this.sCS;
    az.arV();
    ((bdb)localObject).DAs = ((Integer)c.afk().get(ae.a.FiG, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.sCS.Scene), Integer.valueOf(this.sCS.DAr), Integer.valueOf(this.sCS.DAs) });
    AppMethodBeat.o(25469);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.sCT = ((bdc)((b)paramq).gUT.gUX);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.sCT;
      if (paramq != null) {
        ad.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { paramq.DAw, paramq.DAx, paramq.DAt, paramq.sDZ, paramq.Title, paramq.Desc, paramq.DAu, paramq.DAv, paramq.DAy, paramq.DAE });
      }
    }
    try
    {
      az.arV();
      c.afk().set(ae.a.FjN, bt.cy(paramq.toByteArray()));
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
        ad.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[] { paramq.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */