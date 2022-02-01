package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements x
{
  public final void Km(String paramString)
  {
    AppMethodBeat.i(186794);
    if ((aa.asf()) && (ab.PP(paramString)))
    {
      e locale = aa.Kq(paramString);
      if (locale == null)
      {
        Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", new Object[] { paramString });
        AppMethodBeat.o(186794);
        return;
      }
      if (locale.field_queryState == 0)
      {
        Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramString });
        AppMethodBeat.o(186794);
        return;
      }
      locale.a(new GroupToolItem("roomaa@app.origin", "", cm.bfC()));
      Log.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", new Object[] { paramString, Boolean.valueOf(((PluginChatroomUI)h.ag(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0])) });
    }
    AppMethodBeat.o(186794);
  }
  
  public final void asc()
  {
    AppMethodBeat.i(185964);
    aa.asg();
    AppMethodBeat.o(185964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.c
 * JD-Core Version:    0.7.0.1
 */