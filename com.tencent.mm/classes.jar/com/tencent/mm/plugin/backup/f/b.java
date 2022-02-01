package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(if paramif, boolean paramBoolean1, bu parambu, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (bt.isNullOrNil(parambu.field_content))
    {
      i = 0;
      paramLinkedList = ay.aTS(parambu.field_content).IKG.trim();
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.VT(paramLinkedList))
      {
        paramString = parambu.field_content.replace("*#*", ":");
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
      if (!com.tencent.mm.plugin.backup.b.g.VT(paramLinkedList))
      {
        paramLinkedList = g.a.a(parambu, paramif);
        paramString = paramLinkedList;
        if (parambu.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.vF(parambu.field_talker)) {
            paramString = parambu.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.VT(paramString))) {
        break label311;
      }
      ad.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(21508);
      return -1;
      i = parambu.field_content.getBytes().length;
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
    parambu = new cwt();
    parambu.aPy(bt.bI(paramString, ""));
    paramif.Fvk = parambu;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, if paramif, bu parambu)
  {
    AppMethodBeat.i(21509);
    parambu.setContent(paramif.Fvk.HoB);
    paramString = paramif.Fvi.HoB;
    Object localObject1 = paramif.Fvj.HoB;
    if (((String)com.tencent.mm.plugin.backup.h.d.bIY().bIZ().ajl().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    bc localbc;
    for (;;)
    {
      localObject1 = paramif.Fvk.HoB;
      localObject2 = bw.M((String)localObject1, "msg");
      localbc = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fx((String)localObject1, paramString);
      if (localbc != null) {
        break;
      }
      ad.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(localbc.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.h.b.b(localbc, paramString);
      paramString.field_catalog = EmojiInfo.OeN;
      com.tencent.mm.plugin.backup.h.d.bIY().bIZ().bIW().I(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.VW(localbc.md5);
      if (!bt.isNullOrNil((String)localObject1))
      {
        localbc.md5 = ((String)localObject1);
        ad.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localbc.dok;
    parambu.setType(47);
    parambu.tO(localbc.md5);
    Object localObject2 = localbc.itY;
    if ((!paramString.Eb()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      parambu.setContent(ay.a((String)localObject2, 0L, bool, localbc.md5, false, ""));
      if (paramString.fOu()) {
        break label451;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bIY().bIZ();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.gBm + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      com.tencent.mm.plugin.backup.b.g.b(paramif, 4, paramString + localbc.md5 + "_thumb");
      com.tencent.mm.plugin.backup.b.g.b(paramif, 5, paramString + localbc.md5);
    }
    for (;;)
    {
      label451:
      ad.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.v(parambu))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new e(paramString + (String)localObject1);
      if (!((e)localObject2).exists()) {
        ((e)localObject2).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramif, 4, paramString + (String)localObject1 + "/" + localbc.md5 + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramif, 5, paramString + (String)localObject1 + "/" + localbc.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */