package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q
  extends n
  implements k
{
  private g gfX;
  public String pbW;
  private int pcB;
  private final b rr;
  
  public q(String paramString, int paramInt)
  {
    AppMethodBeat.i(108719);
    this.pbW = paramString;
    if ((!bs.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.Jsp)))) {
      this.pbW = "com.tencent.xin.emoticon.tusiji";
    }
    this.pcB = paramInt;
    paramString = new b.a();
    paramString.hvt = new bvf();
    paramString.hvu = new bvg();
    paramString.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    paramString.funcId = 413;
    paramString.reqCmdId = 212;
    paramString.respCmdId = 1000000212;
    this.rr = paramString.aAz();
    AppMethodBeat.o(108719);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108720);
    this.gfX = paramg;
    paramg = (bvf)this.rr.hvr.hvw;
    paramg.ProductID = this.pbW;
    paramg.OpCode = this.pcB;
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
    ac.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.pcB == 1)
      {
        h.wUl.idkeyStat(165L, 3L, 1L, false);
        ac.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(108721);
        return;
      }
      h.wUl.idkeyStat(165L, 5L, 1L, false);
      ac.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.pbW });
      AppMethodBeat.o(108721);
      return;
    }
    if (this.pcB == 1) {
      h.wUl.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108721);
      return;
      h.wUl.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */