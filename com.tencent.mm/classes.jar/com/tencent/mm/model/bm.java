package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.sdk.platformtools.ac;

public final class bm
  extends n
  implements k
{
  private g callback;
  private final b hpf;
  public int hpg;
  public int hph;
  public int hpi;
  public int type;
  
  public bm(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.hpg = 0;
    this.hph = 0;
    this.hpi = 0;
    this.type = 0;
    vl localvl = new vl();
    localvl.Scene = paramInt;
    localvl.EpD = paramString1;
    localvl.tCb = paramString2;
    localvl.EpE = paramString3;
    localvl.EpI = paramString4;
    localvl.EpH = paramString5;
    paramString1 = new b.a();
    paramString1.hvt = localvl;
    paramString1.hvu = new vm();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.hpf = paramString1.aAz();
    this.hpf.option = 1;
    ac.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localvl.EpD, localvl.tCb, localvl.EpE, localvl.EpI, localvl.EpH });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127600);
    this.callback = paramg;
    int i = dispatch(parame, this.hpf, this);
    AppMethodBeat.o(127600);
    return i;
  }
  
  public final int getType()
  {
    return 813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127601);
    ac.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (vm)this.hpf.hvs.hvw;
      this.hpg = paramq.EpL;
      this.hph = paramq.EpK;
      this.type = paramq.ndI;
      this.hpi = paramq.EpJ;
      ac.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(paramq.EpK), Integer.valueOf(paramq.EpJ), Integer.valueOf(paramq.EpL) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bm
 * JD-Core Version:    0.7.0.1
 */