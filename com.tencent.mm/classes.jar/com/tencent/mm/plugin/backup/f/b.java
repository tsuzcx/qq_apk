package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(is paramis, boolean paramBoolean1, ca paramca, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (Util.isNullOrNil(paramca.field_content))
    {
      i = 0;
      paramLinkedList = be.bkr(paramca.field_content).Oph.trim();
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.agB(paramLinkedList))
      {
        paramString = paramca.field_content.replace("*#*", ":");
        j = paramString.indexOf("<msg");
        Log.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(j) });
        if (j >= 0) {
          break label218;
        }
        paramLinkedList = null;
      }
    }
    for (;;)
    {
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.agB(paramLinkedList))
      {
        paramLinkedList = g.a.a(paramca, paramis);
        paramString = paramLinkedList;
        if (paramca.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.Eq(paramca.field_talker)) {
            paramString = paramca.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.agB(paramString))) {
        break label311;
      }
      Log.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(21508);
      return -1;
      i = paramca.field_content.getBytes().length;
      break;
      label218:
      paramHashMap = paramString.substring(0, j).split(":");
      j = paramString.substring(0, j).lastIndexOf(":");
      Log.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(paramHashMap.length) });
      paramLinkedList = paramString;
      if (paramHashMap.length >= 5) {
        paramLinkedList = paramHashMap[4] + paramString.substring(j);
      }
    }
    label311:
    paramca = new dqi();
    paramca.bhy(Util.nullAs(paramString, ""));
    paramis.KHn = paramca;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, is paramis, ca paramca)
  {
    AppMethodBeat.i(21509);
    paramca.setContent(paramis.KHn.MTo);
    paramString = paramis.KHl.MTo;
    Object localObject1 = paramis.KHm.MTo;
    if (((String)com.tencent.mm.plugin.backup.h.d.cgP().cgQ().azQ().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    bi localbi;
    for (;;)
    {
      localObject1 = paramis.KHn.MTo;
      localObject2 = XmlParser.parseXml((String)localObject1, "msg", null);
      localbi = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fT((String)localObject1, paramString);
      if (localbi != null) {
        break;
      }
      Log.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(localbi.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.h.b.b(localbi, paramString);
      paramString.field_catalog = EmojiInfo.Uup;
      com.tencent.mm.plugin.backup.h.d.cgP().cgQ().cgN().J(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.agE(localbi.md5);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localbi.md5 = ((String)localObject1);
        Log.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localbi.productId;
    paramca.setType(47);
    paramca.Cz(localbi.md5);
    Object localObject2 = localbi.jsh;
    if ((!paramString.NA()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      paramca.setContent(be.a((String)localObject2, 0L, bool, localbi.md5, false, ""));
      if (paramString.hRx()) {
        break label452;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cgP().cgQ();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.hqG + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      com.tencent.mm.plugin.backup.b.g.b(paramis, 4, paramString + localbi.md5 + "_thumb");
      com.tencent.mm.plugin.backup.b.g.b(paramis, 5, paramString + localbi.md5);
    }
    for (;;)
    {
      label452:
      Log.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.x(paramca))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new o(paramString + (String)localObject1);
      if (!((o)localObject2).exists()) {
        ((o)localObject2).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramis, 4, paramString + (String)localObject1 + "/" + localbi.md5 + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramis, 5, paramString + (String)localObject1 + "/" + localbi.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */