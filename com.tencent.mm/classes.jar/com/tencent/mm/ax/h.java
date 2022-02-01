package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class h
  implements s
{
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
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
        parama = new cc();
        parama.pI(0);
        parama.BS(paramMap);
        parama.setStatus(3);
        parama.setContent(paramString);
        parama.setCreateTime(br.D(paramMap, System.currentTimeMillis() / 1000L));
        parama.setType(10000);
        parama.setFlag(parama.field_flag | 0x8);
        l = br.B(parama);
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
    ar localar = ((b)com.tencent.mm.kernel.h.ax(b.class)).bzK();
    String str1 = w.a(parama.mpN.YFE);
    String str2 = w.a(parama.mpN.YFF);
    aj localaj;
    if (z.bAM().equals(str1))
    {
      localaj = localar.Ju(str2);
      paramString = localaj;
      if (localaj == null)
      {
        paramString = new aj();
        paramString.field_chatroomname = str2;
      }
      paramString.field_chatroomnoticeEditor = str1;
      label338:
      paramString.field_chatroomnoticePublishTime = parama.mpN.CreateTime;
      paramMap = (String)paramMap.get(".sysmsg.mmchatroombarannouncememt.content");
      if ((Util.isNullOrNil(paramMap)) || (paramMap.equals(paramString.field_chatroomnotice))) {
        break label455;
      }
      paramString.field_chatroomNoticeNew = 1;
    }
    for (;;)
    {
      paramString.field_chatroomnotice = paramMap;
      localar.replace(paramString);
      break;
      localaj = localar.Ju(str1);
      paramString = localaj;
      if (localaj == null)
      {
        paramString = new aj();
        paramString.field_chatroomname = str1;
      }
      paramString.field_chatroomnoticeEditor = br.JJ(parama.mpN.YFG.abwM);
      break label338;
      label455:
      if (Util.isNullOrNil(paramMap)) {
        paramString.field_chatroomNoticeNew = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ax.h
 * JD-Core Version:    0.7.0.1
 */