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
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.qr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class l
  extends n
  implements k
{
  private f callback;
  private String dld;
  private String keN;
  private b nWZ;
  private cye nXa;
  private long nXb;
  private int offset;
  private int scene;
  
  public l(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.dld = paramString1;
    this.nXb = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.keN = paramString2;
    ad.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final qr bNO()
  {
    if (this.nXa == null) {
      return null;
    }
    return this.nXa.Hpw;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5589);
    this.callback = paramf;
    if (!bt.isNullOrNil(this.dld))
    {
      paramf = new b.a();
      paramf.funcId = 1071;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramf.hNM = new cyd();
      paramf.hNN = new cye();
      paramf.hNO = 0;
      paramf.respCmdId = 0;
      this.nWZ = paramf.aDC();
      paramf = (cyd)this.nWZ.hNK.hNQ;
      paramf.GRt = e.bNG();
      paramf.Gxj = this.dld;
      paramf.FMq = this.nXb;
      paramf.FMu = this.offset;
      paramf.Hpu = this.scene;
      paramf.FMt = this.keN;
      int i = dispatch(parame, this.nWZ, this);
      AppMethodBeat.o(5589);
      return i;
    }
    ad.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
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
    ad.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.nWZ != null)) {
      this.nXa = ((cye)this.nWZ.hNL.hNQ);
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