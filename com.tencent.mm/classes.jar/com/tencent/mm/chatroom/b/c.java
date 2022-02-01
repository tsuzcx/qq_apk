package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  implements u
{
  public final void Yo()
  {
    AppMethodBeat.i(185964);
    aa.Ys();
    AppMethodBeat.o(185964);
  }
  
  public final void ve(String paramString)
  {
    AppMethodBeat.i(217096);
    if ((aa.Yr()) && (x.zU(paramString)))
    {
      e locale = aa.vi(paramString);
      if (locale == null)
      {
        ae.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", new Object[] { paramString });
        AppMethodBeat.o(217096);
        return;
      }
      if (locale.field_queryState == 0)
      {
        ae.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramString });
        AppMethodBeat.o(217096);
        return;
      }
      locale.a(new GroupToolItem("roomaa@app.origin", "", ch.aDa()));
      ae.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", new Object[] { paramString, Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0])) });
    }
    AppMethodBeat.o(217096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.c
 * JD-Core Version:    0.7.0.1
 */