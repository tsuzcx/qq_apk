package com.tencent.mm.plugin.card.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.ui.base.h.c;

final class CardBaseUI$5
  implements h.c
{
  CardBaseUI$5(CardBaseUI paramCardBaseUI, b paramb, String paramString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(87621);
    if (this.kkQ.baR())
    {
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(87621);
        return;
      case 0: 
        this.kkO.a((CardInfo)this.kkQ);
        AppMethodBeat.o(87621);
        return;
      }
      CardBaseUI.b(this.kkO, this.kkP);
      AppMethodBeat.o(87621);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(87621);
      return;
      CardBaseUI.b(this.kkO, this.kkP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.5
 * JD-Core Version:    0.7.0.1
 */