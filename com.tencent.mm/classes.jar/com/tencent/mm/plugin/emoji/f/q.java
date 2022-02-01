package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q
  extends n
  implements k
{
  private g gbr;
  public String oyw;
  private int ozb;
  private final b rr;
  
  public q(String paramString, int paramInt)
  {
    AppMethodBeat.i(108719);
    this.oyw = paramString;
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.LBN)))) {
      this.oyw = "com.tencent.xin.emoticon.tusiji";
    }
    this.ozb = paramInt;
    paramString = new b.a();
    paramString.gUU = new bqo();
    paramString.gUV = new bqp();
    paramString.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    paramString.funcId = 413;
    paramString.reqCmdId = 212;
    paramString.respCmdId = 1000000212;
    this.rr = paramString.atI();
    AppMethodBeat.o(108719);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108720);
    this.gbr = paramg;
    paramg = (bqo)this.rr.gUS.gUX;
    paramg.ProductID = this.oyw;
    paramg.OpCode = this.ozb;
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
    ad.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.ozb == 1)
      {
        h.vKh.idkeyStat(165L, 3L, 1L, false);
        ad.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(108721);
        return;
      }
      h.vKh.idkeyStat(165L, 5L, 1L, false);
      ad.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.oyw });
      AppMethodBeat.o(108721);
      return;
    }
    if (this.ozb == 1) {
      h.vKh.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108721);
      return;
      h.vKh.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */