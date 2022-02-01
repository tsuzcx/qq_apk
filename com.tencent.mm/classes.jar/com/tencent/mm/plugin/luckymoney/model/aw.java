package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dnk;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.sdk.platformtools.Log;

public final class aw
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private dnl yXB;
  
  public aw(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(65297);
    Log.i("MicroMsg.NetSceneLuckyMoneyReport", "NetSceneLuckyMoneyReport() sendId:%s unique_id:%s reportType:%s sendUsername:%s recvUserName:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), paramString3, paramString4 });
    d.a locala = new d.a();
    dnk localdnk = new dnk();
    localdnk.yQE = paramString1;
    localdnk.MBV = paramString2;
    localdnk.dYn = paramInt;
    localdnk.yVy = paramString3;
    localdnk.MQD = paramString4;
    locala.iLN = localdnk;
    locala.iLO = new dnl();
    locala.uri = "/cgi-bin/mmpay-bin/ftfhb/wxhbreport";
    locala.funcId = 2715;
    this.rr = locala.aXF();
    AppMethodBeat.o(65297);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65298);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(65298);
    return i;
  }
  
  public final int getType()
  {
    return 2715;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65299);
    Log.w("MicroMsg.NetSceneLuckyMoneyReport", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.yXB = ((dnl)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(65299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aw
 * JD-Core Version:    0.7.0.1
 */