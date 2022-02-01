package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(if paramif, boolean paramBoolean1, bv parambv, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (bu.isNullOrNil(parambv.field_content))
    {
      i = 0;
      paramLinkedList = az.aVt(parambv.field_content).Jfn.trim();
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.WF(paramLinkedList))
      {
        paramString = parambv.field_content.replace("*#*", ":");
        j = paramString.indexOf("<msg");
        ae.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(j) });
        if (j >= 0) {
          break label218;
        }
        paramLinkedList = null;
      }
    }
    for (;;)
    {
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.WF(paramLinkedList))
      {
        paramLinkedList = g.a.a(parambv, paramif);
        paramString = paramLinkedList;
        if (parambv.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.wb(parambv.field_talker)) {
            paramString = parambv.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.WF(paramString))) {
        break label311;
      }
      ae.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(21508);
      return -1;
      i = parambv.field_content.getBytes().length;
      break;
      label218:
      paramHashMap = paramString.substring(0, j).split(":");
      j = paramString.substring(0, j).lastIndexOf(":");
      ae.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(paramHashMap.length) });
      paramLinkedList = paramString;
      if (paramHashMap.length >= 5) {
        paramLinkedList = paramHashMap[4] + paramString.substring(j);
      }
    }
    label311:
    parambv = new cxn();
    parambv.aQV(bu.bI(paramString, ""));
    paramif.FNI = parambv;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, if paramif, bv parambv)
  {
    AppMethodBeat.i(21509);
    parambv.setContent(paramif.FNI.HId);
    paramString = paramif.FNG.HId;
    Object localObject1 = paramif.FNH.HId;
    if (((String)com.tencent.mm.plugin.backup.h.d.bJW().bJX().ajA().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    bd localbd;
    for (;;)
    {
      localObject1 = paramif.FNI.HId;
      localObject2 = bx.M((String)localObject1, "msg");
      localbd = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fB((String)localObject1, paramString);
      if (localbd != null) {
        break;
      }
      ae.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(localbd.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.h.b.b(localbd, paramString);
      paramString.field_catalog = EmojiInfo.OzU;
      com.tencent.mm.plugin.backup.h.d.bJW().bJX().bJU().I(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.WI(localbd.md5);
      if (!bu.isNullOrNil((String)localObject1))
      {
        localbd.md5 = ((String)localObject1);
        ae.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localbd.dpp;
    parambv.setType(47);
    parambv.uj(localbd.md5);
    Object localObject2 = localbd.iwS;
    if ((!paramString.Ee()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      parambv.setContent(az.a((String)localObject2, 0L, bool, localbd.md5, false, ""));
      if (paramString.fxn()) {
        break label451;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bJW().bJX();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.gDT + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      com.tencent.mm.plugin.backup.b.g.b(paramif, 4, paramString + localbd.md5 + "_thumb");
      com.tencent.mm.plugin.backup.b.g.b(paramif, 5, paramString + localbd.md5);
    }
    for (;;)
    {
      label451:
      ae.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.v(parambv))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new k(paramString + (String)localObject1);
      if (!((k)localObject2).exists()) {
        ((k)localObject2).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramif, 4, paramString + (String)localObject1 + "/" + localbd.md5 + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramif, 5, paramString + (String)localObject1 + "/" + localbd.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */