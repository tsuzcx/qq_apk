package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.emoji.event.EmojiPostTaskListener;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  private ArrayList<String> xOb;
  
  public d(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(108671);
    c.a locala = new c.a();
    locala.otE = new kk();
    locala.otF = new kl();
    locala.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
    locala.funcId = 696;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOb = paramArrayList;
    AppMethodBeat.o(108671);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108673);
    this.callback = paramh;
    ((kk)c.b.b(this.rr.otB)).YKG = new LinkedList(this.xOb);
    if ((this.xOb == null) || (this.xOb.size() <= 0))
    {
      Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
      com.tencent.mm.kernel.h.baE().ban().B(348162, Boolean.FALSE);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108672);
    Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt3 == -434)
    {
      Log.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHU, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 4L, 1L, false);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHU, Boolean.FALSE);
      params = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju;
      paramArrayOfByte = this.xOb;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0))
      {
        Log.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 2L, 1L, false);
      }
    }
    for (;;)
    {
      params = (kl)c.c.b(this.rr.otC);
      if ((params.YKI != null) && (params.YKI.size() > 0))
      {
        Log.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
        com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.cw(params.YKI);
        com.tencent.mm.kernel.h.baE().ban().B(348165, Boolean.TRUE);
        EmojiPostTaskListener.nZ(true);
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
      localStringBuilder.append(EmojiInfo.aklY);
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
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(164L, 3L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.d
 * JD-Core Version:    0.7.0.1
 */