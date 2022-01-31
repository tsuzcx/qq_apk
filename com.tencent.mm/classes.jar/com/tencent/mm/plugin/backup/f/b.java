package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(fo paramfo, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    int j;
    int i;
    if (bk.bl(parambi.field_content))
    {
      j = 0;
      paramHashMap = ap.abP(parambi.field_content).uAC.trim();
      paramString = paramHashMap;
      if (!com.tencent.mm.plugin.backup.b.g.xr(paramHashMap))
      {
        paramHashMap = parambi.field_content;
        paramString = paramHashMap;
        if (!com.tencent.mm.plugin.backup.b.g.xr(paramHashMap))
        {
          paramHashMap = g.a.a(parambi, paramfo);
          paramString = paramHashMap;
          if (parambi.field_isSend != 1)
          {
            paramString = paramHashMap;
            if (c.fn(parambi.field_talker)) {
              paramString = parambi.field_talker + " :\n " + paramHashMap;
            }
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.xr(paramString))) {
        break label174;
      }
      y.d("MicroMsg.BackupItemEmoji", "emoji error:" + paramString);
      i = -1;
    }
    label174:
    label234:
    do
    {
      do
      {
        do
        {
          return i;
          j = parambi.field_content.getBytes().length;
          break;
          paramHashMap = new bml();
          paramHashMap.YI(bk.aM(paramString, ""));
          paramfo.svH = paramHashMap;
          parambi = com.tencent.mm.plugin.backup.h.d.avi().avj().avg().acC(parambi.field_imgPath);
          if (parambi == null) {
            break label234;
          }
          i = j;
        } while (parambi.cwC());
        i = j;
      } while (parambi == null);
      if (TextUtils.isEmpty(parambi.field_groupId))
      {
        paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().FL();
        paramString = paramString + parambi.Wv() + "_thumb";
        if (e.aeQ(paramString) < 0L)
        {
          y.e("MicroMsg.BackupItemEmoji", "thumbPath error");
          return -1;
        }
      }
      for (j = i.a(new i.a(paramString, paramfo, paramLinkedList, 4, paramBoolean1, "_thumb", paramBoolean2)) + j; (TextUtils.isEmpty(parambi.field_groupId)) && (parambi.cwz()); j = i.a(new i.a(paramString, paramfo, paramLinkedList, 4, paramBoolean1, "_thumb", paramBoolean2)) + j)
      {
        paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().FL();
        return j + i.a(new i.a(paramString + parambi.Wv(), paramfo, paramLinkedList, 5, paramBoolean1, paramBoolean2, null));
        paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().FL();
        paramString = paramString + parambi.field_groupId + File.separator + parambi.Wv() + "_cover";
        if (e.aeQ(paramString) < 0L)
        {
          y.e("MicroMsg.BackupItemEmoji", "thumbPath error");
          return -1;
        }
      }
      i = j;
    } while (!parambi.cwB());
    paramString = com.tencent.mm.plugin.backup.h.d.avi().avj().FL();
    return j + i.a(new i.a(paramString + parambi.field_groupId + File.separator + parambi.Wv(), paramfo, paramLinkedList, 5, paramBoolean1, paramBoolean2, null));
  }
  
  public final int a(String paramString, fo paramfo, bi parambi)
  {
    boolean bool = true;
    parambi.setContent(paramfo.svH.tFO);
    paramString = paramfo.svF.tFO;
    Object localObject1 = paramfo.svG.tFO;
    if (((String)com.tencent.mm.plugin.backup.h.d.avi().avj().Dz().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      localObject2 = paramfo.svH.tFO;
      localObject1 = bn.s((String)localObject2, "msg");
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().cM((String)localObject2, paramString);
      if (paramString != null) {
        break;
      }
      y.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      return -1;
    }
    Object localObject2 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramString.bIW);
    if (localObject2 == null)
    {
      y.w("MicroMsg.BackupItemEmoji", "EmojiInfo is null");
      return -1;
    }
    if (((Map)localObject1).get(".msg.emoji.$androidmd5") == null)
    {
      localObject3 = g.a.xu(paramString.bIW);
      if (!bk.bl((String)localObject3))
      {
        paramString.bIW = ((String)localObject3);
        y.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject3 });
      }
    }
    localObject1 = (String)((Map)localObject1).get(".msg.emoji.$productid");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString.bJd = ((String)localObject1);
    }
    parambi.setType(47);
    parambi.ed(paramString.bIW);
    Object localObject3 = paramString.eHA;
    if ((!((EmojiInfo)localObject2).ZH()) && (!((EmojiInfo)localObject2).isGif()))
    {
      parambi.setContent(ap.a((String)localObject3, 0L, bool, paramString.bIW, false, ""));
      if (!((EmojiInfo)localObject2).cwz())
      {
        localObject2 = com.tencent.mm.plugin.backup.h.d.avi().avj().FL();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label517;
        }
        com.tencent.mm.plugin.backup.b.g.b(paramfo, 4, (String)localObject2 + paramString.bIW + "_thumb");
        com.tencent.mm.plugin.backup.b.g.b(paramfo, 5, (String)localObject2 + paramString.bIW);
      }
    }
    for (;;)
    {
      paramfo = new EmojiInfo((String)localObject2);
      paramfo.field_md5 = paramString.bIW;
      paramfo.field_svrid = paramString.id;
      paramfo.field_catalog = EmojiInfo.uCT;
      paramfo.field_type = paramString.uAR;
      paramfo.field_size = paramString.uAS;
      paramfo.field_state = EmojiInfo.uDf;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramfo.field_groupId = ((String)localObject1);
      }
      if (!bk.bl(paramString.uBa)) {
        paramfo.field_activityid = paramString.uBa;
      }
      com.tencent.mm.plugin.backup.h.d.avi().avj().avg().a(paramfo);
      long l = c.h(parambi);
      y.d("MicroMsg.BackupItemEmoji", "id " + l);
      return 0;
      bool = false;
      break;
      label517:
      localObject3 = new File((String)localObject2 + (String)localObject1);
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramfo, 4, (String)localObject2 + (String)localObject1 + File.separator + paramString.bIW + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramfo, 5, (String)localObject2 + (String)localObject1 + File.separator + paramString.bIW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */