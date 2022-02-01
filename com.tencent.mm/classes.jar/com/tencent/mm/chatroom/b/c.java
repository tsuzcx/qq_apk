package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements t
{
  public final void Ye()
  {
    AppMethodBeat.i(185964);
    aa.Yi();
    AppMethodBeat.o(185964);
  }
  
  public final void uJ(String paramString)
  {
    AppMethodBeat.i(213384);
    if ((aa.Yh()) && (w.zk(paramString)))
    {
      e locale = aa.uN(paramString);
      if (locale == null)
      {
        ad.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", new Object[] { paramString });
        AppMethodBeat.o(213384);
        return;
      }
      if (locale.field_queryState == 0)
      {
        ad.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramString });
        AppMethodBeat.o(213384);
        return;
      }
      locale.a(new GroupToolItem("roomaa@app.origin", "", cf.aCK()));
      ad.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", new Object[] { paramString, Boolean.valueOf(((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0])) });
    }
    AppMethodBeat.o(213384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.c
 * JD-Core Version:    0.7.0.1
 */