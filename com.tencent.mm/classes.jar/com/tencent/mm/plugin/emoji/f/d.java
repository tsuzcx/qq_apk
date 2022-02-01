package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private ArrayList<String> oyn;
  private final b rr;
  
  public d(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(108671);
    b.a locala = new b.a();
    locala.gUU = new iu();
    locala.gUV = new iv();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
    locala.funcId = 696;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.oyn = paramArrayList;
    AppMethodBeat.o(108671);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108673);
    this.callback = paramg;
    ((iu)this.rr.gUS.gUX).CCA = new LinkedList(this.oyn);
    if ((this.oyn == null) || (this.oyn.size() <= 0))
    {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
      com.tencent.mm.kernel.g.afB().afk().set(348162, Boolean.FALSE);
      AppMethodBeat.o(108673);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108673);
    return i;
  }
  
  public final int getType()
  {
    return 696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108672);
    ad.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      ad.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgg, Boolean.TRUE);
      h.vKh.idkeyStat(164L, 4L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgg, Boolean.FALSE);
      paramq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY;
      paramArrayOfByte = this.oyn;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
      {
        ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
        h.vKh.idkeyStat(164L, 2L, 1L, false);
      }
    }
    for (;;)
    {
      paramq = (iv)this.rr.gUT.gUX;
      if ((paramq.CCD != null) && (paramq.CCD.size() > 0))
      {
        ad.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.bf(paramq.CCD);
        com.tencent.mm.kernel.g.afB().afk().set(348165, Boolean.TRUE);
        a.jC(true);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108672);
      return;
      ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[] { Integer.valueOf(paramArrayOfByte.size()) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UPDATE");
      localStringBuilder.append(" EmojiInfo ");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("source");
      localStringBuilder.append("=");
      localStringBuilder.append(EmojiInfo.LCi);
      localStringBuilder.append(" where ");
      localStringBuilder.append("md5");
      localStringBuilder.append(" IN (");
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfByte.size())
      {
        localStringBuilder.append("'" + (String)paramArrayOfByte.get(paramInt1) + "'");
        if (paramInt1 < paramArrayOfByte.size() - 1) {
          localStringBuilder.append(",");
        }
        paramInt1 += 1;
      }
      localStringBuilder.append(")");
      ad.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
      paramq.db.execSQL("EmojiInfo", localStringBuilder.toString());
      break;
      h.vKh.idkeyStat(164L, 3L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.d
 * JD-Core Version:    0.7.0.1
 */