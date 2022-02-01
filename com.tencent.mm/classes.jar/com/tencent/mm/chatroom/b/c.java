package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements u
{
  public final void Dv(String paramString)
  {
    AppMethodBeat.i(194010);
    if ((aa.ame()) && (ab.Ix(paramString)))
    {
      e locale = aa.Dz(paramString);
      if (locale == null)
      {
        Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", new Object[] { paramString });
        AppMethodBeat.o(194010);
        return;
      }
      if (locale.field_queryState == 0)
      {
        Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramString });
        AppMethodBeat.o(194010);
        return;
      }
      locale.a(new GroupToolItem("roomaa@app.origin", "", cl.aWy()));
      Log.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", new Object[] { paramString, Boolean.valueOf(((PluginChatroomUI)g.ah(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0])) });
    }
    AppMethodBeat.o(194010);
  }
  
  public final void amb()
  {
    AppMethodBeat.i(185964);
    aa.amf();
    AppMethodBeat.o(185964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.c
 * JD-Core Version:    0.7.0.1
 */