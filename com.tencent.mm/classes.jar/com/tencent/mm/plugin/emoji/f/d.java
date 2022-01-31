package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends m
  implements k
{
  private f callback;
  private ArrayList<String> lik;
  private final b rr;
  
  public d(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(53099);
    b.a locala = new b.a();
    locala.fsX = new hx();
    locala.fsY = new hy();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
    locala.funcId = 696;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.lik = paramArrayList;
    AppMethodBeat.o(53099);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53101);
    this.callback = paramf;
    ((hx)this.rr.fsV.fta).wsV = new LinkedList(this.lik);
    if ((this.lik == null) || (this.lik.size() <= 0))
    {
      ab.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
      g.RL().Ru().set(348162, Boolean.FALSE);
      AppMethodBeat.o(53101);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53101);
    return i;
  }
  
  public final int getType()
  {
    return 696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53100);
    ab.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      ab.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
      g.RL().Ru().set(ac.a.yxM, Boolean.TRUE);
      h.qsU.idkeyStat(164L, 4L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.RL().Ru().set(ac.a.yxM, Boolean.FALSE);
      paramq = i.getEmojiStorageMgr().yNn;
      paramArrayOfByte = this.lik;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
      {
        ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
        h.qsU.idkeyStat(164L, 2L, 1L, false);
      }
    }
    for (;;)
    {
      paramq = (hy)this.rr.fsW.fta;
      if ((paramq.wsY != null) && (paramq.wsY.size() > 0))
      {
        ab.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
        i.getEmojiStorageMgr().yNn.aL(paramq.wsY);
        g.RL().Ru().set(348165, Boolean.TRUE);
        a.gE(true);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53100);
      return;
      ab.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[] { Integer.valueOf(paramArrayOfByte.size()) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UPDATE");
      localStringBuilder.append(" EmojiInfo ");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("source");
      localStringBuilder.append("=");
      localStringBuilder.append(EmojiInfo.yPy);
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
      ab.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
      paramq.db.execSQL("EmojiInfo", localStringBuilder.toString());
      break;
      h.qsU.idkeyStat(164L, 3L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.d
 * JD-Core Version:    0.7.0.1
 */