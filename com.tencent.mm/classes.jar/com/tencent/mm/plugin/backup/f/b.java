package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(gx paramgx, boolean paramBoolean1, bi parambi, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(17449);
    if (bo.isNullOrNil(parambi.field_content)) {}
    for (int j = 0;; j = parambi.field_content.getBytes().length)
    {
      paramHashMap = ap.arZ(parambi.field_content).yML.trim();
      paramString = paramHashMap;
      if (!com.tencent.mm.plugin.backup.b.g.Gk(paramHashMap))
      {
        paramHashMap = parambi.field_content;
        paramString = paramHashMap;
        if (!com.tencent.mm.plugin.backup.b.g.Gk(paramHashMap))
        {
          paramHashMap = g.a.a(parambi, paramgx);
          paramString = paramHashMap;
          if (parambi.field_isSend != 1)
          {
            paramString = paramHashMap;
            if (c.lA(parambi.field_talker)) {
              paramString = parambi.field_talker + " :\n " + paramHashMap;
            }
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.Gk(paramString))) {
        break;
      }
      ab.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(17449);
      return -1;
    }
    paramHashMap = new bwc();
    paramHashMap.aoF(bo.bf(paramString, ""));
    paramgx.woR = paramHashMap;
    parambi = com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUI().asP(parambi.field_imgPath);
    if ((parambi != null) && (parambi.dzq()))
    {
      AppMethodBeat.o(17449);
      return j;
    }
    int i = j;
    if (parambi != null)
    {
      if (!TextUtils.isEmpty(parambi.field_groupId)) {
        break label431;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YP();
      paramString = paramString + parambi.Al() + "_thumb";
      if (e.avI(paramString) < 0L)
      {
        ab.e("MicroMsg.BackupItemEmoji", "thumbPath error");
        AppMethodBeat.o(17449);
        return -1;
      }
      j = i.a(new i.a(paramString, paramgx, paramLinkedList, 4, paramBoolean1, "_thumb", paramBoolean2)) + j;
      if ((!TextUtils.isEmpty(parambi.field_groupId)) || (!parambi.dzn())) {
        break label537;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YP();
      i = j + i.a(new i.a(paramString + parambi.Al(), paramgx, paramLinkedList, 5, paramBoolean1, paramBoolean2, null));
    }
    for (;;)
    {
      AppMethodBeat.o(17449);
      return i;
      label431:
      paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YP();
      paramString = paramString + parambi.field_groupId + "/" + parambi.Al() + "_cover";
      if (e.avI(paramString) < 0L)
      {
        ab.e("MicroMsg.BackupItemEmoji", "thumbPath error");
        AppMethodBeat.o(17449);
        return -1;
      }
      j = i.a(new i.a(paramString, paramgx, paramLinkedList, 4, paramBoolean1, "_thumb", paramBoolean2)) + j;
      break;
      label537:
      i = j;
      if (parambi.dzp())
      {
        paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YP();
        i = j + i.a(new i.a(paramString + parambi.field_groupId + "/" + parambi.Al(), paramgx, paramLinkedList, 5, paramBoolean1, paramBoolean2, null));
      }
    }
  }
  
  public final int a(String paramString, gx paramgx, bi parambi)
  {
    AppMethodBeat.i(17450);
    parambi.setContent(paramgx.woR.xJE);
    paramString = paramgx.woP.xJE;
    Object localObject1 = paramgx.woQ.xJE;
    if (((String)com.tencent.mm.plugin.backup.h.d.aUK().aUL().Ru().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    as localas;
    for (;;)
    {
      localObject1 = paramgx.woR.xJE;
      localObject2 = br.F((String)localObject1, "msg");
      localas = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().dN((String)localObject1, paramString);
      if (localas != null) {
        break;
      }
      ab.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(17450);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(localas.cqq);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      ab.w("MicroMsg.BackupItemEmoji", "EmojiInfo is null");
      paramString = new EmojiInfo();
      as.b(localas, paramString);
      paramString.field_catalog = EmojiInfo.yPg;
      com.tencent.mm.plugin.backup.h.d.aUK().aUL().aUI().H(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.Gn(localas.cqq);
      if (!bo.isNullOrNil((String)localObject1))
      {
        localas.cqq = ((String)localObject1);
        ab.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localas.cqx;
    parambi.setType(47);
    parambi.kk(localas.cqq);
    Object localObject2 = localas.fXq;
    boolean bool;
    if ((!paramString.vY()) && (!paramString.isGif()))
    {
      bool = true;
      parambi.setContent(ap.a((String)localObject2, 0L, bool, localas.cqq, false, ""));
      if (!paramString.dzn())
      {
        paramString = com.tencent.mm.plugin.backup.h.d.aUK().aUL().YP();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label441;
        }
        com.tencent.mm.plugin.backup.b.g.b(paramgx, 4, paramString + localas.cqq + "_thumb");
        com.tencent.mm.plugin.backup.b.g.b(paramgx, 5, paramString + localas.cqq);
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.l(parambi))));
      AppMethodBeat.o(17450);
      return 0;
      bool = false;
      break;
      label441:
      localObject2 = new com.tencent.mm.vfs.b(paramString + (String)localObject1);
      if (!((com.tencent.mm.vfs.b)localObject2).exists()) {
        ((com.tencent.mm.vfs.b)localObject2).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramgx, 4, paramString + (String)localObject1 + "/" + localas.cqq + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramgx, 5, paramString + (String)localObject1 + "/" + localas.cqq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */