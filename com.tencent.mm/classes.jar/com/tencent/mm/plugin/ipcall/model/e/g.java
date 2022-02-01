package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;

public final class g
  extends n
  implements k
{
  private f callback;
  private b rr;
  private blb uNn;
  public blc uNo;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.uNn = null;
    this.uNo = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new blb();
    ((b.a)localObject).hNN = new blc();
    ((b.a)localObject).funcId = 257;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.uNn = ((blb)this.rr.hNK.hNQ);
    this.uNn.Scene = paramInt;
    localObject = this.uNn;
    ba.aBQ();
    ((blb)localObject).GFk = ((Integer)c.ajl().get(al.a.IsZ, Integer.valueOf(0))).intValue();
    localObject = this.uNn;
    ba.aBQ();
    ((blb)localObject).GFl = ((Integer)c.ajl().get(al.a.IsN, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.uNn.Scene), Integer.valueOf(this.uNn.GFk), Integer.valueOf(this.uNn.GFl) });
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
    ad.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNo = ((blc)((b)paramq).hNL.hNQ);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.uNo;
      if (paramq != null) {
        ad.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { paramq.GFp, paramq.GFq, paramq.GFm, paramq.uOt, paramq.Title, paramq.Desc, paramq.GFn, paramq.GFo, paramq.GFr, paramq.GFx });
      }
    }
    try
    {
      ba.aBQ();
      c.ajl().set(al.a.ItU, bt.cE(paramq.toByteArray()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */