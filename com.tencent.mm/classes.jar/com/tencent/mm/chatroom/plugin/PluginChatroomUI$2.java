package com.tencent.mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;

final class PluginChatroomUI$2
  implements i
{
  PluginChatroomUI$2(PluginChatroomUI paramPluginChatroomUI) {}
  
  public final void a(ca paramca, i.c paramc, boolean[] paramArrayOfBoolean) {}
  
  public final void a(ca paramca, az paramaz, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(191436);
    if (paramBoolean)
    {
      Log.i("MicroMsg.PluginChatroomUI", "new conversation %s", new Object[] { paramaz.field_username });
      v.PB(paramaz.field_username);
    }
    AppMethodBeat.o(191436);
  }
  
  public final void b(ca paramca, az paramaz, boolean paramBoolean, i.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI.2
 * JD-Core Version:    0.7.0.1
 */