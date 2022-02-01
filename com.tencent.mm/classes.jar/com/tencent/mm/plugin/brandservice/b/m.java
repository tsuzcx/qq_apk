package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class m
  extends n
  implements k
{
  private String cZL;
  private g callback;
  private b nvB;
  private long nvD;
  public cte nvE;
  private int scene;
  
  public m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.cZL = paramString;
    this.nvD = paramLong;
    this.scene = paramInt;
    ac.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(5592);
    ac.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = paramg;
    if (!bs.isNullOrNil(this.cZL))
    {
      paramg = new b.a();
      paramg.funcId = 1070;
      paramg.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramg.hvt = new ctd();
      paramg.hvu = new cte();
      paramg.reqCmdId = 0;
      paramg.respCmdId = 0;
      this.nvB = paramg.aAz();
      paramg = (ctd)this.nvB.hvr.hvw;
      paramg.EOf = this.cZL;
      paramg.FhT = e.bJn();
      paramg.EfR = this.nvD;
      paramg.FEV = this.scene;
      ac.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.nvD) });
      int i = dispatch(parame, this.nvB, this);
      AppMethodBeat.o(5592);
      return i;
    }
    ac.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
    AppMethodBeat.o(5592);
    return -1;
  }
  
  public final int getType()
  {
    return 1070;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5591);
    ac.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.nvB != null)) {
      this.nvE = ((cte)this.nvB.hvs.hvw);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.m
 * JD-Core Version:    0.7.0.1
 */