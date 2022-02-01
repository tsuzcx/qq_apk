package com.tencent.mm.plugin.game.ui.chat_tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kp;
import com.tencent.mm.pluginsdk.event.IListenerMStorage;
import com.tencent.mm.sdk.event.IEvent;

class ChatTabPresenter$6
  extends IListenerMStorage
{
  ChatTabPresenter$6(a parama) {}
  
  public final void g(IEvent paramIEvent)
  {
    AppMethodBeat.i(276712);
    if ((paramIEvent instanceof kp)) {
      this.IVz.fHF();
    }
    AppMethodBeat.o(276712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.ChatTabPresenter.6
 * JD-Core Version:    0.7.0.1
 */