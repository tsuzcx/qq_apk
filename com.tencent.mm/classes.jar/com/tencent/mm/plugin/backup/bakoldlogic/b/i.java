package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.mWW == null)
    {
      ac.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.i.aSp(parama.filePath);
    if (i <= 0)
    {
      ac.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.mWY)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.mWW.DVs.getILen() == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.fPB == null)
        {
          ac.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
        parama.mWW.DVt = i;
        parama.mWW.DVu = parama.mediaType;
        parama.mWW.DVs = ((SKBuiltinBuffer_t)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.fPB);
        continue;
        localObject = com.tencent.mm.vfs.i.aU(parama.filePath, 0, -1);
      }
    }
    if (parama.mWX == null)
    {
      ac.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.mWW.DPT.toString()).append("_").append(parama.mWW.DPU.toString()).append("_").append(parama.mWW.vTQ).append("_backup_");
    if (parama.mWZ == null) {}
    for (Object localObject = "";; localObject = parama.mWZ)
    {
      localObject = (String)localObject;
      ac.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.mWW.DVq.add(new crm().aJV((String)localObject));
      parama.mWW.DVr.add(new crn().XY(parama.mediaType));
      parama.mWW.DVp = parama.mWW.DVq.size();
      if (parama.mWT == null) {
        parama.mWT = new u();
      }
      parama.mWT.ndG = parama.mWW.vTQ;
      parama.mWT.mediaId = ((String)localObject);
      parama.mWT.path = parama.filePath;
      parama.mWT.type = parama.mediaType;
      if (!parama.mXa) {
        parama.mWX.add(parama.mWT);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    EmojiInfo fPB;
    String filePath;
    u mWT;
    hy mWW;
    LinkedList<u> mWX;
    boolean mWY = true;
    String mWZ;
    boolean mXa;
    int mediaType;
    
    public a(String paramString1, hy paramhy, LinkedList<u> paramLinkedList, int paramInt, String paramString2)
    {
      this.filePath = paramString1;
      this.mWW = paramhy;
      this.mWX = paramLinkedList;
      this.mediaType = paramInt;
      this.mWY = false;
      this.mWZ = paramString2;
      this.mXa = false;
      this.mWT = null;
    }
    
    public a(String paramString, hy paramhy, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean, u paramu)
    {
      this.filePath = paramString;
      this.mWW = paramhy;
      this.mWX = paramLinkedList;
      this.mediaType = paramInt;
      this.mWY = false;
      this.mXa = paramBoolean;
      this.mWT = paramu;
    }
    
    public a(String paramString, hy paramhy, LinkedList<u> paramLinkedList, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.mWW = paramhy;
      this.mWX = paramLinkedList;
      this.mediaType = 5;
      this.mWY = false;
      this.mXa = false;
      this.mWT = null;
      this.fPB = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */