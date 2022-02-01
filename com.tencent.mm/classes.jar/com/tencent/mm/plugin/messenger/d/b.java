package com.tencent.mm.plugin.messenger.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/messenger/sec/SecurityMsgNewXmlReceived;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "TAG", "", "onNewXmlReceived", "", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements t
{
  public static final b KRG;
  
  static
  {
    AppMethodBeat.i(288609);
    KRG = new b();
    AppMethodBeat.o(288609);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(288619);
    String str1;
    if ((s.p("secmsg", paramString)) && (paramMap != null))
    {
      parama = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.session"));
      str1 = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.newmsgid"));
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
      paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
      int j = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
      String str2 = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
      int k = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
      int m = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.media-to-emoji"));
      int n = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.block-range"));
      int i1 = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.bubble-type"));
      int i2 = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.preview-type"));
      int i3 = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.url-click-type"));
      Log.i("MicroMsg.SecurityMsgNewXmlReceived", "msgId:" + Util.safeParseLong(str1) + " [" + i + "],[" + paramString + "],[" + j + "],[" + str2 + "],[" + k + "],[" + n + "],[" + m + ']');
      paramMap = (Map)new HashMap();
      paramMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
      s.s(paramString, "showH5");
      paramMap.put(".msgsource.sec_msg_node.show-h5", paramString);
      paramMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
      s.s(str2, "shareTipUrl");
      paramMap.put(".msgsource.sec_msg_node.share-tip-url", str2);
      paramMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
      paramMap.put(".msgsource.sec_msg_node.media-to-emoji", String.valueOf(m));
      paramMap.put(".msgsource.sec_msg_node.block-range", String.valueOf(n));
      paramMap.put(".msgsource.sec_msg_node.bubble-type", String.valueOf(i1));
      paramMap.put(".msgsource.sec_msg_node.preview-type", String.valueOf(i2));
      paramMap.put(".msgsource.sec_msg_node.url-click-type", String.valueOf(i3));
      if (!Util.isNullOrNil(new String[] { parama, str1 }))
      {
        paramString = ((n)h.ax(n.class)).gaZ().aU(parama, Util.safeParseLong(str1));
        if (paramString != null) {
          break label555;
        }
        paramString = null;
        if (paramString == null) {
          Log.e("MicroMsg.SecurityMsgNewXmlReceived", "msg is null, talker:" + parama + ", msgId:" + str1);
        }
      }
    }
    AppMethodBeat.o(288619);
    return;
    label555:
    if ((!Util.isNullOrNil(paramString.field_talker)) && (paramString.field_msgSvrId > 0L)) {
      bt.c(paramString, bt.A(paramMap));
    }
    for (;;)
    {
      paramString = ah.aiuX;
      break;
      Log.i("MicroMsg.SecurityMsgNewXmlReceived", "msg " + str1 + " not found!");
      bt.f(Util.safeParseLong(str1), bt.A(paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.b
 * JD-Core Version:    0.7.0.1
 */