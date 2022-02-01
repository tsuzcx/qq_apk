package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class g
  extends q
  implements m
{
  private cfy DRC;
  public cfz DRD;
  private i callback;
  private d rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.DRC = null;
    this.DRD = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cfy();
    ((d.a)localObject).lBV = new cfz();
    ((d.a)localObject).funcId = 257;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    this.DRC = ((cfy)d.b.b(this.rr.lBR));
    this.DRC.CPw = paramInt;
    localObject = this.DRC;
    bh.beI();
    ((cfy)localObject).Tnf = ((Integer)c.aHp().get(ar.a.Vjy, Integer.valueOf(0))).intValue();
    localObject = this.DRC;
    bh.beI();
    ((cfy)localObject).Tng = ((Integer)c.aHp().get(ar.a.Vjm, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.DRC.CPw), Integer.valueOf(this.DRC.Tnf), Integer.valueOf(this.DRC.Tng) });
    AppMethodBeat.o(25469);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(25470);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25470);
    return i;
  }
  
  public final int getType()
  {
    return 257;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25471);
    Log.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.DRD = ((cfz)d.c.b(((d)params).lBS));
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.DRD;
      if (params != null) {
        Log.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { params.Tnk, params.Tnl, params.Tnh, params.CNP, params.fwr, params.CMB, params.Tni, params.Tnj, params.Tnm, params.Tns });
      }
    }
    try
    {
      bh.beI();
      c.aHp().set(ar.a.Vkt, Util.encodeHexString(params.toByteArray()));
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(25471);
      return;
    }
    catch (IOException params)
    {
      for (;;)
      {
        Log.i("MicroMsg.IPCallUtil", "[royle]save exception:%s", new Object[] { params.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */