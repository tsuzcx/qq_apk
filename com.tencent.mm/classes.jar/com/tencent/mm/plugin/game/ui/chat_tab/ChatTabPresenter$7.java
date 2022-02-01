package com.tencent.mm.plugin.game.ui.chat_tab;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.lc;
import com.tencent.mm.sdk.event.IListener;

class ChatTabPresenter$7
  extends IListener<lc>
{
  ChatTabPresenter$7(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(276714);
    this.__eventId = lc.class.getName().hashCode();
    AppMethodBeat.o(276714);
  }
  
  private boolean fHG()
  {
    try
    {
      AppMethodBeat.i(276719);
      this.IVz.fHF();
      AppMethodBeat.o(276719);
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.ChatTabPresenter.7
 * JD-Core Version:    0.7.0.1
 */