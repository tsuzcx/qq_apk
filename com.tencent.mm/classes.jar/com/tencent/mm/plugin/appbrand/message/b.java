package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.appbrand.ipc.f;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public enum b
  implements s
{
  static
  {
    AppMethodBeat.i(317184);
    tlC = new b("INSTANCE");
    tlD = new b[] { tlC };
    AppMethodBeat.o(317184);
  }
  
  private b() {}
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(317187);
    if ((paramString == null) || (!paramString.equals("wxaapp_msgchannel")))
    {
      Log.e("MicroMsg.WxaAppMsgChannelHandler", "subType is err, return");
      AppMethodBeat.o(317187);
      return null;
    }
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str5 = w.a(parama.mpN.YFG);
    if (Util.isNullOrNil(str5))
    {
      Log.w("MicroMsg.WxaAppMsgChannelHandler", "msg content is null");
      AppMethodBeat.o(317187);
      return null;
    }
    if (paramMap.get(".sysmsg.wxaapp_msgchannel") == null)
    {
      AppMethodBeat.o(317187);
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_id");
    String str1 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.sender_openid");
    String str2 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.receiver_openid");
    String str3 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.appid");
    int i = Util.getInt((String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_type"), 0);
    String str4 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_content");
    long l = Util.getLong((String)paramMap.get(".sysmsg.wxaapp_msgchannel.send_time"), 0L);
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "handle addMsg.MsgId:%s", new Object[] { parama.mpN.Njv });
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "handle wxaapp_msgchannel xml:%s", new Object[] { str5 });
    Log.i("MicroMsg.WxaAppMsgChannelHandler", "msgId:%s, senderOpenId:%s, receiverOpenId:%s, appId:%s, msgType:%d, msgContent:%s, sendTime:%d", new Object[] { paramString, str1, str2, str3, Integer.valueOf(i), str4, Long.valueOf(l) });
    paramMap = new WxaAppMsgChannel();
    paramMap.msgId = paramString;
    paramMap.tlA = str1;
    paramMap.tlB = str2;
    paramMap.appId = str3;
    paramMap.msgType = i;
    paramMap.hWn = str4;
    paramMap.rdg = l;
    f.b(str3, paramMap);
    AppMethodBeat.o(317187);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.b
 * JD-Core Version:    0.7.0.1
 */