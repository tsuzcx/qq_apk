package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.sdk.platformtools.ab;

public final class bj
  extends m
  implements k
{
  private f callback;
  private final b fnd;
  public int fne;
  public int fnf;
  public int fng;
  public int type;
  
  public bj(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(50498);
    this.fne = 0;
    this.fnf = 0;
    this.fng = 0;
    this.type = 0;
    sj localsj = new sj();
    localsj.Scene = paramInt;
    localsj.wKH = paramString1;
    localsj.nGG = paramString2;
    localsj.wKI = paramString3;
    paramString1 = new b.a();
    paramString1.fsX = localsj;
    paramString1.fsY = new sk();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.fnd = paramString1.ado();
    this.fnd.option = 1;
    ab.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s]", new Object[] { Integer.valueOf(paramInt), localsj.wKH, localsj.nGG, localsj.wKI });
    AppMethodBeat.o(50498);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(50499);
    this.callback = paramf;
    int i = dispatch(parame, this.fnd, this);
    AppMethodBeat.o(50499);
    return i;
  }
  
  public final int getType()
  {
    return 813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50500);
    ab.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (sk)this.fnd.fsW.fta;
      this.fne = paramq.wKN;
      this.fnf = paramq.wKM;
      this.type = paramq.jKs;
      this.fng = paramq.wKL;
      ab.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(paramq.wKM), Integer.valueOf(paramq.wKL), Integer.valueOf(paramq.wKN) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(50500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bj
 * JD-Core Version:    0.7.0.1
 */