package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class m
  extends n
  implements k
{
  private f callback;
  private String dmf;
  private b ocI;
  private long ocK;
  public czi ocL;
  private int scene;
  
  public m(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(5590);
    this.dmf = paramString;
    this.ocK = paramLong;
    this.scene = paramInt;
    ae.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(5590);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(5592);
    ae.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
    this.callback = paramf;
    if (!bu.isNullOrNil(this.dmf))
    {
      paramf = new b.a();
      paramf.funcId = 1070;
      paramf.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
      paramf.hQF = new czh();
      paramf.hQG = new czi();
      paramf.hQH = 0;
      paramf.respCmdId = 0;
      this.ocI = paramf.aDS();
      paramf = (czh)this.ocI.hQD.hQJ;
      paramf.GQJ = this.dmf;
      paramf.HkU = e.bOD();
      paramf.GeP = this.ocK;
      paramf.HIW = this.scene;
      ae.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", new Object[] { Long.valueOf(this.ocK) });
      int i = dispatch(parame, this.ocI, this);
      AppMethodBeat.o(5592);
      return i;
    }
    ae.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
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
    ae.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0) && (this.ocI != null)) {
      this.ocL = ((czi)this.ocI.hQE.hQJ);
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.m
 * JD-Core Version:    0.7.0.1
 */