package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ae;

public final class bp
  extends n
  implements k
{
  private f callback;
  private final b hKp;
  public int hKq;
  public int hKr;
  public int hKs;
  public int type;
  
  public bp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.hKq = 0;
    this.hKr = 0;
    this.hKs = 0;
    this.type = 0;
    xn localxn = new xn();
    localxn.Scene = paramInt;
    localxn.Gpn = paramString1;
    localxn.uQx = paramString2;
    localxn.Gpo = paramString3;
    localxn.Gps = paramString4;
    localxn.Gpr = paramString5;
    paramString1 = new b.a();
    paramString1.hQF = localxn;
    paramString1.hQG = new xo();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.hQH = 0;
    paramString1.respCmdId = 0;
    this.hKp = paramString1.aDS();
    this.hKp.option = 1;
    ae.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localxn.Gpn, localxn.uQx, localxn.Gpo, localxn.Gps, localxn.Gpr });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127600);
    this.callback = paramf;
    int i = dispatch(parame, this.hKp, this);
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
    ae.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (xo)this.hKp.hQE.hQJ;
      this.hKq = paramq.Gpv;
      this.hKr = paramq.Gpu;
      this.type = paramq.nJA;
      this.hKs = paramq.Gpt;
      ae.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(paramq.Gpu), Integer.valueOf(paramq.Gpt), Integer.valueOf(paramq.Gpv) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bp
 * JD-Core Version:    0.7.0.1
 */