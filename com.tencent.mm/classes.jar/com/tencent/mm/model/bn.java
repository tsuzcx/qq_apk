package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.protocal.protobuf.xl;
import com.tencent.mm.sdk.platformtools.ad;

public final class bn
  extends n
  implements k
{
  private f callback;
  public int hHA;
  private final b hHx;
  public int hHy;
  public int hHz;
  public int type;
  
  public bn(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.hHy = 0;
    this.hHz = 0;
    this.hHA = 0;
    this.type = 0;
    xk localxk = new xk();
    localxk.Scene = paramInt;
    localxk.FWO = paramString1;
    localxk.uEK = paramString2;
    localxk.FWP = paramString3;
    localxk.FWT = paramString4;
    localxk.FWS = paramString5;
    paramString1 = new b.a();
    paramString1.hNM = localxk;
    paramString1.hNN = new xl();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.hNO = 0;
    paramString1.respCmdId = 0;
    this.hHx = paramString1.aDC();
    this.hHx.option = 1;
    ad.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localxk.FWO, localxk.uEK, localxk.FWP, localxk.FWT, localxk.FWS });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127600);
    this.callback = paramf;
    int i = dispatch(parame, this.hHx, this);
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
    ad.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (xl)this.hHx.hNL.hNQ;
      this.hHy = paramq.FWW;
      this.hHz = paramq.FWV;
      this.type = paramq.nEf;
      this.hHA = paramq.FWU;
      ad.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(paramq.FWV), Integer.valueOf(paramq.FWU), Integer.valueOf(paramq.FWW) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bn
 * JD-Core Version:    0.7.0.1
 */