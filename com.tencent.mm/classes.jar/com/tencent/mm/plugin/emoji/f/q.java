package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q
  extends n
  implements k
{
  private f gzH;
  public String pFG;
  private int pGl;
  private final b rr;
  
  public q(String paramString, int paramInt)
  {
    AppMethodBeat.i(108719);
    this.pFG = paramString;
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.OeK)))) {
      this.pFG = "com.tencent.xin.emoticon.tusiji";
    }
    this.pGl = paramInt;
    b.a locala = new b.a();
    locala.hNM = new bzu();
    locala.hNN = new bzv();
    locala.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    locala.funcId = 413;
    locala.hNO = 212;
    locala.respCmdId = 1000000212;
    this.rr = locala.aDC();
    ad.i("MicroMsg.emoji.NetSceneModEmotionPack", "NetSceneModEmotionPack: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(108719);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108720);
    this.gzH = paramf;
    paramf = (bzu)this.rr.hNK.hNQ;
    paramf.ProductID = this.pFG;
    paramf.OpCode = this.pGl;
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
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.pGl == 1)
      {
        g.yhR.idkeyStat(165L, 3L, 1L, false);
        ad.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(108721);
        return;
      }
      g.yhR.idkeyStat(165L, 5L, 1L, false);
      ad.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.pFG });
      AppMethodBeat.o(108721);
      return;
    }
    if (this.pGl == 1) {
      g.yhR.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108721);
      return;
      g.yhR.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */