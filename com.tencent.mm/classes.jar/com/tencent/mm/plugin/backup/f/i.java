package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.rPH == null)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.u.bBQ(parama.filePath);
    if (i <= 0)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.rPJ)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.rPI == null)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.rPH.RID.toString()).append("_").append(parama.rPH.RIE.toString()).append("_").append(parama.rPH.HlH).append("_backup");
    if (parama.rPK == null) {}
    for (String str = "";; str = "_" + parama.rPK)
    {
      str = str;
      Log.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.rPH.RNK.add(new eaf().btQ(str));
      parama.rPH.RNL.add(new eag().arE(parama.mediaType));
      parama.rPH.RNJ = parama.rPH.RNK.size();
      if (parama.rPE == null) {
        parama.rPE = new com.tencent.mm.plugin.backup.i.u();
      }
      parama.rPE.rWr = parama.rPH.HlH;
      parama.rPE.mediaId = str;
      parama.rPE.path = parama.filePath;
      parama.rPE.type = parama.mediaType;
      if (!parama.rPL) {
        parama.rPI.add(parama.rPE);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    com.tencent.mm.plugin.backup.i.u rPE;
    ih rPH;
    LinkedList<com.tencent.mm.plugin.backup.i.u> rPI;
    boolean rPJ = true;
    String rPK;
    boolean rPL;
    
    public a(String paramString1, ih paramih, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.rPH = paramih;
      this.rPI = paramLinkedList;
      this.mediaType = paramInt;
      this.rPJ = paramBoolean1;
      this.rPK = paramString2;
      this.rPL = paramBoolean2;
      this.rPE = null;
    }
    
    public a(String paramString, ih paramih, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mm.plugin.backup.i.u paramu)
    {
      this.filePath = paramString;
      this.rPH = paramih;
      this.rPI = paramLinkedList;
      this.mediaType = paramInt;
      this.rPJ = paramBoolean1;
      this.rPL = paramBoolean2;
      this.rPE = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */