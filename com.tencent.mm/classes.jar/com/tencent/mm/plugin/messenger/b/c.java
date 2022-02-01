package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/messenger/extdevice/PushLoginUrlAutoLoginSwitchUpdateNewXmlReceived;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "TAG", "", "onNewXmlReceived", "", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements t
{
  public static final c KQk;
  
  static
  {
    AppMethodBeat.i(288548);
    KQk = new c();
    AppMethodBeat.o(288548);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(288551);
    if ((s.p("PushLoginUrlAutoLoginSwitchUpdate", paramString)) && (paramMap != null))
    {
      paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.PushLoginUrlAutoLoginSwitchUpdate.deviceid"));
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.PushLoginUrlAutoLoginSwitchUpdate.setting"));
      Log.i("MicroMsg.PushLoginUrlAutoLoginSwitchUpdateNewXmlReceived", "receive xml, deviceid:" + paramString + ", setting:" + i);
      if (i != 1) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      a.cq(paramString, bool);
      AppMethodBeat.o(288551);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.c
 * JD-Core Version:    0.7.0.1
 */