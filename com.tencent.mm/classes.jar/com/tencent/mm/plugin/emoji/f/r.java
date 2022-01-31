package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.axh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class r
  extends m
  implements k
{
  private f dIJ;
  private final b dmK;
  public String iZD;
  private int jag;
  
  public r(String paramString, int paramInt)
  {
    this.iZD = paramString;
    if ((!bk.bl(paramString)) && (paramString.equals(String.valueOf(EmojiGroupInfo.uCQ)))) {
      this.iZD = "com.tencent.xin.emoticon.tusiji";
    }
    this.jag = paramInt;
    paramString = new b.a();
    paramString.ecH = new axg();
    paramString.ecI = new axh();
    paramString.uri = "/cgi-bin/micromsg-bin/modemotionpack";
    paramString.ecG = 413;
    paramString.ecJ = 212;
    paramString.ecK = 1000000212;
    this.dmK = paramString.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    paramf = (axg)this.dmK.ecE.ecN;
    paramf.syc = this.iZD;
    paramf.ssq = this.jag;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.jag == 1)
      {
        h.nFQ.a(165L, 3L, 1L, false);
        y.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
        return;
      }
      h.nFQ.a(165L, 5L, 1L, false);
      y.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", new Object[] { this.iZD });
      return;
    }
    if (this.jag == 1) {
      h.nFQ.a(165L, 2L, 1L, false);
    }
    for (;;)
    {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      h.nFQ.a(165L, 4L, 1L, false);
    }
  }
  
  public final int getType()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */