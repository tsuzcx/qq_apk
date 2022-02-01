package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.rPH == null)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.u.bBQ(parama.filePath);
    if (i <= 0)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.rPJ)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.rPH.RNM.Ufv == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.jHh == null)
        {
          Log.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new eae().dc((byte[])localObject);
        parama.rPH.RNN = i;
        parama.rPH.RNO = parama.mediaType;
        parama.rPH.RNM = ((eae)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.jHh);
        continue;
        localObject = com.tencent.mm.vfs.u.aY(parama.filePath, 0, -1);
      }
    }
    if (parama.rPI == null)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.rPH.RID.toString()).append("_").append(parama.rPH.RIE.toString()).append("_").append(parama.rPH.HlH).append("_backup_");
    if (parama.rPK == null) {}
    for (Object localObject = "";; localObject = parama.rPK)
    {
      localObject = (String)localObject;
      Log.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.rPH.RNK.add(new eaf().btQ((String)localObject));
      parama.rPH.RNL.add(new eag().arE(parama.mediaType));
      parama.rPH.RNJ = parama.rPH.RNK.size();
      if (parama.rPE == null) {
        parama.rPE = new com.tencent.mm.plugin.backup.i.u();
      }
      parama.rPE.rWr = parama.rPH.HlH;
      parama.rPE.mediaId = ((String)localObject);
      parama.rPE.path = parama.filePath;
      parama.rPE.type = parama.mediaType;
      if (!parama.rPL) {
        parama.rPI.add(parama.rPE);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    EmojiInfo jHh;
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
    
    public a(String paramString, ih paramih, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.rPH = paramih;
      this.rPI = paramLinkedList;
      this.mediaType = 5;
      this.rPJ = false;
      this.rPL = false;
      this.rPE = null;
      this.jHh = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */