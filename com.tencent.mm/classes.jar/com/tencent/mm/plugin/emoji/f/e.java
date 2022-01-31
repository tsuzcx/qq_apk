package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.gi;
import com.tencent.mm.protocal.c.gj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private ArrayList<String> iZv;
  
  public e(ArrayList<String> paramArrayList)
  {
    b.a locala = new b.a();
    locala.ecH = new gi();
    locala.ecI = new gj();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
    locala.ecG = 696;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZv = paramArrayList;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    ((gi)this.dmK.ecE.ecN).syU = new LinkedList(this.iZv);
    if ((this.iZv == null) || (this.iZv.size() <= 0))
    {
      y.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
      g.DP().Dz().o(348162, Boolean.valueOf(false));
      return -1;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      y.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
      g.DP().Dz().c(ac.a.unV, Boolean.valueOf(true));
      h.nFQ.a(164L, 4L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.DP().Dz().c(ac.a.unV, Boolean.valueOf(false));
      paramq = i.getEmojiStorageMgr().uBb;
      paramArrayOfByte = this.iZv;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
      {
        y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
        h.nFQ.a(164L, 2L, 1L, false);
      }
    }
    for (;;)
    {
      paramq = (gj)this.dmK.ecF.ecN;
      if ((paramq.syW != null) && (paramq.syW.size() > 0))
      {
        y.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
        i.getEmojiStorageMgr().uBb.aB(paramq.syW);
        g.DP().Dz().o(348165, Boolean.valueOf(true));
        a.fb(true);
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[] { Integer.valueOf(paramArrayOfByte.size()) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UPDATE");
      localStringBuilder.append(" EmojiInfo ");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("source");
      localStringBuilder.append("=");
      localStringBuilder.append(EmojiInfo.uDl);
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
      y.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
      paramq.dXw.gk("EmojiInfo", localStringBuilder.toString());
      break;
      h.nFQ.a(164L, 3L, 1L, false);
    }
  }
  
  public final int getType()
  {
    return 696;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.e
 * JD-Core Version:    0.7.0.1
 */