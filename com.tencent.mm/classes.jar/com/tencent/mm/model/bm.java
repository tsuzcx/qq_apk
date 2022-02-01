package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.protocal.protobuf.vc;
import com.tencent.mm.sdk.platformtools.ad;

public final class bm
  extends n
  implements k
{
  private g callback;
  private final b gOF;
  public int gOG;
  public int gOH;
  public int gOI;
  public int type;
  
  public bm(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.gOG = 0;
    this.gOH = 0;
    this.gOI = 0;
    this.type = 0;
    vb localvb = new vb();
    localvb.Scene = paramInt;
    localvb.CWU = paramString1;
    localvb.sul = paramString2;
    localvb.CWV = paramString3;
    localvb.CWZ = paramString4;
    localvb.CWY = paramString5;
    paramString1 = new b.a();
    paramString1.gUU = localvb;
    paramString1.gUV = new vc();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.reqCmdId = 0;
    paramString1.respCmdId = 0;
    this.gOF = paramString1.atI();
    this.gOF.option = 1;
    ad.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localvb.CWU, localvb.sul, localvb.CWV, localvb.CWZ, localvb.CWY });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(127600);
    this.callback = paramg;
    int i = dispatch(parame, this.gOF, this);
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
      paramq = (vc)this.gOF.gUT.gUX;
      this.gOG = paramq.CXc;
      this.gOH = paramq.CXb;
      this.type = paramq.mBH;
      this.gOI = paramq.CXa;
      ad.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(paramq.CXb), Integer.valueOf(paramq.CXa), Integer.valueOf(paramq.CXc) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bm
 * JD-Core Version:    0.7.0.1
 */