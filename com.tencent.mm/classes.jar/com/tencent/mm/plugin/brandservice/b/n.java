package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.cnx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  private g callback;
  private String dcm;
  private b mTj;
  private long mTl;
  public cnx mTm;
  private int scene;
  
  public n(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.dcm = paramString;
    this.mTl = paramLong;
    this.scene = paramInt;
    ad.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(5592);
    ad.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = paramg;
    if (!bt.isNullOrNil(this.dcm))
    {
      paramg = new b.a();
      paramg.funcId = 1070;
      paramg.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramg.gUU = new cnw();
      paramg.gUV = new cnx();
      paramg.reqCmdId = 0;
      paramg.respCmdId = 0;
      this.mTj = paramg.atI();
      paramg = (cnw)this.mTj.gUS.gUX;
      paramg.Dtb = this.dcm;
      paramg.DLE = f.bCk();
      paramg.CNp = this.mTl;
      paramg.EhX = this.scene;
      ad.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.mTl) });
      int i = dispatch(parame, this.mTj, this);
      AppMethodBeat.o(5592);
      return i;
    }
    ad.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
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
    ad.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.mTj != null)) {
      this.mTm = ((cnx)this.mTj.gUT.gUX);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.n
 * JD-Core Version:    0.7.0.1
 */