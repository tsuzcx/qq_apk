package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.nxt == null)
    {
      ad.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.i.aYo(parama.filePath);
    if (i <= 0)
    {
      ad.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.nxv)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.nxu == null)
    {
      ad.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.nxt.Fvi.toString()).append("_").append(parama.nxt.Fvj.toString()).append("_").append(parama.nxt.xbt).append("_backup");
    if (parama.nxw == null) {}
    for (String str = "";; str = "_" + parama.nxw)
    {
      str = str;
      ad.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.nxt.FAL.add(new cwt().aPy(str));
      parama.nxt.FAM.add(new cwu().ZU(parama.mediaType));
      parama.nxt.FAK = parama.nxt.FAL.size();
      if (parama.nxq == null) {
        parama.nxq = new u();
      }
      parama.nxq.nEd = parama.nxt.xbt;
      parama.nxq.mediaId = str;
      parama.nxq.path = parama.filePath;
      parama.nxq.type = parama.mediaType;
      if (!parama.nxx) {
        parama.nxu.add(parama.nxq);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    u nxq;
    if nxt;
    LinkedList<u> nxu;
    boolean nxv = true;
    String nxw;
    boolean nxx;
    
    public a(String paramString1, if paramif, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.nxt = paramif;
      this.nxu = paramLinkedList;
      this.mediaType = paramInt;
      this.nxv = paramBoolean1;
      this.nxw = paramString2;
      this.nxx = paramBoolean2;
      this.nxq = null;
    }
    
    public a(String paramString, if paramif, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
    {
      this.filePath = paramString;
      this.nxt = paramif;
      this.nxu = paramLinkedList;
      this.mediaType = paramInt;
      this.nxv = paramBoolean1;
      this.nxx = paramBoolean2;
      this.nxq = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */