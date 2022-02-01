package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.f callback;
  private ArrayList<String> pFx;
  private final b rr;
  
  public d(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(108671);
    b.a locala = new b.a();
    locala.hNM = new jj();
    locala.hNN = new jk();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
    locala.funcId = 696;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pFx = paramArrayList;
    AppMethodBeat.o(108671);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(108673);
    this.callback = paramf;
    ((jj)this.rr.hNK.hNQ).FAs = new LinkedList(this.pFx);
    if ((this.pFx == null) || (this.pFx.size() <= 0))
    {
      ad.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
      com.tencent.mm.kernel.g.ajC().ajl().set(348162, Boolean.FALSE);
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
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqn, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 4L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqn, Boolean.FALSE);
      paramq = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn;
      paramArrayOfByte = this.pFx;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
      {
        ad.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 2L, 1L, false);
      }
    }
    for (;;)
    {
      paramq = (jk)this.rr.hNL.hNQ;
      if ((paramq.FAv != null) && (paramq.FAv.size() > 0))
      {
        ad.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
        com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.bn(paramq.FAv);
        com.tencent.mm.kernel.g.ajC().ajl().set(348165, Boolean.TRUE);
        a.kq(true);
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
      localStringBuilder.append(EmojiInfo.Off);
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
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(164L, 3L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.d
 * JD-Core Version:    0.7.0.1
 */