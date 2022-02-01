package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(ih paramih, boolean paramBoolean1, ca paramca, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (Util.isNullOrNil(paramca.field_content))
    {
      i = 0;
      paramLinkedList = be.bwQ(paramca.field_content).VFa.trim();
      paramString = paramLinkedList;
      if (!g.aof(paramLinkedList))
      {
        paramString = paramca.field_content.replace("*#*", ":");
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
      if (!g.aof(paramLinkedList))
      {
        paramLinkedList = g.a.a(paramca, paramih);
        paramString = paramLinkedList;
        if (paramca.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.Lj(paramca.field_talker)) {
            paramString = paramca.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (g.aof(paramString))) {
        break label321;
      }
      Log.d("MicroMsg.BackupItemEmoji", "emoji error:" + Util.secPrint(paramString));
      AppMethodBeat.o(21508);
      return -1;
      i = paramca.field_content.getBytes().length;
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
    paramca = new eaf();
    paramca.btQ(Util.nullAs(paramString, ""));
    paramih.RIF = paramca;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, ih paramih, ca paramca)
  {
    AppMethodBeat.i(21509);
    paramca.setContent(paramih.RIF.Ufy);
    paramString = paramih.RID.Ufy;
    Object localObject1 = paramih.RIE.Ufy;
    if (((String)com.tencent.mm.plugin.backup.h.d.cua().cub().aHp().b(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    bi localbi;
    for (;;)
    {
      localObject1 = paramih.RIF.Ufy;
      localObject2 = XmlParser.parseXml((String)localObject1, "msg", null);
      localbi = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().gg((String)localObject1, paramString);
      if (localbi != null) {
        break;
      }
      Log.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(localbi.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.i.b.b(localbi, paramString);
      paramString.field_catalog = EmojiInfo.YCx;
      com.tencent.mm.plugin.backup.h.d.cua().cub().ctY().K(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.aoi(localbi.md5);
      if (!Util.isNullOrNil((String)localObject1))
      {
        localbi.md5 = ((String)localObject1);
        Log.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localbi.productId;
    paramca.setType(47);
    paramca.Jn(localbi.md5);
    Object localObject2 = localbi.mhK;
    if ((!paramString.Qv()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      paramca.setContent(be.a((String)localObject2, 0L, bool, localbi.md5, false, ""));
      if (paramString.hBp()) {
        break label452;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.cua().cub();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.kcB + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      g.b(paramih, 4, paramString + localbi.md5 + "_thumb");
      g.b(paramih, 5, paramString + localbi.md5);
    }
    for (;;)
    {
      label452:
      Log.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.z(paramca))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new q(paramString + (String)localObject1);
      if (!((q)localObject2).ifE()) {
        ((q)localObject2).ifL();
      }
      g.b(paramih, 4, paramString + (String)localObject1 + "/" + localbi.md5 + "_cover");
      g.b(paramih, 5, paramString + (String)localObject1 + "/" + localbi.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */