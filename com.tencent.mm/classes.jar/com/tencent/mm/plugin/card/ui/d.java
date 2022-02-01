package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;

public final class d
  implements a
{
  private c oLh;
  
  public d(c paramc)
  {
    this.oLh = paramc;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113185);
    if (this.oLh != null) {
      am.bWc().add(this.oLh);
    }
    AppMethodBeat.o(113185);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113186);
    if (this.oLh != null)
    {
      am.bWc().remove(this.oLh);
      this.oLh.release();
      this.oLh = null;
    }
    AppMethodBeat.o(113186);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113187);
    if (this.oLh != null) {
      this.oLh.a(null, null);
    }
    AppMethodBeat.o(113187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.d
 * JD-Core Version:    0.7.0.1
 */