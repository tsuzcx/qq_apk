package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.sdk.platformtools.ad;

public final class an
  extends n
  implements k
{
  private f callback;
  private final b rr;
  private cty vqv;
  
  public an(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65297);
    ad.i("MicroMsg.NetSceneLuckyMoneyReport", "NetSceneLuckyMoneyReport() sendId:%s unique_id:%s reportType:%s sendUsername:%s recvUserName:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    b.a locala = new b.a();
    ctx localctx = new ctx();
    localctx.vkl = paramString1;
    localctx.GZy = paramString2;
    localctx.dFx = paramInt;
    localctx.voz = paramString3;
    localctx.HlT = paramString4;
    locala.hNM = localctx;
    locala.hNN = new cty();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/wxhbreport";
    locala.funcId = 2715;
    this.rr = locala.aDC();
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
    ad.w("MicroMsg.NetSceneLuckyMoneyReport", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.vqv = ((cty)((b)paramq).hNL.hNQ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(65299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.an
 * JD-Core Version:    0.7.0.1
 */