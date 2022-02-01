package com.tencent.mm.plugin.backup.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.backup.b.g.a;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class b
  implements l
{
  public final int a(hy paramhy, boolean paramBoolean1, bo parambo, String paramString, LinkedList<u> paramLinkedList, HashMap<Long, h.a> paramHashMap, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(21508);
    int i;
    int j;
    if (bs.isNullOrNil(parambo.field_content))
    {
      i = 0;
      paramLinkedList = au.aOb(parambo.field_content).GXs.trim();
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.Sv(paramLinkedList))
      {
        paramString = parambo.field_content.replace("*#*", ":");
        j = paramString.indexOf("<msg");
        ac.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(j) });
        if (j >= 0) {
          break label218;
        }
        paramLinkedList = null;
      }
    }
    for (;;)
    {
      paramString = paramLinkedList;
      if (!com.tencent.mm.plugin.backup.b.g.Sv(paramLinkedList))
      {
        paramLinkedList = g.a.a(parambo, paramhy);
        paramString = paramLinkedList;
        if (parambo.field_isSend != 1)
        {
          paramString = paramLinkedList;
          if (c.sQ(parambo.field_talker)) {
            paramString = parambo.field_talker + " :\n " + paramLinkedList;
          }
        }
      }
      if ((paramString != null) && (com.tencent.mm.plugin.backup.b.g.Sv(paramString))) {
        break label311;
      }
      ac.d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(21508);
      return -1;
      i = parambo.field_content.getBytes().length;
      break;
      label218:
      paramHashMap = paramString.substring(0, j).split(":");
      j = paramString.substring(0, j).lastIndexOf(":");
      ac.i("MicroMsg.emoji.EmojiContent", "getOriginContent: %s", new Object[] { Integer.valueOf(paramHashMap.length) });
      paramLinkedList = paramString;
      if (paramHashMap.length >= 5) {
        paramLinkedList = paramHashMap[4] + paramString.substring(j);
      }
    }
    label311:
    parambo = new crm();
    parambo.aJV(bs.bG(paramString, ""));
    paramhy.DPV = parambo;
    AppMethodBeat.o(21508);
    return i;
  }
  
  public final int a(String paramString, hy paramhy, bo parambo)
  {
    AppMethodBeat.i(21509);
    parambo.setContent(paramhy.DPV.FEm);
    paramString = paramhy.DPT.FEm;
    Object localObject1 = paramhy.DPU.FEm;
    if (((String)com.tencent.mm.plugin.backup.h.d.bEP().bEQ().agA().get(2, null)).equals(paramString)) {
      paramString = (String)localObject1;
    }
    ay localay;
    for (;;)
    {
      localObject1 = paramhy.DPV.FEm;
      localObject2 = bv.L((String)localObject1, "msg");
      localay = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().fn((String)localObject1, paramString);
      if (localay != null) {
        break;
      }
      ac.w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
      AppMethodBeat.o(21509);
      return -1;
    }
    localObject1 = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(localay.md5);
    paramString = (String)localObject1;
    if (localObject1 == null)
    {
      paramString = new EmojiInfo();
      com.tencent.mm.plugin.emoji.h.b.b(localay, paramString);
      paramString.field_catalog = EmojiInfo.Jss;
      com.tencent.mm.plugin.backup.h.d.bEP().bEQ().bEN().J(paramString);
    }
    if (((Map)localObject2).get(".msg.emoji.$androidmd5") == null)
    {
      localObject1 = g.a.Sy(localay.md5);
      if (!bs.isNullOrNil((String)localObject1))
      {
        localay.md5 = ((String)localObject1);
        ac.d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", new Object[] { localObject1 });
      }
    }
    localObject1 = localay.dcO;
    parambo.setType(47);
    parambo.rf(localay.md5);
    Object localObject2 = localay.iaC;
    if ((!paramString.CC()) && (!paramString.isGif())) {}
    for (boolean bool = true;; bool = false)
    {
      parambo.setContent(au.a((String)localObject2, 0L, bool, localay.md5, false, ""));
      if (paramString.fdp()) {
        break label451;
      }
      paramString = com.tencent.mm.plugin.backup.h.d.bEP().bEQ();
      if (paramString.uin != 0) {
        break;
      }
      paramString = new com.tencent.mm.model.b();
      AppMethodBeat.o(21509);
      throw paramString;
    }
    paramString = paramString.ghC + "emoji/";
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      com.tencent.mm.plugin.backup.b.g.b(paramhy, 4, paramString + localay.md5 + "_thumb");
      com.tencent.mm.plugin.backup.b.g.b(paramhy, 5, paramString + localay.md5);
    }
    for (;;)
    {
      label451:
      ac.d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(c.u(parambo))));
      AppMethodBeat.o(21509);
      return 0;
      localObject2 = new e(paramString + (String)localObject1);
      if (!((e)localObject2).exists()) {
        ((e)localObject2).mkdirs();
      }
      com.tencent.mm.plugin.backup.b.g.b(paramhy, 4, paramString + (String)localObject1 + "/" + localay.md5 + "_cover");
      com.tencent.mm.plugin.backup.b.g.b(paramhy, 5, paramString + (String)localObject1 + "/" + localay.md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.b
 * JD-Core Version:    0.7.0.1
 */