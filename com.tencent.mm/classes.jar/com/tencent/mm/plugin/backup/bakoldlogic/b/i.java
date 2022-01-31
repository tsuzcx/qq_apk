package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class i
{
  public static int a(i.a parama)
  {
    AppMethodBeat.i(17801);
    if (parama.jDB == null)
    {
      ab.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(17801);
      return 0;
    }
    int i = e.cM(parama.filePath);
    if (i <= 0)
    {
      ab.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(17801);
      return 0;
    }
    if (parama.jDD)
    {
      AppMethodBeat.o(17801);
      return i;
    }
    if ((i < 8192) && (parama.jDB.wtq.getILen() == 0))
    {
      if (parama.cth == 5) {
        if (parama.evH == null)
        {
          ab.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
        parama.jDB.wtr = i;
        parama.jDB.wts = parama.cth;
        parama.jDB.wtq = ((SKBuiltinBuffer_t)localObject);
        AppMethodBeat.o(17801);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(parama.evH);
        continue;
        localObject = e.j(parama.filePath, 0, -1);
      }
    }
    if (parama.jDC == null)
    {
      ab.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(17801);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.jDB.woP.toString()).append("_").append(parama.jDB.woQ.toString()).append("_").append(parama.jDB.pIG).append("_backup_");
    if (parama.jDE == null) {}
    for (Object localObject = "";; localObject = parama.jDE)
    {
      localObject = (String)localObject;
      ab.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.jDB.wto.add(new bwc().aoF((String)localObject));
      parama.jDB.wtp.add(new bwd().MU(parama.cth));
      parama.jDB.wtn = parama.jDB.wto.size();
      if (parama.jDy == null) {
        parama.jDy = new u();
      }
      parama.jDy.jKq = parama.jDB.pIG;
      parama.jDy.cBO = ((String)localObject);
      parama.jDy.path = parama.filePath;
      parama.jDy.type = parama.cth;
      if (!parama.jDF) {
        parama.jDC.add(parama.jDy);
      }
      AppMethodBeat.o(17801);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */