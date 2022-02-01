package com.tencent.mm.plugin.game.ui.chat_tab;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;

class GameWebTabUI$a
  implements d<IPCInteger, Bundle>
{
  private MStorage.IOnStorageChange IVw;
  private IListenerMStorage IVx;
  private com.tencent.mm.ipcinvoker.f<Bundle> IWQ;
  private IListener Ipg;
  
  private GameWebTabUI$a()
  {
    AppMethodBeat.i(276597);
    this.IVw = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(276695);
        if (((paramAnonymousMStorageEventData.obj instanceof com.tencent.mm.plugin.gamelife.f.a)) && (GameWebTabUI.a.a(GameWebTabUI.a.this) != null)) {
          GameWebTabUI.a.a(GameWebTabUI.a.this).onCallback(GameWebTabUI.a.fHP());
        }
        AppMethodBeat.o(276695);
      }
    };
    this.IVx = new GameWebTabUI.IPCInvoke_readGameLifeConversation.2(this);
    this.Ipg = new GameWebTabUI.IPCInvoke_readGameLifeConversation.3(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(276597);
  }
  
  private static Bundle fHO()
  {
    AppMethodBeat.i(276601);
    int i = ((com.tencent.mm.plugin.gamelife.a.c)h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).fIi();
    int j = ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).WY(1);
    int k = ((com.tencent.mm.plugin.game.api.c)h.ax(com.tencent.mm.plugin.game.api.c.class)).WY(2);
    Bundle localBundle = new Bundle();
    localBundle.putInt("msg_unread_count", i + j);
    localBundle.putInt("notify_unread_count", k);
    com.tencent.mm.plugin.game.chatroom.j.a locala = com.tencent.mm.plugin.game.chatroom.j.a.Imu;
    localBundle.putBoolean("has_chat_room_unread_msg", com.tencent.mm.plugin.game.chatroom.j.a.fCY());
    AppMethodBeat.o(276601);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.a
 * JD-Core Version:    0.7.0.1
 */