package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class h
  implements s
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(184639);
    Log.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", new Object[] { Util.nullAs(paramString, "") });
    if (Util.nullAsNil(paramString).equals("NewXmlUpgradeAssociateChatRoom")) {
      if (paramMap != null)
      {
        if (!paramMap.containsKey(".sysmsg.NewXmlUpgradeAssociateChatRoom.text")) {
          break label230;
        }
        paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.text"));
        paramMap = Util.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.roomname"));
        if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramMap))) {
          break label200;
        }
        parama = new ca();
        parama.pJ(0);
        parama.Jm(paramMap);
        parama.setStatus(3);
        parama.setContent(paramString);
        parama.setCreateTime(bq.z(paramMap, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        l = bq.z(parama);
        Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", new Object[] { paramMap, Util.secPrint(paramString), Long.valueOf(l) });
      }
    }
    label200:
    label230:
    while (!"mmchatroombarannouncememt".equals(paramString)) {
      for (;;)
      {
        long l;
        AppMethodBeat.o(184639);
        return null;
        Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", new Object[] { Util.nullAs(paramMap, ""), Util.secPrint(paramString) });
        continue;
        Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
      }
    }
    aq localaq = ((b)com.tencent.mm.kernel.h.ae(b.class)).bbV();
    String str1 = com.tencent.mm.platformtools.z.a(parama.jQG.RID);
    String str2 = com.tencent.mm.platformtools.z.a(parama.jQG.RIE);
    ah localah;
    if (com.tencent.mm.model.z.bcZ().equals(str1))
    {
      localah = localaq.Rw(str2);
      paramString = localah;
      if (localah == null)
      {
        paramString = new ah();
        paramString.field_chatroomname = str2;
      }
      paramString.field_chatroomnoticeEditor = str1;
      label338:
      paramString.field_chatroomnoticePublishTime = parama.jQG.CreateTime;
      paramMap = (String)paramMap.get(".sysmsg.mmchatroombarannouncememt.content");
      if ((Util.isNullOrNil(paramMap)) || (paramMap.equals(paramString.field_chatroomnotice))) {
        break label455;
      }
      paramString.field_chatroomNoticeNew = 1;
    }
    for (;;)
    {
      paramString.field_chatroomnotice = paramMap;
      localaq.replace(paramString);
      break;
      localah = localaq.Rw(str1);
      paramString = localah;
      if (localah == null)
      {
        paramString = new ah();
        paramString.field_chatroomname = str1;
      }
      paramString.field_chatroomnoticeEditor = bq.RL(parama.jQG.RIF.Ufy);
      break label338;
      label455:
      if (Util.isNullOrNil(paramMap)) {
        paramString.field_chatroomNoticeNew = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.h
 * JD-Core Version:    0.7.0.1
 */