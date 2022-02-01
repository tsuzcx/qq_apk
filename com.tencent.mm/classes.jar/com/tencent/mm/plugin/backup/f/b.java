package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(jd paramjd, boolean paramBoolean1, cc paramcc, String paramString, LinkedList<com.tencent.mm.plugin.backup.i.u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (Util.isNullOrNil(paramcc.field_content))
    {
      i = 0;
      paramLinkedList = bg.byj(paramcc.field_content).adiN.trim();
      paramString = paramLinkedList;
      if (!g.ahC(paramLinkedList))
      {
        paramString = paramcc.field_content.replace("*#*", ":");
        j = paramString.indexOf("<msg");
        Log.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(j) });
        if (j >= 0) {
          break label228;
        }
        paramLinkedList = null;
      }
    }
    for (;;)
    {
      paramString = paramLinkedList;
      if (!g.ahC(paramLinkedList))
      {
        paramLinkedList = g.a.a(paramcc, paramjd);
        paramString = paramLinkedList;
        if (paramcc.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.DQ(paramcc.field_talker)) {
            paramString = paramcc.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (g.ahC(paramString))) {
        break label321;
      }
      Log.d("MicroMsg.BackupItemEmoji", "emoji error:" + Util.secPrint(paramString));
      AppMethodBeat.o(21508);
      return -1;
      i = paramcc.field_content.getBytes().length;
      break;
      label228:
      paramHashMap = paramString.substring(0, j).split(":");
      j = paramString.substring(0, j).lastIndexOf(":");
      Log.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(paramHashMap.length) });
      paramLinkedList = paramString;
      if (paramHashMap.length >= 5) {
        paramLinkedList = paramHashMap[4] + paramString.substring(j);
      }
    }
    label321:
    paramcc = new etl();
    paramcc.btH(Util.nullAs(paramString, ""));
    paramjd.YFG = paramcc;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, jd paramjd, cc paramcc)
  {
    AppMethodBeat.i(21509);
    paramcc.setContent(paramjd.YFG.abwM);
    paramString = paramjd.YFE.abwM;
    Object localObject1 = paramjd.YFF.abwM;
    if (((String)com.tencent.mm.plugin.backup.h.d.cWK().cWL().ban().d(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    bk localbk;
    for (;;)
    {
      localObject1 = paramjd.YFG.abwM;
      localObject2 = XmlParser.parseXml((String)localObject1, "msg", null);
      localbk = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().gM((String)localObject1, paramString);
      if (localbk != null) {
        break;
      }
      Log.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(localbk.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.g.d.b(localbk, paramString);
      paramString.field_catalog = EmojiInfo.aklG;
      com.tencent.mm.plugin.backup.h.d.cWK().cWL().cWI().K(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.ahF(localbk.md5);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localbk.md5 = ((String)localObject1);
        Log.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localbk.productId;
    paramcc.setType(47);
    paramcc.BT(localbk.md5);
    Object localObject2 = localbk.paV;
    if ((!paramString.aqJ()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      paramcc.setContent(bg.a((String)localObject2, 0L, bool, localbk.md5, false, ""));
      if (paramString.kLZ()) {
        break label452;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cWK().cWL();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.mCJ + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      g.b(paramjd, 4, paramString + localbk.md5 + "_thumb");
      g.b(paramjd, 5, paramString + localbk.md5);
    }
    for (;;)
    {
      label452:
      Log.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.B(paramcc))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new com.tencent.mm.vfs.u(paramString + (String)localObject1);
      if (!((com.tencent.mm.vfs.u)localObject2).jKS()) {
        ((com.tencent.mm.vfs.u)localObject2).jKY();
      }
      g.b(paramjd, 4, paramString + (String)localObject1 + "/" + localbk.md5 + "_cover");
      g.b(paramjd, 5, paramString + (String)localObject1 + "/" + localbk.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */