package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;

final class PluginBigBallOfMud$36
  implements p
{
  PluginBigBallOfMud$36(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String au(ca paramca)
  {
    AppMethodBeat.i(22409);
    int i;
    if ((paramca.field_bizChatId != -1L) && (g.KI(paramca.field_talker)))
    {
      i = 1;
      if (i == 0) {
        break label91;
      }
      paramca = paramca.field_talker + ":" + paramca.field_bizChatId;
      Log.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { paramca });
    }
    for (;;)
    {
      AppMethodBeat.o(22409);
      return paramca;
      i = 0;
      break;
      label91:
      paramca = paramca.field_talker;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.36
 * JD-Core Version:    0.7.0.1
 */