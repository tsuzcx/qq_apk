package com.tencent.mm.plugin.game.ui.chat_tab;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lc;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.sdk.event.IListener;

class GameWebTabUI$IPCInvoke_readGameLifeConversation$3
  extends IListener<lc>
{
  GameWebTabUI$IPCInvoke_readGameLifeConversation$3(GameWebTabUI.a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(276618);
    this.__eventId = lc.class.getName().hashCode();
    AppMethodBeat.o(276618);
  }
  
  private boolean fHG()
  {
    try
    {
      AppMethodBeat.i(276624);
      if (GameWebTabUI.a.a(this.IWR) != null) {
        GameWebTabUI.a.a(this.IWR).onCallback(GameWebTabUI.a.fHP());
      }
      AppMethodBeat.o(276624);
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.GameWebTabUI.IPCInvoke_readGameLifeConversation.3
 * JD-Core Version:    0.7.0.1
 */