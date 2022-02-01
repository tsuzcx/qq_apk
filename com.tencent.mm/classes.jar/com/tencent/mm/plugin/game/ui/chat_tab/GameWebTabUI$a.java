package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

class GameWebTabUI$a
  implements b<IPCInteger, Bundle>
{
  private MStorage.IOnStorageChange xWT;
  private com.tencent.mm.pluginsdk.c.a xWU;
  private d<Bundle> xXQ;
  
  private GameWebTabUI$a()
  {
    AppMethodBeat.i(204289);
    this.xWT = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(204287);
        if (((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.e.a)) && (GameWebTabUI.a.a(GameWebTabUI.a.this) != null)) {
          GameWebTabUI.a.a(GameWebTabUI.a.this).bn(GameWebTabUI.a.dWG());
        }
        AppMethodBeat.o(204287);
      }
    };
    this.xWU = new com.tencent.mm.pluginsdk.c.a()
    {
      public final void g(IEvent paramAnonymousIEvent)
      {
        AppMethodBeat.i(204288);
        if (((paramAnonymousIEvent instanceof iy)) && (GameWebTabUI.a.a(GameWebTabUI.a.this) != null)) {
          GameWebTabUI.a.a(GameWebTabUI.a.this).bn(GameWebTabUI.a.dWG());
        }
        AppMethodBeat.o(204288);
      }
    };
    AppMethodBeat.o(204289);
  }
  
  private static Bundle dWF()
  {
    AppMethodBeat.i(204290);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)g.af(com.tencent.mm.plugin.gamelife.a.c.class)).dWZ();
    int j = ((com.tencent.mm.plugin.game.api.c)g.af(com.tencent.mm.plugin.game.api.c.class)).NY(1);
    int k = ((com.tencent.mm.plugin.game.api.c)g.af(com.tencent.mm.plugin.game.api.c.class)).NY(2);
    Bundle localBundle = new Bundle();
    localBundle.putInt("msg_unread_count", i + j);
    localBundle.putInt("notify_unread_count", k);
    AppMethodBeat.o(204290);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.a
 * JD-Core Version:    0.7.0.1
 */