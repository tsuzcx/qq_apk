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
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class l
  extends n
  implements k
{
  private String cZL;
  private g callback;
  private String jKB;
  private b nvB;
  private csu nvC;
  private long nvD;
  private int offset;
  private int scene;
  
  public l(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.cZL = paramString1;
    this.nvD = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.jKB = paramString2;
    ac.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final pm bJv()
  {
    if (this.nvC == null) {
      return null;
    }
    return this.nvC.FEX;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(5589);
    this.callback = paramg;
    if (!bs.isNullOrNil(this.cZL))
    {
      paramg = new b.a();
      paramg.funcId = 1071;
      paramg.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramg.hvt = new cst();
      paramg.hvu = new csu();
      paramg.reqCmdId = 0;
      paramg.respCmdId = 0;
      this.nvB = paramg.aAz();
      paramg = (cst)this.nvB.hvr.hvw;
      paramg.FhT = e.bJn();
      paramg.EOf = this.cZL;
      paramg.EfR = this.nvD;
      paramg.EfV = this.offset;
      paramg.FEV = this.scene;
      paramg.EfU = this.jKB;
      int i = dispatch(parame, this.nvB, this);
      AppMethodBeat.o(5589);
      return i;
    }
    ac.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
    AppMethodBeat.o(5589);
    return -1;
  }
  
  public final int getType()
  {
    return 1071;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5588);
    ac.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.nvB != null)) {
      this.nvC = ((csu)this.nvB.hvs.hvw);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */