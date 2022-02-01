package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bo;

final class PluginChatroomUI$9
  implements f
{
  PluginChatroomUI$9(PluginChatroomUI paramPluginChatroomUI) {}
  
  public final void a(bo parambo, ap paramap, boolean paramBoolean, h.c paramc)
  {
    AppMethodBeat.i(210019);
    if (paramBoolean)
    {
      ac.i("MicroMsg.PluginChatroomUI", "new conversation %s", new Object[] { paramap.field_username });
      q.IJ(paramap.field_username);
    }
    AppMethodBeat.o(210019);
  }
  
  public final void b(bo parambo, ap paramap, boolean paramBoolean, h.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI.9
 * JD-Core Version:    0.7.0.1
 */