package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q
  extends n
  implements k
{
  private f gCo;
  private int pMP;
  public String pMk;
  private final b rr;
  
  public q(String paramString, int paramInt)
  {
    AppMethodBeat.i(108719);
    this.pMk = paramString;
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.OzR)))) {
      this.pMk = "com.tencent.xin.emoticon.tusiji";
    }
    this.pMP = paramInt;
    b.a locala = new b.a();
    locala.hQF = new cao();
    locala.hQG = new cap();
    locala.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    locala.funcId = 413;
    locala.hQH = 212;
    locala.respCmdId = 1000000212;
    this.rr = locala.aDS();
    ae.i("MicroMsg.emoji.NetSceneModEmotionPack", "NetSceneModEmotionPack: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(108719);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108720);
    this.gCo = paramf;
    paramf = (cao)this.rr.hQD.hQJ;
    paramf.ProductID = this.pMk;
    paramf.OpCode = this.pMP;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108720);
    return i;
  }
  
  public final int getType()
  {
    return 413;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108721);
    ae.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.pMP == 1)
      {
        g.yxI.idkeyStat(165L, 3L, 1L, false);
        ae.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(108721);
        return;
      }
      g.yxI.idkeyStat(165L, 5L, 1L, false);
      ae.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.pMk });
      AppMethodBeat.o(108721);
      return;
    }
    if (this.pMP == 1) {
      g.yxI.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108721);
      return;
      g.yxI.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */