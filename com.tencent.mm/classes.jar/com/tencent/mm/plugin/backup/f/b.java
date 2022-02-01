package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(hu paramhu, boolean paramBoolean1, bl parambl, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (bt.isNullOrNil(parambl.field_content))
    {
      i = 0;
      paramLinkedList = ar.aIF(parambl.field_content).Fys.trim();
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.Ol(paramLinkedList))
      {
        paramString = parambl.field_content.replace("*#*", ":");
        j = paramString.indexOf("<msg");
        ad.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(j) });
        if (j >= 0) {
          break label218;
        }
        paramLinkedList = null;
      }
    }
    for (;;)
    {
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.Ol(paramLinkedList))
      {
        paramLinkedList = g.a.a(parambl, paramhu);
        paramString = paramLinkedList;
        if (parambl.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.pF(parambl.field_talker)) {
            paramString = parambl.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.Ol(paramString))) {
        break label311;
      }
      ad.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(21508);
      return -1;
      i = parambl.field_content.getBytes().length;
      break;
      label218:
      paramHashMap = paramString.substring(0, j).split(":");
      j = paramString.substring(0, j).lastIndexOf(":");
      ad.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(paramHashMap.length) });
      paramLinkedList = paramString;
      if (paramHashMap.length >= 5) {
        paramLinkedList = paramHashMap[4] + paramString.substring(j);
      }
    }
    label311:
    parambl = new cmf();
    parambl.aEE(bt.by(paramString, ""));
    paramhu.Cxz = parambl;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, hu paramhu, bl parambl)
  {
    AppMethodBeat.i(21509);
    parambl.setContent(paramhu.Cxz.Ehn);
    paramString = paramhu.Cxx.Ehn;
    Object localObject1 = paramhu.Cxy.Ehn;
    if (((String)com.tencent.mm.plugin.backup.h.d.bxT().bxU().afk().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    av localav;
    for (;;)
    {
      localObject1 = paramhu.Cxz.Ehn;
      localObject2 = bw.K((String)localObject1, "msg");
      localav = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fa((String)localObject1, paramString);
      if (localav != null) {
        break;
      }
      ad.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(localav.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.h.b.b(localav, paramString);
      paramString.field_catalog = EmojiInfo.LBQ;
      com.tencent.mm.plugin.backup.h.d.bxT().bxU().bxR().J(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.Oo(localav.md5);
      if (!bt.isNullOrNil((String)localObject1))
      {
        localav.md5 = ((String)localObject1);
        ad.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localav.dft;
    parambl.setType(47);
    parambl.nZ(localav.md5);
    Object localObject2 = localav.hAb;
    if ((!paramString.CZ()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      parambl.setContent(ar.a((String)localObject2, 0L, bool, localav.md5, false, ""));
      if (paramString.fZM()) {
        break label451;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bxT().bxU();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.gcW + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      com.tencent.mm.plugin.backup.b.g.b(paramhu, 4, paramString + localav.md5 + "_thumb");
      com.tencent.mm.plugin.backup.b.g.b(paramhu, 5, paramString + localav.md5);
    }
    for (;;)
    {
      label451:
      ad.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.u(parambl))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new e(paramString + (String)localObject1);
      if (!((e)localObject2).exists()) {
        ((e)localObject2).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramhu, 4, paramString + (String)localObject1 + "/" + localav.md5 + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramhu, 5, paramString + (String)localObject1 + "/" + localav.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */