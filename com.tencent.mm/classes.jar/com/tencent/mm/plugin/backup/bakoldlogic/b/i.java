package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.nCO == null)
    {
      ae.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)o.aZR(parama.filePath);
    if (i <= 0)
    {
      ae.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.nCQ)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.nCO.FTj.getILen() == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.glt == null)
        {
          ae.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
        parama.nCO.FTk = i;
        parama.nCO.FTl = parama.mediaType;
        parama.nCO.FTj = ((SKBuiltinBuffer_t)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.glt);
        continue;
        localObject = o.bb(parama.filePath, 0, -1);
      }
    }
    if (parama.nCP == null)
    {
      ae.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.nCO.FNG.toString()).append("_").append(parama.nCO.FNH.toString()).append("_").append(parama.nCO.xrk).append("_backup_");
    if (parama.nCR == null) {}
    for (Object localObject = "";; localObject = parama.nCR)
    {
      localObject = (String)localObject;
      ae.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.nCO.FTh.add(new cxn().aQV((String)localObject));
      parama.nCO.FTi.add(new cxo().aaA(parama.mediaType));
      parama.nCO.FTg = parama.nCO.FTh.size();
      if (parama.nCL == null) {
        parama.nCL = new u();
      }
      parama.nCL.nJy = parama.nCO.xrk;
      parama.nCL.mediaId = ((String)localObject);
      parama.nCL.path = parama.filePath;
      parama.nCL.type = parama.mediaType;
      if (!parama.nCS) {
        parama.nCP.add(parama.nCL);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    EmojiInfo glt;
    int mediaType;
    u nCL;
    if nCO;
    LinkedList<u> nCP;
    boolean nCQ = true;
    String nCR;
    boolean nCS;
    
    public a(String paramString1, if paramif, LinkedList<u> paramLinkedList, int paramInt, String paramString2)
    {
      this.filePath = paramString1;
      this.nCO = paramif;
      this.nCP = paramLinkedList;
      this.mediaType = paramInt;
      this.nCQ = false;
      this.nCR = paramString2;
      this.nCS = false;
      this.nCL = null;
    }
    
    public a(String paramString, if paramif, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean, u paramu)
    {
      this.filePath = paramString;
      this.nCO = paramif;
      this.nCP = paramLinkedList;
      this.mediaType = paramInt;
      this.nCQ = false;
      this.nCS = paramBoolean;
      this.nCL = paramu;
    }
    
    public a(String paramString, if paramif, LinkedList<u> paramLinkedList, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.nCO = paramif;
      this.nCP = paramLinkedList;
      this.mediaType = 5;
      this.nCQ = false;
      this.nCS = false;
      this.nCL = null;
      this.glt = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */