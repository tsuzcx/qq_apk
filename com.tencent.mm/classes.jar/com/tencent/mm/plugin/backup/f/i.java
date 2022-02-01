package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21527);
    if (parama.vaW == null)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21527);
      return 0;
    }
    int i = (int)y.bEl(parama.filePath);
    if (i <= 0)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21527);
      return 0;
    }
    if (parama.vaY)
    {
      AppMethodBeat.o(21527);
      return i;
    }
    if (parama.vaX == null)
    {
      Log.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21527);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(parama.vaW.YFE.toString()).append("_").append(parama.vaW.YFF.toString()).append("_").append(parama.vaW.Njv).append("_backup");
    if (parama.vaZ == null) {}
    for (String str = "";; str = "_" + parama.vaZ)
    {
      str = str;
      Log.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { str, parama.filePath });
      parama.vaW.YKY.add(new etl().btH(str));
      parama.vaW.YKZ.add(new etm().axM(parama.mediaType));
      parama.vaW.YKX = parama.vaW.YKY.size();
      if (parama.vaT == null) {
        parama.vaT = new u();
      }
      parama.vaT.vhH = parama.vaW.Njv;
      parama.vaT.mediaId = str;
      parama.vaT.path = parama.filePath;
      parama.vaT.type = parama.mediaType;
      if (!parama.vba) {
        parama.vaX.add(parama.vaT);
      }
      AppMethodBeat.o(21527);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    u vaT;
    jd vaW;
    LinkedList<u> vaX;
    boolean vaY = true;
    String vaZ;
    boolean vba;
    
    public a(String paramString1, jd paramjd, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
    {
      this.filePath = paramString1;
      this.vaW = paramjd;
      this.vaX = paramLinkedList;
      this.mediaType = paramInt;
      this.vaY = paramBoolean1;
      this.vaZ = paramString2;
      this.vba = paramBoolean2;
      this.vaT = null;
    }
    
    public a(String paramString, jd paramjd, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, u paramu)
    {
      this.filePath = paramString;
      this.vaW = paramjd;
      this.vaX = paramLinkedList;
      this.mediaType = paramInt;
      this.vaY = paramBoolean1;
      this.vba = paramBoolean2;
      this.vaT = paramu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.i
 * JD-Core Version:    0.7.0.1
 */