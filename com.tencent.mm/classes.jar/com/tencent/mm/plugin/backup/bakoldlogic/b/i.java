package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.muV == null)
    {
      ad.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)com.tencent.mm.vfs.i.aMN(parama.filePath);
    if (i <= 0)
    {
      ad.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.muX)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.muV.CCV.getILen() == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.fLP == null)
        {
          ad.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
        parama.muV.CCW = i;
        parama.muV.CCX = parama.mediaType;
        parama.muV.CCV = ((SKBuiltinBuffer_t)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.fLP);
        continue;
        localObject = com.tencent.mm.vfs.i.aR(parama.filePath, 0, -1);
      }
    }
    if (parama.muW == null)
    {
      ad.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.muV.Cxx.toString()).append("_").append(parama.muV.Cxy.toString()).append("_").append(parama.muV.uKZ).append("_backup_");
    if (parama.muY == null) {}
    for (Object localObject = "";; localObject = parama.muY)
    {
      localObject = (String)localObject;
      ad.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.muV.CCT.add(new cmf().aEE((String)localObject));
      parama.muV.CCU.add(new cmg().VP(parama.mediaType));
      parama.muV.CCS = parama.muV.CCT.size();
      if (parama.muS == null) {
        parama.muS = new u();
      }
      parama.muS.mBF = parama.muV.uKZ;
      parama.muS.mediaId = ((String)localObject);
      parama.muS.path = parama.filePath;
      parama.muS.type = parama.mediaType;
      if (!parama.muZ) {
        parama.muW.add(parama.muS);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    EmojiInfo fLP;
    String filePath;
    int mediaType;
    u muS;
    hu muV;
    LinkedList<u> muW;
    boolean muX = true;
    String muY;
    boolean muZ;
    
    public a(String paramString1, hu paramhu, LinkedList<u> paramLinkedList, int paramInt, String paramString2)
    {
      this.filePath = paramString1;
      this.muV = paramhu;
      this.muW = paramLinkedList;
      this.mediaType = paramInt;
      this.muX = false;
      this.muY = paramString2;
      this.muZ = false;
      this.muS = null;
    }
    
    public a(String paramString, hu paramhu, LinkedList<u> paramLinkedList, int paramInt, boolean paramBoolean, u paramu)
    {
      this.filePath = paramString;
      this.muV = paramhu;
      this.muW = paramLinkedList;
      this.mediaType = paramInt;
      this.muX = false;
      this.muZ = paramBoolean;
      this.muS = paramu;
    }
    
    public a(String paramString, hu paramhu, LinkedList<u> paramLinkedList, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.muV = paramhu;
      this.muW = paramLinkedList;
      this.mediaType = 5;
      this.muX = false;
      this.muZ = false;
      this.muS = null;
      this.fLP = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */