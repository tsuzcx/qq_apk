package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxj;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
  extends m
  implements k
{
  private f callback;
  private String cnv;
  private String hng;
  private com.tencent.mm.ai.b jSR;
  private bxj jSS;
  private long jST;
  private int offset;
  private int scene;
  
  public h(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(13846);
    this.cnv = paramString1;
    this.jST = paramLong;
    this.offset = paramInt1;
    this.scene = paramInt2;
    this.hng = paramString2;
    ab.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
    AppMethodBeat.o(13846);
  }
  
  public final nc aWt()
  {
    if (this.jSS == null) {
      return null;
    }
    return this.jSS.xKo;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(13848);
    this.callback = paramf;
    if (!bo.isNullOrNil(this.cnv))
    {
      paramf = new b.a();
      paramf.funcId = 1071;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
      paramf.fsX = new bxi();
      paramf.fsY = new bxj();
      paramf.reqCmdId = 0;
      paramf.respCmdId = 0;
      this.jSR = paramf.ado();
      paramf = (bxi)this.jSR.fsV.fta;
      paramf.xqU = b.acv();
      paramf.xba = this.cnv;
      paramf.wBW = this.jST;
      paramf.wzS = this.offset;
      paramf.xKm = this.scene;
      paramf.wBZ = this.hng;
      int i = dispatch(parame, this.jSR, this);
      AppMethodBeat.o(13848);
      return i;
    }
    ab.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
    AppMethodBeat.o(13848);
    return -1;
  }
  
  public final int getType()
  {
    return 1071;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13847);
    ab.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.jSR != null)) {
      this.jSS = ((bxj)this.jSR.fsW.fta);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(13847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.h
 * JD-Core Version:    0.7.0.1
 */