package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.model.am;

public final class d
  implements a
{
  private c wzo;
  
  public d(c paramc)
  {
    this.wzo = paramc;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(113185);
    if (this.wzo != null) {
      am.dkJ().add(this.wzo);
    }
    AppMethodBeat.o(113185);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(113186);
    if (this.wzo != null)
    {
      am.dkJ().remove(this.wzo);
      this.wzo.release();
      this.wzo = null;
    }
    AppMethodBeat.o(113186);
  }
  
  public final void onNotify()
  {
    AppMethodBeat.i(113187);
    if (this.wzo != null) {
      this.wzo.onNotifyChange(null, null);
    }
    AppMethodBeat.o(113187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.d
 * JD-Core Version:    0.7.0.1
 */