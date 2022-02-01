package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.ui.MagicBrushView.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$e
  implements MagicBrushView.g
{
  private a$e(a parama) {}
  
  public final void iI(int paramInt)
  {
    AppMethodBeat.i(130557);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("onMainCanvasTypeDefined received invalid input [" + paramInt + "]");
      AppMethodBeat.o(130557);
      throw localIllegalStateException;
    }
    if ((!((d)this.cuB.QK()).bDU()) && (!((d)this.cuB.QK()).isRunning()))
    {
      AppMethodBeat.o(130557);
      return;
    }
    this.cuB.iH(paramInt);
    AppMethodBeat.o(130557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */