package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q
  extends m
  implements k
{
  private f eGj;
  private int liX;
  public String liu;
  private final b rr;
  
  public q(String paramString, int paramInt)
  {
    AppMethodBeat.i(53147);
    this.liu = paramString;
    if ((!bo.isNullOrNil(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.yPd)))) {
      this.liu = "com.tencent.xin.emoticon.tusiji";
    }
    this.liX = paramInt;
    paramString = new b.a();
    paramString.fsX = new bdw();
    paramString.fsY = new bdx();
    paramString.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    paramString.funcId = 413;
    paramString.reqCmdId = 212;
    paramString.respCmdId = 1000000212;
    this.rr = paramString.ado();
    AppMethodBeat.o(53147);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(53148);
    this.eGj = paramf;
    paramf = (bdw)this.rr.fsV.fta;
    paramf.ProductID = this.liu;
    paramf.OpCode = this.liX;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53148);
    return i;
  }
  
  public final int getType()
  {
    return 413;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53149);
    ab.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.liX == 1)
      {
        h.qsU.idkeyStat(165L, 3L, 1L, false);
        ab.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        AppMethodBeat.o(53149);
        return;
      }
      h.qsU.idkeyStat(165L, 5L, 1L, false);
      ab.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.liu });
      AppMethodBeat.o(53149);
      return;
    }
    if (this.liX == 1) {
      h.qsU.idkeyStat(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53149);
      return;
      h.qsU.idkeyStat(165L, 4L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */