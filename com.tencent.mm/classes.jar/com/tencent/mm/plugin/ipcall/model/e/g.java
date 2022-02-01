package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class g
  extends q
  implements m
{
  private i callback;
  private d rr;
  private bye yrA;
  public byf yrB;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.yrA = null;
    this.yrB = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bye();
    ((d.a)localObject).iLO = new byf();
    ((d.a)localObject).funcId = 257;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    this.yrA = ((bye)this.rr.iLK.iLR);
    this.yrA.Scene = paramInt;
    localObject = this.yrA;
    bg.aVF();
    ((bye)localObject).MdE = ((Integer)c.azQ().get(ar.a.NVy, Integer.valueOf(0))).intValue();
    localObject = this.yrA;
    bg.aVF();
    ((bye)localObject).MdF = ((Integer)c.azQ().get(ar.a.NVm, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.yrA.Scene), Integer.valueOf(this.yrA.MdE), Integer.valueOf(this.yrA.MdF) });
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
    this.yrB = ((byf)((d)params).iLL.iLR);
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.yrB;
      if (params != null) {
        Log.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { params.MdJ, params.MdK, params.MdG, params.xJH, params.Title, params.Desc, params.MdH, params.MdI, params.MdL, params.MdR });
      }
    }
    try
    {
      bg.aVF();
      c.azQ().set(ar.a.NWt, Util.encodeHexString(params.toByteArray()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */