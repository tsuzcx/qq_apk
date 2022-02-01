package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public final class i
{
  public static int a(a parama)
  {
    AppMethodBeat.i(21858);
    if (parama.vaW == null)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[] { "backupItemInfo.backupitem" });
      AppMethodBeat.o(21858);
      return 0;
    }
    int i = (int)y.bEl(parama.filePath);
    if (i <= 0)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + parama.filePath);
      AppMethodBeat.o(21858);
      return 0;
    }
    if (parama.vaY)
    {
      AppMethodBeat.o(21858);
      return i;
    }
    if ((i < 8192) && (parama.vaW.YLa.abwJ == 0))
    {
      if (parama.mediaType == 5) {
        if (parama.mgK == null)
        {
          Log.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
          localObject = null;
        }
      }
      for (;;)
      {
        localObject = new gol().df((byte[])localObject);
        parama.vaW.YLb = i;
        parama.vaW.YLc = parama.mediaType;
        parama.vaW.YLa = ((gol)localObject);
        AppMethodBeat.o(21858);
        return i;
        localObject = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(parama.mgK);
        continue;
        localObject = y.bi(parama.filePath, 0, -1);
      }
    }
    if (parama.vaX == null)
    {
      Log.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
      AppMethodBeat.o(21858);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(parama.vaW.YFE.toString()).append("_").append(parama.vaW.YFF.toString()).append("_").append(parama.vaW.Njv).append("_backup_");
    if (parama.vaZ == null) {}
    for (Object localObject = "";; localObject = parama.vaZ)
    {
      localObject = (String)localObject;
      Log.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[] { localObject, parama.filePath });
      parama.vaW.YKY.add(new etl().btH((String)localObject));
      parama.vaW.YKZ.add(new etm().axM(parama.mediaType));
      parama.vaW.YKX = parama.vaW.YKY.size();
      if (parama.vaT == null) {
        parama.vaT = new u();
      }
      parama.vaT.vhH = parama.vaW.Njv;
      parama.vaT.mediaId = ((String)localObject);
      parama.vaT.path = parama.filePath;
      parama.vaT.type = parama.mediaType;
      if (!parama.vba) {
        parama.vaX.add(parama.vaT);
      }
      AppMethodBeat.o(21858);
      return 0;
    }
  }
  
  public static final class a
  {
    String filePath;
    int mediaType;
    EmojiInfo mgK;
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
    
    public a(String paramString, jd paramjd, LinkedList<u> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2, EmojiInfo paramEmojiInfo)
    {
      this.filePath = paramString;
      this.vaW = paramjd;
      this.vaX = paramLinkedList;
      this.mediaType = 5;
      this.vaY = false;
      this.vba = false;
      this.vaT = null;
      this.mgK = paramEmojiInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.i
 * JD-Core Version:    0.7.0.1
 */