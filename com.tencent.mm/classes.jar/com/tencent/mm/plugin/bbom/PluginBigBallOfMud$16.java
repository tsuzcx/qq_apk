package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class PluginBigBallOfMud$16
  implements l
{
  PluginBigBallOfMud$16(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String N(bi parambi)
  {
    AppMethodBeat.i(18296);
    int i;
    if ((parambi.field_bizChatId != -1L) && (f.lg(parambi.field_talker)))
    {
      i = 1;
      if (i == 0) {
        break label91;
      }
      parambi = parambi.field_talker + ":" + parambi.field_bizChatId;
      ab.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { parambi });
    }
    for (;;)
    {
      AppMethodBeat.o(18296);
      return parambi;
      i = 0;
      break;
      label91:
      parambi = parambi.field_talker;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.16
 * JD-Core Version:    0.7.0.1
 */