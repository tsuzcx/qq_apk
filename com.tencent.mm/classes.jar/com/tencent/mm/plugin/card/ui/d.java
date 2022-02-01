package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;

public final class d
  implements a
{
  private c obm;
  
  public d(c paramc)
  {
    this.obm = paramc;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113185);
    if (this.obm != null) {
      am.bQi().add(this.obm);
    }
    AppMethodBeat.o(113185);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113186);
    if (this.obm != null)
    {
      am.bQi().remove(this.obm);
      this.obm.release();
      this.obm = null;
    }
    AppMethodBeat.o(113186);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113187);
    if (this.obm != null) {
      this.obm.a(null, null);
    }
    AppMethodBeat.o(113187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.d
 * JD-Core Version:    0.7.0.1
 */