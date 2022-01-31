package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.platformtools.ab;

public final class al
  extends m
  implements k
{
  private f callback;
  private bua opv;
  private final b rr;
  
  public al(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(42409);
    ab.i("MicroMsg.NetSceneLuckyMoneyReport", "NetSceneLuckyMoneyReport() sendId:%s unique_id:%s reportType:%s sendUsername:%s recvUserName:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    b.a locala = new b.a();
    btz localbtz = new btz();
    localbtz.ojA = paramString1;
    localbtz.xxV = paramString2;
    localbtz.cFd = paramInt;
    localbtz.onN = paramString3;
    localbtz.xHq = paramString4;
    locala.fsX = localbtz;
    locala.fsY = new bua();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/wxhbreport";
    locala.funcId = 2715;
    this.rr = locala.ado();
    AppMethodBeat.o(42409);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(42410);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(42410);
    return i;
  }
  
  public final int getType()
  {
    return 2715;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(42411);
    ab.w("MicroMsg.NetSceneLuckyMoneyReport", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.opv = ((bua)((b)paramq).fsW.fta);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(42411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.al
 * JD-Core Version:    0.7.0.1
 */