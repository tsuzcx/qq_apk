package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class i
{
  public static int a(i.a parama)
  {
    int i;
    if (parama.hJY == null)
    {
      y.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      i = 0;
    }
    do
    {
      return i;
      i = (int)e.aeQ(parama.filePath);
      if (i <= 0)
      {
        y.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
        return 0;
      }
    } while (parama.hKa);
    if (parama.hJZ == null)
    {
      y.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.hJY.svF.toString()).append("_").append(parama.hJY.svG.toString()).append("_").append(parama.hJY.ndp).append("_backup");
    if (parama.hKb == null) {}
    for (String str = "";; str = parama.hKb)
    {
      str = str;
      y.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.hJY.szn.add(new bml().YI(str));
      parama.hJY.szo.add(new bmm().EU(parama.bLN));
      parama.hJY.szm = parama.hJY.szn.size();
      if (parama.hJV == null) {
        parama.hJV = new u();
      }
      parama.hJV.hQO = parama.hJY.ndp;
      parama.hJV.bUi = str;
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
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */