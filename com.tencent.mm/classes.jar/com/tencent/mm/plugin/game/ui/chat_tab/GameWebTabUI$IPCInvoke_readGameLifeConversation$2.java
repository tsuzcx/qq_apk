package com.tencent.mm.plugin.game.ui.chat_tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kp;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IEvent;

class GameWebTabUI$IPCInvoke_readGameLifeConversation$2
  extends IListenerMStorage
{
  GameWebTabUI$IPCInvoke_readGameLifeConversation$2(GameWebTabUI.a parama) {}
  
  public final void g(IEvent paramIEvent)
  {
    AppMethodBeat.i(276604);
    if (((paramIEvent instanceof kp)) && (GameWebTabUI.a.a(this.IWR) != null)) {
      GameWebTabUI.a.a(this.IWR).onCallback(GameWebTabUI.a.fHP());
    }
    AppMethodBeat.o(276604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.IPCInvoke_readGameLifeConversation.2
 * JD-Core Version:    0.7.0.1
 */