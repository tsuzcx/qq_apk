package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public enum b
  implements p
{
  static
  {
    AppMethodBeat.i(222846);
    lYB = new b("INSTANCE");
    lYC = new b[] { lYB };
    AppMethodBeat.o(222846);
  }
  
  private b() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(222845);
    if ((paramString == null) || (!paramString.equals("wxaapp_msgchannel")))
    {
      ae.e("MicroMsg.WxaAppMsgChannelHandler", "subType is err, return");
      AppMethodBeat.o(222845);
      return null;
    }
    ae.i("MicroMsg.WxaAppMsgChannelHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str5 = z.a(parama.gte.FNI);
    if (bu.isNullOrNil(str5))
    {
      ae.w("MicroMsg.WxaAppMsgChannelHandler", "msg content is null");
      AppMethodBeat.o(222845);
      return null;
    }
    if (paramMap.get(".sysmsg.wxaapp_msgchannel") == null)
    {
      AppMethodBeat.o(222845);
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_id");
    String str1 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.sender_openid");
    String str2 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.receiver_openid");
    String str3 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.appid");
    int i = bu.getInt((String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_type"), 0);
    String str4 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_content");
    long l = bu.getLong((String)paramMap.get(".sysmsg.wxaapp_msgchannel.send_time"), 0L);
    ae.i("MicroMsg.WxaAppMsgChannelHandler", "handle addMsg.MsgId:%s", new Object[] { parama.gte.xrk });
    ae.i("MicroMsg.WxaAppMsgChannelHandler", "handle wxaapp_msgchannel xml:%s", new Object[] { str5 });
    ae.i("MicroMsg.WxaAppMsgChannelHandler", "msgId:%s, senderOpenId:%s, receiverOpenId:%s, appId:%s, msgType:%d, msgContent:%s, sendTime:%d", new Object[] { paramString, str1, str2, str3, Integer.valueOf(i), str4, Long.valueOf(l) });
    paramMap = new WxaAppMsgChannel();
    paramMap.msgId = paramString;
    paramMap.lYz = str1;
    paramMap.lYA = str2;
    paramMap.appId = str3;
    paramMap.msgType = i;
    paramMap.dEU = str4;
    paramMap.kdZ = l;
    e.b(str3, paramMap);
    AppMethodBeat.o(222845);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.b
 * JD-Core Version:    0.7.0.1
 */