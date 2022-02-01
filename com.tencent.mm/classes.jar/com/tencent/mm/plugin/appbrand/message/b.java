package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public enum b
  implements p
{
  static
  {
    AppMethodBeat.i(188676);
    lTY = new b("INSTANCE");
    lTZ = new b[] { lTY };
    AppMethodBeat.o(188676);
  }
  
  private b() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(188675);
    if ((paramString == null) || (!paramString.equals("wxaapp_msgchannel")))
    {
      ad.e("MicroMsg.WxaAppMsgChannelHandler", "subType is err, return");
      AppMethodBeat.o(188675);
      return null;
    }
    ad.i("MicroMsg.WxaAppMsgChannelHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str5 = z.a(parama.gqE.Fvk);
    if (bt.isNullOrNil(str5))
    {
      ad.w("MicroMsg.WxaAppMsgChannelHandler", "msg content is null");
      AppMethodBeat.o(188675);
      return null;
    }
    if (paramMap.get(".sysmsg.wxaapp_msgchannel") == null)
    {
      AppMethodBeat.o(188675);
      return null;
    }
    paramString = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_id");
    String str1 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.sender_openid");
    String str2 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.receiver_openid");
    String str3 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.appid");
    int i = bt.getInt((String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_type"), 0);
    String str4 = (String)paramMap.get(".sysmsg.wxaapp_msgchannel.msg_content");
    long l = bt.getLong((String)paramMap.get(".sysmsg.wxaapp_msgchannel.send_time"), 0L);
    ad.i("MicroMsg.WxaAppMsgChannelHandler", "handle addMsg.MsgId:%s", new Object[] { parama.gqE.xbt });
    ad.i("MicroMsg.WxaAppMsgChannelHandler", "handle wxaapp_msgchannel xml:%s", new Object[] { str5 });
    ad.i("MicroMsg.WxaAppMsgChannelHandler", "msgId:%s, senderOpenId:%s, receiverOpenId:%s, appId:%s, msgType:%d, msgContent:%s, sendTime:%d", new Object[] { paramString, str1, str2, str3, Integer.valueOf(i), str4, Long.valueOf(l) });
    paramMap = new WxaAppMsgChannel();
    paramMap.msgId = paramString;
    paramMap.lTW = str1;
    paramMap.lTX = str2;
    paramMap.appId = str3;
    paramMap.msgType = i;
    paramMap.dDP = str4;
    paramMap.kaJ = l;
    e.b(str3, paramMap);
    AppMethodBeat.o(188675);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.b
 * JD-Core Version:    0.7.0.1
 */