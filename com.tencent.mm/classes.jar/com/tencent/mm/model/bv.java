package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.sdk.platformtools.Log;

public final class bv
  extends p
  implements m
{
  private h callback;
  private final c omC;
  public int omD;
  public int omE;
  public int omF;
  public int type;
  
  public bv(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.omD = 0;
    this.omE = 0;
    this.omF = 0;
    this.type = 0;
    aba localaba = new aba();
    localaba.IJG = paramInt;
    localaba.Zjq = paramString1;
    localaba.Jmq = paramString2;
    localaba.Zjr = paramString3;
    localaba.Zjv = paramString4;
    localaba.Zju = paramString5;
    paramString1 = new c.a();
    paramString1.otE = localaba;
    paramString1.otF = new abb();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.otG = 0;
    paramString1.respCmdId = 0;
    this.omC = paramString1.bEF();
    this.omC.option = 1;
    Log.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localaba.Zjq, localaba.Jmq, localaba.Zjr, localaba.Zjv, localaba.Zju });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(127600);
    this.callback = paramh;
    int i = dispatch(paramg, this.omC, this);
    AppMethodBeat.o(127600);
    return i;
  }
  
  public final int getType()
  {
    return 813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127601);
    Log.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (abb)c.c.b(this.omC.otC);
      this.omD = params.Zjy;
      this.omE = params.Zjx;
      this.type = params.vhJ;
      this.omF = params.Zjw;
      Log.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(params.Zjx), Integer.valueOf(params.Zjw), Integer.valueOf(params.Zjy) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bv
 * JD-Core Version:    0.7.0.1
 */