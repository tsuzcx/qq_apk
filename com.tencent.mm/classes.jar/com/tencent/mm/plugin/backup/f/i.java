package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.mWW == null)
    {
      ac.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.i.aSp(parama.filePath);
    if (i <= 0)
    {
      ac.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.mWY)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.mWX == null)
    {
      ac.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.mWW.DPT.toString()).append("_").append(parama.mWW.DPU.toString()).append("_").append(parama.mWW.vTQ).append("_backup");
    if (parama.mWZ == null) {}
    for (String str = "";; str = "_" + parama.mWZ)
    {
      str = str;
      ac.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.mWW.DVq.add(new crm().aJV(str));
      parama.mWW.DVr.add(new crn().XY(parama.mediaType));
      parama.mWW.DVp = parama.mWW.DVq.size();
      if (parama.mWT == null) {
        parama.mWT = new u();
      }
      parama.mWT.ndG = parama.mWW.vTQ;
      parama.mWT.mediaId = str;
      parama.mWT.path = parama.filePath;
      parama.mWT.type = parama.mediaType;
      if (!parama.mXa) {
        parama.mWX.add(parama.mWT);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    u mWT;
    hy mWW;
    LinkedList<u> mWX;
    boolean mWY = true;
    String mWZ;
    boolean mXa;
    int mediaType;
    
    public a(String paramString1, hy paramhy, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.mWW = paramhy;
      this.mWX = paramLinkedList;
      this.mediaType = paramInt;
      this.mWY = paramBoolean1;
      this.mWZ = paramString2;
      this.mXa = paramBoolean2;
      this.mWT = null;
    }
    
    public a(String paramString, hy paramhy, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
    {
      this.filePath = paramString;
      this.mWW = paramhy;
      this.mWX = paramLinkedList;
      this.mediaType = paramInt;
      this.mWY = paramBoolean1;
      this.mXa = paramBoolean2;
      this.mWT = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */