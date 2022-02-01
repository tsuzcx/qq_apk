package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class m
  extends n
  implements k
{
  private g callback;
  private String dcm;
  private String jko;
  private b mTj;
  private cnn mTk;
  private long mTl;
  private int offset;
  private int scene;
  
  public m(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(5587);
    this.dcm = paramString1;
    this.mTl = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.jko = paramString2;
    ad.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(5587);
  }
  
  public final pf bCs()
  {
    if (this.mTk == null) {
      return null;
    }
    return this.mTk.EhZ;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(5589);
    this.callback = paramg;
    if (!bt.isNullOrNil(this.dcm))
    {
      paramg = new b.a();
      paramg.funcId = 1071;
      paramg.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramg.gUU = new cnm();
      paramg.gUV = new cnn();
      paramg.reqCmdId = 0;
      paramg.respCmdId = 0;
      this.mTj = paramg.atI();
      paramg = (cnm)this.mTj.gUS.gUX;
      paramg.DLE = f.bCk();
      paramg.Dtb = this.dcm;
      paramg.CNp = this.mTl;
      paramg.CNt = this.offset;
      paramg.EhX = this.scene;
      paramg.CNs = this.jko;
      int i = dispatch(parame, this.mTj, this);
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
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.mTj != null)) {
      this.mTk = ((cnn)this.mTj.gUT.gUX);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.m
 * JD-Core Version:    0.7.0.1
 */