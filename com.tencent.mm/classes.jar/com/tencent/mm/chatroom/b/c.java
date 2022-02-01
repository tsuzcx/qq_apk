package com.tencent.mm.chatroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.ad;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.GroupToolItem;
import com.tencent.mm.chatroom.storage.e;
import com.tencent.mm.chatroom.storage.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.List;

public final class c
  implements x
{
  public final void CR(String paramString)
  {
    AppMethodBeat.i(241320);
    if (au.bwG(paramString))
    {
      e locale = ad.CV(paramString);
      if (locale == null)
      {
        Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is null", new Object[] { paramString });
        AppMethodBeat.o(241320);
        return;
      }
      if (locale.field_queryState == 0)
      {
        Log.d("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA(room:%s) groupTools is COL_STATE_NEED_QUERY", new Object[] { paramString });
        AppMethodBeat.o(241320);
        return;
      }
      locale.a(new GroupToolItem("roomaa@app.origin", "", cn.bDu()));
      Log.i("MicroMsg.roomtools.RoomTodoService", "handleGroupToolByLaunchAA room:%s result:%s", new Object[] { paramString, Boolean.valueOf(((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0])) });
    }
    AppMethodBeat.o(241320);
  }
  
  public final void aLY()
  {
    AppMethodBeat.i(185964);
    Log.i("MicroMsg.roomtools.RoomToolsHelp", "resetAllGroupToolsRecentUse");
    Object localObject = ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().aMk();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        locale.field_queryState = 0;
        ((PluginChatroomUI)h.az(PluginChatroomUI.class)).getGroupToolsStorage().a(locale, new String[0]);
      }
    }
    AppMethodBeat.o(185964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.c
 * JD-Core Version:    0.7.0.1
 */