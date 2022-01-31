package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class PluginBigBallOfMud$12
  implements l
{
  PluginBigBallOfMud$12(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final String I(bi parambi)
  {
    if ((parambi.field_bizChatId != -1L) && (f.eW(parambi.field_talker))) {}
    for (int i = 1; i != 0; i = 0)
    {
      parambi = parambi.field_talker + ":" + parambi.field_bizChatId;
      y.d("MicroMsg.PluginBigBallOfMud", "mapNotifyInfo key:%s", new Object[] { parambi });
      return parambi;
    }
    return parambi.field_talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.12
 * JD-Core Version:    0.7.0.1
 */