package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class i
{
  public static int a(i.a parama)
  {
    if (parama.hJY == null)
    {
      y.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      return 0;
    }
    int i = e.bJ(parama.filePath);
    if (i <= 0)
    {
      y.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      return 0;
    }
    if (parama.hKa) {
      return i;
    }
    if ((i < 8192) && (parama.hJY.szp.tFK == 0))
    {
      if (parama.bLN == 5) {
        if (parama.hNs == null)
        {
          y.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new bmk().bs((byte[])localObject);
        parama.hJY.szq = i;
        parama.hJY.szr = parama.bLN;
        parama.hJY.szp = ((bmk)localObject);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.hNs);
        continue;
        localObject = e.d(parama.filePath, 0, -1);
      }
    }
    if (parama.hJZ == null)
    {
      y.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.hJY.svF.toString()).append("_").append(parama.hJY.svG.toString()).append("_").append(parama.hJY.ndp).append("_backup_");
    if (parama.hKb == null) {}
    for (Object localObject = "";; localObject = parama.hKb)
    {
      localObject = (String)localObject;
      y.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.hJY.szn.add(new bml().YI((String)localObject));
      parama.hJY.szo.add(new bmm().EU(parama.bLN));
      parama.hJY.szm = parama.hJY.szn.size();
      if (parama.hJV == null) {
        parama.hJV = new u();
      }
      parama.hJV.hQO = parama.hJY.ndp;
      parama.hJV.bUi = ((String)localObject);
      parama.hJV.path = parama.filePath;
      parama.hJV.type = parama.bLN;
      if (!parama.hKc) {
        parama.hJZ.add(parama.hJV);
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */