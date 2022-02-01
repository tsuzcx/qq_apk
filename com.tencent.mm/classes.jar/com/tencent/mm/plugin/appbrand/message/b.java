package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public enum b
  implements o
{
  static
  {
    AppMethodBeat.i(186881);
    luP = new b("INSTANCE");
    luQ = new b[] { luP };
    AppMethodBeat.o(186881);
  }
  
  private b() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(186880);
    if ((paramString == null) || (!paramString.equals("wxaapp_msgchannel")))
    {
      ac.e("MicroMsg.WxaAppMsgChannelHandler", "subType is err, return");
      AppMethodBeat.o(186880);
      return null;
    }
    ac.i("MicroMsg.WxaAppMsgChannelHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str5 = z.a(parama.fXi.DPV);
    if (bs.isNullOrNil(str5))
    {
      ac.w("MicroMsg.WxaAppMsgChannelHandler", "msg content is null");
      AppMethodBeat.o(186880);
      return null;
    }
    if (paramMap.get(".sysmsg.wxaapp_msgchannel") == null)
    {
      AppMethodBeat.o(186880);
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_id");
    String str1 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.sender_openid");
    String str2 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.receiver_openid");
    String str3 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.appid");
    int i = bs.getInt((String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_type"), 0);
    String str4 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_content");
    long l = bs.getLong((String)paramMap.get(".sysmsg.wxaapp_msgchannel.send_time"), 0L);
    ac.i("MicroMsg.WxaAppMsgChannelHandler", "handle addMsg.MsgId:%s", new Object[] { parama.fXi.vTQ });
    ac.i("MicroMsg.WxaAppMsgChannelHandler", "handle wxaapp_msgchannel xml:%s", new Object[] { str5 });
    ac.i("MicroMsg.WxaAppMsgChannelHandler", "msgId:%s, senderOpenId:%s, receiverOpenId:%s, appId:%s, msgType:%d, msgContent:%s, sendTime:%d", new Object[] { paramString, str1, str2, str3, Integer.valueOf(i), str4, Long.valueOf(l) });
    paramMap = new WxaAppMsgChannel();
    paramMap.dtG = paramString;
    paramMap.luN = str1;
    paramMap.luO = str2;
    paramMap.appId = str3;
    paramMap.msgType = i;
    paramMap.drV = str4;
    paramMap.jGx = l;
    e.b(str3, paramMap);
    AppMethodBeat.o(186880);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.b
 * JD-Core Version:    0.7.0.1
 */