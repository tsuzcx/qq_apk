package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class i
{
  public static int a(i.a parama)
  {
    AppMethodBeat.i(17468);
    if (parama.jDB == null)
    {
      ab.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(17468);
      return 0;
    }
    int i = (int)e.avI(parama.filePath);
    if (i <= 0)
    {
      ab.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(17468);
      return 0;
    }
    if (parama.jDD)
    {
      AppMethodBeat.o(17468);
      return i;
    }
    if (parama.jDC == null)
    {
      ab.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(17468);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.jDB.woP.toString()).append("_").append(parama.jDB.woQ.toString()).append("_").append(parama.jDB.pIG).append("_backup");
    if (parama.jDE == null) {}
    for (String str = "";; str = parama.jDE)
    {
      str = str;
      ab.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.jDB.wto.add(new bwc().aoF(str));
      parama.jDB.wtp.add(new bwd().MU(parama.cth));
      parama.jDB.wtn = parama.jDB.wto.size();
      if (parama.jDy == null) {
        parama.jDy = new u();
      }
      parama.jDy.jKq = parama.jDB.pIG;
      parama.jDy.cBO = str;
      parama.jDy.path = parama.filePath;
      parama.jDy.type = parama.cth;
      if (!parama.jDF) {
        parama.jDC.add(parama.jDy);
      }
      AppMethodBeat.o(17468);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */