package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.nxt == null)
    {
      ad.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.i.aYo(parama.filePath);
    if (i <= 0)
    {
      ad.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.nxv)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.nxt.FAN.getILen() == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.gjb == null)
        {
          ad.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
        parama.nxt.FAO = i;
        parama.nxt.FAP = parama.mediaType;
        parama.nxt.FAN = ((SKBuiltinBuffer_t)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.gjb);
        continue;
        localObject = com.tencent.mm.vfs.i.aY(parama.filePath, 0, -1);
      }
    }
    if (parama.nxu == null)
    {
      ad.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.nxt.Fvi.toString()).append("_").append(parama.nxt.Fvj.toString()).append("_").append(parama.nxt.xbt).append("_backup_");
    if (parama.nxw == null) {}
    for (Object localObject = "";; localObject = parama.nxw)
    {
      localObject = (String)localObject;
      ad.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.nxt.FAL.add(new cwt().aPy((String)localObject));
      parama.nxt.FAM.add(new cwu().ZU(parama.mediaType));
      parama.nxt.FAK = parama.nxt.FAL.size();
      if (parama.nxq == null) {
        parama.nxq = new u();
      }
      parama.nxq.nEd = parama.nxt.xbt;
      parama.nxq.mediaId = ((String)localObject);
      parama.nxq.path = parama.filePath;
      parama.nxq.type = parama.mediaType;
      if (!parama.nxx) {
        parama.nxu.add(parama.nxq);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    EmojiInfo gjb;
    int mediaType;
    u nxq;
    if nxt;
    LinkedList<u> nxu;
    boolean nxv = true;
    String nxw;
    boolean nxx;
    
    public a(String paramString1, if paramif, LinkedList<u> paramLinkedList, int paramInt, String paramString2)
    {
      this.filePath = paramString1;
      this.nxt = paramif;
      this.nxu = paramLinkedList;
      this.mediaType = paramInt;
      this.nxv = false;
      this.nxw = paramString2;
      this.nxx = false;
      this.nxq = null;
    }
    
    public a(String paramString, if paramif, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean, u paramu)
    {
      this.filePath = paramString;
      this.nxt = paramif;
      this.nxu = paramLinkedList;
      this.mediaType = paramInt;
      this.nxv = false;
      this.nxx = paramBoolean;
      this.nxq = paramu;
    }
    
    public a(String paramString, if paramif, LinkedList<u> paramLinkedList, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.nxt = paramif;
      this.nxu = paramLinkedList;
      this.mediaType = 5;
      this.nxv = false;
      this.nxx = false;
      this.nxq = null;
      this.gjb = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */