package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.oNL == null)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)s.boW(parama.filePath);
    if (i <= 0)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.oNN)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.oNM == null)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.oNL.KHl.toString()).append("_").append(parama.oNL.KHm.toString()).append("_").append(parama.oNL.Brn).append("_backup");
    if (parama.oNO == null) {}
    for (String str = "";; str = "_" + parama.oNO)
    {
      str = str;
      Log.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.oNL.KMQ.add(new dqi().bhy(str));
      parama.oNL.KMR.add(new dqj().ajp(parama.mediaType));
      parama.oNL.KMP = parama.oNL.KMQ.size();
      if (parama.oNI == null) {
        parama.oNI = new u();
      }
      parama.oNI.oUt = parama.oNL.Brn;
      parama.oNI.mediaId = str;
      parama.oNI.path = parama.filePath;
      parama.oNI.type = parama.mediaType;
      if (!parama.oNP) {
        parama.oNM.add(parama.oNI);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    u oNI;
    is oNL;
    LinkedList<u> oNM;
    boolean oNN = true;
    String oNO;
    boolean oNP;
    
    public a(String paramString1, is paramis, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.oNL = paramis;
      this.oNM = paramLinkedList;
      this.mediaType = paramInt;
      this.oNN = paramBoolean1;
      this.oNO = paramString2;
      this.oNP = paramBoolean2;
      this.oNI = null;
    }
    
    public a(String paramString, is paramis, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
    {
      this.filePath = paramString;
      this.oNL = paramis;
      this.oNM = paramLinkedList;
      this.mediaType = paramInt;
      this.oNN = paramBoolean1;
      this.oNP = paramBoolean2;
      this.oNI = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */