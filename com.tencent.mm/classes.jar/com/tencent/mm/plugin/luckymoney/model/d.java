package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.crh;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends com.tencent.mm.am.b<cri>
{
  public d(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(283966);
    Log.i("MicroMsg.CgiGetRedpacketFission", "packetId: %s senderUsername：%s msgCreateTime:%s,packetSource：%s sceneType:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    crh localcrh = new crh();
    c.a locala = new c.a();
    locala.otE = localcrh;
    locala.otF = new cri();
    locala.funcId = 6957;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketfission";
    localcrh.nQE = paramString1;
    localcrh.aaxU = paramString2;
    localcrh.aaxV = paramInt1;
    localcrh.nQF = paramInt2;
    localcrh.scene_type = paramInt3;
    if (!Util.isNullOrNil(paramString3)) {
      localcrh.aaxW = com.tencent.mm.bx.b.cX(paramString3.getBytes());
    }
    c(locala.bEF());
    AppMethodBeat.o(283966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.d
 * JD-Core Version:    0.7.0.1
 */