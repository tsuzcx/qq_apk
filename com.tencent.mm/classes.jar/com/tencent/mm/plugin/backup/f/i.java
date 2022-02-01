package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.nCO == null)
    {
      ae.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)o.aZR(parama.filePath);
    if (i <= 0)
    {
      ae.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.nCQ)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.nCP == null)
    {
      ae.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.nCO.FNG.toString()).append("_").append(parama.nCO.FNH.toString()).append("_").append(parama.nCO.xrk).append("_backup");
    if (parama.nCR == null) {}
    for (String str = "";; str = "_" + parama.nCR)
    {
      str = str;
      ae.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.nCO.FTh.add(new cxn().aQV(str));
      parama.nCO.FTi.add(new cxo().aaA(parama.mediaType));
      parama.nCO.FTg = parama.nCO.FTh.size();
      if (parama.nCL == null) {
        parama.nCL = new u();
      }
      parama.nCL.nJy = parama.nCO.xrk;
      parama.nCL.mediaId = str;
      parama.nCL.path = parama.filePath;
      parama.nCL.type = parama.mediaType;
      if (!parama.nCS) {
        parama.nCP.add(parama.nCL);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    u nCL;
    if nCO;
    LinkedList<u> nCP;
    boolean nCQ = true;
    String nCR;
    boolean nCS;
    
    public a(String paramString1, if paramif, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.nCO = paramif;
      this.nCP = paramLinkedList;
      this.mediaType = paramInt;
      this.nCQ = paramBoolean1;
      this.nCR = paramString2;
      this.nCS = paramBoolean2;
      this.nCL = null;
    }
    
    public a(String paramString, if paramif, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
    {
      this.filePath = paramString;
      this.nCO = paramif;
      this.nCP = paramLinkedList;
      this.mediaType = paramInt;
      this.nCQ = paramBoolean1;
      this.nCS = paramBoolean2;
      this.nCL = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */