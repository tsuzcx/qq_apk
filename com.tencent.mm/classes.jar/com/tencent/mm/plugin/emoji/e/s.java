package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class s
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  private final c rr;
  private int xOT;
  public String xOk;
  
  public s(String paramString, int paramInt)
  {
    AppMethodBeat.i(108719);
    this.xOk = paramString;
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.aklD)))) {
      this.xOk = "com.tencent.xin.emoticon.tusiji";
    }
    this.xOT = paramInt;
    c.a locala = new c.a();
    locala.otE = new dpm();
    locala.otF = new dpn();
    locala.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    locala.funcId = 413;
    locala.otG = 212;
    locala.respCmdId = 1000000212;
    this.rr = locala.bEF();
    Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "NetSceneModEmotionPack: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(108719);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108720);
    this.mAY = paramh;
    paramh = (dpm)c.b.b(this.rr.otB);
    paramh.ProductID = this.xOk;
    paramh.YIq = this.xOT;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108720);
    return i;
  }
  
  public final int getType()
  {
    return 413;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108721);
    Log.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.xOT == 1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 3L, 1L, false);
        Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(108721);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 5L, 1L, false);
      Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.xOk });
      AppMethodBeat.o(108721);
      return;
    }
    if (this.xOT == 1) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108721);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.s
 * JD-Core Version:    0.7.0.1
 */