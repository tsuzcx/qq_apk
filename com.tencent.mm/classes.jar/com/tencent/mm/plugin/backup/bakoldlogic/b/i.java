package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.oNL == null)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)s.boW(parama.filePath);
    if (i <= 0)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.oNN)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.oNL.KMS.getILen() == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.gWm == null)
        {
          Log.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
        parama.oNL.KMT = i;
        parama.oNL.KMU = parama.mediaType;
        parama.oNL.KMS = ((SKBuiltinBuffer_t)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(parama.gWm);
        continue;
        localObject = s.aW(parama.filePath, 0, -1);
      }
    }
    if (parama.oNM == null)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.oNL.KHl.toString()).append("_").append(parama.oNL.KHm.toString()).append("_").append(parama.oNL.Brn).append("_backup_");
    if (parama.oNO == null) {}
    for (Object localObject = "";; localObject = parama.oNO)
    {
      localObject = (String)localObject;
      Log.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.oNL.KMQ.add(new dqi().bhy((String)localObject));
      parama.oNL.KMR.add(new dqj().ajp(parama.mediaType));
      parama.oNL.KMP = parama.oNL.KMQ.size();
      if (parama.oNI == null) {
        parama.oNI = new u();
      }
      parama.oNI.oUt = parama.oNL.Brn;
      parama.oNI.mediaId = ((String)localObject);
      parama.oNI.path = parama.filePath;
      parama.oNI.type = parama.mediaType;
      if (!parama.oNP) {
        parama.oNM.add(parama.oNI);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    EmojiInfo gWm;
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
    
    public a(String paramString, is paramis, LinkedList<u> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.oNL = paramis;
      this.oNM = paramLinkedList;
      this.mediaType = 5;
      this.oNN = false;
      this.oNP = false;
      this.oNI = null;
      this.gWm = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */