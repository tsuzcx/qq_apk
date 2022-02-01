package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.c;
import com.tencent.mm.chatroom.storage.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  implements s
{
  public final void GM(String paramString)
  {
    AppMethodBeat.i(210018);
    if ((aa.VQ()) && (w.wp(paramString)))
    {
      c localc = aa.rZ(paramString);
      if (localc == null)
      {
        ac.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", new Object[] { paramString });
        AppMethodBeat.o(210018);
        return;
      }
      if (localc.field_queryState == 0)
      {
        ac.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramString });
        AppMethodBeat.o(210018);
        return;
      }
      localc.b(new GroupToolItem("roomaa@app.origin", "", ce.azH()));
      ac.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", new Object[] { paramString, Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(localc, new String[0])) });
    }
    AppMethodBeat.o(210018);
  }
  
  public final void VN()
  {
    AppMethodBeat.i(185964);
    aa.VR();
    AppMethodBeat.o(185964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.b
 * JD-Core Version:    0.7.0.1
 */