package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yz;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.Log;

public final class bt
  extends q
  implements m
{
  private i callback;
  private final d iFd;
  public int iFe;
  public int iFf;
  public int iFg;
  public int type;
  
  public bt(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.iFe = 0;
    this.iFf = 0;
    this.iFg = 0;
    this.type = 0;
    yz localyz = new yz();
    localyz.Scene = paramInt;
    localyz.LjZ = paramString1;
    localyz.yiZ = paramString2;
    localyz.Lka = paramString3;
    localyz.Lke = paramString4;
    localyz.Lkd = paramString5;
    paramString1 = new d.a();
    paramString1.iLN = localyz;
    paramString1.iLO = new za();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.iLP = 0;
    paramString1.respCmdId = 0;
    this.iFd = paramString1.aXF();
    this.iFd.option = 1;
    Log.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localyz.LjZ, localyz.yiZ, localyz.Lka, localyz.Lke, localyz.Lkd });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127600);
    this.callback = parami;
    int i = dispatch(paramg, this.iFd, this);
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
      params = (za)this.iFd.iLL.iLR;
      this.iFe = params.Lkh;
      this.iFf = params.Lkg;
      this.type = params.oUv;
      this.iFg = params.Lkf;
      Log.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(params.Lkg), Integer.valueOf(params.Lkf), Integer.valueOf(params.Lkh) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bt
 * JD-Core Version:    0.7.0.1
 */