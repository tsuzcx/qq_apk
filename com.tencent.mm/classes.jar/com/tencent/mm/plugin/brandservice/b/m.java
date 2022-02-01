package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
  extends n
  implements k
{
  private f callback;
  private String dld;
  private b nWZ;
  private long nXb;
  public cyo nXc;
  private int scene;
  
  public m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.dld = paramString;
    this.nXb = paramLong;
    this.scene = paramInt;
    ad.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5592);
    ad.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = paramf;
    if (!bt.isNullOrNil(this.dld))
    {
      paramf = new b.a();
      paramf.funcId = 1070;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramf.hNM = new cyn();
      paramf.hNN = new cyo();
      paramf.hNO = 0;
      paramf.respCmdId = 0;
      this.nWZ = paramf.aDC();
      paramf = (cyn)this.nWZ.hNK.hNQ;
      paramf.Gxj = this.dld;
      paramf.GRt = e.bNG();
      paramf.FMq = this.nXb;
      paramf.Hpu = this.scene;
      ad.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.nXb) });
      int i = dispatch(parame, this.nWZ, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.nWZ != null)) {
      this.nXc = ((cyo)this.nWZ.hNL.hNQ);
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