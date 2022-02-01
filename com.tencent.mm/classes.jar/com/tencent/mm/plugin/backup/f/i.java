package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.muV == null)
    {
      ad.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.i.aMN(parama.filePath);
    if (i <= 0)
    {
      ad.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.muX)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.muW == null)
    {
      ad.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.muV.Cxx.toString()).append("_").append(parama.muV.Cxy.toString()).append("_").append(parama.muV.uKZ).append("_backup");
    if (parama.muY == null) {}
    for (String str = "";; str = "_" + parama.muY)
    {
      str = str;
      ad.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.muV.CCT.add(new cmf().aEE(str));
      parama.muV.CCU.add(new cmg().VP(parama.mediaType));
      parama.muV.CCS = parama.muV.CCT.size();
      if (parama.muS == null) {
        parama.muS = new u();
      }
      parama.muS.mBF = parama.muV.uKZ;
      parama.muS.mediaId = str;
      parama.muS.path = parama.filePath;
      parama.muS.type = parama.mediaType;
      if (!parama.muZ) {
        parama.muW.add(parama.muS);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    u muS;
    hu muV;
    LinkedList<u> muW;
    boolean muX = true;
    String muY;
    boolean muZ;
    
    public a(String paramString1, hu paramhu, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.muV = paramhu;
      this.muW = paramLinkedList;
      this.mediaType = paramInt;
      this.muX = paramBoolean1;
      this.muY = paramString2;
      this.muZ = paramBoolean2;
      this.muS = null;
    }
    
    public a(String paramString, hu paramhu, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
    {
      this.filePath = paramString;
      this.muV = paramhu;
      this.muW = paramLinkedList;
      this.mediaType = paramInt;
      this.muX = paramBoolean1;
      this.muZ = paramBoolean2;
      this.muS = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */