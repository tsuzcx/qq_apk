package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.c.a;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends q
  implements m
{
  private i callback;
  private ArrayList<String> rcu;
  private final com.tencent.mm.ak.d rr;
  
  public d(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(108671);
    d.a locala = new d.a();
    locala.iLN = new jy();
    locala.iLO = new jz();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
    locala.funcId = 696;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rcu = paramArrayList;
    AppMethodBeat.o(108671);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(108673);
    this.callback = parami;
    ((jy)this.rr.iLK.iLR).KMy = new LinkedList(this.rcu);
    if ((this.rcu == null) || (this.rcu.size() <= 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
      com.tencent.mm.kernel.g.aAh().azQ().set(348162, Boolean.FALSE);
      AppMethodBeat.o(108673);
      return -1;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108673);
    return i;
  }
  
  public final int getType()
  {
    return 696;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108672);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      Log.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSH, Boolean.TRUE);
      h.CyF.idkeyStat(164L, 4L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NSH, Boolean.FALSE);
      params = k.getEmojiStorageMgr().OpN;
      paramArrayOfByte = this.rcu;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
      {
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
        h.CyF.idkeyStat(164L, 2L, 1L, false);
      }
    }
    for (;;)
    {
      params = (jz)this.rr.iLL.iLR;
      if ((params.KMA != null) && (params.KMA.size() > 0))
      {
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
        k.getEmojiStorageMgr().OpN.bJ(params.KMA);
        com.tencent.mm.kernel.g.aAh().azQ().set(348165, Boolean.TRUE);
        a.lr(true);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108672);
      return;
      Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[] { Integer.valueOf(paramArrayOfByte.size()) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UPDATE");
      localStringBuilder.append(" EmojiInfo ");
      localStringBuilder.append(" SET ");
      localStringBuilder.append("source");
      localStringBuilder.append("=");
      localStringBuilder.append(EmojiInfo.UuH);
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
      Log.d("MicroMsg.emoji.EmojiInfoStorage", localStringBuilder.toString());
      params.db.execSQL("EmojiInfo", localStringBuilder.toString());
      break;
      h.CyF.idkeyStat(164L, 3L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.d
 * JD-Core Version:    0.7.0.1
 */