package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.cus;
import com.tencent.mm.sdk.platformtools.ae;

public final class an
  extends n
  implements k
{
  private f callback;
  private final b rr;
  private cus vCA;
  
  public an(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65297);
    ae.i("MicroMsg.NetSceneLuckyMoneyReport", "NetSceneLuckyMoneyReport() sendId:%s unique_id:%s reportType:%s sendUsername:%s recvUserName:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    b.a locala = new b.a();
    cur localcur = new cur();
    localcur.vwq = paramString1;
    localcur.HsZ = paramString2;
    localcur.dGC = paramInt;
    localcur.vAE = paramString3;
    localcur.HFt = paramString4;
    locala.hQF = localcur;
    locala.hQG = new cus();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/wxhbreport";
    locala.funcId = 2715;
    this.rr = locala.aDS();
    AppMethodBeat.o(65297);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(65298);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(65298);
    return i;
  }
  
  public final int getType()
  {
    return 2715;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65299);
    ae.w("MicroMsg.NetSceneLuckyMoneyReport", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.vCA = ((cus)((b)paramq).hQE.hQJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(65299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.an
 * JD-Core Version:    0.7.0.1
 */