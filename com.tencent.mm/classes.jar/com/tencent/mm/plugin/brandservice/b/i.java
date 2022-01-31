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
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
  extends m
  implements k
{
  private f callback;
  private String cnv;
  private com.tencent.mm.ai.b jSR;
  private long jST;
  public bxt jSU;
  private int scene;
  
  public i(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(13849);
    this.cnv = paramString;
    this.jST = paramLong;
    this.scene = paramInt;
    ab.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(13849);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(13851);
    ab.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = paramf;
    if (!bo.isNullOrNil(this.cnv))
    {
      paramf = new b.a();
      paramf.funcId = 1070;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramf.fsX = new bxs();
      paramf.fsY = new bxt();
      paramf.reqCmdId = 0;
      paramf.respCmdId = 0;
      this.jSR = paramf.ado();
      paramf = (bxs)this.jSR.fsV.fta;
      paramf.xba = this.cnv;
      paramf.xqU = b.acv();
      paramf.wBW = this.jST;
      paramf.xKm = this.scene;
      ab.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.jST) });
      int i = dispatch(parame, this.jSR, this);
      AppMethodBeat.o(13851);
      return i;
    }
    ab.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
    AppMethodBeat.o(13851);
    return -1;
  }
  
  public final int getType()
  {
    return 1070;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13850);
    ab.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.jSR != null)) {
      this.jSU = ((bxt)this.jSR.fsW.fta);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(13850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.i
 * JD-Core Version:    0.7.0.1
 */