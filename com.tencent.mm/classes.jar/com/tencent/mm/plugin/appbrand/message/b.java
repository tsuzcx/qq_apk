package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public enum b
  implements p
{
  static
  {
    AppMethodBeat.i(227197);
    ngh = new b("INSTANCE");
    ngi = new b[] { ngh };
    AppMethodBeat.o(227197);
  }
  
  private b() {}
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(227196);
    if ((paramString == null) || (!paramString.equals("wxaapp_msgchannel")))
    {
      Log.e("MicroMsg.WxaAppMsgChannelHandler", "subType is err, return");
      AppMethodBeat.o(227196);
      return null;
    }
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str5 = z.a(parama.heO.KHn);
    if (Util.isNullOrNil(str5))
    {
      Log.w("MicroMsg.WxaAppMsgChannelHandler", "msg content is null");
      AppMethodBeat.o(227196);
      return null;
    }
    if (paramMap.get(".sysmsg.wxaapp_msgchannel") == null)
    {
      AppMethodBeat.o(227196);
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_id");
    String str1 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.sender_openid");
    String str2 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.receiver_openid");
    String str3 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.appid");
    int i = Util.getInt((String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_type"), 0);
    String str4 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_content");
    long l = Util.getLong((String)paramMap.get(".sysmsg.wxaapp_msgchannel.send_time"), 0L);
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "handle addMsg.MsgId:%s", new Object[] { parama.heO.Brn });
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "handle wxaapp_msgchannel xml:%s", new Object[] { str5 });
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "msgId:%s, senderOpenId:%s, receiverOpenId:%s, appId:%s, msgType:%d, msgContent:%s, sendTime:%d", new Object[] { paramString, str1, str2, str3, Integer.valueOf(i), str4, Long.valueOf(l) });
    paramMap = new WxaAppMsgChannel();
    paramMap.msgId = paramString;
    paramMap.ngf = str1;
    paramMap.ngg = str2;
    paramMap.appId = str3;
    paramMap.msgType = i;
    paramMap.dWG = str4;
    paramMap.lhG = l;
    e.b(str3, paramMap);
    AppMethodBeat.o(227196);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.b
 * JD-Core Version:    0.7.0.1
 */