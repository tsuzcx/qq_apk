package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class r
  extends q
  implements m
{
  private i jQg;
  private final d rr;
  public String uFI;
  private int uGp;
  
  public r(String paramString, int paramInt)
  {
    AppMethodBeat.i(108719);
    this.uFI = paramString;
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.YCu)))) {
      this.uFI = "com.tencent.xin.emoticon.tusiji";
    }
    this.uGp = paramInt;
    d.a locala = new d.a();
    locala.lBU = new cyg();
    locala.lBV = new cyh();
    locala.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    locala.funcId = 413;
    locala.lBW = 212;
    locala.respCmdId = 1000000212;
    this.rr = locala.bgN();
    Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "NetSceneModEmotionPack: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(108719);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108720);
    this.jQg = parami;
    parami = (cyg)d.b.b(this.rr.lBR);
    parami.ProductID = this.uFI;
    parami.RLe = this.uGp;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108720);
    return i;
  }
  
  public final int getType()
  {
    return 413;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108721);
    Log.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.uGp == 1)
      {
        h.IzE.idkeyStat(165L, 3L, 1L, false);
        Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(108721);
        return;
      }
      h.IzE.idkeyStat(165L, 5L, 1L, false);
      Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.uFI });
      AppMethodBeat.o(108721);
      return;
    }
    if (this.uGp == 1) {
      h.IzE.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108721);
      return;
      h.IzE.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */