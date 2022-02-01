package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddq;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.sdk.platformtools.Log;

public final class ag
  extends q
  implements m
{
  private i callback;
  public String content;
  public String dYs;
  public String lco;
  public String pUs;
  public String pUt;
  public boolean pUu;
  public String pUv;
  public String pUw;
  public String pUx;
  public String pUy;
  private final d rr;
  public int status;
  
  public ag(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(112855);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ddq();
    ((d.a)localObject).iLO = new ddr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
    ((d.a)localObject).funcId = 1171;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ddq)this.rr.iLK.iLR;
    ((ddq)localObject).KDl = paramInt;
    ((ddq)localObject).KDm = paramString1;
    ((ddq)localObject).KDn = paramString2;
    AppMethodBeat.o(112855);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112857);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112857);
    return i;
  }
  
  public final int getType()
  {
    return 1171;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112856);
    Log.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ddr)this.rr.iLL.iLR;
      this.dYs = params.KDq;
      this.pUs = params.KDr;
      this.status = params.status;
      this.content = params.content;
      this.pUt = params.pTK;
      this.lco = params.LFY;
      this.pUu = params.pUu;
      this.pUv = params.MIE;
      this.pUw = params.MIF;
      this.pUx = params.MIG;
      this.pUy = params.MIH;
      Log.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", new Object[] { this.dYs, this.pUs, Integer.valueOf(this.status), this.content, this.pUt, this.lco, Boolean.valueOf(this.pUu) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ag
 * JD-Core Version:    0.7.0.1
 */