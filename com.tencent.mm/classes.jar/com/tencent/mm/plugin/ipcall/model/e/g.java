package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;

public final class g
  extends p
  implements m
{
  private cwb JIM;
  public cwc JIN;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(25469);
    this.rr = null;
    this.JIM = null;
    this.JIN = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cwb();
    ((c.a)localObject).otF = new cwc();
    ((c.a)localObject).funcId = 257;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getwechatoutcoupons";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.JIM = ((cwb)c.b.b(this.rr.otB));
    this.JIM.IJG = paramInt;
    localObject = this.JIM;
    bh.bCz();
    ((cwb)localObject).aaBl = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acKS, Integer.valueOf(0))).intValue();
    localObject = this.JIM;
    bh.bCz();
    ((cwb)localObject).aaBm = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acKG, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.NetSceneIPCallGetWeChatOutCoupons", "NetSceneIPCallGetWeChatOutCoupons Scene:%d, RechargeWordingVersion:%d,AccountActivityWordingVersion:%d", new Object[] { Integer.valueOf(this.JIM.IJG), Integer.valueOf(this.JIM.aaBl), Integer.valueOf(this.JIM.aaBm) });
    AppMethodBeat.o(25469);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(25470);
    this.callback = paramh;
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
    this.JIN = ((cwc)c.c.b(((com.tencent.mm.am.c)params).otC));
    if (((paramInt2 == 0) || (paramInt3 == 0)) && (paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.JIN;
      if (params != null) {
        Log.i("MicroMsg.IPCallUtil", "[royle]begin save response,Balance:%s,PVWording:%s,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,SmsDesc:%s,PackageMsg:%s", new Object[] { params.aaBq, params.aaBr, params.aaBn, params.IHZ, params.hAP, params.IGG, params.aaBo, params.aaBp, params.aaBs, params.aaBy });
      }
    }
    try
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLN, Util.encodeHexString(params.toByteArray()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.g
 * JD-Core Version:    0.7.0.1
 */